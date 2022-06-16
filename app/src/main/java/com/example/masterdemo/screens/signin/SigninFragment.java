package com.example.masterdemo.screens.signin;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.masterdemo.R;
import com.example.masterdemo.Storage;
import com.example.masterdemo.api.NetworkService;
import com.example.masterdemo.common.User;
import com.example.masterdemo.common.UserAnswer;
import com.example.masterdemo.databinding.FragmentSigninBinding;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.codec.digest.DigestUtils;

import org.apache.commons.validator.routines.EmailValidator;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SigninFragment extends Fragment {

    FragmentSigninBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentSigninBinding.inflate(inflater, container, false);

        binding.btnReg.setOnClickListener(view -> {

            String login = binding.etLogin.getText().toString();
            String name = binding.etName.getText().toString();
            String password = binding.etPassword.getText().toString();
            if (EmailValidator.getInstance().isValid(login)) {
                if (name.equals("") || password.equals("")){
                    Snackbar.make(view,"Поля не дожны быть пустыми",Snackbar.LENGTH_SHORT).show();
                }
                else {
                    Storage storage = Storage.getInstance(getContext());
                    NetworkService.getInstance()
                            .getApi()
                            .regUser(login, name, password, Storage.getInstance(getContext()).getUUID() ,DigestUtils.sha256Hex(storage.getUUID() + storage.getKeyDevice()).toString())
                            .enqueue(new Callback<UserAnswer>() {
                                @Override
                                public void onResponse(Call<UserAnswer> call, Response<UserAnswer> response) {
                                    Navigation.findNavController(view).navigate(R.id.action_signinFragment_to_logingFragment);
                                }

                                @Override
                                public void onFailure(Call<UserAnswer> call, Throwable t) {

                                }
                            });
                }
            } else {
                Snackbar.make(binding.getRoot(), "Неверный формат почты", Snackbar.LENGTH_SHORT).show();
            }

        });

        binding.btnLogin.setOnClickListener(view -> {
            Navigation.findNavController(view).navigate(R.id.action_signinFragment_to_logingFragment);
        });

        return binding.getRoot();
    }
}