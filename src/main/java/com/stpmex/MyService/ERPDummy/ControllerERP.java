package com.stpmex.MyService.ERPDummy;

import com.stpmex.MyService.ERPDummy.dto.InvoiceRequest;
import com.stpmex.MyService.ERPDummy.dto.InvoiceResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/erp")
public class ControllerERP {

    @PostMapping("/process-invoice")
    public ResponseEntity<InvoiceResponse> processInvoice(@Valid @RequestBody InvoiceRequest request) {

        boolean isSuccess = true;
        
        if (isSuccess) {
            InvoiceResponse response = new InvoiceResponse(
                21587238742323L, // Example invoice ID
                21587238742323L, // Example payment ID
                "Factura procesada exitosamente",
                null
            );
            return ResponseEntity.ok(response);
        } else {
            InvoiceResponse response = new InvoiceResponse(
                null,
                null,
                null,
                "Error al procesar la factura"
            );
            return ResponseEntity.badRequest().body(response);
        }
    }
}
