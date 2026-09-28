package com.example.datetimepicker;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    EditText e1, e2, e3;
    Button b1, b2;
    private int Y, M, D;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e1 = findViewById(R.id.e1);
        e2 = findViewById(R.id.e2);
        e3 = findViewById(R.id.e3);
        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);

        b1.setOnClickListener(v -> {
            final Calendar c = Calendar.getInstance();
            Y = c.get(Calendar.YEAR);
            M = c.get(Calendar.MONTH);
            D = c.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                    (view, year, month, dayOfMonth) -> {
                        e3.setText(dayOfMonth + "-" + (month + 1) + "-" + year);
                    }, Y, M, D);
            datePickerDialog.show();
        });

        b2.setOnClickListener(v -> {
            String name = e1.getText().toString().trim();
            String dept = e2.getText().toString().trim();
            String dob = e3.getText().toString().trim();

            if (name.isEmpty() || dept.isEmpty() || dob.isEmpty()) {
                Toast.makeText(this, R.string.m1, Toast.LENGTH_SHORT).show();
            } else {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("EMP_NAME", name);
                intent.putExtra("EMP_DEPT", dept);
                intent.putExtra("EMP_DOB", dob);
                startActivity(intent);
            }
        });
    }
}
