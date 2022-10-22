package com.example.kutaykerem.computerinformaton.Parts;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kutaykerem.computerinformaton.Adaptor.AnaSayfa.AdaptorPcList;
import com.example.kutaykerem.computerinformaton.Adaptor.PcDetails.AdaptorPcDetails;
import com.example.kutaykerem.computerinformaton.Models.PcDetails;
import com.example.kutaykerem.computerinformaton.Models.PcNames;
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


public class AnakartlarFragment extends Fragment  {

    ArrayList<PcDetails> pcDetailsArrayList;


    AdaptorPcDetails adaptorPcDetails;
    RecyclerView recyclerView;
    private Toolbar toolbar;
    private androidx.appcompat.widget.SearchView searchView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_anakartlar, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        pcDetailsArrayList = new ArrayList<>();
        recyclerView = view.findViewById(R.id.recyclerViewAnakartlar);

        toolbar = view.findViewById(R.id.toolbar_anakart);
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

                            PcDetails pcDetails = new PcDetails("Anakartlar","ASUS PRIME H510M-D Intel H510 Soket 1200 DDR4 3200MHz(OC) M.2");
                            pcDetailsArrayList.add(pcDetails);

                            PcDetails pcDetails2 = new PcDetails("Anakartlar","ASUS PRIME B660M-K D4 Intel B660 Soket 1700 DDR4 5333MHz (OC)");
                            pcDetailsArrayList.add(pcDetails2);

                            PcDetails pcDetails3 = new PcDetails("Anakartlar","ASUS PRIME H510M-E Intel H510 Soket 1200 DDR4 3200MHz(OC) M.2");
                            pcDetailsArrayList.add(pcDetails3);

                            PcDetails pcDetails4 = new PcDetails("Anakartlar","ASUS TUF GAMING B550M-PLUS AMD B550 Soket AM4 Ryzen DDR4");
                            pcDetailsArrayList.add(pcDetails4);

                            PcDetails pcDetails5 = new PcDetails("Anakartlar","ASUS PRIME B450M-K II AMD B450 Soket AM4 DDR4 4400MHz(O.C.)");
                            pcDetailsArrayList.add(pcDetails5);

                            PcDetails pcDetails6 = new PcDetails("Anakartlar","ASUS TUF GAMING X570-PLUS (WI-FI) AM4 AMD Ryzen™ DDR4");
                            pcDetailsArrayList.add(pcDetails6);

                            PcDetails pcDetails7 = new PcDetails("Anakartlar","ASUS ROG MAXIMUS Z690 HERO EVA Intel Z690 Soket 1700 DDR5");
                            pcDetailsArrayList.add(pcDetails7);

                            PcDetails pcDetails8 = new PcDetails("Anakartlar","ASUS PRIME B550M-A WIFI II AMD B550 Soket AM4 Ryzen DDR4");
                            pcDetailsArrayList.add(pcDetails8);

                            PcDetails pcDetails9 = new PcDetails("Anakartlar","ASUS TUF GAMING B660M-PLUS D4 Intel B660 Soket DDR4 5333MHz");
                            pcDetailsArrayList.add(pcDetails9);

                            PcDetails pcDetails10 = new PcDetails("Anakartlar","ASUS ROG STRIX B660-G GAMING WIFI Intel B660 Soket 1700 DDR5");
                            pcDetailsArrayList.add(pcDetails10);

                            PcDetails pcDetails11 = new PcDetails("Anakartlar","ASUS PRIME B550-PLUS AMD B550 Soket AM4 Ryzen DDR4 4600MHz");
                            pcDetailsArrayList.add(pcDetails11);

                            PcDetails pcDetails12 = new PcDetails("Anakartlar","ASUS PRIME H410M-A INTEL H410 Soket 1200 DDR4 2933MHz(O.C)");
                            pcDetailsArrayList.add(pcDetails12);

                            PcDetails pcDetails14 = new PcDetails("Anakartlar","ASUS PRIME Z690-P WIFI Intel Z690 Soket 1700 DDR5 6000MHz (OC)");
                            pcDetailsArrayList.add(pcDetails14);

                            PcDetails pcDetails15 = new PcDetails("Anakartlar","ASUS PRIME Z690-P Intel Z690 Soket 1700 128GB DDR5");
                            pcDetailsArrayList.add(pcDetails15);

                            PcDetails pcDetails16 = new PcDetails("Anakartlar","ASUS ROG STRIX GAMING WIFI Z690-E Intel Soket 1700 DDR5");
                            pcDetailsArrayList.add(pcDetails16);

                            PcDetails pcDetails17 = new PcDetails("Anakartlar","ASUS PRIME H610M-E D4 Intel H610 Soket 1700 DDR4 3200MHz");
                            pcDetailsArrayList.add(pcDetails17);

                            PcDetails pcDetails18 = new PcDetails("Anakartlar","ASUS ROG CROSSHAIR VIII DARK HERO X570 AM4 AMD Ryzen DDR4");
                            pcDetailsArrayList.add(pcDetails18);

                            PcDetails pcDetails19 = new PcDetails("Anakartlar","ASUS PRIME A520M-E A520 Soket AM4 AMD Ryzen DDR4 4600MHz");
                            pcDetailsArrayList.add(pcDetails19);

                            PcDetails pcDetails20 = new PcDetails("Anakartlar","ASUS PRIME H610M-K D4 Intel H610 Soket 1700 DDR4 3200MHz");
                            pcDetailsArrayList.add(pcDetails20);

                            PcDetails pcDetails21 = new PcDetails("Anakartlar","ASUS TUF GAMING Z690-PLUS WF D4 Intel Z690 Soket 1700 DDR4");
                            pcDetailsArrayList.add(pcDetails21);

                            PcDetails pcDetails22 = new PcDetails("Anakartlar","ASUS TUF GAMING Z690-PLUS D4 Intel Z690 Soket 1700 DDR4");
                            pcDetailsArrayList.add(pcDetails22);

                            PcDetails pcDetails23 = new PcDetails("Anakartlar","ASUS ROGSTRIX Z690-A GAMING WIFI D4 Intel Z690 Soket 1700 DDR4");
                            pcDetailsArrayList.add(pcDetails23);

                            PcDetails pcDetails24 = new PcDetails("Anakartlar","ASUS B450M-DRAGON AMD B450 Soket AM4 4400MHz(O.C.) M.2");
                            pcDetailsArrayList.add(pcDetails24);

                            PcDetails pcDetails25 = new PcDetails("Anakartlar","ASUS PRIME H510M-A Intel H510 Soket 1200 DDR4 3200MHz(OC) M.2");
                            pcDetailsArrayList.add(pcDetails25);

                            PcDetails pcDetails26 = new PcDetails("Anakartlar","ASUS TUF GAMING B550-PLUS WF AMD B550 Soket AM4 Ryzen DDR4");
                            pcDetailsArrayList.add(pcDetails26);

                            PcDetails pcDetails27 = new PcDetails("Anakartlar","ASUS PRIME B550-PLUS AMD B550 Soket AM4 Ryzen DDR4 4600MHz");
                            pcDetailsArrayList.add(pcDetails27);

                            PcDetails pcDetails28 = new PcDetails("Anakartlar","ASUS PRIME H410M-A INTEL H410 Soket 1200 DDR4 2933MHz(O.C)");
                            pcDetailsArrayList.add(pcDetails28);

                            PcDetails pcDetails29 = new PcDetails("Anakartlar","ASUS PRIME Z690-P WIFI Intel Z690 Soket 1700 DDR5 6000MHz (OC)");
                            pcDetailsArrayList.add(pcDetails29);

                            PcDetails pcDetails30 = new PcDetails("Anakartlar","ASUS ROG STRIX GAMING WIFI Z690-E Intel Soket 1700 DDR5");
                            pcDetailsArrayList.add(pcDetails30);

                            PcDetails pcDetails31 = new PcDetails("Anakartlar","ASUS ROGSTRIX Z690-A GAMING WIFI Intel Z690 Soket 1700 DDR5");
                            pcDetailsArrayList.add(pcDetails31);

                            PcDetails pcDetails32 = new PcDetails("Anakartlar","ASUS TUF GAMING Z690-PLUS WIFI Intel Z690 Soket 1700 DDR5");
                            pcDetailsArrayList.add(pcDetails32);

                            PcDetails pcDetails33 = new PcDetails("Anakartlar","ASUS TUF GAMING Z690-PLUS Intel Z690 Soket 1700 DDR5 6000MHz");
                            pcDetailsArrayList.add(pcDetails33);

                            PcDetails pcDetails34 = new PcDetails("Anakartlar","ASUS ROG MAXIMUS Z690 FORMULA Intel Z690 Soket 1700");
                            pcDetailsArrayList.add(pcDetails34);

                            PcDetails pcDetails35 = new PcDetails("Anakartlar","ASUS TUF GAMING B660M-PLUS WIFI Intel B660 Soket 1700 DDR5");
                            pcDetailsArrayList.add(pcDetails35);

                            PcDetails pcDetails36 = new PcDetails("Anakartlar","ASUS ROG STRIX B660-A GAMING WF Intel Soket 1700 DDR5 6000MHz");
                            pcDetailsArrayList.add(pcDetails36);

                            PcDetails pcDetails37 = new PcDetails("Anakartlar","ASUS TUF GAMING B660M-PLUS WIFI D4 Intel B660 Soket DDR4");
                            pcDetailsArrayList.add(pcDetails37);

                            PcDetails pcDetails38 = new PcDetails("Anakartlar","ASUS PRIME B660-PLUS D4 Intel B660 Soket 1700 DDR4 5066MHz");
                            pcDetailsArrayList.add(pcDetails38);

                            PcDetails pcDetails39 = new PcDetails("Anakartlar","ASUS PRIME B660M-A WIFI D4 Intel B660 Soket 1700 DDR4 3200MHz");
                            pcDetailsArrayList.add(pcDetails39);

                            PcDetails pcDetails40 = new PcDetails("Anakartlar","ASUS ROG STRIX B660-A GAMING WF Intel B660 Soket 1700 DDR4");
                            pcDetailsArrayList.add(pcDetails40);

                            PcDetails pcDetails41 = new PcDetails("Anakartlar","ASUS PRIME Z690-P D4 Intel Z690 Soket 1700128GB DDR4 5333MHz");
                            pcDetailsArrayList.add(pcDetails41);

                            PcDetails pcDetails42 = new PcDetails("Anakartlar","ASUS TUF GAMING H670-PRO WIFI D4 Intel Soket 1700 DDR4 3200MHz");
                            pcDetailsArrayList.add(pcDetails42);

                            PcDetails pcDetails43 = new PcDetails("Anakartlar","ASUS TUF GAMING B660-PLUS WIFI D4 Intel Soket 1700 DDR4");
                            pcDetailsArrayList.add(pcDetails43);

                            PcDetails pcDetails44 = new PcDetails("Anakartlar","ASUS TUF GAMING B660M-E D4 Intel B660 Soket 1700 DDR4");
                            pcDetailsArrayList.add(pcDetails44);

                            PcDetails pcDetails45 = new PcDetails("Anakartlar","ASUS PROART B660-CREATOR D4 Intel B660 Soket 1700 DDR4");
                            pcDetailsArrayList.add(pcDetails45);

                            PcDetails pcDetails46 = new PcDetails("Anakartlar","ASUS PRIME H670-PLUS D4 Intel H570 Soket 1700 DDR4 2933MHz");
                            pcDetailsArrayList.add(pcDetails46);

                            PcDetails pcDetails47 = new PcDetails("Anakartlar","ASUS PRIME H610M-D D4 Intel H610 Soket 1700 DDR4 3200MHz");
                            pcDetailsArrayList.add(pcDetails47);

                            PcDetails pcDetails48 = new PcDetails("Anakartlar","ASUS PRIME H610M-A D4 Intel H610 Soket 1700 DDR4 3200MHz");
                            pcDetailsArrayList.add(pcDetails48);

                            PcDetails pcDetails49 = new PcDetails("Anakartlar","ASUS PRIME B660M-A D4 Intel B660 Soket 1700 DDR4 3200MHz (OC)");
                            pcDetailsArrayList.add(pcDetails49);

                            PcDetails pcDetails50 = new PcDetails("Anakartlar","ASUS ROG CROSSHAIR VIII FORMULA X570 AMD Soket AM4");
                            pcDetailsArrayList.add(pcDetails50);

                            PcDetails pcDetails51 = new PcDetails("Anakartlar","ASUS ROG STRIX Z690-G GAMING WIFI Intel Z690 Soket 1700 DDR5");
                            pcDetailsArrayList.add(pcDetails51);

                            PcDetails pcDetails52 = new PcDetails("Anakartlar","ASUS PRIME Z690-P WIFI D4 Intel PRIME Z690-P Soket 1700 DDR4");
                            pcDetailsArrayList.add(pcDetails52);

                            PcDetails pcDetails53 = new PcDetails("Anakartlar","ASUS ROG STRIX Z690-F GAMING WF Intel Z690 Soket 1700 DDR5");
                            pcDetailsArrayList.add(pcDetails53);

                            PcDetails pcDetails54 = new PcDetails("Anakartlar","ASUS PRIME Z690M-PLUS D4 Intel Z690 Soket 1700 DDR4 5333MHz");
                            pcDetailsArrayList.add(pcDetails54);

                            PcDetails pcDetails55 = new PcDetails("Anakartlar","ASUS PRIME Z690-A Intel Z690 Soket 1700 DDR5 6000MHz (OC)");
                            pcDetailsArrayList.add(pcDetails55);

                            PcDetails pcDetails56 = new PcDetails("Anakartlar","ASUS ProArt X570-CREATOR WIFI AMD X570 AM4 Soket DDR4");
                            pcDetailsArrayList.add(pcDetails56);

