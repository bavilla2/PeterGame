package com.example.petergame;

public class BikeRider extends Obstacles{

    private Animate walk;

    public BikeRider(int posX, int posY, int speedX){
        super(posX, posY, (Constants.SCREEN_WIDTH/7), (Constants.SCREEN_HEIGHT/10), 0);
        walk = new Animate(3, 0.5);
        //setHitBox(posX, posY, (Constants.SCREEN_WIDTH/7), (Constants.SCREEN_HEIGHT/10));
    }

    public Animate getWalk(){return walk;}
}
