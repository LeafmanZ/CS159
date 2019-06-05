/**
 * This class is supposed to show me my point.
 * 
 * @author Jim Zieleman
 * @version 9/7/15
 * 
 */
public class Point
{
  private double xPosition;
  private double yPosition;
  
  /**
   * Create a point object.
   * 
   * @param xPosition is passed
   * @param yPosition is passed
   */
  Point(double xPosition, double yPosition)
  {
    this.xPosition = xPosition;
    this.yPosition = yPosition;
  }

  /**
   * 
   * @return xPosition
   */
  public double getX()
  {
    return xPosition;
  }

  /**
   * 
   * @return yPosition
   */
  public double getY()
  {
    return yPosition;
  }

  /**
   * 
   * @param newX is passed
   */
  public void setX(double newX)
  {
    xPosition = newX;
  }

  /**
   * 
   * @param newY is passed
   */
  public void setY(double newY)
  {
    yPosition = newY;
  }

  /**
   * 
   * @param otherPoint is passed
   * @return equals
   */
  public boolean equals(Point otherPoint)
  {
    /*if (this == otherPoint)
    {
      return true;
    }
    if (otherPoint == null)
    {
      return false;
    } */
    return xPosition == otherPoint.getX() && yPosition == otherPoint.getY();
  }

  /**
   * 
   * @return toString
   */
  public String toString()
  {
    return String.format("(%.1f, %.1f)", xPosition, yPosition);
  }
}
