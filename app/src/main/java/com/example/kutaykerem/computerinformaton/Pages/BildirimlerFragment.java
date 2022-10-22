package com.example.kutaykerem.computerinformaton.Pages;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kutaykerem.computerinformaton.Adaptor.Arkadaslar.BildirimlerAdaptor;
import com.example.kutaykerem.computerinformaton.R;
import com.example.kutaykerem.computerinformaton.databinding.FragmentBildirimlerBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class BildirimlerFragment extends Fragment {


    private FragmentBildirimlerBinding binding;
    FirebaseAuth firebaseAuth;
    String userId;
    DatabaseReference databaseReference;

    BildirimlerAdaptor bildirimlerAdaptor;
    RecyclerView recyclerView;
    int kontrol = 0;
    List<String> isteklerList;




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       binding = FragmentBildirimlerBinding.inflate(inflater,container,false);
       return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        firebaseAuth = FirebaseAuth.getInstance();
        isteklerList = new ArrayList<>();

        userId = firebaseAuth.getUid();
        databaseReference = FirebaseDatabase.getInstance().getReference("Arkadasİstekleri");

        recyclerView = view.findViewById(R.id.recyclerBildirimler);




        istekler();

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        bildirimlerAdaptor = new BildirimlerAdaptor(isteklerList);
        recyclerView.setAdapter(bildirimlerAdaptor);

        DilTanı(view);

    }
    public void DilTanı(View view){

        FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
        firebaseFirestore.collection("KullanılanDiller").document(userId).collection("SecilenDil").orderBy("tarih", Query.Direction.DESCENDING).limit(1).addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
               if(value != null){
                   for(DocumentSnapshot documentSnapshot : value.getDocuments()){
                       Map<String, Object> data = documentSnapshot.getData();
                       String dil = data.get("dil").toString();


                       if(dil.equals("türkce")){
                           binding.bildirimler.setText("Bildirimler");
                       }else if (dil.equals("ingilizce")){
                           binding.bildirimler.setText("Notifications");}

                   }
               }


            }
        });



    }


    private void istekler() {



        databaseReference.child(userId).addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

                if(snapshot != null){
                    String arkistekKontrol = snapshot.child("tip").getValue().toString();
                    if(arkistekKontrol.equals("aldi")){
                        isteklerList.add(snapshot.getKey());
                        kontrol = 1;
                        bildirimlerAdaptor.notifyDataSetChanged();
                    }
                }





            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {
                isteklerList.remove(snapshot.getKey());
                bildirimlerAdaptor.notifyDataSetChanged();
                kontrol=1;
            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



    }



}