package com.example.kutaykerem.computerinformaton.Pages;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.CountDownTimer;
import android.provider.MediaStore;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.kutaykerem.computerinformaton.Adaptor.Sohbetler.SohbetlerAdaptor;
import com.example.kutaykerem.computerinformaton.Models.GetDate;
import com.example.kutaykerem.computerinformaton.Models.Sohbetlerdetails;
import com.example.kutaykerem.computerinformaton.R;
import com.example.kutaykerem.computerinformaton.databinding.FragmentSohbetlerBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
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
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import de.hdodenhof.circleimageview.CircleImageView;






public class SohbetlerFragment extends Fragment {

    private FragmentSohbetlerBinding binding;

    CircleImageView profile;
    TextView editmesaj;
    TextView kullanıcıAdı;
    ImageView geri;


    FirebaseFirestore firebaseFirestore;
    FirebaseAuth firebaseAuth;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    DatabaseReference reference;
    DatabaseReference reference2;
    StorageReference storageReference,yeniRef,sRef;
    ValueEventListener value;



    ActivityResultLauncher<Intent> activityResultLauncher;
    ActivityResultLauncher<String> permissionLauncher;


    ArrayList<Sohbetlerdetails> sohbetlerDetailsArrayList;


    Uri imageData;
    Bitmap Bitmapresim;
    String kayıtYeri,indirmeLinkli;
    Boolean farklıState;
    String mesaj;
    String msj;

    SohbetlerAdaptor sohbetlerAdaptor;



    LinearLayoutManager linearLayoutManager;

    String gelenkullanıcıId,user;

    String gidenProfile,gidenKullanıcıAdı;





    ImageView geriGit;

    ImageView gonder;
    ImageView gonderImage;


    ByteArrayOutputStream outputStream;
    byte[] resimByte;


    Map<String ,Object> data;
    RecyclerView recyclerView;
    CircleImageView kullaniciState;
    TextView stateTextCevrimİci,stateTextCevrimDısı;

