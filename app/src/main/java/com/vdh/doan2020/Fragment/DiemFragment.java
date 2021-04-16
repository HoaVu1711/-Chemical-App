package com.vdh.doan2020.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.vdh.doan2020.Adapter.DiemAdapter;
import com.vdh.doan2020.DataBase.DatabaseAccess;
import com.vdh.doan2020.Model.Diem;
import com.vdh.doan2020.R;

import java.util.ArrayList;
import java.util.List;
import java.util.PrimitiveIterator;

public class DiemFragment extends Fragment {
    private static  DiemFragment INSTANCE;
    private List<Diem>diemList;
    private DiemAdapter adapter;
    private DatabaseAccess access;
    private RecyclerView recyclerView;
    private  View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.view=inflater.inflate(R.layout.fragment_diem,container,false);
        anhXa();
        access.open();
        diemList=access.getDiem();
        adapter= new DiemAdapter(view.getContext(),diemList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        return view;
    }

    private void anhXa() {
        recyclerView=view.findViewById(R.id.rv_diem);
        diemList=new ArrayList<>();
        access=DatabaseAccess.getInstance(view.getContext());
    }


    public static  DiemFragment getINSTANCE(){
        if(INSTANCE==null){
            INSTANCE=new DiemFragment();
        }
        return INSTANCE;
    }
}