                            PcDetails pcDetails57 = new PcDetails("Anakartlar","ASUS PRIME B460I-PLUS INTEL B460 Soket 1200 DDR4");
                            pcDetailsArrayList.add(pcDetails57);

                            PcDetails pcDetails58 = new PcDetails("Anakartlar","ASUS EX-H510M-V3 INTEL H510 Soket 1200 DDR4 3200MHz(O.C)");
                            pcDetailsArrayList.add(pcDetails58);

                            PcDetails pcDetails59 = new PcDetails("Anakartlar","ASUS TUF GAMING A520M PLUS II Soket AM4 AMD Ryzen DDR4");
                            pcDetailsArrayList.add(pcDetails59);

                            PcDetails pcDetails60 = new PcDetails("Anakartlar","ASUS TUF GAMING A520M PLUS WIFI Soket AM4 AMD Ryzen DDR4");
                            pcDetailsArrayList.add(pcDetails60);

                            PcDetails pcDetails61 = new PcDetails("Anakartlar","ASUS TUF GAMING B560M-E Intel B560 Soket 1200 DDR4 5000MHz");
                            pcDetailsArrayList.add(pcDetails61);

                            PcDetails pcDetails62 = new PcDetails("Anakartlar","ASUS PRIME A520M-A II A520 Soket AM4 AMD Ryzen DDR4 4800MHz4");
                            pcDetailsArrayList.add(pcDetails62);


                            PcDetails pcDetails64 = new PcDetails("Anakartlar","ASUS PRIME B560M-K Intel B560 Soket 1200 DDR4 4800MHz(OC) M.2");
                            pcDetailsArrayList.add(pcDetails64);

                            PcDetails pcDetails65 = new PcDetails("Anakartlar","ASUS PRIME B560M-A Intel B560 Soket 1200 DDR4 5000MHz(OC) M.2");
                            pcDetailsArrayList.add(pcDetails65);

                            PcDetails pcDetails66 = new PcDetails("Anakartlar","ASUS PRIME H570M-PLUS Intel H570 Soket 1200 DDR4 4600MHz");
                            pcDetailsArrayList.add(pcDetails66);

                            PcDetails pcDetails67 = new PcDetails("Anakartlar","ASUS PRIME Z590-P Intel Z590 Soket 1200 DDR4 5133MHz(OC) M.2");
                            pcDetailsArrayList.add(pcDetails67);

                            PcDetails pcDetails68 = new PcDetails("Anakartlar","ASUS TUF GAMING Z590-PLUS Intel Z590 Soket 1200 DDR4");
                            pcDetailsArrayList.add(pcDetails68);

                            PcDetails pcDetails69 = new PcDetails("Anakartlar","ASUS ROG MAXIMUS XIII EXTREME Intel Z590 Soket 1200");
                            pcDetailsArrayList.add(pcDetails69);

                            PcDetails pcDetails70 = new PcDetails("Anakartlar","ASUS ROG STRIX B550 - XE GAMING WF AM4 Soket AMD Ryzen");
                            pcDetailsArrayList.add(pcDetails70);

                            PcDetails pcDetails71 = new PcDetails("Anakartlar","ASUS TUF GAMING B450-PLUS II AMD B450 Soket AM4 Ryzen DDR4");
                            pcDetailsArrayList.add(pcDetails71);

                            PcDetails pcDetails72 = new PcDetails("Anakartlar","ASUS ROG CROSSHAIR VIII HERO WF AMD X570 AM4 Ryzen DDR4");
                            pcDetailsArrayList.add(pcDetails72);

                            PcDetails pcDetails73 = new PcDetails("Anakartlar","ASUS PRIME B450M-A II AMD B450 Soket AM4 DDR4 4400MHz(O.C.)");
                            pcDetailsArrayList.add(pcDetails73);

                            PcDetails pcDetails74 = new PcDetails("Anakartlar","ASUS TUF GAMING B450M-PLUS II AMD B450 Soket AM4 DDR4");
                            pcDetailsArrayList.add(pcDetails74);

                            PcDetails pcDetails75 = new PcDetails("Anakartlar","ASUS TUF GAMING X570-PRO (WI-FI) AM4 X570 AM4 DDR4 5100MHz");
                            pcDetailsArrayList.add(pcDetails75);

                            PcDetails pcDetails76 = new PcDetails("Anakartlar","ASUS TUF GAMING A520M-PLUS A520 Soket AM4 AMD Ryzen DDR4");
                            pcDetailsArrayList.add(pcDetails76);

                            PcDetails pcDetails77 = new PcDetails("Anakartlar","ASUS PRIME A520M-K A520 Soket AM4 AMD Ryzen DDR4 4600MHz");
                            pcDetailsArrayList.add(pcDetails77);

                            PcDetails pcDetails78 = new PcDetails("Anakartlar","ASUS TUF GAMING B450M-PRO S Amd B450 AM4 Soket DDR4");
                            pcDetailsArrayList.add(pcDetails78);

                            PcDetails pcDetails79 = new PcDetails("Anakartlar","ASUS PRIME B550M-A (WI-FI) AMD B550 Soket AM4 Ryzen DDR4");
                            pcDetailsArrayList.add(pcDetails79);

                            PcDetails pcDetails80 = new PcDetails("Anakartlar","ASUS PRIME B460M-K INTEL B460 Soket 1200 DDR4 2933MHz(O.C)");
                            pcDetailsArrayList.add(pcDetails80);

                            PcDetails pcDetails81 = new PcDetails("Anakartlar","ASUS TUF H310M PLUS R2.0 Intel H310M Socket .1151 DDR4");
                            pcDetailsArrayList.add(pcDetails81);

                            PcDetails pcDetails82 = new PcDetails("Anakartlar","ASUS PRIME H310M-F R2.0 Intel H310 Socket  1151 DDR4");
                            pcDetailsArrayList.add(pcDetails82);

                            PcDetails pcDetails83 = new PcDetails("Anakartlar","ASUS ROG CROSSHAIR VIII IMPACT AMD X570 AM4 Ryzen");
                            pcDetailsArrayList.add(pcDetails83);

                            PcDetails pcDetails84 = new PcDetails("Anakartlar","ASUS PRIME A320M-F A320 AM4 AMD Ryzen™ DDR4 3200(O.C.) MHz");
                            pcDetailsArrayList.add(pcDetails84);

                            PcDetails pcDetails85 = new PcDetails("Anakartlar","ASUS PRIME X570-P AMD X570 AM4 Ryzen DDR4 4400MHz (O.C.)");
                            pcDetailsArrayList.add(pcDetails85);

                            PcDetails pcDetails86 = new PcDetails("Anakartlar","ASUS ROG STRIX X570-F GAMING AMD X570 AM4 Ryzen DDR4");
                            pcDetailsArrayList.add(pcDetails86);

                            PcDetails pcDetails87 = new PcDetails("Anakartlar","ASUS PRIME H310M-K R2.0 Intel H310 Socket  1151 DDR4");
                            pcDetailsArrayList.add(pcDetails87);

                            PcDetails pcDetails88 = new PcDetails("Anakartlar","ASUS PRIME B365M-K Intel B365 Soket  1151 DDR4");
                            pcDetailsArrayList.add(pcDetails88);

                            PcDetails pcDetails89 = new PcDetails("Anakartlar","ASUS TUF B450M-PRO GAMING AMD B450 Socket AM4 Ryzen DDR4");
                            pcDetailsArrayList.add(pcDetails89);

                            PcDetails pcDetails90 = new PcDetails("Anakartlar","ASUS TUF B450-PRO GAMING AMD B450 Socket AM4 Ryzen DDR4");
                            pcDetailsArrayList.add(pcDetails90);

                            PcDetails pcDetails91 = new PcDetails("Anakartlar","ASUS TUF B450M-PLUS GAMING AMD B450 AM4 Ryzen™ DDR4");
                            pcDetailsArrayList.add(pcDetails91);

                            PcDetails pcDetails92 = new PcDetails("Anakartlar","ASUS TUF B450-PLUS GAMING AMD B450 Soket AM4 Ryzen™");
                            pcDetailsArrayList.add(pcDetails92);

                            PcDetails pcDetails93 = new PcDetails("Anakartlar","ASUS PRIME A320M-E A320 AM4 AMD Ryzen™ DDR4 3200(O.C.) MHz");
                            pcDetailsArrayList.add(pcDetails93);

                            PcDetails pcDetails94 = new PcDetails("Anakartlar","ASUS EX-A320M-GAMING A320 Socket AM4 AMD Ryzen™DDR4");
                            pcDetailsArrayList.add(pcDetails94);

                            PcDetails pcDetails95 = new PcDetails("Anakartlar","ASUS PRIME A320M-K A320 AM4 AMD Ryzen™ DDR4 3200(O.C.) MHz");
                            pcDetailsArrayList.add(pcDetails95);




                            //GIGABYTE

                            PcDetails pcDetails96 = new PcDetails("Anakartlar","GIGABYTE H510M H UD Intel H510 Soket 1200 DDR4 3200MHz M.2");
                            pcDetailsArrayList.add(pcDetails96);

                            PcDetails pcDetails97 = new PcDetails("Anakartlar","GIGABYTE H610M H 3200MHz DDR4 Soket 1700 M.2 HDMI D-Sub");
                            pcDetailsArrayList.add(pcDetails97);

                            PcDetails pcDetails98 = new PcDetails("Anakartlar","GIGABYTE H610M H 3200MHz DDR4 Soket 1700 M.2 HDMI D-Sub");
                            pcDetailsArrayList.add(pcDetails98);

                            PcDetails pcDetails99 = new PcDetails("Anakartlar","GIGABYTE B550 AORUS PRO AC Amd B550 Soket AM4 DDR4");
                            pcDetailsArrayList.add(pcDetails99);

                            PcDetails pcDetails100 = new PcDetails("Anakartlar","GIGABYTE B560M H 3200MHz (O.C) DDR4 Soket 1200 M.2 HDMI D-Sub");
                            pcDetailsArrayList.add(pcDetails100);

                            PcDetails pcDetails101 = new PcDetails("Anakartlar","GIGABYTE Z690 ULTRA DURABLE Intel Soket 1700 DDR5 6000MHz (O.C) M.2");
                            pcDetailsArrayList.add(pcDetails101);

                            PcDetails pcDetails102 = new PcDetails("Anakartlar","GIGABYTE B450M H UD AMD B450 Soket AM4 DDR4 3600MHZ (O.C)");
                            pcDetailsArrayList.add(pcDetails102);

                            PcDetails pcDetails103 = new PcDetails("Anakartlar","GIGABYTE H310M H Intel H310 Soket 8.-9. Nesil 1151 DDR4");
                            pcDetailsArrayList.add(pcDetails103);

                            PcDetails pcDetails104 = new PcDetails("Anakartlar","GIGABYTE Z590 GAMING X Intel Z590 Soket 1200 DDR4 5333(O.C)");
                            pcDetailsArrayList.add(pcDetails104);

                            PcDetails pcDetails105 = new PcDetails("Anakartlar","GIGABYTE B460M GAMING HD Intel B460 Soket 1200 DDR4 2933MHz");
                            pcDetailsArrayList.add(pcDetails105);

                            PcDetails pcDetails106 = new PcDetails("Anakartlar","GIGABYTE Z590 AORUS MASTER Intel Z590 Soket 1200 DDR4");
                            pcDetailsArrayList.add(pcDetails106);

                            PcDetails pcDetails107 = new PcDetails("Anakartlar","GIGABYTE B450M S2H V2 AMD B450 Socket AM4 DDR4");
                            pcDetailsArrayList.add(pcDetails107);

                            PcDetails pcDetails108 = new PcDetails("Anakartlar","GIGABYTE GA-A520M-S2H AMD A520 Soket AM4 DDR4 5100MHz");
                            pcDetailsArrayList.add(pcDetails108);

                            PcDetails pcDetails109 = new PcDetails("Anakartlar","GIGABYTE B460M D2V Intel B460M Soket 1200 DDR4 2933MHz M.2");
                            pcDetailsArrayList.add(pcDetails109);

                            PcDetails pcDetails110 = new PcDetails("Anakartlar","GIGABYTE Z490I AORUS ULTRA Intel Z490 Soket 1200 DDR4");
                            pcDetailsArrayList.add(pcDetails110);

                            PcDetails pcDetails111 = new PcDetails("Anakartlar","GIGABYTE B550 GAMING X Amd B550 Soket AM4 DDR4 4000MHz");
                            pcDetailsArrayList.add(pcDetails111);

                            PcDetails pcDetails112 = new PcDetails("Anakartlar","GIGABYTE H310M H 2.0 Intel H310 Socket 8.-9. Nesil 1151 DDR4");
                            pcDetailsArrayList.add(pcDetails112);

                            PcDetails pcDetails113 = new PcDetails("Anakartlar","GIGABYTE GA-A320M-S2H A320 Socket AM4 AMD Ryzen™ DDR4");
                            pcDetailsArrayList.add(pcDetails113);




                            //Msi


                            PcDetails pcDetails1143 = new PcDetails("Anakartlar","MSI PRO H610M-B DDR4 Intel H610 Soket 1700 3200MHz (OC) M.2");
                            pcDetailsArrayList.add(pcDetails1143);

                            PcDetails pcDetails114 = new PcDetails("Anakartlar","MSI B450M-A PRO MAX Amd B450 Soket AM4 DDR4 3466(OC) M.2");
                            pcDetailsArrayList.add(pcDetails114);

                            PcDetails pcDetails115 = new PcDetails("Anakartlar","MSI H510M-A PRO Intel H510 Soket 1200 DDR4 3200MHz (OC) M.2");
                            pcDetailsArrayList.add(pcDetails115);

