package com.example.grocery;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.activity.EdgeToEdge;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.grocery.R;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    ListView list;
    TextView date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (view, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());

            view.setPadding(
                    systemBars.left,
                    systemBars.top,
                    systemBars.right,
                    systemBars.bottom
            );

            return insets;
        });

        list = findViewById(R.id.listview);
        date = findViewById(R.id.textView2);

        String[] group1 = {"Carrot", "Tomato"};
        int[] group1Images = {
                R.drawable.carrot,
                R.drawable.tomato
        };

        String[] group2 = {"Cabbage", "Onion"};
        int[] group2Images = {
                R.drawable.cabbage,
                R.drawable.onion
        };

        String[] activeNames = group1.clone();
        int[] activeImages = group1Images.clone();

        ArrayAdapter<String> a1 =
                new ArrayAdapter<String>(
                        this,
                        R.layout.items,
                        R.id.textView3,
                        activeNames
                ) {

                    @NonNull
                    @Override
                    public View getView(
                            int position,
                            View convertView,
                            @NonNull ViewGroup parent
                    ) {
                        View row = super.getView(
                                position,
                                convertView,
                                parent
                        );

                        ImageView image =
                                row.findViewById(R.id.imageView);

                        image.setImageResource(activeImages[position]);

                        return row;
                    }
                };

        list.setAdapter(a1);

        date.setOnClickListener(view -> {

            Calendar today = Calendar.getInstance();

            int year = today.get(Calendar.YEAR);
            int month = today.get(Calendar.MONTH);
            int day = today.get(Calendar.DAY_OF_MONTH);

            new DatePickerDialog(
                    this,

                    (picker, selectedYear, selectedMonth, selectedDay) -> {

                        date.setText(
                                selectedDay
                                        + "-"
                                        + (selectedMonth + 1)
                                        + "-"
                                        + selectedYear
                        );

                        String[] chosenNames;
                        int[] chosenImages;

                        if (selectedDay <= 15) {

                            chosenNames = group1;
                            chosenImages = group1Images;

                        } else {

                            chosenNames = group2;
                            chosenImages = group2Images;
                        }

                        for (int i = 0; i < activeNames.length; i++) {

                            activeNames[i] = chosenNames[i];
                            activeImages[i] = chosenImages[i];
                        }

                        a1.notifyDataSetChanged();
                    },

                    year,
                    month,
                    day

            ).show();
        });
    }
}