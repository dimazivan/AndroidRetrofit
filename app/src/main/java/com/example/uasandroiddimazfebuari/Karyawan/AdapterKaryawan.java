package com.example.uasandroiddimazfebuari.Karyawan;

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
import com.example.uasandroiddimazfebuari.Supplier.ListDataSupplier;
import com.example.uasandroiddimazfebuari.Supplier.MainActivityFormUpdDelSupplier;

import java.util.ArrayList;

public class AdapterKaryawan extends RecyclerView.Adapter<AdapterKaryawan.ViewHolder> {
    private ArrayList<ListDataKaryawan> listDataKaryawan;
    private Context c;

    public AdapterKaryawan(ArrayList<ListDataKaryawan> listDataKaryawan, Context c) {
        this.listDataKaryawan = listDataKaryawan;
        this.c = c;
    }

    @NonNull
    @Override
    public AdapterKaryawan.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.layoutisikaryawan,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterKaryawan.ViewHolder holder, int position) {
        final ListDataKaryawan listDataKaryawanku = listDataKaryawan.get(position);
        holder.id_karyawan1.setText(listDataKaryawan.get(position).getId_karyawan());
        holder.nama_karyawan1.setText(listDataKaryawan.get(position).getNama_karyawan());
        holder.alamat_karyawan1.setText(listDataKaryawan.get(position).getAlamat_karyawan());
        holder.jk_karyawan1.setText(listDataKaryawan.get(position).getJk_karyawan());
        holder.notelp_karyawan1.setText(listDataKaryawan.get(position).getNotelp_karyawan());
        Glide.with(c).load(listDataKaryawan.get(position).getImage_karyawan()).diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.gambarkaryawan1);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pindah = new Intent(c, MainActivityFormUpdDelSupplier.class);
                pindah.putExtra("id_karyawan", listDataKaryawanku.getId_karyawan());
                pindah.putExtra("nama_karyawan", listDataKaryawanku.getNama_karyawan());
                pindah.putExtra("alamat_karyawan", listDataKaryawanku.getAlamat_karyawan());
                pindah.putExtra("jk_karyawan", listDataKaryawanku.getJk_karyawan());
                pindah.putExtra("notelp_karyawan", listDataKaryawanku.getNotelp_karyawan());
//                pindah.putExtra("image_supplier", listDataKaryawanku.getImage_karyawan());
                c.startActivity(pindah);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listDataKaryawan.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView id_karyawan1,nama_karyawan1,alamat_karyawan1,jk_karyawan1,notelp_karyawan1;
        private ImageView gambarkaryawan1;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            id_karyawan1 = (TextView)itemView.findViewById(R.id.textViewidkaryawan);
            nama_karyawan1 = (TextView)itemView.findViewById(R.id.textViewnamakaryawan);
            alamat_karyawan1 = (TextView)itemView.findViewById(R.id.textViewalamatkaryawan);
            jk_karyawan1 = (TextView)itemView.findViewById(R.id.textViewjkkaryawan);
            notelp_karyawan1= (TextView)itemView.findViewById(R.id.textViewnotelpkaryawan);
            gambarkaryawan1= (ImageView)itemView.findViewById(R.id.imageViewkaryawan);
        }
    }
}
