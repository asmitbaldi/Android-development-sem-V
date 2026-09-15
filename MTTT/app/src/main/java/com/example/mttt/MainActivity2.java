package com.example.mttt;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    Button b2;

    RadioButton r1,r2,r3,r4;

    ConstraintLayout cl;

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

        r1 = findViewById(R.id.radioButton);
        r2 = findViewById(R.id.radioButton2);
        r3 = findViewById(R.id.radioButton3);
        r4 = findViewById(R.id.radioButton4);

        b2 = findViewById(R.id.button2);

        //cl = findViewById(R.id.main);

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (r1.isChecked()){
                    Toast.makeText(MainActivity2.this, "Asmit", Toast.LENGTH_SHORT).show();
                }
                if (r2.isChecked()){
                    Toast.makeText(MainActivity2.this, "Baldi", Toast.LENGTH_SHORT).show();
                }
                if (r3.isChecked()) {
                    cl.setBackgroundResource(R.color.red);
                }
                if (r4.isChecked()) {
                    cl.setBackgroundResource(R.color.green);
                }
            }
        });
    }
}