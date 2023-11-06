package com.viduc.billingcore.mapper.sale;

import com.viduc.billingcore.domain.Sales;
import com.viduc.billingcore.domain.view.ElectronicBillingCancellationsView;
import com.viduc.billingcore.dto.components.DteDocumentInvalidationDto;
import com.viduc.billingcore.utils.mapper.CharacterReplacerMapper;
import com.viduc.billingcore.utils.qualifier.CharacterReplacer;
import com.viduc.billingcore.utils.qualifier.CharacterReplacerNoHyphen;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Mapper(uses = CharacterReplacerMapper.class ,  nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface IDteDocumentMapper {

    IDteDocumentMapper INSTANCE = Mappers.getMapper(IDteDocumentMapper.class);

    @Mappings({
            @Mapping(target = "dteType" , source = "data.documentType" , qualifiedByName = "getDteType"),
            @Mapping(target = "generationCode" , source = "data.generationCode"),
            @Mapping(target = "receptionStamp" , source = "data.receptionStamp"),
            @Mapping(target = "controlNumber" , source = "data.controlNumber"),
            @Mapping(target = "dateIssuedOn" , source = "data.documentIssueDate" , qualifiedByName = "getDate"),
            @Mapping(target = "taxAmount" , source = "data.iva"),
            @Mapping(target = "typeIdentificationDocument" , source = "." , qualifiedByName = "getTypeIdentificationDocument"),
            @Mapping(target = "numberIdentificationDocument" , source = "." , qualifiedByName = "getDocumentNumber"),
            @Mapping(target = "name", source = "data.client.commercialName"),
            @Mapping(target = "phoneNumber" , source = "data.client.phone" , qualifiedBy = {CharacterReplacer.class , CharacterReplacerNoHyphen.class}),
            @Mapping(target = "email" , source = "data.client.email"),
    })
    DteDocumentInvalidationDto toDteDocumentInvalidationDto(ElectronicBillingCancellationsView data);


    @Named("getDteType")
    public static String getDteType(Integer documentType) throws Exception {

        if (documentType.equals(2)) {
            return "03";
        } else if (documentType.equals(12) || documentType.equals(15)) {
            return "01";
        } else if (documentType.equals(13) || documentType.equals(18)) {
            return "01";
        } else if (documentType.equals(17) || documentType.equals(19)) {
            return "11";
        } else if (documentType.equals(14)) {
            return "05";
        } else if (documentType.equals(16)) {
            return "06";
        } else if (documentType.equals(11)) {
            return "04";
        } else if (documentType.equals(20)) {
            return "07";
        } else {
            throw new Exception("unassigned tax document code");
        }

    }

    @Named("getDocumentNumber")
    static String getDocumentNumber(ElectronicBillingCancellationsView data) {
        if (data.getClient().getNit() == null)  {
            return data.getClient().getDui() != null ? data.getClient().getDui().replace("-" , "") : null;
        } else {
            return data.getClient().getNit() != null ? data.getClient().getNit().replace("-" , "") : null;
        }
    }

    @Named("getDate")
    public static String getDate(LocalDateTime documentDate) {
        return documentDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        //return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    @Named("getTypeIdentificationDocument")
    static String getTypeIdentificationDocument(ElectronicBillingCancellationsView data) {

        if (data.getClient().getCountryCode().equals(1)) {
            if (data.getClient().getNit() == null && data.getClient().getDui() == null) {
                return null;
            } else {
                return "36";
            }
        } else {
            return "37";
        }

    }

}
