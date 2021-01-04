package com.example.demo.Service;

import com.example.demo.domain.User;

public interface UserService {

     User saveOrUpdate(User user);

     User get(Long id);

     void delete(Long id);
}
