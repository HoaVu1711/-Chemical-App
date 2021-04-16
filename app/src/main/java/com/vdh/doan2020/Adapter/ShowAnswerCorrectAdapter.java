package com.vdh.doan2020.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.vdh.doan2020.Model.Question;
import com.vdh.doan2020.R;

import java.util.List;

public class ShowAnswerCorrectAdapter extends BaseAdapter {
    private Context context;
    private List<Question> list;

    public ShowAnswerCorrectAdapter(Context context, List<Question> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return 30;
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ShowAnswerCorrectAdapter.ViewHolder viewHolder;
        if(view==null){
            LayoutInflater inflater=LayoutInflater.from(context);
            view=inflater.inflate(R.layout.showanswer_item,viewGroup,false);
            viewHolder=new ViewHolder();
            viewHolder.tvIndex=view.findViewById(R.id.tv_number_anwer);
            viewHolder.tvAnswer=view.findViewById(R.id.tv_anwer);
            viewHolder.tvAnswerCorrect=view.findViewById(R.id.tv_anwercorret);
            view.setTag(viewHolder);
        }
        else {
            viewHolder= (ViewHolder) view.getTag();
        }
        int position=i+1;
        viewHolder.tvIndex.setText("Câu:"+position);
        viewHolder.tvAnswer.setText(list.get(i).getTraLoi());
        viewHolder.tvAnswerCorrect.setText(list.get(i).getKetQua());
        return view;
    }
    public class ViewHolder{
        TextView tvIndex,tvAnswer,tvAnswerCorrect;
    }
}
