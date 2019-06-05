/**
 * The change-making machine will add the functionality of being able to pay with cash and.
 * potentially get change back. The change will just be returned as an integer value in cents, but
 * the amount paid in will be determined by the number of quarters and dollars that are entered.
 * 
 * @author Jim Zieleman
 * @version 2/19/19
 */
public class ChangeMakingMachine extends VendingMachine
{
  /**
   * Performs the same action for the ChangeMakingMachine as VendingMachine().
   */
  ChangeMakingMachine()
  {
    super();
  }

  /**
   * Performs the same action for the ChangeMakingMachine as VendingMachine(int size).
   * 
   * @param size
   *          slots that we want
   */
  ChangeMakingMachine(int size)
  {
    super(size);
  }

  /**
   * Performs the same action for the ChangeMakingMachine as VendingMachine(int size, Product.
   * product)
   * 
   * @param size
   *          slots
   * @param product
   *          to put in slots
   * @throws IllegalArgumentException
   *           for bad args
   */
  ChangeMakingMachine(int size, Product product) throws IllegalArgumentException
  {
    super(size, product);
  }

  /**
   * Models buying one item from the slot number indicated. Throws an IllegalArgumentException if.
   * the slotNum is out of bounds or if quarters or dollars are negative. Computes the amount of
   * money put into the machine in quarters and dollars, returning -1 if there is not enough money
   * to buy the product and returning the positive difference or change if there is any. Makes
   * appropriate adjustments to machineProfit and totalProfit by adding the price to the profit
   * values if the buy is successful. (Hint: Use a public method to accomplish this.).
   * 
   * @param slotNum
   *          of slot we want to buy from
   * @param quarters
   *          put in
   * @param dollars
   *          put infail("Not yet implemented");
   * @return our change
   * @throws IllegalArgumentException
   *           for bad args
   */
  public int buy(int slotNum, int quarters, int dollars) throws IllegalArgumentException
  {
    if (quarters < 0 || dollars < 0)
    {
      throw new IllegalArgumentException();
    }

    int moneyIn = (dollars * 100) + (quarters * 25);
    if (moneyIn < nextProduct(slotNum).getPrice())
    {
      return -1;
    }
    int change = moneyIn - nextProduct(slotNum).getPrice();
    super.buy(slotNum);
    // need to remove product after bought
    // call method that adds total profits
    return change; // changes after removed

  }
}
