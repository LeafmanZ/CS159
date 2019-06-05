/**
 * This class is supposed to show me my point.
 * 
 * @author Jim Zieleman
 * @version 1/14/19
 * 
 */
public class Pixel
{
  private final int red;
  private final int green;
  private final int blue;

  /**
   * Create a pixel object.
   * 
   * @param red
   *          is a color being passed
   * @param green
   *          is a color being passed
   * @param blue
   *          is a color being passed
   */
  Pixel(int red, int green, int blue)
  {
    this.red = calculateValue(red);
    this.green = calculateValue(green);
    this.blue = calculateValue(blue);
  }

  /**
   * Set color values.
   * 
   * @param color
   *          is passed
   * @return calculateValue
   */
  private int calculateValue(int color)
  {
    if (color < 0)
    {
      return 0;
    }
    else if (color > 255)
    {
      return 255;
    }
    else
    {
      return color;
    }
  }

  /**
   * Get pixel red value.
   * 
   * @return red
   */
  public int getRed()
  {
    return red;
  }

  /**
   * Get pixel green value.
   * 
   * @return green
   */
  public int getGreen()
  {
    return green;
  }

  /**
   * Get pixel blue value.
   * 
   * @return blue
   */
  public int getBlue()
  {
    return blue;
  }

  /**
   * Get pixel color value based from channel passed.
   * 
   * @param channel
   *          is passed
   * @return red
   */
  public int getChannel(int channel)
  {
    switch (channel)
    {
      case 0:
        return getRed();
      case 1:
        return getGreen();
      case 2:
        return getBlue();
      default:
        return -1;
    }
  }

  /**
   * Fix for checkstyle equals bug.
   * 
   * @return hashCode
   */
  public int hashCode()
  {
    return super.hashCode();
  }

  /**
   * Check if objects are equal.
   * 
   * @param other
   *          is passed
   * @return boolean
   */
  public boolean equals(Object other)
  {
    if (this == other)
    {
      return true;
    }
    if (other == null || getClass() != other.getClass())
    {
      return false;
    }
    Pixel oPixel = (Pixel) other;
    return red == oPixel.red && green == oPixel.green && blue == oPixel.blue;
  }

  /**
   * Give pixel colors back as a string.
   * 
   * @return String
   */
  public String toString()
  {
    return String.format("(%d, %d, %d)", red, green, blue);
  }
}
