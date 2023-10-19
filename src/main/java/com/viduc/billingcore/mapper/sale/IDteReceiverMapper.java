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
    //@Mapping(target = "email" , source = "data.client.email")
    @Mapping(target = "email" , constant = "facturacionelectronica@viduc.com.sv")
    //@Mapping(target = "activityCode" , source = "data.client.economicActivityCode")
    //@Mapping(target = "activityDescription" , source = "data.client.descriptionEconomicActivity")
    @Mapping(target = "activityCode" , source = "data.client.economicActivityCode" , defaultValue = "10005")
    @Mapping(target = "activityDescription" , source = "data.client.descriptionEconomicActivity" , defaultValue = "Otros")
    @Mapping(target = "address" , expression = "java(getAddress(data.getClient().getDepartment().getDepartmentCodeMH() , data.getClient().getMunicipality().getMunicipalityCodeMH() , data.getClient().getAddress()))")
    DteReceiverTaxReceiptSaleDto toDteTaxReceiptDto(Sales data);


    @Mapping(target = "typeIdentificationDocument" , constant = "36")
    @Mapping(target = "numberIdentificationDocument" , source = "data.supplier.nit" , qualifiedBy = {CharacterReplacer.class , CharacterReplacerNoHyphen.class})
    @Mapping(target = "nrc" , source = "data.supplier.nrc" , qualifiedBy = {CharacterReplacer.class , CharacterReplacerNoHyphen.class})
    @Mapping(target = "name" , source = "data.supplier.name")
    @Mapping(target = "commercialName" , source = "data.supplier.name")
    @Mapping(target = "phoneNumber" , source = "data.supplier.phone" , qualifiedBy = {CharacterReplacer.class , CharacterReplacerNoHyphen.class})
    //@Mapping(target = "email" , source = "data.supplier.email")
    @Mapping(target = "email" , constant = "facturacionelectronica@viduc.com.sv")
    //@Mapping(target = "activityCode" , source = "data.supplier.economicActivityCode")
    //@Mapping(target = "activityDescription" , source = "data.supplier.descriptionEconomicActivity")
    @Mapping(target = "activityCode" , source = "data.supplier.codeEconomicActivity" , defaultValue = "10005")
    @Mapping(target = "activityDescription" , source = "data.supplier.descriptionEconomicActivity" , defaultValue = "Otros")
    @Mapping(target = "address" , expression = "java(getAddress(data.getSupplier().getDepartment().getDepartmentCodeMH() , data.getSupplier().getMunicipality().getMunicipalityCodeMH() , data.getSupplier().getAddress()))")
    DteReceiverWithholdingReceiptDto toDteWithholdingReceiptDto(Sales data);

    @Mapping(target = "nit" , source = "data.client.nit" , qualifiedBy = {CharacterReplacer.class , CharacterReplacerNoHyphen.class})
    @Mapping(target = "nrc" , source = "data.client.nrc" , qualifiedBy = {CharacterReplacer.class , CharacterReplacerNoHyphen.class})
    @Mapping(target = "name" , source = "data.client.name")
    @Mapping(target = "commercialName" , source = "data.client.commercialName")
    @Mapping(target = "phoneNumber" , source = "data.client.phone" , qualifiedBy = {CharacterReplacer.class , CharacterReplacerNoHyphen.class})
    //@Mapping(target = "email" , source = "data.client.email")
    @Mapping(target = "email" , constant = "facturacionelectronica@viduc.com.sv")
    //@Mapping(target = "activityCode" , source = "data.client.economicActivityCode")
    //@Mapping(target = "activityDescription" , source = "data.client.descriptionEconomicActivity")
    @Mapping(target = "activityCode" , source = "data.client.economicActivityCode" , defaultValue = "10005")
    @Mapping(target = "activityDescription" , source = "data.client.descriptionEconomicActivity" , defaultValue = "Otros")
    @Mapping(target = "address" , expression = "java(getAddress(data.getClient().getDepartment().getDepartmentCodeMH() , data.getClient().getMunicipality().getMunicipalityCodeMH() , data.getClient().getAddress()))")
    DteReceiverCreditNoteDto toDteCreditNoteDto(Sales data);

    @Mapping(target = "nit" , source = "data.client.nit" , qualifiedBy = {CharacterReplacer.class , CharacterReplacerNoHyphen.class})
    @Mapping(target = "nrc" , source = "data.client.nrc" , qualifiedBy = {CharacterReplacer.class , CharacterReplacerNoHyphen.class})
    @Mapping(target = "name" , source = "data.client.name")
    @Mapping(target = "commercialName" , source = "data.client.commercialName")
    @Mapping(target = "phoneNumber" , source = "data.client.phone" , qualifiedBy = {CharacterReplacer.class , CharacterReplacerNoHyphen.class})
    @Mapping(target = "email" , source = "data.client.email")
    //@Mapping(target = "activityCode" , source = "data.client.economicActivityCode")
    //@Mapping(target = "activityDescription" , source = "data.client.descriptionEconomicActivity")
    @Mapping(target = "activityCode" , source = "data.client.economicActivityCode" , defaultValue = "10005")
    @Mapping(target = "activityDescription" , source = "data.client.descriptionEconomicActivity" , defaultValue = "Otros")
    @Mapping(target = "address" , expression = "java(getAddress(data.getClient().getDepartment().getDepartmentCodeMH() , data.getClient().getMunicipality().getMunicipalityCodeMH() , data.getClient().getAddress()))")
    DteReceiverDebitNoteDto toDteDebitNoteDto(Sales data);

    @Mappings({
            @Mapping(target = "name" , source = "data.client.name"),
            @Mapping(target = "phoneNumber" , source = "data.client.phone" , qualifiedBy = {CharacterReplacer.class , CharacterReplacerNoHyphen.class}),
            //@Mapping(target = "email" , source = "data.client.email"),
            @Mapping(target = "email" , constant = "facturacionelectronica@viduc.com.sv"),
            @Mapping(target = "typeIdentificationDocument" , source = "." , qualifiedByName = "getTypeIdentificationDocument"),
            @Mapping(target = "numberIdentificationDocument" , source = "." , qualifiedByName = "getDocumentNumber"),
            @Mapping(target = "nrc" , source = "data.client.nrc" , qualifiedBy = {CharacterReplacer.class , CharacterReplacerNoHyphen.class}),
            //@Mapping(target = "activityCode" , source = "data.client.economicActivityCode"),
            //@Mapping(target = "activityDescription" , source = "data.client.descriptionEconomicActivity"),
            @Mapping(target = "activityCode" , source = "data.client.economicActivityCode" , defaultValue = "10005"),
            @Mapping(target = "activityDescription" , source = "data.client.descriptionEconomicActivity" , defaultValue = "Otros"),
            @Mapping(target = "address" , expression = "java(getAddress(data.getClient().getDepartment().getDepartmentCodeMH() , data.getClient().getMunicipality().getMunicipalityCodeMH() , data.getClient().getAddress()))")
    })
    DteReceiverInvoiceSaleDto toDteInvoiceSaleDto(Sales data);

    @Mappings({
            @Mapping(target = "name" , source = "data.client.name"),
            @Mapping(target = "phoneNumber" , source = "data.client.phone" , qualifiedBy = {CharacterReplacer.class , CharacterReplacerNoHyphen.class}),
            //@Mapping(target = "email" , source = "data.client.email"),
            @Mapping(target = "email" , constant = "facturacionelectronica@viduc.com.sv"),
            @Mapping(target = "typeIdentificationDocument" , constant = "36"),
            @Mapping(target = "numberIdentificationDocument" , source = "data.client.nit" ),
            //@Mapping(target = "activityDescription" , source = "data.client.descriptionEconomicActivity"),
            @Mapping(target = "activityDescription" , source = "data.client.descriptionEconomicActivity" , defaultValue = "Otros"),
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
            @Mapping(target = "activityCode" , source = "data.company.economicActivityCode"),
            @Mapping(target = "numberIdentificationDocument" , source = "data.company.nit" , qualifiedBy = {CharacterReplacer.class , CharacterReplacerNoHyphen.class}),
            @Mapping(target = "activityDescription" , source = "data.company.descriptionEconomicActivity"),
            @Mapping(target = "address" , expression = "java(getAddress(data.getCompanyDepartment().getDepartmentCodeMH() , data.getCompanyMunicipality().getMunicipalityCodeMH() , data.getCompany().getAddress()))")
    })
    DteReceiverDeliveryNoteDto toDteDeliveryNoteDto(InventoryMovementDto data);

    @Named("getDocumentNumber")
    static String getDocumentNumber(Sales data) {
        if (data.getClient().getNit() == null)  {
            return data.getClient().getDui();
        } else {
            return data.getClient().getNit();
        }
    }

    @Named("getTypeIdentificationDocument")
    static String getTypeIdentificationDocument(Sales data) {
        if (data.getClient().getNit() == null && data.getClient().getDui() == null) {
            return null;
        } else {
            return "36";
        }
    }

    default DteAddressDto getAddress(String departmentCode , String municipalityCode , String complement) {
        return DteAddressDto.builder().departmentCode(departmentCode).municipality(municipalityCode).complement(complement).build();
    }

}
