package com.example.kutaykerem.computerinformaton.Pages;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.MenuItemCompat;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.kutaykerem.computerinformaton.Adaptor.Kesfet.KesfetAnlÄ±kDusuncelerAdaptor;
import com.example.kutaykerem.computerinformaton.Models.KesfetAnlÄ±kDusuncelerDetails;
import com.example.kutaykerem.computerinformaton.Models.KesfetDetails;
import com.example.kutaykerem.computerinformaton.R;
import com.example.kutaykerem.computerinformaton.databinding.FragmentKesfetAnlikDusuncelerBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
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


public class KesfetAnlikDusuncelerFragment extends Fragment implements SearchView.OnQueryTextListener {

    private FragmentKesfetAnlikDusuncelerBinding binding;


    ArrayList<KesfetAnlÄ±kDusuncelerDetails> kesfetAnlÄ±kDusuncelerDetailsArrayList;

    private FirebaseAuth auth;

    private Toolbar toolbar;
    private MenuItem menuItem;
    private SearchView searchView;


    BottomNavigationView bottomNavigationView;

    FirebaseFirestore firebaseFirestore;
    FirebaseFirestore firebaseFirestoreFiltre;
    KesfetAnlÄ±kDusuncelerAdaptor kesfetAnlÄ±kDusuncelerAdaptor;


    RecyclerView recyclerView;
    String arananParcaAdÄ±;




    public KesfetAnlikDusuncelerFragment() {

    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentKesfetAnlikDusuncelerBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);




        recyclerView = view.findViewById(R.id.recycler_AnlÄ±kDusuncelerkesfet);



        kesfetAnlÄ±kDusuncelerDetailsArrayList = new ArrayList<>();

        auth = FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();
        firebaseFirestoreFiltre = FirebaseFirestore.getInstance();

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        kesfetAnlÄ±kDusuncelerAdaptor = new KesfetAnlÄ±kDusuncelerAdaptor(kesfetAnlÄ±kDusuncelerDetailsArrayList);
        recyclerView.setAdapter(kesfetAnlÄ±kDusuncelerAdaptor);


        toolbar = view.findViewById(R.id.toolbarkesfet);


        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayShowTitleEnabled(false);



        bottomNavigationView = view.findViewById(R.id.buttomNavigationkesfetanlikdÃ¼sÃ¼nceler);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.gonderiler:
                        NavDirections action = KesfetAnlikDusuncelerFragmentDirections.actionKesfetAnlikDusuncelerFragmentToKesfetFragment2();
                        Navigation.findNavController(view).navigate(action);

                        return true;

                    case R.id.anlÄ±kDusunceler:
                        return true;

