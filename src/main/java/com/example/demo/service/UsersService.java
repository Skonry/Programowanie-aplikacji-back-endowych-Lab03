package com.example.demo.service;

import com.example.demo.entity.UserEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsersService {

    private List<UserEntity> users = new ArrayList<>();

    public List<UserEntity> index(int pageNumber, int pageSize) {
        if (pageNumber < 1) {
            return users;
        }

        if (pageSize < 0 || pageSize > 100) {
            return  users;
        }

        int from = (pageNumber - 1) * pageSize;

        int to = from + pageSize;

        users.subList(from, to);
    }

    public UserEntity create(UserEntity user) {
    }

    public UserEntity show(int id) {
    }

    public UserEntity update(UserEntity user) {
    }

    public UserEntity remove(int id) {
    }

    private void onCreate() {

    }

    private void onDestroy() {

    }
}
