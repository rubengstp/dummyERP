package com.stpmex.MyService.ERPDummy.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceResponse {
    private Long invoiceId;
    private Long pagoId;
    private String mensaje;
    private String mensajeError;
}
