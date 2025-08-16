package com.eCom.eCommerce.User;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.eCom.eCommerce.Home.Login.LoginRequest;
import com.eCom.eCommerce.Home.Login.LoginResponse;
import com.eCom.eCommerce.Home.SignUp.SignUpRequest;
import com.eCom.eCommerce.Home.SignUp.SignUpResponse;
import com.eCom.eCommerce.Repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    
    public LoginResponse loginUser(LoginRequest loginRequest){
        Optional<User> optionalUser = userRepository.findByEmail(loginRequest.getEmail());
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            if (user.getPassword().equals(loginRequest.getPassword())) {
                return new LoginResponse("success", "Login successful");
            }else{
                return new LoginResponse("passwordFailure", "Invalid email or password");
            }
        } else {
            return new LoginResponse("userFailure", "User does not exist");
        }
    }

    public SignUpResponse signUpUser(SignUpRequest signUpRequest){
        Optional<User> optionalUser = userRepository.findByEmail(signUpRequest.getEmail());
        optionalUser =  userRepository.findByMobile(signUpRequest.getMobile());
        if (optionalUser.isPresent()) {
            return new SignUpResponse("userExists", "User already exists with this email or mobile  number");
        } else {
            User newUser = new User();
            String encodedPassword = passwordEncoder.encode(signUpRequest.getPassword());
            newUser.setEmail(signUpRequest.getEmail());
            newUser.setPassword(encodedPassword);
            newUser.setUserName(signUpRequest.getUserName());
            newUser.setMobile(signUpRequest.getMobile());
            userRepository.save(newUser);
            return new SignUpResponse("Success", "Sign up successful");
        }
    }
}
