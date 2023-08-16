package com.example.tempreture;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    String str;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner spinner=findViewById(R.id.spinner);
        Button btn=findViewById(R.id.btn1);
        EditText temp=(EditText) findViewById(R.id.num);
       TextView r=findViewById(R.id.text);
       TextView degree=findViewById(R.id.dgree);


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
               String item=parent.getItemAtPosition(position).toString();
               str=item;
                if(str=="Fahrenheit")
                {
                    degree.setText("℃");
                }
                if(str=="Celsius")
                {
                    degree.setText("℉");
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        ArrayList<String> items=new ArrayList<>();
        items.add("Fahrenheit");
        items.add("Celsius");
        ArrayAdapter<String > adapter=new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,items);
        adapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        spinner.setAdapter(adapter);
         btn.setOnClickListener(new View.OnClickListener() {
             Double result=0.0;
             @Override
             public void onClick(View view) {
                 String s1=temp.getText().toString();
                 if(s1.isEmpty())
                 {
                       r.setText("Please Given Temperature");
                 }
                 else
                 {
                     Double x=Double.parseDouble(s1);
                     if(str=="Fahrenheit")
                     {
                         result=(x*9)/5+32;
                         String s2=String.format("%.3f",result);
                         r.setText(s2 +" ℉");
                     }
                     else if(str=="Celsius")
                     {
                         result=(x-32)*5/9;
                         String s2=String.format("%.3f",result);
                         r.setText(s2 +" ℃");

                     }

                 }
             }
         });
    }
}