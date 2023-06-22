package com.example.uasandroiddimazfebuari;

import com.example.uasandroiddimazfebuari.Barang.GetDataBarang;
import com.example.uasandroiddimazfebuari.Supplier.GetDataSupplier;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface APIService {
    @Headers("Context-Type:application/json")
    @GET("/Andro_UAS/ReadSupplier.php")
    Call<GetDataSupplier> AmbilDataSupplier (
    );

    @Headers("Context-Type:application/json")
    @GET("/Andro_UAS/ReadBarang.php")
    Call<GetDataBarang> AmbilDataBarang();

    @Headers("Context-Type:application/json")
    @POST("/Andro_UAS/InsertBarang.php")
    Call<GetDataBarang> SimpanDataBarang(
            @Query("id_barang") String id_barang,
            @Query("nama_barang") String nama_barang,
            @Query("jenis_barang") String jenis_barang,
            @Query("harga_barang") int harga_barang,
            @Query("lokasi_gudang") String lokasi_gudang
    );

    @Headers("Context-Type:application/json")
    @POST("/Andro_UAS/UpdateBarang.php")
    Call<GetDataBarang> UpdateDataBarang(
            @Query("id_barang") String id_barang,
            @Query("nama_barang") String nama_barang,
            @Query("jenis_barang") String jenis_barang,
            @Query("harga_barang") int harga_barang,
            @Query("lokasi_gudang") String lokasi_gudang
    );

    @Headers("Context-Type:application/json")
    @POST("Andro_UAS/DeleteBarang.php")
    Call<GetDataBarang> DeleteDataBarang(
            @Query("id_barang") String id_barang
    );

    @Headers("Context-Type:application/json")
    @POST("Andro_UAS/DeleteSupplier.php")
    Call<GetDataSupplier> DeleteDataSupplier(
            @Query("id_supplier") String id_supplier
    );
}
