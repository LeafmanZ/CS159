/**
 * A mover object that moves in random moves.
 * 
 * References and acknowledgements: I worked with Hafiz Buyan and used the occasional TA help. I do
 * not remember the TA names however they did help. Next time I will ask for their names.
 * 
 * @author Jim Zieleman
 * @version 4/3/19
 * 
 */
public class Saucer extends Mover
{
  /*
   * Saucer visibility attribute
   */
  private boolean visible;

  /**
   * Construct my saucer object. We super the location and vector to the parent. Visible is set to
   * true when the saucer is first made as it is on the screen.
   */
  Saucer()
  {
    double xPosition = GameConstants.GENERATOR.nextInt(GameConstants.SCREEN_HEIGHT + 1);
    double yPosition = GameConstants.GENERATOR.nextInt(GameConstants.SCREEN_WIDTH + 1);
    super.location = new Point(xPosition, yPosition);
    super.vector = new Vector2D(Math.random() * GameConstants.SAUCER_DIRECTION_PROB,
        GameConstants.SAUCER_SPEED);
    visible = true;
  }

  /**
   * Draw our object on the game.
   */
  public void draw()
  {

    StdDraw.rectangle(location.getX(), location.getY(), GameConstants.SAUCER_WIDTH / 2,
        GameConstants.SAUCER_HEIGHT / 2);
  }

  /**
   * Update the object on the game. Randomized movements.
   */
  public void update()
  {
    location.move(vector);
    if (GameConstants.GENERATOR.nextDouble() <= .05)
    {
      vector.setHeading(GameConstants.GENERATOR.nextDouble() * (Math.PI * 2));
      location.move(vector);
    }
  }

  /**
   * See if the object is visible on the game screen or not.
   * 
   * @return visible of object
   */
  public boolean isVisible()
  {
    if (location.getX() > GameConstants.SCREEN_WIDTH || location.getX() < 0
        || location.getY() > GameConstants.SCREEN_HEIGHT || location.getY() < 0)
    {
      visible = false;
    }
    return visible;
  }
}
