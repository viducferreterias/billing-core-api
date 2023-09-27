package com.viduc.billingcore.mapper.sale;

import com.viduc.billingcore.domain.view.ElectronicBillingPaymentView;
import com.viduc.billingcore.dto.components.DtePaymentsDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "cdi")
public interface IDtePaymentMapper {

    IDtePaymentMapper INSTANCE = Mappers.getMapper(IDtePaymentMapper.class);
    List<DtePaymentsDto> toDtePaymentDto(List<ElectronicBillingPaymentView> data);

    default DtePaymentsDto toDtePaymentDto(ElectronicBillingPaymentView data) {
        return DtePaymentsDto.builder()
                            .code(data.getWayToPayCode())
                            .amount(data.getBalance())
                            .period(data.getPeriodTerm())
                            .term(data.getTerm())
                            .build();
    }

}
