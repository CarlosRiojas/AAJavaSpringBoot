package com.fundmaentosplatzi.springboot.fundamentos.configuration;

import com.fundmaentosplatzi.springboot.fundamentos.CaseUse.GetUser;
import com.fundmaentosplatzi.springboot.fundamentos.CaseUse.GetUserImplement;
import com.fundmaentosplatzi.springboot.fundamentos.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CaseUseConfiguration {

    @Bean
    GetUser getUser(UserService userService) {
        return new GetUserImplement(userService);
    }

}
