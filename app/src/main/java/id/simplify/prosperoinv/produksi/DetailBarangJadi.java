package id.simplify.prosperoinv.produksi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import id.simplify.prosperoinv.R;
import id.simplify.prosperoinv.model.Bahan;

public class DetailBarangJadi extends AppCompatActivity {
    Intent a;
    String nama,jumlah,pengupdate;
    String n1,n2,n3,n4,n5,n6,n7,n8,n9,n10,n11,n12;
    Integer lama,baru,total;
    TextView nm,jml,pud;
    EditText barui;
    DatabaseReference databaseReference,dr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_barang_jadi);
        nm = (TextView) findViewById(R.id.editText);
        jml = (TextView) findViewById(R.id.editText2);
        pud = (TextView) findViewById(R.id.editText3);
        barui = (EditText) findViewById(R.id.editText5);

        databaseReference = FirebaseDatabase.getInstance().getReference();
        dr = FirebaseDatabase.getInstance().getReference("baseline-mentah");

        a = getIntent();
        nama = a.getStringExtra("nama");
        jumlah = a.getStringExtra("jumlah");
        pengupdate = a.getStringExtra("pengupdate");
        FindOutJumlah();
        nm.setText(nama);
        jml.setText(jumlah);
        pud.setText(pengupdate);
