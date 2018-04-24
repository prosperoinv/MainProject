package id.simplify.prosperoinv.pengadaan;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import id.simplify.prosperoinv.model.Bahan;
import id.simplify.prosperoinv.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentPengadaan2 extends Fragment {
    private List<Bahan> posts;
    RecyclerView recyclerView;
    DatabaseReference databaseReference;
    public FragmentPengadaan2() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.tab_pengadaan2, container, false);
        databaseReference = FirebaseDatabase.getInstance().getReference("pesanan");

        recyclerView = (RecyclerView) view.findViewById(R.id.recviewer);
        posts = new ArrayList<>();
        return view;
    }
    @Override
    public void onStart() {
        super.onStart();
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                posts.clear();

                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    Bahan post = postSnapshot.getValue(Bahan.class);
                    posts.add(post);
                }
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                //Bagian yang memasukkan get data ke adapter sehingga masuk recyclerview
                PostAdapter postList = new PostAdapter(getContext(), posts);
                recyclerView.setAdapter(postList);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
