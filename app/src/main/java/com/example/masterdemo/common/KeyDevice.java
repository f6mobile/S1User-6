package com.example.masterdemo.common;

public class KeyDevice {

    private String keyDevice;

    public KeyDevice() {
    }

    public KeyDevice(String keyDevice) {
        this.keyDevice = keyDevice;
    }

    public String getKeyDevice() {
        return keyDevice;
    }

    public void setKeyDevice(String keyDevice) {
        this.keyDevice = keyDevice;
    }

    @Override
    public String toString() {
        return "KeyDevice{" +
                "keyDevice='" + keyDevice + '\'' +
                '}';
    }
}
