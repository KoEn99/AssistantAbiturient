package com.example.assistantabiturient;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.assistantabiturient.Adapter.SlideAdapter;
import com.example.assistantabiturient.Fragments.PageFragment;
import com.example.assistantabiturient.Fragments.PageFragment2;
import com.example.assistantabiturient.Fragments.PageFragment3;
import com.example.assistantabiturient.Fragments.PageFragment4;
import com.example.assistantabiturient.Fragments.PageFragmentExit;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private SlideAdapter slideAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(new PageFragment4());
        fragmentList.add(new PageFragment());
        fragmentList.add(new PageFragment2());
        fragmentList.add(new PageFragment3());
        fragmentList.add(new PageFragmentExit());
        viewPager = findViewById(R.id.viewpager);
        slideAdapter = new SlideAdapter(getSupportFragmentManager(), fragmentList);
        viewPager.setAdapter(slideAdapter);
    }
}
