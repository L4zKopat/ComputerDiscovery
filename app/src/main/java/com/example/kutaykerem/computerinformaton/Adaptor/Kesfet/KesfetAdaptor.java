package com.example.kutaykerem.computerinformaton.Adaptor.Kesfet;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
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
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.kutaykerem.computerinformaton.Pages.ImageToScreenFragment;
import com.example.kutaykerem.computerinformaton.Models.KesfetDetails;
import com.example.kutaykerem.computerinformaton.Pages.KesfetFragmentDirections;
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

public class KesfetAdaptor extends RecyclerView.Adapter<KesfetAdaptor.KesfetHolder> {

FirebaseFirestore firebaseFirestore;
FirebaseUser firebaseUser;
ArrayList<KesfetDetails> kesfetDetailsArrayList;
Context context;
String userId;

    int gonderiPosition = -1;


    boolean isImageFitToScreen;
    public KesfetAdaptor(boolean isImageFitToScreen) {
        this.isImageFitToScreen = isImageFitToScreen;
    }


    public KesfetAdaptor(Context context) {
        this.context = context;
    }

    public KesfetAdaptor(ArrayList<KesfetDetails> kesfetDetailsArrayList) {
        this.firebaseFirestore = firebaseFirestore;
        this.firebaseUser = firebaseUser;
        this.kesfetDetailsArrayList = kesfetDetailsArrayList;
    }

    public void setKesfetDetailsArrayList(ArrayList<KesfetDetails> kesfetDetailsArrayList) {
        this.kesfetDetailsArrayList = kesfetDetailsArrayList;
    }




