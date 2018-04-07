package id.simplify.prosperoinv.penjualan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

import id.simplify.prosperoinv.R;

public class Penjualan1 extends AppCompatActivity {
    private ArrayList<String> psn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_penjualan1);

        initView();
    }

        private void initView(){
            RecyclerView recyclerView = (RecyclerView)findViewById(R.id.rv);
            recyclerView.setHasFixedSize(true);

            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());

            recyclerView.setLayoutManager(layoutManager);
            psn = new ArrayList<>();
            psn.add("Pesanan 001");
            psn.add("Pesanan 002");
            psn.add("Pesanan 003");
            psn.add("Pesanan 004");
            psn.add("Pesanan 005");

            RecyclerView.Adapter adapter = new Adapter(psn);
            recyclerView.setAdapter(adapter);

            recyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
                GestureDetector gestureDetector = new GestureDetector(getApplicationContext(), new GestureDetector.SimpleOnGestureListener() {

                    public boolean onSingleTapUp(MotionEvent e){
                        return true;
                    }
                });

                @Override
                public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
                    View child = rv.findChildViewUnder(e.getX(), e.getY());
                    if (child != null && gestureDetector.onTouchEvent(e)){
                        int position = rv.getChildAdapterPosition(child);
                        Intent intent = new Intent(getBaseContext(), Detail.class);
                        intent.putExtra("pesanan",psn.get(position));
                        startActivity(intent);
                    }
                    return false;
                }

                @Override
                public void onTouchEvent(RecyclerView rv, MotionEvent e) {

                }

                @Override
                public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

                }

    });
}}
