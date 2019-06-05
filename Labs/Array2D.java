/**
 * Array2D - Utility methods for working with ragged 2d double arrays.
 * 
 * @author - YOUR NAME GOES HERE
 * @version - V1 - YOUR DATE GOES HERE
 */
public class Array2D
{

  /**
   * Return true if the indicated row exists in this 2d array.
   * 
   * A row exists if:
   * <ul>
   * <li>The row index is valid
   * <li>The row is not null
   * <li>The length of the row is not 0.
   * </ul>
   * 
   * @param values
   *          The two dimensional array
   * @param row
   *          The row index to check
   * @return true if the row exists in this array, false otherwise
   */
  public static boolean isRowValid(double[][] values, int row)
  {
    if (values == null || row < 0 || row >= values.length || values[row] == null
        || values[row].length == 0)
    {
      return false;
    }
    return true;
  }

  /**
   * Return true if the indicated column exists in this 2d array.
   * 
   * A column exists if:
   * <ul>
   * <li>The column index is non-negative
   * <li>At least one row is long enough to contain the column entry
   * </ul>
   * 
   * @param values
   *          The two dimensional array
   * @param col
   *          The column to check
   * @return true if the row exists in this array, false otherwise
   */
  public static boolean isColumnValid(double[][] values, int col)
  {

    if (col < 0)
    {
      return false;
    }
    else if (values[0].length >= col)
    {
      return true;
    }
    return false;
  }

  /**
   * Return the number of doubles stored in the array.
   * 
   * @param values
   *          The two dimensional array
   * @return The number of entries.
   */
  public static int countEntries(double[][] values)
  {
    int count = 0;
    for (int i = 0; i < values.length; i++)
    {
      if (isRowValid(values, i))
      {
        count += values[i].length;
      }
    }
    // HINT: This method should -not- use a nested for loop.
    return count;
  }

  /**
   * Return the sum of all the values in one row of the array.
   * 
   * @param values
   *          The two dimensional array
   * @param row
   *          The index (0 based) of the row to sum
   * 
   * @return The sum of the row array elements. Returns Double.MIN_VALUE if the row is not valid.
   * 
   */
  public static double getRowTotal(double[][] values, int row)
  {
    double count = 0;
    for (int i = 0; i < values[row].length; i++)
    {
      count += values[row][i];
    }
    return count;
  }

  /**
   * Return the sum of all the values in the the array.
   * 
   * @param values
   *          The two dimensional array
   * @return The sum of the array elements. Returns Double.MIN_VALUE if there are no entries in the
   *         array
   */
  public static double getTotal(double[][] values)
  {
    double count = 0;
    for (int i = 0; i < values.length; i++)
    {
      if (isRowValid(values, i))
      {
        count += getRowTotal(values, i);
      }
    }
    return count;
  }

  // --------------------------------------------------------------------
  // METHODS BELOW ARE OPTIONAL. COMPLETE THEM IF YOU WANT MORE PRACTICE.
  // --------------------------------------------------------------------

  /**
   * Return the average of all the values of the array.
   * 
   * 
   * @param values
   *          The two dimensional array
   * @return The average of the array elements. Returns Double.MIN_VALUE if there are no entries in
   *         the array
   */

  public static double getAverage(double[][] values)
  {
    // HINT: No loops. Use the methods you implemented above.
    return 0;
  }

  /**
   * Return the sum of all the values in one column of the array.
   * 
   * @param values
   *          The two dimensional array
   * @param col
   *          The number (0 based) of the column to sum
   * 
   * @return The sum of the array elements in that column. Returns Double.MIN_VALUE if the column is
   *         not valid.
   * 
   */
  public static double getColumnTotal(double[][] values, int col)
  {

    return 0;
  }

  /**
   * Return the the largest value in one row of the array.
   * 
   * @param values
   *          The two dimensional array
   * @param row
   *          The number (0 based) of the row to examine
   * 
   * @return The highest of the row array elements. Returns Double.MIN_VALUE if the row does not
   *         exist.
   */
  public static double getHighestInRow(double[][] values, int row)
  {
    return 0;
  }

  /**
   * This method returns a new two dimensional array in which the rows and columns have been
   * exchanged. In other words, the first row from the original array will be the first column in
   * the new array, the second row from the original array will be the second column in the original
   * array, etc. This method may only be applied to rectangular arrays.
   * 
   * 
   * @param values
   *          The two dimensional array
   * 
   * @return A newly created transpose array
   */
  public static double[][] transpose(double[][] values)
  {
    return new double[0][0];
  }

}
