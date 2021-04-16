package com.vdh.doan2020.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vdh.doan2020.Model.Diem;
import com.vdh.doan2020.R;

import java.util.List;

public class DiemAdapter extends RecyclerView.Adapter<DiemAdapter.ViewHolder> {
    private Context context;
    private List<Diem>list;

    public DiemAdapter(Context context, List<Diem> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      LayoutInflater inflater= LayoutInflater.from(context);
      View view=inflater.inflate(R.layout.diem_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvThoigian.setText(list.get(position).getThoiGian());
        holder.tvDiem.setText(list.get(position).getDiem()+"/30");
    }
    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvThoigian,tvDiem;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvThoigian=itemView.findViewById(R.id.tv_thoigian);
            tvDiem=itemView.findViewById(R.id.tv_diem);
        }
    }
}
