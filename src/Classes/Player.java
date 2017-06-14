/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 * Imports
 */
import org.newdawn.slick.Image;

/**
 *
 * @author Lennart
 */
public class Player {
    private int maxHealth = 100;
    private int health = maxHealth;
    private float speed = 0.1f;  
    private float cordX = 200;
    private float cordY = 325;
    private float orginX;
    private float orginY;
    private Image playerImage;


    // constructor
    public Player()
    {
        
    }
    public Player(int H, float X, float Y){
        this.health = H;
        this.maxHealth = H;
        this.cordX = X;
        this.cordY = Y;
    }
    
    // methods

    public Image getPlayerImage() {
        return playerImage;
    }

    public void setPlayerImage(Image playerImage) {
        this.playerImage = playerImage;
    }
    
    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public float getCordX() {
        return cordX;
    }

    public void setCordX(float cordX) {
        this.cordX = cordX;
    }

    public float getCordY() {
        return cordY;
    }

    public void setCordY(float cordY) {
        this.cordY = cordY;
    }

    public float getOrginX() {
        return orginX;
    }

    public void setOrginX(float orginX) {
        this.orginX = orginX;
    }

    public float getOrginY() {
        return orginY;
    }

    public void setOrginY(float orginY) {
        this.orginY = orginY;
    }
}
