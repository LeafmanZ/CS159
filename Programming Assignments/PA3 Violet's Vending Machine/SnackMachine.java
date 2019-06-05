import java.util.ArrayList;

/**
 * The snack machine will inherit from the ChangeMakingMachine. The difference is it will have an.
 * additional instance variable of an array list of products which will indicate the type of product
 * each slot should contain and its load method will fill each slot completely with the particular
 * product the slot contains, making appropriate adjustments to the profit tallies.
 * 
 * @author Jim Zieleman
 * @version 2/19/19
 */
public class SnackMachine extends ChangeMakingMachine
{
  /*
   * contains the list of products for each slot in the SnackMachine. The first position in the.
   * productList corresponds to the product in the first slot in the slots array.
   */
  private ArrayList<Product> productList;

  /**
   * This constructor initializes the product list of the SnackMachine and creates a new snack.
   * machine where each slot is full of the product indicated in the matching position in the
   * product list. The size of the snack machine is just the length of the product list.
   * 
   * @param pList
   *          of products
   */
  @SuppressWarnings("unchecked")
  SnackMachine(ArrayList<Product> pList)
  {
    super(pList.size());
    productList = (ArrayList<Product>) pList.clone();
    load();
  }

  /**
   * This load method completely fills each slot in the snack machine with the appropriate product.
   * As a slot is filled, the total cost of the items is subtracted from the profit tallies.
   */
  public void load()
  {
    int j = 0;
    for (int i = 0; i < getSlotCount(); i++)
    {
      if (nextProduct(i) == null)
      {
        super.load(i, Slot.SLOT_SIZE, productList.get(j));
        j++;
      }
    }
  }
}
