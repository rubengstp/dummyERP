package com.stpmex.MyService.ERPDummy.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDTO {

    @JsonProperty("DOCUMENT_STATUS")
    private String documentStatus;

    @JsonProperty("CREATION_DATE")
    private String creationDate;

    @JsonProperty("PO_NUMBER")
    private String poNumber;

    @JsonProperty("CURRENCY_CODE")
    private String currencyCode;

    @JsonProperty("APPROVED_FLAG")
    private String approvedFlag;

    @JsonProperty("PAYMENT_TERMS")
    private String paymentTerms;

    @JsonProperty("AMOUNT")
    private String amount;

}