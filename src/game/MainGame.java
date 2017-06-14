
package game;

/**
 * Imports
 */
import Weapons.*;
import Classes.*;
import java.util.*;
import org.newdawn.slick.*;

public class MainGame extends BasicGame{
    
    private static int height = 640;
    private static int width = 640;
    private static int MaxMonsters = 5;
    private static boolean fullscreen = false;
    private static boolean showFPS = true;
    private static String title = "Defend The Base";
    private static int fpslimit = 60;
    private int Time, kills;
    private Image Background, Base, Player;
    public float scale = 0.75f;
    public float scale1 = 1.25f;
    private Base base = new Base();
    private Player player = new Player();
    private Weapon weapon;
    private Random rand = new Random();
    private Monster[] MonsterArray = new Monster[MaxMonsters];
    private Shot[] ShotArray = new Shot[20];
    private float x, y, x2, y2, WeaponOrgin;
    
    private double angleToTurn; // ta bort sen och andra tillbaka på det andra stället
    
    // TODO
    // Change collision detection methods
    // split the code in to a more readable state
    

    public MainGame(String title){
        super(title);
    }
     
 
    @Override
    public void init(GameContainer gc) throws SlickException{
        player.setOrginX(7 * scale);
        player.setOrginY(7 * scale);
        
        Base = new Image("resources/base1.png");
        Background = new Image("resources/test3.png");
        Player = new Image("resources/Green/GreenMachineGuner.png");
        weapon = new Lmg();
        
        for (int i = 0; i < MaxMonsters; i++){
            //MonsterArray[i] = new Monster(100, rand.nextInt(640), rand.nextInt(640));
            MonsterArray[i] = new Monster();
            setSpawn(MonsterArray[i]);
        }
    }
 
