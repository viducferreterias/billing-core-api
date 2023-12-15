package com.viduc.billingcore.repository.task;

import com.viduc.billingcore.domain.InventoryMovement;
import com.viduc.billingcore.domain.InventoryMovementPrimaryKey_;
import com.viduc.billingcore.domain.InventoryMovement_;
import com.viduc.billingcore.dto.request.sales.DteRequestDto;
import com.viduc.billingcore.repository.sale.DteGeneratorRepository;
import jakarta.ejb.*;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.extern.java.Log;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

@Log
@Stateless
public class DteInventoryDocumentProcessing {

    @PersistenceContext(unitName = "factur")
    private EntityManager em;

    @Inject
    private DteGeneratorRepository dteGeneratorRepository;


    @Timeout
    @Asynchronous
    @AccessTimeout(value = 10 , unit = TimeUnit.MINUTES)
    @Schedule(hour = "*", minute = "*/15", second = "0", info = "procesamiento de transacciones de inventarios no procesadas")
    private void process() {

        var builder = em.getCriteriaBuilder();
        var criteria = builder.createQuery(InventoryMovement.class);
        var inventory = criteria.from(InventoryMovement.class);

        criteria.where(builder.greaterThanOrEqualTo(inventory.get(InventoryMovement_.issuedOn) , LocalDateTime.now().minusDays(5).toLocalDate().atStartOfDay()),
                builder.isNull(inventory.get(InventoryMovement_.electronicReceiptSale)),
                builder.equal(inventory.get(InventoryMovement_.id).get(InventoryMovementPrimaryKey_.type) , 11));

        em.createQuery(criteria).getResultStream().forEach(result -> {

            var request = DteRequestDto.builder()
                    .documentType(result.getId().getType())
                    .documentNumber(result.getId().getNumber())
                    .date(result.getIssuedOn())
                    .companyId(result.getId().getCompanyId())
                    .warehouseOrigin(result.getId().getWarehouse())
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
