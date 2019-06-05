/**
 * Manages and stores all my Moving objects attributes and forced methods to implement.
 * 
 * References and acknowledgements: I worked with Hafiz Buyan and used the occasional TA help. I do
 * not remember the TA names however they did help. Next time I will ask for their names.
 * 
 * @author Jim Zieleman
 * @version 4/3/19
 * 
 */
public class Asteroid extends Mover
{

  /**
   * Construct our asteroid object. This will just super the Vector and Location values to Mover.
   */
  Asteroid()
  {
    super.vector = new Vector2D(GameConstants.GENERATOR.nextDouble(), GameConstants.ASTEROID_SPEED);
    super.location = new Point(GameConstants.GENERATOR.nextInt(GameConstants.SCREEN_HEIGHT),
        GameConstants.GENERATOR.nextInt(GameConstants.SCREEN_HEIGHT));
  }

  /**
   * Update our object positions on the game.
   */
  public void update()
  {
    location.moveAndWrap(vector, GameConstants.SCREEN_WIDTH, GameConstants.SCREEN_HEIGHT);
  }

  /**
   * Draw our object on the game. It will be a circle.
   */
  public void draw()
  {
    StdDraw.circle(location.getX(), location.getY(), GameConstants.ASTEROID_RADIUS);
  }
}
