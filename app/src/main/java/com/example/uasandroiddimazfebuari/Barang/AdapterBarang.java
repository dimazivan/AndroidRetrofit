package com.example.uasandroiddimazfebuari.Barang;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.uasandroiddimazfebuari.R;

import java.util.ArrayList;

public class AdapterBarang extends RecyclerView.Adapter<AdapterBarang.ViewHolder>{
    private ArrayList<ListDataBarang> listDataBarang;
    private Context c;

    public AdapterBarang(ArrayList<ListDataBarang> dataProfilArrayList, Context c) {
        this.listDataBarang = dataProfilArrayList;
        this.c = c;
    }

    @NonNull
    @Override
    public AdapterBarang.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.layoutisibarang,parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterBarang.ViewHolder holder, int position) {
        final ListDataBarang listDataBarangku = listDataBarang.get(position);
        holder.id_barang1.setText(listDataBarang.get(position).getId_barang());
        holder.nama_barang1.setText(listDataBarang.get(position).getNama_barang());
        holder.jenis_barang1.setText(listDataBarang.get(position).getJenis_barang());
        holder.harga_barang1.setText(Integer.toString(listDataBarang.get(position).getHarga_barang()));
        holder.lokasi_gudang1.setText(listDataBarang.get(position).getLokasi_gudang());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pindah = new Intent(c, MainActivityFormUpdDelBarang.class);
                pindah.putExtra("id_barang", listDataBarangku.getId_barang());
                pindah.putExtra("nama_barang", listDataBarangku.getNama_barang());
                pindah.putExtra("jenis_barang", listDataBarangku.getJenis_barang());
                pindah.putExtra("harga_barang", listDataBarangku.getHarga_barang());
                pindah.putExtra("lokasi_gudang", listDataBarangku.getLokasi_gudang());
                c.startActivity(pindah);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listDataBarang.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView id_barang1,nama_barang1,jenis_barang1,harga_barang1,lokasi_gudang1;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            id_barang1 = (TextView)itemView.findViewById(R.id.textViewidbarang);
            nama_barang1 = (TextView)itemView.findViewById(R.id.textViewnamabarang);
            jenis_barang1 = (TextView)itemView.findViewById(R.id.textViewjenisbarang);
            harga_barang1 = (TextView)itemView.findViewById(R.id.textViewhargabarang);
            lokasi_gudang1= (TextView)itemView.findViewById(R.id.textViewlokasigudang);
        }
    }
}
