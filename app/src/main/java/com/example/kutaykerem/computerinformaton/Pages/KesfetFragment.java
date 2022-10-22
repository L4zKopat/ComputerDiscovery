package com.example.kutaykerem.computerinformaton.Pages;


import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.MenuItemCompat;

import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import androidx.fragment.app.Fragment;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.SearchView;
import android.widget.Toast;
import com.example.kutaykerem.computerinformaton.Adaptor.Kesfet.KesfetAdaptor;
import com.example.kutaykerem.computerinformaton.Models.KesfetDetails;
import com.example.kutaykerem.computerinformaton.R;
import com.example.kutaykerem.computerinformaton.databinding.FragmentKesfetBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Map;


public class KesfetFragment extends Fragment implements SearchView.OnQueryTextListener {


    private FragmentKesfetBinding binding;


    BottomNavigationView bottomNavigationView;


    ArrayList<KesfetDetails> kesfetDetailsArrayList;

    private FirebaseAuth auth;
    FirebaseFirestore firebaseFirestore;
    KesfetAdaptor kesfetAdaptor;


    private Toolbar toolbar;
    private MenuItem menuItem;
    private SearchView searchView;

    String arananParcaAdı;

    ImageButton imageButton;


    Button ekle;

    RecyclerView recyclerView;
    Button button;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentKesfetBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);





        bottomNavigationView = view.findViewById(R.id.buttomNavigationkesfet);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.gonderiler:
                        return true;

                    case R.id.anlıkDusunceler:
                        KesfetFragmentDirections.ActionKesfetFragment2ToKesfetAnlikDusuncelerFragment action = KesfetFragmentDirections.actionKesfetFragment2ToKesfetAnlikDusuncelerFragment();
                        action.setArananAnlikDusunceler("null");
                        Navigation.findNavController(view).navigate(action);
                        return true;



                    default:
                        return false;
                }

            }
        });




        toolbar = view.findViewById(R.id.toolbarkesfet);


        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayShowTitleEnabled(false);

        recyclerView = view.findViewById(R.id.recycler_kesfet);

        button = view.findViewById(R.id.ekle_button);

        imageButton = view.findViewById(R.id.yorumlarButton);

        kesfetDetailsArrayList = new ArrayList<>();

        ekle = view.findViewById(R.id.ekle_button);
     

        auth = FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        kesfetAdaptor = new KesfetAdaptor(kesfetDetailsArrayList);
        recyclerView.setAdapter(kesfetAdaptor);



        if(getArguments() != null) {
            arananParcaAdı = KesfetFragmentArgs.fromBundle(getArguments()).getArananParca();

            if (arananParcaAdı.equals("null")){
                getData();
            }else{
                Parcafiltreleme(arananParcaAdı);

                bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()){
                            case R.id.gonderiler:
                                return true;

                            case R.id.anlıkDusunceler:
                                String ad = arananParcaAdı;
                                KesfetFragmentDirections.ActionKesfetFragment2ToKesfetAnlikDusuncelerFragment action = KesfetFragmentDirections.actionKesfetFragment2ToKesfetAnlikDusuncelerFragment();
                                action.setArananAnlikDusunceler(ad);
                                Navigation.findNavController(view).navigate(action);
                                return true;

                            default:
                                return false;
                        }

                    }
                });
            }




        }
        ekle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavDirections action = KesfetFragmentDirections.actionKesfetFragment2ToGonderiEkleFragment();
                Navigation.findNavController(view).navigate(action);
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
                             bottomNavigationView.getMenu().findItem(R.id.gonderiler).setTitle("Gönderiler");
                             bottomNavigationView.getMenu().findItem(R.id.anlıkDusunceler).setTitle("Anlık Düşünceler");

                         } else if (dil.equals("ingilizce")) {
                             bottomNavigationView.getMenu().findItem(R.id.gonderiler).setTitle("Shipments");
                             bottomNavigationView.getMenu().findItem(R.id.anlıkDusunceler).setTitle("İnstant thoughts");
                         }
                     }
                 }


                };
            });
        }





    public void Parcafiltreleme(String arananParcaAdı){

        firebaseFirestore.collection("Kesfet").document("Gönderi").collection("Gonderiler").whereEqualTo("parcaModeli",arananParcaAdı).addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                if (error != null) {

                }
                if (value != null) {

                    for (DocumentSnapshot snapshot : value.getDocuments()) {


                        Map<String, Object> dates = snapshot.getData();
                        String downloadUrl = (String) dates.get("downloadUrl");
                        String aciklama = (String) dates.get("aciklama");
                        String parcaAdi = (String) dates.get("parcaAdi");
                        String parcaModeli = (String) dates.get("parcaModeli");
                        String puanDegeri = (String) dates.get("puanDegeri");

                        String gonderiId = (String) dates.get("gonderiId");
                        String gonderenId = (String) dates.get("gonderenId");
                        String tarih = (String) dates.get("tarih");
                        String ayrıParca = (String) dates.get("ayrıParca");

                        KesfetDetails kesfetDetails = new KesfetDetails(downloadUrl, parcaAdi, aciklama, puanDegeri, gonderiId, gonderenId, tarih,parcaModeli,ayrıParca);
                        kesfetDetailsArrayList.add(kesfetDetails);

                    }
                    kesfetAdaptor.notifyDataSetChanged();
                }

            }

        });



    }


    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.toolbar_search,menu);
        menuItem = menu.findItem(R.id.action_search);
        searchView = (SearchView) MenuItemCompat.getActionView(menuItem);
        searchView.setIconified(true);


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
                            searchView.setQueryHint("Parça modeli giriniz");
                        } else if (dil.equals("ingilizce")) {
                            searchView.setQueryHint("Enter part model");
                        }
                    }
                }


            };
        });


        SearchManager searchManager = (SearchManager) getActivity().getSystemService(Context.SEARCH_SERVICE);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getActivity().getComponentName()));

        searchView.setIconifiedByDefault(false);

    }

    public void getData() {

        CollectionReference collectionReference = firebaseFirestore.collection("Kesfet").document("Gönderi").collection("Gonderiler");

        collectionReference.orderBy("tarih", Query.Direction.DESCENDING).addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {

                if (error != null) {

                }

                if (value != null) {

                    for (DocumentSnapshot snapshot : value.getDocuments()) {

                        Map<String, Object> dates = snapshot.getData();
                        String downloadUrl = (String) dates.get("downloadUrl");
                        String aciklama = (String) dates.get("aciklama");
                        String parcaAdi = (String) dates.get("parcaAdi");
                        String parcaModeli = (String) dates.get("parcaModeli");
                        String puanDegeri = (String) dates.get("puanDegeri");
                        String gonderiId = (String) dates.get("gonderiId");
                        String gonderenId = (String) dates.get("gonderenId");
                        String tarih = (String) dates.get("tarih");
                        String ayrıParca = (String) dates.get("ayrıParca");

                        KesfetDetails kesfetDetails = new KesfetDetails(downloadUrl, parcaAdi, aciklama, puanDegeri, gonderiId, gonderenId, tarih,parcaModeli,ayrıParca);
                        kesfetDetailsArrayList.add(kesfetDetails);


                    }
                    kesfetAdaptor.notifyDataSetChanged();


                }
            }

            ;


        })

        ;
    }



    @Override
    public boolean onQueryTextSubmit(String s) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String s) {
        ArrayList<KesfetDetails> newKesfet = new ArrayList<>();

        for (KesfetDetails kesfetDetails : kesfetDetailsArrayList) {



            if(kesfetDetails.getParcaModeli() != null){
                if(kesfetDetails.getParcaModeli().toLowerCase().contains(s.toLowerCase())){
                    newKesfet.add(kesfetDetails);
                }
            }
            else{
                if(kesfetDetails.getAyrıParca().toLowerCase().contains(s.toLowerCase())){
                    newKesfet.add(kesfetDetails);
                }
            }




        }
        kesfetAdaptor.setKesfetDetailsArrayList(newKesfet);
        kesfetAdaptor.notifyDataSetChanged();


        return true;
    }
}
