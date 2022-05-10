package edu.bank.service;

public interface UserService {

    public boolean withdrawMoney(String username, double money);
    public boolean depositMoney(String username, double money);
    public double checkDeposit(String username);
    public boolean createAccount(String username,String psw);
    public boolean logIn(String username, String psw);
    public boolean userExist(String username);

}
