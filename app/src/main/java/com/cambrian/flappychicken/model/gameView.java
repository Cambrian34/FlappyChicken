package com.cambrian.flappychicken.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

import com.cambrian.flappychicken.R;

import java.util.ArrayList;

public class gameView extends View {
    private Player player;
    //handler and runnable
    private Handler handler;
    private Runnable runnable;

    public gameView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
      // player = new Player(100*Constant.SCREEN_WIDTH/1000 ,Constant.SCREEN_HEIGHT/2-player.getHeight()/2,100*Constant.SCREEN_WIDTH/1000,100*Constant.SCREEN_HEIGHT/1000);
       //ArrayList<Bitmap> images = new ArrayList<>();
      // images.add(BitmapFactory.decodeResource(this.getResources(), R.drawable.ic_launcher_foreground));
       //player.setImages(images);
        player = new Player();

        player.setWidth(100*Constant.SCREEN_WIDTH/1080);
        player.setHeight(100*Constant.SCREEN_HEIGHT/1920);

        player.setX( (100 * Constant.SCREEN_WIDTH) /1000);
        player.setY( Constant.SCREEN_HEIGHT /2-  player.getHeight() /2);

        ArrayList<Bitmap> images = new ArrayList<>();
        Bitmap bitmap1 = BitmapFactory.decodeResource(this.getResources(), R.drawable.rooster);
        if (bitmap1 != null) {
            images.add(bitmap1);
        }

        Bitmap bitmap2 = BitmapFactory.decodeResource(this.getResources(), R.drawable.rooster);
        if (bitmap2 != null) {
            images.add(bitmap2);
        }
        player.setImagesbm(images);

        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                //player.setY(player.getY() + 10);
                invalidate();
            }
            };

    }
    public void draw(Canvas canvas){
        super.draw(canvas);

        player.draw(canvas);
        handler.postDelayed(runnable, 10);

    }
    //jump
   public boolean onTouchEvent(MotionEvent event){
        if (event.getAction() == MotionEvent.ACTION_DOWN){
            player.setGravity(-15);
        }
        return true;
    }
}
