package com.vdh.doan2020.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.vdh.doan2020.R;
import com.vdh.doan2020.UI.HHHCChuong1;
import com.vdh.doan2020.UI.HHHCChuong2;
import com.vdh.doan2020.UI.HHHCChuong3;
import com.vdh.doan2020.UI.HHHCChuong5;
import com.vdh.doan2020.UI.HHHCChuong6;
import com.vdh.doan2020.UI.HHHCChuong7;
import com.vdh.doan2020.UI.HHHCChuong8;
import com.vdh.doan2020.UI.HHHCchuong10;
import com.vdh.doan2020.UI.HHHChuong4;
import com.vdh.doan2020.UI.HHHChuong9;


public class LyThuyetHHHCFragment extends Fragment implements View.OnClickListener {
    private static LyThuyetHHHCFragment INSTANCE;
    private Button btn1, btn2, btn3, btn4, btn5, btn6, btn7,btn8,btn9,btn10;
    private View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_lythuyethhhc, container, false);
        anhXa();
        return view;
    }

    public static LyThuyetHHHCFragment getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new LyThuyetHHHCFragment();
        }
        return INSTANCE;
    }

    private void anhXa() {
        btn1 = view.findViewById(R.id.btn_chuong1);
        btn2 = view.findViewById(R.id.btn_chuong2);
        btn3 = view.findViewById(R.id.btn_chuong3);
        btn4 = view.findViewById(R.id.btn_chuong4);
        btn5 = view.findViewById(R.id.btn_chuong5);
        btn6 = view.findViewById(R.id.btn_chuong6);
        btn7 = view.findViewById(R.id.btn_chuong7);
        btn8 = view.findViewById(R.id.btn_chuong8);
        btn9 = view.findViewById(R.id.btn_chuong9);
        btn10 = view.findViewById(R.id.btn_chuong10);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btn10.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()){
            case R.id.btn_chuong1:
             intent= new Intent(getActivity(), HHHCChuong1.class);
             startActivity(intent);
             break;
            case R.id.btn_chuong2:
                intent= new Intent(getActivity(), HHHCChuong2.class);
                startActivity(intent);
                break;
            case R.id.btn_chuong3:
                intent= new Intent(getActivity(), HHHCChuong3.class);
                startActivity(intent);
                break;
            case R.id.btn_chuong4:
                intent= new Intent(getActivity(), HHHChuong4.class);
                startActivity(intent);
                break;
            case R.id.btn_chuong5:
                intent= new Intent(getActivity(), HHHCChuong5.class);
                startActivity(intent);
                break;
            case R.id.btn_chuong6:
                intent= new Intent(getActivity(), HHHCChuong6.class);
                startActivity(intent);
                break;
            case R.id.btn_chuong7:
                intent= new Intent(getActivity(), HHHCChuong7.class);
                startActivity(intent);
                break;
            case R.id.btn_chuong8:
                intent= new Intent(getActivity(), HHHCChuong8.class);
                startActivity(intent);
                break;
            case R.id.btn_chuong9:
                intent= new Intent(getActivity(),HHHChuong9.class);
                startActivity(intent);
                break;
            case R.id.btn_chuong10:
                intent= new Intent(getActivity(), HHHCchuong10.class);
                startActivity(intent);
                break;
        }
    }
}
