package com.example.uasandroiddimazfebuari.Barang;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.uasandroiddimazfebuari.APIService;
import com.example.uasandroiddimazfebuari.APIUtils;
import com.example.uasandroiddimazfebuari.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivityFormSimpanBarang extends AppCompatActivity {
    EditText idbarang,namabarang,jenisbarang,hargabarang,lokasigudang;
    Button btnsimpan,btncancel,btnkembali;
    APIService apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_form_simpan_barang);
        idbarang = (EditText)findViewById(R.id.txtidbarangsimpan);
        namabarang = (EditText)findViewById(R.id.txtnamabarangsimpan);
        jenisbarang = (EditText)findViewById(R.id.txtjenisbarangsimpan);
        hargabarang = (EditText)findViewById(R.id.txthargabarangsimpan);
        lokasigudang = (EditText)findViewById(R.id.txtlokasigudangsimpan);
        btnsimpan = (Button)findViewById(R.id.btnsimpanbarang);
        btncancel = (Button)findViewById(R.id.btncancelbarang);
        btnkembali = (Button)findViewById(R.id.btnkembalibarang);
        apiService = APIUtils.getAPIService();

        btnsimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SimpanDataBarang(idbarang.getText().toString(),namabarang.getText().toString(),jenisbarang.getText().toString(),Integer.valueOf(hargabarang.getText().toString()),lokasigudang.getText().toString());
                Intent pindah = new Intent(getApplicationContext(), MainActivityBarang.class);
                startActivity(pindah);
                Toast.makeText(MainActivityFormSimpanBarang.this, "Data Berhasil Disimpan", Toast.LENGTH_SHORT).show();
            }
        });

        btncancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                idbarang.setText("");
                namabarang.setText("");
                jenisbarang.setText("");
                hargabarang.setText("");
                lokasigudang.setText("");
            }
        });

        btnkembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent kembali = new Intent(getApplicationContext(), MainActivityBarang.class);
                startActivity(kembali);
            }
        });
    }
    public void SimpanDataBarang(String idbarang, String namabarang, String jenisbarang, int hargabarang, String lokasigudang){

        apiService.SimpanDataBarang(idbarang,namabarang,jenisbarang,hargabarang,lokasigudang).enqueue(new Callback<GetDataBarang>() {
            @Override
            public void onResponse(Call<GetDataBarang> call, Response<GetDataBarang> response) {
                Log.d("save", "sukses");
            }

            @Override
            public void onFailure(Call<GetDataBarang> call, Throwable t) {
            }
        });
    }
}