package com.viduc.billingcore.mapper.sale;

import com.viduc.billingcore.domain.Sales;
import com.viduc.billingcore.dto.components.*;
import com.viduc.billingcore.utils.mapper.CharacterReplacerMapper;
import com.viduc.billingcore.utils.qualifier.CharacterReplacer;
import com.viduc.billingcore.utils.qualifier.CharacterReplacerNoHyphen;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(uses = CharacterReplacerMapper.class , nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface IDteReceiverMapper {

    IDteReceiverMapper INSTANCE = Mappers.getMapper(IDteReceiverMapper.class);


    @Mapping(target = "nit" , source = "data.client.nit" , qualifiedBy = {CharacterReplacer.class , CharacterReplacerNoHyphen.class})
    @Mapping(target = "nrc" , source = "data.client.nrc" , qualifiedBy = {CharacterReplacer.class , CharacterReplacerNoHyphen.class})
    @Mapping(target = "name" , source = "data.client.name")
    @Mapping(target = "commercialName" , source = "data.client.commercialName")
    @Mapping(target = "phoneNumber" , source = "data.client.phone" , qualifiedBy = {CharacterReplacer.class , CharacterReplacerNoHyphen.class})
    @Mapping(target = "email" , source = "data.client.email" , defaultValue = "no-reply@viduc.com.sv")
    //@Mapping(target = "email" , constant = "facturacion@viduc.com.sv")
    @Mapping(target = "activityCode" , source = "data.client.economicActivityCode" , defaultValue = "10005" , qualifiedByName = "getActivityCode")
    @Mapping(target = "activityDescription" , source = "data.client.descriptionEconomicActivity" , defaultValue = "Otros")
    //@Mapping(target = "activityCode" , source = "data.client.economicActivityCode" , defaultValue = "10005")
    //@Mapping(target = "activityDescription" , source = "data.client.descriptionEconomicActivity" , defaultValue = "Otros")
    //@Mapping(target = "address" , expression = "java(getAddress(data.getClient().getDepartment().getDepartmentCodeMH() , data.getClient().getMunicipality().getMunicipalityCodeMH() , data.getClient().getAddress()))")
    @Mapping(target = "address" , source = "." , qualifiedByName = "getAddress")
    DteReceiverTaxReceiptSaleDto toDteTaxReceiptDto(Sales data);


    @Mapping(target = "typeIdentificationDocument" , constant = "36")
    @Mapping(target = "numberIdentificationDocument" , source = "data.supplier.nit" , qualifiedBy = {CharacterReplacer.class , CharacterReplacerNoHyphen.class})
    @Mapping(target = "nrc" , source = "data.supplier.nrc" , qualifiedBy = {CharacterReplacer.class , CharacterReplacerNoHyphen.class})
    @Mapping(target = "name" , source = "data.supplier.name")
    @Mapping(target = "commercialName" , source = "data.supplier.name")
    @Mapping(target = "phoneNumber" , source = "data.supplier.phone" , qualifiedBy = {CharacterReplacer.class , CharacterReplacerNoHyphen.class})
    @Mapping(target = "email" , source = "data.supplier.email" , defaultValue = "no-reply@viduc.com.sv")
    //@Mapping(target = "email" , constant = "facturacion@viduc.com.sv")
    @Mapping(target = "activityCode" , source = "data.supplier.codeEconomicActivity" , defaultValue = "10005" , qualifiedByName = "getActivityCode")
    @Mapping(target = "activityDescription" , source = "data.supplier.descriptionEconomicActivity" , defaultValue = "Otros")
    //@Mapping(target = "activityCode" , source = "data.supplier.codeEconomicActivity" , defaultValue = "10005")
    //@Mapping(target = "activityDescription" , source = "data.supplier.descriptionEconomicActivity" , defaultValue = "Otros")
    //@Mapping(target = "address" , expression = "java(getAddress(data.getSupplier().getDepartment().getDepartmentCodeMH() , data.getSupplier().getMunicipality().getMunicipalityCodeMH() , data.getSupplier().getAddress()))")
    @Mapping(target = "address" , source = "." , qualifiedByName = "getAddress")
    DteReceiverWithholdingReceiptDto toDteWithholdingReceiptDto(Sales data);

    @Mapping(target = "nit" , source = "data.client.nit" , qualifiedBy = {CharacterReplacer.class , CharacterReplacerNoHyphen.class})
    @Mapping(target = "nrc" , source = "data.client.nrc" , qualifiedBy = {CharacterReplacer.class , CharacterReplacerNoHyphen.class})
    @Mapping(target = "name" , source = "data.client.name")
    @Mapping(target = "commercialName" , source = "data.client.commercialName")
    @Mapping(target = "phoneNumber" , source = "data.client.phone" , qualifiedBy = {CharacterReplacer.class , CharacterReplacerNoHyphen.class})
    @Mapping(target = "email" , source = "data.client.email" , defaultValue = "no-reply@viduc.com.sv")
    //@Mapping(target = "email" , constant = "facturacion@viduc.com.sv")
    @Mapping(target = "activityCode" , source = "data.client.economicActivityCode" , defaultValue = "10005" , qualifiedByName = "getActivityCode")
    @Mapping(target = "activityDescription" , source = "data.client.descriptionEconomicActivity" , defaultValue = "Otros")
    //@Mapping(target = "activityCode" , source = "data.client.economicActivityCode" , defaultValue = "10005")
    //@Mapping(target = "activityDescription" , source = "data.client.descriptionEconomicActivity" , defaultValue = "Otros")
    //@Mapping(target = "address" , expression = "java(getAddress(data.getClient().getDepartment().getDepartmentCodeMH() , data.getClient().getMunicipality().getMunicipalityCodeMH() , data.getClient().getAddress()))")
    @Mapping(target = "address" , source = "." , qualifiedByName = "getAddress")
    DteReceiverCreditNoteDto toDteCreditNoteDto(Sales data);

    @Mapping(target = "nit" , source = "data.client.nit" , qualifiedBy = {CharacterReplacer.class , CharacterReplacerNoHyphen.class})
    @Mapping(target = "nrc" , source = "data.client.nrc" , qualifiedBy = {CharacterReplacer.class , CharacterReplacerNoHyphen.class})
    @Mapping(target = "name" , source = "data.client.name")
    @Mapping(target = "commercialName" , source = "data.client.commercialName")
    @Mapping(target = "phoneNumber" , source = "data.client.phone" , qualifiedBy = {CharacterReplacer.class , CharacterReplacerNoHyphen.class})
    //@Mapping(target = "email" , constant = "facturacion@viduc.com.sv")
    @Mapping(target = "email" , source = "data.client.email" , defaultValue = "no-reply@viduc.com.sv")
    @Mapping(target = "activityCode" , source = "data.client.economicActivityCode" , defaultValue = "10005" , qualifiedByName = "getActivityCode")
    @Mapping(target = "activityDescription" , source = "data.client.descriptionEconomicActivity" , defaultValue = "Otros")
    //@Mapping(target = "activityCode" , source = "data.client.economicActivityCode" , defaultValue = "10005")
    //@Mapping(target = "activityDescription" , source = "data.client.descriptionEconomicActivity" , defaultValue = "Otros")
    //@Mapping(target = "address" , expression = "java(getAddress(data.getClient().getDepartment().getDepartmentCodeMH() , data.getClient().getMunicipality().getMunicipalityCodeMH() , data.getClient().getAddress()))")
    @Mapping(target = "address" , source = "." , qualifiedByName = "getAddress")
    DteReceiverDebitNoteDto toDteDebitNoteDto(Sales data);

    @Mappings({
            @Mapping(target = "name" , source = "data.client.name"),
            @Mapping(target = "phoneNumber" , source = "data.client.phone" , qualifiedBy = {CharacterReplacer.class , CharacterReplacerNoHyphen.class}),
            @Mapping(target = "email" , source = "data.client.email"),
            //@Mapping(target = "email" , constant = "facturacion@viduc.com.sv"),
            @Mapping(target = "typeIdentificationDocument" , source = "." , qualifiedByName = "getTypeIdentificationDocument"),
            @Mapping(target = "numberIdentificationDocument" , source = "." , qualifiedByName = "getDocumentNumber"),
            @Mapping(target = "nrc" , source = "data.client.nrc" , qualifiedBy = {CharacterReplacer.class , CharacterReplacerNoHyphen.class}),
            @Mapping(target = "activityCode" , source = "data.client.economicActivityCode" , defaultValue = "10005" , qualifiedByName = "getActivityCode"),
            @Mapping(target = "activityDescription" , source = "data.client.descriptionEconomicActivity" , defaultValue = "Otros"),
            //@Mapping(target = "activityCode" , source = "data.client.economicActivityCode" , defaultValue = "10005"),
            //@Mapping(target = "activityDescription" , source = "data.client.descriptionEconomicActivity" , defaultValue = "Otros"),
            //@Mapping(target = "address" , expression = "java(getAddress(data.getClient().getCountryCode() ,data.getClient().getDepartment().getDepartmentCodeMH() , data.getClient().getMunicipality().getMunicipalityCodeMH() , data.getClient().getAddress()))")
            @Mapping(target = "address" , source = "." , qualifiedByName = "getAddress")
    })
    DteReceiverInvoiceSaleDto toDteInvoiceSaleDto(Sales data);

    @Mappings({
            @Mapping(target = "name" , source = "data.client.name"),
            @Mapping(target = "phoneNumber" , source = "data.client.phone" , qualifiedBy = {CharacterReplacer.class , CharacterReplacerNoHyphen.class}),
            @Mapping(target = "email" , source = "data.client.email" , defaultValue = "no-reply@viduc.com.sv"),
            //@Mapping(target = "email" , constant = "facturacion@viduc.com.sv"),
            @Mapping(target = "typeIdentificationDocument" , source = "." , qualifiedByName = "getTypeIdentificationDocument"),
            @Mapping(target = "numberIdentificationDocument" , source = "data.nit" , qualifiedBy = {CharacterReplacer.class , CharacterReplacerNoHyphen.class}),
            @Mapping(target = "activityDescription" , source = "data.client.descriptionEconomicActivity" , defaultValue = "Otros"),
            //@Mapping(target = "activityDescription" , source = "data.client.descriptionEconomicActivity" , defaultValue = "Otros"),
            @Mapping(target = "countryCode" , source = "data.client.country.countryCodeMH"),
            @Mapping(target = "countryName" , source = "data.client.country.description"),
            @Mapping(target = "complement" , source = "data.client.address"),
            @Mapping(target = "personType" , source = "data.client.personType"),
    })
    DteReceiverExportInvoiceSaleDto toDteExportSaleDto(Sales data);

    @Mappings({
            @Mapping(target = "name" , source = "data.company.businessName"),
            @Mapping(target = "nrc" , source = "data.company.nrc" , qualifiedBy = {CharacterReplacer.class , CharacterReplacerNoHyphen.class}),
            @Mapping(target = "referralType" , constant = "04"),
            @Mapping(target = "phoneNumber" , source = "data.company.phoneNumber" , qualifiedBy = {CharacterReplacer.class , CharacterReplacerNoHyphen.class}),
            @Mapping(target = "email" , source = "data.company.email"),
            @Mapping(target = "typeIdentificationDocument" , constant = "36"),
            @Mapping(target = "activityCode" , source = "data.company.economicActivityCode" , defaultValue = "10005" , qualifiedByName = "getActivityCode"),
            @Mapping(target = "numberIdentificationDocument" , source = "data.company.nit" , qualifiedBy = {CharacterReplacer.class , CharacterReplacerNoHyphen.class}),
            @Mapping(target = "activityDescription" , source = "data.company.descriptionEconomicActivity" , defaultValue = "Otros"),
            @Mapping(target = "address" , expression = "java(getCompanyAddress(data.getCompanyDepartment().getDepartmentCodeMH() , data.getCompanyMunicipality().getMunicipalityCodeMH() , data.getCompany().getAddress()))")
    })
    DteReceiverDeliveryNoteDto toDteDeliveryNoteDto(InventoryMovementDto data);

    @Named("getDocumentNumber")
    static String getDocumentNumber(Sales data) {
        if (data.getClient().getNit() == null)  {
            return data.getClient().getDui() != null ? data.getClient().getDui().replace("-" , "") : null;
        } else {
            return data.getClient().getNit() != null ? data.getClient().getNit().replace("-" , "") : null;
        }
    }

    @Named("getTypeIdentificationDocument")
    static String getTypeIdentificationDocument(Sales data) {

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

    default DteAddressDto getCompanyAddress(String departmentCode , String municipalityCode , String complement) {
        return DteAddressDto.builder().departmentCode(departmentCode).municipality(municipalityCode).complement(complement).build();
    }

    @Named("getActivityCode")
    default String getActivityCode(Integer activityCode) {
        return String.format("%05d" , activityCode);
    }

    @Named("getAddress")
    default DteAddressDto getAddress(Sales data) {

        DteAddressDto address = null;

        if (data.getId().getDocumentTypeCode().equals(12) || data.getId().getDocumentTypeCode().equals(13)) {
            if (data.getClient().getCountryCode().equals(1)) {

                if (data.getClient().getAddress() != null) {
                    address = DteAddressDto.builder().
                            departmentCode(data.getClient().getDepartment().getDepartmentCodeMH())
                            .municipality(data.getClient().getMunicipality().getMunicipalityCodeMH())
                            .complement(data.getClient().getAddress()).build();
                }

            }
        } else if (data.getId().getDocumentTypeCode().equals(20)) {
            address = DteAddressDto.builder().
                    departmentCode(data.getSupplier().getDepartment().getDepartmentCodeMH())
                    .municipality(data.getSupplier().getMunicipality().getMunicipalityCodeMH())
                    .complement(data.getSupplier().getAddress()).build();
        } else {

            address = DteAddressDto.builder().
                    departmentCode(data.getClient().getDepartment().getDepartmentCodeMH())
                    .municipality(data.getClient().getMunicipality().getMunicipalityCodeMH())
                    .complement(data.getClient().getAddress()).build();
        }

        return  address;

    }



}
