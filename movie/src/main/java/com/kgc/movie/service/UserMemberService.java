package com.kgc.movie.service;

import com.kgc.movie.pojo.UserMember;

import java.util.List;

public interface UserMemberService {
    List<UserMember>selectAllMember();
    void addMember(UserMember userMember);
    void updateMember(UserMember userMember);
}
