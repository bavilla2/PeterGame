package com.example.petergame;

import android.graphics.Bitmap;
import android.graphics.Rect;

public abstract class Entity {
    private Rect rect, hitBox;
    private int posX, posY;

    //Entity will know if its in air
    private boolean falling = false;

    //Every Entity will have a singular animation
    private Animate animation;


    public Entity(){ // Default Constructor
        rect.setEmpty();
    } // Entity

    public Entity(int posX, int posY, int width, int height){ // Constructor
        rect = new Rect(posX, posY, posX + width, posY + height);

        setPosX(posX);
        setPosY(posY);
    } // Entity

    public void setHitBox(int left, int top, int right, int bottom){
        hitBox = new Rect(left, top, right, bottom);
    }//setHitBox

    private void setPosX(int x){posX = x;}
    private void setPosY(int y){posY = y;}

    protected void setFalling(boolean falling){this.falling = falling;}


    /* Getter Methods */
    public Rect getRect(){
        return rect;
    }//getRect

    public Rect getHitBox(){
        return hitBox;
    }//getHitBox

    public int getPosX(){
        return posX;
    }//getPosX

    public int getPosY(){
        return posY;
    }//getPosY

    public int getWidth(){
        return rect.width();
    }//getWidth

    public int getHeight(){
        return rect.height();
    }

    public boolean isFalling(){
        return falling;
    }

    public Animate getAnimation(){
        return animation;
    } // getAnimation

    //All Entity subclasses should have a method that changes its x and y position
    public void move(int x, int y){
        setPosX(getPosX() + x);
        setPosY(getPosY() + y);

        getRect().offset(x, y);
        if((getHitBox() != null) && !getHitBox().isEmpty()){
            getHitBox().offset(x, y);
        }//if
    } // move

}//Entity
