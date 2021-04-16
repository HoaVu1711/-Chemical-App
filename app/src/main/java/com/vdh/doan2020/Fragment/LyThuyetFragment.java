package com.vdh.doan2020.Fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.vdh.doan2020.Adapter.LyThuyetAdapter;
import com.vdh.doan2020.R;

public class LyThuyetFragment extends Fragment {
    private static LyThuyetFragment INSTANCE;
    private ViewPager viewPagerLyThuyet;
    private TabLayout tabLyThuyet;
    private View view;
    private LyThuyetAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.view=inflater.inflate(R.layout.fragment_lythuyet,container,false);
        anhXa();
        adapter= new LyThuyetAdapter(getFragmentManager());
        tabLyThuyet.setupWithViewPager(viewPagerLyThuyet);
        viewPagerLyThuyet.setAdapter(adapter);
        tabLyThuyet.setBackgroundColor(Color.LTGRAY);
        return view;
    }

    private void anhXa() {
        viewPagerLyThuyet=view.findViewById(R.id.vp_lythuyet);
        tabLyThuyet=view.findViewById(R.id.tb_lythuyet);
    }

    public static LyThuyetFragment getINSTANCE(){
        if(INSTANCE==null){
            INSTANCE= new LyThuyetFragment();
        }
        return INSTANCE;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewPagerLyThuyet.setAdapter(new LyThuyetAdapter(getChildFragmentManager()));
    }
}
