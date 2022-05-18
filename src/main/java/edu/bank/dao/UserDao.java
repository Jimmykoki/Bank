package edu.bank.dao;

public interface UserDao {

    public boolean withdraw(String username, double money );
    public boolean deposit(String username, double money);
    public double checkDeposit(String username);
    public boolean createAccount(String psw,String username, double amount);
    public boolean logIn(String username, String psw);
    public boolean userExist(String username);
}
