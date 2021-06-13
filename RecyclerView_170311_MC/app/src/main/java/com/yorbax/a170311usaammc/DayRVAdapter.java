package com.yorbax.a170311usaammc;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Random;

class DayRVAdapter extends RecyclerView.Adapter<DayRVAdapter.ViewHolder> {
    RVClickDelListener callback;
    List<DaysModel> list;

    public DayRVAdapter(RVClickDelListener callback, List<DaysModel> list) {
        this.callback = callback;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View v = layoutInflater.inflate(R.layout.item_days, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DaysModel currentDay = list.get(position);
        holder.txTitle.setText(currentDay.getDaysName());
        holder.txSecondary.setText(currentDay.getDescription());
        Random rnd = new Random();
        int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
        holder.viewColorBar.setCardBackgroundColor(color);

        holder.btnDelete.setOnClickListener(v -> {
            callback.onItemDelete(holder.getAdapterPosition(), list.get(holder.getAdapterPosition()));
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void deleteItem(int position) {
        list.remove(position);
        this.notifyItemRemoved(position);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView txTitle, txSecondary;
        ImageButton btnDelete;
        CardView viewColorBar;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txTitle = itemView.findViewById(R.id.day_name);
            txSecondary = itemView.findViewById(R.id.description);
            btnDelete = itemView.findViewById(R.id.btn_delete);
            viewColorBar = itemView.findViewById(R.id.view_left);
        }
    }
}
