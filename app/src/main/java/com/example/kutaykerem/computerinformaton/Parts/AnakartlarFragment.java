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

        PcDetails pcDetails4 = new PcDetails("Anakartlar","ASUS PRIME H510M-D Intel H510 Soket 1200 DDR4 3200MHz(OC) M.2");
        PcDetails pcDetails5 = new PcDetails("Anakartlar","ASUS PRIME H510M-E Intel H510 Soket 1200 DDR4 3200MHz(OC) M.2");
        PcDetails pcDetails3 = new PcDetails("Anakartlar","ASUS TUF GAMING B550M-PLUS AMD B550 Soket AM4 Ryzen DDR4");
        PcDetails pcDetails2 = new PcDetails("Anakartlar","ASUS PRIME B450M-K II AMD B450 Soket AM4 DDR4 4400MHz(O.C.)");
        PcDetails pcDetails = new PcDetails("Anakartlar","ASUS TUF GAMING X570-PLUS (WI-FI) AM4 AMD Ryzen™ DDR4");
        PcDetails pcDetails6 = new PcDetails("Anakartlar","ASUS ROG MAXIMUS Z690 HERO EVA Intel Z690 socket 1700 DDR5");
        PcDetails pcDetails10 = new PcDetails("Anakartlar","ASUS PRIME B550M-A WIFI II AMD B550 socket AM4 Ryzen DDR4");
        PcDetails pcDetails19 = new PcDetails("Anakartlar","ASUS TUF GAMING B660M-PLUS D4 Intel B660 socket DDR4 5333MHz");
        PcDetails pcDetails7 = new PcDetails("Anakartlar","ASUS ROG STRIX B660-G GAMING WIFI Intel B660 socket 1700 DDR5");
        PcDetails pcDetails14 = new PcDetails("Anakartlar","ASUS PRIME B550-PLUS AMD B550 socket AM4 Ryzen DDR4 4600MHz");
        PcDetails pcDetails16 = new PcDetails("Anakartlar","ASUS PRIME H410M-A INTEL H410 socket 1200 DDR4 2933MHz(O.C)");
        PcDetails pcDetails9 = new PcDetails("Anakartlar","ASUS PRIME Z690-P WIFI Intel Z690 socket 1700 DDR5 6000MHz (OC)");
        PcDetails pcDetails20 = new PcDetails("Anakartlar","ASUS PRIME Z690-P Intel Z690 socket 1700 128GB DDR5");
        PcDetails pcDetails18 = new PcDetails("Anakartlar","ASUS ROG STRIX GAMING WIFI Z690-E Intel socket 1700 DDR5");
        PcDetails pcDetails11 = new PcDetails("Anakartlar","ASUS PRIME H610M-E D4 Intel H610 socket 1700 DDR4 3200MHz");
        PcDetails pcDetails15 = new PcDetails("Anakartlar","ASUS ROG CROSSHAIR VIII DARK HERO X570 AM4 AMD Ryzen DDR4");
        PcDetails pcDetails12 = new PcDetails("Anakartlar","ASUS PRIME A520M-E A520 socket AM4 AMD Ryzen DDR4 4600MHz");
        PcDetails pcDetails21 = new PcDetails("Anakartlar","ASUS PRIME H610M-K D4 Intel H610 socket 1700 DDR4 3200MHz");
        PcDetails pcDetails25 = new PcDetails("Anakartlar","ASUS TUF GAMING Z690-PLUS WF D4 Intel Z690 socket 1700 DDR4");
        PcDetails pcDetails17 = new PcDetails("Anakartlar","ASUS TUF GAMING Z690-PLUS D4 Intel Z690 socket 1700 DDR4");
        PcDetails pcDetails22 = new PcDetails("Anakartlar","ASUS ROGSTRIX Z690-A GAMING WIFI D4 Intel Z690 socket 1700 DDR4");
        PcDetails pcDetails23 = new PcDetails("Anakartlar","ASUS B450M-DRAGON AMD B450 socket AM4 4400MHz(O.C.) M.2");
        PcDetails pcDetails24 = new PcDetails("Anakartlar","ASUS PRIME H510M-A Intel H510 socket 1200 DDR4 3200MHz(OC) M.2");
        PcDetails pcDetails26 = new PcDetails("Anakartlar","ASUS TUF GAMING B550-PLUS WF AMD B550 socket AM4 Ryzen DDR4");
        PcDetails pcDetails28 = new PcDetails("Anakartlar","ASUS PRIME B550-PLUS AMD B550 socket AM4 Ryzen DDR4 4600MHz");
        PcDetails pcDetails27 = new PcDetails("Anakartlar","ASUS PRIME H410M-A INTEL H410 socket 1200 DDR4 2933MHz(O.C)");
        PcDetails pcDetails29 = new PcDetails("Anakartlar","ASUS PRIME Z690-P WIFI Intel Z690 socket 1700 DDR5 6000MHz (OC)");
        PcDetails pcDetails31 = new PcDetails("Anakartlar","ASUS ROG STRIX GAMING WIFI Z690-E Intel socket 1700 DDR5");
        PcDetails pcDetails32 = new PcDetails("Anakartlar","ASUS ROGSTRIX Z690-A GAMING WIFI Intel Z690  socket 1700 DDR5");
        PcDetails pcDetails33 = new PcDetails("Anakartlar","ASUS TUF GAMING Z690-PLUS WIFI Intel Z690 socket 1700 DDR5");
        PcDetails pcDetails34 = new PcDetails("Anakartlar","ASUS TUF GAMING Z690-PLUS Intel Z690 socket 1700 DDR5 6000MHz");
        PcDetails pcDetails35 = new PcDetails("Anakartlar","ASUS ROG MAXIMUS Z690 FORMULA Intel Z690 socket 1700");
        PcDetails pcDetails36 = new PcDetails("Anakartlar","ASUS TUF GAMING B660M-PLUS WIFI Intel B660 socket 1700 DDR5");
        PcDetails pcDetails37 = new PcDetails("Anakartlar","ASUS ROG STRIX B660-A GAMING WF Intel socket 1700 DDR5 6000MHz");
        PcDetails pcDetails38 = new PcDetails("Anakartlar","ASUS TUF GAMING B660M-PLUS WIFI D4 Intel B660 socket DDR4");
        PcDetails pcDetails39 = new PcDetails("Anakartlar","ASUS PRIME B660-PLUS D4 Intel B660 socket 1700 DDR4 5066MHz");
        PcDetails pcDetails40 = new PcDetails("Anakartlar","ASUS PRIME B660M-A WIFI D4 Intel B660 socket 1700 DDR4 3200MHz");
        PcDetails pcDetails41 = new PcDetails("Anakartlar","ASUS ROG STRIX B660-A GAMING WF Intel B660 socket 1700 DDR4");
        PcDetails pcDetails42 = new PcDetails("Anakartlar","ASUS PRIME Z690-P D4 Intel Z690 socket 1700128GB DDR4 5333MHz");
        PcDetails pcDetails43 = new PcDetails("Anakartlar","ASUS TUF GAMING H670-PRO WIFI D4 Intel socket 1700 DDR4 3200MHz");
        PcDetails pcDetails45 = new PcDetails("Anakartlar","ASUS TUF GAMING B660-PLUS WIFI D4 Intel socket 1700 DDR4");
        PcDetails pcDetails44 = new PcDetails("Anakartlar","ASUS TUF GAMING B660M-E D4 Intel B660 socket 1700 DDR4");
        PcDetails pcDetails46 = new PcDetails("Anakartlar","ASUS PROART B660-CREATOR D4 Intel B660 socket 1700 DDR4");
        PcDetails pcDetails47 = new PcDetails("Anakartlar","ASUS PRIME H670-PLUS D4 Intel H570 socket 1700 DDR4 2933MHz");
        PcDetails pcDetails48 = new PcDetails("Anakartlar","ASUS PRIME H610M-D D4 Intel H610 socket 1700 DDR4 3200MHz");
        PcDetails pcDetails51 = new PcDetails("Anakartlar","ASUS PRIME H610M-A D4 Intel H610 socket 1700 DDR4 3200MHz");
        PcDetails pcDetails50 = new PcDetails("Anakartlar","ASUS PRIME B660M-A D4 Intel B660 socket 1700 DDR4 3200MHz (OC)");
        PcDetails pcDetails52 = new PcDetails("Anakartlar","ASUS ROG CROSSHAIR VIII FORMULA X570 AMD socket AM4");
        PcDetails pcDetails49 = new PcDetails("Anakartlar","ASUS ROG STRIX Z690-G GAMING WIFI Intel Z690 socket 1700 DDR5");
        PcDetails pcDetails53 = new PcDetails("Anakartlar","ASUS PRIME Z690-P WIFI D4 Intel PRIME Z690-P socket 1700 DDR4");
        PcDetails pcDetails54 = new PcDetails("Anakartlar","ASUS ROG STRIX Z690-F GAMING WF Intel Z690 socket 1700 DDR5");
        PcDetails pcDetails55 = new PcDetails("Anakartlar","ASUS PRIME Z690M-PLUS D4 Intel Z690 socket 1700 DDR4 5333MHz");
        PcDetails pcDetails56 = new PcDetails("Anakartlar","ASUS PRIME Z690-A Intel Z690 socket 1700 DDR5 6000MHz (OC)");
        PcDetails pcDetails57 = new PcDetails("Anakartlar","ASUS ProArt X570-CREATOR WIFI AMD X570 AM4 socket DDR4");
        PcDetails pcDetails58 = new PcDetails("Anakartlar","ASUS PRIME B460I-PLUS INTEL B460 socket 1200 DDR4");
        PcDetails pcDetails65 = new PcDetails("Anakartlar","ASUS EX-H510M-V3 INTEL H510 socket 1200 DDR4 3200MHz(O.C)");
        PcDetails pcDetails66 = new PcDetails("Anakartlar","ASUS TUF GAMING A520M PLUS II socket AM4 AMD Ryzen DDR4");
        PcDetails pcDetails67 = new PcDetails("Anakartlar","ASUS TUF GAMING A520M PLUS WIFI socket AM4 AMD Ryzen DDR4");
        PcDetails pcDetails64 = new PcDetails("Anakartlar","ASUS TUF GAMING B560M-E Intel B560 socket 1200 DDR4 5000MHz");
        PcDetails pcDetails68 = new PcDetails("Anakartlar","ASUS PRIME A520M-A II A520 socket AM4 AMD Ryzen DDR4 4800MHz4");
        PcDetails pcDetails59 = new PcDetails("Anakartlar","ASUS PRIME B560M-K Intel B560 socket 1200 DDR4 4800MHz(OC) M.2");
        PcDetails pcDetails69 = new PcDetails("Anakartlar","ASUS PRIME B560M-A Intel B560 socket 1200 DDR4 5000MHz(OC) M.2");
        PcDetails pcDetails71 = new PcDetails("Anakartlar","ASUS PRIME H570M-PLUS Intel H570 socket 1200 DDR4 4600MHz");
        PcDetails pcDetails70 = new PcDetails("Anakartlar","ASUS PRIME Z590-P Intel Z590 socket 1200 DDR4 5133MHz(OC) M.2");
        PcDetails pcDetails75 = new PcDetails("Anakartlar","ASUS TUF GAMING Z590-PLUS Intel Z590 socket 1200 DDR4");
        PcDetails pcDetails73 = new PcDetails("Anakartlar","ASUS ROG MAXIMUS XIII EXTREME Intel Z590 socket 1200");
        PcDetails pcDetails62 = new PcDetails("Anakartlar","ASUS ROG STRIX B550 - XE GAMING WF AM4 socket AMD Ryzen");
        PcDetails pcDetails72 = new PcDetails("Anakartlar","ASUS TUF GAMING B450-PLUS II AMD B450 socket AM4 Ryzen DDR4");
        PcDetails pcDetails76 = new PcDetails("Anakartlar","ASUS ROG CROSSHAIR VIII HERO WF AMD X570 AM4 Ryzen DDR4");
        PcDetails pcDetails61 = new PcDetails("Anakartlar","ASUS PRIME B450M-A II AMD B450 socket AM4 DDR4 4400MHz(O.C.)");
        PcDetails pcDetails60 = new PcDetails("Anakartlar","ASUS TUF GAMING B450M-PLUS II AMD B450 socket AM4 DDR4");
        PcDetails pcDetails83 = new PcDetails("Anakartlar","ASUS TUF GAMING X570-PRO (WI-FI) AM4 X570 AM4 DDR4 5100MHz");
        PcDetails pcDetails77 = new PcDetails("Anakartlar","ASUS TUF GAMING A520M-PLUS A520 socket AM4 AMD Ryzen DDR4");
        PcDetails pcDetails79 = new PcDetails("Anakartlar","ASUS PRIME A520M-K A520 socket AM4 AMD Ryzen DDR4 4600MHz");
        PcDetails pcDetails82 = new PcDetails("Anakartlar","ASUS TUF GAMING B450M-PRO S Amd B450 AM4 socket DDR4");
        PcDetails pcDetails80 = new PcDetails("Anakartlar","ASUS PRIME B550M-A (WI-FI) AMD B550 socket AM4 Ryzen DDR4");
        PcDetails pcDetails81 = new PcDetails("Anakartlar","ASUS PRIME B460M-K INTEL B460 socket 1200 DDR4 2933MHz(O.C)");
        PcDetails pcDetails74 = new PcDetails("Anakartlar","ASUS TUF H310M PLUS R2.0 Intel H310M socket 1151 DDR4");
        PcDetails pcDetails78 = new PcDetails("Anakartlar","ASUS PRIME H310M-F R2.0 Intel H310 socket 1151 DDR4");
        PcDetails pcDetails84 = new PcDetails("Anakartlar","ASUS ROG CROSSHAIR VIII IMPACT AMD X570 AM4 Ryzen");
        PcDetails pcDetails87 = new PcDetails("Anakartlar","ASUS PRIME A320M-F A320 AM4 AMD Ryzen™ DDR4 3200(O.C.) MHz");
        PcDetails pcDetails85 = new PcDetails("Anakartlar","ASUS PRIME X570-P AMD X570 AM4 Ryzen DDR4 4400MHz (O.C.)");
        PcDetails pcDetails91 = new PcDetails("Anakartlar","ASUS ROG STRIX X570-F GAMING AMD X570 AM4 Ryzen DDR4");
        PcDetails pcDetails90 = new PcDetails("Anakartlar","ASUS PRIME H310M-K R2.0 Intel H310 socket 1151 DDR4");
        PcDetails pcDetails89 = new PcDetails("Anakartlar","ASUS PRIME B365M-K Intel B365 socket 1151 DDR4");
        PcDetails pcDetails93 = new PcDetails("Anakartlar","ASUS TUF B450M-PRO GAMING AMD B450 socket AM4 Ryzen DDR4");
        PcDetails pcDetails92 = new PcDetails("Anakartlar","ASUS TUF B450-PRO GAMING AMD B450 socket AM4 Ryzen DDR4");
        PcDetails pcDetails94 = new PcDetails("Anakartlar","ASUS TUF B450M-PLUS GAMING AMD B450 AM4 Ryzen™ DDR4");
        PcDetails pcDetails95 = new PcDetails("Anakartlar","ASUS TUF B450-PLUS GAMING AMD B450 socket AM4 Ryzen™");
        PcDetails pcDetails98 = new PcDetails("Anakartlar","ASUS PRIME A320M-E A320 AM4 AMD Ryzen™ DDR4 3200(O.C.) MHz");
        PcDetails pcDetails86 = new PcDetails("Anakartlar","ASUS EX-A320M-GAMING A320  socket AM4 AMD Ryzen™DDR4");
        PcDetails pcDetails99 = new PcDetails("Anakartlar","ASUS PRIME A320M-K A320 AM4 AMD Ryzen™ DDR4 3200(O.C.) MHz");
        PcDetails pcDetails96 = new PcDetails("Anakartlar","GIGABYTE H510M H UD Intel H510 socket 1200 DDR4 3200MHz M.2");
        PcDetails pcDetails100 = new PcDetails("Anakartlar","GIGABYTE H610M H 3200MHz DDR4 socket1700 M.2 HDMI D-Sub");
        PcDetails pcDetails102 = new PcDetails("Anakartlar","GIGABYTE H610M H 3200MHz DDR4 socket1700 M.2 HDMI D-Sub");
        PcDetails pcDetails97 = new PcDetails("Anakartlar","GIGABYTE B560M H 3200MHz (O.C) DDR4 socket  1200 M.2 HDMI D-Sub");
        PcDetails pcDetails104 = new PcDetails("Anakartlar","GIGABYTE Z690 ULTRA DURABLE Intel socket1700 DDR5 6000MHz (O.C) M.2");
        PcDetails pcDetails101 = new PcDetails("Anakartlar","GIGABYTE B450M H UD AMD B450 socket AM4 DDR4 3600MHZ (O.C)");
        PcDetails pcDetails88 = new PcDetails("Anakartlar","GIGABYTE H310M H Intel H310 socket 8.-9.  1151 DDR4");
        PcDetails pcDetails106 = new PcDetails("Anakartlar","GIGABYTE Z590 GAMING X Intel Z590 socket 1200 DDR4 5333(O.C)");
        PcDetails pcDetails108 = new PcDetails("Anakartlar","GIGABYTE B460M GAMING HD Intel B460 socket 1200 DDR4 2933MHz");
        PcDetails pcDetails105 = new PcDetails("Anakartlar","GIGABYTE Z590 AORUS MASTER Intel Z590 socket 1200 DDR4");
        PcDetails pcDetails103 = new PcDetails("Anakartlar","GIGABYTE B450M S2H V2 AMD B450 socket AM4 DDR4");
        PcDetails pcDetails109 = new PcDetails("Anakartlar","GIGABYTE GA-A520M-S2H AMD A520 socket AM4 DDR4 5100MHz");
        PcDetails pcDetails107 = new PcDetails("Anakartlar","GIGABYTE B460M D2V Intel B460M socket 1200 DDR4 2933MHz M.2");
        PcDetails pcDetails115 = new PcDetails("Anakartlar","GIGABYTE Z490I AORUS ULTRA Intel Z490 socket 1200 DDR4");
        PcDetails pcDetails117 = new PcDetails("Anakartlar","GIGABYTE B550 GAMING X Amd B550 socket AM4 DDR4 4000MHz");
        PcDetails pcDetails112 = new PcDetails("Anakartlar","GIGABYTE H310M H 2.0 Intel H310 socket  8.-9. 1151 DDR4");
        PcDetails pcDetails1143 = new PcDetails("Anakartlar","GIGABYTE GA-A320M-S2H A320 Socket AM4 AMD Ryzen™ DDR4");
        PcDetails pcDetails113 = new PcDetails("Anakartlar","MSI PRO H610M-B DDR4 Intel H610 socket 1700 3200MHz (OC) M.2");
        PcDetails pcDetails116 = new PcDetails("Anakartlar","MSI B450M-A PRO MAX Amd B450    socket AM4 DDR4 3466(OC) M.2");
        PcDetails pcDetails200 = new PcDetails("Anakartlar","MSI H510M-A PRO Intel H510      socket 1200 DDR4 3200MHz (OC) M.2");
        PcDetails pcDetails114 = new PcDetails("Anakartlar","MSI H310M PRO-VDH PLUS Intel H310 socket 1151 DDR4 2666");
        PcDetails pcDetails203 = new PcDetails("Anakartlar","MSI PRO H410M-B Intel H410 socket 1200 DDR4 2933MHz M.2 ");
        PcDetails pcDetails111 = new PcDetails("Anakartlar","MSI MAG B460M BAZOOKA Intel B460 socket 1200 DDR4 2933MHz");
        PcDetails pcDetails201 = new PcDetails("Anakartlar","MSI B550M-A PRO Amd B550 socket AM4 DDR4 4600(O.C.) M.2 ");
        PcDetails pcDetails202 = new PcDetails("Anakartlar","MSI PRO Z690-A Intel Z690 socket 1700 DDR4 5200MHz (OC) M.2");
        PcDetails pcDetails110 = new PcDetails("Anakartlar","MSI MEG Z590 UNIFY Intel Z590 socket 1200 DDR4 5600(O.C.) M.2");
        PcDetails pcDetails204 = new PcDetails("Anakartlar","MSI MEG Z590 ACE Intel Z590 socket1200 DDR4 5600(O.C.) M.2 ");
        PcDetails pcDetails118 = new PcDetails("Anakartlar","MSI B550-A PRO Amd B550  socket AM4 DDR4 4400MHz M.2");
        PcDetails pcDetails206 = new PcDetails("Anakartlar","MSI MAG B660 TOMAHAWK WIFI DDR4 Intel B660 socket 1700 DDR4");
        PcDetails pcDetails205 = new PcDetails("Anakartlar","MSI PRO Z690-A WIFI Intel Z690 socket 1700 DDR5 6400MHz (OC)");
        PcDetails pcDetails119 = new PcDetails("Anakartlar","MSI MEG Z590 ACE GOLD EDITION Intel Z590  1200 DDR4");
        PcDetails pcDetails872 = new PcDetails("Anakartlar","MSI MPG Z590 GAMING PLUS Intel Z590 socket 1200 DDR4 5333MHz");
        PcDetails pcDetails873 = new PcDetails("Anakartlar","MSI H310M PRO-M2 PLUS Intel H310  socket 1151 DDR4 2666 M.2");
        PcDetails pcDetails874 = new PcDetails("Anakartlar","MSI MPG B550 GAMING PLUS Amd B550 socket AM4 DDR4 4400(OC)");
        PcDetails pcDetails875 = new PcDetails("Anakartlar","MSI MPG Z690 EDGE WIFI Intel Z690 socket 1700 DDR5 6400MHz");
        PcDetails pcDetails876 = new PcDetails("Anakartlar","MSI PRO H610M-G Intel H610 socket 1700 DDR4 3200MHz (OC) M.2");
        PcDetails pcDetails877 = new PcDetails("Anakartlar","MSI PRO B660M-E Intel B660 socket 1700 DDR4 4600MHz (OC) M.2");
        PcDetails pcDetails878 = new PcDetails("Anakartlar","MSI PRO B660M-B Intel B660 socket 1700 DDR4 4600MHz (OC) M.2");
        PcDetails pcDetails879 = new PcDetails("Anakartlar","MSI PRO B660M-A WIFI Intel B660 socket 1700 DDR4 4800MHz (OC)");
        PcDetails pcDetails970 = new PcDetails("Anakartlar","MSI MAG B660M MORTAR WIFI Intel B660socket 1700 DDR5 6200MHz");
        PcDetails pcDetails971 = new PcDetails("Anakartlar","MSI MPG Z690 EDGE WIFI Intel Z690 socket 1700 DDR4 5200MHz");
        PcDetails pcDetails972 = new PcDetails("Anakartlar","MSI H510M PRO Intel H510  socket 1200 DDR4 3200MHz (OC) M.2");
        PcDetails pcDetails973 = new PcDetails("Anakartlar","MSI MPG Z590 GAMING EDGE WIFI Intel Z590 socket 1200 DDR4");
        PcDetails pcDetails974 = new PcDetails("Anakartlar", "MSI B460M PRO-VDH Intel B460 socket 1200 DDR4 2933(O.C.) M.2");
        PcDetails pcDetails975 = new PcDetails("Anakartlar", "MSI MAG B460 TORPEDO socket 1200 DDR4 2933(O.C.) M.2 ");
        PcDetails pcDetails931 = new PcDetails("Anakartlar", "MSI MPG B550 GAMING CARBON WIFI Amd B550 socket AM4 DDR4 5100(O.C.) M.2 ");
        PcDetails pcDetails932 = new PcDetails("Anakartlar", "MSI B460M-A PRO Intel B460 socket 1200 DDR4 2933(OC) M.2 ");
        PcDetails pcDetails933 = new PcDetails("Anakartlar" ,"MSI B450M PRO-M2 MAX Amd B450 socket AM4 DDR4 3466(OC) M.2");
        PcDetails pcDetails9332 = new PcDetails("Anakartlar","MSI A320M-A PRO Amd A320 socket AM4 DDR4 3200(OC) ");
        PcDetails pcDetails9333 = new PcDetails("Anakartlar","MSI H610M BOMBER DDR4 3200MHz(OC) socket 1700 M.2 HDMI");
        PcDetails pcDetails9334 = new PcDetails("Anakartlar","MSI PRO B660M-P WIFI DDR4 Intel B660 socket 1700 DDR4 4600MHz");
        PcDetails pcDetails209 = new PcDetails("Anakartlar","MSI B660 BOMBER DDR4 4600MHz (OC) DDR4 socket 1700 M.2 HDMI");
        PcDetails pcDetails9335 = new PcDetails("Anakartlar","MSI PRO B660M-P DDR4 Intel B660 socket 1700 DDR4 4600MHz (OC) M.2");
        PcDetails pcDetails210 = new PcDetails("Anakartlar","MSI PRO B550M-P GEN3 B550 socket AM4 DDR4 4400MHz (OC) M.2");
        PcDetails pcDetails213 = new PcDetails("Anakartlar" ,"MSI PRO B550-P GEN3 B550 socket AM4 DDR4 4400MHz (OC) M.2");
        PcDetails pcDetails224 = new PcDetails("Anakartlar" ,"MSI H510I PRO WIFI 3200MHz DDR4 socket 1200 M.2 HDMI mITX");
        PcDetails pcDetails244 = new PcDetails("Anakartlar" ,"MSI MAG B660M BAZOOKA 4800MHz(OC) DDR4 socket 1700 M.2");
        PcDetails pcDetails234 = new PcDetails("Anakartlar" ,"MSI PRO B660-A Intel B660 socket 1700 DDR4 4800MHz (OC) M.2");
        PcDetails pcDetails208 = new PcDetails("Anakartlar" ,"MSI PRO B660M-A WIFI Intel B660 socket 1700 DDR5 6200MHz (OC)");
        PcDetails pcDetails212 = new PcDetails("Anakartlar" ,"MSI MAG H670 TOMAHAWK WIFI Intel H670 socket 1700 DDR4");
        PcDetails pcDetails255 = new PcDetails("Anakartlar" ,"MSI PRO B660M-A DDR4 Intel B660 socket 1700 DDR4 4600MHz (OC)");
        PcDetails pcDetails288 = new PcDetails("Anakartlar" ,"MSI PRO B660M-A DDR4 Intel B660 socket 1700 DDR4 4600MHz (OC)");
        PcDetails pcDetails211 = new PcDetails("Anakartlar" ,"MSI MAG Z690 TOMAHAWK WIFI Intel Z690 socket 1700 DDR5");
        PcDetails pcDetails266 = new PcDetails("Anakartlar" ,"MSI PRO B660M-G Intel B660 socket 1700 DDR4 4600MHz (OC) M.2");
        PcDetails pcDetails299 = new PcDetails("Anakartlar" ,"MSI MAG B660M MORTAR Intel B660 socket 1700 DDR5 6200MHz");
        PcDetails pcDetails300 = new PcDetails("Anakartlar" ,"MSI MAG B660 TOMAHAWK WIFI Intel B660 socket 1700 DDR5");
        PcDetails pcDetails333 = new PcDetails("Anakartlar" ,"MSI MAG Z690M MORTAR WIFI Intel Z690 socket 1700 DDR5 6200MHz");
        PcDetails pcDetails377= new PcDetails("Anakartlar","MSI MAG B660M MORTAR DDR4 Intel B660 socket 1700 DDR4");
        PcDetails pcDetails320 = new PcDetails("Anakartlar" ,"MSI MAG B660M MORTAR WIFI DDR4 Intel B660 socket 1700 DDR4");
        PcDetails pcDetails366 = new PcDetails("Anakartlar" ,"MSI H510M PRO-E Intel H510 socket 1200 DDR4 3200MHz (OC)");
        PcDetails pcDetails277 = new PcDetails("Anakartlar" ,"MSI PRO Z690-P DDR4 Intel Z690  socket 1700 DDR4 5200MHz(OC) M.2");
        PcDetails pcDetails355 = new PcDetails("Anakartlar" ,"MSI MAG Z690 TORPEDO Intel Z690 socket 1700 DDR5 6400MHz(OC)");
        PcDetails pcDetails412 = new PcDetails("Anakartlar" ,"MSI MAG Z690 TOMAHAWK WIFI DDR4 Intel Z690 socket 1700 DDR4");
        PcDetails pcDetails401 = new PcDetails("Anakartlar" ,"MSI MEG X570S UNIFY-X MAX Amd X570 socket AM4 DDR4");
        PcDetails pcDetails391 = new PcDetails("Anakartlar" ,"MSI PRO Z690-A WIFI Intel Z690 socket 1700 DDR4 5200MHz (OC)");
        PcDetails pcDetails344 = new PcDetails("Anakartlar" ,"MSI PRO Z690-A Intel Z690 socket 1700 DDR5 6400MHz (OC) M.2");
        PcDetails pcDetails207 = new PcDetails("Anakartlar" ,"MSI MPG Z690 FORCE WIFI Intel Z690 socket 1700 DDR5 6666MHz");
        PcDetails pcDetails421 = new PcDetails("Anakartlar" ,"MSI MPG Z690 CARBON WIFI Intel Z690 socket 1700 DDR5 6666MHz");
        PcDetails pcDetails381 = new PcDetails("Anakartlar" ,"MSI B560-A PRO Intel B560 socket 1200 DDR4 5066MHz (OC) M.2");
        PcDetails pcDetails433 = new PcDetails("Anakartlar" ,"MSI MPG X570S CARBON MAX WIFI Amd X570 socket AM4 DDR4");
        PcDetails pcDetails456 = new PcDetails("Anakartlar" ,"MSI MPG X570S EDGE MAX WIFI Amd X570 socket AM4 DDR4");
        PcDetails pcDetails477 = new PcDetails("Anakartlar" ,"MSI MEG X570S ACE MAX Amd X570 socket AM4 DDR4 5300MHz");
        PcDetails pcDetails467 = new PcDetails("Anakartlar" ,"MSI MAG X570S TORPEDO MAX Amd X570 socket AM4 DDR4");
        PcDetails pcDetails499 = new PcDetails("Anakartlar" ,"MSI MAG X570S TOMAHAWK MAX WIFI Amd X570 socket AM4 DDR4");
        PcDetails pcDetails512 = new PcDetails("Anakartlar" ,"MSI A320M PRO-VH Amd A320 socket AM4 DDR4 3200(OC) M.2");
        PcDetails pcDetails488 = new PcDetails("Anakartlar" ,"MSI MAG B560 TORPEDO Intel B560 socket 1200 DDR4 5066MHz (OC)");
        PcDetails pcDetails513 = new PcDetails("Anakartlar" ,"MSI MAG B560M MORTAR Intel B560 socket 1200 DDR4 5066MHz");
        PcDetails pcDetails444 = new PcDetails("Anakartlar" ,"MSI MAG B560 TOMAHAWK WIFI Intel B560 socket 1200 DDR4");
        PcDetails pcDetails516 = new PcDetails("Anakartlar" ,"MSI Z590 PLUS Intel Z590 socket 1200 DDR4 5333MHz (OC) M.2");
        PcDetails pcDetails511 = new PcDetails("Anakartlar" ,"MSI MAG Z590 TOMAHAWK WIFI Intel Z590 socket 1200 DDR4");
        PcDetails pcDetails517 = new PcDetails("Anakartlar" ,"MSI B450 TOMAHAWK MAX II Amd B450 socket AM4 DDR4 4333MHz");
        PcDetails pcDetails518 = new PcDetails("Anakartlar" ,"MSI B560M PRO WIFI Intel B560 socket 1200 DDR4 5200MHz (OC)");
        PcDetails pcDetails519 = new PcDetails("Anakartlar" ,"MSI MAG B560M MORTAR WIFI Intel B560 socket 1200 DDR4 5066MHz");
        PcDetails pcDetails611 = new PcDetails("Anakartlar" ,"MSI B560M-A PRO Intel B560 socket 1200 DDR4 5200MHz (OC) M.2");
        PcDetails pcDetails610 = new PcDetails("Anakartlar" ,"MSI B560M PRO-E Intel B560 socket 1200 DDR4 4800MHz (OC) M.2 ");
        PcDetails pcDetails631 = new PcDetails("Anakartlar" ,"MSI B560M PRO Intel B560 socket 1200 DDR4 5200MHz (OC) M.2");
        PcDetails pcDetails514 = new PcDetails("Anakartlar" ,"MSI MAG B560M BAZOOKA Intel B560 socket 1200 DDR4 5066MHz");
        PcDetails pcDetails515 = new PcDetails("Anakartlar" ,"MSI MPG Z590 GAMING FORCE Intel Z590 socket 1200 DDR4");
        PcDetails pcDetails621 = new PcDetails("Anakartlar" ,"MSI MAG Z590 TORPEDO Intel Z590 socket 1200 DDR4 5333(O.C.) M.2");
        PcDetails pcDetails662 = new PcDetails("Anakartlar" ,"MSI B560M PRO-VDH Intel B560M socket 1200 DDR4 5066(O.C.) M.2");
        PcDetails pcDetails671 = new PcDetails("Anakartlar" ,"MSI B560M PRO-VDH WIFI Intel B560M socket 1200 DDR4 5066(O.C.) M.2");
        PcDetails pcDetails642 = new PcDetails("Anakartlar" ,"MSI MEG B550 UNIFY Amd B550 socket AM4 DDR4 5600MHz (OC) M.2");
        PcDetails pcDetails713 = new PcDetails("Anakartlar" ,"MSI MPG Z590-A PRO Intel Z590 socket 1200 DDR4 5333MHz (OC)");
        PcDetails pcDetails681 = new PcDetails("Anakartlar" ,"MSI MPG Z590 PRO WIFI Intel Z590 socket 1200 DDR4 5333MHz (OC)");
        PcDetails pcDetails691 = new PcDetails("Anakartlar" ,"MSI MPG Z590 GAMING CARBON WIFI Intel Z590  socket 1200 DDR4");
        PcDetails pcDetails710 = new PcDetails("Anakartlar" ,"MSI B550M PRO Amd B550 socketAM4 DDR4 4600(O.C.) M.2");
        PcDetails pcDetails711 = new PcDetails("Anakartlar","MSI MEG B550 UNIFY-X Amd B550 socket AM4 DDR4 5800MHz(OC) M.2");
        PcDetails pcDetails652 = new PcDetails("Anakartlar","MSI B550M PRO-VDH Amd B550 socket AM4 DDR4 4400(O.C.) M.2");
        PcDetails pcDetails501 = new PcDetails("Anakartlar","MSI MAG A520M VECTOR WIFI Amd A520 socket AM4 DDR4 4600");
        PcDetails pcDetails721 = new PcDetails("Anakartlar","MSI A520M PRO Amd A520  socket AM4 DDR4 4600 MHz(OC) M.2");
        PcDetails pcDetails715 = new PcDetails("Anakartlar","MSI A520M-A PRO Amd A520 socket AM4 DDR4 4600 MHz(OC) M.2");
        PcDetails pcDetails716 = new PcDetails("Anakartlar","MSI MAG X570 TOMAHAWK WIFI Amd X570 socket AM4 DDR4");
        PcDetails pcDetails821 = new PcDetails("Anakartlar","MSI H410M PRO Intel H410 socket 1200 DDR4 2933MHz M.2 ");
        PcDetails pcDetails718 = new PcDetails("Anakartlar","MSI B550M PRO-VDH WIFI Amd B550 socket AM4 DDR4 4400(O.C.) M.2");
        PcDetails pcDetails815 = new PcDetails("Anakartlar","MSI MAG B460 TOMAHAWK Intel B460 socket 1200 DDR4 2933MHz");
        PcDetails pcDetails810 = new PcDetails("Anakartlar","MSI MPG B550 GAMING EDGE WIFI Amd B550 socket AM4 DDR4");
        PcDetails pcDetails811 = new PcDetails("Anakartlar","MSI MAG B550M MORTAR WIFI Amd B550M socket AM4 DDR4 4400(OC)");
        PcDetails pcDetails719 = new PcDetails("Anakartlar","MSI MAG B550M MORTAR Amd B550M socket AM4 DDR4 4400(OC)");
        PcDetails pcDetails817 = new PcDetails("Anakartlar","MSI MAG B550 TOMAHAWK Amd B550 socket AM4 DDR4 5100(OC)");
        PcDetails pcDetails814 = new PcDetails("Anakartlar","MSI B460M PRO-VDH WIFI Intel B460 socket 1200 DDR4 2933(OC)");
        PcDetails pcDetails819 = new PcDetails("Anakartlar","MSI MAG B460M MORTAR WIFI Intel B460 socket 1200 DDR4 2933(OC) M.2 ");
        PcDetails pcDetails901 = new PcDetails("Anakartlar","MSI MAG B460M MORTAR Intel B460 socket 1200 DDR4 2933(OC)");
        PcDetails pcDetails911 = new PcDetails("Anakartlar" ,"MSI Z490-A PRO Intel Z490 socket 1200 DDR4 4800(OC) M.2 ");
        PcDetails pcDetails818 = new PcDetails("Anakartlar" ,"MSI MAG Z490 TOMAHAWK Intel Z490 socket 1200 DDR4 4800(OC)");
        PcDetails pcDetails816 = new PcDetails("Anakartlar" ,"MSI X299 PRO Intel X299 socket 2066 DDR4 4200(OC) M.2 ");
        PcDetails pcDetails813 = new PcDetails("Anakartlar" ,"MSI MEG X570 UNIFY Amd X570 socket AM4 DDR4 4600(OC) M.2");
        PcDetails pcDetails717 = new PcDetails("Anakartlar" ,"MSI A320M-A PRO MAX Amd A320 socket AM4 DDR4 3200(OC) M.2");
        PcDetails pcDetails913 = new PcDetails("Anakartlar" ,"MSI B450-A PRO MAX Amd B450 socket AM4 DDR4 3466(OC) M.2");
        PcDetails pcDetails7119 = new PcDetails("Anakartlar","MSI B450 GAMING PLUS MAX Amd B450 socket AM4 DDR4 3466(OC)");
        PcDetails pcDetails7118 = new PcDetails("Anakartlar","MSI B450 TOMAHAWK MAX Amd B450 socket AM4 DDR4 3466(OC)");
        PcDetails pcDetails912 = new PcDetails("Anakartlar","MSI X570-A PRO Amd X570 socket AM4 DDR4 4000(OC) M.2 ");
        PcDetails pcDetails915 = new PcDetails("Anakartlar","MSI MPG X570 GAMING PLUS Amd X570 socket AM4 DDR4 4400(OC)");
        PcDetails pcDetails714 = new PcDetails("Anakartlar","MSI MPG X570 GAMING EDGE WIFI Amd X570 socket AM4 DDR4");
        PcDetails pcDetails914 = new PcDetails("Anakartlar","MSI MEG X570 ACE Amd X570 socket AM4 DDR4 4600(OC) M.2 ");
        PcDetails pcDetails871 = new PcDetails("Anakartlar","MSI B365M PRO-VH Intel B365 socket 1151 DDR4 2666 M.2");
        PcDetails pcDetails870 = new PcDetails("Anakartlar","MSI Z390-A PRO Intel Z390 socket 1151 DDR4 4400(OC) M.2 ");



        pcDetailsArrayList.add(pcDetails714);
        pcDetailsArrayList.add(pcDetails715);
        pcDetailsArrayList.add(pcDetails716);
        pcDetailsArrayList.add(pcDetails717);
        pcDetailsArrayList.add(pcDetails718);
        pcDetailsArrayList.add(pcDetails719);
        pcDetailsArrayList.add(pcDetails810);
        pcDetailsArrayList.add(pcDetails811);
        pcDetailsArrayList.add(pcDetails821);
        pcDetailsArrayList.add(pcDetails813);
        pcDetailsArrayList.add(pcDetails814);
        pcDetailsArrayList.add(pcDetails815);
        pcDetailsArrayList.add(pcDetails816);
        pcDetailsArrayList.add(pcDetails817);
        pcDetailsArrayList.add(pcDetails818);
        pcDetailsArrayList.add(pcDetails819);
        pcDetailsArrayList.add(pcDetails901);
        pcDetailsArrayList.add(pcDetails911);
        pcDetailsArrayList.add(pcDetails912);
        pcDetailsArrayList.add(pcDetails913);
        pcDetailsArrayList.add(pcDetails914);
        pcDetailsArrayList.add(pcDetails915);
        pcDetailsArrayList.add(pcDetails7118);
        pcDetailsArrayList.add(pcDetails7119);
        pcDetailsArrayList.add(pcDetails870);
        pcDetailsArrayList.add(pcDetails871);
        pcDetailsArrayList.add(pcDetails501);
        pcDetailsArrayList.add(pcDetails511);
        pcDetailsArrayList.add(pcDetails512);
        pcDetailsArrayList.add(pcDetails513);
        pcDetailsArrayList.add(pcDetails514);
        pcDetailsArrayList.add(pcDetails515);
        pcDetailsArrayList.add(pcDetails516);
        pcDetailsArrayList.add(pcDetails517);
        pcDetailsArrayList.add(pcDetails518);
        pcDetailsArrayList.add(pcDetails519);
        pcDetailsArrayList.add(pcDetails610);
        pcDetailsArrayList.add(pcDetails611);
        pcDetailsArrayList.add(pcDetails621);
        pcDetailsArrayList.add(pcDetails631);
        pcDetailsArrayList.add(pcDetails642);
        pcDetailsArrayList.add(pcDetails652);
        pcDetailsArrayList.add(pcDetails662);
        pcDetailsArrayList.add(pcDetails671);
        pcDetailsArrayList.add(pcDetails681);
        pcDetailsArrayList.add(pcDetails691);
        pcDetailsArrayList.add(pcDetails710);
        pcDetailsArrayList.add(pcDetails711);
        pcDetailsArrayList.add(pcDetails721);
        pcDetailsArrayList.add(pcDetails713);
        pcDetailsArrayList.add(pcDetails872);
        pcDetailsArrayList.add(pcDetails103);
        pcDetailsArrayList.add(pcDetails104);
        pcDetailsArrayList.add(pcDetails105);
        pcDetailsArrayList.add(pcDetails106);
        pcDetailsArrayList.add(pcDetails107);
        pcDetailsArrayList.add(pcDetails108);
        pcDetailsArrayList.add(pcDetails109);
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
        pcDetailsArrayList.add(pcDetails204);
        pcDetailsArrayList.add(pcDetails205);
        pcDetailsArrayList.add(pcDetails206);
        pcDetailsArrayList.add(pcDetails873);
        pcDetailsArrayList.add(pcDetails874);
        pcDetailsArrayList.add(pcDetails875);
        pcDetailsArrayList.add(pcDetails877);
        pcDetailsArrayList.add(pcDetails876);
        pcDetailsArrayList.add(pcDetails879);
        pcDetailsArrayList.add(pcDetails975);
        pcDetailsArrayList.add(pcDetails974);
        pcDetailsArrayList.add(pcDetails973);
        pcDetailsArrayList.add(pcDetails878);
        pcDetailsArrayList.add(pcDetails972);
        pcDetailsArrayList.add(pcDetails931);
        pcDetailsArrayList.add(pcDetails932);
        pcDetailsArrayList.add(pcDetails971);
        pcDetailsArrayList.add(pcDetails970);
        pcDetailsArrayList.add(pcDetails933);
        pcDetailsArrayList.add(pcDetails9332);
        pcDetailsArrayList.add(pcDetails9333);
        pcDetailsArrayList.add(pcDetails9334);
        pcDetailsArrayList.add(pcDetails9335);
        pcDetailsArrayList.add(pcDetails2);
        pcDetailsArrayList.add(pcDetails);
        pcDetailsArrayList.add(pcDetails3);
        pcDetailsArrayList.add(pcDetails4);
        pcDetailsArrayList.add(pcDetails5);
        pcDetailsArrayList.add(pcDetails6);
        pcDetailsArrayList.add(pcDetails7);;
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
        pcDetailsArrayList.add(pcDetails56);
        pcDetailsArrayList.add(pcDetails57);
        pcDetailsArrayList.add(pcDetails58);
        pcDetailsArrayList.add(pcDetails47);
        pcDetailsArrayList.add(pcDetails48);
        pcDetailsArrayList.add(pcDetails49);
        pcDetailsArrayList.add(pcDetails50);
        pcDetailsArrayList.add(pcDetails51);
        pcDetailsArrayList.add(pcDetails52);
        pcDetailsArrayList.add(pcDetails59);
        pcDetailsArrayList.add(pcDetails29);
        pcDetailsArrayList.add(pcDetails31);
        pcDetailsArrayList.add(pcDetails32);
        pcDetailsArrayList.add(pcDetails33);
        pcDetailsArrayList.add(pcDetails34);
        pcDetailsArrayList.add(pcDetails35);
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
        pcDetailsArrayList.add(pcDetails46);
        pcDetailsArrayList.add(pcDetails54);
        pcDetailsArrayList.add(pcDetails53);
        pcDetailsArrayList.add(pcDetails55);
        pcDetailsArrayList.add(pcDetails60);
        pcDetailsArrayList.add(pcDetails72);
        pcDetailsArrayList.add(pcDetails61);
        pcDetailsArrayList.add(pcDetails62);
        pcDetailsArrayList.add(pcDetails64);
        pcDetailsArrayList.add(pcDetails65);
        pcDetailsArrayList.add(pcDetails66);
        pcDetailsArrayList.add(pcDetails67);
        pcDetailsArrayList.add(pcDetails68);
        pcDetailsArrayList.add(pcDetails69);
        pcDetailsArrayList.add(pcDetails70);
        pcDetailsArrayList.add(pcDetails71);
        pcDetailsArrayList.add(pcDetails73);
        pcDetailsArrayList.add(pcDetails74);
        pcDetailsArrayList.add(pcDetails75);
        pcDetailsArrayList.add(pcDetails76);
        pcDetailsArrayList.add(pcDetails77);
        pcDetailsArrayList.add(pcDetails78);
        pcDetailsArrayList.add(pcDetails79);
        pcDetailsArrayList.add(pcDetails80);
        pcDetailsArrayList.add(pcDetails81);
        pcDetailsArrayList.add(pcDetails82);
        pcDetailsArrayList.add(pcDetails83);
        pcDetailsArrayList.add(pcDetails84);
        pcDetailsArrayList.add(pcDetails85);
        pcDetailsArrayList.add(pcDetails86);
        pcDetailsArrayList.add(pcDetails87);
        pcDetailsArrayList.add(pcDetails88);
        pcDetailsArrayList.add(pcDetails89);
        pcDetailsArrayList.add(pcDetails90);
        pcDetailsArrayList.add(pcDetails91);
        pcDetailsArrayList.add(pcDetails92);
        pcDetailsArrayList.add(pcDetails93);
        pcDetailsArrayList.add(pcDetails94);
        pcDetailsArrayList.add(pcDetails95);
        pcDetailsArrayList.add(pcDetails96);
        pcDetailsArrayList.add(pcDetails97);
        pcDetailsArrayList.add(pcDetails98);
        pcDetailsArrayList.add(pcDetails99);
        pcDetailsArrayList.add(pcDetails100);
        pcDetailsArrayList.add(pcDetails101);
        pcDetailsArrayList.add(pcDetails102);
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
        pcDetailsArrayList.add(pcDetails355);
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