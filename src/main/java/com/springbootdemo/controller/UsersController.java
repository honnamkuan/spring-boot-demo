package com.springbootdemo.controller;

import com.springbootdemo.model.User;
import com.springbootdemo.repository.jpa.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class UsersController
{
    UsersRepository userRepo;

    @Autowired
    public UsersController(UsersRepository pUsersRepository)
    {
        userRepo = pUsersRepository;
    }

    @GetMapping("{id}")
    public User getById(@PathVariable("id") final int pId)
    {
        return userRepo.findById(pId);
    }

    @GetMapping
    public List<User> getAll()
    {
        return userRepo.findAll();
    }

    @PostMapping
    public void save(@RequestBody @Validated List<User> pUsers)
    {
        userRepo.save(pUsers);
    }
}