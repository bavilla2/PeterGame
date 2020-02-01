package com.example.petergame;

public class BikeRider extends Obstacles{
    public BikeRider(int posX, int posY, int speedX){
        super(posX, posY, (Constants.SCREEN_WIDTH/7), (Constants.SCREEN_HEIGHT/10), 0);
        setHitBox(posX, posY, (Constants.SCREEN_WIDTH/7), (Constants.SCREEN_HEIGHT/10));
    }
}
