package id.simplify.prosperoinv.produksi;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import id.simplify.prosperoinv.R;
import id.simplify.prosperoinv.model.Bahan;
import id.simplify.prosperoinv.model.Barang;
import id.simplify.prosperoinv.pengadaan.PostAdapter;

public class produksi extends AppCompatActivity {
    private List<Barang> posts;
    RecyclerView recyclerView;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produksi);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        databaseReference = FirebaseDatabase.getInstance().getReference("barang-jadi");
        recyclerView = (RecyclerView) findViewById(R.id.review);
        posts = new ArrayList<>();
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(produksi.this, update_produksi.class);
                startActivity(a);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                posts.clear();

                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    Barang post = postSnapshot.getValue(Barang.class);
                    posts.add(post);
                }
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                //Bagian yang memasukkan get data ke adapter sehingga masuk recyclerview
                BarangAdapter postList = new BarangAdapter(getApplicationContext(), posts);
                recyclerView.setAdapter(postList);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
