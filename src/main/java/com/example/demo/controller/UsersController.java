package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;

import com.example.demo.entity.UserEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UsersController {
    private Map<Integer, UserEntity> users = new HashMap<>();

    @RequestMapping("/users")
    @ResponseBody
    public Map<Integer, UserEntity> index() {
        return users;
    }

    @RequestMapping("/users/{id}/get")
    @ResponseBody
    public UserEntity get(@PathVariable Integer id) {
        return users.get(id);
    }

    @RequestMapping("/users/{id}/remove")
    @ResponseBody
    public void remove(@PathVariable Integer id) {
        users.remove(id);

        return;
    }

    @RequestMapping("/users/add")
    @ResponseBody
    public int add(@RequestParam String name, @RequestParam Integer age) {
        int userId = users.size() + 1;

        users.put(userId, new UserEntity(name, age));

        return userId;
    }
}
