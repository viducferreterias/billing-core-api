package com.viduc.billingcore.mapper.sale;

import com.viduc.billingcore.domain.view.ElectronicBillingCancellationsView;
import com.viduc.billingcore.dto.components.DteReasonDto;
import com.viduc.billingcore.utils.mapper.CharacterReplacerMapper;
import com.viduc.billingcore.utils.qualifier.CharacterReplacer;
import com.viduc.billingcore.utils.qualifier.CharacterReplacerNoHyphen;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(uses = CharacterReplacerMapper.class ,  nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface IDteReasonMapper {

    IDteReasonMapper INSTANCE = Mappers.getMapper(IDteReasonMapper.class);

    @Mappings({
            @Mapping(target = "type"  , source = "data.type"),
            @Mapping(target = "descriptionReason" , source = "data.reason"),
            @Mapping(target = "responsibleName" , source = "." , qualifiedByName = "getResponsibleName"),
            @Mapping(target = "responsibleDocumentType" , constant = "13"),
            @Mapping(target = "responsibleDocumentNumber" , source = "data.employeeCreatedBy.dui" , qualifiedBy = {CharacterReplacer.class , CharacterReplacerNoHyphen.class}),
            @Mapping(target = "applicantName" , source = "." , qualifiedByName = "getApplicantName"),
            @Mapping(target = "applicantDocumentType" , constant = "13"),
            @Mapping(target = "applicantDocumentNumber" , source = "data.employeeRequestBy.dui" , qualifiedBy = {CharacterReplacer.class , CharacterReplacerNoHyphen.class}),
    })
    DteReasonDto toDteReasonDto(ElectronicBillingCancellationsView data);

    @Named("getResponsibleName")
    default String getResponsibleName(ElectronicBillingCancellationsView data) {

        return data.getEmployeeCreatedBy().getId() + " - " + data.getEmployeeCreatedBy().getName() + " " + data.getEmployeeCreatedBy().getLastname();

    }

    @Named("getApplicantName")
    default String getApplicantName(ElectronicBillingCancellationsView data) {

        return data.getEmployeeRequestBy().getId() + " - " + data.getEmployeeRequestBy().getName() + " " + data.getEmployeeRequestBy().getLastname();

    }
}
