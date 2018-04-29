package id.simplify.prosperoinv.distribusi;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import id.simplify.prosperoinv.Login;
import id.simplify.prosperoinv.R;
import id.simplify.prosperoinv.model.Jual;
import id.simplify.prosperoinv.penjualan.Adapter;
import id.simplify.prosperoinv.penjualan.Detail;
import id.simplify.prosperoinv.penjualan.JualAdapter;
import id.simplify.prosperoinv.penjualan.TambahJualan;

public class Distribusi1 extends AppCompatActivity {
    RecyclerView recyclerView;
    private List<Jual> posts;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_distribusi1);
        recyclerView = (RecyclerView)findViewById(R.id.rv);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar3);
        setSupportActionBar(toolbar);
        databaseReference = FirebaseDatabase.getInstance().getReference("penjualan");
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        posts = new ArrayList<>();

    }

    @Override
    protected void onStart() {
        super.onStart();
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                posts.clear();

                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    Jual post = postSnapshot.getValue(Jual.class);
                    posts.add(post);
                }
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                //Bagian yang memasukkan get data ke adapter sehingga masuk recyclerview
                DistAdapter postList = new DistAdapter(getApplicationContext(), posts);
                recyclerView.setAdapter(postList);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu_main) {
        //getMenuInflater().inflate(R.menu.menu_jual, menu_main);
        return true;
    }
    @SuppressLint("NewApi")
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.logout) {
            //Logout dan mencegah dapat mengklik back
            FirebaseAuth.getInstance().signOut();
            Intent a = new Intent(this, Login.class);
            startActivity(a);
            finishAffinity();
            return true;
        } else if (id == R.id.addsell){
            Intent a = new Intent(this,TambahJualan.class);
            startActivity(a);
        }
        return super.onOptionsItemSelected(item);
    }
}


