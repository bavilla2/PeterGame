package com.example.petergame;

import android.view.animation.Animation;

public class Skater extends Obstacles{

    private Animate walk;

    public Skater(int posX, int posY, int speedX){
        super(posX, posY, (Constants.SCREEN_WIDTH/10), (Constants.SCREEN_HEIGHT/5), speedX);
        walk = new Animate(2, 0.5);
        setAnimation(getWalk());
        setHitBox(posX, posY, (Constants.SCREEN_WIDTH/7), (Constants.SCREEN_HEIGHT/10));
    }

    public Skater(Skater obs){
        super(Constants.SCREEN_WIDTH - obs.getWidth(), obs.getPosY(), obs.getWidth(), obs.getHeight(), obs.getSpeedX());
        setAnimation(obs.getWalk());
    }

    public Animate getWalk(){return walk;}
}
