package com.cambrian.flappychicken;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import com.cambrian.flappychicken.model.Constant;

/**
 * @author Alistair Chambers
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //makes the activity full screen
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //gets the screen size and store it in constant class
        DisplayMetrics displayMetrics = new DisplayMetrics();
        this.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        Constant.SCREEN_WIDTH = displayMetrics.widthPixels;
        Constant.SCREEN_HEIGHT = displayMetrics.heightPixels;

        setContentView(R.layout.activity_main);
    }

}