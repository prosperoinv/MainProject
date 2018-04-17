package id.simplify.prosperoinv.pengadaan;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.LinkedList;

import id.simplify.prosperoinv.R;
import id.simplify.prosperoinv.pengadaan.StockRec;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentPengadaan1 extends Fragment {
    private final LinkedList<String> barang = new LinkedList<>();
    private final LinkedList<String> vendor = new LinkedList<>();
    private final LinkedList<String> jumlah = new LinkedList<>();

    private RecyclerView mRecyclerView;
    private id.simplify.prosperoinv.pengadaan.StockRec mAdapter;
    public FragmentPengadaan1() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.tab_pengadaan1, container, false);
        insertData();
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.receviewer);
        //FloatingActionButton fab = (FloatingActionButton) getActivity().findViewById(R.id.fab1);
        mAdapter = new id.simplify.prosperoinv.pengadaan.StockRec(getActivity(), barang, vendor, jumlah);
        recyclerView.setAdapter(mAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        return view;
    }

    private void insertData() {
        for (int i = 0; i < 1; i++) {//pengulangan untuk menghasilkan data yang banyak
            barang.add("Bahan Dasar"); //untuk menambah merk minuman
            barang.add("Alas");
            barang.add("Karet");
            barang.add("Tali");
            barang.add("Hiasan");


            vendor.add("M"); //untuk menambah deskripsi
            vendor.add("N");
            vendor.add("O");
            vendor.add("P");
            vendor.add("Q");

            jumlah.add("27"); //untuk menambahkan foto
            jumlah.add("11");
            jumlah.add("19");
            jumlah.add("98");
            jumlah.add("103");

        }
    }


}
