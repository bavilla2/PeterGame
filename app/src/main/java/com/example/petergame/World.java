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
    private BikeRider bike;
    private Officer officer;
    private Skater skater;

    /*Constructor*/
    public World(){
        setEndGame(false);
        peter = new Peter((SCREEN_WIDTH/9), (SCREEN_HEIGHT/13) * 8, 0, 0);
        peter.setCurrentAnimation(peter.getWalk());
        peter.getCurrentAnimation().startAnimation();

        bike = new BikeRider((SCREEN_WIDTH/7)*2, ((SCREEN_HEIGHT/7)*4) + (SCREEN_HEIGHT/9) - (SCREEN_HEIGHT/10), -10);
        bike.getWalk().startAnimation();

        officer = new Officer((SCREEN_WIDTH/4), ((SCREEN_HEIGHT/7)*4) + (SCREEN_HEIGHT/9) - (SCREEN_HEIGHT/10), -10);
        officer.getWalk().startAnimation();

        skater = new Skater((SCREEN_WIDTH/2), ((SCREEN_HEIGHT/7)*4) + (SCREEN_HEIGHT/9) - (SCREEN_HEIGHT/10), -10);
        skater.getWalk().startAnimation();
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
    public Peter getPeter(){ return peter; }//getPeter

    /*Makes bike rack accessible to other classes*/
    public BikeRider getBike(){ return bike; }//getBike

    public Officer getOfficer(){ return officer; }

    public Skater getSkater(){return skater;}

    /*Makes obstacles accessible to other classes*/
    public Vector<Obstacles> getObstacles(){ return obstacles; }//getObstacles

}//World
