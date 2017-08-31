/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 * Imports
 */
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Shape;

/**
 *
 * @author Lennart
 */
public abstract class Entity {
    
    protected float CoordX;
    protected float CoordY;
    
    public Sprite sprite;
    
    public Shape BoundingShape;
    
    public abstract void Update(GameContainer gc, int delta);
    
    public abstract void Render(GameContainer gc, Graphics g);
    
    
    public void UpdateBoundingShapePosition(){
        this.BoundingShape.setLocation(CoordX, CoordY);
    }
    
    public void DrawBoundingShape(Graphics g){
        g.draw(BoundingShape);
    }
    
    // Todo remove later
    /**
     *
     * @return
     */
    public float getCordX() {
        return CoordX;
    }

    /**
     *
     * @param cordX
     */
    public void setCordX(float cordX) {
        this.CoordX = cordX;
    }

    /**
     *
     * @return
     */
    public float getCordY() {
        return CoordY;
    }

    /**
     *
     * @param cordY
     */
    public void setCordY(float cordY) {
        this.CoordY = cordY;
    }
}
