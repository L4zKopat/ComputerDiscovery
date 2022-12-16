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


public class IslemcilerFragment extends Fragment {

    ArrayList<PcDetails> pcDetailsArrayList;


    AdaptorPcDetails adaptorPcDetails;
    RecyclerView recyclerView;
    private Toolbar toolbar;
    private androidx.appcompat.widget.SearchView searchView;




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_islemciler, container, false);



    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        pcDetailsArrayList = new ArrayList<>();
        recyclerView = view.findViewById(R.id.recyclerViewİslemciler);
        toolbar = view.findViewById(R.id.toolbar_İslemciler);
        ((AppCompatActivity) (getActivity())).setSupportActionBar(toolbar);
        ((AppCompatActivity) (getActivity())).getSupportActionBar().setDisplayShowTitleEnabled(false);





                            PcDetails pcDetails96 = new PcDetails("İşlemciler","Intel Core i3 12100F socket 1700 12.generation 3.30GHz 12MB 10nm");
                            PcDetails pcDetails97 = new PcDetails("İşlemciler","Intel Core i5 11400F socket 1200 11.generation 2.60GHz 12MB  14nm");
                            PcDetails pcDetails98 = new PcDetails("İşlemciler","Intel Core i3 10100F socket 1200 10.generation 3.60GHz 6MB ");
                            PcDetails pcDetails99 = new PcDetails("İşlemciler","Intel Core i7 12700F socket 1700 12.generation 25MB 10nm ");
                            PcDetails pcDetails100 = new PcDetails("İşlemciler","Intel Core i5 12400 socket 1700 12.generation 2.50GHz 18MB  10nm");
                            PcDetails pcDetails101 = new PcDetails("İşlemciler","Intel Core i5 12600K socket 1700 12.generation 3.70GHz 20MB  10nm");
                            PcDetails pcDetails102 = new PcDetails("İşlemciler","Intel Core i5 9400 socket 1151 - 9.generation 2.9GHz 9MB  14nm");
                            PcDetails pcDetails103 = new PcDetails("İşlemciler","Intel Core i9 11900KF socket 1200 11.generation 3.50GHz 16MB  14nm");
                            PcDetails pcDetails104 = new PcDetails("İşlemciler","Intel Core i5 11600K socket 1200 11.generation 3.90GHz 12MB 14nm");
                            PcDetails pcDetails105 = new PcDetails("İşlemciler","Intel Core i5 12400F socket 1700 12.generation 2.50GHz 18MB 10nm");
                            PcDetails pcDetails106 = new PcDetails("İşlemciler","Intel Core i7 12700K socket 1700 12.generation 2.70GHz 25MB 10nm");
                            PcDetails pcDetails107 = new PcDetails("İşlemciler","Intel Core i9 12900KS socket 1700 3.4GHz 12. 30MB");
                            PcDetails pcDetails108 = new PcDetails("İşlemciler","Intel Core i9 12900 socket 1700 12.generation  3.20GHz 30MB 10nm");
                            PcDetails pcDetails109 = new PcDetails("İşlemciler","Intel Core i3 10105F socket 1200 10.generation  3.70GHz 6MB 14nm");
                            PcDetails pcDetails110 = new PcDetails("İşlemciler","Intel Core i9 12900F socket 1700 12.generation  2.40GHz 30MB 10nm");
                            PcDetails pcDetails111 = new PcDetails("İşlemciler","Intel Core i7 12700  socket 1700 12.generation  2.10GHz 25MB  10nm");
                            PcDetails pcDetails112 = new PcDetails("İşlemciler","Intel Core i5 10600KF socket 1200 10generation. 4.10GHz 12MB 14nm");
                            PcDetails pcDetails113 = new PcDetails("İşlemciler","Intel Core i9 10900F socket 1200 10.generation  2.80 GHz 20MB 14nm");
                            PcDetails pcDetails1143 = new PcDetails("İşlemciler","Intel Core i9 10850K socket 1200 10.generation  3.60 GHz 20MB 14nm");
                            PcDetails pcDetails114 = new PcDetails("İşlemciler","Intel Core i9 10900  socket 1200 10.generation  2.80 GHz 20MB 14nm");
                            PcDetails pcDetails115 = new PcDetails("İşlemciler","Intel Core i5 10400F socket 1200 10.generation  2.9GHz 12MBb 14nm");
                            PcDetails pcDetails116 = new PcDetails("İşlemciler","Intel Core i3 12100  socket 1700 12.generation  3.30GHz 12MB 10nm");
                            PcDetails pcDetails117 = new PcDetails("İşlemciler","Intel Core i7 12700KF socket 1700 12generation. 2.70GHz 25MB 10nm");
                            PcDetails pcDetails118 = new PcDetails("İşlemciler","Intel Core i9 11900  socket 1200 11.generation  2.50GHz 16MB 14nm");
                            PcDetails pcDetails119 = new PcDetails("İşlemciler","Intel Core i5 11600KF socket 1200 11generation  3.90GHz 12MB 14nm");
                            PcDetails pcDetails200 = new PcDetails("İşlemciler","Intel Core i5 10400  socket 1200 10.generation  2.9GHz 12MB 14nm");
                            PcDetails pcDetails201 = new PcDetails("İşlemciler","Intel Core i3 10320  socket 1200 10.generation  3.80GHz 8MB ");
                            PcDetails pcDetails202 = new PcDetails("İşlemciler","Intel Core i5 12500  socket 1700 12.generation  3 GHz 18MB 10nm");
                            PcDetails pcDetails203 = new PcDetails("İşlemciler","Intel Core i9 12900KF socket 1700 12generation. 3.20GHz 30MB 10nm");
                            PcDetails pcDetails204 = new PcDetails("İşlemciler","Intel Core i9 12900K socket 1700 12.generation  3.20GHz 30MB 10nm");
                            PcDetails pcDetails205 = new PcDetails("İşlemciler","Intel Core i5 12600KF socket 1700 12generation. 3.70GHz 20MB 10nm");
                            PcDetails pcDetails206 = new PcDetails("İşlemciler","Intel Core i3 10105  socket 1200 10.generation  3.70GHz 6MB 14nm");
                            PcDetails pcDetails207 = new PcDetails("İşlemciler","Intel Core i9 11900K socket 1200 11.generation  3.50GHz 16MB 14nm");
                            PcDetails pcDetails208 = new PcDetails("İşlemciler","Intel Core i7 11700KF socket 1200 11generation. 3.60GHz 16MB 14nm");
                            PcDetails pcDetails209 = new PcDetails("İşlemciler","Intel Core i5 11600 socket 1200 11.generation  2.80GHz 12MB 14nm");
                            PcDetails pcDetails210 = new PcDetails("İşlemciler","Intel Core i5 11500  socket 1200 11.generation  2.70GHz 12MB 14nm");
                            PcDetails pcDetails211 = new PcDetails("İşlemciler","Intel Core i7 11700F socket 1200 11.generation  2.50GHz 16MB 14nm");
                            PcDetails pcDetails212 = new PcDetails("İşlemciler","Intel Core i7 11700  socket 1200 11.generation  2.50GHz 16MB 14nm");
                            PcDetails pcDetails213 = new PcDetails("İşlemciler","Intel Core i5 11400  socket 1200 11.generation  2.60GHz 12MB 14nm");
                            PcDetails pcDetails224 = new PcDetails("İşlemciler","Intel Core i7 11700K socket 1200 11.generation  3.60GHz 16MB 14nm");
                            PcDetails pcDetails234 = new PcDetails("İşlemciler","Intel Core i9 10850K socket 1200 10.generation  3.60 GHz 20MB 14nm");
                            PcDetails pcDetails244 = new PcDetails("İşlemciler","Intel Core i9 10940X socket 2066 10.generation  3.30 GHz 19.25M");
                            PcDetails pcDetails255 = new PcDetails("İşlemciler","Intel Core i9 10980XE socket 2066 3.0GHz 24.75MB 14nm");
                            PcDetails pcDetails266 = new PcDetails("İşlemciler","Intel Core i9 10900K socket 1200 10.generation 3.70 GHz 20MB  14nm");
                            PcDetails pcDetails277 = new PcDetails("İşlemcilerı","Intel Core i9 10900KF socket 1200 10.generation 3.70 GHz 20MB 14nm");
                            PcDetails pcDetails288 = new PcDetails("İşlemciler","Intel Core i7 10700K socket 1200 10.generation 3.80 GHz 16MB  14nm");
                            PcDetails pcDetails299 = new PcDetails("İşlemciler","Intel Core i7 10700KF socket 1200 10.generation 3.80 GHz 16MB 14nm");
                            PcDetails pcDetails320 = new PcDetails("İşlemciler","Intel Core i7 10700 socket 1200 10.generation 2.90GHz 16MB 14nm");
                            PcDetails pcDetails300 = new PcDetails("İşlemciler","Intel Core i7 10700F socket 1200 10.generation 2.90GHz 16MB 14nm");
                            PcDetails pcDetails333 = new PcDetails("İşlemciler","Intel Core i5 10600K socket 1200 10.generation 4.10GHz 12MB 14nm");
                            PcDetails pcDetails344 = new PcDetails("İşlemciler","Intel Core i5 10600 socket 1200 10.generation 3.30GHz 12MB 14nm");
                            PcDetails pcDetails355 = new PcDetails("İşlemciler","Intel Core i5 10500 socket 1200 10.generation 3.10GHz 12MB 14nm");
                            PcDetails pcDetails366 = new PcDetails("İşlemciler","Intel Core i3 10100 socket 1200 10.generation 3.6GHz 6MB 14nm");
                            PcDetails pcDetails381 = new PcDetails("İşlemciler","Intel Core i9 10900X socket 2066 3.70GHz 19.25MB 14nm");
                            PcDetails pcDetails377= new PcDetails("İşlemciler", "AMD Ryzen™5 5500   AM4 4.2 GHz 19MB 65W 7nm");
                            PcDetails pcDetails391 = new PcDetails("İşlemciler","AMD Ryzen™5 5600X  AM4 Wraith Stealth 3.7GHz 32MB 65W");
                            PcDetails pcDetails412 = new PcDetails("İşlemciler","AMD Ryzen™5 5600   AM4 3.5GHz 32MB 65W 7nm");
                            PcDetails pcDetails401 = new PcDetails("İşlemciler","AMD Ryzen™7 5700X  AM4 3.4GHz 32MB 65W 7nm");
                            PcDetails pcDetails421 = new PcDetails("İşlemciler","AMD Ryzen™5 4500   AM4 4.1GHz 11MB 165W 7nm");
                            PcDetails pcDetails433 = new PcDetails("İşlemciler","AMD Ryzen™7 5800X  AM4 3.8GHz 32MB 105W 7nm");
                            PcDetails pcDetails456 = new PcDetails("İşlemciler","AMD Ryzen™7 5700G  AM4 3.8 GHz 20MB 65W 7nm");
                            PcDetails pcDetails477 = new PcDetails("İşlemciler","AMD Ryzen™9 5950X  AM4 3.4GHz 64MB 105W 7nm");
                            PcDetails pcDetails499 = new PcDetails("İşlemciler","AMD Ryzen™5 5600G  AM4 3.9 GHz 19MB 65W 7nm");
                            PcDetails pcDetails488 = new PcDetails("İşlemciler","AMD Ryzen™7 3800XT AM4 4.7 GHz 36MB 105W 7nm");
                            PcDetails pcDetails467 = new PcDetails("İşlemciler","AMD Ryzen™7 3800X  AM4+WraithPrism(RGB) 3.9 GHz");
                            PcDetails pcDetails444 = new PcDetails("İşlemciler","AMD Ryzen™7 3700X  AM4+Wraith Prism(RGB) 3.6 GHz");



                            pcDetailsArrayList.add(pcDetails366);
                            pcDetailsArrayList.add(pcDetails377);
                            pcDetailsArrayList.add(pcDetails381);
                            pcDetailsArrayList.add(pcDetails391);
                            pcDetailsArrayList.add(pcDetails401);
                            pcDetailsArrayList.add(pcDetails412);
                            pcDetailsArrayList.add(pcDetails421);
                            pcDetailsArrayList.add(pcDetails433);
                            pcDetailsArrayList.add(pcDetails444);
                            pcDetailsArrayList.add(pcDetails456);
                            pcDetailsArrayList.add(pcDetails467);
                            pcDetailsArrayList.add(pcDetails477);
                            pcDetailsArrayList.add(pcDetails488);
                            pcDetailsArrayList.add(pcDetails499);
                            pcDetailsArrayList.add(pcDetails109);
                            pcDetailsArrayList.add(pcDetails96);
                            pcDetailsArrayList.add(pcDetails97);
                            pcDetailsArrayList.add(pcDetails98);
                            pcDetailsArrayList.add(pcDetails99);
                            pcDetailsArrayList.add(pcDetails100);
                            pcDetailsArrayList.add(pcDetails101);
                            pcDetailsArrayList.add(pcDetails102);
                            pcDetailsArrayList.add(pcDetails103);
                            pcDetailsArrayList.add(pcDetails104);
                            pcDetailsArrayList.add(pcDetails105);
                            pcDetailsArrayList.add(pcDetails106);
                            pcDetailsArrayList.add(pcDetails107);
                            pcDetailsArrayList.add(pcDetails108);
                            pcDetailsArrayList.add(pcDetails110);
                            pcDetailsArrayList.add(pcDetails111);
                            pcDetailsArrayList.add(pcDetails112);
                            pcDetailsArrayList.add(pcDetails113);
                            pcDetailsArrayList.add(pcDetails1143);
                            pcDetailsArrayList.add(pcDetails114);
                            pcDetailsArrayList.add(pcDetails115);
                            pcDetailsArrayList.add(pcDetails116);
                            pcDetailsArrayList.add(pcDetails117);
                            pcDetailsArrayList.add(pcDetails118);
                            pcDetailsArrayList.add(pcDetails119);
                            pcDetailsArrayList.add(pcDetails200);
                            pcDetailsArrayList.add(pcDetails201);
                            pcDetailsArrayList.add(pcDetails202);
                            pcDetailsArrayList.add(pcDetails203);
                            pcDetailsArrayList.add(pcDetails355);
                            pcDetailsArrayList.add(pcDetails204);
                            pcDetailsArrayList.add(pcDetails205);
                            pcDetailsArrayList.add(pcDetails206);
                            pcDetailsArrayList.add(pcDetails207);
                            pcDetailsArrayList.add(pcDetails208);
                            pcDetailsArrayList.add(pcDetails209);
                            pcDetailsArrayList.add(pcDetails210);
                            pcDetailsArrayList.add(pcDetails211);
                            pcDetailsArrayList.add(pcDetails212);
                            pcDetailsArrayList.add(pcDetails213);
                            pcDetailsArrayList.add(pcDetails224);
                            pcDetailsArrayList.add(pcDetails234);
                            pcDetailsArrayList.add(pcDetails244);
                            pcDetailsArrayList.add(pcDetails255);
                            pcDetailsArrayList.add(pcDetails266);
                            pcDetailsArrayList.add(pcDetails277);
                            pcDetailsArrayList.add(pcDetails288);
                            pcDetailsArrayList.add(pcDetails299);
                            pcDetailsArrayList.add(pcDetails300);
                            pcDetailsArrayList.add(pcDetails320);
                            pcDetailsArrayList.add(pcDetails333);
                            pcDetailsArrayList.add(pcDetails344);

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
                            searchView = view.findViewById(R.id.searchView_İslemciler);
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
                            searchView = view.findViewById(R.id.searchView_İslemciler);
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