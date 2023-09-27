package com.viduc.billingcore.repository.sale;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.viduc.billingcore.domain.Setting;
import com.viduc.billingcore.dto.components.DteDocumentBodyDto;
import com.viduc.billingcore.dto.components.DtePaymentsDto;
import jakarta.annotation.Nullable;

import java.util.List;

public interface IDteProcessor {

    <T> Object generate(T data , @Nullable List<DtePaymentsDto> payment , List<DteDocumentBodyDto> body) throws Exception;

}
