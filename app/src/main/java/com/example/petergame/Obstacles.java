package com.example.petergame;

public class Obstacles extends Entity {

    private Animate walk;

    public Obstacles(int posX, int posY, int width, int height, int speedX){
        super(posX, posY, width, height, speedX, 0);
    }//Obstacles

    public Obstacles(Obstacles obs){
        super(obs.getPosX(), obs.getPosY(), obs.getWidth(), obs.getHeight(), obs.getSpeedX(), 0);
        this.setAnimation(obs.getAnimation());
    }

    public Animate getWalk(){return walk;}

}//class obstacles
