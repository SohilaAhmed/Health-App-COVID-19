package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Survey extends AppCompatActivity {
    ListView lst;
    MyAdapter adt;
    List<Question> questions;
    Button sub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey);


        lst =findViewById(R.id.lstvew);
        Intent in=getIntent();
        questions=new ArrayList<Question>();
        questions.add(new Question(getString(R.string.tempq),getString(R.string.tempa1),getString(R.string.tempa2),getString(R.string.tempa3)));
        questions.add(new Question(getString(R.string.headq),getString(R.string.heada1),getString(R.string.heada2),getString(R.string.heada3)));
        questions.add(new Question(getString(R.string.cufq),getString(R.string.cufa1),getString(R.string.cufa2),getString(R.string.cufa3)));
        questions.add(new Question(getString(R.string.brtq),getString(R.string.brta1),getString(R.string.brta2),getString(R.string.brta3)));
        questions.add(new Question(getString(R.string.prgq),getString(R.string.prga1),getString(R.string.prga2),getString(R.string.prga3)));
        questions.add(new Question(getString(R.string.sntq),getString(R.string.snta1),getString(R.string.snta2),getString(R.string.snta3)));
        questions.add(new Question(getString(R.string.bpq),getString(R.string.bpa1),getString(R.string.bpa2),getString(R.string.bpa3)));


        adt=new MyAdapter(this,R.layout.row,questions);
        lst.setAdapter(adt);
        sub=findViewById(R.id.submit);

       sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] an=Rosheta(MyAdapter.selectedAnswers);
                if (!ansChk(an)){
                    Toast.makeText(getApplicationContext(),getString(R.string.noAn), Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent in = new Intent(getApplicationContext(), Analysis.class);
                    in.putExtra("Survey", an);
                    startActivity(in);
                }
            }
        });


    }

    protected void onSaveInstanceState(Bundle outstate){
        super.onSaveInstanceState(outstate);
    }

    public boolean ansChk(String[] k){
        for(int i=0;i<k.length;i++){
            if(k[i]=="nA")
                return false;
        }
        return true;
    }

    public String[] Rosheta(List<String> s){

        String[] t=new String[8];
        t[1]=getString(R.string.t);
        t[2]=getString(R.string.h);
        t[3]=getString(R.string.c);
        t[4]=getString(R.string.b);
        t[5]=getString(R.string.p);
        t[6]=getString(R.string.s);
        t[7]=getString(R.string.bp);
        double oa=0;

        if(s.get(0)=="a1"){t[1] +=getString(R.string.tempan1);}
        else if(s.get(0)=="a2"){t[1]+=getString(R.string.tempan2);
        oa+=0.5;}
        else if(s.get(0)=="a3"){t[1]+=getString(R.string.tempan3);
        oa+=1;}
        else{t[1]="nA";}
        ////
        if(s.get(1)=="a1"){t[2]+=getString(R.string.headan1);}
        else if(s.get(1)=="a2"){t[2]+=getString(R.string.headan2);
            oa+=0.5;}
        else if(s.get(1)=="a3"){t[2]+=getString(R.string.headan3);
            oa+=1;}
        else{t[2]="nA";}

        ////
        if(s.get(2)=="a1"){t[3]+=getString(R.string.cufan1);}
        else if(s.get(2)=="a2"){t[3]+=getString(R.string.cufan2);
            oa+=0.5;}
        else if(s.get(2)=="a3"){t[3]+=getString(R.string.cufan3);
            oa+=1;}
        else{t[3]="nA";}

        ///////
        if(s.get(3)=="a1"){t[4]+=getString(R.string.brtan1);}
        else if(s.get(3)=="a2"){t[4]+=getString(R.string.brtan2);
            oa+=0.5;}
        else if(s.get(3)=="a3"){t[4]+=getString(R.string.brtan3);
            oa+=1;}
        else{t[4]="nA";}

        ////
        if(s.get(4)=="a1"){t[5]+=getString(R.string.prgan1);}
        else if(s.get(4)=="a2"){t[5]+=getString(R.string.prgan2);
            oa+=0.5;}
        else if(s.get(4)=="a3"){t[5]+=getString(R.string.prgan3);
            oa+=1;}
        else{t[5]="nA";}

        /////
        if(s.get(5)=="a1"){t[6]+=getString(R.string.sntan1);}
        else if(s.get(5)=="a2"){t[6]+=getString(R.string.sntan2);
            oa+=0.5;}
        else if(s.get(5)=="a3"){t[6]+=getString(R.string.sntan3);
            oa+=1;}
        else{t[6]="nA";}

        /////
        if(s.get(6)=="a1"){t[7]+=getString(R.string.bpan1);}
        else if(s.get(6)=="a2"){t[7]+=getString(R.string.bpan2);
            oa+=0.5;}
        else if(s.get(6)=="a3"){t[7]+=getString(R.string.bpan3);
            oa+=1;}
        else{t[7]="nA";}

        ////
        if(oa<=3)
            t[0]=getString(R.string.gc);
        else if(oa>=3.5 && oa<=5)
            t[0]=getString(R.string.mc);
        else
            t[0]=getString(R.string.cc);



        return t;

    }
}