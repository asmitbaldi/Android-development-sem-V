package com.example.datetimepicker;

import android.app.TimePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;

public class SecondActivity extends AppCompatActivity {
    TextView t1, t2, t3;
    EditText e4, e5;
    Button b3, b4, b5;
    String name, dept, dob;
    private int H, M;
    private static final String FILE_NAME = "project_data.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        t1 = findViewById(R.id.t1);
        t2 = findViewById(R.id.t2);
        t3 = findViewById(R.id.t3);
        e4 = findViewById(R.id.e4);
        e5 = findViewById(R.id.e5);
        b3 = findViewById(R.id.b3);
        b4 = findViewById(R.id.b4);
        b5 = findViewById(R.id.b5);

        name = getIntent().getStringExtra("EMP_NAME");
        dept = getIntent().getStringExtra("EMP_DEPT");
        dob = getIntent().getStringExtra("EMP_DOB");

        String info = "Name: " + name + "\nDept: " + dept + "\nDOB: " + dob;
        t2.setText(info);

        b3.setOnClickListener(v -> {
            final Calendar c = Calendar.getInstance();
            H = c.get(Calendar.HOUR_OF_DAY);
            M = c.get(Calendar.MINUTE);

            TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                    (view, hourOfDay, minute) -> {
                        e5.setText(hourOfDay + ":" + (minute < 10 ? "0" + minute : minute));
                    }, H, M, false);
            timePickerDialog.show();
        });

        b4.setOnClickListener(v -> {
            String projectName = e4.getText().toString().trim();
            String time = e5.getText().toString().trim();

            if (projectName.isEmpty() || time.isEmpty()) {
                Toast.makeText(this, R.string.m2, Toast.LENGTH_SHORT).show();
                return;
            }

            String dataToSave = info + "\nProject: " + projectName + "\nTime: " + time;

            try {
                FileOutputStream fos = openFileOutput(FILE_NAME, Context.MODE_PRIVATE);
                fos.write(dataToSave.getBytes());
                fos.close();
                Toast.makeText(this, getString(R.string.m3) + " " + getFilesDir() + "/" + FILE_NAME, Toast.LENGTH_LONG).show();
            } catch (Exception e) {
            }
        });

        b5.setOnClickListener(v -> {
            try {
                FileInputStream fis = openFileInput(FILE_NAME);
                InputStreamReader isr = new InputStreamReader(fis);
                BufferedReader br = new BufferedReader(isr);
                
                StringBuilder sb = new StringBuilder();
                String text;
                while ((text = br.readLine()) != null) {
                    sb.append(text).append("\n");
                }
                br.close();
                t3.setText(sb.toString());
                Toast.makeText(this, R.string.m5, Toast.LENGTH_SHORT).show();

            } catch (Exception e) {
            }
        });
    }
}
