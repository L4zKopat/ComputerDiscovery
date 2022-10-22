package com.example.kutaykerem.computerinformaton.Sign;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.kutaykerem.computerinformaton.Pages.AnaSayfa;
import com.example.kutaykerem.computerinformaton.R;
import com.example.kutaykerem.computerinformaton.databinding.ActivityUserLoginBinding;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;

public class UserLogin extends AppCompatActivity {

    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;

    FirebaseFirestore firebaseFirestore;
  //  GoogleSignInOptions googleSignInOptions;
   // GoogleSignInClient googleSignInClient;

    public ActivityUserLoginBinding binding;

    String userId;

    HashMap<String,Object> data;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUserLoginBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

       // googleSignInOptions = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
      //  googleSignInClient = GoogleSignIn.getClient(this, googleSignInOptions);


      //  GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);
        //   if(acct!=null){
        //     googleSignActivity();
        //  }














        firebaseAuth = FirebaseAuth.getInstance();



        firebaseUser = firebaseAuth.getCurrentUser();

        Intent cıkısIntent = getIntent();

        if(cıkısIntent.getStringExtra("cıkıs") != null){
            firebaseAuth.signOut();
        }else{



            if (firebaseUser != null) {
                Intent intent = new Intent(UserLogin.this, AnaSayfa.class);
                startActivity(intent);
            }

        }



    }



    public void giris(View view) {

        String email = binding.email.getText().toString();
        String password = binding.sifre.getText().toString();

        if (TextUtils.isEmpty(email)) {

            binding.email.setError("Email");
        } else if (TextUtils.isEmpty(password)) {
            binding.sifre.setError("Password");

        } else {
            firebaseAuth.signInWithEmailAndPassword(email,password).addOnSuccessListener(this, new OnSuccessListener<AuthResult>() {
                @Override
                public void onSuccess(AuthResult authResult) {
                    Intent intent = new Intent(UserLogin.this, AnaSayfa.class);
                    startActivity(intent);


                }
            }).addOnFailureListener(this, new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(getApplicationContext(),e.getLocalizedMessage(),Toast.LENGTH_LONG).show();
                }
            });
        }
    }


    public void kayıt (View view){
            Intent intent = new Intent(UserLogin.this, Kayıt.class);
            startActivity(intent);

    }

      /*  public void google (View view){
            Intent signIntent = googleSignInClient.getSignInIntent();
            startActivityForResult(signIntent, 1000);
        }




        @Override
        protected void onActivityResult ( int requestCode, int resultCode, @Nullable Intent data){
            super.onActivityResult(requestCode, resultCode, data);

            if (requestCode == 1000) {

                Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
                try {
                    task.getResult(ApiException.class);
                    googleSignActivity();

                } catch (ApiException e) {
                    Toast.makeText(UserLogin.this, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                }

            }
        }
        public void googleSignActivity () {
            finish();
            Intent intent = new Intent(UserLogin.this, AnaSayfa.class);
            startActivity(intent);

        }

          */


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK){
            Intent setIntent = new Intent(Intent.ACTION_MAIN);
            setIntent.addCategory(Intent.CATEGORY_HOME);
            setIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(setIntent);
        }

        return super.onKeyDown(keyCode, event);

    }
}
