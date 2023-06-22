package com.example.uasandroiddimazfebuari;

public class APIUtils {
    private APIUtils(){}
    public static final String BASE_URL="http://192.168.100.37:8080";
    public static APIService getAPIService(){
        return RetrofitClient.getClient(BASE_URL).create(APIService.class);
    }
}
