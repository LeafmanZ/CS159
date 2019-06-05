import java.util.ArrayList;

/**
 * Stationary white circles that look like stars in the background.
 * 
 * References and acknowledgements: I worked with Hafiz Buyan and used the occasional TA help. I do
 * not remember the TA names however they did help. Next time I will ask for their names.
 * 
 * @author Jim Zieleman
 * @version 4/3/19
 * 
 */
public class Star
{
  /*
   * Store x,y positions of all the stars in my game.
   */
  private ArrayList<Integer> x;
  private ArrayList<Integer> y;

  /**
   * Construct star object.
   */
  Star()
  {
    x = new ArrayList<Integer>();
    y = new ArrayList<Integer>();
    /*
     * Randomly assign star coordinates
     */
    for (int i = 0; i < GameConstants.NUMBER_OF_STARS; i++)
    {
      x.add(GameConstants.GENERATOR.nextInt(GameConstants.SCREEN_WIDTH));
      y.add(GameConstants.GENERATOR.nextInt(GameConstants.SCREEN_HEIGHT));
    }
  }

  /**
   * Display our stars using StdDraw.
   */
  public void draw()
  {
    for (int i = 0; i < GameConstants.NUMBER_OF_STARS; i++)
    {
      StdDraw.filledCircle(x.get(i), y.get(i), GameConstants.STAR_RADIUS);
    }
  }
}
