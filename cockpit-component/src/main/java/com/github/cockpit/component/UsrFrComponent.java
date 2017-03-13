package com.github.cockpit.component;

import com.github.cockpit.mapper.FrMapper;
import com.github.cockpit.mapper.UsrMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * UsrFrComponent
 * Create on 2017/3/9
 *
 * @author Asin Liu
 * @version 1.0
 */
@Component
public class UsrFrComponent {
    @Resource
    private UsrMapper usrMapper;
    @Resource
    private FrMapper frMapper;

    @Transactional(rollbackFor = Exception.class)
    public void addNewTwo() {
        try {
            usrMapper.addNew("Asin", "xxxx01200365", "pxuuxTest");
            divByZero(1, 0);
            frMapper.addNewFr("Ray");

            System.out.println("addNewTwo runs without exception.");

        } catch (Exception e) {
            System.out.println("Caught exception :" + e.toString());
        }
    }

    private int divByZero(int x, int y) {
        try {
            return x / y;
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}
