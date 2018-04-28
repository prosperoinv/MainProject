package id.simplify.prosperoinv.penjualan;

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
import id.simplify.prosperoinv.model.Jual;
import id.simplify.prosperoinv.produksi.DetailBarangJadi;

public class JualAdapter extends RecyclerView.Adapter<id.simplify.prosperoinv.penjualan.JualAdapter.MyViewHolder> {
    private Context context;

    private List<Jual> posts;

    public JualAdapter(Context context, List<Jual> posts) {
        this.context = context;
        this.posts = posts;
    }


    @Override
    public id.simplify.prosperoinv.penjualan.JualAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_adapter, parent, false);
        return new id.simplify.prosperoinv.penjualan.JualAdapter.MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(id.simplify.prosperoinv.penjualan.JualAdapter.MyViewHolder holder, int position) {
        final Jual post= posts.get(position);

        holder.mNo.setText(post.getNojual());
        holder.mPemesan.setText(post.getPemesan());
        holder.mPengupdate.setText(post.getPengupdate());
        holder.cardViewPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, Detail.class);
                intent.putExtra("nama",post.getNamabarang());
                intent.putExtra("jumlah",post.getJumlah());
                intent.putExtra("pengupdate",post.getPengupdate());
                intent.putExtra("no",post.getNojual());
                intent.putExtra("pemesan",post.getPemesan());
                intent.putExtra("alamat",post.getAlamat());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder{

        public TextView mNo;
        public TextView mPemesan;
        public TextView mPengupdate;
        public CardView cardViewPost;

        public MyViewHolder(View itemView) {
            super(itemView);
            mNo = itemView.findViewById(R.id.pesanan);
            mPemesan = itemView.findViewById(R.id.jumlah);
            mPengupdate = itemView.findViewById(R.id.pengupdate);
            cardViewPost= itemView.findViewById(R.id.card_view);
        }
    }

}