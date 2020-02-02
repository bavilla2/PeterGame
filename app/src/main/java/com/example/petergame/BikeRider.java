package com.example.petergame;

public class BikeRider extends Obstacles{

    private Animate walk;

    public BikeRider(int posX, int posY, int speedX){
        super(posX, posY, (Constants.SCREEN_WIDTH/10), (Constants.SCREEN_HEIGHT/5), speedX);
        walk = new Animate(3, 0.5);
        setAnimation(getWalk());
        //setHitBox(posX, posY, (Constants.SCREEN_WIDTH/7), (Constants.SCREEN_HEIGHT/10));
    }

    public Animate getWalk(){return walk;}
}
