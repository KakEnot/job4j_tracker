package ru.job4j.bank;

import java.util.Objects;

public class User {
    /**
     * The passport number of the user.
     */
    private String passport;

    /**
     * The name of the user.
     */
    private String username;

    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     * Returns the passport number of the user.
     *
     * @return the passport number
     */
    public String getPassport() {
        return passport;
    }

    /**
     * Sets the passport number of the user.
     *
     * @param passport the new passport number to set
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * Returns the username of the user.
     *
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username of the user
     *
     * @param username the new username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}