package com.example.kutaykerem.computerinformaton.Pages;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.os.CountDownTimer;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.car.ui.AlertDialogBuilder;
import com.bumptech.glide.Glide;
import com.example.kutaykerem.computerinformaton.Models.GetDateDetail;
import com.example.kutaykerem.computerinformaton.Models.KullanıcıBilgileri;
import com.example.kutaykerem.computerinformaton.R;
import com.example.kutaykerem.computerinformaton.Sign.UserLogin;
import com.example.kutaykerem.computerinformaton.databinding.FragmentKullaniciProfileBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
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
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;


public class KullaniciProfileFragment extends Fragment {

    private FragmentKullaniciProfileBinding binding;


    ArrayList<KullanıcıBilgileri> kullanıcıBilgileriArrayList;





    Button düzenle,sohbetButton,cıkısButton;

    ImageView arkaplan;

    String düzenleAdi,cikisAdi,arkadasliktancikaradi,arkadasekleadi,arkadasistekiptaladi,sohbetadi;


    FirebaseAuth auth;
    DatabaseReference databaseReference = null;
    FirebaseDatabase database = null;
    StorageReference storageReference;
    FirebaseFirestore firebaseFirestore;
    FirebaseStorage firebaseStorage;
    FirebaseUser user;

    DatabaseReference arkreference;
    DatabaseReference arkadaslarreference,onlineKontrolReference;


    String farklıKullanıcı;
    String arkistekKontrol = "";
    String userId;
    String dil;

    Button arkadasEkle,arkadasİstegiİptalEt,arkadastanCıkar;





    ArrayList<KullanıcıBilgileri> kullanıcıBilgileris;




    HashMap<String,Object> dataOnlineOfline;
    int butonKontrol = 0;
    int butonKontrol2 = 0;



    TextView kullanıcıAdıText,biyografiText,katılmaTarihiText;


    CircleImageView circleImageProfile,removeProfile;


    public KullaniciProfileFragment() {

    }




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

    binding = FragmentKullaniciProfileBinding.inflate(inflater,container,false);
    return binding.getRoot();


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        düzenle = (Button) view.findViewById(R.id.düzenle);
        sohbetButton = (Button) view.findViewById(R.id.sohbetButton);
        cıkısButton = (Button) view.findViewById(R.id.cıkısButton);
        arkadastanCıkar = view.findViewById(R.id.arkcikar);




        kullanıcıBilgileriArrayList = new ArrayList<>();
        kullanıcıBilgileris = new ArrayList<>();

        kullanıcıAdıText = view.findViewById(R.id.profilekullaniciadi);
        biyografiText = view.findViewById(R.id.profilebiyografi);

        katılmaTarihiText = view.findViewById(R.id.katilmaTarihi);



        circleImageProfile = view.findViewById(R.id.ImageProfile);
        removeProfile = view.findViewById(R.id.removeProfile);
        arkadasEkle = view.findViewById(R.id.profileArkadasEkle);
        arkadasİstegiİptalEt = view.findViewById(R.id.arkadasİstegiİptalEt);





        auth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference().child("Profile");
        arkadaslarreference = FirebaseDatabase.getInstance().getReference();
        onlineKontrolReference = FirebaseDatabase.getInstance().getReference();


        user = auth.getCurrentUser();

        userId = user.getUid();




        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();

        arkreference = FirebaseDatabase.getInstance().getReference("Arkadasİstekleri");


        firebaseStorage = FirebaseStorage.getInstance();
        storageReference = firebaseStorage.getReference();
        firebaseFirestore = FirebaseFirestore.getInstance();



        CountDownTimer countDownTimer = new CountDownTimer(50,1000) {
            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {
                circleImageProfile.setVisibility(View.VISIBLE);
                kullanıcıAdıText.setVisibility(View.VISIBLE);
            }
        }.start();


        arkaplan = (ImageView) view.findViewById(R.id.imageView22);






