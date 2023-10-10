import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.GreenfootImage;

/**
 * Write a description of class Boards here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Boards extends Actor
{
    /**
     * Act - do whatever the Boards wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    protected String message = "";
    int size = 20;
    public void setMessage(String message){
        this.message = message;
        GreenfootImage msg = new GreenfootImage(this.message, size, Color.WHITE, Color.BLACK);
        this.setImage(msg);
    }
}
