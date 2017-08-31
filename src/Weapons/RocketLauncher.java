/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Weapons;

/**
 *
 * @author Lennart
 */
public class RocketLauncher  extends Weapon{
    
    /**
     *
     */
    public RocketLauncher() {
        damage= 100;
        speed = 0.15f;
        maxShots = 1;
        weaponType = 1;
        weaponNbr = 3;
        currentNbrOfShots = 0;
        ShotImageName = "resources/Green/GreenRocket.png";
    }
}