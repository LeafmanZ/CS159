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
public class Scoreboard
{
  /*
   * Our scoreboard attributes. Our lives and score in the game.
   */
  private static int lives;
  private static int score;

  /**
   * Construct our scoreboard. All it has is set our lives and score. It isn't necessary do it in
   * the constructor and could be put in the attributes already.
   */
  Scoreboard()
  {
    lives = 3;
    score = 0;
  }

  /**
   * Update our scoreboard in the game.
   */
  public void update()
  {
    StdDraw.text(GameConstants.SCORE_X, GameConstants.SCORE_Y, "Score: " + score);
    StdDraw.text(GameConstants.LIVES_X, GameConstants.LIVES_Y, "Life: " + lives);
  }

  /**
   * Decrement lives attribute.
   */
  public void death()
  {
    lives--;
  }

  /**
   * Increment points attribute.
   * 
   * @param points
   *          that we get for killing an object.
   */
  public void kill(int points)
  {
    score += points;
  }

  /**
   * Get our lives attribute value.
   * 
   * @return lives
   */
  public int getLives()
  {
    return lives;
  }

  /**
   * Get our score attribute value.
   * 
   * @return score
   */
  public int getScore()
  {
    return score;
  }
}
