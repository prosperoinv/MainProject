package id.simplify.prosperoinv.pengadaan;

import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import id.simplify.prosperoinv.R;
import id.simplify.prosperoinv.model.Bahan;
import id.simplify.prosperoinv.model.User;

public class TambahPesanan extends AppCompatActivity {
    Spinner a;
    EditText jml;
    FirebaseDatabase database;
    DatabaseReference inputkeun,inputkeun2,user;
    String uiduser,namauser;
    FirebaseUser ujicoba;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_pesanan);
        a = (Spinner) findViewById(R.id.spinner);
        jml = (EditText) findViewById(R.id.editText4);
        ujicoba = FirebaseAuth.getInstance().getCurrentUser();
        uiduser = ujicoba.getUid();
        inputkeun = database.getInstance().getReference("baseline-mentah");
        inputkeun2 = database.getInstance().getReference("pesanan");
        user = database.getInstance().getReference();
        dataforspinner();
        dataforuser();

    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    private void dataforuser() {
        Query query = user.child("user").orderByChild("userId").equalTo(uiduser);
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()){
                    User user = dataSnapshot.getValue(User.class);
                    namauser = user.getUsername();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }

    private void dataforspinner() {
        inputkeun.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                ArrayList<String> list = new ArrayList<>();
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()){
                    Bahan bahanpesan = dataSnapshot1.getValue(Bahan.class);
                    list.add(bahanpesan.getNamabarang().toString());
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
        a.setAdapter(adapter);
    }



    public void tambahpesan(View view) {
        if(a != null && a.getSelectedItem() !=null ) {
           String pesanan = (String)a.getSelectedItem();
           String jumlah = jml.getText().toString();
           Bahan pesan = new Bahan(pesanan,null,jumlah,null,namauser);
           inputkeun2.child(pesanan).setValue(pesan);
           TambahPesanan.this.finish();
        } else  {

        }
    }
}
