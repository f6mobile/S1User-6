package com.example.masterdemo;

import android.content.Context;
import android.content.SharedPreferences;
import android.provider.Settings;

import com.example.masterdemo.api.NetworkService;

import java.util.UUID;

public class Storage {
    private static Storage mInstance;
    private static final String PREF_UNIQUE_ID = "PREF_UNIQUE_ID";
    private final Context context;

    private static String UUID = null;
    private String keyDevice;
    private String token;

    public static Storage getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new Storage(context);
        }
        return mInstance;
    }

    private Storage(Context context) {
        this.context = context;
        if (UUID == null) {
            SharedPreferences sharedPrefs = context.getSharedPreferences(PREF_UNIQUE_ID, Context.MODE_PRIVATE);
            UUID = sharedPrefs.getString(PREF_UNIQUE_ID, null);
            if (UUID == null) {
                UUID = java.util.UUID.randomUUID().toString();
                SharedPreferences.Editor editor = sharedPrefs.edit();
                editor.putString(PREF_UNIQUE_ID, UUID);
                editor.commit();
            }
        }
    }

    public String getUUID() {
        return UUID;
    }

    public void setUUID(String UUID) {
        this.UUID = UUID;
    }

    public String getKeyDevice() {
        return keyDevice;
    }

    public void setKeyDevice(String keyDevice) {
        this.keyDevice = keyDevice;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
