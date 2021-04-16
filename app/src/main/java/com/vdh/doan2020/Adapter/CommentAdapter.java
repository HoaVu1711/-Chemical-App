package com.vdh.doan2020.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vdh.doan2020.Model.BinhLuan;
import com.vdh.doan2020.R;

import java.util.List;

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.ViewHolder> {
    private Context context;
    private List<BinhLuan>comment;

    public CommentAdapter(Context context, List<BinhLuan> comment) {
        this.context = context;
        this.comment = comment;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater= LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.comment_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
         holder.tvnoidung.setText(comment.get(position).getBinhluan().toString());
         holder.tvUserName.setText(comment.get(position).getUsername().toString());
    }

    @Override
    public int getItemCount() {
        return comment.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tvnoidung;
        private  TextView tvUserName;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvnoidung=itemView.findViewById(R.id.tv_comment);
            tvUserName=itemView.findViewById(R.id.tvAdmin);
        }
    }
}