    @NonNull
    @Override
    public KesfetHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View  view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_row_kesfet, parent, false);
        return new KesfetHolder(view);



        }








    @Override
    public void onBindViewHolder(@NonNull KesfetHolder holder, @SuppressLint("RecyclerView") int position) {


        holder.kullan??c??Aciklamasi.setText(kesfetDetailsArrayList.get(position).aciklama);
        holder.puan.setText(kesfetDetailsArrayList.get(position).puan);
        holder.tarih.setText(kesfetDetailsArrayList.get(position).tarih);

        String parcaAdi = kesfetDetailsArrayList.get(position).getParcaAdi();



        FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
        firebaseFirestore.collection("Kullan??lanDiller").document(userId).collection("SecilenDil").orderBy("tarih", Query.Direction.DESCENDING).limit(1).addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {

                if(value != null){
                    for (DocumentSnapshot documentSnapshot : value.getDocuments()) {
                        Map<String, Object> data = documentSnapshot.getData();
                        String dil = data.get("dil").toString();


                        if (dil.equals("t??rkce"))
                        {






                            if (parcaAdi.equals("Anakart"))
                            {
                                holder.parcaAdi.setText("Anakart");

                            } else if (parcaAdi.equals("Ekran kart??"))
                            {
                                holder.parcaAdi.setText("Ekran kart??");
                            }

                            else if (parcaAdi.equals("????lemci"))
                            {
                                holder.parcaAdi.setText("????lemci");
                            }

                            else if (parcaAdi.equals("Ram"))
                            {
                                holder.parcaAdi.setText("Ram");
                            }
                            else if (parcaAdi.equals("G???? kayna????"))
                            {
                                holder.parcaAdi.setText("G???? kayna????");
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
                                holder.parcaAdi.setText("Ekran kart??");
                            }
                            else if (parcaAdi.equals("Processors"))

                            {
                                holder.parcaAdi.setText("????lemci");
                            }
                            else if (parcaAdi.equals("Rams"))
                            {
                                holder.parcaAdi.setText("Ram");
                            }
                            else if (parcaAdi.equals("Power Supplies"))
                            {
                                holder.parcaAdi.setText("G???? kayna????");
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

                            } else if (parcaAdi.equals("Ekran kart??"))
                            {
                                holder.parcaAdi.setText("Graphics Cards");
                            }

                            else if (parcaAdi.equals("????lemci"))
                            {
                                holder.parcaAdi.setText("Processors");
                            }

                            else if (parcaAdi.equals("Ram"))
                            {
                                holder.parcaAdi.setText("Rams");
                            }
                            else if (parcaAdi.equals("G???? kayna????"))
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












            String parcaModeli = kesfetDetailsArrayList.get(position).parcaModeli;
            String ayr??Parca = kesfetDetailsArrayList.get(position).ayr??Parca;

            if (parcaModeli != null) {
                holder.parcaModeli.setText(parcaModeli);
            } else if (parcaModeli == null) {
                holder.ayr??Parca.setText(ayr??Parca);
            }


            DatabaseReference reference = holder.databaseReference.child(kesfetDetailsArrayList.get(position).getGonderenId());

            reference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    String kullan??c??Ad?? = snapshot.child("kullan??c??Ad??").getValue().toString();

                    holder.kullan??c??Ad??.setText(kullan??c??Ad??);
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });


            Picasso.get().load(kesfetDetailsArrayList.get(position).downloadUrl).into(holder.paylast??g??Resim);


            String gonderen = kesfetDetailsArrayList.get(position).gonderenId.toString();


            FirebaseFirestore kullan??c??ProfileFirestore = FirebaseFirestore.getInstance();

            kullan??c??ProfileFirestore.collection("Profiles").document("Resimler").collection(gonderen).orderBy("time", Query.Direction.DESCENDING).limit(1).addSnapshotListener(new EventListener<QuerySnapshot>() {
                @Override
                public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {

                    if (error != null) {

                    }

                    if (value != null) {

                        for (DocumentSnapshot snapshot : value.getDocuments()) {

                            Map<String, Object> data = snapshot.getData();

                            if (data.get("ImageProfile") != null) {
                                String image = (String) data.get("ImageProfile");

                                Picasso.get().load(image).resize(500, 500).into(holder.profile);
                            }


                        }
                    }
                }

                ;

            });


            holder.itemView.findViewById(R.id.profile).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {


                    // Gezinti
                    String gonderen = kesfetDetailsArrayList.get(position).gonderenId.toString();


                    KesfetFragmentDirections.ActionKesfetFragment2ToKullaniciProfileFragment action = KesfetFragmentDirections.actionKesfetFragment2ToKullaniciProfileFragment();
                    action.setGonderen(gonderen);
                    Navigation.findNavController(view).navigate(action);


                }


            });


            String gonderiId = kesfetDetailsArrayList.get(position).gonderiId;
            if (gonderiId != null) {

                holder.yorumlar.setBackground(null);

                holder.yorumlar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        KesfetFragmentDirections.ActionKesfetFragment2ToYorumlarFragment action = KesfetFragmentDirections.actionKesfetFragment2ToYorumlarFragment(gonderiId);
                        Navigation.findNavController(view).navigate(action);

                    }
                });


            }


            holder.paylast??g??Resim.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Bundle bundle = new Bundle();
                    bundle.putString("image", kesfetDetailsArrayList.get(position).downloadUrl);

                    ImageToScreenFragment imageToScreen = new ImageToScreenFragment();
                    AppCompatActivity appCompatActivity = (AppCompatActivity) view.getContext();
                    FragmentManager fragmentManager = appCompatActivity.getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.frameLayout_kesfet_toScreen, imageToScreen).commit();
                    imageToScreen.setArguments(bundle);


                }
            });

            holder.secenekler.setVisibility(View.GONE);
            holder.sil.setVisibility(View.GONE);
            if (kesfetDetailsArrayList.get(position).getGonderenId().equals(userId)) {

                holder.secenekler.setVisibility(View.VISIBLE);

                holder.secenekler.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        gonderiPosition = position;
                        notifyDataSetChanged();

                    }
                });

                if (gonderiPosition == position) {
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
                        GonderiSil(position, view);
                    }
                });


            }



    }

    private void GonderiSil(int position, View view) {
        String bilgi = kesfetDetailsArrayList.get(position).getGonderiId();
        CollectionReference collectionReference = firebaseFirestore.getInstance().collection("Kesfet").document("G??nderi").collection("Gonderiler");
        Query query = collectionReference.whereEqualTo("gonderiId",bilgi);

        query.addSnapshotListener(new EventListener<QuerySnapshot>() {
    @Override
    public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {

        if(error != null){
            Toast.makeText(view.getContext(),error.getLocalizedMessage(),Toast.LENGTH_LONG).show();
        }
        
        if(value != null){

            for(DocumentSnapshot documentSnapshot : value.getDocuments()){
               documentSnapshot.getReference().delete();

            }

            notifyDataSetChanged();
            FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
            firebaseFirestore.collection("Kullan??lanDiller").document(userId).collection("SecilenDil").orderBy("tarih", com.google.firebase.firestore.Query.Direction.DESCENDING).limit(1).addSnapshotListener(new EventListener<QuerySnapshot>() {
                @Override
                public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {


                    if(value != null){
                        for (DocumentSnapshot documentSnapshot : value.getDocuments()) {
                            Map<String, Object> data = documentSnapshot.getData();
                            String dil = data.get("dil").toString();


                            if (dil.equals("t??rkce")) {
                                Toast.makeText(view.getContext(),"G??nderi silindi",Toast.LENGTH_LONG).show();
                            } else if (dil.equals("ingilizce")) {
                                Toast.makeText(view.getContext(),"post deleted",Toast.LENGTH_LONG).show();

                            }
                        }
                    }


                };
            });
        }
    }

        });


        kesfetDetailsArrayList.clear();





    }

    @Override
    public int getItemCount() {

        return kesfetDetailsArrayList.size();
    }

    public class KesfetHolder extends RecyclerView.ViewHolder{


        TextView kullan??c??Aciklamasi,parcaAdi,puan,parcaModeli,kullan??c??Ad??,tarih,ayr??Parca,textViewyorumlar;
        CircleImageView profile;
        ImageView  paylast??g??Resim,secenekler,sil;
        ImageButton yorumlar;
        CardView cardView;
        FirebaseDatabase database;
        DatabaseReference databaseReference;




        @SuppressLint("WrongViewCast")
        public KesfetHolder(View itemView) {
            super(itemView);


            cardView = itemView.findViewById(R.id.cardview_kesfet);
            sil = itemView.findViewById(R.id.kesfet_gonderiler_sil);
            secenekler = itemView.findViewById(R.id.secenekler_??cnokta_kesfet);
            kullan??c??Aciklamasi = itemView.findViewById(R.id.kullaniciAciklamasiText);
            parcaAdi = itemView.findViewById(R.id.parcaAdiText);
            puan = itemView.findViewById(R.id.puanText);
            kullan??c??Ad?? = itemView.findViewById(R.id.kulllaniciAdiText);
            tarih   = itemView.findViewById(R.id.tarihText);
            paylast??g??Resim = itemView.findViewById(R.id.kullaniciPaylastigiResim);
            profile =  (CircleImageView) itemView.findViewById(R.id.profile);
            yorumlar = itemView.findViewById(R.id.yorumlarButton);
            parcaModeli = itemView.findViewById(R.id.parcaModeliText);
            ayr??Parca = itemView.findViewById(R.id.parcaModeliText);
            textViewyorumlar = itemView.findViewById(R.id.textViewyorumlar);

            database = FirebaseDatabase.getInstance();
            databaseReference = database.getReference().child("Profile");


            CountDownTimer countDownTimer = new CountDownTimer(50,1000) {
                @Override
                public void onTick(long l) {

                }

                @Override
                public void onFinish() {
                    profile.setVisibility(View.VISIBLE);
                    kullan??c??Ad??.setVisibility(View.VISIBLE);
                }
            }.start();


            firebaseFirestore = FirebaseFirestore.getInstance();

            firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
            userId = firebaseUser.getUid();



            FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
            firebaseFirestore.collection("Kullan??lanDiller").document(userId).collection("SecilenDil").orderBy("tarih", Query.Direction.DESCENDING).limit(1).addSnapshotListener(new EventListener<QuerySnapshot>() {
                @Override
                public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {

                   if(value != null){
                       for (DocumentSnapshot documentSnapshot : value.getDocuments()) {
                           Map<String, Object> data = documentSnapshot.getData();
                           String dil = data.get("dil").toString();


                           if (dil.equals("t??rkce")) {
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
