/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

/**
 *
 * @author Lennart
 */
public class Base extends Entity{
    private int maxHealth = 100;
    private int health = maxHealth;

    /**
     *
     */
    public Base(){
        try {
            sprite = new Sprite(new Image("resources/base1.png"));
        } catch (SlickException ex) {
            Logger.getLogger(Base.class.getName()).log(Level.SEVERE, null, ex);
        }
        CoordX = 270;
        CoordY = 270;
        BoundingShape = new Rectangle(CoordX, CoordY, sprite.getWidth(), 
                sprite.getHeight());
    }
    
    /**
     *
     * @param h Health of the base
     * @param X X coordinate
     * @param Y Y coordinate
     */
    public Base(int h, float X, float Y){
        this.health = h;
        this.CoordX = X;
        this.CoordY = Y;
        try {
            sprite = new Sprite(new Image("resources/base1.png"));
        } catch (SlickException ex) {
            Logger.getLogger(Base.class.getName()).log(Level.SEVERE, null, ex);
        }
        BoundingShape = new Rectangle(CoordX, CoordY, sprite.getWidth(), 
                sprite.getHeight());
    }
    
 
    //Methods
    
    
    @Override
    public void Update(GameContainer gc, int delta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Render(GameContainer gc, Graphics g) {
        sprite.draw(g, CoordX, CoordY);
    }
    
    /**
     * Getter and Setters
     */

    /**
     *
     * @return
     */
    public int getMaxHealth() {
        return maxHealth;
    }

    /**
     *
     * @return
     */
    public int getHealth() {
        return health;
    }

    /**
     *
     * @param health
     */
    public void setHealth(int health) {
        this.health = health;
    }
}
