package com.example.petergame;

import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    private ConstraintLayout screenConstraint = null;
    TextView scoreView;
    int peterHeight, peterWidth;
    int peterWalkHeight, peterWalkWidth;
    int bikerHeight, bikerWidth;
    int officerHeight, officerWidth;
    int skaterHeight, skaterWidth;
    public TextView getScoreView(){return scoreView;}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        scoreView = findViewById(R.id.points);
        scoreView.setText("Points: " + Integer.toString(Camera.getWorld().getPeter().getPoints()));

        Constants.CURRENT_CONTEXT = this;

        screenConstraint = findViewById(R.id.activity2Constraint);
        screenConstraint.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return false;
            }
        });

        /*Initializing all the sprite sheets for each individual object*/
        Camera.getWorld().getPeter().getWalk().setSpriteSheet(BitmapFactory.decodeResource(getResources(), R.drawable.peter));
        peterWalkHeight = Camera.getWorld().getPeter().getWalk().getSpriteSheet().getHeight();
        peterWalkWidth = Camera.getWorld().getPeter().getWalk().getSpriteSheet().getWidth() / Camera.getWorld().getPeter().getWalk().length();
        for(int y = 0; y < Camera.getWorld().getPeter().getWalk().length(); y++){
            Camera.getWorld().getPeter().getWalk().insertFrame(Bitmap.createBitmap(Camera.getWorld().getPeter().getWalk().getSpriteSheet(), y*peterWalkWidth, 0, peterWalkWidth, peterWalkHeight), y);
        }//for

        /*Camera.getWorld().getPeter().getJump().setSpriteSheet(BitmapFactory.decodeResource(getResources(), R.drawable.jump));
        peterHeight = Camera.getWorld().getPeter().getJump().getSpriteSheet().getHeight();
        peterWidth = Camera.getWorld().getPeter().getJump().getSpriteSheet().getWidth() / Camera.getWorld().getPeter().getJump().length();
        for(int x = 0; x < Camera.getWorld().getPeter().getJump().length(); x++){
            Camera.getWorld().getPeter().getJump().insertFrame(Bitmap.createBitmap(Camera.getWorld().getPeter().getJump().getSpriteSheet(), x*peterWidth, 0, peterWidth, peterHeight), x);
        }//for*/

        /*Camera.getWorld().getBike().getAnimation().setSpriteSheet(BitmapFactory.decodeResource(getResources(), R.drawable.biker));
        bikerHeight = Camera.getWorld().getBike().getAnimation().getSpriteSheet().getHeight();
        bikerWidth = Camera.getWorld().getBike().getAnimation().getSpriteSheet().getWidth();
        for(int c = 0; c < Camera.getWorld().getBike().getAnimation().length(); c++){
            Camera.getWorld().getBike().getAnimation().insertFrame(Bitmap.createBitmap(Camera.getWorld().getBike().getAnimation().getSpriteSheet(), c*bikerWidth, 0, bikerWidth, bikerHeight), c);
        }//for

        Camera.getWorld().getOfficer().getAnimation().setSpriteSheet(BitmapFactory.decodeResource(getResources(), R.drawable.officer));
        officerHeight = Camera.getWorld().getOfficer().getAnimation().getSpriteSheet().getHeight();
        officerWidth = Camera.getWorld().getOfficer().getAnimation().getSpriteSheet().getWidth();

        Camera.getWorld().getSkater().getAnimation().setSpriteSheet(BitmapFactory.decodeResource(getResources(), R.drawable.skater));
        skaterHeight = Camera.getWorld().getSkater().getAnimation().getSpriteSheet().getHeight();
        skaterWidth = Camera.getWorld().getSkater().getAnimation().getSpriteSheet().getWidth();
        for(int d = 0; d < Camera.getWorld().getSkater().getAnimation().length(); d++){
            Camera.getWorld().getSkater().getAnimation().insertFrame(Bitmap.createBitmap(Camera.getWorld().getSkater().getAnimation().getSpriteSheet(), d*skaterWidth, 0, skaterWidth, skaterHeight), d);
        }//for*/

    }//onCreate
}