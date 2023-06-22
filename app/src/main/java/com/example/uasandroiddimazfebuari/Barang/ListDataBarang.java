package com.example.uasandroiddimazfebuari.Barang;

public class ListDataBarang {
    String id_barang, nama_barang, jenis_barang,lokasi_gudang;
    int harga_barang;

    public ListDataBarang(String id_barang, String nama_barang, String jenis_barang, int harga_barang, String lokasi_gudang) {
        this.id_barang = id_barang;
        this.nama_barang = nama_barang;
        this.jenis_barang = jenis_barang;
        this.harga_barang = harga_barang;
        this.lokasi_gudang = lokasi_gudang;
    }

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

    public String getLokasi_gudang() {
        return lokasi_gudang;
    }

    public void setLokasi_gudang(String lokasi_gudang) {
        this.lokasi_gudang = lokasi_gudang;
    }

    public int getHarga_barang() {
        return harga_barang;
    }

    public void setHarga_barang(int harga_barang) {
        this.harga_barang = harga_barang;
    }
}
