package com.stpmex.MyService.ERPDummy;

import com.stpmex.MyService.ERPDummy.dto.*;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Slf4j
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

    @PostMapping("/get-invoice")
    public ResponseEntity<GetInvoiceResponse> getInvoice(@Valid @RequestBody GetInvoiceRequest recuperaFactura) {
        log.info("get-invoice: " + recuperaFactura);

        GetInvoiceResponse response = new GetInvoiceResponse();

        List<OrderDTO> orders = new ArrayList<>();
        response.setTipoDeDocumento("I");
        response.setRfc("ASE1809185N2");
        response.setPaymentMethod("");

        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setDocumentStatus("");
        orderDTO.setCreationDate("2024-07-23T18:32:43.000+00:00");
        orderDTO.setPoNumber("OC_1");
        orderDTO.setCurrencyCode("MXN");
        orderDTO.setApprovedFlag("");
        orderDTO.setPaymentTerms("Inmediato");
        orderDTO.setAmount("100.10");
        orders.add(orderDTO);

        response.setOrders(orders);

        return ResponseEntity.ok(response);

    }

}
