import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;


public class Bear extends Actor
{
    
    private int offsetX = 5;
    private int offsetY = 5;
    private static int nextOffset = 5;
    
    public Bear () {
        offsetX = nextOffset;
        offsetY = nextOffset;
        
        nextOffset += 3;
    }
    
    public void act()
    {
        // Add your action code here.
        int x = getX();
        int y = getY();
        
        setLocation(x + offsetX, y + offsetY);
        
        if (getY() >= 380) {
            offsetY = -5;
        }
        
        if (getX() >= 575) {
            offsetX = -5;
        }
        
        if (getY() <= 0) {
            offsetY = 5;
        }
        
        if (getX() <= 0) {
            offsetX = 5;
        }
        
        
        Turtle turtle = (Turtle)getOneIntersectingObject(Turtle.class);
        
        if (turtle != null) {
            World world = getWorld();
            
            Bomb bomb = new Bomb();
            
            //world.removeObject(turtle);
            world.addObject(bomb, getX(), getY());
        }
    }
}
