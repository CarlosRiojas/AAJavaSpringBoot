package com.fundmaentosplatzi.springboot.fundamentos.CaseUse;

import com.fundmaentosplatzi.springboot.fundamentos.entity.User;
import com.fundmaentosplatzi.springboot.fundamentos.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class CreateUser {
    private UserService userService;

    public CreateUser(UserService userService){
        this.userService = userService;
    }

    public User save(User newUserRegis) {
      return  userService.save(newUserRegis);
    }
}
