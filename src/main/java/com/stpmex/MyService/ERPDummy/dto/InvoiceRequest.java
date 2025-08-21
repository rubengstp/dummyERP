package com.stpmex.MyService.ERPDummy.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class InvoiceRequest {
    @NotBlank(message = "OrdenCompra is required")
    @JsonProperty("OrdenCompra")
    private String ordenCompra;
    
    @NotBlank(message = "AplicaOC is required")
    @JsonProperty("AplicaOC")
    private String aplicaOC;
    
    @NotBlank(message = "Description is required")
    @JsonProperty("Description")
    private String description;
    
    @NotBlank(message = "XML_FACT is required")
    @JsonProperty("XML_FACT")
    private String xmlFact;
    
    @NotBlank(message = "PDF_FACT is required")
    @JsonProperty("PDF_FACT")
    private String pdfFact;
}