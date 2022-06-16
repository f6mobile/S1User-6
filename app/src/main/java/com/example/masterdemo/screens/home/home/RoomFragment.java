package com.example.masterdemo.screens.home.home;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.masterdemo.R;
import com.example.masterdemo.databinding.FragmentRoomBinding;


public class RoomFragment extends Fragment {

    FragmentRoomBinding binding;

    public static final String ARG_PARAM1 = "id";

    // TODO: Rename and change types of parameters
    private String id;

    public RoomFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static RoomFragment newInstance(String id) {
        RoomFragment fragment = new RoomFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, id);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            id = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentRoomBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
}