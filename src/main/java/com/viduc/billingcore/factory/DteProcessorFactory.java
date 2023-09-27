package com.viduc.billingcore.factory;

import com.viduc.billingcore.impl.inventory.DteDeliveryNoteImpl;
import com.viduc.billingcore.impl.sale.*;
import com.viduc.billingcore.repository.sale.IDteProcessor;
import com.viduc.billingcore.utils.enums.DocumentType;
import com.viduc.billingcore.utils.qualifier.TypeElectronicDocument;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Produces;

import java.io.Serializable;

@RequestScoped
public class DteProcessorFactory implements Serializable {

    @Produces
    @TypeElectronicDocument(DocumentType.FISCAL_CREDIT)
    public IDteProcessor getFiscalCreditDte() {
        return new DteTaxReceiptImpl();
    }

    @Produces
    @TypeElectronicDocument(DocumentType.BILL)
    public IDteProcessor getBillDte() {
        return new DteBillImpl();
    }

    @Produces
    @TypeElectronicDocument(DocumentType.EXPORT_INVOICE)
    public IDteProcessor getExportDte() {
        return new DteExportBillImpl();
    }

    @Produces
    @TypeElectronicDocument(DocumentType.CREDIT_NOTE)
    public IDteProcessor getCreditNoteDte() {
        return  new DteCreditNoteImpl();
    }

    @Produces
    @TypeElectronicDocument(DocumentType.DEBIT_NOTE)
    public IDteProcessor getDebitNOteDte(){
        return new DteDebitNoteImpl();
    }

    @Produces
    @TypeElectronicDocument(DocumentType.DELIVERY_NOTE)
    public IDteProcessor getDeliveryNoteDte() {
        return new DteDeliveryNoteImpl();
    }

}
