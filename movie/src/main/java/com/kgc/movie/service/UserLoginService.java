package com.kgc.movie.service;

import com.kgc.movie.pojo.User;

import java.util.List;

/**
 * @author shkstart
 * @create 2020-09-10 9:08
 */
public interface UserLoginService {
    User selectLogin(String uName, String uPhone);
    int addUser(User user);
    List<User> selectAll();
    User selectById(Integer id);
}
