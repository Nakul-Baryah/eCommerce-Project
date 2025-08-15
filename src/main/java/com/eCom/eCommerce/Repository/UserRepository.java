package com.eCom.eCommerce.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eCom.eCommerce.User.User;
@Repository
public interface UserRepository extends JpaRepository<User, String> {

    static Optional <User> findByEmail(String email) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByEmail'");
    }
} 