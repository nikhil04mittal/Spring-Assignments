package com.ttn.repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Repository
public class UserRepo {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    User1Repo user1Repo;

    @Transactional(propagation = Propagation.REQUIRED)
    public void insert() {
        String sql = "INSERT INTO user (username,password,name,age,dob)VALUES(?,?,?,?,?)";
        System.out.println("No. of rows Added : " + jdbcTemplate
                .update(sql, "spring5", "spring5", "Harsh", 20,"1990-01-16"));
        user1Repo.insert();
    }

    @Transactional
    public void insert2() {
        insert();
    }

    @Transactional(timeout = 10)
    public void insert3() {
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        insert();
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = ArithmeticException.class)
    public void insert4() {
        insert();
        throw new ArithmeticException();
    }

    @Transactional(propagation = Propagation.REQUIRED, noRollbackFor = ArithmeticException.class)
    public void insert5() {
        insert();
        throw new ArithmeticException();
    }
}