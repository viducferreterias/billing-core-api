package com.viduc.billingcore.impl.sale;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.viduc.billingcore.domain.Sales;
import com.viduc.billingcore.dto.components.DteDocumentBodyDto;
import com.viduc.billingcore.dto.components.DtePaymentsDto;
import com.viduc.billingcore.dto.response.DteSchemaBillResponseDto;
import com.viduc.billingcore.dto.response.DteSchemaCreditNoteResponseDto;
import com.viduc.billingcore.mapper.sale.*;
import com.viduc.billingcore.repository.sale.IDteProcessor;
import jakarta.ejb.Stateless;
import jakarta.transaction.Transactional;
import lombok.extern.java.Log;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Log
@Stateless
@Transactional
public class DteCreditNoteImpl implements IDteProcessor {
    @Override
    public <T> Object generate(T data, List<DtePaymentsDto> payment, List<DteDocumentBodyDto> body) throws Exception {
        var baseData = (Sales) data;
        var jsonMapper = new ObjectMapper();

        var identification = IDteIdentificationMapper.INSTANCE.identificationToIdentificationDto(baseData);
        var transmitter = IDteTransmitterMapper.INSTANCE.transmitterDataToDto(baseData);
        var receiver = IDteReceiverMapper.INSTANCE.toDteCreditNoteDto(baseData);
        var summary = IDteSummaryMapper.INSTANCE.toDteSummaryCreditNoteDto(baseData);
        var relatedDocument = IDteRelatedDocumentMapper.INSTANCE.toRelatedDocumentDto(baseData);

        var dte = DteSchemaCreditNoteResponseDto.builder()
                .identification(identification)
                .transmitter(transmitter)
                .receiver(receiver)
                .relatedDocuments(Collections.singletonList(relatedDocument))
                .body(body)
                .summary(summary)
                .build();

        log.info("DTE: " + jsonMapper.writerWithDefaultPrettyPrinter().writeValueAsString(dte));

        return dte;
    }
}
