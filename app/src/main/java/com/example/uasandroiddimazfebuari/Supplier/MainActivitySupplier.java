package com.example.uasandroiddimazfebuari.Supplier;

import android.content.Intent;
import android.os.Bundle;

import com.example.uasandroiddimazfebuari.APIService;
import com.example.uasandroiddimazfebuari.APIUtils;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.View;

import com.example.uasandroiddimazfebuari.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivitySupplier extends AppCompatActivity {
    APIService apiService;
    RecyclerView recyclerViewSupplier;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_supplier);
        recyclerViewSupplier = (RecyclerView)findViewById(R.id.isisupplier);
        apiService = APIUtils.getAPIService();
        BacaData();

        FloatingActionButton btntambah = findViewById(R.id.btntambahsupplier);
        btntambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivityFormSimpanSupplier.class);
                startActivity(intent);
            }
        });
    }

    public void BacaData(){
        apiService.AmbilDataSupplier().enqueue(new Callback<GetDataSupplier>() {
            @Override
            public void onResponse(Call<GetDataSupplier> call, Response<GetDataSupplier> response) {
                ArrayList<ListDataSupplier> listDataSuppliers = new ArrayList<>();
                for(int i = 0; i < response.body().getData().size(); i++){
                    listDataSuppliers.add(new ListDataSupplier(response.body().getData().get(i).getId_supplier(),
                            response.body().getData().get(i).getNama_supplier(),
                            response.body().getData().get(i).getAlamat_supplier(),
                            response.body().getData().get(i).getJk_supplier(),
                            response.body().getData().get(i).getNotelp_supplier(),
                            response.body().getData().get(i).getImage_supplier()));
                }
                AdapterSupplier adapter = new AdapterSupplier(listDataSuppliers,getApplicationContext());
                RecyclerView.LayoutManager layoutManager;
                layoutManager = new LinearLayoutManager(getApplicationContext());
                recyclerViewSupplier.setLayoutManager(layoutManager);
                recyclerViewSupplier.setAdapter(adapter);
                Log.d("Isi Data", response.body().toString());
            }

            @Override
            public void onFailure(Call<GetDataSupplier> call, Throwable t) {

            }
        });
    }
}