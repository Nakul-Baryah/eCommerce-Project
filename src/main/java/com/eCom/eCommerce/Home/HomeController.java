package com.eCom.eCommerce.Home;

import java.io.InputStream;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/ecom/v1/home")
public class HomeController {
    private ObjectMapper objectMapper;
    @GetMapping("/")
    public ResponseEntity<HomePageProduct> showProductList() {
        HomePageProduct homePageProduct = null;
         InputStream inputStream = getClass().getClassLoader().getResourceAsStream("HomePageProduct.json");
         try{
            homePageProduct = objectMapper.readValue(inputStream, HomePageProduct.class);
         }catch(Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(null);
         }
        
        return ResponseEntity.ok(homePageProduct);
    }
    @GetMapping("/about")
    public String showAboutPage() {
        return "About Us: We are an e-commerce platform dedicated to providing the best online shopping experience.";
    }
}
