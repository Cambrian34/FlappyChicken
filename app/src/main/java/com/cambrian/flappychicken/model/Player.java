package com.cambrian.flappychicken.model;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;

import java.util.ArrayList;

public class Player extends Objects{
    private ArrayList<Bitmap> imagesbm = new ArrayList<>();
    //count for animation
    private int count,  VFLAP,idcurrbm;
    //gravity
    private float gravity;

    public Player() {
        super();
        //speed of animation
        this.count = 0;
        this.VFLAP = 10;
        this.idcurrbm = 0;
        this.gravity = 0;

    }


    public void draw(Canvas canvas){
        gravity();
        canvas.drawBitmap(this.getImage(),this.x,this.y,null);
    }

    private void gravity() {
        // Set lower limit to stop the player from falling
        if (this.y + this.height > Constant.SCREEN_HEIGHT) {
            this.y = Constant.SCREEN_HEIGHT - this.height;
            // Handle player hitting the ground (e.g., stop falling, play sound)
        } else if (this.y < 0) {
            // Set upper limit to prevent player from going off screen
            this.y = 0;
            // Handle player hitting the top (e.g., reverse direction, play sound)
        } else {
            // Apply gravity acceleration
            this.gravity += Constant.GRAVITY_ACCELERATION;
            this.y += this.gravity;
        }
    }

    public ArrayList<Bitmap> getImagesbm() {
        return imagesbm;
    }

    /*public void setImagesbm(ArrayList<Bitmap> imagesbm) {
        this.imagesbm = imagesbm;
        for (int i = 0; i < imagesbm.size(); i++) {

                this.imagesbm.set(i,Bitmap.createScaledBitmap(this.imagesbm.get(i),  this.width,  this.height, true));

        }
    }*/
    public void setImagesbm(ArrayList<Bitmap> imagesbm) {
        this.imagesbm = imagesbm;

        for (int i = 0; i < imagesbm.size(); i++) {
            Bitmap originalBitmap = imagesbm.get(i);
            if (originalBitmap != null) {
                Bitmap scaledBitmap = Bitmap.createScaledBitmap(originalBitmap, this.width, this.height, true);
                imagesbm.set(i, scaledBitmap);
            }
        }
    }

    @Override
    public Bitmap getImage() {
        count++;//
        //animate the player images
        if (this.count == this.VFLAP) {
            for (int i = 0; i < this.imagesbm.size(); i++) {
                if (i == this.imagesbm.size() - 1) {
                    this.idcurrbm = 0;
                    break;
                } else if (i == this.idcurrbm) {
                    this.idcurrbm++;
                    break;
                }
            }

            count = 0;
        }
        //rotate the Bitmap
        if (this.gravity < 0) {
            Matrix matrix = new Matrix();
            matrix.postRotate(-25);
            return Bitmap.createBitmap(this.imagesbm.get(this.idcurrbm), 0, 0, this.imagesbm.get(this.idcurrbm).getWidth(), this.imagesbm.get(this.idcurrbm).getHeight(), matrix, true);
        } else if (gravity >=0) {
            Matrix matrix = new Matrix();
            if (this.gravity < 60) {
                matrix.postRotate(-25+(this.gravity*2));
            } else {
                matrix.postRotate(45);
            }
            return Bitmap.createBitmap(this.imagesbm.get(this.idcurrbm), 0, 0, this.imagesbm.get(this.idcurrbm).getWidth(), this.imagesbm.get(this.idcurrbm).getHeight(), matrix, true);


        }
        return this.imagesbm.get(this.idcurrbm);
    }

    public float getGravity() {
        return gravity;
    }

    public void setGravity(float gravity) {
        this.gravity = gravity;
    }
}
