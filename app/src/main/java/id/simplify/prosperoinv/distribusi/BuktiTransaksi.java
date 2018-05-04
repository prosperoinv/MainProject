package id.simplify.prosperoinv.distribusi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import id.simplify.prosperoinv.R;
import id.simplify.prosperoinv.model.User;

public class BuktiTransaksi extends AppCompatActivity {
    Intent manaada;
    String nama,jumlah,no,pemesan,alamat,uiduser,namauser,pengupdate;
    TextView noo,nm,jmll,pmsn,almt,userna;
    DatabaseReference databaseReference;
    FirebaseUser user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bukti_transaksi);
        manaada=getIntent();
        nama = manaada.getStringExtra("nama");
        jumlah = manaada.getStringExtra("jumlah");
        no = manaada.getStringExtra("no");
        pemesan = manaada.getStringExtra("pemesan");
        alamat = manaada.getStringExtra("alamat");
        pengupdate = manaada.getStringExtra("pengupdate");
        noo = (TextView) findViewById(R.id.nopem);
        nm = (TextView) findViewById(R.id.namabarang);
        jmll = (TextView) findViewById(R.id.jml);
        pmsn = (TextView) findViewById(R.id.pemesan);
        almt = (TextView) findViewById(R.id.alamat);

        noo.setText(no);
        nm.setText(nama);
        jmll.setText(jumlah);
        pmsn.setText(pemesan);
        almt.setText(alamat);

        databaseReference = FirebaseDatabase.getInstance().getReference("");
        user = FirebaseAuth.getInstance().getCurrentUser();
        uiduser = user.getUid();
        Query query = databaseReference.child("user").child(uiduser);
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()){
                    User user = dataSnapshot.getValue(User.class);
                    namauser = user.getUsername().toString();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });

        userna = (TextView) findViewById(R.id.pengupdatean);
        userna.setText(pengupdate);

    }
}