                    default:
                        return false;
                }

            }
        });


        if(getArguments() != null) {
            arananParcaAdÄ± = KesfetAnlikDusuncelerFragmentArgs.fromBundle(getArguments()).getArananAnlikDusunceler();

            if (arananParcaAdÄ±.equals("null")){
                getData();

            }else{
                System.out.println(arananParcaAdÄ±);

                Parcafiltreleme(arananParcaAdÄ±);


                bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()){
                            case R.id.gonderiler:
                                String ad = arananParcaAdÄ±;
                                KesfetAnlikDusuncelerFragmentDirections.ActionKesfetAnlikDusuncelerFragmentToKesfetFragment2 action = KesfetAnlikDusuncelerFragmentDirections.actionKesfetAnlikDusuncelerFragmentToKesfetFragment2();
                                action.setArananParca(ad);
                                Navigation.findNavController(view).navigate(action);
                                return true;

                            case R.id.anlÄ±kDusunceler:
                                return true;

                            default:
                                return false;
                        }

                    }
                });
            }




        }
        DilTanÄ±(view);



    }
    public void DilTanÄ±(View view){
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String userId = user.getUid();

        FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
        firebaseFirestore.collection("KullanÄ±lanDiller").document(userId).collection("SecilenDil").orderBy("tarih", Query.Direction.DESCENDING).limit(1).addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {

              if(value != null){
                  for (DocumentSnapshot documentSnapshot : value.getDocuments()) {
                      Map<String, Object> data = documentSnapshot.getData();
                      String dil = data.get("dil").toString();

                      if (dil.equals("tÃ¼rkce")) {
                          bottomNavigationView.getMenu().findItem(R.id.gonderiler).setTitle("GÃ¶nderiler");
                          bottomNavigationView.getMenu().findItem(R.id.anlÄ±kDusunceler).setTitle("AnlÄ±k DÃ¼ÅÃ¼nceler");

                      } else if (dil.equals("ingilizce")) {
                          bottomNavigationView.getMenu().findItem(R.id.gonderiler).setTitle("Shipments");
                          bottomNavigationView.getMenu().findItem(R.id.anlÄ±kDusunceler).setTitle("Ä°nstant thoughts");
                      }
                  }
              }


            };
        });
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);

        inflater.inflate(R.menu.toolbar_search,menu);
        menuItem = menu.findItem(R.id.action_search);
        searchView = (SearchView) MenuItemCompat.getActionView(menuItem);
        searchView.setIconified(true);

        SearchManager searchManager2 = (SearchManager) getActivity().getSystemService(Context.SEARCH_SERVICE);
        searchView.setSearchableInfo(searchManager2.getSearchableInfo(getActivity().getComponentName()));
        searchView.setQueryHint("ParÃ§a modeli giriniz");
        searchView.setIconifiedByDefault(false);

    }

    public void getData(){

     CollectionReference collectionReference = (CollectionReference) firebaseFirestore.collection("Kesfet").document("AnlÄ±kDÃ¼sÃ¼nce").collection("Gonderiler");


     collectionReference.orderBy("tarih",Query.Direction.DESCENDING).addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {

                if (error != null) {

                }

                if (value != null) {

                    for (DocumentSnapshot snapshot : value.getDocuments()) {

                        Map<String, Object> dates = snapshot.getData();
                        String aciklama = (String) dates.get("aciklama");
                        String parcaAdi = (String) dates.get("parcaAdi");
                        String parcaModeli = (String) dates.get("parcaModeli");
                        String puanDegeri = (String) dates.get("puanDegeri");
                        String gonderiId = (String) dates.get("gonderiId");
                        String gonderenId = (String) dates.get("gonderenId");
                        String tarih = (String) dates.get("tarih");
                        String ayrÄ±Parca = (String) dates.get("ayrÄ±Parca");


                        KesfetAnlÄ±kDusuncelerDetails kesfetAnlÄ±kDusuncelerDetails = new KesfetAnlÄ±kDusuncelerDetails(parcaAdi, aciklama, puanDegeri, gonderiId, gonderenId, tarih,parcaModeli,ayrÄ±Parca);
                        kesfetAnlÄ±kDusuncelerDetailsArrayList.add(kesfetAnlÄ±kDusuncelerDetails);


                    }
                    kesfetAnlÄ±kDusuncelerAdaptor.notifyDataSetChanged();


                }
            }
        });








    }





    public void Parcafiltreleme(String arananParcaAdÄ±){

        firebaseFirestoreFiltre.collection("Kesfet").document("AnlÄ±kDÃ¼sÃ¼nceler").collection("Gonderiler").whereEqualTo("parcaModeli",arananParcaAdÄ±).addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                if (error != null) {
                    Toast.makeText(getActivity(), error.getLocalizedMessage(), Toast.LENGTH_LONG).show();

                }
                if (value != null) {


                    for (DocumentSnapshot snapshot : value.getDocuments()) {

                        Map<String, Object> dates = snapshot.getData();
                        String aciklama = (String) dates.get("aciklama");
                        String parcaAdi = (String) dates.get("parcaAdi");
                        String parcaModeli = (String) dates.get("parcaModeli");
                        String puanDegeri = (String) dates.get("puanDegeri");
                        String gonderiId = (String) dates.get("gonderiId");
                        String gonderenId = (String) dates.get("gonderenId");
                        String tarih = (String) dates.get("tarih");
                        String ayrÄ±Parca = (String) dates.get("ayrÄ±Parca");

                        KesfetAnlÄ±kDusuncelerDetails kesfetAnlÄ±kDusuncelerDetails = new KesfetAnlÄ±kDusuncelerDetails(parcaAdi, aciklama, puanDegeri, gonderiId, gonderenId, tarih,parcaModeli,ayrÄ±Parca);
                        kesfetAnlÄ±kDusuncelerDetailsArrayList.add(kesfetAnlÄ±kDusuncelerDetails);

                    }
                    kesfetAnlÄ±kDusuncelerAdaptor.notifyDataSetChanged();
                }

            }

        });


















    }


    @Override
    public boolean onQueryTextSubmit(String s) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String s) {
        ArrayList<KesfetAnlÄ±kDusuncelerDetails> newKesfet = new ArrayList<>();

        for (KesfetAnlÄ±kDusuncelerDetails kesfetDetails : kesfetAnlÄ±kDusuncelerDetailsArrayList) {



            if(kesfetDetails.getParcaModeli() != null){
                if(kesfetDetails.getParcaModeli().toLowerCase().contains(s.toLowerCase())){
                    newKesfet.add(kesfetDetails);
                }
            }
            else{
                if(kesfetDetails.getAyrÄ±Parca().toLowerCase().contains(s.toLowerCase())){
                    newKesfet.add(kesfetDetails);
                }
            }




        }
        kesfetAnlÄ±kDusuncelerAdaptor.setKesfetAnlÄ±kDusuncelerDetailsArrayList(newKesfet);
        kesfetAnlÄ±kDusuncelerAdaptor.notifyDataSetChanged();


        return true;
    }




}