        if(getArguments() !=  null){

            farklıKullanıcı = KullaniciProfileFragmentArgs.fromBundle(getArguments()).getGonderen();

            if(farklıKullanıcı.equals(userId) || farklıKullanıcı.equals("null")){
                arkadastanCıkar.setVisibility(View.INVISIBLE);
                butonKontrol2 = 1;
                cıkısButton.setVisibility(View.VISIBLE);
                getData();
                userkatılmaTarihi();

            } else{

                farklıK(farklıKullanıcı);
                farklıKullanıcıkatılmaTarihi();

                arkreference.child(farklıKullanıcı).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(snapshot.hasChild(userId)){

                            arkistekKontrol = "istek";
                            snapshot.child(userId).child("tip").getValue().toString();

                            arkadasEkle.setVisibility(View.INVISIBLE);
                            arkadasİstegiİptalEt.setVisibility(View.VISIBLE);

                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });


                arkadaslarreference.child("Arkadaslar").child(userId).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(snapshot.hasChild(farklıKullanıcı)){
                            arkistekKontrol = "arkadas";
                            arkadasEkle.setVisibility(View.INVISIBLE);
                            arkadasİstegiİptalEt.setVisibility(View.INVISIBLE);
                            arkadastanCıkar.setVisibility(View.VISIBLE);
                            butonKontrol = 4;
                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });


