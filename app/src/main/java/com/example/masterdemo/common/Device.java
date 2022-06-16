package com.example.masterdemo.common;

public class Device {
    private String uuid;
    private String appId;
    private String device;

    public Device() {
    }

    public Device(String uuid, String appId, String device) {
        this.uuid = uuid;
        this.appId = appId;
        this.device = device;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    @Override
    public String toString() {
        return "Device{" +
                "uuid='" + uuid + '\'' +
                ", appId='" + appId + '\'' +
                ", device='" + device + '\'' +
                '}';
    }
}
