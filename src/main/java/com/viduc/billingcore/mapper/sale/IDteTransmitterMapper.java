package com.viduc.billingcore.mapper.sale;

import com.viduc.billingcore.domain.Sales;
import com.viduc.billingcore.domain.Setting;
import com.viduc.billingcore.dto.components.DteAddressDto;
import com.viduc.billingcore.dto.components.DteTransmitterDto;
import com.viduc.billingcore.dto.components.DteTransmitterExportSaleDto;
import com.viduc.billingcore.dto.components.InventoryMovementDto;
import com.viduc.billingcore.utils.mapper.CharacterReplacerMapper;
import com.viduc.billingcore.utils.qualifier.CharacterReplacer;
import com.viduc.billingcore.utils.qualifier.CharacterReplacerNoHyphen;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = CharacterReplacerMapper.class)
public interface IDteTransmitterMapper {

    IDteTransmitterMapper INSTANCE = Mappers.getMapper(IDteTransmitterMapper.class);

    @Mapping(target = "nit" , source = "data.company.nit" , qualifiedBy = {CharacterReplacer.class , CharacterReplacerNoHyphen.class})
    @Mapping(target = "nrc" , source = "data.company.nrc" , qualifiedBy = {CharacterReplacer.class , CharacterReplacerNoHyphen.class})
    @Mapping(target = "name", source = "data.company.businessName")
    @Mapping(target = "commercialName" , source = "data.company.commercialName")
    @Mapping(target = "activityCode" , source = "data.company.economicActivityCode")
    //@Mapping(target = "activityDescription" , source = "data.company.descriptionEconomicActivity")
    @Mapping(target = "activityDescription" , constant = "Venta al por mayor de artículos de ferretería y pinturerías")
    @Mapping(target = "phone" , source = "data.company.phoneNumber" , qualifiedBy = {CharacterReplacer.class , CharacterReplacerNoHyphen.class})
    @Mapping(target = "email" , source = "data.company.email")
    @Mapping(target = "establishmentType" , source = "data.pointSale.establishmentType")
    @Mapping(target = "establishmentCodeMh" , source = "data.pointSale.establishmentCodeMH")
    @Mapping(target = "pointSaleCodeMh" , source = "data.pointSale.pointSaleCodeMH")
    //@Mapping(target = "pointSaleCode" , source = "data.pointSale.id")
    @Mapping(target = "pointSaleCode" , ignore = true)
    //@Mapping(target = "establishmentCode" , source = "data.pointSale.agencyCode")
    @Mapping(target = "establishmentCode" , ignore = true)
    @Mapping(target = "address" , expression = "java(getAddress(data.getPointSale().getDepartment().getDepartmentCodeMH() , data.getPointSale().getMunicipality().getMunicipalityCodeMH() , data.getPointSale().getAddress()))")
    DteTransmitterDto transmitterDataToDto(Sales data);

    @Mapping(target = "nit" , source = "data.company.nit" , qualifiedBy = {CharacterReplacer.class , CharacterReplacerNoHyphen.class})
    @Mapping(target = "nrc" , source = "data.company.nrc" , qualifiedBy = {CharacterReplacer.class , CharacterReplacerNoHyphen.class})
    @Mapping(target = "name", source = "data.company.businessName")
    @Mapping(target = "commercialName" , source = "data.company.commercialName")
    @Mapping(target = "activityCode" , source = "data.company.economicActivityCode")
    //@Mapping(target = "activityDescription" , source = "data.company.descriptionEconomicActivity")
    @Mapping(target = "activityDescription" , constant = "Venta al por mayor de artículos de ferretería y pinturerías")
    @Mapping(target = "phone" , source = "data.company.phoneNumber" , qualifiedBy = {CharacterReplacer.class , CharacterReplacerNoHyphen.class})
    @Mapping(target = "email" , source = "data.company.email")
    @Mapping(target = "establishmentType" , source = "data.pointSale.establishmentType")
    @Mapping(target = "establishmentCodeMh" , source = "data.pointSale.establishmentCodeMH")
    @Mapping(target = "pointSaleCodeMh" , source = "data.pointSale.pointSaleCodeMH")
    //@Mapping(target = "pointSaleCode" , source = "data.pointSale.id")
    @Mapping(target = "pointSaleCode" , ignore = true)
    //@Mapping(target = "establishmentCode" , source = "data.pointSale.agencyCode")
    @Mapping(target = "establishmentCode" , ignore = true)
    @Mapping(target = "address" , expression = "java(getAddress(data.getCompanyDepartment().getDepartmentCodeMH() , data.getCompanyMunicipality().getMunicipalityCodeMH() , data.getCompany().getAddress()))")
    DteTransmitterDto toDteTransmitterDeliverNote(InventoryMovementDto data);

    @Mapping(target = "nit" , source = "data.company.nit" , qualifiedBy = {CharacterReplacer.class , CharacterReplacerNoHyphen.class})
    @Mapping(target = "nrc" , source = "data.company.nrc" , qualifiedBy = {CharacterReplacer.class , CharacterReplacerNoHyphen.class})
    @Mapping(target = "name", source = "data.company.businessName")
    @Mapping(target = "commercialName" , source = "data.company.commercialName")
    @Mapping(target = "activityCode" , source = "data.company.economicActivityCode")
    //@Mapping(target = "activityDescription" , source = "data.company.descriptionEconomicActivity")
    @Mapping(target = "activityDescription" , constant = "Venta al por mayor de artículos de ferretería y pinturerías")
    @Mapping(target = "phone" , source = "data.company.phoneNumber" , qualifiedBy = {CharacterReplacer.class , CharacterReplacerNoHyphen.class})
    @Mapping(target = "email" , source = "data.company.email")
    @Mapping(target = "establishmentType" , source = "data.pointSale.establishmentType")
    @Mapping(target = "establishmentCodeMh" , source = "data.pointSale.establishmentCodeMH")
    @Mapping(target = "pointSaleCodeMh" , source = "data.pointSale.pointSaleCodeMH")
    //@Mapping(target = "pointSaleCode" , source = "data.pointSale.id")
    @Mapping(target = "pointSaleCode" , ignore = true)
    //@Mapping(target = "establishmentCode" , source = "data.pointSale.agencyCode")
    @Mapping(target = "establishmentCode" , ignore = true)
    @Mapping(target = "address" , expression = "java(getAddress(data.getPointSale().getDepartment().getDepartmentCodeMH() , data.getPointSale().getMunicipality().getMunicipalityCodeMH() , data.getPointSale().getAddress()))")
    @Mapping(target = "exportItemType" , constant = "1")
    @Mapping(target = "bondedWarehouse" , source = "data.electronicBillingSummary.bondedWarehouseCode")
    @Mapping(target = "exportRegime" , source = "data.electronicBillingSummary.exportRegimeCode")
    DteTransmitterExportSaleDto toDteTransmitterExportBillDto(Sales data);

    default DteAddressDto getAddress(String departmentCode , String municipalityCode , String complement) {
        return DteAddressDto.builder().departmentCode(departmentCode).municipality(municipalityCode).complement(complement).build();
    }


}
