package com.example.uasandroiddimazfebuari.Barang;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataBarang {
    @SerializedName("id_barang")
    @Expose
    private String id_barang;
    @SerializedName("nama_barang")
    @Expose
    private String nama_barang;
    @SerializedName("jenis_barang")
    @Expose
    private String jenis_barang;
    @SerializedName("harga_barang")
    @Expose
    private int harga_barang;
    @SerializedName("lokasi_gudang")
    @Expose
    private String lokasi_gudang;

    public String getId_barang() {
        return id_barang;
    }

    public void setId_barang(String id_barang) {
        this.id_barang = id_barang;
    }

    public String getNama_barang() {
        return nama_barang;
    }

    public void setNama_barang(String nama_barang) {
        this.nama_barang = nama_barang;
    }

    public String getJenis_barang() {
        return jenis_barang;
    }

    public void setJenis_barang(String jenis_barang) {
        this.jenis_barang = jenis_barang;
    }

    public int getHarga_barang() {
        return harga_barang;
    }

    public void setHarga_barang(int harga_barang) {
        this.harga_barang = harga_barang;
    }

    public String getLokasi_gudang() {
        return lokasi_gudang;
    }

    public void setLokasi_gudang(String lokasi_gudang) {
        this.lokasi_gudang = lokasi_gudang;
    }
}
