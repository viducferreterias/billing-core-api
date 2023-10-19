package com.viduc.billingcore.dto.components;

import com.viduc.billingcore.domain.Company;
import com.viduc.billingcore.domain.Department;
import com.viduc.billingcore.domain.Municipality;
import com.viduc.billingcore.domain.PointSale;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class InventoryMovementDto {

    private Integer type;
    private Integer number;
    private Integer warehouse;
    private Integer companyId;
    private LocalDateTime issuedOn;
    private String controlNumber;
    private String generationCode;
    private Integer taxDocumentVersion;
    private Integer billingModel;
    private Integer transmissionType;
    private Integer contingencyType;
    private String contingencyReason;
    private Float total;
    private Float subtotal;
    private Integer destinationWarehouse;
    private Integer originAgency;
    private Integer destinationAgency;
    private Integer receivedBy;
    private String valueInWord;
    private String dateIssuedOn;
    private String hourIssuedOn;
    private Integer impression;
    private Company company;
    private PointSale pointSale;
    private Department pointSaleDepartment;
    private Municipality pointSaleMunicipality;
    private Department companyDepartment;
    private Municipality companyMunicipality;

}
