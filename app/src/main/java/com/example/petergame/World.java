package com.example.petergame;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

import java.util.Observable;
import java.util.Vector;

import static com.example.petergame.Constants.SCREEN_HEIGHT;
import static com.example.petergame.Constants.SCREEN_WIDTH;


public class World {
    private boolean endGame;

    private Peter peter;
    private Vector<Obstacles> obstacles = new Vector<>(10);
    private BikeRider br;
    private Officer officer;
    //private Skater skater;

    /*Constructor*/
    public World(){
        setEndGame(false);
        peter = new Peter((SCREEN_WIDTH/9), (SCREEN_HEIGHT/4)*2);
        br = new BikeRider((SCREEN_WIDTH/7), ((SCREEN_HEIGHT/4)*2) + (Constants.SCREEN_HEIGHT/3) - (Constants.SCREEN_HEIGHT/10), 0);
        officer = new Officer((SCREEN_WIDTH/7), ((SCREEN_HEIGHT/4)*2) + (SCREEN_HEIGHT/3) - (SCREEN_HEIGHT/10), 0);
    }//World Constructor

    /*Sets the end of the game*/
    public void setEndGame(boolean endGame){
        this.endGame = endGame;
    }//setEndGame

    /*Returns the status of endgame*/
    public boolean isEndGame(){
        return endGame;
    }//isEndGame

    /*Makes Peter accessible to other classes*/
    public Peter getPeter(){
        return peter;
    }//getPeter

    /*Makes bike rack accessible to other classes*/
    public BikeRider getBike(){
        return br;
    }//getBike

    /*Makes obstacles accessible to other classes*/
    public Vector<Obstacles> getObstacles(){
        return obstacles;
    }//getObstacles

    /*draws onto our canvas*/
    public void draw(Canvas cam){
        Paint p = new Paint();
        Paint bikeColor = new Paint();
        Paint hitBoxColor = new Paint();

        int color;
        int color2;
        int color3;

        color = Color.BLACK;
        color2 = Color.RED;
        color3 = Color.GREEN;

        p.setColor(color);
        bikeColor.setColor(color2);
        hitBoxColor.setColor(color3);

        cam.drawRect(peter.getRect(), p);
        cam.drawRect(peter.getHitBox(), hitBoxColor);

        for(int c = 0; c < getObstacles().size(); c++){
            if(getObstacles().get(c) != null) {
                /*if (getObstacles().get(c) instanceof BikeRider) {
                    cam.drawRect(getObstacles().get(c).getRect(), bikeColor);
                } /*else if (getObstacles().get(c) instanceof Pole) {
                    cam.drawRect(getObstacles().get(c).getRect(), poleColor);
                }// if/elif/elif*/
            }//if
        }//for

        cam.drawBitmap(Constants.peterSprite, null, peter.getRect(), new Paint());
    }//draw
}//World
