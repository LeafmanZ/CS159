import java.util.ArrayList;
import java.util.Iterator;

/**
 * Manage all my game objects.
 * 
 * References and acknowledgements: I worked with Hafiz Buyan and used the occasional TA help. I do
 * not remember the TA names however they did help. Next time I will ask for their names.
 * 
 * @author Jim Zieleman
 * @version 4/3/19
 * 
 */
public class AsteroidsGame
{
  /*
   * Storage for all duplicated game Movers
   */
  private ArrayList<Asteroid> asteroids;
  private ArrayList<Bullet> bullets;
  private ArrayList<Saucer> saucers;
  /*
   * Storage for my non moving or non duplicatable objects
   */
  private Ship ship;
  private Star star;
  private Scoreboard scoreboard;

  /**
   * Construct our game.
   * 
   * @param numAsteroids
   *          that are passed by the GameDriver
   */
  AsteroidsGame(int numAsteroids)
  {
    /*
     * Instantiate our duplicated game movers
     */
    asteroids = new ArrayList<Asteroid>();
    bullets = new ArrayList<Bullet>();
    saucers = new ArrayList<Saucer>();
    /*
     * Add asteroids to the game
     */
    for (int i = 0; i < numAsteroids; i++)
    {
      Asteroid asteroid = new Asteroid();
      asteroids.add(asteroid);
    }

    /*
     * Instantiate non moving or non duplicatable objects.
     */
    ship = new Ship();
    star = new Star();
    scoreboard = new Scoreboard();

  }

  /**
   * The actual running of the game. Here we will be updating the game constantly.
   */
  public void update()
  {
    /*
     * We continue to update until lives are 0.
     */
    if (scoreboard.getLives() > 0)
    {
      scoreboard.update();
      // COLLISION ASTEROID LOOPS VS SHIP
      for (int i = 0; i < asteroids.size(); i++)
      {
        // Check if ship is within asteroid distance
        if (ship.getPose().distance(asteroids.get(i).getPoint()) < (GameConstants.ASTEROID_RADIUS
            + GameConstants.COLLISION_RADIUS))
        {
          asteroids.remove(i);
          ship = new Ship();
          scoreboard.death();
          scoreboard.kill(GameConstants.ASTEROID_POINTS);
        }
      }

      // COLLISION ASTEROID LOOPS VS BULLET LOOPS
      for (int i = 0; i < asteroids.size(); i++)
      {
        Asteroid a = asteroids.get(i);
        // Check if bullets is within asteroid distance
        for (int j = 0; j < bullets.size(); j++)
        {
          Bullet b = bullets.get(j);
          if (b.getPose().distance(
              a.getPoint()) < (GameConstants.BULLET_RADIUS + GameConstants.ASTEROID_RADIUS))
          {
            bullets.remove(j);
            asteroids.remove(i);
            scoreboard.kill(GameConstants.ASTEROID_POINTS);
          }
        }
      }

      // COLLISION BULLET LOOPS SAUCER LOOPS
      for (int j = 0; j < bullets.size(); j++)
      {
        Bullet b = bullets.get(j);
        // Check if bullets is within saucer distance
        for (int k = 0; k < saucers.size(); k++)
        {

          if (b.getPose().distance(saucers.get(k).getPoint()) < (GameConstants.BULLET_RADIUS
              + GameConstants.SAUCER_WIDTH))
          {

            bullets.remove(j);
            saucers.remove(k);
            scoreboard.kill(GameConstants.SAUCER_POINTS);
          }
        }
      }

      // COLLISION SAUCER LOOPS SHIP
      for (int k = 0; k < saucers.size(); k++)
      {
        // Check if ship is within saucer distance
        if (ship.getPose().distance(saucers.get(k).getPoint()) < (GameConstants.COLLISION_RADIUS
            + GameConstants.SAUCER_WIDTH))
        {
          saucers.remove(k);
          ship = new Ship();
          scoreboard.death();
          scoreboard.kill(GameConstants.SAUCER_POINTS);
        }
      }

      // UPDATE ALL MOVER POSITIONS
      for (Asteroid a : asteroids)
      {
        a.update();
      }
      for (int i = 0; i < saucers.size(); i++)
      {

        if (saucers.get(i).isVisible())
        {
          saucers.get(i).update();
        }
        else
        {
          saucers.remove(i);
        }
      }
      for (Bullet b : bullets)
      {
        b.update();
      }

      // CHECK LEVEL
      spawnAsteroids();

      // UPDATE SHIP
      ship.update();

      // SHOOTING
      if (StdDraw.hasNextKeyTyped() && StdDraw.nextKeyTyped() == ' ')
      {
        Bullet bullet = new Bullet(ship.getXPos(), ship.getYPos(), ship.getHeading());
        bullets.add(bullet);
      }

      // Spawn new saucer if the randomly generated number is less than the threshold
      if (GameConstants.GENERATOR.nextDouble() < GameConstants.SAUCER_APPEARANCE_PROB)
      {
        saucers.add(new Saucer());
      }

      // CHECK BULLET LIFETIME
      Iterator<Bullet> iterator = bullets.iterator();
      while (iterator.hasNext())
      {
        if (((Bullet) iterator.next()).getBulletLife() >= GameConstants.BULLET_LIFETIME)
        {
          iterator.remove();
        }
      }
    }
    // IF SCORE IS NO LONGER GREATER THAN 0 WE STOP UPDATING
    else
    {
      scoreboard.update();
    }

  }

  /**
   * Draw our objects on the game.
   */
  public void draw()
  {
    StdDraw.setPenColor(StdDraw.WHITE);

    star.draw();

    for (Asteroid a : asteroids)
    {
      a.draw();
    }
    ship.draw();
    for (Bullet b : bullets)
    {
      b.draw();
    }
    for (Saucer s : saucers)
    {
      s.draw();
    }

  }

  /**
   * Our asteroid replenishment after all are destroyed.
   */
  private void spawnAsteroids()
  {
    if (asteroids.size() == 0 && saucers.size() == 0)
    {
      for (int i = 0; i < GameConstants.DEFAULT_ASTEROIDS_PER_LEVEL; i++)
      {
        Asteroid asteroid = new Asteroid();
        asteroids.add(asteroid);
      }
    }
  }
}
