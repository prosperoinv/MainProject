package id.simplify.prosperoinv.pengadaan;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;

import id.simplify.prosperoinv.R;
import id.simplify.prosperoinv.model.Bahan;

public class tbhbarangbaru extends AppCompatActivity {
    EditText namabarang, vendorbarang, jumlahbarang;
    FirebaseAuth a;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tbhbarangbaru);
        namabarang = (EditText) findViewById(R.id.editText);
        vendorbarang = (EditText) findViewById(R.id.editText2);
        jumlahbarang = (EditText) findViewById(R.id.editText3);
    }

    public void tambah(View view) {

    }
}
