package com.example.masterdemo.common;

public class UserLoginAnswer {
    private String token;

    public UserLoginAnswer() {
    }

    public UserLoginAnswer(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "UserLoginAnswer{" +
                "token=" + token +
                '}';
    }
}
