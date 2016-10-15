package com.springbootdemo.controller;

import com.springbootdemo.model.User;
import com.springbootdemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class HomeController
{
    @Autowired
    UserRepository userRepo;

    @GetMapping("/{id}")
    public User getById(@PathVariable("id") final int pId)
    {
        return userRepo.findById(pId);
    }
}