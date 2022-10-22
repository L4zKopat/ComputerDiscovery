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


public class KasalarFragment extends Fragment {


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
        return inflater.inflate(R.layout.fragment_kasalar, container, false);


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        pcDetailsArrayList = new ArrayList<>();
        recyclerView = view.findViewById(R.id.recyclerViewKasalar);

        toolbar = view.findViewById(R.id.toolbar_Kasalar);
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


                            PcDetails pcDetails616161 = new PcDetails("Kasalar","POWERBOOST VK-P1900B 500W USB 3.0 MESH FIXED 4x120mm");
                            pcDetailsArrayList.add(pcDetails616161);

                            PcDetails pcDetails2 = new PcDetails("Kasalar","POWERBOOST VK-P15B 600W 80 PLUS USB 3.0 MESH 4x120mm");
                            pcDetailsArrayList.add(pcDetails2);

                            PcDetails pcDetails3 = new PcDetails("Kasalar","COOLER MASTER MASTERBOX TD500 650W 80PLUS BRONZE");
                            pcDetailsArrayList.add(pcDetails3);

                            PcDetails pcDetails4 = new PcDetails("Kasalar","MSI MAG FORGE 100M TEMPERED GLASS 2x120mm RGB MidT");
                            pcDetailsArrayList.add(pcDetails4);

                            PcDetails pcDetails5 = new PcDetails("Kasalar","COOLER MASTER MASTERBOX TD500 MESH 4x120mm ARGB ");
                            pcDetailsArrayList.add(pcDetails5);

                            PcDetails pcDetails6 = new PcDetails("Kasalar","RAMPAGE REACTION 4x120mm Rainbow  600W 80PLUS");
                            pcDetailsArrayList.add(pcDetails6);

                            PcDetails pcDetails7 = new PcDetails("Kasalar","POWERBOOST VK-P06B 550W USB 3.0 DOUBLE RING MESH 4x120mm");
                            pcDetailsArrayList.add(pcDetails7);

                            PcDetails pcDetails8 = new PcDetails("Kasalar","POWERBOOST VK-P06B 550W USB 3.0 DOUBLE RING MESH 4x120mm");
                            pcDetailsArrayList.add(pcDetails8);

                            PcDetails pcDetails9 = new PcDetails("Kasalar","COOLER MASTER MASTERBOX TD500 MESH 4x120mm ARGB ");
                            pcDetailsArrayList.add(pcDetails9);

                            PcDetails pcDetails10 = new PcDetails("Kasalar","COOLER MASTER MASTEBOX TD500 750W 80PLUS BRONZE");
                            pcDetailsArrayList.add(pcDetails10);

                            PcDetails pcDetails11 = new PcDetails("Kasalar","COOLER MASTER MASTERBOX K501L V4 600W 80PLUS MESH ");
                            pcDetailsArrayList.add(pcDetails11);

                            PcDetails pcDetails12 = new PcDetails("Kasalar","COOLER MASTER MASTERBOX MB311L 600W 3x120mm RGB  MINI TOWER");
                            pcDetailsArrayList.add(pcDetails12);

                            PcDetails pcDetails14 = new PcDetails("Kasalar","POWERBOOST VK-M202B USB 3.0 MESH 4x120mm RGB FAN ATX");
                            pcDetailsArrayList.add(pcDetails14);

                            PcDetails pcDetails15 = new PcDetails("Kasalar","CORSAIR İCUE 4000X RGB 750W 80PLUS BRONZE TEMPERED");
                            pcDetailsArrayList.add(pcDetails15);

                            PcDetails pcDetails16 = new PcDetails("Kasalar","FRISBY 4x120mm RGB  650W 80 PLUS MESH ÖN PANEL MidT ATX GAMING ");
                            pcDetailsArrayList.add(pcDetails16);

                            PcDetails pcDetails17 = new PcDetails("Kasalar","CORSAIR 4000D TEMPERED GLASS 2x120mm MidT ");
                            pcDetailsArrayList.add(pcDetails17);

                            PcDetails pcDetails18 = new PcDetails("Kasalar","RAMPAGE SAILOR 4x120mm Rainbow  600W 80Plus");
                            pcDetailsArrayList.add(pcDetails18);

                            PcDetails pcDetails19 = new PcDetails("Kasalar","THERMALTAKE V200TG 600W 80PLUS 3x120mm RGB MidT");
                            pcDetailsArrayList.add(pcDetails19);

                            PcDetails pcDetails20 = new PcDetails("Kasalar","POWERBOOST VK-D501M 650W 80PLUS USB 3.0 MESH 4x120mm");
                            pcDetailsArrayList.add(pcDetails20);

                            PcDetails pcDetails21 = new PcDetails("Kasalar","THERMALTAKE DIVIDER 500 TG 3x120mm ARGB  MidT");
                            pcDetailsArrayList.add(pcDetails21);

                            PcDetails pcDetails22 = new PcDetails("Kasalar","MSI MAG FORGE 100R TEMPERED GLASS 2x120mm ARGB  MidT");
                            pcDetailsArrayList.add(pcDetails22);

                            PcDetails pcDetails23 = new PcDetails("Kasalar","RAMPAGE FUSION 4x120mm RAINBOW USB3.0 MidT ATX");
                            pcDetailsArrayList.add(pcDetails23);

                            PcDetails pcDetails24 = new PcDetails("Kasalar","XIGMATEK DIAMOND 600W 80 PLUS POWER 4X120mm RAINBOW");
                            pcDetailsArrayList.add(pcDetails24);

                            PcDetails pcDetails25 = new PcDetails("Kasalar","THERMALTAKE COMMANDER G33 TG 750W 80PLUS 2x200mm ARGB");
                            pcDetailsArrayList.add(pcDetails25);

                            PcDetails pcDetails26 = new PcDetails("Kasalar","COUGAR PANZER EVO RGB GAMING USB3.0 FullT ATX ");
                            pcDetailsArrayList.add(pcDetails26);

                            PcDetails pcDetails27 = new PcDetails("Kasalar","COUGAR PURITAS GAMING USB3.0 MidT ATX ");
                            pcDetailsArrayList.add(pcDetails27);

                            PcDetails pcDetails28 = new PcDetails("Kasalar","THERMALTAKE TOWER 500  3X TEMPERED GLASS  GAMING ");
                            pcDetailsArrayList.add(pcDetails28);

                            PcDetails pcDetails29 = new PcDetails("Kasalar","MSI MAG FORGE M100R TEMPERED GLASS ARGB FAN USB");
                            pcDetailsArrayList.add(pcDetails29);

                            PcDetails pcDetails30 = new PcDetails("Kasalar","MSI MAG FORGE M100A  YAN PANEL ARGB FAN USB 3.2");
                            pcDetailsArrayList.add(pcDetails30);

                            PcDetails pcDetails31 = new PcDetails("Kasalar","POWERBOOST VK-P3301B 500W USB 3.0 MESH FIXED 4x120mm");
                            pcDetailsArrayList.add(pcDetails31);

                            PcDetails pcDetails32 = new PcDetails("Kasalar","POWERBOOST VK-C12B USB 3.0 TEMPERED GLASS 4x120mm RGB");
                            pcDetailsArrayList.add(pcDetails32);

                            PcDetails pcDetails33 = new PcDetails("Kasalar","COOLER MASTER HAF 700 EVO 2x120mm-2x200mm ARGB ");
                            pcDetailsArrayList.add(pcDetails33);

                            PcDetails pcDetails34 = new PcDetails("Kasalar","MAG SHIELD 110R USB3.2 MidT ATX");
                            pcDetailsArrayList.add(pcDetails34);

                            PcDetails pcDetails35 = new PcDetails("Kasalar","COOLER MASTER HAF 500 TG MESH ARGB 1x120cm 2x200cm");
                            pcDetailsArrayList.add(pcDetails35);

                            PcDetails pcDetails36 = new PcDetails("Kasalar","THERMALTAKE AH T200 empered Glass MiniT");
                            pcDetailsArrayList.add(pcDetails36);

                            PcDetails pcDetails37 = new PcDetails("Kasalar","MSI MAG FORGE 100 RB65  650W BRONZ");
                            pcDetailsArrayList.add(pcDetails37);

                            PcDetails pcDetails38 = new PcDetails("Kasalar","THERMALTAKE Core P6  3xTempered Glass  MidT");
                            pcDetailsArrayList.add(pcDetails38);

                            PcDetails pcDetails39 = new PcDetails("Kasalar","COOLER MASTER Universal PCI-e 4.0 Riser ");
                            pcDetailsArrayList.add(pcDetails39);

                            PcDetails pcDetails40 = new PcDetails("Kasalar","COOLER MASTER MasterAccessory ARGB Tempered Universal ");
                            pcDetailsArrayList.add(pcDetails40);

                            PcDetails pcDetails41 = new PcDetails("Kasalar","MSI MPG VELOX 100P AIRFLOW 4x120mm  MidT ATX GAMING");
                            pcDetailsArrayList.add(pcDetails41);

                            PcDetails pcDetails42 = new PcDetails("Kasalar","THERMALTAKE PCI-e 4.0 X16 300mm 90°  RISER");
                            pcDetailsArrayList.add(pcDetails42);

                            PcDetails pcDetails43 = new PcDetails("Kasalar","MSI MAG SHIELD M300 USB3.2 MidT ATX");
                            pcDetailsArrayList.add(pcDetails43);

                            PcDetails pcDetails44 = new PcDetails("Kasalar","MSI MAG FORGE 101M TEMPERED GLASS 4x120mm RGB  MidT");
                            pcDetailsArrayList.add(pcDetails44);

                            PcDetails pcDetails45 = new PcDetails("Kasalar","COUGAR MX660 MESH RGB 4x120mm RGB  MESH GEX");
                            pcDetailsArrayList.add(pcDetails45);

                            PcDetails pcDetails46 = new PcDetails("Kasalar","MSI MPG GUNGNIR 110R TEMPERED GLASS 4x120mm ARGB");
                            pcDetailsArrayList.add(pcDetails46);

                            PcDetails pcDetails47 = new PcDetails("Kasalar","COOLER MASTER MASTERCASE H500 MESH 2x200mm +1x120mm");
                            pcDetailsArrayList.add(pcDetails47);

                            PcDetails pcDetails48 = new PcDetails("Kasalar","CORSAIR 5000D TEMPERED GLASS YAN PANEL 2x120mm ");
                            pcDetailsArrayList.add(pcDetails48);

                            PcDetails pcDetails49 = new PcDetails("Kasalar","ZALMAN M3 PLUS 4x120mm RGB  MINI TOWER GAMING ");
                            pcDetailsArrayList.add(pcDetails49);

                            PcDetails pcDetails50 = new PcDetails("Kasalar","ZALMAN S4 PLUS 3x120mm RGB  MEGAMAX 600W 80PLUS MidT ATX GAMING");
                            pcDetailsArrayList.add(pcDetails50);

                            PcDetails pcDetails51 = new PcDetails("Kasalar","THERMALTAKE VIEW 51 TEMPERED GLASS 2x200mm ARGB");
                            pcDetailsArrayList.add(pcDetails51);

                            PcDetails pcDetails52 = new PcDetails("Kasalar","THERMALTAKE VIEW 51 TEMPERED GLASS 2x200mm ARGB");
                            pcDetailsArrayList.add(pcDetails52);

                            PcDetails pcDetails53 = new PcDetails("Kasalar","RAMPAGE HACKER 4x120mm RGB  600W 80PLUS BRONZE MidT");
                            pcDetailsArrayList.add(pcDetails53);

                            PcDetails pcDetails54 = new PcDetails("Kasalar","COUGAR DARK BLADER-G RGB  USB3.0 FullT ATX");
                            pcDetailsArrayList.add(pcDetails54);

                            PcDetails pcDetails55 = new PcDetails("Kasalar","THERMALTAKE VERSA J23 650W 3x120mm RGB ");
                            pcDetailsArrayList.add(pcDetails55);

                            PcDetails pcDetails56 = new PcDetails("Kasalar","EVEREST X-MESH 3x120mm RAINBOW  USB 3.0 Mini Tower");
                            pcDetailsArrayList.add(pcDetails56);

                            PcDetails pcDetails57 = new PcDetails("Kasalar","CORSAIR CARBIDE SPEC-DELTA 550W 80PLUS RGB ");
                            pcDetailsArrayList.add(pcDetails57);

