package com.avx.clientserver.security.details;

import com.avx.clientserver.entity.UserEntity;
import com.avx.clientserver.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component(value = "customUserDetailsService")
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByEmail(email);

        if (user != null) {
            return new UserDetailsImpl(user);
        } else throw new UsernameNotFoundException("User not found");

    }
}
