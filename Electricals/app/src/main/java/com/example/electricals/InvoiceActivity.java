package com.example.electricals;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class InvoiceActivity extends AppCompatActivity {

    private TextView tvCustomerSummary;
    private ListView invoiceListView;
    private Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_invoice);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.invoice_main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tvCustomerSummary = findViewById(R.id.tvCustomerSummary);
        invoiceListView = findViewById(R.id.invoiceListView);
        btnBack = findViewById(R.id.btnBack);

        Intent intent = getIntent();
        String customerName = intent.getStringExtra("CUSTOMER_NAME");
        String customerPhone = intent.getStringExtra("CUSTOMER_PHONE");
        String grandTotal = intent.getStringExtra("GRAND_TOTAL");
        ArrayList<String> billDetails = intent.getStringArrayListExtra("BILL_DETAILS");

        if (customerName == null) customerName = "Customer";
        if (customerPhone == null) customerPhone = "N/A";
        if (billDetails == null) billDetails = new ArrayList<>();

        String summaryText = "Customer: " + customerName + "\n" +
                "Phone: " + customerPhone + "\n" +
                "Grand Total: ₹" + (grandTotal != null ? grandTotal : "0.00");
        tvCustomerSummary.setText(summaryText);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                billDetails
        );
        invoiceListView.setAdapter(adapter);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}