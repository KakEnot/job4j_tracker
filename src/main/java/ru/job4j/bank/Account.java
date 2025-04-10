package ru.job4j.bank;

import java.util.Objects;

public class Account {
    /**
     * Actual account requisite
     */
    private String requisite;
    /**
     * Actual account balance
     */
    private double balance;

    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * Returns the requisite of the account
     *
     * @return requisite
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     * Sets the requisite of the account.
     *
     * @param requisite the new requisite to set
     */
    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     * Returns the current balance of the account.
     *
     * @return the account's balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Sets the balance of the account.
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}