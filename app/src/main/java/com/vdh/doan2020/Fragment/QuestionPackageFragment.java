package com.vdh.doan2020.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.vdh.doan2020.R;
import com.vdh.doan2020.UI.QuestionPageActivity;

public class QuestionPackageFragment extends Fragment implements View.OnClickListener {
    private View view;
    private ImageButton btnPk1,btnPk2,btnPk3,btnPk4,btnPk5,btnPk6;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.package_question_fragment,container,false);
        this.view=view;
        anhXa();
        btnPk1.setOnClickListener(this);
        btnPk2.setOnClickListener(this);
        btnPk3.setOnClickListener(this);
        btnPk4.setOnClickListener(this);
        btnPk5.setOnClickListener(this);
        btnPk6.setOnClickListener(this);
        return view;
    }
    private void anhXa() {
        btnPk1=view.findViewById(R.id.btn_namepackage1);
        btnPk2=view.findViewById(R.id.btn_namepackage2);
        btnPk3=view.findViewById(R.id.btn_namepackage3);
        btnPk4=view.findViewById(R.id.btn_namepackage4);
        btnPk5=view.findViewById(R.id.btn_namepackage5);
        btnPk6=view.findViewById(R.id.btn_namepackage6);
}

    @Override
    public void onClick(View view) {
        Intent intent= new Intent();
     switch (view.getId()){
         case R.id.btn_namepackage1:
             intent=new Intent(view.getContext(),QuestionPageActivity.class);
             intent.putExtra("made",1);
             startActivity(intent);
             break;
         case R.id.btn_namepackage2:
             intent=new Intent(view.getContext(),QuestionPageActivity.class);
             intent.putExtra("made",1);
             startActivity(intent);
             break;
         case R.id.btn_namepackage3:
             intent=new Intent(view.getContext(),QuestionPageActivity.class);
             intent.putExtra("made",1);
             startActivity(intent);
             break;
         case R.id.btn_namepackage4:
             intent=new Intent(view.getContext(),QuestionPageActivity.class);
             intent.putExtra("made",1);
             startActivity(intent);
             break;
         case R.id.btn_namepackage5:
             intent=new Intent(view.getContext(),QuestionPageActivity.class);
             intent.putExtra("made",1);
             startActivity(intent);
             break;
         case R.id.btn_namepackage6:
             intent=new Intent(view.getContext(),QuestionPageActivity.class);
             intent.putExtra("made",1);
             startActivity(intent);
             break;
     }
    }
}
