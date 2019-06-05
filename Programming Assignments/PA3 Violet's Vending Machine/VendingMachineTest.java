import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class VendingMachineTest
{

  @Test
  void testDefaultVendingMachine()
  {
    VendingMachine.resetTotalProfit();
    new VendingMachine();
  }

  @Test
  void testVendingMachine()
  {
    VendingMachine.resetTotalProfit();
    new VendingMachine(10);
  }

  @Test
  void testVendingMachineFull()
  {
    VendingMachine.resetTotalProfit();
    Product product = new Product("Doritos", 200, 250);
    new VendingMachine(10, product);
  }

  // GENERIC LOAD
  @Test
  void testDefaultVendingMachineGenLoad()
  {
    VendingMachine.resetTotalProfit();
    VendingMachine vm = new VendingMachine();
    vm.load();
    assertEquals(-3750, vm.getMachineProfit());
  }

  @Test
  void testVendingMachineGenLoad()
  {
    VendingMachine vm = new VendingMachine(10);
    vm.load();
    assertEquals(-2500, vm.getMachineProfit());
  }

  // NON GENERIC LOAD
  @Test
  void testDefaultVendingMachineLoad()
  {
    VendingMachine.resetTotalProfit();
    VendingMachine vm = new VendingMachine();
    vm.load(1, 5, new Product("Doritos", 200, 250));
    assertEquals(-1000, vm.getMachineProfit());
  }

  @Test
  void testVendingMachineLoad()
  {
    VendingMachine.resetTotalProfit();
    VendingMachine vm = new VendingMachine(10);
    vm.load(1, 5, new Product("Doritos", 200, 250));
    assertEquals(-1000, vm.getMachineProfit());
  }

  // LOAD BAD PRODUCT
  @Test
  void testBPDefaultVendingMachineLoad()
  {
    VendingMachine.resetTotalProfit();
    try
    {
      VendingMachine vm = new VendingMachine();
      vm.load(1, 5, null);
    }
    catch (IllegalArgumentException iae)
    {
      assertTrue(true);
    }
  }

  @Test
  void testBPVendingMachineLoad()
  {
    VendingMachine.resetTotalProfit();
    try
    {
      VendingMachine vm = new VendingMachine(10);
      vm.load(1, 5, null);
    }
    catch (IllegalArgumentException iae)
    {
      assertTrue(true);
    }
  }

  // LOAD BAD COUNT
  @Test
  void testBCDefaultVendingMachineLoad()
  {
    VendingMachine.resetTotalProfit();
    try
    {
      VendingMachine vm = new VendingMachine();
      vm.load(1, -5, new Product("Doritos", 200, 250));
    }
    catch (IllegalArgumentException iae)
    {
      assertTrue(true);
    }
  }

  @Test
  void testBCVendingMachineLoad()
  {
    VendingMachine.resetTotalProfit();
    try
    {
      VendingMachine vm = new VendingMachine(10);
      vm.load(1, 25, new Product("Doritos", 200, 250));
    }
    catch (IllegalArgumentException iae)
    {
      assertTrue(true);
    }
  }

  // LOAD BAD SLOTNUM
  @Test
  void testSNDefaultVendingMachineLoad()
  {
    VendingMachine.resetTotalProfit();
    try
    {
      VendingMachine vm = new VendingMachine();
      vm.load(-1, 5, new Product("Doritos", 200, 250));
    }
    catch (IllegalArgumentException iae)
    {
      assertTrue(true);
    }
  }

  @Test
  void testSNVendingMachineLoad()
  {
    VendingMachine.resetTotalProfit();
    try
    {
      VendingMachine vm = new VendingMachine(10);
      vm.load(11, 3, new Product("Doritos", 200, 250));
    }
    catch (IllegalArgumentException iae)
    {
      assertTrue(true);
    }
  }

  // NEXT PRODUCT
  @Test
  void testNullVendingMachineNextProduct()
  {
    VendingMachine.resetTotalProfit();
    VendingMachine vm = new VendingMachine();
    assertEquals(null, vm.nextProduct(0));
  }

  @Test
  void testVendingMachineNextProduct()
  {
    VendingMachine.resetTotalProfit();
    Product product = new Product("Doritos", 200, 250);
    VendingMachine vm = new VendingMachine(10);
    vm.load(0, 3, product);
    assertEquals(product, vm.nextProduct(0));
  }

  @Test
  void testBadSlotNumVendingMachineNextProduct()
  {
    VendingMachine.resetTotalProfit();
    try
    {
      VendingMachine vm = new VendingMachine(10);
      vm.nextProduct(-1);
    }
    catch (IllegalArgumentException iae)
    {
      assertTrue(true);
    }
  }

  // BUY
  @Test
  void testVendingMachineBuy()
  {
    VendingMachine.resetTotalProfit();
    VendingMachine vm = new VendingMachine(10, new Product("Doritos", 200, 250));
    vm.buy(0);
    assertEquals(-19750, vm.getMachineProfit());
  }

  @Test
  void testFullVendingMachineBuy()
  {
    VendingMachine.resetTotalProfit();
    VendingMachine vm = new VendingMachine(10, new Product("Doritos", 200, 250));
    for (int i = 0; i < Slot.SLOT_SIZE; i++)
    {
      for (int j = 0; j < vm.getSlotCount(); j++)
      {
        vm.buy(j);
      }
    }
    assertEquals(5000, vm.getMachineProfit());
  }

  @Test
  void testNullVendingMachineBuy()
  {
    VendingMachine.resetTotalProfit();
    VendingMachine vm = new VendingMachine(1, new Product("Doritos", 200, 250));
    for (int i = 0; i < Slot.SLOT_SIZE; i++)
    {
      vm.buy(0);
    }
    assertEquals(false, vm.buy(0));
  }

  @Test
  void testBadSlotNumVendingMachineBuy()
  {
    VendingMachine.resetTotalProfit();
    try
    {
      VendingMachine vm = new VendingMachine(1, new Product("Doritos", 200, 250));
      vm.buy(-1);
    }
    catch (IllegalArgumentException iae)
    {
      assertTrue(true);
    }
  }

  // GET SLOT COUNT
  @Test
  void testVendingMachineGetSlotCount()
  {
    VendingMachine.resetTotalProfit();
    VendingMachine vm = new VendingMachine(1, new Product("Doritos", 200, 250));
    assertEquals(1, vm.getSlotCount());
  }

  // GET TOTAL PROFIT
  @Test
  void testVendingMachineGetTotalProfit()
  {
    VendingMachine.resetTotalProfit();
    @SuppressWarnings("unused")
    VendingMachine vm = new VendingMachine(1, new Product("Doritos", 200, 250));
    assertEquals(-2000, VendingMachine.getTotalProfit());
  }

  // RESET TOTAL PROFIT
  @Test
  void testVendingMachineResetTotalProfit()
  {
    VendingMachine.resetTotalProfit();
    @SuppressWarnings("unused")
    VendingMachine vm = new VendingMachine(1, new Product("Doritos", 200, 250));
    VendingMachine.resetTotalProfit();
    assertEquals(0, VendingMachine.getTotalProfit());

  }

  @Test
  void testVendingMachineToString()
  {
    VendingMachine.resetTotalProfit();
    VendingMachine vm1 = new VendingMachine(1, new Product("Doritos", 200, 250));
    @SuppressWarnings("unused")
    VendingMachine vm2 = new VendingMachine(1, new Product("Doritos", 200, 250));
    assertEquals(
        "Vending Machine\n" + "SlotCount: 10 of \n" + "Product: Doritos Cost: 2.00 Price: 2.50.\n"
            + "Product: Doritos Cost: 2.00 Price: 2.50.\n"
            + "Product: Doritos Cost: 2.00 Price: 2.50.\n"
            + "Product: Doritos Cost: 2.00 Price: 2.50.\n"
            + "Product: Doritos Cost: 2.00 Price: 2.50.\n"
            + "Product: Doritos Cost: 2.00 Price: 2.50.\n"
            + "Product: Doritos Cost: 2.00 Price: 2.50.\n"
            + "Product: Doritos Cost: 2.00 Price: 2.50.\n"
            + "Product: Doritos Cost: 2.00 Price: 2.50.\n"
            + "Product: Doritos Cost: 2.00 Price: 2.50.\n"
            + "Total Profit: -40.00 Machine Profit: -20.00.",
        vm1.toString());
  }

}
