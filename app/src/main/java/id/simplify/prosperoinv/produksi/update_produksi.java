package id.simplify.prosperoinv.produksi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import id.simplify.prosperoinv.R;

public class update_produksi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_produksi);
    }

    public void backtoproduksi(View view) {
        Intent a = new Intent(this, produksi.class);
        startActivity(a);
    }
}
