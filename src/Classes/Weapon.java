/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author Lennart
 */

public class Weapon {
    private int damage;
    private float speed;
    private int range;
    private int maxShots;
    private int weaponType;
    private int weaponNbr;
    private int currentNbrOfShots;
    private String ShotImageName;

    public String getShotImageName() {
        return ShotImageName;
    }

    public void setShotImageName(String ShotImageName) {
        this.ShotImageName = ShotImageName;
    }

    public int getCurrentNbrOfShots() {
        return currentNbrOfShots;
    }

    public void setCurrentNbrOfShots(int currentNbrOfShots) {
        this.currentNbrOfShots = currentNbrOfShots;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int Range) {
        this.range = Range;
    }

    public int getWeaponNbr() {
        return weaponNbr;
    }

    public void setWeaponNbr(int WeaponNbr) {
        this.weaponNbr = WeaponNbr;
    }
    

    public int getWeaponType() {
        return weaponType;
    }

    public void setWeaponType(int WeaponType) {
        this.weaponType = WeaponType;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int Damage) {
        this.damage = Damage;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float Speed) {
        this.speed = Speed;
    }

    public int getMaxShots() {
        return maxShots;
    }

    public void setMaxShots(int MaxShots) {
        this.maxShots = MaxShots;
    }
}


