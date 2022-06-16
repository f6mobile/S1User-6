package com.example.masterdemo.common;

public class UserAnswer {
    private boolean secure;

    public UserAnswer() {
    }

    public UserAnswer(boolean secure) {
        this.secure = secure;
    }

    public boolean isSecure() {
        return secure;
    }

    public void setSecure(boolean secure) {
        this.secure = secure;
    }

    @Override
    public String toString() {
        return "UserAnswer{" +
                "secure=" + secure +
                '}';
    }
}
