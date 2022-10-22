package com.example.kutaykerem.computerinformaton.Adaptor.Kesfet;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;


import com.example.kutaykerem.computerinformaton.Pages.YorumlarFragmentDirections;
import com.example.kutaykerem.computerinformaton.R;
import com.example.kutaykerem.computerinformaton.Models.YorumlarDetails;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Map;

public class YorumlarAdaptor extends RecyclerView.Adapter<YorumlarAdaptor.YorumlarHolder> {


    private  static final int VIEW_TYPE_MESSAGE_sag = 1;
    private  static final int VIEW_TYPE_MESSAGE_sol = 2;


    int yorumPosition = -1;

    ArrayList<YorumlarDetails> yorumlarDetailsArrayList;

    public YorumlarAdaptor(ArrayList<YorumlarDetails> yorumlarDetailsArrayList) {
        this.yorumlarDetailsArrayList = yorumlarDetailsArrayList;
    }


    @Override
    public int getItemViewType(int position) {




        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();

        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();

        String userId = firebaseUser.getUid();


        String gelenId = yorumlarDetailsArrayList.get(position).gonderenId;



        if (gelenId.equals(userId)) {
            System.out.println("sagda");
            return VIEW_TYPE_MESSAGE_sag;
        } else {
            System.out.println("solda");
            return VIEW_TYPE_MESSAGE_sol;
        }



    }

    @NonNull

