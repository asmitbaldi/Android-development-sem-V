package com.example.knowyournumber;

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
    Button b1, b2;
    EditText numberInput;
    TextView resultText;

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

        b1 = findViewById(R.id.b1);
        b2 = findViewById((R.id.b2));
        numberInput = findViewById(R.id.numberInput);
        resultText = findViewById(R.id.resultText);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double a, fact = 1;
                String s1 = numberInput.getText().toString();
                a = Double.parseDouble(s1);
                for (int i = 1; i <= a; i++) {
                    fact = fact * i;
                }
                resultText.setText("Factorial is: " + fact);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double a;
                String s2 = numberInput.getText().toString();
                a = Double.parseDouble((s2));
                if (a % 2 == 0) {
                    resultText.setText("Even");
                } else {
                    resultText.setText(("Odd"));
                }
            }
        });
    }
}