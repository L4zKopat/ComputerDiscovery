package com.example.kutaykerem.computerinformaton.Pages;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kutaykerem.computerinformaton.Adaptor.Arkadaslar.ArkadaslarAdaptor;
import com.example.kutaykerem.computerinformaton.Models.MesajList;
import com.example.kutaykerem.computerinformaton.R;
import com.example.kutaykerem.computerinformaton.databinding.ActivityAnaSayfaBinding;
import com.example.kutaykerem.computerinformaton.databinding.FragmentArkadaslarListesiBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class ArkadaslarListesiFragment extends Fragment {

   private FragmentArkadaslarListesiBinding binding;


    FirebaseFirestore firebaseFirestore;
    FirebaseAuth firebaseAuth;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference reference;
    DatabaseReference databaseReference;

    TextView arkSayısı;

    List<String> arkList;
    ArrayList<MesajList> mesajListArrayList;

    RecyclerView recyclerView;



    String userId;
    String arkadaslar;

    ArkadaslarAdaptor arkadaslarAdaptor;

    ImageView back;


    public ArkadaslarListesiFragment() {

    }




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding =  FragmentArkadaslarListesiBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);




        back = view.findViewById(R.id.arkadaslarlistesi_geri);
        arkSayısı = view.findViewById(R.id.arkSayısı);
        arkList = new ArrayList<>();
        mesajListArrayList = new ArrayList<>();



        firebaseDatabase = FirebaseDatabase.getInstance();
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();
        reference = FirebaseDatabase.getInstance().getReference();
        databaseReference = FirebaseDatabase.getInstance().getReference();


        userId = firebaseAuth.getUid();




        Arkadaslar();
        ArkadasSayısı(view);


        recyclerView = view.findViewById(R.id.recyclerView_arkadaslar_listesi);


        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        arkadaslarAdaptor = new ArkadaslarAdaptor(arkList, mesajListArrayList);
        recyclerView.setAdapter(arkadaslarAdaptor);



        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavDirections action = ArkadaslarListesiFragmentDirections.actionArkadaslarListesiFragmentToAnasayfaFragment();
                Navigation.findNavController(view).navigate(action);
            }
        });





    }



    public void Arkadaslar(){

        reference.child("Arkadaslar").child(userId).addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

                if(snapshot != null){
                    arkadaslar = snapshot.getKey();
                    arkList.add(arkadaslar);
                    arkadaslarAdaptor.notifyDataSetChanged();

                }


            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {
                arkList.remove(snapshot.getKey());
                arkadaslarAdaptor.notifyDataSetChanged();
            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



    }



    public void ArkadasSayısı(View view) {


        FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
        firebaseFirestore.collection("KullanılanDiller").document(userId).collection("SecilenDil").orderBy("tarih", Query.Direction.DESCENDING).limit(1).addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {

             if(value != null){
                 for (DocumentSnapshot documentSnapshot : value.getDocuments()) {
                     Map<String, Object> data = documentSnapshot.getData();
                     String dil = data.get("dil").toString();



                     if (dil.equals("türkce")) {

                         reference.child("Arkadaslar").child(userId).addValueEventListener(new ValueEventListener() {
                             @Override
                             public void onDataChange(@NonNull DataSnapshot snapshot) {
                                 arkSayısı.setText(snapshot.getChildrenCount() + " " + "Arkadaş");
                                 arkadaslarAdaptor.notifyDataSetChanged();
                             }

                             @Override
                             public void onCancelled(@NonNull DatabaseError error) {


                             }
                         });


                     } else if (dil.equals("ingilizce")) {

                         reference.child("Arkadaslar").child(userId).addValueEventListener(new ValueEventListener() {
                             @Override
                             public void onDataChange(@NonNull DataSnapshot snapshot) {
                                 arkSayısı.setText(snapshot.getChildrenCount() + " " + "Friend");
                                 arkadaslarAdaptor.notifyDataSetChanged();
                             }

                             @Override
                             public void onCancelled(@NonNull DatabaseError error) {


                             }
                         });
                     }


                 }
             }

            }
        });


    }





}