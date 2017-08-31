/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 * Imports
 */
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
public class Monster extends Entity{
    private int health;
    private int maxHealth = 100;
    private float speed = 0.025f;
    private int damage = 1;
    private float orginX = 7; // todo change
    private float orginY = 12;
    
    private double xDistancePlayer;
    private double yDistancePlayer;
    private double xDistanceBase;
    private double yDistanceBase;
    private double angleToTurntoplayer;
    private double angleToTurntobase;
    private double distancePlayer;
    private double distanceBase;

    /**
     *
     * @param H
     * @param X
     * @param Y
     */
    public Monster(int H, float X, float Y){
        this.health = H;
        this.CoordX = X;
        this.CoordY = Y;
        
        try {
            sprite = new Sprite(new Image("resources/monster.png"));
        } catch (SlickException ex) {
            Logger.getLogger(Monster.class.getName()).log(Level.SEVERE, null, ex);
        }
        sprite.setCenterOfRotation(orginX, orginY);
        BoundingShape = new Rectangle(CoordX, CoordY, sprite.getWidth(), 
                sprite.getHeight());
    }
    
    /**
     *
     */
    public Monster(){
        try {
            sprite = new Sprite(new Image("resources/monster.png"));
        } catch (SlickException ex) {
            Logger.getLogger(Monster.class.getName()).log(Level.SEVERE, null, ex);
        }
        sprite.setCenterOfRotation(orginX, orginY);
        BoundingShape = new Rectangle(CoordX, CoordY, sprite.getWidth(), 
                sprite.getHeight());
    }
    
    
    //methods

    
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
    public int getDamage() {
        return damage;
    }

    /**
     *
     * @param damage
     */
    public void setDamage(int damage) {
        this.damage = damage;
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

    /**
     *
     * @return
     */
    public double getxDistancePlayer() {
        return xDistancePlayer;
    }

    /**
     *
     * @param xDistancePlayer
     */
    public void setxDistancePlayer(double xDistancePlayer) {
        this.xDistancePlayer = xDistancePlayer;
    }

    /**
     *
     * @return
     */
    public double getyDistancePlayer() {
        return yDistancePlayer;
    }

    /**
     *
     * @param yDistancePlayer
     */
    public void setyDistancePlayer(double yDistancePlayer) {
        this.yDistancePlayer = yDistancePlayer;
    }

    /**
     *
     * @return
     */
    public double getxDistanceBase() {
        return xDistanceBase;
    }

    /**
     *
     * @param xDistanceBase
     */
    public void setxDistanceBase(double xDistanceBase) {
        this.xDistanceBase = xDistanceBase;
    }

    /**
     *
     * @return
     */
    public double getyDistanceBase() {
        return yDistanceBase;
    }

    /**
     *
     * @param yDistanceBase
     */
    public void setyDistanceBase(double yDistanceBase) {
        this.yDistanceBase = yDistanceBase;
    }

    /**
     *
     * @return
     */
    public double getAngleToTurntoplayer() {
        return angleToTurntoplayer;
    }

    /**
     *
     * @param angleToTurntoplayer
     */
    public void setAngleToTurntoplayer(double angleToTurntoplayer) {
        this.angleToTurntoplayer = angleToTurntoplayer;
    }

    /**
     *
     * @return
     */
    public double getAngleToTurntobase() {
        return angleToTurntobase;
    }

    /**
     *
     * @param angleToTurntobase
     */
    public void setAngleToTurntobase(double angleToTurntobase) {
        this.angleToTurntobase = angleToTurntobase;
    }

    /**
     *
     * @return
     */
    public double getDistancePlayer() {
        return distancePlayer;
    }

    /**
     *
     * @param distancePlayer
     */
    public void setDistancePlayer(double distancePlayer) {
        this.distancePlayer = distancePlayer;
    }

    /**
     *
     * @return
     */
    public double getDistanceBase() {
        return distanceBase;
    }

    /**
     *
     * @param distanceBase
     */
    public void setDistanceBase(double distanceBase) {
        this.distanceBase = distanceBase;
    }
}
