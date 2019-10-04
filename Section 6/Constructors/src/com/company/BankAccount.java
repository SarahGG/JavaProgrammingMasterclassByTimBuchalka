package com.company;

public class BankAccount {
    private int accountNum;
    private double balance;
    private String name;
    private String email;
    private String phoneNum;

    public BankAccount(int accountNum, double balance, String name, String email, String phoneNum) {
        this.setAccountNum(accountNum);
        this.setBalance(balance);
        this.setName(name);
        this.setEmail(email);
        this.setPhoneNum(phoneNum);
    }

    public void depositFunds(int depositedFunds) {
        System.out.println("-----------------------");
        System.out.println("Previous Balance = " + this.getBalance());
        System.out.println("Depositing Funds = " + depositedFunds);
        this.setBalance(this.getBalance() + depositedFunds);
        System.out.println("New Balance = " + this.getBalance());
        System.out.println("-----------------------");
    }

    public void withdrawFunds(int withdrawnFunds) {
        System.out.println("-----------------------");
        System.out.println("Previous Balance = " + this.getBalance());
        if(withdrawnFunds <= this.getBalance()) {
            System.out.println("Withdrawn Funds = " + withdrawnFunds);
            this.setBalance(this.getBalance() - withdrawnFunds);
            System.out.println("New Balance = " + this.getBalance());
        } else {
            System.out.println("Funds Insufficient To Withdraw " + withdrawnFunds);
        }
        System.out.println("-----------------------");
    }

    public int getAccountNum() {
        return accountNum;
    }

    public void setAccountNum(int accountNum) {
        this.accountNum = accountNum;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
}
