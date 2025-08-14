package com.eCom.eCommerce.Home;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ecom/v1/home")
public class HomeController {
    @GetMapping("/")
    public String showProductList() {
        return "Welcome to the E-Commerce Home Page!";
    }
    @GetMapping("/about")
    public String showAboutPage() {
        return "About Us: We are an e-commerce platform dedicated to providing the best online shopping experience.";
    }
}
