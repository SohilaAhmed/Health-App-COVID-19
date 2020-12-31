package com.example.project;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

import com.daimajia.androidanimations.library.Techniques;
import com.viksaa.sssplash.lib.activity.AwesomeSplash;
import com.viksaa.sssplash.lib.cnst.Flags;
import com.viksaa.sssplash.lib.model.ConfigSplash;

public class splash extends AwesomeSplash {



    @Override
    public void initSplash(ConfigSplash configSplash) {
        ActionBar actionbar = getSupportActionBar();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        configSplash.setBackgroundColor(R.color.design_default_color_primary);
        configSplash.setAnimCircularRevealDuration(3000);
        configSplash.setRevealFlagX(Flags.REVEAL_LEFT);
        configSplash.setRevealFlagX(Flags.REVEAL_BOTTOM);
        configSplash.setTitleSplash("Welcome to our AntiCorona Virus");
        configSplash.setTitleTextColor(R.color.white);
        configSplash.setTitleTextSize(25f);
        configSplash.setAnimLogoSplashDuration(3000);
        configSplash.setAnimTitleTechnique(Techniques.FlipInX);


    }

    @Override
    public void animationsFinished() {
        startActivity(new Intent(splash.this , MainActivity.class));

    }
}