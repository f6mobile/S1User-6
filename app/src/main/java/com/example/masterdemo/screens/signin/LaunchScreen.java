package com.example.masterdemo.screens.signin;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.provider.Settings;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.masterdemo.BuildConfig;
import com.example.masterdemo.R;
import com.example.masterdemo.Storage;
import com.example.masterdemo.api.NetworkService;
import com.example.masterdemo.common.App;
import com.example.masterdemo.common.Device;
import com.example.masterdemo.common.KeyDevice;
import com.example.masterdemo.databinding.FragmentLaunchScreenBinding;
import com.google.android.material.snackbar.Snackbar;

import java.util.concurrent.Executors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LaunchScreen extends Fragment {

    FragmentLaunchScreenBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentLaunchScreenBinding.inflate(inflater, container, false);


        NetworkService.getInstance()
                .getApi()
                .registerApp(new App(BuildConfig.APPLICATION_ID, "Competitor-1"))
                        .enqueue(new Callback<String>() {
                            @Override
                            public void onResponse(Call<String> call, Response<String> response) {

                                if (response.code() == 201) {
                                    NetworkService
                                            .getInstance()
                                            .getApi()
                                            .registerDevice(new Device(Storage.getInstance(getContext()).getUUID(), BuildConfig.APPLICATION_ID, "Android Emulator API 28"))
                                            .enqueue(new Callback<KeyDevice>() {
                                                @Override
                                                public void onResponse(Call<KeyDevice> call, Response<KeyDevice> response) {
                                                    Storage.getInstance(getContext()).setKeyDevice(response.body().getKeyDevice());
                                                    String answer = response.body().toString();
                                                    Executors.newFixedThreadPool(1).execute(() -> {
                                                        getActivity().runOnUiThread
                                                                (() -> {
                                                                    Navigation.findNavController(getView()).navigate(R.id.action_launchScreen_to_logingFragment);
                                                                });
                                                    });
                                                }

                                                @Override
                                                public void onFailure(Call<KeyDevice> call, Throwable t) {

                                                }
                                            });
                                }

                            }

                            @Override
                            public void onFailure(Call<String> call, Throwable t) {
                                Log.e("APP_REG", t.toString());
                                Snackbar.make(binding.getRoot(), "Error register application", Snackbar.LENGTH_SHORT).show();
                            }
                        });
        return binding.getRoot();
    }
}