package com.viduc.billingcore.impl.sale;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.viduc.billingcore.domain.Sales;
import com.viduc.billingcore.dto.components.DteAppendixDto;
import com.viduc.billingcore.dto.components.DteDocumentBodyDto;
import com.viduc.billingcore.dto.components.DteDocumentBodyWithholdingReceiptDto;
import com.viduc.billingcore.dto.components.DtePaymentsDto;
import com.viduc.billingcore.dto.response.DteSchemaTaxReceiptResponseDto;
import com.viduc.billingcore.dto.response.DteSchemaWithholdingReceiptResponseDto;
import com.viduc.billingcore.mapper.sale.*;
import com.viduc.billingcore.repository.sale.IDteProcessor;
import jakarta.annotation.Nullable;
import jakarta.ejb.Stateless;
import lombok.extern.java.Log;

import java.util.ArrayList;
import java.util.List;

@Log
@Stateless
public class DteWithholdingReceiptImpl implements IDteProcessor {
    @Override
    public <T> Object generate(T data, @Nullable List<DtePaymentsDto> payment, @Nullable List<DteDocumentBodyDto> body) throws Exception {

        var baseData = (Sales) data;
        var jsonMapper = new ObjectMapper();
        var appendixList = new ArrayList<DteAppendixDto>();
        var bodyList = new ArrayList<DteDocumentBodyWithholdingReceiptDto>();

        var identification = IDteIdentificationMapper.INSTANCE.identificationToIdentificationDto(baseData);
        var transmitter = IDteTransmitterMapper.INSTANCE.transmitterDataToDto(baseData);
        var receiver = IDteReceiverMapper.INSTANCE.toDteWithholdingReceiptDto(baseData);
        bodyList.add(IDteBodyMapper.INSTANCE.toDteBodyWithholdingReceiptDto(baseData));
        var summary = IDteSummaryMapper.INSTANCE.toDteSummaryWithholdingReceiptDto(baseData);

        appendixList.add(DteAppendixDto.builder().label("numeroDocumentoInterno").field("Numero Documento").value(baseData.getPointSale().getId().toString().concat("-").concat(baseData.getId().getDocumentNumber().toString())).build());

        var dte = DteSchemaWithholdingReceiptResponseDto.builder()
                .identification(identification)
                .transmitter(transmitter)
                .receiver(receiver)
                .body(bodyList)
                .summary(summary)
                .appendix(appendixList)
                .build();

        log.info("DTE: " + jsonMapper.writerWithDefaultPrettyPrinter().writeValueAsString(dte));

        return dte;
    }
}
