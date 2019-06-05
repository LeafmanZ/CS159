/**
 * The VendingMachine class is a simple vending machine. Exact change is required so it is assumed.
 * if someone is buying something they have inserted the right amount of money or have used a debit
 * card. The get methods return the appropriate instance variable values.
 * 
 * @author Jim Zieleman
 * @version 2/19/19
 */
public class VendingMachine
{
  /*
   * the default size for a VendingMachine, used primarily by the default constructor.
   */
  public static final int DEFAULT_SIZE = 15;
  /*
   * this models the total profit for all of the VendingMachines together. It is the sum of the.
   * price of every product bought from all of the machines minus the sum of the cost of all the
   * products ever put in all of the machines. Note that it is protected in the UML diagram so it is
   * accessible to classes that inherit from this class.
   */
  protected static int totalProfit = 0;
  /*
   * this models the long term profit for this particular machine. It is the sum of the price of.
   * every product bought from this machine minus the sum of the cost of all the products ever put
   * in this machine. Note that it is protected in the UML diagram so it is accessible to classes
   * that inherit from this class.
   */
  protected int machineProfit = 0;
  /*
   * this array models the array of slots in the VendingMachine.
   */
  private Slot[] slots;

  /**
   * The default constructor creates a VendingMachine with DEFAULT_SIZE empty slots.
   */
  VendingMachine()
  {
    slots = new Slot[DEFAULT_SIZE];
  }

  /**
   * Creates a VendingMachine with the indicated number of empty slots.
   * 
   * @param size
   *          slots
   */
  VendingMachine(int size)
  {
    slots = new Slot[size];
    for (int i = 0; i < slots.length; i++)
    {
      slots[i] = new Slot();
    }
  }

  /**
   * Creates a VendingMachine with size slots each full of product.
   * 
   * @param size
   *          slots
   * @param product
   *          in slots
   */
  VendingMachine(int size, Product product)
  {
    this(size);
    for (int i = 0; i < size; i++)
    {
      int countLoaded = slots[i].load(product);
      machineProfit -= (countLoaded * product.getCost());
      totalProfit -= (countLoaded * product.getCost());
    }

  }

  /**
   * Loads an empty or partially empty VendingMachine with a Generic product for testing purposes.
   * Makes appropriate adjustments to machineProfit and totalProfit by subtracting costs from profit
   * values.
   * 
   */
  public void load()
  {
    Product product = new Product();

    for (int i = 0; i < slots.length; i++)
    {
      Slot slot = new Slot();
      int num = slot.load(product);
      slots[i] = slot;
      totalProfit -= num * product.getCost();
      this.machineProfit -= num * product.getCost();
    }
  }

  /**
   * Loads the slot indicated by slotNum with product until it is full or until count is reached.
   * Makes appropriate adjustments to machineProfit and totalProfit by subtracting costs from profit
   * values. Throws an IllegalArgumentException if the slotNum is out of bounds, the count is less
   * than or equal to zero, or if the product is null.
   * 
   * @param slotNum
   *          is the slot position on the array of slots
   * @param count
   *          the amount of spots in the slot to fill
   * @param product
   *          is the item put in the slot
   * @throws IllegalArgumentException
   *           for bad args
   */
  public void load(int slotNum, int count, Product product) throws IllegalArgumentException
  {
    if (product == null || count < 0 || (count > Slot.SLOT_SIZE))
    {
      throw new IllegalArgumentException();
    }
    try
    {
      Slot slot = new Slot();
      int num = slot.load(product, count);
      slots[slotNum] = slot;
      this.machineProfit -= num * product.getCost();
      totalProfit -= num * product.getCost();
    }
    catch (ArrayIndexOutOfBoundsException obe)
    {
      throw new IllegalArgumentException();
    }
  }

  /**
   * Returns a reference to the next available product in the indicated slot or null if the slot is.
   * empty. Throws an IllegalArgumentException if the slotNum is out of bounds.
   * 
   * @param slotNum
   *          is the next available slot
   * @return product of the next available slot
   * @throws IllegalArgumentException
   *           for bad args
   */
  public Product nextProduct(int slotNum) throws IllegalArgumentException
  {

    try
    {
      if (slots[slotNum] == null)
      {
        return null;
      }
      return slots[slotNum].nextProduct();
    }
    catch (ArrayIndexOutOfBoundsException obe)
    {
      throw new IllegalArgumentException();
    }

  }

  /**
   * Models buying one item from the slot number indicated. Makes appropriate adjustments to.
   * machineProfit and totalProfit by adding the price to the profit values. Throws an
   * IllegalArgumentException if the slotNum is out of bounds. Returns false if there is no product
   * to buy.
   * 
   * @param slotNum
   *          of the slot we want to buy from
   * @return false if there is no product to buy
   * @throws IllegalArgumentException
   *           for bad args
   */
  public boolean buy(int slotNum) throws IllegalArgumentException
  {
    try
    {
      if (slots[slotNum].nextProduct() == null)
      {
        return false;
      }
      else
      {
        Product bought = slots[slotNum].buyOne();
        machineProfit += bought.getPrice();
        totalProfit += bought.getPrice();
        return true;
      }
    }
    catch (ArrayIndexOutOfBoundsException obe)
    {
      throw new IllegalArgumentException();
    }

  }

  /**
   * Gets our amount of slots.
   * 
   * @return number of slots
   */
  public int getSlotCount()
  {
    return slots.length;
  }

  /**
   * Gets our total profit.
   * 
   * @return total profit
   */
  public static int getTotalProfit()
  {
    return totalProfit;
  }

  /**
   * This method resets the totalProfit static instance variable to zero. This is useful when.
   * testing to make sure that different method tests start out in a known state for the static
   * variable so the final value can be computed without knowing the order of the test runs.
   * 
   */
  public static void resetTotalProfit()
  {
    totalProfit = 0;
  }

  /**
   * Gets our machines profit.
   * 
   * @return total machine profit
   */
  public int getMachineProfit()
  {
    return machineProfit;
  }

  /**
   * returns a String representing the VendingMachine, each slot, the machineProfit and totalProfit.
   * exactly as shown below for a 2-slot VendingMachine filled with Generic product where nothing
   * has been bought (so the profits are negative).
   * 
   * @return String of our entire vending machine
   */
  public String toString()
  {
    String vm = "Vending Machine\n";
    for (int i = 0; i < getSlotCount(); i++)
    {
      vm += slots[i].toString() + "\n";
    }
    vm += String.format("Total Profit: %.02f Machine Profit: %.02f.", totalProfit / 100.00,
        machineProfit / 100.0);
    return vm;
  }
}
