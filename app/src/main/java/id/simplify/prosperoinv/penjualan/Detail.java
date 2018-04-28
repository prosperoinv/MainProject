package id.simplify.prosperoinv.penjualan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import id.simplify.prosperoinv.R;

public class Detail extends AppCompatActivity {
    Intent manaada;
    String nama,jumlah,pengupdate,no,pemesan,alamat;
    TextView a,b,c,d,e,f;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        manaada=getIntent();
        nama = manaada.getStringExtra("nama");
        jumlah = manaada.getStringExtra("jumlah");
        pengupdate = manaada.getStringExtra("pengupdate");
        no = manaada.getStringExtra("no");
        pemesan = manaada.getStringExtra("pemesan");
        alamat = manaada.getStringExtra("alamat");
        a = (TextView) findViewById(R.id.editText);
        b = (TextView) findViewById(R.id.editText2);
        c = (TextView) findViewById(R.id.editText3);
        d = (TextView) findViewById(R.id.editText6);
        e = (TextView) findViewById(R.id.editText7);
        f = (TextView) findViewById(R.id.textView19);
        a.setText(no);
        b.setText(nama);
        c.setText(jumlah);
        d.setText(pemesan);
        e.setText(alamat);
        f.setText(pengupdate);
    }
}
