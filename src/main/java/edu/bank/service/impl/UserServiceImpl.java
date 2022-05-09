package edu.bank.service.impl;


import edu.bank.dao.UserDao;
import edu.bank.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Component("UserService")
public class UserServiceImpl implements UserService {


    @Autowired
    private UserDao userDao;


    @Transactional(isolation = Isolation.READ_COMMITTED)
    public boolean withdrawMoney(String username, double money) {
        return userDao.withDraw(username,money);
    }


    @Transactional(isolation = Isolation.READ_COMMITTED)
    public boolean depositMoney(String username, double money) {
        return userDao.deposit(username, money);
    }

    @Transactional(isolation = Isolation.READ_COMMITTED)
    public double checkDeposit(String username) {
        return userDao.checkDeposit(username);
    }

    @Transactional(isolation = Isolation.READ_COMMITTED)
    public boolean createAccount(String username,String psw) {
        return userDao.createAccount(username,psw);
    }

    @Transactional(isolation = Isolation.READ_COMMITTED)
    public boolean logIn(String username, String psw) {
        return userDao.logIn(username, psw);
    }

    @Transactional(isolation = Isolation.READ_COMMITTED)
    public boolean userExist(String username) {
        return userDao.userExist(username);
    }


}
