/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 * Imports
 */
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Transform;

/**
 *
 * @author Lennart
 */
public class Shot extends Entity{
    private int damage;
    private float speed;
    private int range;
    private int maxShots;
    private double xDistance;
    private double yDistance;
    private double angleToTurn;

    
    /**
     *
     * @param startingX
     * @param startingY
     * @param damage
     * @param speed
     * @param imageName
     * @param rotation
     */
    public Shot(float startingX, float startingY, int damage, float speed, String imageName, double rotation){
        this.damage = damage;
        this.speed = speed;
        this.CoordX = startingX;
        this.CoordY = startingY;
        this.angleToTurn = rotation;
        
        try {
            sprite = new Sprite(new Image(imageName));
        } catch (SlickException ex) {
            Logger.getLogger(Shot.class.getName()).log(Level.SEVERE, null, ex);
        }
        sprite.setRotation((float) angleToTurn);
        BoundingShape = new Rectangle(CoordX, CoordY, sprite.getWidth(), 
                sprite.getHeight());
        
//        BoundingShape = BoundingShape.transform(Transform.createRotateTransform((float) Math.toRadians(sprite.getRotation()),1, 1));
    }
    
    /**
     *
     */
    public Shot(){
    
    }
    
    // methods

    
    @Override
    public void Update(GameContainer gc, int delta) {
        CoordX += (speed * delta) * Math.cos(Math.toRadians(angleToTurn));
        CoordY += (speed * delta) * Math.sin(Math.toRadians(angleToTurn));
        UpdateBoundingShapePosition();
    }

    @Override
    public void Render(GameContainer gc, Graphics g) {
        sprite.draw(g, CoordX, CoordY);
    }
    
    
    /**
     * Getter and Setters
     */
    

    /**
     *
     * @return
     */
    public int getDamage() {
        return damage;
    }

    /**
     *
     * @param damage
     */
    public void setDamage(int damage) {
        this.damage = damage;
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
     * @param speed
     */
    public void setSpeed(float speed) {
        this.speed = speed;
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
     * @param range
     */
    public void setRange(int range) {
        this.range = range;
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
     * @param maxShots
     */
    public void setMaxShots(int maxShots) {
        this.maxShots = maxShots;
    }

    /**
     *
     * @return
     */
    public double getxDistance() {
        return xDistance;
    }

    /**
     *
     * @param xDistance
     */
    public void setxDistance(double xDistance) {
        this.xDistance = xDistance;
    }

    /**
     *
     * @return
     */
    public double getyDistance() {
        return yDistance;
    }

    /**
     *
     * @param yDistance
     */
    public void setyDistance(double yDistance) {
        this.yDistance = yDistance;
    }

    /**
     *
     * @return
     */
    public double getAngleToTurn() {
        return angleToTurn;
    }

    /**
     *
     * @param angleToTurn
     */
    public void setAngleToTurn(double angleToTurn) {
        this.angleToTurn = angleToTurn;
    }
}
