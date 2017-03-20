package com.github.cockpit;

import com.github.cockpit.mapper.FrMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * MapperMainTest
 * Create on 2017/3/14
 *
 * @author Asin Liu
 * @version 1.0
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MapperMain.class)
public class MapperMainTest {

    @Resource
    FrMapper frMapper;
    @Test
    public void queryUseCahceTest() {
        String name = "queryMybatisCache";
        frMapper.addNewFr(name);
        for (int i = 0; i < 10; i++) {
            frMapper.getFrByName(name);
        }
    }
}