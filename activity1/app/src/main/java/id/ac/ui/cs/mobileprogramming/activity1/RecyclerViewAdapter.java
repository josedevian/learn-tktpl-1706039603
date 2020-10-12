package id.ac.ui.cs.mobileprogramming.activity1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import id.ac.ui.cs.mobileprogramming.activity1.databinding.ListItemsBinding;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private List<Item> list;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onClick(View view, int position);
    }

    public RecyclerViewAdapter(List<Item> list) {
        this.list = list;
    }

    public void setListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public Item getItemAt(int position) {
        return list.get(position);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ListItemsBinding binding = DataBindingUtil.inflate(inflater, R.layout.list_items, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.binding.course.setText(list.get(position).getCourse());
        holder.binding.task.setText(list.get(position).getTask());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ListItemsBinding binding;

        public ViewHolder(@NonNull ListItemsBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            this.binding.getRoot().setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            listener.onClick(v, getAdapterPosition());
        }
    }
}
