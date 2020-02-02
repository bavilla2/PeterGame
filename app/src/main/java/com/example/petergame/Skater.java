package com.example.petergame;

import android.view.animation.Animation;

public class Skater extends Obstacles{

    private Animate walk;

    public Skater(int posX, int posY, int speedX){
        super(posX, posY, (Constants.SCREEN_WIDTH/7), (Constants.SCREEN_HEIGHT/10), 0);
        walk = new Animate(2, 0.5);
        setHitBox(posX, posY, (Constants.SCREEN_WIDTH/7), (Constants.SCREEN_HEIGHT/10));
    }
    public Animate getWalk(){return walk;}
}
