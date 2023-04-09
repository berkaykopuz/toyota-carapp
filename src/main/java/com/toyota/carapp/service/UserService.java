package com.toyota.carapp.service;


import com.toyota.carapp.dto.UserDto;

import java.util.List;


public interface UserService {
    List<UserDto> getAllUsers();

    UserDto getUserById(Long userId);
    UserDto updateUser(UserDto userDto,Long userId);

    void deleteUser(Long userId);
}
