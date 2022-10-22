package com.example.kutaykerem.computerinformaton.Adaptor.Sohbetler;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kutaykerem.computerinformaton.Pages.ImageToScreenFragment;
import com.example.kutaykerem.computerinformaton.Models.Sohbetlerdetails;
import com.example.kutaykerem.computerinformaton.Pages.SohbetlerFragmentDirections;
import com.example.kutaykerem.computerinformaton.R;
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
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Map;

public class SohbetlerAdaptor extends RecyclerView.Adapter<SohbetlerAdaptor.SohbetlerHolder> {



    FirebaseAuth firebaseAuth;
    FirebaseUser user;
    Boolean state =false;
    int mesajPosition = -1;
    int karsıPosition;
    int kontrol = 0;
    int resimsil = 0;



    Context context;




    public SohbetlerAdaptor(Context context) {
        this.context = context;
    }



    int view_type_user=1;
    int view_type_karsı=2;



    ArrayList<Sohbetlerdetails> sohbetlerdetailsArrayList;

    public SohbetlerAdaptor(ArrayList<Sohbetlerdetails> sohbetlerdetailsArrayList) {
        this.firebaseAuth = firebaseAuth;
        this.user = user;
        this.state = state;
        this.view_type_user = view_type_user;
        this.view_type_karsı = view_type_karsı;
        this.sohbetlerdetailsArrayList = sohbetlerdetailsArrayList;
    }



    @Override
    public int getItemViewType(int position) {


      firebaseAuth = FirebaseAuth.getInstance();

      user = firebaseAuth.getCurrentUser();
      String userId = user.getUid().toString();

      String hedefId = String.valueOf(sohbetlerdetailsArrayList.get(position).getFrom());

        if(userId.equals(hedefId)){
            state = true;
            return view_type_user;
        }else{

            state = false;
            return view_type_karsı;
        }


    }


    @NonNull
    @Override
    public SohbetlerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;