                            PcDetails pcDetails58 = new PcDetails("Kasalar","COUGAR GEMINI S GAMING USB3.0 MidT ");
                            pcDetailsArrayList.add(pcDetails58);

                            PcDetails pcDetails59 = new PcDetails("Kasalar","COUGAR GEMINI T RGB GAMING USB3.0 MidT ATX ");
                            pcDetailsArrayList.add(pcDetails59);

                            PcDetails pcDetails60 = new PcDetails("Kasalar","XIGMATEK ASTRO 650W 80PLUS POWER 4x120mm RGB ");
                            pcDetailsArrayList.add(pcDetails60);

                            PcDetails pcDetails61 = new PcDetails("Kasalar","RAMPAGE THE KING 4x120mm RGB FAN USB 3.0 MidT ATX");
                            pcDetailsArrayList.add(pcDetails61);

                            PcDetails pcDetails62 = new PcDetails("Kasalar","POWER BOOST VK-G3403S 650W 80 PLUS MESH PANEL USB 3.0");
                            pcDetailsArrayList.add(pcDetails62);


                            PcDetails pcDetails64 = new PcDetails("Kasalar","POWER BOOST VK-T01B RGB 650W 80+ Mesh Panel USB 3.0 Mid");
                            pcDetailsArrayList.add(pcDetails64);

                            PcDetails pcDetails65 = new PcDetails("Kasalar","FRISBY FC-9410G WOLF 500W RGB 3X FAN USB 3.0 Mid ATX");
                            pcDetailsArrayList.add(pcDetails65);

                            PcDetails pcDetails66 = new PcDetails("Kasalar","FRISBY FC-9320G MESH 4XRGB 600W USB 3.0 80 PLUS Mid ATX ");
                            pcDetailsArrayList.add(pcDetails66);

                            PcDetails pcDetails67 = new PcDetails("Kasalar","THERMALTAKE CORE P6  3X TEMPERED GLASS ");
                            pcDetailsArrayList.add(pcDetails67);

                            PcDetails pcDetails68 = new PcDetails("Kasalar","THARMALTAKE AH T200  TEMPERED GLASS ");
                            pcDetailsArrayList.add(pcDetails68);

                            PcDetails pcDetails69 = new PcDetails("Kasalar","MSI MAG SHIELD M301 MESH mATX" );
                            pcDetailsArrayList.add(pcDetails69);

                            PcDetails pcDetails70 = new PcDetails("Kasalar","ASUS TUF GAMING GT301 3x120mm ARGB ");
                            pcDetailsArrayList.add(pcDetails70);

                            PcDetails pcDetails71 = new PcDetails("Kasalar","RAMPAGE REDSKY 4x120mm RGB700W 80 Plus Bronze ");
                            pcDetailsArrayList.add(pcDetails71);

                            PcDetails pcDetails72 = new PcDetails("Kasalar","XIGMATEK GAMING M 4*X20C RGB X-Power 500W Mesh Panel Tempered ");
                            pcDetailsArrayList.add(pcDetails72);

                            PcDetails pcDetails73 = new PcDetails("Kasalar","EVEREST BUMPY 4x120mm ARGB GAMING");
                            pcDetailsArrayList.add(pcDetails73);

                            PcDetails pcDetails74 = new PcDetails("Kasalar","EVEREST 2*Sata Mesh 720R Peak-250W  Metal");
                            pcDetailsArrayList.add(pcDetails74);

                            PcDetails pcDetails75 = new PcDetails("Kasalar","MSI MAG FORGE 112R ARGB Tempered ATX Mid Tower");
                            pcDetailsArrayList.add(pcDetails75);

                            PcDetails pcDetails76 = new PcDetails("Kasalar","POWERBOOST X59RGB 650W 80 PLUS USB 3.0 TEMPERED");
                            pcDetailsArrayList.add(pcDetails76);

                            PcDetails pcDetails77 = new PcDetails("Kasalar","POWERBOOST VK-G3701B 550W 80 PLUS USB 3.0 MESH 4x120mm");
                            pcDetailsArrayList.add(pcDetails77);

                            PcDetails pcDetails78 = new PcDetails("Kasalar","MSI MPG GUNGNIR 110R WHITE Tempered Glass RGB USB 3.2 ATX");
                            pcDetailsArrayList.add(pcDetails78);

                            PcDetails pcDetails79 = new PcDetails("Kasalar","MSI MAG FORGE 110R ARGB USB 3.2 ATX Mid Tower ");
                            pcDetailsArrayList.add(pcDetails79);

                            PcDetails pcDetails80 = new PcDetails("Kasalar","MSI MAG FORGE 111R USB 3.2 ARGB Tempered Glass ATX");
                            pcDetailsArrayList.add(pcDetails80);

                            PcDetails pcDetails81 = new PcDetails("Kasalar","COOLER MASTER MASTERBOX MB520 600W 80 PLUS 3x120mm");
                            pcDetailsArrayList.add(pcDetails81);

                            PcDetails pcDetails82 = new PcDetails("Kasalar","MSI MAG SHIELD 110A USB3.2 MidT ATX");
                            pcDetailsArrayList.add(pcDetails82);

                            PcDetails pcDetails83 = new PcDetails("Kasalar","S-LINK SLX-F201 10cm 4 Pin 2'li PWM ");
                            pcDetailsArrayList.add(pcDetails83);

                            PcDetails pcDetails84 = new PcDetails("Kasalar","COOLER MASTER TD300 TG MESH 2x120mm ARGB ");
                            pcDetailsArrayList.add(pcDetails84);

                            PcDetails pcDetails85 = new PcDetails("Kasalar","COOLER MASTER HAF 500 TG MESH ARGB 1x120cm 2x200cm");
                            pcDetailsArrayList.add(pcDetails85);

                            PcDetails pcDetails86 = new PcDetails("Kasalar","THERMALTAKE AH T200 Tempered Glass  Micro ATX");
                            pcDetailsArrayList.add(pcDetails86);

                            PcDetails pcDetails87 = new PcDetails("Kasalar","THERMALTAKE Core P6  3xTempered Glass  MidT");
                            pcDetailsArrayList.add(pcDetails87);

                            PcDetails pcDetails88 = new PcDetails("Kasalar","THERMALTAKE Divider 200 TG Air  1x200mmMesh MiniT");
                            pcDetailsArrayList.add(pcDetails88);

                            PcDetails pcDetails89 = new PcDetails("Kasalar","THERMALTAKE Divider 200 TG Air 1x200mm Mesh MiniT");
                            pcDetailsArrayList.add(pcDetails89);

                            PcDetails pcDetails90 = new PcDetails("Kasalar","THERMALTAKE DIVIDER 500 TG AIR 2x120mm  MESH");
                            pcDetailsArrayList.add(pcDetails90);

                            PcDetails pcDetails91 = new PcDetails("Kasalar","THERMALTAKE DIVIDER 500 TG AIR 2x120mm  MESH");
                            pcDetailsArrayList.add(pcDetails91);

                            PcDetails pcDetails92 = new PcDetails("Kasalar","THERMALTAKE DIVIDER 500 TG 4x120mm ARGB  MidT");
                            pcDetailsArrayList.add(pcDetails92);

                            PcDetails pcDetails93 = new PcDetails("Kasalar","THERMALTAKE DIVIDER 300 TG AIR B2x120mm MESH");
                            pcDetailsArrayList.add(pcDetails93);

                            PcDetails pcDetails94 = new PcDetails("Kasalar","THERMALTAKE DIVIDER 300 TG AIR  2x120mm  MESH");
                            pcDetailsArrayList.add(pcDetails94);

                            PcDetails pcDetails95 = new PcDetails("Kasalar","THERMALTAKE The Tower 100 Racing Green 3xTempered Glass");
                            pcDetailsArrayList.add(pcDetails95);


                            PcDetails pcDetails96 = new PcDetails("Kasalar","THERMALTAKE THE TOWER 100 3xTEMPERED GLASS");
                            pcDetailsArrayList.add(pcDetails96);

                            PcDetails pcDetails97 = new PcDetails("Kasalar","THERMALTAKE The Tower 100  3xTempered Glass");
                            pcDetailsArrayList.add(pcDetails97);

                            PcDetails pcDetails98 = new PcDetails("Kasalar","THERMALTAKE THE TOWER 100  3xTEMPERED GLASS ");
                            pcDetailsArrayList.add(pcDetails98);

                            PcDetails pcDetails99 = new PcDetails("Kasalar","MSI MAG VAMPIRIC 300R PACIFIC BLUE TEMPERED GLASS 1x120mm");
                            pcDetailsArrayList.add(pcDetails99);

                            PcDetails pcDetails100 = new PcDetails("Kasalar","MSI MAG VAMPIRIC 300R MIDNIGHT GREEN TEMPERED");
                            pcDetailsArrayList.add(pcDetails100);

                            PcDetails pcDetails101 = new PcDetails("Kasalar","MSI MAG VAMPIRIC 100L TEMPERED GLASS MidT ARGB ATX");
                            pcDetailsArrayList.add(pcDetails101);

                            PcDetails pcDetails102 = new PcDetails("Kasalar","COOLER MASTER MASTERBOX NR200P TEMPERED GLASS Mini");
                            pcDetailsArrayList.add(pcDetails102);

                            PcDetails pcDetails103 = new PcDetails("Kasalar","COOLER MASTER MASTERBOX NR200P TEMPERED GLASS Mini-");
                            pcDetailsArrayList.add(pcDetails103);

                            PcDetails pcDetails104 = new PcDetails("Kasalar","COOLER MASTER MASTERBOX NR200P TEMPERED GLASS Mini-");
                            pcDetailsArrayList.add(pcDetails104);

                            PcDetails pcDetails105 = new PcDetails("Kasalar","MSI MPG VELOX 100R 4x120mm ARGB  MidT ATX GAMING");
                            pcDetailsArrayList.add(pcDetails105);


                            PcDetails pcDetails107 = new PcDetails("Kasalar","MSI MPG VELOX 100R 4x120mm ARGB MidT ATX GAMING");
                            pcDetailsArrayList.add(pcDetails107);

                            PcDetails pcDetails108 = new PcDetails("Kasalar","MSI MPG QUIETUDE 100S 1x120mm  MidT ATX GAMING");
                            pcDetailsArrayList.add(pcDetails108);

                            PcDetails pcDetails109 = new PcDetails("Kasalar","MSI MAG VAMPIRIC 300R TEMPERED GLASS 1x120mm ARGB");
                            pcDetailsArrayList.add(pcDetails109);

                            PcDetails pcDetails110 = new PcDetails("Kasalar","MSI MPG GUNGNIR 111R TEMPERED GLASS 4x120mm ARGB");
                            pcDetailsArrayList.add(pcDetails110);

                            PcDetails pcDetails111 = new PcDetails("Kasalar","COUGAR GEMINI T PRO ARGB  MidT ATX GAMING");
                            pcDetailsArrayList.add(pcDetails111);

                            PcDetails pcDetails112 = new PcDetails("Kasalar","COUGAR GEMINI S SILVER XTC 600W 80 PLUS MidT ATX GAMING");
                            pcDetailsArrayList.add(pcDetails112);

                            PcDetails pcDetails113 = new PcDetails("Kasalar","COUGAR QBX USB3.0 Mini-ITX");
                            pcDetailsArrayList.add(pcDetails113);


                            PcDetails pcDetails1143 = new PcDetails("Kasalar","COUGAR BLAZER ESSENCE TEMPER  MidT ATX GAMIN");
                            pcDetailsArrayList.add(pcDetails1143);

                            PcDetails pcDetails114 = new PcDetails("Kasalar","MSI MPG SEKIRA 500G TEMPERED GLASS 3x200mm MidT ATX ");
                            pcDetailsArrayList.add(pcDetails114);

                            PcDetails pcDetails115 = new PcDetails("Kasalar","COOLER MASTER MASTERBOX TD500 650W 80PLUS BRONZE");
                            pcDetailsArrayList.add(pcDetails115);

                            PcDetails pcDetails116 = new PcDetails("Kasalar","COUGAR MX440 MESH RGB 4x120mm RGB VTE X2 750W");
                            pcDetailsArrayList.add(pcDetails116);

