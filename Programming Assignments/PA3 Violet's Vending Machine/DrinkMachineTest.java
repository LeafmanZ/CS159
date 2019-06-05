import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DrinkMachineTest
{

  @Test
  void testDrinkMachine()
  {
    new DrinkMachine();
  }

  @Test
  void testDrinkMachineIntProduct()
  {
    new DrinkMachine(10, new Product());
  }

  @Test
  void testBadSlotNumBuy()
  {
    try
    {
      DrinkMachine dm = new DrinkMachine();
      dm.buy(-1);
    }
    catch (IllegalArgumentException iae)
    {
      assertTrue(true);
    }
  }

  @Test
  void testBigSlotNumBuy()
  {
    try
    {
      DrinkMachine dm = new DrinkMachine(1, new Product());
      dm.buy(1);
    }
    catch (IllegalArgumentException iae)
    {
      assertTrue(true);
    }
  }

  @Test
  void testNumBuy()
  {
    DrinkMachine dm = new DrinkMachine(1, new Product());
    dm.buy(0);
    assertEquals(-210, dm.getMachineProfit());
  }

  @Test
  void testFalseNumBuy()
  {
    DrinkMachine dm = new DrinkMachine(1, new Product());
    for (int i = 0; i < Slot.SLOT_SIZE; i++)
    {
      dm.buy(0);
    }
    assertFalse(dm.buy(0));
  }
}
