package id.simplify.prosperoinv.pengadaan;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListAdapter;

import java.util.LinkedList;

import id.simplify.prosperoinv.pengadaan.PengadaanRec;
import id.simplify.prosperoinv.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentPengadaan2 extends Fragment implements View.OnClickListener {
    private final LinkedList<String> barang = new LinkedList<>();
    private final LinkedList<String> vendor = new LinkedList<>();
    private final LinkedList<String> jumlah = new LinkedList<>();

    private RecyclerView mRecyclerView;
    private id.simplify.prosperoinv.pengadaan.PengadaanRec mAdapter;

    public FragmentPengadaan2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.tab_pengadaan2, container, false);
        insertData();
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recviewer);
        mAdapter = new PengadaanRec(getActivity(), barang, vendor, jumlah);
        recyclerView.setAdapter(mAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        return view;

    }

    private void insertData() {
        for (int i = 0; i < 1; i++) {//pengulangan untuk menghasilkan data yang banyak
            barang.add("Kulit"); //untuk menambah merk minuman
            barang.add("Sol");
            barang.add("Alas");
            barang.add("Cat");
            barang.add("Bahan");


            vendor.add("A"); //untuk menambah deskripsi
            vendor.add("B");
            vendor.add("C");
            vendor.add("D");
            vendor.add("E");

            jumlah.add("10"); //untuk menambahkan foto
            jumlah.add("20");
            jumlah.add("30");
            jumlah.add("40");
            jumlah.add("50");

        }
    }

    @Override
    public void onClick(View view) {

    }
}
