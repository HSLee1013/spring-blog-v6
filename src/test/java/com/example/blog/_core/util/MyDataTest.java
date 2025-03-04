package com.example.blog._core.util;

import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyDataTest {

    @Test
    public void formatToStr() {
        // given
        Timestamp createdAt = new Timestamp(System.currentTimeMillis());

        // when
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
        String formattedDate = sdf.format(createdAt);

        // eye(then)
        System.out.println(formattedDate);
    }
}
