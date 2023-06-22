package com.example.uasandroiddimazfebuari.Karyawan;

public class ListDataKaryawan {
    String id_karyawan,nama_karyawan,alamat_karyawan,jk_karyawan,notelp_karyawan,image_karyawan;

    public ListDataKaryawan(String id_karyawan, String nama_karyawan, String alamat_karyawan, String jk_karyawan, String notelp_karyawan, String image_karyawan) {
        this.id_karyawan = id_karyawan;
        this.nama_karyawan = nama_karyawan;
        this.alamat_karyawan = alamat_karyawan;
        this.jk_karyawan = jk_karyawan;
        this.notelp_karyawan = notelp_karyawan;
        this.image_karyawan = image_karyawan;
    }

    public String getId_karyawan() {
        return id_karyawan;
    }

    public void setId_karyawan(String id_karyawan) {
        this.id_karyawan = id_karyawan;
    }

    public String getNama_karyawan() {
        return nama_karyawan;
    }

    public void setNama_karyawan(String nama_karyawan) {
        this.nama_karyawan = nama_karyawan;
    }

    public String getAlamat_karyawan() {
        return alamat_karyawan;
    }

    public void setAlamat_karyawan(String alamat_karyawan) {
        this.alamat_karyawan = alamat_karyawan;
    }

    public String getJk_karyawan() {
        return jk_karyawan;
    }

    public void setJk_karyawan(String jk_karyawan) {
        this.jk_karyawan = jk_karyawan;
    }

    public String getNotelp_karyawan() {
        return notelp_karyawan;
    }

    public void setNotelp_karyawan(String notelp_karyawan) {
        this.notelp_karyawan = notelp_karyawan;
    }

    public String getImage_karyawan() {
        return image_karyawan;
    }

    public void setImage_karyawan(String image_karyawan) {
        this.image_karyawan = image_karyawan;
    }
}
