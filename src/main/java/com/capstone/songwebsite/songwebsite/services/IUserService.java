package com.capstone.songwebsite.songwebsite.services;

import com.capstone.songwebsite.songwebsite.dtos.UserDto;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IUserService {
    @Transactional
    List<String> addUser(UserDto userDto);

    List<String> userLogin(UserDto userDto);
}
