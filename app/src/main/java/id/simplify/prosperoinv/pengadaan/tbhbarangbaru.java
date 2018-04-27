package id.simplify.prosperoinv.pengadaan;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ServerValue;
import com.google.firebase.database.ValueEventListener;

import java.sql.Time;

import id.simplify.prosperoinv.R;
import id.simplify.prosperoinv.model.Bahan;
import id.simplify.prosperoinv.model.User;

public class tbhbarangbaru extends AppCompatActivity {
    EditText namabarang, vendorbarang, jumlahbarang;
    FirebaseAuth a;
    DatabaseReference c;
    FirebaseUser user;
    String uiduser,namauser;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tbhbarangbaru);
        namabarang = (EditText) findViewById(R.id.editText);
        vendorbarang = (EditText) findViewById(R.id.editText2);
        jumlahbarang = (EditText) findViewById(R.id.editText3);
        a = FirebaseAuth.getInstance();
        c = FirebaseDatabase.getInstance().getReference();
        FindOutUser();
    }
    private void FindOutUser() {
        user = a.getCurrentUser();
        uiduser = user.getUid();
        Query query = c.child("user").child(uiduser);
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
    public void tambah(View view) {
        String nama, vendor, jumlah;
        nama = namabarang.getText().toString();
        vendor = vendorbarang.getText().toString();
        jumlah = jumlahbarang.getText().toString();
        String usernow = a.getCurrentUser().getUid();
        Bahan baru = new Bahan(nama, vendor, jumlah, null, namauser);
        c.child("baseline-mentah").child(nama).setValue(baru);
        tbhbarangbaru.this.finish();
    }
}
