package com.example.buoi01;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ImageButton btnBack, btnEdit;
    private TextView tvName, tvLocation;
    private ImageView imgProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ÁNh xạ view
        btnBack = findViewById(R.id.btnBack);
        btnEdit = findViewById(R.id.btnEdit);
        tvName = findViewById(R.id.tvName);
        tvLocation = findViewById(R.id.tvLocation);
        imgProfile = findViewById(R.id.imgProfile);

        // Sự kiện btn Back
        btnBack.setOnClickListener(v -> {
            Toast.makeText(this, "Back pressed", Toast.LENGTH_SHORT).show();
            finish(); // đóng activity
        });

        // Sự kiệnn btn Edit
        btnEdit.setOnClickListener(v -> {
            Toast.makeText(this, "Edit profile", Toast.LENGTH_SHORT).show();
        });
    }
}