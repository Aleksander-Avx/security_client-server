package com.avx.clientserver.service;

import com.avx.clientserver.entity.UserEntity;

import java.util.List;

public interface UserService {

    List<UserEntity> findAll();
    void saveUser(UserEntity user);
}
