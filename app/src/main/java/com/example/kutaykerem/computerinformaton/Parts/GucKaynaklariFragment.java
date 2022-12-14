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


public class GucKaynaklariFragment extends Fragment {


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

        return inflater.inflate(R.layout.fragment_guc_kaynaklari, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        pcDetailsArrayList = new ArrayList<>();
        recyclerView = view.findViewById(R.id.recyclerViewG??cKaynaklari);

        toolbar = view.findViewById(R.id.toolbar_G??cKaynaklari);
        ((AppCompatActivity) (getActivity())).setSupportActionBar(toolbar);
        ((AppCompatActivity) (getActivity())).getSupportActionBar().setDisplayShowTitleEnabled(false);




        PcDetails pcDetails98 = new PcDetails("G???? Kaynaklar??","RAMPAGE RGB 600W 80 PLUS BRONZE 120mm RGB ");
        PcDetails pcDetails97 = new PcDetails("G???? Kaynaklar??","POWERBOOST FURY 550W 80 PLUS 120mm");
        PcDetails pcDetails96 = new PcDetails("G???? Kaynaklar??","COOLER MASTER MWE 80PLUS BRONZE 750W 2xEPS");
        PcDetails pcDetails101 = new PcDetails("G???? Kaynaklar??","EVGA SUPERNOVA 850 GA 850W 80 PLUS GOLD FULL MODULER");
        PcDetails pcDetails100 = new PcDetails("G???? Kaynaklar??","COOLER MASTER MWE V2 850W 80PLUS GOLD 2xEPS 120MM ");
        PcDetails pcDetails103 = new PcDetails("G???? Kaynaklar??","MSI MPG A850GF 850W 80 PLUS GOLD ");
        PcDetails pcDetails104 = new PcDetails("G???? Kaynaklar??","POWERBOOST FURY 650W 80 PLUS 120mm ");
        PcDetails pcDetails105 = new PcDetails("G???? Kaynaklar??","COOLER MASTER ELITE V4 80PLUS 500W PFC 120mm");
        PcDetails pcDetails106 = new PcDetails("G???? Kaynaklar??","POWERBOOST FURY 750W 80 PLUS 120mm ");
        PcDetails pcDetails102 = new PcDetails("G???? Kaynaklar??","CORSAIR CX CX750F RGB 750W 80PLUS BRONZE ");
        PcDetails pcDetails108 = new PcDetails("G???? Kaynaklar??","THERMALTAKE TOUGHPOWER GF1 80+ GOLD 750W 140mm ");
        PcDetails pcDetails110 = new PcDetails("G???? Kaynaklar??","COOLER MASTER MWE 80PLUS BRONZE 600W 2xEPS, PFC");
        PcDetails pcDetails99 = new PcDetails("G???? Kaynaklar??","THERMALTAKE L??TEPOWER RGB 650W APFC 12cm  PSU");
        PcDetails pcDetails107 = new PcDetails("G???? Kaynaklar??","COOLER MASTER M2000 2000W 80PLUS PLATINUM 135MM ");
        PcDetails pcDetails1143 = new PcDetails("G???? Kaynaklar??","MSI MPG A1000G 1000W 80+ GOLD PSU Full Mod??ler");
        PcDetails pcDetails113 = new PcDetails("G???? Kaynaklar??","THERMALTAKE SMART BX1 80PLUS BRONZE 750W ");
        PcDetails pcDetails109 = new PcDetails("G???? Kaynaklar??","THERMALTAKE TOUGHPOWER GF 850W 80PLUS GOLD");
        PcDetails pcDetails111 = new PcDetails("G???? Kaynaklar??","CORSAIR CX  CX750F RGB 750W 80PLUS BRONZE ");
        PcDetails pcDetails114 = new PcDetails("G???? Kaynaklar??","MSI MPG A650GF 650W 80 PLUS GOLD");
        PcDetails pcDetails112 = new PcDetails("G???? Kaynaklar??","XIGMATEK X-POWER 350W ");
        PcDetails pcDetails117 = new PcDetails("G???? Kaynaklar??","ZALMAN ZM600-TXII 600W 80 PLUS ");
        PcDetails pcDetails118 = new PcDetails("G???? Kaynaklar??","COOLER MASTER MWE 80PLUS BRONZE 700W 2xEPS");
        PcDetails pcDetails116 = new PcDetails("G???? Kaynaklar??","COOLER MASTER MWE 80PLUS BRONZE 650W 2xEPS");
        PcDetails pcDetails202 = new PcDetails("G???? Kaynaklar??","ASUS ROG STRIX 850W 80 PLUS GOLD ");
        PcDetails pcDetails115 = new PcDetails("G???? Kaynaklar??","THERMALTAKE SMART BX1 80PLUS BRONZE 650W G????");
        PcDetails pcDetails203 = new PcDetails("G???? Kaynaklar??","COOLER MASTER MWE 80PLUS 650W 2xEPS");
        PcDetails pcDetails204 = new PcDetails("G???? Kaynaklar??","THERMALTAKE TOUGHPOWER GRAND 80+ PLATINUM 1200W FUL");
        PcDetails pcDetails200 = new PcDetails("G???? Kaynaklar??","RAMPAGE RMP-500-80P 500W 80PLUS 120MM ");
        PcDetails pcDetails205 = new PcDetails("G???? Kaynaklar??","THERMALTAKE LITEPOWER 650W ");
        PcDetails pcDetails206 = new PcDetails("G???? Kaynaklar??","ASUS ROG-THOR GAMING 1200W 80PLUS PLATINIUM AURO SYNC &");
        PcDetails pcDetails208 = new PcDetails("G???? Kaynaklar??","THERMALTAKE TOUGHPOWER GF1 1000W 80PLUS GOLD FULL");
        PcDetails pcDetails207 = new PcDetails("G???? Kaynaklar??","POWERBOOST 2000W 140mm");
        PcDetails pcDetails211 = new PcDetails("G???? Kaynaklar??","POWERBOOST WARRIOR 850W 80 PLUS GOLD FULL MOD??LER ");
        PcDetails pcDetails209 = new PcDetails("G???? Kaynaklar??","CORSAIR CP-9020234-EU RM750 750W TAM MODULER 80PLUS ");
        PcDetails pcDetails212 = new PcDetails("G???? Kaynaklar??","CORSAIR RM850 850W TAM MODULER 80PLUS GOLD ");
        PcDetails pcDetails119 = new PcDetails("G???? Kaynaklar??","CORSAIR RM750 750W TAM MODULER 80PLUS GOLD ");
        PcDetails pcDetails224 = new PcDetails("G???? Kaynaklar??","COOLER MASTER XG PLUS 850W 80+ PLATINYUM RGB FULL");
        PcDetails pcDetails213 = new PcDetails("G???? Kaynaklar??","THERMALTAKE TOUGHPOWER GF2 80 PLUS 750W GOLD ARGB");
        PcDetails pcDetails244 = new PcDetails("G???? Kaynaklar??","EVGA 500 W2 500W 80 PLUSI");
        PcDetails pcDetails234 = new PcDetails("G???? Kaynaklar??","EVGA SUPERNOVA 750 GA 750W 80 PLUS GOLD FULL MODULER");
        PcDetails pcDetails255 = new PcDetails("G???? Kaynaklar??","EVGA 1000 GQ 1000W 80 PLUS GOLD SEMI MODULER");
        PcDetails pcDetails210 = new PcDetails("G???? Kaynaklar??","EVGA 750 GQ 750W 80 PLUS GOLD SEMI MODULER");
        PcDetails pcDetails266 = new PcDetails("G???? Kaynaklar??","MSI MAG A550BN 550W 80 PLUS BRONZE ");
        PcDetails pcDetails277 = new PcDetails("G???? Kaynaklar??","COOLER MASTER V750W SFX 80PLUS GOLD 750W");
        PcDetails pcDetails333 = new PcDetails("G???? Kaynaklar??","COOLER MASTER MWE V2 80PLUS GOLD 1250W FULL MOD??LER 140MM");
        PcDetails pcDetails299 = new PcDetails("G???? Kaynaklar??","COOLER MASTER MWE V2 80PLUS GOLD 1050W FULL MOD??LER");
        PcDetails pcDetails300 = new PcDetails("G???? Kaynaklar??","ZALMAN ZM1200-EBTII WATTTERA 80PLUS GOLD 1200W ");
        PcDetails pcDetails288 = new PcDetails("G???? Kaynaklar??","RAMPAGE BTC-1650 1650W 140MM FANLI ");
        PcDetails pcDetails344 = new PcDetails("G???? Kaynaklar??","COUGAR GEX1050 1050W 80PLUS GOLD");
        PcDetails pcDetails320 = new PcDetails("G???? Kaynaklar??","COUGAR GEX850 850W 80PLUS GOLD ");
        PcDetails pcDetails377= new PcDetails("G???? Kaynaklar??","COUGAR VTE X2 750 750W 80PLUS BRONZE ");
        PcDetails pcDetails366 = new PcDetails("G???? Kaynaklar??","COUGAR GX-S450 450W 80PLUS GOLD ");
        PcDetails pcDetails391 = new PcDetails("G???? Kaynaklar??","COOLER MASTER MWE V2 750W 80PLUS GOLD 2xEPS 120MM ");
        PcDetails pcDetails381 = new PcDetails("G???? Kaynaklar??","RAMPAGE RGB 500W 80 PLUS BRONZE 120mm RGB ");
        PcDetails pcDetails355 = new PcDetails("G???? Kaynaklar??","CORSAIR RMx  RM750X 750W 80PLUS GOLD TAM");
        PcDetails pcDetails412 = new PcDetails("G???? Kaynaklar??","XIGMATEK MINOTOUR 750W 80PLUS GOLD FULL");
        PcDetails pcDetails421 = new PcDetails("G???? Kaynaklar??","XIGMATEK MINOTOUR 850W 80PLUS GOLD FULL");
        PcDetails pcDetails444 = new PcDetails("G???? Kaynaklar??","FRISBY FR-PS50F12B 500W 120mm ");
        PcDetails pcDetails456 = new PcDetails("G???? Kaynaklar??","THERMALTAKE TOUGHPOWER GF 750W 80PLUS GOLD FULL");
        PcDetails pcDetails433 = new PcDetails("G???? Kaynaklar??","THERMALTAKE TOUGHPOWER GRAND 80PLUS PLATINUM 1050W");
        PcDetails pcDetails467 = new PcDetails("G???? Kaynaklar??","ASUS ROG THOR 850W 80 PLUS PLATINUM AURO SYNC & OLED");
        PcDetails pcDetails488 = new PcDetails("G???? Kaynaklar??","CORSAIR RMx  RM750X V2 750W 80PLUS GOLD TAM");
        PcDetails pcDetails401 = new PcDetails("G???? Kaynaklar??","THERMALTAKE TOUGHPOWER GF2 80 PLUS 850W GOLD ARGB");
        PcDetails pcDetails477 = new PcDetails("G???? Kaynaklar??","CORSAIR CX  CX650F RGB 650W 80PLUS BRONZE TAM");
        PcDetails pcDetails513 = new PcDetails("G???? Kaynaklar??","ASUS TUF GAMING 450W 80PLUS BRONZE ");
        PcDetails pcDetails499 = new PcDetails("G???? Kaynaklar??","ASUS TUF GAMING 750W 80PLUS BRONZE ");
        PcDetails pcDetails515 = new PcDetails("G???? Kaynaklar??","ASUS ROG STRIX 1000W 80 PLUS GOLD");
        PcDetails pcDetails501 = new PcDetails("G???? Kaynaklar??","MSI MPG A750GF 750W 80 PLUS GOLD");
        PcDetails pcDetails512 = new PcDetails("G???? Kaynaklar??","THERMALTAKE TOUGHPOWER PF1 850W 80+ PLATINUM FULL");
        PcDetails pcDetails516 = new PcDetails("G???? Kaynaklar??","ASUS TUF GAMING 650W 80PLUS BRONZE ");
        PcDetails pcDetails514 = new PcDetails("G???? Kaynaklar??","XIGMATEK HYDRA M 550W 80PLUS BRONZE FULL MODULER");
        PcDetails pcDetails511 = new PcDetails("G???? Kaynaklar??","XIGMATEK HYDRA M 650W 80PLUS BRONZE FULL MODULER");
        PcDetails pcDetails518 = new PcDetails("G???? Kaynaklar??","ZALMAN ZM700-TXII 700W 80 PLUS ");
        PcDetails pcDetails519 = new PcDetails("G???? Kaynaklar??","ZALMAN ZM1200-EBTII WATTTERA 80PLUS GOLD 1200W ");
        PcDetails pcDetails610 = new PcDetails("G???? Kaynaklar??","RAMPAGE BTC-1650 1650W 140MM ");
        PcDetails pcDetails621 = new PcDetails("G???? Kaynaklar??","COUGAR GEX1050 1050W 80PLUS GOLD ");
        PcDetails pcDetails611 = new PcDetails("G???? Kaynaklar??","COUGAR GEX850 850W 80PLUS GOLD ");
        PcDetails pcDetails517 = new PcDetails("G???? Kaynaklar??","COUGAR VTE X2 750 750W 80PLUS BRONZE");
        PcDetails pcDetails631 = new PcDetails("G???? Kaynaklar??","COUGAR GX-S450 450W 80PLUS GOLD ");
        PcDetails pcDetails652 = new PcDetails("G???? Kaynaklar??","COOLER MASTER MWE V2 750W 80PLUS GOLD 2xEPS 120MM");
        PcDetails pcDetails642 = new PcDetails("G???? Kaynaklar??","RAMPAGE RGB 500W 80 PLUS BRONZE 120mm RGB");
        PcDetails pcDetails681 = new PcDetails("G???? Kaynaklar??","CORSAIR RMx  RM750X 750W 80PLUS GOLD ");
        PcDetails pcDetails662 = new PcDetails("G???? Kaynaklar??","XIGMATEK MINOTOUR  750W 80PLUS GOLD");
        PcDetails pcDetails671 = new PcDetails("G???? Kaynaklar??","XIGMATEK MINOTOUR  850W 80PLUS GOLD");
        PcDetails pcDetails718 = new PcDetails("G???? Kaynaklar??","FRISBY FR-PS50F12B 500W 120mm ");
        PcDetails pcDetails717 = new PcDetails("G???? Kaynaklar??","THERMALTAKE TOUGHPOWER GF 750W 80PLUS GOLD ");
        PcDetails pcDetails711 = new PcDetails("G???? Kaynaklar??","THERMALTAKE TOUGHPOWER GRAND 80PLUS PLATINUM 1050W");
        PcDetails pcDetails810 = new PcDetails("G???? Kaynaklar??","ASUS ROG THOR 850W 80 PLUS PLATINUM AURO SYNC & OLED");
        PcDetails pcDetails710 = new PcDetails("G???? Kaynaklar??","CORSAIR RMx RM750X V2 750W 80PLUS GOLD TAM");
        PcDetails pcDetails716 = new PcDetails("G???? Kaynaklar??","THERMALTAKE TOUGHPOWER GF2 80 PLUS 850W GOLD ARGB");
        PcDetails pcDetails691 = new PcDetails("G???? Kaynaklar??","CORSAIR CX  CX650F RGB 650W 80PLUS BRONZE ");
        PcDetails pcDetails713 = new PcDetails("G???? Kaynaklar??","ASUS TUF GAMING 450W 80PLUS BRONZE ");
        PcDetails pcDetails721 = new PcDetails("G???? Kaynaklar??","ASUS TUF GAMING 750W 80PLUS BRONZE ");
        PcDetails pcDetails714 = new PcDetails("G???? Kaynaklar??","ASUS ROG STRIX 1000W 80 PLUS GOLD ");
        PcDetails pcDetails715 = new PcDetails("G???? Kaynaklar??","MSI MPG A750GF 750W 80 PLUS GOLD");
        PcDetails pcDetails719 = new PcDetails("G???? Kaynaklar??","THERMALTAKE TOUGHPOWER PF1 850W 80+ PLATINUM L");
        PcDetails pcDetails913 = new PcDetails("G???? Kaynaklar??","ASUS TUF GAMING 650W 80PLUS BRONZE ");
        PcDetails pcDetails814 = new PcDetails("G???? Kaynaklar??","ASUS TUF GAMING 650W 80PLUS BRONZE ");
        PcDetails pcDetails912 = new PcDetails("G???? Kaynaklar??","XIGMATEK HYDRA M 550W 80PLUS BRONZE FULL MODULER ");
        PcDetails pcDetails901 = new PcDetails("G???? Kaynaklar??","XIGMATEK HYDRA M 650W 80PLUS BRONZE FULL MODULER ");
        PcDetails pcDetails911 = new PcDetails("G???? Kaynaklar??","ZALMAN ZM700-TXII 700W 80 PLUS ");
        PcDetails pcDetails813 = new PcDetails("G???? Kaynaklar??","ZALMAN ZM500-TXII 500W 80 PLUS ");
        PcDetails pcDetails819 = new PcDetails("G???? Kaynaklar??","ASUS ROG STRIX WHITE 850W 80 PLUS GOLD ");
        PcDetails pcDetails815 = new PcDetails("G???? Kaynaklar??","CORSAIR CV  CV650 650W 80PLUS BRONZE ");
        PcDetails pcDetails816 = new PcDetails("G???? Kaynaklar??","COOLER MASTER MWE 80PLUS BRONZE 750W 2xEPS");
        PcDetails pcDetails817 = new PcDetails("G???? Kaynaklar??","CORSAIR CV  CV550 550W 80PLUS BRONZE");
        PcDetails pcDetails821 = new PcDetails("G???? Kaynaklar??","CORSAIR RM  650W 80PLUS GOLD MOD??LER");
        PcDetails pcDetails818 = new PcDetails("G???? Kaynaklar??","THERMALTAKE TOUGHPOWER PF1 ARGB 80PLUS PLATINUM 1200W");
        PcDetails pcDetails811 = new PcDetails("G???? Kaynaklar??","COUGAR BXM-850 850W 80 PLUS BRONZE ");
        PcDetails pcDetails7119 = new PcDetails("G???? Kaynaklar??","COUGAR BXM-700 700W 80 PLUS BRONZE ");
        PcDetails pcDetails914 = new PcDetails("G???? Kaynaklar??","COUGAR XTC 500 500W 80 PLUS ");
        PcDetails pcDetails915 = new PcDetails("G???? Kaynaklar??","FRISBY FR-PS6580P-RGB 80 PLUS 650W");
        PcDetails pcDetails7118 = new PcDetails("G???? Kaynaklar??","FRISBY FR-PS6080P 80 PLUS BRONZE 600W ");
        PcDetails pcDetails875 = new PcDetails("G???? Kaynaklar??","ASUS ROG STRIX 750W 80 PLUS GOLD");
        PcDetails pcDetails870 = new PcDetails("G???? Kaynaklar??","ASUS ROG STRIX 650W 80 PLUS GOLD ");
        PcDetails pcDetails874 = new PcDetails("G???? Kaynaklar??","ASUS ROG STRIX 550W 80 PLUS GOLD ");
        PcDetails pcDetails876 = new PcDetails("G???? Kaynaklar??","THERMALTAKE TR2 S 750W 80 PLUS 120mm ");
        PcDetails pcDetails877 = new PcDetails("G???? Kaynaklar??","THERMALTAKE TR2 S 650W 80 PLUS 120mm ");
        PcDetails pcDetails871 = new PcDetails("G???? Kaynaklar??","THERMALTAKE TR2 S 550W 80 PLUS 120mm ");
        PcDetails pcDetails872 = new PcDetails("G???? Kaynaklar??","FRISBY FR-PS6580P 650W 80 PLUS 120mm ");
        PcDetails pcDetails873 = new PcDetails("G???? Kaynaklar??","COUGAR CGR-GS-750 GX-S 750W 80PLUS GOLD");
        PcDetails pcDetails878 = new PcDetails("G???? Kaynaklar??","COUGAR CGR-BX-700 CMX 700W 80PLUS BRONZE ");
        PcDetails pcDetails971 = new PcDetails("G???? Kaynaklar??","THERMALTAKE TOUGHPOWER PF1 ARGB 80PLUS PLATINUM 1050W");
        PcDetails pcDetails970 = new PcDetails("G???? Kaynaklar??","THERMALTAKE TOUGHPOWER GF1 80 PLUS 850W GOLD ");
        PcDetails pcDetails973 = new PcDetails("G???? Kaynaklar??","THERMALTAKE SMART RGB BX1 80PLUS BRONZE 750W ");
        PcDetails pcDetails972 = new PcDetails("G???? Kaynaklar??","COOLER MASTER MWE 80PLUS 600W 2xEPS");
        PcDetails pcDetails974 = new PcDetails("G???? Kaynaklar??","XIGMATEK MINOTAUR FULL RANGE 80PLUS GOLD 650W");
        PcDetails pcDetails931 = new PcDetails("G???? Kaynaklar??","COUGAR CGR-STX-700 700W 80 PLUS ");
        PcDetails pcDetails975 = new PcDetails("G???? Kaynaklar??","XIGMATEK X-POWER 650W 80PLUS");
        PcDetails pcDetails932 = new PcDetails("G???? Kaynaklar??","THERMALTAKE LITEPOWER RGB 550W APFC 12cm PSU");
        PcDetails pcDetails933 = new PcDetails("G???? Kaynaklar??","XIGMATEK X-POWER 600W 80PLUS ");
        PcDetails pcDetails9332 = new PcDetails("G???? Kaynaklar??","XIGMATEK X-POWER 500W 80PLUS ");
        PcDetails pcDetails9334 = new PcDetails("G???? Kaynaklar??","THERMALTAKE SMART RGB 80 PLUS 700W ");
        PcDetails pcDetails9333 = new PcDetails("G???? Kaynaklar??","THERMALTAKE SMART RGB 80PLUS 600W ");
        PcDetails pcDetails9335 = new PcDetails("G???? Kaynaklar??","THERMALTAKE SMART RGB 80PLUS 500W ");
        PcDetails pcDetails933445 = new PcDetails("G???? Kaynaklar??","RAMPAGE RMP-750-80PB 750W 80 PLUS BRONZE 140MM ");
        PcDetails pcDetails93356 = new PcDetails("G???? Kaynaklar??","RAMPAGE RMP-700-80P 700W 80PLUS 120MM ");
        PcDetails pcDetails97181 = new PcDetails("G???? Kaynaklar??","RAMPAGE RMP-650-80PB 650W 80PLUS BRONZE 140MM ");
        PcDetails pcDetails97077 = new PcDetails("G???? Kaynaklar??","THERMALTAKE TOUGHPOWER GF1 80 PLUS 850W GOLD FULL");
        PcDetails pcDetails97484 = new PcDetails("G???? Kaynaklar??","RAMPAGE RMP-750-80PB 750W 80 PLUS BRONZE 140MM");
        PcDetails pcDetails97383 = new PcDetails("G???? Kaynaklar??","RAMPAGE RMP-700-80P 700W 80PLUS 120MM ");
        PcDetails pcDetails97282 = new PcDetails("G???? Kaynaklar??","RAMPAGE RMP-650-80PB 650W 80PLUS BRONZE 140MM ");
        PcDetails pcDetails879 = new PcDetails("G???? Kaynaklar??","RAMPAGE RMP-600-80P 600W 80PLUS 120MM ");
        PcDetails pcDetails97585 = new PcDetails("G???? Kaynaklar??","XIGMATEK X MINER 1800W 80 PLUS GOLD ");
        PcDetails pcDetails93287 = new PcDetails("G???? Kaynaklar??","AMPAGE RGB-550 80PLUS GOLD 550W FULL MOD??LER RGB ");
        PcDetails pcDetails93186 = new PcDetails("G???? Kaynaklar??","COOLER MASTER WATT 80PLUS 600W  PFC 120MM ");
        PcDetails pcDetails93388 = new PcDetails("G???? Kaynaklar??","THERMALTAKE LITEPOWER 550W");
        PcDetails pcDetails933289 = new PcDetails("G???? Kaynaklar??","EVEREST BTX-600 600W 80PLUS BRONZE");
        PcDetails pcDetails933390 = new PcDetails("G???? Kaynaklar??","EVEREST ETX-750 750W 80PLUS GOLD ");
        PcDetails pcDetails933491 = new PcDetails("G???? Kaynaklar??", "EVEREST EPS-4900B 350W ");


        pcDetailsArrayList.add(pcDetails879);
        pcDetailsArrayList.add(pcDetails970);
        pcDetailsArrayList.add(pcDetails971);
        pcDetailsArrayList.add(pcDetails972);
        pcDetailsArrayList.add(pcDetails973);
        pcDetailsArrayList.add(pcDetails974);
        pcDetailsArrayList.add(pcDetails975);
        pcDetailsArrayList.add(pcDetails931);
        pcDetailsArrayList.add(pcDetails932);
        pcDetailsArrayList.add(pcDetails933);
        pcDetailsArrayList.add(pcDetails9332);
        pcDetailsArrayList.add(pcDetails9333);
        pcDetailsArrayList.add(pcDetails9334);
        pcDetailsArrayList.add(pcDetails9335);
        pcDetailsArrayList.add(pcDetails933445);
        pcDetailsArrayList.add(pcDetails93356);
        pcDetailsArrayList.add(pcDetails97077);
        pcDetailsArrayList.add(pcDetails97181);
        pcDetailsArrayList.add(pcDetails97282);
        pcDetailsArrayList.add(pcDetails97383);
        pcDetailsArrayList.add(pcDetails97484);
        pcDetailsArrayList.add(pcDetails97585);
        pcDetailsArrayList.add(pcDetails93186);
        pcDetailsArrayList.add(pcDetails93287);
        pcDetailsArrayList.add(pcDetails93388);
        pcDetailsArrayList.add(pcDetails933289);
        pcDetailsArrayList.add(pcDetails933390);
        pcDetailsArrayList.add(pcDetails933491);
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
        pcDetailsArrayList.add(pcDetails872);
        pcDetailsArrayList.add(pcDetails873);
        pcDetailsArrayList.add(pcDetails874);
        pcDetailsArrayList.add(pcDetails875);
        pcDetailsArrayList.add(pcDetails876);
        pcDetailsArrayList.add(pcDetails877);
        pcDetailsArrayList.add(pcDetails878);
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
        pcDetailsArrayList.add(pcDetails202);
        pcDetailsArrayList.add(pcDetails203);
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
        pcDetailsArrayList.add(pcDetails355);
        pcDetailsArrayList.add(pcDetails366);
        pcDetailsArrayList.add(pcDetails377);
        pcDetailsArrayList.add(pcDetails381);
        pcDetailsArrayList.add(pcDetails391);
        pcDetailsArrayList.add(pcDetails412);
        pcDetailsArrayList.add(pcDetails401);
        pcDetailsArrayList.add(pcDetails421);
        pcDetailsArrayList.add(pcDetails433);
        pcDetailsArrayList.add(pcDetails444);
        pcDetailsArrayList.add(pcDetails456);
        pcDetailsArrayList.add(pcDetails467);
        pcDetailsArrayList.add(pcDetails477);
        pcDetailsArrayList.add(pcDetails488);
        pcDetailsArrayList.add(pcDetails499);
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
        pcDetailsArrayList.add(pcDetails714);
        pcDetailsArrayList.add(pcDetails715);
        pcDetailsArrayList.add(pcDetails716);
        pcDetailsArrayList.add(pcDetails717);
        pcDetailsArrayList.add(pcDetails718);
        pcDetailsArrayList.add(pcDetails719);
        pcDetailsArrayList.add(pcDetails810);


        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adaptorPcDetails = new AdaptorPcDetails(pcDetailsArrayList);
        recyclerView.setAdapter(adaptorPcDetails);


        adaptorPcDetails.notifyDataSetChanged();






        DilTan??(view);


    }
    public void DilTan??(View view){

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String userId = user.getUid();

        FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
        firebaseFirestore.collection("Kullan??lanDiller").document(userId).collection("SecilenDil").orderBy("tarih", Query.Direction.DESCENDING).limit(1).addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {

                if(value != null){
                    for (DocumentSnapshot documentSnapshot : value.getDocuments()) {
                        Map<String, Object> data = documentSnapshot.getData();
                        String dil = data.get("dil").toString();

                        if (dil.equals("t??rkce")) {
                            searchView = view.findViewById(R.id.searchView_G??cKaynaklari);
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
                            searchView = view.findViewById(R.id.searchView_G??cKaynaklari);
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