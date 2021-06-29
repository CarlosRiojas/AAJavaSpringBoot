package com.fundmaentosplatzi.springboot.fundamentos.service;

import com.fundmaentosplatzi.springboot.fundamentos.entity.User;
import com.fundmaentosplatzi.springboot.fundamentos.repository.UserRepository;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {
    private final Log LOG = LogFactory.getLog(UserService.class);
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public void saveTransactional(List<User> users){
        users.stream()
                .peek(user ->LOG.info("usuario insertado: "+user))
                        .forEach(userRepository::save);
                        //.forEach(user ->userRepository.save(user));
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User save(User newUserRegis) {
        return userRepository.save(newUserRegis);
    }

    public void delete(Long id) {
        userRepository.delete(new User(id));
    }

    public User update(User newUser, Long id) {
          return  userRepository.findById(id)
                .map(user -> {
                            user.setEmail(newUser.getEmail());
                            user.setBirthDate(newUser.getBirthDate());
                            user.setName(newUser.getName());
                             return userRepository.save(user);
                        }
                ).get();
    }

}
