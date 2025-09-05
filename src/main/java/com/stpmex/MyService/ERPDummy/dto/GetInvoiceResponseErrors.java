package com.stpmex.MyService.ERPDummy.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetInvoiceResponseErrors {

    private String tipoDeDocumento;
    @JsonProperty("RFC")
    private String rfc;
    private String paymentMethod;

}