                            PcDetails pcDetails117 = new PcDetails("Kasalar","ZALMAN N5 MF (SE) 4x120mm RGB  MegaMax 600W 80PLUS MidT");
                            pcDetailsArrayList.add(pcDetails117);

                            PcDetails pcDetails118 = new PcDetails("Kasalar","COUGAR PANZER 1x120mm  MidT ATX USB3.0 GAMING");
                            pcDetailsArrayList.add(pcDetails118);

                            PcDetails pcDetails119 = new PcDetails("Kasalar","COUGAR DARK BLADER X7 1x120mm ARGB GAMING");
                            pcDetailsArrayList.add(pcDetails119);

                            PcDetails pcDetails200 = new PcDetails("Kasalar","COUGAR DARK BLADER X5-RGB 3x120mm ARGB GAMING");
                            pcDetailsArrayList.add(pcDetails200);

                            PcDetails pcDetails201 = new PcDetails("Kasalar","XIGMATEK MASTER X 4x120mm ARGBX-Power 650W TEMPER MESH ");
                            pcDetailsArrayList.add(pcDetails201);

                            PcDetails pcDetails202 = new PcDetails("Kasalar","XIGMATEK X7 7x120mm ARGB TEMPERED  GAMING");
                            pcDetailsArrayList.add(pcDetails202);

                            PcDetails pcDetails203 = new PcDetails("Kasalar","XIGMATEK GAMING X 4x120mm RGB  X-Power 500W TEMPER");
                            pcDetailsArrayList.add(pcDetails203);

                            PcDetails pcDetails204 = new PcDetails("Kasalar","MSI MPG GUNGNIR 100P TEMPERED GLASS 1x120mm ");
                            pcDetailsArrayList.add(pcDetails204);

                            PcDetails pcDetails205 = new PcDetails("Kasalar","CORSAIR 470T RGB  CAM YAN PANEL MidT ATX ");
                            pcDetailsArrayList.add(pcDetails205);

                            PcDetails pcDetails206 = new PcDetails("Kasalar","RAMPAGE DEEPFORCE 4x120mm RGB 600W 80PLUS BRONZE");
                            pcDetailsArrayList.add(pcDetails206);

                            PcDetails pcDetails207 = new PcDetails("Kasalar","MSI MPG SEKIRA 500X TEMPERED GLASS 3x200mm ARGB  MidT");
                            pcDetailsArrayList.add(pcDetails207);

                            PcDetails pcDetails208 = new PcDetails("Kasalar","THERMALTAKE H330 650W x120mm I TEMPERED");
                            pcDetailsArrayList.add(pcDetails208);

                            PcDetails pcDetails209 = new PcDetails("Kasalar","THERMALTAKE VERSA T25 550W 80+ TEMPERED GLASS RGB");
                            pcDetailsArrayList.add(pcDetails209);

                            PcDetails pcDetails210 = new PcDetails("Kasalar","ASUS TUF GAMING GT501 WHITE EDITION 3x120mm RGB  MidT ATX ");
                            pcDetailsArrayList.add(pcDetails210);

                            PcDetails pcDetails211 = new PcDetails("Kasalar","FRISBY 4x120mm RAINBOW  600W 80PLUS BRONZE USB3.0");
                            pcDetailsArrayList.add(pcDetails211);

                            PcDetails pcDetails212 = new PcDetails("Kasalar","EVEREST SPECTRUM 4x120mm  500W MidT ATX GAMING");
                            pcDetailsArrayList.add(pcDetails212);

                            PcDetails pcDetails213 = new PcDetails("Kasalar","RAMPAGE PHANTOM X2 600W 80PLUS BRONZE 1x120mm RGB");
                            pcDetailsArrayList.add(pcDetails213);

                            PcDetails pcDetails224 = new PcDetails("Kasalar","RAMPAGE PHANTOM X1 600W 80PLUS BRONZE 1x120mm RGB");
                            pcDetailsArrayList.add(pcDetails224);

                            PcDetails pcDetails234 = new PcDetails("Kasalar","CORSAIR CARBIDE  SPEC-05 650W 80PLUS BRONZE MidT");
                            pcDetailsArrayList.add(pcDetails234);

                            PcDetails pcDetails244 = new PcDetails("Kasalar","CORSAIR CARBIDE  SPEC-05 550W 80PLUS BRONZE MidT");
                            pcDetailsArrayList.add(pcDetails244);

                            PcDetails pcDetails255 = new PcDetails("Kasalar","COUGAR MX410 MESH-G RGB 4x120mm ARGB  650W 80 PLUS USB3.0 GAMING ");
                            pcDetailsArrayList.add(pcDetails255);

                            PcDetails pcDetails266 = new PcDetails("Kasalar","ASUS ROG Z11 3x120mm  USB3.2 MINI TOWER ");
                            pcDetailsArrayList.add(pcDetails266);

                            PcDetails pcDetails277 = new PcDetails("Kasalar","MSI MPG SEKIRA 100R TEMPERED GLASS 4x120mm ARGB MidT");
                            pcDetailsArrayList.add(pcDetails277);

                            PcDetails pcDetails288 = new PcDetails("Kasalar","MSI MPG GUNGNIR 110M TEMPERED GLASS 3x120mm RGB");
                            pcDetailsArrayList.add(pcDetails288);

                            PcDetails pcDetails299 = new PcDetails("Kasalar","MSI MPG GUNGNIR 100D TEMPERED GLASS 2x120mm ");
                            pcDetailsArrayList.add(pcDetails299);

                            PcDetails pcDetails300 = new PcDetails("Kasalar","MSI MPG GUNGNIR 100 TEMPERED GLASS 1x120mm ARGB");
                            pcDetailsArrayList.add(pcDetails300);

                            PcDetails pcDetails320 = new PcDetails("Kasalar","MSI MAG VAMPIRIC 100R TEMPERED GALSS 1x120mm ARGB");
                            pcDetailsArrayList.add(pcDetails320);

                            PcDetails pcDetails333 = new PcDetails("Kasalar","MSI MAG VAMPIRIC 011C TEMPERED GLASS 1x120mm ARGB");
                            pcDetailsArrayList.add(pcDetails333);

                            PcDetails pcDetails344 = new PcDetails("Kasalar","MSI MAG VAMPIRIC 010X TEMPERED GLASS 1x120mm RGB");
                            pcDetailsArrayList.add(pcDetails344);

                            PcDetails pcDetails355 = new PcDetails("Kasalar","CORSAIR 5000D TEMPERED GLASS 2x120mm FANLI MidT");
                            pcDetailsArrayList.add(pcDetails355);

                            PcDetails pcDetails366 = new PcDetails("Kasalar","FRISBY 4x120mm RGB  650W 80 PLUS USB3.0 MidT ATX GAMING");
                            pcDetailsArrayList.add(pcDetails366);

                            PcDetails pcDetails377= new PcDetails("Kasalar","FRISBY 4x120mm RGB 600W 80 PLUS USB3.0 MidT ATX GAMING");
                            pcDetailsArrayList.add(pcDetails377);

                            PcDetails pcDetails381 = new PcDetails("Kasalar","FRISBY 4x120mm RGB 650W 80 PLUS USB3.0 MidT ATX GAMING");
                            pcDetailsArrayList.add(pcDetails381);

                            PcDetails pcDetails391 = new PcDetails("Kasalar","XIGMATEK CYCLOPS M 4x120mm RGB  X-POWER 650W");
                            pcDetailsArrayList.add(pcDetails391);

                            PcDetails pcDetails401 = new PcDetails("Kasalar","XIGMATEK TRIDENT PLUS 4x120mm RGB  X-POWER");
                            pcDetailsArrayList.add(pcDetails401);

                            PcDetails pcDetails412 = new PcDetails("Kasalar","COOLER MASTER MASTERCASE H500 750W 80PLUS BRONZE ARGB");
                            pcDetailsArrayList.add(pcDetails412);

                            PcDetails pcDetails421 = new PcDetails("Kasalar","XIGMATEK VERA M 2x200mm ARGB FANLI MESH PANEL SUPER");
                            pcDetailsArrayList.add(pcDetails421);

                            PcDetails pcDetails433 = new PcDetails("Kasalar","XIGMATEK VERA 2x200mm ARGB FANLI CAM PANEL SUPER TOWER");
                            pcDetailsArrayList.add(pcDetails433);

                            PcDetails pcDetails444 = new PcDetails("Kasalar","RAMPAGE HECTORA GLASS 4x140mm ARGB  700W");
                            pcDetailsArrayList.add(pcDetails444);

                            PcDetails pcDetails456 = new PcDetails("Kasalar","RAMPAGE AMAZE 4x120mm RGB  700W 80PLUS BRONZE MidT");
                            pcDetailsArrayList.add(pcDetails456);

                            PcDetails pcDetails467 = new PcDetails("Kasalar","RAMPAGE HECTORA XL 4x140mm ARGB  700W 80PLUS");
                            pcDetailsArrayList.add(pcDetails467);

                            PcDetails pcDetails477 = new PcDetails("Kasalar","THERMALTAKE VERSA T25 650W 80PLUS ARGB 3x120mm MidT");
                            pcDetailsArrayList.add(pcDetails477);

                            PcDetails pcDetails488 = new PcDetails("Kasalar","THERMALTAKE H330 650W ARGB 3x120mm  TEMPERED GLASS");
                            pcDetailsArrayList.add(pcDetails488);

                            PcDetails pcDetails499 = new PcDetails("Kasalar","RAMPAGE PLATINO 4x120mm RAINBOW  600W 80PLUS");
                            pcDetailsArrayList.add(pcDetails499);

                            PcDetails pcDetails501 = new PcDetails("Kasalar","RAMPAGE ESPECTRO 4x120mm RAINBOW 600W 80PLUS");
                            pcDetailsArrayList.add(pcDetails501);

                            PcDetails pcDetails511 = new PcDetails("Kasalar","RAMPAGE GALAXY 4x120mm RGB 600W 80PLUS BRONZE MidT");
                            pcDetailsArrayList.add(pcDetails511);

                            PcDetails pcDetails512 = new PcDetails("Kasalar","RAMPAGE X-HORSE 650W 80 PLUS BRONZE 4x120mm RAINBOW");
                            pcDetailsArrayList.add(pcDetails512);

                            PcDetails pcDetails513 = new PcDetails("Kasalar","COOLER MASTER MASTERBOX MB520 4x120mm");
                            pcDetailsArrayList.add(pcDetails513);

                            PcDetails pcDetails514 = new PcDetails("Kasalar","CORSAIR İCUE 4000X RGB TEMPERED GLASS 3x120mm ");
                            pcDetailsArrayList.add(pcDetails514);

                            PcDetails pcDetails515 = new PcDetails("Kasalar","CORSAIR 4000D TEMPERED GLASS 2x120mm FMidT");
                            pcDetailsArrayList.add(pcDetails515);

                            PcDetails pcDetails516 = new PcDetails("Kasalar","COOLER MASTER MASTERBOX MB511 650W 80PLUS BRONZE");
                            pcDetailsArrayList.add(pcDetails516);

                            PcDetails pcDetails517 = new PcDetails("Kasalar","XIGMATEK ZEUS SPECTRUM EDITION 5x120mm RGB ");
                            pcDetailsArrayList.add(pcDetails517);

                            PcDetails pcDetails518 = new PcDetails("Kasalar","XIGMATEK PERSEUS 5x120mm RGB  USB3.0");
                            pcDetailsArrayList.add(pcDetails518);

                            PcDetails pcDetails519 = new PcDetails("Kasalar","RAMPAGE CARISMA MESH 4x120mm RAINBOW  650W");
                            pcDetailsArrayList.add(pcDetails519);

                            PcDetails pcDetails610 = new PcDetails("Kasalar","RAMPAGE VICTORY 1x12mm 600W 80 PLUS BRONZE MidT ATX");
                            pcDetailsArrayList.add(pcDetails610);

                            PcDetails pcDetails611 = new PcDetails("Kasalar","XIGMATEK GRIP 4x120mm RAINBOW  X-POWER 600W");
                            pcDetailsArrayList.add(pcDetails611);

                            PcDetails pcDetails621 = new PcDetails("Kasalar","THERMALTAKE AH T600 2 x Tempered Glass ARGB ");
                            pcDetailsArrayList.add(pcDetails621);

