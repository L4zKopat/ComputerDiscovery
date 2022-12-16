package com.example.kutaykerem.computerinformaton.Parts;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kutaykerem.computerinformaton.Adaptor.PcDetails.AdaptorPcDetails;
import com.example.kutaykerem.computerinformaton.Models.PcDetails;
import com.example.kutaykerem.computerinformaton.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Map;


public class BelleklerFragment extends Fragment {

    ArrayList<PcDetails> pcDetailsArrayList;


    AdaptorPcDetails adaptorPcDetails;
    RecyclerView recyclerView;
    private Toolbar toolbar;
    private androidx.appcompat.widget.SearchView searchView;



    public BelleklerFragment() {

    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_bellekler, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        pcDetailsArrayList = new ArrayList<>();
        recyclerView = view.findViewById(R.id.recyclerViewRamlar);

        toolbar = view.findViewById(R.id.toolbar_Ramlar);
        ((AppCompatActivity) (getActivity())).setSupportActionBar(toolbar);
        ((AppCompatActivity) (getActivity())).getSupportActionBar().setDisplayShowTitleEnabled(false);






        PcDetails pcDetails5 = new PcDetails("Ramlar","SKILL 8GB (1x8GB) RipjawsV DDR4 3200Mhz CL16 1.35V ");
        PcDetails pcDetails6 = new PcDetails("Ramlar","GSKILL 8GB (1x8GB) RipjawsV  DDR4 3000MHz CL16 1.35V");
        PcDetails pcDetails7 = new PcDetails("Ramlar","GSKILL 16GB (1x16) RipjawsV  DDR4 3200Mhz CL16 1.35V ");
        PcDetails pcDetails4 = new PcDetails("Ramlar","GSKILL 8GB (1x8GB) RipjawsV  DDR4 3600MHz CL18 1.35V");
        PcDetails pcDetails9 = new PcDetails("Ramlar","GSKILL 16GB (1x16GB) RipjawsV Red DDR4 3000MHz CL16 1.35V");
        PcDetails pcDetails8 = new PcDetails("Ramlar","GSKILL 8GB Value DDR3 1600MHz CL11");
        PcDetails pcDetails3 = new PcDetails("Ramlar","Crucial 8GB (1x8GB) Ballistix  DDR4 3000MHz CL15 1.35V RGB PC ");
        PcDetails pcDetails2 = new PcDetails("Ramlar","Kingston 8GB (1x8GB) Fury Renegade  DDR4 3600MHz CL16");
        PcDetails pcDetails10 = new PcDetails("Ramlar","GSKILL 4GB Value DDR3 1333MHz CL9 PC3 ");
        PcDetails pcDetails12 = new PcDetails("Ramlar","Crucial 16GB (1x16GB) Ballistix  DDR4 2666MHz CL16 1.2V");
        PcDetails pcDetails11 = new PcDetails("Ramlar","Kingston 8GB (1x8GB) DDR4 3200MHz CL22");
        PcDetails pcDetails14 = new PcDetails("Ramlar","Crucial 8GB (1x8GB) Ballistix DDR4 3200MHz CL16 1.35V RGB");
        PcDetails pcDetails21 = new PcDetails("Ramlar","Crucial 8GB (1x8GB) DDR5 4800MHz CL40 1.1V");
        PcDetails pcDetails19 = new PcDetails("Ramlar","CORSAIR 8GB Vengeance RGB RS 3200mhz CL16 DDR4");
        PcDetails pcDetails17 = new PcDetails("Ramlar","CORSAIR 16GB Vengeance RGB RS 3200mhz CL16 DDR4");
        PcDetails pcDetails20 = new PcDetails("Ramlar","Kingston 16GB (1x16GB) Fury Beast RGB DDR4 3200MHz CL16");
        PcDetails pcDetails16 = new PcDetails("Ramlar","Kingston 16GB (1x16GB) Fury Beast  DDR4 3200MHz CL16 PC");
        PcDetails pcDetails24 = new PcDetails("Ramlar","Kıngston 8GB (1x8GB) Fury Beast RGB DDR4 3600MHz CL17");
        PcDetails pcDetails = new PcDetails("Ramlar","Kıngston 8GB (1x8GB) Fury Beast RGB DDR4 3200MHz CL16 PC");
        PcDetails pcDetails22 = new PcDetails("Ramlar","Kingston 32GB (1x32GB) DDR4 3200MHz CL22");
        PcDetails pcDetails29 = new PcDetails("Ramlar","Kingston 32GB (1x32GB) DDR4 2666MHz CL19");
        PcDetails pcDetails18 = new PcDetails("Ramlar","Kingston 16GB (1x16GB) DDR4 3200MHz CL22");
        PcDetails pcDetails27 = new PcDetails("Ramlar","Kingston 16GB (1x16GB) DDR4 2666MHz CL19");
        PcDetails pcDetails28 = new PcDetails("Ramlar","Crucial 16GB (1x16GB) DDR5 4800MHz CL40 1.1V");
        PcDetails pcDetails30 = new PcDetails("Ramlar","Crucial 8GB (1x8GB) Ballistix DDR4 3000MHz CL15 1.35V RGB");
        PcDetails pcDetails23 = new PcDetails("Ramlar","Kingston 32GB (1x32GB) Fury Beast DDR4 3600MHz CL17 P");
        PcDetails pcDetails32 = new PcDetails("Ramlar","GSKILL 16GB (1x16GB) Aegis DDR4 2666Mhz CL19 1.2V");
        PcDetails pcDetails15 = new PcDetails("Ramlar","Crucial 16GB (1x16GB) DDR4 3200MHz CL22 1.2V");
        PcDetails pcDetails25 = new PcDetails("Ramlar","Crucial 8GB (1x8GB) Ballistix  DDR4 3200MHz CL16 RGB");
        PcDetails pcDetails33 = new PcDetails("Ramlar","Kingston 8GB (1x8GB) Fruy Beast DDR4 3200MHz CL16 PC");
        PcDetails pcDetails35 = new PcDetails("Ramlar","Kingston 8GB (1x8GB) Fury Beast DDR4 3600MHz CL17");
        PcDetails pcDetails34 = new PcDetails("Ramlar","Kingston 8GB (1x8GB) DDR4 2666MHz CL19");
        PcDetails pcDetails26 = new PcDetails("Ramlar","CORSAIR 8GB (1x8GB) Vengeance LPX  DDR4 3200MHz CL16");
        PcDetails pcDetails31 = new PcDetails("Ramlar","CORSAIR 16GB (1x16GB) Vengeance LPX  DDR4");
        PcDetails pcDetails39 = new PcDetails("Ramlar","CORSAIR 8GB (1x8GB) Vengeance RGB PRO  DDR4 3600MHz CL18 Single ");
        PcDetails pcDetails36 = new PcDetails("Ramlar","CORSAIR 8GB (1x8GB) Vengeance RGB PRO  DDR4 3200MHz");
        PcDetails pcDetails43 = new PcDetails("Ramlar","CORSAIR 8GB (1x8GB) Vengeance LPX  DDR4 3600MHz CL18");
        PcDetails pcDetails40 = new PcDetails("Ramlar","CORSAIR 32GB (1x32GB) Vengeance LPX DDR4");
        PcDetails pcDetails41 = new PcDetails("Ramlar","CORSAIR 16GB (1x16) Vengeance  DDR4 3200Mhz CL16");
        PcDetails pcDetails37 = new PcDetails("Ramlar","CORSAIR 8GB Vengeance  DDR4 3200Mhz CL16 Single ");
        PcDetails pcDetails45 = new PcDetails("Ramlar","CORSAIR 8GB (1x8GB) Vengeance  DDR4 3000MHz CL16");
        PcDetails pcDetails44 = new PcDetails("Ramlar","CORSAIR 8GB Vengeance DDR4 2666MHz CL16");
        PcDetails pcDetails42 = new PcDetails("Ramlar","GSKILL 4GB Value DDR3 1600MHz CL11");
        PcDetails pcDetails38 = new PcDetails("Ramlar","GSKILL 4GB Value DDR3 1600MHz CL11");


        pcDetailsArrayList.add(pcDetails36);
        pcDetailsArrayList.add(pcDetails37);
        pcDetailsArrayList.add(pcDetails38);
        pcDetailsArrayList.add(pcDetails39);
        pcDetailsArrayList.add(pcDetails40);
        pcDetailsArrayList.add(pcDetails41);
        pcDetailsArrayList.add(pcDetails42);
        pcDetailsArrayList.add(pcDetails43);
        pcDetailsArrayList.add(pcDetails44);
        pcDetailsArrayList.add(pcDetails45);
        pcDetailsArrayList.add(pcDetails);
        pcDetailsArrayList.add(pcDetails2);
        pcDetailsArrayList.add(pcDetails3);
        pcDetailsArrayList.add(pcDetails4);
        pcDetailsArrayList.add(pcDetails5);
        pcDetailsArrayList.add(pcDetails6);
        pcDetailsArrayList.add(pcDetails7);
        pcDetailsArrayList.add(pcDetails8);
        pcDetailsArrayList.add(pcDetails9);
        pcDetailsArrayList.add(pcDetails10);
        pcDetailsArrayList.add(pcDetails11);
        pcDetailsArrayList.add(pcDetails12);
        pcDetailsArrayList.add(pcDetails14);
        pcDetailsArrayList.add(pcDetails15);
        pcDetailsArrayList.add(pcDetails16);
        pcDetailsArrayList.add(pcDetails17);
        pcDetailsArrayList.add(pcDetails18);
        pcDetailsArrayList.add(pcDetails19);
        pcDetailsArrayList.add(pcDetails20);
        pcDetailsArrayList.add(pcDetails21);
        pcDetailsArrayList.add(pcDetails22);
        pcDetailsArrayList.add(pcDetails23);
        pcDetailsArrayList.add(pcDetails24);
        pcDetailsArrayList.add(pcDetails25);
        pcDetailsArrayList.add(pcDetails26);
        pcDetailsArrayList.add(pcDetails27);
        pcDetailsArrayList.add(pcDetails28);
        pcDetailsArrayList.add(pcDetails29);
        pcDetailsArrayList.add(pcDetails30);
        pcDetailsArrayList.add(pcDetails31);
        pcDetailsArrayList.add(pcDetails32);
        pcDetailsArrayList.add(pcDetails33);
        pcDetailsArrayList.add(pcDetails34);
        pcDetailsArrayList.add(pcDetails35);











                            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                            adaptorPcDetails = new AdaptorPcDetails(pcDetailsArrayList);
                            recyclerView.setAdapter(adaptorPcDetails);

                            adaptorPcDetails.notifyDataSetChanged();












        DilTanı(view);


    }
    public void DilTanı(View view){

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String userId = user.getUid();

        FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
        firebaseFirestore.collection("KullanılanDiller").document(userId).collection("SecilenDil").orderBy("tarih", Query.Direction.DESCENDING).limit(1).addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {

             if(value != null){
                 for (DocumentSnapshot documentSnapshot : value.getDocuments()) {
                     Map<String, Object> data = documentSnapshot.getData();
                     String dil = data.get("dil").toString();

                     if (dil.equals("türkce")) {
                         searchView = view.findViewById(R.id.searchView_ramlar);
                         searchView.setQueryHint("Arama");
                         searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                             @Override
                             public boolean onQueryTextSubmit(String query) {
                                 return false;
                             }

                             @Override
                             public boolean onQueryTextChange(String newText) {
                                 filter(newText);
                                 return true;
                             }
                         });

                     } else if (dil.equals("ingilizce")) {
                         searchView = view.findViewById(R.id.searchView_ramlar);
                         searchView.setQueryHint("Search");
                         searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                             @Override
                             public boolean onQueryTextSubmit(String query) {
                                 return false;
                             }

                             @Override
                             public boolean onQueryTextChange(String newText) {
                                 filter(newText);
                                 return true;
                             }
                         });


                     }
                 }
             }


            };
        });
    }

    private void filter(String newText) {
        ArrayList<PcDetails> newDetails = new ArrayList<>();

        for(PcDetails pcDetails : pcDetailsArrayList){
            if(pcDetails.getDetailsName().toLowerCase().contains(newText.toLowerCase())){
                newDetails.add(pcDetails);
            }

        }
        adaptorPcDetails.setPcDetailsArrayList(newDetails);
        adaptorPcDetails.notifyDataSetChanged();


    }
}