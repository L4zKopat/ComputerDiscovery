package com.example.kutaykerem.computerinformaton.Adaptor.Kesfet;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;


import com.example.kutaykerem.computerinformaton.Pages.KesfetAnlikDusuncelerFragmentDirections;
import com.example.kutaykerem.computerinformaton.Models.KesfetAnlıkDusuncelerDetails;
import com.example.kutaykerem.computerinformaton.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;

public class KesfetAnlıkDusuncelerAdaptor extends RecyclerView.Adapter<KesfetAnlıkDusuncelerAdaptor.AnlıkDusuncelerHolder> {

    FirebaseFirestore firebaseFirestore;
    FirebaseUser firebaseUser;
    String userId;
    int anlıkdüsüncelerPosition ;


    ArrayList<KesfetAnlıkDusuncelerDetails> kesfetAnlıkDusuncelerDetailsArrayList;
    public KesfetAnlıkDusuncelerAdaptor(ArrayList<KesfetAnlıkDusuncelerDetails> kesfetAnlıkDusuncelerDetailsArrayList) {
        this.kesfetAnlıkDusuncelerDetailsArrayList = kesfetAnlıkDusuncelerDetailsArrayList;
    }

    public void setKesfetAnlıkDusuncelerDetailsArrayList(ArrayList<KesfetAnlıkDusuncelerDetails> kesfetAnlıkDusuncelerDetailsArrayList) {
        this.kesfetAnlıkDusuncelerDetailsArrayList = kesfetAnlıkDusuncelerDetailsArrayList;
    }

