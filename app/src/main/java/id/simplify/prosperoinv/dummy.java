package id.simplify.prosperoinv;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;

import id.simplify.prosperoinv.pengadaan.LaporanPengadaan;
import id.simplify.prosperoinv.pengadaan.tbhbarangbaru;

public class dummy extends AppCompatActivity {
    //Halo, linda su masuk
    //Tes tis
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dummy);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);
    }

    public void gopengadaan(View view) {
        Intent a = new Intent(dummy.this, id.simplify.prosperoinv.pengadaan.Pengadaan3Activity.class);
        startActivity(a);
    }

    public void goproduksi(View view) {
        Intent b = new Intent(dummy.this, id.simplify.prosperoinv.produksi.produksi.class);
        startActivity(b);
    }

    public void godistribusi(View view) {
    //    Intent c = new Intent(dummy.this,);
    }

    public void golayanan(View view) {
    }

    public void gopenjualan(View view) {
            Intent e = new Intent(dummy.this,id.simplify.prosperoinv.penjualan.Penjualan1.class);
            startActivity(e);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu_main) {
        getMenuInflater().inflate(R.menu.menu_dummy, menu_main);
        return true;
    }

    @SuppressLint("NewApi")
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.logout) {
            //Logout dan mencegah dapat mengklik back
            FirebaseAuth.getInstance().signOut();
            Intent a = new Intent(this, Login.class);
            startActivity(a);
            finishAffinity();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
