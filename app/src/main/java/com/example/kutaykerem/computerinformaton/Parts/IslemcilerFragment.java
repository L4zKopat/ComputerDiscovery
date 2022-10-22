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



        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String userId = user.getUid();

        FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();

        firebaseFirestore.collection("KullanılanDiller").document(userId).collection("SecilenDil").orderBy("tarih", Query.Direction.DESCENDING).limit(1).addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {



                if(value != null){

                    for(DocumentSnapshot documentSnapshot : value.getDocuments()){
                        Map<String, Object> data = documentSnapshot.getData();
                        String dil = data.get("dil").toString();


                        if(dil.equals("türkce")){

                            PcDetails pcDetails96 = new PcDetails("İşlemciler","Intel Core i3 12100F Soket 1700 12. Nesil 3.30GHz 12MB  10nm");
                            pcDetailsArrayList.add(pcDetails96);

                            PcDetails pcDetails97 = new PcDetails("İşlemciler","Intel Core i5 11400F Soket 1200 11. Nesil 2.60GHz 12MB  14nm");
                            pcDetailsArrayList.add(pcDetails97);

                            PcDetails pcDetails98 = new PcDetails("İşlemciler","Intel Core i3 10100F Soket 1200 10.Nesil 3.60GHz 6MB");
                            pcDetailsArrayList.add(pcDetails98);

                            PcDetails pcDetails99 = new PcDetails("İşlemciler","Intel Core i7 12700F Soket 1700 12. Nesil 25MB  10nm ");
                            pcDetailsArrayList.add(pcDetails99);

                            PcDetails pcDetails100 = new PcDetails("İşlemciler","Intel Core i5 12400 Soket 1700 12. Nesil 2.50GHz 18MB  10nm");
                            pcDetailsArrayList.add(pcDetails100);

                            PcDetails pcDetails101 = new PcDetails("İşlemciler","Intel Core i5 12600K Soket 1700 12. Nesil 3.70GHz 20MB  10nm");
                            pcDetailsArrayList.add(pcDetails101);

                            PcDetails pcDetails102 = new PcDetails("İşlemciler","Intel Core i5 9400 Soket 1151 - 9. Nesil 2.9GHz 9MB 14nm");
                            pcDetailsArrayList.add(pcDetails102);

                            PcDetails pcDetails103 = new PcDetails("İşlemciler","Intel Core i9 11900KF Soket 1200 11. Nesil 3.50GHz 16MB  14nm");
                            pcDetailsArrayList.add(pcDetails103);

                            PcDetails pcDetails104 = new PcDetails("İşlemciler","Intel Core i5 11600K Soket 1200 11. Nesil 3.90GHz 12MB 14nm");
                            pcDetailsArrayList.add(pcDetails104);

                            PcDetails pcDetails105 = new PcDetails("İşlemciler","Intel Core i5 12400F Soket 1700 12. Nesil 2.50GHz 18MB 10nm");
                            pcDetailsArrayList.add(pcDetails105);

                            PcDetails pcDetails106 = new PcDetails("İşlemciler","Intel Core i7 12700K Soket 1700 12. Nesil 2.70GHz 25MB  10nm");
                            pcDetailsArrayList.add(pcDetails106);

                            PcDetails pcDetails107 = new PcDetails("İşlemciler","Intel Core i9 12900KS Soket 1700 3.4GHz 12. Nesil 30MB");
                            pcDetailsArrayList.add(pcDetails107);

                            PcDetails pcDetails108 = new PcDetails("İşlemciler","Intel Core i9 12900 Soket 1700 12. Nesil 3.20GHz 30MB  10nm");
                            pcDetailsArrayList.add(pcDetails108);

                            PcDetails pcDetails109 = new PcDetails("İşlemciler","Intel Core i3 10105F Soket 1200 10. Nesil 3.70GHz 6MB  14nm");
                            pcDetailsArrayList.add(pcDetails109);

                            PcDetails pcDetails110 = new PcDetails("İşlemciler","Intel Core i9 12900F Soket 1700 12. Nesil 2.40GHz 30MB  10nm");
                            pcDetailsArrayList.add(pcDetails110);

                            PcDetails pcDetails111 = new PcDetails("İşlemciler","Intel Core i7 12700 Soket 1700 12. Nesil 2.10GHz 25MB  10nm");
                            pcDetailsArrayList.add(pcDetails111);

                            PcDetails pcDetails112 = new PcDetails("İşlemciler","Intel Core i5 10600KF Soket 1200 10. Nesil 4.10GHz 12MB  14nm");
                            pcDetailsArrayList.add(pcDetails112);

                            PcDetails pcDetails113 = new PcDetails("İşlemciler","Intel Core i9 10900F Soket 1200 10. Nesil 2.80 GHz 20MB  14nm");
                            pcDetailsArrayList.add(pcDetails113);


                            PcDetails pcDetails1143 = new PcDetails("İşlemciler","Intel Core i9 10850K Soket 1200 10. Nesil 3.60 GHz 20MB 14nm");
                            pcDetailsArrayList.add(pcDetails1143);

                            PcDetails pcDetails114 = new PcDetails("İşlemciler","Intel Core i9 10900 Soket 1200 10. Nesil 2.80 GHz 20MB 14nm");
                            pcDetailsArrayList.add(pcDetails114);

                            PcDetails pcDetails115 = new PcDetails("İşlemciler","Intel Core i5 10400F Soket 1200 10. Nesil 2.9GHz 12MB  14nm");
                            pcDetailsArrayList.add(pcDetails115);

                            PcDetails pcDetails116 = new PcDetails("İşlemciler","Intel Core i3 12100 Soket 1700 12. Nesil 3.30GHz 12MB  10nm");
                            pcDetailsArrayList.add(pcDetails116);

                            PcDetails pcDetails117 = new PcDetails("İşlemciler","Intel Core i7 12700KF Soket 1700 12. Nesil 2.70GHz 25MB 0nm");
                            pcDetailsArrayList.add(pcDetails117);

                            PcDetails pcDetails118 = new PcDetails("İşlemciler","Intel Core i9 11900 Soket 1200 11. Nesil 2.50GHz 16MB  14nm");
                            pcDetailsArrayList.add(pcDetails118);

                            PcDetails pcDetails119 = new PcDetails("İşlemciler","Intel Core i5 11600KF Soket 1200 11. Nesil 3.90GHz 12MB  14nm");
                            pcDetailsArrayList.add(pcDetails119);

                            PcDetails pcDetails200 = new PcDetails("İşlemciler","Intel Core i5 10400 Soket 1200 10. Nesil 2.9GHz 12MB 14nm");
                            pcDetailsArrayList.add(pcDetails200);

                            PcDetails pcDetails201 = new PcDetails("İşlemciler","Intel Core i3 10320 Soket 1200 10.Nesil 3.80GHz 8MB ");
                            pcDetailsArrayList.add(pcDetails201);

                            PcDetails pcDetails202 = new PcDetails("İşlemciler","Intel Core i5 12500 Soket 1700 12. Nesil 3 GHz 18MB  10nm");
                            pcDetailsArrayList.add(pcDetails202);

                            PcDetails pcDetails203 = new PcDetails("İşlemciler","Intel Core i9 12900KF Soket 1700 12. Nesil 3.20GHz 30MB 10nm");
                            pcDetailsArrayList.add(pcDetails203);

                            PcDetails pcDetails204 = new PcDetails("İşlemciler","Intel Core i9 12900K Soket 1700 12. Nesil 3.20GHz 30MB  10nm");
                            pcDetailsArrayList.add(pcDetails204);

                            PcDetails pcDetails205 = new PcDetails("İşlemciler","Intel Core i5 12600KF Soket 1700 12. Nesil 3.70GHz 20MB  10nm");
                            pcDetailsArrayList.add(pcDetails205);

                            PcDetails pcDetails206 = new PcDetails("İşlemciler","Intel Core i3 10105 Soket 1200 10. Nesil 3.70GHz 6MB  14nm");
                            pcDetailsArrayList.add(pcDetails206);

                            PcDetails pcDetails207 = new PcDetails("İşlemciler","Intel Core i9 11900K Soket 1200 11. Nesil 3.50GHz 16MB 14nm");
                            pcDetailsArrayList.add(pcDetails207);

                            PcDetails pcDetails208 = new PcDetails("İşlemciler","Intel Core i7 11700KF Soket 1200 11. Nesil 3.60GHz 16MB  14nm");
                            pcDetailsArrayList.add(pcDetails208);

                            PcDetails pcDetails209 = new PcDetails("İşlemciler","Intel Core i5 11600 Soket 1200 11. Nesil 2.80GHz 12MB 14nm");
                            pcDetailsArrayList.add(pcDetails209);

                            PcDetails pcDetails210 = new PcDetails("İşlemciler","Intel Core i5 11500 Soket 1200 11. Nesil 2.70GHz 12MB  14nm");
                            pcDetailsArrayList.add(pcDetails210);

                            PcDetails pcDetails211 = new PcDetails("İşlemciler","Intel Core i7 11700F Soket 1200 11. Nesil 2.50GHz 16MB  14nm");
                            pcDetailsArrayList.add(pcDetails211);

                            PcDetails pcDetails212 = new PcDetails("İşlemciler","Intel Core i7 11700 Soket 1200 11. Nesil 2.50GHz 16MB 14nm");
                            pcDetailsArrayList.add(pcDetails212);

                            PcDetails pcDetails213 = new PcDetails("İşlemciler","Intel Core i5 11400 Soket 1200 11. Nesil 2.60GHz 12MB 14nm");
                            pcDetailsArrayList.add(pcDetails213);

                            PcDetails pcDetails224 = new PcDetails("İşlemciler","Intel Core i7 11700K Soket 1200 11. Nesil 3.60GHz 16MB 14nm");
                            pcDetailsArrayList.add(pcDetails224);

                            PcDetails pcDetails234 = new PcDetails("İşlemciler","Intel Core i9 10850K Soket 1200 10. Nesil 3.60 GHz 20MB  14nm");
                            pcDetailsArrayList.add(pcDetails234);

                            PcDetails pcDetails244 = new PcDetails("İşlemciler","Intel Core i9 10940X Soket 2066 10.Nesil 3.30 GHz 19.25MB");
                            pcDetailsArrayList.add(pcDetails244);

                            PcDetails pcDetails255 = new PcDetails("İşlemciler","Intel Core i9 10980XE Soket 2066 3.0GHz 24.75MB  14nm");
                            pcDetailsArrayList.add(pcDetails255);

                            PcDetails pcDetails266 = new PcDetails("İşlemciler","Intel Core i9 10900K Soket 1200 10. Nesil 3.70 GHz 20MB  14nm");
                            pcDetailsArrayList.add(pcDetails266);

                            PcDetails pcDetails277 = new PcDetails("İşlemcilerı","Intel Core i9 10900KF Soket 1200 10. Nesil 3.70 GHz 20MB  14nm");
                            pcDetailsArrayList.add(pcDetails277);

                            PcDetails pcDetails288 = new PcDetails("İşlemciler","Intel Core i7 10700K Soket 1200 10. Nesil 3.80 GHz 16MB  14nm");
                            pcDetailsArrayList.add(pcDetails288);

                            PcDetails pcDetails299 = new PcDetails("İşlemciler","Intel Core i7 10700KF Soket 1200 10. Nesil 3.80 GHz 16MB14nm");
                            pcDetailsArrayList.add(pcDetails299);

                            PcDetails pcDetails300 = new PcDetails("İşlemciler","Intel Core i7 10700 Soket 1200 10. Nesil 2.90GHz 16MB  14nm");
                            pcDetailsArrayList.add(pcDetails300);

                            PcDetails pcDetails320 = new PcDetails("İşlemciler","Intel Core i7 10700F Soket 1200 10. Nesil 2.90GHz 16MB  14nm");
                            pcDetailsArrayList.add(pcDetails320);

                            PcDetails pcDetails333 = new PcDetails("İşlemciler","Intel Core i5 10600K Soket 1200 10. Nesil 4.10GHz 12MB  14nm");
                            pcDetailsArrayList.add(pcDetails333);

                            PcDetails pcDetails344 = new PcDetails("İşlemciler","Intel Core i5 10600 Soket 1200 10. Nesil 3.30GHz 12MB  14nm");
                            pcDetailsArrayList.add(pcDetails344);

                            PcDetails pcDetails355 = new PcDetails("İşlemciler","Intel Core i5 10500 Soket 1200 10. Nesil 3.10GHz 12MB  14nm");
                            pcDetailsArrayList.add(pcDetails355);

                            PcDetails pcDetails366 = new PcDetails("İşlemciler","Intel Core i3 10100 Soket 1200 10. Nesil 3.6GHz 6MB  14nm");
                            pcDetailsArrayList.add(pcDetails366);

                            PcDetails pcDetails377= new PcDetails("İşlemciler","Intel Core i9 10900X Soket 2066 3.70GHz 19.25MB k 14nm");
                            pcDetailsArrayList.add(pcDetails377);

                            PcDetails pcDetails381 = new PcDetails("İşlemciler","AMD Ryzen™5 5500 Soket AM4 4.2 GHz 19MB 65W 7nm ");
                            pcDetailsArrayList.add(pcDetails381);

                            PcDetails pcDetails391 = new PcDetails("İşlemciler","AMD Ryzen™5 5600X Soket AM4 Wraith Stealth 3.7GHz 32MB 65W");
                            pcDetailsArrayList.add(pcDetails391);

                            PcDetails pcDetails401 = new PcDetails("İşlemciler","AMD Ryzen™5 5600 Soket AM4 3.5GHz 32MB 65W 7nm");
                            pcDetailsArrayList.add(pcDetails401);

                            PcDetails pcDetails412 = new PcDetails("İşlemciler","AMD Ryzen™7 5700X Soket AM4 3.4GHz 32MB 65W 7nm ");
                            pcDetailsArrayList.add(pcDetails412);

                            PcDetails pcDetails421 = new PcDetails("İşlemciler","AMD Ryzen™5 4500 Soket AM4 4.1GHz 11MB 165W 7nm ");
                            pcDetailsArrayList.add(pcDetails421);

                            PcDetails pcDetails433 = new PcDetails("İşlemciler","AMD Ryzen™7 5800X Soket AM4 3.8GHz 32MB 105W 7nm ");
                            pcDetailsArrayList.add(pcDetails433);

                            PcDetails pcDetails444 = new PcDetails("İşlemciler","AMD Ryzen™7 5700G Soket AM4 3.8 GHz 20MB 65W 7nm ");
                            pcDetailsArrayList.add(pcDetails444);

                            PcDetails pcDetails456 = new PcDetails("İşlemciler","AMD Ryzen™9 5950X Soket AM4 3.4GHz 64MB 105W 7nm ");
                            pcDetailsArrayList.add(pcDetails456);

                            PcDetails pcDetails467 = new PcDetails("İşlemciler","AMD Ryzen™5 5600G Soket AM4 3.9 GHz 19MB 65W 7nm ");
                            pcDetailsArrayList.add(pcDetails467);

                            PcDetails pcDetails477 = new PcDetails("İşlemciler","AMD Ryzen™7 3800XT Soket AM4 4.7 GHz 36MB 105W 7nm ");
                            pcDetailsArrayList.add(pcDetails477);

                            PcDetails pcDetails488 = new PcDetails("İşlemciler","AMD Ryzen™7 3800X Soket AM4+WraithPrism(RGB) 3.9 GHz");
                            pcDetailsArrayList.add(pcDetails488);

                            PcDetails pcDetails499 = new PcDetails("İşlemciler","AMD Ryzen™7 3700X Soket AM4+Wraith Prism(RGB) 3.6 GHz");
                            pcDetailsArrayList.add(pcDetails499);



                            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                            adaptorPcDetails = new AdaptorPcDetails(pcDetailsArrayList);
                            recyclerView.setAdapter(adaptorPcDetails);



                            adaptorPcDetails.notifyDataSetChanged();


                        }else if (dil.equals("ingilizce")){

                            PcDetails pcDetails96 = new PcDetails("Processors","Intel Core i3 12100F Soket 1700 12. Nesil 3.30GHz 12MB  10nm");
                            pcDetailsArrayList.add(pcDetails96);

                            PcDetails pcDetails97 = new PcDetails("Processors","Intel Core i5 11400F Soket 1200 11. Nesil 2.60GHz 12MB  14nm");
                            pcDetailsArrayList.add(pcDetails97);

                            PcDetails pcDetails98 = new PcDetails("Processors","Intel Core i3 10100F Soket 1200 10.Nesil 3.60GHz 6MB ");
                            pcDetailsArrayList.add(pcDetails98);

                            PcDetails pcDetails99 = new PcDetails("Processors","Intel Core i7 12700F Soket 1700 12. Nesil 25MB 10nm ");
                            pcDetailsArrayList.add(pcDetails99);

                            PcDetails pcDetails100 = new PcDetails("Processors","Intel Core i5 12400 Soket 1700 12. Nesil 2.50GHz 18MB 10nm");
                            pcDetailsArrayList.add(pcDetails100);

                            PcDetails pcDetails101 = new PcDetails("Processors","Intel Core i5 12600K Soket 1700 12. Nesil 3.70GHz 20MB  10nm");
                            pcDetailsArrayList.add(pcDetails101);

                            PcDetails pcDetails102 = new PcDetails("Processors","Intel Core i5 9400 Soket 1151 - 9. Nesil 2.9GHz 9MB  14nm");
                            pcDetailsArrayList.add(pcDetails102);

                            PcDetails pcDetails103 = new PcDetails("Processors","Intel Core i9 11900KF Soket 1200 11. Nesil 3.50GHz 16MB 14nm");
                            pcDetailsArrayList.add(pcDetails103);

                            PcDetails pcDetails104 = new PcDetails("Processors","Intel Core i5 11600K Soket 1200 11. Nesil 3.90GHz 12MB 14nm");
                            pcDetailsArrayList.add(pcDetails104);

                            PcDetails pcDetails105 = new PcDetails("Processors","Intel Core i5 12400F Soket 1700 12. Nesil 2.50GHz 18MB 10nm");
                            pcDetailsArrayList.add(pcDetails105);

                            PcDetails pcDetails106 = new PcDetails("Processors","Intel Core i7 12700K Soket 1700 12. Nesil 2.70GHz 25MB 10nm");
                            pcDetailsArrayList.add(pcDetails106);

                            PcDetails pcDetails107 = new PcDetails("Processors","Intel Core i9 12900KS Soket 1700 3.4GHz 12. Nesil 30MB ");
                            pcDetailsArrayList.add(pcDetails107);

                            PcDetails pcDetails108 = new PcDetails("Processors","Intel Core i9 12900 Soket 1700 12. Nesil 3.20GHz 30MB  10nm");
                            pcDetailsArrayList.add(pcDetails108);

                            PcDetails pcDetails109 = new PcDetails("Processors","Intel Core i3 10105F Soket 1200 10. Nesil 3.70GHz 6MB  14nm");
                            pcDetailsArrayList.add(pcDetails109);

                            PcDetails pcDetails110 = new PcDetails("Processors","Intel Core i9 12900F Soket 1700 12. Nesil 2.40GHz 30MB  10nm");
                            pcDetailsArrayList.add(pcDetails110);

                            PcDetails pcDetails111 = new PcDetails("Processors","Intel Core i7 12700 Soket 1700 12. Nesil 2.10GHz 25MB  10nm");
                            pcDetailsArrayList.add(pcDetails111);

                            PcDetails pcDetails112 = new PcDetails("Processors","Intel Core i5 10600KF Soket 1200 10. Nesil 4.10GHz 12MB  14nm");
                            pcDetailsArrayList.add(pcDetails112);

                            PcDetails pcDetails113 = new PcDetails("Processors","Intel Core i9 10900F Soket 1200 10. Nesil 2.80 GHz 20MB  14nm");
                            pcDetailsArrayList.add(pcDetails113);


                            PcDetails pcDetails1143 = new PcDetails("Processors","Intel Core i9 10850K Soket 1200 10. Nesil 3.60 GHz 20MB 14nm");
                            pcDetailsArrayList.add(pcDetails1143);

                            PcDetails pcDetails114 = new PcDetails("Processors","Intel Core i9 10900 Soket 1200 10. Nesil 2.80 GHz 20MB  14nm");
                            pcDetailsArrayList.add(pcDetails114);

                            PcDetails pcDetails115 = new PcDetails("Processors","Intel Core i5 10400F Soket 1200 10. Nesil 2.9GHz 12MB  14nm");
                            pcDetailsArrayList.add(pcDetails115);

                            PcDetails pcDetails116 = new PcDetails("Processors","Intel Core i3 12100 Soket 1700 12. Nesil 3.30GHz 12MB  10nm");
                            pcDetailsArrayList.add(pcDetails116);

                            PcDetails pcDetails117 = new PcDetails("Processors","Intel Core i7 12700KF Soket 1700 12. Nesil 2.70GHz 25MB  10nm");
                            pcDetailsArrayList.add(pcDetails117);

                            PcDetails pcDetails118 = new PcDetails("Processors","Intel Core i9 11900 Soket 1200 11. Nesil 2.50GHz 16MB  14nm");
                            pcDetailsArrayList.add(pcDetails118);

                            PcDetails pcDetails119 = new PcDetails("Processors","Intel Core i5 11600KF Soket 1200 11. Nesil 3.90GHz 12MB  14nm");
                            pcDetailsArrayList.add(pcDetails119);

                            PcDetails pcDetails200 = new PcDetails("Processors","Intel Core i5 10400 Soket 1200 10. Nesil 2.9GHz 12MB  14nm");
                            pcDetailsArrayList.add(pcDetails200);

                            PcDetails pcDetails201 = new PcDetails("Processors","Intel Core i3 10320 Soket 1200 10.Nesil 3.80GHz 8MB ");
                            pcDetailsArrayList.add(pcDetails201);

                            PcDetails pcDetails202 = new PcDetails("Processors","Intel Core i5 12500 Soket 1700 12. Nesil 3 GHz 18MB  10nm");
                            pcDetailsArrayList.add(pcDetails202);

                            PcDetails pcDetails203 = new PcDetails("Processors","Intel Core i9 12900KF Soket 1700 12. Nesil 3.20GHz 30MB 10nm");
                            pcDetailsArrayList.add(pcDetails203);

                            PcDetails pcDetails204 = new PcDetails("Processors","Intel Core i9 12900K Soket 1700 12. Nesil 3.20GHz 30MB 10nm");
                            pcDetailsArrayList.add(pcDetails204);

                            PcDetails pcDetails205 = new PcDetails("Processors","Intel Core i5 12600KF Soket 1700 12. Nesil 3.70GHz 20MB  10nm");
                            pcDetailsArrayList.add(pcDetails205);

                            PcDetails pcDetails206 = new PcDetails("Processors","Intel Core i3 10105 Soket 1200 10. Nesil 3.70GHz 6MB 14nm");
                            pcDetailsArrayList.add(pcDetails206);

                            PcDetails pcDetails207 = new PcDetails("Processors","Intel Core i9 11900K Soket 1200 11. Nesil 3.50GHz 16MB 14nm");
                            pcDetailsArrayList.add(pcDetails207);

                            PcDetails pcDetails208 = new PcDetails("Processors","Intel Core i7 11700KF Soket 1200 11. Nesil 3.60GHz 16MB  14nm");
                            pcDetailsArrayList.add(pcDetails208);

                            PcDetails pcDetails209 = new PcDetails("Processors","Intel Core i5 11600 Soket 1200 11. Nesil 2.80GHz 12MB  14nm");
                            pcDetailsArrayList.add(pcDetails209);

                            PcDetails pcDetails210 = new PcDetails("Processors","Intel Core i5 11500 Soket 1200 11. Nesil 2.70GHz 12MB  14nm");
                            pcDetailsArrayList.add(pcDetails210);

                            PcDetails pcDetails211 = new PcDetails("Processors","Intel Core i7 11700F Soket 1200 11. Nesil 2.50GHz 16MB  14nm");
                            pcDetailsArrayList.add(pcDetails211);

                            PcDetails pcDetails212 = new PcDetails("Processors","Intel Core i7 11700 Soket 1200 11. Nesil 2.50GHz 16MB 14nm");
                            pcDetailsArrayList.add(pcDetails212);

                            PcDetails pcDetails213 = new PcDetails("Processors","Intel Core i5 11400 Soket 1200 11. Nesil 2.60GHz 12MB 14nm");
                            pcDetailsArrayList.add(pcDetails213);

                            PcDetails pcDetails224 = new PcDetails("Processors","Intel Core i7 11700K Soket 1200 11. Nesil 3.60GHz 16MB 14nm");
                            pcDetailsArrayList.add(pcDetails224);

                            PcDetails pcDetails234 = new PcDetails("Processors","Intel Core i9 10850K Soket 1200 10. Nesil 3.60 GHz 20MB  14nm");
                            pcDetailsArrayList.add(pcDetails234);

                            PcDetails pcDetails244 = new PcDetails("Processors","Intel Core i9 10940X Soket 2066 10.Nesil 3.30 GHz 19.25MB ");
                            pcDetailsArrayList.add(pcDetails244);

                            PcDetails pcDetails255 = new PcDetails("Processors","Intel Core i9 10980XE Soket 2066 3.0GHz 24.75MB  14nm");
                            pcDetailsArrayList.add(pcDetails255);

                            PcDetails pcDetails266 = new PcDetails("Processors","Intel Core i9 10900K Soket 1200 10. Nesil 3.70 GHz 20MB  14nm");
                            pcDetailsArrayList.add(pcDetails266);

                            PcDetails pcDetails277 = new PcDetails("Processorsı","Intel Core i9 10900KF Soket 1200 10. Nesil 3.70 GHz 20MB  14nm");
                            pcDetailsArrayList.add(pcDetails277);

                            PcDetails pcDetails288 = new PcDetails("Processors","Intel Core i7 10700K Soket 1200 10. Nesil 3.80 GHz 16MB  14nm");
                            pcDetailsArrayList.add(pcDetails288);

                            PcDetails pcDetails299 = new PcDetails("Processors","Intel Core i7 10700KF Soket 1200 10. Nesil 3.80 GHz 16MB 14nm");
                            pcDetailsArrayList.add(pcDetails299);

                            PcDetails pcDetails300 = new PcDetails("Processors","Intel Core i7 10700 Soket 1200 10. Nesil 2.90GHz 16MB  14nm");
                            pcDetailsArrayList.add(pcDetails300);

                            PcDetails pcDetails320 = new PcDetails("Processors","Intel Core i7 10700F Soket 1200 10. Nesil 2.90GHz 16MB  14nm");
                            pcDetailsArrayList.add(pcDetails320);

                            PcDetails pcDetails333 = new PcDetails("Processors","Intel Core i5 10600K Soket 1200 10. Nesil 4.10GHz 12MB 14nm");
                            pcDetailsArrayList.add(pcDetails333);

                            PcDetails pcDetails344 = new PcDetails("Processors","Intel Core i5 10600 Soket 1200 10. Nesil 3.30GHz 12MB 14nm");
                            pcDetailsArrayList.add(pcDetails344);

                            PcDetails pcDetails355 = new PcDetails("Processors","Intel Core i5 10500 Soket 1200 10. Nesil 3.10GHz 12MB 14nm");
                            pcDetailsArrayList.add(pcDetails355);

                            PcDetails pcDetails366 = new PcDetails("Processors","Intel Core i3 10100 Soket 1200 10. Nesil 3.6GHz 6MB  14nm");
                            pcDetailsArrayList.add(pcDetails366);

                            PcDetails pcDetails377= new PcDetails("İProcessors","Intel Core i9 10900X Soket 2066 3.70GHz 19.25MB  14nm");
                            pcDetailsArrayList.add(pcDetails377);

                            PcDetails pcDetails381 = new PcDetails("Processors","AMD Ryzen™5 5500 Soket AM4 4.2 GHz 19MB 65W 7nm ");
                            pcDetailsArrayList.add(pcDetails381);

                            PcDetails pcDetails391 = new PcDetails("Processors","AMD Ryzen™5 5600X Soket AM4 Wraith Stealth 3.7GHz 32MB 65W");
                            pcDetailsArrayList.add(pcDetails391);

                            PcDetails pcDetails401 = new PcDetails("Processors","AMD Ryzen™5 5600 Soket AM4 3.5GHz 32MB 65W 7nm");
                            pcDetailsArrayList.add(pcDetails401);

                            PcDetails pcDetails412 = new PcDetails("Processors","AMD Ryzen™7 5700X Soket AM4 3.4GHz 32MB 65W 7nm ");
                            pcDetailsArrayList.add(pcDetails412);

                            PcDetails pcDetails421 = new PcDetails("Processors","AMD Ryzen™5 4500 Soket AM4 4.1GHz 11MB 165W 7nm ");
                            pcDetailsArrayList.add(pcDetails421);

                            PcDetails pcDetails433 = new PcDetails("Processors","AMD Ryzen™7 5800X Soket AM4 3.8GHz 32MB 105W 7nm ");
                            pcDetailsArrayList.add(pcDetails433);

                            PcDetails pcDetails444 = new PcDetails("Processors","AMD Ryzen™7 5700G Soket AM4 3.8 GHz 20MB 65W 7nm ");
                            pcDetailsArrayList.add(pcDetails444);

                            PcDetails pcDetails456 = new PcDetails("Processors","AMD Ryzen™9 5950X Soket AM4 3.4GHz 64MB 105W 7nm ");
                            pcDetailsArrayList.add(pcDetails456);

                            PcDetails pcDetails467 = new PcDetails("Processors","AMD Ryzen™5 5600G Soket AM4 3.9 GHz 19MB 65W 7nm ");
                            pcDetailsArrayList.add(pcDetails467);

                            PcDetails pcDetails477 = new PcDetails("Processors","AMD Ryzen™7 3800XT Soket AM4 4.7 GHz 36MB 105W 7nm ");
                            pcDetailsArrayList.add(pcDetails477);

                            PcDetails pcDetails488 = new PcDetails("Processors","AMD Ryzen™7 3800X Soket AM4+WraithPrism(RGB) 3.9 GHz");
                            pcDetailsArrayList.add(pcDetails488);  
                                                                   
                            PcDetails pcDetails499 = new PcDetails("Processors","AMD Ryzen™7 3700X Soket AM4+Wraith Prism(RGB) 3.6 GHz");
                            pcDetailsArrayList.add(pcDetails499);


                            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                            adaptorPcDetails = new AdaptorPcDetails(pcDetailsArrayList);
                            recyclerView.setAdapter(adaptorPcDetails);



                            adaptorPcDetails.notifyDataSetChanged();


                        }

                    }

                }


            }
        });





















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