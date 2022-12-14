package com.example.kutaykerem.computerinformaton.Pages;

import android.Manifest;
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

import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kutaykerem.computerinformaton.Models.GetDateDetail;
import com.example.kutaykerem.computerinformaton.R;
import com.example.kutaykerem.computerinformaton.databinding.FragmentDuzenleBinding;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
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

import java.util.HashMap;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;


public class DuzenleFragment extends Fragment {

    private FragmentDuzenleBinding binding;

    FirebaseAuth auth;
    DatabaseReference databaseReference = null;
    FirebaseDatabase database=null;
    FirebaseUser user;
    FirebaseFirestore firebaseFirestore;
    StorageReference storageReference;
    FirebaseStorage firebaseStorage;

    ActivityResultLauncher<Intent> activityResultLauncher;

    ActivityResultLauncher<String> permissionLauncher;


    ImageView dilsec,arkaplan;
    Button t??rkce,ingilizce;
    String d??zenleAdi,cikisAdi,arkadasliktancikaradi,arkadasekleadi,arkadasistekiptaladi,sohbetadi,katilmatarihiadi;


    TextView eposata,kullan??c??Ad??,biyografi;

    Uri imageData;
    Bitmap selectedimage;
    ImageView g??sterge;
    CircleImageView profile;
    Button kaydet;
    int kontrol;

