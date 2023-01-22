package com.avx.clientserver.service;

import com.avx.clientserver.entity.UserEntity;
import com.avx.clientserver.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;


    public List<UserEntity> findAll() {
        return userRepository.findAll();
    }
    public void saveUser(UserEntity user) {
        userRepository.save(user);
    }

}
