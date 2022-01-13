package com.example.ui.model;

import java.util.Objects;

public class User {
    private final String userId;
    private final String firstName;
    private final String lastName;
    private final String email;

    public User(String userId, String firstName, String lastName, String email) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getUserId() {
        return this.userId;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getEmail() {
        return this.email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final User that = (User) o;
        return Objects.equals(this.userId, that.userId)
                && Objects.equals(this.firstName, that.firstName)
                && Objects.equals(this.lastName, that.lastName)
                && Objects.equals(this.email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.userId, this.firstName, this.lastName, this.email);
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + this.userId + '\'' +
                ", firstName='" + this.firstName + '\'' +
                ", lastName='" + this.lastName + '\'' +
                ", email='" + this.email + '\'' +
                '}';
    }
}
