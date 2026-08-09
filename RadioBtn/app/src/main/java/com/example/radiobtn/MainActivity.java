package com.example.radiobtn;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button button,button2;
    RadioGroup Rg1,Rg2;

    ConstraintLayout cl;

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
        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        Rg1 = findViewById(R.id.Rg1);
        Rg2 = findViewById(R.id.Rg2);
        cl = findViewById(R.id.main);

        Rg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull RadioGroup group, int checkedId) {
                RadioButton rb = findViewById(checkedId);
                if (checkedId != -1){
                    String s1 = rb.getText().toString();
                    if (s1.equals("A")) cl.setBackgroundResource(R.color.cyan);
                    if (s1.equals("B")) cl.setBackgroundResource(R.color.pink);
                    if (s1.equals("C")) cl.setBackgroundResource(R.color.yellow);
            }   else{
                    cl.setBackgroundResource(R.color.white);
                    Toast.makeText(MainActivity.this, "Clear", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Rg2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull RadioGroup group, int checkedId) {
                RadioButton rb2 = findViewById(checkedId);
                if (checkedId != -1) {
                    String s1 = rb2.getText().toString();
                    if (s1.equals("D")) cl.setBackgroundResource(R.color.pink);
                    if (s1.equals("E")) cl.setBackgroundResource(R.color.cyan);
                    if (s1.equals("F")) cl.setBackgroundResource(R.color.yellow);
            }   else{
                    cl.setBackgroundResource(R.color.white);
                    Toast.makeText(MainActivity.this, "Clear", Toast.LENGTH_SHORT).show();
                }
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioButton rb1 = findViewById(Rg1.getCheckedRadioButtonId());
                RadioButton rb2 = findViewById(Rg2.getCheckedRadioButtonId());
                if (Rg1.getCheckedRadioButtonId() != -1 && Rg2.getCheckedRadioButtonId() != -1){
                    String s1 = "You are " + rb1.getText().toString() + " and are a " + rb2.getText().toString();
                    Toast.makeText(MainActivity.this, s1, Toast.LENGTH_SHORT).show();
            }   else Toast.makeText(MainActivity.this, "First Select", Toast.LENGTH_SHORT).show();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Rg1.clearCheck();
                Rg2.clearCheck();
            }
        });
    }

}