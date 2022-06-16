package com.example.masterdemo.common;

public class User {
    private String email;
    private String name;
    private String password;
    private String uuid;
    private String hash;

    public User(String email, String name, String password, String uuid) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.uuid = uuid;
    }

    public User(String email, String password, String uuid) {
        this.email = email;
        this.password = password;
        this.uuid = uuid;
    }

    public User(String email, String name, String password, String uuid, String hash) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.uuid = uuid;
        this.hash = hash;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
