package com.kgc.movie.dao;

import com.kgc.movie.pojo.UserMember;
import com.kgc.movie.pojo.UserMemberExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMemberMapper {
    int countByExample(UserMemberExample example);

    int deleteByExample(UserMemberExample example);

    int deleteByPrimaryKey(Integer memberId);

    int insert(UserMember record);

    int insertSelective(UserMember record);

    List<UserMember> selectByExample(UserMemberExample example);

    UserMember selectByPrimaryKey(Integer memberId);

    int updateByExampleSelective(@Param("record") UserMember record, @Param("example") UserMemberExample example);

    int updateByExample(@Param("record") UserMember record, @Param("example") UserMemberExample example);

    int updateByPrimaryKeySelective(UserMember record);

    int updateByPrimaryKey(UserMember record);
}