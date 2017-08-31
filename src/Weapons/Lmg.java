/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Weapons;

/**
 *
 * @author Lennart
 */
public class Lmg  extends Weapon{
    
    /**
     *
     */
    public Lmg()
    {
        damage = 20;
        speed = 0.25f;
        maxShots = 20;
        weaponType = 1;
        weaponNbr = 1;
        currentNbrOfShots = 0;
        ShotImageName = "resources/Green/GreenMachineGunShot.png";
    }
}