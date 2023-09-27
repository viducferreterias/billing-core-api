package com.viduc.billingcore.impl.inventory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.viduc.billingcore.domain.Sales;
import com.viduc.billingcore.dto.components.DteAppendixDto;
import com.viduc.billingcore.dto.components.DteDocumentBodyDto;
import com.viduc.billingcore.dto.components.DtePaymentsDto;
import com.viduc.billingcore.dto.components.InventoryMovementDto;
import com.viduc.billingcore.dto.response.DteSchemaBillResponseDto;
import com.viduc.billingcore.mapper.sale.IDteIdentificationMapper;
import com.viduc.billingcore.mapper.sale.IDteReceiverMapper;
import com.viduc.billingcore.mapper.sale.IDteSummaryMapper;
import com.viduc.billingcore.mapper.sale.IDteTransmitterMapper;
import com.viduc.billingcore.repository.sale.IDteProcessor;
import jakarta.annotation.Nullable;
import jakarta.ejb.Stateless;
import jakarta.transaction.Transactional;
import lombok.extern.java.Log;

import java.util.ArrayList;
import java.util.List;

@Log
@Stateless
@Transactional
public class DteDeliveryNoteImpl implements IDteProcessor {

    @Override
    public <T> Object generate(T data, @Nullable List<DtePaymentsDto> payment, List<DteDocumentBodyDto> body) throws Exception {
        var baseData = (InventoryMovementDto) data;
        var jsonMapper = new ObjectMapper();
        var appendix = new ArrayList<DteAppendixDto>();

        var identification = IDteIdentificationMapper.INSTANCE.toIdentificationInventoryDto(baseData);
        var transmitter = IDteTransmitterMapper.INSTANCE.toDteTransmitterDeliverNote(baseData);
        var receiver = IDteReceiverMapper.INSTANCE.toDteDeliveryNoteDto(baseData);
        var summary = IDteSummaryMapper.INSTANCE.toDteSummaryDeliveryNoteDto(baseData);

        appendix.add(DteAppendixDto.builder().label("numeroDoctoInterno").field("Numero Documento").value(baseData.getNumber().toString()).build());
        appendix.add(DteAppendixDto.builder().label("codBodega").field("Codigo Bodega Origen").value(baseData.getWarehouse().toString()).build());
        appendix.add(DteAppendixDto.builder().label("codBodegaDestino").field("Codigo Bodega Destino").value(baseData.getDestinationWarehouse().toString()).build());

        var dte = DteSchemaBillResponseDto.builder()
                .identification(identification)
                .transmitter(transmitter)
                .receiver(receiver)
                .body(body)
                .summary(summary)
                .appendix(appendix)
                .build();

        log.info("DTE: " + jsonMapper.writerWithDefaultPrettyPrinter().writeValueAsString(dte));

        return dte;
    }

}
