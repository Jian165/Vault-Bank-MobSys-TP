package com.example.vaultbank;

public class TransactionModel {

    String transactionType;
    String transactionTime;
    String transactionDate;

    public String getTransactionAmount() {
        return transactionAmount;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public String getTransactionTime() {
        return transactionTime;
    }

    public String getTransactionType() {
        return transactionType;
    }

    String transactionAmount;
    public TransactionModel(String transactionType, String transactionTime, String transactionDate, String transactionAmount) {
        this.transactionType = transactionType;
        this.transactionTime = transactionTime;
        this.transactionDate = transactionDate;
        this.transactionAmount = transactionAmount;
    }

}
