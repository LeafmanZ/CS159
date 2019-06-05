import java.util.ArrayList;

/**
 * This class creates and access' aisle.
 * 
 * @author Jim Zieleman
 * @version 2/8/19
 * 
 */

public class Aisle
{
  private int aisleNumber;
  private int custInLine;
  private int custServed;
  private ArrayList<Customer> customers;

  /**
   * Create an aisle object.
   * 
   * @param customer
   *          our customer
   * @param items
   *          our customers items
   * @param id
   *          our customers ids
   * @param aisleNumber
   *          that we have
   *
   */
  Aisle(Customer customer, int items, int id, int aisleNumber)
  {

  }

  /**
   * Get our customer waiting amount.
   * 
   * @return custInLine our customers waiting
   */
  public int getCustInLine()
  {
    return custInLine;
  }

  /**
   * Get our customers served amount.
   * 
   * @return custServed our customers served.
   */
  public int getCustServed()
  {
    return custServed;
  }

  /**
   * Remove our customer from waiting.
   * 
   * @param id
   *          our customer id.
   */
  public void removeCust(int id)
  {

  }

  /**
   * Gain a customer in our line.
   * 
   * @param id
   *          our new customer id.
   */
  public void addCust(int id)
  {

  }

}
