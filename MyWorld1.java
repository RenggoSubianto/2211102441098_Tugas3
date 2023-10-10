import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
import java.util.Random;

/**
 * Write a description of class MyWorld1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld1 extends World
{
    ScoreBoard scoreBoard;
    
    int combo = 0;
    int shotDone = 0;
    int shotMiss = 0;
    Boards accBoard;
    Boards comboBoard;
    
    private void recalculateAcc(){
        float accuracy;
        if(shotDone <=0){
            accuracy = 0;
        } else {
            accuracy = ((float) (shotDone - shotMiss) / shotDone) * 100;
        }
        
        accBoard.setMessage("accuracy: " +accuracy + "%\nShot: " + shotDone + "\nMiss: " + shotMiss);
    }
    
    private void updateCombo(){
        combo++;
        comboBoard.setMessage("Combo: " + combo);
    }
    
    public void incShotDone(){
        this.shotDone++;
        recalculateAcc();
        updateCombo();
    }
    
    public void incShotMiss(){
        this.shotMiss++;
        combo = 0;
        comboBoard.setMessage("Combo: " + combo);
        recalculateAcc();
    }
    
    public MyWorld1()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 700, 1);
        spawnHero();
        this.scoreBoard = new ScoreBoard();
        this.addObject(scoreBoard, 300, 30);
        this.setPaintOrder(Karakter.class, Boards.class, Props.class, Environments.class);
        accBoard = new Boards();
        this.addObject(accBoard, 80, 60);
        comboBoard = new Boards();
        this.addObject(comboBoard, 520, 60);
    }
    
    private void spawnRandomObject(){
        Random rnd = new Random();
        Environments env = new Environments();
        this.addObject(env, rnd.nextInt(this.getWidth() -30), 0);
    }
    
    private void spawnHero(){
        Random rnd = new Random();
        Hero p1 = new Hero();
        p1.setRotation(270);
        this.addObject(p1, rnd.nextInt(this.getWidth() -30), this.getHeight() -30);
    }
    
    private void spawnVillain(){
        Random rnd = new Random();
        for (int i=0; 1<rnd.nextInt(5); i++){
             if(i % 2 == 0){
                Kutu kutu = new Kutu();
                this.addObject(kutu, rnd.nextInt(this.getWidth() -30), 5);
             }
            Villain en = new Villain();
            this.addObject(en, rnd.nextInt(this.getWidth() -30), 5);
        }
    }
    
    public void act() {
        spawnRandomObject();
        List<Villain>villain = this.getObjects(Villain.class);
        if(villain.size()==0){
            spawnVillain();
        }
    }
}
