package id.simplify.prosperoinv.pengadaan;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.OnLifecycleEvent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.firebase.ui.common.ChangeEventType;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.firebase.ui.database.ObservableSnapshotArray;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;

public abstract class FirebaseRecyclerAdapter<T, VH extends RecyclerView.ViewHolder>
        extends RecyclerView.Adapter<VH> implements FirebaseAdapter<T> {
    private static final String TAG = "FirebaseRecyclerAdapter";

    private final ObservableSnapshotArray<T> mSnapshots;

    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     */
    public FirebaseRecyclerAdapter(@NonNull FirebaseRecyclerOptions<T> options) {
        mSnapshots = options.getSnapshots();

        if (options.getOwner() != null) {
            options.getOwner().getLifecycle().addObserver(this);
        }
    }

    @Override
    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void startListening() {
        if (!mSnapshots.isListening(this)) {
            mSnapshots.addChangeEventListener(this);
        }
    }

    @Override
    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void stopListening() {
        mSnapshots.removeChangeEventListener(this);
        notifyDataSetChanged();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    void cleanup(LifecycleOwner source) {
        source.getLifecycle().removeObserver(this);
    }

    @Override
    public void onChildChanged(@NonNull ChangeEventType type,
                               @NonNull DataSnapshot snapshot,
                               int newIndex,
                               int oldIndex) {
        switch (type) {
            case ADDED:
                notifyItemInserted(newIndex);
                break;
            case CHANGED:
                notifyItemChanged(newIndex);
                break;
            case REMOVED:
                notifyItemRemoved(newIndex);
                break;
            case MOVED:
                notifyItemMoved(oldIndex, newIndex);
                break;
            default:
                throw new IllegalStateException("Incomplete case statement");
        }
    }

    @Override
    public void onDataChanged() {
    }

    @Override
    public void onError(@NonNull DatabaseError error) {
        Log.w(TAG, error.toException());
    }

    @NonNull
    @Override
    public ObservableSnapshotArray<T> getSnapshots() {
        return mSnapshots;
    }

    @NonNull
    @Override
    public T getItem(int position) {
        return mSnapshots.get(position);
    }

    @NonNull
    @Override
    public DatabaseReference getRef(int position) {
        return mSnapshots.getSnapshot(position).getRef();
    }

    @Override
    public int getItemCount() {
        return mSnapshots.isListening(this) ? mSnapshots.size() : 0;
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        onBindViewHolder(holder, position, getItem(position));
    }

    /**
     * @param model the model object containing the data that should be used to populate the view.
     * @see #onBindViewHolder(RecyclerView.ViewHolder, int)
     */
    protected abstract void onBindViewHolder(@NonNull VH holder, int position, @NonNull T model);
}