package com.example.uasandroiddimazfebuari.Supplier;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
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

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivityFormUpdDelSupplier extends AppCompatActivity {
    private static final String UPLOAD_URL = "http://192.168.100.37:8080/Andro_UAS/UpdateSupplier.php";
    EditText idsupplier,namasupplier,alamatsupplier,jksupplier,notelpsupplier;
    String isiidsupplier,isinamasupplier,isialamatsupplier,isijksupplier,isinotelpsupplier,isigambarsupplier;
    TextView txtPath;
    ImageView imageViewSupplier;
    Button btnupdate, btndelete, btnkembali, pilihfotosupplier;
    APIService apiService;
    Uri x;
    Bitmap y;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_form_upd_del_supplier);
        idsupplier = (EditText)findViewById(R.id.txtidsupplierupddel);
        namasupplier = (EditText)findViewById(R.id.txtnamasupplierupddel);
        alamatsupplier = (EditText)findViewById(R.id.txtalamatsupplierupddel);
        jksupplier = (EditText)findViewById(R.id.txtjksupplierupddel);
        notelpsupplier = (EditText)findViewById(R.id.txtnotelpsupplierupddel);
        txtPath = (TextView)findViewById(R.id.textViewPathSupplierupddel);
        imageViewSupplier = (ImageView)findViewById(R.id.imageViewSupplierupddel);
        btnupdate = (Button)findViewById(R.id.btnupdatesupplier);
        btndelete = (Button)findViewById(R.id.btndeletesupplier);
        btnkembali = (Button)findViewById(R.id.btnkembalisupplierupddel);
        pilihfotosupplier = (Button) findViewById(R.id.btnpilihgambarsupplierupddel);
        apiService = APIUtils.getAPIService();

        Intent intent = getIntent();
        if(getIntent().getStringExtra("id_supplier")!=null){
            isiidsupplier = intent.getStringExtra("id_supplier");
            isinamasupplier = intent.getStringExtra("nama_supplier");
            isialamatsupplier = intent.getStringExtra("alamat_supplier");
            isijksupplier = intent.getStringExtra("jk_supplier");
            isinotelpsupplier = intent.getStringExtra("notelp_supplier");
//            isigambarsupplier = intent.getStringExtra("image_supplier");

            idsupplier.setText(isiidsupplier);
            namasupplier.setText(isinamasupplier);
            alamatsupplier.setText(isialamatsupplier);
            jksupplier.setText(isijksupplier);
            notelpsupplier.setText(isinotelpsupplier);
//            txtPath.setText(isigambarsupplier);

        }

        pilihfotosupplier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent g = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(g,2);
            }
        });

        btnupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                uploadMultipart();
                Intent intent = new Intent(getApplicationContext(), MainActivitySupplier.class);
                startActivity(intent);
            }
        });

        btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HapusDataSupplier(idsupplier.getText().toString());
                Intent delete = new Intent(getApplicationContext(), MainActivitySupplier.class);
                startActivity(delete);
            }
        });

        btnkembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

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

    private void uploadMultipart() {
        String id_supplier = idsupplier.getText().toString().trim();
        String nama_supplier = namasupplier.getText().toString().trim();
        String alamat_supplier = alamatsupplier.getText().toString().trim();
        String jk_supplier = jksupplier.getText().toString().trim();
        String notelp_supplier = notelpsupplier.getText().toString().trim();

        String path = getPath(x);
        try{
            new MultipartUploadRequest(this, UPLOAD_URL)
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

    private void HapusDataSupplier(String id_supplier){
        apiService.DeleteDataSupplier(id_supplier).enqueue(new Callback<GetDataSupplier>() {
            @Override
            public void onResponse(Call<GetDataSupplier> call, Response<GetDataSupplier> response) {
                Log.d("Delete", "Sukses");
            }

            @Override
            public void onFailure(Call<GetDataSupplier> call, Throwable t) {

            }
        });
    }
}