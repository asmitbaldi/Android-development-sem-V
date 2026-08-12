package com.example.listview;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    Spinner sp1, sp2;

    String school[] = {"Select School", "STME", "SBM"};

    String STME[] = {"Select Course", "CE", "AI&DS"};

    String SBM[] = {"Selct Course", "Finance", "Marketing"};

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
        sp1 = findViewById(R.id.spinner);
        sp2 = findViewById(R.id.spinner2);

        ArrayAdapter ar = new ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, school);
        ArrayAdapter ar1 = new ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, STME);
        ArrayAdapter ar2 = new ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, SBM);

        sp1.setAdapter(ar);

        sp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(id==1)
                {
                    sp2.setAdapter(ar1);
                }
                if(id==2)
                {
                    sp2.setAdapter(ar2);
                }
                sp2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        if (sp2.getSelectedItemId() != 0){
                            String s1 = sp1.getSelectedItem().toString();
                            String s2 = sp2.getSelectedItem().toString();
                            Toast.makeText(MainActivity2.this, "Your School is "+ s1 + " and your branch is " + s2, Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}