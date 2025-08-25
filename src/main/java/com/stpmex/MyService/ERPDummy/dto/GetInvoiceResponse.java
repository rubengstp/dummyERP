package com.stpmex.MyService.ERPDummy.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GetInvoiceResponse {
    private String tipoDeDocumento;
    @JsonProperty("RFC")
    private String rfc;
    private String paymentMethod;
    private List<OrderDTO> orders;
    private String importe;
}
