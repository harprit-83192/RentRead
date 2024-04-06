package com.example.RentRead.Services;

import com.example.RentRead.Entities.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public interface UserService extends UserDetailsService {

    User registerUser(User user);

}
