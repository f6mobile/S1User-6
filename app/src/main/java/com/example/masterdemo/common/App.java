package com.example.masterdemo.common;

public class App {

    private String appId;
    private String competitor;

    public App() {
    }

    public App(String appId, String competitor) {
        this.appId = appId;
        this.competitor = competitor;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getCompetitor() {
        return competitor;
    }

    public void setCompetitor(String competitor) {
        this.competitor = competitor;
    }

    @Override
    public String toString() {
        return "App{" +
                "appId='" + appId + '\'' +
                ", competitor='" + competitor + '\'' +
                '}';
    }
}
