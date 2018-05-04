package id.simplify.prosperoinv.pengadaan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import id.simplify.prosperoinv.R;
import id.simplify.prosperoinv.model.Bahan;
import id.simplify.prosperoinv.model.User;

public class DetailBarang extends AppCompatActivity {
    Intent masuk;
    String nama,vendor,jumlah,aa,bb;
    String nilai1,uiduser,namauser;
    String jumlahin;
    Button button;
    FirebaseUser useer;
    DatabaseReference databaseReference,databaseReference1;
    TextView a,b,c,judul,vedor,remover;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laporan_pengadaan);
        a = (TextView) findViewById(R.id.editText);
        b = (TextView) findViewById(R.id.editText2);
        c = (TextView) findViewById(R.id.editText3);
        judul = (TextView) findViewById(R.id.textView);
        vedor = (TextView) findViewById(R.id.textView2);
        remover = (TextView) findViewById(R.id.textView13);
        button = (Button) findViewById(R.id.button);
        masuk = getIntent();
        databaseReference1 = FirebaseDatabase.getInstance().getReference("");
        nama = masuk.getStringExtra("nama");
        vendor = masuk.getStringExtra("vendor");
        jumlah = masuk.getStringExtra("jumlah");
        if (vendor!=null){
            a.setText(nama);
            b.setText(vendor);
            c.setText(jumlah);
            button.setVisibility(View.GONE);
        }
        else if (vendor==null) {
            judul.setText("Detail Pesanan");
            a.setText(nama);
            b.setText(jumlah);
            remover.setText("");
            c.setText("");
            databaseReference = FirebaseDatabase.getInstance().getReference("baseline-mentah");

            databaseReference.child(nama).addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    if (dataSnapshot.exists()){
                        Bahan bahan = dataSnapshot.getValue(Bahan.class);
                        nilai1 = bahan.getJumlahbarang();
                    }
                }
                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
            FindOutUser();
        }
    }

    private void FindOutUser() {
        useer = FirebaseAuth.getInstance().getCurrentUser();
        uiduser = useer.getUid();
        Query query = databaseReference1.child("user").child(uiduser);
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
    }

    public void konfirmkan(View view) {
        caridata();
        databaseReference.child(aa).child("jumlahbarang").setValue(String.valueOf(jumlahin));
        databaseReference.child(aa).child("pengupdate").setValue(namauser);
        Toast.makeText(this,jumlahin,Toast.LENGTH_SHORT).show();
        databaseReference1.child("pesanan").child(nama).removeValue();
        DetailBarang.this.finish();
    }

    private void caridata() {
        aa=a.getText().toString();
        bb=b.getText().toString();
        getJumlahin(nilai1,jumlah);

    }

    public String getJumlahin(String a, String b) {
        Integer satu = Integer.parseInt(a);
        Integer dua = Integer.parseInt(b);
        Integer tiga = satu+dua;
        jumlahin = String.valueOf(tiga);
        return jumlahin;
    }
}