                            PcDetails pcDetails116 = new PcDetails("Anakartlar","MSI H310M PRO-VDH PLUS Intel H310 Soket 1151 DDR4 2666 ");
                            pcDetailsArrayList.add(pcDetails116);

                            PcDetails pcDetails117 = new PcDetails("Anakartlar","MSI PRO H410M-B Intel H410 Soket 1200 DDR4 2933MHz M.2 ");
                            pcDetailsArrayList.add(pcDetails117);

                            PcDetails pcDetails118 = new PcDetails("Anakartlar","MSI MAG B460M BAZOOKA Intel B460 Soket 1200 DDR4 2933MHz");
                            pcDetailsArrayList.add(pcDetails118);

                            PcDetails pcDetails119 = new PcDetails("Anakartlar","MSI B550M-A PRO Amd B550 Soket AM4 DDR4 4600(O.C.) M.2 ");
                            pcDetailsArrayList.add(pcDetails119);

                            PcDetails pcDetails200 = new PcDetails("Anakartlar","MSI PRO Z690-A Intel Z690 Soket 1700 DDR4 5200MHz (OC) M.2");
                            pcDetailsArrayList.add(pcDetails200);

                            PcDetails pcDetails201 = new PcDetails("Anakartlar","MSI MEG Z590 UNIFY Intel Z590 Soket 1200 DDR4 5600(O.C.) M.2");
                            pcDetailsArrayList.add(pcDetails201);

                            PcDetails pcDetails202 = new PcDetails("Anakartlar","MSI MEG Z590 ACE Intel Z590 Soket 1200 DDR4 5600(O.C.) M.2");
                            pcDetailsArrayList.add(pcDetails202);

                            PcDetails pcDetails203 = new PcDetails("Anakartlar","MSI B550-A PRO Amd B550 Soket AM4 DDR4 4400MHz M.2 ");
                            pcDetailsArrayList.add(pcDetails203);

                            PcDetails pcDetails204 = new PcDetails("Anakartlar","MSI MAG B660 TOMAHAWK WIFI DDR4 Intel B660 Soket 1700 DDR4");
                            pcDetailsArrayList.add(pcDetails204);

                            PcDetails pcDetails205 = new PcDetails("Anakartlar","MSI PRO Z690-A WIFI Intel Z690 Soket 1700 DDR5 6400MHz (OC)");
                            pcDetailsArrayList.add(pcDetails205);

                            PcDetails pcDetails206 = new PcDetails("Anakartlar","MSI MEG Z590 ACE GOLD EDITION Intel Z590 Soket 1200 DDR4");
                            pcDetailsArrayList.add(pcDetails206);

                            PcDetails pcDetails207 = new PcDetails("Anakartlar","MSI MPG Z590 GAMING PLUS Intel Z590 Soket 1200 DDR4 5333MHz");
                            pcDetailsArrayList.add(pcDetails207);

                            PcDetails pcDetails208 = new PcDetails("Anakartlar","MSI H310M PRO-M2 PLUS Intel H310 Soket 1151 DDR4 2666 M.2");
                            pcDetailsArrayList.add(pcDetails208);

                            PcDetails pcDetails209 = new PcDetails("Anakartlar","MSI MPG B550 GAMING PLUS Amd B550 Soket AM4 DDR4 4400(OC)");
                            pcDetailsArrayList.add(pcDetails209);

                            PcDetails pcDetails210 = new PcDetails("Anakartlar","MSI MPG Z690 EDGE WIFI Intel Z690 Soket 1700 DDR5 6400MHz");
                            pcDetailsArrayList.add(pcDetails210);

                            PcDetails pcDetails211 = new PcDetails("Anakartlar","MSI PRO H610M-G Intel H610 Soket 1700 DDR4 3200MHz (OC) M.2");
                            pcDetailsArrayList.add(pcDetails211);

                            PcDetails pcDetails212 = new PcDetails("Anakartlar","MSI PRO B660M-E Intel B660 Soket 1700 DDR4 4600MHz (OC) M.2");
                            pcDetailsArrayList.add(pcDetails212);

                            PcDetails pcDetails213 = new PcDetails("Anakartlar","MSI PRO B660M-B Intel B660 Soket 1700 DDR4 4600MHz (OC) M.2");
                            pcDetailsArrayList.add(pcDetails213);

                            PcDetails pcDetails224 = new PcDetails("Anakartlar","MSI PRO B660M-A WIFI Intel B660 Soket 1700 DDR4 4800MHz (OC)");
                            pcDetailsArrayList.add(pcDetails224);

                            PcDetails pcDetails234 = new PcDetails("Anakartlar","MSI MAG B660M MORTAR WIFI Intel B660 Soket 1700 DDR5 6200MHz");
                            pcDetailsArrayList.add(pcDetails234);

                            PcDetails pcDetails244 = new PcDetails("Anakartlar","MSI MPG Z690 EDGE WIFI Intel Z690 Soket 1700 DDR4 5200MHz");
                            pcDetailsArrayList.add(pcDetails244);

                            PcDetails pcDetails255 = new PcDetails("Anakartlar","MSI H510M PRO Intel H510 Soket 1200 DDR4 3200MHz (OC) M.2");
                            pcDetailsArrayList.add(pcDetails255);

                            PcDetails pcDetails266 = new PcDetails("Anakartlar","MSI MPG Z590 GAMING EDGE WIFI Intel Z590 Soket 1200 DDR4");
                            pcDetailsArrayList.add(pcDetails266);

                            PcDetails pcDetails277 = new PcDetails("Anakartlar","MSI B460M PRO-VDH Intel B460 Solet 1200 DDR4 2933(O.C.) M.2");
                            pcDetailsArrayList.add(pcDetails277);

                            PcDetails pcDetails288 = new PcDetails("Anakartlar","MSI MAG B460 TORPEDO Soket 1200 DDR4 2933(O.C.) M.2");
                            pcDetailsArrayList.add(pcDetails288);

                            PcDetails pcDetails299 = new PcDetails("Anakartlar","MSI MPG B550 GAMING CARBON WIFI Amd B550 Soket AM4 DDR4 5100(O.C.) M.2");
                            pcDetailsArrayList.add(pcDetails299);

                            PcDetails pcDetails300 = new PcDetails("Anakartlar","MSI B460M-A PRO Intel B460 Soket 1200 DDR4 2933(OC) M.2 ");
                            pcDetailsArrayList.add(pcDetails300);

                            PcDetails pcDetails320 = new PcDetails("Anakartlar","MSI B450M PRO-M2 MAX Amd B450 Soket AM4 DDR4 3466(OC) M.2");
                            pcDetailsArrayList.add(pcDetails320);

                            PcDetails pcDetails333 = new PcDetails("Anakartlar","MSI A320M-A PRO Amd A320 Soket AM4 DDR4 3200(OC) ");
                            pcDetailsArrayList.add(pcDetails333);

                            PcDetails pcDetails344 = new PcDetails("Anakartlar","MSI H610M BOMBER DDR4 3200MHz(OC) Soket 1700 M.2 HDMI");
                            pcDetailsArrayList.add(pcDetails344);

                            PcDetails pcDetails355 = new PcDetails("Anakartlar","MSI PRO B660M-P WIFI DDR4 Intel B660 Soket 1700 DDR4 4600MHz");
                            pcDetailsArrayList.add(pcDetails355);

                            PcDetails pcDetails366 = new PcDetails("Anakartlar","MSI B660 BOMBER DDR4 4600MHz (OC) DDR4 Soket 1700 M.2 HDMI");
                            pcDetailsArrayList.add(pcDetails366);

                            PcDetails pcDetails377= new PcDetails("Anakartlar","MSI PRO B660M-P DDR4 Intel B660 Soket 1700 DDR4 4600MHz (OC) M.2");
                            pcDetailsArrayList.add(pcDetails377);

                            PcDetails pcDetails381 = new PcDetails("Anakartlar","MSI PRO B550M-P GEN3 B550 Soket AM4 DDR4 4400MHz (OC) M.2");
                            pcDetailsArrayList.add(pcDetails381);

                            PcDetails pcDetails391 = new PcDetails("Anakartlar","MSI PRO B550-P GEN3 B550 Soket AM4 DDR4 4400MHz (OC) M.2");
                            pcDetailsArrayList.add(pcDetails391);

                            PcDetails pcDetails401 = new PcDetails("Anakartlar","MSI H510I PRO WIFI 3200MHz DDR4 Soket 1200 M.2 HDMI mITX");
                            pcDetailsArrayList.add(pcDetails401);

                            PcDetails pcDetails412 = new PcDetails("Anakartlar","MSI MAG B660M BAZOOKA 4800MHz(OC) DDR4 Soket 1700 M.2");
                            pcDetailsArrayList.add(pcDetails412);

                            PcDetails pcDetails421 = new PcDetails("Anakartlar","MSI PRO B660-A Intel B660 Soket 1700 DDR4 4800MHz (OC) M.2");
                            pcDetailsArrayList.add(pcDetails421);

                            PcDetails pcDetails433 = new PcDetails("Anakartlar","MSI PRO B660M-A WIFI Intel B660 Soket 1700 DDR5 6200MHz (OC)");
                            pcDetailsArrayList.add(pcDetails433);

                            PcDetails pcDetails444 = new PcDetails("Anakartlar","MSI MAG H670 TOMAHAWK WIFI Intel H670 Soket 1700 DDR4");
                            pcDetailsArrayList.add(pcDetails444);

                            PcDetails pcDetails456 = new PcDetails("Anakartlar","MSI PRO B660M-A DDR4 Intel B660 Soket 1700 DDR4 4600MHz (OC)");
                            pcDetailsArrayList.add(pcDetails456);

                            PcDetails pcDetails467 = new PcDetails("Anakartlar","MSI PRO B660M-A DDR4 Intel B660 Soket 1700 DDR4 4600MHz (OC)");
                            pcDetailsArrayList.add(pcDetails467);

                            PcDetails pcDetails477 = new PcDetails("Anakartlar","MSI MAG Z690 TOMAHAWK WIFI Intel Z690 Soket 1700 DDR5");
                            pcDetailsArrayList.add(pcDetails477);

                            PcDetails pcDetails488 = new PcDetails("Anakartlar","MSI PRO B660M-G Intel B660 Soket 1700 DDR4 4600MHz (OC) M.2");
                            pcDetailsArrayList.add(pcDetails488);

                            PcDetails pcDetails499 = new PcDetails("Anakartlar","MSI MAG B660M MORTAR Intel B660 Soket 1700 DDR5 6200MHz");
                            pcDetailsArrayList.add(pcDetails499);

                            PcDetails pcDetails501 = new PcDetails("Anakartlar","MSI MAG B660 TOMAHAWK WIFI Intel B660 Soket 1700 DDR5");
                            pcDetailsArrayList.add(pcDetails501);

                            PcDetails pcDetails511 = new PcDetails("Anakartlar","MSI MAG Z690M MORTAR WIFI Intel Z690 Soket 1700 DDR5 6200MHz");
                            pcDetailsArrayList.add(pcDetails511);

                            PcDetails pcDetails512 = new PcDetails("Anakartlar","MSI MAG B660M MORTAR DDR4 Intel B660 Soket 1700 DDR4");
                            pcDetailsArrayList.add(pcDetails512);

                            PcDetails pcDetails513 = new PcDetails("Anakartlar","MSI MAG B660M MORTAR WIFI DDR4 Intel B660 Soket 1700 DDR4");
                            pcDetailsArrayList.add(pcDetails513);

                            PcDetails pcDetails514 = new PcDetails("Anakartlar","MSI H510M PRO-E Intel H510 Soket 1200 DDR4 3200MHz (OC) ");
                            pcDetailsArrayList.add(pcDetails514);

                            PcDetails pcDetails515 = new PcDetails("Anakartlar","MSI PRO Z690-P DDR4 Intel Z690 Soket 1700 DDR4 5200MHz(OC) M.2");
                            pcDetailsArrayList.add(pcDetails515);

                            PcDetails pcDetails516 = new PcDetails("Anakartlar","MSI MAG Z690 TORPEDO Intel Z690 Soket 1700 DDR5 6400MHz(OC)");
                            pcDetailsArrayList.add(pcDetails516);

                            PcDetails pcDetails517 = new PcDetails("Anakartlar","MSI MAG Z690 TOMAHAWK WIFI DDR4 Intel Z690 Soket 1700 DDR4");
                            pcDetailsArrayList.add(pcDetails517);

                            PcDetails pcDetails518 = new PcDetails("Anakartlar","MSI MEG X570S UNIFY-X MAX Amd X570 Soket AM4 DDR4");
                            pcDetailsArrayList.add(pcDetails518);

                            PcDetails pcDetails519 = new PcDetails("Anakartlar","MSI PRO Z690-A WIFI Intel Z690 Soket 1700 DDR4 5200MHz (OC)");
                            pcDetailsArrayList.add(pcDetails519);

                            PcDetails pcDetails610 = new PcDetails("Anakartlar","MSI PRO Z690-A Intel Z690 Soket 1700 DDR5 6400MHz (OC) M.2");
                            pcDetailsArrayList.add(pcDetails610);

                            PcDetails pcDetails611 = new PcDetails("Anakartlar","MSI MPG Z690 FORCE WIFI Intel Z690 Soket 1700 DDR5 6666MHz");
                            pcDetailsArrayList.add(pcDetails611);

                            PcDetails pcDetails621 = new PcDetails("Anakartlar","MSI MPG Z690 CARBON WIFI Intel Z690 Soket 1700 DDR5 6666MHz");
                            pcDetailsArrayList.add(pcDetails621);

