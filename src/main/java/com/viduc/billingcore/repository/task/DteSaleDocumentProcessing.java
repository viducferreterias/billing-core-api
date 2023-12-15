package com.viduc.billingcore.repository.task;

import com.viduc.billingcore.domain.*;
import com.viduc.billingcore.dto.request.sales.DteRequestDto;
import com.viduc.billingcore.repository.sale.DteGeneratorRepository;
import jakarta.ejb.*;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.extern.java.Log;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Log
@Stateless
public class DteSaleDocumentProcessing {

    @PersistenceContext(unitName = "factur")
    private EntityManager em;

    @Inject
    private DteGeneratorRepository dteGeneratorRepository;

    @Timeout
    @Asynchronous
    @AccessTimeout(value = 15 , unit = TimeUnit.MINUTES)
    @Schedule(hour = "*", minute = "*/10", second = "0", info = "procesamiento de transacciones de venta no procesadas")
    private void process() {

        var builder = em.getCriteriaBuilder();
        var criteria = builder.createQuery(Sales.class);
        var sales = criteria.from(Sales.class);

        List<Integer> documents = Arrays.asList(2,12,13,17,14,20);

        criteria.where(builder.greaterThanOrEqualTo(sales.get(Sales_.documentDate) , LocalDateTime.now().minusDays(5).toLocalDate().atStartOfDay()),
                builder.isNull(sales.get(Sales_.electronicReceiptSale)),
                builder.and(sales.get(Sales_.id).get(SalesPrimaryKey_.documentTypeCode).in(documents)));

        em.createQuery(criteria).getResultStream().forEach(result -> {

            var request = DteRequestDto.builder()
                    .documentType(result.getId().getDocumentTypeCode())
                    .documentNumber(result.getId().getDocumentNumber())
                    .date(result.getDocumentDate())
                    .companyId(result.getId().getCompanyId())
                    .posId(result.getId().getPointSaleCode())
                    .build();

            new Thread(() -> {
                try {
                    dteGeneratorRepository.generate(request);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }).start();


        });

    }

}
