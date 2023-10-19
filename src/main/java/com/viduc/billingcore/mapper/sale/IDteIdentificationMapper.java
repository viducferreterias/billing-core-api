package com.viduc.billingcore.mapper.sale;

import com.viduc.billingcore.domain.Sales;
import com.viduc.billingcore.dto.components.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Mapper
public interface IDteIdentificationMapper {

    IDteIdentificationMapper INSTANCE = Mappers.getMapper(IDteIdentificationMapper.class);

    @Mapping(target = "version" , source = "data.taxDocumentVersion")
    @Mapping(target = "destinationEnvironment" , constant = "00")
    @Mapping(target = "dteType" , source = "data.id.documentTypeCode" , qualifiedByName = "getDteType")
    @Mapping(target = "dateIssuedOn" , source = "documentDate"  , qualifiedByName = "getDate")
    @Mapping(target = "hourIssuedOn" , source = "documentDate" , qualifiedByName = "getTime")
    @Mapping(target = "coinType" , constant = "USD")
    DteIdentificationBaseDocumentDto identificationToIdentificationDto(Sales data);


    @Mappings({
            @Mapping(target = "version" , source = "data.taxDocumentVersion"),
            @Mapping(target = "destinationEnvironment" , constant = "00"),
            @Mapping(target = "dteType" , source = "data.type" , qualifiedByName = "getDteType"),
            @Mapping(target = "dateIssuedOn" , source = "data.dateIssuedOn" ),
            @Mapping(target = "hourIssuedOn" , source = "data.hourIssuedOn" ),
            @Mapping(target = "coinType" , constant = "USD")
    })
    DteIdentificationBaseDocumentDto toIdentificationInventoryDto(InventoryMovementDto data);

    @Named("getDate")
    public static String getDate(LocalDateTime documentDate) {
        //return documentDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        return LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    @Named("getTime")
    public static String getTime(LocalDateTime documentDate) {
        return documentDate.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
    }

    @Named("getDteType")
    public static String getDteType(Integer documentType) throws Exception {

        if (documentType.equals(2)) {
            return "03";
        } else if (documentType.equals(12)) {
            return "01";
        } else if (documentType.equals(13)) {
            return "01";
        } else if (documentType.equals(17)) {
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


}
