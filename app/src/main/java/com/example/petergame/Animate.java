package com.example.petergame;

import android.graphics.Bitmap;

public class Animate {

    /* Class Variables */
    private Bitmap spriteSheet; // Holds the frames of animation on an image sheet
    private int frames; // number of frames within sprite sheet
    private int frameIndex; // index to distinguish the current frame
    private boolean animating; // used to check if object animation is currently running
    private double startTime; // stamps the start time of animation
    private double timePerFrame; // length of time each frame is displayed

    private final double timeConvert = 1000; // used to convert milliseconds to  seconds

    /* Class Methods */
    public Animate(Bitmap spriteSheet, int frames, double animationTime){ // Constructor
        setSpriteSheet(spriteSheet);
        setFrames(frames);
        setTPF(animationTime);
        setStartTime();
    } // Constructor

    /* Private Methods */
    private void setSpriteSheet(Bitmap spriteSheet){ // stores sprite sheet to this object
        this.spriteSheet = spriteSheet;
    } // setSpriteSheet

    private void setFrames(int frames){ // sets the number of frames in sprite sheet
        this.frames = frames;
    } // setFrames

    private int getFrames(){ // retrieves number of frames in this animation
        return frames;
    } // getFrames

    private void setTPF(double animationTime){ // sets time per frame
        timePerFrame = (animationTime / (double) getFrames()) * timeConvert ;
    }// setTPS

    private void setStartTime(){ // stamps the start time in milli seconds
        startTime = System.currentTimeMillis();
    }// setStartTime

    private double getStartTime(){ // retrieves start time
        return startTime;
    } // getStartTime

    private void setFrameIndex(int frameIndex){ // assigns a value to frameIndex
        this.frameIndex = frameIndex;
    }// setFrameIndex

    /* Public Methods */
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


