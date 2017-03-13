package com.github.cockpit;

import com.github.cockpit.component.UsrFrComponent;
import com.github.cockpit.domain.Fr;
import com.github.cockpit.domain.Usr;
import com.github.cockpit.mapper.FrMapper;
import com.github.cockpit.mapper.UsrMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * ComponentMainTest
 * Create on 2017/3/13
 *
 * @author Asin Liu
 * @version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ComponentMain.class)
public class ComponentMainTest {
    @Resource
    UsrFrComponent component;

    @Resource
    UsrMapper usrMapper;
    @Resource
    FrMapper frMapper;

    @Test
    public void addNewTwoTest() throws Exception {
        component.addNewTwo();

        List<Usr> usrs =  usrMapper.listUsrByAccount("Asin");
        List<Fr> frs = frMapper.getFrByName("Ray");

        Assert.assertFalse(usrs == null);
        System.out.println(usrs.size());
        //Assert.assertTrue(usrs.size() == 0);

        Assert.assertFalse(frs == null);
        System.out.println(frs.size());
        Assert.assertTrue(frs.size() == 0);

    }


}
