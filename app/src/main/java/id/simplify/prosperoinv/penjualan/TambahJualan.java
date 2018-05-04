package id.simplify.prosperoinv.penjualan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import id.simplify.prosperoinv.R;
import id.simplify.prosperoinv.model.Bahan;
import id.simplify.prosperoinv.model.Barang;
import id.simplify.prosperoinv.model.Jual;
import id.simplify.prosperoinv.model.User;
import id.simplify.prosperoinv.pengadaan.TambahPesanan;

public class TambahJualan extends AppCompatActivity {
    DatabaseReference inputkeun1,inputkeun2,user,databaseReference;
    String no,namabarang,jumlah,pemesan,pengupdate,alamat,uiduser,namauser,jumlahbarang,totalbaru,pesanan;
    EditText a,b,c,d,e,f;
    Integer satu,dua,tiga;
    Spinner aa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_jualann);
        aa = (Spinner) findViewById(R.id.spinner2);
        inputkeun1 = FirebaseDatabase.getInstance().getReference("barang-jadi");
        inputkeun2 = FirebaseDatabase.getInstance().getReference("penjualan");
        databaseReference = FirebaseDatabase.getInstance().getReference();
        a = (EditText) findViewById(R.id.editText);
        b = (EditText) findViewById(R.id.editText3);
        c = (EditText) findViewById(R.id.editText6);
        d = (EditText) findViewById(R.id.editText7);
        dataforspinner();
        user = FirebaseDatabase.getInstance().getReference();
        uiduser = FirebaseAuth.getInstance().getCurrentUser().getUid();
        Query query = user.child("user").child(uiduser);
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
        aa.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                pesanan = (String)aa.getSelectedItem();
                inputkeun1.child(pesanan).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if(dataSnapshot.exists()){
                            Barang barang = dataSnapshot.getValue(Barang.class);
                            jumlahbarang = barang.getJumlahbarang();
                        }
                    }
                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                    }
                });
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });

    }

    private void dataforspinner() {
        inputkeun1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                ArrayList<String> list = new ArrayList<>();
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()){
                    Barang bahanpesan = dataSnapshot1.getValue(Barang.class);
                    list.add(bahanpesan.getNamabrg().toString());
                }
                showdatainspinner(list);
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private void showdatainspinner(ArrayList<String> data) {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_spinner_item, data);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        aa.setAdapter(adapter);
    }

    public void tambah(View view) {
        no = a.getText().toString();
        jumlah = b.getText().toString();
        pemesan = c.getText().toString();
        alamat = d.getText().toString();
        if(aa != null && aa.getSelectedItem() !=null ) {
            pesanan = (String)aa.getSelectedItem();
            Jual nambahnih = new Jual(no,pesanan,jumlah,namauser,pemesan,alamat);
            caridata();
            inputkeun1.child(pesanan).child("jumlahbarang").setValue(String.valueOf(totalbaru));
            inputkeun2.child(no).setValue(nambahnih);
            TambahJualan.this.finish();
        }
    }

    private void caridata() {

        //Toast.makeText(this,jumlahbarang,Toast.LENGTH_SHORT).show();
        getKurangin(jumlahbarang,jumlah);
    }

    private String getKurangin(String aa, String be) {
        satu = Integer.parseInt(aa);
        dua = Integer.parseInt(be);
        tiga = satu-dua;
        totalbaru = String.valueOf(tiga);
        return totalbaru;
    }


}
