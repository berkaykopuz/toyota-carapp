package com.toyota.carapp.service.impl;

import com.toyota.carapp.dto.UserDto;
import com.toyota.carapp.model.Role;
import com.toyota.carapp.model.User;
import com.toyota.carapp.repository.UserRepository;
import com.toyota.carapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        List<UserDto> userDtos = new ArrayList<>();

        users.forEach(user -> {
            UserDto userDto = new UserDto();
            userDto.setId(user.getId());
            userDto.setUsername(user.getUsername());
            userDto.setPassword(user.getPassword());
            userDto.setRoles(user.getRoles().stream().map(Role::getRolename).collect(Collectors.toList()));

            userDtos.add(userDto);
        }
        );
    return userDtos;
    }


    @Override
    public UserDto getUserById(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(null);

        return mapToDto(user);

    }

    @Override
    public UserDto updateUser(UserDto userDto,Long userId) {
        User user = userRepository.findById(userId).orElseThrow(null);

        user.setUsername(userDto.getUsername());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));

        User updatedUser = userRepository.save(user);
        return mapToDto(updatedUser);
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    private UserDto mapToDto(User user){
        UserDto userDto = new UserDto();

        userDto.setId(user.getId());
        userDto.setUsername(user.getUsername());
        userDto.setPassword(user.getPassword());
        userDto.setRoles(user.getRoles().stream().map(Role::getRolename).collect(Collectors.toList()));


        return userDto;
    }
}
