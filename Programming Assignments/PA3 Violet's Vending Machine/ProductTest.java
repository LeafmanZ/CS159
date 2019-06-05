import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ProductTest
{

  @Test
  void testProduct()
  {
    new Product();
  }

  // BAD CONSTRUCTOR
  @Test
  void testBadConstructorName()
  {
    try
    {
      new Product(null, 125, 125);
    }
    catch (IllegalArgumentException iae)
    {
      assertTrue(true);
    }
  }

  @Test
  void testBadConstructorCost()
  {
    try
    {
      new Product("", -125, 125);
    }
    catch (IllegalArgumentException iae)
    {
      assertTrue(true);
    }
  }

  @Test
  void testBadConstructorPrice()
  {
    try
    {
      new Product("", 125, -125);
    }
    catch (IllegalArgumentException iae)
    {
      assertTrue(true);
    }
  }

  // PERFECT SMALLER PRICE CONSTRUCTOR
  @Test
  void testSmPriceConstructorGetName()
  {
    Product product = new Product("M&M", 125, 100);
    assertEquals("M&M", product.getName());
  }

  @Test
  void testSmPriceConstructorGetCost()
  {
    Product product = new Product("M&M", 125, 100);
    assertEquals(125, product.getCost());
  }

  @Test
  void testSmPriceConstructorGetPrice()
  {
    Product product = new Product("M&M", 125, 100);
    ;
    assertEquals(150, product.getPrice());
  }

  @Test
  void testSmPriceConstructorToString()
  {
    Product product = new Product("M&M", 125, 150);
    assertEquals("Product: M&M Cost: 1.25 Price: 1.50.", product.toString());
  }

  // PERFECT PRICE CONSTRUCTOR
  @Test
  void testPerfPriceConstructorGetName()
  {
    Product product = new Product("M&M", 125, 150);
    assertEquals("M&M", product.getName());
  }

  @Test
  void testPerfPriceConstructorGetCost()
  {
    Product product = new Product("M&M", 125, 150);
    assertEquals(125, product.getCost());
  }

  @Test
  void testPerfPriceConstructorGetPrice()
  {
    Product product = new Product("M&M", 125, 150);
    ;
    assertEquals(150, product.getPrice());
  }

  @Test
  void testPerfPriceConstructorToString()
  {
    Product product = new Product("M&M", 125, 150);
    assertEquals("Product: M&M Cost: 1.25 Price: 1.50.", product.toString());
  }

  // PERFECT NORMAL CONSTRUCTOR
  @Test
  void testPerfConstructorGetName()
  {
    Product product = new Product("M&M", 125, 125);
    assertEquals("M&M", product.getName());
  }

  @Test
  void testPerfConstructorGetCost()
  {
    Product product = new Product("M&M", 125, 125);
    assertEquals(125, product.getCost());
  }

  @Test
  void testPerfConstructorGetPrice()
  {
    Product product = new Product("M&M", 125, 125);
    ;
    assertEquals(150, product.getPrice());
  }

  @Test
  void testPerfConstructorToString()
  {
    Product product = new Product("M&M", 125, 125);
    assertEquals("Product: M&M Cost: 1.25 Price: 1.50.", product.toString());
  }

  // IMPERFECT NORMAL CONSTRUCTOR
  @Test
  void testImperfConstructorGetName()
  {
    Product product = new Product("Cheese", 102, 110);
    assertEquals("Cheese", product.getName());
  }

  @Test
  void testImperfConstructorGetCost()
  {
    Product product = new Product("Cheese", 102, 110);
    assertEquals(102, product.getCost());
  }

  @Test
  void testImperfConstructorGetPrice()
  {
    Product product = new Product("Cheese", 102, 110);
    ;
    assertEquals(125, product.getPrice());
  }

  @Test
  void testImperfConstructorToString()
  {
    Product product = new Product("Cheese", 102, 110);
    assertEquals("Product: Cheese Cost: 1.02 Price: 1.25.", product.toString());
  }

  // DEFAULT CONSTRUCTOR TESTS
  @Test
  void testDefaultConstructorGetName()
  {
    Product product = new Product();
    assertEquals("Generic", product.getName());
  }

  @Test
  void testDefaultConstructorGetCost()
  {
    Product product = new Product();
    assertEquals(25, product.getCost());
  }

  @Test
  void testDefaultConstructorGetPrice()
  {
    Product product = new Product();
    assertEquals(50, product.getPrice());
  }

  @Test
  void testDefaultConstructorToString()
  {
    Product product = new Product();
    assertEquals("Product: Generic Cost: 0.25 Price: 0.50.", product.toString());
  }

}
