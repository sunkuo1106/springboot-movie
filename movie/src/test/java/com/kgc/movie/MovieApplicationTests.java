package com.kgc.movie;

import com.kgc.movie.dao.MovieCommentMapper;
import com.kgc.movie.pojo.MovieComment;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class MovieApplicationTests {

    @Resource
    MovieCommentMapper movieCommentMapper;

    @Test
    void contextLoads() {
        List<MovieComment> movieComments = movieCommentMapper.selectByExample(null);
        for (MovieComment movieComment : movieComments) {
            System.out.println(movieComment);
        }
    }

}
