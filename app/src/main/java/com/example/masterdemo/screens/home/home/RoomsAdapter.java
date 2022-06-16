package com.example.masterdemo.screens.home.home;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.masterdemo.R;
import com.example.masterdemo.common.Items;
import com.example.masterdemo.databinding.RoomHolderBinding;

import java.util.List;

public class RoomsAdapter extends RecyclerView.Adapter<RoomsAdapter.RoomHolder> {

    List<Items> items;
    Context context;

    public RoomsAdapter(List<Items> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @NonNull
    @Override
    public RoomHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.room_holder, parent, false);
        return new RoomHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RoomHolder holder, int position) {

        holder.bind(items.get(position));

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class RoomHolder extends RecyclerView.ViewHolder {

        RoomHolderBinding binding;

        public RoomHolder(@NonNull View itemView) {
            super(itemView);
            binding = RoomHolderBinding.bind(itemView);
        }

        public void bind(Items items) {
            binding.roomName.setText(items.getName());
        }
    }
}
