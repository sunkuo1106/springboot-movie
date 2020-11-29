package com.kgc.movie.service.impl;


import com.kgc.movie.dao.UserMemberMapper;
import com.kgc.movie.pojo.UserMember;
import com.kgc.movie.service.UserMemberService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class UserMemberServiceImpl implements UserMemberService {

    @Resource
    UserMemberMapper userMemberMapper;

    @Override
    public List<UserMember> selectAllMember() {
        return userMemberMapper.selectByExample(null);
    }

    @Override
    public void addMember(UserMember userMember) {
        userMemberMapper.insertSelective(userMember);
    }

    @Override
    public void updateMember(UserMember userMember) {
        userMemberMapper.updateByPrimaryKeySelective(userMember);
    }
}
