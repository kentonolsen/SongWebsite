package com.capstone.songwebsite.songwebsite.services;


import com.capstone.songwebsite.songwebsite.dtos.UserDto;
import com.capstone.songwebsite.songwebsite.entites.User;
import com.capstone.songwebsite.songwebsite.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserRepository iUserRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public List<String> addUser(UserDto userDto) {
        List<String> response = new ArrayList<>();
        User user = new User(userDto);
        iUserRepository.saveAndFlush(user);
        response.add("http://localhost:8090/login.html");
        return response;
    }

    @Override
    public List<String> userLogin(UserDto userDto) {
        List<String> response = new ArrayList<>();
        Optional<User> userOptional = iUserRepository.findByUsername(userDto.getUsername());
        if (userOptional.isPresent()){
            if (passwordEncoder.matches(userDto.getPassword(), userOptional.get().getPassword())){
                response.add("http://localhost:8090/home.html");
                response.add(String.valueOf(userOptional.get().getId()));
            } else {
                response.add("Username or password is incorrect");
            }
        } else {
            response.add("Username or password is incorrect");
        }
        return response;
    }
}