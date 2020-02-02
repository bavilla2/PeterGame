package com.example.petergame;

public class Buildings extends Entity {

    private Animate still;

    public Buildings(int posX, int posY, int width, int height, int speedX){
        super(posX, posY, width, height, speedX, 0);

        still = new Animate(1, 1);
        setAnimation(still);
    }

    public Animate getStill(){
        return still;
    };
}
