package com.example.webview;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RemoteWeb extends AppCompatActivity {

    Button b3;
    EditText e1;
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_remote_web);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        b3 = findViewById(R.id.button3);
        e1 = findViewById(R.id.editTextText);
        webView = findViewById(R.id.remote);

        webView.setWebViewClient(new WebViewClient());

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = e1.getText().toString().trim();

                if (url.isEmpty()){
                    e1.setError("Cannot be Empty");
                } else if (!url.matches("[a-zA-Z.]+")) {
                    e1.setError("Only alphabets and dot allowed");
                } else {
                    String fullUrl = "https://" + url;

                    AlertDialog.Builder builder = new AlertDialog.Builder(RemoteWeb.this);
                    builder.setTitle("Loading Website");
                    builder.setMessage("You want to visit " + url + "?");
                    builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            webView.loadUrl(fullUrl);
                        }
                    });
                    builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
                    builder.show();
                }
            }
        });
    }
}