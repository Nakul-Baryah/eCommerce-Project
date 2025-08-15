package com.eCom.eCommerce.About;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/ecom/v1/about")
public class AboutController {
    @GetMapping
    public ResponseEntity<AboutResponse> showAboutPage() {
        log.info("Fetching about page");
        AboutResponse aboutResponse = new AboutResponse();
        aboutResponse.setDescription("At MN-SHOP, we believe shopping should be simple, joyful, and a little bit magical. What started as a small idea—curating quality products you’ll actually love—has grown into a trusted destination for smart shoppers across the country. We obsess over the details so you don’t have to: from carefully vetted suppliers and transparent pricing to fast shipping and easy returns, every step is designed to make your life easier.\n" + //
                        "\n" + //
                        "We’re builders at heart—constantly listening, learning, and improving. Our team uses customer feedback and real data to choose better products, streamline checkout, and keep your orders moving. Behind the scenes, we’re investing in modern tech to personalize your experience—so recommendations feel relevant, inventory stays accurate, and support is there the moment you need it. If it doesn’t make shopping better for you, we don’t ship it.\n" + //
                        "\n" + //
                        "Community is our compass. We partner with responsible brands, champion small businesses, and keep sustainability in focus—from mindful packaging to ethical sourcing. And we’re here when it counts: whether you’re upgrading your everyday essentials or discovering something delightfully new. Thanks for being part of our journey—let’s make your next great find happen today.");
        Map<String, String> contactInfo = new HashMap<>();
        contactInfo.put("mobile","8684020868");
        aboutResponse.setContactInfo(contactInfo);
        return ResponseEntity.ok(aboutResponse);
    }
}
