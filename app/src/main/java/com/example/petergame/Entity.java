package com.example.petergame;

import android.graphics.Bitmap;
import android.graphics.Rect;

public abstract class Entity {
    private Rect rect, hitBox;
    private int posX, width;
    private int posY, height;
    private int floor;
    private int posInd;
    private int relPos;

    //Entity will know if its in air
    boolean falling = false;

    //Every Entity will have the left,right, and idle animation
    private Animation move1;
    private Animation move2;
    private Animation idle;
    private Animation current;
    private Animation previous;

    public Entity(){
        setRect(0,0,0,0);
    }//Enitity

    public void setHitBox(int left, int top, int right, int bottom){
        hitBox = new Rect(left, top, right, bottom);
    }//setHitBox

    public Rect getHitBox(){
        return hitBox;
    }//getHitBox

    public void setRect(int posX, int posY, int width, int height){
        setPosX(posX);
        setPosY(posY);
        setWidth(width);
        setHeight(height);

        rect = new Rect(posX, posY, posX + width, posY + height);
    }//setRect

    private void setPosX(int x){posX = x;}
    private void setPosY(int y){posY = y;}
    private void setWidth(int w){width = w;}
    private void setHeight(int h){height = h;}
    public void setEmpty(){setRect(0,0,0,0);}

    protected void setFalling(boolean falling){this.falling = falling;}

    public void setCurrentAnimation(Animation current){
        this.current = current;
    }// setCurrentAnimation

    public void setPreviousAnimation(Animation previous) {
        this.previous = previous;
    }

    protected void setIdle(Bitmap[] sprites, double aniTime){
        idle = new Animation(sprites, aniTime);
    }

    protected void setIdle(Animation idle){
        this.idle = idle;
    }//copy setIdle

    protected void setMove1(Bitmap[] sprites, double aniTime) {
        move1 = new Animation(sprites, aniTime);
    }

    protected void setMove1(Animation move1){
        this.move1 = move1;
    }//copy setMove1

    protected void setMove2(Bitmap[] sprites, double aniTime){
        move2 = new Animation(sprites, aniTime);
    }

    protected void setMove2(Animation move2){
        this.move2 = move2;
    }//copy setMove2

    protected void setFloor(int floor){
        this.floor = floor;
    }

    protected void setPosInd(int posInd){
        this.posInd = posInd;
    }

    protected void setRelPos(int pos){
        relPos = pos;
    }

    public void moveRelPos(int x){
        relPos += x;
    }

    /* Getter Methods */
    public Rect getRect(){
        return rect;
    }//getRect

    public int getPosX(){
        return posX;
    }//getPosX

    public int getPosY(){
        return posY;
    }//getPosY

    public int getWidth(){
        return width;
    }//getWidth

    public int getHeight(){
        return height;
    }

    public int getRelPos(){
        return relPos;
    }

    public boolean isFalling(){
        return falling;
    }

    public int getFloor(){
        return floor;
    }

    public int getPosInd(){
        return posInd;
    }

    public Animation getMove1(){
        return move1;
    }//getMove1

    public Animation getMove2(){
        return move2;
    }//getMove2

    public Animation getIdle(){
        return idle;
    }//getIdle

    public Animation getCurrentAnimation(){
        return current;
    }//getCurrentAnimation

    public Animation getPreviousAnimation(){
        return previous;
    }

    //All Entity subclasses should have a method that changes its x and y position
    public void move(int x, int y){
        posX += x;
        posY += y;

        //moveRelPos(x);

        getRect().offset(x, y);
        if((getHitBox() != null) && !getHitBox().isEmpty()){
            getHitBox().offset(x, y);
        }//if
    }

}//Entity
