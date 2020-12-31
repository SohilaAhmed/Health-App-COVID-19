package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class Analysis extends AppCompatActivity {

    TextView res;
    TextView temp,head,cuf,brt,prg,snt,bodp;
    Button reg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analysis);
        res=findViewById(R.id.gen);
        temp=findViewById(R.id.temp);
        head=findViewById(R.id.head);
        cuf=findViewById(R.id.cuf);
        brt=findViewById(R.id.brt);
        prg=findViewById(R.id.prg);
        snt=findViewById(R.id.snt);
        bodp=findViewById(R.id.bodp);
        reg=findViewById(R.id.regbtn);


       Intent i=getIntent();
        //retrieving data
        String[] o=i.getStringArrayExtra("Survey");
// assigning to the page
        res.setText(o[0]);
        temp.setText(o[1]);
        head.setText(o[2]);
        cuf.setText(o[3]);
        brt.setText(o[4]);
        prg.setText(o[5]);
        snt.setText(o[6]);
        bodp.setText(o[7]);

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                  Intent p=new Intent(Analysis.this,MainActivity2.class);
//                  p.putExtra("result",o);
//                  Intent z=new Intent(Analysis.this,MainActivity.class);
//                  startActivity(z);
//                public void logout(View view) {
                    FirebaseAuth.getInstance().signOut();
                    startActivity(new Intent(getApplicationContext() , Login.class));
                    finish();
//                }
            }
        });

    }
 public void barra(View v){
        Intent i=new Intent(Analysis.this,Survey.class);
        startActivity(i);
    }
}