package com.example.maps;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.maps.databinding.ActivityMainBinding;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    private ActivityMainBinding binding;
    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ViewCompat.setOnApplyWindowInsetsListener(binding.main, (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        setSupportActionBar(binding.toolbar);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(this);
        }

        binding.contentMain.btnLocate.setOnClickListener(v -> locateOnMap());
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap = googleMap;

        double defaultLat = 22.7196;
        double defaultLng = 75.8577;

        if (binding.contentMain.etLatitude.getText() != null && TextUtils.isEmpty(binding.contentMain.etLatitude.getText().toString())) {
            binding.contentMain.etLatitude.setText(String.valueOf(defaultLat));
        }
        if (binding.contentMain.etLongitude.getText() != null && TextUtils.isEmpty(binding.contentMain.etLongitude.getText().toString())) {
            binding.contentMain.etLongitude.setText(String.valueOf(defaultLng));
        }

        plotLocation(defaultLat, defaultLng, "NMIMS Indore");
    }

    private void locateOnMap() {
        if (binding.contentMain.etLatitude.getText() == null || binding.contentMain.etLongitude.getText() == null) {
            return;
        }

        String latStr = binding.contentMain.etLatitude.getText().toString().trim();
        String lngStr = binding.contentMain.etLongitude.getText().toString().trim();

        if (TextUtils.isEmpty(latStr) || TextUtils.isEmpty(lngStr)) {
            Toast.makeText(this, "Please enter both Latitude and Longitude", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            double lat = Double.parseDouble(latStr);
            double lng = Double.parseDouble(lngStr);

            if (lat < -90 || lat > 90 || lng < -180 || lng > 180) {
                Toast.makeText(this, "Latitude must be [-90, 90] and Longitude [-180, 180]", Toast.LENGTH_SHORT).show();
                return;
            }

            plotLocation(lat, lng, "Location (" + lat + ", " + lng + ")");

        } catch (NumberFormatException e) {
            Toast.makeText(this, "Invalid coordinate format", Toast.LENGTH_SHORT).show();
        }
    }

    private void plotLocation(double latitude, double longitude, String title) {
        if (mMap != null) {
            mMap.clear();
            LatLng location = new LatLng(latitude, longitude);
            mMap.addMarker(new MarkerOptions().position(location).title(title));
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(location, 15f));
        }
    }
}