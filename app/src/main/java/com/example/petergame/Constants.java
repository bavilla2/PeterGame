package com.example.petergame;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;

public class Constants {
    public static final int SCREEN_HEIGHT = Resources.getSystem().getDisplayMetrics().widthPixels;
    public static final int SCREEN_WIDTH = Resources.getSystem().getDisplayMetrics().heightPixels;

    public static Context CURRENT_CONTEXT;

    //Sprites for the Level
    public static Bitmap[] level = new Bitmap[3];

    //Sprites for future obstacles
    public static Bitmap[] obstacle1 = new Bitmap[1];

    //Sprites for Peter
    public static Bitmap peterSprite;
    public static Bitmap[] peterIdle = new Bitmap[1];
    public static Bitmap[] peterIdleLeft = new Bitmap[1];
    public static Bitmap[] peterWalk = new Bitmap[4];
    public static Bitmap[] peterWalkLeft = new Bitmap[4];
    public static Bitmap[] peterHit = new Bitmap[1];
    public static Bitmap[] peterJump = new Bitmap[1];
    public static Bitmap[] peterJumpLeft = new Bitmap[1];

    //Sprites for Skater
    public static Bitmap skaterSprite;

    //Sprites for Biker
    public static Bitmap bikerSprite;

    //Sprites for Officer
    public static Bitmap officerSprite;
}
