package com.example.petergame;

public class Peter extends Entity {
    public int points;
    private int jumpSpeed;
    private boolean jumping;
    private Animate damage;
    private Animate jump;

    //Constructor
    public Peter(int posX, int posY, int speedX, int speedY){
       super(posX, posY, Constants.SCREEN_WIDTH/9, Constants.SCREEN_HEIGHT/3, 0, speedY);
       setPoints(0);
       setJumpSpeed((getHeight()/-7));
       setHitBox(posX + (getWidth()/10), posY + (getHeight()/10), posX+(9 * getWidth()/10), posY + (9 * getHeight()/10));

      // setCurrentAnimation(getIdle());
    }//Peter

    /*Private Methods*/
    private void setPoints(int points){this.points = points;}
    public int getPoints(){return points;}
    private void addPoints(int points){this.points += points;}
    private void setJumpSpeed(int jumpHeight){this.jumpSpeed = jumpHeight;}


    /*Public Methods*/
    public boolean inAir = false;
//    public void Jumping(boolean jumping){this.jumping = jumping;}
//    public boolean isJumping(){return jumping;}
    public int getJumpSpeed(){return jumpSpeed;}


}//Peter class
