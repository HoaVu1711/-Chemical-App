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
import com.vdh.doan2020.UI.HHVCChuong1;
import com.vdh.doan2020.UI.HHVCChuong2;
import com.vdh.doan2020.UI.HHVCChuong3;
import com.vdh.doan2020.UI.HHVCChuong4;
import com.vdh.doan2020.UI.HHVCChuong6;
import com.vdh.doan2020.UI.HHVCchuong5;
import com.vdh.doan2020.UI.HHVCchuong7;

public class LyThuyetHHVCFragment extends Fragment implements View.OnClickListener {
    private static LyThuyetHHVCFragment INSTANCE;
    private Button btn1, btn2, btn3, btn4, btn5, btn6, btn7;
    private View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_lythuyethhvc, container, false);
        anhXa();
        return view;
    }

    public static LyThuyetHHVCFragment getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new LyThuyetHHVCFragment();
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
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        this.view=view;
        switch (view.getId()) {
            case R.id.btn_chuong1:
                intent= new Intent(getActivity(), HHVCChuong1.class);
                startActivity(intent);
                break;
            case R.id.btn_chuong2:
                intent= new Intent(getActivity(), HHVCChuong2.class);
                startActivity(intent);
                break;
            case R.id.btn_chuong3:
                intent= new Intent(getActivity(), HHVCChuong3.class);
                startActivity(intent);
                break;
            case R.id.btn_chuong4:
                intent= new Intent(getActivity(), HHVCChuong4.class);
                startActivity(intent);
                break;
            case R.id.btn_chuong5:
                intent= new Intent(getActivity(), HHVCchuong5.class);
                startActivity(intent);
                break;
            case R.id.btn_chuong6:
                intent= new Intent(getActivity(), HHVCChuong6.class);
                startActivity(intent);
                break;
            case R.id.btn_chuong7:
                intent= new Intent(getActivity(), HHVCchuong7.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