                arkadasEkle.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(arkistekKontrol.equals("istek")){
                            arkadasİstegiİptalEt();
                        }else if (arkistekKontrol.equals("arkadas")){
                            arkadaslıktanCıkar(userId,farklıKullanıcı);
                        }else{
                            arkadasEkle();
                        }


                    }
                });
                arkadasİstegiİptalEt.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        arkadasİstegiİptalEt();
                    }
                });

                arkadastanCıkar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(arkistekKontrol.equals("istek")){
                            arkadasİstegiİptalEt();
                        }else if (arkistekKontrol.equals("arkadas")){
                            arkadaslıktanCıkar(userId,farklıKullanıcı);
                        }else{
                            arkadasEkle();
                        }
                    }
                });




            }

            if(farklıKullanıcı.equals("null")){
                butonKontrol2 = 1;
                cıkısButton.setVisibility(View.VISIBLE);
                arkadastanCıkar.setVisibility(View.INVISIBLE);
                getData();
                userkatılmaTarihi();
            }

        }



        if(butonKontrol2 != 1){



            if(butonKontrol == 0){
                arkadasEkle.setVisibility(View.VISIBLE);
                arkadasİstegiİptalEt.setVisibility(View.INVISIBLE);
                arkadastanCıkar.setVisibility(View.INVISIBLE);
            }else if(butonKontrol == 1){
                arkadasEkle.setVisibility(View.INVISIBLE);
                arkadasİstegiİptalEt.setVisibility(View.VISIBLE);
                arkadastanCıkar.setVisibility(View.INVISIBLE);
            }else if (butonKontrol == 2){
                arkadasEkle.setVisibility(View.VISIBLE);
                arkadasİstegiİptalEt.setVisibility(View.INVISIBLE);
                arkadastanCıkar.setVisibility(View.INVISIBLE);
            }else if (butonKontrol == 4){
                arkadasEkle.setVisibility(View.INVISIBLE);
                arkadasİstegiİptalEt.setVisibility(View.INVISIBLE);
                arkadastanCıkar.setVisibility(View.VISIBLE);
            }
        }


        else{

            getData();
        }


        düzenle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavDirections action = KullaniciProfileFragmentDirections.actionKullaniciProfileFragmentToDuzenleFragment();
                Navigation.findNavController(view).navigate(action);
            }
        });
        sohbetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                KullaniciProfileFragmentDirections.ActionKullaniciProfileFragmentToSohbetlerFragment action = KullaniciProfileFragmentDirections.actionKullaniciProfileFragmentToSohbetlerFragment();
                action.setKullaniciId(farklıKullanıcı);
                Navigation.findNavController(view).navigate(action);
            }
        });



        view.setFocusableInTouchMode(true);
        view.requestFocus();
        view.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if(i == KeyEvent.KEYCODE_BACK){
                    NavDirections navDirections = KullaniciProfileFragmentDirections.actionKullaniciProfileFragmentToAnasayfaFragment();
                    Navigation.findNavController(view).navigate(navDirections);
                }

                return true;
            }
        });



        DilTanı();


    }


    public void DilTanı(){

        FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
        firebaseFirestore.collection("KullanılanDiller").document(userId).collection("SecilenDil").orderBy("tarih",Query.Direction.DESCENDING).limit(1).addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {

            if(value != null ){


                for(DocumentSnapshot documentSnapshot : value.getDocuments()){
                    Map<String, Object> data = documentSnapshot.getData();
                    String dil = data.get("dil").toString();




                    if(dil.equals("türkce")){

                        /*
                        removeProfile.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                                AlertDialogBuilder alertDialogBuilder = new AlertDialogBuilder(getActivity());

                                alertDialogBuilder.setTitle("Profil fotoğrafını kaldır");
                                alertDialogBuilder.setMessage("Profil fotoğrafınızı kaldırmak istiyor musunuz?");

                                alertDialogBuilder.setPositiveButton("Evet", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {


                                        firebaseFirestore.collection("Profiles").document("Resimler").collection(userId).addSnapshotListener(new EventListener<QuerySnapshot>() {@Override
                                                public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error)
                                        {

                                                    if(value != null)
                                                    {

                                                        for(DocumentSnapshot documentSnapshot  : value.getDocuments())
                                                        {
                                                            documentSnapshot.getReference().delete();
                                                        }
                                                        NavDirections navDirections = KullaniciProfileFragmentDirections.actionKullaniciProfileFragmentSelf();
                                                        Navigation.findNavController(view).navigate(navDirections);

                                                    }



                                        };

                                            });



                                    }
                                }).setNegativeButton("Hayır", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {

                                    }
                                }).show();


                            }
                        });
                        */








                        düzenleAdi = "düzenle";
                        cikisAdi = "Çıkış";
                        arkadasekleadi = "Arkadaş İsteği Gönder";
                        arkadasistekiptaladi = "arkadaşlık isteğini iptal et";
                        arkadasliktancikaradi = "arkadaş listesinden çıkar";
                        sohbetadi = "sohbet";
                        binding.biyografi.setText("Biyografi");




                        arkadasEkle.setText(arkadasekleadi);
                        arkadasİstegiİptalEt.setText(arkadasistekiptaladi);
                        arkadastanCıkar.setText(arkadasliktancikaradi);
                        sohbetButton.setText(sohbetadi);
                        cıkısButton.setText(cikisAdi);
                        düzenle.setText(düzenleAdi);




                        cıkısButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                AlertDialog.Builder alertDialog = new AlertDialog.Builder(getActivity());
                                alertDialog.setTitle("Çıkış");
                                alertDialog.setMessage("Çıkış yapmak istediğinizden emin misiniz?");
                                alertDialog.setPositiveButton("Evet", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        OnlineOflineDurum(false);
                                        Intent intent = new Intent(getActivity(), UserLogin.class);
                                        startActivity(intent);
                                        auth.signOut();



                                    }

                                });
                                alertDialog.setNegativeButton("Hayır", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {

                                    }
                                });
                                alertDialog.show();
                            }
                        });




                    }else if (dil.equals("ingilizce")){

                        /*
                        removeProfile.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                                AlertDialogBuilder alertDialogBuilder = new AlertDialogBuilder(getActivity());

                                alertDialogBuilder.setTitle("Remove profile photo");
                                alertDialogBuilder.setMessage("Do you want to remove your profile photo?");

                                alertDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {


                                        firebaseFirestore.collection("Profiles").document("Resimler").collection(userId).addSnapshotListener(new EventListener<QuerySnapshot>() {@Override
                                        public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error)
                                        {

                                            if(value != null)
                                            {

                                                for(DocumentSnapshot documentSnapshot  : value.getDocuments())
                                                {
                                                    documentSnapshot.getReference().delete();
                                                }
                                                NavDirections navDirections = KullaniciProfileFragmentDirections.actionKullaniciProfileFragmentSelf();
                                                Navigation.findNavController(view).navigate(navDirections);




                                            }



                                        };

                                        });


                                    }

                                }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {

                                    }
                                }).show();

                            }
                        });

                        */

                        düzenleAdi = "edıt";
                        cikisAdi = "Exıt";
                        arkadasekleadi = "Send frendship request";
                        arkadasistekiptaladi = "cancel friend request";
                        arkadasliktancikaradi = "remove from friend list";
                        sohbetadi = "chat";
                        binding.biyografi.setText("Biography");


                        arkadasEkle.setText(arkadasekleadi);
                        arkadasİstegiİptalEt.setText(arkadasistekiptaladi);
                        arkadastanCıkar.setText(arkadasliktancikaradi);
                        sohbetButton.setText(sohbetadi);
                        cıkısButton.setText(cikisAdi);
                        düzenle.setText(düzenleAdi);



                        cıkısButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                AlertDialog.Builder alertDialog = new AlertDialog.Builder(getActivity());
                                alertDialog.setTitle("Exit");
                                alertDialog.setMessage("Are you sure you want to log out?");
                                alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        OnlineOflineDurum(false);
                                        Intent intent = new Intent(getActivity(), UserLogin.class);
                                        startActivity(intent);
                                        auth.signOut();




                                    }

                                });
                                alertDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {

                                    }
                                });
                                alertDialog.show();
                            }
                        });

                    }


                }

            }

            }
        });



    }



    public void getData(){

        arkadasEkle.setVisibility(View.INVISIBLE);
        arkadasİstegiİptalEt.setVisibility(View.INVISIBLE);
        sohbetButton.setVisibility(View.INVISIBLE);
        düzenle.setVisibility(View.VISIBLE);
        cıkısButton.setVisibility(View.VISIBLE);
        arkadastanCıkar.setVisibility(View.INVISIBLE);

        String yol = userId;






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


                                Picasso.get().load(image).resize(500,500).into(circleImageProfile);
                            }else{

                            }



                        }
                    }
                };

            });

        }



        user = auth.getCurrentUser();
        DatabaseReference reference = databaseReference.child(user.getUid());

        if(reference != null){


            reference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {


                    if(snapshot.getValue() != null){
                        KullanıcıBilgileri kullanıcıBilgileri = snapshot.getValue(KullanıcıBilgileri.class);
                        kullanıcıBilgileris.add(kullanıcıBilgileri);

                        if(kullanıcıBilgileri == null){
                            biyografiText.setText("");
                            kullanıcıAdıText.setText("");
                        }
                        else if (kullanıcıBilgileri != null ){

                            if(kullanıcıBilgileri.kullanıcıAdı != null){
                                kullanıcıAdıText.setText(kullanıcıBilgileri.kullanıcıAdı);
                            } else if (kullanıcıBilgileri.kullanıcıAdı == null ){
                               kullanıcıAdıText.setText("");
                            }

                            if(kullanıcıBilgileri.biyografi != null){
                               biyografiText.setText(kullanıcıBilgileri.biyografi);
                            } else if (kullanıcıBilgileri.biyografi == null){
                                biyografiText.setText("");
                            }

                        }


                    }






                }
                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
        }







    }

    public void farklıK(String farklıKullanıcı){

        arkadasEkle.setVisibility(View.VISIBLE);
        arkadasİstegiİptalEt.setVisibility(View.INVISIBLE);
        sohbetButton.setVisibility(View.VISIBLE);
        düzenle.setVisibility(View.INVISIBLE);
        cıkısButton.setVisibility(View.INVISIBLE);


        String yol = farklıKullanıcı;


        if(firebaseFirestore.collection("Profiles").document("Resimler").collection(yol) != null){

            firebaseFirestore.collection("Profiles").document("Resimler").collection(yol).orderBy("time", Query.Direction.DESCENDING).limit(1).addSnapshotListener(new EventListener<QuerySnapshot>() {
                @Override
                public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {

                    if(error !=null){
                        Toast.makeText(getActivity(),error.getLocalizedMessage(),Toast.LENGTH_LONG).show();
                    }

                    if(value != null){

                        for(DocumentSnapshot snapshot  : value.getDocuments()){

                            Map<String ,Object> data = snapshot.getData();

                            if(data.get("ImageProfile") != null){
                                String image = (String) data.get("ImageProfile");

                                if(image == null){

                                }else{
                                    Picasso.get().load(image).resize(500,500).into(circleImageProfile);
                                }
                            }



                        }
                    }
                };

            });

        }












        DatabaseReference reference2 = databaseReference.child(farklıKullanıcı);

        if(reference2 != null){


            reference2.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {


                    if(snapshot.getValue() != null){
                        KullanıcıBilgileri kullanıcıBilgileri = snapshot.getValue(KullanıcıBilgileri.class);
                        kullanıcıBilgileris.add(kullanıcıBilgileri);

                        if(kullanıcıBilgileri == null){
                            biyografiText.setText("");
                            kullanıcıAdıText.setText("");
                        }
                        else if (kullanıcıBilgileri != null ){

                            if(kullanıcıBilgileri.kullanıcıAdı != null){
                                kullanıcıAdıText.setText(kullanıcıBilgileri.kullanıcıAdı);
                            } else if (kullanıcıBilgileri.kullanıcıAdı == null ){
                                kullanıcıAdıText.setText("");
                            }

                            if(kullanıcıBilgileri.biyografi != null){
                                biyografiText.setText(kullanıcıBilgileri.biyografi);
                            } else if (kullanıcıBilgileri.biyografi == null){
                                biyografiText.setText("");
                            }

                        }


                    }

                }
                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
        }


    }




    public void userkatılmaTarihi(){


                    DatabaseReference databaseReference1 = FirebaseDatabase.getInstance().getReference("KatılmaTarihi").child(userId);

                    databaseReference1.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {

                            if(snapshot.getValue() != null){
                                for(DataSnapshot dataSnapshot : snapshot.getChildren()){
                                    String tarih = dataSnapshot.child("tarih").getValue().toString();


                                    FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
                                    firebaseFirestore.collection("KullanılanDiller").document(userId).collection("SecilenDil").orderBy("tarih",Query.Direction.DESCENDING).limit(1).addSnapshotListener(new EventListener<QuerySnapshot>() {
                                        @Override
                                        public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {

                                            if(value != null){
                                                for(DocumentSnapshot documentSnapshot : value.getDocuments()){

                                                    Map<String, Object> data = documentSnapshot.getData();
                                                    String dil = data.get("dil").toString();

                                                    if(dil.equals("türkce")){
                                                        katılmaTarihiText.setText(tarih + "  " + "tarihinde katıldı");

                                                    }else if (dil.equals("ingilizce")){
                                                        katılmaTarihiText.setText(tarih + "  " + "joined");

                                                    }

                                                }
                                            }






                                        }
                                    });


                                }
                            }

                        }


                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });



  }










    public void farklıKullanıcıkatılmaTarihi(){
        DatabaseReference databaseReference1 = FirebaseDatabase.getInstance().getReference("KatılmaTarihi").child(farklıKullanıcı);


                    databaseReference1.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {

                            if(snapshot.getValue() != null){

                                for(DataSnapshot dataSnapshot : snapshot.getChildren()){
                                    String tarih = dataSnapshot.child("tarih").getValue().toString();


                                    FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
                                    firebaseFirestore.collection("KullanılanDiller").document(userId).collection("SecilenDil").orderBy("tarih",Query.Direction.DESCENDING).limit(1).addSnapshotListener(new EventListener<QuerySnapshot>() {
                                        @Override
                                        public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {

                                         if(value != null){
                                             for(DocumentSnapshot documentSnapshot : value.getDocuments()){
                                                 Map<String, Object> data = documentSnapshot.getData();
                                                 String dil = data.get("dil").toString();

                                                 if(dil.equals("türkce")){
                                                     katılmaTarihiText.setText(tarih + "  " + "tarihinde katıldı");

                                                 }else if (dil.equals("ingilizce")){
                                                     katılmaTarihiText.setText(tarih + "  " + "joined");

                                                 }

                                             }
                                         }

                                        }
                                    });



                                }
                            }



                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                            Toast.makeText(getActivity(),error.getMessage(),Toast.LENGTH_LONG).show();
                        }
                    });





    }

    public void arkadasEkle(){
        arkadasEkle.setVisibility(View.VISIBLE);
        arkadasİstegiİptalEt.setVisibility(View.INVISIBLE);
        arkadastanCıkar.setVisibility(View.INVISIBLE);
        arkreference.child(userId).child(farklıKullanıcı).child("tip").setValue("gonderdi").addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {

                if(task.isSuccessful()){
                    arkreference.child(farklıKullanıcı).child(userId).child("tip").setValue("aldi").addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {

                            if(task.isSuccessful()){
                                arkistekKontrol="aldi";

                                FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
                                firebaseFirestore.collection("KullanılanDiller").document(userId).collection("SecilenDil").orderBy("tarih", Query.Direction.DESCENDING).limit(1).addSnapshotListener(new EventListener<QuerySnapshot>() {
                                    @Override
                                    public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {

                                     if(value != null){
                                         for (DocumentSnapshot documentSnapshot : value.getDocuments()) {
                                             Map<String, Object> data = documentSnapshot.getData();
                                             String dil = data.get("dil").toString();


                                             if (dil.equals("türkce")) {
                                                 Toast.makeText(getActivity(),"Arkadaş isteği gönderildi",Toast.LENGTH_LONG).show();
                                             } else if (dil.equals("ingilizce")) {
                                                 Toast.makeText(getActivity(),"Friend request sent",Toast.LENGTH_LONG).show();

                                             }
                                         }
                                     }


                                    };
                                });
                                arkadasEkle.setVisibility(View.INVISIBLE);
                                arkadasİstegiİptalEt.setVisibility(View.VISIBLE);
                                butonKontrol=1;



                            }else{
                                FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
                                firebaseFirestore.collection("KullanılanDiller").document(userId).collection("SecilenDil").orderBy("tarih", Query.Direction.DESCENDING).limit(1).addSnapshotListener(new EventListener<QuerySnapshot>() {
                                    @Override
                                    public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                                       if(value != null){
                                           for (DocumentSnapshot documentSnapshot : value.getDocuments()) {
                                               Map<String, Object> data = documentSnapshot.getData();
                                               String dil = data.get("dil").toString();


                                               if (dil.equals("türkce")) {
                                                   Toast.makeText(getActivity(),"Arkadaş isteği gönderilemedi",Toast.LENGTH_LONG).show();
                                               } else if (dil.equals("ingilizce")) {
                                                   Toast.makeText(getActivity(),"Failed to send friend request",Toast.LENGTH_LONG).show();

                                               }
                                           }
                                       }


                                    };
                                });

                            }

                        }
                    });
                }else{
                    FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
                    firebaseFirestore.collection("KullanılanDiller").document(userId).collection("SecilenDil").orderBy("tarih", Query.Direction.DESCENDING).limit(1).addSnapshotListener(new EventListener<QuerySnapshot>() {
                        @Override
                        public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {

                         if(value != null){
                             for (DocumentSnapshot documentSnapshot : value.getDocuments()) {
                                 Map<String, Object> data = documentSnapshot.getData();
                                 String dil = data.get("dil").toString();


                                 if (dil.equals("türkce")) {
                                     Toast.makeText(getActivity(),"Arkadaş isteği gönderilemedi",Toast.LENGTH_LONG).show();
                                 } else if (dil.equals("ingilizce")) {
                                     Toast.makeText(getActivity(),"Failed to send friend request",Toast.LENGTH_LONG).show();

                                 }
                             }
                         }


                        };
                    });
                }


            }
        });



    }


    public void arkadasİstegiİptalEt(){
        arkadasEkle.setVisibility(View.VISIBLE);
        arkadasİstegiİptalEt.setVisibility(View.INVISIBLE);
        arkadastanCıkar.setVisibility(View.INVISIBLE);

        arkreference.child(userId).child(farklıKullanıcı).removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {

                if(task.isSuccessful()){
                    arkreference.child(farklıKullanıcı).child(userId).removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {


                            arkistekKontrol="";
                            arkadasEkle.setVisibility(View.VISIBLE);
                            arkadasİstegiİptalEt.setVisibility(View.INVISIBLE);
                            butonKontrol=2;

                            FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
                            firebaseFirestore.collection("KullanılanDiller").document(userId).collection("SecilenDil").orderBy("tarih", Query.Direction.DESCENDING).limit(1).addSnapshotListener(new EventListener<QuerySnapshot>() {
                                @Override
                                public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {

                                   if(value != null){
                                       for (DocumentSnapshot documentSnapshot : value.getDocuments()) {
                                           Map<String, Object> data = documentSnapshot.getData();
                                           String dil = data.get("dil").toString();


                                           if (dil.equals("türkce")) {
                                               Toast.makeText(getActivity(),"Arkadaşlık isteği iptal edildi",Toast.LENGTH_LONG).show();
                                           } else if (dil.equals("ingilizce")) {
                                               Toast.makeText(getActivity(),"Friend request canceled",Toast.LENGTH_LONG).show();

                                           }
                                       }

                                   }





                                };
                            });







                        }
                    });
                }

            }
        });


    }

    public void arkadaslıktanCıkar(String userId,String hedefId){
        butonKontrol = 0;
        arkadasEkle.setVisibility(View.VISIBLE);
        arkadasİstegiİptalEt.setVisibility(View.INVISIBLE);

        arkadaslarreference.child("Arkadaslar").child(userId).child(farklıKullanıcı).removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {

                if(task.isSuccessful()){
                    arkadaslarreference.child("Arkadaslar").child(farklıKullanıcı).child(userId).removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            arkistekKontrol="";
                            arkadasEkle.setVisibility(View.VISIBLE);
                            arkadasİstegiİptalEt.setVisibility(View.INVISIBLE);
                            butonKontrol=1;
                            arkadastanCıkar.setVisibility(View.INVISIBLE);

                            FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
                            firebaseFirestore.collection("KullanılanDiller").document(userId).collection("SecilenDil").orderBy("tarih", Query.Direction.DESCENDING).limit(1).addSnapshotListener(new EventListener<QuerySnapshot>() {
                                @Override
                                public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {

                                    if(value != null){
                                        for (DocumentSnapshot documentSnapshot : value.getDocuments()) {
                                            Map<String, Object> data = documentSnapshot.getData();
                                            String dil = data.get("dil").toString();


                                            if (dil.equals("türkce")) {
                                                Toast.makeText(getActivity(),"Arkadaş listesinden kaldırıldı",Toast.LENGTH_LONG).show();
                                            } else if (dil.equals("ingilizce")) {
                                                Toast.makeText(getActivity(),"Removed from friend list",Toast.LENGTH_LONG).show();

                                            }
                                        }
                                    }



                                };
                            });










                        }
                    });
                }

            }
        });


    }



    public void OnlineOflineDurum(Boolean durum) {


        DatabaseReference reference = databaseReference.child(userId);

        if(reference != null){


            reference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {

                    if (snapshot.getValue() != null) {
                        KullanıcıBilgileri kullanıcıBilgileri = snapshot.getValue(KullanıcıBilgileri.class);
                        String kulllaniciAdi = kullanıcıBilgileri.getKullanıcıAdı();
                        dataOnlineOfline = new HashMap<>();
                        dataOnlineOfline.put("durum", durum);
                        dataOnlineOfline.put("kullanıcıAdı",kulllaniciAdi);
                        if(durum == false){
                            dataOnlineOfline.put("songörülme", GetDateDetail.getDate());
                        }


                        onlineKontrolReference.child("Durum").child(userId).child("State").setValue(dataOnlineOfline);
                        onlineKontrolReference.child("Durum").child(userId).child("State").updateChildren(dataOnlineOfline);


                    }

                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });

        }
    }






}