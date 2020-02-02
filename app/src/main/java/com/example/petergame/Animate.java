package com.example.petergame;

import android.graphics.Bitmap;

public class Animate {

    /* Class Variables */
    private Bitmap spriteSheet; // holds the sheet that contains all frames
    private Bitmap[] sprites; // Holds the frames of animation
    private int frameIndex; // index to distinguish the current frame
    private boolean animating; // used to check if object animation is currently running
    private double startTime; // stamps the start time of animation
    private double timePerFrame; // length of time each frame is displayed

    private final double timeConvert = 1000; // used to convert milliseconds to  seconds

    /* Class Methods */
    public Animate(int frames, double animationTime){ // Constructor
        createSpriteArray(frames);
        setTPF(animationTime);
        setStartTime();
    } // Constructor

    /* Private Methods */
    public void setSpriteSheet(Bitmap spriteSheet){ // stores sprite sheet to this object
        this.spriteSheet = spriteSheet;
    } // setSpriteSheet

    private void createSpriteArray(int frames){ // creates bitmap array that holds frames
        sprites = new Bitmap[frames];
    } // createSpriteArray

    private void setTPF(double animationTime){ // sets time per frame
        timePerFrame = (animationTime / (double) length()) * timeConvert ;
    } //

    private double getTPF(){ // returns timePerFrame
        return timePerFrame;
    } // getTPF

    public Bitmap getSpriteSheet(){return spriteSheet;}

    private void setStartTime(){ // stamps the start time in milli seconds
        startTime = System.currentTimeMillis();
    }// setStartTime

    private double getStartTime(){ // retrieves start time
        return startTime;
    } // getStartTime

    private void setFrameIndex(int frameIndex){ // assigns a value of current frame to frameIndex
        this.frameIndex = frameIndex;
    } // setFrameIndex

    private int getFrameIndex(){ // returns the index of the current frame
        return frameIndex;
    } // getFrameIndex

    private void update(){
        double dTime = System.currentTimeMillis() - getStartTime();
        if(isAnimating() && (dTime > getTPF()) ){
            setFrameIndex(++frameIndex % length());
            setStartTime();
        } // if
    } // update

    /* Public Methods */
    public int length(){ // retrieves number of frames in this animation
        return sprites.length;
    } // getFrames

    public void insertFrame(Bitmap frame, int index){ // places a frame in the sprite array at the given index
       sprites[index] = frame;
    } // insertFrame

    public Bitmap getCurrentFrame(){
        return sprites[getFrameIndex()];
    } // getCurrentFrame

    public boolean isAnimating(){ // methods that checks if the animation is running
        return animating;
    } // isAnimating

    public void startAnimation(){ // starts the animation
        setFrameIndex(0);
        setStartTime();
        animating = true;
    } // startAnimation

    public void stopAnimation(){ // stops the animation
        animating = false;
    } // stopAnimation


}// Animate

/* EOF */


