package com.viduc.billingcore.mapper.sale;

import com.viduc.billingcore.domain.Sales;
import com.viduc.billingcore.dto.components.DteRelatedDocumentsDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface IDteRelatedDocumentMapper {

    IDteRelatedDocumentMapper INSTANCE = Mappers.getMapper(IDteRelatedDocumentMapper.class);

    @Mappings({
            @Mapping(target = "type" , constant = "03"),
            @Mapping(target = "generationType" , source = "data.electronicBillingSummary.documentGenerationType"),
            @Mapping(target = "number" , source = "data.electronicBillingSummary.relatedDocumentNumber"),
            @Mapping(target = "date" , source = "data.electronicBillingSummary.relatedDocumentIssueDate")
    })
    DteRelatedDocumentsDto toRelatedDocumentDto(Sales data);

}
