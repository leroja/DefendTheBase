/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

/**
 *
 * @author Lennarts Dator
 */
public class MenuItem extends Entity{

    public MenuItem(String imgPath, int CoordX, int CoordY){ 
        this.CoordX = CoordX;
        this.CoordY = CoordY;
        try {
            sprite = new Sprite(new Image(imgPath));
        } catch (SlickException ex) {
            Logger.getLogger(MenuItem.class.getName()).log(Level.SEVERE, null, ex);
        }
        BoundingShape = new Rectangle(CoordX, CoordY, sprite.getWidth(), 
                sprite.getHeight());
    }
    
    @Override
    public void Update(GameContainer gc, int delta) {
        
    }

    @Override
    public void Render(GameContainer gc, Graphics g) {
        sprite.draw(g, CoordX, CoordY);
    }
}
