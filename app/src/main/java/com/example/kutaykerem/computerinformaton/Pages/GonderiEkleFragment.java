package com.example.kutaykerem.computerinformaton.Pages;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.icu.text.Transliterator;
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
import androidx.viewpager.widget.ViewPager;

import android.os.CountDownTimer;
import android.provider.MediaStore;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kutaykerem.computerinformaton.Adaptor.AnaSayfa.AdaptorPcList;
import com.example.kutaykerem.computerinformaton.Models.EkleParcaModeli;
import com.example.kutaykerem.computerinformaton.Models.EkleparcaAdi;
import com.example.kutaykerem.computerinformaton.Models.GetDate;
import com.example.kutaykerem.computerinformaton.Models.PcDetails;
import com.example.kutaykerem.computerinformaton.Models.PcNames;
import com.example.kutaykerem.computerinformaton.R;
import com.example.kutaykerem.computerinformaton.databinding.FragmentGonderiEkleBinding;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;


public class GonderiEkleFragment extends Fragment {


    private FragmentGonderiEkleBinding binding;


    ListView listView;
    ArrayAdapter<String> arrayAdapter;
    List<String> ekleparcaAdiArrayList;

    RatingBar ratingBar;
    TextView puanDeger;
    TextView acıklama;
    TextView parcaAdı;
    TextView parcaModeli;

    String parcaAdiii,ParcaModeliii;


    ActivityResultLauncher<Intent> activityResultLauncher;
    ActivityResultLauncher<String> permissionLauncher;
    Uri imageData;

    FirebaseFirestore firebaseFirestore;
    FirebaseStorage firebaseStorage;
    StorageReference storageReference;
    FirebaseAuth firebaseAuth;

    FirebaseAuth auth;
    DatabaseReference databaseReference = null;
    FirebaseDatabase database=null;


    ArrayList<String> pcDetailsArrayList;



    Bitmap selectedimage;
    ImageView resim;
    private String profile;

    String parcaAdSon,parcaModelSon;

    Button upload;


    HashMap<String, Object> data = new HashMap<>();
    HashMap<String, Object> datas = new HashMap<>();


    Button yükle;

    int Kontrol= 0;
    int kontrol2 = 0;

   Switch switch1;
   ImageView selectImage;

