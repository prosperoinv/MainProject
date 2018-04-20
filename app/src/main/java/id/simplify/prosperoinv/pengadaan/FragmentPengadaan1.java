package id.simplify.prosperoinv.pengadaan;


import android.content.Intent;
import android.content.PeriodicSync;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import id.simplify.prosperoinv.R;
import id.simplify.prosperoinv.model.Bahan;
import id.simplify.prosperoinv.pengadaan.StockRec;



/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentPengadaan1 extends Fragment {
    private final LinkedList<String> barang = new LinkedList<>();
    private final LinkedList<String> vendor = new LinkedList<>();
    private final LinkedList<String> jumlah = new LinkedList<>();
    private List<Bahan> posts;
    RecyclerView recyclerView;
    FirebaseDatabase db;
    private ArrayList<Bahan> listPosts;
    Query databaseFood;
    DatabaseReference databaseReference;
   // private RecyclerView mRecyclerView;
    private id.simplify.prosperoinv.pengadaan.StockRec mAdapter;
    public FragmentPengadaan1() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.tab_pengadaan1, container, false);
        databaseReference = FirebaseDatabase.getInstance().getReference("baseline-mentah");

        recyclerView = (RecyclerView) view.findViewById(R.id.receviewer);
//      posts = new ArrayList<>();
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
//                posts.clear();

                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    Bahan post = postSnapshot.getValue(Bahan.class);
                    posts.add(post);
                }
                recyclerView.setHasFixedSize(true);

                recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

                PostAdapter postList = new PostAdapter(getContext(), posts);

                recyclerView.setAdapter(postList);
                //mProgressDialog.dismiss();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
