package com.example.masterdemo.screens.home.stats;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.masterdemo.R;
import com.example.masterdemo.databinding.FragmentStaticsBinding;

public class StaticsFragment extends Fragment {

    FragmentStaticsBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentStaticsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
}