    public GonderiEkleFragment() {

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       binding = FragmentGonderiEkleBinding.inflate(inflater,container,false);
       return binding.getRoot();

    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        listView = view.findViewById(R.id.listView);
        ekleparcaAdiArrayList = new ArrayList<>();
        pcDetailsArrayList = new ArrayList<>();




        parcaAdları();


        switch1 = view.findViewById(R.id.switch1);

        auth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference().child("Profile");










        selectImage = view.findViewById(R.id.selectImage);
        puanDeger = view.findViewById(R.id.puanDeger);
        acıklama = view.findViewById(R.id.aciklama);
        parcaAdı = view.findViewById(R.id.parcaAdiEkle);
        parcaModeli = view.findViewById(R.id.parcaModeliEkle);
        puanDeger.setEnabled(false);
        resim = view.findViewById(R.id.selectImage);
        upload = view.findViewById(R.id.upload);

        ratingBar = view.findViewById(R.id.ratingBar);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                puanDeger.setText(String.valueOf(v));
                ratingBar.setEnabled(true);

            }
        });



        firebaseStorage = FirebaseStorage.getInstance();
        storageReference = firebaseStorage.getReference();
        firebaseFirestore = FirebaseFirestore.getInstance();
        firebaseAuth = FirebaseAuth.getInstance();


        registerLauncher();

        yükle = view.findViewById(R.id.upload);

        selectImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectImage(view);
            }
        });
        parcaAdı.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              parcaAdi();
            }
        });

        parcaModeli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             parcaModeli();
            }
        });
        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                yükle(view);
            }
        });

        DilTanı(view);

    }

    public void DilTanı(View view){
      FirebaseUser  user = auth.getCurrentUser();
      String userId = user.getUid();

      FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
      firebaseFirestore.collection("KullanılanDiller").document(userId).collection("SecilenDil").orderBy("tarih", Query.Direction.DESCENDING).limit(1).addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {

            if(value != null){
                for(DocumentSnapshot documentSnapshot : value.getDocuments()){
                    Map<String, Object> data = documentSnapshot.getData();
                    String dil = data.get("dil").toString();

                    if(dil.equals("türkce")){

                        binding.parcaAdiEkle.setHint("Parça Adını Seçiniz");
                        binding.parcaModeliEkle.setHint("Parça Modelini Seçiniz");
                        binding.ayrParca.setHint("Eklemek İstediğiniz Parça Yok Mu? Buradan Ekleyebilirsiniz");
                        binding.aciklama.setHint("Açıklama");
                        yükle.setText("Yükle");



                        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                            @Override
                            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                                if(compoundButton.isChecked()){
                                    binding.switch1.setText("Anlık düşünce");

                                    resim.setVisibility(View.INVISIBLE);
                                    upload.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            anlıkDusunce(view);
                                        }
                                    });

                                }else{
                                    binding.switch1.setText("Gönderi");
                                    resim.setVisibility(View.VISIBLE);
                                    upload.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            yükle(view);
                                        }
                                    });
                                }
                            }
                        });



                    }else if (dil.equals("ingilizce")){

                        binding.parcaAdiEkle.setHint("Select Part Name");
                        binding.parcaModeliEkle.setHint("Select Part Model");
                        binding.ayrParca.setHint("The Part You Want To Add Is Not Here? you can add it here");
                        binding.aciklama.setHint("Explanation");
                        yükle.setText("Upload");


                        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                            @Override
                            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                                if(compoundButton.isChecked()){
                                    binding.switch1.setText("İnstant thought");
                                    resim.setVisibility(View.INVISIBLE);
                                    upload.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            anlıkDusunce(view);
                                        }
                                    });

                                }else{
                                    binding.switch1.setText("Shipment");
                                    resim.setVisibility(View.VISIBLE);
                                    upload.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            yükle(view);
                                        }
                                    });
                                }
                            }
                        });


                    }

                }
            }

            }
        });











    }

    public void selectImage(View view) {

        if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {

            if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(), Manifest.permission.READ_EXTERNAL_STORAGE)) {

                FirebaseUser  user = auth.getCurrentUser();
                String userId = user.getUid();

                FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
                firebaseFirestore.collection("KullanılanDiller").document(userId).collection("SecilenDil").orderBy("tarih", Query.Direction.DESCENDING).limit(1).addSnapshotListener(new EventListener<QuerySnapshot>() {
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

    public void registerLauncher() {


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
                                selectedimage = ImageDecoder.decodeBitmap(source);
                                selectImage.setImageBitmap(selectedimage);
                            } else {
                                selectedimage = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), imageData);
                                selectImage.setImageBitmap(selectedimage);
                            }

                        } catch (Exception e1) {
                            e1.printStackTrace();
                        }


                    }
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
                    FirebaseUser  user = auth.getCurrentUser();
                    String userId = user.getUid();

                    FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
                    firebaseFirestore.collection("KullanılanDiller").document(userId).collection("SecilenDil").orderBy("tarih", Query.Direction.DESCENDING).limit(1).addSnapshotListener(new EventListener<QuerySnapshot>() {
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


    public void anlıkDusunce(View view){
        CountDownTimer countDownTimer = new CountDownTimer(6000,1000) {
            @Override
            public void onTick(long l) {
                yükle.setEnabled(false);
            }

            @Override
            public void onFinish() {
                yükle.setEnabled(true);
            }
        }.start();

        imageData = null;

        String aciklama = binding.aciklama.getText().toString();
        String parcaAdi = binding.parcaAdiEkle.getText().toString();
        String parcaModeli = binding.parcaModeliEkle.getText().toString();
        String puanDegeri = binding.puanDeger.getText().toString();
        FirebaseUser user = firebaseAuth.getCurrentUser();
        String email = user.getEmail();
        String ayrıParca = binding.ayrParca.getText().toString();



        if(parcaAdi.isEmpty() || aciklama.isEmpty()) {

            FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
            firebaseFirestore.collection("KullanılanDiller").document(user.getUid()).collection("SecilenDil").orderBy("tarih", Query.Direction.DESCENDING).limit(1).addSnapshotListener(new EventListener<QuerySnapshot>() {
                @Override
                public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {

                    if(value != null){
                        for(DocumentSnapshot documentSnapshot : value.getDocuments()){
                            Map<String, Object> data = documentSnapshot.getData();
                            String dil = data.get("dil").toString();

                            if(dil.equals("türkce")){
                                Toast.makeText(getActivity(),"Bilgileri Doldurunuz",Toast.LENGTH_LONG).show();

                            }else if (dil.equals("ingilizce")){
                                Toast.makeText(getActivity(), "Fill in Information", Toast.LENGTH_LONG).show();

                            }

                        }
                    }

                }
            });




            Kontrol = 0;
        }
        else{

            if(parcaModeli.isEmpty()) {

                if(ayrıParca.isEmpty()) {
                    FirebaseUser userr = firebaseAuth.getCurrentUser();
                    String userId = userr.getUid();

                    FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
                    firebaseFirestore.collection("KullanılanDiller").document(userId).collection("SecilenDil").orderBy("tarih", Query.Direction.DESCENDING).limit(1).addSnapshotListener(new EventListener<QuerySnapshot>() {
                        @Override
                        public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {

                           if(value != null){
                               for(DocumentSnapshot documentSnapshot : value.getDocuments()){
                                   Map<String, Object> data = documentSnapshot.getData();
                                   String dil = data.get("dil").toString();

                                   if(dil.equals("türkce")){
                                       Toast.makeText(getActivity(), "Bilgileri Doldurunuz", Toast.LENGTH_LONG).show();
                                   }else if (dil.equals("ingilizce")){
                                       Toast.makeText(getActivity(), "Fill in Information", Toast.LENGTH_LONG).show();

                                   }

                               }
                           }

                        }
                    });
                } else {
                    Kontrol = 2;
                }

            }
            else {
                Kontrol = 1;
            }


        }




        if(Kontrol == 1){


                                    String gonderiId = UUID.randomUUID().toString();

                                    String gonderenId = firebaseAuth.getUid();

                                    data.put("aciklama", aciklama);
                                    data.put("parcaAdi",parcaAdi);
                                    data.put("parcaModeli", parcaModeli);
                                    data.put("puanDegeri", puanDegeri);
                                    data.put("email", email);
                                    data.put("gonderiId", gonderiId);
                                    data.put("gonderenId", gonderenId);
                                    data.put("tarih", GetDate.getDate());
                                    //    data.put("ayrıParca",ayrıParca);




                                    firebaseFirestore.collection("Kesfet").document("AnlıkDüsünce").collection("Gonderiler").add(data).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                                    @Override
                                    public void onSuccess(DocumentReference documentReference) {

                                        NavDirections action = GonderiEkleFragmentDirections.actionGonderiEkleFragmentToKesfetAnlikDusuncelerFragment();
                                        Navigation.findNavController(view).navigate(action);

                                    }
                                }).addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toast.makeText(getActivity(), e.getLocalizedMessage(), Toast.LENGTH_LONG).show();
                                    }
                                });











                }








        if(Kontrol == 2){




                                    String gonderiId = UUID.randomUUID().toString();

                                    String gonderenId = firebaseAuth.getUid();



                                    data.put("aciklama", aciklama);
                                    data.put("parcaAdi",parcaAdi);
                                    //   data.put("parcaModeli", parcaModeli);
                                    data.put("puanDegeri", puanDegeri);
                                    data.put("email", email);
                                    data.put("profile", profile);
                                    data.put("gonderiId", gonderiId);
                                    data.put("gonderenId", gonderenId);
                                    data.put("tarih", GetDate.getDate());
                                    data.put("ayrıParca",ayrıParca);




                                firebaseFirestore.collection("Kesfet").document("AnlıkDüsünce").collection("Gonderiler").add(data).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                                    @Override
                                    public void onSuccess(DocumentReference documentReference) {
                                        NavDirections action = GonderiEkleFragmentDirections.actionGonderiEkleFragmentToKesfetAnlikDusuncelerFragment();
                                        Navigation.findNavController(view).navigate(action);
                                    }
                                }).addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toast.makeText(getActivity(), e.getLocalizedMessage(), Toast.LENGTH_LONG).show();
                                    }
                                });





                        }















    }



    public void parcaAdi(){

        listView.setVisibility(View.VISIBLE);
        arrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1,ekleparcaAdiArrayList);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


                if(parcaModeli!= null){
                 parcaModeli.setText("");
                }


                parcaAdiii = ekleparcaAdiArrayList.get(i).toString();
                parcaModelleri(parcaAdiii);
                if(parcaAdiii != null){
                   parcaAdı.setText(parcaAdiii);
                }

                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        parcaAdiii = ekleparcaAdiArrayList.get(i).toString();
                        parcaModeli.setText("");
                        if(parcaAdiii != null){
                          parcaAdı.setText(parcaAdiii);
                        }

                    }
                });




            }
        });


    }

    public void parcaModeli(){
        listView.setVisibility(View.VISIBLE);
       String i = parcaAdı.getText().toString();
        if(i != null){
            arrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1,pcDetailsArrayList);
            listView.setAdapter(arrayAdapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                    String parcaModelı = pcDetailsArrayList.get(i);
                    if(parcaModelı != null){
                        parcaModeli.setText(parcaModelı);
                        listView.setVisibility(View.GONE);

                    }




                }
            });

        }else{
            FirebaseUser user = firebaseAuth.getCurrentUser();
            String userId = user.getUid();

            FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
            firebaseFirestore.collection("KullanılanDiller").document(userId).collection("SecilenDil").orderBy("tarih", Query.Direction.DESCENDING).limit(1).addSnapshotListener(new EventListener<QuerySnapshot>() {
                @Override
                public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {

                    if(value != null){
                        for(DocumentSnapshot documentSnapshot : value.getDocuments()){
                            Map<String, Object> data = documentSnapshot.getData();
                            String dil = data.get("dil").toString();

                            if(dil.equals("türkce")){
                                Toast.makeText(getActivity(),"Lütfen bir parça adı seçin",Toast.LENGTH_LONG).show();
                            }else if (dil.equals("ingilizce")){
                                Toast.makeText(getActivity(), "Please select a track name", Toast.LENGTH_LONG).show();

                            }

                        }
                    }

                }
            });

        }
    }

    public void yükle(View view) {


        CountDownTimer countDownTimer = new CountDownTimer(6000,1000) {
            @Override
            public void onTick(long l) {
                yükle.setEnabled(false);
            }

            @Override
            public void onFinish() {
                yükle.setEnabled(true);
            }
        }.start();

        String aciklama = binding.aciklama.getText().toString();
        String parcaAdi = binding.parcaAdiEkle.getText().toString();
        String parcaModeli = binding.parcaModeliEkle.getText().toString();
        String puanDegeri = binding.puanDeger.getText().toString();
        FirebaseUser user = firebaseAuth.getCurrentUser();
        String email = user.getEmail();
        String ayrıParca = binding.ayrParca.getText().toString();



        if(parcaAdi.isEmpty() || aciklama.isEmpty()) {

            FirebaseUser userr = firebaseAuth.getCurrentUser();
            String userId = userr.getUid();

            FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
            firebaseFirestore.collection("KullanılanDiller").document(userId).collection("SecilenDil").orderBy("tarih", Query.Direction.DESCENDING).limit(1).addSnapshotListener(new EventListener<QuerySnapshot>() {
                @Override
                public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                   if(value != null){
                       for(DocumentSnapshot documentSnapshot : value.getDocuments()){
                           Map<String, Object> data = documentSnapshot.getData();
                           String dil = data.get("dil").toString();

                           if(dil.equals("türkce")){
                               Toast.makeText(getActivity(), "Bilgileri Doldurunuz", Toast.LENGTH_LONG).show();
                           }else if (dil.equals("ingilizce")){
                               Toast.makeText(getActivity(), "Fill in Information", Toast.LENGTH_LONG).show();

                           }

                       }
                   }

                }
            });

            Kontrol = 0;
        }
        else{

            if(parcaModeli.isEmpty()) {

                if(ayrıParca.isEmpty()) {
                    FirebaseUser userr = firebaseAuth.getCurrentUser();
                    String userId = userr.getUid();

                    FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
                    firebaseFirestore.collection("KullanılanDiller").document(userId).collection("SecilenDil").orderBy("tarih", Query.Direction.DESCENDING).limit(1).addSnapshotListener(new EventListener<QuerySnapshot>() {
                        @Override
                        public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {

                            if(value != null){
                                for(DocumentSnapshot documentSnapshot : value.getDocuments()){
                                    Map<String, Object> data = documentSnapshot.getData();
                                    String dil = data.get("dil").toString();

                                    if(dil.equals("türkce")){
                                        Toast.makeText(getActivity(), "Bilgileri Doldurunuz", Toast.LENGTH_LONG).show();
                                    }else if (dil.equals("ingilizce")){
                                        Toast.makeText(getActivity(), "Fill in Information", Toast.LENGTH_LONG).show();

                                    }

                                }
                            }

                        }
                    });
                }
                else {
                    Kontrol = 2;
                }

            }
            else {
                Kontrol = 1;
            }

        }




        if(imageData == null){
            FirebaseUser userr = firebaseAuth.getCurrentUser();
            String userId = userr.getUid();

            FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
            firebaseFirestore.collection("KullanılanDiller").document(userId).collection("SecilenDil").orderBy("tarih", Query.Direction.DESCENDING).limit(1).addSnapshotListener(new EventListener<QuerySnapshot>() {
                @Override
                public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {

                    if(value != null){
                        for(DocumentSnapshot documentSnapshot : value.getDocuments()){
                            Map<String, Object> data = documentSnapshot.getData();
                            String dil = data.get("dil").toString();

                            if(dil.equals("türkce")){
                                Toast.makeText(getActivity(), "Gönderi için bir resim seçiniz", Toast.LENGTH_LONG).show();
                            }else if (dil.equals("ingilizce")){
                                Toast.makeText(getActivity(), "Please select an image for the post", Toast.LENGTH_LONG).show();

                            }

                        }
                    }

                }
            });
        }
        else{
            UUID uuid = UUID.randomUUID();
            final String imagesName = "İmages/" + uuid + ".jpg";

            storageReference.child(imagesName).putFile(imageData).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    StorageReference storage = FirebaseStorage.getInstance().getReference(imagesName);
                    storage.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                        @Override
                        public void onSuccess(Uri uri) {
                            String downloadUrl = uri.toString();
                            String aciklama = binding.aciklama.getText().toString();
                            String parcaAdi = binding.parcaAdiEkle.getText().toString();
                            String parcaModeli = binding.parcaModeliEkle.getText().toString();
                            String puanDegeri = binding.puanDeger.getText().toString();
                            FirebaseUser user = firebaseAuth.getCurrentUser();
                            String email = user.getEmail();
                            String ayrıParca = binding.ayrParca.getText().toString();



                            if(parcaAdi.isEmpty() || aciklama.isEmpty()) {

                                FirebaseUser userr = firebaseAuth.getCurrentUser();
                                String userId = userr.getUid();

                                FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
                                firebaseFirestore.collection("KullanılanDiller").document(userId).collection("SecilenDil").orderBy("tarih", Query.Direction.DESCENDING).limit(1).addSnapshotListener(new EventListener<QuerySnapshot>() {
                                    @Override
                                    public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {

                                        if(value != null){
                                            for(DocumentSnapshot documentSnapshot : value.getDocuments()){
                                                Map<String, Object> data = documentSnapshot.getData();
                                                String dil = data.get("dil").toString();

                                                if(dil.equals("türkce")){
                                                    Toast.makeText(getActivity(), "Bilgileri Doldurunuz", Toast.LENGTH_LONG).show();
                                                }else if (dil.equals("ingilizce")){
                                                    Toast.makeText(getActivity(), "Fill in Information", Toast.LENGTH_LONG).show();

                                                }

                                            }
                                        }

                                    }
                                });


                            }else{
                                if(parcaModeli.isEmpty()){
                                    if(ayrıParca.isEmpty()){
                                        FirebaseUser userr = firebaseAuth.getCurrentUser();
                                        String userId = userr.getUid();

                                        FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
                                        firebaseFirestore.collection("KullanılanDiller").document(userId).collection("SecilenDil").orderBy("tarih", Query.Direction.DESCENDING).limit(1).addSnapshotListener(new EventListener<QuerySnapshot>() {
                                            @Override
                                            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {

                                                if(value != null){
                                                    for(DocumentSnapshot documentSnapshot : value.getDocuments()){
                                                        Map<String, Object> data = documentSnapshot.getData();
                                                        String dil = data.get("dil").toString();

                                                        if(dil.equals("türkce")){
                                                            Toast.makeText(getActivity(), "Bilgileri Doldurunuz", Toast.LENGTH_LONG).show();
                                                        }else if (dil.equals("ingilizce")){
                                                            Toast.makeText(getActivity(), "Fill in Information", Toast.LENGTH_LONG).show();

                                                        }

                                                    }
                                                }

                                            }
                                        });
                                    }else{
                                        Kontrol = 2;
                                    }

                                }else{
                                    Kontrol = 1;
                                }
                            }



                            if(Kontrol ==1){

                                String gonderiId = UUID.randomUUID().toString();

                                String gonderenId = firebaseAuth.getUid();

                                data.put("downloadUrl",downloadUrl);
                                data.put("aciklama", aciklama);
                                data.put("parcaAdi",parcaAdi);
                                data.put("parcaModeli", parcaModeli);
                                data.put("puanDegeri", puanDegeri);
                                data.put("email", email);
                                data.put("gonderiId", gonderiId);
                                data.put("gonderenId", gonderenId);
                                data.put("tarih", GetDate.getDate());
                                // data.put("ayrıParca",ayrıParca);

                                firebaseFirestore.collection("Kesfet").document("Gönderi").collection("Gonderiler").add(data).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                                    @Override
                                    public void onSuccess(DocumentReference documentReference) {
                                        NavDirections action = GonderiEkleFragmentDirections.actionGonderiEkleFragmentToKesfetFragment2();
                                        Navigation.findNavController(view).navigate(action);

                                    }
                                }).addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toast.makeText(getActivity(), e.getLocalizedMessage(), Toast.LENGTH_LONG).show();
                                    }
                                });





                            }


                         if(Kontrol == 2){

                             String gonderiId = UUID.randomUUID().toString();

                             String gonderenId = firebaseAuth.getUid();

                             data.put("downloadUrl", downloadUrl);
                             data.put("aciklama", aciklama);
                             data.put("parcaAdi", parcaAdi);
                             //   data.put("parcaModeli", parcaModeli);
                             data.put("puanDegeri", puanDegeri);
                             data.put("email", email);
                             data.put("gonderiId", gonderiId);
                             data.put("gonderenId", gonderenId);
                             data.put("tarih", GetDate.getDate());
                             data.put("ayrıParca", ayrıParca);



                             firebaseFirestore.collection("Kesfet").document("Gönderi").collection("Gonderiler").add(data).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                                 @Override
                                 public void onSuccess(DocumentReference documentReference) {
                                     NavDirections action = GonderiEkleFragmentDirections.actionGonderiEkleFragmentToKesfetFragment2();
                                     Navigation.findNavController(view).navigate(action);
                                 }
                             }).addOnFailureListener(new OnFailureListener() {
                                 @Override
                                 public void onFailure(@NonNull Exception e) {
                                     Toast.makeText(getActivity(), e.getLocalizedMessage(), Toast.LENGTH_LONG).show();
                                 }
                             });





                         }
















                         }


                            });



                        };
                    });
                ;
            };



        }







    public void parcaAdları(){

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String userId = user.getUid();

        FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();

        firebaseFirestore.collection("KullanılanDiller").document(userId).collection("SecilenDil").orderBy("tarih", Query.Direction.DESCENDING).limit(1).addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {



                if(value != null){

                    for(DocumentSnapshot documentSnapshot : value.getDocuments()){
                        Map<String, Object> data = documentSnapshot.getData();
                        String dil = data.get("dil").toString();


                        if(dil.equals("türkce")){
                            ekleparcaAdiArrayList.add("Anakart");
                            ekleparcaAdiArrayList.add("Ekran kartı");
                            ekleparcaAdiArrayList.add("İşlemci");
                            ekleparcaAdiArrayList.add("Ram");
                            ekleparcaAdiArrayList.add("Güç kaynağı");
                            ekleparcaAdiArrayList.add("Kasa");

                        }else if (dil.equals("ingilizce")){
                            ekleparcaAdiArrayList.add("Motherboards");
                            ekleparcaAdiArrayList.add("Graphics Cards");
                            ekleparcaAdiArrayList.add("Processors");
                            ekleparcaAdiArrayList.add("Rams");
                            ekleparcaAdiArrayList.add("Power Supplies");
                            ekleparcaAdiArrayList.add("Safes");

                        }

                    }

                }


            }
        });



    }

    public void parcaModelleri(String parcaAdi) {
        pcDetailsArrayList.clear();


        if (parcaAdi.equals("Anakart") || parcaAdi.equals("Motherboards"))
        {
            pcDetailsArrayList.add("ASUS PRIME H510M-D Intel H510 Soket 1200 DDR4 3200MHz(OC) M.2");
            pcDetailsArrayList.add("ASUS PRIME H510M-E Intel H510 Soket 1200 DDR4 3200MHz(OC) M.2");
            pcDetailsArrayList.add("ASUS TUF GAMING B550M-PLUS AMD B550 Soket AM4 Ryzen DDR4");
            pcDetailsArrayList.add("ASUS PRIME B450M-K II AMD B450 Soket AM4 DDR4 4400MHz(O.C.)");
            pcDetailsArrayList.add("ASUS TUF GAMING X570-PLUS (WI-FI) AM4 AMD Ryzen™ DDR4");
            pcDetailsArrayList.add("ASUS ROG MAXIMUS Z690 HERO EVA Intel Z690 socket 1700 DDR5");
            pcDetailsArrayList.add("ASUS PRIME B550M-A WIFI II AMD B550 socket AM4 Ryzen DDR4");
            pcDetailsArrayList.add("ASUS TUF GAMING B660M-PLUS D4 Intel B660 socket DDR4 5333MHz");
            pcDetailsArrayList.add("ASUS ROG STRIX B660-G GAMING WIFI Intel B660 socket 1700 DDR5");
            pcDetailsArrayList.add("ASUS PRIME B550-PLUS AMD B550 socket AM4 Ryzen DDR4 4600MHz");
            pcDetailsArrayList.add("ASUS PRIME H410M-A INTEL H410 socket 1200 DDR4 2933MHz(O.C)");
            pcDetailsArrayList.add("ASUS PRIME Z690-P WIFI Intel Z690 socket 1700 DDR5 6000MHz (OC)");
            pcDetailsArrayList.add("ASUS PRIME Z690-P Intel Z690 socket 1700 128GB DDR5");
            pcDetailsArrayList.add("ASUS ROG STRIX GAMING WIFI Z690-E Intel socket 1700 DDR5");
            pcDetailsArrayList.add("ASUS PRIME H610M-E D4 Intel H610 socket 1700 DDR4 3200MHz");
            pcDetailsArrayList.add("ASUS ROG CROSSHAIR VIII DARK HERO X570 AM4 AMD Ryzen DDR4");
            pcDetailsArrayList.add("ASUS PRIME A520M-E A520 socket AM4 AMD Ryzen DDR4 4600MHz");
            pcDetailsArrayList.add("ASUS PRIME H610M-K D4 Intel H610 socket 1700 DDR4 3200MHz");
            pcDetailsArrayList.add("ASUS TUF GAMING Z690-PLUS WF D4 Intel Z690 socket 1700 DDR4");
            pcDetailsArrayList.add("ASUS TUF GAMING Z690-PLUS D4 Intel Z690 socket 1700 DDR4");
            pcDetailsArrayList.add("ASUS ROGSTRIX Z690-A GAMING WIFI D4 Intel Z690 socket 1700 DDR4");
            pcDetailsArrayList.add("ASUS B450M-DRAGON AMD B450 socket AM4 4400MHz(O.C.) M.2");
            pcDetailsArrayList.add("ASUS PRIME H510M-A Intel H510 socket 1200 DDR4 3200MHz(OC) M.2");
            pcDetailsArrayList.add("ASUS TUF GAMING B550-PLUS WF AMD B550 socket AM4 Ryzen DDR4");
            pcDetailsArrayList.add("ASUS PRIME B550-PLUS AMD B550 socket AM4 Ryzen DDR4 4600MHz");
            pcDetailsArrayList.add("ASUS PRIME H410M-A INTEL H410 socket 1200 DDR4 2933MHz(O.C)");
            pcDetailsArrayList.add("ASUS PRIME Z690-P WIFI Intel Z690 socket 1700 DDR5 6000MHz (OC)");
            pcDetailsArrayList.add("ASUS ROG STRIX GAMING WIFI Z690-E Intel socket 1700 DDR5");
            pcDetailsArrayList.add("ASUS ROGSTRIX Z690-A GAMING WIFI Intel Z690  socket 1700 DDR5");
            pcDetailsArrayList.add("ASUS TUF GAMING Z690-PLUS WIFI Intel Z690 socket 1700 DDR5");
            pcDetailsArrayList.add("ASUS TUF GAMING Z690-PLUS Intel Z690 socket 1700 DDR5 6000MHz");
            pcDetailsArrayList.add("ASUS ROG MAXIMUS Z690 FORMULA Intel Z690 socket 1700");
            pcDetailsArrayList.add("ASUS TUF GAMING B660M-PLUS WIFI Intel B660 socket 1700 DDR5");
            pcDetailsArrayList.add("ASUS ROG STRIX B660-A GAMING WF Intel socket 1700 DDR5 6000MHz");
            pcDetailsArrayList.add("ASUS TUF GAMING B660M-PLUS WIFI D4 Intel B660 socket DDR4");
            pcDetailsArrayList.add("ASUS PRIME B660-PLUS D4 Intel B660 socket 1700 DDR4 5066MHz");
            pcDetailsArrayList.add("ASUS PRIME B660M-A WIFI D4 Intel B660 socket 1700 DDR4 3200MHz");
            pcDetailsArrayList.add("ASUS ROG STRIX B660-A GAMING WF Intel B660 socket 1700 DDR4");
            pcDetailsArrayList.add("ASUS PRIME Z690-P D4 Intel Z690 socket 1700128GB DDR4 5333MHz");
            pcDetailsArrayList.add("ASUS TUF GAMING H670-PRO WIFI D4 Intel socket 1700 DDR4 3200MHz");
            pcDetailsArrayList.add("ASUS TUF GAMING B660-PLUS WIFI D4 Intel socket 1700 DDR4");
            pcDetailsArrayList.add("ASUS TUF GAMING B660M-E D4 Intel B660 socket 1700 DDR4");
            pcDetailsArrayList.add("ASUS PROART B660-CREATOR D4 Intel B660 socket 1700 DDR4");
            pcDetailsArrayList.add("ASUS PRIME H670-PLUS D4 Intel H570 socket 1700 DDR4 2933MHz");
            pcDetailsArrayList.add("ASUS PRIME H610M-D D4 Intel H610 socket 1700 DDR4 3200MHz");
            pcDetailsArrayList.add("ASUS PRIME H610M-A D4 Intel H610 socket 1700 DDR4 3200MHz");
            pcDetailsArrayList.add("ASUS PRIME B660M-A D4 Intel B660 socket 1700 DDR4 3200MHz (OC)");
            pcDetailsArrayList.add("ASUS ROG CROSSHAIR VIII FORMULA X570 AMD socket AM4");
            pcDetailsArrayList.add("ASUS ROG STRIX Z690-G GAMING WIFI Intel Z690 socket 1700 DDR5");
            pcDetailsArrayList.add("ASUS PRIME Z690-P WIFI D4 Intel PRIME Z690-P socket 1700 DDR4");
            pcDetailsArrayList.add("ASUS ROG STRIX Z690-F GAMING WF Intel Z690 socket 1700 DDR5");
            pcDetailsArrayList.add("ASUS PRIME Z690M-PLUS D4 Intel Z690 socket 1700 DDR4 5333MHz");
            pcDetailsArrayList.add("ASUS PRIME Z690-A Intel Z690 socket 1700 DDR5 6000MHz (OC)");
            pcDetailsArrayList.add("ASUS ProArt X570-CREATOR WIFI AMD X570 AM4 socket DDR4");
            pcDetailsArrayList.add("ASUS PRIME B460I-PLUS INTEL B460 socket 1200 DDR4");
            pcDetailsArrayList.add("ASUS EX-H510M-V3 INTEL H510 socket 1200 DDR4 3200MHz(O.C)");
            pcDetailsArrayList.add("ASUS TUF GAMING A520M PLUS II socket AM4 AMD Ryzen DDR4");
            pcDetailsArrayList.add("ASUS TUF GAMING A520M PLUS WIFI socket AM4 AMD Ryzen DDR4");
            pcDetailsArrayList.add("ASUS TUF GAMING B560M-E Intel B560 socket 1200 DDR4 5000MHz");
            pcDetailsArrayList.add("ASUS PRIME A520M-A II A520 socket AM4 AMD Ryzen DDR4 4800MHz4");
            pcDetailsArrayList.add("ASUS PRIME B560M-K Intel B560 socket 1200 DDR4 4800MHz(OC) M.2");
            pcDetailsArrayList.add("ASUS PRIME B560M-A Intel B560 socket 1200 DDR4 5000MHz(OC) M.2");
            pcDetailsArrayList.add("ASUS PRIME H570M-PLUS Intel H570 socket 1200 DDR4 4600MHz");
            pcDetailsArrayList.add("ASUS PRIME Z590-P Intel Z590 socket 1200 DDR4 5133MHz(OC) M.2");
            pcDetailsArrayList.add("ASUS TUF GAMING Z590-PLUS Intel Z590 socket 1200 DDR4");
            pcDetailsArrayList.add("ASUS ROG MAXIMUS XIII EXTREME Intel Z590 socket 1200");
            pcDetailsArrayList.add("ASUS ROG STRIX B550 - XE GAMING WF AM4 socket AMD Ryzen");
            pcDetailsArrayList.add("ASUS TUF GAMING B450-PLUS II AMD B450 socket AM4 Ryzen DDR4");
            pcDetailsArrayList.add("ASUS ROG CROSSHAIR VIII HERO WF AMD X570 AM4 Ryzen DDR4");
            pcDetailsArrayList.add("ASUS PRIME B450M-A II AMD B450 socket AM4 DDR4 4400MHz(O.C.)");
            pcDetailsArrayList.add("ASUS TUF GAMING B450M-PLUS II AMD B450 socket AM4 DDR4");
            pcDetailsArrayList.add("ASUS TUF GAMING X570-PRO (WI-FI) AM4 X570 AM4 DDR4 5100MHz");
            pcDetailsArrayList.add("ASUS TUF GAMING A520M-PLUS A520 socket AM4 AMD Ryzen DDR4");
            pcDetailsArrayList.add("ASUS PRIME A520M-K A520 socket AM4 AMD Ryzen DDR4 4600MHz");
            pcDetailsArrayList.add("ASUS TUF GAMING B450M-PRO S Amd B450 AM4 socket DDR4");
            pcDetailsArrayList.add("ASUS PRIME B550M-A (WI-FI) AMD B550 socket AM4 Ryzen DDR4");
            pcDetailsArrayList.add("ASUS PRIME B460M-K INTEL B460 socket 1200 DDR4 2933MHz(O.C)");
            pcDetailsArrayList.add("ASUS TUF H310M PLUS R2.0 Intel H310M socket 1151 DDR4");
            pcDetailsArrayList.add("ASUS PRIME H310M-F R2.0 Intel H310 socket 1151 DDR4");
            pcDetailsArrayList.add("ASUS ROG CROSSHAIR VIII IMPACT AMD X570 AM4 Ryzen");
            pcDetailsArrayList.add("ASUS PRIME A320M-F A320 AM4 AMD Ryzen™ DDR4 3200(O.C.) MHz");
            pcDetailsArrayList.add("ASUS PRIME X570-P AMD X570 AM4 Ryzen DDR4 4400MHz (O.C.)");
            pcDetailsArrayList.add("ASUS ROG STRIX X570-F GAMING AMD X570 AM4 Ryzen DDR4");
            pcDetailsArrayList.add("ASUS PRIME H310M-K R2.0 Intel H310 socket 1151 DDR4");
            pcDetailsArrayList.add("ASUS PRIME B365M-K Intel B365 socket 1151 DDR4");
            pcDetailsArrayList.add("ASUS TUF B450M-PRO GAMING AMD B450 socket AM4 Ryzen DDR4");
            pcDetailsArrayList.add("ASUS TUF B450-PRO GAMING AMD B450 socket AM4 Ryzen DDR4");
            pcDetailsArrayList.add("ASUS TUF B450M-PLUS GAMING AMD B450 AM4 Ryzen™ DDR4");
            pcDetailsArrayList.add("ASUS TUF B450-PLUS GAMING AMD B450 socket AM4 Ryzen™");
            pcDetailsArrayList.add("ASUS PRIME A320M-E A320 AM4 AMD Ryzen™ DDR4 3200(O.C.) MHz");
            pcDetailsArrayList.add("ASUS EX-A320M-GAMING A320  socket AM4 AMD Ryzen™DDR4");
            pcDetailsArrayList.add("ASUS PRIME A320M-K A320 AM4 AMD Ryzen™ DDR4 3200(O.C.) MHz");
            pcDetailsArrayList.add("GIGABYTE H510M H UD Intel H510 socket 1200 DDR4 3200MHz M.2");
            pcDetailsArrayList.add("GIGABYTE H610M H 3200MHz DDR4 socket1700 M.2 HDMI D-Sub");
            pcDetailsArrayList.add("GIGABYTE H610M H 3200MHz DDR4 socket1700 M.2 HDMI D-Sub");
            pcDetailsArrayList.add("GIGABYTE B560M H 3200MHz (O.C) DDR4 socket  1200 M.2 HDMI D-Sub");
            pcDetailsArrayList.add("GIGABYTE Z690 ULTRA DURABLE Intel socket1700 DDR5 6000MHz (O.C) M.2");
            pcDetailsArrayList.add("GIGABYTE B450M H UD AMD B450 socket AM4 DDR4 3600MHZ (O.C)");
            pcDetailsArrayList.add("GIGABYTE H310M H Intel H310 socket 8.-9.  1151 DDR4");
            pcDetailsArrayList.add("GIGABYTE Z590 GAMING X Intel Z590 socket 1200 DDR4 5333(O.C)");
            pcDetailsArrayList.add("GIGABYTE B460M GAMING HD Intel B460 socket 1200 DDR4 2933MHz");
            pcDetailsArrayList.add("GIGABYTE Z590 AORUS MASTER Intel Z590 socket 1200 DDR4");
            pcDetailsArrayList.add("GIGABYTE B450M S2H V2 AMD B450 socket AM4 DDR4");
            pcDetailsArrayList.add("GIGABYTE GA-A520M-S2H AMD A520 socket AM4 DDR4 5100MHz");
            pcDetailsArrayList.add("GIGABYTE B460M D2V Intel B460M socket 1200 DDR4 2933MHz M.2");
            pcDetailsArrayList.add("GIGABYTE Z490I AORUS ULTRA Intel Z490 socket 1200 DDR4");
            pcDetailsArrayList.add("GIGABYTE B550 GAMING X Amd B550 socket AM4 DDR4 4000MHz");
            pcDetailsArrayList.add("GIGABYTE H310M H 2.0 Intel H310 socket  8.-9. 1151 DDR4");
            pcDetailsArrayList.add("GIGABYTE GA-A320M-S2H A320 Socket AM4 AMD Ryzen™ DDR4");
            pcDetailsArrayList.add("MSI PRO H610M-B DDR4 Intel H610 socket 1700 3200MHz (OC) M.2");
            pcDetailsArrayList.add("MSI B450M-A PRO MAX Amd B450    socket AM4 DDR4 3466(OC) M.2");
            pcDetailsArrayList.add("MSI H510M-A PRO Intel H510      socket 1200 DDR4 3200MHz (OC) M.2");
            pcDetailsArrayList.add("MSI H310M PRO-VDH PLUS Intel H310 socket 1151 DDR4 2666");
            pcDetailsArrayList.add("MSI PRO H410M-B Intel H410 socket 1200 DDR4 2933MHz M.2 ");
            pcDetailsArrayList.add("MSI MAG B460M BAZOOKA Intel B460 socket 1200 DDR4 2933MHz");
            pcDetailsArrayList.add("MSI B550M-A PRO Amd B550 socket AM4 DDR4 4600(O.C.) M.2 ");
            pcDetailsArrayList.add("MSI PRO Z690-A Intel Z690 socket 1700 DDR4 5200MHz (OC) M.2");
            pcDetailsArrayList.add("MSI MEG Z590 UNIFY Intel Z590 socket 1200 DDR4 5600(O.C.) M.2");
            pcDetailsArrayList.add("MSI MEG Z590 ACE Intel Z590 socket1200 DDR4 5600(O.C.) M.2 ");
            pcDetailsArrayList.add("MSI B550-A PRO Amd B550  socket AM4 DDR4 4400MHz M.2");
            pcDetailsArrayList.add("MSI MAG B660 TOMAHAWK WIFI DDR4 Intel B660 socket 1700 DDR4");
            pcDetailsArrayList.add("MSI PRO Z690-A WIFI Intel Z690 socket 1700 DDR5 6400MHz (OC)");
            pcDetailsArrayList.add("MSI MEG Z590 ACE GOLD EDITION Intel Z590  1200 DDR4");
            pcDetailsArrayList.add("MSI MPG Z590 GAMING PLUS Intel Z590 socket 1200 DDR4 5333MHz");
            pcDetailsArrayList.add("MSI H310M PRO-M2 PLUS Intel H310  socket 1151 DDR4 2666 M.2");
            pcDetailsArrayList.add("MSI MPG B550 GAMING PLUS Amd B550 socket AM4 DDR4 4400(OC)");
            pcDetailsArrayList.add("MSI MPG Z690 EDGE WIFI Intel Z690 socket 1700 DDR5 6400MHz");
            pcDetailsArrayList.add("MSI PRO H610M-G Intel H610        socket 1700 DDR4 3200MHz (OC) M.2");
            pcDetailsArrayList.add("MSI PRO B660M-E Intel B660        socket 1700 DDR4 4600MHz (OC) M.2");
            pcDetailsArrayList.add("MSI PRO B660M-B Intel B660        socket 1700 DDR4 4600MHz (OC) M.2");
            pcDetailsArrayList.add("MSI PRO B660M-A WIFI Intel B660   socket 1700 DDR4 4800MHz (OC)");
            pcDetailsArrayList.add("MSI MAG B660M MORTAR WIFI Intel B660socket 1700 DDR5 6200MHz");
            pcDetailsArrayList.add("MSI MPG Z690 EDGE WIFI Intel Z690 socket 1700 DDR4 5200MHz");
            pcDetailsArrayList.add("MSI H510M PRO Intel H510          socket 1200 DDR4 3200MHz (OC) M.2");
            pcDetailsArrayList.add("MSI MPG Z590 GAMING EDGE WIFI Intel Z590 socket 1200 DDR4");
            pcDetailsArrayList.add("MSI B460M PRO-VDH Intel B460      socket 1200 DDR4 2933(O.C.) M.2");
            pcDetailsArrayList.add("MSI MAG B460 TORPEDO              socket 1200 DDR4 2933(O.C.) M.2 ");
            pcDetailsArrayList.add("MSI MPG B550 GAMING CARBON WIFI Amd B550 socket AM4 DDR4 5100(O.C.) M.2 ");
            pcDetailsArrayList.add("MSI B460M-A PRO Intel B460        socket 1200 DDR4 2933(OC) M.2 ");
            pcDetailsArrayList.add("MSI B450M PRO-M2 MAX Amd B450 socket AM4 DDR4 3466(OC) M.2");
            pcDetailsArrayList.add("MSI A320M-A PRO Amd A320 socket AM4 DDR4 3200(OC) ");
            pcDetailsArrayList.add("MSI H610M BOMBER DDR4 3200MHz(OC) socket 1700 M.2 HDMI");
            pcDetailsArrayList.add("MSI PRO B660M-P WIFI DDR4 Intel B660 socket 1700 DDR4 4600MHz");
            pcDetailsArrayList.add("MSI B660 BOMBER DDR4 4600MHz (OC) DDR4 socket 1700 M.2 HDMI");
            pcDetailsArrayList.add("MSI PRO B660M-P DDR4 Intel B660 socket 1700 DDR4 4600MHz (OC) M.2");
            pcDetailsArrayList.add("MSI PRO B550M-P GEN3 B550 socket AM4 DDR4 4400MHz (OC) M.2");
            pcDetailsArrayList.add("MSI PRO B550-P GEN3 B550 socket AM4 DDR4 4400MHz (OC) M.2");
            pcDetailsArrayList.add("MSI H510I PRO WIFI 3200MHz DDR4 socket 1200 M.2 HDMI mITX");
            pcDetailsArrayList.add("MSI MAG B660M BAZOOKA 4800MHz(OC) DDR4 socket 1700 M.2");
            pcDetailsArrayList.add("MSI PRO B660-A Intel B660 socket 1700 DDR4 4800MHz (OC) M.2");
            pcDetailsArrayList.add("MSI PRO B660M-A WIFI Intel B660 socket 1700 DDR5 6200MHz (OC)");
            pcDetailsArrayList.add("MSI MAG H670 TOMAHAWK WIFI Intel H670 socket 1700 DDR4");
            pcDetailsArrayList.add("MSI PRO B660M-A DDR4 Intel B660 socket 1700 DDR4 4600MHz (OC)");
            pcDetailsArrayList.add("MSI PRO B660M-A DDR4 Intel B660 socket 1700 DDR4 4600MHz (OC)");
            pcDetailsArrayList.add("MSI MAG Z690 TOMAHAWK WIFI Intel Z690 socket 1700 DDR5");
            pcDetailsArrayList.add("MSI PRO B660M-G Intel B660 socket 1700 DDR4 4600MHz (OC) M.2");
            pcDetailsArrayList.add("MSI MAG B660M MORTAR Intel B660 socket 1700 DDR5 6200MHz");
            pcDetailsArrayList.add("MSI MAG B660 TOMAHAWK WIFI Intel B660 socket 1700 DDR5");
            pcDetailsArrayList.add("MSI MAG Z690M MORTAR WIFI Intel Z690 socket 1700 DDR5 6200MHz");
            pcDetailsArrayList.add("MSI MAG B660M MORTAR DDR4 Intel B660 socket 1700 DDR4");
            pcDetailsArrayList.add("MSI MAG B660M MORTAR WIFI DDR4 Intel B660 socket 1700 DDR4");
            pcDetailsArrayList.add("MSI H510M PRO-E Intel H510 socket 1200 DDR4 3200MHz (OC)");
            pcDetailsArrayList.add("MSI PRO Z690-P DDR4 Intel Z690  socket 1700 DDR4 5200MHz(OC) M.2");
            pcDetailsArrayList.add("MSI MAG Z690 TORPEDO Intel Z690 socket 1700 DDR5 6400MHz(OC)");
            pcDetailsArrayList.add("MSI MAG Z690 TOMAHAWK WIFI DDR4 Intel Z690 socket 1700 DDR4");
            pcDetailsArrayList.add("MSI MEG X570S UNIFY-X MAX Amd X570 socket AM4 DDR4");
            pcDetailsArrayList.add("MSI PRO Z690-A WIFI Intel Z690 socket 1700 DDR4 5200MHz (OC)");
            pcDetailsArrayList.add("MSI PRO Z690-A Intel Z690 socket 1700 DDR5 6400MHz (OC) M.2");
            pcDetailsArrayList.add("MSI MPG Z690 FORCE WIFI Intel Z690 socket 1700 DDR5 6666MHz");
            pcDetailsArrayList.add("MSI MPG Z690 CARBON WIFI Intel Z690 socket 1700 DDR5 6666MHz");
            pcDetailsArrayList.add("MSI B560-A PRO Intel B560 socket 1200 DDR4 5066MHz (OC) M.2");
            pcDetailsArrayList.add("MSI MPG X570S CARBON MAX WIFI Amd X570 socket AM4 DDR4");
            pcDetailsArrayList.add("MSI MPG X570S EDGE MAX WIFI Amd X570 socket AM4 DDR4");
            pcDetailsArrayList.add("MSI MEG X570S ACE MAX Amd X570 socket AM4 DDR4 5300MHz");
            pcDetailsArrayList.add("MSI MAG X570S TORPEDO MAX Amd X570 socket AM4 DDR4");
            pcDetailsArrayList.add("MSI MAG X570S TOMAHAWK MAX WIFI Amd X570 socket AM4 DDR4");
            pcDetailsArrayList.add("MSI A320M PRO-VH Amd A320 socket AM4 DDR4 3200(OC) M.2");
            pcDetailsArrayList.add("MSI MAG B560 TORPEDO Intel B560 socket 1200 DDR4 5066MHz (OC)");
            pcDetailsArrayList.add("MSI MAG B560M MORTAR Intel B560 socket 1200 DDR4 5066MHz");
            pcDetailsArrayList.add("MSI MAG B560 TOMAHAWK WIFI Intel B560 socket 1200 DDR4");
            pcDetailsArrayList.add("MSI Z590 PLUS Intel Z590 socket 1200 DDR4 5333MHz (OC) M.2");
            pcDetailsArrayList.add("MSI MAG Z590 TOMAHAWK WIFI Intel Z590 socket 1200 DDR4");
            pcDetailsArrayList.add("MSI B450 TOMAHAWK MAX II Amd B450 socket AM4 DDR4 4333MHz");
            pcDetailsArrayList.add("MSI B560M PRO WIFI Intel B560 socket 1200 DDR4 5200MHz (OC)");
            pcDetailsArrayList.add("MSI MAG B560M MORTAR WIFI Intel B560 socket 1200 DDR4 5066MHz");
            pcDetailsArrayList.add("MSI B560M-A PRO Intel B560 socket 1200 DDR4 5200MHz (OC) M.2");
            pcDetailsArrayList.add("MSI B560M PRO-E Intel B560 socket 1200 DDR4 4800MHz (OC) M.2 ");
            pcDetailsArrayList.add("MSI B560M PRO Intel B560 socket 1200 DDR4 5200MHz (OC) M.2");
            pcDetailsArrayList.add("MSI MAG B560M BAZOOKA Intel B560 socket 1200 DDR4 5066MHz");
            pcDetailsArrayList.add("MSI MPG Z590 GAMING FORCE Intel Z590 socket 1200 DDR4");
            pcDetailsArrayList.add("MSI MAG Z590 TORPEDO Intel Z590 socket 1200 DDR4 5333(O.C.) M.2");
            pcDetailsArrayList.add("MSI B560M PRO-VDH Intel B560M socket 1200 DDR4 5066(O.C.) M.2");
            pcDetailsArrayList.add("MSI B560M PRO-VDH WIFI Intel B560M socket 1200 DDR4 5066(O.C.) M.2");
            pcDetailsArrayList.add("MSI MEG B550 UNIFY Amd B550 socket AM4 DDR4 5600MHz (OC) M.2");
            pcDetailsArrayList.add("MSI MPG Z590-A PRO Intel Z590 socket 1200 DDR4 5333MHz (OC)");
            pcDetailsArrayList.add("MSI MPG Z590 PRO WIFI Intel Z590 socket 1200 DDR4 5333MHz (OC)");
            pcDetailsArrayList.add("MSI MPG Z590 GAMING CARBON WIFI Intel Z590  socket 1200 DDR4");
            pcDetailsArrayList.add("MSI B550M PRO Amd B550 socketAM4 DDR4 4600(O.C.) M.2");
            pcDetailsArrayList.add("MSI MEG B550 UNIFY-X Amd B550 socket AM4 DDR4 5800MHz(OC) M.2");
            pcDetailsArrayList.add("MSI B550M PRO-VDH Amd B550 socket AM4 DDR4 4400(O.C.) M.2");
            pcDetailsArrayList.add("MSI MAG A520M VECTOR WIFI Amd A520 socket AM4 DDR4 4600");
            pcDetailsArrayList.add("MSI A520M PRO Amd A520  socket AM4 DDR4 4600 MHz(OC) M.2");
            pcDetailsArrayList.add("MSI A520M-A PRO Amd A520 socket AM4 DDR4 4600 MHz(OC) M.2");
            pcDetailsArrayList.add("MSI MAG X570 TOMAHAWK WIFI Amd X570 socket AM4 DDR4");
            pcDetailsArrayList.add("MSI H410M PRO Intel H410 socket 1200 DDR4 2933MHz M.2 ");
            pcDetailsArrayList.add("MSI B550M PRO-VDH WIFI Amd B550 socket AM4 DDR4 4400(O.C.) M.2");
            pcDetailsArrayList.add("MSI MAG B460 TOMAHAWK Intel B460 socket 1200 DDR4 2933MHz");
            pcDetailsArrayList.add("MSI MPG B550 GAMING EDGE WIFI Amd B550 socket AM4 DDR4");
            pcDetailsArrayList.add("MSI MAG B550M MORTAR WIFI Amd B550M socket AM4 DDR4 4400(OC)");
            pcDetailsArrayList.add("MSI MAG B550M MORTAR Amd B550M socket AM4 DDR4 4400(OC)");
            pcDetailsArrayList.add("MSI MAG B550 TOMAHAWK Amd B550 socket AM4 DDR4 5100(OC)");
            pcDetailsArrayList.add("MSI B460M PRO-VDH WIFI Intel B460 socket 1200 DDR4 2933(OC)");
            pcDetailsArrayList.add("MSI MAG B460M MORTAR WIFI Intel B460 socket 1200 DDR4 2933(OC) M.2 ");
            pcDetailsArrayList.add("MSI MAG B460M MORTAR Intel B460 socket 1200 DDR4 2933(OC)");
            pcDetailsArrayList.add("MSI Z490-A PRO Intel Z490 socket 1200 DDR4 4800(OC) M.2 ");
            pcDetailsArrayList.add("MSI MAG Z490 TOMAHAWK Intel Z490 socket 1200 DDR4 4800(OC)");
            pcDetailsArrayList.add("MSI X299 PRO Intel X299 socket 2066 DDR4 4200(OC) M.2 ");
            pcDetailsArrayList.add("MSI MEG X570 UNIFY Amd X570 socket AM4 DDR4 4600(OC) M.2");
            pcDetailsArrayList.add("MSI A320M-A PRO MAX Amd A320 socket AM4 DDR4 3200(OC) M.2");
            pcDetailsArrayList.add("MSI B450-A PRO MAX Amd B450 socket AM4 DDR4 3466(OC) M.2");
            pcDetailsArrayList.add("MSI B450 GAMING PLUS MAX Amd B450 socket AM4 DDR4 3466(OC)");
            pcDetailsArrayList.add("MSI B450 TOMAHAWK MAX Amd B450 socket AM4 DDR4 3466(OC)");
            pcDetailsArrayList.add("MSI X570-A PRO Amd X570 socket AM4 DDR4 4000(OC) M.2 ");
            pcDetailsArrayList.add("MSI MPG X570 GAMING PLUS Amd X570 socket AM4 DDR4 4400(OC)");
            pcDetailsArrayList.add("MSI MPG X570 GAMING EDGE WIFI Amd X570 socket AM4 DDR4");
            pcDetailsArrayList.add("MSI MEG X570 ACE Amd X570 socket AM4 DDR4 4600(OC) M.2 ");
            pcDetailsArrayList.add("MSI B365M PRO-VH Intel B365 socket 1151 DDR4 2666 M.2");
            pcDetailsArrayList.add("MSI Z390-A PRO Intel Z390 socket 1151 DDR4 4400(OC) M.2 ");
        }
        else if (parcaAdi.equals("Ekran kartı") || parcaAdi.equals("Graphics Cards"))
        {
            pcDetailsArrayList.add("ASUS TUF GeForce GTX 1660 TI EVO OC 6GB GDDR6 192Bit DX12");
            pcDetailsArrayList.add("ASUS GeForce TUF RTX 3060 GAMING V2 OC 12GB GDDR6");
            pcDetailsArrayList.add("ASUS GeForce GT710 1GB GDDR5 32Bit Nvidia DX12 ");
            pcDetailsArrayList.add("ASUS GeForce TUF GTX 1650 GAMING OC 4GB GDDR6 128Bit");
            pcDetailsArrayList.add("ASUS GeForce TUF RTX 3080 GAMING OC 12GB GDDR6X 384Bit");
            pcDetailsArrayList.add("ASUS GeForce DUAL RTX 3060 OC V2 12GB GDDR6 192Bit NVIDIA");
            pcDetailsArrayList.add("ASUS GeForce TUF RTX 3080 Ti GAMING OC 12GB GDDR6X 384Bit");
            pcDetailsArrayList.add("ASUS GeForce TUF GTX 1650 4GD6 GAMING 4GB GDDR6 128Bit Nvidia");
            pcDetailsArrayList.add("ASUS GeForce TUF GTX 1660 SUPER GAMING OC 6GB GDDR6");
            pcDetailsArrayList.add("ASUS GeForce GTX 1660 SUPER EVO OC 6GB GDDR6 192Bit DX12");
            pcDetailsArrayList.add("ASUS GeForce GTX 1050 Ti CERBERUS OC 4GB GDDR5 128Bit");
            pcDetailsArrayList.add("Asus GeForce GT1030 GDDR5 OC 2GB 64Bit NVIDIA DX12 ");
            pcDetailsArrayList.add("Asus GeForce GT730 2GB GDDR5 64Bit NVIDIA DX12 ");
            pcDetailsArrayList.add("ASUS GeForce GTX 1050 TI CERBERUS 4GB GDDR5 128Bit");
            pcDetailsArrayList.add("ASUS GeForce TUF GTX 1650 4GD6-P GAMING 4GB GDDR6 128Bit Nvidia DX12");
            pcDetailsArrayList.add("ASUS GeForce TUF RTX 3090 GAMING OC 24GB GDDR6X 384Bit");
            pcDetailsArrayList.add("ASUS GeForce TUF GTX 1650 SUPER GAMING OC 4GB GDDR6");
            pcDetailsArrayList.add("Asus GeForce GT1030 GDDR5 2GB 64Bit NVIDIA DX12 ");
            pcDetailsArrayList.add("ASUS GeForce GTX1050 Ti GDDR5 4GB 128Bit NVIDIA ");
            pcDetailsArrayList.add("ASUS GeForce TUF-RTX3050-O8G-GAMING 8GB GDDR6 128Bit");
            pcDetailsArrayList.add("ASUS GeForce RTX 3080 NOCTUA 10GB OC GDDR6X 320Bit DX12");
            pcDetailsArrayList.add("ASUS GeForce DUAL RTX 3060 V2 12GB GDDR6 192Bit NVIDIA");
            pcDetailsArrayList.add("Asus GeForce GTX 1650 4GB GDDR5 128Bit DX12 Nvidia");
            pcDetailsArrayList.add("Asus GeForce GT730 SL-2GD5-BRK-E DDR5 2GB 64Bit NVIDIA DX12");
            pcDetailsArrayList.add("ASUS GeForce RTX 3070 8GB GDDR6 256Bit DX12 Nvidia ");
            pcDetailsArrayList.add("ASUS GeForce TUF GTX 1650 4GD6 GAMING OC 4GB GDDR6 128Bit");
            pcDetailsArrayList.add("ASUS GeForce TUF RTX 3090 TI GAMING OC 24GB GDDR6X 384Bit");
            pcDetailsArrayList.add("ASUS GeForce DUAL RTX 2060 EVO 12GB GDDR6 192Bit Nvidia ");
            pcDetailsArrayList.add("ASUS GeForce DUAL RTX 3050 8GB GDDR6 128Bit Nvidia ");
            pcDetailsArrayList.add("ASUS GeForce RTX 3050 Phoenix 8GB GDDR6 128Bit Nvidia");
            pcDetailsArrayList.add("ASUS GeForce RTX 3050 Phoenix 8GB GDDR6 128Bit Nvidia");
            pcDetailsArrayList.add("ASUS GeForce TUF GTX 1660 TI EVO 6GB GDDR6 192Bit DX12");
            pcDetailsArrayList.add("ASUS GeForce GT1030 DDR4 2GB 64Bit NVIDIA ");
            pcDetailsArrayList.add("ASUS GeForce ROG STRIX RTX 3070 GAMING V2 OC 8GB GDDR6");
            pcDetailsArrayList.add("ASUS GeForce TUF RTX 3070 GAMING OC 8GB GDDR6 256Bit");
            pcDetailsArrayList.add("ASUS GeForce DUAL RTX 3060 Ti MIN OC 8GB GDDR6 256Bit DX12");
            pcDetailsArrayList.add("Asus GeForce GT730 DDR5 2GB 64Bit NVIDIA DX12 ");
            pcDetailsArrayList.add("ASUS GeForce DUAL RTX 3060 Ti OC 8GB GDDR6 256Bit DX12 Nvidia");
            pcDetailsArrayList.add("ASUS GeForce RTX 3060 Phoenix 12GB GDDR6 192Bit DX12 Nvidia");
            pcDetailsArrayList.add("ASUS GeForce TUF RTX 3070 Ti GAMING OC 8GB GDDR6X 256Bit");
            pcDetailsArrayList.add("ASUS GeForce ROG STRIX RTX 3070 Ti GAMING OC 8GB GDDR6X");
            pcDetailsArrayList.add("ASUS GeForce RTX 3060 Phoenix 12GB GDDR6 192Bit DX12 Nvidia");
            pcDetailsArrayList.add("ASUS GeForce GTX 1650 Phoenix OC 4GB GDDR6 128Bit DX12 Nvidia");
            pcDetailsArrayList.add("ASUS GeForce ROG STRIX RTX 3090 GAMING OC 24GB GDDR6X");
            pcDetailsArrayList.add("ASUS GeForce TUF RTX 3090 GAMING 24GB GDDR6X 384Bit DX12 Nvidia ");
            pcDetailsArrayList.add("ASUS GeForce TUF GTX 1660 SUPER GAMING 6GB GDDR6 192Bit");
            pcDetailsArrayList.add("ASUS GeForce GT710 1GB GDDR5 32Bit Nvidia DX12");
            pcDetailsArrayList.add("ASUS GeForce GT710 2GB DDR5 64Bit Nvidia DX12 ");
            pcDetailsArrayList.add("ASUS GeForce GTX 1660 SUPER Phoenix OC 6GB DDR6 192Bit DX12");
            pcDetailsArrayList.add("ASUS GeForce GTX 1650 Phoenix OC 4GB GDDR5 128Bit DX12 Nvidia");
            pcDetailsArrayList.add("ASUS GeForce DUAL GTX1650 4GB GDDR5 128Bit DX12 Nvidia ");
            pcDetailsArrayList.add("ASUS GeForce DUAL GTX 1650 OC 4GB GDDR5 128Bit DX12 Nvidia");
            pcDetailsArrayList.add("ASUS GeForce GT1030 GDDR5 2GB 64Bit NVIDIA ");
            pcDetailsArrayList.add("EVGA GeForce RTX 3090 FTW3 ULTRA GAMING 24GB GDDR6X");
            pcDetailsArrayList.add("EVGA RTX 3080 XC3 ULTRA GAMING 12GB GDDR6X RGB LED");
            pcDetailsArrayList.add("EVGA GeForce RTX 3070 FTW3 ULTRA GAMING 8GB GDDR6 256Bit");
            pcDetailsArrayList.add("EVGA GeForce GTX 1660 SC ULTRA GAMING 6GB GDDR5 192Bit Nvidia");
            pcDetailsArrayList.add("EVGA GeForce RTX 3050 XC GAMING 8GB GDDR6 128Bit Nvidia");
            pcDetailsArrayList.add("EVGA GeForce RTX 3090 Ti FTW3 ULTRA GAMING 24GB GDDR6X");
            pcDetailsArrayList.add("EVGA GeForce RTX 3080 Ti FTW3 ULTRA GAMING 12GB GDDR6X");
            pcDetailsArrayList.add("EVGA GeForce GTX 1660 SUPER SC ULTRA GAMING 6GB GDDR6");
            pcDetailsArrayList.add("EVGA RTX 3090 Ti FTW3 BLACK GAMING 24GB GDDR6X ARGB ");
            pcDetailsArrayList.add("EVGA RTX 3080 FTW3 ULTRA GAMING 12GB GDDR6X ARGB");
            pcDetailsArrayList.add("EVGA GeForce RTX 2060 SC OVERCLOCKED 6GB GDDR6 192 bit Nvidia");
            pcDetailsArrayList.add("EVGA GeForce RTX 3090 Ti FTW3 GAMING 24GB GDDR6X 384Bit");
            pcDetailsArrayList.add("EVGA GeForce RTX 3090 XC3 ULTRA GAMING 24GB GDDR6X 384Bit ARGB ");
            pcDetailsArrayList.add("EVGA GeForce RTX 3080 Ti XC3 ULTRA GAMING 12GB GDDR6X");
            pcDetailsArrayList.add("EVGA GeForce RTX 3080 FTW3 ULTRA GAMING 10GB GDDR6X");
            pcDetailsArrayList.add("GIGABYTE GeForce GTX 1660 TI OC 6GB GDDR6 192Bit DX12 Nvidia");
            pcDetailsArrayList.add("GIGABYTE GeForce RTX 3090 Ti GAMING 24G 24GB GDDR6X 384 Bit");
            pcDetailsArrayList.add("GIGABYTE GEFORCE RTX 2060 GAMING OC 12GB GDDR6 192Bit");
            pcDetailsArrayList.add("GIGABYTE GEFORCE RTX 3080 GAMING OC 12GB GDDR6X 384Bit");
            pcDetailsArrayList.add("GIGABYTE GeForce RTX 3070 Ti MASTER 8GB GDDR6X 256Bit");
            pcDetailsArrayList.add("GIGABYTE GeForce RTX 3080 Ti EAGLE OC 12GB GDDR6X 384Bit");
            pcDetailsArrayList.add("GIGABYTE GeForce RTX 3070 Ti GAMING OC 8GB GDDR6X 256Bit");
            pcDetailsArrayList.add("GIGABYTE GeForce RTX 3080 Ti GAMING OC 12GB GDDR6X 384Bit");
            pcDetailsArrayList.add("GIGABYTE GeForce RTX 3090 GAMING OC 24GB GDDR6X 384Bit");
            pcDetailsArrayList.add("GIGABYTE GeForce RTX 3070 AORUS MASTER 8GB GDDR6");
            pcDetailsArrayList.add("GIGABYTE GeForce RTX 3080 GAMING OC 10GB GDDR6X 320Bit");
            pcDetailsArrayList.add("GIGABYTE GeForce GTX 1660 SUPER OC 6GB GDDR6 192Bit");
            pcDetailsArrayList.add("GIGABYTE GeForce RTX 3080 Ti GAMING OC 12GB GDDR6X 384Bit");
            pcDetailsArrayList.add("ZOTAC GeForce RTX 3060 TWIN EDGE GAMING OC 12GB GDDR6");
            pcDetailsArrayList.add("ZOTAC GeForce RTX 3080 GAMING TRINTY OC 10GB GDDR6X");
            pcDetailsArrayList.add("ZOTAC GeForce RTX 3070 TWIN EDGE GAMINGOC 8GB GDDR6");
            pcDetailsArrayList.add("ZOTAC GeForce RTX 3060 Ti TWINEDGE GAMING 8GB GDDR6");
            pcDetailsArrayList.add("ZOTAC GeForce RTX 3080 Ti GAMING AMP HOLO 12GB GDDR6X");
            pcDetailsArrayList.add("ZOTAC GeForce RTX 3080 Ti GAMING TRINTY OC 12GB GDDR6X");
            pcDetailsArrayList.add("ZOTAC GTX 1660 Super GDDR6 6GB 192Bit Nvidia GeForce DX12 ");
            pcDetailsArrayList.add("GIGABYTE GeForce RTX 3080 GAMING OC 10GB GDDR6X 320Bit");
            pcDetailsArrayList.add("GIGABYTE GeForce GTX 1660 SUPER OC 6GB GDDR6 192Bit");
            pcDetailsArrayList.add("GIGABYTE GeForce RTX 3080 Ti GAMING OC 12GB GDDR6X 384Bit");
            pcDetailsArrayList.add("ASUS RADEON DUAL RX 6600-8G 8GB 128Bit AMD ");
            pcDetailsArrayList.add("ASUS RADEON DUAL RX 6400 4GB GDDR6 64Bit AMD  ");
            pcDetailsArrayList.add("ASUS RADEON DUAL RX 6500 XT OC 4GB GDDR6 64Bit AMD ");
            pcDetailsArrayList.add("ASUS Radeon ROG STRIX RX560 GAMING 4GB GDDR5 128 Bit AMD");
            pcDetailsArrayList.add("ASUS ROG STRIX Radeon RX 6650 XT OC ARGB 8GB GDDR6 128 Bit ");
            pcDetailsArrayList.add("ASUS TUF GAMING Radeon RX 6950 XT OC Edition 16GB GDDR6");
            pcDetailsArrayList.add("ASUS RADEON DUAL RX 6650 XT OC 8GB GDRR6 128Bit AMD ");
            pcDetailsArrayList.add("ASUS RADEON DUAL RX 6750 XT OC 12GB GDDR6 192Bit AMD");
            pcDetailsArrayList.add("ASUS RADEON ROG STRIX RX 6750 XT OC GAMING 12GB GDDR6");
            pcDetailsArrayList.add("ASUS RADEON RX560 DUAL 4GB GDDR5 128 Bit AMD");
            pcDetailsArrayList.add("ASUS RADEON RX 6400 4GB GDDR6 64Bit AMD ");
            pcDetailsArrayList.add("ASUS RADEON 550 Phoenix 2GB GDDR5 64Bit AMD ");
            pcDetailsArrayList.add("ASUS RADEON TUF RX 6500 XT GAMING OC 4GB GDDR6 64Bit AMD");
            pcDetailsArrayList.add("ASUS RADEON ROG STRIX RX 6600 XT OC GAMING 8GB GDDR6");
            pcDetailsArrayList.add("ASUS RADEON DUAL RX 6600 XT OC 8GB GDDR6 128Bit AMD ");
            pcDetailsArrayList.add("ASUS RADEON TUF RX 6800 GAMING OC 16GB GDDR6 256Bit");
            pcDetailsArrayList.add("ASUS RADEON TUF RX 6800 XT OC 16GB GAMING GDDR6 256Bit DX12");
            pcDetailsArrayList.add("ASUS RADEON RX 550 4G EVO Phoenix 4G GDD5 128bit DX12 AMD");
            pcDetailsArrayList.add("MSI RADEON RX 6800 XT GAMING Z TRIO 16GB GDDR6 256bit AMD");
            pcDetailsArrayList.add("MSI RADEON RX 6600 ARMOR 8G 8GB GDDR6 128Bit AMD ");
            pcDetailsArrayList.add("MSI RADEON RX 6700 XT MECH 2X 12GB GDDR6 192Bit AMD ");
            pcDetailsArrayList.add("MSI RADEON RX 6500 XT MECH 2X 4G OC GDDR6 64bit DX12 AMD");
            pcDetailsArrayList.add("MSI RADEON RX 6900 XT GAMING Z TRIO 16GB GDDR6 256bit AMD");
            pcDetailsArrayList.add("MSI RADEON RX 6800 GAMING X TRIO 16GB GDDR6 256bit AMD");
            pcDetailsArrayList.add("MSI RADEON RX 6750 XT GAMING X TRIO 12G GDDR6 192Bit AMD");
            pcDetailsArrayList.add("MSI RADEON RX 6750 XT MECH 2X 12G OC GDDR6 192Bit AMD ");
            pcDetailsArrayList.add("MSI RADEON RX 6650 XT MECH 2X OC 8GB GDDR6 128 Bit AMD");
            pcDetailsArrayList.add("MSI RADEON RX 6400 AERO ITX 4GB GDDR6 64 Bit AMD");
            pcDetailsArrayList.add("MSI RADEON RX 6950 XT GAMING TRIO 16GB GDDR6 256 Bit AMD");
            pcDetailsArrayList.add("MSI RADEON RX 6600 XT MECH 2X 8G OC GDDR6 128Bit AMD");
            pcDetailsArrayList.add("MSI RADEON RX 6600 XT GAMING X 8GB GDDR6 128Bit AMD ");
            pcDetailsArrayList.add("MSI RADEON RX 6700 XT MECH 2X 12G OC GDDR6 192Bit AMD");
            pcDetailsArrayList.add("MSI RADEON RX 6700 XT GAMING X 12GB GDDR6 192Bit AMD");
            pcDetailsArrayList.add("MSI RADEON RX 6800 XT GAMING X TRIO 16GB GDDR6 256bit AMD");
            pcDetailsArrayList.add("GIGABYTE RADEON RX 6600 XT EAGLE 8GB GDDR6 128Bit AMD");
            pcDetailsArrayList.add("GIGABYTE RADEON RX 6800 GAMING OC 16GB GDDR6 256Bit");
            pcDetailsArrayList.add("GIGABYTE RADEON RX 6700 XT GAMING OC 12GB GDDR6 192Bit");
            pcDetailsArrayList.add("MSI GEFORCE RTX 3060 VENTUS 2X OC 12GB GDDR6 192bit NVIDIA");
            pcDetailsArrayList.add("MSI GEFORCE RTX 3090 TI SUPRIM X 24GB GDDR6X 384bit");
            pcDetailsArrayList.add("MSI GEFORCE GTX 1650 4GT LP OC 4GB GDDR5 128bit NVIDIA");
            pcDetailsArrayList.add("MSI GEFORCE RTX 2060 VENTUS 12G OC 12GB GDDR6 192bit NVIDIA");
            pcDetailsArrayList.add("MSI GEFORCE GTX 1660 SUPER GAMING X 6GB GDDR6 192bit");
            pcDetailsArrayList.add("MSI GEFORCE RTX 3050 GAMING X 8G GDDR6 128Bit NVIDIA ");
            pcDetailsArrayList.add("MSI GEFORCE RTX 3050 VENTUS 2X 8GB GDDR6 128Bit NVIDIA ");
            pcDetailsArrayList.add("MSI GEFORCE RTX 3060 TI GAMING Z TRIO 8GB LHR GDDR6 256bit NVIDIA ");
            pcDetailsArrayList.add("MSI GEFORCE RTX 2060 VENTUS GP OC 6GB GDDR6 192Bit NVIDIA");
            pcDetailsArrayList.add("MSI GEFORCE GTX 1650 VENTUS XS 4G OC 4GB GDDR5 128bit");
            pcDetailsArrayList.add("MSI GEFORCE GTX 1050 TI 4GT LP 4GB GDDR5 128bit NVIDIA");
            pcDetailsArrayList.add("MSI GEFORCE RTX 3060 AERO ITX 12G OC 12GB GDDR6 192Bit");
            pcDetailsArrayList.add("MSI GEFORCE RTX 3090 TI GAMING X TRIO 24G 24GB GDDR6X 384Bit NVIDIA ");
            pcDetailsArrayList.add("MSI GEFORCE RTX 3060 GAMING Z TRIO 12GB GDDR6 192bit NVIDIA");
            pcDetailsArrayList.add("MSI GEFORCE RTX 3080 TI GAMING X TRIO 12GB GDDR6X");
            pcDetailsArrayList.add("MSI GEFORCE GTX 1660 SUPER VENTUS XS OC 6GB GDDR6 192bit");
            pcDetailsArrayList.add("MSI GEFORCE GT 710 1GD3H LP 1GB DDR3 64bit NVIDIA ");
            pcDetailsArrayList.add("MSI GEFORCE RTX 2060 VENTUS GP 6GB GDDR6 192Bit NVIDIA");
            pcDetailsArrayList.add("MSI GEFORCE RTX 3080 VENTUS 3X PLUS 10G LHR GDDR6X 320Bit");
            pcDetailsArrayList.add("MSI GeForce RTX 3070 SUPRIM 8GB GDDR6 256 Bit LHR ");
            pcDetailsArrayList.add("MSI GeForce GTX 1650 D6 AERO ITX OCV1 4GB GDDR6 128 Bit");
            pcDetailsArrayList.add("MSI GEFORCE RTX 3090 TI BLACK TRIO 24GB GDDR6X 384 Bit NVIDIA ");
            pcDetailsArrayList.add("MSI GEFORCE GTX 1650 D6 AERO ITX 4G OC GDDR6 128bit NVIDIA");
            pcDetailsArrayList.add("MSI GEFORCE GT 730 2GD3 LP 2GB DDR3 64Bit NVIDIA ");
            pcDetailsArrayList.add("MSI GEFORCE RTX 3050 VENTUS 2X 8GB OC GDDR6 128Bit NVIDIA");
            pcDetailsArrayList.add("MSI GEFORCE RTX 3080 GAMING Z TRIO 12G LHR GDDR6X 384Bit");
            pcDetailsArrayList.add("MSI GEFORCE RTX 3080 VENTUS 3X PLUS 12G OC LHR GDDR6X");
            pcDetailsArrayList.add("MSI GEFORCE RTX 3080 VENTUS 3X PLUS 10G OC LHR GDDR6X");
            pcDetailsArrayList.add("MSI GEFORCE GT 730 2GD3H LP 2GB DDR3 64bit NVIDIA ");
            pcDetailsArrayList.add("MSI GEFORCE RTX 3050 AERO ITX 8G OC GDDR6 128Bit NVIDIA ");
            pcDetailsArrayList.add("MSI GEFORCE RTX 3070 VENTUS 3X OC LHR 8GB GDDR6 256Bit NVIDIA ");
            pcDetailsArrayList.add("MSI GEFORCE RTX 3050 AERO ITX 8GB GDDR6 128Bit NVIDIA ");
            pcDetailsArrayList.add("MSI GEFORCE RTX 3060 TI VENTUS 3X OC LHR 8GB GDDR6");
            pcDetailsArrayList.add("MSI GEFORCE RTX 3070 GAMING Z TRIO 8G LHR 8GB GDDR6 256bit");
            pcDetailsArrayList.add("MSI GEFORCE RTX 3070 VENTUS 2X 8G OC LHR 8GB GDDR6 256bit");
            pcDetailsArrayList.add("MSI GEFORCE RTX 3080 SUPRIM X LHR 10GB GDDR6X 320bit NVIDIA");
            pcDetailsArrayList.add("MSI GEFORCE RTX 3080 TI VENTUS 3X 12GB GDDR6X 384Bit");
            pcDetailsArrayList.add("MSI GEFORCE RTX 3070 SUPRIM X 8G LHR GDDR6 256bit NVIDIA");
            pcDetailsArrayList.add("MSI GEFORCE RTX 3060 TI GAMING X LHR 8GB GDDR6 256Bit");
            pcDetailsArrayList.add("MSI GEFORCE RTX 3060 TI VENTUS 2X 8G OCV1 LHR GDDR6");
            pcDetailsArrayList.add("MSI GEFORCE GT 730 4GB DDR3 64Bit NVIDIA ");
            pcDetailsArrayList.add("MSI GEFORCE RTX 3080 GAMING Z TRIO 10G LHR GDDR6X 320Bit");
            pcDetailsArrayList.add("MSI GEFORCE RTX 3070 TI GAMING X TRIO 8GB GDDR6X");
            pcDetailsArrayList.add("MSI GEFORCE RTX 3070 TI SUPRIM X 8GB GDDR6X 256bit");
            pcDetailsArrayList.add("MSI GEFORCE RTX 3080 TI VENTUS 3X 12G OC GDDR6X");
            pcDetailsArrayList.add("MSI GEFORCE RTX 3080 TI SUPRIM X 12GB GDDR6X 384Bit");
            pcDetailsArrayList.add("MSI GEFORCE GT 710 2GD3H H2D 2GB DDR3 64Bit NVIDIA ");
            pcDetailsArrayList.add("MSI GEFORCE RTX 3060 VENTUS 3X 12G OC 12GB GDDR6 192Bit");
            pcDetailsArrayList.add("MSI GEFORCE RTX 3060 GAMING X 12GB GDDR6 192bit NVIDIA");
            pcDetailsArrayList.add("MSI GEFORCE RTX 3090 GAMING X TRIO 24G 24GB GDDR6X 384Bit");
            pcDetailsArrayList.add("MSI GEFORCE GTX 1660 SUPER GAMING 6GB GDDR6 192bit NVIDIA");
            pcDetailsArrayList.add("MSI GEFORCE GTX 1660 VENTUS XS 6G OC 6GB GDDR5 192bit NVIDIA");
            pcDetailsArrayList.add("MSI GEFORCE GTX 1660 TI VENTUS XS 6G OC 6GB GDDR6");
            pcDetailsArrayList.add("MSI GEFORCE GTX 1660 TI VENTUS XS 6G 6GB GDDR6 192bit");
            pcDetailsArrayList.add("MSI GEFORCE GTX 1660 TI ARMOR 6G OC 6GB GDDR6 192bit NVIDIA");
            pcDetailsArrayList.add("MSI GEFORCE GT 1030 2GHD4 LP OC 2GB DDR4 64bit NVIDIA ");
            pcDetailsArrayList.add("MSI GEFORCE GTX 1050 TI AERO ITX 4G OCV1 4GB GDDR5 128bit");
            pcDetailsArrayList.add("MSI N730-2GD3V2 2GB DDR3 128bit NVIDIA");


        } else if (parcaAdi.equals("İşlemci")|| parcaAdi.equals("Processors"))
        {
            pcDetailsArrayList.add("Intel Core i3 12100F socket 1700 12.generation 3.30GHz 12MB 10nm");
            pcDetailsArrayList.add("Intel Core i5 11400F socket 1200 11.generation 2.60GHz 12MB  14nm");
            pcDetailsArrayList.add("Intel Core i3 10100F socket 1200 10.generation 3.60GHz 6MB ");
            pcDetailsArrayList.add("Intel Core i7 12700F socket 1700 12.generation 25MB 10nm ");
            pcDetailsArrayList.add("Intel Core i5 12400 socket 1700 12.generation 2.50GHz 18MB  10nm");
            pcDetailsArrayList.add("Intel Core i5 12600K socket 1700 12.generation 3.70GHz 20MB  10nm");
            pcDetailsArrayList.add("Intel Core i5 9400 socket 1151 - 9.generation 2.9GHz 9MB  14nm");
            pcDetailsArrayList.add("Intel Core i9 11900KF socket 1200 11.generation 3.50GHz 16MB  14nm");
            pcDetailsArrayList.add("Intel Core i5 11600K socket 1200 11.generation 3.90GHz 12MB 14nm");
            pcDetailsArrayList.add("Intel Core i5 12400F socket 1700 12.generation 2.50GHz 18MB 10nm");
            pcDetailsArrayList.add("Intel Core i7 12700K socket 1700 12.generation 2.70GHz 25MB 10nm");
            pcDetailsArrayList.add("Intel Core i9 12900KS socket 1700 3.4GHz 12. 30MB");
            pcDetailsArrayList.add("Intel Core i9 12900 socket 1700 12.generation  3.20GHz 30MB 10nm");
            pcDetailsArrayList.add("Intel Core i3 10105F socket 1200 10.generation  3.70GHz 6MB 14nm");
            pcDetailsArrayList.add("Intel Core i9 12900F socket 1700 12.generation  2.40GHz 30MB 10nm");
            pcDetailsArrayList.add("Intel Core i7 12700  socket 1700 12.generation  2.10GHz 25MB  10nm");
            pcDetailsArrayList.add("Intel Core i5 10600KF socket 1200 10generation. 4.10GHz 12MB 14nm");
            pcDetailsArrayList.add("Intel Core i9 10900F socket 1200 10.generation  2.80 GHz 20MB 14nm");
            pcDetailsArrayList.add("Intel Core i9 10850K socket 1200 10.generation  3.60 GHz 20MB 14nm");
            pcDetailsArrayList.add("Intel Core i9 10900  socket 1200 10.generation  2.80 GHz 20MB 14nm");
            pcDetailsArrayList.add("Intel Core i5 10400F socket 1200 10.generation  2.9GHz 12MBb 14nm");
            pcDetailsArrayList.add("Intel Core i3 12100  socket 1700 12.generation  3.30GHz 12MB 10nm");
            pcDetailsArrayList.add("Intel Core i7 12700KF socket 1700 12generation. 2.70GHz 25MB 10nm");
            pcDetailsArrayList.add("Intel Core i9 11900  socket 1200 11.generation  2.50GHz 16MB 14nm");
            pcDetailsArrayList.add("Intel Core i5 11600KF socket 1200 11generation  3.90GHz 12MB 14nm");
            pcDetailsArrayList.add("Intel Core i5 10400  socket 1200 10.generation  2.9GHz 12MB 14nm");
            pcDetailsArrayList.add("Intel Core i3 10320  socket 1200 10.generation  3.80GHz 8MB ");
            pcDetailsArrayList.add("Intel Core i5 12500  socket 1700 12.generation  3 GHz 18MB 10nm");
            pcDetailsArrayList.add("Intel Core i9 12900KF socket 1700 12generation. 3.20GHz 30MB 10nm");
            pcDetailsArrayList.add("Intel Core i9 12900K socket 1700 12.generation  3.20GHz 30MB 10nm");
            pcDetailsArrayList.add("Intel Core i5 12600KF socket 1700 12generation. 3.70GHz 20MB 10nm");
            pcDetailsArrayList.add("Intel Core i3 10105  socket 1200 10.generation  3.70GHz 6MB 14nm");
            pcDetailsArrayList.add("Intel Core i9 11900K socket 1200 11.generation  3.50GHz 16MB 14nm");
            pcDetailsArrayList.add("Intel Core i7 11700KF socket 1200 11generation. 3.60GHz 16MB 14nm");
            pcDetailsArrayList.add("Intel Core i5 11600 socket 1200 11.generation  2.80GHz 12MB 14nm");
            pcDetailsArrayList.add("Intel Core i5 11500  socket 1200 11.generation  2.70GHz 12MB 14nm");
            pcDetailsArrayList.add("Intel Core i7 11700F socket 1200 11.generation  2.50GHz 16MB 14nm");
            pcDetailsArrayList.add("Intel Core i7 11700  socket 1200 11.generation  2.50GHz 16MB 14nm");
            pcDetailsArrayList.add("Intel Core i5 11400  socket 1200 11.generation  2.60GHz 12MB 14nm");
            pcDetailsArrayList.add("Intel Core i7 11700K socket 1200 11.generation  3.60GHz 16MB 14nm");
            pcDetailsArrayList.add("Intel Core i9 10850K socket 1200 10.generation  3.60 GHz 20MB 14nm");
            pcDetailsArrayList.add("Intel Core i9 10940X socket 2066 10.generation  3.30 GHz 19.25M");
            pcDetailsArrayList.add("Intel Core i9 10980XE socket 2066 3.0GHz 24.75MB 14nm");
            pcDetailsArrayList.add("Intel Core i9 10900K socket 1200 10.generation 3.70 GHz 20MB  14nm");
            pcDetailsArrayList.add("Intel Core i9 10900KF socket 1200 10.generation 3.70 GHz 20MB 14nm");
            pcDetailsArrayList.add("Intel Core i7 10700K socket 1200 10.generation 3.80 GHz 16MB  14nm");
            pcDetailsArrayList.add("Intel Core i7 10700KF socket 1200 10.generation 3.80 GHz 16MB 14nm");
            pcDetailsArrayList.add("Intel Core i7 10700 socket 1200 10.generation 2.90GHz 16MB 14nm");
            pcDetailsArrayList.add("Intel Core i7 10700F socket 1200 10.generation 2.90GHz 16MB 14nm");
            pcDetailsArrayList.add("Intel Core i5 10600K socket 1200 10.generation 4.10GHz 12MB 14nm");
            pcDetailsArrayList.add("Intel Core i5 10600 socket 1200 10.generation 3.30GHz 12MB 14nm");
            pcDetailsArrayList.add("Intel Core i5 10500 socket 1200 10.generation 3.10GHz 12MB 14nm");
            pcDetailsArrayList.add("Intel Core i3 10100 socket 1200 10.generation 3.6GHz 6MB 14nm");
            pcDetailsArrayList.add("Intel Core i9 10900X socket 2066 3.70GHz 19.25MB 14nm");
            pcDetailsArrayList.add("AMD Ryzen™5 5500   AM4 4.2 GHz 19MB 65W 7nm");
            pcDetailsArrayList.add("AMD Ryzen™5 5600X  AM4 Wraith Stealth 3.7GHz 32MB 65W");
            pcDetailsArrayList.add("AMD Ryzen™5 5600   AM4 3.5GHz 32MB 65W 7nm");
            pcDetailsArrayList.add("AMD Ryzen™7 5700X  AM4 3.4GHz 32MB 65W 7nm");
            pcDetailsArrayList.add("AMD Ryzen™5 4500   AM4 4.1GHz 11MB 165W 7nm");
            pcDetailsArrayList.add("AMD Ryzen™7 5800X  AM4 3.8GHz 32MB 105W 7nm");
            pcDetailsArrayList.add("AMD Ryzen™7 5700G  AM4 3.8 GHz 20MB 65W 7nm");
            pcDetailsArrayList.add("AMD Ryzen™9 5950X  AM4 3.4GHz 64MB 105W 7nm");
            pcDetailsArrayList.add("AMD Ryzen™5 5600G  AM4 3.9 GHz 19MB 65W 7nm");
            pcDetailsArrayList.add("AMD Ryzen™7 3800XT AM4 4.7 GHz 36MB 105W 7nm");
            pcDetailsArrayList.add("AMD Ryzen™7 3800X  AM4+WraithPrism(RGB) 3.9 GHz");
            pcDetailsArrayList.add("AMD Ryzen™7 3700X  AM4+Wraith Prism(RGB) 3.6 GHz");


        } else if (parcaAdi.equals("Kasa") || parcaAdi.equals("Safes"))
        {


            pcDetailsArrayList.add("POWERBOOST VK-P1900B 500W USB 3.0 MESH FIXED 4x120mm");
            pcDetailsArrayList.add("POWERBOOST VK-P15B 600W 80 PLUS USB 3.0 MESH 4x120mm");
            pcDetailsArrayList.add("COOLER MASTER MASTERBOX TD500 650W 80PLUS BRONZE");
            pcDetailsArrayList.add("MSI MAG FORGE 100M TEMPERED GLASS 2x120mm RGB  MidT");
            pcDetailsArrayList.add("COOLER MASTER MASTERBOX TD500 MESH 4x120mm ARGB");
            pcDetailsArrayList.add("RAMPAGE REACTION 4x120mm Rainbow 600W 80 PLUS");
            pcDetailsArrayList.add("POWERBOOST VK-P06B 550W USB 3.0 DOUBLE RING MESH 4x120mm");
            pcDetailsArrayList.add("POWERBOOST VK-P06B 550W USB 3.0 DOUBLE RING MESH 4x120mm");
            pcDetailsArrayList.add("COOLER MASTER MASTERBOX TD500 MESH 4x120mm ARGB ");
            pcDetailsArrayList.add("COOLER MASTER MASTEBOX TD500 750W 80PLUS BRONZE");
            pcDetailsArrayList.add("COOLER MASTER MASTERBOX K501L V4 600W 80PLUS MESH ");
            pcDetailsArrayList.add("COOLER MASTER MASTERBOX MB311L 600W 3x120mm RGB MINI TOWER");
            pcDetailsArrayList.add("POWERBOOST VK-M202B USB 3.0 MESH 4x120mm RGB FAN ATX");
            pcDetailsArrayList.add("CORSAIR İCUE 4000X RGB 750W 80PLUS BRONZE TEMPERED");
            pcDetailsArrayList.add("FRISBY 4x120mm RGB  650W 80 PLUS MESH MidT ATX GAMING ");
            pcDetailsArrayList.add("CORSAIR 4000D TEMPERED GLASS 2x120mm MidT ");
            pcDetailsArrayList.add("RAMPAGE SAILOR 4x120mm Rainbow 600W 80Plus");
            pcDetailsArrayList.add("THERMALTAKE V200TG 600W 80PLUS 3x120mm RGB  MidT");
            pcDetailsArrayList.add("POWERBOOST VK-D501M 650W 80PLUS USB 3.0 MESH 4x120mm");
            pcDetailsArrayList.add("THERMALTAKE DIVIDER 500 TG  3x120mm ARGB  MidT");
            pcDetailsArrayList.add("MSI MAG FORGE 100R TEMPERED GLASS 2x120mm ARGB  MidT");
            pcDetailsArrayList.add("RAMPAGE FUSION 4x120mm RAINBOW  USB3.0 MidT ATX");
            pcDetailsArrayList.add("XIGMATEK DIAMOND 600W 80 PLUS POWER 4X120mm RAINBOW");
            pcDetailsArrayList.add("THERMALTAKE COMMANDER G33 TG 750W 80PLUS 2x200mm ARGB");
            pcDetailsArrayList.add("COUGAR PANZER EVO RGB GAMING USB3.0 FullT ATX ");
            pcDetailsArrayList.add("COUGAR PURITAS GAMING USB3.0 MidT ATX ");
            pcDetailsArrayList.add("THERMALTAKE TOWER 500  3X TEMPERED GLASS");
            pcDetailsArrayList.add("MSI MAG FORGE M100R TEMPERED GLASS ARGB FAN USB");
            pcDetailsArrayList.add("MSI MAG FORGE M100A ARGB FAN USB 3.2");
            pcDetailsArrayList.add("POWERBOOST VK-P3301B 500W USB 3.0 MESH FIXED 4x120mm");
            pcDetailsArrayList.add("POWERBOOST VK-C12B USB 3.0 TEMPERED GLASS 4x120mm RGB");
            pcDetailsArrayList.add("COOLER MASTER HAF 700 EVO 2x120mm-2x200mm ARGB");
            pcDetailsArrayList.add("MAG SHIELD 110R USB3.2 MidT ATX ");
            pcDetailsArrayList.add("COOLER MASTER HAF 500 TG MESH ARGB 1x120cm 2x200cm");
            pcDetailsArrayList.add("THERMALTAKE AH T200  Tempered Glass ");
            pcDetailsArrayList.add("MSI MAG FORGE 100 RB65CAM 650W BRONZ");
            pcDetailsArrayList.add("THERMALTAKE Core P6  3xTempered Glass ");
            pcDetailsArrayList.add("MSI MPG VELOX 100P AIRFLOW 4x120mm  MidT ATX GAMING");
            pcDetailsArrayList.add("THERMALTAKE PCI-e 4.0 X16 300mm 90°  RISER");
            pcDetailsArrayList.add("MSI MAG SHIELD M300 USB3.2 MidT ATX");
            pcDetailsArrayList.add("MSI MAG FORGE 101M TEMPERED GLASS 4x120mm RGB  MidT");
            pcDetailsArrayList.add("COUGAR MX660 MESH RGB 4x120mm RGB MESH GEX");
            pcDetailsArrayList.add("MSI MPG GUNGNIR 110R TEMPERED GLASS 4x120mm ARGB");
            pcDetailsArrayList.add("COOLER MASTER MASTERCASE H500 MESH 2x200mm +1x120mm");
            pcDetailsArrayList.add("CORSAIR 5000D TEMPERED GLASS YAN PANEL 2x120mm ");
            pcDetailsArrayList.add("ZALMAN M3 PLUS 4x120mm RGB  MINI TOWER GAMING ");
            pcDetailsArrayList.add("ZALMAN S4 PLUS 3x120mm RGB  MEGAMAX 600W 80PLUS MidT ATX GAMING ");
            pcDetailsArrayList.add("THERMALTAKE VIEW 51 TEMPERED GLASS 2x200mm ARGB");
            pcDetailsArrayList.add("THERMALTAKE VIEW 51 TEMPERED GLASS 2x200mm ARGB");
            pcDetailsArrayList.add("RAMPAGE HACKER 4x120mm RGB 600W 80PLUS BRONZE MidT");
            pcDetailsArrayList.add("COUGAR DARK BLADER-G RGB  USB3.0 FullT ATX");
            pcDetailsArrayList.add("THERMALTAKE VERSA J23 650W 3x120mm RGB ");
            pcDetailsArrayList.add("EVEREST X-MESH 3x120mm RAINBOW USB 3.0 Tower");
            pcDetailsArrayList.add("CORSAIR CARBIDE  SPEC-DELTA 550W 80PLUS RGB ");
            pcDetailsArrayList.add("COUGAR GEMINI S GAMING USB3.0 MidT ");
            pcDetailsArrayList.add("COUGAR GEMINI T RGB GAMING USB3.0 MidT ATX ");
            pcDetailsArrayList.add("XIGMATEK ASTRO 650W 80PLUS POWER 4x120mm RGB ");
            pcDetailsArrayList.add("RAMPAGE THE KING 4x120mm RGB FAN USB 3.0 MidT ATX");
            pcDetailsArrayList.add("POWER BOOST VK-G3403S 650W 80 PLUS MESH PANEL USB 3.0");
            pcDetailsArrayList.add("POWER BOOST VK-T01B RGB 650W 80+ Mesh Panel USB 3.0 Mid");
            pcDetailsArrayList.add("FRISBY FC-9410G WOLF 500W RGB 3X FAN USB 3.0 Mid ATX");
            pcDetailsArrayList.add("FRISBY FC-9320G MESH 4XRGB 600W USB 3.0 80 PLUS Mid ATX");
            pcDetailsArrayList.add("THERMALTAKE CORE P6 3X TEMPERED GLASS");
            pcDetailsArrayList.add("THARMALTAKE AH T200  TEMPERED GLASS ");
            pcDetailsArrayList.add("MSI MAG SHIELD M301 MESH mATX ");
            pcDetailsArrayList.add("ASUS TUF GAMING GT301 3x120mm ARGB  CAM MidT ATX");
            pcDetailsArrayList.add("RAMPAGE REDSKY 4x120mm RGB 700W 80 Plus Bronze");
            pcDetailsArrayList.add("XIGMATEK GAMING M 4*X20C RGB  X-Power 500W Mesh Panel Tempered ");
            pcDetailsArrayList.add("EVEREST BUMPY 4x120mm ARGB  TEMPERED ");
            pcDetailsArrayList.add("EVEREST 2*Sata Mesh 720R Peak-250W");
            pcDetailsArrayList.add("MSI MAG FORGE 112R ARGB Tempered ATX Mid Tower");
            pcDetailsArrayList.add("POWERBOOST X59RGB 650W 80 PLUS USB 3.0 TEMPERED");
            pcDetailsArrayList.add("POWERBOOST VK-G3701B 550W 80 PLUS USB 3.0 MESH 4x120mm");
            pcDetailsArrayList.add("MSI MPG GUNGNIR 110R WHITE Tempered Glass RGB USB 3.2 ATX");
            pcDetailsArrayList.add("MSI MAG FORGE 110R ARGB USB 3.2  ATX Mid Tower ");
            pcDetailsArrayList.add("MSI MAG FORGE 111R USB 3.2 ARGB Tempered Glass  ATX");
            pcDetailsArrayList.add("COOLER MASTER MASTERBOX MB520 600W 80 PLUS 3x120mm");
            pcDetailsArrayList.add("MSI MAG SHIELD 110A USB3.2 MidT ATX ");
            pcDetailsArrayList.add("S-LINK SLX-F201 10cm 4 Pin 2'li PWM ");
            pcDetailsArrayList.add("COOLER MASTER TD300 TG MESH 2x120mm ARGB ");
            pcDetailsArrayList.add("COOLER MASTER HAF 500 TG MESH ARGB 1x120cm 2x200cm");
            pcDetailsArrayList.add("THERMALTAKE AH T200  Tempered Glass  Micro ATX");
            pcDetailsArrayList.add("THERMALTAKE Core P6  3xTempered Glass  MidT");
            pcDetailsArrayList.add("THERMALTAKE Divider 200 TG Air  1x200mm Mesh MiniT");
            pcDetailsArrayList.add("THERMALTAKE Divider 200 TG Air  1x200mm Mesh MiniT");
            pcDetailsArrayList.add("THERMALTAKE DIVIDER 500 TG AIR  2x120mm MESH");
            pcDetailsArrayList.add("THERMALTAKE DIVIDER 500 TG AIR  2x120mm MESH");
            pcDetailsArrayList.add("THERMALTAKE DIVIDER 500 TG  4x120mm ARGB MidT");
            pcDetailsArrayList.add("THERMALTAKE DIVIDER 300 TG AIR  2x120mm  MESH");
            pcDetailsArrayList.add("THERMALTAKE DIVIDER 300 TG AIR  2x120mm  MESH");
            pcDetailsArrayList.add("THERMALTAKE The Tower 100 Racing Green 3xTempered Glass");
            pcDetailsArrayList.add("THERMALTAKE THE TOWER 100  3xTEMPERED GLASS");
            pcDetailsArrayList.add("THERMALTAKE The Tower 100 3xTempered Glass");
            pcDetailsArrayList.add("THERMALTAKE THE TOWER 100 3xTEMPERED GLASS");
            pcDetailsArrayList.add("MSI MAG VAMPIRIC 300R PACIFIC BLUE TEMPERED GLASS 1x120mm");
            pcDetailsArrayList.add("MSI MAG VAMPIRIC 300R MIDNIGHT GREEN TEMPERED");
            pcDetailsArrayList.add("MSI MAG VAMPIRIC 100L TEMPERED GLASS MidT ARGB ATX");
            pcDetailsArrayList.add("COOLER MASTER MASTERBOX NR200P TEMPERED GLASS Mini");
            pcDetailsArrayList.add("COOLER MASTER MASTERBOX NR200P TEMPERED GLASS Mini-");
            pcDetailsArrayList.add("COOLER MASTER MASTERBOX NR200P TEMPERED GLASS Mini-");
            pcDetailsArrayList.add("MSI MPG VELOX 100R 4x120mm ARGB  MidT ATX GAMING");
            pcDetailsArrayList.add("MSI MPG VELOX 100R 4x120mm ARGB  MidT ATX GAMING");
            pcDetailsArrayList.add("MSI MPG QUIETUDE 100S 1x120mm  MidT ATX GAMING");
            pcDetailsArrayList.add("MSI MAG VAMPIRIC 300R TEMPERED GLASS 1x120mm ARGB");
            pcDetailsArrayList.add("MSI MPG GUNGNIR 111R TEMPERED GLASS 4x120mm ARGB");
            pcDetailsArrayList.add("COUGAR GEMINI T PRO ARGB LED MidT ATX GAMING");
            pcDetailsArrayList.add("COUGAR GEMINI S SILVER XTC 600W 80 PLUS MidT ATX GAMING");
            pcDetailsArrayList.add("COUGAR QBX USB3.0 Mini-ITX");
            pcDetailsArrayList.add("COUGAR BLAZER ESSENCE TEMPER  MidT ATX GAMIN");
            pcDetailsArrayList.add("MSI MPG SEKIRA 500G TEMPERED GLASS 3x200mm  MidT ATX ");
            pcDetailsArrayList.add("COOLER MASTER MASTERBOX TD500 650W 80PLUS BRONZE");
            pcDetailsArrayList.add("COUGAR MX440 MESH RGB 4x120mm RGB VTE X2 750W");
            pcDetailsArrayList.add("ZALMAN N5 MF (SE) 4x120mm RGB  MegaMax 600W 80PLUS MidT");
            pcDetailsArrayList.add("COUGAR PANZER 1x120mm MidT ATX USB3.0 GAMING ");
            pcDetailsArrayList.add("COUGAR DARK BLADER X7 1x120mm ARGB  GAMING");
            pcDetailsArrayList.add("COUGAR DARK BLADER X5-RGB 3x120mm ARGBGAMING");
            pcDetailsArrayList.add("XIGMATEK MASTER X 4x120mm ARGB  X-Power 650W TEMPER MESH PANEL");
            pcDetailsArrayList.add("XIGMATEK X7 7x120mm ARGB TEMPERED");
            pcDetailsArrayList.add("XIGMATEK GAMING X 4x120mm RGB  X-Power 500W TEMPER");
            pcDetailsArrayList.add("MSI MPG GUNGNIR 100P TEMPERED GLASS 1x120mm ");
            pcDetailsArrayList.add("CORSAIR 470T RGB  CAM YAN PANEL MidT ATX ");
            pcDetailsArrayList.add("RAMPAGE DEEPFORCE 4x120mm RGB  600W 80PLUS BRONZE");
            pcDetailsArrayList.add("MSI MPG SEKIRA 500X TEMPERED GLASS 3x200mm ARGB  MidT");
            pcDetailsArrayList.add("THERMALTAKE H330 650W 2x120mm  TEMPERED");
            pcDetailsArrayList.add("THERMALTAKE VERSA T25 550W 80+ TEMPERED GLASS RGB");
            pcDetailsArrayList.add("ASUS TUF GAMING GT501 WHITE EDITION 3x120mm RGB");
            pcDetailsArrayList.add("FRISBY 4x120mm RAINBOW 600W 80PLUS BRONZE USB3.0");
            pcDetailsArrayList.add("EVEREST SPECTRUM 4x120mm  500W MidT ATX GAMING");
            pcDetailsArrayList.add("RAMPAGE PHANTOM X2 600W 80PLUS BRONZE 1x120mm RGB");
            pcDetailsArrayList.add("RAMPAGE PHANTOM X1 600W 80PLUS BRONZE 1x120mm RGB");
            pcDetailsArrayList.add("CORSAIR CARBIDE SPEC-05 650W 80PLUS BRONZE MidT");
            pcDetailsArrayList.add("CORSAIR CARBIDE SPEC-05 550W 80PLUS BRONZE MidT");
            pcDetailsArrayList.add("COUGAR MX410 MESH-G RGB 4x120mm ARGB  650W 80 PLUS USB3.0 GAMING ");
            pcDetailsArrayList.add("ASUS ROG Z11 3x120mm USB3.2 MINI TOWER ");
            pcDetailsArrayList.add("MSI MPG SEKIRA 100R TEMPERED GLASS 4x120mm ARGB  MidT");
            pcDetailsArrayList.add("MSI MPG GUNGNIR 110M TEMPERED GLASS 3x120mm RGB");
            pcDetailsArrayList.add("MSI MPG GUNGNIR 100D TEMPERED GLASS 2x120mm ");
            pcDetailsArrayList.add("MSI MPG GUNGNIR 100 TEMPERED GLASS 1x120mm ARGB");
            pcDetailsArrayList.add("MSI MAG VAMPIRIC 100R TEMPERED GALSS 1x120mm ARGB");
            pcDetailsArrayList.add("MSI MAG VAMPIRIC 011C TEMPERED GLASS 1x120mm ARGB");
            pcDetailsArrayList.add("MSI MAG VAMPIRIC 010X TEMPERED GLASS 1x120mm RGB");
            pcDetailsArrayList.add("CORSAIR 5000D TEMPERED GLASS YAN PANEL 2x120mm  MidT ");
            pcDetailsArrayList.add("FRISBY 4x120mm RGB 650W 80 PLUS USB3.0 MidT ATX GAMING");
            pcDetailsArrayList.add("FRISBY 4x120mm RGB 600W 80 PLUS USB3.0 MidT ATX GAMING");
            pcDetailsArrayList.add("FRISBY 4x120mm RGB 650W 80 PLUS USB3.0 MidT ATX GAMING");
            pcDetailsArrayList.add("XIGMATEK CYCLOPS M 4x120mm RGB  X-POWER 650W");
            pcDetailsArrayList.add("XIGMATEK TRIDENT PLUS 4x120mm RGB  X-POWER");
            pcDetailsArrayList.add("COOLER MASTER MASTERCASE H500 750W 80PLUS BRONZE ARGB");
            pcDetailsArrayList.add("XIGMATEK VERA M 2x200mm ARGB  MESH PANEL SUPER");
            pcDetailsArrayList.add("XIGMATEK VERA 2x200mm ARGB  CAM PANEL SUPER TOWER");
            pcDetailsArrayList.add("RAMPAGE HECTORA GLASS 4x140mm ARGB  700W");
            pcDetailsArrayList.add("RAMPAGE AMAZE 4x120mm RGB 700W 80PLUS BRONZE MidT");
            pcDetailsArrayList.add("RAMPAGE HECTORA XL 4x140mm ARGB 700W 80PLUS");
            pcDetailsArrayList.add("THERMALTAKE VERSA T25 650W 80PLUS ARGB 3x120mm  MidT");
            pcDetailsArrayList.add("THERMALTAKE H330 650W ARGB 3x120mm TEMPERED GLASS");
            pcDetailsArrayList.add("RAMPAGE PLATINO 4x120mm RAINBOW 600W 80PLUS");
            pcDetailsArrayList.add("RAMPAGE ESPECTRO 4x120mm RAINBOW  600W 80PLUS");
            pcDetailsArrayList.add("RAMPAGE GALAXY 4x120mm RGB  600W 80PLUS BRONZE MidT");
            pcDetailsArrayList.add("RAMPAGE X-HORSE 650W 80 PLUS BRONZE 4x120mm RAINBOW FAN");
            pcDetailsArrayList.add("COOLER MASTER MASTERBOX MB520  4x120mm");
            pcDetailsArrayList.add("CORSAIR İCUE 4000X RGB TEMPERED GLASS 3x120mm ");
            pcDetailsArrayList.add("CORSAIR 4000D TEMPERED GLASS 2x120mm MidT");
            pcDetailsArrayList.add("COOLER MASTER MASTERBOX MB511 650W 80PLUS BRONZE");
            pcDetailsArrayList.add("XIGMATEK ZEUS SPECTRUM EDITION 5x120mm RGB ");
            pcDetailsArrayList.add("XIGMATEK PERSEUS 5x120mm RGB  USB3.0 TEMPER ");
            pcDetailsArrayList.add("RAMPAGE  MESH 4x120mm RAINBOW  650W");
            pcDetailsArrayList.add("RAMPAGE VICTORY 1x12mm  600W 80 PLUS BRONZE MidT ATX");
            pcDetailsArrayList.add("XIGMATEK GRIP 4x120mm RAINBOW  X-POWER 600W");
            pcDetailsArrayList.add("THERMALTAKE AH T600 2 x Tempered Glass ARGB");
            pcDetailsArrayList.add("ASUS TUF GAMING GT301 3x120mm ARGB");
            pcDetailsArrayList.add("RAMPAGE SHAKE 4x120mm RGB 600W 80Plus BRONZE MidT");
            pcDetailsArrayList.add("RAMPAGE TRAPPER 3x140mm ARGB  650W 80PLUS");
            pcDetailsArrayList.add("FRISBY FC-9325G INFINITY 4x120mm RGB 650W 80PLUS");
            pcDetailsArrayList.add("XIGMATEK SIROCON III X-POWER 600W 80 PLUS RAINBOW FAN");
            pcDetailsArrayList.add("RAMPAGE IMPOSING PRO 2x200mm ARGB  700W");
            pcDetailsArrayList.add("FRISBY 4x120mm DUAL RING RGB  600W 80 PLUS BRONZE MidT");
            pcDetailsArrayList.add("FRISBY 4x120mm DUAL RING 600W 80 PLUS BRONZE MidT");
            pcDetailsArrayList.add("CORSAIR iCUE 220T 3x120mm RGB TEMPER MidT ATX");
            pcDetailsArrayList.add("CORSAIR iCUE 220T 3x120mm RGB  TEMPER MidT ATX");
            pcDetailsArrayList.add("COUGAR BLAZER TEMPER USB3.0 MidT ATX GAMING");
            pcDetailsArrayList.add("COUGAR GEMINI S IRON GRAY XTC 600W 80 PLUS USB3.0 MidT");
            pcDetailsArrayList.add("COUGAR DARK BLADER-S RGB  PANEL USB3.0 FullT ATX GAMING ");
            pcDetailsArrayList.add("ASUS ROG STRIX GX601 HELIOS 4x140mm  USB3.1 MidT ATX");
            pcDetailsArrayList.add("ASUS TUF GAMING GT501 3x120mm RGB ");
            pcDetailsArrayList.add("XIGMATEK LAMIYA 4x120mm  X-POWER 650W 80PLUS MidT ATX");
            pcDetailsArrayList.add("XIGMATEK COCKPIT MESH PANEL 4x120mm  X-POWER 700W");
            pcDetailsArrayList.add("XIGMATEK CYCLOPS 4x120mm FAN X-POWER 650W 80PLUS MidT");
            pcDetailsArrayList.add("XIGMATEK CYCLOPS BLACK 4x120mm FAN X-POWER 650W");
            pcDetailsArrayList.add("COUGAR DARK BLADER-S RGB USB3.0 FullT ATX");
            pcDetailsArrayList.add("ASUS ROG STRIX GX601 HELIOS 4x140mm  USB3.1 MidT ATX");
            pcDetailsArrayList.add("ASUS TUF GAMING GT501 3x120mm RGB ");
            pcDetailsArrayList.add("XIGMATEK LAMIYA 4x120mm  X-POWER 650W 80PLUS MidT ATX");
            pcDetailsArrayList.add("XIGMATEK COCKPIT MESH PANEL 4x120mm  X-POWER 700W 80PLUS MidT ATX");
            pcDetailsArrayList.add("XIGMATEK CYCLOPS 4x120mm FAN X-POWER 650W 80PLUS MidT ATX ");
            pcDetailsArrayList.add("XIGMATEK CYCLOPS BLACK 4x120mm FAN X-POWER 650W");
            pcDetailsArrayList.add("XIGMATEK HELIOS RAINBOW USB 3.0 MidT ATX GAMING");
            pcDetailsArrayList.add("FRISBY FC-8940G 650W 80 PLUS 2x200mm+1x120mm RGB");
            pcDetailsArrayList.add("FRISBY FC-8935G 650W 80 PLUS 4x120mm RAINBOW  MidT");
            pcDetailsArrayList.add("FRISBY FC-8930G 650W 80 PLUS 3x120mm RAINBOW  MESH");
            pcDetailsArrayList.add("XIGMATEK AQUARIUS PLUS 7x120mm  USB3.0 TEMPER");
            pcDetailsArrayList.add("COUGAR PURITAS RGB 3x120mm RGB  USB3.0 MidT ATX");
            pcDetailsArrayList.add("CORSAIR CARBIDE  SPEC-05 550W 80PLUS MidT ATX");
            pcDetailsArrayList.add("THERMALTAKE VERSA J25 650W 80PLUS RGB 3x120mm MidT");
            pcDetailsArrayList.add("THERMALTAKE VERSA J24 650W 80PLUS RGB 3x120mm MidT");
            pcDetailsArrayList.add("XIGMATEK BEAST 4 x RGB  X-POWER 650W 80PLUS USB 3.0");
            pcDetailsArrayList.add("COOLER MASTER MASTERBOX MB520 650W 80PLUS 3x120mm");
            pcDetailsArrayList.add("COUGAR CGR-5NM1B-C MX350 700W 80 PLUS MidT ATX GAMING");
            pcDetailsArrayList.add("THERMALTAKE PCI-e X16 Riser Cable");
            pcDetailsArrayList.add("THERMALTAKE VIEW 27 600W 80PLUS ARGB 3x120mm  MidT");
            pcDetailsArrayList.add("NZXT S340MB-GB Mid TOWER ATX");
            pcDetailsArrayList.add("NZXT S340MB-GR Mid TOWER ATX");
            pcDetailsArrayList.add("NZXT S340W-TH ELITE SPECIAL EDITION Mid TOWER ATX ");
            pcDetailsArrayList.add("NZXT S340W-B5 ELITE Mid TOWER ATX ");
            pcDetailsArrayList.add("NZXT S340W-B3 ELITE Mid TOWER ATX ");
            pcDetailsArrayList.add("COUGAR PANZER-G GAMING USB3.0 MidT ATX ");
            pcDetailsArrayList.add("COUGAR PANZER MAX GAMING USB3.0 FullT ATX");
            pcDetailsArrayList.add("COUGAR CONQUER GAMING USB3.0 MidT ATX ");
            pcDetailsArrayList.add("RAMPAGE TEMPER PRO V5 4x120mm RGB FAN 6xRGB ");
            pcDetailsArrayList.add("XIGMATEK ZEST RAINBOW LED BAR USB3.0 TEMPER ");
            pcDetailsArrayList.add("COUGAR TURRET V2 700W 80 PLUS GAMING USB3.0 MidT ATX");
            pcDetailsArrayList.add("THERMALTAKE LEVEL 20 MT ARGB 3x120mm FANLI MidT ");
            pcDetailsArrayList.add("THERMALTAKE V200TG 3x120MM RGB FANLI MidT ATX GAMING");
            pcDetailsArrayList.add("FRISBY GC-9250G GAMEMAX RAPTOR 650W USB 3.0MidT ATX");
            pcDetailsArrayList.add("COOLER MASTER MASTERBOX K500L 600W 80PLUS MidT ATX");
            pcDetailsArrayList.add("FRISBY FC-8860G-650 650W USB 3.0 MidT GAMING ");
            pcDetailsArrayList.add("FRISBY FC-8865G-650 650W MidT ATX");
            pcDetailsArrayList.add("RAMPAGE CARBON 4x120mm RGB FAN USB 3.0 MidT ATX");
            pcDetailsArrayList.add("COOLER MASTER MASTERBOX LITE 5 600W 80PLUS MidT ATX");
            pcDetailsArrayList.add("FRISBY FC-8870G 400W USB 3.0 MidT GAMING ");


        } else if (parcaAdi.equals("Güç kaynağı")  || parcaAdi.equals("Power Supplies"))
        {
            pcDetailsArrayList.add("RAMPAGE RGB 600W 80 PLUS BRONZE 120mm RGB ");
            pcDetailsArrayList.add("POWERBOOST FURY 550W 80 PLUS 120mm");
            pcDetailsArrayList.add("COOLER MASTER MWE 80PLUS BRONZE 750W 2xEPS");
            pcDetailsArrayList.add("EVGA SUPERNOVA 850 GA 850W 80 PLUS GOLD FULL MODULER");
            pcDetailsArrayList.add("COOLER MASTER MWE V2 850W 80PLUS GOLD 2xEPS 120MM ");
            pcDetailsArrayList.add("MSI MPG A850GF 850W 80 PLUS GOLD ");
            pcDetailsArrayList.add("POWERBOOST FURY 650W 80 PLUS 120mm ");
            pcDetailsArrayList.add("COOLER MASTER ELITE V4 80PLUS 500W PFC 120mm");
            pcDetailsArrayList.add("POWERBOOST FURY 750W 80 PLUS 120mm ");
            pcDetailsArrayList.add("CORSAIR CX CX750F RGB 750W 80PLUS BRONZE ");
            pcDetailsArrayList.add("THERMALTAKE TOUGHPOWER GF1 80+ GOLD 750W 140mm ");
            pcDetailsArrayList.add("COOLER MASTER MWE 80PLUS BRONZE 600W 2xEPS, PFC");
            pcDetailsArrayList.add("THERMALTAKE LİTEPOWER RGB 650W APFC 12cm  PSU");
            pcDetailsArrayList.add("COOLER MASTER M2000 2000W 80PLUS PLATINUM 135MM ");
            pcDetailsArrayList.add("MSI MPG A1000G 1000W 80+ GOLD PSU Full Modüler");
            pcDetailsArrayList.add("THERMALTAKE SMART BX1 80PLUS BRONZE 750W ");
            pcDetailsArrayList.add("THERMALTAKE TOUGHPOWER GF 850W 80PLUS GOLD");
            pcDetailsArrayList.add("CORSAIR CX  CX750F RGB 750W 80PLUS BRONZE ");
            pcDetailsArrayList.add("MSI MPG A650GF 650W 80 PLUS GOLD");
            pcDetailsArrayList.add("XIGMATEK X-POWER 350W ");
            pcDetailsArrayList.add("ZALMAN ZM600-TXII 600W 80 PLUS ");
            pcDetailsArrayList.add("COOLER MASTER MWE 80PLUS BRONZE 700W 2xEPS");
            pcDetailsArrayList.add("COOLER MASTER MWE 80PLUS BRONZE 650W 2xEPS");
            pcDetailsArrayList.add("ASUS ROG STRIX 850W 80 PLUS GOLD ");
            pcDetailsArrayList.add("THERMALTAKE SMART BX1 80PLUS BRONZE 650W GÜÇ");
            pcDetailsArrayList.add("COOLER MASTER MWE 80PLUS 650W 2xEPS");
            pcDetailsArrayList.add("THERMALTAKE TOUGHPOWER GRAND 80+ PLATINUM 1200W FUL");
            pcDetailsArrayList.add("RAMPAGE RMP-500-80P 500W 80PLUS 120MM ");
            pcDetailsArrayList.add("THERMALTAKE LITEPOWER 650W ");
            pcDetailsArrayList.add("ASUS ROG-THOR GAMING 1200W 80PLUS PLATINIUM AURO SYNC &");
            pcDetailsArrayList.add("THERMALTAKE TOUGHPOWER GF1 1000W 80PLUS GOLD FULL");
            pcDetailsArrayList.add("POWERBOOST 2000W 140mm");
            pcDetailsArrayList.add("POWERBOOST WARRIOR 850W 80 PLUS GOLD FULL MODÜLER ");
            pcDetailsArrayList.add("CORSAIR CP-9020234-EU RM750 750W TAM MODULER 80PLUS ");
            pcDetailsArrayList.add("CORSAIR RM850 850W TAM MODULER 80PLUS GOLD ");
            pcDetailsArrayList.add("CORSAIR RM750 750W TAM MODULER 80PLUS GOLD ");
            pcDetailsArrayList.add("COOLER MASTER XG PLUS 850W 80+ PLATINYUM RGB FULL");
            pcDetailsArrayList.add("THERMALTAKE TOUGHPOWER GF2 80 PLUS 750W GOLD ARGB");
            pcDetailsArrayList.add("EVGA 500 W2 500W 80 PLUSI");
            pcDetailsArrayList.add("EVGA SUPERNOVA 750 GA 750W 80 PLUS GOLD FULL MODULER");
            pcDetailsArrayList.add("EVGA 1000 GQ 1000W 80 PLUS GOLD SEMI MODULER");
            pcDetailsArrayList.add("EVGA 750 GQ 750W 80 PLUS GOLD SEMI MODULER");
            pcDetailsArrayList.add("MSI MAG A550BN 550W 80 PLUS BRONZE ");
            pcDetailsArrayList.add("COOLER MASTER V750W SFX 80PLUS GOLD 750W");
            pcDetailsArrayList.add("COOLER MASTER MWE V2 80PLUS GOLD 1250W FULL MODÜLER 140MM");
            pcDetailsArrayList.add("COOLER MASTER MWE V2 80PLUS GOLD 1050W FULL MODÜLER");
            pcDetailsArrayList.add("ZALMAN ZM1200-EBTII WATTTERA 80PLUS GOLD 1200W ");
            pcDetailsArrayList.add("RAMPAGE BTC-1650 1650W 140MM FANLI ");
            pcDetailsArrayList.add("COUGAR GEX1050 1050W 80PLUS GOLD");
            pcDetailsArrayList.add("COUGAR GEX850 850W 80PLUS GOLD ");
            pcDetailsArrayList.add("COUGAR VTE X2 750 750W 80PLUS BRONZE ");
            pcDetailsArrayList.add("COUGAR GX-S450 450W 80PLUS GOLD ");
            pcDetailsArrayList.add("COOLER MASTER MWE V2 750W 80PLUS GOLD 2xEPS 120MM ");
            pcDetailsArrayList.add("RAMPAGE RGB 500W 80 PLUS BRONZE 120mm RGB ");
            pcDetailsArrayList.add("CORSAIR RMx  RM750X 750W 80PLUS GOLD TAM");
            pcDetailsArrayList.add("XIGMATEK MINOTOUR 750W 80PLUS GOLD FULL");
            pcDetailsArrayList.add("XIGMATEK MINOTOUR 850W 80PLUS GOLD FULL");
            pcDetailsArrayList.add("FRISBY FR-PS50F12B 500W 120mm ");
            pcDetailsArrayList.add("THERMALTAKE TOUGHPOWER GF 750W 80PLUS GOLD FULL");
            pcDetailsArrayList.add("THERMALTAKE TOUGHPOWER GRAND 80PLUS PLATINUM 1050W");
            pcDetailsArrayList.add("ASUS ROG THOR 850W 80 PLUS PLATINUM AURO SYNC & OLED");
            pcDetailsArrayList.add("CORSAIR RMx  RM750X V2 750W 80PLUS GOLD TAM");
            pcDetailsArrayList.add("THERMALTAKE TOUGHPOWER GF2 80 PLUS 850W GOLD ARGB");
            pcDetailsArrayList.add("CORSAIR CX  CX650F RGB 650W 80PLUS BRONZE TAM");
            pcDetailsArrayList.add("ASUS TUF GAMING 450W 80PLUS BRONZE ");
            pcDetailsArrayList.add("ASUS TUF GAMING 750W 80PLUS BRONZE ");
            pcDetailsArrayList.add("ASUS ROG STRIX 1000W 80 PLUS GOLD");
            pcDetailsArrayList.add("MSI MPG A750GF 750W 80 PLUS GOLD");
            pcDetailsArrayList.add("THERMALTAKE TOUGHPOWER PF1 850W 80+ PLATINUM FULL");
            pcDetailsArrayList.add("ASUS TUF GAMING 650W 80PLUS BRONZE ");
            pcDetailsArrayList.add("XIGMATEK HYDRA M 550W 80PLUS BRONZE FULL MODULER");
            pcDetailsArrayList.add("XIGMATEK HYDRA M 650W 80PLUS BRONZE FULL MODULER");
            pcDetailsArrayList.add("ZALMAN ZM700-TXII 700W 80 PLUS ");
            pcDetailsArrayList.add("ZALMAN ZM1200-EBTII WATTTERA 80PLUS GOLD 1200W ");
            pcDetailsArrayList.add("RAMPAGE BTC-1650 1650W 140MM ");
            pcDetailsArrayList.add("COUGAR GEX1050 1050W 80PLUS GOLD ");
            pcDetailsArrayList.add("COUGAR GEX850 850W 80PLUS GOLD ");
            pcDetailsArrayList.add("COUGAR VTE X2 750 750W 80PLUS BRONZE");
            pcDetailsArrayList.add("COUGAR GX-S450 450W 80PLUS GOLD ");
            pcDetailsArrayList.add("COOLER MASTER MWE V2 750W 80PLUS GOLD 2xEPS 120MM");
            pcDetailsArrayList.add("RAMPAGE RGB 500W 80 PLUS BRONZE 120mm RGB");
            pcDetailsArrayList.add("CORSAIR RMx  RM750X 750W 80PLUS GOLD ");
            pcDetailsArrayList.add("XIGMATEK MINOTOUR  750W 80PLUS GOLD");
            pcDetailsArrayList.add("XIGMATEK MINOTOUR  850W 80PLUS GOLD");
            pcDetailsArrayList.add("FRISBY FR-PS50F12B 500W 120mm ");
            pcDetailsArrayList.add("THERMALTAKE TOUGHPOWER GF 750W 80PLUS GOLD ");
            pcDetailsArrayList.add("THERMALTAKE TOUGHPOWER GRAND 80PLUS PLATINUM 1050W");
            pcDetailsArrayList.add("ASUS ROG THOR 850W 80 PLUS PLATINUM AURO SYNC & OLED");
            pcDetailsArrayList.add("CORSAIR RMx RM750X V2 750W 80PLUS GOLD TAM");
            pcDetailsArrayList.add("THERMALTAKE TOUGHPOWER GF2 80 PLUS 850W GOLD ARGB");
            pcDetailsArrayList.add("CORSAIR CX  CX650F RGB 650W 80PLUS BRONZE ");
            pcDetailsArrayList.add("ASUS TUF GAMING 450W 80PLUS BRONZE ");
            pcDetailsArrayList.add("ASUS TUF GAMING 750W 80PLUS BRONZE ");
            pcDetailsArrayList.add("ASUS ROG STRIX 1000W 80 PLUS GOLD ");
            pcDetailsArrayList.add("MSI MPG A750GF 750W 80 PLUS GOLD");
            pcDetailsArrayList.add("THERMALTAKE TOUGHPOWER PF1 850W 80+ PLATINUM L");
            pcDetailsArrayList.add("ASUS TUF GAMING 650W 80PLUS BRONZE ");
            pcDetailsArrayList.add("ASUS TUF GAMING 650W 80PLUS BRONZE ");
            pcDetailsArrayList.add("XIGMATEK HYDRA M 550W 80PLUS BRONZE FULL MODULER ");
            pcDetailsArrayList.add("XIGMATEK HYDRA M 650W 80PLUS BRONZE FULL MODULER ");
            pcDetailsArrayList.add("ZALMAN ZM700-TXII 700W 80 PLUS ");
            pcDetailsArrayList.add("ZALMAN ZM500-TXII 500W 80 PLUS ");
            pcDetailsArrayList.add("ASUS ROG STRIX WHITE 850W 80 PLUS GOLD ");
            pcDetailsArrayList.add("CORSAIR CV  CV650 650W 80PLUS BRONZE ");
            pcDetailsArrayList.add("COOLER MASTER MWE 80PLUS BRONZE 750W 2xEPS");
            pcDetailsArrayList.add("CORSAIR CV  CV550 550W 80PLUS BRONZE");
            pcDetailsArrayList.add("CORSAIR RM  650W 80PLUS GOLD MODÜLER");
            pcDetailsArrayList.add("THERMALTAKE TOUGHPOWER PF1 ARGB 80PLUS PLATINUM 1200W");
            pcDetailsArrayList.add("COUGAR BXM-850 850W 80 PLUS BRONZE ");
            pcDetailsArrayList.add("COUGAR BXM-700 700W 80 PLUS BRONZE ");
            pcDetailsArrayList.add("COUGAR XTC 500 500W 80 PLUS ");
            pcDetailsArrayList.add("FRISBY FR-PS6580P-RGB 80 PLUS 650W");
            pcDetailsArrayList.add("FRISBY FR-PS6080P 80 PLUS BRONZE 600W ");
            pcDetailsArrayList.add("ASUS ROG STRIX 750W 80 PLUS GOLD");
            pcDetailsArrayList.add("ASUS ROG STRIX 650W 80 PLUS GOLD ");
            pcDetailsArrayList.add("ASUS ROG STRIX 550W 80 PLUS GOLD ");
            pcDetailsArrayList.add("THERMALTAKE TR2 S 750W 80 PLUS 120mm ");
            pcDetailsArrayList.add("THERMALTAKE TR2 S 650W 80 PLUS 120mm ");
            pcDetailsArrayList.add("THERMALTAKE TR2 S 550W 80 PLUS 120mm ");
            pcDetailsArrayList.add("FRISBY FR-PS6580P 650W 80 PLUS 120mm ");
            pcDetailsArrayList.add("COUGAR CGR-GS-750 GX-S 750W 80PLUS GOLD");
            pcDetailsArrayList.add("COUGAR CGR-BX-700 CMX 700W 80PLUS BRONZE ");
            pcDetailsArrayList.add("THERMALTAKE TOUGHPOWER PF1 ARGB 80PLUS PLATINUM 1050W");
            pcDetailsArrayList.add("THERMALTAKE TOUGHPOWER GF1 80 PLUS 850W GOLD ");
            pcDetailsArrayList.add("THERMALTAKE SMART RGB BX1 80PLUS BRONZE 750W ");
            pcDetailsArrayList.add("COOLER MASTER MWE 80PLUS 600W 2xEPS");
            pcDetailsArrayList.add("XIGMATEK MINOTAUR FULL RANGE 80PLUS GOLD 650W");
            pcDetailsArrayList.add("COUGAR CGR-STX-700 700W 80 PLUS ");
            pcDetailsArrayList.add("XIGMATEK X-POWER 650W 80PLUS");
            pcDetailsArrayList.add("THERMALTAKE LITEPOWER RGB 550W APFC 12cm PSU");
            pcDetailsArrayList.add("XIGMATEK X-POWER 600W 80PLUS ");
            pcDetailsArrayList.add("XIGMATEK X-POWER 500W 80PLUS ");
            pcDetailsArrayList.add("THERMALTAKE SMART RGB 80 PLUS 700W ");
            pcDetailsArrayList.add("THERMALTAKE SMART RGB 80PLUS 600W ");
            pcDetailsArrayList.add("THERMALTAKE SMART RGB 80PLUS 500W ");
            pcDetailsArrayList.add("RAMPAGE RMP-750-80PB 750W 80 PLUS BRONZE 140MM ");
            pcDetailsArrayList.add("RAMPAGE RMP-700-80P 700W 80PLUS 120MM ");
            pcDetailsArrayList.add("RAMPAGE RMP-650-80PB 650W 80PLUS BRONZE 140MM ");
            pcDetailsArrayList.add("THERMALTAKE TOUGHPOWER GF1 80 PLUS 850W GOLD FULL");
            pcDetailsArrayList.add("RAMPAGE RMP-750-80PB 750W 80 PLUS BRONZE 140MM");
            pcDetailsArrayList.add("RAMPAGE RMP-700-80P 700W 80PLUS 120MM ");
            pcDetailsArrayList.add("RAMPAGE RMP-650-80PB 650W 80PLUS BRONZE 140MM ");
            pcDetailsArrayList.add("RAMPAGE RMP-600-80P 600W 80PLUS 120MM ");
            pcDetailsArrayList.add("XIGMATEK X MINER 1800W 80 PLUS GOLD ");
            pcDetailsArrayList.add("RAMPAGE RGB-550 80PLUS GOLD 550W FULL MODÜLER RGB ");
            pcDetailsArrayList.add("COOLER MASTER WATT 80PLUS 600W  PFC 120MM ");
            pcDetailsArrayList.add("THERMALTAKE LITEPOWER 550W");
            pcDetailsArrayList.add("EVEREST BTX-600 600W 80PLUS BRONZE");
            pcDetailsArrayList.add("EVEREST ETX-750 750W 80PLUS GOLD ");
            pcDetailsArrayList.add("EVEREST EPS-4900B 350W ");


        } else if (parcaAdi.equals("Ram") || parcaAdi.equals("Rams"))
        {

            pcDetailsArrayList.add("SKILL 8GB (1x8GB) RipjawsV DDR4 3200Mhz CL16 1.35V ");
            pcDetailsArrayList.add("GSKILL 8GB (1x8GB) RipjawsV  DDR4 3000MHz CL16 1.35V");
            pcDetailsArrayList.add("GSKILL 16GB (1x16) RipjawsV  DDR4 3200Mhz CL16 1.35V ");
            pcDetailsArrayList.add("GSKILL 8GB (1x8GB) RipjawsV  DDR4 3600MHz CL18 1.35V");
            pcDetailsArrayList.add("GSKILL 16GB (1x16GB) RipjawsV Red DDR4 3000MHz CL16 1.35V");
            pcDetailsArrayList.add("GSKILL 8GB Value DDR3 1600MHz CL11");
            pcDetailsArrayList.add("Crucial 8GB (1x8GB) Ballistix  DDR4 3000MHz CL15 1.35V RGB PC ");
            pcDetailsArrayList.add("Kingston 8GB (1x8GB) Fury Renegade  DDR4 3600MHz CL16");
            pcDetailsArrayList.add("GSKILL 4GB Value DDR3 1333MHz CL9 PC3 ");
            pcDetailsArrayList.add("Crucial 16GB (1x16GB) Ballistix  DDR4 2666MHz CL16 1.2V");
            pcDetailsArrayList.add("Kingston 8GB (1x8GB) DDR4 3200MHz CL22");
            pcDetailsArrayList.add("Crucial 8GB (1x8GB) Ballistix DDR4 3200MHz CL16 1.35V RGB");
            pcDetailsArrayList.add("Crucial 8GB (1x8GB) DDR5 4800MHz CL40 1.1V");
            pcDetailsArrayList.add("CORSAIR 8GB Vengeance RGB RS 3200mhz CL16 DDR4");
            pcDetailsArrayList.add("CORSAIR 16GB Vengeance RGB RS 3200mhz CL16 DDR4");
            pcDetailsArrayList.add("Kingston 16GB (1x16GB) Fury Beast RGB DDR4 3200MHz CL16");
            pcDetailsArrayList.add("Kingston 16GB (1x16GB) Fury Beast  DDR4 3200MHz CL16 PC");
            pcDetailsArrayList.add("Kıngston 8GB (1x8GB) Fury Beast RGB DDR4 3600MHz CL17");
            pcDetailsArrayList.add("Kıngston 8GB (1x8GB) Fury Beast RGB DDR4 3200MHz CL16 PC");
            pcDetailsArrayList.add("Kingston 32GB (1x32GB) DDR4 3200MHz CL22");
            pcDetailsArrayList.add("Kingston 32GB (1x32GB) DDR4 2666MHz CL19");
            pcDetailsArrayList.add("Kingston 16GB (1x16GB) DDR4 3200MHz CL22");
            pcDetailsArrayList.add("Kingston 16GB (1x16GB) DDR4 2666MHz CL19");
            pcDetailsArrayList.add("Crucial 16GB (1x16GB) DDR5 4800MHz CL40 1.1V");
            pcDetailsArrayList.add("Crucial 8GB (1x8GB) Ballistix DDR4 3000MHz CL15 1.35V RGB");
            pcDetailsArrayList.add("Kingston 32GB (1x32GB) Fury Beast DDR4 3600MHz CL17 P");
            pcDetailsArrayList.add("GSKILL 16GB (1x16GB) Aegis DDR4 2666Mhz CL19 1.2V");
            pcDetailsArrayList.add("Crucial 16GB (1x16GB) DDR4 3200MHz CL22 1.2V");
            pcDetailsArrayList.add("Crucial 8GB (1x8GB) Ballistix  DDR4 3200MHz CL16 RGB");
            pcDetailsArrayList.add("Kingston 8GB (1x8GB) Fruy Beast DDR4 3200MHz CL16 PC");
            pcDetailsArrayList.add("Kingston 8GB (1x8GB) Fury Beast DDR4 3600MHz CL17");
            pcDetailsArrayList.add("Kingston 8GB (1x8GB) DDR4 2666MHz CL19");
            pcDetailsArrayList.add("CORSAIR 8GB (1x8GB) Vengeance LPX  DDR4 3200MHz CL16");
            pcDetailsArrayList.add("CORSAIR 16GB (1x16GB) Vengeance LPX  DDR4");
            pcDetailsArrayList.add("CORSAIR 8GB (1x8GB) Vengeance RGB PRO  DDR4 3600MHz CL18 Single ");
            pcDetailsArrayList.add("CORSAIR 8GB (1x8GB) Vengeance RGB PRO  DDR4 3200MHz");
            pcDetailsArrayList.add("CORSAIR 8GB (1x8GB) Vengeance LPX  DDR4 3600MHz CL18");
            pcDetailsArrayList.add("CORSAIR 32GB (1x32GB) Vengeance LPX DDR4");
            pcDetailsArrayList.add("CORSAIR 16GB (1x16) Vengeance  DDR4 3200Mhz CL16");
            pcDetailsArrayList.add("CORSAIR 8GB Vengeance  DDR4 3200Mhz CL16 Single ");
            pcDetailsArrayList.add("CORSAIR 8GB (1x8GB) Vengeance  DDR4 3000MHz CL16");
            pcDetailsArrayList.add("CORSAIR 8GB Vengeance DDR4 2666MHz CL16");
            pcDetailsArrayList.add("GSKILL 4GB Value DDR3 1600MHz CL11");
            pcDetailsArrayList.add("GSKILL 4GB Value DDR3 1600MHz CL11");


        }

          arrayAdapter.notifyDataSetChanged();

        
    }
}