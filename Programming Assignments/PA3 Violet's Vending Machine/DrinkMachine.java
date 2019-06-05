/**
 * The drink machine inherits from the general VendingMachine described above. The only additions.
 * are a constant for the cooling charge and a different buy method which will affect the profit for
 * the machine and the total profit differently than in the general VendingMachine. DrinkMachines
 * will assess a charge for keeping the drink cold when the drink is purchased.
 * 
 * @author Jim Zieleman
 * @version 2/19/19
 */
public class DrinkMachine extends VendingMachine
{
  /*
   * IllegalArgumentException This models the ten-cent charge assessed to each drink when it is
   * purchased to account for the refrigeration costs of the drink machine.
   */
  public static final int COOLING_CHARGE = 10;

  /**
   * Performs the same action for the DrinkMachine as VendingMachine().
   */
  DrinkMachine()
  {
    super();
  }

  /**
   * Performs the same action for the DrinkMachine as VendingMachine(int size, Product product).
   * 
   * @param size
   *          slots
   * @param product
   *          that we put in our vending machine
   */
  DrinkMachine(int size, Product product)
  {
    super(size, product);
  }

  /**
   * Models buying one item from the slot number indicated. Throws an IllegalArgumentException if.
   * the slotNum is out-of-bounds. Makes appropriate adjustments to machineProfit and totalProfit by
   * adding the price (Hint: use a public method) minus the COOLING_CHARGE to the profit values.
   * 
   * @param slotNum
   *          of the slots we want to buy from
   * @return false if there is no product to buy
   * @throws IllegalArgumentException
   *           for bad args
   */
  public boolean buy(int slotNum) throws IllegalArgumentException
  {
    if (nextProduct(slotNum) == null)
    {
      return false;
    }
    super.buy(slotNum);
    machineProfit -= COOLING_CHARGE;
    totalProfit -= COOLING_CHARGE;
    // total profit
    return true;
  }
}
