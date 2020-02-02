package com.example.petergame;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

import java.util.Observable;
import java.util.Vector;

import static com.example.petergame.Constants.SCREEN_HEIGHT;
import static com.example.petergame.Constants.SCREEN_WIDTH;
import static com.example.petergame.Constants.runSpeed;


public class World {
    private boolean endGame;

    private Peter peter;
    private Vector<Obstacles> obstacles = new Vector<>(10);
    private Vector<Buildings> buildings = new Vector<>(3);
    private BikeRider bike;
    private Officer officer;
    private Skater skater;
    private Buildings eTower, library, subway;


    /*Constructor*/
    public World(){
        setEndGame(false);
        peter = new Peter((SCREEN_WIDTH/9), (SCREEN_HEIGHT/13) * 8, 0, 0);
        peter.setCurrentAnimation(peter.getWalk());
        peter.getCurrentAnimation().startAnimation();

        bike = new BikeRider((SCREEN_WIDTH/7)*2, ((SCREEN_HEIGHT/7)*4) + (SCREEN_HEIGHT/9) - (SCREEN_HEIGHT/10), -(runSpeed));
        bike.getWalk().startAnimation();

        officer = new Officer((SCREEN_WIDTH/4), ((SCREEN_HEIGHT/7)*4) + (SCREEN_HEIGHT/9) - (SCREEN_HEIGHT/10), -(runSpeed));
        officer.getWalk().startAnimation();

        skater = new Skater((SCREEN_WIDTH/2), ((SCREEN_HEIGHT/7)*4) + (SCREEN_HEIGHT/9) - (SCREEN_HEIGHT/10), -(runSpeed));
        skater.getWalk().startAnimation();

        buildings.add(new Buildings(SCREEN_WIDTH, (SCREEN_HEIGHT/5)*2, SCREEN_WIDTH/3, SCREEN_HEIGHT/2, -(runSpeed/2)));
        buildings.add(new Buildings(2*SCREEN_WIDTH, (SCREEN_HEIGHT/6)*2, SCREEN_WIDTH/2, SCREEN_HEIGHT/2, -(runSpeed/2)));
        buildings.add(new Buildings(3*SCREEN_WIDTH, (SCREEN_HEIGHT/5)*2, SCREEN_WIDTH/3, SCREEN_HEIGHT/2, -(runSpeed/2)));
        buildings.get(0).getStill().startAnimation();
        buildings.get(1).getStill().startAnimation();
        buildings.get(2).getStill().startAnimation();

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

    public Vector<Buildings> getBuildings(){ return buildings;}

    public void decSpeed(){
        //for(int c = 0; c < getObstacles().size(); c++){
            //getObstacles().get(c).decSpeedX();
            getBike().decSpeedX();
            getOfficer().decSpeedX();
            getSkater().decSpeedX();
            for(int c = 0; c < getBuildings().size(); c++){
                buildings.get(c).decSpeedX();
            }
         // for
    } // decSpeed

}//World
