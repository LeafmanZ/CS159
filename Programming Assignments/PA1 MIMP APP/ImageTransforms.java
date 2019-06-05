/**
 * This class is supposed to show me my point.
 * 
 * @author Jim Zieleman
 * @version 1/14/19
 * 
 */
public class ImageTransforms
{
  /**
   * Change image pixel red value by +25.
   * 
   * @param image
   *          is passed
   * @return Image
   */
  public static Image roseTintedGlasses(Image image)
  {
    Image nImage = new Image(image.getWidth(), image.getHeight());
    for (int i = 0; i < image.getWidth(); i++)
    {
      for (int j = 0; j < image.getHeight(); j++)
      {
        Pixel pixel = image.getPixel(i, j);
        Pixel nPixel = new Pixel(pixel.getRed() + 25, pixel.getGreen(), pixel.getBlue());
        nImage.setPixel(i, j, nPixel);
      }
    }
    return nImage;
  }

  /**
   * Change image pixel values into a gray color.
   * 
   * @param image
   *          is passed
   * @return Image
   */
  public static Image convertToGrayscale(Image image)
  {
    Image nImage = new Image(image.getWidth(), image.getHeight());
    for (int i = 0; i < image.getWidth(); i++)
    {
      for (int j = 0; j < image.getHeight(); j++)
      {
        Pixel pixel = image.getPixel(i, j);
        int l = (int) ((pixel.getRed() * .299) + (pixel.getGreen() * .587)
            + (pixel.getBlue() * .114));
        nImage.setPixel(i, j, new Pixel(l, l, l));
      }
    }
    return nImage;

  }

  /**
   * Change image pixel values to black and white.
   * 
   * @param image
   *          is passed
   * @param threshold
   *          is passed
   * @return Image
   */
  public static Image threshold(Image image, int threshold)
  {
    Image nImage = convertToGrayscale(image);
    for (int i = 0; i < image.getWidth(); i++)
    {
      for (int j = 0; j < image.getHeight(); j++)
      {
        if (nImage.getPixel(i, j).getRed() < threshold)
        {
          nImage.setPixel(i, j, new Pixel(0, 0, 0));
        }
        else
        {
          nImage.setPixel(i, j, new Pixel(255, 255, 255));
        }
      }
    }
    return nImage;
  }

  /**
   * Change image pixel and dimension value and rotate left.
   * 
   * @param image
   *          is passed
   * @return Image
   */
  public static Image rotateLeft(Image image)
  {
    Image nImage = new Image(image.getHeight(), image.getWidth());
    for (int i = 0; i < image.getWidth(); i++)
    {
      for (int j = 0; j < image.getHeight(); j++)
      {
        Pixel pixel = image.getPixel(i, j);
        nImage.setPixel(j, i, pixel);
      }
    }
    nImage = flip(nImage);
    return nImage;
  }

  /**
   * Change image pixel and dimension value and rotate right.
   * 
   * @param image
   *          is passed
   * @return Image
   */
  public static Image rotateRight(Image image)
  {
    Image nImage = new Image(image.getHeight(), image.getWidth());
    for (int i = 0; i < image.getWidth(); i++)
    {
      for (int j = 0; j < image.getHeight(); j++)
      {
        Pixel pixel = image.getPixel(i, j);
        nImage.setPixel(image.getHeight() - 1 - j, image.getWidth() - 1 - i, pixel);
      }
    }
    nImage = flip(nImage);
    return nImage;
  }

  /**
   * Flips the image object pixels vertically.
   * 
   * @param image
   *          is passed
   * @return Image
   */
  public static Image mirror(Image image)
  {
    Image nImage = new Image(image.getWidth(), image.getHeight());
    for (int i = 0; i < image.getWidth(); i++)
    {
      for (int j = 0; j < image.getHeight(); j++)
      {
        Pixel pixel = image.getPixel(i, j);
        nImage.setPixel(image.getWidth() - 1 - i, j, pixel);
      }
    }
    return nImage;
  }

  /**
   * Flips the image object pixels horizontally.
   * 
   * @param image
   *          is passed
   * @return Image
   */
  public static Image flip(Image image)
  {
    Image nImage = new Image(image.getWidth(), image.getHeight());
    for (int i = 0; i < image.getWidth(); i++)
    {
      for (int j = 0; j < image.getHeight(); j++)
      {
        Pixel pixel = image.getPixel(i, j);
        nImage.setPixel(i, image.getHeight() - 1 - j, pixel);
      }
    }
    return nImage;
  }
}
