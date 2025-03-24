package com.example.vaultbank;

public class AccountBalanceModel {

    public static float getAmount() {
        return Amount;
    }

    public static void setAmount(float amount) {
        Amount = amount;
    }

    private static float Amount;
    public static float BonusCount;
}
