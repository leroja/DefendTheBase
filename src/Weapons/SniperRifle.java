/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Weapons;

/**
 *
 * @author Lennart
 */
public class SniperRifle extends Weapon{
   
    /**
     *
     */
    public SniperRifle()
    {
        damage = 100;
        speed = 0.18f;
        maxShots = 4;
        weaponType = 1;
        weaponNbr = 2;
        currentNbrOfShots = 0;
        ShotImageName = "resources/Green/GreenSniperShot.png";
    }
}