                            PcDetails pcDetails631 = new PcDetails("Anakartlar","MSI B560-A PRO Intel B560 Soket 1200 DDR4 5066MHz (OC) M.2");
                            pcDetailsArrayList.add(pcDetails631);

                            PcDetails pcDetails642 = new PcDetails("Anakartlar","MSI MPG X570S CARBON MAX WIFI Amd X570 Soket AM4 DDR4");
                            pcDetailsArrayList.add(pcDetails642);

                            PcDetails pcDetails652 = new PcDetails("Anakartlar","MSI MPG X570S EDGE MAX WIFI Amd X570 Soket AM4 DDR4");
                            pcDetailsArrayList.add(pcDetails652);

                            PcDetails pcDetails662 = new PcDetails("Anakartlar","MSI MEG X570S ACE MAX Amd X570 Soket AM4 DDR4 5300MHz");
                            pcDetailsArrayList.add(pcDetails662);

                            PcDetails pcDetails671 = new PcDetails("Anakartlar","MSI MAG X570S TORPEDO MAX Amd X570 Soket AM4 DDR4");
                            pcDetailsArrayList.add(pcDetails671);

                            PcDetails pcDetails681 = new PcDetails("Anakartlar","MSI MAG X570S TOMAHAWK MAX WIFI Amd X570 Soket AM4 DDR4");
                            pcDetailsArrayList.add(pcDetails681);

                            PcDetails pcDetails691 = new PcDetails("Anakartlar","MSI A320M PRO-VH Amd A320 Soket AM4 DDR4 3200(OC) M.2");
                            pcDetailsArrayList.add(pcDetails691);

                            PcDetails pcDetails710 = new PcDetails("Anakartlar","MSI MAG B560 TORPEDO Intel B560 Soket 1200 DDR4 5066MHz (OC)");
                            pcDetailsArrayList.add(pcDetails710);

                            PcDetails pcDetails711 = new PcDetails("Anakartlar","MSI MAG B560M MORTAR Intel B560 Soket 1200 DDR4 5066MHz");
                            pcDetailsArrayList.add(pcDetails711);

                            PcDetails pcDetails721 = new PcDetails("Anakartlar","MSI MAG B560 TOMAHAWK WIFI Intel B560 Soket 1200 DDR4");
                            pcDetailsArrayList.add(pcDetails721);

                            PcDetails pcDetails713 = new PcDetails("Anakartlar","MSI Z590 PLUS Intel Z590 Soket 1200 DDR4 5333MHz (OC) M.2 ");
                            pcDetailsArrayList.add(pcDetails713);

                            PcDetails pcDetails714 = new PcDetails("Anakartlar","MSI MAG Z590 TOMAHAWK WIFI Intel Z590 Soket 1200 DDR4");
                            pcDetailsArrayList.add(pcDetails714);

                            PcDetails pcDetails715 = new PcDetails("Anakartlar","MSI B450 TOMAHAWK MAX II Amd B450 Soket AM4 DDR4 4333MHz");
                            pcDetailsArrayList.add(pcDetails715);

                            PcDetails pcDetails716 = new PcDetails("Anakartlar","MSI B560M PRO WIFI Intel B560 Soket 1200 DDR4 5200MHz (OC)");
                            pcDetailsArrayList.add(pcDetails716);

                            PcDetails pcDetails717 = new PcDetails("Anakartlar","MSI MAG B560M MORTAR WIFI Intel B560 Soket 1200 DDR4 5066MHz");
                            pcDetailsArrayList.add(pcDetails717);

                            PcDetails pcDetails718 = new PcDetails("Anakartlar","MSI B560M-A PRO Intel B560 Soket 1200 DDR4 5200MHz (OC) M.2");
                            pcDetailsArrayList.add(pcDetails718);

                            PcDetails pcDetails719 = new PcDetails("Anakartlar","MSI B560M PRO-E Intel B560 Soket 1200 DDR4 4800MHz (OC) M.2 ");
                            pcDetailsArrayList.add(pcDetails719);

                            PcDetails pcDetails810 = new PcDetails("Anakartlar","MSI B560M PRO Intel B560 Soket 1200 DDR4 5200MHz (OC) M.2");
                            pcDetailsArrayList.add(pcDetails810);

                            PcDetails pcDetails811 = new PcDetails("Anakartlar","MSI MAG B560M BAZOOKA Intel B560 Soket 1200 DDR4 5066MHz");
                            pcDetailsArrayList.add(pcDetails811);

                            PcDetails pcDetails821 = new PcDetails("Anakartlar","MSI MPG Z590 GAMING FORCE Intel Z590 Soket 1200 DDR4");
                            pcDetailsArrayList.add(pcDetails821);

                            PcDetails pcDetails813 = new PcDetails("Anakartlar","MSI MAG Z590 TORPEDO Intel Z590 Soket 1200 DDR4 5333(O.C.) M.2");
                            pcDetailsArrayList.add(pcDetails813);

                            PcDetails pcDetails814 = new PcDetails("Anakartlar","MSI B560M PRO-VDH Intel B560M Soket 1200 DDR4 5066(O.C.) M.2");
                            pcDetailsArrayList.add(pcDetails814);

                            PcDetails pcDetails815 = new PcDetails("Anakartlar","MSI B560M PRO-VDH WIFI Intel B560M Soket 1200 DDR4 5066(O.C.) M.2 ");
                            pcDetailsArrayList.add(pcDetails815);

                            PcDetails pcDetails816 = new PcDetails("Anakartlar","MSI MEG B550 UNIFY Amd B550 Soket AM4 DDR4 5600MHz (OC) M.2");
                            pcDetailsArrayList.add(pcDetails816);

                            PcDetails pcDetails817 = new PcDetails("Anakartlar","MSI MPG Z590-A PRO Intel Z590 Soket 1200 DDR4 5333MHz (OC)");
                            pcDetailsArrayList.add(pcDetails817);

                            PcDetails pcDetails818 = new PcDetails("Anakartlar","MSI MPG Z590 PRO WIFI Intel Z590 Soket 1200 DDR4 5333MHz (OC)");
                            pcDetailsArrayList.add(pcDetails818);

                            PcDetails pcDetails819 = new PcDetails("Anakartlar","MSI MPG Z590 GAMING CARBON WIFI Intel Z590 Soket 1200 DDR4");
                            pcDetailsArrayList.add(pcDetails819);

                            PcDetails pcDetails901 = new PcDetails("Anakartlar","MSI B550M PRO Amd B550 Soket AM4 DDR4 4600(O.C.) M.2 ");
                            pcDetailsArrayList.add(pcDetails901);

                            PcDetails pcDetails911 = new PcDetails("Anakartlar","MSI MEG B550 UNIFY-X Amd B550 Soket AM4 DDR4 5800MHz(OC) M.2");
                            pcDetailsArrayList.add(pcDetails911);

                            PcDetails pcDetails912 = new PcDetails("Anakartlar","MSI B550M PRO-VDH Amd B550 Soket AM4 DDR4 4400(O.C.) M.2");
                            pcDetailsArrayList.add(pcDetails912);

                            PcDetails pcDetails913 = new PcDetails("Anakartlar","MSI MAG A520M VECTOR WIFI Amd A520 Soket AM4 DDR4 4600");
                            pcDetailsArrayList.add(pcDetails913);

                            PcDetails pcDetails914 = new PcDetails("Anakartlar","MSI A520M PRO Amd A520 Soket AM4 DDR4 4600 MHz(OC) M.2");
                            pcDetailsArrayList.add(pcDetails914);

                            PcDetails pcDetails915 = new PcDetails("Anakartlar","MSI A520M-A PRO Amd A520 Soket AM4 DDR4 4600 MHz(OC) M.2");
                            pcDetailsArrayList.add(pcDetails915);

                            PcDetails pcDetails7118 = new PcDetails("Anakartlar","MSI MAG X570 TOMAHAWK WIFI Amd X570 Soket AM4 DDR4");
                            pcDetailsArrayList.add(pcDetails7118);

                            PcDetails pcDetails7119 = new PcDetails("Anakartlar","MSI H410M PRO Intel H410 Soket 1200 DDR4 2933MHz M.2 ");
                            pcDetailsArrayList.add(pcDetails7119);

                            PcDetails pcDetails870 = new PcDetails("Anakartlar","MSI B550M PRO-VDH WIFI Amd B550 Soket AM4 DDR4 4400(O.C.) M.2 ");
                            pcDetailsArrayList.add(pcDetails870);

                            PcDetails pcDetails871 = new PcDetails("Anakartlar","MSI MAG B460 TOMAHAWK Intel B460 Soket 1200 DDR4 2933MHz");
                            pcDetailsArrayList.add(pcDetails871);

                            PcDetails pcDetails872 = new PcDetails("Anakartlar","MSI MPG B550 GAMING EDGE WIFI Amd B550 Soket AM4 DDR4");
                            pcDetailsArrayList.add(pcDetails872);

                            PcDetails pcDetails873 = new PcDetails("Anakartlar","MSI MAG B550M MORTAR WIFI Amd B550M Soket AM4 DDR4 4400(OC)");
                            pcDetailsArrayList.add(pcDetails873);

                            PcDetails pcDetails874 = new PcDetails("Anakartlar","MSI MAG B550M MORTAR Amd B550M Soket AM4 DDR4 4400(OC)");
                            pcDetailsArrayList.add(pcDetails874);

                            PcDetails pcDetails875 = new PcDetails("Anakartlar","MSI MAG B550 TOMAHAWK Amd B550 Soket AM4 DDR4 5100(OC)");
                            pcDetailsArrayList.add(pcDetails875);

                            PcDetails pcDetails876 = new PcDetails("Anakartlar","MSI B460M PRO-VDH WIFI Intel B460 Soket 1200 DDR4 2933(OC)");
                            pcDetailsArrayList.add(pcDetails876);

                            PcDetails pcDetails877 = new PcDetails("Anakartlar","MSI MAG B460M MORTAR WIFI Intel B460 Soket 1200 DDR4 2933(OC) M.2 ");
                            pcDetailsArrayList.add(pcDetails877);

                            PcDetails pcDetails878 = new PcDetails("Anakartlar","MSI MAG B460M MORTAR Intel B460 Soket 1200 DDR4 2933(OC)");
                            pcDetailsArrayList.add(pcDetails878);

                            PcDetails pcDetails879 = new PcDetails("Anakartlar","MSI Z490-A PRO Intel Z490 Soket 1200 DDR4 4800(OC) M.2 ");
                            pcDetailsArrayList.add(pcDetails879);

                            PcDetails pcDetails970 = new PcDetails("Anakartlar","MSI MAG Z490 TOMAHAWK Intel Z490 Soket 1200 DDR4 4800(OC)");
                            pcDetailsArrayList.add(pcDetails970);

                            PcDetails pcDetails971 = new PcDetails("Anakartlar","MSI X299 PRO Intel X299 Soket 2066 DDR4 4200(OC) M.2 ");
                            pcDetailsArrayList.add(pcDetails971);

                            PcDetails pcDetails972 = new PcDetails("Anakartlar","MSI MEG X570 UNIFY Amd X570 Soket AM4 DDR4 4600(OC) M.2 ");
                            pcDetailsArrayList.add(pcDetails972);

                            PcDetails pcDetails973 = new PcDetails("Anakartlar","MSI A320M-A PRO MAX Amd A320 Soket AM4 DDR4 3200(OC) M.2");
                            pcDetailsArrayList.add(pcDetails973);

                            PcDetails pcDetails974 = new PcDetails("Anakartlar","MSI B450-A PRO MAX Amd B450 Soket AM4 DDR4 3466(OC) M.2");
                            pcDetailsArrayList.add(pcDetails974);

                            PcDetails pcDetails975 = new PcDetails("Anakartlar","MSI B450 GAMING PLUS MAX Amd B450 Soket AM4 DDR4 3466(OC)");
                            pcDetailsArrayList.add(pcDetails975);

                            PcDetails pcDetails931 = new PcDetails("Anakartlar","MSI B450 TOMAHAWK MAX Amd B450 Soket AM4 DDR4 3466(OC)");
                            pcDetailsArrayList.add(pcDetails931);

                            PcDetails pcDetails932 = new PcDetails("Anakartlar","MSI X570-A PRO Amd X570 Soket AM4 DDR4 4000(OC) M.2 ");
                            pcDetailsArrayList.add(pcDetails932);

                            PcDetails pcDetails933 = new PcDetails("Anakartlar","MSI MPG X570 GAMING PLUS Amd X570 Soket AM4 DDR4 4400(OC)");
                            pcDetailsArrayList.add(pcDetails933);

                            PcDetails pcDetails9332 = new PcDetails("Anakartlar","MSI MPG X570 GAMING EDGE WIFI Amd X570 Soket AM4 DDR4");
                            pcDetailsArrayList.add(pcDetails9332);

                            PcDetails pcDetails9333 = new PcDetails("Anakartlar","MSI MEG X570 ACE Amd X570 Soket AM4 DDR4 4600(OC) M.2 ");
                            pcDetailsArrayList.add(pcDetails9333);

                            PcDetails pcDetails9334 = new PcDetails("Anakartlar","MSI B365M PRO-VH Intel B365 Soket 1151 DDR4 2666 M.2 ");
                            pcDetailsArrayList.add(pcDetails9334);

                            PcDetails pcDetails9335 = new PcDetails("Anakartlar","MSI Z390-A PRO Intel Z390 Soket 1151 DDR4 4400(OC) M.2 ");
                            pcDetailsArrayList.add(pcDetails9335);


                            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                            adaptorPcDetails = new AdaptorPcDetails(pcDetailsArrayList);
                            recyclerView.setAdapter(adaptorPcDetails);

