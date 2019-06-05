/**
 * This class is supposed to show me my point.
 * 
 * @author Jim Zieleman
 * @version 1/14/19
 * 
 */
public class Image
{
  private Pixel[][] pixels;
  private int height;
  private int width;

  /**
   * Create an image object.
   * 
   * @param height
   *          is passed
   * @param width
   *          is passed
   * @param red
   *          is passed
   * @param green
   *          is passed
   * @param blue
   *          is passed
   */
  Image(int width, int height, int red, int green, int blue)
  {
    if (height <= 0 || width <= 0)
    {
      this.height = 0;
      this.width = 0;
    }
    else
    {
      this.height = height;
      this.width = width;
    }

    pixels = new Pixel[this.height][this.width];

    for (int i = 0; i < pixels.length; i++)
    {
      for (int j = 0; j < pixels[i].length; j++)
      {
        pixels[i][j] = new Pixel(red, green, blue);
      }
    }
  }

  /**
   * Create an image object in an overloaded constructor.
   * 
   * @param height
   *          is passed
   * @param width
   *          is passed
   */
  Image(int width, int height)
  {
    if (height <= 0 || width <= 0)
    {
      this.height = 0;
      this.width = 0;
    }
    else
    {
      this.height = height;
      this.width = width;
    }

    pixels = new Pixel[this.height][this.width];

    for (int i = 0; i < pixels.length; i++)
    {
      for (int j = 0; j < pixels[i].length; j++)
      {
        pixels[i][j] = new Pixel(255, 255, 255);
      }
    }
  }

  /**
   * To construct a pixel we need to check coordinates.
   * 
   * @param x
   *          is passed
   * @param y
   *          is passed
   * @return boolean
   */
  private boolean isNotCoordinate(int x, int y)
  {
    return x >= width || y >= height || x < 0 || y < 0;
  }

  /**
   * Get a pixel object.
   * 
   * @param x
   *          is passed
   * @param y
   *          is passed
   * @return Pixel
   */
  public Pixel getPixel(int x, int y)
  {
    if (isNotCoordinate(x, y))
    {
      return null;
    }
    return pixels[y][x];
  }

  /**
   * Change a pixel object.
   * 
   * @param x
   *          is passed
   * @param y
   *          is passed
   * @param pixel
   *          is passed
   */
  public void setPixel(int x, int y, Pixel pixel)
  {
    if (pixel == null)
    {
      pixels[y][x] = pixels[y][x];
    }
    else if (isNotCoordinate(x, y))
    {
      return;
    }
    else
    {
      pixels[y][x] = pixel;
    }
  }

  /**
   * Get image object height.
   * 
   * @return int
   */
  public int getHeight()
  {
    return height;
  }

  /**
   * Get image object width.
   * 
   * @return int
   */
  public int getWidth()
  {
    return width;
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
   * Check if the object passed is equal to the image.
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
    Image oImage = (Image) other;
    if (width != oImage.getWidth() || height != oImage.getHeight())
    {
      return false;
    }
    for (int i = 0; i < pixels.length; i++)
    {
      for (int j = 0; j < pixels[i].length; j++)
      {
        if (!pixels[i][j].equals(oImage.getPixel(j, i)))
        {
          return false;
        }
      }
    }
    return true;
  }

  /**
   * Put the image object dimensions in a string format.
   * 
   * @return String
   */
  public String toString()
  {
    return String.format("<Image width=%d height=%d>", width, height);
  }

  /*
   * NON BUILDER ATTEMPT??? uses more memory less efficient ** public String toStringDebug() {
   * String deBugged = String.format("<Image height=%d width=%d>\n", height, width); for (int i = 0;
   * i < width; i++) { for (int j = 0; j < height; j++) { deBugged += "\t" +
   * pixels[j][i].toString(); } if (i < width - 1) { deBugged += "\n"; } } return deBugged; }
   * BUILDER TRY??? // Strings are immutable so they cost more memory. // It is inefficient to
   * StringBuilder builder = new StringBuilder(); builder.append(this.toString());
   * builder.append("\n");
   * 
   * for (int i = 0; i < pixels.length; i++) { for (int j = 0; j < pixels[i].length; j++) {
   * builder.append("\t"); builder.append(pixels[i][j].toString());
   * 
   * } } return builder.toString();
   */
  /**
   * Put the image object dimensions and pixels in a string format.
   * 
   * @return String
   */
  public String toStringDebug()
  {
    String fullArray = toString() + "\n";
    for (int i = 0; i < pixels.length; i++)
    {
      for (int j = 0; j < pixels[i].length; j++)
      {
        fullArray += "\t" + pixels[i][j];
      }
      fullArray += "\n";
    }
    return fullArray;
  }
}
