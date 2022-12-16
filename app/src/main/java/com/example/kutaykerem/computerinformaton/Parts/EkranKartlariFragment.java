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


public class EkranKartlariFragment extends Fragment{

    ArrayList<PcDetails> pcDetailsArrayList;

    AdaptorPcDetails adaptorPcDetails;
    RecyclerView recyclerView;
    private SearchView searchView;
    private Toolbar toolbar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ekran_kartlari, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        pcDetailsArrayList = new ArrayList<>();
        recyclerView = view.findViewById(R.id.recyclerViewEkranKartlari);

        searchView = view.findViewById(R.id.searchView_ekrankarti);
        toolbar = view.findViewById(R.id.toolbar_ekrankarti);
        ((AppCompatActivity) (getActivity())).setSupportActionBar(toolbar);
        ((AppCompatActivity) (getActivity())).getSupportActionBar().setDisplayShowTitleEnabled(false);







        PcDetails pcDetails2 = new PcDetails("Ekran Kartları","ASUS TUF GeForce GTX 1660 TI EVO OC 6GB GDDR6 192Bit DX12");
        PcDetails pcDetails3 = new PcDetails("Ekran Kartları","ASUS GeForce TUF RTX 3060 GAMING V2 OC 12GB GDDR6");
        PcDetails pcDetails22 = new PcDetails("Ekran Kartları","ASUS GeForce GT710 1GB GDDR5 32Bit Nvidia DX12 ");
        PcDetails pcDetails23 = new PcDetails("Ekran Kartları","ASUS GeForce TUF GTX 1650 GAMING OC 4GB GDDR6 128Bit");
        PcDetails pcDetails24 = new PcDetails("Ekran Kartları","ASUS GeForce TUF RTX 3080 GAMING OC 12GB GDDR6X 384Bit");
        PcDetails pcDetails27 = new PcDetails("Ekran Kartları","ASUS GeForce DUAL RTX 3060 OC V2 12GB GDDR6 192Bit NVIDIA");
        PcDetails pcDetails26 = new PcDetails("Ekran Kartları","ASUS GeForce TUF RTX 3080 Ti GAMING OC 12GB GDDR6X 384Bit");
        PcDetails pcDetails28 = new PcDetails("Ekran Kartları","ASUS GeForce TUF GTX 1650 4GD6 GAMING 4GB GDDR6 128Bit Nvidia");
        PcDetails pcDetails33 = new PcDetails("Ekran Kartları","ASUS GeForce TUF GTX 1660 SUPER GAMING OC 6GB GDDR6");
        PcDetails pcDetails25 = new PcDetails("Ekran Kartları","ASUS GeForce GTX 1660 SUPER EVO OC 6GB GDDR6 192Bit DX12");
        PcDetails pcDetails12 = new PcDetails("Ekran Kartları","ASUS GeForce GTX 1050 Ti CERBERUS OC 4GB GDDR5 128Bit");
        PcDetails pcDetails31 = new PcDetails("Ekran Kartları","Asus GeForce GT1030 GDDR5 OC 2GB 64Bit NVIDIA DX12 ");
        PcDetails pcDetails122 = new PcDetails("Ekran Kartları","Asus GeForce GT730 2GB GDDR5 64Bit NVIDIA DX12 ");
        PcDetails pcDetails29 = new PcDetails("Ekran Kartları","ASUS GeForce GTX 1050 TI CERBERUS 4GB GDDR5 128Bit");
        PcDetails pcDetails222 = new PcDetails("Ekran Kartları","ASUS GeForce TUF GTX 1650 4GD6-P GAMING 4GB GDDR6 128Bit Nvidia DX12");
        PcDetails pcDetails224 = new PcDetails("Ekran Kartları","ASUS GeForce TUF RTX 3090 GAMING OC 24GB GDDR6X 384Bit");
        PcDetails pcDetails225 = new PcDetails("Ekran Kartları","ASUS GeForce TUF GTX 1650 SUPER GAMING OC 4GB GDDR6");
        PcDetails pcDetails226 = new PcDetails("Ekran Kartları","Asus GeForce GT1030 GDDR5 2GB 64Bit NVIDIA DX12 ");
        PcDetails pcDetails227 = new PcDetails("Ekran Kartları","ASUS GeForce GTX1050 Ti GDDR5 4GB 128Bit NVIDIA ");
        PcDetails pcDetails228 = new PcDetails("Ekran Kartları","ASUS GeForce TUF-RTX3050-O8G-GAMING 8GB GDDR6 128Bit");
        PcDetails pcDetails32 = new PcDetails("Ekran Kartları","ASUS GeForce RTX 3080 NOCTUA 10GB OC GDDR6X 320Bit DX12");
        PcDetails pcDetails229 = new PcDetails("Ekran Kartları","ASUS GeForce DUAL RTX 3060 V2 12GB GDDR6 192Bit NVIDIA");
        PcDetails pcDetails332 = new PcDetails("Ekran Kartları","Asus GeForce GTX 1650 4GB GDDR5 128Bit DX12 Nvidia");
        PcDetails pcDetails223 = new PcDetails("Ekran Kartları","Asus GeForce GT730 SL-2GD5-BRK-E DDR5 2GB 64Bit NVIDIA DX12");
        PcDetails pcDetails123 = new PcDetails("Ekran Kartları","ASUS GeForce RTX 3070 8GB GDDR6 256Bit DX12 Nvidia ");
        PcDetails pcDetails552 = new PcDetails("Ekran Kartları","ASUS GeForce TUF GTX 1650 4GD6 GAMING OC 4GB GDDR6 128Bit");
        PcDetails pcDetails = new PcDetails("Ekran Kartları","ASUS GeForce TUF RTX 3090 TI GAMING OC 24GB GDDR6X 384Bit");
        PcDetails pcDetails662 = new PcDetails("Ekran Kartları","ASUS GeForce DUAL RTX 2060 EVO 12GB GDDR6 192Bit Nvidia ");
        PcDetails pcDetails622 = new PcDetails("Ekran Kartları","ASUS GeForce DUAL RTX 3050 8GB GDDR6 128Bit Nvidia ");
        PcDetails pcDetails612 = new PcDetails("Ekran Kartları","ASUS GeForce RTX 3050 Phoenix 8GB GDDR6 128Bit Nvidia");
        PcDetails pcDetails992 = new PcDetails("Ekran Kartları","ASUS GeForce RTX 3050 Phoenix 8GB GDDR6 128Bit Nvidia");
        PcDetails pcDetails62 = new PcDetails("Ekran Kartları","ASUS GeForce TUF GTX 1660 TI EVO 6GB GDDR6 192Bit DX12");
        PcDetails pcDetails772 = new PcDetails("Ekran Kartları","ASUS GeForce GT1030 DDR4 2GB 64Bit NVIDIA ");
        PcDetails pcDetails882 = new PcDetails("Ekran Kartları","ASUS GeForce ROG STRIX RTX 3070 GAMING V2 OC 8GB GDDR6");
        PcDetails pcDetails3324234 = new PcDetails("Ekran Kartlar","ASUS GeForce TUF RTX 3070 GAMING OC 8GB GDDR6 256Bit");
        PcDetails pcDetails642 = new PcDetails("Ekran Kartları","ASUS GeForce DUAL RTX 3060 Ti MIN OC 8GB GDDR6 256Bit DX12");
        PcDetails pcDetails442 = new PcDetails("Ekran Kartları","Asus GeForce GT730 DDR5 2GB 64Bit NVIDIA DX12 ");
        PcDetails pcDetails712 = new PcDetails("Ekran Kartları","ASUS GeForce DUAL RTX 3060 Ti OC 8GB GDDR6 256Bit DX12 Nvidia");
        PcDetails pcDetails652 = new PcDetails("Ekran Kartları","ASUS GeForce RTX 3060 Phoenix 12GB GDDR6 192Bit DX12 Nvidia");
        PcDetails pcDetails662222 = new PcDetails("Ekran Kartları","ASUS GeForce TUF RTX 3070 Ti GAMING OC 8GB GDDR6X 256Bit");
        PcDetails pcDetails752 = new PcDetails("Ekran Kartları","ASUS GeForce ROG STRIX RTX 3070 Ti GAMING OC 8GB GDDR6X");
        PcDetails pcDetails732 = new PcDetails("Ekran Kartları","ASUS GeForce RTX 3060 Phoenix 12GB GDDR6 192Bit DX12 Nvidia");
        PcDetails pcDetails742 = new PcDetails("Ekran Kartları","ASUS GeForce GTX 1650 Phoenix OC 4GB GDDR6 128Bit DX12 Nvidia");
        PcDetails pcDetails722 = new PcDetails("Ekran Kartları","ASUS GeForce ROG STRIX RTX 3090 GAMING OC 24GB GDDR6X");
        PcDetails pcDetails211 = new PcDetails("Ekran Kartları","ASUS GeForce TUF RTX 3090 GAMING 24GB GDDR6X 384Bit DX12 Nvidia ");
        PcDetails pcDetails782 = new PcDetails("Ekran Kartları","ASUS GeForce TUF GTX 1660 SUPER GAMING 6GB GDDR6 192Bit");
        PcDetails pcDetails718 = new PcDetails("Ekran Kartları","ASUS GeForce GT710 1GB GDDR5 32Bit Nvidia DX12");
        PcDetails pcDetails214 = new PcDetails("Ekran Kartları","ASUS GeForce GT710 2GB DDR5 64Bit Nvidia DX12 ");
        PcDetails pcDetails762 = new PcDetails("Ekran Kartları","ASUS GeForce GTX 1660 SUPER Phoenix OC 6GB DDR6 192Bit DX12");
        PcDetails pcDetails213 = new PcDetails("Ekran Kartları","ASUS GeForce GTX 1650 Phoenix OC 4GB GDDR5 128Bit DX12 Nvidia");
        PcDetails pcDetails216 = new PcDetails("Ekran Kartları","ASUS GeForce DUAL GTX1650 4GB GDDR5 128Bit DX12 Nvidia ");
        PcDetails pcDetails212 = new PcDetails("Ekran Kartları","ASUS GeForce DUAL GTX 1650 OC 4GB GDDR5 128Bit DX12 Nvidia");
        PcDetails pcDetails217 = new PcDetails("Ekran Kartları","ASUS GeForce GT1030 GDDR5 2GB 64Bit NVIDIA ");
        PcDetails pcDetails215 = new PcDetails("Ekran Kartları","EVGA GeForce RTX 3090 FTW3 ULTRA GAMING 24GB GDDR6X");
        PcDetails pcDetails02 = new PcDetails("Ekran Kartları","EVGA RTX 3080 XC3 ULTRA GAMING 12GB GDDR6X RGB LED");
        PcDetails pcDetails219 = new PcDetails("Ekran Kartları","EVGA GeForce RTX 3070 FTW3 ULTRA GAMING 8GB GDDR6 256Bit");
        PcDetails pcDetails218 = new PcDetails("Ekran Kartları","EVGA GeForce GTX 1660 SC ULTRA GAMING 6GB GDDR5 192Bit Nvidia");
        PcDetails pcDetails2222 = new PcDetails("Ekran Kartları","EVGA GeForce RTX 3050 XC GAMING 8GB GDDR6 128Bit Nvidia");
        PcDetails pcDetails1112 = new PcDetails("Ekran Kartları","EVGA GeForce RTX 3090 Ti FTW3 ULTRA GAMING 24GB GDDR6X");
        PcDetails pcDetails4442 = new PcDetails("Ekran Kartları","EVGA GeForce RTX 3080 Ti FTW3 ULTRA GAMING 12GB GDDR6X");
        PcDetails pcDetails632 = new PcDetails("Ekran Kartları","EVGA GeForce GTX 1660 SUPER SC ULTRA GAMING 6GB GDDR6");
        PcDetails pcDetails3332 = new PcDetails("Ekran Kartları","EVGA RTX 3090 Ti FTW3 BLACK GAMING 24GB GDDR6X ARGB ");
        PcDetails pcDetails7772 = new PcDetails("Ekran Kartları","EVGA RTX 3080 FTW3 ULTRA GAMING 12GB GDDR6X ARGB");
        PcDetails pcDetails6662 = new PcDetails("Ekran Kartları","EVGA GeForce RTX 2060 SC OVERCLOCKED 6GB GDDR6 192 bit Nvidia");
        PcDetails pcDetails2111 = new PcDetails("Ekran Kartları","EVGA GeForce RTX 3090 Ti FTW3 GAMING 24GB GDDR6X 384Bit");
        PcDetails pcDetails5552 = new PcDetails("Ekran Kartları","EVGA GeForce RTX 3090 XC3 ULTRA GAMING 24GB GDDR6X 384Bit ARGB ");
        PcDetails pcDetails9992 = new PcDetails("Ekran Kartları","EVGA GeForce RTX 3080 Ti XC3 ULTRA GAMING 12GB GDDR6X");
        PcDetails pcDetails0002 = new PcDetails("Ekran Kartları","EVGA GeForce RTX 3080 FTW3 ULTRA GAMING 10GB GDDR6X");
        PcDetails pcDetails8882 = new PcDetails("Ekran Kartları","GIGABYTE GeForce GTX 1660 TI OC 6GB GDDR6 192Bit DX12 Nvidia");
        PcDetails pcDetails2555 = new PcDetails("Ekran Kartları","GIGABYTE GeForce RTX 3090 Ti GAMING 24G 24GB GDDR6X 384 Bit");
        PcDetails pcDetails2445 = new PcDetails("Ekran Kartları","GIGABYTE GEFORCE RTX 2060 GAMING OC 12GB GDDR6 192Bit");
        PcDetails pcDetails2888 = new PcDetails("Ekran Kartları","GIGABYTE GEFORCE RTX 3080 GAMING OC 12GB GDDR6X 384Bit");
        PcDetails pcDetails2666 = new PcDetails("Ekran Kartları","GIGABYTE GeForce RTX 3070 Ti MASTER 8GB GDDR6X 256Bit");
        PcDetails pcDetails2444 = new PcDetails("Ekran Kartları","GIGABYTE GeForce RTX 3080 Ti EAGLE OC 12GB GDDR6X 384Bit");
        PcDetails pcDetails2777 = new PcDetails("Ekran Kartları","GIGABYTE GeForce RTX 3070 Ti GAMING OC 8GB GDDR6X 256Bit");
        PcDetails pcDetails2999 = new PcDetails("Ekran Kartları","GIGABYTE GeForce RTX 3080 Ti GAMING OC 12GB GDDR6X 384Bit");
        PcDetails pcDetails21111 = new PcDetails("Ekran Kartları","GIGABYTE GeForce RTX 3090 GAMING OC 24GB GDDR6X 384Bit");
        PcDetails pcDetails24444 = new PcDetails("Ekran Kartları","GIGABYTE GeForce RTX 3070 AORUS MASTER 8GB GDDR6");
        PcDetails pcDetails23333 = new PcDetails("Ekran Kartları","GIGABYTE GeForce RTX 3080 GAMING OC 10GB GDDR6X 320Bit");
        PcDetails pcDetails25555 = new PcDetails("Ekran Kartları","GIGABYTE GeForce GTX 1660 SUPER OC 6GB GDDR6 192Bit");
        PcDetails pcDetails29999 = new PcDetails("Ekran Kartları","GIGABYTE GeForce RTX 3080 Ti GAMING OC 12GB GDDR6X 384Bit");
        PcDetails pcDetails26666 = new PcDetails("Ekran Kartları","ZOTAC GeForce RTX 3060 TWIN EDGE GAMING OC 12GB GDDR6");
        PcDetails pcDetails22222 = new PcDetails("Ekran Kartları","ZOTAC GeForce RTX 3080 GAMING TRINTY OC 10GB GDDR6X");
        PcDetails pcDetails27777 = new PcDetails("Ekran Kartları","ZOTAC GeForce RTX 3070 TWIN EDGE GAMINGOC 8GB GDDR6");
        PcDetails pcDetails00002 = new PcDetails("Ekran Kartları","ZOTAC GeForce RTX 3060 Ti TWINEDGE GAMING 8GB GDDR6");
        PcDetails pcDetails21000 = new PcDetails("Ekran Kartları","ZOTAC GeForce RTX 3080 Ti GAMING AMP HOLO 12GB GDDR6X");
        PcDetails pcDetails2177 = new PcDetails("Ekran Kartları","ZOTAC GeForce RTX 3080 Ti GAMING TRINTY OC 12GB GDDR6X");
        PcDetails pcDetails28888 = new PcDetails("Ekran Kartları","ZOTAC GTX 1660 Super GDDR6 6GB 192Bit Nvidia GeForce DX12 ");
        PcDetails pcDetails21234 = new PcDetails("Ekran Kartları","GIGABYTE GeForce RTX 3080 GAMING OC 10GB GDDR6X 320Bit");
        PcDetails pcDetails00003 = new PcDetails("Ekran Kartları","GIGABYTE GeForce GTX 1660 SUPER OC 6GB GDDR6 192Bit");
        PcDetails pcDetails212345 = new PcDetails("Ekran Kartları","GIGABYTE GeForce RTX 3080 Ti GAMING OC 12GB GDDR6X 384Bit");
        PcDetails pcDetails2333 = new PcDetails("Ekran Kartları","ASUS RADEON DUAL RX 6600-8G 8GB 128Bit AMD ");
        PcDetails pcDetails2123456 = new PcDetails("Ekran Kartlar","ASUS RADEON DUAL RX 6400 4GB GDDR6 64Bit AMD  ");
        PcDetails pcDetails212345678 = new PcDetails("Ekran Kartl","ASUS RADEON DUAL RX 6500 XT OC 4GB GDDR6 64Bit AMD ");
        PcDetails pcDetails2234 = new PcDetails("Ekran Kartları","ASUS Radeon ROG STRIX RX560 GAMING 4GB GDDR5 128 Bit AMD");
        PcDetails pcDetails21234567 = new PcDetails("Ekran Kartla","ASUS ROG STRIX Radeon RX 6650 XT OC ARGB 8GB GDDR6 128 Bit ");
        PcDetails pcDetails2236 = new PcDetails("Ekran Kartları","ASUS TUF GAMING Radeon RX 6950 XT OC Edition 16GB GDDR6");
        PcDetails pcDetails2235 = new PcDetails("Ekran Kartları","ASUS RADEON DUAL RX 6650 XT OC 8GB GDRR6 128Bit AMD ");
        PcDetails pcDetails2123 = new PcDetails("Ekran Kartları","ASUS RADEON DUAL RX 6750 XT OC 12GB GDDR6 192Bit AMD");
        PcDetails pcDetails2233 = new PcDetails("Ekran Kartları","ASUS RADEON ROG STRIX RX 6750 XT OC GAMING 12GB GDDR6");
        PcDetails pcDetails2237 = new PcDetails("Ekran Kartları","ASUS RADEON RX560 DUAL 4GB GDDR5 128 Bit AMD");
        PcDetails pcDetails2224 = new PcDetails("Ekran Kartları","ASUS RADEON RX 6400 4GB GDDR6 64Bit AMD ");
        PcDetails pcDetails258 = new PcDetails("Ekran Kartları","ASUS RADEON 550 Phoenix 2GB GDDR5 64Bit AMD ");
        PcDetails pcDetails260 = new PcDetails("Ekran Kartları","ASUS RADEON TUF RX 6500 XT GAMING OC 4GB GDDR6 64Bit AMD");
        PcDetails pcDetails2132 = new PcDetails("Ekran Kartları","ASUS RADEON ROG STRIX RX 6600 XT OC GAMING 8GB GDDR6");
        PcDetails pcDetails259 = new PcDetails("Ekran Kartları","ASUS RADEON DUAL RX 6600 XT OC 8GB GDDR6 128Bit AMD ");
        PcDetails pcDetails263 = new PcDetails("Ekran Kartları","ASUS RADEON TUF RX 6800 GAMING OC 16GB GDDR6 256Bit");
        PcDetails pcDetails262 = new PcDetails("Ekran Kartları","ASUS RADEON TUF RX 6800 XT OC 16GB GAMING GDDR6 256Bit DX12");
        PcDetails pcDetails257 = new PcDetails("Ekran Kartları","ASUS RADEON RX 550 4G EVO Phoenix 4G GDD5 128bit DX12 AMD");
        PcDetails pcDetails261 = new PcDetails("Ekran Kartları","MSI RADEON RX 6800 XT GAMING Z TRIO 16GB GDDR6 256bit AMD");
        PcDetails pcDetails2238 = new PcDetails("Ekran Kartları","MSI RADEON RX 6600 ARMOR 8G 8GB GDDR6 128Bit AMD ");
        PcDetails pcDetails266 = new PcDetails("Ekran Kartları","MSI RADEON RX 6700 XT MECH 2X 12GB GDDR6 192Bit AMD ");
        PcDetails pcDetails267 = new PcDetails("Ekran Kartları","MSI RADEON RX 6500 XT MECH 2X 4G OC GDDR6 64bit DX12 AMD");
        PcDetails pcDetails268 = new PcDetails("Ekran Kartları","MSI RADEON RX 6900 XT GAMING Z TRIO 16GB GDDR6 256bit AMD");
        PcDetails pcDetails265 = new PcDetails("Ekran Kartları","MSI RADEON RX 6800 GAMING X TRIO 16GB GDDR6 256bit AMD");
        PcDetails pcDetails270 = new PcDetails("Ekran Kartları","MSI RADEON RX 6750 XT GAMING X TRIO 12G GDDR6 192Bit AMD");
        PcDetails pcDetails264 = new PcDetails("Ekran Kartları","MSI RADEON RX 6750 XT MECH 2X 12G OC GDDR6 192Bit AMD ");
        PcDetails pcDetails269 = new PcDetails("Ekran Kartları","MSI RADEON RX 6650 XT MECH 2X OC 8GB GDDR6 128 Bit AMD");
        PcDetails pcDetails274 = new PcDetails("Ekran Kartları","MSI RADEON RX 6400 AERO ITX 4GB GDDR6 64 Bit AMD");
        PcDetails pcDetails275 = new PcDetails("Ekran Kartları","MSI RADEON RX 6950 XT GAMING TRIO 16GB GDDR6 256 Bit AMD");
        PcDetails pcDetails272 = new PcDetails("Ekran Kartları","MSI RADEON RX 6600 XT MECH 2X 8G OC GDDR6 128Bit AMD");
        PcDetails pcDetails277 = new PcDetails("Ekran Kartları","MSI RADEON RX 6600 XT GAMING X 8GB GDDR6 128Bit AMD ");
        PcDetails pcDetails278 = new PcDetails("Ekran Kartları","MSI RADEON RX 6700 XT MECH 2X 12G OC GDDR6 192Bit AMD");
        PcDetails pcDetails276 = new PcDetails("Ekran Kartları","MSI RADEON RX 6700 XT GAMING X 12GB GDDR6 192Bit AMD");
        PcDetails pcDetails271 = new PcDetails("Ekran Kartları","MSI RADEON RX 6800 XT GAMING X TRIO 16GB GDDR6 256bit AMD");
        PcDetails pcDetails273 = new PcDetails("Ekran Kartları","GIGABYTE RADEON RX 6600 XT EAGLE 8GB GDDR6 128Bit AMD");
        PcDetails pcDetails252 = new PcDetails("Ekran Kartları","GIGABYTE RADEON RX 6800 GAMING OC 16GB GDDR6 256Bit");
        PcDetails pcDetails253 = new PcDetails("Ekran Kartları","GIGABYTE RADEON RX 6700 XT GAMING OC 12GB GDDR6 192Bit");
        PcDetails pcDetails254 = new PcDetails("Ekran Kartları","MSI GEFORCE RTX 3060 VENTUS 2X OC 12GB GDDR6 192bit NVIDIA");
        PcDetails pcDetails256 = new PcDetails("Ekran Kartları","MSI GEFORCE RTX 3090 TI SUPRIM X 24GB GDDR6X 384bit");
        PcDetails pcDetails251 = new PcDetails("Ekran Kartları","MSI GEFORCE GTX 1650 4GT LP OC 4GB GDDR5 128bit NVIDIA");
        PcDetails pcDetails2588 = new PcDetails("Ekran Kartları","MSI GEFORCE RTX 2060 VENTUS 12G OC 12GB GDDR6 192bit NVIDIA");
        PcDetails pcDetails2577 = new PcDetails("Ekran Kartları","MSI GEFORCE GTX 1660 SUPER GAMING X 6GB GDDR6 192bit");
        PcDetails pcDetails2332 = new PcDetails("Ekran Kartları","MSI GEFORCE RTX 3050 GAMING X 8G GDDR6 128Bit NVIDIA ");
        PcDetails pcDetails233 = new PcDetails("Ekran Kartları","MSI GEFORCE RTX 3050 VENTUS 2X 8GB GDDR6 128Bit NVIDIA ");
        PcDetails pcDetails234 = new PcDetails("Ekran Kartları","MSI GEFORCE RTX 3060 TI GAMING Z TRIO 8GB LHR GDDR6 256bit NVIDIA ");
        PcDetails pcDetails2559 = new PcDetails("Ekran Kartları","MSI GEFORCE RTX 2060 VENTUS GP OC 6GB GDDR6 192Bit NVIDIA");
        PcDetails pcDetails235 = new PcDetails("Ekran Kartları","MSI GEFORCE GTX 1650 VENTUS XS 4G OC 4GB GDDR5 128bit");
        PcDetails pcDetails255 = new PcDetails("Ekran Kartları","MSI GEFORCE GTX 1050 TI 4GT LP 4GB GDDR5 128bit NVIDIA");
        PcDetails pcDetails237 = new PcDetails("Ekran Kartları","MSI GEFORCE RTX 3060 AERO ITX 12G OC 12GB GDDR6 192Bit");
        PcDetails pcDetails240 = new PcDetails("Ekran Kartları","MSI GEFORCE RTX 3090 TI GAMING X TRIO 24G 24GB GDDR6X 384Bit NVIDIA ");
        PcDetails pcDetails241 = new PcDetails("Ekran Kartları","MSI GEFORCE RTX 3060 GAMING Z TRIO 12GB GDDR6 192bit NVIDIA");
        PcDetails pcDetails238 = new PcDetails("Ekran Kartları","MSI GEFORCE RTX 3080 TI GAMING X TRIO 12GB GDDR6X");
        PcDetails pcDetails243 = new PcDetails("Ekran Kartları","MSI GEFORCE GTX 1660 SUPER VENTUS XS OC 6GB GDDR6 192bit");
        PcDetails pcDetails244 = new PcDetails("Ekran Kartları","MSI GEFORCE GT 710 1GD3H LP 1GB DDR3 64bit NVIDIA ");
        PcDetails pcDetails245 = new PcDetails("Ekran Kartları","MSI GEFORCE RTX 2060 VENTUS GP 6GB GDDR6 192Bit NVIDIA");
        PcDetails pcDetails242 = new PcDetails("Ekran Kartları","MSI GEFORCE RTX 3080 VENTUS 3X PLUS 10G LHR GDDR6X 320Bit");
        PcDetails pcDetails239 = new PcDetails("Ekran Kartları","MSI GeForce RTX 3070 SUPRIM 8GB GDDR6 256 Bit LHR ");
        PcDetails pcDetails236 = new PcDetails("Ekran Kartları","MSI GeForce GTX 1650 D6 AERO ITX OCV1 4GB GDDR6 128 Bit");
        PcDetails pcDetails247 = new PcDetails("Ekran Kartları","MSI GEFORCE RTX 3090 TI BLACK TRIO 24GB GDDR6X 384 Bit NVIDIA ");
        PcDetails pcDetails249 = new PcDetails("Ekran Kartları","MSI GEFORCE GTX 1650 D6 AERO ITX 4G OC GDDR6 128bit NVIDIA");
        PcDetails pcDetails281 = new PcDetails("Ekran Kartları","MSI GEFORCE GT 730 2GD3 LP 2GB DDR3 64Bit NVIDIA ");
        PcDetails pcDetails283 = new PcDetails("Ekran Kartları","MSI GEFORCE RTX 3050 VENTUS 2X 8GB OC GDDR6 128Bit NVIDIA");
        PcDetails pcDetails284 = new PcDetails("Ekran Kartları","MSI GEFORCE RTX 3080 GAMING Z TRIO 12G LHR GDDR6X 384Bit");
        PcDetails pcDetails280 = new PcDetails("Ekran Kartları","MSI GEFORCE RTX 3080 VENTUS 3X PLUS 12G OC LHR GDDR6X");
        PcDetails pcDetails248 = new PcDetails("Ekran Kartları","MSI GEFORCE RTX 3080 VENTUS 3X PLUS 10G OC LHR GDDR6X");
        PcDetails pcDetails285 = new PcDetails("Ekran Kartları","MSI GEFORCE GT 730 2GD3H LP 2GB DDR3 64bit NVIDIA ");
        PcDetails pcDetails286 = new PcDetails("Ekran Kartları","MSI GEFORCE RTX 3050 AERO ITX 8G OC GDDR6 128Bit NVIDIA ");
        PcDetails pcDetails282 = new PcDetails("Ekran Kartları","MSI GEFORCE RTX 3070 VENTUS 3X OC LHR 8GB GDDR6 256Bit NVIDIA ");
        PcDetails pcDetails287 = new PcDetails("Ekran Kartları","MSI GEFORCE RTX 3050 AERO ITX 8GB GDDR6 128Bit NVIDIA ");
        PcDetails pcDetails292 = new PcDetails("Ekran Kartları","MSI GEFORCE RTX 3060 TI VENTUS 3X OC LHR 8GB GDDR6");
        PcDetails pcDetails289 = new PcDetails("Ekran Kartları","MSI GEFORCE RTX 3070 GAMING Z TRIO 8G LHR 8GB GDDR6 256bit");
        PcDetails pcDetails288 = new PcDetails("Ekran Kartları","MSI GEFORCE RTX 3070 VENTUS 2X 8G OC LHR 8GB GDDR6 256bit");
        PcDetails pcDetails246 = new PcDetails("Ekran Kartları","MSI GEFORCE RTX 3080 SUPRIM X LHR 10GB GDDR6X 320bit NVIDIA");
        PcDetails pcDetails290 = new PcDetails("Ekran Kartları","MSI GEFORCE RTX 3080 TI VENTUS 3X 12GB GDDR6X 384Bit");
        PcDetails pcDetails293 = new PcDetails("Ekran Kartları","MSI GEFORCE RTX 3070 SUPRIM X 8G LHR GDDR6 256bit NVIDIA");
        PcDetails pcDetails291 = new PcDetails("Ekran Kartları","MSI GEFORCE RTX 3060 TI GAMING X LHR 8GB GDDR6 256Bit");
        PcDetails pcDetails296 = new PcDetails("Ekran Kartları","MSI GEFORCE RTX 3060 TI VENTUS 2X 8G OCV1 LHR GDDR6");
        PcDetails pcDetails297 = new PcDetails("Ekran Kartları","MSI GEFORCE GT 730 4GB DDR3 64Bit NVIDIA ");
        PcDetails pcDetails299 = new PcDetails("Ekran Kartları","MSI GEFORCE RTX 3080 GAMING Z TRIO 10G LHR GDDR6X 320Bit");
        PcDetails pcDetails295 = new PcDetails("Ekran Kartları","MSI GEFORCE RTX 3070 TI GAMING X TRIO 8GB GDDR6X");
        PcDetails pcDetails33332 = new PcDetails("Ekran Kartları","MSI GEFORCE RTX 3070 TI SUPRIM X 8GB GDDR6X 256bit");
        PcDetails pcDetails298 = new PcDetails("Ekran Kartları","MSI GEFORCE RTX 3080 TI VENTUS 3X 12G OC GDDR6X");
        PcDetails pcDetails44452 = new PcDetails("Ekran Kartları","MSI GEFORCE RTX 3080 TI SUPRIM X 12GB GDDR6X 384Bit");
        PcDetails pcDetails55552 = new PcDetails("Ekran Kartları","MSI GEFORCE GT 710 2GD3H H2D 2GB DDR3 64Bit NVIDIA ");
        PcDetails pcDetails01002 = new PcDetails("Ekran Kartları","MSI GEFORCE RTX 3060 VENTUS 3X 12G OC 12GB GDDR6 192Bit");
        PcDetails pcDetails72 = new PcDetails("Ekran Kartları","MSI GEFORCE RTX 3060 GAMING X 12GB GDDR6 192bit NVIDIA");
        PcDetails pcDetails66662 = new PcDetails("Ekran Kartları","MSI GEFORCE RTX 3090 GAMING X TRIO 24G 24GB GDDR6X 384Bit");
        PcDetails pcDetails82 = new PcDetails("Ekran Kartları","MSI GEFORCE GTX 1660 SUPER GAMING 6GB GDDR6 192bit NVIDIA");
        PcDetails pcDetails92 = new PcDetails("Ekran Kartları","MSI GEFORCE GTX 1660 VENTUS XS 6G OC 6GB GDDR5 192bit NVIDIA");
        PcDetails pcDetails3322 = new PcDetails("Ekran Kartları","MSI GEFORCE GTX 1660 TI VENTUS XS 6G OC 6GB GDDR6");
        PcDetails pcDetails13252 = new PcDetails("Ekran Kartları","MSI GEFORCE GTX 1660 TI VENTUS XS 6G 6GB GDDR6 192bit");
        PcDetails pcDetails294 = new PcDetails("Ekran Kartları","MSI GEFORCE GTX 1660 TI ARMOR 6G OC 6GB GDDR6 192bit NVIDIA");
        PcDetails pcDetails2196 = new PcDetails("Ekran Kartları","MSI GEFORCE GT 1030 2GHD4 LP OC 2GB DDR4 64bit NVIDIA ");
        PcDetails pcDetails2198 = new PcDetails("Ekran Kartları","MSI GEFORCE GTX 1050 TI AERO ITX 4G OCV1 4GB GDDR5 128bit");
        PcDetails pcDetails2197 = new PcDetails("Ekran Kartları","MSI N730-2GD3V2 2GB DDR3 128bit NVIDIA");