                            adaptorPcDetails.notifyDataSetChanged();





                        }else if (dil.equals("ingilizce")){


                            PcDetails pcDetails = new PcDetails("Motherboards","ASUS PRIME H510M-D Intel H510 Soket 1200 DDR4 3200MHz(OC) M.2");
                            pcDetailsArrayList.add(pcDetails);

                            PcDetails pcDetails2 = new PcDetails("Motherboards","ASUS PRIME B660M-K D4 Intel B660 Soket 1700 DDR4 5333MHz (OC)");
                            pcDetailsArrayList.add(pcDetails2); 
                                                                
                            PcDetails pcDetails3 = new PcDetails("Motherboards","ASUS PRIME H510M-E Intel H510 Soket 1200 DDR4 3200MHz(OC) M.2");
                            pcDetailsArrayList.add(pcDetails3); 
                                                                
                            PcDetails pcDetails4 = new PcDetails("Motherboards","ASUS TUF GAMING B550M-PLUS AMD B550 Soket AM4 Ryzen DDR4");
                            pcDetailsArrayList.add(pcDetails4);  
                                                                 
                            PcDetails pcDetails5 = new PcDetails("Motherboards","ASUS PRIME B450M-K II AMD B450 Soket AM4 DDR4 4400MHz(O.C.)");
                            pcDetailsArrayList.add(pcDetails5);  
                                                                 
                            PcDetails pcDetails6 = new PcDetails("Motherboards","ASUS TUF GAMING X570-PLUS (WI-FI) AM4 AMD Ryzen™ DDR4");
                            pcDetailsArrayList.add(pcDetails6);   
                                                                  
                            PcDetails pcDetails7 = new PcDetails("Motherboards","ASUS ROG MAXIMUS Z690 HERO EVA Intel Z690 Soket 1700 DDR5");
                            pcDetailsArrayList.add(pcDetails7);

                            PcDetails pcDetails8 = new PcDetails("Motherboards","ASUS PRIME B550M-A WIFI II AMD B550 Soket AM4 Ryzen DDR4");
                            pcDetailsArrayList.add(pcDetails8);

                            PcDetails pcDetails9 = new PcDetails("Motherboards","ASUS TUF GAMING B660M-PLUS D4 Intel B660 Soket DDR4 5333MHz");
                            pcDetailsArrayList.add(pcDetails9);

                            PcDetails pcDetails10 = new PcDetails("Motherboards","ASUS ROG STRIX B660-G GAMING WIFI Intel B660 Soket 1700 DDR5");
                            pcDetailsArrayList.add(pcDetails10);

                            PcDetails pcDetails11 = new PcDetails("Motherboards","ASUS PRIME B550-PLUS AMD B550 Soket AM4 Ryzen DDR4 4600MHz");
                            pcDetailsArrayList.add(pcDetails11); 
                                                                 
                            PcDetails pcDetails12 = new PcDetails("Motherboards","ASUS PRIME H410M-A INTEL H410 Soket 1200 DDR4 2933MHz(O.C)");
                            pcDetailsArrayList.add(pcDetails12);

                            PcDetails pcDetails14 = new PcDetails("Motherboards","ASUS PRIME Z690-P WIFI Intel Z690 Soket 1700 DDR5 6000MHz (OC)");
                            pcDetailsArrayList.add(pcDetails14);

                            PcDetails pcDetails15 = new PcDetails("Motherboards","ASUS PRIME Z690-P Intel Z690 Soket 1700 128GB DDR5");
                            pcDetailsArrayList.add(pcDetails15);

                            PcDetails pcDetails16 = new PcDetails("Motherboards","ASUS ROG STRIX GAMING WIFI Z690-E Intel Soket 1700 DDR5");
                            pcDetailsArrayList.add(pcDetails16);

                            PcDetails pcDetails17 = new PcDetails("Motherboards","ASUS PRIME H610M-E D4 Intel H610 Soket 1700 DDR4 3200MHz");
                            pcDetailsArrayList.add(pcDetails17);

                            PcDetails pcDetails18 = new PcDetails("Motherboards","ASUS ROG CROSSHAIR VIII DARK HERO X570 AM4 AMD Ryzen DDR4");
                            pcDetailsArrayList.add(pcDetails18);

                            PcDetails pcDetails19 = new PcDetails("Motherboards","ASUS PRIME A520M-E A520 Soket AM4 AMD Ryzen DDR4 4600MHz");
                            pcDetailsArrayList.add(pcDetails19);

                            PcDetails pcDetails20 = new PcDetails("Motherboards","ASUS PRIME H610M-K D4 Intel H610 Soket 1700 DDR4 3200MHz");
                            pcDetailsArrayList.add(pcDetails20);

                            PcDetails pcDetails21 = new PcDetails("Motherboards","ASUS TUF GAMING Z690-PLUS WF D4 Intel Z690 Soket 1700 DDR4");
                            pcDetailsArrayList.add(pcDetails21);

                            PcDetails pcDetails22 = new PcDetails("Motherboards","ASUS TUF GAMING Z690-PLUS D4 Intel Z690 Soket 1700 DDR4");
                            pcDetailsArrayList.add(pcDetails22);

                            PcDetails pcDetails23 = new PcDetails("Motherboards","ASUS ROGSTRIX Z690-A GAMING WIFI D4 Intel Z690 Soket 1700 DDR4");
                            pcDetailsArrayList.add(pcDetails23);

                            PcDetails pcDetails24 = new PcDetails("Motherboards","ASUS B450M-DRAGON AMD B450 Soket AM4 4400MHz(O.C.) M.2");
                            pcDetailsArrayList.add(pcDetails24);

                            PcDetails pcDetails25 = new PcDetails("Motherboards","ASUS PRIME H510M-A Intel H510 Soket 1200 DDR4 3200MHz(OC) M.2");
                            pcDetailsArrayList.add(pcDetails25);

                            PcDetails pcDetails26 = new PcDetails("Motherboards","ASUS TUF GAMING B550-PLUS WF AMD B550 Soket AM4 Ryzen DDR4");
                            pcDetailsArrayList.add(pcDetails26);

                            PcDetails pcDetails27 = new PcDetails("Motherboards","ASUS PRIME B550-PLUS AMD B550 Soket AM4 Ryzen DDR4 4600MHz");
                            pcDetailsArrayList.add(pcDetails27);

                            PcDetails pcDetails28 = new PcDetails("Motherboards","ASUS PRIME H410M-A INTEL H410 Soket 1200 DDR4 2933MHz(O.C)");
                            pcDetailsArrayList.add(pcDetails28);

                            PcDetails pcDetails29 = new PcDetails("Motherboards","ASUS PRIME Z690-P WIFI Intel Z690 Soket 1700 DDR5 6000MHz (OC)");
                            pcDetailsArrayList.add(pcDetails29);

                            PcDetails pcDetails30 = new PcDetails("Motherboards","ASUS ROG STRIX GAMING WIFI Z690-E Intel Soket 1700 DDR5");
                            pcDetailsArrayList.add(pcDetails30);

                            PcDetails pcDetails31 = new PcDetails("Motherboards","ASUS ROGSTRIX Z690-A GAMING WIFI Intel Z690 Soket 1700 DDR5");
                            pcDetailsArrayList.add(pcDetails31);

                            PcDetails pcDetails32 = new PcDetails("Motherboards","ASUS TUF GAMING Z690-PLUS WIFI Intel Z690 Soket 1700 DDR5");
                            pcDetailsArrayList.add(pcDetails32);

                            PcDetails pcDetails33 = new PcDetails("Motherboards","ASUS TUF GAMING Z690-PLUS Intel Z690 Soket 1700 DDR5 6000MHz");
                            pcDetailsArrayList.add(pcDetails33);

                            PcDetails pcDetails34 = new PcDetails("Motherboards","ASUS ROG MAXIMUS Z690 FORMULA Intel Z690 Soket 1700");
                            pcDetailsArrayList.add(pcDetails34);

                            PcDetails pcDetails35 = new PcDetails("Motherboards","ASUS TUF GAMING B660M-PLUS WIFI Intel B660 Soket 1700 DDR5");
                            pcDetailsArrayList.add(pcDetails35);

                            PcDetails pcDetails36 = new PcDetails("Motherboards","ASUS ROG STRIX B660-A GAMING WF Intel Soket 1700 DDR5 6000MHz");
                            pcDetailsArrayList.add(pcDetails36);

                            PcDetails pcDetails37 = new PcDetails("Motherboards","ASUS TUF GAMING B660M-PLUS WIFI D4 Intel B660 Soket DDR4");
                            pcDetailsArrayList.add(pcDetails37);

                            PcDetails pcDetails38 = new PcDetails("Motherboards","ASUS PRIME B660-PLUS D4 Intel B660 Soket 1700 DDR4 5066MHz");
                            pcDetailsArrayList.add(pcDetails38);

                            PcDetails pcDetails39 = new PcDetails("Motherboards","ASUS PRIME B660M-A WIFI D4 Intel B660 Soket 1700 DDR4 3200MHz");
                            pcDetailsArrayList.add(pcDetails39);

                            PcDetails pcDetails40 = new PcDetails("Motherboards","ASUS ROG STRIX B660-A GAMING WF Intel B660 Soket 1700 DDR4");
                            pcDetailsArrayList.add(pcDetails40);

                            PcDetails pcDetails41 = new PcDetails("Motherboards","ASUS PRIME Z690-P D4 Intel Z690 Soket 1700128GB DDR4 5333MHz");
                            pcDetailsArrayList.add(pcDetails41);

                            PcDetails pcDetails42 = new PcDetails("Motherboards","ASUS TUF GAMING H670-PRO WIFI D4 Intel Soket 1700 DDR4 3200MHz");
                            pcDetailsArrayList.add(pcDetails42);

                            PcDetails pcDetails43 = new PcDetails("Motherboards","ASUS TUF GAMING B660-PLUS WIFI D4 Intel Soket 1700 DDR4");
                            pcDetailsArrayList.add(pcDetails43);

                            PcDetails pcDetails44 = new PcDetails("Motherboards","ASUS TUF GAMING B660M-E D4 Intel B660 Soket 1700 DDR4");
                            pcDetailsArrayList.add(pcDetails44);

                            PcDetails pcDetails45 = new PcDetails("","ASUS PROART B660-CREATOR D4 Intel B660 Soket 1700 DDR4");
                            pcDetailsArrayList.add(pcDetails45);

                            PcDetails pcDetails46 = new PcDetails("Motherboards","ASUS PRIME H670-PLUS D4 Intel H570 Soket 1700 DDR4 2933MHz");
                            pcDetailsArrayList.add(pcDetails46);  
                                                                  
                            PcDetails pcDetails47 = new PcDetails("Motherboards","ASUS PRIME H610M-D D4 Intel H610 Soket 1700 DDR4 3200MHz");
                            pcDetailsArrayList.add(pcDetails47);   
                                                                   
                            PcDetails pcDetails48 = new PcDetails("Motherboards","ASUS PRIME H610M-A D4 Intel H610 Soket 1700 DDR4 3200MHz");
                            pcDetailsArrayList.add(pcDetails48);  
                                                                  
                            PcDetails pcDetails49 = new PcDetails("Motherboards","ASUS PRIME B660M-A D4 Intel B660 Soket 1700 DDR4 3200MHz (OC)");
                            pcDetailsArrayList.add(pcDetails49);   
                                                                   
                            PcDetails pcDetails50 = new PcDetails("Motherboards","ASUS ROG CROSSHAIR VIII FORMULA X570 AMD Soket AM4");
                            pcDetailsArrayList.add(pcDetails50); 
                                                                 
                            PcDetails pcDetails51 = new PcDetails("Motherboards","ASUS ROG STRIX Z690-G GAMING WIFI Intel Z690 Soket 1700 DDR5");
                            pcDetailsArrayList.add(pcDetails51);   
                                                                   
                            PcDetails pcDetails52 = new PcDetails("Motherboards","ASUS PRIME Z690-P WIFI D4 Intel PRIME Z690-P Soket 1700 DDR4");
                            pcDetailsArrayList.add(pcDetails52);  
                                                                  
                            PcDetails pcDetails53 = new PcDetails("Motherboards","ASUS ROG STRIX Z690-F GAMING WF Intel Z690 Soket 1700 DDR5");
                            pcDetailsArrayList.add(pcDetails53);
                                                                
                            PcDetails pcDetails54 = new PcDetails("Motherboards","ASUS PRIME Z690M-PLUS D4 Intel Z690 Soket 1700 DDR4 5333MHz");
                            pcDetailsArrayList.add(pcDetails54);   
                                                                   
                            PcDetails pcDetails55 = new PcDetails("Motherboards","ASUS PRIME Z690-A Intel Z690 Soket 1700 DDR5 6000MHz (OC)");
                            pcDetailsArrayList.add(pcDetails55);  
                                                                  
                            PcDetails pcDetails56 = new PcDetails("Motherboards","ASUS ProArt X570-CREATOR WIFI AMD X570 AM4 Soket DDR4");
                            pcDetailsArrayList.add(pcDetails56);  
                                                                  
                            PcDetails pcDetails57 = new PcDetails("Motherboards","ASUS PRIME B460I-PLUS INTEL B460 Soket 1200 DDR4");
                            pcDetailsArrayList.add(pcDetails57); 
                                                                 
                            PcDetails pcDetails58 = new PcDetails("Motherboards","ASUS EX-H510M-V3 INTEL H510 Soket 1200 DDR4 3200MHz(O.C)");
                            pcDetailsArrayList.add(pcDetails58);   
                                                                   
                            PcDetails pcDetails59 = new PcDetails("Motherboards","ASUS TUF GAMING A520M PLUS II Soket AM4 AMD Ryzen DDR4");
                            pcDetailsArrayList.add(pcDetails59);  
                                                                  
                            PcDetails pcDetails60 = new PcDetails("Motherboards","ASUS TUF GAMING A520M PLUS WIFI Soket AM4 AMD Ryzen DDR4");
                            pcDetailsArrayList.add(pcDetails60);  
                                                                  
                            PcDetails pcDetails61 = new PcDetails("Motherboards","ASUS TUF GAMING B560M-E Intel B560 Soket 1200 DDR4 5000MHz");
                            pcDetailsArrayList.add(pcDetails61);  
                                                                  
                            PcDetails pcDetails62 = new PcDetails("Motherboards","ASUS PRIME A520M-A II A520 Soket AM4 AMD Ryzen DDR4 4800MHz4");
                            pcDetailsArrayList.add(pcDetails62);  
                                                                  
                                                                  
                            PcDetails pcDetails64 = new PcDetails("Motherboards","ASUS PRIME B560M-K Intel B560 Soket 1200 DDR4 4800MHz(OC) M.2");
                            pcDetailsArrayList.add(pcDetails64);   
                                                                   
                            PcDetails pcDetails65 = new PcDetails("Motherboards","ASUS PRIME B560M-A Intel B560 Soket 1200 DDR4 5000MHz(OC) M.2");
                            pcDetailsArrayList.add(pcDetails65);  
                                                                  
                            PcDetails pcDetails66 = new PcDetails("Motherboards","ASUS PRIME H570M-PLUS Intel H570 Soket 1200 DDR4 4600MHz");
                            pcDetailsArrayList.add(pcDetails66);  
                                                                  
                            PcDetails pcDetails67 = new PcDetails("Motherboards","ASUS PRIME Z590-P Intel Z590 Soket 1200 DDR4 5133MHz(OC) M.2");
                            pcDetailsArrayList.add(pcDetails67);   
                                                                   
                            PcDetails pcDetails68 = new PcDetails("Motherboards","ASUS TUF GAMING Z590-PLUS Intel Z590 Soket 1200 DDR4");
                            pcDetailsArrayList.add(pcDetails68);  
                                                                  
                            PcDetails pcDetails69 = new PcDetails("Motherboards","ASUS ROG MAXIMUS XIII EXTREME Intel Z590 Soket 1200");
                            pcDetailsArrayList.add(pcDetails69);  
                                                                  
                            PcDetails pcDetails70 = new PcDetails("Motherboards","ASUS ROG STRIX B550 - XE GAMING WF AM4 Soket AMD Ryzen");
                            pcDetailsArrayList.add(pcDetails70);  
                                                                 
                            PcDetails pcDetails71 = new PcDetails("Motherboards","ASUS TUF GAMING B450-PLUS II AMD B450 Soket AM4 Ryzen DDR4");
                            pcDetailsArrayList.add(pcDetails71);   
                                                                   
                            PcDetails pcDetails72 = new PcDetails("Motherboards","ASUS ROG CROSSHAIR VIII HERO WF AMD X570 AM4 Ryzen DDR4");
                            pcDetailsArrayList.add(pcDetails72);  
                                                                  
                            PcDetails pcDetails73 = new PcDetails("Motherboards","ASUS PRIME B450M-A II AMD B450 Soket AM4 DDR4 4400MHz(O.C.)");
                            pcDetailsArrayList.add(pcDetails73);   
                                                                   
                            PcDetails pcDetails74 = new PcDetails("Motherboards","ASUS TUF GAMING B450M-PLUS II AMD B450 Soket AM4 DDR4");
                            pcDetailsArrayList.add(pcDetails74);  
                                                                  
                            PcDetails pcDetails75 = new PcDetails("Motherboards","ASUS TUF GAMING X570-PRO (WI-FI) AM4 X570 AM4 DDR4 5100MHz");
                            pcDetailsArrayList.add(pcDetails75); 
                                                                 
                            PcDetails pcDetails76 = new PcDetails("Motherboards","ASUS TUF GAMING A520M-PLUS A520 Soket AM4 AMD Ryzen DDR4");
                            pcDetailsArrayList.add(pcDetails76);   
                                                                   
                            PcDetails pcDetails77 = new PcDetails("Motherboards","ASUS PRIME A520M-K A520 Soket AM4 AMD Ryzen DDR4 4600MHz");
                            pcDetailsArrayList.add(pcDetails77);   
                                                                   
                            PcDetails pcDetails78 = new PcDetails("Motherboards","ASUS TUF GAMING B450M-PRO S Amd B450 AM4 Soket DDR4");
                            pcDetailsArrayList.add(pcDetails78);  
                                                                  
                            PcDetails pcDetails79 = new PcDetails("Motherboards","ASUS PRIME B550M-A (WI-FI) AMD B550 Soket AM4 Ryzen DDR4");
                            pcDetailsArrayList.add(pcDetails79);   
                                                                
                            PcDetails pcDetails80 = new PcDetails("Motherboards","ASUS PRIME B460M-K INTEL B460 Soket 1200 DDR4 2933MHz(O.C)");
                            pcDetailsArrayList.add(pcDetails80);   
                                                                   
                            PcDetails pcDetails81 = new PcDetails("Motherboards","ASUS TUF H310M PLUS R2.0 Intel H310M Socket 8-9. Nesil 1151 DDR4");
                            pcDetailsArrayList.add(pcDetails81);   
                                                                   
                            PcDetails pcDetails82 = new PcDetails("Motherboards","ASUS PRIME H310M-F R2.0 Intel H310 Socket 8.-9.Nesil 1151 DDR4");
                            pcDetailsArrayList.add(pcDetails82);   
                                                                   
                            PcDetails pcDetails83 = new PcDetails("Motherboards","ASUS ROG CROSSHAIR VIII IMPACT AMD X570 AM4 Ryzen");
                            pcDetailsArrayList.add(pcDetails83);   
                                                                   
                            PcDetails pcDetails84 = new PcDetails("Motherboards","ASUS PRIME A320M-F A320 AM4 AMD Ryzen™ DDR4 3200(O.C.) MHz");
                            pcDetailsArrayList.add(pcDetails84);   
                                                                   
                            PcDetails pcDetails85 = new PcDetails("Motherboards","ASUS PRIME X570-P AMD X570 AM4 Ryzen DDR4 4400MHz (O.C.)");
                            pcDetailsArrayList.add(pcDetails85);  
                                                                  
                            PcDetails pcDetails86 = new PcDetails("Motherboards","ASUS ROG STRIX X570-F GAMING AMD X570 AM4 Ryzen DDR4");
                            pcDetailsArrayList.add(pcDetails86);   
                                                                   
                            PcDetails pcDetails87 = new PcDetails("Motherboards","ASUS PRIME H310M-K R2.0 Intel H310 Socket 8.-9.Nesil 1151 DDR4");
                            pcDetailsArrayList.add(pcDetails87);  
                                                                  
                            PcDetails pcDetails88 = new PcDetails("Motherboards","ASUS PRIME B365M-K Intel B365 Soket 8.-9. Nesil 1151 DDR4");
                            pcDetailsArrayList.add(pcDetails88);   
                                                                   
                            PcDetails pcDetails89 = new PcDetails("Motherboards","ASUS TUF B450M-PRO GAMING AMD B450 Socket AM4 Ryzen DDR4");
                            pcDetailsArrayList.add(pcDetails89);  
                                                                  
                            PcDetails pcDetails90 = new PcDetails("Motherboards","ASUS TUF B450-PRO GAMING AMD B450 Socket AM4 Ryzen DDR4");
                            pcDetailsArrayList.add(pcDetails90);   
                                                                   
                            PcDetails pcDetails91 = new PcDetails("Motherboards","ASUS TUF B450M-PLUS GAMING AMD B450 AM4 Ryzen™ DDR4");
                            pcDetailsArrayList.add(pcDetails91); 
                                                                 
                            PcDetails pcDetails92 = new PcDetails("Motherboards","ASUS TUF B450-PLUS GAMING AMD B450 Soket AM4 Ryzen™");
                            pcDetailsArrayList.add(pcDetails92);  
                                                                  
                            PcDetails pcDetails93 = new PcDetails("Motherboards","ASUS PRIME A320M-E A320 AM4 AMD Ryzen™ DDR4 3200(O.C.) MHz");
                            pcDetailsArrayList.add(pcDetails93); 
                                                                 
                            PcDetails pcDetails94 = new PcDetails("Motherboards","ASUS EX-A320M-GAMING A320 Socket AM4 AMD Ryzen™DDR4");
                            pcDetailsArrayList.add(pcDetails94);   
                                                                   
                            PcDetails pcDetails95 = new PcDetails("Motherboards","ASUS PRIME A320M-K A320 AM4 AMD Ryzen™ DDR4 3200(O.C.) MHz");
                            pcDetailsArrayList.add(pcDetails95);  
                                                                  
                                                                  
                                                                  
                                                                  
                            //GIGABYTE

                            PcDetails pcDetails96 = new PcDetails("Motherboards","GIGABYTE H510M H UD Intel H510 Soket 1200 DDR4 3200MHz M.2");
                            pcDetailsArrayList.add(pcDetails96);

                            PcDetails pcDetails97 = new PcDetails("Motherboards","GIGABYTE H610M H 3200MHz DDR4 Soket 1700 M.2 HDMI D-Sub");
                            pcDetailsArrayList.add(pcDetails97);

                            PcDetails pcDetails98 = new PcDetails("Motherboards","GIGABYTE H610M H 3200MHz DDR4 Soket 1700 M.2 HDMI D-Sub");
                            pcDetailsArrayList.add(pcDetails98);

                            PcDetails pcDetails99 = new PcDetails("Motherboards","GIGABYTE B550 AORUS PRO AC Amd B550 Soket AM4 DDR4");
                            pcDetailsArrayList.add(pcDetails99);

                            PcDetails pcDetails100 = new PcDetails("Motherboards","GIGABYTE B560M H 3200MHz (O.C) DDR4 Soket 1200 M.2 HDMI D-Sub");
                            pcDetailsArrayList.add(pcDetails100);  
                                                                   
                            PcDetails pcDetails101 = new PcDetails("Motherboards","GIGABYTE Z690 ULTRA DURABLE Intel Soket 1700 DDR5 6000MHz (O.C) M.2 ");
                            pcDetailsArrayList.add(pcDetails101);   
                                                                    
                            PcDetails pcDetails102 = new PcDetails("Motherboards","GIGABYTE B450M H UD AMD B450 Soket AM4 DDR4 3600MHZ (O.C)");
                            pcDetailsArrayList.add(pcDetails102);   
                                                                    
                            PcDetails pcDetails103 = new PcDetails("Motherboards","GIGABYTE H310M H Intel H310 Soket 8.-9. Nesil 1151 DDR4");
                            pcDetailsArrayList.add(pcDetails103);  
                                                                   
                            PcDetails pcDetails104 = new PcDetails("Motherboards","GIGABYTE Z590 GAMING X Intel Z590 Soket 1200 DDR4 5333(O.C)");
                            pcDetailsArrayList.add(pcDetails104);   
                                                                    
                            PcDetails pcDetails105 = new PcDetails("Motherboards","GIGABYTE B460M GAMING HD Intel B460 Soket 1200 DDR4 2933MHz");
                            pcDetailsArrayList.add(pcDetails105);   
                                                                    
                            PcDetails pcDetails106 = new PcDetails("Motherboards","GIGABYTE Z590 AORUS MASTER Intel Z590 Soket 1200 DDR4");
                            pcDetailsArrayList.add(pcDetails106);  
                                                                   
                            PcDetails pcDetails107 = new PcDetails("Motherboards","GIGABYTE B450M S2H V2 AMD B450 Socket AM4 DDR4");
                            pcDetailsArrayList.add(pcDetails107);  
                                                                   
                            PcDetails pcDetails108 = new PcDetails("Motherboards","GIGABYTE GA-A520M-S2H AMD A520 Soket AM4 DDR4 5100MHz");
                            pcDetailsArrayList.add(pcDetails108);   
                                                                    
                            PcDetails pcDetails109 = new PcDetails("Motherboards","GIGABYTE B460M D2V Intel B460M Soket 1200 DDR4 2933MHz M.2");
                            pcDetailsArrayList.add(pcDetails109);  
                                                                   
                            PcDetails pcDetails110 = new PcDetails("Motherboards","GIGABYTE Z490I AORUS ULTRA Intel Z490 Soket 1200 DDR4");
                            pcDetailsArrayList.add(pcDetails110);  
                                                                   
                            PcDetails pcDetails111 = new PcDetails("Motherboards","GIGABYTE B550 GAMING X Amd B550 Soket AM4 DDR4 4000MHz");
                            pcDetailsArrayList.add(pcDetails111);   
                                                                    
                            PcDetails pcDetails112 = new PcDetails("Motherboards","GIGABYTE H310M H 2.0 Intel H310 Socket 8.-9. Nesil 1151 DDR4");
                            pcDetailsArrayList.add(pcDetails112);   
                                                                    
                            PcDetails pcDetails113 = new PcDetails("Motherboards","GIGABYTE GA-A320M-S2H A320 Socket AM4 AMD Ryzen™ DDR4");
                            pcDetailsArrayList.add(pcDetails113);




                            //Msi


                            PcDetails pcDetails1143 = new PcDetails("Motherboards","MSI PRO H610M-B DDR4 Intel H610 Soket 1700 3200MHz (OC) M.2");
                            pcDetailsArrayList.add(pcDetails1143);

                            PcDetails pcDetails114 = new PcDetails("Motherboards","MSI B450M-A PRO MAX Amd B450 Soket AM4 DDR4 3466(OC) M.2");
                            pcDetailsArrayList.add(pcDetails114);  
                                                                   
                            PcDetails pcDetails115 = new PcDetails("Motherboards","MSI H510M-A PRO Intel H510 Soket 1200 DDR4 3200MHz (OC) M.2");
                            pcDetailsArrayList.add(pcDetails115);

                            PcDetails pcDetails116 = new PcDetails("Motherboards","MSI H310M PRO-VDH PLUS Intel H310 Soket 1151 DDR4 2666");
                            pcDetailsArrayList.add(pcDetails116);

                            PcDetails pcDetails117 = new PcDetails("Motherboards","MSI PRO H410M-B Intel H410 Soket 1200 DDR4 2933MHz M.2");
                            pcDetailsArrayList.add(pcDetails117);

                            PcDetails pcDetails118 = new PcDetails("Motherboards","MSI MAG B460M BAZOOKA Intel B460 Soket 1200 DDR4 2933MHz");
                            pcDetailsArrayList.add(pcDetails118);

                            PcDetails pcDetails119 = new PcDetails("Motherboards","MSI B550M-A PRO Amd B550 Soket AM4 DDR4 4600(O.C.) M.2 ");
                            pcDetailsArrayList.add(pcDetails119);

                            PcDetails pcDetails200 = new PcDetails("Motherboards","MSI PRO Z690-A Intel Z690 Soket 1700 DDR4 5200MHz (OC) M.2");
                            pcDetailsArrayList.add(pcDetails200);

                            PcDetails pcDetails201 = new PcDetails("Motherboards","MSI MEG Z590 UNIFY Intel Z590 Soket 1200 DDR4 5600(O.C.) M.2");
                            pcDetailsArrayList.add(pcDetails201);

                            PcDetails pcDetails202 = new PcDetails("Motherboards","MSI MEG Z590 ACE Intel Z590 Soket 1200 DDR4 5600(O.C.) M.2 ");
                            pcDetailsArrayList.add(pcDetails202);

                            PcDetails pcDetails203 = new PcDetails("Motherboards","MSI B550-A PRO Amd B550 Soket AM4 DDR4 4400MHz M.2");
                            pcDetailsArrayList.add(pcDetails203);

                            PcDetails pcDetails204 = new PcDetails("Motherboards","MSI MAG B660 TOMAHAWK WIFI DDR4 Intel B660 Soket 1700 DDR4");
                            pcDetailsArrayList.add(pcDetails204);

                            PcDetails pcDetails205 = new PcDetails("Motherboards","MSI PRO Z690-A WIFI Intel Z690 Soket 1700 DDR5 6400MHz (OC)");
                            pcDetailsArrayList.add(pcDetails205);

                            PcDetails pcDetails206 = new PcDetails("Motherboards","MSI MEG Z590 ACE GOLD EDITION Intel Z590 Soket 1200 DDR4");
                            pcDetailsArrayList.add(pcDetails206);

                            PcDetails pcDetails207 = new PcDetails("Motherboards","MSI MPG Z590 GAMING PLUS Intel Z590 Soket 1200 DDR4 5333MHz");
                            pcDetailsArrayList.add(pcDetails207);

                            PcDetails pcDetails208 = new PcDetails("Motherboards","MSI H310M PRO-M2 PLUS Intel H310 Soket 1151 DDR4 2666 M.2");
                            pcDetailsArrayList.add(pcDetails208);

                            PcDetails pcDetails209 = new PcDetails("Motherboards","MSI MPG B550 GAMING PLUS Amd B550 Soket AM4 DDR4 4400(OC)");
                            pcDetailsArrayList.add(pcDetails209);

                            PcDetails pcDetails210 = new PcDetails("Motherboards","MSI MPG Z690 EDGE WIFI Intel Z690 Soket 1700 DDR5 6400MHz");
                            pcDetailsArrayList.add(pcDetails210);

                            PcDetails pcDetails211 = new PcDetails("Motherboards","MSI PRO H610M-G Intel H610 Soket 1700 DDR4 3200MHz (OC) M.2");
                            pcDetailsArrayList.add(pcDetails211);

                            PcDetails pcDetails212 = new PcDetails("Motherboards","MSI PRO B660M-E Intel B660 Soket 1700 DDR4 4600MHz (OC) M.2");
                            pcDetailsArrayList.add(pcDetails212);

                            PcDetails pcDetails213 = new PcDetails("Motherboards","MSI PRO B660M-B Intel B660 Soket 1700 DDR4 4600MHz (OC) M.2");
                            pcDetailsArrayList.add(pcDetails213);

                            PcDetails pcDetails224 = new PcDetails("Motherboards","MSI PRO B660M-A WIFI Intel B660 Soket 1700 DDR4 4800MHz (OC)");
                            pcDetailsArrayList.add(pcDetails224);

                            PcDetails pcDetails234 = new PcDetails("Motherboards","MSI MAG B660M MORTAR WIFI Intel B660 Soket 1700 DDR5 6200MHz");
                            pcDetailsArrayList.add(pcDetails234);

                            PcDetails pcDetails244 = new PcDetails("Motherboards","MSI MPG Z690 EDGE WIFI Intel Z690 Soket 1700 DDR4 5200MHz");
                            pcDetailsArrayList.add(pcDetails244);

                            PcDetails pcDetails255 = new PcDetails("Motherboards","MSI H510M PRO Intel H510 Soket 1200 DDR4 3200MHz (OC) M.2");
                            pcDetailsArrayList.add(pcDetails255);

                            PcDetails pcDetails266 = new PcDetails("Motherboards","MSI MPG Z590 GAMING EDGE WIFI Intel Z590 Soket 1200 DDR4");
                            pcDetailsArrayList.add(pcDetails266);

                            PcDetails pcDetails277 = new PcDetails("Motherboards","MSI B460M PRO-VDH Intel B460 Solet 1200 DDR4 2933(O.C.) M.2");
                            pcDetailsArrayList.add(pcDetails277);

                            PcDetails pcDetails288 = new PcDetails("Motherboards","MSI MAG B460 TORPEDO Soket 1200 DDR4 2933(O.C.) M.2");
                            pcDetailsArrayList.add(pcDetails288);

                            PcDetails pcDetails299 = new PcDetails("Motherboards","MSI MPG B550 GAMING CARBON WIFI Amd B550 Soket AM4 DDR4 5100(O.C.) M.2");
                            pcDetailsArrayList.add(pcDetails299);

                            PcDetails pcDetails300 = new PcDetails("Motherboards","MSI B460M-A PRO Intel B460 Soket 1200 DDR4 2933(OC) M.2 ");
                            pcDetailsArrayList.add(pcDetails300);

                            PcDetails pcDetails320 = new PcDetails("Motherboards","MSI B450M PRO-M2 MAX Amd B450 Soket AM4 DDR4 3466(OC) M.2");
                            pcDetailsArrayList.add(pcDetails320);

                            PcDetails pcDetails333 = new PcDetails("Motherboards","MSI A320M-A PRO Amd A320 Soket AM4 DDR4 3200(OC) ");
                            pcDetailsArrayList.add(pcDetails333);

                            PcDetails pcDetails344 = new PcDetails("Motherboards","MSI H610M BOMBER DDR4 3200MHz(OC) Soket 1700 M.2 HDMI");
                            pcDetailsArrayList.add(pcDetails344);

                            PcDetails pcDetails355 = new PcDetails("Motherboards","MSI PRO B660M-P WIFI DDR4 Intel B660 Soket 1700 DDR4 4600MHz");
                            pcDetailsArrayList.add(pcDetails355);

                            PcDetails pcDetails366 = new PcDetails("Motherboards","MSI B660 BOMBER DDR4 4600MHz (OC) DDR4 Soket 1700 M.2 HDMI");
                            pcDetailsArrayList.add(pcDetails366);

                            PcDetails pcDetails377= new PcDetails("AMotherboards","MSI PRO B660M-P DDR4 Intel B660 Soket 1700 DDR4 4600MHz (OC) M.2 ");
                            pcDetailsArrayList.add(pcDetails377);

                            PcDetails pcDetails381 = new PcDetails("Motherboards","MSI PRO B550M-P GEN3 B550 Soket AM4 DDR4 4400MHz (OC) M.2");
                            pcDetailsArrayList.add(pcDetails381);

                            PcDetails pcDetails391 = new PcDetails("Motherboards","MSI PRO B550-P GEN3 B550 Soket AM4 DDR4 4400MHz (OC) M.2");
                            pcDetailsArrayList.add(pcDetails391);

                            PcDetails pcDetails401 = new PcDetails("Motherboards","MSI H510I PRO WIFI 3200MHz DDR4 Soket 1200 M.2 HDMI mITX");
                            pcDetailsArrayList.add(pcDetails401);

                            PcDetails pcDetails412 = new PcDetails("Motherboards","MSI MAG B660M BAZOOKA 4800MHz(OC) DDR4 Soket 1700 M.2");
                            pcDetailsArrayList.add(pcDetails412);

                            PcDetails pcDetails421 = new PcDetails("Motherboards","MSI PRO B660-A Intel B660 Soket 1700 DDR4 4800MHz (OC) M.2");
                            pcDetailsArrayList.add(pcDetails421);

                            PcDetails pcDetails433 = new PcDetails("Motherboards","MSI PRO B660M-A WIFI Intel B660 Soket 1700 DDR5 6200MHz (OC)");
                            pcDetailsArrayList.add(pcDetails433);

                            PcDetails pcDetails444 = new PcDetails("Motherboards","MSI MAG H670 TOMAHAWK WIFI Intel H670 Soket 1700 DDR4");
                            pcDetailsArrayList.add(pcDetails444);

                            PcDetails pcDetails456 = new PcDetails("Motherboards","MSI PRO B660M-A DDR4 Intel B660 Soket 1700 DDR4 4600MHz (OC)");
                            pcDetailsArrayList.add(pcDetails456);

                            PcDetails pcDetails467 = new PcDetails("Motherboards","MSI PRO B660M-A DDR4 Intel B660 Soket 1700 DDR4 4600MHz (OC)");
                            pcDetailsArrayList.add(pcDetails467);

                            PcDetails pcDetails477 = new PcDetails("Motherboards","MSI MAG Z690 TOMAHAWK WIFI Intel Z690 Soket 1700 DDR5");
                            pcDetailsArrayList.add(pcDetails477);

                            PcDetails pcDetails488 = new PcDetails("Motherboards","MSI PRO B660M-G Intel B660 Soket 1700 DDR4 4600MHz (OC) M.2");
                            pcDetailsArrayList.add(pcDetails488);

                            PcDetails pcDetails499 = new PcDetails("Motherboards","MSI MAG B660M MORTAR Intel B660 Soket 1700 DDR5 6200MHz");
                            pcDetailsArrayList.add(pcDetails499);

                            PcDetails pcDetails501 = new PcDetails("Motherboards","MSI MAG B660 TOMAHAWK WIFI Intel B660 Soket 1700 DDR5");
                            pcDetailsArrayList.add(pcDetails501);

                            PcDetails pcDetails511 = new PcDetails("Motherboards","MSI MAG Z690M MORTAR WIFI Intel Z690 Soket 1700 DDR5 6200MHz");
                            pcDetailsArrayList.add(pcDetails511);

                            PcDetails pcDetails512 = new PcDetails("Motherboards","MSI MAG B660M MORTAR DDR4 Intel B660 Soket 1700 DDR4");
                            pcDetailsArrayList.add(pcDetails512);

                            PcDetails pcDetails513 = new PcDetails("Motherboards","MSI MAG B660M MORTAR WIFI DDR4 Intel B660 Soket 1700 DDR4");
                            pcDetailsArrayList.add(pcDetails513);

                            PcDetails pcDetails514 = new PcDetails("Motherboards","MSI H510M PRO-E Intel H510 Soket 1200 DDR4 3200MHz (OC) ");
                            pcDetailsArrayList.add(pcDetails514);

                            PcDetails pcDetails515 = new PcDetails("Motherboards","MSI PRO Z690-P DDR4 Intel Z690 Soket 1700 DDR4 5200MHz(OC) M.2");
                            pcDetailsArrayList.add(pcDetails515);

                            PcDetails pcDetails516 = new PcDetails("Motherboards","MSI MAG Z690 TORPEDO Intel Z690 Soket 1700 DDR5 6400MHz(OC)");
                            pcDetailsArrayList.add(pcDetails516);

                            PcDetails pcDetails517 = new PcDetails("Motherboards","MSI MAG Z690 TOMAHAWK WIFI DDR4 Intel Z690 Soket 1700 DDR4");
                            pcDetailsArrayList.add(pcDetails517);

                            PcDetails pcDetails518 = new PcDetails("Motherboards","MSI MEG X570S UNIFY-X MAX Amd X570 Soket AM4 DDR4");
                            pcDetailsArrayList.add(pcDetails518);

                            PcDetails pcDetails519 = new PcDetails("Motherboards","MSI PRO Z690-A WIFI Intel Z690 Soket 1700 DDR4 5200MHz (OC)");
                            pcDetailsArrayList.add(pcDetails519);

                            PcDetails pcDetails610 = new PcDetails("Motherboards","MSI PRO Z690-A Intel Z690 Soket 1700 DDR5 6400MHz (OC) M.2");
                            pcDetailsArrayList.add(pcDetails610);

                            PcDetails pcDetails611 = new PcDetails("Motherboards","MSI MPG Z690 FORCE WIFI Intel Z690 Soket 1700 DDR5 6666MHz");
                            pcDetailsArrayList.add(pcDetails611);

                            PcDetails pcDetails621 = new PcDetails("Motherboards","MSI MPG Z690 CARBON WIFI Intel Z690 Soket 1700 DDR5 6666MHz");
                            pcDetailsArrayList.add(pcDetails621);

                            PcDetails pcDetails631 = new PcDetails("Motherboards","MSI B560-A PRO Intel B560 Soket 1200 DDR4 5066MHz (OC) M.2");
                            pcDetailsArrayList.add(pcDetails631);

                            PcDetails pcDetails642 = new PcDetails("Motherboards","MSI MPG X570S CARBON MAX WIFI Amd X570 Soket AM4 DDR4");
                            pcDetailsArrayList.add(pcDetails642);

                            PcDetails pcDetails652 = new PcDetails("Motherboards","MSI MPG X570S EDGE MAX WIFI Amd X570 Soket AM4 DDR4");
                            pcDetailsArrayList.add(pcDetails652);

                            PcDetails pcDetails662 = new PcDetails("Motherboards","MSI MEG X570S ACE MAX Amd X570 Soket AM4 DDR4 5300MHz");
                            pcDetailsArrayList.add(pcDetails662);  
                                                                   
                            PcDetails pcDetails671 = new PcDetails("Motherboards","MSI MAG X570S TORPEDO MAX Amd X570 Soket AM4 DDR4");
                            pcDetailsArrayList.add(pcDetails671);

                            PcDetails pcDetails681 = new PcDetails("Motherboards","MSI MAG X570S TOMAHAWK MAX WIFI Amd X570 Soket AM4 DDR4");
                            pcDetailsArrayList.add(pcDetails681);

                            PcDetails pcDetails691 = new PcDetails("Motherboards","MSI A320M PRO-VH Amd A320 Soket AM4 DDR4 3200(OC) M.2");
                            pcDetailsArrayList.add(pcDetails691);

                            PcDetails pcDetails710 = new PcDetails("Motherboards","MSI MAG B560 TORPEDO Intel B560 Soket 1200 DDR4 5066MHz (OC)");
                            pcDetailsArrayList.add(pcDetails710);

                            PcDetails pcDetails711 = new PcDetails("Motherboards","MSI MAG B560M MORTAR Intel B560 Soket 1200 DDR4 5066MHz");
                            pcDetailsArrayList.add(pcDetails711);

                            PcDetails pcDetails721 = new PcDetails("Motherboards","MSI MAG B560 TOMAHAWK WIFI Intel B560 Soket 1200 DDR4");
                            pcDetailsArrayList.add(pcDetails721);

                            PcDetails pcDetails713 = new PcDetails("Motherboards","MSI Z590 PLUS Intel Z590 Soket 1200 DDR4 5333MHz (OC) M.2");
                            pcDetailsArrayList.add(pcDetails713);

                            PcDetails pcDetails714 = new PcDetails("Motherboards","MSI MAG Z590 TOMAHAWK WIFI Intel Z590 Soket 1200 DDR4");
                            pcDetailsArrayList.add(pcDetails714);

                            PcDetails pcDetails715 = new PcDetails("Motherboards","MSI B450 TOMAHAWK MAX II Amd B450 Soket AM4 DDR4 4333MHz");
                            pcDetailsArrayList.add(pcDetails715);

                            PcDetails pcDetails716 = new PcDetails("Motherboards","MSI B560M PRO WIFI Intel B560 Soket 1200 DDR4 5200MHz (OC)");
                            pcDetailsArrayList.add(pcDetails716);

                            PcDetails pcDetails717 = new PcDetails("Motherboards","MSI MAG B560M MORTAR WIFI Intel B560 Soket 1200 DDR4 5066MHz");
                            pcDetailsArrayList.add(pcDetails717);

                            PcDetails pcDetails718 = new PcDetails("Motherboards","MSI B560M-A PRO Intel B560 Soket 1200 DDR4 5200MHz (OC) M.2");
                            pcDetailsArrayList.add(pcDetails718);

                            PcDetails pcDetails719 = new PcDetails("Motherboards","MSI B560M PRO-E Intel B560 Soket 1200 DDR4 4800MHz (OC) M.2");
                            pcDetailsArrayList.add(pcDetails719);

                            PcDetails pcDetails810 = new PcDetails("Motherboards","MSI B560M PRO Intel B560 Soket 1200 DDR4 5200MHz (OC) M.2");
                            pcDetailsArrayList.add(pcDetails810);

                            PcDetails pcDetails811 = new PcDetails("Motherboards","MSI MAG B560M BAZOOKA Intel B560 Soket 1200 DDR4 5066MHz");
                            pcDetailsArrayList.add(pcDetails811);

                            PcDetails pcDetails821 = new PcDetails("Motherboards","MSI MPG Z590 GAMING FORCE Intel Z590 Soket 1200 DDR4");
                            pcDetailsArrayList.add(pcDetails821);

                            PcDetails pcDetails813 = new PcDetails("Motherboards","MSI MAG Z590 TORPEDO Intel Z590 Soket 1200 DDR4 5333(O.C.) M.2");
                            pcDetailsArrayList.add(pcDetails813);

                            PcDetails pcDetails814 = new PcDetails("Motherboards","MSI B560M PRO-VDH Intel B560M Soket 1200 DDR4 5066(O.C.) M.2");
                            pcDetailsArrayList.add(pcDetails814);

                            PcDetails pcDetails815 = new PcDetails("Motherboards","MSI B560M PRO-VDH WIFI Intel B560M Soket 1200 DDR4 5066(O.C.) M.2 ");
                            pcDetailsArrayList.add(pcDetails815);

                            PcDetails pcDetails816 = new PcDetails("Motherboards","MSI MEG B550 UNIFY Amd B550 Soket AM4 DDR4 5600MHz (OC) M.2");
                            pcDetailsArrayList.add(pcDetails816);

                            PcDetails pcDetails817 = new PcDetails("Motherboards","MSI MPG Z590-A PRO Intel Z590 Soket 1200 DDR4 5333MHz (OC)");
                            pcDetailsArrayList.add(pcDetails817);

                            PcDetails pcDetails818 = new PcDetails("Motherboards","MSI MPG Z590 PRO WIFI Intel Z590 Soket 1200 DDR4 5333MHz (OC)");
                            pcDetailsArrayList.add(pcDetails818);

                            PcDetails pcDetails819 = new PcDetails("Motherboards","MSI MPG Z590 GAMING CARBON WIFI Intel Z590 Soket 1200 DDR4");
                            pcDetailsArrayList.add(pcDetails819);

                            PcDetails pcDetails901 = new PcDetails("Motherboards","MSI B550M PRO Amd B550 Soket AM4 DDR4 4600(O.C.) M.2 ");
                            pcDetailsArrayList.add(pcDetails901);

                            PcDetails pcDetails911 = new PcDetails("Motherboards","MSI MEG B550 UNIFY-X Amd B550 Soket AM4 DDR4 5800MHz(OC) M.2");
                            pcDetailsArrayList.add(pcDetails911);

                            PcDetails pcDetails912 = new PcDetails("Motherboards","MSI B550M PRO-VDH Amd B550 Soket AM4 DDR4 4400(O.C.) M.2");
                            pcDetailsArrayList.add(pcDetails912);

                            PcDetails pcDetails913 = new PcDetails("Motherboards","MSI MAG A520M VECTOR WIFI Amd A520 Soket AM4 DDR4 4600");
                            pcDetailsArrayList.add(pcDetails913);

                            PcDetails pcDetails914 = new PcDetails("Motherboards","MSI A520M PRO Amd A520 Soket AM4 DDR4 4600 MHz(OC) M.2");
                            pcDetailsArrayList.add(pcDetails914);

                            PcDetails pcDetails915 = new PcDetails("Motherboards","MSI A520M-A PRO Amd A520 Soket AM4 DDR4 4600 MHz(OC) M.2");
                            pcDetailsArrayList.add(pcDetails915);

                            PcDetails pcDetails7118 = new PcDetails("Motherboards","MSI MAG X570 TOMAHAWK WIFI Amd X570 Soket AM4 DDR4");
                            pcDetailsArrayList.add(pcDetails7118);

                            PcDetails pcDetails7119 = new PcDetails("Motherboards","MSI H410M PRO Intel H410 Soket 1200 DDR4 2933MHz M.2 ");
                            pcDetailsArrayList.add(pcDetails7119);

                            PcDetails pcDetails870 = new PcDetails("Motherboards","MSI B550M PRO-VDH WIFI Amd B550 Soket AM4 DDR4 4400(O.C.) M.2");
                            pcDetailsArrayList.add(pcDetails870);

                            PcDetails pcDetails871 = new PcDetails("Motherboards","MSI MAG B460 TOMAHAWK Intel B460 Soket 1200 DDR4 2933MHz");
                            pcDetailsArrayList.add(pcDetails871);

                            PcDetails pcDetails872 = new PcDetails("Motherboards","MSI MPG B550 GAMING EDGE WIFI Amd B550 Soket AM4 DDR4");
                            pcDetailsArrayList.add(pcDetails872);

                            PcDetails pcDetails873 = new PcDetails("Motherboards","MSI MAG B550M MORTAR WIFI Amd B550M Soket AM4 DDR4 4400(OC)");
                            pcDetailsArrayList.add(pcDetails873);

                            PcDetails pcDetails874 = new PcDetails("Motherboards","MSI MAG B550M MORTAR Amd B550M Soket AM4 DDR4 4400(OC)");
                            pcDetailsArrayList.add(pcDetails874);

                            PcDetails pcDetails875 = new PcDetails("Motherboards","MSI MAG B550 TOMAHAWK Amd B550 Soket AM4 DDR4 5100(OC)");
                            pcDetailsArrayList.add(pcDetails875);

                            PcDetails pcDetails876 = new PcDetails("Motherboards","MSI B460M PRO-VDH WIFI Intel B460 Soket 1200 DDR4 2933(OC)");
                            pcDetailsArrayList.add(pcDetails876);

                            PcDetails pcDetails877 = new PcDetails("Motherboards","MSI MAG B460M MORTAR WIFI Intel B460 Soket 1200 DDR4 2933(OC) M.2");
                            pcDetailsArrayList.add(pcDetails877);

                            PcDetails pcDetails878 = new PcDetails("Motherboards","MSI MAG B460M MORTAR Intel B460 Soket 1200 DDR4 2933(OC)");
                            pcDetailsArrayList.add(pcDetails878);

                            PcDetails pcDetails879 = new PcDetails("Motherboards","MSI Z490-A PRO Intel Z490 Soket 1200 DDR4 4800(OC) M.2");
                            pcDetailsArrayList.add(pcDetails879);

                            PcDetails pcDetails970 = new PcDetails("Motherboards","MSI MAG Z490 TOMAHAWK Intel Z490 Soket 1200 DDR4 4800(OC)");
                            pcDetailsArrayList.add(pcDetails970);

                            PcDetails pcDetails971 = new PcDetails("Motherboards","MSI X299 PRO Intel X299 Soket 2066 DDR4 4200(OC) M.2 ");
                            pcDetailsArrayList.add(pcDetails971);

                            PcDetails pcDetails972 = new PcDetails("Motherboards","MSI MEG X570 UNIFY Amd X570 Soket AM4 DDR4 4600(OC) M.2 ");
                            pcDetailsArrayList.add(pcDetails972);

                            PcDetails pcDetails973 = new PcDetails("Motherboards","MSI A320M-A PRO MAX Amd A320 Soket AM4 DDR4 3200(OC) M.2");
                            pcDetailsArrayList.add(pcDetails973);

                            PcDetails pcDetails974 = new PcDetails("Motherboards","MSI B450-A PRO MAX Amd B450 Soket AM4 DDR4 3466(OC) M.2");
                            pcDetailsArrayList.add(pcDetails974);

                            PcDetails pcDetails975 = new PcDetails("Motherboards","MSI B450 GAMING PLUS MAX Amd B450 Soket AM4 DDR4 3466(OC)");
                            pcDetailsArrayList.add(pcDetails975);

                            PcDetails pcDetails931 = new PcDetails("Motherboards","MSI B450 TOMAHAWK MAX Amd B450 Soket AM4 DDR4 3466(OC)");
                            pcDetailsArrayList.add(pcDetails931);

                            PcDetails pcDetails932 = new PcDetails("Motherboards","MSI X570-A PRO Amd X570 Soket AM4 DDR4 4000(OC) M.2");
                            pcDetailsArrayList.add(pcDetails932);

                             PcDetails pcDetails933 = new PcDetails("Motherboards","MSI MPG X570 GAMING PLUS Amd X570 Soket AM4 DDR4 4400(OC)");
                            pcDetailsArrayList.add(pcDetails933);

                            PcDetails pcDetails9332 = new PcDetails("Motherboards","MSI MPG X570 GAMING EDGE WIFI Amd X570 Soket AM4 DDR4");
                            pcDetailsArrayList.add(pcDetails9332);

                            PcDetails pcDetails9333 = new PcDetails("Motherboards","MSI MEG X570 ACE Amd X570 Soket AM4 DDR4 4600(OC) M.2 ");
                            pcDetailsArrayList.add(pcDetails9333);

                            PcDetails pcDetails9334 = new PcDetails("Motherboards","MSI B365M PRO-VH Intel B365 Soket 1151 DDR4 2666 M.2 ");
                            pcDetailsArrayList.add(pcDetails9334);

                            PcDetails pcDetails9335 = new PcDetails("Motherboards","MSI Z390-A PRO Intel Z390 Soket 1151 DDR4 4400(OC) M.2");
                            pcDetailsArrayList.add(pcDetails9335);


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
                           searchView = view.findViewById(R.id.searchView_anakart);
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
                           searchView = view.findViewById(R.id.searchView_anakart);
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