package com.example.counter;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvCounter;

    Button btnIncrease, btnDecrease, btnReset;

    int count = 0;

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

        tvCounter = findViewById(R.id.tvCounter);
        btnIncrease = findViewById(R.id.btnIncrease);
        btnDecrease = findViewById(R.id.btnDecrease);
        btnReset = findViewById(R.id.btnReset);

        btnIncrease.setOnClickListener(v -> {
            count++;
            tvCounter.setText(String.valueOf(count));
        });

        btnDecrease.setOnClickListener(v -> {
            count--;
            tvCounter.setText(String.valueOf(count));
        });

        btnReset.setOnClickListener(v -> {
            count = 0;
            tvCounter.setText(String.valueOf(count));
        });

    }
}