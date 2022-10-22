package com.example.kutaykerem.computerinformaton.Pages;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.se.omapi.SEService;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kutaykerem.computerinformaton.Models.GetDate;
import com.example.kutaykerem.computerinformaton.Models.GetDateDetail;
import com.example.kutaykerem.computerinformaton.Models.KullanıcıBilgileri;
import com.example.kutaykerem.computerinformaton.Sign.UserLogin;
import com.example.kutaykerem.computerinformaton.databinding.ActivityAnaSayfaBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import java.security.Key;
import java.util.HashMap;
import java.util.Map;

public class AnaSayfa extends AppCompatActivity {


    private BottomNavigationView bottomNavigationView;


    HashMap<String, Object> data;
    DatabaseReference databaseReference,onlineKontrolReference;
    FirebaseFirestore firebaseFirestore;
    FirebaseAuth firebaseAuth;
    String userId;



    public ActivityAnaSayfaBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAnaSayfaBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);


        databaseReference = FirebaseDatabase.getInstance().getReference().child("Profile");
        onlineKontrolReference = FirebaseDatabase.getInstance().getReference();
        firebaseFirestore = FirebaseFirestore.getInstance();
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        userId = user.getUid();



        networkController();

    }

    public void OnlineOflineDurum(Boolean durum) {


        DatabaseReference reference = databaseReference.child(userId);

        if(reference != null){



            reference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {

                    if (snapshot.getValue() != null) {

                        KullanıcıBilgileri kullanıcıBilgileri = snapshot.getValue(KullanıcıBilgileri.class);
                        String kulllaniciAdi = kullanıcıBilgileri.getKullanıcıAdı();
                        data = new HashMap<>();
                        data.put("durum", durum);
                        data.put("kullanıcıAdı",kulllaniciAdi);
                        if(durum == false){
                            data.put("songörülme",GetDateDetail.getDate());
                        }


                        onlineKontrolReference.child("Durum").child(userId).child("State").setValue(data);
                        onlineKontrolReference.child("Durum").child(userId).child("State").updateChildren(data);


                    }

                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });

        }

    }



    @Override
    protected void onResume() {
        super.onResume();
        OnlineOflineDurum(true);
        networkController();

    }

    @Override
    protected void onStop() {
        super.onStop();
        OnlineOflineDurum(false);

    }

    @Override
    protected void onPause() {
        super.onPause();
        OnlineOflineDurum(false);
    }
    public boolean isConnected() {

        boolean connected = false;
        try {
            ConnectivityManager cm = (ConnectivityManager)getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo nInfo = cm.getActiveNetworkInfo();
            connected = nInfo != null && nInfo.isAvailable() && nInfo.isConnected();
            return connected;
        } catch (Exception e) {
            Log.e("Connectivity Exception", e.getMessage());
        }
        return connected;
    }


    public void networkController()  {

        ConnectivityManager cm = (ConnectivityManager)getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo nInfo = cm.getActiveNetworkInfo();
        boolean connected = nInfo != null && nInfo.isAvailable() && nInfo.isConnected();

        if (isConnected()) {

        } else {


            FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
            firebaseFirestore.collection("KullanılanDiller").document(userId).collection("SecilenDil").orderBy("tarih", Query.Direction.DESCENDING).limit(1).addSnapshotListener(new EventListener<QuerySnapshot>() {
                @Override
                public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {

                    if(value != null ){

                        for(DocumentSnapshot documentSnapshot : value.getDocuments()){
                            Map<String, Object> data = documentSnapshot.getData();
                            String dil = data.get("dil").toString();

                            if(dil.equals("türkce")){
                                Toast.makeText(getApplicationContext(),"İnternet bağlantınızı kontrol edin",Toast.LENGTH_SHORT).show();

                            }else if (dil.equals("ingilizce")){
                                Toast.makeText(getApplicationContext(),"Check your internet connection",Toast.LENGTH_SHORT).show();

                                };

                            }

                        }

                    }

                });


        }















        }















    }

















