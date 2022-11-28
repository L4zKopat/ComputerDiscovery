package com.example.kutaykerem.computerinformaton.Pages;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.example.kutaykerem.computerinformaton.R;


public class SohbetlerbackgroundChooseFragment extends Fragment {

    ImageView background,background1,background2,background3,background4,background5,background6,background7,background8;
    Button Buttonbackground,Buttonbackground1,Buttonbackground2,Buttonbackground3,Buttonbackground4,Buttonbackground5,Buttonbackground6,Buttonbackground7,Buttonbackground8,ButtonGüncelle;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sohbetlerbackground_choose, container, false);

    }


    @SuppressLint("ResourceType")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        Buttonbackground = view.findViewById(R.id.background);
        Buttonbackground1 = view.findViewById(R.id.background1);
        Buttonbackground2 = view.findViewById(R.id.background2);
        Buttonbackground3 = view.findViewById(R.id.background3);
        Buttonbackground4 = view.findViewById(R.id.background4);
        Buttonbackground5 = view.findViewById(R.id.background5);
        Buttonbackground6 = view.findViewById(R.id.background6);
        Buttonbackground7 = view.findViewById(R.id.background7);
        Buttonbackground8 = view.findViewById(R.id.background8);

        background = view.findViewById(R.drawable.background);
        background1 = view.findViewById(R.drawable.background1);
        background2 = view.findViewById(R.drawable.background2);
        background4 = view.findViewById(R.drawable.background4);
        background5 = view.findViewById(R.drawable.background5);
        background6 = view.findViewById(R.drawable.background6);
        background7 = view.findViewById(R.drawable.background7);
        background8 = view.findViewById(R.drawable.background8);
        ButtonGüncelle = view.findViewById(R.id.guncelle);





        Buttonbackground.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                ButtonGüncelle.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                      /*
                        Intent intent = new Intent(getActivity().getApplicationContext(), ArkadaslarListesi.class);
                        intent.putExtra("background","backgroundd");
                        getActivity().startActivity(intent);
*/
                    }
                });



            }
        });


        Buttonbackground1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ButtonGüncelle.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                      /*
                        Intent intent = new Intent(getActivity().getApplicationContext(), ArkadaslarListesi.class);
                        intent.putExtra("background","background1");
                        getActivity().startActivity(intent);
*/
                    }
                });

            }
        });


        Buttonbackground2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ButtonGüncelle.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                    /*
                        Intent intent = new Intent(getActivity().getApplicationContext(), ArkadaslarListesi.class);
                        intent.putExtra("background","background2");
                        getActivity().startActivity(intent);
*/
                    }
                });
            }
        });



        Buttonbackground4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ButtonGüncelle.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                      /*
                        Intent intent = new Intent(getActivity().getApplicationContext(), ArkadaslarListesi.class);
                        intent.putExtra("background","background4");
                        getActivity().startActivity(intent);
*/
                    }
                });

            }
        });

        Buttonbackground5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ButtonGüncelle.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                       /*
                        Intent intent = new Intent(getActivity().getApplicationContext(), ArkadaslarListesi.class);
                        intent.putExtra("background","background5");
                        getActivity().startActivity(intent);
*/
                    }
                });

            }
        });

        Buttonbackground6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ButtonGüncelle.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                 /*
                       Intent intent = new Intent(getActivity().getApplicationContext(), ArkadaslarListesi.class);
                        intent.putExtra("background","background6");
                        getActivity().startActivity(intent);
*/
                    }
                });

            }
        });

        Buttonbackground7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ButtonGüncelle.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                      /*  Intent intent = new Intent(getActivity().getApplicationContext(), ArkadaslarListesi.class);
                        intent.putExtra("background","background7");
                        getActivity().startActivity(intent);
*/
                    }
                });

            }
        });

        Buttonbackground8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ButtonGüncelle.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                    /*    Intent intent = new Intent(getActivity().getApplicationContext(), ArkadaslarListesi.class);
                        intent.putExtra("background","background8");
                        getActivity().startActivity(intent);
*/
                    }
                });

            }
        });

    }





}