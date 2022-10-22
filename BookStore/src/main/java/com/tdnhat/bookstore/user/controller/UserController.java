package com.tdnhat.bookstore.user.controller;

import com.tdnhat.bookstore.user.entity.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

//TODO: think about authen and security when save here
@Controller
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


}
