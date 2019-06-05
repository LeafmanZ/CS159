
package gamePlay;

import java.util.HashSet;

/**
 * ComputerPlayer--The computer playing the game and finding all the words in the game.
 * 
 * References and acknowledgments: I worked with occasional TAs.
 *
 * @author Jim Zieleman
 * @version 4/18/19
 */
public class ComputerPlayer extends Player
{
  private Dictionary dictionary;

  /**
   * Construct our computer player object.
   * 
   * @param d
   *          the dictionary our computer player will check with the board
   * 
   */
  public ComputerPlayer(Dictionary d)
  {
    super();
    this.dictionary = d;
  }

  /**
   * Find the words in our board.
   * 
   * @param b
   *          our board
   * 
   */
  public void findWords(Board b)
  {
    // wordSet = new HashSet<>(wordSet);
    // char[][] grid = b.getGrid();
    wordSet = new HashSet<>();
    for (String s : dictionary.getList())
    {
      if (b.isOnBoard(s))
      {
        wordSet.add(s);
        System.out.println(s);
      }
    }
  }
}

