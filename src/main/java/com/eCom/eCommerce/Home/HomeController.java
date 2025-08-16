package com.eCom.eCommerce.Home;

import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eCom.eCommerce.Home.Login.LoginRequest;
import com.eCom.eCommerce.Home.Login.LoginResponse;
import com.eCom.eCommerce.Home.SignUp.SignUpRequest;
import com.eCom.eCommerce.Home.SignUp.SignUpResponse;
import com.eCom.eCommerce.User.UserService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/ecom/v1/home")
public class HomeController {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private UserService userService;

    @GetMapping
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
        log.info("Home data is  : {}", homePageProducts);
        return ResponseEntity.ok(homePageProducts);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        log.info("Login request received for email: {}", loginRequest.getEmail());
        LoginResponse loginResponse = userService.loginUser(loginRequest);
        if(loginResponse.getStatus().equals("Success")) {
            log.info("Login successful for user: {}", loginRequest.getEmail());
            return ResponseEntity.ok(loginResponse);
        } else{
            log.error("Login failed for user: {}", loginRequest.getEmail());
            return ResponseEntity
                .status(401)
                .body(loginResponse);
        }
    }

    @PostMapping("/signUp")
    public ResponseEntity<SignUpResponse> signUp(@RequestBody SignUpRequest signUpRequest){
        log.info("Sign Up request received for email: {}", signUpRequest.getEmail());
        SignUpResponse signUpResponse = userService.signUpUser(signUpRequest);
        if(signUpResponse.getStatus().equals("Success")){
            log.info("Sign Up successful for user: {}", signUpRequest.getEmail());
            return ResponseEntity.ok(signUpResponse);
        }else{
            log.error("Sign up Failed for user : {}", signUpRequest.getEmail());
            return ResponseEntity.status(401).body(signUpResponse);
        }
    }

}
