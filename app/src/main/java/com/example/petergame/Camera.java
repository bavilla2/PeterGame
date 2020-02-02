package com.example.petergame;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import org.w3c.dom.Attr;

import java.util.jar.Attributes;

public class Camera extends View {
    static World world;
    Activity2 activity2;
    Context context;
    private GameEngine engine;

    Thread game;

    private final long FPS = 30;
    private long timeStamp;

    public Camera(Context context, AttributeSet attributeSet){
        super(context, attributeSet);
        this.context = context;
        activity2 = (Activity2) context;

        world = new World();
        engine = new GameEngine(context, world);
        game = new Thread(engine);
        game.start();
    }//Camera Constructor

    public static World getWorld(){return world;}

    @Override
    protected void onDraw(Canvas cam){

        /*cam.drawBitmap(getWorld().getPeter().getJump().getCurrentFrame(), null, getWorld().getPeter().getRect(), new Paint());
        Camera.getWorld().getPeter().getJump().update();*/

        cam.drawBitmap(getWorld().getPeter().getCurrentAnimation().getCurrentFrame(), null, getWorld().getPeter().getRect(), new Paint());
        Camera.getWorld().getPeter().getCurrentAnimation().update();

     /*   cam.drawBitmap(getWorld().getBike().getWalk().getCurrentFrame(), null, getWorld().getBike().getRect(), new Paint());
        Camera.getWorld().getBike().getWalk().update();

        cam.drawBitmap(getWorld().getOfficer().getWalk().getCurrentFrame(), null, getWorld().getOfficer().getRect(), new Paint());
        Camera.getWorld().getOfficer().getWalk().update();

        cam.drawBitmap(getWorld().getSkater().getWalk().getCurrentFrame(), null, getWorld().getSkater().getRect(), new Paint());
        Camera.getWorld().getSkater().getWalk().update(); /**/

        try{
            Thread.sleep(1000/30);
        }catch(InterruptedException e){
            e.printStackTrace();
        }//end try/catch
        invalidate();
    }//onDraw


}//Camera Class
