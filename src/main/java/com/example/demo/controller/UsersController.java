package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import com.example.demo.entity.UserEntity;
import com.example.demo.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UsersController {

    @Autowired
    private UsersService usersService;

    @RequestMapping("api/users")
    @ResponseBody
    public List<UserEntity> index(
        @RequestParam(name = "page-number", required = false) int pageNumber,
        @RequestParam(name = "page-number", required = false) int pageSize
    ) {
        return usersService.index(pageNumber, pageSize);
    }

    @RequestMapping(
        value = "api/users/create",
        method = RequestMethod.POST,
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public UserEntity create(@RequestBody UserEntity user) {
        return usersService.create(user);
    }

    @RequestMapping("api/users/{id}")
    public UserEntity show(@PathVariable int id) {
        return usersService.show(id);
    }

    @RequestMapping(
        value = "api/users/{id}/update",
        method = RequestMethod.POST,
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public UserEntity update(@RequestBody UserEntity user) {
        return usersService.update(user);
    }

    @RequestMapping("api/users/{id}/remove")
    public UserEntity remove(@PathVariable int id) {
        return usersService.remove(id);
    }
}
