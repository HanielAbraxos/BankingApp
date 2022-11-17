package com.java.haniel;

import java.math.BigDecimal;

public class Customer {
    private String name;
    private String accountNumber;
    private BigDecimal accountBalance;

    public Customer(String name, String accountNumber, BigDecimal accountBalance) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.accountBalance = accountBalance;
    }

    public Customer (){
        this.name = null;
        this.accountBalance = null;
        this.accountNumber = null;
    }

    public String getName() {
        return name;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public BigDecimal getAccountBalance() {
        return accountBalance;
    }

    public static Customer createCustomer(String name, String accountNumber,BigDecimal accountBalance) {
        return new Customer(name, accountNumber, accountBalance);
    }

    public static Customer createBalance(String name, String accountNumber,BigDecimal accountBalance) {
        return new Customer(name, accountNumber, accountBalance);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setAccountBalance(BigDecimal accountBalance) {
        this.accountBalance = accountBalance;
    }

    @Override
    public String toString() {
        return name +"," + accountNumber + "," + accountBalance;
    }

}