//        Toast.makeText(this,n1,Toast.LENGTH_SHORT).show();

    }

    private void FindOutJumlah() {
        dr.child("ALAS DALAM").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Bahan bahan = dataSnapshot.getValue(Bahan.class);
                n1 = bahan.getJumlahbarang();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        databaseReference.child("baseline-mentah").child("ALAS LUAR").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Bahan bahan = dataSnapshot.getValue(Bahan.class);
                n2 = bahan.getJumlahbarang().toString();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        databaseReference.child("baseline-mentah").child("KAIN ALAS DALAM").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Bahan bahan = dataSnapshot.getValue(Bahan.class);
                n3 = bahan.getJumlahbarang().toString();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        databaseReference.child("baseline-mentah").child("KAIN CORAK BUNGA").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Bahan bahan = dataSnapshot.getValue(Bahan.class);
                n4 = bahan.getJumlahbarang().toString();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        databaseReference.child("baseline-mentah").child("KAIN SEPATU COKLAT").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Bahan bahan = dataSnapshot.getValue(Bahan.class);
                n5 = bahan.getJumlahbarang().toString();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        databaseReference.child("baseline-mentah").child("KAIN SEPATU CREAM").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Bahan bahan = dataSnapshot.getValue(Bahan.class);
                n6 = bahan.getJumlahbarang().toString();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        databaseReference.child("baseline-mentah").child("KAIN SEPATU HITAM").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Bahan bahan = dataSnapshot.getValue(Bahan.class);
                n7 = bahan.getJumlahbarang().toString();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        databaseReference.child("baseline-mentah").child("KAIN SEPATU PINK").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Bahan bahan = dataSnapshot.getValue(Bahan.class);
                n8 = bahan.getJumlahbarang().toString();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        databaseReference.child("baseline-mentah").child("KAIN SEPATU PUTIH").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Bahan bahan = dataSnapshot.getValue(Bahan.class);
                n9 = bahan.getJumlahbarang().toString();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        databaseReference.child("baseline-mentah").child("KULIT").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Bahan bahan = dataSnapshot.getValue(Bahan.class);
                n10 = bahan.getJumlahbarang().toString();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        databaseReference.child("baseline-mentah").child("KULIT SUEDE PINK").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Bahan bahan = dataSnapshot.getValue(Bahan.class);
                n11 = bahan.getJumlahbarang().toString();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        databaseReference.child("baseline-mentah").child("PERMATA SEPATU").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Bahan bahan = dataSnapshot.getValue(Bahan.class);
                n12 = bahan.getJumlahbarang().toString();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

    public void updatejumlahjadi(View view) {
        if (nama=="Sepatu Merah"){
            databaseReference.child("baseline-mentah")
                    .child("ALAS DALAM")
                    .child("jumlahbarang")
                    .setValue(String.valueOf(Integer.parseInt(n1)-2));
            databaseReference.child("baseline-mentah")
                    .child("KAIN ALAS DALAM")
                    .child("jumlahbarang")
                    .setValue(String.valueOf(Integer.parseInt(n3)-2));
            databaseReference.child("baseline-mentah")
                    .child("ALAS LUAR")
                    .child("jumlahbarang")
                    .setValue(String.valueOf(Integer.parseInt(n2)-2));
            databaseReference.child("baseline-mentah")
                    .child("KULIT")
                    .child("jumlahbarang")
                    .setValue(String.valueOf(Integer.parseInt(n10)-2));
            databaseReference.child("baseline-mentah")
                    .child("PERMATA SEPATU")
                    .child("jumlahbarang")
                    .setValue(String.valueOf(Integer.parseInt(n12)-2));

        } else if (nama=="Flat Sepatu Kulit Suede Pink"){
            databaseReference.child("baseline-mentah")
                    .child("ALAS DALAM")
                    .child("jumlahbarang")
                    .setValue(String.valueOf(Integer.parseInt(n1)-2));
            databaseReference.child("baseline-mentah")
                    .child("ALAS LUAR")
                    .child("jumlahbarang")
                    .setValue(String.valueOf(Integer.parseInt(n2)-2));
            databaseReference.child("baseline-mentah")
                    .child("KULIT SUEDE PINK")
                    .child("jumlahbarang")
                    .setValue(String.valueOf(Integer.parseInt(n11)-2));

        } else if (nama=="Flat Shoes Coklat"){
            databaseReference.child("baseline-mentah")
                    .child("ALAS DALAM")
                    .child("jumlahbarang")
                    .setValue(String.valueOf(Integer.parseInt(n1)-2));
            databaseReference.child("baseline-mentah")
                    .child("ALAS LUAR")
                    .child("jumlahbarang")
                    .setValue(String.valueOf(Integer.parseInt(n2)-2));
            databaseReference.child("baseline-mentah")
                    .child("KAIN SEPATU COKLAT")
                    .child("jumlahbarang")
                    .setValue(String.valueOf(Integer.parseInt(n5)-2));
        }
        else if (nama=="Flat Shoes Cream"){
            databaseReference.child("baseline-mentah")
                    .child("ALAS DALAM")
                    .child("jumlahbarang")
                    .setValue(String.valueOf(Integer.parseInt(n1)-2));
            databaseReference.child("baseline-mentah")
                    .child("ALAS LUAR")
                    .child("jumlahbarang")
                    .setValue(String.valueOf(Integer.parseInt(n2)-2));
            databaseReference.child("baseline-mentah")
                    .child("KAIN SEPATU CREAM")
                    .child("jumlahbarang")
                    .setValue(String.valueOf(Integer.parseInt(n6)-2));

        }
        else if (nama=="Flat Shoes Hitam"){
            databaseReference.child("baseline-mentah")
                    .child("ALAS DALAM")
                    .child("jumlahbarang")
                    .setValue(String.valueOf(Integer.parseInt(n1)-2));
            databaseReference.child("baseline-mentah")
                    .child("ALAS LUAR")
                    .child("jumlahbarang")
                    .setValue(String.valueOf(Integer.parseInt(n2)-2));
            databaseReference.child("baseline-mentah")
                    .child("KAIN SEPATU HITAM")
                    .child("jumlahbarang")
                    .setValue(String.valueOf(Integer.parseInt(n7)-2));

        }
        else if (nama=="Flat Shoes Pink"){
            databaseReference.child("baseline-mentah")
                    .child("ALAS DALAM")
                    .child("jumlahbarang")
                    .setValue(String.valueOf(Integer.parseInt(n1)-2));
            databaseReference.child("baseline-mentah")
                    .child("ALAS LUAR")
                    .child("jumlahbarang")
                    .setValue(String.valueOf(Integer.parseInt(n2)-2));
            databaseReference.child("baseline-mentah")
                    .child("KAIN SEPATU PINK")
                    .child("jumlahbarang")
                    .setValue(String.valueOf(Integer.parseInt(n8)-2));

        }
        else if (nama=="Flat Shoes Putih"){
            databaseReference.child("baseline-mentah")
                    .child("ALAS DALAM")
                    .child("jumlahbarang")
                    .setValue(String.valueOf(Integer.parseInt(n1)-2));
            databaseReference.child("baseline-mentah")
                    .child("ALAS LUAR")
                    .child("jumlahbarang")
                    .setValue(String.valueOf(Integer.parseInt(n2)-2));
            databaseReference.child("baseline-mentah")
                    .child("KAIN SEPATU PUTIH")
                    .child("jumlahbarang")
                    .setValue(String.valueOf(Integer.parseInt(n9)-2));
        }

        lama = Integer.parseInt(jumlah);
        baru = Integer.parseInt(barui.getText().toString());
        total = lama+baru;
        String totalupdate = String.valueOf(total);
        databaseReference.child("barang-jadi").child(nama).child("jumlahbarang").setValue(totalupdate);


        DetailBarangJadi.this.finish();
    }
}
