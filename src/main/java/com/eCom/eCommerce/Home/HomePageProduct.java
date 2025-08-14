package com.eCom.eCommerce.Home;

import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HomePageProduct {
    private String productId;
    private String productName;
    private Double price;
    private String  description;
    private List<String> sizes;
    private Map<String,String> images;
}
