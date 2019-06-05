
public class ToughAsteroid extends Asteroid
{
  private int health = 4;
  /**
   * Construct our asteroid object. This will just super the Vector and Location values to Mover.
   */
  ToughAsteroid()
  {
    super();
  }

  /**
   * Draw our object on the game. It will be a circle.
   */
  public void draw()
  {
    StdDraw.circle(location.getX(), location.getY(), GameConstants.ASTEROID_RADIUS * health);
  }
  
  public void weGotHit() {
    health--;
  }
  
  public boolean isHealthOne() {
    if(health <= 1) {
      return true;
    } else
      return false;
  }
}
