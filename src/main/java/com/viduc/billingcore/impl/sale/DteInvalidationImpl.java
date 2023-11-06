package com.viduc.billingcore.impl.sale;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.viduc.billingcore.domain.view.ElectronicBillingCancellationsView;
import com.viduc.billingcore.dto.components.DteDocumentBodyDto;
import com.viduc.billingcore.dto.components.DtePaymentsDto;
import com.viduc.billingcore.dto.response.DteSchemaInvalidationResponseDto;
import com.viduc.billingcore.mapper.sale.IDteDocumentMapper;
import com.viduc.billingcore.mapper.sale.IDteIdentificationMapper;
import com.viduc.billingcore.mapper.sale.IDteReasonMapper;
import com.viduc.billingcore.mapper.sale.IDteTransmitterMapper;
import com.viduc.billingcore.repository.sale.IDteProcessor;
import jakarta.annotation.Nullable;
import jakarta.ejb.Stateless;
import lombok.extern.java.Log;

import java.util.List;

@Log
@Stateless
public class DteInvalidationImpl implements IDteProcessor {
    @Override
    public <T> Object generate(T data, @Nullable List<DtePaymentsDto> payment, @Nullable List<DteDocumentBodyDto> body) throws Exception {

        var baseData = (ElectronicBillingCancellationsView) data;
        var mapper = new ObjectMapper();

        var dte = DteSchemaInvalidationResponseDto.builder()
                                                    .identification(IDteIdentificationMapper.INSTANCE.toIdentificationInvalidationDto(baseData))
                                                    .transmitter(IDteTransmitterMapper.INSTANCE.toDteTransmitterInvalidationDto(baseData))
                                                    .document(IDteDocumentMapper.INSTANCE.toDteDocumentInvalidationDto(baseData))
                                                    .reason(IDteReasonMapper.INSTANCE.toDteReasonDto(baseData))
                                                    .build();

        log.info("DTE [INVALIDACION]: " + mapper.writerWithDefaultPrettyPrinter().writeValueAsString(dte));

        return dte;
    }
}
