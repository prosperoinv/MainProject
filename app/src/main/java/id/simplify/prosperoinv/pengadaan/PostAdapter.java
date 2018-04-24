package id.simplify.prosperoinv.pengadaan;

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
import id.simplify.prosperoinv.model.Bahan;
//Class ini berfungsi sebagai adapter dari recyclerview per fragment
public class PostAdapter extends RecyclerView.Adapter<PostAdapter.MyViewHolder> {
    private Context context;
    private List<Bahan> posts;

    public PostAdapter(Context context, List<Bahan> posts) {
        this.context = context;
        this.posts = posts;
    }

    @Override
    public PostAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_view_temp, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(PostAdapter.MyViewHolder holder, int position) {
        final Bahan post= posts.get(position);

        holder.mNama.setText(post.getNamabarang());
        holder.mVendor.setText(post.getVendorbarang());
        holder.mJumlah.setText(post.getJumlahbarang());
        holder.cardViewPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailBarang.class);
                intent.putExtra("group",context.getClass().toString());
                intent.putExtra("nama",post.getNamabarang());
                intent.putExtra("vendor",post.getVendorbarang());
                intent.putExtra("jumlah",post.getJumlahbarang());
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
        public TextView mVendor;
        public TextView mJumlah;
        public CardView cardViewPost;

        public MyViewHolder(View itemView) {
            super(itemView);
            mNama = itemView.findViewById(R.id.bahan);
            mVendor = itemView.findViewById(R.id.vendor);
            mJumlah = itemView.findViewById(R.id.jumlah);
            cardViewPost= itemView.findViewById(R.id.card_view);
        }
    }

}