import java.util.ArrayList;

/**
 * The simulator will provide a means of simulating a small business of vending machines. The.
 * vending machines of the business are stored in an array list. Vending machines can be added to
 * the list using the provided method to simulate the growth of a business. Simulation of the
 * business running and selling product is done by simulating a specific number of products being
 * bought from every slot of every vending machine in the business and returning the totalProfit of
 * all of the vending machines in cents.
 * 
 * @author Jim Zieleman
 * @version 2/19/19
 */

public class Simulator
{
  /*
   * models the list of vending machines owned by the company.
   */
  private ArrayList<VendingMachine> vmList;

  /**
   * Instantiates a Simulator.
   * 
   * @param vmmList
   *          of VendingMachine objects
   */
  @SuppressWarnings("unchecked")
  Simulator(ArrayList<VendingMachine> vmmList)
  {
    this.vmList = (ArrayList<VendingMachine>) vmmList.clone();
  }

  /**
   * Adds the VendingMachine indicated by vm to the end of the list of vending machines owned by.
   * the company.
   * 
   * @param vm
   *          a VendingMachine object
   */
  public void addVM(VendingMachine vm)
  {
    vmList.add(vm);
  }

  /**
   * Simulates buying pCount products from every slot of every VendingMachine owned by the company.
   * Returns the totalProfit of all of the VendingMachines.
   * 
   * @param pCount
   *          our products bought
   * @return totalProfit of the machines
   */
  public int simulate(int pCount)
  {
    for (int i = 0; i < vmList.size(); i++)
    {
      VendingMachine vm = vmList.get(i);
      for (int j = 0; j < vm.getSlotCount(); j++)
      {
        for (int k = 0; k < pCount; k++)
        {
          vm.buy(j);
        }
      }
    }

    return VendingMachine.getTotalProfit();
  }
}