    @Override
    public YorumlarHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {




       if(viewType == VIEW_TYPE_MESSAGE_sag){
           View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_row_yorumlar_sag,parent,false);
           return new YorumlarHolder(view);

       }else {
           View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_row_yorumlar,parent,false);
           return new YorumlarHolder(view);

       }



    }

    @Override
    public void onBindViewHolder(@NonNull YorumlarHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.yorum.setText(yorumlarDetailsArrayList.get(position).getYorum());
        holder.tarih.setText(yorumlarDetailsArrayList.get(position).getTarih());


        String gonderen = yorumlarDetailsArrayList.get(position).gonderenId.toString();


        DatabaseReference reference = holder.databaseReference.child(gonderen);

        reference.addValueEventListener(new ValueEventListener()
        {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot)

            {
                String kullanıcıAdı = snapshot.child("kullanıcıAdı").getValue().toString();

                holder.kullanıcıAdı.setText(kullanıcıAdı);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        FirebaseFirestore kullanıcıProfileFirestore = FirebaseFirestore.getInstance();

        kullanıcıProfileFirestore.collection("Profiles").document("Resimler").collection(gonderen).orderBy("time", com.google.firebase.firestore.Query.Direction.DESCENDING).limit(1).addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {



                if(value != null)
                {

                    for(DocumentSnapshot snapshot  : value.getDocuments())
                    {
                        Map<String ,Object> data = snapshot.getData();

                        if(data.get("ImageProfile") != null)
                        {
                            String image = (String) data.get("ImageProfile");

                            Picasso.get().load(image).resize(500,500).into(holder.profile);

                        }

                    }


                }

            };

        });





        holder.itemView.findViewById(R.id.yorumlarKullanıcıProfile).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {




                String gonderen = yorumlarDetailsArrayList.get(position).gonderenId.toString();

                YorumlarFragmentDirections.ActionYorumlarFragmentToKullaniciProfileFragment action = YorumlarFragmentDirections.actionYorumlarFragmentToKullaniciProfileFragment();
                action.setGonderen(gonderen);
                Navigation.findNavController(view).navigate(action);


            }
        });

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String userId = user.getUid();

        if(yorumlarDetailsArrayList.get(position).getGonderenId().equals(userId))
        {


            holder.cardView.setOnLongClickListener(new View.OnLongClickListener()
            {
                @Override
                public boolean onLongClick(View view) {
                    yorumPosition = position;
                    notifyDataSetChanged();
                    return false;

                }
            });

            if(yorumPosition == position){
                holder.sil.setVisibility(View.VISIBLE);
                holder.copy.setVisibility(View.VISIBLE);
                holder.tarih.setVisibility(View.GONE);

                holder.cardView.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View view) {
                        holder.sil.setVisibility(View.GONE);
                        holder.copy.setVisibility(View.GONE);
                        holder.tarih.setVisibility(View.VISIBLE);
                    }
                });

            }


            holder.sil.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view)
                {
                    yorumSil(position,view);

                }
            });


            holder.copy.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view) {
                    ClipboardManager clipboardManager = (ClipboardManager) view.getContext().getSystemService(Context.CLIPBOARD_SERVICE);
                    ClipData clipData = ClipData.newPlainText("",holder.yorum.getText());
                    clipboardManager.setPrimaryClip(clipData);

                    FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
                    firebaseFirestore.collection("KullanılanDiller").document(user.getUid()).collection("SecilenDil").orderBy("tarih", com.google.firebase.firestore.Query.Direction.DESCENDING).limit(1).addSnapshotListener(new EventListener<QuerySnapshot>() {
                        @Override
                        public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {

                         if(value != null){
                             for (DocumentSnapshot documentSnapshot : value.getDocuments()) {
                                 Map<String, Object> data = documentSnapshot.getData();
                                 String dil = data.get("dil").toString();


                                 if (dil.equals("türkce")) {
                                     Toast.makeText(view.getContext(),"Kopyalandı",Toast.LENGTH_SHORT).show();
                                 } else if (dil.equals("ingilizce")) {
                                     Toast.makeText(view.getContext(),"Copied",Toast.LENGTH_SHORT).show();

                                 }
                             }
                         }


                        };
                    });
                    holder.sil.setVisibility(View.GONE);
                    holder.copy.setVisibility(View.GONE);
                }
            });










        }


        if(yorumlarDetailsArrayList.get(position).getGonderenId() != userId){
            holder.cardView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    yorumPosition = position;
                    notifyDataSetChanged();
                    return false;
                }
            });

            if(yorumPosition == position){
                holder.copy.setVisibility(View.VISIBLE);
                holder.tarih.setVisibility(View.GONE);
                holder.cardView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        holder.sil.setVisibility(View.GONE);
                        holder.copy.setVisibility(View.GONE);
                        holder.tarih.setVisibility(View.VISIBLE);
                    }
                });

            }


            holder.copy.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ClipboardManager clipboardManager = (ClipboardManager) view.getContext().getSystemService(Context.CLIPBOARD_SERVICE);
                    ClipData clipData = ClipData.newPlainText("",holder.yorum.getText());
                    clipboardManager.setPrimaryClip(clipData);
                    FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
                    firebaseFirestore.collection("KullanılanDiller").document(user.getUid()).collection("SecilenDil").orderBy("tarih", com.google.firebase.firestore.Query.Direction.DESCENDING).limit(1).addSnapshotListener(new EventListener<QuerySnapshot>() {
                        @Override
                        public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {

                           if(value != null){
                               for (DocumentSnapshot documentSnapshot : value.getDocuments()) {
                                   Map<String, Object> data = documentSnapshot.getData();
                                   String dil = data.get("dil").toString();


                                   if (dil.equals("türkce")) {
                                       Toast.makeText(view.getContext(),"Kopyalandı",Toast.LENGTH_LONG).show();
                                   } else if (dil.equals("ingilizce")) {
                                       Toast.makeText(view.getContext(),"Copied",Toast.LENGTH_LONG).show();

                                   }
                               }
                           }


                        };
                    });
                    holder.sil.setVisibility(View.GONE);
                    holder.copy.setVisibility(View.GONE);
                }
            });





        }













    }

    private void yorumSil(int position, View view) {

        String bilgi = yorumlarDetailsArrayList.get(position).getYorumId();
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Yorumlar").child(yorumlarDetailsArrayList.get(position).getGonderiId()).child("Gonderiler");
        Query query = databaseReference.orderByChild("yorumId").equalTo(bilgi);

        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                if(snapshot != null){
                    for(DataSnapshot dataSnapshot : snapshot.getChildren()) {
                        dataSnapshot.getRef().removeValue();
                    }
                }


                FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();;
                firebaseFirestore.collection("KullanılanDiller").document(user.getUid()).collection("SecilenDil").orderBy("tarih", com.google.firebase.firestore.Query.Direction.DESCENDING).limit(1).addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @Override
                    public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {

                       if(value != null){
                           for (DocumentSnapshot documentSnapshot : value.getDocuments()) {
                               Map<String, Object> data = documentSnapshot.getData();
                               String dil = data.get("dil").toString();


                               if (dil.equals("türkce")) {
                                   Toast.makeText(view.getContext(),"Yorum silindi",Toast.LENGTH_SHORT).show();
                               } else if (dil.equals("ingilizce")) {
                                   Toast.makeText(view.getContext(),"Comment deleted",Toast.LENGTH_SHORT).show();

                               }
                           }
                       }


                    };
                });


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String userId = user.getUid();
        if(yorumlarDetailsArrayList.get(position).getGonderenId().equals(userId)){
            NavDirections action = YorumlarFragmentDirections.actionYorumlarFragmentSelf(yorumlarDetailsArrayList.get(position).getGonderiId());
            Navigation.findNavController(view).navigate(action);
        }


    }

    @Override
    public int getItemCount() {
        return yorumlarDetailsArrayList.size();

    }

    public class YorumlarHolder extends RecyclerView.ViewHolder{
        TextView yorum,kullanıcıAdı,tarih;
        ImageView profile,sil,copy;
        CardView cardView;
        FirebaseDatabase database;
        DatabaseReference databaseReference;

        public YorumlarHolder(View itemView) {
           super(itemView);

            FirebaseFirestore firebaseFirestore;
            firebaseFirestore = FirebaseFirestore.getInstance();
            cardView = itemView.findViewById(R.id.yorumlar_cardView);

            copy = itemView.findViewById(R.id.yorumlar_yorum_copy);
            sil = itemView.findViewById(R.id.yorumlar_yorum_sil);
            yorum = itemView.findViewById(R.id.yorumlarKullanıcıYorum);
            kullanıcıAdı = itemView.findViewById(R.id.yorumlarKullanıcıAdı);
            profile = itemView.findViewById(R.id.yorumlarKullanıcıProfile);
            tarih = itemView.findViewById(R.id.yorumlarTarih);
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
                    tarih.setVisibility(View.VISIBLE);
                    cardView.setVisibility(View.VISIBLE);
                }
            }.start();

       }


    }



}
