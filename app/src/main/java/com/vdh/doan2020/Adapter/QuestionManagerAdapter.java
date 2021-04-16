package com.vdh.doan2020.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.vdh.doan2020.Fragment.QuestionFragment;

public class QuestionManagerAdapter extends FragmentPagerAdapter {

    public QuestionManagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        QuestionFragment instance= new QuestionFragment();
        instance.setPageNumber(position+1);
        return instance;
    }

    @Override
    public int getCount() {
        return 30;
    }
}
