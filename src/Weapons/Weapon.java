/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Weapons;

/**
 *
 * @author Lennart
 */

public abstract class Weapon {
    protected int damage;
    protected float speed;
    protected int range;
    protected int maxShots;
    protected int weaponType;
    protected int weaponNbr;
    protected int currentNbrOfShots;
    protected String ShotImageName;

    /**
     *
     * @return
     */
    public String getShotImageName() {
        return ShotImageName;
    }

    /**
     *
     * @param ShotImageName
     */
    public void setShotImageName(String ShotImageName) {
        this.ShotImageName = ShotImageName;
    }

    /**
     *
     * @return
     */
    public int getCurrentNbrOfShots() {
        return currentNbrOfShots;
    }

    /**
     *
     * @param currentNbrOfShots
     */
    public void setCurrentNbrOfShots(int currentNbrOfShots) {
        this.currentNbrOfShots = currentNbrOfShots;
    }

    /**
     *
     * @return
     */
    public int getRange() {
        return range;
    }

    /**
     *
     * @param Range
     */
    public void setRange(int Range) {
        this.range = Range;
    }

    /**
     *
     * @return
     */
    public int getWeaponNbr() {
        return weaponNbr;
    }

    /**
     *
     * @param WeaponNbr
     */
    public void setWeaponNbr(int WeaponNbr) {
        this.weaponNbr = WeaponNbr;
    }
    
    /**
     *
     * @return
     */
    public int getWeaponType() {
        return weaponType;
    }

    /**
     *
     * @param WeaponType
     */
    public void setWeaponType(int WeaponType) {
        this.weaponType = WeaponType;
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
     * @param Damage
     */
    public void setDamage(int Damage) {
        this.damage = Damage;
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
     * @param Speed
     */
    public void setSpeed(float Speed) {
        this.speed = Speed;
    }

    /**
     *
     * @return
     */
    public int getMaxShots() {
        return maxShots;
    }

    /**
     *
     * @param MaxShots
     */
    public void setMaxShots(int MaxShots) {
        this.maxShots = MaxShots;
    }
}


