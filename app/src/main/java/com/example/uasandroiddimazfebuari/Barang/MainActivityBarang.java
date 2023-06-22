package com.example.uasandroiddimazfebuari.Barang;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;

import com.example.uasandroiddimazfebuari.APIService;
import com.example.uasandroiddimazfebuari.APIUtils;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.View;

import com.example.uasandroiddimazfebuari.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivityBarang extends AppCompatActivity {
    APIService apiService;
    RecyclerView recyclerViewBarang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_barang);
        apiService = APIUtils.getAPIService();
        recyclerViewBarang = (RecyclerView)findViewById(R.id.isibarang);

        BacaData();
        FloatingActionButton fab = findViewById(R.id.btntambahbarang);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent barang = new Intent(getApplicationContext(), MainActivityFormSimpanBarang.class);
                startActivity(barang);
            }
        });
    }

    public void BacaData(){
        apiService.AmbilDataBarang().enqueue(new Callback<GetDataBarang>() {
            @Override
            public void onResponse(Call<GetDataBarang> call, Response<GetDataBarang> response) {
//                String x = "";
                ArrayList<ListDataBarang> listDataProfils = new ArrayList<>();
                for(int i = 0; i < response.body().getData().size(); i++){
                    listDataProfils.add(new ListDataBarang(response.body().getData().get(i).getId_barang(),
                            response.body().getData().get(i).getNama_barang(),
                            response.body().getData().get(i).getJenis_barang(),
                            response.body().getData().get(i).getHarga_barang(),
                            response.body().getData().get(i).getLokasi_gudang()));
                }
                AdapterBarang adapter = new AdapterBarang(listDataProfils,getApplicationContext());
                RecyclerView.LayoutManager layoutManager;
                layoutManager = new LinearLayoutManager(getApplicationContext());
                recyclerViewBarang.setLayoutManager(layoutManager);
                recyclerViewBarang.setAdapter(adapter);
                Log.d("Isi Data", response.body().toString());
            }

            @Override
            public void onFailure(Call<GetDataBarang> call, Throwable t) {
            }
        });
    }
}