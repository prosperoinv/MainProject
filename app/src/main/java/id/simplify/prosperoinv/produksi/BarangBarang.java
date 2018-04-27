package id.simplify.prosperoinv.produksi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import id.simplify.prosperoinv.R;
import id.simplify.prosperoinv.model.Barang;
import id.simplify.prosperoinv.model.User;

public class BarangBarang extends AppCompatActivity {
    DatabaseReference databaseReference;
    EditText nama,jumlah;
    String nm,jml,uiduser,namauser;
    FirebaseUser user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barang_barang);
        nama = (EditText) findViewById(R.id.editText);
        jumlah = (EditText) findViewById(R.id.editText3);

        databaseReference = FirebaseDatabase.getInstance().getReference("");
        FindOutUser();

    }

    private void FindOutUser() {
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
    }

    public void tambahprodukbaru(View view) {
        nm =  nama.getText().toString();
        jml = jumlah.getText().toString();
        Barang baru = new Barang(nm,jml,null,namauser);
        databaseReference.child("barang-jadi").child(nm).setValue(baru);
        BarangBarang.this.finish();
    }
}
