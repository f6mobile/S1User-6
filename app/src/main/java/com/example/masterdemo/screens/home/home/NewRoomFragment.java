package com.example.masterdemo.screens.home.home;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.masterdemo.R;
import com.example.masterdemo.Storage;
import com.example.masterdemo.api.NetworkService;
import com.example.masterdemo.common.RoomsTypesRepo;
import com.example.masterdemo.databinding.FragmentNewRoomBinding;
import com.example.masterdemo.databinding.TypeHolderBinding;
import com.google.android.material.card.MaterialCardView;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.codec.digest.DigestUtils;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Header;

public class NewRoomFragment extends Fragment {

    FragmentNewRoomBinding binding;

    String selectedType = "";

    Storage storage = Storage.getInstance(getContext());



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentNewRoomBinding.inflate(inflater, container, false);


        binding.rvTypes.setLayoutManager(new GridLayoutManager(getContext(),3));
        binding.rvTypes.setAdapter(new RoomTypeAdapter());



        binding.save.setOnClickListener(view -> {
            NetworkService.getInstance().getApi()
                    .addRoom(binding.name.getText().toString(),
                            selectedType, storage.getToken(), storage.getUUID(),
                            DigestUtils.sha256Hex(storage.getToken() + storage.getUUID() + storage.getKeyDevice()))
                    .enqueue(new Callback<String>() {
                        @Override
                        public void onResponse(Call<String> call, Response<String> response) {

                            Toast.makeText(getContext(), "Комната Сохранена", Toast.LENGTH_SHORT).show();

                        }

                        @Override
                        public void onFailure(Call<String> call, Throwable t) {

                        }
                    });
        });

        return binding.getRoot();
    }

    private class RoomTypeAdapter extends RecyclerView.Adapter<RoomTypeAdapter.TypeHolder> {


        RoomsTypesRepo roomsTypesRepo = new RoomsTypesRepo();

        List<String> types = roomsTypesRepo.getTypes();
        List<TypeHolder> holders = new ArrayList<>();

        public RoomTypeAdapter() {

        }

        @NonNull
        @Override
        public TypeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            Context context = parent.getContext();
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            View view = layoutInflater.inflate(R.layout.type_holder, parent, false);
            TypeHolder holder = new TypeHolder(view);
            holders.add(holder);
            return holder;
        }

        @Override
        public void onBindViewHolder(@NonNull TypeHolder holder, int position) {

            holder.bind(position);

            holder._binding.getRoot().setOnClickListener(view -> {
                selectedType = types.get(position);
                for (TypeHolder typeHolder : holders) {
                    typeHolder._binding.card.setCardBackgroundColor(getResources().getColor(R.color.white));
                    typeHolder._binding.image.setColorFilter(getResources().getColor(R.color.green));
                }
                holder._binding.card.setCardBackgroundColor(getResources().getColor(R.color.green));
                holder._binding.image.setColorFilter(getResources().getColor(R.color.white));

            });

        }

        @Override
        public int getItemCount() {
            return types.size();
        }

        class TypeHolder extends RecyclerView.ViewHolder {

            TypeHolderBinding _binding;

            public TypeHolder(@NonNull View itemView) {
                super(itemView);
                _binding = TypeHolderBinding.bind(itemView);

            }


            public void bind(int position) {
                switch (position){
                    case 0:
                        _binding.roomName.setText(types.get(position));
                        _binding.image.setImageResource(R.drawable.ic_kitchen);
                        break;
                    case 1:
                        _binding.roomName.setText(types.get(position));
                        _binding.image.setImageResource(R.drawable.ic_bedroom);
                        break;
                    case 2:
                        _binding.roomName.setText(types.get(position));
                        _binding.image.setImageResource(R.drawable.ic_bathroom);
                        break;
                    case 3:
                        _binding.roomName.setText(types.get(position));
                        _binding.image.setImageResource(R.drawable.ic_office);
                        break;
                    case 4:
                        _binding.roomName.setText(types.get(position));
                        _binding.image.setImageResource(R.drawable.ic_tv_room);
                        break;
                    case 5:
                        _binding.roomName.setText(types.get(position));
                        _binding.image.setImageResource(R.drawable.ic_living_room);
                        break;
                    case 6:
                        _binding.roomName.setText(types.get(position));
                        _binding.image.setImageResource(R.drawable.ic_garage);
                        break;
                    case 7:
                        _binding.roomName.setText(types.get(position));
                        _binding.image.setImageResource(R.drawable.ic_toilet);
                        break;
                    case 8:
                        _binding.roomName.setText(types.get(position));
                        _binding.image.setImageResource(R.drawable.ic_kids_room);
                        break;
                }

            }
        }
    }
}