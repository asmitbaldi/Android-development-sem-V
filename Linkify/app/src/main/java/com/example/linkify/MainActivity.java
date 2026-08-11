package com.example.linkify;

import static android.text.util.Linkify.MAP_ADDRESSES;
import static android.text.util.Linkify.PHONE_NUMBERS;
import static android.text.util.Linkify.WEB_URLS;

import android.os.Bundle;
import android.text.util.Linkify;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView t1,t2,t3;
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

        t1 = findViewById(R.id.textView);
        t2 = findViewById(R.id.textView2);
        t3 = findViewById(R.id.textView3);

        Linkify.addLinks(t1,WEB_URLS);
        Linkify.addLinks(t2,WEB_URLS);
        Linkify.addLinks(t3,PHONE_NUMBERS);
    }
}