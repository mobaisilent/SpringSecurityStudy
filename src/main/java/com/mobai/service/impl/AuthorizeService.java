package com.mobai.service.impl;

import com.mobai.entity.Account;
import com.mobai.mapper.UserMapper;
import jakarta.annotation.Resource;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthorizeService implements UserDetailsService {

  @Resource
  UserMapper mapper;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    System.out.println("here");
    Account account = mapper.findUserByName(username);
    System.out.println(account);
    if (account == null) {
      throw new UsernameNotFoundException("Username or Password Error");
    }
    return User
            .withUsername(username)
            .password(account.getPassword())
            .build();
  }
}