import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ChangeMakingMachineTest
{

  @Test
  void testChangeMachine()
  {
    new ChangeMakingMachine();
  }

  @Test
  void testChangeMachineInt()
  {
    new ChangeMakingMachine(1);
  }

  @Test
  void testChangeMachineIntProduct()
  {
    new ChangeMakingMachine(1, new Product());
  }

  @Test
  void testNegSlotNumBuyIntIntInt()
  {
    try
    {
      ChangeMakingMachine cm = new ChangeMakingMachine(1, new Product());
      cm.buy(-1, 2, 0);
    }
    catch (IllegalArgumentException iae)
    {
      assertTrue(true);
    }
  }

  @Test
  void testBigSlotNumBuyIntIntInt()
  {
    try
    {
      ChangeMakingMachine cm = new ChangeMakingMachine(1, new Product());
      cm.buy(1, 2, 0);
    }
    catch (IllegalArgumentException iae)
    {
      assertTrue(true);
    }
  }

  @Test
  void testBadQuarterBuyIntIntInt()
  {
    try
    {
      ChangeMakingMachine cm = new ChangeMakingMachine(1, new Product());
      cm.buy(0, -2, 0);
    }
    catch (IllegalArgumentException iae)
    {
      assertTrue(true);
    }
  }

  @Test
  void testBadDollarBuyIntIntInt()
  {
    try
    {
      ChangeMakingMachine cm = new ChangeMakingMachine(1, new Product());
      cm.buy(0, 0, -1);
    }
    catch (IllegalArgumentException iae)
    {
      assertTrue(true);
    }
  }

  @Test
  void testNegQuarterBuyIntIntInt()
  {
    ChangeMakingMachine cm = new ChangeMakingMachine(1, new Product());
    assertEquals(-1, cm.buy(0, 1, 0));

  }

  @Test
  void testNegDollarBuyIntIntInt()
  {
    ChangeMakingMachine cm = new ChangeMakingMachine(1, new Product("Coke", 25, 125));
    assertEquals(-1, cm.buy(0, 0, 1));
  }

  @Test
  void testGoodQuarterBuyIntIntInt()
  {
    ChangeMakingMachine cm = new ChangeMakingMachine(1, new Product());
    assertEquals(25, cm.buy(0, 3, 0));

  }

  @Test
  void testGoodDollarBuyIntIntInt()
  {
    ChangeMakingMachine cm = new ChangeMakingMachine(1, new Product("Coke", 25, 125));
    assertEquals(75, cm.buy(0, 0, 2));
  }

  @Test
  void testPerfQuarterBuyIntIntInt()
  {
    ChangeMakingMachine cm = new ChangeMakingMachine(1, new Product());
    assertEquals(0, cm.buy(0, 2, 0));

  }

  @Test
  void testPerfDollarBuyIntIntInt()
  {
    ChangeMakingMachine cm = new ChangeMakingMachine(1, new Product("Coke", 25, 120));
    assertEquals(0, cm.buy(0, 1, 1));
  }

  @Test
  void testFalseBuyIntIntInt()
  {
    ChangeMakingMachine cm = new ChangeMakingMachine(1, new Product("Coke", 25, 120));
    for (int i = 0; i < Slot.SLOT_SIZE; i++)
    {
      cm.buy(0);
    }
    assertFalse(cm.buy(0));
  }

  @Test
  void testTrueBuyIntIntInt()
  {
    ChangeMakingMachine cm = new ChangeMakingMachine(1, new Product("Coke", 25, 120));
    assertTrue(cm.buy(0));
  }

}
