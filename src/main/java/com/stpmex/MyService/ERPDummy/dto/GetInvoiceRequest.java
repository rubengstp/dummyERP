package com.stpmex.MyService.ERPDummy.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.ToString;

@ToString
public class GetInvoiceRequest {
    @JsonProperty("XML_INFO")
    @NotBlank
    private String xml_info;

    public String getTagFromXML(String tag) {
         String xmlInfo = xml_info.trim();
            int startIndex = xmlInfo.indexOf("<" + tag + ">") + tag.length() + 2;
            int endIndex = xmlInfo.indexOf("</" + tag + ">", startIndex);

            if (startIndex != -1 && endIndex != -1) {
                return xmlInfo.substring(startIndex, endIndex);
            }
            return null;

    }
}
