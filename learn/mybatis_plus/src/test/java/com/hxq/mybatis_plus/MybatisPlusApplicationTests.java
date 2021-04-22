package com.hxq.mybatis_plus;

import com.hxq.mybatis_plus.mapper.mymapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MybatisPlusApplicationTests {
    @Autowired
   private mymapper mymapper;

    @Test
    void contextLoads() {
        mymapper.deleteById(2);
        mymapper.selectList(null).forEach(System.out::println);


    }

}
