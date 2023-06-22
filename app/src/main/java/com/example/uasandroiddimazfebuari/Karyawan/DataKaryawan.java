package com.example.uasandroiddimazfebuari.Karyawan;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataKaryawan {
    @SerializedName("id_karyawan")
    @Expose
    private String id_karyawan;
    @SerializedName("nama_karyawan")
    @Expose
    private String nama_karyawan;
    @SerializedName("alamat_karyawan")
    @Expose
    private String alamat_karyawan;
    @SerializedName("jk_karyawan")
    @Expose
    private String jk_karyawan;
    @SerializedName("notelp_karyawan")
    @Expose
    private String notelp_karyawan;
    @SerializedName("image_karyawan")
    @Expose
    private String image_karyawan;

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
