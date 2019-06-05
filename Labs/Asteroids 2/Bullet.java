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
public class Bullet extends Mover
{
  /*
   * Attribute holds our bullets life time per iteration in update.
   */
  private int bulletLife;

  /**
   * Construct our bullet object.
   * 
   * @param x
   *          position of ship.
   * @param y
   *          position of ship.
   * @param heading
   *          of ship.
   */
  Bullet(double x, double y, double heading)
  {
    super.pose = new Pose(x, y, heading);
    super.vector = new Vector2D(this.pose.getHeading(), GameConstants.BULLET_SPEED);

  }

  /**
   * Update our object on the game screen.
   */
  public void update()
  {
    pose.moveAndWrap(vector, GameConstants.SCREEN_WIDTH, GameConstants.SCREEN_HEIGHT);
    bulletLife++;
  }

  /**
   * Draw our object on the game screen.
   */
  public void draw()
  {
    StdDraw.setPenColor(StdDraw.WHITE);
    StdDraw.filledCircle(pose.getX(), pose.getY(), GameConstants.BULLET_RADIUS);
  }

  /**
   * Get our bulletsLife so that if it is too old in the game it will be removed after some
   * iterations.
   * 
   * @return bulletLife time
   */
  public int getBulletLife()
  {
    return bulletLife;
  }
}
