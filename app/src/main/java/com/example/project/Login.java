package com.example.project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {
    EditText emailtxt1 , passwordtxt1;
    Button login;
    TextView logtxt;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        emailtxt1 = findViewById(R.id.email);
        passwordtxt1 = findViewById(R.id.pass);
        login = findViewById(R.id.button4);
        logtxt = findViewById(R.id.textVi);
        auth = FirebaseAuth.getInstance();
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailtxt1.getText().toString().trim();
                String password = passwordtxt1.getText().toString().trim();
                if(TextUtils.isEmpty(email)){
                    emailtxt1.setError("Email is required");
                    return ;
                }
                if(TextUtils.isEmpty(password)){
                    passwordtxt1.setError("password is required");
                    return ;
                }
                if(password.length() < 6){
                    passwordtxt1.setError("password must be greater than or equal to 6 ");
                    return ;
                }
              auth.signInWithEmailAndPassword(email , password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                  @Override
                  public void onComplete(@NonNull Task<AuthResult> task) {
                      if(task.isSuccessful()){
                          Toast.makeText(Login.this , "Login successful" , Toast.LENGTH_SHORT).show();
                          startActivity(new Intent(getApplicationContext() , MainActivity2.class));
                      }else{
                          Toast.makeText(Login.this , "Error" +task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                      }

                  }
              });
            }
        });
        logtxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext() , MainActivity.class));
            }
        });
    }
}