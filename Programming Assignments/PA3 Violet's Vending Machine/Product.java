/**
 * The Product class models an individual item type in a vending machine. Each product has a name.
 * cost. and price. Note that cost is the cost of the product to the vending machine company. Price
 * is the price that the vending machine will charge the customer. Violet has said that she is
 * unwilling to deal with anything but quarters, dollar bills, and debit cards so all prices are
 * kept divisible by 25 cents. Costs to the vending machine company can be any penny value. All of
 * the get methods perform the expected operation.
 * 
 * @author Jim Zieleman
 * @version 2/19/19
 */
public class Product
{
  /*
   * Note: cost and price are both integers. All money in the vending machine is represented as
   * cents to enable simpler math and eliminate rounding issues.
   */
  public static final int ROUND_PRICE = 25;
  private String name;
  private int cost;
  private int price;

  /**
   * The default constructor will create an instance of a product with a name of Generic, a cost. of
   * ROUND_PRICE = 25 cents and a price of twice the ROUND_PRICE.
   * 
   */
  Product()
  {
    this.name = "Generic";
    this.cost = ROUND_PRICE;
    this.price = ROUND_PRICE * 2;
  }

  /**
   * This constructor takes the name, cost, and price as parameters and sets the instance variables.
   * appropriately. Null string names or negative cost or price should throw an
   * IllegalArgumentException. prices should be rounded to the next ROUND_PRICE cents above the
   * amount given if the amount given if not already divisible by ROUND_PRICE. Note: if the price
   * given is not greater than the cost, the price should be the next ROUND_PRICE-divisible-value
   * that is greater than the cost.
   * 
   * @param name
   *          of product
   * @param cost
   *          of product
   * @param price
   *          of product
   * @throws IllegalArgumentException
   *           is thrown
   */
  Product(String name, int cost, int price) throws IllegalArgumentException
  {
    if (name == null || cost < 0 || price < 0)
    {
      throw new IllegalArgumentException();
    }

    if (price <= cost)
    {
      this.price = cost - (cost % ROUND_PRICE) + ROUND_PRICE;
    }
    else if ((price % ROUND_PRICE) == 0)
    {
      this.price = price;
    }
    else
    {
      this.price = price - (price % ROUND_PRICE) + ROUND_PRICE;
    }
    this.name = name;
    this.cost = cost;
  }

  /**
   * Get object name.
   * 
   * @return string of name
   */
  public String getName()
  {
    return this.name;
  }

  /**
   * Get object cost.
   * 
   * @return cost of product
   */
  public int getCost()
  {
    return this.cost;
  }

  /**
   * Get object price.
   * 
   * @return price of product
   */
  public int getPrice()
  {
    return this.price;
  }

  /**
   * The toString() method will return a String of the instance variables of the class exactly as.
   * shown below. Assuming a name of M&Ms, cost of $1.02, and a price of $1.25 toString() would
   * return: Product: M&Ms Cost: 1.02 Price: 1.25. Note: the cost and price are kept in cents so the
   * toString() method will need to transform the values into the right format.
   * 
   * @return String of product list
   */
  public String toString()
  {
    return String.format("Product: %s Cost: %.2f Price: %.2f.", this.name, this.cost / 100.0,
        this.price / 100.0);
  }
}
