package com.example.uasandroiddimazfebuari.Supplier;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataSupplier {
    @SerializedName("id_supplier")
    @Expose
    private String id_supplier;
    @SerializedName("nama_supplier")
    @Expose
    private String nama_supplier;
    @SerializedName("alamat_supplier")
    @Expose
    private String alamat_supplier;
    @SerializedName("jk_supplier")
    @Expose
    private String jk_supplier;
    @SerializedName("notelp_supplier")
    @Expose
    private String notelp_supplier;
    @SerializedName("image_supplier")
    @Expose
    private String image_supplier;

    public String getId_supplier() {
        return id_supplier;
    }

    public void setId_supplier(String id_supplier) {
        this.id_supplier = id_supplier;
    }

    public String getNama_supplier() {
        return nama_supplier;
    }

    public void setNama_supplier(String nama_supplier) {
        this.nama_supplier = nama_supplier;
    }

    public String getAlamat_supplier() {
        return alamat_supplier;
    }

    public void setAlamat_supplier(String alamat_supplier) {
        this.alamat_supplier = alamat_supplier;
    }

    public String getJk_supplier() {
        return jk_supplier;
    }

    public void setJk_supplier(String jk_supplier) {
        this.jk_supplier = jk_supplier;
    }

    public String getNotelp_supplier() {
        return notelp_supplier;
    }

    public void setNotelp_supplier(String notelp_supplier) {
        this.notelp_supplier = notelp_supplier;
    }

    public String getImage_supplier() {
        return image_supplier;
    }

    public void setImage_supplier(String image_supplier) {
        this.image_supplier = image_supplier;
    }
}
