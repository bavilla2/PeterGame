package com.example.petergame;

public class Officer extends Obstacles {

    private Animate walk;

    public Officer(int posX, int posY, int speedX){
        super(posX, posY, (Constants.SCREEN_WIDTH/15), (Constants.SCREEN_HEIGHT/5), 0);
        walk = new Animate(1, 1);
    }//Constructor
    public Animate getWalk(){return walk;}
}//Officer Class
