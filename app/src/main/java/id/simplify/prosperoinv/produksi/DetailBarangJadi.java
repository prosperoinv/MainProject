package id.simplify.prosperoinv.produksi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
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

public class DetailBarangJadi extends AppCompatActivity {
    Intent ab;
    String nama,jumlah,pengupdate;
    String nilaisatu,nilaidua,nilaitiga,nmbhn1,nmbhn2,nmbhn3;
    String satu,dua,tiga;
    Integer lama,baru,total,var1,var2,var3;
    TextView nm,jml,pud;
    EditText barui;
    DatabaseReference databaseReference,dr;
    FirebaseUser user;
    FirebaseAuth a;
    String uiduser,namauser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_barang_jadi);
        nm = (TextView) findViewById(R.id.editText);
        jml = (TextView) findViewById(R.id.editText2);
        pud = (TextView) findViewById(R.id.editText3);
        barui = (EditText) findViewById(R.id.editText5);
        a = FirebaseAuth.getInstance();

        databaseReference = FirebaseDatabase.getInstance().getReference();
        dr = FirebaseDatabase.getInstance().getReference("baseline-mentah");
        FindOutUser();
        ab = getIntent();
        nama = ab.getStringExtra("nama");
        jumlah = ab.getStringExtra("jumlah");
        pengupdate = ab.getStringExtra("pengupdate");
//        FindOutJumlah();
        nm.setText(nama);
        jml.setText(jumlah);
        pud.setText(pengupdate);
//        Toast.makeText(this,n1,Toast.LENGTH_SHORT).show();





//        if (nama.equals("Sepatu Merah")){
//            nmbhn1 = "ALAS DALAM";
//            nmbhn2 = "ALAS LUAR";
//            nmbhn3 = "PERMATA SEPATU";
//            var1 = FindNilaiA(nmbhn1);
//            var2 = FindNilaiB(nmbhn2);
//            var3 = FindNilaiC(nmbhn3);
//        } else if (nama.equals("Flat Shoes Cream")){
//            nmbhn1 = "ALAS DALAM";
//            nmbhn2 = "ALAS LUAR";
//            nmbhn3 = "KAIN SEPATU CREAM";
//            var1 = FindNilaiA(nmbhn1);
//            var2 = FindNilaiB(nmbhn2);
//            var3 = FindNilaiC(nmbhn3);
//        } else if (nama.equals("Flat Shoes Hitam")){
//            nmbhn1 = "ALAS DALAM";
//            nmbhn2 = "ALAS LUAR";
//            nmbhn3 = "KAIN SEPATU HITAM";
//            var1 = FindNilaiA(nmbhn1);
//            var2 = FindNilaiB(nmbhn2);
//            var3 = FindNilaiC(nmbhn3);
//        } else if (nama.equals("Flat Shoes Pink")){
//            nmbhn1 = "ALAS DALAM";
//            nmbhn2 = "ALAS LUAR";
//            nmbhn3 = "KAIN SEPATU PINK";
//            var1 = FindNilaiA(nmbhn1);
//            var2 = FindNilaiB(nmbhn2);
//            var3 = FindNilaiC(nmbhn3);
//        } else if (nama.equals("Flat Shoes Coklat")){
//            nmbhn1 = "ALAS DALAM";
//            nmbhn2 = "ALAS LUAR";
//            nmbhn3 = "KAIN SEPATU COKLAT";
//            var1 = FindNilaiA(nmbhn1);
//            var2 = FindNilaiB(nmbhn2);
//            var3 = FindNilaiC(nmbhn3);
//        } else if (nama.equals("Flat Shoes Putih")){
//            nmbhn1 = "ALAS DALAM";
//            nmbhn2 = "ALAS LUAR";
//            nmbhn3 = "KAIN SEPATU PUTIH";
//            var1 = FindNilaiA(nmbhn1);
//            var2 = FindNilaiB(nmbhn2);
//            var3 = FindNilaiC(nmbhn3);
//        } else if (nama.equals("Flat Sepatu Kulit Suede Pink")){
//            nmbhn1 = "ALAS DALAM";
//            nmbhn2 = "ALAS LUAR";
//            nmbhn3 = "KULIT SUEDE PINK";
//            var1 = FindNilaiA(nmbhn1);
//            var2 = FindNilaiB(nmbhn2);
//            var3 = FindNilaiC(nmbhn3);
//        }

//        Toast.makeText(this,var1,Toast.LENGTH_SHORT).show();
    }

//   private Integer FindNilaiA(String n1){
//        satu= n1;
//        dr.child(nmbhn1).addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                if (dataSnapshot.exists()) {
//                    Bahan baru = dataSnapshot.getValue(Bahan.class);
//                    nilaisatu = baru.getJumlahbarang();
//                }
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//            }
//        });
//        Integer a = Integer.parseInt(nilaisatu);
//        return a;
//    }
//    private Integer FindNilaiB(String n1){
//        dua= n1;
//        dr.child(nmbhn2).addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                if (dataSnapshot.exists()) {
//                    Bahan baru = dataSnapshot.getValue(Bahan.class);
//                    nilaidua = baru.getJumlahbarang();
//                }
//            }
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//            }
//        });
//        Integer b = Integer.parseInt(nilaidua);
//        return b;
//    }
//    private Integer FindNilaiC(String n1){
//        tiga= n1;
//        dr.child(nmbhn3).addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                if (dataSnapshot.exists()) {
//                    Bahan baru = dataSnapshot.getValue(Bahan.class);
//                    nilaitiga = baru.getJumlahbarang();
//                }
//            }
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//            }
//        });
//        Integer c = Integer.parseInt(nilaitiga);
//        return c;
//    }

    private void FindOutUser() {
        user = a.getCurrentUser();
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
    }

    public void updatejumlahjadi(View view) {
//        Integer nilaibahan1,nilaibahan2,nilaibahan3,yangbaru;
//        yangbaru = Integer.parseInt(barui.getText().toString());
//        nilaibahan1 = var1-(2*yangbaru);
//        nilaibahan2 = var2-(2*yangbaru);
//        nilaibahan3 = var3-(2*yangbaru);
        lama = Integer.parseInt(jumlah);
        baru = Integer.parseInt(barui.getText().toString());
        total = lama+baru;
        String totalupdate = String.valueOf(total);
        databaseReference.child("barang-jadi").child(nama).child("jumlahbarang").setValue(totalupdate);
        databaseReference.child("barang-jadi").child(nama).child("pengupdate").setValue(namauser);
//        dr.child(nmbhn1).child("jumlahbarang").setValue(String.valueOf(nilaibahan1));
//        dr.child(nmbhn1).child("pengupdate").setValue(namauser);
//        dr.child(nmbhn2).child("jumlahbarang").setValue(String.valueOf(nilaibahan2));
//        dr.child(nmbhn2).child("pengupdate").setValue(namauser);
//        dr.child(nmbhn3).child("jumlahbarang").setValue(String.valueOf(nilaibahan3));
//        dr.child(nmbhn3).child("pengupdate").setValue(namauser);
        DetailBarangJadi.this.finish();
    }
}
