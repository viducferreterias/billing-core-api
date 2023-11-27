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

        appendixList.add(DteAppendixDto.builder().label("Numero Documento").field("numeroDocumentoInterno").value(baseData.getPointSale().getId().toString().concat("-").concat(baseData.getDocumentType().getAbbreviation()).concat("-").concat(baseData.getId().getDocumentNumber().toString())).build());
        appendixList.add(DteAppendixDto.builder().label("Cuenta Proveedor").field("cuentaProveedor").value(baseData.getSupplier().getId()).build());
        appendixList.add(DteAppendixDto.builder().label(baseData.getPointSale().getPrinter()).field("1MPR1M3").value("S").build());

        if (baseData.getSpecialComment() != null) {
            appendixList.add(DteAppendixDto.builder().label("Observacion Especial").field("comentarioEspecial").value(baseData.getSpecialComment()).build());
        }

        /*if (baseData.getImpression().equals(1)) {
            appendixList.add(DteAppendixDto.builder().label(baseData.getPointSale().getPrinter()).field("1MPR1M3").value("S").build());
        }*/

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
