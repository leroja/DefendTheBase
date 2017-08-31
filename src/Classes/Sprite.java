/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

/**
 *
 * @author Lennarts Dator
 */
public class Sprite {
    /** The image to be drawn for this sprite */
    private final Image image;
    
    /**
     * Create a new sprite based on an image
     * 
     * @param image The image that is this sprite
     */
    public Sprite(Image image) {
        this.image = image;
    }

    /**
     * Get the width of the drawn sprite
     * 
     * @return The width in pixels of this sprite
     */
    public int getWidth() {
        return image.getWidth();
    }

    /**
     * Get the height of the drawn sprite
     * 
     * @return The height in pixels of this sprite
     */
    public int getHeight() {
        return image.getHeight();
    }
    
    public void setRotation(float rotation){
        image.setRotation(rotation);
    }
    
    public float getRotation(){
        return image.getRotation();
    }
    
    public void setCenterOfRotation(float X, float Y){
        image.setCenterOfRotation(X, Y);
    }
    
    /**
     * Draw the sprite onto the graphics context provided
     * 
     * @param g The graphics context on which to draw the sprite
     * @param x The x location at which to draw the sprite
     * @param y The y location at which to draw the sprite
     */
    public void draw(Graphics g, float x, float y) {
            g.drawImage(image, x, y, null);
    }
}
