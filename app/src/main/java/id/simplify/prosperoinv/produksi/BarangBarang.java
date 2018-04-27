package id.simplify.prosperoinv.produksi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

import id.simplify.prosperoinv.R;
import id.simplify.prosperoinv.model.Bahan;
import id.simplify.prosperoinv.model.Barang;

public class BarangBarang extends AppCompatActivity {
    private List<Barang> posts;
    RecyclerView recyclerView;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barang_barang);
        databaseReference = FirebaseDatabase.getInstance().getReference("barang-jadi");
        recyclerView = (RecyclerView) findViewById(R.id.receviewer);
        posts = new ArrayList<>();

    }
}
