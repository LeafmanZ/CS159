/**
 * The object that is player controlled and can shoot bullets to kill saucer and asteroids.
 * 
 * References and acknowledgements: I worked with Hafiz Buyan and used the occasional TA help. I do
 * not remember the TA names however they did help. Next time I will ask for their names.
 * 
 * @author Jim Zieleman
 * @version 4/3/19
 * 
 */
public class Ship extends Mover
{
  /**
   * Construct our ship that that player will move.
   */
  Ship()
  {
    double xPos = GameConstants.SCREEN_HEIGHT / 2;
    double yPos = GameConstants.SCREEN_WIDTH / 2;
    super.pose = new Pose(xPos, yPos, GameConstants.SHIP_START_HEADING);
    super.vector = new Vector2D(pose.getHeading(), GameConstants.SHIP_START_SPEED);
  }

  /**
   * Update our objects movements. Unlike other movers this one will be moved by player input keys.
   */
  public void update()
  {
    if (StdDraw.isKeyPressed(java.awt.event.KeyEvent.VK_RIGHT))
    {
      pose.setHeading(pose.getHeading() - GameConstants.SHIP_TURN_SPEED);
    }
    if (StdDraw.isKeyPressed(java.awt.event.KeyEvent.VK_LEFT))
    {
      pose.setHeading(pose.getHeading() + GameConstants.SHIP_TURN_SPEED);
    }
    if (StdDraw.isKeyPressed(java.awt.event.KeyEvent.VK_DOWN))
    {
      GameUtils.applyThrust(vector, pose.getHeading(), GameConstants.SHIP_ACCELERATION);

    }
    else
    {
      vector.setMagnitude(vector.getMagnitude() * GameConstants.SHIP_FRICTION);
    }
    pose.moveAndWrap(vector, GameConstants.SCREEN_WIDTH, GameConstants.SCREEN_HEIGHT);

  }

  /**
   * Draw our object on the game.
   */
  public void draw()
  {
    GameUtils.drawPoseAsTriangle(pose, GameConstants.SHIP_WIDTH, GameConstants.SHIP_HEIGHT);
  }

  /**
   * Get object heading. This is where the bullets will be shot from.
   * 
   * @return heading
   */
  public double getHeading()
  {
    return pose.getHeading();
  }

  /**
   * Get object X Position.
   * 
   * @return xPosition
   */
  public double getXPos()
  {
    return pose.getX();
  }

  /**
   * Get object Y Position.
   * 
   * @return yPosition
   */
  public double getYPos()
  {
    return pose.getY();
  }
}
