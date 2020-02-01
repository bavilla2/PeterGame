package com.example.petergame;

public class Peter extends Entity {
    public int points;
    private int jumpHeight;
    private boolean jumping;
    private Animate damage;
    private Animate jump;

    //Constructor
    public Peter(int posX, int posY){
       super(posX, posY, Constants.SCREEN_WIDTH/9, Constants.SCREEN_HEIGHT/3);
       setPoints(0);
       setJumpHeight(posY - (6*getHeight()/5));
       setHitBox(posX + (getWidth()/10), posY + (getHeight()/10), posX+(9 * getWidth()/10), posY + (9 * getHeight()/10));

      // setCurrentAnimation(getIdle());
    }//Peter

    /*Private Methods*/
    private void setPoints(int points){this.points = points;}
    public int getPoints(){return points;}
    private void addPoints(int points){this.points += points;}
    private void setJumpHeight(int jumpHeight){this.jumpHeight = jumpHeight;}


    /*Public Methods*/
    public void Jumping(boolean jumping){this.jumping = jumping;}
    public boolean isJumping(){return jumping;}
    public int getJumpHeight(){return jumpHeight;}


}//Peter class
