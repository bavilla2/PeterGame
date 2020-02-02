package com.example.petergame;

import android.graphics.BitmapFactory;

public class Peter extends Entity {
    public int points;
    private int jumpSpeed;
    private int jumpOrigin;
    private boolean jumping;
    private Animate damage;
    private Animate jump;
    private Animate fall;
    private Animate walk;

    //Constructor
    public Peter(int posX, int posY, int speedX, int speedY){
       super(posX, posY, Constants.SCREEN_WIDTH/10, Constants.SCREEN_HEIGHT/6, 0, speedY);
       jump = new Animate(2, 1);
       damage = new Animate(4, 1);
       fall = new Animate(2, 1);
       walk = new Animate(6, 0.5);
       setPoints(0);
       //setJumpSpeed((getHeight()/-7));
        setJumpOrigin((getPosY()));
       setHitBox(posX + (getWidth()/10), posY + (getHeight()/10), posX+(9 * getWidth()/10), posY + (9 * getHeight()/10));
       // setCurrentAnimation(getIdle());
    }//Peter

    /*Private Methods*/
    private void setPoints(int points){this.points = points;}
    public int getPoints(){return points;}
    private void addPoints(int points){this.points += points;}
    //private void setJumpSpeed(int jumpHeight){this.jumpSpeed = jumpHeight;}
    private void setJumpOrigin(int jumpHeight){this.jumpOrigin = jumpHeight;}
    public int getJumpOrigin(){return jumpOrigin;}


    /*Public Methods*/
    public boolean inAir = false;
    public void Jumping(boolean jumping){this.jumping = jumping;}
    public boolean isJumping(){return jumping;}
    public int getJumpSpeed(){return jumpSpeed;}
    public Animate getJump(){return jump;}
    public Animate getFall(){return fall;}
    public Animate getDamage(){return damage;}
    public Animate getWalk(){return walk;}

}//Peter class
