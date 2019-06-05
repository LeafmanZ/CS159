
package gamePlay;

import java.util.Random;

/**
 * Board--Keeps the 4x4 grid of letters, mixing it, making it accessible, and checkinletter words
 * against it to make sure that they are really present. As an aid to algorithms, asking for a
 * letter in an illegal board position returns a special Board.NON_LETTER character. Also, letters
 * can be marked as "in use"; requesting an in use letter return the special NON_LETTER character.
 * This facility also aids in searching the board.
 * 
 * References and acknowledgments: I worked with occasional TAs.
 *
 * @author Jim Zieleman
 * @version 4/18/19
 */
public class Board
{
  public static final char NON_LETTER = '\0';
  public static final int DIMENSION = 4;
  private static final int RANDOM_RANGE = 96;
  private static final char[] LETTER // Boggle frequencies of occurrence
      = {'j', 'k', 'q', 'y', 'z', // frequency 1 in 96
          'b', 'c', 'f', 'g', 'm', 'p', 'v', // frequency 2 in 96
          'b', 'c', 'f', 'g', 'm', 'p', 'v', 'd', 'u', 'w', 'x', // frequency 3 in 96
          'd', 'u', 'w', 'x', 'd', 'u', 'w', 'x', 'h', 'l', 'r', // frequency 5 in 96
          'h', 'l', 'r', 'h', 'l', 'r', 'h', 'l', 'r', 'h', 'l', 'r', 'a', 'i', 'n', 's', 'o', // frequency
                                                                                               // 6
                                                                                               // in
                                                                                               // 96
          'a', 'i', 'n', 's', 'o', 'a', 'i', 'n', 's', 'o', 'a', 'i', 'n', 's', 'o', 'a', 'i', 'n',
          's', 'o', 'a', 'i', 'n', 's', 'o', 'e', 't', // frequency 10 in 96
          'e', 't', 'e', 't', 'e', 't', 'e', 't', 'e', 't', 'e', 't', 'e', 't',

          'e', 't', 'e', 't'};
  private char[][] grid;
  private boolean[][] inUse;

  /**
   * Construct our Board object. This will instantiate our grid and inUse.
   */
  public Board()
  {
    grid = new char[DIMENSION][DIMENSION];
    inUse = new boolean[DIMENSION][DIMENSION];
    for (int i = 0; i < grid.length; i++)
    {
      for (int j = 0; j < grid[i].length; j++)
      {
        grid[i][j] = NON_LETTER;
        inUse[i][j] = false;
      }
    }
  }

  /**
   * Construct our Board object. This will instantiate our grid and inUse.
   * 
   * @param grid
   *          our board we want to use for the game.
   */
  public Board(char[][] grid)
  {
    this.grid = grid;
    inUse = new boolean[grid.length][grid.length];
    for (int i = 0; i < grid.length; i++)
    {
      for (int j = 0; j < grid[i].length; j++)
      {
        this.grid[i][j] = grid[i][j];
        inUse[i][j] = false;
      }
    }
  }

  /**
   * Mix up our board.
   */
  public void mix()
  {
    Random rand = new Random();

    for (int i = 0; i < grid.length; i++)
    {
      for (int j = 0; j < grid[i].length; j++)
      {
        double number = (rand.nextDouble() * Board.RANDOM_RANGE);
        grid[i][j] = LETTER[(int) number];
        inUse[i][j] = false;
      }
    }
  }

  /**
   * Get our char at the specified coordinates.
   * 
   * @param row
   *          of grid
   * @param col
   *          of grid
   * @return char of the coords.
   * 
   */
  public char charAt(int row, int col)
  {
    if (row < 0 || col < 0 || row >= DIMENSION || col >= DIMENSION)
    {
      return NON_LETTER;
    }
    return grid[row][col];
  }

  /**
   * Set our char at the specified coordinates to true.
   * 
   * @param row
   *          of grid
   * @param col
   *          of grid
   * @return char of the coords.
   * 
   */
  public char useCharAt(int row, int col)
  {
    if (row < 0 || row >= DIMENSION || col < 0 || col >= DIMENSION || inUse[row][col])
    {
      return NON_LETTER;
    }
    inUse[row][col] = true;
    return grid[row][col];
  }

  /**
   * Set our char at the specified coordinates to false.
   * 
   * @param row
   *          of grid
   * @param col
   *          of grid
   * 
   */
  public void unUseCharAt(int row, int col)
  {
    inUse[row][col] = false;
  }

  /**
   * Set our char at all coordinates to false.
   */
  public void unUseAll()
  {
    for (int i = 0; i < inUse.length; i++)
    {
      for (int j = 0; j < inUse.length; j++)
      {
        inUse[i][j] = false;
      }
    }
  }

  /**
   * Check if a specified word is in our board.
   * 
   * @param word
   *          that we want to see if it is in the board
   * @return boolean true if the word is in the board else false.
   *         /home/autograde/autolab/src/gamePlay/Board.java
   * 
   */
  public boolean isOnBoard(String word)
  {

    if (word == null)
    {
      unUseAll();
      return false;
    }

    if (word.length() == 0)
    {
      return true;
    }
    for (int i = 0; i < grid.length; i++)
    {
      for (int j = 0; j < grid[i].length; j++)
      {
        if (grid[i][j] == word.charAt(0))
        {
          inUse[i][j] = true;
          if (stringFinder(i, j, word.substring(1)))
          {
            return true;
          }
          inUse[i][j] = false;
        }
      }
    }
    unUseAll();
    return false;
  }

  /**
   * Find our possible word combinations in the board.
   * 
   * @param i
   *          row of grid
   * @param j
   *          col of grid
   * @param word
   *          we are trying to complete.
   * @return String the words that we can find.
   * 
   */
  private boolean stringFinder(int i, int j, String word)
  {

    int minI = i - 1;
    int maxI = i + 1;
    int minJ = j - 1;
    int maxJ = j + 1;

    if (word.length() == 0)
    {
      unUseAll();
      return true;
    }

    for (int i2 = minI; i2 <= maxI; i2++)
    {
      for (int j2 = minJ; j2 <= maxJ; j2++)
      {
        if (word.charAt(0) == charAt(i2, j2) && !isInUse(i2, j2))
        {
          inUse[i][j] = true;
          if (stringFinder(i2, j2, word.substring(1)))
          {
            return true;
          }
          inUse[i][j] = false;
        }
      }
    }
    return false;
  }

  /**
   * Get our boolean if used or not at the specified coordinates.
   * 
   * @param row
   *          of grid
   * @param col
   *          of grid
   * @return boolean of the coords if they are used.
   * 
   */
  boolean isInUse(int row, int col)
  {
    return inUse[row][col];
  }

  /**
   * Get our grid.
   *
   * @return grid our board.
   */
  public char[][] getGrid()
  {
    return grid;
  }

}

