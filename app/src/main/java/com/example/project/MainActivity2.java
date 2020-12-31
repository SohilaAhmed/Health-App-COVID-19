package com.example.project;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.LocusId;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity2 extends AppCompatActivity {
    TextView txt1;
    Button gs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        txt1 = findViewById(R.id.textView);
        gs=findViewById(R.id.button2);
       // Bundle b1 = getIntent().getExtras();
        //String s1 =  b1.getString("fname");
        //txt1.setText(s1);
//        gs.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent(MainActivity2.this , Survey.class);
//                startActivity(i);
//            }
//        });

    }

    public void logout(View view) {
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(getApplicationContext() , Login.class));
        finish();
    }

    public void getstart(View view) {
        startActivity(new Intent(MainActivity2.this , Survey.class));

    }
}