package com.example.kutaykerem.computerinformaton.Adaptor.Arkadaslar;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;
import com.example.kutaykerem.computerinformaton.Models.MesajList;
import com.example.kutaykerem.computerinformaton.Pages.ArkadaslarListesiFragmentDirections;
import com.example.kutaykerem.computerinformaton.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
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
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;

public class ArkadaslarAdaptor extends RecyclerView.Adapter<ArkadaslarAdaptor.ArkadaslarHolder> {

    Activity activity;
    Context context;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    DatabaseReference reference;
    FirebaseFirestore firebaseFirestore;
    List<String> arkList;
    ArrayList<MesajList> mesajListArrayList;


    String userId;


    public ArkadaslarAdaptor(List<String> arkList, ArrayList<MesajList> mesajListArrayList) {
        this.activity = activity;
        this.context = context;
        this.firebaseDatabase = firebaseDatabase;
        this.databaseReference = databaseReference;
        this.reference = reference;
        this.firebaseFirestore = firebaseFirestore;
        this.mesajListArrayList = mesajListArrayList;
        this.arkList = arkList;
        this.userId = userId;


    }


    @NonNull
    @Override
    public ArkadaslarHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recylerrow_arkadaslar_listesi, parent, false);
        return new ArkadaslarHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ArkadaslarHolder holder, @SuppressLint("RecyclerView") int position) {


        String id = arkList.get(position);

        databaseReference.child("Mesajlar").child(userId).child(id).orderByChild("time" + Query.Direction.DESCENDING).limitToLast(1).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {



                if(snapshot != null){
                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {

                        String mesaj = dataSnapshot.child("mesaj").getValue().toString();
                        String gönderen = dataSnapshot.child("from").getValue().toString();
                        String tarih = dataSnapshot.child("time").getValue().toString();
                        String type = dataSnapshot.child("type").getValue().toString();

                        holder.sonMesaj.setText(mesaj);
                        holder.sonMesajTarih.setText(tarih);



                        if (gönderen.equals(userId)) {

                            if (type.equals("resim")) {
                                holder.sonMesaj.setText(holder.resimgönderildi);
                            } else {
                                holder.sonMesaj.setText(mesaj);
                                holder.sonMesajKarsi.setVisibility(View.GONE);
                            }

                        } else {
                            if (type.equals("resim")) {
                                holder.sonMesaj.setText(holder.resimigör);
                            } else {
                                holder.sonMesajKarsi.setText(mesaj);
                                holder.sonMesaj.setVisibility(View.GONE);
                            }

                        }


                    }
                }



            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        DatabaseReference databaseReference1 = reference.child(id);

        if (databaseReference1 != null) {


            databaseReference1.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {

                    if(snapshot != null){
                        String kullanıcıAdı = snapshot.child("kullanıcıAdı").getValue().toString();
                        holder.kullanıcıAdı.setText(kullanıcıAdı);

                    }

                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });

        }


        String yol = id;


        String gonderen = id;



        FirebaseFirestore kullanıcıProfileFirestore = FirebaseFirestore.getInstance();

        kullanıcıProfileFirestore.collection("Profiles").document("Resimler").collection(gonderen).orderBy("time", Query.Direction.DESCENDING).limit(1).addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {

                if(error !=null){

                }

                if(value != null){

                    for(DocumentSnapshot snapshot  : value.getDocuments()){

                        Map<String ,Object> data = snapshot.getData();

                        if(data.get("ImageProfile") != null){
                            String image = (String) data.get("ImageProfile");

                            Picasso.get().load(image).resize(500,500).into(holder.profile);
                        }



                    }
                }
            };

        });


        holder.profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArkadaslarListesiFragmentDirections.ActionArkadaslarListesiFragmentToKullaniciProfileFragment action = ArkadaslarListesiFragmentDirections.actionArkadaslarListesiFragmentToKullaniciProfileFragment();
                action.setGonderen(id);
                Navigation.findNavController(view).navigate(action);

            }
        });


        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ArkadaslarListesiFragmentDirections.ActionArkadaslarListesiFragmentToSohbetlerFragment action = ArkadaslarListesiFragmentDirections.actionArkadaslarListesiFragmentToSohbetlerFragment();
                action.setKullaniciId(id);
                Navigation.findNavController(view).navigate(action);

            }
        });


    }


    @Override
    public int getItemCount() {
        return arkList.size() + mesajListArrayList.size();
    }

    public class ArkadaslarHolder extends RecyclerView.ViewHolder {

        CircleImageView profile;
        TextView kullanıcıAdı, sonMesaj, sonMesajKarsi, sonMesajTarih;
        LinearLayout linearLayout;
        String resimigör, ilkmesajat,resimgönderildi;

        public ArkadaslarHolder(@NonNull View itemView) {
            super(itemView);




            profile = itemView.findViewById(R.id.recyclerrow_arkadaslar_Propfile);
            kullanıcıAdı = itemView.findViewById(R.id.recyclerrow_arkadaslar_kullanıcıAdı);
            sonMesaj = itemView.findViewById(R.id.recyclerrow_arkadaslar_sonMesaj);
            sonMesajKarsi = itemView.findViewById(R.id.recyclerrow_arkadaslar_sonMesajKarsi);
            sonMesajTarih = itemView.findViewById(R.id.recyclerrow_arkadaslar_sonMesajTarih);
            linearLayout = itemView.findViewById(R.id.arkadaslarlinear);

            CountDownTimer countDownTimer = new CountDownTimer(50,1000) {
                @Override
                public void onTick(long l) {

                }

                @Override
                public void onFinish() {
                    profile.setVisibility(View.VISIBLE);
                    kullanıcıAdı.setVisibility(View.VISIBLE);
                }
            }.start();


            firebaseFirestore = FirebaseFirestore.getInstance();
            firebaseDatabase = FirebaseDatabase.getInstance();
            reference = firebaseDatabase.getReference().child("Profile");
            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
            databaseReference = FirebaseDatabase.getInstance().getReference();


            userId = user.getUid();

            FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
            firebaseFirestore.collection("KullanılanDiller").document(userId).collection("SecilenDil").orderBy("tarih", Query.Direction.DESCENDING).limit(1).addSnapshotListener(new EventListener<QuerySnapshot>() {
                @Override
                public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {

                    if(value != null){
                        for (DocumentSnapshot documentSnapshot : value.getDocuments()) {
                            Map<String, Object> data = documentSnapshot.getData();
                            String dil = data.get("dil").toString();


                            if (dil.equals("türkce")) {
                                resimigör = "Resimi gör";
                                resimgönderildi = "Resim gönderildi";
                                ilkmesajat = "İlk mesajı siz atın";

                                sonMesaj.setHint(ilkmesajat);
                            } else if (dil.equals("ingilizce")) {
                                resimigör = "see picture";
                                resimgönderildi = "picture sent";
                                ilkmesajat = "Send first message";

                                sonMesaj.setHint(ilkmesajat);
                            }
                        }
                    }


                };
            });









        }


    }

}
