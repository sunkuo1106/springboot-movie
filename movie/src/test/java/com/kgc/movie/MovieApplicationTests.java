package com.kgc.movie;

import com.kgc.movie.dao.MovieCommentMapper;
import com.kgc.movie.pojo.MovieComment;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@SpringBootTest
class MovieApplicationTests {

    @Resource
    MovieCommentMapper movieCommentMapper;

    @Test
    void contextLoads() {
//        List<MovieComment> movieComments = movieCommentMapper.selectByExample(null);
//        for (MovieComment movieComment : movieComments) {
//            System.out.println(movieComment);
//        }

        String movieSeats = "2_2,2_2,3_3,4_4,";
        int count = 0;
        int index = 0;
        String key=",";
        while ((index = movieSeats.indexOf(key, index)) != -1) {
            index = index + key.length();

            count++;
        }
        System.out.println(count);
    }

//    @Test
//    void subMonth() {
//        Calendar rightNow = Calendar.getInstance();
//        rightNow.setTime(new Date());
//        rightNow.add(Calendar.MONTH, 1);
//        Date endTime = rightNow.getTime();
//        System.out.println(endTime);
//    }

}