        pcDetailsArrayList.add(pcDetails2198);
        pcDetailsArrayList.add(pcDetails2197);
        pcDetailsArrayList.add(pcDetails2196);
        pcDetailsArrayList.add(pcDetails294);
        pcDetailsArrayList.add(pcDetails295);
        pcDetailsArrayList.add(pcDetails296);
        pcDetailsArrayList.add(pcDetails297);
        pcDetailsArrayList.add(pcDetails298);
        pcDetailsArrayList.add(pcDetails299);
        pcDetailsArrayList.add(pcDetails33332);
        pcDetailsArrayList.add(pcDetails3322);
        pcDetailsArrayList.add(pcDetails44452);
        pcDetailsArrayList.add(pcDetails55552);
        pcDetailsArrayList.add(pcDetails66662);
        pcDetailsArrayList.add(pcDetails01002);
        pcDetailsArrayList.add(pcDetails72);
        pcDetailsArrayList.add(pcDetails82);
        pcDetailsArrayList.add(pcDetails92);
        pcDetailsArrayList.add(pcDetails13252);
        pcDetailsArrayList.add(pcDetails246);
        pcDetailsArrayList.add(pcDetails248);
        pcDetailsArrayList.add(pcDetails247);
        pcDetailsArrayList.add(pcDetails249);
        pcDetailsArrayList.add(pcDetails280);
        pcDetailsArrayList.add(pcDetails281);
        pcDetailsArrayList.add(pcDetails282);
        pcDetailsArrayList.add(pcDetails283);
        pcDetailsArrayList.add(pcDetails284);
        pcDetailsArrayList.add(pcDetails285);
        pcDetailsArrayList.add(pcDetails286);
        pcDetailsArrayList.add(pcDetails287);
        pcDetailsArrayList.add(pcDetails288);
        pcDetailsArrayList.add(pcDetails289);
        pcDetailsArrayList.add(pcDetails290);
        pcDetailsArrayList.add(pcDetails291);
        pcDetailsArrayList.add(pcDetails292);
        pcDetailsArrayList.add(pcDetails293);
        pcDetailsArrayList.add(pcDetails236);
        pcDetailsArrayList.add(pcDetails237);
        pcDetailsArrayList.add(pcDetails238);
        pcDetailsArrayList.add(pcDetails239);
        pcDetailsArrayList.add(pcDetails241);
        pcDetailsArrayList.add(pcDetails240);
        pcDetailsArrayList.add(pcDetails242);
        pcDetailsArrayList.add(pcDetails243);
        pcDetailsArrayList.add(pcDetails244);
        pcDetailsArrayList.add(pcDetails245);
        pcDetailsArrayList.add(pcDetails251);
        pcDetailsArrayList.add(pcDetails252);
        pcDetailsArrayList.add(pcDetails253);
        pcDetailsArrayList.add(pcDetails254);
        pcDetailsArrayList.add(pcDetails255);
        pcDetailsArrayList.add(pcDetails256);
        pcDetailsArrayList.add(pcDetails2577);
        pcDetailsArrayList.add(pcDetails2588);
        pcDetailsArrayList.add(pcDetails2559);
        pcDetailsArrayList.add(pcDetails2332);
        pcDetailsArrayList.add(pcDetails233);
        pcDetailsArrayList.add(pcDetails234);
        pcDetailsArrayList.add(pcDetails235);
        pcDetailsArrayList.add(pcDetails264);
        pcDetailsArrayList.add(pcDetails265);
        pcDetailsArrayList.add(pcDetails266);
        pcDetailsArrayList.add(pcDetails267);
        pcDetailsArrayList.add(pcDetails268);
        pcDetailsArrayList.add(pcDetails269);
        pcDetailsArrayList.add(pcDetails270);
        pcDetailsArrayList.add(pcDetails271);
        pcDetailsArrayList.add(pcDetails272);
        pcDetailsArrayList.add(pcDetails273);
        pcDetailsArrayList.add(pcDetails274);
        pcDetailsArrayList.add(pcDetails275);
        pcDetailsArrayList.add(pcDetails276);
        pcDetailsArrayList.add(pcDetails277);
        pcDetailsArrayList.add(pcDetails278);
        pcDetailsArrayList.add(pcDetails2238);
        pcDetailsArrayList.add(pcDetails2132);
        pcDetailsArrayList.add(pcDetails257);
        pcDetailsArrayList.add(pcDetails258);
        pcDetailsArrayList.add(pcDetails259);
        pcDetailsArrayList.add(pcDetails260);
        pcDetailsArrayList.add(pcDetails261);
        pcDetailsArrayList.add(pcDetails262);
        pcDetailsArrayList.add(pcDetails263);
        pcDetailsArrayList.add(pcDetails2224);
        pcDetailsArrayList.add(pcDetails2333);
        pcDetailsArrayList.add(pcDetails2444);
        pcDetailsArrayList.add(pcDetails2445);
        pcDetailsArrayList.add(pcDetails2555);
        pcDetailsArrayList.add(pcDetails2666);
        pcDetailsArrayList.add(pcDetails2777);
        pcDetailsArrayList.add(pcDetails2888);
        pcDetailsArrayList.add(pcDetails2999);
        pcDetailsArrayList.add(pcDetails21111);
        pcDetailsArrayList.add(pcDetails22222);
        pcDetailsArrayList.add(pcDetails23333);
        pcDetailsArrayList.add(pcDetails24444);
        pcDetailsArrayList.add(pcDetails25555);
        pcDetailsArrayList.add(pcDetails26666);
        pcDetailsArrayList.add(pcDetails27777);
        pcDetailsArrayList.add(pcDetails28888);
        pcDetailsArrayList.add(pcDetails29999);
        pcDetailsArrayList.add(pcDetails21000);
        pcDetailsArrayList.add(pcDetails00002);
        pcDetailsArrayList.add(pcDetails00003);
        pcDetailsArrayList.add(pcDetails2177);
        pcDetailsArrayList.add(pcDetails2123);
        pcDetailsArrayList.add(pcDetails21234);
        pcDetailsArrayList.add(pcDetails212345);
        pcDetailsArrayList.add(pcDetails2123456);
        pcDetailsArrayList.add(pcDetails21234567);
        pcDetailsArrayList.add(pcDetails212345678);
        pcDetailsArrayList.add(pcDetails2233);
        pcDetailsArrayList.add(pcDetails2234);
        pcDetailsArrayList.add(pcDetails2235);
        pcDetailsArrayList.add(pcDetails2236);
        pcDetailsArrayList.add(pcDetails2237);
        pcDetailsArrayList.add(pcDetails);
        pcDetailsArrayList.add(pcDetails2);
        pcDetailsArrayList.add(pcDetails3);
        pcDetailsArrayList.add(pcDetails22);
        pcDetailsArrayList.add(pcDetails23);
        pcDetailsArrayList.add(pcDetails24);
        pcDetailsArrayList.add(pcDetails25);
        pcDetailsArrayList.add(pcDetails26);
        pcDetailsArrayList.add(pcDetails27);
        pcDetailsArrayList.add(pcDetails28);
        pcDetailsArrayList.add(pcDetails29);
        pcDetailsArrayList.add(pcDetails32);
        pcDetailsArrayList.add(pcDetails3324234);
        pcDetailsArrayList.add(pcDetails31);
        pcDetailsArrayList.add(pcDetails33);
        pcDetailsArrayList.add(pcDetails12);
        pcDetailsArrayList.add(pcDetails122);
        pcDetailsArrayList.add(pcDetails222);
        pcDetailsArrayList.add(pcDetails223);
        pcDetailsArrayList.add(pcDetails224);
        pcDetailsArrayList.add(pcDetails225);
        pcDetailsArrayList.add(pcDetails226);
        pcDetailsArrayList.add(pcDetails227);
        pcDetailsArrayList.add(pcDetails228);
        pcDetailsArrayList.add(pcDetails229);
        pcDetailsArrayList.add(pcDetails123);
        pcDetailsArrayList.add(pcDetails332);
        pcDetailsArrayList.add(pcDetails442);
        pcDetailsArrayList.add(pcDetails552);
        pcDetailsArrayList.add(pcDetails662);
        pcDetailsArrayList.add(pcDetails772);
        pcDetailsArrayList.add(pcDetails882);
        pcDetailsArrayList.add(pcDetails992);
        pcDetailsArrayList.add(pcDetails62);
        pcDetailsArrayList.add(pcDetails612);
        pcDetailsArrayList.add(pcDetails622);
        pcDetailsArrayList.add(pcDetails632);
        pcDetailsArrayList.add(pcDetails642);
        pcDetailsArrayList.add(pcDetails652);
        pcDetailsArrayList.add(pcDetails662222);
        pcDetailsArrayList.add(pcDetails712);
        pcDetailsArrayList.add(pcDetails722);
        pcDetailsArrayList.add(pcDetails732);
        pcDetailsArrayList.add(pcDetails742);
        pcDetailsArrayList.add(pcDetails752);
        pcDetailsArrayList.add(pcDetails762);
        pcDetailsArrayList.add(pcDetails718);
        pcDetailsArrayList.add(pcDetails782);
        pcDetailsArrayList.add(pcDetails211);
        pcDetailsArrayList.add(pcDetails212);
        pcDetailsArrayList.add(pcDetails213);
        pcDetailsArrayList.add(pcDetails214);
        pcDetailsArrayList.add(pcDetails215);
        pcDetailsArrayList.add(pcDetails216);
        pcDetailsArrayList.add(pcDetails217);
        pcDetailsArrayList.add(pcDetails218);
        pcDetailsArrayList.add(pcDetails219);
        pcDetailsArrayList.add(pcDetails02);
        pcDetailsArrayList.add(pcDetails1112);
        pcDetailsArrayList.add(pcDetails2222);
        pcDetailsArrayList.add(pcDetails3332);
        pcDetailsArrayList.add(pcDetails4442);
        pcDetailsArrayList.add(pcDetails5552);
        pcDetailsArrayList.add(pcDetails6662);
        pcDetailsArrayList.add(pcDetails7772);
        pcDetailsArrayList.add(pcDetails8882);
        pcDetailsArrayList.add(pcDetails9992);
        pcDetailsArrayList.add(pcDetails0002);
        pcDetailsArrayList.add(pcDetails2111);













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
                            searchView = view.findViewById(R.id.searchView_ekrankarti);
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
                            searchView = view.findViewById(R.id.searchView_ekrankarti);
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