package com.fundmaentosplatzi.springboot.fundamentos.CaseUse;

import com.fundmaentosplatzi.springboot.fundamentos.entity.User;
import com.fundmaentosplatzi.springboot.fundamentos.service.UserService;

import java.util.List;

public class GetUserImplement implements GetUser{
    private UserService userService;

    public GetUserImplement(UserService userService) {
        this.userService = userService;
    }

    @Override
    public List<User> getAll() {
        return userService.getAllUsers();
    }
}
