package com.example.project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends ArrayAdapter<Question> {
    Context _cont;
    int res;
    List<Question> items;
    public static ArrayList<String> selectedAnswers;

    public MyAdapter(@NonNull Context context, int resource, @NonNull List<Question> questions) {
        super(context, resource, questions);
        _cont=context;
        res=resource;
        items=questions;
        selectedAnswers = new ArrayList<>();
        for (int i = 0; i < questions.size(); i++) {
            selectedAnswers.add("Not Attempted");
        }
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
    View row;
        LayoutInflater loi=(LayoutInflater) _cont.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        row=loi.inflate(res,parent,false);
        TextView ques=row.findViewById(R.id.question);
        ques.setText(items.get(position).getQuestion());



        RadioButton ans1=row.findViewById(R.id.ans1);
        ans1.setText(items.get(position).getAns1());

        RadioButton ans2=row.findViewById(R.id.ans2);
        ans2.setText(items.get(position).getAns2());

        RadioButton ans3=row.findViewById(R.id.ans3);
        ans3.setText(items.get(position).getAns3());

ans1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            // set ans1 values in ArrayList if RadioButton is checked
                if (isChecked)
                    selectedAnswers.set(position, "a1");
            }
        });
        ans2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // set ans2 values in ArrayList if RadioButton is checked
                if (isChecked)
                    selectedAnswers.set(position, "a2");
            }
        });
        ans3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // set ans3 values in ArrayList if RadioButton is checked
                if (isChecked)
                    selectedAnswers.set(position, "a3");
                
            }
        });
    return row;

    }
//    public void checkButton(View v){
//        int radioID = rg.getCheckedRadioButtonId();
//        rb=findViewById(radioID);
//    }
}
