package com.kgc.movie.service.impl;

import com.kgc.movie.dao.UserMapper;
import com.kgc.movie.pojo.User;
import com.kgc.movie.pojo.UserExample;
import com.kgc.movie.service.UserLoginService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author shkstart
 * @create 2020-09-10 9:11
 */
@Service("userLoginService")
public class UserLoginServiceImpl implements UserLoginService {
    @Resource
    UserMapper userMapper;
    @Override
    public User selectLogin(String uName, String uPhone) {
        User user=null;
        UserExample userExample=new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        if(uName!=null&&uName.isEmpty()==false){
            criteria.andUnameEqualTo(uName);
        }else if(uPhone!=null&&uPhone.isEmpty()==false){
            criteria.andUphoneEqualTo(uPhone);
        }
        List<User> users = userMapper.selectByExample(userExample);
        if(users!=null&&users.size()>0){
            user=users.get(0);
        }
        return user;
    }

    @Override
    public int addUser(User user) {
        int i = userMapper.insertSelective(user);
        return i;
    }

    @Override
    public List<User> selectAll() {
        List<User> userList = userMapper.selectByExample(null);
        return userList;
    }
}
