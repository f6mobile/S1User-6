package com.example.masterdemo.screens.home;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.masterdemo.R;
import com.example.masterdemo.databinding.FragmentMainHomeBinding;
import com.google.android.material.navigation.NavigationBarView;


public class MainHomeFragment extends Fragment {

    FragmentMainHomeBinding binding;
    NavController navController;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentMainHomeBinding.inflate(inflater, container, false);
//
//        navController = Navigation.findNavController(binding.getRoot());
//        NavigationUI.setupWithNavController(binding.nav, navController);


        return binding.getRoot();
    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        return NavigationUI.onNavDestinationSelected(item, navController)
//                || super.onOptionsItemSelected(item);
//    }

//    @Override
//    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
//        super.onCreateOptionsMenu(menu, inflater);
//        inflater.inflate(R.menu.home_menu, menu);
//    }
}