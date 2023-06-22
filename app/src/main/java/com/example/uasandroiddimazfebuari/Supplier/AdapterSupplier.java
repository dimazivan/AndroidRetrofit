package com.example.uasandroiddimazfebuari.Supplier;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.uasandroiddimazfebuari.R;

import java.util.ArrayList;

public class AdapterSupplier extends RecyclerView.Adapter<AdapterSupplier.ViewHolder> {
    private ArrayList<ListDataSupplier> listDataSupplier;
    private Context c;

    public AdapterSupplier(ArrayList<ListDataSupplier> listDataSupplier, Context c) {
        this.listDataSupplier = listDataSupplier;
        this.c = c;
    }

    @NonNull
    @Override
    public AdapterSupplier.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.layoutisisupplier,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterSupplier.ViewHolder holder, int position) {
        final ListDataSupplier listDataSupplierku = listDataSupplier.get(position);
        holder.id_supplier1.setText(listDataSupplier.get(position).getId_supplier());
        holder.nama_supplier1.setText(listDataSupplier.get(position).getNama_supplier());
        holder.alamat_supplier1.setText(listDataSupplier.get(position).getAlamat_supplier());
        holder.jk_supplier1.setText(listDataSupplier.get(position).getJk_supplier());
        holder.notelp_supplier1.setText(listDataSupplier.get(position).getNotelp_supplier());
        Glide.with(c).load(listDataSupplier.get(position).getImage_supplier()).diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.gambarsupplier1);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pindah = new Intent(c, MainActivityFormUpdDelSupplier.class);
                pindah.putExtra("id_supplier", listDataSupplierku.getId_supplier());
                pindah.putExtra("nama_supplier", listDataSupplierku.getNama_supplier());
                pindah.putExtra("alamat_supplier", listDataSupplierku.getAlamat_supplier());
                pindah.putExtra("jk_supplier", listDataSupplierku.getJk_supplier());
                pindah.putExtra("notelp_supplier", listDataSupplierku.getNotelp_supplier());
//                pindah.putExtra("image_supplier", listDataSupplierku.getImage_supplier());
                c.startActivity(pindah);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listDataSupplier.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView id_supplier1,nama_supplier1,alamat_supplier1,jk_supplier1,notelp_supplier1;
        private ImageView gambarsupplier1;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            id_supplier1 = (TextView)itemView.findViewById(R.id.textViewidsupplier);
            nama_supplier1 = (TextView)itemView.findViewById(R.id.textViewnamasupplier);
            alamat_supplier1 = (TextView)itemView.findViewById(R.id.textViewalamatsupplier);
            jk_supplier1 = (TextView)itemView.findViewById(R.id.textViewjksupplier);
            notelp_supplier1 = (TextView)itemView.findViewById(R.id.textViewnotelpsupplier);
            gambarsupplier1 = (ImageView)itemView.findViewById(R.id.imageViewsupplier);
        }
    }
}
