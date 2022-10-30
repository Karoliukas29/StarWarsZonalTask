package com.zonal.starwars.view.welcomescreen.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import com.zonal.starwars.base.BaseActivity;
import com.zonal.starwars.databinding.ActivityMainBinding;

public class StartActivity extends BaseActivity<ActivityMainBinding>{

    @Override
    protected ActivityMainBinding getBinding() {
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        return binding;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getDecorView()
                .setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        getWindow().setStatusBarColor(Color.TRANSPARENT);

    }
}
