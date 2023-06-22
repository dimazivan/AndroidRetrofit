package com.example.uasandroiddimazfebuari;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.uasandroiddimazfebuari.Barang.MainActivityBarang;
import com.example.uasandroiddimazfebuari.Supplier.MainActivitySupplier;

public class MainActivity extends AppCompatActivity {
    Button btnbarang,btnsupplier,btnkaryawan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnbarang = (Button)findViewById(R.id.btnbarang);
        btnsupplier = (Button)findViewById(R.id.btnsupplier);
        btnkaryawan = (Button)findViewById(R.id.btnkaryawan);

        btnbarang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivityBarang.class);
                startActivity(intent);
            }
        });

        btnkaryawan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btnsupplier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivitySupplier.class);
                startActivity(intent);
            }
        });
    }
}