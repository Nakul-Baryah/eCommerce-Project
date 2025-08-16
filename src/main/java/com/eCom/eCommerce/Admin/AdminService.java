package com.eCom.eCommerce.Admin;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.eCom.eCommerce.Repository.UserRepository;
import com.eCom.eCommerce.User.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AdminService {
    @Autowired
    private UserRepository userRepository;
    public AdminDeleteResponse deleteUser(String email){
         Optional<User> user = userRepository.findByEmail(email);

        if(user.isPresent()){
            log.info("User found with email: {}", email);
            userRepository.delete(user.get());
            AdminDeleteResponse adminDeleteResponse = new AdminDeleteResponse("Success", "User deleted successfully");
            return adminDeleteResponse;
        }else{
            log.info("User does not exist with email: {}", email);
            return new AdminDeleteResponse("userNotFound", "User does not exist with this email");
        }
    }
}
