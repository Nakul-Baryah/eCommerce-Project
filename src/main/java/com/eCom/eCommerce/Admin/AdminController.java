package com.eCom.eCommerce.Admin;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eCom.eCommerce.Repository.UserRepository;
import com.eCom.eCommerce.User.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/ecom/v1/admin")
public class AdminController {

   
    @Autowired
    private AdminService adminService;
    @PostMapping("/deleteUser")
    public ResponseEntity<AdminDeleteResponse> deleteUser(@RequestParam String email) {
        log.info("Deleteing user with email : {}", email);
        AdminDeleteResponse adminDeleteResponse = adminService.deleteUser(email);
        if(adminDeleteResponse.getStatus().equals("Success")) {
            log.info("User deleted successfully with email: {}", email);
            return ResponseEntity.ok(adminDeleteResponse);
        } else {
            log.info("User deletion failed for email: {}", email);
            return ResponseEntity.status(404).body(adminDeleteResponse);
        }
    }
    
}
