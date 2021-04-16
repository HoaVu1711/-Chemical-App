package com.vdh.doan2020.Adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.vdh.doan2020.Fragment.LyThuyetHHHCFragment;
import com.vdh.doan2020.Fragment.LyThuyetHHVCFragment;

public class LyThuyetAdapter extends FragmentPagerAdapter {
    private String[] titles = {"Lý Thuyết Vô Cơ", "Lý Thuyết Hữu Cơ"};
    public LyThuyetAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new LyThuyetHHVCFragment();
            case 1:
                return  new LyThuyetHHHCFragment();
        }
        return null;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }

    @Override
    public int getCount() {
        return 2;
    }
}
