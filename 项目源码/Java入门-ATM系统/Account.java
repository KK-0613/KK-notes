package com.kk.atm;

/**
 * @ClassName Account
 * @Description //TODO
 * @Author kk
 * @Date 2022/9/1 16:33
 * @Version 1.0
 **/
public class Account {
    private String cardId; //卡号
    private String name; //姓名
    private String password; //密码
    private double balance = 0; //余额
    private double cashWithdrawalAmount;//取现额度

    public Account() {
    }

    public Account(String cardId, String name, String password,  double cashWithdrawalAmount) {
        this.cardId = cardId;
        this.name = name;
        this.password = password;
        this.cashWithdrawalAmount = cashWithdrawalAmount;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance += balance;
    }

    public double getCashWithdrawalAmount() {
        return cashWithdrawalAmount;
    }

    public void setCashWithdrawalAmount(double cashWithdrawalAmount) {
        this.cashWithdrawalAmount = cashWithdrawalAmount;
    }
}