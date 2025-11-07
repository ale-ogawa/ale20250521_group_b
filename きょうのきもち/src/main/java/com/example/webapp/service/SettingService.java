package com.example.webapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.webapp.entity.User;
import com.example.webapp.repository.UserMapper;

@Service
public class SettingService {

    @Autowired
    private UserMapper userMapper;

    public List<User> getUserSet(Integer id) {
        return userMapper.getUserSet(id);
    }

//    public List<Disease> getAllDiseases() {
//        return userMapper.getAllDiseases();
//    }
//
//    public void updateUser(Setting setting) {
//        userMapper.updateUser(setting);
//    }
}