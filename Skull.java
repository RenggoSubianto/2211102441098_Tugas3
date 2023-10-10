import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Skull here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Skull extends Props
{
    int size = 60;
    public void act()
    {
        GreenfootImage img = this.getImage();
        img.scale(size, size);
        this.setImage(img);
        size--;
        if(size <=1){
            World wrld = this.getWorld();
            wrld.removeObject(this);
            Greenfoot.stop();
        }
    }
}
