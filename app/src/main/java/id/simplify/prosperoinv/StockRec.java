package id.simplify.prosperoinv;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.LinkedList;

/**
 * Created by Haikal on 3/24/2018.
 */

public class StockRec extends RecyclerView.Adapter<StockRec.MenuViewHolder> {
    private final LinkedList<String> mbahanlist;
    private final LinkedList<String> mvendorlist;
    private final LinkedList<String> mjumlahlist;
    private LayoutInflater mInflater;

    public StockRec(Context context, LinkedList<String> a, LinkedList<String> b, LinkedList<String> c) {
        mInflater = LayoutInflater.from(context);
        this.mbahanlist = a; //constructor untuk menerima variable
        this.mvendorlist = b;
        this.mjumlahlist = c;
    }

    @Override
    public MenuViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.recycle_view_temp, parent, false);
        return new StockRec.MenuViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(StockRec.MenuViewHolder holder, int position) {
        String mCurrentbahan = mbahanlist.get(position);
        String mCurrentvendor = mvendorlist.get(position);
        String mCurrentjumlah = mjumlahlist.get(position); //memasukkan nilai ke variabel
        holder.bahanItemView.setText(mCurrentbahan);
        holder.vendorItemView.setText(mCurrentvendor);
        holder.jmlItemView.setText(mCurrentjumlah);
    }

    @Override
    public int getItemCount() {
        return mbahanlist.size();
    }

    class MenuViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public final TextView bahanItemView;
        public final TextView vendorItemView;
        public final TextView jmlItemView;
        public final LinearLayout linearLayout;

        final StockRec mAdapter;

        public MenuViewHolder(final View itemView, StockRec adapter) {
            super(itemView);
            bahanItemView = (TextView) itemView.findViewById(R.id.bahan);
            vendorItemView = (TextView) itemView.findViewById(R.id.vendor);
            jmlItemView = (TextView) itemView.findViewById(R.id.jumlah);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.cabskut);
            linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Get the position of the item that was clicked.
                    int mPosition = getLayoutPosition();
                    // Use that to access the affected item in mWordList.
                    String namaa = mbahanlist.get(mPosition);
                    String deski = mvendorlist.get(mPosition);
                    String photo = mjumlahlist.get(mPosition);
                }
            });
            this.mAdapter = adapter;
        }

        @Override
        public void onClick(View view) {

        }
    }
}
