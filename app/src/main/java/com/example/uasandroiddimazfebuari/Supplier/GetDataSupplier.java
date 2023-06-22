package com.example.uasandroiddimazfebuari.Supplier;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetDataSupplier {
    @SerializedName("result")
    @Expose
    private String result;
    @SerializedName("data")
    @Expose
    private List<DataSupplier> data = null;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public List<DataSupplier> getData() {
        return data;
    }

    public void setData(List<DataSupplier> data) {
        this.data = data;
    }
}
