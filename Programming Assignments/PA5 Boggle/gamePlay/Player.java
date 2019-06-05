
package gamePlay;

import java.util.HashSet;
import java.util.Set;

/**
 * Player-- is our score controller, and is extended by human and computer player for the words they
 * found.
 * 
 * References and acknowledgments: I worked with occasional TAs.
 *
 * @author Jim Zieleman
 * @version 4/18/19
 */
public abstract class Player
{
  protected int totalScore;
  protected int roundScore;
  protected Set<String> wordSet;

  /**
   * Construct our player object.
   * 
   */
  public Player()
  {
    this.totalScore = 0;
    this.roundScore = 0;
    this.wordSet = new HashSet<>();
  }

  /**
   * Reset the players scores.
   * 
   */
  public void resetScores()
  {
    this.totalScore = 0;
    this.roundScore = 0;
  }

  /**
   * Assign a score for our player.
   * 
   * @param s
   *          the amount we need to change our score by.
   */
  public void assignRoundScore(int s)
  {
    this.roundScore = s;
    this.totalScore += s;
  }

  /**
   * Decreasing the score to our player.
   * 
   * @param s
   *          the amount we are decrementing our score by.
   * 
   */
  public void decrementRoundScore(int s)
  {
    this.roundScore -= s;
    this.totalScore -= s;
  }

  /**
   * Set our set of words to the given set.
   * 
   * @param set
   *          of words we are passing.
   * 
   */
  public void setWordSet(Set<String> set)
  {
    if (!(set == null || set.isEmpty()))
    {
      wordSet = new HashSet<String>(wordSet);
      for (String s : set)
      {
        if (!(s == null || s.isEmpty()))
        {
          if (s.matches("[a-zA-Z]+"))
          {
            wordSet.add(s.toLowerCase());
          }
        }
      }
    }
  }

  /**
   * Get our roundscore.
   * 
   * @return roundscore.
   */
  public int getRoundScore()
  {
    return roundScore;
  }

  /**
   * Get our totalscore.
   * 
   * @return totalscore.
   */
  public int getTotalScore()
  {
    return totalScore;
  }

  /**
   * Get our wordset.
   * 
   * @return wordset.
   */
  public Set<String> getWordSet()
  {
    return wordSet;
  }

  /**
   * Make our child classes find the words in the board.
   * 
   * @param b
   *          the board we are going to pass.
   */
  public abstract void findWords(Board b);
}

