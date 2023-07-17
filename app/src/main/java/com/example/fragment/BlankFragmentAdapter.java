package com.example.fragment;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class BlankFragmentAdapter extends FragmentStateAdapter {

    public BlankFragmentAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return new BlankFragment();
    }

    @Override
    public int getItemCount() {
        return 30;
    }
}
