/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 * Imports
 */
import Weapons.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Rectangle;

/**
 *
 * @author Lennart
 */
public class Player extends Entity{
    private int maxHealth = 100;
    private int health = maxHealth;
    private float speed = 0.1f;
    private float orginX;
    private float orginY;
    
    public Weapon weapon;

    /**
     *
     * @param H
     * @param X
     * @param Y
     */
    public Player(int H, float X, float Y){
        this.health = H;
        this.maxHealth = H;
        this.CoordX = X;
        this.CoordY = Y;
        weapon = new Lmg();
        try {
            sprite = new Sprite(new Image("resources/Green/GreenMachineGuner.png"));
        } catch (SlickException ex) {
            Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
        }
        orginX = 6; // todo change
        orginY = 7;
        BoundingShape = new Circle(CoordX + orginX, CoordY + orginY, sprite.getWidth());
//        BoundingShape = new Rectangle(CoordX, CoordY, sprite.getWidth(), 
//                sprite.getHeight());
        sprite.setCenterOfRotation(orginX, orginY);
    }
    
    // methods
    
    @Override
    public void UpdateBoundingShapePosition(){
        BoundingShape.setCenterX(CoordX + orginX);
        BoundingShape.setCenterY(CoordY + orginY);
    }
    
    @Override
    public void Update(GameContainer gc, int delta) {
        Input input = gc.getInput();
         
        UpdateBoundingShapePosition();
        // Changing Weapon
        if(input.isKeyDown(Input.KEY_1)){
            weapon = new Lmg();
            try {
                sprite = new Sprite(new Image("resources/Green/GreenMachineGuner.png"));
            } catch (SlickException ex) {
                Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
            }
            orginX = 6; // todo change
            orginY = 7;
            sprite.setCenterOfRotation(orginX, orginY);
            BoundingShape = new Circle(CoordX + orginX, CoordY + orginY, sprite.getWidth());
        }
         
        if (input.isKeyDown(Input.KEY_2)){
            weapon = new SniperRifle();
            try {
                sprite = new Sprite(new Image("resources/Green/GreenSniper.png"));
            } catch (SlickException ex) {
                Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
            }
            orginX = 7;
            orginY = 8;
            sprite.setCenterOfRotation(orginX, orginY);
            BoundingShape = new Circle(CoordX + orginX, CoordY + orginY, sprite.getWidth());
        }
        
        if (input.isKeyDown(Input.KEY_3)){
            weapon = new RocketLauncher();
            try {
                sprite = new Sprite(new Image("resources/Green/GreenRocketLauncher.png"));
            } catch (SlickException ex) {
                Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
            }
            orginX =10;
            orginY = 8;
            sprite.setCenterOfRotation(orginX, orginY);
            BoundingShape = new Circle(CoordX + orginX, CoordY + orginY, sprite.getWidth());
        }
        
//        if (input.isKeyDown(Input.KEY_4)){
//            try {
//                sprite = new Sprite(new Image("resources/Green/GreenFlameThrower.png"));
//            } catch (SlickException ex) {
//                Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            orginX = 7;
//            orginY = 8;
//            weapon = new FlameThrower();
//            sprite.setCenterOfRotation(orginX, orginY);
//        }
        
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
     * @param maxHealth
     */
    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
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

    /**
     *
     * @return
     */
    public float getSpeed() {
        return speed;
    }

    /**
     *
     * @param speed
     */
    public void setSpeed(float speed) {
        this.speed = speed;
    }

    /**
     *
     * @return
     */
    public float getOrginX() {
        return orginX;
    }

    /**
     *
     * @param orginX
     */
    public void setOrginX(float orginX) {
        this.orginX = orginX;
    }

    /**
     *
     * @return
     */
    public float getOrginY() {
        return orginY;
    }

    /**
     *
     * @param orginY
     */
    public void setOrginY(float orginY) {
        this.orginY = orginY;
    }
}
