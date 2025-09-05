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
import java.util.Objects;

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
    public ResponseEntity<?> getInvoice(@Valid @RequestBody GetInvoiceRequest recuperaFactura) {
        log.info("get-invoice: " + recuperaFactura);

        String serie = recuperaFactura.getTagFromXML("Serie");
        log.info("Serie: " + serie);

        GetInvoiceResponseErrors responseErrors = new GetInvoiceResponseErrors();
        if (serie.equals("B")) {
            responseErrors.setTipoDeDocumento("Error general en la integracion. Razon: Received a SOAPFault while invoking https://ibbqqy-test.fa.ocs.oraclecloud.com:443/xmlpserver/services/ExternalReportWSSService due to \"PublicReportService::generateReport for reportAbsolutePath [/Custom/Payables/Invoices/XXSTP_PURCHASING_ORDERS_REP.xdo] Failure: Due to oracle.xdo.servlet.CreateException: oracle.xdo.servlet.CreateException: Report definition not found:/Custom/Payables/Invoices/XXSTP_PURCHASING_ORDERS_REP.xdo [username=stp.integrador]\"");
            responseErrors.setRfc("");
            responseErrors.setPaymentMethod("");

            return ResponseEntity.badRequest().body(responseErrors);
        }else if (serie.equals("C")) {
            responseErrors.setTipoDeDocumento("P");
            responseErrors.setRfc("Campo RFC vacio en el XML o el comprobante no es de tipo I");
            responseErrors.setPaymentMethod("");

            return ResponseEntity.badRequest().body(responseErrors);
        }else if (serie.equals("D")) {
            responseErrors.setTipoDeDocumento("");
            responseErrors.setRfc("Campo RFC vacio en el XML o el comprobante no es de tipo I");
            responseErrors.setPaymentMethod("");

            return ResponseEntity.badRequest().body(responseErrors);
        }else if (serie.equals("E")) {
            responseErrors.setTipoDeDocumento("");
            responseErrors.setRfc("No se encontraron ordenes de compra abiertas o el proveedor con el RFC XXXXXXXXXXXX no existe en el ERP");

            return ResponseEntity.badRequest().body(responseErrors);
        }else if (serie.equals("F")) {
            responseErrors.setTipoDeDocumento("");
            responseErrors.setRfc("");
            responseErrors.setPaymentMethod("Error al obtener metodo de pago");

            return ResponseEntity.badRequest().body(responseErrors);
        }else {//HAPPY PATH

            GetInvoiceResponseHappyPath responseHappyPath = new GetInvoiceResponseHappyPath();

            List<OrderDTO> orders = new ArrayList<>();
            responseHappyPath.setTipoDeDocumento("I");
            responseHappyPath.setRfc("ASE1809185N2");
            responseHappyPath.setPaymentMethod("");

            OrderDTO orderDTO = new OrderDTO();
            orderDTO.setDocumentStatus("");
            orderDTO.setCreationDate("2024-07-23T18:32:43.000+00:00");
            orderDTO.setPoNumber("OC_1");
            orderDTO.setCurrencyCode("MXN");
            orderDTO.setApprovedFlag("");
            orderDTO.setPaymentTerms("Inmediato");
            orderDTO.setAmount("100.10");
            orders.add(orderDTO);

            responseHappyPath.setOrders(orders);

            return ResponseEntity.ok(responseHappyPath);
        }

    }

}
