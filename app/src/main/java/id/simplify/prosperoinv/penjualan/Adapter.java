package id.simplify.prosperoinv.penjualan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

import id.simplify.prosperoinv.R;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private ArrayList<String> psn;

    public Adapter (ArrayList<String> a){
        this.psn = a;
    }

    @Override
    public Adapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_adapter, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(Adapter.ViewHolder viewHolder, int i) {

        viewHolder.txta.setText(psn.get(i));
    }

    @Override
    public int getItemCount() {return psn.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txta;
        private RelativeLayout relativeLayout;
        public ViewHolder(View view) {
            super(view);
            txta = (TextView)view.findViewById(R.id.pesanan);
            relativeLayout =(RelativeLayout)view.findViewById(R.id.background_list);
        }
    }
    }

