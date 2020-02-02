package com.example.petergame;

public class Buildings extends Entity {

    private Animate still;

    public Buildings(int posX, int posY, int width, int height, int speedX){
        super(posX, posY, width, height, speedX, 0);

        still = new Animate(1, 1);
        setAnimation(still);
    }

    public Buildings (Buildings build){
        super(3*Constants.SCREEN_WIDTH, build.getPosY(), build.getWidth(), build.getHeight(), build.getSpeedX(), 0);

        this.still = build.getStill();
        setAnimation(still);
    }

    public Animate getStill(){
        return still;
    };
}
