package com.example.uasandroiddimazfebuari.Barang;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.uasandroiddimazfebuari.APIService;
import com.example.uasandroiddimazfebuari.APIUtils;
import com.example.uasandroiddimazfebuari.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivityFormUpdDelBarang extends AppCompatActivity {
    EditText idbarang,namabarang,jenisbarang,hargabarang,lokasigudang;
    Button btnupdate,btndelete,btnkembali;
    String isiidbarang,isinamabarang,isijenisbarang,isilokasigudang;
    int isihargabarang;
    APIService apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_form_upd_del_barang);
        idbarang = (EditText)findViewById(R.id.txtidbarangupddel);
        namabarang = (EditText)findViewById(R.id.txtnamabarangupddel);
        jenisbarang = (EditText)findViewById(R.id.txtjenisbarangupddel);
        hargabarang = (EditText)findViewById(R.id.txthargabarangupddel);
        lokasigudang = (EditText)findViewById(R.id.txtlokasigudangupddel);
        btnupdate = (Button)findViewById(R.id.btnupdatebarang);
        btndelete = (Button)findViewById(R.id.btndeletebarang);
        btnkembali = (Button)findViewById(R.id.btnkembalibarangupddel);
        apiService = APIUtils.getAPIService();

        Intent intent = getIntent();
        if(getIntent().getStringExtra("id_barang")!=null){
            isiidbarang = intent.getStringExtra("id_barang");
            isinamabarang = intent.getStringExtra("nama_barang");
            isijenisbarang = intent.getStringExtra("jenis_barang");
            isihargabarang = intent.getIntExtra("harga_barang",0);
            isilokasigudang = intent.getStringExtra("lokasi_gudang");

            idbarang.setText(isiidbarang);
            namabarang.setText(isinamabarang);
            jenisbarang.setText(isijenisbarang);
            hargabarang.setText(Integer.toString(isihargabarang));
            lokasigudang.setText(isilokasigudang);
        }

        btnupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UpdateData(idbarang.getText().toString(),namabarang.getText().toString(),jenisbarang.getText().toString(),Integer.valueOf(hargabarang.getText().toString()),lokasigudang.getText().toString());
                Intent pindah = new Intent(getApplicationContext(), MainActivityBarang.class);
                startActivity(pindah);
                Toast.makeText(MainActivityFormUpdDelBarang.this, "Data Berhasil Diubah", Toast.LENGTH_SHORT).show();
            }
        });

        btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DeleteData(idbarang.getText().toString());
                Intent pindah = new Intent(getApplicationContext(), MainActivityBarang.class);
                startActivity(pindah);
                Toast.makeText(MainActivityFormUpdDelBarang.this, "Data Berhasil DiHapus", Toast.LENGTH_SHORT).show();
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

    public void UpdateData(String idbarang, String namabarang, String jenisbarang, int hargabarang, String lokasigudang){

        apiService.UpdateDataBarang(idbarang,namabarang,jenisbarang,hargabarang, lokasigudang).enqueue(new Callback<GetDataBarang>() {
            @Override
            public void onResponse(Call<GetDataBarang> call, Response<GetDataBarang> response) {
                Log.d("updated", "sukses");
            }

            @Override
            public void onFailure(Call<GetDataBarang> call, Throwable t) {
            }
        });
    }

    public void DeleteData(String idbarang){
        apiService.DeleteDataBarang(idbarang).enqueue(new Callback<GetDataBarang>() {
            @Override
            public void onResponse(Call<GetDataBarang> call, Response<GetDataBarang> response) {
                Log.d("delete", "sukses");
            }

            @Override
            public void onFailure(Call<GetDataBarang> call, Throwable t) {
            }
        });
    }
}