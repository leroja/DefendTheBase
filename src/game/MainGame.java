package game;

/**
 * Imports
 */
import org.newdawn.slick.*;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author Lennart
 */
public class MainGame extends StateBasedGame{
    /**
     * Game state identifiers
     */
    public static final int MAINMENU     = 0;
    public static final int GAME         = 1;
    
    /**
     * Constants
     */
    private static final int HEIGHT = 640;
    private static final int WIDTH = 640;
    private static final boolean FULLSCREEN = false;
    private static final boolean SHOWFPS = true;
    private static final String TITLE = "Defend The Base";
    private static final int FPSLIMIT = 60;

    /**
     *
     * @param title
     */
    public MainGame(String title){
        super(title);
//        this.enterState(1);
    }

    /**
     *
     * @param args
     * @throws SlickException
     */
    public static void main(String[] args) throws SlickException{
        AppGameContainer app = new AppGameContainer(new MainGame(TITLE));
        app.setDisplayMode(WIDTH, HEIGHT, FULLSCREEN);
        app.setSmoothDeltas(true);
        app.setTargetFrameRate(FPSLIMIT);
        app.setShowFPS(SHOWFPS);
        app.start();
    }

    @Override
    public void initStatesList(GameContainer gc) throws SlickException {
        // The first state added will be the one that is loaded first, when the application is launched
        this.addState(new MainMenu());
        this.addState(new EndlessGameMode(TITLE));
        this.addState(new WaveBasedGameMode());
        this.addState(new HighScoreScreen());
        this.addState(new Options());
    }

}