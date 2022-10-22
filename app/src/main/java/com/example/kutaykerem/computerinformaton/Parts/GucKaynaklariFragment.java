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
        recyclerView = view.findViewById(R.id.recyclerViewGücKaynaklari);

        toolbar = view.findViewById(R.id.toolbar_GücKaynaklari);
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
                            PcDetails pcDetails96 = new PcDetails("Güç Kaynakları","RAMPAGE RGB 600W 80 PLUS BRONZE 120mm RGB");
                            pcDetailsArrayList.add(pcDetails96);

                            PcDetails pcDetails97 = new PcDetails("Güç Kaynakları","POWERBOOST FURY 550W 80 PLUS 120mm ");
                            pcDetailsArrayList.add(pcDetails97);

                            PcDetails pcDetails98 = new PcDetails("Güç Kaynakları","COOLER MASTER MWE 80PLUS BRONZE 750W 2xEPS, AKTİF PFC");
                            pcDetailsArrayList.add(pcDetails98);

                            PcDetails pcDetails99 = new PcDetails("Güç Kaynakları","EVGA SUPERNOVA 850 GA 850W 80 PLUS GOLD FULL MODULER");
                            pcDetailsArrayList.add(pcDetails99);

                            PcDetails pcDetails100 = new PcDetails("Güç Kaynakları","COOLER MASTER MWE V2 850W 80PLUS GOLD 2xEPS 120MM ");
                            pcDetailsArrayList.add(pcDetails100);

                            PcDetails pcDetails101 = new PcDetails("Güç Kaynakları","MSI MPG A850GF 850W 80 PLUS GOLD ");
                            pcDetailsArrayList.add(pcDetails101);

                            PcDetails pcDetails102 = new PcDetails("Güç Kaynakları","POWERBOOST FURY 650W 80 PLUS 120mm ");
                            pcDetailsArrayList.add(pcDetails102);

                            PcDetails pcDetails103 = new PcDetails("Güç Kaynakları","COOLER MASTER ELITE V4 80PLUS 500W AKTİF PFC 120mm");
                            pcDetailsArrayList.add(pcDetails103);

                            PcDetails pcDetails104 = new PcDetails("Güç Kaynakları","POWERBOOST FURY 750W 80 PLUS 120mm ");
                            pcDetailsArrayList.add(pcDetails104);

                            PcDetails pcDetails105 = new PcDetails("Güç Kaynakları","CORSAIR CX SERİSİ CX750F RGB 750W 80PLUS BRONZE ");
                            pcDetailsArrayList.add(pcDetails105);

                            PcDetails pcDetails106 = new PcDetails("Güç Kaynakları","THERMALTAKE TOUGHPOWER GF1 80+ GOLD 750W 140mm ");
                            pcDetailsArrayList.add(pcDetails106);

                            PcDetails pcDetails107 = new PcDetails("Güç Kaynakları","COOLER MASTER MWE 80PLUS BRONZE 600W 2xEPS, AKTİF PFC");
                            pcDetailsArrayList.add(pcDetails107);

                            PcDetails pcDetails108 = new PcDetails("Güç Kaynakları","THERMALTAKE LİTEPOWER RGB 650W APFC 12cm PSU");
                            pcDetailsArrayList.add(pcDetails108);

                            PcDetails pcDetails109 = new PcDetails("Güç Kaynakları","COOLER MASTER M2000 2000W 80PLUS PLATINUM 135MM ");
                            pcDetailsArrayList.add(pcDetails109);

                            PcDetails pcDetails110 = new PcDetails("Güç Kaynakları","MSI MPG A1000G 1000W 80+ GOLD PSU Full Modüler ");
                            pcDetailsArrayList.add(pcDetails110);

                            PcDetails pcDetails111 = new PcDetails("Güç Kaynakları","THERMALTAKE SMART BX1 80PLUS BRONZE 750W ");
                            pcDetailsArrayList.add(pcDetails111);

                            PcDetails pcDetails112 = new PcDetails("Güç Kaynakları","THERMALTAKE TOUGHPOWER GF 850W 80PLUS GOLD FULL");
                            pcDetailsArrayList.add(pcDetails112);

                            PcDetails pcDetails113 = new PcDetails("Güç Kaynakları","CORSAIR CX  CX750F RGB 750W 80PLUS BRONZE TAM");
                            pcDetailsArrayList.add(pcDetails113);


                            PcDetails pcDetails1143 = new PcDetails("Güç Kaynakları","MSI MPG A650GF 650W 80 PLUS GOLD ");
                            pcDetailsArrayList.add(pcDetails1143);

                            PcDetails pcDetails114 = new PcDetails("Güç Kaynakları","XIGMATEK X-POWER  350W");
                            pcDetailsArrayList.add(pcDetails114);

                            PcDetails pcDetails115 = new PcDetails("Güç Kaynakları","ZALMAN ZM600-TXII 600W 80 PLUS");
                            pcDetailsArrayList.add(pcDetails115);

                            PcDetails pcDetails116 = new PcDetails("Güç Kaynakları","COOLER MASTER MWE 80PLUS BRONZE 700W 2xEPS, AKTİF PFC");
                            pcDetailsArrayList.add(pcDetails116);

                            PcDetails pcDetails117 = new PcDetails("Güç Kaynakları","COOLER MASTER MWE 80PLUS BRONZE 650W 2xEPS, AKTİF PFC");
                            pcDetailsArrayList.add(pcDetails117);

                            PcDetails pcDetails118 = new PcDetails("Güç Kaynakları","ASUS ROG STRIX 850W 80 PLUS GOLD ");
                            pcDetailsArrayList.add(pcDetails118);

                            PcDetails pcDetails119 = new PcDetails("Güç Kaynakları","THERMALTAKE SMART BX1 80PLUS BRONZE 650W ");
                            pcDetailsArrayList.add(pcDetails119);

                            PcDetails pcDetails200 = new PcDetails("Güç Kaynakları","COOLER MASTER MWE 80PLUS 650W 2xEPS, AKTİF PFC 120MM");
                            pcDetailsArrayList.add(pcDetails200);

                            PcDetails pcDetails202 = new PcDetails("Güç Kaynakları","THERMALTAKE TOUGHPOWER GRAND 80+ PLATINUM 1200W FUL");
                            pcDetailsArrayList.add(pcDetails202);

                            PcDetails pcDetails203 = new PcDetails("Güç Kaynakları","RAMPAGE RMP-500-80P 500W 80PLUS 120MM");
                            pcDetailsArrayList.add(pcDetails203);

                            PcDetails pcDetails204 = new PcDetails("Güç Kaynakları","THERMALTAKE LITEPOWER 650W ");
                            pcDetailsArrayList.add(pcDetails204);

                            PcDetails pcDetails205 = new PcDetails("Güç Kaynakları","ASUS ROG-THOR GAMING 1200W 80PLUS PLATINIUM AURO SYNC &");
                            pcDetailsArrayList.add(pcDetails205);

                            PcDetails pcDetails206 = new PcDetails("Güç Kaynakları","THERMALTAKE TOUGHPOWER GF1 1000W 80PLUS GOLD FULL");
                            pcDetailsArrayList.add(pcDetails206);

                            PcDetails pcDetails207 = new PcDetails("Güç Kaynakları","POWERBOOST 2000W 140mm");
                            pcDetailsArrayList.add(pcDetails207);

                            PcDetails pcDetails208 = new PcDetails("Güç Kaynakları","POWERBOOST WARRIOR 850W 80 PLUS GOLD FULL MODÜLER ");
                            pcDetailsArrayList.add(pcDetails208);

                            PcDetails pcDetails209 = new PcDetails("Güç Kaynakları","CORSAIR CP-9020234-EU RM750 750W TAM MODULER 80PLUS ");
                            pcDetailsArrayList.add(pcDetails209);

                            PcDetails pcDetails210 = new PcDetails("Güç Kaynakları","CORSAIR RM850 850W TAM MODULER 80PLUS GOLD");
                            pcDetailsArrayList.add(pcDetails210);

                            PcDetails pcDetails211 = new PcDetails("Güç Kaynakları","CORSAIR RM750 750W TAM MODULER 80PLUS GOLD");
                            pcDetailsArrayList.add(pcDetails211);

                            PcDetails pcDetails212 = new PcDetails("Güç Kaynakları","COOLER MASTER XG PLUS 850W 80+ PLATINYUM RGB FULL");
                            pcDetailsArrayList.add(pcDetails212);

                            PcDetails pcDetails213 = new PcDetails("Güç Kaynakları","THERMALTAKE TOUGHPOWER GF2 80 PLUS 750W GOLD ARGB");
                            pcDetailsArrayList.add(pcDetails213);

                            PcDetails pcDetails224 = new PcDetails("Güç Kaynakları","EVGA 500 W2 500W 80 PLUS ");
                            pcDetailsArrayList.add(pcDetails224);

                            PcDetails pcDetails234 = new PcDetails("Güç Kaynakları","EVGA SUPERNOVA 750 GA 750W 80 PLUS GOLD FULL MODULER");
                            pcDetailsArrayList.add(pcDetails234);

                            PcDetails pcDetails244 = new PcDetails("Güç Kaynakları","EVGA 1000 GQ 1000W 80 PLUS GOLD SEMI MODULER");
                            pcDetailsArrayList.add(pcDetails244);

                            PcDetails pcDetails255 = new PcDetails("Güç Kaynakları","EVGA 750 GQ 750W 80 PLUS GOLD SEMI MODULER ");
                            pcDetailsArrayList.add(pcDetails255);

                            PcDetails pcDetails266 = new PcDetails("Güç Kaynakları","MSI MAG A550BN 550W 80 PLUS BRONZE ");
                            pcDetailsArrayList.add(pcDetails266);

                            PcDetails pcDetails277 = new PcDetails("Güç Kaynakları","COOLER MASTER V750W SFX 80PLUS GOLD 750W ");
                            pcDetailsArrayList.add(pcDetails277);

                            PcDetails pcDetails288 = new PcDetails("Güç Kaynakları","COOLER MASTER MWE V2 80PLUS GOLD 1250W FULL MODÜLER 140MM");
                            pcDetailsArrayList.add(pcDetails288);

                            PcDetails pcDetails299 = new PcDetails("Güç Kaynakları","COOLER MASTER MWE V2 80PLUS GOLD 1050W FULL MODÜLER");
                            pcDetailsArrayList.add(pcDetails299);

                            PcDetails pcDetails300 = new PcDetails("Güç Kaynakları","ZALMAN ZM1200-EBTII WATTTERA 80PLUS GOLD 1200W I");
                            pcDetailsArrayList.add(pcDetails300);

                            PcDetails pcDetails320 = new PcDetails("Güç Kaynakları","RAMPAGE BTC-1650 1650W 140MM");
                            pcDetailsArrayList.add(pcDetails320);

                            PcDetails pcDetails333 = new PcDetails("Güç Kaynakları","COUGAR GEX1050 1050W 80PLUS GOLD ");
                            pcDetailsArrayList.add(pcDetails333);

                            PcDetails pcDetails344 = new PcDetails("Güç Kaynakları","COUGAR GEX850 850W 80PLUS GOLD ");
                            pcDetailsArrayList.add(pcDetails344);

                            PcDetails pcDetails355 = new PcDetails("Güç Kaynakları","COUGAR VTE X2 750 750W 80PLUS BRONZE ");
                            pcDetailsArrayList.add(pcDetails355);

                            PcDetails pcDetails366 = new PcDetails("Güç Kaynakları","COUGAR GX-S450 450W 80PLUS GOLD ");
                            pcDetailsArrayList.add(pcDetails366);

                            PcDetails pcDetails377= new PcDetails("Güç Kaynakları","COOLER MASTER MWE V2 750W 80PLUS GOLD 2xEPS 120MM ");
                            pcDetailsArrayList.add(pcDetails377);

                            PcDetails pcDetails381 = new PcDetails("Güç Kaynakları","RAMPAGE RGB 500W 80 PLUS BRONZE 120mm RGB");
                            pcDetailsArrayList.add(pcDetails381);

                            PcDetails pcDetails391 = new PcDetails("Güç Kaynakları","CORSAIR RMx SERİSİ RM750X 750W 80PLUS GOLD TAM");
                            pcDetailsArrayList.add(pcDetails391);

                            PcDetails pcDetails401 = new PcDetails("Güç Kaynakları","XIGMATEK MINOTOUR SERİSİ 750W 80PLUS GOLD FULL");
                            pcDetailsArrayList.add(pcDetails401);

                            PcDetails pcDetails412 = new PcDetails("Güç Kaynakları","XIGMATEK MINOTOUR SERİSİ 850W 80PLUS GOLD FULL");
                            pcDetailsArrayList.add(pcDetails412);

                            PcDetails pcDetails421 = new PcDetails("Güç Kaynakları","FRISBY FR-PS50F12B 500W 120mm");
                            pcDetailsArrayList.add(pcDetails421);

                            PcDetails pcDetails433 = new PcDetails("Güç Kaynakları","THERMALTAKE TOUGHPOWER GF 750W 80PLUS GOLD FULL");
                            pcDetailsArrayList.add(pcDetails433);

                            PcDetails pcDetails444 = new PcDetails("Güç Kaynakları","THERMALTAKE TOUGHPOWER GRAND 80PLUS PLATINUM 1050W");
                            pcDetailsArrayList.add(pcDetails444);

                            PcDetails pcDetails456 = new PcDetails("Güç Kaynakları","ASUS ROG THOR 850W 80 PLUS PLATINUM AURO SYNC & OLED");
                            pcDetailsArrayList.add(pcDetails456);

                            PcDetails pcDetails467 = new PcDetails("Güç Kaynakları","CORSAIR RMx SERİSİ RM750X V2 750W 80PLUS GOLD ");
                            pcDetailsArrayList.add(pcDetails467);

                            PcDetails pcDetails477 = new PcDetails("Güç Kaynakları","THERMALTAKE TOUGHPOWER GF2 80 PLUS 850W GOLD ARGB");
                            pcDetailsArrayList.add(pcDetails477);

                            PcDetails pcDetails488 = new PcDetails("Güç Kaynakları","CORSAIR CX SERİSİ CX650F RGB 650W 80PLUS BRONZE ");
                            pcDetailsArrayList.add(pcDetails488);

                            PcDetails pcDetails499 = new PcDetails("Güç Kaynakları","ASUS TUF GAMING 450W 80PLUS BRONZE");
                            pcDetailsArrayList.add(pcDetails499);

                            PcDetails pcDetails501 = new PcDetails("Güç Kaynakları","ASUS TUF GAMING 750W 80PLUS BRONZE ");
                            pcDetailsArrayList.add(pcDetails501);

                            PcDetails pcDetails511 = new PcDetails("Güç Kaynakları","ASUS ROG STRIX 1000W 80 PLUS GOLD ");
                            pcDetailsArrayList.add(pcDetails511);

                            PcDetails pcDetails512 = new PcDetails("Güç Kaynakları","MSI MPG A750GF 750W 80 PLUS GOLD ");
                            pcDetailsArrayList.add(pcDetails512);

                            PcDetails pcDetails513 = new PcDetails("Güç Kaynakları","THERMALTAKE TOUGHPOWER PF1 850W 80+ PLATINUM FULL");
                            pcDetailsArrayList.add(pcDetails513);

                            PcDetails pcDetails514 = new PcDetails("Güç Kaynakları","ASUS TUF GAMING 650W 80PLUS BRONZE");
                            pcDetailsArrayList.add(pcDetails514);

                            PcDetails pcDetails515 = new PcDetails("Güç Kaynakları","XIGMATEK HYDRA M 550W 80PLUS BRONZE FULL MODULERI");
                            pcDetailsArrayList.add(pcDetails515);

                            PcDetails pcDetails516 = new PcDetails("Güç Kaynakları","XIGMATEK HYDRA M 650W 80PLUS BRONZE FULL MODULER");
                            pcDetailsArrayList.add(pcDetails516);

                            PcDetails pcDetails517 = new PcDetails("Güç Kaynakları","ZALMAN ZM700-TXII 700W 80 PLUS");
                            pcDetailsArrayList.add(pcDetails517);

                            PcDetails pcDetails518 = new PcDetails("Güç Kaynakları","ZALMAN ZM1200-EBTII WATTTERA 80PLUS GOLD 1200W ");
                            pcDetailsArrayList.add(pcDetails518);

                            PcDetails pcDetails519 = new PcDetails("Güç Kaynakları","RAMPAGE BTC-1650 1650W 140MM");
                            pcDetailsArrayList.add(pcDetails519);

                            PcDetails pcDetails610 = new PcDetails("Güç Kaynakları","COUGAR GEX1050 1050W 80PLUS GOLD ");
                            pcDetailsArrayList.add(pcDetails610);

                            PcDetails pcDetails611 = new PcDetails("Güç Kaynakları","COUGAR GEX850 850W 80PLUS GOLD ");
                            pcDetailsArrayList.add(pcDetails611);

                            PcDetails pcDetails621 = new PcDetails("Güç Kaynakları","COUGAR VTE X2 750 750W 80PLUS BRONZE ");
                            pcDetailsArrayList.add(pcDetails621);

                            PcDetails pcDetails631 = new PcDetails("Güç Kaynakları","COUGAR GX-S450 450W 80PLUS GOLD");
                            pcDetailsArrayList.add(pcDetails631);

                            PcDetails pcDetails642 = new PcDetails("Güç Kaynakları","COOLER MASTER MWE V2 750W 80PLUS GOLD 2xEPS 120MM ");
                            pcDetailsArrayList.add(pcDetails642);

                            PcDetails pcDetails652 = new PcDetails("Güç Kaynakları","RAMPAGE RGB 500W 80 PLUS BRONZE 120mm RGB ");
                            pcDetailsArrayList.add(pcDetails652);

                            PcDetails pcDetails662 = new PcDetails("Güç Kaynakları","CORSAIR RMx SERİSİ RM750X 750W 80PLUS GOLD TAM");
                            pcDetailsArrayList.add(pcDetails662);

                            PcDetails pcDetails671 = new PcDetails("Güç Kaynakları","XIGMATEK MINOTOUR SERİSİ 750W 80PLUS GOLD FULL");
                            pcDetailsArrayList.add(pcDetails671);

                            PcDetails pcDetails681 = new PcDetails("Güç Kaynakları","XIGMATEK MINOTOUR SERİSİ 850W 80PLUS GOLD FULL");
                            pcDetailsArrayList.add(pcDetails681);

                            PcDetails pcDetails691 = new PcDetails("Güç Kaynakları","FRISBY FR-PS50F12B 500W 120mm ");
                            pcDetailsArrayList.add(pcDetails691);

                            PcDetails pcDetails710 = new PcDetails("Güç Kaynakları","THERMALTAKE TOUGHPOWER GF 750W 80PLUS GOLD FULL");
                            pcDetailsArrayList.add(pcDetails710);

                            PcDetails pcDetails711 = new PcDetails("Güç Kaynakları","THERMALTAKE TOUGHPOWER GRAND 80PLUS PLATINUM 1050W");
                            pcDetailsArrayList.add(pcDetails711);

                            PcDetails pcDetails721 = new PcDetails("Güç Kaynakları","ASUS ROG THOR 850W 80 PLUS PLATINUM AURO SYNC & OLED");
                            pcDetailsArrayList.add(pcDetails721);

                            PcDetails pcDetails713 = new PcDetails("Güç Kaynakları","CORSAIR RMx SERİSİ RM750X V2 750W 80PLUS GOLD ");
                            pcDetailsArrayList.add(pcDetails713);

                            PcDetails pcDetails714 = new PcDetails("Güç Kaynakları","THERMALTAKE TOUGHPOWER GF2 80 PLUS 850W GOLD ARGB");
                            pcDetailsArrayList.add(pcDetails714);

                            PcDetails pcDetails715 = new PcDetails("Güç Kaynakları","CORSAIR CX SERİSİ CX650F RGB 650W 80PLUS BRONZE");
                            pcDetailsArrayList.add(pcDetails715);

                            PcDetails pcDetails716 = new PcDetails("Güç Kaynakları","ASUS TUF GAMING 450W 80PLUS BRONZE");
                            pcDetailsArrayList.add(pcDetails716);

                            PcDetails pcDetails717 = new PcDetails("Güç Kaynakları","ASUS TUF GAMING 750W 80PLUS BRONZE ");
                            pcDetailsArrayList.add(pcDetails717);

                            PcDetails pcDetails718 = new PcDetails("Güç Kaynakları","ASUS ROG STRIX 1000W 80 PLUS GOLD ");
                            pcDetailsArrayList.add(pcDetails718);

                            PcDetails pcDetails719 = new PcDetails("Güç Kaynakları","MSI MPG A750GF 750W 80 PLUS GOLD ");
                            pcDetailsArrayList.add(pcDetails719);

                            PcDetails pcDetails810 = new PcDetails("Güç Kaynakları","THERMALTAKE TOUGHPOWER PF1 850W 80+ PLATINUM FULL");
                            pcDetailsArrayList.add(pcDetails810);

                            PcDetails pcDetails811 = new PcDetails("Güç Kaynakları","ASUS TUF GAMING 650W 80PLUS BRONZE ");
                            pcDetailsArrayList.add(pcDetails811);

                            PcDetails pcDetails821 = new PcDetails("Güç Kaynakları","ASUS TUF GAMING 650W 80PLUS BRONZE ");
                            pcDetailsArrayList.add(pcDetails821);

                            PcDetails pcDetails813 = new PcDetails("Güç Kaynakları","XIGMATEK HYDRA M 550W 80PLUS BRONZE FULL MODULER ");
                            pcDetailsArrayList.add(pcDetails813);

                            PcDetails pcDetails814 = new PcDetails("Güç Kaynakları","XIGMATEK HYDRA M 650W 80PLUS BRONZE FULL MODULER ");
                            pcDetailsArrayList.add(pcDetails814);

                            PcDetails pcDetails815 = new PcDetails("Güç Kaynakları","ZALMAN ZM700-TXII 700W 80 PLUS ");
                            pcDetailsArrayList.add(pcDetails815);

                            PcDetails pcDetails816 = new PcDetails("Güç Kaynakları","ZALMAN ZM500-TXII 500W 80 PLUS ");
                            pcDetailsArrayList.add(pcDetails816);

                            PcDetails pcDetails817 = new PcDetails("Güç Kaynakları","ASUS ROG STRIX WHITE 850W 80 PLUS GOLD ");
                            pcDetailsArrayList.add(pcDetails817);

                            PcDetails pcDetails818 = new PcDetails("Güç Kaynakları","CORSAIR CV SERİSİ CV650 650W 80PLUS BRONZE ");
                            pcDetailsArrayList.add(pcDetails818);

                            PcDetails pcDetails819 = new PcDetails("Güç Kaynakları","COOLER MASTER MWE 80PLUS BRONZE 750W 2xEPS,AKTİF PFC");
                            pcDetailsArrayList.add(pcDetails819);

                            PcDetails pcDetails901 = new PcDetails("Güç Kaynakları","CORSAIR CV SERİSİ CV550 550W 80PLUS BRONZE ");
                            pcDetailsArrayList.add(pcDetails901);

                            PcDetails pcDetails911 = new PcDetails("Güç Kaynakları","CORSAIR RM SERİSİ 650W 80PLUS GOLD MODULER");
                            pcDetailsArrayList.add(pcDetails911);

                            PcDetails pcDetails912 = new PcDetails("Güç Kaynakları","THERMALTAKE TOUGHPOWER PF1 ARGB 80PLUS PLATINUM 1200W");
                            pcDetailsArrayList.add(pcDetails912);

                            PcDetails pcDetails913 = new PcDetails("Güç Kaynakları","COUGAR BXM-850 850W 80 PLUS BRONZE ");
                            pcDetailsArrayList.add(pcDetails913);

                            PcDetails pcDetails914 = new PcDetails("Güç Kaynakları","COUGAR BXM-700 700W 80 PLUS BRONZE ");
                            pcDetailsArrayList.add(pcDetails914);

                            PcDetails pcDetails915 = new PcDetails("Güç Kaynakları","COUGAR XTC 500 500W 80 PLUS ");
                            pcDetailsArrayList.add(pcDetails915);

                            PcDetails pcDetails7118 = new PcDetails("Güç Kaynakları","FRISBY FR-PS6580P-RGB 80 PLUS 650W");
                            pcDetailsArrayList.add(pcDetails7118);

                            PcDetails pcDetails7119 = new PcDetails("Güç Kaynakları","FRISBY FR-PS6080P 80 PLUS BRONZE 600W ");
                            pcDetailsArrayList.add(pcDetails7119);

                            PcDetails pcDetails870 = new PcDetails("Güç Kaynakları","ASUS ROG STRIX 750W 80 PLUS GOLD ");
                            pcDetailsArrayList.add(pcDetails870);

                            PcDetails pcDetails871 = new PcDetails("Güç Kaynakları","ASUS ROG STRIX 650W 80 PLUS GOLD ");
                            pcDetailsArrayList.add(pcDetails871);

                            PcDetails pcDetails872 = new PcDetails("Güç Kaynakları","ASUS ROG STRIX 550W 80 PLUS GOLD");
                            pcDetailsArrayList.add(pcDetails872);

                            PcDetails pcDetails873 = new PcDetails("Güç Kaynakları","THERMALTAKE TR2 S 750W 80 PLUS 120mm ");
                            pcDetailsArrayList.add(pcDetails873);

                            PcDetails pcDetails874 = new PcDetails("Güç Kaynakları","THERMALTAKE TR2 S 650W 80 PLUS 120mm ");
                            pcDetailsArrayList.add(pcDetails874);

                            PcDetails pcDetails875 = new PcDetails("Güç Kaynakları","THERMALTAKE TR2 S 550W 80 PLUS 120mm ");
                            pcDetailsArrayList.add(pcDetails875);

                            PcDetails pcDetails876 = new PcDetails("Güç Kaynakları","FRISBY FR-PS6580P 650W 80 PLUS 120mm");
                            pcDetailsArrayList.add(pcDetails876);

                            PcDetails pcDetails877 = new PcDetails("Güç Kaynakları","COUGAR CGR-GS-750 GX-S 750W 80PLUS GOLD ");
                            pcDetailsArrayList.add(pcDetails877);

                            PcDetails pcDetails878 = new PcDetails("Güç Kaynakları","COUGAR CGR-BX-700 CMX 700W 80PLUS BRONZE ");
                            pcDetailsArrayList.add(pcDetails878);

                            PcDetails pcDetails879 = new PcDetails("Güç Kaynakları","THERMALTAKE TOUGHPOWER PF1 ARGB 80PLUS PLATINUM 1050W");
                            pcDetailsArrayList.add(pcDetails879);

                            PcDetails pcDetails970 = new PcDetails("Güç Kaynakları","THERMALTAKE TOUGHPOWER GF1 80 PLUS 850W GOLD FULL");
                            pcDetailsArrayList.add(pcDetails970);

                            PcDetails pcDetails971 = new PcDetails("Güç Kaynakları","THERMALTAKE SMART RGB BX1 80PLUS BRONZE 750W ");
                            pcDetailsArrayList.add(pcDetails971);

                            PcDetails pcDetails972 = new PcDetails("Güç Kaynakları","COOLER MASTER MWE 80PLUS 600W 2xEPS, AKTİF PFC 120MM");
                            pcDetailsArrayList.add(pcDetails972);

                            PcDetails pcDetails973 = new PcDetails("Güç Kaynakları","XIGMATEK MINOTAUR FULL RANGE 80PLUS GOLD 650W FULL");
                            pcDetailsArrayList.add(pcDetails973);

                            PcDetails pcDetails974 = new PcDetails("Güç Kaynakları","COUGAR CGR-STX-700 700W 80 PLUS ");
                            pcDetailsArrayList.add(pcDetails974);

                            PcDetails pcDetails975 = new PcDetails("Güç Kaynakları","XIGMATEK X-POWER 650W 80PLUS");
                            pcDetailsArrayList.add(pcDetails975);

                            PcDetails pcDetails931 = new PcDetails("Güç Kaynakları","THERMALTAKE LITEPOWER RGB 550W APFC 12cm");
                            pcDetailsArrayList.add(pcDetails931);

                            PcDetails pcDetails932 = new PcDetails("Güç Kaynakları","XIGMATEK X-POWER SERİSİ 600W 80PLUS ");
                            pcDetailsArrayList.add(pcDetails932);

                            PcDetails pcDetails933 = new PcDetails("Güç Kaynakları","XIGMATEK X-POWER SERİSİ 500W 80PLUS ");
                            pcDetailsArrayList.add(pcDetails933);

                            PcDetails pcDetails9332 = new PcDetails("Güç Kaynakları","THERMALTAKE SMART RGB 80 PLUS 700W ");
                            pcDetailsArrayList.add(pcDetails9332);

                            PcDetails pcDetails9333 = new PcDetails("Güç Kaynakları","THERMALTAKE SMART RGB 80PLUS 600W ");
                            pcDetailsArrayList.add(pcDetails9333);

                            PcDetails pcDetails9334 = new PcDetails("Güç Kaynakları","THERMALTAKE SMART RGB 80PLUS 500W ");
                            pcDetailsArrayList.add(pcDetails9334);

                            PcDetails pcDetails9335 = new PcDetails("Güç Kaynakları","RAMPAGE RMP-750-80PB 750W 80 PLUS BRONZE 140MM");
                            pcDetailsArrayList.add(pcDetails9335);

                            PcDetails pcDetails933445 = new PcDetails("Güç Kaynakları","RAMPAGE RMP-700-80P 700W 80PLUS 120MM");
                            pcDetailsArrayList.add(pcDetails933445);

                            PcDetails pcDetails93356 = new PcDetails("Güç Kaynakları","RAMPAGE RMP-650-80PB 650W 80PLUS BRONZE 140MM ");
                            pcDetailsArrayList.add(pcDetails93356);

                            PcDetails pcDetails97077 = new PcDetails("Güç Kaynakları","THERMALTAKE TOUGHPOWER GF1 80 PLUS 850W GOLD FULL");
                            pcDetailsArrayList.add(pcDetails97077);

                            PcDetails pcDetails97181 = new PcDetails("Güç Kaynakları","RAMPAGE RMP-750-80PB 750W 80 PLUS BRONZE 140MM");
                            pcDetailsArrayList.add(pcDetails97181);

                            PcDetails pcDetails97282 = new PcDetails("Güç Kaynakları","RAMPAGE RMP-700-80P 700W 80PLUS 120MM  ");
                            pcDetailsArrayList.add(pcDetails97282);

                            PcDetails pcDetails97383 = new PcDetails("Güç Kaynakları","RAMPAGE RMP-650-80PB 650W 80PLUS BRONZE 140MM");
                            pcDetailsArrayList.add(pcDetails97383);

                            PcDetails pcDetails97484 = new PcDetails("Güç Kaynakları","RAMPAGE RMP-600-80P 600W 80PLUS 120MM ");
                            pcDetailsArrayList.add(pcDetails97484);

                            PcDetails pcDetails97585 = new PcDetails("Güç Kaynakları","XIGMATEK X MINER 1800W 80 PLUS GOLD ");
                            pcDetailsArrayList.add(pcDetails97585);

                            PcDetails pcDetails93186 = new PcDetails("Güç Kaynakları","RAMPAGE RGB-550 80PLUS GOLD 550W FULL MODÜLER RGB ");
                            pcDetailsArrayList.add(pcDetails93186);

                            PcDetails pcDetails93287 = new PcDetails("Güç Kaynakları","COOLER MASTER WATT 80PLUS 600W AKTİF PFC 120MM ");
                            pcDetailsArrayList.add(pcDetails93287);

                            PcDetails pcDetails93388 = new PcDetails("Güç Kaynakları","THERMALTAKE LITEPOWER 550W ");
                            pcDetailsArrayList.add(pcDetails93388);

                            PcDetails pcDetails933289 = new PcDetails("Güç Kaynakları","EVEREST BTX-600 600W 80PLUS BRONZE ");
                            pcDetailsArrayList.add(pcDetails933289);

                            PcDetails pcDetails933390 = new PcDetails("Güç Kaynakları","EVEREST ETX-750 750W 80PLUS GOLD");
                            pcDetailsArrayList.add(pcDetails933390);

                            PcDetails pcDetails933491 = new PcDetails("Güç Kaynakları","EVEREST EPS-4900B 350W");
                            pcDetailsArrayList.add(pcDetails933491);



                            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                            adaptorPcDetails = new AdaptorPcDetails(pcDetailsArrayList);
                            recyclerView.setAdapter(adaptorPcDetails);




                            adaptorPcDetails.notifyDataSetChanged();


                        }else if (dil.equals("ingilizce")){

                            PcDetails pcDetails96 = new PcDetails("Power Supplies","RAMPAGE RGB 600W 80 PLUS BRONZE 120mm RGB");
                            pcDetailsArrayList.add(pcDetails96);

                            PcDetails pcDetails97 = new PcDetails("Power Supplies","POWERBOOST FURY 550W 80 PLUS 120mm ");
                            pcDetailsArrayList.add(pcDetails97);  
                                                                  
                            PcDetails pcDetails98 = new PcDetails("Power Supplies","COOLER MASTER MWE 80PLUS BRONZE 750W 2xEPS, AKTİF PFC");
                            pcDetailsArrayList.add(pcDetails98);

                            PcDetails pcDetails99 = new PcDetails("Power Supplies","EVGA SUPERNOVA 850 GA 850W 80 PLUS GOLD FULL MODULER");
                            pcDetailsArrayList.add(pcDetails99);

                            PcDetails pcDetails100 = new PcDetails("Power Supplies","COOLER MASTER MWE V2 850W 80PLUS GOLD 2xEPS 120MM ");
                            pcDetailsArrayList.add(pcDetails100);

                            PcDetails pcDetails101 = new PcDetails("Power Supplies","MSI MPG A850GF 850W 80 PLUS GOLD ");
                            pcDetailsArrayList.add(pcDetails101);

                            PcDetails pcDetails102 = new PcDetails("Power Supplies","POWERBOOST FURY 650W 80 PLUS 120mm ");
                            pcDetailsArrayList.add(pcDetails102);

                            PcDetails pcDetails103 = new PcDetails("Power Supplies","COOLER MASTER ELITE V4 80PLUS 500W AKTİF PFC 120mm");
                            pcDetailsArrayList.add(pcDetails103);

                            PcDetails pcDetails104 = new PcDetails("Power Supplies","POWERBOOST FURY 750W 80 PLUS 120mm ");
                            pcDetailsArrayList.add(pcDetails104);

                            PcDetails pcDetails105 = new PcDetails("Power Supplies","CORSAIR CX SERİSİ CX750F RGB 750W 80PLUS BRONZE ");
                            pcDetailsArrayList.add(pcDetails105);

                            PcDetails pcDetails106 = new PcDetails("Power Supplies","THERMALTAKE TOUGHPOWER GF1 80+ GOLD 750W 140mm ");
                            pcDetailsArrayList.add(pcDetails106);

                            PcDetails pcDetails107 = new PcDetails("Power Supplies","COOLER MASTER MWE 80PLUS BRONZE 600W 2xEPS, AKTİF PFC");
                            pcDetailsArrayList.add(pcDetails107);

                            PcDetails pcDetails108 = new PcDetails("Power Supplies","THERMALTAKE LİTEPOWER RGB 650W APFC 12cm PSU");
                            pcDetailsArrayList.add(pcDetails108);

                            PcDetails pcDetails109 = new PcDetails("Power Supplies","COOLER MASTER M2000 2000W 80PLUS PLATINUM 135MM ");
                            pcDetailsArrayList.add(pcDetails109);

                            PcDetails pcDetails110 = new PcDetails("Power Supplies","MSI MPG A1000G 1000W 80+ GOLD PSU Full Modüler ");
                            pcDetailsArrayList.add(pcDetails110);

                            PcDetails pcDetails111 = new PcDetails("Power Supplies","THERMALTAKE SMART BX1 80PLUS BRONZE 750W ");
                            pcDetailsArrayList.add(pcDetails111);

                            PcDetails pcDetails112 = new PcDetails("Power Supplies","THERMALTAKE TOUGHPOWER GF 850W 80PLUS GOLD FULL");
                            pcDetailsArrayList.add(pcDetails112);

                            PcDetails pcDetails113 = new PcDetails("Power Supplies","CORSAIR CX SERİSİ CX750F RGB 750W 80PLUS BRONZE TAM");
                            pcDetailsArrayList.add(pcDetails113);


                            PcDetails pcDetails1143 = new PcDetails("Power Supplies","MSI MPG A650GF 650W 80 PLUS GOLD ");
                            pcDetailsArrayList.add(pcDetails1143);

                            PcDetails pcDetails114 = new PcDetails("Power Supplies","XIGMATEK X-POWER SERİSİ 350W");
                            pcDetailsArrayList.add(pcDetails114);

                            PcDetails pcDetails115 = new PcDetails("Power Supplies","ZALMAN ZM600-TXII 600W 80 PLUS");
                            pcDetailsArrayList.add(pcDetails115);

                            PcDetails pcDetails116 = new PcDetails("Power Supplies","COOLER MASTER MWE 80PLUS BRONZE 700W 2xEPS, AKTİF PFC");
                            pcDetailsArrayList.add(pcDetails116);

                            PcDetails pcDetails117 = new PcDetails("Power Supplies","COOLER MASTER MWE 80PLUS BRONZE 650W 2xEPS, AKTİF PFC");
                            pcDetailsArrayList.add(pcDetails117);

                            PcDetails pcDetails118 = new PcDetails("Power Supplies","ASUS ROG STRIX 850W 80 PLUS GOLD ");
                            pcDetailsArrayList.add(pcDetails118);

                            PcDetails pcDetails119 = new PcDetails("Power Supplies","THERMALTAKE SMART BX1 80PLUS BRONZE 650W ");
                            pcDetailsArrayList.add(pcDetails119);

                            PcDetails pcDetails200 = new PcDetails("Power Supplies","COOLER MASTER MWE 80PLUS 650W 2xEPS, AKTİF PFC 120MM");
                            pcDetailsArrayList.add(pcDetails200);

                            PcDetails pcDetails202 = new PcDetails("Power Supplies","THERMALTAKE TOUGHPOWER GRAND 80+ PLATINUM 1200W FUL");
                            pcDetailsArrayList.add(pcDetails202);

                            PcDetails pcDetails203 = new PcDetails("Power Supplies","RAMPAGE RMP-500-80P 500W 80PLUS 120MM");
                            pcDetailsArrayList.add(pcDetails203);

                            PcDetails pcDetails204 = new PcDetails("Power Supplies","THERMALTAKE LITEPOWER 650W ");
                            pcDetailsArrayList.add(pcDetails204);

                            PcDetails pcDetails205 = new PcDetails("Power Supplies","ASUS ROG-THOR GAMING 1200W 80PLUS PLATINIUM AURO SYNC &");
                            pcDetailsArrayList.add(pcDetails205);

                            PcDetails pcDetails206 = new PcDetails("Power Supplies","THERMALTAKE TOUGHPOWER GF1 1000W 80PLUS GOLD FULL");
                            pcDetailsArrayList.add(pcDetails206);

                            PcDetails pcDetails207 = new PcDetails("Power Supplies","POWERBOOST 2000W 140mm");
                            pcDetailsArrayList.add(pcDetails207);

                            PcDetails pcDetails208 = new PcDetails("Power Supplies","POWERBOOST WARRIOR 850W 80 PLUS GOLD FULL MODÜLER");
                            pcDetailsArrayList.add(pcDetails208);

                            PcDetails pcDetails209 = new PcDetails("Power Supplies","CORSAIR CP-9020234-EU RM750 750W TAM MODULER 80PLUS ");
                            pcDetailsArrayList.add(pcDetails209);

                            PcDetails pcDetails210 = new PcDetails("Power Supplies","CORSAIR RM850 850W TAM MODULER 80PLUS GOLD");
                            pcDetailsArrayList.add(pcDetails210);

                            PcDetails pcDetails211 = new PcDetails("Power Supplies","CORSAIR RM750 750W TAM MODULER 80PLUS GOLD");
                            pcDetailsArrayList.add(pcDetails211);

                            PcDetails pcDetails212 = new PcDetails("Power Supplies","COOLER MASTER XG PLUS 850W 80+ PLATINYUM RGB FULL");
                            pcDetailsArrayList.add(pcDetails212);

                            PcDetails pcDetails213 = new PcDetails("Power Supplies","THERMALTAKE TOUGHPOWER GF2 80 PLUS 750W GOLD ARGB");
                            pcDetailsArrayList.add(pcDetails213);

                            PcDetails pcDetails224 = new PcDetails("Power Supplies","EVGA 500 W2 500W 80 PLUS ");
                            pcDetailsArrayList.add(pcDetails224);

                            PcDetails pcDetails234 = new PcDetails("Power Supplies","EVGA SUPERNOVA 750 GA 750W 80 PLUS GOLD FULL MODULER");
                            pcDetailsArrayList.add(pcDetails234);

                            PcDetails pcDetails244 = new PcDetails("Power Supplies","EVGA 1000 GQ 1000W 80 PLUS GOLD SEMI MODULER");
                            pcDetailsArrayList.add(pcDetails244);

                            PcDetails pcDetails255 = new PcDetails("Power Supplies","EVGA 750 GQ 750W 80 PLUS GOLD SEMI MODULER ");
                            pcDetailsArrayList.add(pcDetails255);

                            PcDetails pcDetails266 = new PcDetails("Power Supplies","MSI MAG A550BN 550W 80 PLUS BRONZE ");
                            pcDetailsArrayList.add(pcDetails266);

                            PcDetails pcDetails277 = new PcDetails("Power Supplies","COOLER MASTER V750W SFX 80PLUS GOLD 750W ");
                            pcDetailsArrayList.add(pcDetails277);

                            PcDetails pcDetails288 = new PcDetails("Power Supplies","COOLER MASTER MWE V2 80PLUS GOLD 1250W FULL MODÜLER 140MM");
                            pcDetailsArrayList.add(pcDetails288);

                            PcDetails pcDetails299 = new PcDetails("Power Supplies","COOLER MASTER MWE V2 80PLUS GOLD 1050W FULL MODÜLER");
                            pcDetailsArrayList.add(pcDetails299);

                            PcDetails pcDetails300 = new PcDetails("Power Supplies","ZALMAN ZM1200-EBTII WATTTERA 80PLUS GOLD 1200W I");
                            pcDetailsArrayList.add(pcDetails300);

                            PcDetails pcDetails320 = new PcDetails("Power Supplies","RAMPAGE BTC-1650 1650W 140MM");
                            pcDetailsArrayList.add(pcDetails320);

                            PcDetails pcDetails333 = new PcDetails("Power Supplies","COUGAR GEX1050 1050W 80PLUS GOLD ");
                            pcDetailsArrayList.add(pcDetails333);

                            PcDetails pcDetails344 = new PcDetails("Power Supplies","COUGAR GEX850 850W 80PLUS GOLD ");
                            pcDetailsArrayList.add(pcDetails344);

                            PcDetails pcDetails355 = new PcDetails("Power Supplies","COUGAR VTE X2 750 750W 80PLUS BRONZE ");
                            pcDetailsArrayList.add(pcDetails355);

                            PcDetails pcDetails366 = new PcDetails("Power Supplies","COUGAR GX-S450 450W 80PLUS GOLD ");
                            pcDetailsArrayList.add(pcDetails366);   

                            PcDetails pcDetails377= new PcDetails("Power Supplies","COOLER MASTER MWE V2 750W 80PLUS GOLD 2xEPS 120MM ");
                            pcDetailsArrayList.add(pcDetails377);

                            PcDetails pcDetails381 = new PcDetails("Power Supplies","RAMPAGE RGB 500W 80 PLUS BRONZE 120mm RGB");
                            pcDetailsArrayList.add(pcDetails381);

                            PcDetails pcDetails391 = new PcDetails("Power Supplies","CORSAIR RMx SERİSİ RM750X 750W 80PLUS GOLD TAM");
                            pcDetailsArrayList.add(pcDetails391);

                            PcDetails pcDetails401 = new PcDetails("Power Supplies","XIGMATEK MINOTOUR SERİSİ 750W 80PLUS GOLD FULL");
                            pcDetailsArrayList.add(pcDetails401);

                            PcDetails pcDetails412 = new PcDetails("Power Supplies","XIGMATEK MINOTOUR SERİSİ 850W 80PLUS GOLD FULL");
                            pcDetailsArrayList.add(pcDetails412);

                            PcDetails pcDetails421 = new PcDetails("Power Supplies","FRISBY FR-PS50F12B 500W 120mm");
                            pcDetailsArrayList.add(pcDetails421);

                            PcDetails pcDetails433 = new PcDetails("Power Supplies","THERMALTAKE TOUGHPOWER GF 750W 80PLUS GOLD FULL");
                            pcDetailsArrayList.add(pcDetails433);

                            PcDetails pcDetails444 = new PcDetails("Power Supplies","THERMALTAKE TOUGHPOWER GRAND 80PLUS PLATINUM 1050W");
                            pcDetailsArrayList.add(pcDetails444);

                            PcDetails pcDetails456 = new PcDetails("Power Supplies","ASUS ROG THOR 850W 80 PLUS PLATINUM AURO SYNC & OLED");
                            pcDetailsArrayList.add(pcDetails456);

                            PcDetails pcDetails467 = new PcDetails("Power Supplies","CORSAIR RMx SERİSİ RM750X V2 750W 80PLUS GOLD ");
                            pcDetailsArrayList.add(pcDetails467);

                            PcDetails pcDetails477 = new PcDetails("Power Supplies","THERMALTAKE TOUGHPOWER GF2 80 PLUS 850W GOLD ARGB");
                            pcDetailsArrayList.add(pcDetails477);

                            PcDetails pcDetails488 = new PcDetails("Power Supplies","CORSAIR CX SERİSİ CX650F RGB 650W 80PLUS BRONZE ");
                            pcDetailsArrayList.add(pcDetails488);

                            PcDetails pcDetails499 = new PcDetails("Power Supplies","ASUS TUF GAMING 450W 80PLUS BRONZE");
                            pcDetailsArrayList.add(pcDetails499);

                            PcDetails pcDetails501 = new PcDetails("Power Supplies","ASUS TUF GAMING 750W 80PLUS BRONZE ");
                            pcDetailsArrayList.add(pcDetails501);

                            PcDetails pcDetails511 = new PcDetails("Power Supplies","ASUS ROG STRIX 1000W 80 PLUS GOLD ");
                            pcDetailsArrayList.add(pcDetails511);

                            PcDetails pcDetails512 = new PcDetails("Power Supplies","MSI MPG A750GF 750W 80 PLUS GOLD ");
                            pcDetailsArrayList.add(pcDetails512);

                            PcDetails pcDetails513 = new PcDetails("Power Supplies","THERMALTAKE TOUGHPOWER PF1 850W 80+ PLATINUM FULL");
                            pcDetailsArrayList.add(pcDetails513);

                            PcDetails pcDetails514 = new PcDetails("Power Supplies","ASUS TUF GAMING 650W 80PLUS BRONZE");
                            pcDetailsArrayList.add(pcDetails514);

                            PcDetails pcDetails515 = new PcDetails("Power Supplies","XIGMATEK HYDRA M 550W 80PLUS BRONZE FULL MODULERI");
                            pcDetailsArrayList.add(pcDetails515);

                            PcDetails pcDetails516 = new PcDetails("Power Supplies","XIGMATEK HYDRA M 650W 80PLUS BRONZE FULL MODULER");
                            pcDetailsArrayList.add(pcDetails516);

                            PcDetails pcDetails517 = new PcDetails("Power Supplies","ZALMAN ZM700-TXII 700W 80 PLUS");
                            pcDetailsArrayList.add(pcDetails517);

                            PcDetails pcDetails518 = new PcDetails("Power Supplies","ZALMAN ZM1200-EBTII WATTTERA 80PLUS GOLD 1200W ");
                            pcDetailsArrayList.add(pcDetails518);

                            PcDetails pcDetails519 = new PcDetails("Power Supplies","RAMPAGE BTC-1650 1650W 140MM");
                            pcDetailsArrayList.add(pcDetails519);

                            PcDetails pcDetails610 = new PcDetails("Power Supplies","COUGAR GEX1050 1050W 80PLUS GOLD ");
                            pcDetailsArrayList.add(pcDetails610);

                            PcDetails pcDetails611 = new PcDetails("Power Supplies","COUGAR GEX850 850W 80PLUS GOLD ");
                            pcDetailsArrayList.add(pcDetails611);

                            PcDetails pcDetails621 = new PcDetails("Power Supplies","COUGAR VTE X2 750 750W 80PLUS BRONZE ");
                            pcDetailsArrayList.add(pcDetails621);

                            PcDetails pcDetails631 = new PcDetails("Power Supplies","COUGAR GX-S450 450W 80PLUS GOLD");
                            pcDetailsArrayList.add(pcDetails631);

                            PcDetails pcDetails642 = new PcDetails("Power Supplies","COOLER MASTER MWE V2 750W 80PLUS GOLD 2xEPS 120MM ");
                            pcDetailsArrayList.add(pcDetails642);

                            PcDetails pcDetails652 = new PcDetails("Power Supplies","RAMPAGE RGB 500W 80 PLUS BRONZE 120mm RGB ");
                            pcDetailsArrayList.add(pcDetails652);

                            PcDetails pcDetails662 = new PcDetails("Power Supplies","CORSAIR RMx SERİSİ RM750X 750W 80PLUS GOLD TAM");
                            pcDetailsArrayList.add(pcDetails662);

                            PcDetails pcDetails671 = new PcDetails("Power Supplies","XIGMATEK MINOTOUR SERİSİ 750W 80PLUS GOLD FULL");
                            pcDetailsArrayList.add(pcDetails671);

                            PcDetails pcDetails681 = new PcDetails("Power Supplies","XIGMATEK MINOTOUR SERİSİ 850W 80PLUS GOLD FULL");
                            pcDetailsArrayList.add(pcDetails681);

                            PcDetails pcDetails691 = new PcDetails("Power Supplies","FRISBY FR-PS50F12B 500W 120mm ");
                            pcDetailsArrayList.add(pcDetails691);

                            PcDetails pcDetails710 = new PcDetails("Power Supplies","THERMALTAKE TOUGHPOWER GF 750W 80PLUS GOLD FULL");
                            pcDetailsArrayList.add(pcDetails710);

                            PcDetails pcDetails711 = new PcDetails("Power Supplies","THERMALTAKE TOUGHPOWER GRAND 80PLUS PLATINUM 1050W");
                            pcDetailsArrayList.add(pcDetails711);

                            PcDetails pcDetails721 = new PcDetails("Power Supplies","ASUS ROG THOR 850W 80 PLUS PLATINUM AURO SYNC & OLED");
                            pcDetailsArrayList.add(pcDetails721);

                            PcDetails pcDetails713 = new PcDetails("Power Supplies","CORSAIR RMx SERİSİ RM750X V2 750W 80PLUS GOLD ");
                            pcDetailsArrayList.add(pcDetails713);

                            PcDetails pcDetails714 = new PcDetails("Power Supplies","THERMALTAKE TOUGHPOWER GF2 80 PLUS 850W GOLD ARGB");
                            pcDetailsArrayList.add(pcDetails714);

                            PcDetails pcDetails715 = new PcDetails("Power Supplies","CORSAIR CX SERİSİ CX650F RGB 650W 80PLUS BRONZE");
                            pcDetailsArrayList.add(pcDetails715);

                            PcDetails pcDetails716 = new PcDetails("Power Supplies","ASUS TUF GAMING 450W 80PLUS BRONZE");
                            pcDetailsArrayList.add(pcDetails716);

                            PcDetails pcDetails717 = new PcDetails("Power Supplies","ASUS TUF GAMING 750W 80PLUS BRONZE ");
                            pcDetailsArrayList.add(pcDetails717);

                            PcDetails pcDetails718 = new PcDetails("Power Supplies","ASUS ROG STRIX 1000W 80 PLUS GOLD ");
                            pcDetailsArrayList.add(pcDetails718);

                            PcDetails pcDetails719 = new PcDetails("Power Supplies","MSI MPG A750GF 750W 80 PLUS GOLD ");
                            pcDetailsArrayList.add(pcDetails719);

                            PcDetails pcDetails810 = new PcDetails("Power Supplies","THERMALTAKE TOUGHPOWER PF1 850W 80+ PLATINUM FULL");
                            pcDetailsArrayList.add(pcDetails810);

                            PcDetails pcDetails811 = new PcDetails("Power Supplies","ASUS TUF GAMING 650W 80PLUS BRONZE ");
                            pcDetailsArrayList.add(pcDetails811);

                            PcDetails pcDetails821 = new PcDetails("Power Supplies","ASUS TUF GAMING 650W 80PLUS BRONZE ");
                            pcDetailsArrayList.add(pcDetails821);

                            PcDetails pcDetails813 = new PcDetails("Power Supplies","XIGMATEK HYDRA M 550W 80PLUS BRONZE FULL MODULER ");
                            pcDetailsArrayList.add(pcDetails813);

                            PcDetails pcDetails814 = new PcDetails("Power Supplies","XIGMATEK HYDRA M 650W 80PLUS BRONZE FULL MODULER ");
                            pcDetailsArrayList.add(pcDetails814);

                            PcDetails pcDetails815 = new PcDetails("Power Supplies","ZALMAN ZM700-TXII 700W 80 PLUS ");
                            pcDetailsArrayList.add(pcDetails815);

                            PcDetails pcDetails816 = new PcDetails("Power Supplies","ZALMAN ZM500-TXII 500W 80 PLUS ");
                            pcDetailsArrayList.add(pcDetails816);

                            PcDetails pcDetails817 = new PcDetails("Power Supplies","ASUS ROG STRIX WHITE 850W 80 PLUS GOLD ");
                            pcDetailsArrayList.add(pcDetails817);

                            PcDetails pcDetails818 = new PcDetails("Power Supplies","CORSAIR CV SERİSİ CV650 650W 80PLUS BRONZE ");
                            pcDetailsArrayList.add(pcDetails818);

                            PcDetails pcDetails819 = new PcDetails("Power Supplies","COOLER MASTER MWE 80PLUS BRONZE 750W 2xEPS,AKTİF PFC");
                            pcDetailsArrayList.add(pcDetails819);

                            PcDetails pcDetails901 = new PcDetails("Power Supplies","CORSAIR CV SERİSİ CV550 550W 80PLUS BRONZE ");
                            pcDetailsArrayList.add(pcDetails901);

                            PcDetails pcDetails911 = new PcDetails("Power Supplies","CORSAIR RM SERİSİ 650W 80PLUS GOLD MODULER");
                            pcDetailsArrayList.add(pcDetails911);

                            PcDetails pcDetails912 = new PcDetails("Power Supplies","THERMALTAKE TOUGHPOWER PF1 ARGB 80PLUS PLATINUM 1200W");
                            pcDetailsArrayList.add(pcDetails912);

                            PcDetails pcDetails913 = new PcDetails("Power Supplies","COUGAR BXM-850 850W 80 PLUS BRONZE ");
                            pcDetailsArrayList.add(pcDetails913);

                            PcDetails pcDetails914 = new PcDetails("Power Supplies","COUGAR BXM-700 700W 80 PLUS BRONZE ");
                            pcDetailsArrayList.add(pcDetails914);

                            PcDetails pcDetails915 = new PcDetails("Power Supplies","COUGAR XTC 500 500W 80 PLUS ");
                            pcDetailsArrayList.add(pcDetails915);

                            PcDetails pcDetails7118 = new PcDetails("Power Supplies","FRISBY FR-PS6580P-RGB 80 PLUS 650W");
                            pcDetailsArrayList.add(pcDetails7118);

                            PcDetails pcDetails7119 = new PcDetails("Power Supplies","FRISBY FR-PS6080P 80 PLUS BRONZE 600W ");
                            pcDetailsArrayList.add(pcDetails7119);

                            PcDetails pcDetails870 = new PcDetails("Power Supplies","ASUS ROG STRIX 750W 80 PLUS GOLD ");
                            pcDetailsArrayList.add(pcDetails870);  
                                                                   
                            PcDetails pcDetails871 = new PcDetails("Power Supplies","ASUS ROG STRIX 650W 80 PLUS GOLD ");
                            pcDetailsArrayList.add(pcDetails871);

                            PcDetails pcDetails872 = new PcDetails("Power Supplies","ASUS ROG STRIX 550W 80 PLUS GOLD");
                            pcDetailsArrayList.add(pcDetails872);

                            PcDetails pcDetails873 = new PcDetails("Power Supplies","THERMALTAKE TR2 S 750W 80 PLUS 120mm ");
                            pcDetailsArrayList.add(pcDetails873);

                            PcDetails pcDetails874 = new PcDetails("Power Supplies","THERMALTAKE TR2 S 650W 80 PLUS 120mm ");
                            pcDetailsArrayList.add(pcDetails874);

                            PcDetails pcDetails875 = new PcDetails("Power Supplies","THERMALTAKE TR2 S 550W 80 PLUS 120mm ");
                            pcDetailsArrayList.add(pcDetails875);

                            PcDetails pcDetails876 = new PcDetails("Power Supplies","FRISBY FR-PS6580P 650W 80 PLUS 120mm");
                            pcDetailsArrayList.add(pcDetails876);

                            PcDetails pcDetails877 = new PcDetails("Power Supplies","COUGAR CGR-GS-750 GX-S 750W 80PLUS GOLD ");
                            pcDetailsArrayList.add(pcDetails877);

                            PcDetails pcDetails878 = new PcDetails("Power Supplies","COUGAR CGR-BX-700 CMX 700W 80PLUS BRONZE ");
                            pcDetailsArrayList.add(pcDetails878);

                            PcDetails pcDetails879 = new PcDetails("Power Supplies","THERMALTAKE TOUGHPOWER PF1 ARGB 80PLUS PLATINUM 1050W");
                            pcDetailsArrayList.add(pcDetails879);

                            PcDetails pcDetails970 = new PcDetails("Power Supplies","THERMALTAKE TOUGHPOWER GF1 80 PLUS 850W GOLD FULL");
                            pcDetailsArrayList.add(pcDetails970);

                            PcDetails pcDetails971 = new PcDetails("Power Supplies","THERMALTAKE SMART RGB BX1 80PLUS BRONZE 750W ");
                            pcDetailsArrayList.add(pcDetails971);

                            PcDetails pcDetails972 = new PcDetails("Power Supplies","COOLER MASTER MWE 80PLUS 600W 2xEPS, AKTİF PFC 120MM");
                            pcDetailsArrayList.add(pcDetails972);

                            PcDetails pcDetails973 = new PcDetails("Power Supplies","XIGMATEK MINOTAUR FULL RANGE 80PLUS GOLD 650W FULL");
                            pcDetailsArrayList.add(pcDetails973);

                            PcDetails pcDetails974 = new PcDetails("Power Supplies","COUGAR CGR-STX-700 700W 80 PLUS ");
                            pcDetailsArrayList.add(pcDetails974);

                            PcDetails pcDetails975 = new PcDetails("Power Supplies","XIGMATEK X-POWER 650W 80PLUS");
                            pcDetailsArrayList.add(pcDetails975);

                            PcDetails pcDetails931 = new PcDetails("Power Supplies","THERMALTAKE LITEPOWER RGB 550W APFC 12cm");
                            pcDetailsArrayList.add(pcDetails931);

                            PcDetails pcDetails932 = new PcDetails("Power Supplies","XIGMATEK X-POWER SERİSİ 600W 80PLUS ");
                            pcDetailsArrayList.add(pcDetails932);

                            PcDetails pcDetails933 = new PcDetails("Power Supplies","XIGMATEK X-POWER SERİSİ 500W 80PLUS ");
                            pcDetailsArrayList.add(pcDetails933);

                            PcDetails pcDetails9332 = new PcDetails("Power Supplies","THERMALTAKE SMART RGB 80 PLUS 700W ");
                            pcDetailsArrayList.add(pcDetails9332);
                                                                    
                            PcDetails pcDetails9333 = new PcDetails("Power Supplies","THERMALTAKE SMART RGB 80PLUS 600W ");
                            pcDetailsArrayList.add(pcDetails9333);

                            PcDetails pcDetails9334 = new PcDetails("Power Supplies","THERMALTAKE SMART RGB 80PLUS 500W ");
                            pcDetailsArrayList.add(pcDetails9334);

                            PcDetails pcDetails9335 = new PcDetails("Power Supplies","RAMPAGE RMP-750-80PB 750W 80 PLUS BRONZE 140MM");
                            pcDetailsArrayList.add(pcDetails9335);

                            PcDetails pcDetails933445 = new PcDetails("Power Supplies","RAMPAGE RMP-700-80P 700W 80PLUS 120MM");
                            pcDetailsArrayList.add(pcDetails933445);

                            PcDetails pcDetails93356 = new PcDetails("Power Supplies","RAMPAGE RMP-650-80PB 650W 80PLUS BRONZE 140MM ");
                            pcDetailsArrayList.add(pcDetails93356);

                            PcDetails pcDetails97077 = new PcDetails("Power Supplies","THERMALTAKE TOUGHPOWER GF1 80 PLUS 850W GOLD FULL");
                            pcDetailsArrayList.add(pcDetails97077);

                            PcDetails pcDetails97181 = new PcDetails("Power Supplies","RAMPAGE RMP-750-80PB 750W 80 PLUS BRONZE 140MM");
                            pcDetailsArrayList.add(pcDetails97181);

                            PcDetails pcDetails97282 = new PcDetails("Power Supplies","RAMPAGE RMP-700-80P 700W 80PLUS 120MM  ");
                            pcDetailsArrayList.add(pcDetails97282);

                            PcDetails pcDetails97383 = new PcDetails("Power Supplies","RAMPAGE RMP-650-80PB 650W 80PLUS BRONZE 140MM");
                            pcDetailsArrayList.add(pcDetails97383);

                            PcDetails pcDetails97484 = new PcDetails("Power Supplies","RAMPAGE RMP-600-80P 600W 80PLUS 120MM ");
                            pcDetailsArrayList.add(pcDetails97484);

                            PcDetails pcDetails97585 = new PcDetails("Power Supplies","XIGMATEK X MINER 1800W 80 PLUS GOLD ");
                            pcDetailsArrayList.add(pcDetails97585);

                            PcDetails pcDetails93186 = new PcDetails("Power Supplies","RAMPAGE RGB-550 80PLUS GOLD 550W FULL MODÜLER RGB ");
                            pcDetailsArrayList.add(pcDetails93186);

                            PcDetails pcDetails93287 = new PcDetails("Power Supplies","COOLER MASTER WATT 80PLUS 600W AKTİF PFC 120MM ");
                            pcDetailsArrayList.add(pcDetails93287);

                            PcDetails pcDetails93388 = new PcDetails("Power Supplies","THERMALTAKE LITEPOWER 550W ");
                            pcDetailsArrayList.add(pcDetails93388);

                            PcDetails pcDetails933289 = new PcDetails("Power Supplies","EVEREST BTX-600 600W 80PLUS BRONZE ");
                            pcDetailsArrayList.add(pcDetails933289);

                            PcDetails pcDetails933390 = new PcDetails("Power Supplies","EVEREST ETX-750 750W 80PLUS GOLD");
                            pcDetailsArrayList.add(pcDetails933390);

                            PcDetails pcDetails933491 = new PcDetails("Power Supplies","EVEREST EPS-4900B 350W");
                            pcDetailsArrayList.add(pcDetails933491);




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
                            searchView = view.findViewById(R.id.searchView_GücKaynaklari);
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
                            searchView = view.findViewById(R.id.searchView_GücKaynaklari);
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