        if(viewType == view_type_user){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerrow_sohbetler_user,parent,false);
            return new SohbetlerHolder(view);

        }else{
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerrow_sohbetler_karsi,parent,false);
            return new SohbetlerHolder(view);

        }



    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull SohbetlerHolder holder, @SuppressLint("RecyclerView") int position) {


        Sohbetlerdetails sohbetlerdetails = sohbetlerdetailsArrayList.get(position);



        if(sohbetlerdetails.getType().equals("text")){
            holder.progressBar.setVisibility(View.GONE);
            holder.resim.setVisibility(View.GONE);
            holder.mesaj.setVisibility(View.VISIBLE);
            holder.mesaj.setText(sohbetlerdetailsArrayList.get(position).getMesaj());
        }else{

            holder.resim.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    printResim(position,view);
                }
            });

            holder.resim.setVisibility(View.VISIBLE);
            holder.mesaj.setVisibility(View.GONE);
            Picasso.get().load(sohbetlerdetails.getMesaj()).resize(600,600).into(holder.resim, new Callback() {
                @Override
                public void onSuccess() {
                    holder.progressBar.setVisibility(View.GONE);
                }

                @Override
                public void onError(Exception e) {
                    e.printStackTrace();
                }
            });

        }



        if(sohbetlerdetailsArrayList.get(position).getFrom().equals(user.getUid())){

            if(position == sohbetlerdetailsArrayList.size()-1){
                if(sohbetlerdetails.getSeen()){

                    if(sohbetlerdetails.getType().equals("text")){
                        holder.goruldu.setVisibility(View.VISIBLE);
                        holder.gorulduResim.setVisibility(View.GONE);

                    } else{

                        holder.gorulduResim.setVisibility(View.VISIBLE);
                        holder.goruldu.setVisibility(View.GONE);
                    }


                }
                else{

                    holder.goruldu.setVisibility(View.INVISIBLE);
                    holder.gorulduResim.setVisibility(View.GONE);
                }

            }else{
                holder.goruldu.setVisibility(View.GONE);
                holder.gorulduResim.setVisibility(View.GONE);
            }

        }












        if(sohbetlerdetailsArrayList.get(position).getFrom().equals(user.getUid())){

            holder.cardView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    mesajPosition = position;
                    notifyDataSetChanged();
                    return false;
                }

            });

            holder.resim.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    holder.resim.setVisibility(View.GONE);
                    holder.mesajsilcard.setVisibility(View.VISIBLE);
                    holder.mesajsilResim.setVisibility(View.VISIBLE);


                    holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            holder.resim.setVisibility(View.VISIBLE);
                            holder.mesajsilcard.setVisibility(View.GONE);
                            holder.mesajsilResim.setVisibility(View.GONE);
                        }
                    });


                    holder.mesajsilcard.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            messajSil(position,view);
                        }
                    });
                    return true;
                }
            });




            if(mesajPosition == position){
                holder.mesajSil.setVisibility(View.VISIBLE);
                holder.mesajCopy.setVisibility(View.VISIBLE);

                holder.cardView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        holder.mesajSil.setVisibility(View.GONE);
                        holder.mesajCopy.setVisibility(View.GONE);
                    }
                });


            }




            holder.mesajSil.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    messajSil(position,view);
                }
            });
            holder.mesajCopy.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ClipboardManager clipboardManager = (ClipboardManager) view.getContext().getSystemService(Context.CLIPBOARD_SERVICE);
                    ClipData clipData = ClipData.newPlainText("",holder.mesaj.getText());
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
                    holder.mesajSil.setVisibility(View.GONE);
                    holder.mesajCopy.setVisibility(View.GONE);
                }
            });


        }


        if (sohbetlerdetailsArrayList.get(position).getHedefId().equals(user.getUid())){
            holder.cardView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    mesajPosition = position;
                    notifyDataSetChanged();
                    return false;
                }

            });

            if(mesajPosition == position){
                holder.mesajCopy.setVisibility(View.VISIBLE);

                holder.cardView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        holder.mesajCopy.setVisibility(View.GONE);
                    }
                });



            }

            holder.mesajCopy.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ClipboardManager clipboardManager = (ClipboardManager) view.getContext().getSystemService(Context.CLIPBOARD_SERVICE);
                    ClipData clipData = ClipData.newPlainText("",holder.mesaj.getText());
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



                    holder.mesajSil.setVisibility(View.GONE);
                    holder.mesajCopy.setVisibility(View.GONE);

                }
            });









        }









    }

    private void printResim(int position, View view) {

        String resim = sohbetlerdetailsArrayList.get(position).getMesaj();

        Bundle bundle = new Bundle();
        bundle.putString("image",resim);

        ImageToScreenFragment imageToScreen = new ImageToScreenFragment();
        AppCompatActivity appCompatActivity = (AppCompatActivity) view.getContext();
        FragmentManager fragmentManager = appCompatActivity.getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.sohbetler_frameLayout, imageToScreen).commit();
        imageToScreen.setArguments(bundle);

    }



    public void messajSil(final int position, View view){
        String bilgi = sohbetlerdetailsArrayList.get(position).getMesajId();
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("Mesajlar").child(user.getUid()).child(sohbetlerdetailsArrayList.get(position).getHedefId());
        Query query = reference.orderByChild("mesajId").equalTo(bilgi);

        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

             if(snapshot != null){
                 for(DataSnapshot dataSnapshot : snapshot.getChildren()) {
                     dataSnapshot.getRef().removeValue();
                 }
             }



            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        String bilgi2 = sohbetlerdetailsArrayList.get(position).getMesajId();
        DatabaseReference reference2 = FirebaseDatabase.getInstance().getReference().child("Mesajlar").child(sohbetlerdetailsArrayList.get(position).getHedefId()).child(user.getUid());
        Query query2 = reference2.orderByChild("mesajId").equalTo(bilgi2);

        query2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                if(snapshot != null) {
                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                        dataSnapshot.getRef().removeValue();
                    }

                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });




        FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
        firebaseFirestore.collection("KullanılanDiller").document(user.getUid()).collection("SecilenDil").orderBy("tarih", com.google.firebase.firestore.Query.Direction.DESCENDING).limit(1).addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {

             if(value != null){
                 for (DocumentSnapshot documentSnapshot : value.getDocuments()) {
                     Map<String, Object> data = documentSnapshot.getData();
                     String dil = data.get("dil").toString();


                     if (dil.equals("türkce")) {
                         Toast.makeText(view.getContext(),"Mesaj gönderimi iptal edildi",Toast.LENGTH_LONG).show();
                     } else if (dil.equals("ingilizce")) {
                         Toast.makeText(view.getContext(),"Message canceled",Toast.LENGTH_LONG).show();

                     }
                 }
             }


            };
        });



        if(sohbetlerdetailsArrayList.get(position).getFrom().equals(user.getUid())){
            SohbetlerFragmentDirections.ActionSohbetlerFragmentSelf action = SohbetlerFragmentDirections.actionSohbetlerFragmentSelf();
            action.setKullaniciId(sohbetlerdetailsArrayList.get(position).getHedefId());
            Navigation.findNavController(view).navigate(action);
        }









    }



    @Override
    public int getItemCount() {
        return sohbetlerdetailsArrayList.size();
    }

    public class SohbetlerHolder extends RecyclerView.ViewHolder{

        TextView mesaj,goruldu,gorulduResim ,mesajsilResim;
        ImageView resim,mesajSil,mesajCopy;
        ProgressBar progressBar;
        CardView cardView,mesajsilcard;
        ConstraintLayout constraintLayout;


        public SohbetlerHolder(@NonNull View itemView) {
            super(itemView);





           mesajSil = itemView.findViewById(R.id.sohbetler_mesaj_sil);
            mesajCopy = itemView.findViewById(R.id.sohbetler_mesaj_copy);
            cardView = itemView.findViewById(R.id.cardViewSohbetler);
            goruldu = itemView.findViewById(R.id.sohbetler_goruldu);
            resim = itemView.findViewById(R.id.sohbetler_resim);
            gorulduResim = itemView.findViewById(R.id.sohbetler_goruldu_resim);
            progressBar = itemView.findViewById(R.id.sohbetler_progressbar);
            mesajsilResim = itemView.findViewById(R.id.resimsilyazı);
            mesajsilcard = itemView.findViewById(R.id.resimsilcard);
            constraintLayout = itemView.findViewById(R.id.arkaplan);
            if(state == true){
                mesaj = itemView.findViewById(R.id.recyclerrow_mesaj_user);
            }else{
                mesaj = itemView.findViewById(R.id.recyclerrow_mesaj_karsi);
            }

            FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
            String userId = firebaseUser.getUid();



            FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
            firebaseFirestore.collection("KullanılanDiller").document(userId).collection("SecilenDil").orderBy("tarih", com.google.firebase.firestore.Query.Direction.DESCENDING).limit(1).addSnapshotListener(new EventListener<QuerySnapshot>() {
                @Override
                public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {

                if(value != null){
                    for (DocumentSnapshot documentSnapshot : value.getDocuments()) {
                        Map<String, Object> data = documentSnapshot.getData();
                        String dil = data.get("dil").toString();


                        if (dil.equals("türkce")) {
                            gorulduResim.setText("Görüldü");
                            goruldu.setText("Görüldü");
                        } else if (dil.equals("ingilizce")) {
                            goruldu.setText("Seen");
                            gorulduResim.setText("Seen");
                        }
                    }
                }



                };
            });


        }
    }












}
