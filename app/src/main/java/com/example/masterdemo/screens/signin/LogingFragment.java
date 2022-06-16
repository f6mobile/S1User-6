package com.example.masterdemo.screens.signin;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.masterdemo.R;
import com.example.masterdemo.Storage;
import com.example.masterdemo.api.NetworkService;
import com.example.masterdemo.common.User;
import com.example.masterdemo.common.UserLoginAnswer;
import com.example.masterdemo.databinding.FragmentLogingBinding;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.codec.digest.DigestUtils;

import org.apache.commons.validator.routines.EmailValidator;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LogingFragment extends Fragment {

    FragmentLogingBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentLogingBinding.inflate(inflater,container, false);

        binding.btnLogin.setOnClickListener(view -> {
            String login = binding.etLogin.getText().toString();
            String password = binding.etPassword.getText().toString();

            if (login.equals("") || password.equals("")) {
                Snackbar.make(view,"Поля не дожны быть пустыми",Snackbar.LENGTH_SHORT).show();
            }
            else {
                if (EmailValidator.getInstance().isValid(login)) {

                    Log.i("LOGIN", login + " " + password + " " + Storage.getInstance(getContext()).getUUID() + "  " + DigestUtils.sha256Hex(login + password + Storage.getInstance(getContext()).getKeyDevice()).toString());
                    NetworkService
                            .getInstance()
                            .getApi()
                            .loginUser(login, password, Storage.getInstance(getContext()).getUUID(), DigestUtils.sha256Hex(login + password + Storage.getInstance(getContext()).getKeyDevice()).toString())
                            .enqueue(new Callback<UserLoginAnswer>() {
                                @Override
                                public void onResponse(Call<UserLoginAnswer> call, Response<UserLoginAnswer> response) {
                                    Log.i("LOGIN", String.valueOf(response.code()));
                                    if (response.code() == 201) {
                                        Storage.getInstance(getContext()).setToken(response.body().getToken());
                                        Navigation.findNavController(view).navigate(R.id.action_logingFragment_to_mainHomeFragment);
                                    }
                                    else {
                                        Snackbar.make(view, "Неверный email или пароль", Snackbar.LENGTH_SHORT).show();
                                    }
                                }

                                @Override
                                public void onFailure(Call<UserLoginAnswer> call, Throwable t) {
                                    Toast.makeText(getContext(), "ERRROR", Toast.LENGTH_SHORT).show();
                                }
                            });

                }
                else {
                    Snackbar.make(binding.getRoot(), "Неверный формат почты", Snackbar.LENGTH_SHORT).show();
                }
            }
        });

        binding.btnReg.setOnClickListener(view -> Navigation.findNavController(view).navigate(R.id.action_logingFragment_to_signinFragment));

        return binding.getRoot();
    }
}