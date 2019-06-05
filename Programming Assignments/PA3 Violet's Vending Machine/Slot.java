import java.util.ArrayList;

/**
 * The Slot class models a slot in the vending machine.
 * 
 * @author Jim Zieleman
 * @version 2/19/19
 */
public class Slot
{
  /*
   * The maximum number of products that a slot in the vending machine can hold.
   */
  public static final int SLOT_SIZE = 10;
  /*
   * models the actual products that are in the slot. Removing the one at the front models buying.
   * one of the products in the slot and all of the others are moved forward similar to an actual
   * vending machine.
   */
  private ArrayList<Product> products;

  /**
   * The Slot() constructor creates an empty array list of products.
   */
  Slot()
  {
    this.products = new ArrayList<Product>();
  }

  /**
   * This constructor creates a new slot that is filled with SLOT_SIZE of product.
   * 
   * @param product
   *          our product passed
   */
  Slot(Product product)
  {
    this();
    for (int i = 0; i < SLOT_SIZE; i++)
    {
      products.add(product);
    }
  }

  /**
   * This method loads the slot with however many new products are required to make sure it is full.
   * and returns the number of products it took to fill the slot.
   * 
   * @param product
   *          that is loaded
   * @return products used
   */
  public int load(Product product)
  {
    int countLoaded = 0;
    if (products.size() >= SLOT_SIZE)
    {
      return 0;
    }
    countLoaded = SLOT_SIZE - products.size();
    for (int i = 0; i < countLoaded; i++)
    {
      products.add(product);
    }
    return countLoaded;
  }

  /**
   * This method loads the slot with up to count new products in an attempt to fill the slot and.
   * returns the number of products it used.
   * 
   * @param product
   *          loaded
   * @param count
   *          of products attempted to load
   * @return number of products used
   */
  public int load(Product product, int count)
  {
    // probably put cap for 10
    int countLoaded = SLOT_SIZE - products.size();
    int countGiven = count;
    if (countLoaded <= countGiven)
    {
      countGiven = countLoaded;
    }
    for (int i = 0; i < countGiven; i++)
    {
      products.add(product);
    }
    return countGiven;

  }

  /**
   * This method returns a reference to the next product available for purchase. If the slot is.
   * empty this method will return null.
   * 
   * @return Product that is next available for purchase
   */
  public Product nextProduct()
  {
    if (products.size() == 0 || products.get(0) == null)
    {
      return null;
    }
    return products.get(0);

  }

  /**
   * This method simulates the purchase of one item from the perspective of the slot. That means no.
   * money is dealt with here, rather the slot is checked to make sure there is product to buy and
   * then one product is removed from the front of the ArrayList modeling the slot. If a product is
   * successfully removed from the slot, it is returned, otherwise null is returned.
   * 
   * @return Product removed from the slot
   */
  public Product buyOne()
  {
    if (products.size() > 0 && products.get(0) != null)
    {
      Product bought = products.get(0);
      products.remove(0);
      return bought;
    }
    return null;

  }

  /**
   * The toString() method returns a String exactly like the one below for a slot with 10 M&M.
   * products.
   * 
   * @return String of products in slot
   */
  public String toString()
  {
    String slot = String.format("SlotCount: %d of ", SLOT_SIZE);
    for (int i = 0; i < products.size(); i++)
    {
      slot += "\n" + products.get(i).toString();
    }
    return slot;
  }
}
