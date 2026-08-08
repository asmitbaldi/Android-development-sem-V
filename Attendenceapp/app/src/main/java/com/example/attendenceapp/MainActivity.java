package com.example.attendenceapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    CheckBox checkBox1,checkBox2,checkBox3,checkBox4,checkBox5,checkBox6,checkBox7,checkBox8,checkBox9,checkBox10,checkBox11,checkBox12;
    Button btnAllPresent, btnAllAbsent, btnSubmit;

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

        checkBox1 = findViewById(R.id.checkBox1);
        checkBox2 = findViewById(R.id.checkBox2);
        checkBox3 = findViewById(R.id.checkBox3);
        checkBox4 = findViewById(R.id.checkBox4);
        checkBox5 = findViewById(R.id.checkBox5);
        checkBox6 = findViewById(R.id.checkBox6);
        checkBox7 = findViewById(R.id.checkBox7);
        checkBox8 = findViewById(R.id.checkBox8);
        checkBox9 = findViewById(R.id.checkBox9);
        checkBox10 = findViewById(R.id.checkBox10);
        checkBox11 = findViewById(R.id.checkBox11);
        checkBox12 = findViewById(R.id.checkBox12);

        checkBox1.setBackgroundResource(R.color.red);
        checkBox2.setBackgroundResource(R.color.red);
        checkBox3.setBackgroundResource(R.color.red);
        checkBox4.setBackgroundResource(R.color.red);
        checkBox5.setBackgroundResource(R.color.red);
        checkBox6.setBackgroundResource(R.color.red);
        checkBox7.setBackgroundResource(R.color.red);
        checkBox8.setBackgroundResource(R.color.red);
        checkBox9.setBackgroundResource(R.color.red);
        checkBox10.setBackgroundResource(R.color.red);
        checkBox11.setBackgroundResource(R.color.red);
        checkBox12.setBackgroundResource(R.color.red);

        checkBox1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox1.isChecked()) checkBox1.setBackgroundResource(R.color.white);
                else checkBox1.setBackgroundResource(R.color.red);
            }
        });

        btnAllPresent = findViewById(R.id.button2);
        btnAllAbsent = findViewById(R.id.button3);
        btnSubmit = findViewById(R.id.button4);
        btnAllPresent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkBox1.setChecked(true);
                checkBox2.setChecked(true);
                checkBox3.setChecked(true);
                checkBox4.setChecked(true);
                checkBox5.setChecked(true);
                checkBox6.setChecked(true);
                checkBox7.setChecked(true);
                checkBox8.setChecked(true);
                checkBox9.setChecked(true);
                checkBox10.setChecked(true);
                checkBox11.setChecked(true);
                checkBox12.setChecked(true);

                checkBox1.setBackgroundResource(R.color.white);
                checkBox2.setBackgroundResource(R.color.white);
                checkBox3.setBackgroundResource(R.color.white);
                checkBox4.setBackgroundResource(R.color.white);
                checkBox5.setBackgroundResource(R.color.white);
                checkBox6.setBackgroundResource(R.color.white);
                checkBox7.setBackgroundResource(R.color.white);
                checkBox8.setBackgroundResource(R.color.white);
                checkBox9.setBackgroundResource(R.color.white);
                checkBox10.setBackgroundResource(R.color.white);
                checkBox11.setBackgroundResource(R.color.white);
                checkBox12.setBackgroundResource(R.color.white);
            }
        });
        btnAllAbsent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkBox1.setChecked(false);
                checkBox2.setChecked(false);
                checkBox3.setChecked(false);
                checkBox4.setChecked(false);
                checkBox5.setChecked(false);
                checkBox6.setChecked(false);
                checkBox7.setChecked(false);
                checkBox8.setChecked(false);
                checkBox9.setChecked(false);
                checkBox10.setChecked(false);
                checkBox11.setChecked(false);
                checkBox12.setChecked(false);

                checkBox1.setBackgroundResource(R.color.red);
                checkBox2.setBackgroundResource(R.color.red);
                checkBox3.setBackgroundResource(R.color.red);
                checkBox4.setBackgroundResource(R.color.red);
                checkBox5.setBackgroundResource(R.color.red);
                checkBox6.setBackgroundResource(R.color.red);
                checkBox7.setBackgroundResource(R.color.red);
                checkBox8.setBackgroundResource(R.color.red);
                checkBox9.setBackgroundResource(R.color.red);
                checkBox10.setBackgroundResource(R.color.red);
                checkBox11.setBackgroundResource(R.color.red);
                checkBox12.setBackgroundResource(R.color.red);
            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = 0;
                if(checkBox1.isChecked()) a++;
                if(checkBox2.isChecked()) a++;
                if(checkBox3.isChecked()) a++;
                if(checkBox4.isChecked()) a++;
                if(checkBox5.isChecked()) a++;
                if(checkBox6.isChecked()) a++;
                if(checkBox7.isChecked()) a++;
                if(checkBox8.isChecked()) a++;
                if(checkBox9.isChecked()) a++;
                if(checkBox10.isChecked()) a++;
                if(checkBox11.isChecked()) a++;
                if(checkBox12.isChecked()) a++;
                Toast.makeText(MainActivity.this, "Total students present:"+a, Toast.LENGTH_SHORT).show();
            }
        });
    }
}