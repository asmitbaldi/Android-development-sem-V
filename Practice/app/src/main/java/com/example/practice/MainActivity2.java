package com.example.practice;

import android.os.Bundle;
import android.text.util.Linkify;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    Button b5;
    TextView t2,t3;

    CheckBox ch1,ch2,ch3,ch4;
    RadioButton rb1,rb2,rb3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        rb1 = findViewById(R.id.radioButton);
        rb2 = findViewById(R.id.radioButton2);
        rb3 = findViewById(R.id.radioButton3);

        ch1 = findViewById(R.id.checkBox);
        ch2 = findViewById(R.id.checkBox2);
        ch3 = findViewById(R.id.checkBox3);
        ch4 = findViewById(R.id.checkBox4);

        t2 = findViewById(R.id.textView2);

        b5 = findViewById(R.id.button5);
        t3 = findViewById(R.id.textView3);

        Linkify.addLinks(t3,Linkify.WEB_URLS);

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = 0;
                int b = 0;
                if (rb1.isChecked()) {
                    a = 500;
                } else if (rb2.isChecked()) {
                    a = 300;
                } else if (rb3.isChecked()) {
                    a = 200;
                }

                if (ch1.isChecked()){
                    b = b + 150;
                }
                if (ch2.isChecked()){
                    b = b + 50;
                }
                if (ch3.isChecked()){
                    b = b + 500;
                }
                if (ch4.isChecked()){
                    b = b + 200;
                }

                int fee;
                fee = a + b;

                t2.setText(String.valueOf(fee));

                Toast.makeText(MainActivity2.this, "Registration Successful!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}