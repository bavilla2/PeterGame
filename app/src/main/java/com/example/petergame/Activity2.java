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

        Camera.getWorld().getPeter().getJump().setSpriteSheet(BitmapFactory.decodeResource(getResources(), R.drawable.jump));
        peterHeight = Camera.getWorld().getPeter().getJump().getSpriteSheet().getHeight();
        peterWidth = Camera.getWorld().getPeter().getJump().getSpriteSheet().getWidth() / Camera.getWorld().getPeter().getJump().length();
        for(int x = 0; x < Camera.getWorld().getPeter().getJump().length(); x++){
            Camera.getWorld().getPeter().getJump().insertFrame(Bitmap.createBitmap(Camera.getWorld().getPeter().getJump().getSpriteSheet(), x*peterWidth, 0, peterWidth, peterHeight), x);
        }//for


    }//onCreate
}
