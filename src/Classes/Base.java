/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author Lennart
 */
public class Base {
    private int maxHealth = 100;
    private int health = maxHealth;
    private float cordX = 270;
    private float cordY = 270;
     
    //constructor
    public Base(){
        
    }
    public Base(int h, float X, float Y){
        this.health = h;
        this.cordX = X;
        this.cordY = Y;
    }
    
 
    //Methods

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
    
}
