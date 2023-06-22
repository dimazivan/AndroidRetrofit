package com.example.uasandroiddimazfebuari.Supplier;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.uasandroiddimazfebuari.APIService;
import com.example.uasandroiddimazfebuari.APIUtils;
import com.example.uasandroiddimazfebuari.R;

import net.gotev.uploadservice.MultipartUploadRequest;
import net.gotev.uploadservice.UploadNotificationConfig;

import java.io.IOException;

public class MainActivityFormSimpanSupplier extends AppCompatActivity {
    private static final String UPLOAD_URL = "http://192.168.100.37:8080/Andro_UAS/InsertSupplier.php";
    EditText idsupplier,namasupplier,alamatsupplier,jksupplier,notelpsupplier;
    TextView txtPath;
    ImageView imageViewSupplier;
    Button btnsimpan, btnkembali, pilihfotosupplier;
    APIService apiService;
    Uri x;
    Bitmap y;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_form_simpan_supplier);
        idsupplier = (EditText)findViewById(R.id.txtidsuppliersimpan);
        namasupplier = (EditText)findViewById(R.id.txtnamasuppliersimpan);
        alamatsupplier = (EditText)findViewById(R.id.txtalamatsuppliersimpan);
        jksupplier = (EditText)findViewById(R.id.txtjksuppliersimpan);
        notelpsupplier = (EditText)findViewById(R.id.txtnotelpsuppliersimpan);
        txtPath = (TextView)findViewById(R.id.textViewPathSuppliersimpan);
        imageViewSupplier = (ImageView)findViewById(R.id.imageViewSuppliersimpan);
        btnsimpan = (Button)findViewById(R.id.btnsimpansupplier);
        btnkembali = (Button)findViewById(R.id.btnkembalisuppliersimpan);
        pilihfotosupplier = (Button)findViewById(R.id.btnpilihgambarsuppliersimpan);
        apiService = APIUtils.getAPIService();

        btnsimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                uploadMultipart();
                Intent pindah =new Intent(getApplicationContext(), MainActivitySupplier.class);
                startActivity(pindah);
            }
        });

        pilihfotosupplier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent g = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(g,2);
            }
        });

        btnkembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivitySupplier.class);
                startActivity(intent);
            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK){
            x = data.getData();
            try {
                y = MediaStore.Images.Media.getBitmap(getContentResolver(),x);
                txtPath.setText(x.toString());
                imageViewSupplier.setImageBitmap(y);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public String getPath(Uri uri){
        Cursor cursor = getContentResolver().query(uri, null, null, null, null);
        cursor.moveToFirst();
        String id_supplier = cursor.getString(0);
        id_supplier = id_supplier.substring(id_supplier.lastIndexOf(":") + 1);
        cursor.close();

        cursor = getContentResolver().query(
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI,null,
                MediaStore.Images.Media._ID+" = ? ",new String[]{id_supplier}, null
        );
        cursor.moveToFirst();
        String path = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA));
        cursor.close();

        return path;
    }

    public void uploadMultipart(){
        String id_supplier = idsupplier.getText().toString().trim();
        String nama_supplier = namasupplier.getText().toString().trim();
        String alamat_supplier = alamatsupplier.getText().toString().trim();
        String jk_supplier = jksupplier.getText().toString().trim();
        String notelp_supplier = notelpsupplier.getText().toString().trim();

        String path = getPath(x);
        try{
            new MultipartUploadRequest(this, id_supplier, UPLOAD_URL)
                    .addFileToUpload(path, "image_supplier")
                    .addParameter("id_supplier", id_supplier)
                    .addParameter("nama_supplier", nama_supplier)
                    .addParameter("alamat_supplier", alamat_supplier)
                    .addParameter("jk_supplier", jk_supplier)
                    .addParameter("notelp_supplier", notelp_supplier)
                    .setNotificationConfig(new UploadNotificationConfig())
                    .setMaxRetries(3)
                    .startUpload();
        }
        catch(Exception e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}