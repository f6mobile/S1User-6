package com.example.masterdemo.screens.home.home;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.masterdemo.R;
import com.example.masterdemo.Storage;
import com.example.masterdemo.api.NetworkService;
import com.example.masterdemo.common.GetAllRoomsResponse;
import com.example.masterdemo.databinding.FragmentHomeBinding;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.codec.digest.DigestUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {

    FragmentHomeBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);

        Storage storage = Storage.getInstance(getContext());

        binding.newRoom.setOnClickListener(view -> {
            Navigation.findNavController(getView()).navigate(R.id.action_homeFragment_to_newRoomFragment);
        });


        binding.rvRooms.setLayoutManager(new GridLayoutManager(getContext(),2));
        NetworkService
                .getInstance()
                .getApi()
                .getAllRooms(storage.getToken(), storage.getUUID(), DigestUtils.sha256Hex(storage.getToken() + storage.getUUID() + storage.getKeyDevice()))
                .enqueue(new Callback<GetAllRoomsResponse>() {
                    @Override
                    public void onResponse(Call<GetAllRoomsResponse> call, Response<GetAllRoomsResponse> response) {
                        binding.rvRooms.setAdapter(new RoomsAdapter(response.body().getItems(), getContext()));
                    }

                    @Override
                    public void onFailure(Call<GetAllRoomsResponse> call, Throwable t) {

                    }
                });


        return binding.getRoot();
    }
}