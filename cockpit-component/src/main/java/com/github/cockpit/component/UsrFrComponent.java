package com.github.cockpit.component;

import com.github.cockpit.mapper.FrMapper;
import com.github.cockpit.mapper.UsrMapper;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

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


    @Resource
    DataSourceTransactionManager txManager ;


    /**
     * @Transaction  has no efforts.
     *
     * Why??
     */

    @Transactional
    public void addNewTwoWithAnnotation() {
        try {
            usrMapper.addNew("Asin", "01200365", "pxuuxTest");
            divByZero(1, 0);
            frMapper.addNewFr("Ray");

            System.out.println("addNewTwo runs without exception.");

        } catch (Exception e) {
            System.out.println("Is exception a RuntimeException: " + (e instanceof RuntimeException));
            System.out.println("Caught exception :" + e.toString());
        }
    }


    /**
     * This method is OK.
     */
    public void addNewTwo() {
        try {
            DefaultTransactionDefinition def = new DefaultTransactionDefinition();
            def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);

            TransactionStatus status = txManager.getTransaction(def);
            try {
                usrMapper.addNew("Asin", "01200365", "uuuuu");
                divByZero(1, 0);
                frMapper.addNewFr("Ray");
            }
            catch (Exception ex) {
                txManager.rollback(status);
                throw ex;
            }
            txManager.commit(status);
            System.out.println("addNewTwo executed without exception.");

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
