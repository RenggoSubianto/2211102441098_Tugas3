import greenfoot.*;
  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Hero here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Hero extends Karakter
{
    int speed = 10;
    int bulletSpeed = 15;
    int cooldown = 20;
    int lastShotTimer = 0;
    
    public Hero(){
        GreenfootImage img = this.getImage();
        img.scale(60, 60);
        this.setImage(img);
    }
    
    private void tembak(){
        MyWorld1 wrld = (MyWorld1)this.getWorld();
        Bullets bullet = new Bullets();
        bullet.setRotation(this.getRotation());
        wrld.incShotDone();
        wrld.addObject(bullet, this.getX(), this.getY());
    }
    
    public void act()
    {
        if(Greenfoot.isKeyDown("up")){
            this.setLocation(this.getX(), this.getY()-speed);
        }
        
        if(Greenfoot.isKeyDown("down")){
            this.setLocation(this.getX(), this.getY()+speed);
        }
        
        if(Greenfoot.isKeyDown("left")){
            this.setLocation(this.getX() -speed, this.getY());
        }
        
        if(Greenfoot.isKeyDown("right")){
            this.setLocation(this.getX() +speed, this.getY());
        }
        
        System.out.println(lastShotTimer);
        
        if(lastShotTimer < cooldown && lastShotTimer > 0 ){
            lastShotTimer ++;
        }
        
        if(Greenfoot.isKeyDown("space") && lastShotTimer == 0){
            tembak();
            lastShotTimer++;
        }
        
        if(lastShotTimer == cooldown){
            lastShotTimer = 0;
        }
        
        if(this.isTouching(Villain.class)){
            World wrld = this.getWorld();
            Skull d = new Skull();
            wrld.addObject(d, this.getX(), this.getY());
            wrld.removeObject(this);
        }
    }
}
