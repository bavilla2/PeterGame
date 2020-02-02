package com.example.petergame;

import android.content.Context;
import android.graphics.Rect;
import java.util.Random;

public class GameEngine extends Thread {
    private World world;
    private Activity2 actualGame;

    private int gravity = Constants.SCREEN_HEIGHT / 75;
    private int runSpeed = Constants.SCREEN_HEIGHT / 100;

    private Random random;
    private int numberObstacle = 3;
    private int obstacleDistance = 100;
    private int distanceIt = 0;
    private int points = 0;

    /*Constructor*/
    public GameEngine(Context context, World world) {
        this.world = world;
        actualGame = (Activity2) context;

        random = new Random();
    }//Engine

    /*Updating Methods*/
    private void Initialize() {
        synchronized (world.getObstacles()) {
            if (world.getObstacles().isEmpty()) {
                for (int x = 0; x < 10; x++) {
                    world.getObstacles().add(randObstacle(random.nextInt(numberObstacle)));
                }//for
            }//if
        }//synchronized
    }//Initialize

    /*Chooses what random obstacle to place next*/
    private Obstacles randObstacle(int id) {
        switch (id) {
            case 0:
                return new BikeRider(Constants.SCREEN_WIDTH, ((Constants.SCREEN_HEIGHT / 4) * 2) + (Constants.SCREEN_HEIGHT / 3) - (Constants.SCREEN_HEIGHT / 10), runSpeed * 2);
            case 1:
                return new Officer(Constants.SCREEN_WIDTH, ((Constants.SCREEN_HEIGHT / 4) * 2) + (Constants.SCREEN_HEIGHT / 3) - (Constants.SCREEN_HEIGHT / 7), runSpeed);
            case 2:
                return new Skater(Constants.SCREEN_WIDTH, ((Constants.SCREEN_HEIGHT / 4) * 2) + (Constants.SCREEN_HEIGHT / 3) - (Constants.SCREEN_HEIGHT / 5),(int)(runSpeed * 1.5));
            default:
                return new Officer(Constants.SCREEN_WIDTH, ((Constants.SCREEN_HEIGHT / 4) * 2) + (Constants.SCREEN_HEIGHT / 3) - (Constants.SCREEN_HEIGHT / 7), runSpeed);
        }//switch
    }//randObstacle

    /*Gravity on Peter*/
    private void Gravity() {
        synchronized (world.getPeter()) {

            if(world.getPeter().inAir)
            {
                world.getPeter().setSpeedY(world.getPeter().getSpeedY() - (int)(0.5 * world.getPeter().getHeight()) );
                if (world.getPeter().getSpeedY() == world.getPeter().getJumpSpeed())
                {
                    world.getPeter().inAir = false;
                }
                world.getPeter().move();
            }
//            if (world.getPeter().isJumping() && !world.getPeter().isFalling()) {
//                System.out.println("Jumping!");
//                if (world.getPeter().getPosY() > world.getPeter().getJumpHeight()) {
//                    world.getPeter().move(0, -gravity);
//                }//if
//                else {
//                    world.getPeter().setFalling(true);
//                }//else
//            }//if
//            else if (world.getPeter().isJumping() && world.getPeter().isFalling()) {
//                if (world.getPeter().getPosY() < world.getPeter().getInitY()) {
//                    System.out.println("Falling!");
//                    world.getPeter().move(0, gravity);
//                }//if
//                else {
//                    world.getPeter().setFalling(false);
//                    world.getPeter().Jumping(false);
//                }//else
//            }//else if
        }//Synchronized(Peter)
    }//Gravity

    /*Movement of the world*/
    private void shiftWorld() {
        synchronized (world.getObstacles()) {
            if (world.getObstacles().isEmpty()) {
                world.getObstacles().add(randObstacle(random.nextInt(numberObstacle)));
            }//if

            for (int c = 0; c < world.getObstacles().size(); c++) {
                world.getObstacles().get(c).move();
                if ((world.getObstacles().get(c).getPosX() + world.getObstacles().get(c).getWidth()) <= 0) {
                    world.getObstacles().remove(c);
                }//if
                if (Rect.intersects(world.getPeter().getHitBox(), world.getObstacles().get(c).getRect())) {
                    world.setEndGame(true);
                }
            }//for

            if (distanceIt >= (obstacleDistance + random.nextInt(60))) {
                if (distanceIt >= (obstacleDistance + random.nextInt(150))) {
                    world.getObstacles().add(randObstacle(random.nextInt(numberObstacle)));
                    distanceIt = 0;
                }//if
                distanceIt++;
            }//if
        }//synchronized
        points++;
    }//shiftWorld

    /*Update the Points*/
//    public void updateView() {
//        actualGame.getScoreView.setText("Points: " + Integer.toString(points / 10));
//    }//updateView

    /*Run*/
    public void run(){
        do{
            try{
                Gravity();
                shiftWorld();
                sleep(25);
                //updateView();
            } catch(InterruptedException e){
                e.printStackTrace();
            }//catch
        }while(!world.isEndGame());
    }//Run
}//GameEngine
