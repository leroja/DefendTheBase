/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import Classes.Base;
import Classes.Monster;
import Classes.Player;
import Classes.Shot;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author Lennarts Dator
 */
public class EndlessGameMode extends BasicGameState{
    public static final int ID = 1;
    
    /**
     * Constants
     */
    private static final int HEIGHT = 640;
    private static final int WIDTH = 640;
    private static final int SPAWNTIMER = 60000;
    
    /**
     * private variables
     */
    private int NewMonsterSpawnTimer;
    private int MaxMonsters;
    private int Time, kills;
    private Image BackgroundImage;
    private Base base;
    private Player player;
    private final Random rand;
    private final List<Monster> MonsterList;
    private final Shot[] ShotArray;
    private float x, y, x2, y2, WeaponOrgin;
    
    private double angleToTurn; // ta bort sen och andra tillbaka på det andra stället
    
    /**
     *
     * @param title
     */
    public EndlessGameMode(String title){
//        super(title);
        
        rand = new Random();
        MaxMonsters = 5;
        MonsterList = new ArrayList<>();
        ShotArray = new Shot[20];
        NewMonsterSpawnTimer = SPAWNTIMER;
    }
 
    /**
     *
     * @param ar
     * @param index
     */
    public void deleteShot(Shot[] ar, int index){
        for(int i = index;i < player.weapon.getCurrentNbrOfShots() - 1; i++){
            ar[i] = ar[i+1];
        }
        player.weapon.setCurrentNbrOfShots(player.weapon.getCurrentNbrOfShots() - 1);
    }
    
    /**
     *
     * @param monster
     */
    public void setSpawn(Monster monster){
        int randX, randY, border;
        randX = rand.nextInt(WIDTH);
        randY = rand.nextInt(HEIGHT);
        border = 120;
        
        //Sets the spawn of the monster in the outer parts of the window
        while (randX > border && randX < (WIDTH - border)){
            randX = rand.nextInt(WIDTH);
        }
        while (randY > border && randY < (HEIGHT - border)){
            randY = rand.nextInt(HEIGHT);
        }
        
        monster.setCordX(randX);
        monster.setCordY(randY);
        monster.setHealth(monster.getMaxHealth());   
        
        
        // kan ha med skala om man använder get och set när man hämntar ut bredd och höjd
        // bredd * skala
    }

