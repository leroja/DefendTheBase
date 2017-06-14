/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Weapons;

import Classes.Weapon;

/**
 *
 * @author Lennart
 */
public class RocketLauncher  extends Weapon{
    private int damage= 100;
    private float speed = 0.15f;
    private int range;
    private int maxShots = 1;
    private int weaponType = 1;
    private int weaponNbr = 3;
    private int currentNbrOfShots = 0;
    private String ShotImageName = "resources/Green/GreenRocket.png";
    
    
    
    //constructor
    
    public RocketLauncher() {
        
    }
    
    // methods
    @Override
    public String getShotImageName() {
        return ShotImageName;
    }

    @Override
    public void setShotImageName(String ShotImageName) {
        this.ShotImageName = ShotImageName;
    }
    
    @Override
    public int getCurrentNbrOfShots() {
        return currentNbrOfShots;
    }

    @Override
    public void setCurrentNbrOfShots(int currentNbrOfShots) {
        this.currentNbrOfShots = currentNbrOfShots;
    }
    
    @Override
    public void setMaxShots(int MaxShots) {
        this.maxShots = MaxShots;
    }

    @Override
    public int getMaxShots() {
        return this.maxShots;
    }

    @Override
    public void setSpeed(float Speed) {
        this.speed = Speed;
    }

    @Override
    public float getSpeed() {
        return this.speed;
    }

    @Override
    public void setDamage(int Damage) {
        this.damage = Damage;
    }

    @Override
    public int getDamage() {
        return this.damage;
    }

    @Override
    public void setWeaponType(int WeaponType) {
        this.weaponType = WeaponType;
    }

    @Override
    public int getWeaponType() {
        return this.weaponType;
    }

    @Override
    public void setWeaponNbr(int WeaponNbr) {
        this.weaponNbr = WeaponNbr;
    }

    @Override
    public int getWeaponNbr() {
        return this.weaponNbr;
    }

    @Override
    public void setRange(int Range) {
        this.range = Range;
    }

    @Override
    public int getRange() {
        return this.range;
    }
    
}