    @Override
    public void update(GameContainer gc, int delta) throws SlickException{
        Time += delta;
        Input input = gc.getInput();
         
                
        // Changing Weapon
        if(input.isKeyDown(Input.KEY_1)){
            weapon = new Lmg();
            Player = new Image("resources/Green/GreenMachineGuner.png");
            player.setOrginX(6 * scale);
            player.setOrginY(7 * scale);
        }
         
        if (input.isKeyDown(Input.KEY_2)){
            weapon = new SniperRifle();
            Player = new Image("resources/Green/GreenSniper.png");
            player.setOrginX(7 * scale);
            player.setOrginY(8 * scale);
        }
        
        if (input.isKeyDown(Input.KEY_3)){
            weapon = new RocketLauncher();
            Player = new Image("resources/Green/GreenRocketLauncher.png");
            player.setOrginX(10 * scale);
            player.setOrginY(8 * scale);
        }
        
//        if (input.isKeyDown(Input.KEY_4)){
//            Player = new Image("resources/Green/GreenFlameThrower.png");
//            player.setOrginX(7 * scale);
//            player.setOrginY(8 * scale);
//            weapon = new FlameThrower();
//        }
          
        //Movement and collision detection for player
        if(input.isKeyDown(Input.KEY_A)){
            player.setCordX(player.getCordX() - player.getSpeed() * delta);
            if(player.getCordX() <= (0)){
                player.setCordX(player.getCordX() + player.getSpeed() * delta);
            }
            if(player.getCordY() + Player.getHeight()/2  >= (base.getCordY())){
                if(player.getCordY() <= (base.getCordY()+ Base.getHeight() * scale1)){
                    if(player.getCordX() + Player.getWidth()/2>= base.getCordX()){
                        if(player.getCordX() <= (base.getCordX()+ Base.getWidth() * scale1)){
                            player.setCordX(player.getCordX() + player.getSpeed() * delta);                                                     
                        }
                    }
                }
            }
        }
 
        if(input.isKeyDown(Input.KEY_D)){
            player.setCordX(player.getCordX() + player.getSpeed() * delta);
            if((player.getCordX() + Player.getHeight()) >= (width)){
                player.setCordX(player.getCordX() - player.getSpeed() * delta);
            }
            if(player.getCordY() + Player.getHeight()/2  >= (base.getCordY())){
                if(player.getCordY() <= (base.getCordY()+ Base.getHeight() * scale1)){
                    if(player.getCordX() + Player.getWidth()/2>= base.getCordX()){
                        if(player.getCordX() <= (base.getCordX() + Base.getWidth() * scale1)){
                            player.setCordX(player.getCordX() - player.getSpeed() * delta);                                                    
                        }
                    }
                }
            }
        }
 
        if(input.isKeyDown(Input.KEY_W)){
            player.setCordY(player.getCordY() - player.getSpeed() * delta);
            if(player.getCordY() <= (0)){
                player.setCordY(player.getCordY() + player.getSpeed() * delta);
            }
            if(player.getCordY() + Player.getHeight()/2  >= (base.getCordY())){
                if(player.getCordY() <= (base.getCordY()+ Base.getHeight() * scale1)){
                    if(player.getCordX() + Player.getWidth()/2>= base.getCordX()){
                        if(player.getCordX() <= (base.getCordX()+ Base.getWidth() * scale1)){
                            player.setCordY(player.getCordY() + player.getSpeed() * delta);                                                      
                        }
                    }
                }
            }
        }
        
        if(input.isKeyDown(Input.KEY_S)){
            player.setCordY(player.getCordY() + player.getSpeed() * delta);
             if((player.getCordY() + Player.getHeight()) >= (height)){
                player.setCordY(player.getCordY() - player.getSpeed() * delta);
            }
            if(player.getCordY() + Player.getHeight()/2  >= (base.getCordY())){
                if(player.getCordY() <= (base.getCordY()+ Base.getHeight() * scale1)){
                    if(player.getCordX() + Player.getWidth()/2>= base.getCordX()){
                        if(player.getCordX() <= (base.getCordX()+ Base.getWidth() * scale1)){
                            player.setCordY(player.getCordY() - player.getSpeed() * delta);                                                      
                        }
                    }
                }
            }
        }
         

         
        // turns the game off if the escape key is pressed
        if(input.isKeyDown(Input.KEY_ESCAPE)){
            System.exit(0);
        }
        
                 
        // rotating player to face the mouse
        double mouseX = input.getMouseX();
        double mouseY = input.getMouseY();
        double xDistance = mouseX - (player.getCordX() + player.getOrginX());
        double yDistance = mouseY - (player.getCordY() + player.getOrginY());
        /*double*/angleToTurn = Math.toDegrees(Math.atan2(yDistance, xDistance));
        Player.setRotation((float)angleToTurn);
           
        Player.setCenterOfRotation(player.getOrginX(), player.getOrginY());
           
           
        // Monsters
           
           
        for(int i = 0; i < MaxMonsters; i++){
            MonsterArray[i].image.setCenterOfRotation(MonsterArray[i].getOrginX(), MonsterArray[i].getOrginY());
        }

        for(int i = 0; i < MaxMonsters; i++){
               
            MonsterArray[i].setxDistancePlayer(player.getCordX()-MonsterArray[i].getCordX());
            MonsterArray[i].setyDistancePlayer(player.getCordY()-MonsterArray[i].getCordY());
            MonsterArray[i].setAngleToTurntoplayer(Math.toDegrees(Math.atan2(MonsterArray[i].getyDistancePlayer(), MonsterArray[i].getxDistancePlayer())));
               
            MonsterArray[i].setxDistanceBase(base.getCordX() + Base.getWidth()/2 - MonsterArray[i].getCordX());
            MonsterArray[i].setyDistanceBase(base.getCordY() + Base.getHeight()/2 - MonsterArray[i].getCordY());
            MonsterArray[i].setAngleToTurntobase(Math.toDegrees(Math.atan2(MonsterArray[i].getyDistanceBase(), MonsterArray[i].getxDistanceBase())));
           
            MonsterArray[i].setDistancePlayer(Math.sqrt((player.getCordX() - MonsterArray[i].getCordX())*(player.getCordX() - MonsterArray[i].getCordX()) + (player.getCordY() - MonsterArray[i].getCordY())*(player.getCordY() - MonsterArray[i].getCordY())));
            MonsterArray[i].setDistanceBase(Math.sqrt((base.getCordX() - MonsterArray[i].getCordX())*(base.getCordX() - MonsterArray[i].getCordX()) + (base.getCordY() - MonsterArray[i].getCordY())*(base.getCordY() - MonsterArray[i].getCordY())));
             
            if(MonsterArray[i].getDistancePlayer() < MonsterArray[i].getDistanceBase()){
                MonsterArray[i].image.setRotation((float)MonsterArray[i].getAngleToTurntoplayer());
            }else{
                MonsterArray[i].image.setRotation((float)MonsterArray[i].getAngleToTurntobase());
            }
        }
           
           
        for(int i = 0; i <  MaxMonsters; i++){
            if(MonsterArray[i].getCordX() <= 0){
                //System.exit(0);
            }
               
            if(MonsterArray[i].getCordX() >= width){
                //System.exit(0);
            }
               
            if(MonsterArray[i].getCordY() <= 0){
                //System.exit(0);
            }
            if(MonsterArray[i].getCordY() >= width){
                //System.exit(0);
            }  
        }
           
        // checks if monster collide with base
        // Not working properly
        for(int i = 0;i < MaxMonsters;i++){
            if(MonsterArray[i].getCordY() >= (base.getCordY() - MonsterArray[i].image.getHeight())){
                if(MonsterArray[i].getCordY() <= (base.getCordY()+ Base.getHeight() * scale1)){
                    if(MonsterArray[i].getCordX()>= base.getCordX()){
                        if(MonsterArray[i].getCordX() <= (base.getCordX()+ Base.getWidth() * scale1)){
                            base.setHealth(base.getHealth() - MonsterArray[i].getDamage());
//                            MonsterArray[i].setCordX(rand.nextInt(640));
//                            MonsterArray[i].setCordY(rand.nextInt(640));
//                            MonsterArray[i].setHealth(MonsterArray[i].getMaxHealth());
                            setSpawn(MonsterArray[i]);
                        }
                    }
                }
            }
        }
            
        // checks if monster collide with player
        // Not Working properly
        for(int i = 0; i < MaxMonsters;i++){
            if(MonsterArray[i].getCordX() >= player.getCordX()){
                if(MonsterArray[i].getCordX() <= player.getCordX() + Player.getWidth()){
                    if(MonsterArray[i].getCordY() >= player.getCordY()){
                        if(MonsterArray[i].getCordY() <= player.getCordY() + Player.getHeight()){
                            player.setHealth(player.getHealth() - MonsterArray[i].getDamage());
//                            MonsterArray[i].setCordX(rand.nextInt(640));
//                            MonsterArray[i].setCordY(rand.nextInt(640));
//                            MonsterArray[i].setHealth(MonsterArray[i].getMaxHealth());
                            setSpawn(MonsterArray[i]);
                        }
                    }
                }
            }
        }
        
//        if(monster.GetcordX() >= player.GetcordX()){
//          if(monster.GetcordX() <= player.GetcordX() + Player.getWidth()){
//                   if(monster.GetcordY() >= player.GetcordY()){
//                        if(monster.GetcordY() <= player.GetcordY() + Player.getHeight()){
//                            player.SetHealth(player.GetHealth() - monster.getDamage());
//                            monster.SetcordX(rand.nextInt(640));
//                            monster.SetcordY(rand.nextInt(640));
//                            monster.SetHealth(monster.GetMaxHealth());
//                        }
//                   }
//               }
//               
//           }
           
           
           

   
           
                     
        // Monster movement
        for(int i = 0; i < MaxMonsters; i++){
            MonsterArray[i].setCordX(MonsterArray[i].getCordX() + (MonsterArray[i].getSpeed() * delta) * (float)Math.cos(Math.toRadians(MonsterArray[i].image.getRotation())));
            MonsterArray[i].setCordY(MonsterArray[i].getCordY() + (MonsterArray[i].getSpeed() * delta) * (float)Math.sin(Math.toRadians(MonsterArray[i].image.getRotation())));
        }
           
        //Shooting
           
        // shot out of barrel is not working
           
        switch(weapon.getWeaponNbr()){
            case 1:  
                x = player.getCordX() + 23 * scale;
                y = player.getCordY() + 12 * scale;
                break;
            case 2:  
                x = player.getCordX() + 27 * scale;
                y = player.getCordY() + 13 * scale;
                break;
            case 3:  
                x = player.getCordX() + 20 * scale;
                y = player.getCordY() + 14 * scale;
                break;
            case 4:  
                x = player.getCordX() +22 * scale;
                y = player.getCordY() +9 * scale;
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
           
//           x2 = player.GetcordX() + (x * (float)Math.cos(Math.toRadians(Player.getRotation())));
//           y2 = player.GetcordY() + (y * (float)Math.sin(Math.toRadians(Player.getRotation())));
           
           x2 = player.getCordX() + WeaponOrgin * (float)Math.cos(Math.toRadians(Player.getRotation()));
           y2 = player.getCordY() + WeaponOrgin * (float)Math.sin(Math.toRadians(Player.getRotation()));
           
//           x2 = x * (float)Math.cos(Math.toRadians(angleToTurn)) - y * (float)Math.sin(angleToTurn);
//           y2 = x * (float)Math.sin(Math.toRadians(angleToTurn)) + y * (float)Math.cos(angleToTurn);
           
//           x2 = x * (float)Math.cos(Math.toRadians(Player.getRotation())) - y * (float)Math.sin(Math.toRadians(Player.getRotation()));
//           y2 = x * (float)Math.sin(Math.toRadians(Player.getRotation())) + y * (float)Math.cos(Math.toRadians(Player.getRotation()));
           
           
           
        double XDistance = mouseX - player.getCordX();
        double YDistance = mouseY - player.getCordY();
        double AngleToTurn = Math.toDegrees(Math.atan2(YDistance, XDistance));
           
           
        if(input.isMousePressed(0)){
            if(weapon.getCurrentNbrOfShots() < weapon.getMaxShots()){    
//                ShotArray[weapon.getCurrentNbrOfShots()] = new Shot(x2,y2, weapon.getDamage(),weapon.getSpeed(),weapon.getShotImageName()); 
                ShotArray[weapon.getCurrentNbrOfShots()] = new Shot(player.getCordX(), player.getCordY(), weapon.getDamage(),weapon.getSpeed(),weapon.getShotImageName()); 
                ShotArray[weapon.getCurrentNbrOfShots()].shotImage.setRotation((float)AngleToTurn);
                weapon.setCurrentNbrOfShots(weapon.getCurrentNbrOfShots() + 1);
            }              
        }
           
        for(int i = 0; i < weapon.getCurrentNbrOfShots();i++){
            ShotArray[i].setxCord(ShotArray[i].getxCord() + (ShotArray[i].getSpeed() * delta) * (float)Math.cos(Math.toRadians(ShotArray[i].shotImage.getRotation())));
            ShotArray[i].setyCord(ShotArray[i].getyCord() + (ShotArray[i].getSpeed() * delta) * (float)Math.sin(Math.toRadians(ShotArray[i].shotImage.getRotation())));
        }
           
        
        
        // Checks if the shots hit the monsters
        // Not working properly
        for(int i = 0;i<weapon.getCurrentNbrOfShots();i++){
            for(int j = 0;j<MaxMonsters;j++){
                if(weapon.getWeaponType() == 1){
                    if(ShotArray[i].getyCord() >= MonsterArray[j].getCordY()){
                        if(ShotArray[i].getyCord() <= MonsterArray[j].getCordY() + MonsterArray[j].image.getHeight()){
                            if(ShotArray[i].getxCord() >= MonsterArray[j].getCordX()){
                                if(ShotArray[i].getxCord() <= MonsterArray[j].getCordX() + MonsterArray[j].image.getWidth()){
                                    deleteShot(ShotArray, i);
                                    MonsterArray[j].setHealth(MonsterArray[j].getHealth() - ShotArray[i].getDamage());
                                }
                            }
                        }
                    }
                }
            }
        }
           
          
           // Checks if bullet hits the monster
           // Not working
//           if (WeponType == 2) {
//             if(shot.GetYCord() + Shot.getHeight()>= monster.GetcordY()){
//                if(shot.GetYCord() + Shot.getHeight() <= monster.GetcordY() + Monster.getHeight()){
//                    if(shot.GetXCord() + Shot.getWidth()>= monster.GetcordX()){
//                        if(shot.GetXCord() + Shot.getWidth() <= monster.GetcordX() + Monster.getWidth()){
//                            monster.SetHealth(monster.GetHealth()-shot.GetDamage());
//                        }
//                    }
//                }
//            }
//         }
           
           
        // Checks if the bullets go out of the screen
        for(int i = 0;i<weapon.getCurrentNbrOfShots(); i++){
            if(weapon.getWeaponType() == 1){
                if(ShotArray[i].getxCord() >= height){
                    deleteShot(ShotArray, i);
                }else if(ShotArray[i].getxCord() <= 0){
                    deleteShot(ShotArray, i);
                }else if(ShotArray[i].getyCord() >= width){
                    deleteShot(ShotArray, i);
                }else if(ShotArray[i].getyCord() <= 0){
                    deleteShot(ShotArray, i);
                }
            }
        }   

          

           
        // checks if bullets collide with base.
        // Right side needs a little bit more work
        
        for(int i = 0; i <weapon.getCurrentNbrOfShots(); i++){
            if(weapon.getWeaponType() == 1){
                if(ShotArray[i].getyCord() >= base.getCordY()){
                    if(ShotArray[i].getyCord() <= (base.getCordY()+ Base.getHeight() * scale1)){
                        if(ShotArray[i].getxCord() >= base.getCordX()){
                            if(ShotArray[i].getxCord() <= (base.getCordX()+ Base.getWidth() * scale1)){
                                base.setHealth(base.getHealth() - (ShotArray[i].getDamage()/100 + 1));
                                deleteShot(ShotArray,i);
                            }
                        }
                    }
                }
            }
        }
        
           
           
        // att göra
        // gör så att monster inte spawnar för nära eller i basen
        for(int i = 0;i<MaxMonsters;i++){
            if(MonsterArray[i].getHealth() <=0){
                setSpawn(MonsterArray[i]);
//                MonsterArray[i].setCordX(rand.nextInt(640));   
//                MonsterArray[i].setCordY(rand.nextInt(640));
//                MonsterArray[i].setHealth(MonsterArray[i].getMaxHealth());                  
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


    @Override
    public void render(GameContainer gc, Graphics g) throws SlickException{
        Background.draw(0, 0);
        Base.draw(base.getCordX(), base.getCordX(), scale1); 
        
        for(int i = 0; i < weapon.getCurrentNbrOfShots(); i++){
            ShotArray[i].shotImage.draw(ShotArray[i].getxCord(),ShotArray[i].getyCord());
        }
         
        Player.draw(player.getCordX(), player.getCordY(), scale);
         
        for (int i = 0; i < MaxMonsters; i++){
            MonsterArray[i].image.draw(MonsterArray[i].getCordX(), MonsterArray[i].getCordY(), scale);
        }
                 
        g.drawString("Base Health: " + base.getHealth(), 10, 25);
        g.drawString("Player Health: " + player.getHealth(), 10, 40);
        g.drawString("Time: " + Time/1000, 550, 10);
        g.drawString("Kills: " + kills, 550, 25);
        
        
        g.drawString("Player Rotation " + Player.getRotation(), 400, 425);
//        g.drawString("shot " + Shot.getRotation(), 400, 440);
        g.drawString("Nbt of shot " + weapon.getCurrentNbrOfShots(), 400, 440);
        g.drawString("x2   " + x2, 400, 455);
        g.drawString("y2   " + y2, 400, 470);
        g.drawString("x  " + x, 400, 505);
        g.drawString("y  " + y, 400, 520);
        g.drawString("weponorgin   " + WeaponOrgin, 400, 535);
    }
    
     
    public static void main(String[] args) throws SlickException{
        AppGameContainer app = new AppGameContainer(new MainGame(title));
        app.setDisplayMode(width, height, fullscreen);
        app.setSmoothDeltas(true);
        app.setTargetFrameRate(fpslimit);
        app.setShowFPS(showFPS);
        app.start();
    }
    
    public void deleteShot(Shot[] ar, int index){
        for(int i = index;i < weapon.getCurrentNbrOfShots() - 1; i++){
            ar[i] = ar[i+1];
        }
        weapon.setCurrentNbrOfShots(weapon.getCurrentNbrOfShots() - 1);
    }
    
    public void setSpawn(Monster monster){
        int randX, randY, border;
        randX = rand.nextInt(width);
        randY = rand.nextInt(height);
        border = 120;
        
        //Sets the spawn of the monster in the outer parts of the window
        while (randX > border && randX < (width - border)){
            randX = rand.nextInt(width);
        }
        while (randY > border && randY < (height - border)){
            randY = rand.nextInt(height);
        }
        
        monster.setCordX(randX);
        monster.setCordY(randY);
        monster.setHealth(monster.getMaxHealth());   
        
    }
       
}