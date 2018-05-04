package id.simplify.prosperoinv.distribusi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import id.simplify.prosperoinv.R;

public class DetailDistribusi extends AppCompatActivity {
    Intent manaada;
    String nama,jumlah,pengupdate,no,pemesan,alamat;
    TextView a,b,c,d,e,f;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_distribusi);
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
        Toast.makeText(this,manaada.getStringExtra("klas"),Toast.LENGTH_SHORT).show();

    }

    public void kirim(View view) {
        databaseReference = FirebaseDatabase.getInstance().getReference("penjualan");
        databaseReference.child(no).removeValue();
        Intent bukti = new Intent(this,BuktiTransaksi.class);
        bukti.putExtra("nama",nama);
        bukti.putExtra("jumlah",jumlah);
        bukti.putExtra("no",no);
        bukti.putExtra("pemesan",pemesan);
        bukti.putExtra("alamat",alamat);
        bukti.putExtra("pengupdate",pengupdate);
        startActivity(bukti);
        DetailDistribusi.this.finish();
    }
}
