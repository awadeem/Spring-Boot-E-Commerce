package com.shopme.admin.user;

import com.shopme.common.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired //let spring framework inject an instance, an implementation of the UserRepository at runtime.
    private UserRepository userRepository;

    public List<User> listAll(){
        return (List<User>) userRepository.findAll();
    }
}