    public DuzenleFragment() {

    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       binding = FragmentDuzenleBinding.inflate(inflater,container,false);
       return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        auth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference().child("Profile");
        firebaseStorage = FirebaseStorage.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();
        storageReference = firebaseStorage.getReference();

        g??sterge = view.findViewById(R.id.g??sterge);
        eposata = view.findViewById(R.id.d??zenleeposta);
        kullan??c??Ad?? = view.findViewById(R.id.d??zenleEditTextKullaniciAdi);
        biyografi = view.findViewById(R.id.editTextTextBiyografi);
        profile = view.findViewById(R.id.imageProfile);
        kaydet = view.findViewById(R.id.kaydetButton);

        FirebaseUser user2 = auth.getCurrentUser();
        String email =  user2.getEmail();

        eposata.setText(email);

        registerLauncher();

        t??rkce = view.findViewById(R.id.t??rkce);
        ingilizce = view.findViewById(R.id.ingilizce);

        dilsec = (ImageView) view.findViewById(R.id.seceneklerdil);
        dilsec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t??rkce.setVisibility(View.VISIBLE);
                ingilizce.setVisibility(View.VISIBLE);


            }
        });



        t??rkce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String dil = "t??rkce";
                DilSecildi(dil);
                NavDirections navDirections = DuzenleFragmentDirections.actionDuzenleFragmentSelf();
                Navigation.findNavController(view).navigate(navDirections);
            }
        });
        ingilizce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String dil = "ingilizce";
                DilSecildi(dil);
                NavDirections navDirections = DuzenleFragmentDirections.actionDuzenleFragmentSelf();
                Navigation.findNavController(view).navigate(navDirections);

            }
        });

        DilTan??();


        g??sterge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {

                    if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(), Manifest.permission.READ_EXTERNAL_STORAGE)) {


                        FirebaseUser  user = auth.getCurrentUser();
                        String userId = user.getUid();

                        FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
                        firebaseFirestore.collection("Kullan??lanDiller").document(userId).collection("SecilenDil").orderBy("tarih", Query.Direction.DESCENDING).limit(1).addSnapshotListener(new EventListener<QuerySnapshot>() {
                            @Override
                            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {

                               if(value != null){
                                   for(DocumentSnapshot documentSnapshot : value.getDocuments()){
                                       Map<String, Object> data = documentSnapshot.getData();
                                       String dil = data.get("dil").toString();

                                       if(dil.equals("t??rkce")){
                                           Snackbar.make(view, "Profil foto??raf?? se??meniz i??in izne ihtiyac??m??z var", Snackbar.LENGTH_INDEFINITE).setAction("??zin ver", new View.OnClickListener() {
                                               @Override
                                               public void onClick(View view) {
                                                   permissionLauncher.launch(Manifest.permission.READ_EXTERNAL_STORAGE);
                                               }
                                           }).show();

                                       }else if (dil.equals("ingilizce")){
                                           Snackbar.make(view, " We need permission to choose a profile photo", Snackbar.LENGTH_INDEFINITE).setAction("??zin ver", new View.OnClickListener() {
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
        });
        view.setFocusableInTouchMode(true);
        view.requestFocus();
        view.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if(i == KeyEvent.KEYCODE_BACK){
                    NavDirections navDirections = DuzenleFragmentDirections.actionDuzenleFragmentToKullaniciProfileFragment();
                    Navigation.findNavController(view).navigate(navDirections);

                }

                return true;
            }
        });

        kaydet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                kaydetMethod(view);
            }
        });



       super.onViewCreated(view, savedInstanceState);
    }

    private void kaydetMethod(View view) {

        String kullaniciAdi=kullan??c??Ad??.getText().toString();
        String biyograf?? = biyografi.getText().toString();

        if(TextUtils.isEmpty(kullaniciAdi)){
            kullan??c??Ad??.setError("User Name");
        } else if (kullan??c??Ad?? != null) {
            user = auth.getCurrentUser();

            databaseReference.child(user.getUid()).child("kullan??c??Ad??").setValue(kullaniciAdi);
            databaseReference.child(user.getUid()).child("biyografi").setValue(biyograf??);

            NavDirections action = DuzenleFragmentDirections.actionDuzenleFragmentToKullaniciProfileFragment();
            Navigation.findNavController(view).navigate(action);

        }

    }


    public void DilSecildi(String value){
        user = auth.getCurrentUser();

        String userId = user.getUid();

        HashMap<String,Object> data = new HashMap<>();
        data.put("dil",value);
        data.put("tarih",GetDateDetail.getDate());

        FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
        firebaseFirestore.collection("Kullan??lanDiller").document(userId).collection("SecilenDil").add(data);

    }
    public void DilTan??(){
        user = auth.getCurrentUser();

        String userId = user.getUid();

        FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
        firebaseFirestore.collection("Kullan??lanDiller").document(userId).collection("SecilenDil").orderBy("tarih", Query.Direction.DESCENDING).limit(1).addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                if(value != null){
                    for(DocumentSnapshot documentSnapshot : value.getDocuments()){
                        Map<String, Object> data = documentSnapshot.getData();
                        String dil = data.get("dil").toString();

                        if(dil.equals("t??rkce")){
                            binding.dZenleEditTextKullaniciAdi.setHint("Kullan??c?? ad??");
                            binding.editTextTextBiyografi.setHint("Biyografi");
                            kaydet.setText("Kaydet");

                        }else if (dil.equals("ingilizce")){
                            binding.dZenleEditTextKullaniciAdi.setHint("User name");
                            binding.editTextTextBiyografi.setHint("biography");
                            kaydet.setText("Save");
                        }

                    }
                }

            }
        });



    }



    public void registerLauncher() {


        activityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {
                if (result.getResultCode() == Activity.RESULT_OK) {
                    Intent intent = result.getData();
                    if (intent != null) {
                        imageData = intent.getData();
                        g??sterge.setVisibility(View.INVISIBLE);
                        try {
                            if (Build.VERSION.SDK_INT >= 28) {

                                ImageDecoder.Source source = ImageDecoder.createSource(getActivity().getContentResolver(), imageData);
                                selectedimage = ImageDecoder.decodeBitmap(source);
                                profile.setImageBitmap(selectedimage);
                            } else {
                                selectedimage = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), imageData);
                                profile.setImageBitmap(selectedimage);
                            }

                        } catch (Exception e1) {
                            e1.printStackTrace();
                        }






                  String uid = auth.getUid().toString();
                  final String name = "Kullan??c??lar/" + uid + ".jpg";

                  storageReference.child(name).putFile(imageData).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                      @Override
                      public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                          StorageReference storageReference = FirebaseStorage.getInstance().getReference(name);
                          storageReference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                              @Override
                              public void onSuccess(Uri uri) {

                                  String profileImage = uri.toString();

                                  HashMap<String ,Object> data = new HashMap<>();
                                  data.put("ImageProfile",profileImage);
                                  data.put("time", GetDateDetail.getDate());

                                  String yol = auth.getUid().toString();

                                  firebaseFirestore.collection("Profiles").document("Resimler").collection(yol).add(data).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                                      @Override
                                      public void onSuccess(DocumentReference documentReference) {
                                          System.out.println("ba??ar??l??");
                                      }
                                  }).addOnFailureListener(new OnFailureListener() {
                                      @Override
                                      public void onFailure(@NonNull Exception e) {
                                          Toast.makeText(getActivity(),e.getLocalizedMessage(),Toast.LENGTH_LONG).show();
                                      }
                                  });


                              }
                          });


                      }
                  });





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
                    firebaseFirestore.collection("Kullan??lanDiller").document(userId).collection("SecilenDil").orderBy("tarih", Query.Direction.DESCENDING).limit(1).addSnapshotListener(new EventListener<QuerySnapshot>() {
                        @Override
                        public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                           if(value != null){
                               for(DocumentSnapshot documentSnapshot : value.getDocuments()){
                                   Map<String, Object> data = documentSnapshot.getData();
                                   String dil = data.get("dil").toString();

                                   if(dil.equals("t??rkce")){
                                       Toast.makeText(getActivity(), "??zin verilmedi", Toast.LENGTH_LONG).show();

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




}