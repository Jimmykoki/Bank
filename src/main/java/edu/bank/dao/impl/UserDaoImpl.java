package edu.bank.dao.impl;

import edu.bank.dao.UserDao;
import edu.bank.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import static org.apache.commons.lang3.Validate.notNull;

import java.util.List;

@Component("UserDao")
public class UserDaoImpl implements UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public boolean withdraw(String username, double money) {

        notNull(username);
        notNull(money);
        if(!userExist(username)){
            System.out.println("User doesn't exist");
            return false;
        }
        double deposit= checkDeposit(username);
        System.out.println("deposit is "+deposit);
        if(deposit-money<0||money<0){
            System.out.println("operation fail!");
            return false;
        }
        jdbcTemplate.update("update account set deposit=? where username=?", deposit-money, username);
        System.out.println("Withdraw "+money+"successful");
        return true;
    }

    @Override
    public boolean deposit(String username, double money) {
        notNull(username);
        notNull(money);
        if(!userExist(username)){
            System.out.println("User doesn't exist");
            return false;
        }
        if(money<0){
            System.out.println("Please enter the valid money");
            return false;
        }
        User user = jdbcTemplate.queryForObject("Select deposit from account where username=?", new BeanPropertyRowMapper<User>(User.class), username);
        double deposit = user.getDeposit();
        jdbcTemplate.update("update account set deposit=? where username=?", money+deposit, username);
        System.out.println("Deposit "+money+"successful");
        return true;
    }

    @Override
    public double checkDeposit(String username) {
        notNull(username);
        if(!userExist(username)){
            System.out.println("User doesn't exist");
            return 0;
        }
        User user=jdbcTemplate.queryForObject("Select deposit from account where username=?", new BeanPropertyRowMapper<User>(User.class), username);
        System.out.println("invoke success");
        return user.getDeposit();
    }

    @Override
    public boolean createAccount(String username, String psw, double deposit) {
        notNull(username);
        notNull(psw);
        notNull(deposit);
        if(!userExist(username)){
            jdbcTemplate.update("INSERT INTO account (username,psw,deposit) values(?,?,?)", username,psw,deposit);
            System.out.println("Create success");
            return true;
        }
        return false;
    }
    @Override
    public boolean logIn(String username, String psw) {
        notNull(username);
        notNull(psw);
        List<User> users = jdbcTemplate.query("Select * from account where username='" + username + "' and psw='" + psw + "'", new BeanPropertyRowMapper<User>(User.class));
        if(users.size()==0){
            System.out.println("User not found, please check your psw or username");
            return false;
        }
        else{
            System.out.println("login success");
            return true;
        }
    }

    @Override
    public boolean userExist(String username) {
        notNull(username);
        List<User> users = jdbcTemplate.query("Select username from account where username=?", new BeanPropertyRowMapper<User>(User.class), username);
        if(users.size()==0){
            return false;
        }
        System.out.println("User exist! ");
        return true;
    }
}
