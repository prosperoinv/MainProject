package id.simplify.prosperoinv.pengadaan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import id.simplify.prosperoinv.R;

public class DetailBarang extends AppCompatActivity {
    Intent masuk;
    String nama,vendor,jumlah;
    TextView a,b,c,judul,vedor,remover;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laporan_pengadaan);
        a = (TextView) findViewById(R.id.editText);
        b = (TextView) findViewById(R.id.editText2);
        c = (TextView) findViewById(R.id.editText3);
        judul = (TextView) findViewById(R.id.textView10);
        vedor = (TextView) findViewById(R.id.textView2);
        remover = (TextView) findViewById(R.id.textView13);
        masuk = getIntent();
        nama = masuk.getStringExtra("nama");
        vendor = masuk.getStringExtra("vendor");
        jumlah = masuk.getStringExtra("jumlah");
        if (vendor!=null){
            a.setText(nama);
            b.setText(vendor);
            c.setText(jumlah);}
        else if (vendor==null) {
            judul.setText("Detail Pesanan");
            a.setText(nama);
            b.setText(jumlah);
            remover.setText("");
            c.setText("");

        }
    }
}
