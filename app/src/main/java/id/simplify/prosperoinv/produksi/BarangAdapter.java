package id.simplify.prosperoinv.produksi;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;

import id.simplify.prosperoinv.R;
import id.simplify.prosperoinv.model.Barang;



public class BarangAdapter extends RecyclerView.Adapter<id.simplify.prosperoinv.produksi.BarangAdapter.MyViewHolder> {
    private Context context;
    private List<Barang> posts;

    public BarangAdapter(Context context, List<Barang> posts) {
        this.context = context;
        this.posts = posts;
    }


    @Override
    public id.simplify.prosperoinv.produksi.BarangAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_adapter, parent, false);
        return new id.simplify.prosperoinv.produksi.BarangAdapter.MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(id.simplify.prosperoinv.produksi.BarangAdapter.MyViewHolder holder, int position) {
        final Barang post= posts.get(position);

        holder.mNama.setText(post.getNamabrg());
        holder.mJumlah.setText(post.getJumlahbarang());
        holder.mPengupdate.setText(post.getPengupdate());
        holder.cardViewPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailBarangJadi.class);
                intent.putExtra("nama",post.getNamabrg());
                intent.putExtra("jumlah",post.getJumlahbarang());
                intent.putExtra("pengupdate",post.getPengupdate());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder{

        public TextView mNama;
        public TextView mPengupdate;
        public TextView mJumlah;
        public CardView cardViewPost;

        public MyViewHolder(View itemView) {
            super(itemView);
            mNama = itemView.findViewById(R.id.pesanan);
            mJumlah = itemView.findViewById(R.id.jumlah);
            mPengupdate = itemView.findViewById(R.id.pengupdate);
            cardViewPost= itemView.findViewById(R.id.card_view);
        }
    }

}