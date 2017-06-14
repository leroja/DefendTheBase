/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/**
 *
 * @author Lennart
 */
public class Monster {
    private int health;
    private int maxHealth = 100;
    private float speed = 0.025f;
    private int damage = 1;
    private float cordX;
    private float cordY;
    private float orginX = 7 * 0.75f;
    private float orginY = 12 * 0.75f;
    private double xDistancePlayer;
    private double yDistancePlayer;
    private double xDistanceBase;
    private double yDistanceBase;
    private double angleToTurntoplayer;
    private double angleToTurntobase;
    private double distancePlayer;
    private double distanceBase;
    public  Image image = null;
    
    //constructors
    public Monster(int H, float X, float Y) throws SlickException{
        this.health = H;
        this.cordX = X;
        this.cordY = Y;
        
        image = new Image("resources/monster.png");
    }
    public Monster(int H) throws SlickException{
        this.health = H;        
        image = new Image("resources/monster.png");
    }
    public Monster() throws SlickException{
        image = new Image("resources/monster.png");
    }
    
    
    //methods

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
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

    public double getxDistancePlayer() {
        return xDistancePlayer;
    }

    public void setxDistancePlayer(double xDistancePlayer) {
        this.xDistancePlayer = xDistancePlayer;
    }

    public double getyDistancePlayer() {
        return yDistancePlayer;
    }

    public void setyDistancePlayer(double yDistancePlayer) {
        this.yDistancePlayer = yDistancePlayer;
    }

    public double getxDistanceBase() {
        return xDistanceBase;
    }

    public void setxDistanceBase(double xDistanceBase) {
        this.xDistanceBase = xDistanceBase;
    }

    public double getyDistanceBase() {
        return yDistanceBase;
    }

    public void setyDistanceBase(double yDistanceBase) {
        this.yDistanceBase = yDistanceBase;
    }

    public double getAngleToTurntoplayer() {
        return angleToTurntoplayer;
    }

    public void setAngleToTurntoplayer(double angleToTurntoplayer) {
        this.angleToTurntoplayer = angleToTurntoplayer;
    }

    public double getAngleToTurntobase() {
        return angleToTurntobase;
    }

    public void setAngleToTurntobase(double angleToTurntobase) {
        this.angleToTurntobase = angleToTurntobase;
    }

    public double getDistancePlayer() {
        return distancePlayer;
    }

    public void setDistancePlayer(double distancePlayer) {
        this.distancePlayer = distancePlayer;
    }

    public double getDistanceBase() {
        return distanceBase;
    }

    public void setDistanceBase(double distanceBase) {
        this.distanceBase = distanceBase;
    }
    
}