    public SohbetlerFragment() {

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentSohbetlerBinding.inflate(inflater,container,false);
        return binding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {




        recyclerView = view.findViewById(R.id.sohbetler_mesajlar_recyclerView);

        gonder = view.findViewById(R.id.gonderSend);
        gonderImage = view.findViewById(R.id.gonderImage);
        stateTextCevrimİci = view.findViewById(R.id.stateTextCevrimİci);
        stateTextCevrimDısı = view.findViewById(R.id.stateTextCevrimDısı);
        kullaniciState = view.findViewById(R.id.sohbetler_kullanıcı_state);


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




        sohbetlerDetailsArrayList = new ArrayList<>();

        geriGit = view.findViewById(R.id.sohbetler_geri);

        geriGit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              NavDirections action =  SohbetlerFragmentDirections.actionSohbetlerFragmentToArkadaslarListesiFragment();
              Navigation.findNavController(view).navigate(action);
            }
        });


        profile = view.findViewById(R.id.sohbetlerkisiprofile);
        kullanıcıAdı =  view.findViewById(R.id.sohbetler_kullanıcıAdı);
        editmesaj = view.findViewById(R.id.sohbetlerEditmesaj);



        storageReference = FirebaseStorage.getInstance().getReference();
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference().child("Profile");
        reference = firebaseDatabase.getReference();
        reference2 = FirebaseDatabase.getInstance().getReference("Mesajlar");
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();

        user = firebaseAuth.getUid();


        data = new HashMap<>();

        editmesaj.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                msj = editmesaj.getText().toString().trim();

            }
            @Override
            public void afterTextChanged(Editable editable) {


            }
        });


        gonder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gonder();
            }
        });
        gonderImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gönderImage(view);
            }
        });



        if(getArguments() != null){
            gelenkullanıcıId = SohbetlerFragmentArgs.fromBundle(getArguments()).getKullaniciId();
            direktKisiVerisiCekme();
            OnlineOflineKontrolFarklıK(gelenkullanıcıId);
        }


        linearLayoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        linearLayoutManager.setStackFromEnd(true);
        sohbetlerAdaptor = new SohbetlerAdaptor(sohbetlerDetailsArrayList);
        recyclerView.setAdapter(sohbetlerAdaptor);
        recyclerView.setLayoutManager(linearLayoutManager);





        sohbetleriCek();

        fotoGonder("resim");

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SohbetlerFragmentDirections.ActionSohbetlerFragmentToKullaniciProfileFragment action = SohbetlerFragmentDirections.actionSohbetlerFragmentToKullaniciProfileFragment();
                action.setGonderen(gelenkullanıcıId);
                Navigation.findNavController(view).navigate(action);
            }
        });


        DilTanı(view);


        super.onViewCreated(view, savedInstanceState);
    }
  public void DilTanı(View view){

        FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
        firebaseFirestore.collection("KullanılanDiller").document(user).collection("SecilenDil").orderBy("tarih", Query.Direction.DESCENDING).limit(1).addSnapshotListener(new EventListener<QuerySnapshot>() {
          @Override
          public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {

            if(value != null){
                for (DocumentSnapshot documentSnapshot : value.getDocuments()) {
                    Map<String, Object> data = documentSnapshot.getData();
                    String dil = data.get("dil").toString();


                    if (dil.equals("türkce")) {

                        binding.stateTextCevrimCi.setText("Çevrimİçi");
                        binding.stateTextCevrimDS.setText("ÇevrimDışı");
                        editmesaj.setHint("Mesaj");
                    } else if (dil.equals("ingilizce")) {

                        binding.stateTextCevrimCi.setText("Online");
                        binding.stateTextCevrimDS.setText("Offline");
                        editmesaj.setHint("Message");
                    }


                }
            }




          };
      });
  }


    public void direktKisiVerisiCekme(){




        // KullanıcıAdı, KullanıcıId;



        DatabaseReference reference = databaseReference.child(gelenkullanıcıId);

        if(reference != null){


            reference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {

                    String kd = snapshot.child("kullanıcıAdı").getValue().toString();
                    kullanıcıAdı.setText(kd);

                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });

        }



        // Profile


        String yol = gelenkullanıcıId;


        if(firebaseFirestore.collection("Profiles").document("Resimler").collection(yol) != null){

            firebaseFirestore.collection("Profiles").document("Resimler").collection(yol).orderBy("time", Query.Direction.DESCENDING).limit(1).addSnapshotListener(new EventListener<QuerySnapshot>() {
                @Override
                public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {

                    if(error !=null){

                    }

                    if(value != null){

                        for(DocumentSnapshot snapshot  : value.getDocuments()){

                            Map<String ,Object> data = snapshot.getData();

                            if(data.get("ImageProfile") != null){
                                String image = (String) data.get("ImageProfile");

                                if(image == null){

                                }else{
                                    Picasso.get().load(image).resize(500,500).into(profile);
                                }
                            }



                        }
                    }
                };

            });

        }






    }


    public void sohbetleriCek(){


        reference.child("Mesajlar").child(user).child(gelenkullanıcıId).addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

               if(snapshot != null)

               {
                   Sohbetlerdetails sohbetlerdetails = snapshot.getValue(Sohbetlerdetails.class);
                   sohbetlerDetailsArrayList.add(sohbetlerdetails);
                   sohbetlerAdaptor.notifyDataSetChanged();
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




    }



    public void goruldu(){


        value =  reference.child("Mesajlar").child(user).child(gelenkullanıcıId).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {


                value = reference.child("Mesajlar").child(gelenkullanıcıId).child(user).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                     if(value != null)

                     {

                         for (DataSnapshot snapshot1 : snapshot.getChildren())
                         {
                             
                             Sohbetlerdetails sohbetlerdetails = snapshot1.getValue(Sohbetlerdetails.class);

                             String userId = firebaseAuth.getUid();

                             if (sohbetlerdetails.getHedefId().equals(userId))
                             {
                                 HashMap<String, Object> data = new HashMap<>();
                                 data.put("seen", true);
                                 snapshot1.getRef().updateChildren(data);
                             }


                         }



                     }

                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });


                if(value != null){

                    for(DataSnapshot snapshot1 : snapshot.getChildren()){
                        Sohbetlerdetails sohbetlerdetails = snapshot1.getValue(Sohbetlerdetails.class);

                        String userId = firebaseAuth.getUid();


                        if(sohbetlerdetails.getHedefId().equals(userId)){
                            HashMap<String,Object> data = new HashMap<>();
                            data.put("seen",true);
                            snapshot1.getRef().updateChildren(data);

                        }




    }
}


                sohbetlerAdaptor.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        System.out.println("gördü");



    }

    public void gonder(){

        mesaj = editmesaj.getText().toString();

        if(mesaj.isEmpty()){


        }else if(!msj.isEmpty()){

            // Karşıda gözükecek sohbet listesi

            // KullanıcıAdı

            DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Profile");


            DatabaseReference databaseReference2 = reference.child(user);

            databaseReference2.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {

                 if(snapshot != null){
                     gidenKullanıcıAdı =  snapshot.child("kullanıcıAdı").getValue().toString();


                     // Profile

                     String yol = firebaseAuth.getUid();

                     firebaseFirestore.collection("Profiles").document("Resimler").collection(yol).addSnapshotListener(new EventListener<QuerySnapshot>() {
                         @Override
                         public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {

                             if(error !=null){
                                 Toast.makeText(getActivity(),error.getLocalizedMessage(),Toast.LENGTH_LONG).show();
                             }

                             if(value != null){

                                 for(DocumentSnapshot snapshot  : value.getDocuments()){

                                     Map<String ,Object> data = snapshot.getData();

                                     if(data.get("ImageProfile") != null){

                                         gidenProfile = (String) data.get("ImageProfile");

                                     }

                                 }

                                 mesajGonder(user,gelenkullanıcıId,"text", GetDate.getDate(),false,mesaj);
                                 editmesaj.setText("");


                             }
                         };

                     });
                 }



                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                   ;
                }



            });

        }













    }





    public void mesajGonder(final String userId,final String hedefId,String textType,String date,Boolean seen,String mesaj){

        final String  mesajId = reference.child("Mesajlar").child(userId).child(hedefId).push().getKey();

        UUID uuid = UUID.randomUUID();
        String MesajId = System.currentTimeMillis() + uuid.toString();


        HashMap<String,Object> data = new  HashMap<>();
        data.put("type",textType);
        data.put("seen",seen);
        data.put("time",date);
        data.put("mesaj",mesaj);
        data.put("from",userId);
        data.put("hedefId",hedefId);
        data.put("mesajId",MesajId);
        data.put("kullanıcıAdı",gidenKullanıcıAdı);
        data.put("profile",gidenProfile);



        reference.child("Mesajlar").child(userId).child(hedefId).child(mesajId).setValue(data).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                reference.child("Mesajlar").child(hedefId).child(userId).child(mesajId).setValue(data).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {


                    }
                });


            }
        });


    }






    public void gönderImage(View view){


        if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {

            if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(), Manifest.permission.READ_EXTERNAL_STORAGE)) {

                FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
                firebaseFirestore.collection("KullanılanDiller").document(user).collection("SecilenDil").orderBy("tarih", Query.Direction.DESCENDING).limit(1).addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @Override
                    public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {

                        if(value != null){
                            for(DocumentSnapshot documentSnapshot : value.getDocuments()){
                                Map<String, Object> data = documentSnapshot.getData();
                                String dil = data.get("dil").toString();

                                if(dil.equals("türkce")){
                                    Snackbar.make(view, "Fotoğraf yüklemeniz için izne ihtiyacımız var", Snackbar.LENGTH_INDEFINITE).setAction("İzin ver", new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            permissionLauncher.launch(Manifest.permission.READ_EXTERNAL_STORAGE);
                                        }
                                    }).show();

                                }else if (dil.equals("ingilizce")){
                                    Snackbar.make(view, "We need permission to choose a profile photo", Snackbar.LENGTH_INDEFINITE).setAction("İzin ver", new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            permissionLauncher.launch(Manifest.permission.READ_EXTERNAL_STORAGE);
                                        }
                                    }).show();

                                }

                            }
                        }


                    }
                });

            } else {
                permissionLauncher.launch(Manifest.permission.READ_EXTERNAL_STORAGE);

            }
        } else {

            Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            activityResultLauncher.launch(intent);

        }



    }




    private void fotoGonder(String mesajTipi) {

        activityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {
                if (result.getResultCode() == Activity.RESULT_OK) {

                    Intent intent = result.getData();
                    if (intent != null) {
                        imageData = intent.getData();
                        try {
                            if (Build.VERSION.SDK_INT >= 28) {
                                ImageDecoder.Source source = ImageDecoder.createSource(getActivity().getContentResolver(), imageData);
                                Bitmapresim = ImageDecoder.decodeBitmap(source);

                            } else {
                                Bitmapresim  = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), imageData);

                            }

                            outputStream = new ByteArrayOutputStream();
                            Bitmapresim .compress(Bitmap.CompressFormat.PNG,75,outputStream);
                            resimByte  = outputStream.toByteArray();

                            UUID random = UUID.randomUUID();

                            kayıtYeri = "Sohbetler/" + "Resimler/" + user + "/" +  gelenkullanıcıId + "/" + random + ".png";
                            sRef = storageReference.child(kayıtYeri);
                            sRef.putBytes(resimByte).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                                @Override
                                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                                    yeniRef = FirebaseStorage.getInstance().getReference(kayıtYeri);
                                    yeniRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                                        @Override
                                        public void onSuccess(Uri uri) {
                                            indirmeLinkli = uri.toString();
                                            FotoGonderildi(indirmeLinkli,mesajTipi);

                                        }
                                    }).addOnFailureListener(new OnFailureListener() {
                                        @Override
                                        public void onFailure(@NonNull Exception e) {
                                            Toast.makeText(getActivity(),e.getLocalizedMessage(),Toast.LENGTH_LONG).show();
                                        }
                                    });

                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(getActivity(),e.getLocalizedMessage(),Toast.LENGTH_LONG).show();
                                }
                            });

                        } catch (Exception e1) {
                            Toast.makeText(getActivity(),e1.getLocalizedMessage(),Toast.LENGTH_LONG).show();
                        }


                    }

                }else{


                }


            }
        });

        permissionLauncher = registerForActivityResult(new ActivityResultContracts.RequestPermission(), new ActivityResultCallback<Boolean>() {
            @Override
            public void onActivityResult(Boolean result) {
                if (result) {
                    Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    activityResultLauncher.launch(intent);
                } else {
                    FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
                    firebaseFirestore.collection("KullanılanDiller").document(user).collection("SecilenDil").orderBy("tarih", Query.Direction.DESCENDING).limit(1).addSnapshotListener(new EventListener<QuerySnapshot>() {
                        @Override
                        public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {

                       if(value != null){


                           for(DocumentSnapshot documentSnapshot : value.getDocuments()){
                               Map<String, Object> data = documentSnapshot.getData();
                               String dil = data.get("dil").toString();

                               if(dil.equals("türkce")){
                                   Toast.makeText(getActivity(), "İzin verilmedi", Toast.LENGTH_LONG).show();

                               }else if (dil.equals("ingilizce")){
                                   Toast.makeText(getActivity(), "Not allowed", Toast.LENGTH_LONG).show();

                               }

                           }
                       }

                        }
                    });
                }

            }
        });


    }

    private void FotoGonderildi(String mesajİcerigi, String mesajTipi) {


        final String  mesajId = reference.child("Mesajlar").child(user).child(gelenkullanıcıId).push().getKey();

        UUID uuid = UUID.randomUUID();
        String MesajId = System.currentTimeMillis() + uuid.toString();

        HashMap<String,Object> data = new  HashMap<>();
        data.put("type",mesajTipi);
        data.put("seen",false);
        data.put("time",GetDate.getDate());
        data.put("mesaj",mesajİcerigi);
        data.put("mesajId",MesajId);
        data.put("from",user);
        data.put("hedefId",gelenkullanıcıId);
        data.put("kullanıcıAdı",gidenKullanıcıAdı);
        data.put("profile",gidenProfile);



        reference.child("Mesajlar").child(user).child(gelenkullanıcıId).child(mesajId).setValue(data).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                reference.child("Mesajlar").child(gelenkullanıcıId).child(user).child(mesajId).setValue(data).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {

                    }
                });
            }
        });





    }


    public void OnlineOflineKontrolFarklıK(String farklıKullanıcıId){
        DatabaseReference databaseReference2 = FirebaseDatabase.getInstance().getReference().child("Durum").child(farklıKullanıcıId).child("State");

        databaseReference2.addValueEventListener(new ValueEventListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                if(dataSnapshot != null){
                    farklıState = Boolean.parseBoolean(dataSnapshot.child("durum").getValue().toString());
                    if(farklıState == true){
                        stateTextCevrimDısı.setVisibility(View.INVISIBLE);
                        stateTextCevrimİci.setVisibility(View.VISIBLE);
                        kullaniciState.setImageResource(R.drawable.kullanici_online);
                    }else{
                        stateTextCevrimDısı.setVisibility(View.VISIBLE);
                        stateTextCevrimİci.setVisibility(View.INVISIBLE);
                        kullaniciState.setImageResource(R.drawable.kullanici_offline);

                    }
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }



    @Override
    public void onResume() {
        super.onResume();
        goruldu();

    }

    @Override
    public void onPause() {
        super.onPause();
        reference.removeEventListener(value);
    }
}