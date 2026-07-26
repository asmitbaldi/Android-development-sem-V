package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView t1;
    EditText e1,e2;
    Button b1,b2,b3,b4,b5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        t1 = findViewById(R.id.textView);
        e1 = findViewById(R.id.editTextText);
        e2 = findViewById(R.id.editTextText2);
        b1 = findViewById(R.id.button);
        b2 = findViewById(R.id.button2);
        b3 = findViewById(R.id.button3);
        b4 = findViewById(R.id.button4);
        b5 = findViewById(R.id.button5);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double a,b,c;
                String s1=e1.getText().toString();
                String s2=e2.getText().toString();
                a = Double.parseDouble(s1);
                b = Double.parseDouble(s2);
                c = a+b;
                t1.setText("Add: "+ c);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double a,b,c;
                String s1 = e1.getText().toString();
                String s2 = e2.getText().toString();
                a = Double.parseDouble(s1);
                b = Double.parseDouble(s2);
                c = a-b;
                t1.setText("Sub: " + c);
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double a = Double.parseDouble(e1.getText().toString());
                double b = Double.parseDouble(e2.getText().toString());
                double c = a*b;
                t1.setText("Mul: "+ c);
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double a = Double.parseDouble(e1.getText().toString());
                double b = Double.parseDouble(e2.getText().toString());
                if (b!=0){
                    double c=a/b;
                    t1.setText("Div: "+ c);
                }
                else {
                    t1.setText("Can't be divided by 0");
                }
            }
        });

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                e1.setText("");
                e2.setText("");
                t1.setText("Result");
            }
        });
    }
}