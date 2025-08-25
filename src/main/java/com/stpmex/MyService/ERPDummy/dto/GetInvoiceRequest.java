package com.stpmex.MyService.ERPDummy.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.ToString;

@ToString
public class GetInvoiceRequest {
    @JsonProperty("XML_INFO")
    @NotBlank
    private String xml_info;
}
