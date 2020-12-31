package com.example.project;

import android.widget.RadioButton;
import android.widget.RadioGroup;


import androidx.appcompat.app.AppCompatActivity;

public class Question extends AppCompatActivity {
    String question,ans1,ans2,ans3;
    RadioGroup rg;

    public Question(String question,String ans1,String ans2,String ans3) {
        this.question = question;
        this.ans1=ans1;
        this.ans2=ans2;
        this.ans3=ans3;
    }

    public String getAns() {

        rg=findViewById(R.id.bla);
        RadioButton rb=findViewById(rg.getCheckedRadioButtonId());
        return  rb.getText().toString();
    }

    public String getAns3() {
        return ans3;
    }

    public String getAns2() {
        return ans2;
    }

    public String getAns1() {
        return ans1;
    }

    public String getQuestion() {
        return question;
    }
}
