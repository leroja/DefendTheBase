/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import org.newdawn.slick.*;

/**
 *
 * @author Lennart
 */
public class Shot {
    private float xCord;
    private float yCord;
    private int damage;
    private float speed;
    private int range;
    private int maxShots;
    private double xDistance;
    private double yDistance;
    private double angleToTurn;
    public Image shotImage = null;
    
    //constructor
    public Shot(float startingX, float startingY, int damage, float speed, String imageName) throws SlickException{
        this.damage = damage;
        this.speed = speed;
        this.xCord = startingX;
        this.yCord = startingY;
        
        shotImage = new Image(imageName);
        
    }
    
    public Shot(int damage, float speed, String ImageName) throws SlickException{
        this.damage = damage;
        this.speed = speed;
        
        shotImage = new Image(ImageName);
    }
    
    public Shot(){
    
    }
    
    //methods

    public float getxCord() {
        return xCord;
    }

    public void setxCord(float xCord) {
        this.xCord = xCord;
    }

    public float getyCord() {
        return yCord;
    }

    public void setyCord(float yCord) {
        this.yCord = yCord;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public int getMaxShots() {
        return maxShots;
    }

    public void setMaxShots(int maxShots) {
        this.maxShots = maxShots;
    }

    public double getxDistance() {
        return xDistance;
    }

    public void setxDistance(double xDistance) {
        this.xDistance = xDistance;
    }

    public double getyDistance() {
        return yDistance;
    }

    public void setyDistance(double yDistance) {
        this.yDistance = yDistance;
    }

    public double getAngleToTurn() {
        return angleToTurn;
    }

    public void setAngleToTurn(double angleToTurn) {
        this.angleToTurn = angleToTurn;
    }
    
}
