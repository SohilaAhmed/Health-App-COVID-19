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

public class MainActivity extends AppCompatActivity {
    EditText nametxt, emailtxt , passwordtxt;
    Button register;
    TextView txt;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nametxt = findViewById(R.id.editTextTextPersonName2);
        emailtxt = findViewById(R.id.email);
        passwordtxt = findViewById(R.id.pass);
        register = findViewById(R.id.button5);
        txt = findViewById(R.id.textVi);
        auth = FirebaseAuth.getInstance();

        if (auth.getCurrentUser() != null){
            startActivity(new Intent(getApplicationContext() , MainActivity2.class));
            finish();
        }

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailtxt.getText().toString().trim();
                String password = passwordtxt.getText().toString().trim();
                //Intent p =  new Intent(getApplicationContext() , MainActivity2.class);
                //p.putExtra("fname" , nametxt.getText().toString());

                if(TextUtils.isEmpty(email)){
                    emailtxt.setError("Email is required");
                    return ;
                }
                if(TextUtils.isEmpty(password)){
                    passwordtxt.setError("password is required");
                    return ;
                }
                if(password.length() < 6){
                    passwordtxt.setError("password must be greater than or equal to 6 ");
                    return ;
                }
                auth.createUserWithEmailAndPassword(email , password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(MainActivity.this , "User created" , Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext() , MainActivity2.class));
                        }else{
                            Toast.makeText(MainActivity.this , "Error" +task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                           }
        });
        txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext() , Login.class));
            }
        });
    }
}