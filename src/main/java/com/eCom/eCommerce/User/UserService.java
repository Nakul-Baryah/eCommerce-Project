package com.eCom.eCommerce.User;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eCom.eCommerce.Home.Login.LoginRequest;
import com.eCom.eCommerce.Home.Login.LoginResponse;
import com.eCom.eCommerce.Repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    
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
}
