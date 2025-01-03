package com.example.aquafin.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.aquafin.Dto.UserDto;
import com.example.aquafin.models.User;
@Service
public interface UserService {
    User save(UserDto userDto);
    List<User> getUsersByRole(String role);
    List<User> getallUsers();
    boolean hasErrors();

}
