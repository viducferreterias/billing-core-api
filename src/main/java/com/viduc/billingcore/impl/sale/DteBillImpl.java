package com.viduc.billingcore.impl.sale;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.viduc.billingcore.domain.Sales;
import com.viduc.billingcore.dto.components.DteAppendixDto;
import com.viduc.billingcore.dto.components.DteDocumentBodyDto;
import com.viduc.billingcore.dto.components.DtePaymentsDto;
import com.viduc.billingcore.dto.response.DteSchemaBillResponseDto;
import com.viduc.billingcore.dto.response.DteSchemaTaxReceiptResponseDto;
import com.viduc.billingcore.mapper.sale.IDteIdentificationMapper;
import com.viduc.billingcore.mapper.sale.IDteReceiverMapper;
import com.viduc.billingcore.mapper.sale.IDteSummaryMapper;
import com.viduc.billingcore.mapper.sale.IDteTransmitterMapper;
import com.viduc.billingcore.repository.sale.IDteProcessor;
import jakarta.ejb.Stateless;
import jakarta.transaction.Transactional;
import lombok.extern.java.Log;

import java.util.ArrayList;
import java.util.List;

@Log
@Stateless
@Transactional
public class DteBillImpl implements IDteProcessor {
    @Override
    public <T>  Object generate(T data , List<DtePaymentsDto> payment , List<DteDocumentBodyDto> body) throws JsonProcessingException {

        var baseData = (Sales) data;
        var jsonMapper = new ObjectMapper();
        var appendixList = new ArrayList<DteAppendixDto>();

        var identification = IDteIdentificationMapper.INSTANCE.identificationToIdentificationDto(baseData);
        var transmitter = IDteTransmitterMapper.INSTANCE.transmitterDataToDto(baseData);
        var receiver = IDteReceiverMapper.INSTANCE.toDteInvoiceSaleDto(baseData);
        var summary = IDteSummaryMapper.INSTANCE.toDteSummaryBillDocumentDto(baseData , payment);

        appendixList.add(DteAppendixDto.builder().label("numeroDocumentoInterno").field("Numero Documento").value(baseData.getPointSale().getId().toString().concat("-").concat(baseData.getId().getDocumentNumber().toString())).build());

        var dte = DteSchemaBillResponseDto.builder()
                .identification(identification)
                .transmitter(transmitter)
                .receiver(receiver)
                .body(body)
                .summary(summary)
                .appendix(appendixList)
                .build();

        log.info("DTE: " + jsonMapper.writerWithDefaultPrettyPrinter().writeValueAsString(dte));

        return dte;

    }
}
