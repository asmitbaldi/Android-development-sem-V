package com.example.mttprac;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button b1, b2;
    CheckBox c1, c2, c3, c4, c5, c6, c7, c8, c9, c10;
    EditText e1;

    ConstraintLayout cl;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main),
                (v, insets) -> {
                    Insets systemBars =
                            insets.getInsets(WindowInsetsCompat.Type.systemBars());

                    v.setPadding(
                            systemBars.left,
                            systemBars.top,
                            systemBars.right,
                            systemBars.bottom
                    );

                    return insets;
                });

        // Find Views
        e1 = findViewById(R.id.editTextText);

        b1 = findViewById(R.id.button);
        b2 = findViewById(R.id.button2);

        c1 = findViewById(R.id.checkBox);
        c2 = findViewById(R.id.checkBox2);
        c3 = findViewById(R.id.checkBox3);
        c4 = findViewById(R.id.checkBox4);
        c5 = findViewById(R.id.checkBox5);
        c6 = findViewById(R.id.checkBox6);
        c7 = findViewById(R.id.checkBox7);
        c8 = findViewById(R.id.checkBox8);
        c9 = findViewById(R.id.checkBox9);
        c10 = findViewById(R.id.checkBox10);

        cl = findViewById(R.id.main);

        cl.setBackgroundResource(R.color.pink);

        // Reset button
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                e1.setText("");

                c1.setChecked(false);
                c2.setChecked(false);
                c3.setChecked(false);
                c4.setChecked(false);
                c5.setChecked(false);
                c6.setChecked(false);
                c7.setChecked(false);
                c8.setChecked(false);
                c9.setChecked(false);
                c10.setChecked(false);
            }
        });

        // Done button
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                cl.setBackgroundResource(R.color.green);

                String input = e1.getText().toString().trim();

                if (input.isEmpty()) {
                    Toast.makeText(
                            MainActivity.this,
                            "Please enter a number",
                            Toast.LENGTH_SHORT
                    ).show();
                    return;
                }

                try {
                    int number = Integer.parseInt(input);

                    int sum = 0;

                    if (c1.isChecked()) {
                        sum += 1;
                        cl.setBackgroundResource(R.color.green);
                    }

                    if (c2.isChecked()) {
                        sum += 2;
                    }

                    if (c3.isChecked()) {
                        sum += 3;
                    }

                    if (c4.isChecked()) {
                        sum += 4;
                    }

                    if (c5.isChecked()) {
                        sum += 5;
                    }

                    if (c6.isChecked()) {
                        sum += 6;
                    }

                    if (c7.isChecked()) {
                        sum += 7;
                    }

                    if (c8.isChecked()) {
                        sum += 8;
                    }

                    if (c9.isChecked()) {
                        sum += 9;
                    }

                    if (c10.isChecked()) {
                        sum += 10;
                    }

                    if (number == sum) {

                        Toast.makeText(
                                MainActivity.this,
                                "You Did Well",
                                Toast.LENGTH_SHORT
                        ).show();

                    } else if (sum > number) {

                        Toast.makeText(
                                MainActivity.this,
                                "Try one more time",
                                Toast.LENGTH_SHORT
                        ).show();

                    } else {

                        Toast.makeText(
                                MainActivity.this,
                                "You can't do it",
                                Toast.LENGTH_SHORT
                        ).show();

                        Toast.makeText(MainActivity.this, "", Toast.LENGTH_SHORT).show();
                    }

                } catch (NumberFormatException e) {

                    Toast.makeText(
                            MainActivity.this,
                            "Please enter a valid number",
                            Toast.LENGTH_SHORT
                    ).show();
                }
            }
        });
    }
}