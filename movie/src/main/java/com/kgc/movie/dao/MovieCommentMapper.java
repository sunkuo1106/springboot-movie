package com.kgc.movie.dao;

import com.kgc.movie.pojo.MovieComment;
import com.kgc.movie.pojo.MovieCommentExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MovieCommentMapper {
    int countByExample(MovieCommentExample example);

    int deleteByExample(MovieCommentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MovieComment record);

    int insertSelective(MovieComment record);

    List<MovieComment> selectByExample(MovieCommentExample example);

    MovieComment selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MovieComment record, @Param("example") MovieCommentExample example);

    int updateByExample(@Param("record") MovieComment record, @Param("example") MovieCommentExample example);

    int updateByPrimaryKeySelective(MovieComment record);

    int updateByPrimaryKey(MovieComment record);
}