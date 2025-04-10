package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    /**
     * HashMap of current existing users with accounts
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Add new user if it doesn't exist
     *
     * @param user - Existing user
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * Delete user by passport number if it exists
     *
     * @param passport - passport number of an existing user
     */
    public void deleteUser(String passport) {
        User user = findByPassport(passport);
        if (user != null) {
            users.remove(user);
        }
    }

    /**
     * Add a new account to an existing user
     *
     * @param passport - passport number of an existing user
     * @param account  - new non-existent account
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null && !users.get(user).contains(account)) {
            users.get(user).add(account);
        }
    }

    /**
     * Search for user by passport number
     *
     * @param passport - passport number of an existing user
     * @return user if it exists, or null
     */
    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                return user;
            }
        }
        return null;
    }

    /**
     * Search for user account by requisite
     *
     * @param passport  - passport number of an existing user
     * @param requisite - requisite of an existing account
     * @return Account if it exists, or null
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> userAcc = users.get(user);
            for (Account account : userAcc) {
                if (account.getRequisite().equals(requisite)) {
                    return account;
                }
            }
        }
        return null;
    }

    /**
     * Transferring money from a source account to a destination account
     *
     * @param sourcePassport       - passport number of an existing source user
     * @param sourceRequisite      -  requisite of an existing account of the source user
     * @param destinationPassport  -  passport number of an existing destination user
     * @param destinationRequisite - requisite of an existing account of the destination user
     * @param amount               - double amount for transaction
     * @return true in success case, or false otherwise
     */
    public boolean transferMoney(String sourcePassport, String sourceRequisite,
                                 String destinationPassport, String destinationRequisite,
                                 double amount) {
        boolean result = false;
        Account sourceAccount = findByRequisite(sourcePassport, sourceRequisite);
        Account destinationAccount = findByRequisite(destinationPassport, destinationRequisite);
        if (sourceAccount != null && sourceAccount.getBalance() >= amount && destinationAccount != null) {
            double sourceBalance = sourceAccount.getBalance();
            double destinationBalance = destinationAccount.getBalance();
            sourceAccount.setBalance(sourceBalance - amount);
            destinationAccount.setBalance(destinationBalance + amount);
            result = true;
        }
        return result;
    }

    /**
     * Returns the list of accounts associated with the specified user.
     *
     * @param user - whose accounts are to be become
     * @return - list of accounts belonging to user, or null
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}