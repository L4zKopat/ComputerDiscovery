package com.example.kutaykerem.computerinformaton.Pages;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.kutaykerem.computerinformaton.R;


public class ImageToScreenFragment extends Fragment {


    ImageView fotograf;
    String url;

    public ImageToScreenFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_image_to_screen, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        fotograf = view.findViewById(R.id.ımageToScreen);


        if(getArguments() != null){
            url = getArguments().getString("image").toString();
            Glide.with(getActivity()).load(url).into(fotograf);

        }

        fotograf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fotograf.setVisibility(View.GONE);
            }
        });



    }
}