    @NonNull
    @Override
    public AnlıkDusuncelerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerrow_kesfet_anlikdusunceler,parent,false);
        return new AnlıkDusuncelerHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull AnlıkDusuncelerHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.kullanıcıAciklamasi.setText(kesfetAnlıkDusuncelerDetailsArrayList.get(position).aciklama);
        holder.tarih.setText(kesfetAnlıkDusuncelerDetailsArrayList.get(position).tarih);
        holder.puan.setText(kesfetAnlıkDusuncelerDetailsArrayList.get(position).puan);

        String parcaAdi = kesfetAnlıkDusuncelerDetailsArrayList.get(position).getParcaAdi();

        FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
        firebaseFirestore.collection("KullanılanDiller").document(userId).collection("SecilenDil").orderBy("tarih", Query.Direction.DESCENDING).limit(1).addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {

                if(value != null){
                    for (DocumentSnapshot documentSnapshot : value.getDocuments()) {
                        Map<String, Object> data = documentSnapshot.getData();
                        String dil = data.get("dil").toString();


                        if (dil.equals("türkce"))
                        {



                            if (parcaAdi.equals("Anakart"))
                            {
                                holder.parcaAdi.setText("Anakart");

                            } else if (parcaAdi.equals("Ekran kartı"))
                            {
                                holder.parcaAdi.setText("Ekran kartı");
                            }

                            else if (parcaAdi.equals("İşlemci"))
                            {
                                holder.parcaAdi.setText("İşlemci");
                            }

                            else if (parcaAdi.equals("Ram"))
                            {
                                holder.parcaAdi.setText("Ram");
                            }
                            else if (parcaAdi.equals("Güç kaynağı"))
                            {
                                holder.parcaAdi.setText("Güç kaynağı");
                            }
                            else if (parcaAdi.equals("Kasa"))
                            {
                                holder.parcaAdi.setText("Kasa");
                            }
                            else if (parcaAdi.equals("Motherboards"))
                            {
                                holder.parcaAdi.setText("Anakart");
                            }
                            else if (parcaAdi.equals("Graphics Cards"))

                            {
                                holder.parcaAdi.setText("Ekran kartı");
                            }
                            else if (parcaAdi.equals("Processors"))

                            {
                                holder.parcaAdi.setText("İşlemci");
                            }
                            else if (parcaAdi.equals("Rams"))
                            {
                                holder.parcaAdi.setText("Ram");
                            }
                            else if (parcaAdi.equals("Power Supplies"))
                            {
                                holder.parcaAdi.setText("Güç kaynağı");
                            }

                            else if (parcaAdi.equals("Safes"))
                            {
                                holder.parcaAdi.setText("Kasa");

                            }







                        } else if (dil.equals("ingilizce"))
                        {



                            if (parcaAdi.equals("Anakart"))
                            {
                                holder.parcaAdi.setText("Motherboards");

                            } else if (parcaAdi.equals("Ekran kartı"))
                            {
                                holder.parcaAdi.setText("Graphics Cards");
                            }

                            else if (parcaAdi.equals("İşlemci"))
                            {
                                holder.parcaAdi.setText("Processors");
                            }

                            else if (parcaAdi.equals("Ram"))
                            {
                                holder.parcaAdi.setText("Rams");
                            }
                            else if (parcaAdi.equals("Güç kaynağı"))
                            {
                                holder.parcaAdi.setText("Power Supplies");
                            }
                            else if (parcaAdi.equals("Kasa"))
                            {
                                holder.parcaAdi.setText("Safes");
                            }
                            else if (parcaAdi.equals("Motherboards"))
                            {
                                holder.parcaAdi.setText("Motherboards");
                            }
                            else if (parcaAdi.equals("Graphics Cards"))

                            {
                                holder.parcaAdi.setText("Graphics Cards");
                            }
                            else if (parcaAdi.equals("Processors"))

                            {
                                holder.parcaAdi.setText("Processors");
                            }
                            else if (parcaAdi.equals("Rams"))
                            {
                                holder.parcaAdi.setText("Rams");
                            }
                            else if (parcaAdi.equals("Power Supplies"))
                            {
                                holder.parcaAdi.setText("Power Supplies");
                            }

                            else if (parcaAdi.equals("Safes"))
                            {
                                holder.parcaAdi.setText("Safes");

                            }



                        }



                    }


                }


            };
        });




        String gonderen = kesfetAnlıkDusuncelerDetailsArrayList.get(position).gonderenId.toString();

        DatabaseReference reference = holder.databaseReference.child(gonderen);

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String kullanıcıAdı = snapshot.child("kullanıcıAdı").getValue().toString();

                holder.kullanıcıAdı.setText(kullanıcıAdı);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



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





        String parcaModeli = kesfetAnlıkDusuncelerDetailsArrayList.get(position).parcaModeli;
        String ayrıParca = kesfetAnlıkDusuncelerDetailsArrayList.get(position).ayrıParca;

        if(parcaModeli != null){
            holder.parcaModeli.setText(parcaModeli);
        }else if (parcaModeli == null){
            holder.ayrıParca.setText(ayrıParca);
        }















        holder.itemView.findViewById(R.id.recyclerrow_anlıkdüsüncelerProfile).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {





                // Gezinti
                String gonderen = kesfetAnlıkDusuncelerDetailsArrayList.get(position).gonderenId.toString();



              KesfetAnlikDusuncelerFragmentDirections.ActionKesfetAnlikDusuncelerFragmentToKullaniciProfileFragment action = KesfetAnlikDusuncelerFragmentDirections.actionKesfetAnlikDusuncelerFragmentToKullaniciProfileFragment();
              action.setGonderen(gonderen);
              Navigation.findNavController(view).navigate(action);
            }





        });

        String gonderiId =  kesfetAnlıkDusuncelerDetailsArrayList.get(position).gonderiId;
        if(gonderiId != null){

            holder.yorumlar.setBackground(null);

            holder.yorumlar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

               KesfetAnlikDusuncelerFragmentDirections.ActionKesfetAnlikDusuncelerFragmentToYorumlarFragment action = KesfetAnlikDusuncelerFragmentDirections.actionKesfetAnlikDusuncelerFragmentToYorumlarFragment(gonderiId);
               Navigation.findNavController(view).navigate(action);
                }
            });



        }


        holder.secenekler.setVisibility(View.GONE);
        holder.sil.setVisibility(View.GONE);

        if(kesfetAnlıkDusuncelerDetailsArrayList.get(position).getGonderenId().equals(userId)){
            holder.secenekler.setVisibility(View.VISIBLE);

            holder.secenekler.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    anlıkdüsüncelerPosition = position;
                    notifyDataSetChanged();

                }
            });

            if(anlıkdüsüncelerPosition == position){
                holder.sil.setVisibility(View.VISIBLE);

                holder.cardView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        holder.sil.setVisibility(View.GONE);
                    }
                });

            }

            holder.sil.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AnlıkDüsüncelerGönderiSil(position,view);
                }
            });




        }







    }

    private void AnlıkDüsüncelerGönderiSil(int position, View view) {
        if(kesfetAnlıkDusuncelerDetailsArrayList.get(position).getGonderenId().equals(userId)) {

            String bilgi = kesfetAnlıkDusuncelerDetailsArrayList.get(position).getGonderiId();
            CollectionReference collectionReference = firebaseFirestore.collection("Kesfet").document("AnlıkDüsünce").collection("Gonderiler");
            Query query = collectionReference.whereEqualTo("gonderiId", bilgi);

            query.addSnapshotListener(new EventListener<QuerySnapshot>() {
                @Override
                public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {

                    if (error != null) {
                        Toast.makeText(view.getContext(), error.getLocalizedMessage(), Toast.LENGTH_LONG).show();
                    }

                    if (value != null) {
                        for (DocumentSnapshot documentSnapshot : value.getDocuments()) {
                            documentSnapshot.getReference().delete();

                        }
                        notifyItemChanged(position);
                        notifyDataSetChanged();
                        FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
                        firebaseFirestore.collection("KullanılanDiller").document(userId).collection("SecilenDil").orderBy("tarih", com.google.firebase.firestore.Query.Direction.DESCENDING).limit(1).addSnapshotListener(new EventListener<QuerySnapshot>() {
                            @Override
                            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {

                           if(value != null){
                               for (DocumentSnapshot documentSnapshot : value.getDocuments()) {
                                   Map<String, Object> data = documentSnapshot.getData();
                                   String dil = data.get("dil").toString();


                                   if (dil.equals("türkce")) {
                                       Toast.makeText(view.getContext(),"Gönderi silindi",Toast.LENGTH_SHORT).show();
                                   } else if (dil.equals("ingilizce")) {
                                       Toast.makeText(view.getContext(),"post deleted",Toast.LENGTH_SHORT).show();

                                   }
                               }
                           }


                            };
                        });
                    }

                }
            });

            kesfetAnlıkDusuncelerDetailsArrayList.clear();


        }


    }

    @Override
    public int getItemCount() {
        return kesfetAnlıkDusuncelerDetailsArrayList.size();
    }

    public class AnlıkDusuncelerHolder extends RecyclerView.ViewHolder{

        TextView kullanıcıAciklamasi,parcaAdi,puan,parcaModeli,kullanıcıAdı,tarih,ayrıParca,textViewyorumlar;
        CircleImageView profile;
        ImageButton yorumlar;
        ImageView sil,secenekler;
        CardView cardView;
        FirebaseDatabase database;
        DatabaseReference databaseReference;


        public AnlıkDusuncelerHolder(@NonNull View itemView) {
            super(itemView);

            cardView = itemView.findViewById(R.id.cardview_anlikdüsüncelerkesfet);
            sil  = itemView.findViewById(R.id.kesfetanlikdüsünceler_gonderiler_sil);
            secenekler = itemView.findViewById(R.id.secenekler_ücnokta_kesfetanlikdüsünceler);
            kullanıcıAciklamasi = itemView.findViewById(R.id.recyclerrow_anlıkdüsüncelerAcıklama);
            kullanıcıAdı = itemView.findViewById(R.id.recyclerrow_anlıkdüsüncelerKullanıcıAdı);
            parcaAdi = itemView.findViewById(R.id.recyclerrow_anlıkdüsüncelerParcaAdi);
            parcaModeli = itemView.findViewById(R.id.recyclerrow_anlıkdüsüncelerParcaModeli);
            ayrıParca = itemView.findViewById(R.id.recyclerrow_anlıkdüsüncelerParcaModeli);
            puan = itemView.findViewById(R.id.anlıkdusuncepuan);
            tarih = itemView.findViewById(R.id.recyclerrow_anlıkdüsüncelerTarih);
            profile = itemView.findViewById(R.id.recyclerrow_anlıkdüsüncelerProfile);
            yorumlar = itemView.findViewById(R.id.anlıkdusunceyorumlarButton);
            textViewyorumlar = itemView.findViewById(R.id.textViewyorumlar);
            yorumlar.setBackground(null);


            database = FirebaseDatabase.getInstance();
            databaseReference = database.getReference().child("Profile");

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
            firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
            userId = firebaseUser.getUid();

            FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
            firebaseFirestore.collection("KullanılanDiller").document(userId).collection("SecilenDil").orderBy("tarih", Query.Direction.DESCENDING).limit(1).addSnapshotListener(new EventListener<QuerySnapshot>() {
                @Override
                public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {

                  if(value != null){
                      for (DocumentSnapshot documentSnapshot : value.getDocuments()) {
                          Map<String, Object> data = documentSnapshot.getData();
                          String dil = data.get("dil").toString();


                          if (dil.equals("türkce")) {
                              textViewyorumlar.setText("Yorumlar");
                          } else if (dil.equals("ingilizce")) {
                              textViewyorumlar.setText("Comments");
                          }
                      }
                  }


                };
            });

        }
    }




}
