import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class Villain here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Villain extends Karakter
{
    protected int reward = 2;
    protected int speed = 4;
    
    public Villain(){
        GreenfootImage img = this.getImage();
        img.scale(60, 60);
        this.setImage(img);
        this.setRotation(90);
    }
    public void act()
    {
        this.move(speed);
        World wrld = this.getWorld();
        
        List<Hero> pls = this.getNeighbours(300, true, Hero.class);
        if(pls.size()>0){
            this.turnTowards(pls.get(0).getX(),pls.get(0).getY());
        }
        
        if(this.isTouching(Bullets.class)){
            ScoreBoard scoreBoard = wrld.getObjects(ScoreBoard.class).get(0);
            scoreBoard.addScore(reward);
            this.removeTouching(Bullets.class);
            wrld.removeObject(this);
            return;
        }
        
        if(this.getY() == wrld.getHeight()-1){
            wrld.removeObject(this);
        }
    }
}
