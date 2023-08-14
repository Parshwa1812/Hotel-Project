package com.backend.services.interfaces;

import java.util.List;

import com.backend.dtos.UserDTO;
import com.backend.pojos.UserPOJO;

public interface IUserService {
    String addUser(UserPOJO user);
    List<UserDTO> allUsers();
    UserDTO userById(Long userId);
    
}
