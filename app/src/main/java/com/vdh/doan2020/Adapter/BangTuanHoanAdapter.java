package com.vdh.doan2020.Adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vdh.doan2020.Model.NguyenToHoaHoc;
import com.vdh.doan2020.R;

import java.util.ArrayList;
import java.util.List;

public class BangTuanHoanAdapter extends RecyclerView.Adapter<BangTuanHoanAdapter.ViewHolder> implements Filterable {
    private List<NguyenToHoaHoc> nguyenToHoaHocList;
    private Context context;
    private List<NguyenToHoaHoc> filterList;

    public BangTuanHoanAdapter(List<NguyenToHoaHoc> nguyenToHoaHocList, Context context) {
        this.nguyenToHoaHocList = nguyenToHoaHocList;
        this.context = context;
        filterList = nguyenToHoaHocList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.nguyentohoahoc_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvTen.setText(filterList.get(position).getmTen());
        holder.tvKihieu.setBackgroundColor(filterList.get(position).getmMauSac());
        holder.tvKihieu.setText(filterList.get(position).getmKiHieu());
        holder.tvNguyenTuKhoi.setText(String.valueOf(filterList.get(position).getmNguyenTuKhoi()));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Thông tin chi tiết về nguyên tố " + nguyenToHoaHocList.get(position).getmTen());
                String msg = nguyenToHoaHocList.get(position).getmChiTiet();
                builder.setMessage(msg);
                builder.setNegativeButton("Thoat", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                builder.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return filterList.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String character = charSequence.toString();
                if (character == null) {
                    filterList = nguyenToHoaHocList;
                } else {
                    List<NguyenToHoaHoc> ListCurrent = new ArrayList<>();
                    for (NguyenToHoaHoc s : nguyenToHoaHocList) {
                        if (charSequence.toString().toLowerCase().contains(s.getmTen().toLowerCase())) {
                            ListCurrent.add(s);
                        }
                    }
                    filterList = ListCurrent;
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = filterList;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                filterList = (List<NguyenToHoaHoc>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvTen, tvKihieu, tvNguyenTuKhoi;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTen = itemView.findViewById(R.id.tv_ten);
            tvKihieu = itemView.findViewById(R.id.tv_Kieuhieu);
            tvNguyenTuKhoi = itemView.findViewById(R.id.tv_nguyentukhoi);
        }
    }
}

