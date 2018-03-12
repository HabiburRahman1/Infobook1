package com.example.habib.infobook;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LogIn extends AppCompatActivity {
    private Button nLogIn;
    private Button nRegister;
    private EditText nemail;
    private EditText npassword;



    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        nLogIn=(Button)findViewById(R.id.login);
        nRegister=(Button)findViewById(R.id.register);

        nemail=(EditText) findViewById(R.id.email);
        npassword=(EditText) findViewById(R.id.password);


        final ProgressDialog progress = new ProgressDialog(this);

        mAuth = FirebaseAuth.getInstance();

        nRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LogIn.this, MainActivity.class));

            }
        });

        nLogIn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                progress.setTitle("Loading");
                progress.setMessage("Wait while loading...");
                progress.setCancelable(false); // disable dismiss by tapping outside of the dialog
                progress.show();
                checkLogin(progress);
            }
        });
    }
    public void checkLogin(final ProgressDialog progress){
        String email=nemail.getText().toString();
        String password=npassword.getText().toString();
        if((!TextUtils.isEmpty(email))&& (!TextUtils.isEmpty(password))){
            mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        progress.dismiss();
                        startActivity(new Intent(LogIn.this, ProfileActivity.class));


                    }
                    else{
                        progress.dismiss();
                        Toast.makeText(LogIn.this," Error",Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
        else {
            progress.dismiss();
            Toast.makeText(LogIn.this," Error",Toast.LENGTH_SHORT).show();
        }




    }

    @Override
    public void onBackPressed(){
        moveTaskToBack(true);
    }
}
