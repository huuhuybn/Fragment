package com.example.fragment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TabLayout tb = findViewById(R.id.tabs);
        tb.setTabMode(TabLayout.MODE_SCROLLABLE);
        ViewPager2 pager2 = findViewById(R.id.pagers);
        BlankFragmentAdapter adapter = new BlankFragmentAdapter(this);
        pager2.setAdapter(adapter);
        // liên kết tablayout vs viewpager
        // set tiêu đề cho tab
        new TabLayoutMediator(tb, pager2, (tab, position) -> {
            tab.setText("Tab " + position + new Random().nextInt());
        }).attach();



        FragmentManager fm = getSupportFragmentManager();
        BlankFragment blank = new BlankFragment();
        fm.beginTransaction().add(R.id.container,blank,"BLANK").commit();
        findViewById(R.id.btnHeyFragment).setOnClickListener(v ->{

            // tim ra fragment theo id
            Fragment fra = getSupportFragmentManager()
                    .findFragmentByTag("BLANK");
            if (fra != null){
                ((BlankFragment)fra)
                        .tvView.setText("HELLO");
            }

        });
    }
}