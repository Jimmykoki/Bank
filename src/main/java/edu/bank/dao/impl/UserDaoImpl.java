package edu.bank.dao.impl;

import edu.bank.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component("UserDao")
public class UserDaoImpl implements UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public boolean withDraw(String username, double money) {
        return false;
    }

    @Override
    public boolean deposit(String username, double money) {
        return false;
    }

    @Override
    public double checkDeposit(String username) {
        return 0;
    }

    @Override
    public boolean createAccount(String psw, String username) {
        return false;
    }

    @Override
    public boolean logIn(String username, String psw) {
        return false;
    }

    @Override
    public boolean userExist(String username) {
        return false;
    }
}
