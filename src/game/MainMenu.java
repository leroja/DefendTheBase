/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import Classes.MenuItem;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author Lennarts Dator
 */
public class MainMenu extends BasicGameState{
    public static final int ID = 0; 
    
    private MenuItem endless;
    private MenuItem wave;
    private MenuItem Highscore;
    private MenuItem Option;
    private MenuItem ExitGame;
    
    @Override
    public int getID() {
        return MainMenu.ID;
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        endless = new MenuItem("resources/MenuItems/Endless.png", 100, 50);
        wave = new MenuItem("resources/MenuItems/Waves.png", 100, 110);
        Highscore = new MenuItem("resources/MenuItems/HS.png", 100, 170);
        Option = new MenuItem("resources/MenuItems/Options.png", 100, 230);
        ExitGame = new MenuItem("resources/MenuItems/Exit.png", 100, 290);
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics grphcs) throws SlickException {
        endless.Render(gc, grphcs);
        wave.Render(gc, grphcs);
        Highscore.Render(gc, grphcs);
        Option.Render(gc, grphcs);
        ExitGame.Render(gc, grphcs);
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
        Input input = gc.getInput();
        
        int mX = input.getMouseX();
        int mY = input.getMouseY();
        
        if(endless.BoundingShape.contains(mX, mY) && input.isMouseButtonDown(0)){
            sbg.enterState(1);
        }
        if(wave.BoundingShape.contains(mX, mY) && input.isMouseButtonDown(0)){
            sbg.enterState(2);
        }
        if(Highscore.BoundingShape.contains(mX, mY) && input.isMouseButtonDown(0)){
            sbg.enterState(3);
        }
        if(Option.BoundingShape.contains(mX, mY) && input.isMouseButtonDown(0)){
            sbg.enterState(4);
        }
        if(ExitGame.BoundingShape.contains(mX, mY) && input.isMouseButtonDown(0)){
            System.exit(0);
        }
    }
    
}
