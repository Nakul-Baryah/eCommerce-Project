package com.eCom.eCommerce.About;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AboutResponse {
    private String description;
    private Map<String,String> contactInfo;
}
