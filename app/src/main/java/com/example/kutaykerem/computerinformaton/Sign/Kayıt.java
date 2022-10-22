package com.example.kutaykerem.computerinformaton.Sign;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kutaykerem.computerinformaton.Models.GetDateDetail;
import com.example.kutaykerem.computerinformaton.Pages.AnaSayfa;
import com.example.kutaykerem.computerinformaton.Models.GetDate;
import com.example.kutaykerem.computerinformaton.R;
import com.example.kutaykerem.computerinformaton.databinding.ActivityKayitBinding;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.HashMap;

public class Kayıt extends AppCompatActivity {

    FirebaseAuth firebaseAuth;
    TextView kullanıcıAdi;
    public ActivityKayitBinding binding;

    DatabaseReference databaseReference = null;
    FirebaseDatabase database=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityKayitBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);


        firebaseAuth = FirebaseAuth.getInstance();

        kullanıcıAdi = findViewById(R.id.kullaniciadi);

        database = FirebaseDatabase.getInstance();


    }




    public void kaydol(View view) {


        String email = binding.mail.getText().toString();

        String password = binding.sifre.getText().toString();

        String kullanıcıAdı = binding.kullaniciadi.getText().toString();

        if (TextUtils.isEmpty(email)) {

            binding.mail.setError("Email");
        } else if (TextUtils.isEmpty(password)) {
            binding.sifre.setError("Password");

        } else {
            firebaseAuth.createUserWithEmailAndPassword(email,password).addOnSuccessListener(this, new OnSuccessListener<AuthResult>() {
                @Override
                public void onSuccess(AuthResult authResult) {
                    databaseReference = database.getReference().child("Profile");
                    FirebaseUser user = firebaseAuth.getCurrentUser();
                    databaseReference.child(user.getUid()).child("kullanıcıAdı").setValue(kullanıcıAdı);
                    Intent intent = new Intent(Kayıt.this, AnaSayfa.class);
                    startActivity(intent);

                    HashMap<String,Object> data = new HashMap<>();
                    data.put("kullanıcıAdı",kullanıcıAdı);
                    data.put("tarih", GetDate.getDate());
                    DatabaseReference reference = FirebaseDatabase.getInstance().getReference("KatılmaTarihi").child(user.getUid());

                    reference.push().setValue(data);





                    HashMap<String,Object> datas = new HashMap<>();
                    datas.put("dil","ingilizce");
                    datas.put("tarih", GetDateDetail.getDate());

                    FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
                    firebaseFirestore.collection("KullanılanDiller").document(user.getUid()).collection("SecilenDil").add(datas);




                }


            }).addOnFailureListener(this, new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(Kayıt.this, e.getLocalizedMessage(), Toast.LENGTH_LONG).show();
                }
            });

        }


    }



}