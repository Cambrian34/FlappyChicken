package com.cambrian.flappychicken.model;

import android.graphics.Bitmap;
import android.graphics.Rect;

public class Objects {
    protected float x;
    protected float y;
    protected int width;
    protected int height;
    protected Bitmap image;
    protected Rect obj;

    public Objects(){

    }

    public Objects(float x, float y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public Rect getObj() {
        return new Rect((int)this.x, (int)this.y, (int)this.x + this.width, (int)this.y + this.height);
    }

    public void setObj(Rect obj) {
        this.obj = obj;
    }
}
