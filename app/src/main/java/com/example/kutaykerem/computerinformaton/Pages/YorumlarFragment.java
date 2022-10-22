package com.example.kutaykerem.computerinformaton.Pages;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kutaykerem.computerinformaton.Adaptor.Kesfet.YorumlarAdaptor;
import com.example.kutaykerem.computerinformaton.Models.GetDate;
import com.example.kutaykerem.computerinformaton.Models.YorumlarDetails;
import com.example.kutaykerem.computerinformaton.R;
import com.example.kutaykerem.computerinformaton.databinding.FragmentKullaniciProfileBinding;
import com.example.kutaykerem.computerinformaton.databinding.FragmentYorumlarBinding;
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


public class YorumlarFragment extends Fragment {

    private FragmentYorumlarBinding binding;


    FirebaseFirestore firebaseFirestore;
    FirebaseDatabase firebaseDatabase;
    FirebaseAuth firebaseAuth;
    String gonderiId, gonderenId;
    String yorum;
    int yorumKontrol;
    DatabaseReference databaseReference = null;
    ArrayList<YorumlarDetails> yorumlarDetailsArrayList;

    YorumlarAdaptor yorumlarAdaptor;

    TextView yorumEkle,yorumlar;
    String kullanıcıAdı, profile;
    String yrm;

    ImageButton gonder;
    LinearLayoutManager linearLayoutManager;
    RecyclerView recyclerView;


    public YorumlarFragment() {
       
    }

   

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentYorumlarBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



        AppCompatActivity appCompatActivity = (AppCompatActivity) view.getContext();
        appCompatActivity.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);


        recyclerView = view.findViewById(R.id.recyclerYorumlar);


        yorumlarDetailsArrayList = new ArrayList<>();

        yorumEkle = view.findViewById(R.id.yorumEkle);
        gonder = view.findViewById(R.id.yorumGonder);
        yorumlar = view.findViewById(R.id.yorumlar);
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();



        if(getArguments() != null){
            gonderiId = YorumlarFragmentArgs.fromBundle(getArguments()).getGonderiId();
            gonderenId = firebaseAuth.getUid();
        }



        gonder  = view.findViewById(R.id.yorumGonder);
        gonder.setBackground(null);


        linearLayoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        linearLayoutManager.setStackFromEnd(true);
        yorumlarAdaptor = new YorumlarAdaptor(yorumlarDetailsArrayList);
        recyclerView.setAdapter(yorumlarAdaptor);
        recyclerView.setLayoutManager(linearLayoutManager);




        firebaseDatabase = FirebaseDatabase.getInstance();

        databaseReference = firebaseDatabase.getReference().child("Profile");

        FirebaseUser user = firebaseAuth.getCurrentUser();

        DatabaseReference reference = databaseReference.child(user.getUid());

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
     if(snapshot != null){
    kullanıcıAdı = snapshot.child("kullanıcıAdı").getValue().toString();
      }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getActivity(), error.getMessage(), Toast.LENGTH_LONG).show();
            }
        });



        String yol = firebaseAuth.getUid().toString();
        firebaseFirestore.collection("Profiles").document("Resimler").collection(yol).addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {

                if (error != null) {
                    Toast.makeText(getActivity(), error.getLocalizedMessage(), Toast.LENGTH_LONG).show();
                }

                if (value != null) {

                    for (DocumentSnapshot snapshot : value.getDocuments()) {

                        Map<String, Object> data = snapshot.getData();

                        profile = (String) data.get("ImageProfile");


                    }


                }
            }


        });
        yorumEkle.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
               yrm = yorumEkle.getText().toString().trim();


            }
            @Override
            public void afterTextChanged(Editable editable) {
            }
        });


        getYorumlar();

        gonder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                yorumGonder(view);
            }
        });


        DilTanı(view);


    }


    public void DilTanı(View view){
        FirebaseUser user = firebaseAuth.getCurrentUser();
        String userId = user.getUid();

        FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
        firebaseFirestore.collection("KullanılanDiller").document(userId).collection("SecilenDil").orderBy("tarih",Query.Direction.DESCENDING).limit(1).addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
              if(value != null){
                  for (DocumentSnapshot documentSnapshot : value.getDocuments()) {
                      Map<String, Object> data = documentSnapshot.getData();
                      String dil = data.get("dil").toString();


                      if (dil.equals("türkce")) {
                          binding.yorumEkle.setHint("Yorum");
                          yorumlar.setText("Yorumlar");
                      } else if (dil.equals("ingilizce")) {
                          yorumlar.setText("Comments");
                          binding.yorumEkle.setHint("Comment");
                      }
                  }
              }


            };
        });
    }



    public void getYorumlar(){





        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Yorumlar").child(gonderiId).child("Gonderiler");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                yorumlarDetailsArrayList.clear();

                if(dataSnapshot != null){
                    for(DataSnapshot snapshot : dataSnapshot.getChildren()){

                        YorumlarDetails yorumlarDetails = snapshot.getValue(YorumlarDetails.class);
                        yorumlarDetailsArrayList.add(yorumlarDetails);


                    }
                    yorumlarAdaptor.notifyDataSetChanged();
                }




            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {



            }
        });




    }


    public void yorumGonder(View view) {

        yorum = yorumEkle.getText().toString();

        if(yorum.isEmpty()){

        }
        else if(!yrm.isEmpty()){
            UUID uuid = UUID.randomUUID();
            String YorumId = System.currentTimeMillis() + uuid.toString();

            HashMap<String, Object> data = new HashMap<>();
            data.put("gonderiId", gonderiId);
            data.put("gonderenId", gonderenId);
            data.put("kullanıcıAdı", kullanıcıAdı);
            data.put("profile", profile);
            data.put("yorum", yorum);
            data.put("yorumId",YorumId);
            data.put("tarih", GetDate.getDate());



            DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Yorumlar").child(gonderiId).child("Gonderiler");

            databaseReference.push().setValue(data);
            binding.yorumEkle.setText("");
        }







    }






    
    
}