package edu.bank.entity;

import org.springframework.stereotype.Component;

@Component
public class User {

    private String accid;
    private String username;
    private String psw;
    private double deposit;


    public String getAccid() {
        return accid;
    }

    public void setAccid(String accid) {
        this.accid = accid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPsw() {
        return psw;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }
}
