package com.example.kutaykerem.computerinformaton.Pages;

import android.app.AlertDialog;
import android.app.SearchManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.MenuItemCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;

import com.android.car.ui.AlertDialogBuilder;
import com.example.kutaykerem.computerinformaton.Adaptor.AnaSayfa.AdaptorPcList;
import com.example.kutaykerem.computerinformaton.Models.GetDateDetail;
import com.example.kutaykerem.computerinformaton.Models.KesfetDetails;
import com.example.kutaykerem.computerinformaton.Models.PcNames;
import com.example.kutaykerem.computerinformaton.R;
import com.example.kutaykerem.computerinformaton.databinding.FragmentAnasayfaBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class AnasayfaFragment extends Fragment  {

    private FragmentAnasayfaBinding binding;

    ArrayList<PcNames> pcNamesArrayList;


    RecyclerView recyclerView;

    AdaptorPcList adaptorPcList;
    DatabaseReference databaseReference;


    ImageView zil;
    int Kontrol = 0;
    String userId;

    String arkistek ;
    int kontroll = 0;






    private BottomNavigationView bottomNavigationView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        arkistek = null;





    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

      binding = FragmentAnasayfaBinding.inflate(inflater,container,false);
      return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        pcNamesArrayList = new ArrayList<>();

        bottomNavigationView = view.findViewById(R.id.buttomNavigation);




        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.Kesfet:
                       AnasayfaFragmentDirections.ActionAnasayfaFragmentToKesfetFragment2 action2 = AnasayfaFragmentDirections.actionAnasayfaFragmentToKesfetFragment2();
                       Navigation.findNavController(view).navigate(action2);
                        return true;
                    case R.id.Arkadaslar:
                        NavDirections navDirections1 = AnasayfaFragmentDirections.actionAnasayfaFragmentToArkadaslarListesiFragment();
                        Navigation.findNavController(view).navigate(navDirections1);
                        return true;

                    case R.id.Bildirimler:
                        NavDirections navDirections2 = AnasayfaFragmentDirections.actionAnasayfaFragmentToBildirimlerFragment();
                        Navigation.findNavController(view).navigate(navDirections2);
                        return true;
                    case R.id.Profile:
                      AnasayfaFragmentDirections.ActionAnasayfaFragmentToKullaniciProfileFragment action = AnasayfaFragmentDirections.actionAnasayfaFragmentToKullaniciProfileFragment();
                      Navigation.findNavController(view).navigate(action);
                      return true;

                    case R.id.anaSayfa:

                        return true;
                    default:
                        return false;
                }


            }
        });


        recyclerView = view.findViewById(R.id.recycler_anasayfa);




        zil = view.findViewById(R.id.zil);
        zil.setVisibility(View.INVISIBLE);

        databaseReference = FirebaseDatabase.getInstance().getReference("Arkadasİstekleri");



        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();;
        userId = user.getUid();

        bell();

        arkistek = null;

        zil.setVisibility(View.INVISIBLE);







        DilTanı(view);








    }


    public void DilTanı(View view){

        FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();

        firebaseFirestore.collection("KullanılanDiller").document(userId).collection("SecilenDil").orderBy("tarih", Query.Direction.DESCENDING).limit(1).addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {



                if(value != null){

                    for(DocumentSnapshot documentSnapshot : value.getDocuments()){
                        Map<String, Object> data = documentSnapshot.getData();
                        String dil = data.get("dil").toString();



                        if(dil.equals("türkce")){

                            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                            adaptorPcList = new AdaptorPcList(pcNamesArrayList);
                            recyclerView.setAdapter(adaptorPcList);

                            PcNames pcNames = new PcNames("Anakartlar",R.drawable.anakart);
                            pcNamesArrayList.add(pcNames);

                            PcNames pcNames2 = new PcNames("Ekran Kartları",R.drawable.grafik);
                            pcNamesArrayList.add(pcNames2);

                            PcNames pcNames3 = new PcNames("Ramlar",R.drawable.ram);
                            pcNamesArrayList.add(pcNames3);

                            PcNames pcNames4 = new PcNames("İşlemciler",R.drawable.islemci);
                            pcNamesArrayList.add(pcNames4);

                            PcNames pcNames5 = new PcNames("Güç Kaynakları",R.drawable.psu);
                            pcNamesArrayList.add(pcNames5);

                            PcNames pcNames6 = new PcNames("Kasalar",R.drawable.kasa);
                            pcNamesArrayList.add(pcNames6);

                            bottomNavigationView.getMenu().findItem(R.id.Kesfet).setTitle("Keşfet");
                            bottomNavigationView.getMenu().findItem(R.id.anaSayfa).setTitle("Ana Sayfa");
                            bottomNavigationView.getMenu().findItem(R.id.Arkadaslar).setTitle("Arkadaşlar");
                            bottomNavigationView.getMenu().findItem(R.id.Bildirimler).setTitle("Bildirimler");
                            bottomNavigationView.getMenu().findItem(R.id.Profile).setTitle("Profil");



                            view.setFocusableInTouchMode(true);
                            view.requestFocus();
                            view.setOnKeyListener(new View.OnKeyListener() {
                                @Override
                                public boolean onKey(View view, int i, KeyEvent keyEvent) {
                                    if(i == KeyEvent.KEYCODE_BACK){
                                        AlertDialog.Builder alertDialog = new AlertDialog.Builder(getActivity());

                                        alertDialog.setTitle("Çık");
                                        alertDialog.setMessage("Uygulamadan çıkmak istiyor musunuz?");

                                        alertDialog.setPositiveButton("Evet", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialogInterface, int i) {
                                                Intent setIntent = new Intent(Intent.ACTION_MAIN);
                                                setIntent.addCategory(Intent.CATEGORY_HOME);
                                                setIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                                startActivity(setIntent);
                                            }
                                        }).setNegativeButton("Hayır", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialogInterface, int i) {

                                            }
                                        });
                                        alertDialog.show();
                                    }

                                    adaptorPcList.notifyDataSetChanged();
                                    return true;
                                }
                            });




                        }else if (dil.equals("ingilizce")){
                            bottomNavigationView.getMenu().findItem(R.id.Kesfet).setTitle("Discover");
                            bottomNavigationView.getMenu().findItem(R.id.anaSayfa).setTitle("Home Page");
                            bottomNavigationView.getMenu().findItem(R.id.Arkadaslar).setTitle("Friends");
                            bottomNavigationView.getMenu().findItem(R.id.Bildirimler).setTitle("Notifications");
                            bottomNavigationView.getMenu().findItem(R.id.Profile).setTitle("Profile");

                            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                            adaptorPcList = new AdaptorPcList(pcNamesArrayList);
                            recyclerView.setAdapter(adaptorPcList);

                            PcNames pcNames = new PcNames("Motherboards",R.drawable.anakart);
                            pcNamesArrayList.add(pcNames);

                            PcNames pcNames2 = new PcNames("Graphics Cards",R.drawable.grafik);
                            pcNamesArrayList.add(pcNames2);

                            PcNames pcNames3 = new PcNames("Rams",R.drawable.ram);
                            pcNamesArrayList.add(pcNames3);

                            PcNames pcNames4 = new PcNames("Processors",R.drawable.islemci);
                            pcNamesArrayList.add(pcNames4);

                            PcNames pcNames5 = new PcNames("Power Supplies",R.drawable.psu);
                            pcNamesArrayList.add(pcNames5);

                            PcNames pcNames6 = new PcNames("Safes",R.drawable.kasa);
                            pcNamesArrayList.add(pcNames6);


                            view.setFocusableInTouchMode(true);
                            view.requestFocus();
                            view.setOnKeyListener(new View.OnKeyListener() {
                                @Override
                                public boolean onKey(View view, int i, KeyEvent keyEvent) {
                                    if(i == KeyEvent.KEYCODE_BACK){
                                        AlertDialog.Builder alertDialog = new AlertDialog.Builder(getActivity());

                                        alertDialog.setTitle("Exit");
                                        alertDialog.setMessage("Do you want to exit the application?");

                                        alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialogInterface, int i) {
                                                Intent setIntent = new Intent(Intent.ACTION_MAIN);
                                                setIntent.addCategory(Intent.CATEGORY_HOME);
                                                setIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                                startActivity(setIntent);
                                            }
                                        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialogInterface, int i) {

                                            }
                                        });
                                        alertDialog.show();
                                    }

                                    adaptorPcList.notifyDataSetChanged();

                                    return true;
                                }
                            });





                        }

                    }

                }


            }
        });



    }





    public void bell(){

        databaseReference.child(userId).addChildEventListener(new ChildEventListener() {

            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

                if(snapshot != null){
                    arkistek  = snapshot.child("tip").getValue().toString();

                    System.out.println(arkistek);

                    if(arkistek.equals("aldi")){
                        zil.setVisibility(View.VISIBLE);
                    }else{
                        zil.setVisibility(View.INVISIBLE);
                    }
                }


            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {


            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });




        if(Kontrol == 1){
            zil.setVisibility(View.VISIBLE);
        }else if (Kontrol == 2){
            zil.setVisibility(View.INVISIBLE);
        }

    }



}

