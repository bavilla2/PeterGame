package com.example.petergame;

public class Officer extends Obstacles {

    private Animate walk;

    public Officer(int posX, int posY, int speedX){
        super(posX, posY, (Constants.SCREEN_WIDTH/15), (Constants.SCREEN_HEIGHT/5), speedX);
        walk = new Animate(1, 1);
        setHitBox(posX, posY, (Constants.SCREEN_WIDTH/15), (Constants.SCREEN_HEIGHT/5));
        setAnimation(getWalk());
    }//Constructor

    public Officer(Officer obs){
        super(Constants.SCREEN_WIDTH - (obs.getWidth()/90), obs.getPosY(), obs.getWidth(), obs.getHeight(), obs.getSpeedX());
        setAnimation(obs.getWalk());
        setHitBox(getPosX() + (getWidth()/3), getPosY() + (getHeight()/4), getPosX() + ((getWidth()*2)/3), getPosY() + ((getHeight()*3)/4));
    }

    public Animate getWalk(){return walk;}
}//Officer Class
