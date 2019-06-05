/**
 * This class creates and access' customer.
 * 
 * @author Jim Zieleman
 * @version 2/8/19
 * 
 */

public class Customer
{
  private int items;
  private int id;
  private int time;

  /**
   * Create a customer object.
   * 
   * @param items
   *          customer items.
   * @param id
   *          for individual customer object.
   */
  Customer(int items, int id)
  {

  }

  /**
   * Get our customer item amount.
   * 
   * @return items that we have.
   */
  public int getItems()
  {
    return items;
  }

  /**
   * Get our time that customer has spent.
   * 
   * @return time that customer took.
   */
  public int getTime()
  {
    return time;
  }

}