                            PcDetails pcDetails631 = new PcDetails("Kasalar","ASUS TUF GAMING GT301 3x120mm ARGB");
                            pcDetailsArrayList.add(pcDetails631);

                            PcDetails pcDetails642 = new PcDetails("Kasalar","RAMPAGE SHAKE 4x120mm RGB  600W 80Plus BRONZE MidT");
                            pcDetailsArrayList.add(pcDetails642);

                            PcDetails pcDetails652 = new PcDetails("Kasalar","RAMPAGE TRAPPER 3x140mm ARGB  650W 80PLUS");
                            pcDetailsArrayList.add(pcDetails652);

                            PcDetails pcDetails662 = new PcDetails("Kasalar","FRISBY FC-9325G INFINITY 4x120mm RGB 650W 80PLUS");
                            pcDetailsArrayList.add(pcDetails662);

                            PcDetails pcDetails671 = new PcDetails("Kasalar","XIGMATEK SIROCON III X-POWER 600W 80 PLUS RAINBOW");
                            pcDetailsArrayList.add(pcDetails671);

                            PcDetails pcDetails681 = new PcDetails("Kasalar","RAMPAGE IMPOSING PRO 2x200mm ARGB 700W");
                            pcDetailsArrayList.add(pcDetails681);

                            PcDetails pcDetails691 = new PcDetails("Kasalar","FRISBY 4x120mm DUAL RING RGB 600W 80 PLUS BRONZE MidT");
                            pcDetailsArrayList.add(pcDetails691);

                            PcDetails pcDetails710 = new PcDetails("Kasalar","FRISBY 4x120mm DUAL RING  600W 80 PLUS BRONZE MidT");
                            pcDetailsArrayList.add(pcDetails710);

                            PcDetails pcDetails711 = new PcDetails("Kasalar","CORSAIR iCUE 220T 3x120mm RGB  TEMPER  MidT ATX");
                            pcDetailsArrayList.add(pcDetails711);

                            PcDetails pcDetails721 = new PcDetails("Kasalar","CORSAIR iCUE 220T 3x120mm RGB  MidT ATX");
                            pcDetailsArrayList.add(pcDetails721);

                            PcDetails pcDetails713 = new PcDetails("Kasalar","COUGAR BLAZER TEMPER USB3.0 MidT ATX GAMING ");
                            pcDetailsArrayList.add(pcDetails713);

                            PcDetails pcDetails714 = new PcDetails("Kasalar","COUGAR GEMINI S IRON GRAY XTC 600W 80 PLUS USB3.0 MidT");
                            pcDetailsArrayList.add(pcDetails714);

                            PcDetails pcDetails715 = new PcDetails("Kasalar","COUGAR DARK BLADER-S RGB USB3.0 FullT ATX GAMING ");
                            pcDetailsArrayList.add(pcDetails715);

                            PcDetails pcDetails716 = new PcDetails("Kasalar","ASUS ROG STRIX GX601 HELIOS 4x140mm  USB3.1 MidT ATX");
                            pcDetailsArrayList.add(pcDetails716);

                            PcDetails pcDetails717 = new PcDetails("Kasalar","ASUS TUF GAMING GT501 3x120mm RGB ");
                            pcDetailsArrayList.add(pcDetails717);

                            PcDetails pcDetails718 = new PcDetails("Kasalar","XIGMATEK LAMIYA 4x120mm X-POWER 650W 80PLUS MidT ATX");
                            pcDetailsArrayList.add(pcDetails718);

                            PcDetails pcDetails719 = new PcDetails("Kasalar","XIGMATEK COCKPIT MESH PANEL 4x120mm X-POWER 700W");
                            pcDetailsArrayList.add(pcDetails719);

                            PcDetails pcDetails810 = new PcDetails("Kasalar","XIGMATEK CYCLOPS 4x120mm FAN X-POWER 650W 80PLUS MidT");
                            pcDetailsArrayList.add(pcDetails810);

                            PcDetails pcDetails811 = new PcDetails("Kasalar","XIGMATEK CYCLOPS BLACK 4x120mm FAN X-POWER 650W");
                            pcDetailsArrayList.add(pcDetails811);

                            PcDetails pcDetails821 = new PcDetails("Kasalar","COUGAR DARK BLADER-S RGB LEDLİ PANEL USB3.0 FullT ATX");
                            pcDetailsArrayList.add(pcDetails821);

                            PcDetails pcDetails813 = new PcDetails("Kasalar","ASUS ROG STRIX GX601 HELIOS 4x140mm FANLI USB3.1 MidT ATX");
                            pcDetailsArrayList.add(pcDetails813);

                            PcDetails pcDetails814 = new PcDetails("Kasalar","ASUS TUF GAMING GT501 3x120mm RGB");
                            pcDetailsArrayList.add(pcDetails814);

                            PcDetails pcDetails815 = new PcDetails("Kasalar","XIGMATEK LAMIYA 4x120mm X-POWER 650W 80PLUS MidT ATX");
                            pcDetailsArrayList.add(pcDetails815);

                            PcDetails pcDetails816 = new PcDetails("Kasalar","XIGMATEK COCKPIT MESH PANEL 4x120mm  X-POWER 700W 80PLUS MidT ATX ");
                            pcDetailsArrayList.add(pcDetails816);

                            PcDetails pcDetails817 = new PcDetails("Kasalar","XIGMATEK CYCLOPS 4x120mm FAN X-POWER 650W 80PLUS MidT ATX ");
                            pcDetailsArrayList.add(pcDetails817);

                            PcDetails pcDetails818 = new PcDetails("Kasalar","XIGMATEK CYCLOPS BLACK 4x120mm FAN X-POWER 650W");
                            pcDetailsArrayList.add(pcDetails818);

                            PcDetails pcDetails819 = new PcDetails("Kasalar","XIGMATEK HELIOS RAINBOW LEUSB 3.0 MidT ATX GAMING");
                            pcDetailsArrayList.add(pcDetails819);

                            PcDetails pcDetails901 = new PcDetails("Kasalar","FRISBY FC-8940G 650W 80 PLUS 2x200mm+1x120mm RGB ");
                            pcDetailsArrayList.add(pcDetails901);

                            PcDetails pcDetails911 = new PcDetails("Kasalar","FRISBY FC-8935G 650W 80 PLUS 4x120mm RAINBOW  MidT");
                            pcDetailsArrayList.add(pcDetails911);

                            PcDetails pcDetails912 = new PcDetails("Kasalar","FRISBY FC-8930G 650W 80 PLUS 3x120mm RAINBOW MESH");
                            pcDetailsArrayList.add(pcDetails912);

                            PcDetails pcDetails913 = new PcDetails("Kasalar","XIGMATEK AQUARIUS PLUS 7x120mm  USB3.0 TEMPER");
                            pcDetailsArrayList.add(pcDetails913);

                            PcDetails pcDetails914 = new PcDetails("Kasalar","COUGAR PURITAS RGB 3x120mm RGB USB3.0 MidT ATX");
                            pcDetailsArrayList.add(pcDetails914);

                            PcDetails pcDetails915 = new PcDetails("Kasalar","CORSAIR CARBIDE SERİSİ SPEC-05 550W 80PLUS MidT ATX ");
                            pcDetailsArrayList.add(pcDetails915);

                            PcDetails pcDetails7118 = new PcDetails("Kasalar","THERMALTAKE VERSA J25 650W 80PLUS RGB 3x120mm  MidT");
                            pcDetailsArrayList.add(pcDetails7118);

                            PcDetails pcDetails7119 = new PcDetails("Kasalar","THERMALTAKE VERSA J24 650W 80PLUS RGB 3x120mm  MidT");
                            pcDetailsArrayList.add(pcDetails7119);

                            PcDetails pcDetails870 = new PcDetails("Kasalar","XIGMATEK BEAST 4 x RGB  X-POWER 650W 80PLUS USB 3.0");
                            pcDetailsArrayList.add(pcDetails870);

                            PcDetails pcDetails871 = new PcDetails("Kasalar","COOLER MASTER MASTERBOX MB520 650W 80PLUS 3x120mm");
                            pcDetailsArrayList.add(pcDetails871);

                            PcDetails pcDetails872 = new PcDetails("Kasalar","COUGAR CGR-5NM1B-C MX350 700W 80 PLUS MidT ATX GAMING");
                            pcDetailsArrayList.add(pcDetails872);

                            PcDetails pcDetails873 = new PcDetails("Kasalar","THERMALTAKE PCI-e X16 Riser Cable");
                            pcDetailsArrayList.add(pcDetails873);

                            PcDetails pcDetails874 = new PcDetails("Kasalar","THERMALTAKE VIEW 27 600W 80PLUS ARGB 3x120mm MidT");
                            pcDetailsArrayList.add(pcDetails874);

                            PcDetails pcDetails875 = new PcDetails("Kasalar","NZXT S340MB-GB Mid TOWER ATX ");
                            pcDetailsArrayList.add(pcDetails875);

                            PcDetails pcDetails876 = new PcDetails("Kasalar","NZXT S340MB-GR Mid TOWER ATX ");
                            pcDetailsArrayList.add(pcDetails876);

                            PcDetails pcDetails877 = new PcDetails("Kasalar","NZXT S340W-TH ELITE SPECIAL EDITION Mid TOWER ATX ");
                            pcDetailsArrayList.add(pcDetails877);

                            PcDetails pcDetails878 = new PcDetails("Kasalar","NZXT S340W-B5 ELITE Mid TOWER ATX");
                            pcDetailsArrayList.add(pcDetails878);

                            PcDetails pcDetails879 = new PcDetails("Kasalar","NZXT S340W-B3 ELITE Mid TOWER ATX");
                            pcDetailsArrayList.add(pcDetails879);

                            PcDetails pcDetails970 = new PcDetails("Kasalar","COUGAR PANZER-G GAMING USB3.0 MidT ATX ");
                            pcDetailsArrayList.add(pcDetails970);

                            PcDetails pcDetails971 = new PcDetails("Kasalar","COUGAR PANZER MAX GAMING USB3.0 FullT ATX ");
                            pcDetailsArrayList.add(pcDetails971);

                            PcDetails pcDetails972 = new PcDetails("Kasalar","COUGAR CONQUER GAMING USB3.0 MidT ATX");
                            pcDetailsArrayList.add(pcDetails972);

                            PcDetails pcDetails973 = new PcDetails("Kasalar","RAMPAGE TEMPER PRO V5 4x120mm RGB FAN 6xRGB");
                            pcDetailsArrayList.add(pcDetails973);

                            PcDetails pcDetails974 = new PcDetails("Kasalar","XIGMATEK ZEST RAINBOW LED BAR USB3.0");
                            pcDetailsArrayList.add(pcDetails974);

                            PcDetails pcDetails975 = new PcDetails("Kasalar","COUGAR TURRET V2 700W 80 PLUS GAMING USB3.0 MidT ATX");
                            pcDetailsArrayList.add(pcDetails975);

                            PcDetails pcDetails931 = new PcDetails("Kasalar","THERMALTAKE LEVEL 20 MT ARGB 3x120mm  MidT");
                            pcDetailsArrayList.add(pcDetails931);

                            PcDetails pcDetails932 = new PcDetails("Kasalar","THERMALTAKE V200TG 3x120MM RGB MidT ATX GAMING");
                            pcDetailsArrayList.add(pcDetails932);

                            PcDetails pcDetails933 = new PcDetails("Kasalar","FRISBY GC-9250G GAMEMAX RAPTOR 650W USB 3.0MidT ATX");
                            pcDetailsArrayList.add(pcDetails933);

                            PcDetails pcDetails9332 = new PcDetails("Kasalar","COOLER MASTER MASTERBOX K500L 600W 80PLUS MidT ATX");
                            pcDetailsArrayList.add(pcDetails9332);

                            PcDetails pcDetails9333 = new PcDetails("Kasalar","FRISBY FC-8860G-650 650W USB 3.0 MidT GAMING ");
                            pcDetailsArrayList.add(pcDetails9333);

                            PcDetails pcDetails9334 = new PcDetails("Kasalar","FRISBY FC-8865G-650 650W MidT ATX");
                            pcDetailsArrayList.add(pcDetails9334);

                            PcDetails pcDetails9335 = new PcDetails("Kasalar","RAMPAGE CARBON 4x120mm RGB FAN USB 3.0 MidT ATX ");
                            pcDetailsArrayList.add(pcDetails9335);

