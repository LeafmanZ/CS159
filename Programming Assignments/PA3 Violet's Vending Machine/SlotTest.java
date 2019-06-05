import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SlotTest
{

  @Test
  void testSlot()
  {
    new Slot();
  }

  @Test
  void testDefaultLoadProduct()
  {
    Product product = new Product();
    Slot slot = new Slot();
    assertEquals(10, slot.load(product));
  }

  @Test
  void testLoadProduct()
  {

    Product product = new Product();
    Slot slot = new Slot(product);
    assertEquals(0, slot.load(product));
  }

  @Test
  void testDefaultLoadProductInt()
  {
    Product product = new Product();
    Slot slot = new Slot();
    assertEquals(5, slot.load(product, 5));
  }

  @Test
  void testLoadProductInt()
  {
    Product product = new Product();
    Slot slot = new Slot(product);
    assertEquals(0, slot.load(product, 5));
  }

  @Test
  void testDefaultLoadZeroProductInt()
  {
    Product product = new Product();
    Slot slot = new Slot();
    assertEquals(0, slot.load(product, 0));
  }

  @Test
  void testLoadZeroProductInt()
  {
    Product product = new Product();
    Slot slot = new Slot(product);
    assertEquals(0, slot.load(product, 0));
  }

  @Test
  void testDefaultNextProduct()
  {
    Slot slot = new Slot();
    assertEquals(null, slot.nextProduct());
  }

  @Test
  void testB1DefaultNextProduct()
  {
    Slot slot = new Slot();
    slot.load(null);
    assertEquals(null, slot.nextProduct());
  }

  @Test
  void testNextProduct()
  {
    Product product = new Product();
    Slot slot = new Slot(product);
    assertEquals(product, slot.nextProduct());
  }

  @Test
  void testDefaultBuyOne()
  {
    Slot slot = new Slot();
    assertEquals(null, slot.buyOne());
  }

  @Test
  void testB1DefaultBuyOne()
  {
    Slot slot = new Slot();
    slot.load(null);
    assertEquals(null, slot.buyOne());
  }

  @Test
  void testBuyOne()
  {
    Product product = new Product();
    Slot slot = new Slot(product);
    assertEquals(product, slot.buyOne());
  }

  @Test
  void testToString()
  {
    Product product = new Product();
    Slot slot = new Slot(product);
    assertEquals("SlotCount: 10 of \n" + "Product: Generic Cost: 0.25 Price: 0.50.\n"
        + "Product: Generic Cost: 0.25 Price: 0.50.\n"
        + "Product: Generic Cost: 0.25 Price: 0.50.\n"
        + "Product: Generic Cost: 0.25 Price: 0.50.\n"
        + "Product: Generic Cost: 0.25 Price: 0.50.\n"
        + "Product: Generic Cost: 0.25 Price: 0.50.\n"
        + "Product: Generic Cost: 0.25 Price: 0.50.\n"
        + "Product: Generic Cost: 0.25 Price: 0.50.\n"
        + "Product: Generic Cost: 0.25 Price: 0.50.\n" + "Product: Generic Cost: 0.25 Price: 0.50.",
        slot.toString());
  }

}
