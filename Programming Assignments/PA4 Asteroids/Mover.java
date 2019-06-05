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
public abstract class Mover
{
  /*
   * Storing my vector, location and pose attributes for all my movers.
   */
  protected Vector2D vector;
  protected Point location;
  protected Pose pose;

  /**
   * Child classes will have to draw on the screen.
   */
  public abstract void draw();

  /**
   * Child classes will have to update object movement.
   */
  public abstract void update();

  /**
   * Give objects pose.
   * 
   * @return Pose
   */
  public Pose getPose()
  {
    return pose;
  }

  /**
   * Give objects point.
   * 
   * @return Point
   */
  public Point getPoint()
  {
    return location;
  }
}