                            PcDetails pcDetails933445 = new PcDetails("Kasalar","COOLER MASTER MASTERBOX LITE 5 600W 80PLUS MidT ATX");
                            pcDetailsArrayList.add(pcDetails933445);

                            PcDetails pcDetails93356 = new PcDetails("Kasalar","FRISBY FC-8870G 400W USB 3.0 MidT GAMING");
                            pcDetailsArrayList.add(pcDetails93356);




                            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                            adaptorPcDetails = new AdaptorPcDetails(pcDetailsArrayList);
                            recyclerView.setAdapter(adaptorPcDetails);





                            adaptorPcDetails.notifyDataSetChanged();


                        }else if (dil.equals("ingilizce")){

                            PcDetails pcDetails616161 = new PcDetails("Safes","POWERBOOST VK-P1900B 500W USB 3.0 MESH FIXED 4x120mm");
                            pcDetailsArrayList.add(pcDetails616161);

                            PcDetails pcDetails2 = new PcDetails("Safes","POWERBOOST VK-P15B 600W 80 PLUS USB 3.0 MESH 4x120mm");
                            pcDetailsArrayList.add(pcDetails2);

                            PcDetails pcDetails3 = new PcDetails("Safes","COOLER MASTER MASTERBOX TD500 650W 80PLUS BRONZE");
                            pcDetailsArrayList.add(pcDetails3);

                            PcDetails pcDetails4 = new PcDetails("Safes","MSI MAG FORGE 100M TEMPERED GLASS 2x120mm RGB MidT");
                            pcDetailsArrayList.add(pcDetails4);

                            PcDetails pcDetails5 = new PcDetails("Safes","COOLER MASTER MASTERBOX TD500 MESH 4x120mm ARGB ");
                            pcDetailsArrayList.add(pcDetails5);
                                                                 
                            PcDetails pcDetails6 = new PcDetails("Safes","RAMPAGE REACTION 4x120mm Rainbow  600W 80PLUS");
                            pcDetailsArrayList.add(pcDetails6);

                            PcDetails pcDetails7 = new PcDetails("Safes","POWERBOOST VK-P06B 550W USB 3.0 DOUBLE RING MESH 4x120mm");
                            pcDetailsArrayList.add(pcDetails7);

                            PcDetails pcDetails8 = new PcDetails("Safes","POWERBOOST VK-P06B 550W USB 3.0 DOUBLE RING MESH 4x120mm");
                            pcDetailsArrayList.add(pcDetails8);

                            PcDetails pcDetails9 = new PcDetails("Safes","COOLER MASTER MASTERBOX TD500 MESH 4x120mm ARGB ");
                            pcDetailsArrayList.add(pcDetails9);

                            PcDetails pcDetails10 = new PcDetails("Safes","COOLER MASTER MASTEBOX TD500 750W 80PLUS BRONZE");
                            pcDetailsArrayList.add(pcDetails10);

                            PcDetails pcDetails11 = new PcDetails("Safes","COOLER MASTER MASTERBOX K501L V4 600W 80PLUS MESH ");
                            pcDetailsArrayList.add(pcDetails11);

                            PcDetails pcDetails12 = new PcDetails("Safes","COOLER MASTER MASTERBOX MB311L 600W 3x120mm RGB  MINI TOWER");
                            pcDetailsArrayList.add(pcDetails12);

                            PcDetails pcDetails14 = new PcDetails("Safes","POWERBOOST VK-M202B USB 3.0 MESH 4x120mm RGB FAN ATX");
                            pcDetailsArrayList.add(pcDetails14);

                            PcDetails pcDetails15 = new PcDetails("Safes","CORSAIR İCUE 4000X RGB 750W 80PLUS BRONZE TEMPERED");
                            pcDetailsArrayList.add(pcDetails15);

                            PcDetails pcDetails16 = new PcDetails("Safes","FRISBY 4x120mm RGB  650W 80 PLUS MESH ÖN PANEL MidT ATX GAMING ");
                            pcDetailsArrayList.add(pcDetails16);

                            PcDetails pcDetails17 = new PcDetails("Safes","CORSAIR 4000D TEMPERED GLASS 2x120mm MidT ");
                            pcDetailsArrayList.add(pcDetails17);

                            PcDetails pcDetails18 = new PcDetails("Safes","RAMPAGE SAILOR 4x120mm Rainbow  600W 80Plus");
                            pcDetailsArrayList.add(pcDetails18);

                            PcDetails pcDetails19 = new PcDetails("Safes","THERMALTAKE V200TG 600W 80PLUS 3x120mm RGB MidT");
                            pcDetailsArrayList.add(pcDetails19);

                            PcDetails pcDetails20 = new PcDetails("Safes","POWERBOOST VK-D501M 650W 80PLUS USB 3.0 MESH 4x120mm");
                            pcDetailsArrayList.add(pcDetails20);

                            PcDetails pcDetails21 = new PcDetails("Safes","THERMALTAKE DIVIDER 500 TG 3x120mm ARGB  MidT");
                            pcDetailsArrayList.add(pcDetails21);

                            PcDetails pcDetails22 = new PcDetails("Safes","MSI MAG FORGE 100R TEMPERED GLASS 2x120mm ARGB  MidT");
                            pcDetailsArrayList.add(pcDetails22);

                            PcDetails pcDetails23 = new PcDetails("Safes","RAMPAGE FUSION 4x120mm RAINBOW USB3.0 MidT ATX");
                            pcDetailsArrayList.add(pcDetails23);

                            PcDetails pcDetails24 = new PcDetails("Safes","XIGMATEK DIAMOND 600W 80 PLUS POWER 4X120mm RAINBOW");
                            pcDetailsArrayList.add(pcDetails24);

                            PcDetails pcDetails25 = new PcDetails("Safes","THERMALTAKE COMMANDER G33 TG 750W 80PLUS 2x200mm ARGB");
                            pcDetailsArrayList.add(pcDetails25);

                            PcDetails pcDetails26 = new PcDetails("Safes","COUGAR PANZER EVO RGB GAMING USB3.0 FullT ATX ");
                            pcDetailsArrayList.add(pcDetails26);

                            PcDetails pcDetails27 = new PcDetails("Safes","COUGAR PURITAS GAMING USB3.0 MidT ATX ");
                            pcDetailsArrayList.add(pcDetails27);

                            PcDetails pcDetails28 = new PcDetails("Safes","THERMALTAKE TOWER 500  3X TEMPERED GLASS  GAMING ");
                            pcDetailsArrayList.add(pcDetails28);

                            PcDetails pcDetails29 = new PcDetails("Safes","MSI MAG FORGE M100R TEMPERED GLASS ARGB FAN USB");
                            pcDetailsArrayList.add(pcDetails29);

                            PcDetails pcDetails30 = new PcDetails("Safes","MSI MAG FORGE M100A  YAN PANEL ARGB FAN USB 3.2");
                            pcDetailsArrayList.add(pcDetails30);

                            PcDetails pcDetails31 = new PcDetails("Safes","POWERBOOST VK-P3301B 500W USB 3.0 MESH FIXED 4x120mm");
                            pcDetailsArrayList.add(pcDetails31);

                            PcDetails pcDetails32 = new PcDetails("Safes","POWERBOOST VK-C12B USB 3.0 TEMPERED GLASS 4x120mm RGB");
                            pcDetailsArrayList.add(pcDetails32);

                            PcDetails pcDetails33 = new PcDetails("Safes","COOLER MASTER HAF 700 EVO 2x120mm-2x200mm ARGB ");
                            pcDetailsArrayList.add(pcDetails33);

                            PcDetails pcDetails34 = new PcDetails("Safes","MAG SHIELD 110R USB3.2 MidT ATX");
                            pcDetailsArrayList.add(pcDetails34);

                            PcDetails pcDetails35 = new PcDetails("Safes","COOLER MASTER HAF 500 TG MESH ARGB 1x120cm 2x200cm");
                            pcDetailsArrayList.add(pcDetails35);

                            PcDetails pcDetails36 = new PcDetails("Safes","THERMALTAKE AH T200 empered Glass MiniT");
                            pcDetailsArrayList.add(pcDetails36);

                            PcDetails pcDetails37 = new PcDetails("Safes","MSI MAG FORGE 100 RB65  650W BRONZ");
                            pcDetailsArrayList.add(pcDetails37);

                            PcDetails pcDetails38 = new PcDetails("Safes","THERMALTAKE Core P6  3xTempered Glass  MidT");
                            pcDetailsArrayList.add(pcDetails38);

                            PcDetails pcDetails39 = new PcDetails("Safes","COOLER MASTER Universal PCI-e 4.0 Riser ");
                            pcDetailsArrayList.add(pcDetails39);

                            PcDetails pcDetails40 = new PcDetails("Safes","COOLER MASTER MasterAccessory ARGB Tempered Universal ");
                            pcDetailsArrayList.add(pcDetails40);

                            PcDetails pcDetails41 = new PcDetails("Safes","MSI MPG VELOX 100P AIRFLOW 4x120mm  MidT ATX GAMING");
                            pcDetailsArrayList.add(pcDetails41);

                            PcDetails pcDetails42 = new PcDetails("Safes","THERMALTAKE PCI-e 4.0 X16 300mm 90°  RISER");
                            pcDetailsArrayList.add(pcDetails42);

                            PcDetails pcDetails43 = new PcDetails("Safes","MSI MAG SHIELD M300 USB3.2 MidT ATX");
                            pcDetailsArrayList.add(pcDetails43);

                            PcDetails pcDetails44 = new PcDetails("Safes","MSI MAG FORGE 101M TEMPERED GLASS 4x120mm RGB  MidT");
                            pcDetailsArrayList.add(pcDetails44);

                            PcDetails pcDetails45 = new PcDetails("Safes","COUGAR MX660 MESH RGB 4x120mm RGB  MESH GEX");
                            pcDetailsArrayList.add(pcDetails45);

                            PcDetails pcDetails46 = new PcDetails("Safes","MSI MPG GUNGNIR 110R TEMPERED GLASS 4x120mm ARGB");
                            pcDetailsArrayList.add(pcDetails46);

                            PcDetails pcDetails47 = new PcDetails("Safes","COOLER MASTER MASTERCASE H500 MESH 2x200mm +1x120mm");
                            pcDetailsArrayList.add(pcDetails47);

                            PcDetails pcDetails48 = new PcDetails("Safes","CORSAIR 5000D TEMPERED GLASS YAN PANEL 2x120mm ");
                            pcDetailsArrayList.add(pcDetails48);

                            PcDetails pcDetails49 = new PcDetails("Safes","ZALMAN M3 PLUS 4x120mm RGB  MINI TOWER GAMING ");
                            pcDetailsArrayList.add(pcDetails49);

                            PcDetails pcDetails50 = new PcDetails("Safes","ZALMAN S4 PLUS 3x120mm RGB  MEGAMAX 600W 80PLUS MidT ATX GAMING");
                            pcDetailsArrayList.add(pcDetails50);

                            PcDetails pcDetails51 = new PcDetails("Safes","THERMALTAKE VIEW 51 TEMPERED GLASS 2x200mm ARGB");
                            pcDetailsArrayList.add(pcDetails51);

                            PcDetails pcDetails52 = new PcDetails("Safes","THERMALTAKE VIEW 51 TEMPERED GLASS 2x200mm ARGB");
                            pcDetailsArrayList.add(pcDetails52);

                            PcDetails pcDetails53 = new PcDetails("Safes","RAMPAGE HACKER 4x120mm RGB  600W 80PLUS BRONZE MidT");
                            pcDetailsArrayList.add(pcDetails53);

                            PcDetails pcDetails54 = new PcDetails("Safes","COUGAR DARK BLADER-G RGB  USB3.0 FullT ATX");
                            pcDetailsArrayList.add(pcDetails54);

                            PcDetails pcDetails55 = new PcDetails("Safes","THERMALTAKE VERSA J23 650W 3x120mm RGB ");
                            pcDetailsArrayList.add(pcDetails55);

                            PcDetails pcDetails56 = new PcDetails("Safes","EVEREST X-MESH 3x120mm RAINBOW  USB 3.0 Mini Tower");
                            pcDetailsArrayList.add(pcDetails56);

                            PcDetails pcDetails57 = new PcDetails("Safes","CORSAIR CARBIDE SPEC-DELTA 550W 80PLUS RGB ");
                            pcDetailsArrayList.add(pcDetails57);

                            PcDetails pcDetails58 = new PcDetails("Safes","COUGAR GEMINI S GAMING USB3.0 MidT ");
                            pcDetailsArrayList.add(pcDetails58);

                            PcDetails pcDetails59 = new PcDetails("Safes","COUGAR GEMINI T RGB GAMING USB3.0 MidT ATX ");
                            pcDetailsArrayList.add(pcDetails59);

                            PcDetails pcDetails60 = new PcDetails("Safes","XIGMATEK ASTRO 650W 80PLUS POWER 4x120mm RGB ");
                            pcDetailsArrayList.add(pcDetails60);

                            PcDetails pcDetails61 = new PcDetails("Safes","RAMPAGE THE KING 4x120mm RGB FAN USB 3.0 MidT ATX");
                            pcDetailsArrayList.add(pcDetails61);

                            PcDetails pcDetails62 = new PcDetails("Safes","POWER BOOST VK-G3403S 650W 80 PLUS MESH PANEL USB 3.0");
                            pcDetailsArrayList.add(pcDetails62);


                            PcDetails pcDetails64 = new PcDetails("Safes","POWER BOOST VK-T01B RGB 650W 80+ Mesh Panel USB 3.0 Mid");
                            pcDetailsArrayList.add(pcDetails64);

                            PcDetails pcDetails65 = new PcDetails("Safes","FRISBY FC-9410G WOLF 500W RGB 3X FAN USB 3.0 Mid ATX");
                            pcDetailsArrayList.add(pcDetails65);

                            PcDetails pcDetails66 = new PcDetails("Safes","FRISBY FC-9320G MESH 4XRGB 600W USB 3.0 80 PLUS Mid ATX ");
                            pcDetailsArrayList.add(pcDetails66);

                            PcDetails pcDetails67 = new PcDetails("Safes","THERMALTAKE CORE P6  3X TEMPERED GLASS ");
                            pcDetailsArrayList.add(pcDetails67);

                            PcDetails pcDetails68 = new PcDetails("Safes","THARMALTAKE AH T200  TEMPERED GLASS ");
                            pcDetailsArrayList.add(pcDetails68);

                            PcDetails pcDetails69 = new PcDetails("Safes","MSI MAG SHIELD M301 MESH mATX" );
                            pcDetailsArrayList.add(pcDetails69);

                            PcDetails pcDetails70 = new PcDetails("Safes","ASUS TUF GAMING GT301 3x120mm ARGB ");
                            pcDetailsArrayList.add(pcDetails70);

                            PcDetails pcDetails71 = new PcDetails("Safes","RAMPAGE REDSKY 4x120mm RGB700W 80 Plus Bronze ");
                            pcDetailsArrayList.add(pcDetails71);

                            PcDetails pcDetails72 = new PcDetails("Safes","XIGMATEK GAMING M 4*X20C RGB X-Power 500W Mesh Panel Tempered ");
                            pcDetailsArrayList.add(pcDetails72);

                            PcDetails pcDetails73 = new PcDetails("Safes","EVEREST BUMPY 4x120mm ARGB GAMING");
                            pcDetailsArrayList.add(pcDetails73);

                            PcDetails pcDetails74 = new PcDetails("Safes","EVEREST 2*Sata Mesh 720R Peak-250W  Metal");
                            pcDetailsArrayList.add(pcDetails74);

                            PcDetails pcDetails75 = new PcDetails("Safes","MSI MAG FORGE 112R ARGB Tempered ATX Mid Tower");
                            pcDetailsArrayList.add(pcDetails75);

                            PcDetails pcDetails76 = new PcDetails("Safes","POWERBOOST X59RGB 650W 80 PLUS USB 3.0 TEMPERED");
                            pcDetailsArrayList.add(pcDetails76);

                            PcDetails pcDetails77 = new PcDetails("Safes","POWERBOOST VK-G3701B 550W 80 PLUS USB 3.0 MESH 4x120mm");
                            pcDetailsArrayList.add(pcDetails77);

                            PcDetails pcDetails78 = new PcDetails("Safes","MSI MPG GUNGNIR 110R WHITE Tempered Glass RGB USB 3.2 ATX");
                            pcDetailsArrayList.add(pcDetails78);

                            PcDetails pcDetails79 = new PcDetails("Safes","MSI MAG FORGE 110R ARGB USB 3.2 ATX Mid Tower ");
                            pcDetailsArrayList.add(pcDetails79);

                            PcDetails pcDetails80 = new PcDetails("Safes","MSI MAG FORGE 111R USB 3.2 ARGB Tempered Glass ATX");
                            pcDetailsArrayList.add(pcDetails80);

                            PcDetails pcDetails81 = new PcDetails("Safes","COOLER MASTER MASTERBOX MB520 600W 80 PLUS 3x120mm");
                            pcDetailsArrayList.add(pcDetails81);

                            PcDetails pcDetails82 = new PcDetails("Safes","MSI MAG SHIELD 110A USB3.2 MidT ATX");
                            pcDetailsArrayList.add(pcDetails82);

                            PcDetails pcDetails83 = new PcDetails("Safes","S-LINK SLX-F201 10cm 4 Pin 2'li PWM ");
                            pcDetailsArrayList.add(pcDetails83);

                            PcDetails pcDetails84 = new PcDetails("Safes","COOLER MASTER TD300 TG MESH 2x120mm ARGB ");
                            pcDetailsArrayList.add(pcDetails84);

                            PcDetails pcDetails85 = new PcDetails("Safes","COOLER MASTER HAF 500 TG MESH ARGB 1x120cm 2x200cm");
                            pcDetailsArrayList.add(pcDetails85);

                            PcDetails pcDetails86 = new PcDetails("Safes","THERMALTAKE AH T200 Tempered Glass  Micro ATX");
                            pcDetailsArrayList.add(pcDetails86);

                            PcDetails pcDetails87 = new PcDetails("Safes","THERMALTAKE Core P6  3xTempered Glass  MidT");
                            pcDetailsArrayList.add(pcDetails87);

                            PcDetails pcDetails88 = new PcDetails("Safes","THERMALTAKE Divider 200 TG Air  1x200mmMesh MiniT");
                            pcDetailsArrayList.add(pcDetails88);

                            PcDetails pcDetails89 = new PcDetails("Safes","THERMALTAKE Divider 200 TG Air 1x200mm Mesh MiniT");
                            pcDetailsArrayList.add(pcDetails89);

                            PcDetails pcDetails90 = new PcDetails("Safes","THERMALTAKE DIVIDER 500 TG AIR 2x120mm  MESH");
                            pcDetailsArrayList.add(pcDetails90);

                            PcDetails pcDetails91 = new PcDetails("Safes","THERMALTAKE DIVIDER 500 TG AIR 2x120mm  MESH");
                            pcDetailsArrayList.add(pcDetails91);

                            PcDetails pcDetails92 = new PcDetails("Safes","THERMALTAKE DIVIDER 500 TG 4x120mm ARGB  MidT");
                            pcDetailsArrayList.add(pcDetails92);

                            PcDetails pcDetails93 = new PcDetails("Safes","THERMALTAKE DIVIDER 300 TG AIR B2x120mm MESH");
                            pcDetailsArrayList.add(pcDetails93);

                            PcDetails pcDetails94 = new PcDetails("Safes","THERMALTAKE DIVIDER 300 TG AIR  2x120mm  MESH");
                            pcDetailsArrayList.add(pcDetails94);

                            PcDetails pcDetails95 = new PcDetails("Safes","THERMALTAKE The Tower 100 Racing Green 3xTempered Glass");
                            pcDetailsArrayList.add(pcDetails95);


                            PcDetails pcDetails96 = new PcDetails("Safes","THERMALTAKE THE TOWER 100 3xTEMPERED GLASS");
                            pcDetailsArrayList.add(pcDetails96);

                            PcDetails pcDetails97 = new PcDetails("Safes","THERMALTAKE The Tower 100  3xTempered Glass");
                            pcDetailsArrayList.add(pcDetails97);

                            PcDetails pcDetails98 = new PcDetails("Safes","THERMALTAKE THE TOWER 100  3xTEMPERED GLASS ");
                            pcDetailsArrayList.add(pcDetails98);

                            PcDetails pcDetails99 = new PcDetails("Safes","MSI MAG VAMPIRIC 300R PACIFIC BLUE TEMPERED GLASS 1x120mm");
                            pcDetailsArrayList.add(pcDetails99);

                            PcDetails pcDetails100 = new PcDetails("Safes","MSI MAG VAMPIRIC 300R MIDNIGHT GREEN TEMPERED");
                            pcDetailsArrayList.add(pcDetails100);

                            PcDetails pcDetails101 = new PcDetails("Safes","MSI MAG VAMPIRIC 100L TEMPERED GLASS MidT ARGB ATX");
                            pcDetailsArrayList.add(pcDetails101);

                            PcDetails pcDetails102 = new PcDetails("Safes","COOLER MASTER MASTERBOX NR200P TEMPERED GLASS Mini");
                            pcDetailsArrayList.add(pcDetails102);

                            PcDetails pcDetails103 = new PcDetails("Safes","COOLER MASTER MASTERBOX NR200P TEMPERED GLASS Mini-");
                            pcDetailsArrayList.add(pcDetails103);

                            PcDetails pcDetails104 = new PcDetails("Safes","COOLER MASTER MASTERBOX NR200P TEMPERED GLASS Mini-");
                            pcDetailsArrayList.add(pcDetails104);

                            PcDetails pcDetails105 = new PcDetails("Safes","MSI MPG VELOX 100R 4x120mm ARGB  MidT ATX GAMING");
                            pcDetailsArrayList.add(pcDetails105);


                            PcDetails pcDetails107 = new PcDetails("Safes","MSI MPG VELOX 100R 4x120mm ARGB MidT ATX GAMING");
                            pcDetailsArrayList.add(pcDetails107);

                            PcDetails pcDetails108 = new PcDetails("Safes","MSI MPG QUIETUDE 100S 1x120mm  MidT ATX GAMING");
                            pcDetailsArrayList.add(pcDetails108);

                            PcDetails pcDetails109 = new PcDetails("Safes","AG VAMPIRIC 300R TEMPERED GLASS 1x120mm ARGB");
                            pcDetailsArrayList.add(pcDetails109);

                            PcDetails pcDetails110 = new PcDetails("Safes","MSI MPG GUNGNIR 111R TEMPERED GLASS 4x120mm ARGB");
                            pcDetailsArrayList.add(pcDetails110);

                            PcDetails pcDetails111 = new PcDetails("Safes","COUGAR GEMINI T PRO ARGB  MidT ATX GAMING");
                            pcDetailsArrayList.add(pcDetails111);

                            PcDetails pcDetails112 = new PcDetails("Safes","COUGAR GEMINI S SILVER XTC 600W 80 PLUS MidT ATX GAMING");
                            pcDetailsArrayList.add(pcDetails112);

                            PcDetails pcDetails113 = new PcDetails("Safes","COUGAR QBX USB3.0 Mini-ITX");
                            pcDetailsArrayList.add(pcDetails113);


                            PcDetails pcDetails1143 = new PcDetails("Safes","COUGAR BLAZER ESSENCE TEMPER  MidT ATX GAMIN");
                            pcDetailsArrayList.add(pcDetails1143);

                            PcDetails pcDetails114 = new PcDetails("Safes","MSI MPG SEKIRA 500G TEMPERED GLASS 3x200mm MidT ATX ");
                            pcDetailsArrayList.add(pcDetails114);

                            PcDetails pcDetails115 = new PcDetails("Safes","COOLER MASTER MASTERBOX TD500 650W 80PLUS BRONZE");
                            pcDetailsArrayList.add(pcDetails115);

                            PcDetails pcDetails116 = new PcDetails("Safes","COUGAR MX440 MESH RGB 4x120mm RGB VTE X2 750W");
                            pcDetailsArrayList.add(pcDetails116);

                            PcDetails pcDetails117 = new PcDetails("Safes","ZALMAN N5 MF (SE) 4x120mm RGB  MegaMax 600W 80PLUS MidT");
                            pcDetailsArrayList.add(pcDetails117);

                            PcDetails pcDetails118 = new PcDetails("Safes","COUGAR PANZER 1x120mm  MidT ATX USB3.0 GAMING");
                            pcDetailsArrayList.add(pcDetails118);

                            PcDetails pcDetails119 = new PcDetails("Safes","COUGAR DARK BLADER X7 1x120mm ARGB GAMING");
                            pcDetailsArrayList.add(pcDetails119);

                            PcDetails pcDetails200 = new PcDetails("Safes","COUGAR DARK BLADER X5-RGB 3x120mm ARGB GAMING");
                            pcDetailsArrayList.add(pcDetails200);

                            PcDetails pcDetails201 = new PcDetails("Safes","XIGMATEK MASTER X 4x120mm ARGBX-Power 650W TEMPER MESH");
                            pcDetailsArrayList.add(pcDetails201);   

                            PcDetails pcDetails202 = new PcDetails("Safes","XIGMATEK X7 7x120mm ARGB TEMPERED  GAMING");
                            pcDetailsArrayList.add(pcDetails202);

                            PcDetails pcDetails203 = new PcDetails("Safes","XIGMATEK GAMING X 4x120mm RGB  X-Power 500W TEMPER");
                            pcDetailsArrayList.add(pcDetails203);

                            PcDetails pcDetails204 = new PcDetails("Safes","MSI MPG GUNGNIR 100P TEMPERED GLASS 1x120mm ");
                            pcDetailsArrayList.add(pcDetails204);

                            PcDetails pcDetails205 = new PcDetails("Safes","CORSAIR 470T RGB  CAM YAN PANEL MidT ATX ");
                            pcDetailsArrayList.add(pcDetails205);

                            PcDetails pcDetails206 = new PcDetails("Safes","RAMPAGE DEEPFORCE 4x120mm RGB 600W 80PLUS BRONZE");
                            pcDetailsArrayList.add(pcDetails206);

                            PcDetails pcDetails207 = new PcDetails("Safes","MSI MPG SEKIRA 500X TEMPERED GLASS 3x200mm ARGB  MidT");
                            pcDetailsArrayList.add(pcDetails207);

                            PcDetails pcDetails208 = new PcDetails("Safes","THERMALTAKE H330 650W x120mm I TEMPERED");
                            pcDetailsArrayList.add(pcDetails208);

                            PcDetails pcDetails209 = new PcDetails("Safes","THERMALTAKE VERSA T25 550W 80+ TEMPERED GLASS RGB");
                            pcDetailsArrayList.add(pcDetails209);

                            PcDetails pcDetails210 = new PcDetails("Safes","ASUS TUF GAMING GT501 WHITE EDITION 3x120mm RGB  MidT ATX ");
                            pcDetailsArrayList.add(pcDetails210);

                            PcDetails pcDetails211 = new PcDetails("Safes","FRISBY 4x120mm RAINBOW  600W 80PLUS BRONZE USB3.0");
                            pcDetailsArrayList.add(pcDetails211);

                            PcDetails pcDetails212 = new PcDetails("Safes","EVEREST SPECTRUM 4x120mm  500W MidT ATX GAMING");
                            pcDetailsArrayList.add(pcDetails212);

                            PcDetails pcDetails213 = new PcDetails("Safes","RAMPAGE PHANTOM X2 600W 80PLUS BRONZE 1x120mm RGB");
                            pcDetailsArrayList.add(pcDetails213);

                            PcDetails pcDetails224 = new PcDetails("Safes","RAMPAGE PHANTOM X1 600W 80PLUS BRONZE 1x120mm RGB");
                            pcDetailsArrayList.add(pcDetails224);

                            PcDetails pcDetails234 = new PcDetails("Safes","CORSAIR CARBIDE  SPEC-05 650W 80PLUS BRONZE MidT");
                            pcDetailsArrayList.add(pcDetails234);

                            PcDetails pcDetails244 = new PcDetails("Safes","CORSAIR CARBIDE  SPEC-05 550W 80PLUS BRONZE MidT");
                            pcDetailsArrayList.add(pcDetails244);

                            PcDetails pcDetails255 = new PcDetails("Safes","COUGAR MX410 MESH-G RGB 4x120mm ARGB  650W 80 PLUS USB3.0 GAMING ");
                            pcDetailsArrayList.add(pcDetails255);

                            PcDetails pcDetails266 = new PcDetails("Safes","ASUS ROG Z11 3x120mm  USB3.2 MINI TOWER ");
                            pcDetailsArrayList.add(pcDetails266);

                            PcDetails pcDetails277 = new PcDetails("Safes","MSI MPG SEKIRA 100R TEMPERED GLASS 4x120mm ARGB MidT");
                            pcDetailsArrayList.add(pcDetails277);

                            PcDetails pcDetails288 = new PcDetails("Safes","MSI MPG GUNGNIR 110M TEMPERED GLASS 3x120mm RGB");
                            pcDetailsArrayList.add(pcDetails288);

                            PcDetails pcDetails299 = new PcDetails("Safes","MSI MPG GUNGNIR 100D TEMPERED GLASS 2x120mm ");
                            pcDetailsArrayList.add(pcDetails299);

                            PcDetails pcDetails300 = new PcDetails("Safes","MSI MPG GUNGNIR 100 TEMPERED GLASS 1x120mm ARGB");
                            pcDetailsArrayList.add(pcDetails300);

                            PcDetails pcDetails320 = new PcDetails("Safes","MSI MAG VAMPIRIC 100R TEMPERED GALSS 1x120mm ARGB");
                            pcDetailsArrayList.add(pcDetails320);

                            PcDetails pcDetails333 = new PcDetails("Safes","MSI MAG VAMPIRIC 011C TEMPERED GLASS 1x120mm ARGB");
                            pcDetailsArrayList.add(pcDetails333);

                            PcDetails pcDetails344 = new PcDetails("Safes","MSI MAG VAMPIRIC 010X TEMPERED GLASS 1x120mm RGB");
                            pcDetailsArrayList.add(pcDetails344);

                            PcDetails pcDetails355 = new PcDetails("Safes","CORSAIR 5000D TEMPERED GLASS 2x120mm FANLI MidT");
                            pcDetailsArrayList.add(pcDetails355);

                            PcDetails pcDetails366 = new PcDetails("Safes","FRISBY 4x120mm RGB  650W 80 PLUS USB3.0 MidT ATX GAMING");
                            pcDetailsArrayList.add(pcDetails366);

                            PcDetails pcDetails377= new PcDetails("Safes","FRISBY 4x120mm RGB 600W 80 PLUS USB3.0 MidT ATX GAMING");
                            pcDetailsArrayList.add(pcDetails377);

                            PcDetails pcDetails381 = new PcDetails("Safes","FRISBY 4x120mm RGB 650W 80 PLUS USB3.0 MidT ATX GAMING");
                            pcDetailsArrayList.add(pcDetails381);

                            PcDetails pcDetails391 = new PcDetails("Safes","XIGMATEK CYCLOPS M 4x120mm RGB  X-POWER 650W");
                            pcDetailsArrayList.add(pcDetails391);

                            PcDetails pcDetails401 = new PcDetails("Safes","XIGMATEK TRIDENT PLUS 4x120mm RGB  X-POWER");
                            pcDetailsArrayList.add(pcDetails401);

                            PcDetails pcDetails412 = new PcDetails("Safes","COOLER MASTER MASTERCASE H500 750W 80PLUS BRONZE ARGB");
                            pcDetailsArrayList.add(pcDetails412);

                            PcDetails pcDetails421 = new PcDetails("Safes","XIGMATEK VERA M 2x200mm ARGB FANLI MESH PANEL SUPER");
                            pcDetailsArrayList.add(pcDetails421);

                            PcDetails pcDetails433 = new PcDetails("Safes","XIGMATEK VERA 2x200mm ARGB FANLI CAM PANEL SUPER TOWER");
                            pcDetailsArrayList.add(pcDetails433);

                            PcDetails pcDetails444 = new PcDetails("Safes","RAMPAGE HECTORA GLASS 4x140mm ARGB  700W");
                            pcDetailsArrayList.add(pcDetails444);

                            PcDetails pcDetails456 = new PcDetails("Safes","RAMPAGE AMAZE 4x120mm RGB  700W 80PLUS BRONZE MidT");
                            pcDetailsArrayList.add(pcDetails456);

                            PcDetails pcDetails467 = new PcDetails("Safes","RAMPAGE HECTORA XL 4x140mm ARGB  700W 80PLUS");
                            pcDetailsArrayList.add(pcDetails467);

                            PcDetails pcDetails477 = new PcDetails("Safes","THERMALTAKE VERSA T25 650W 80PLUS ARGB 3x120mm MidT");
                            pcDetailsArrayList.add(pcDetails477);

                            PcDetails pcDetails488 = new PcDetails("Safes","THERMALTAKE H330 650W ARGB 3x120mm  TEMPERED GLASS");
                            pcDetailsArrayList.add(pcDetails488);   
                                                                    
                            PcDetails pcDetails499 = new PcDetails("Safes","RAMPAGE PLATINO 4x120mm RAINBOW  600W 80PLUS");
                            pcDetailsArrayList.add(pcDetails499);

                            PcDetails pcDetails501 = new PcDetails("Safes","RAMPAGE ESPECTRO 4x120mm RAINBOW 600W 80PLUS");
                            pcDetailsArrayList.add(pcDetails501);

                            PcDetails pcDetails511 = new PcDetails("Safes","RAMPAGE GALAXY 4x120mm RGB 600W 80PLUS BRONZE MidT");
                            pcDetailsArrayList.add(pcDetails511);   
                                                                    
                            PcDetails pcDetails512 = new PcDetails("Safes","RAMPAGE X-HORSE 650W 80 PLUS BRONZE 4x120mm RAINBOW");
                            pcDetailsArrayList.add(pcDetails512);

                            PcDetails pcDetails513 = new PcDetails("Safes","COOLER MASTER MASTERBOX MB520 4x120mm");
                            pcDetailsArrayList.add(pcDetails513);

                            PcDetails pcDetails514 = new PcDetails("Safes","CORSAIR İCUE 4000X RGB TEMPERED GLASS 3x120mm ");
                            pcDetailsArrayList.add(pcDetails514);

                            PcDetails pcDetails515 = new PcDetails("Safes","CORSAIR 4000D TEMPERED GLASS 2x120mm FMidT");
                            pcDetailsArrayList.add(pcDetails515);

                            PcDetails pcDetails516 = new PcDetails("Safes","COOLER MASTER MASTERBOX MB511 650W 80PLUS BRONZE");
                            pcDetailsArrayList.add(pcDetails516);

                            PcDetails pcDetails517 = new PcDetails("Safes","XIGMATEK ZEUS SPECTRUM EDITION 5x120mm RGB ");
                            pcDetailsArrayList.add(pcDetails517);

                            PcDetails pcDetails518 = new PcDetails("Safes","XIGMATEK PERSEUS 5x120mm RGB  USB3.0");
                            pcDetailsArrayList.add(pcDetails518);

                            PcDetails pcDetails519 = new PcDetails("Safes","RAMPAGE CARISMA MESH 4x120mm RAINBOW  650W");
                            pcDetailsArrayList.add(pcDetails519);

                            PcDetails pcDetails610 = new PcDetails("Safes","RAMPAGE VICTORY 1x12mm 600W 80 PLUS BRONZE MidT ATX");
                            pcDetailsArrayList.add(pcDetails610);

                            PcDetails pcDetails611 = new PcDetails("Safes","XIGMATEK GRIP 4x120mm RAINBOW  X-POWER 600W");
                            pcDetailsArrayList.add(pcDetails611);

                            PcDetails pcDetails621 = new PcDetails("Safes","THERMALTAKE AH T600 2 x Tempered Glass ARGB ");
                            pcDetailsArrayList.add(pcDetails621); 
                                                                  
                            PcDetails pcDetails631 = new PcDetails("Safes","ASUS TUF GAMING GT301 3x120mm ARGB");
                            pcDetailsArrayList.add(pcDetails631);

                            PcDetails pcDetails642 = new PcDetails("Safes","RAMPAGE SHAKE 4x120mm RGB  600W 80Plus BRONZE MidT");
                            pcDetailsArrayList.add(pcDetails642);

                            PcDetails pcDetails652 = new PcDetails("Safes","RAMPAGE TRAPPER 3x140mm ARGB  650W 80PLUS");
                            pcDetailsArrayList.add(pcDetails652);

                            PcDetails pcDetails662 = new PcDetails("Safes","FRISBY FC-9325G INFINITY 4x120mm RGB 650W 80PLUS");
                            pcDetailsArrayList.add(pcDetails662);

                            PcDetails pcDetails671 = new PcDetails("Safes","XIGMATEK SIROCON III X-POWER 600W 80 PLUS RAINBOW ");
                            pcDetailsArrayList.add(pcDetails671);

                            PcDetails pcDetails681 = new PcDetails("Safes","RAMPAGE IMPOSING PRO 2x200mm ARGB 700W");
                            pcDetailsArrayList.add(pcDetails681);

                            PcDetails pcDetails691 = new PcDetails("Safes","FRISBY 4x120mm DUAL RING RGB 600W 80 PLUS BRONZE MidT");
                            pcDetailsArrayList.add(pcDetails691);

                            PcDetails pcDetails710 = new PcDetails("Safes","FRISBY 4x120mm DUAL RING  600W 80 PLUS BRONZE MidT");
                            pcDetailsArrayList.add(pcDetails710);

                            PcDetails pcDetails711 = new PcDetails("Safes","CORSAIR iCUE 220T 3x120mm RGB  TEMPER  MidT ATX");
                            pcDetailsArrayList.add(pcDetails711);

                            PcDetails pcDetails721 = new PcDetails("Safes","CORSAIR iCUE 220T 3x120mm RGB  MidT ATX");
                            pcDetailsArrayList.add(pcDetails721);

                            PcDetails pcDetails713 = new PcDetails("Safes","COUGAR BLAZER TEMPER USB3.0 MidT ATX GAMING ");
                            pcDetailsArrayList.add(pcDetails713);

                            PcDetails pcDetails714 = new PcDetails("Safes","COUGAR GEMINI S IRON GRAY XTC 600W 80 PLUS USB3.0 MidT");
                            pcDetailsArrayList.add(pcDetails714);

                            PcDetails pcDetails715 = new PcDetails("Safes","COUGAR DARK BLADER-S RGB USB3.0 FullT ATX GAMING ");
                            pcDetailsArrayList.add(pcDetails715);

                            PcDetails pcDetails716 = new PcDetails("Safes","ASUS ROG STRIX GX601 HELIOS 4x140mm  USB3.1 MidT ATX");
                            pcDetailsArrayList.add(pcDetails716);

                            PcDetails pcDetails717 = new PcDetails("Safes","ASUS TUF GAMING GT501 3x120mm RGB ");
                            pcDetailsArrayList.add(pcDetails717);

                            PcDetails pcDetails718 = new PcDetails("Safes","XIGMATEK LAMIYA 4x120mm X-POWER 650W 80PLUS MidT ATX");
                            pcDetailsArrayList.add(pcDetails718);

                            PcDetails pcDetails719 = new PcDetails("Safes","XIGMATEK COCKPIT MESH PANEL 4x120mm X-POWER 700W");
                            pcDetailsArrayList.add(pcDetails719);

                            PcDetails pcDetails810 = new PcDetails("Safes","XIGMATEK CYCLOPS 4x120mm FAN X-POWER 650W 80PLUS MidT");
                            pcDetailsArrayList.add(pcDetails810);

                            PcDetails pcDetails811 = new PcDetails("Safes","XIGMATEK CYCLOPS BLACK 4x120mm FAN X-POWER 650W");
                            pcDetailsArrayList.add(pcDetails811);

                            PcDetails pcDetails821 = new PcDetails("Safes","COUGAR DARK BLADER-S RGB LEDLİ PANEL USB3.0 FullT ATX");
                            pcDetailsArrayList.add(pcDetails821);

                            PcDetails pcDetails813 = new PcDetails("Safes","ASUS ROG STRIX GX601 HELIOS 4x140mm FANLI USB3.1 MidT ATX");
                            pcDetailsArrayList.add(pcDetails813);

                            PcDetails pcDetails814 = new PcDetails("Safes","ASUS TUF GAMING GT501 3x120mm RGB");
                            pcDetailsArrayList.add(pcDetails814);

                            PcDetails pcDetails815 = new PcDetails("Safes","XIGMATEK LAMIYA 4x120mm X-POWER 650W 80PLUS MidT ATX");
                            pcDetailsArrayList.add(pcDetails815);

                            PcDetails pcDetails816 = new PcDetails("Safes","XIGMATEK COCKPIT MESH PANEL 4x120mm  X-POWER 700W 80PLUS MidT ATX ");
                            pcDetailsArrayList.add(pcDetails816);

                            PcDetails pcDetails817 = new PcDetails("Safes","XIGMATEK CYCLOPS 4x120mm FAN X-POWER 650W 80PLUS MidT ATX ");
                            pcDetailsArrayList.add(pcDetails817);

                            PcDetails pcDetails818 = new PcDetails("Safes","XIGMATEK CYCLOPS BLACK 4x120mm FAN X-POWER 650W");
                            pcDetailsArrayList.add(pcDetails818);

                            PcDetails pcDetails819 = new PcDetails("Safes","XIGMATEK HELIOS RAINBOW LEUSB 3.0 MidT ATX GAMING");
                            pcDetailsArrayList.add(pcDetails819);

                            PcDetails pcDetails901 = new PcDetails("Safes","FRISBY FC-8940G 650W 80 PLUS 2x200mm+1x120mm RGB ");
                            pcDetailsArrayList.add(pcDetails901);

                            PcDetails pcDetails911 = new PcDetails("Safes","FRISBY FC-8935G 650W 80 PLUS 4x120mm RAINBOW  MidT");
                            pcDetailsArrayList.add(pcDetails911);

                            PcDetails pcDetails912 = new PcDetails("Safes","FRISBY FC-8930G 650W 80 PLUS 3x120mm RAINBOW MESH");
                            pcDetailsArrayList.add(pcDetails912);

                            PcDetails pcDetails913 = new PcDetails("Safes","XIGMATEK AQUARIUS PLUS 7x120mm  USB3.0 TEMPER");
                            pcDetailsArrayList.add(pcDetails913);

                            PcDetails pcDetails914 = new PcDetails("Safes","COUGAR PURITAS RGB 3x120mm RGB USB3.0 MidT ATX");
                            pcDetailsArrayList.add(pcDetails914);

                            PcDetails pcDetails915 = new PcDetails("Safes","CORSAIR CARBIDE SERİSİ SPEC-05 550W 80PLUS MidT ATX ");
                            pcDetailsArrayList.add(pcDetails915);

                            PcDetails pcDetails7118 = new PcDetails("Safes","THERMALTAKE VERSA J25 650W 80PLUS RGB 3x120mm  MidT");
                            pcDetailsArrayList.add(pcDetails7118);

                            PcDetails pcDetails7119 = new PcDetails("Safes","THERMALTAKE VERSA J24 650W 80PLUS RGB 3x120mm  MidT");
                            pcDetailsArrayList.add(pcDetails7119);

                            PcDetails pcDetails870 = new PcDetails("Safes","XIGMATEK BEAST 4 x RGB  X-POWER 650W 80PLUS USB 3.0");
                            pcDetailsArrayList.add(pcDetails870);

                            PcDetails pcDetails871 = new PcDetails("Safes","COOLER MASTER MASTERBOX MB520 650W 80PLUS 3x120mm");
                            pcDetailsArrayList.add(pcDetails871);

                            PcDetails pcDetails872 = new PcDetails("Safes","COUGAR CGR-5NM1B-C MX350 700W 80 PLUS MidT ATX GAMING");
                            pcDetailsArrayList.add(pcDetails872);

                            PcDetails pcDetails873 = new PcDetails("Safes","THERMALTAKE PCI-e X16 Riser Cable");
                            pcDetailsArrayList.add(pcDetails873);

                            PcDetails pcDetails874 = new PcDetails("Safes","THERMALTAKE VIEW 27 600W 80PLUS ARGB 3x120mm MidT");
                            pcDetailsArrayList.add(pcDetails874);  
                                                                   
                            PcDetails pcDetails875 = new PcDetails("Safes","NZXT S340MB-GB Mid TOWER ATX ");
                            pcDetailsArrayList.add(pcDetails875);

                            PcDetails pcDetails876 = new PcDetails("Safes","NZXT S340MB-GR Mid TOWER ATX ");
                            pcDetailsArrayList.add(pcDetails876);  
                                                                   
                            PcDetails pcDetails877 = new PcDetails("Safes","NZXT S340W-TH ELITE SPECIAL EDITION Mid TOWER ATX ");
                            pcDetailsArrayList.add(pcDetails877);

                            PcDetails pcDetails878 = new PcDetails("Safes","NZXT S340W-B5 ELITE Mid TOWER ATX");
                            pcDetailsArrayList.add(pcDetails878);

                            PcDetails pcDetails879 = new PcDetails("Safes","NZXT S340W-B3 ELITE Mid TOWER ATX");
                            pcDetailsArrayList.add(pcDetails879);

                            PcDetails pcDetails970 = new PcDetails("Safes","COUGAR PANZER-G GAMING USB3.0 MidT ATX ");
                            pcDetailsArrayList.add(pcDetails970);

                            PcDetails pcDetails971 = new PcDetails("Safes","COUGAR PANZER MAX GAMING USB3.0 FullT ATX ");
                            pcDetailsArrayList.add(pcDetails971);

                            PcDetails pcDetails972 = new PcDetails("Safes","COUGAR CONQUER GAMING USB3.0 MidT ATX");
                            pcDetailsArrayList.add(pcDetails972);

                            PcDetails pcDetails973 = new PcDetails("Safes","RAMPAGE TEMPER PRO V5 4x120mm RGB FAN 6xRGB");
                            pcDetailsArrayList.add(pcDetails973);

                            PcDetails pcDetails974 = new PcDetails("Safes","XIGMATEK ZEST RAINBOW LED BAR USB3.0");
                            pcDetailsArrayList.add(pcDetails974);

                            PcDetails pcDetails975 = new PcDetails("Safes","COUGAR TURRET V2 700W 80 PLUS GAMING USB3.0 MidT ATX");
                            pcDetailsArrayList.add(pcDetails975);

                            PcDetails pcDetails931 = new PcDetails("Safes","THERMALTAKE LEVEL 20 MT ARGB 3x120mm  MidT");
                            pcDetailsArrayList.add(pcDetails931);

                            PcDetails pcDetails932 = new PcDetails("Safes","THERMALTAKE V200TG 3x120MM RGB MidT ATX GAMING");
                            pcDetailsArrayList.add(pcDetails932);

                            PcDetails pcDetails933 = new PcDetails("Safes","FRISBY GC-9250G GAMEMAX RAPTOR 650W USB 3.0MidT ATX");
                            pcDetailsArrayList.add(pcDetails933);

                            PcDetails pcDetails9332 = new PcDetails("Safes","COOLER MASTER MASTERBOX K500L 600W 80PLUS MidT ATX");
                            pcDetailsArrayList.add(pcDetails9332);

                            PcDetails pcDetails9333 = new PcDetails("Safes","FRISBY FC-8860G-650 650W USB 3.0 MidT GAMING ");
                            pcDetailsArrayList.add(pcDetails9333);

                            PcDetails pcDetails9334 = new PcDetails("Safes","FRISBY FC-8865G-650 650W MidT ATX");
                            pcDetailsArrayList.add(pcDetails9334);

                            PcDetails pcDetails9335 = new PcDetails("Safes","RAMPAGE CARBON 4x120mm RGB FAN USB 3.0 MidT ATX ");
                            pcDetailsArrayList.add(pcDetails9335);

                            PcDetails pcDetails933445 = new PcDetails("Safes","COOLER MASTER MASTERBOX LITE 5 600W 80PLUS MidT ATX");
                            pcDetailsArrayList.add(pcDetails933445);

                            PcDetails pcDetails93356 = new PcDetails("Safes","FRISBY FC-8870G 400W USB 3.0 MidT GAMING");
                            pcDetailsArrayList.add(pcDetails93356);





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
                            searchView = view.findViewById(R.id.searchView_Kasalar);
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
                            searchView = view.findViewById(R.id.searchView_Kasalar);
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