    @Override
    public int getID() {
        return EndlessGameMode.ID;
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        base = new Base();
        player = new Player(100, 200, 325);
        
        BackgroundImage = new Image("resources/test3.png");
        
        for (int i = 0; i < MaxMonsters; i++){
            MonsterList.add(new Monster());
            setSpawn(MonsterList.get(i));
        }
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        BackgroundImage.draw(0, 0);
        base.Render(gc, g);
        
        for(int i = 0; i < player.weapon.getCurrentNbrOfShots(); i++){
            ShotArray[i].Render(gc, g);
            ShotArray[i].DrawBoundingShape(g);
        }
         
        player.Render(gc, g);
         
        for (int i = 0; i < MaxMonsters; i++){
            Monster monster = MonsterList.get(i);
            monster.Render(gc, g);
            monster.DrawBoundingShape(g);
        }
                 
        g.drawString("Base Health: " + base.getHealth(), 10, 25);
        g.drawString("Player Health: " + player.getHealth(), 10, 40);
        g.drawString("Time: " + Time/1000, 550, 10);
        g.drawString("Kills: " + kills, 550, 25);
        
        
        base.DrawBoundingShape(g);
        player.DrawBoundingShape(g);
//        g.drawString("Player Rotation " + player.sprite.getRotation(), 400, 425);
//        g.drawString("shot " + Shot.getRotation(), 400, 440);
//        g.drawString("Nbt of shot " + weapon.getCurrentNbrOfShots(), 400, 440);
//        g.drawString("x2   " + x2, 400, 455);
//        g.drawString("y2   " + y2, 400, 470);
//        g.drawString("x  " + x, 400, 505);
//        g.drawString("y  " + y, 400, 520);
//        g.drawString("weponorgin   " + WeaponOrgin, 400, 535);
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
            Time += delta;
        Input input = gc.getInput();
        
        NewMonsterSpawnTimer -= delta;
        
        if(NewMonsterSpawnTimer <= 0){
            MaxMonsters += 1;
            Monster monster = new Monster();
            setSpawn(monster);
            MonsterList.add(monster);
            NewMonsterSpawnTimer = SPAWNTIMER;
        }
        
                 
        // turns the game off if the escape key is pressed
        if(input.isKeyDown(Input.KEY_ESCAPE)){
            System.exit(0);
        }
        

        player.Update(gc, delta);
        //Movement and collision detection for player
        //Todo, fix the shit that happens whne player collides with the base
        if(input.isKeyDown(Input.KEY_A)){
            player.setCordX(player.getCordX() - player.getSpeed() * delta);
            if(player.getCordX() <= (0)){
                player.setCordX(player.getCordX() + player.getSpeed() * delta);
            }
            while (player.BoundingShape.intersects(base.BoundingShape)){
                player.setCordX(player.getCordX() + player.getSpeed() * delta); 
                player.UpdateBoundingShapePosition();                                                    
            }
        }
 
        if(input.isKeyDown(Input.KEY_D)){
            player.setCordX(player.getCordX() + player.getSpeed() * delta);
            if((player.getCordX() + player.sprite.getHeight()) >= (WIDTH)){
                player.setCordX(player.getCordX() - player.getSpeed() * delta);
            }
            while(player.BoundingShape.intersects(base.BoundingShape)){
                player.setCordX(player.getCordX() - player.getSpeed() * delta);
                player.UpdateBoundingShapePosition();
            }
        }
 
        if(input.isKeyDown(Input.KEY_W)){
            player.setCordY(player.getCordY() - player.getSpeed() * delta);
            if(player.getCordY() <= (0)){
                player.setCordY(player.getCordY() + player.getSpeed() * delta);
            }
            while(player.BoundingShape.intersects(base.BoundingShape)){
                player.setCordY(player.getCordY() + player.getSpeed() * delta);
                player.UpdateBoundingShapePosition();                                                    
            }
        }
        
        if(input.isKeyDown(Input.KEY_S)){
            player.setCordY(player.getCordY() + player.getSpeed() * delta);
             if((player.getCordY() + player.sprite.getHeight()) >= (HEIGHT)){
                player.setCordY(player.getCordY() - player.getSpeed() * delta);
            }
            while(player.BoundingShape.intersects(base.BoundingShape)){
                player.setCordY(player.getCordY() - player.getSpeed() * delta);
                player.UpdateBoundingShapePosition();
            }
        }
                 
        // rotating player to face the mouse
        double mouseX = input.getMouseX();
        double mouseY = input.getMouseY();
        double xDistance = mouseX - (player.getCordX() + player.getOrginX());
        double yDistance = mouseY - (player.getCordY() + player.getOrginY());
        /*double*/angleToTurn = Math.toDegrees(Math.atan2(yDistance, xDistance));
        player.sprite.setRotation((float)angleToTurn);
        
           
        // Monsters

        for(int i = 0; i < MaxMonsters; i++){
            Monster monster = MonsterList.get(i);
            monster.UpdateBoundingShapePosition();
            
            monster.setxDistancePlayer(player.getCordX() - monster.getCordX());
            monster.setyDistancePlayer(player.getCordY() - monster.getCordY());
            monster.setAngleToTurntoplayer(Math.toDegrees(Math.atan2(
                    monster.getyDistancePlayer(), monster.getxDistancePlayer())));
               
            monster.setxDistanceBase(base.getCordX() + base.sprite.getWidth()/2 - 
                    monster.getCordX());
            monster.setyDistanceBase(base.getCordY() + base.sprite.getHeight()/2 - 
                    monster.getCordY());
            monster.setAngleToTurntobase(Math.toDegrees(Math.atan2(
                    monster.getyDistanceBase(), monster.getxDistanceBase())));
           
            
            monster.setDistancePlayer(Math.sqrt((player.getCordX() - 
                    monster.getCordX())*(player.getCordX() - monster.getCordX()) 
                    + (player.getCordY() - monster.getCordY())*(player.getCordY() 
                            - monster.getCordY())));
            monster.setDistanceBase(Math.sqrt((base.getCordX() - 
                    monster.getCordX())*(base.getCordX() - monster.getCordX()) 
                    + (base.getCordY() - monster.getCordY())*(base.getCordY() 
                            - monster.getCordY())));
             
            if(monster.getDistancePlayer() < monster.getDistanceBase()){
                monster.sprite.setRotation((float)monster.getAngleToTurntoplayer());
            }else{
                monster.sprite.setRotation((float)monster.getAngleToTurntobase());
            }
        }
        
        for (int i = 0;i < MaxMonsters;i++){
            Monster monster = MonsterList.get(i);
            if (monster.BoundingShape.intersects(base.BoundingShape)){
                base.setHealth(base.getHealth() - monster.getDamage());
                setSpawn(monster);
            }
        }
        
        for(int i = 0; i < MaxMonsters;i++){
            Monster monster = MonsterList.get(i);
            if(monster.BoundingShape.intersects(player.BoundingShape)){
                player.setHealth(player.getHealth() - monster.getDamage());
                setSpawn(monster);
            }
        }
                     
        // Monster movement
        for(int i = 0; i < MaxMonsters; i++){
            Monster monster = MonsterList.get(i);
            monster.setCordX(monster.getCordX() + (monster.getSpeed() * delta) * 
                    (float)Math.cos(Math.toRadians(monster.sprite.getRotation())));
            monster.setCordY(monster.getCordY() + (monster.getSpeed() * delta) * 
                    (float)Math.sin(Math.toRadians(monster.sprite.getRotation())));
        }
           
        //Shooting
           
        // shot out of barrel is not working
           
        switch(player.weapon.getWeaponNbr()){
            case 1:  
                x = player.getCordX() + 23;
                y = player.getCordY() + 12;
                break;
            case 2:  
                x = player.getCordX() + 27;
                y = player.getCordY() + 13;
                break;
            case 3:  
                x = player.getCordX() + 20;
                y = player.getCordY() + 14;
                break;
            case 4:  
                x = player.getCordX() +22;
                y = player.getCordY() +9;
                break;
        }
           
//           If the base (point of rotation) of the cannon is (CannonBaseX, CannonBaseY),
//           and the length of the cannon barrel is Radius, then:
//            BulletX = CannonBaseX + Radius * Cos(Angle);
//            BulletY = CannonBaseY + Radius * Sin(Angle);
           

//           WeaponOrgin = (float)Math.sqrt((x - player.GetcordX())*(x - player.GetcordX())+ (y - player.GetcordY())*(y - player.GetcordY()));
           WeaponOrgin = (float)Math.sqrt((x - (player.getCordX() + player.getOrginX()))*(x - (player.getCordX()+player.getOrginX()))+ (y - (player.getCordY() + player.getOrginY()))*(y - (player.getCordY() + player.getOrginY())));
//           WeaponOrgin = (float)Math.sqrt((x - player.GetcordX())*(x - player.GetcordX())+ (y - player.GetcordY())*(y - player.GetcordY()));
           
           // måste göra en sak som är nästan som player.getOrgin fast mer precis så att skotten kommer ur pipan.
           // måste modifirera den här funktionen ännu för att få flamethrowern att fungera, skriva en egen för den.
           
//           x2 = player.GetcordX() + (x * (float)Math.cos(Math.toRadians(PlayerImage.getRotation())));
//           y2 = player.GetcordY() + (y * (float)Math.sin(Math.toRadians(PlayerImage.getRotation())));
           
           x2 = player.getCordX() + WeaponOrgin * (float)Math.cos(Math.toRadians(player.sprite.getRotation()));
           y2 = player.getCordY() + WeaponOrgin * (float)Math.sin(Math.toRadians(player.sprite.getRotation()));
           
//           x2 = x * (float)Math.cos(Math.toRadians(angleToTurn)) - y * (float)Math.sin(angleToTurn);
//           y2 = x * (float)Math.sin(Math.toRadians(angleToTurn)) + y * (float)Math.cos(angleToTurn);
           
//           x2 = x * (float)Math.cos(Math.toRadians(PlayerImage.getRotation())) - y * (float)Math.sin(Math.toRadians(PlayerImage.getRotation()));
//           y2 = x * (float)Math.sin(Math.toRadians(PlayerImage.getRotation())) + y * (float)Math.cos(Math.toRadians(PlayerImage.getRotation()));
           
           
           
        double XDistance = mouseX - player.getCordX();
        double YDistance = mouseY - player.getCordY();
        double AngleToTurn = Math.toDegrees(Math.atan2(YDistance, XDistance));
           
           
        if(input.isMousePressed(0)){
            if(player.weapon.getCurrentNbrOfShots() < player.weapon.getMaxShots()){    
//                ShotArray[weapon.getCurrentNbrOfShots()] = new Shot(x2,y2, weapon.getDamage(),weapon.getSpeed(),weapon.getShotImageName()); 
                ShotArray[player.weapon.getCurrentNbrOfShots()] = new 
                    Shot(player.getCordX(), player.getCordY(), player.weapon.getDamage(), 
                    player.weapon.getSpeed(), player.weapon.getShotImageName(), AngleToTurn); 
                player.weapon.setCurrentNbrOfShots(player.weapon.getCurrentNbrOfShots() + 1);
            }              
        }
           
        for(int i = 0; i < player.weapon.getCurrentNbrOfShots();i++){
            ShotArray[i].Update(gc, delta);
        }
           
        
        for(int i = 0; i < player.weapon.getCurrentNbrOfShots(); i++){
            Shot shot = ShotArray[i];
            for(int j = 0; j < MaxMonsters; j++){
                Monster monster = MonsterList.get(j);
                if(shot.BoundingShape.intersects(monster.BoundingShape)){
                    deleteShot(ShotArray, i);
                    monster.setHealth(monster.getHealth() - ShotArray[i].getDamage());    
                }
            }  
        }
           
        // Checks if the bullets go out of the screen
        for(int i = 0; i < player.weapon.getCurrentNbrOfShots(); i++){
            if(player.weapon.getWeaponType() == 1){
                if(ShotArray[i].getCordX() >= HEIGHT){
                    deleteShot(ShotArray, i);
                }else if(ShotArray[i].getCordX() <= 0){
                    deleteShot(ShotArray, i);
                }else if(ShotArray[i].getCordY() >= WIDTH){
                    deleteShot(ShotArray, i);
                }else if(ShotArray[i].getCordY() <= 0){
                    deleteShot(ShotArray, i);
                }
            }
        }
        
        // checks if bullets collide with base.
        for(int i = 0; i < player.weapon.getCurrentNbrOfShots(); i++){
            if(player.weapon.getWeaponType() == 1){
                if(ShotArray[i].BoundingShape.intersects(base.BoundingShape)){
                    base.setHealth(base.getHealth() - (ShotArray[i].getDamage()/100 + 1));
                    deleteShot(ShotArray,i);
                }
            }                        
        }
        
        for(int i = 0; i < MaxMonsters; i++){
            Monster monster = MonsterList.get(i);
            if(monster.getHealth() <= 0){
                setSpawn(monster);                
                kills++;
            }
        }
           
        if(base.getHealth() <= 0){
            System.exit(0);
        }
        if(player.getHealth() <= 0){
            System.exit(0);
        }
    }
}
