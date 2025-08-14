package com.eCom.eCommerce.Home;

import java.io.InputStream;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/ecom/v1/home")
public class HomeController {
    private ObjectMapper objectMapper = new ObjectMapper();
    @GetMapping("/")
    public ResponseEntity<List<HomePageProduct>> showProductList() {
        log.info("Fetching home page product list");
        List<HomePageProduct> homePageProducts = null;
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("HomePageProduct.json");
        try{
            log.info("Mapping home product JSON to HomePageProduct object");
            homePageProducts = objectMapper.readValue(
                inputStream,
                new TypeReference<List<HomePageProduct>>() {}
            );
        }catch(Exception e) {
            log.info("Error while mapping JSON to HomePageProduct object");
            e.printStackTrace();
            return ResponseEntity.status(500).body(null);
        }
        return ResponseEntity.ok(homePageProducts);
    }
    @GetMapping("/about")
    public String showAboutPage() {
        return "About Us: We are an e-commerce platform dedicated to providing the best online shopping experience.";
    }
}
