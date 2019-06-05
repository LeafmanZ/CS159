import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class is supposed to show me my image and load and save.
 * 
 * @author Jim Zieleman
 * @version 2/7/19
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
   *          is passed *
   * @param red
   *          is passed,
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

  /**
   * Put the image object dimensions and pixels in a string format.
   * 
   * @param image
   *          our image
   * @param file
   *          where we want to save
   * @throws FileNotFoundException
   *           our exception
   */
  public static void saveImage(Image image, File file) throws FileNotFoundException
  {
    if (file == null)
    {
      throw new FileNotFoundException();
    }
    String stringImage = image.toStringDebug();
    try (PrintWriter output = new PrintWriter(file))
    {
      output.write(stringImage);
      output.close();
    }
  }

  /**
   * Put the image object dimensions and pixels in a string format.
   * 
   * @param image
   *          our image
   * @param fileName
   *          where we want to save
   * @throws FileNotFoundException
   *           our exception
   */
  public static void saveImage(Image image, String fileName) throws FileNotFoundException
  {
    if (fileName == null || fileName.length() <= 0)
    {
      throw new FileNotFoundException();
    }
    saveImage(image, new File(fileName));
  }

  /**
   * Put the image object dimensions and pixels in a string format.
   * 
   * @param file
   *          where we want to load
   * @throws FileNotFoundException
   *           no file
   * @throws ImageFileFormatException
   *           no image
   * @return file our passed mim
   */
  public static Image loadImage(File file) throws ImageFileFormatException, FileNotFoundException
  {
    if (file == null)
    {
      throw new FileNotFoundException();
    }
    ArrayList<String> fileLines = new ArrayList<String>();
    String fileString = "";
    Image fileImage;
    try (Scanner sc = new Scanner(file))
    {
      if (sc.hasNextLine())
      {
        fileString = sc.nextLine();
      }

      int indexd1 = fileString.indexOf("=") + 1;
      int indexd2 = fileString.indexOf("h", indexd1) - 1;
      int width = Integer.parseInt(fileString.substring(indexd1, indexd2));
      indexd1 = fileString.indexOf("=", indexd2) + 1;
      indexd2 = fileString.indexOf(">");
      int height = Integer.parseInt(fileString.substring(indexd1, indexd2));
      fileImage = new Image(width, height);
      int count = 0;
      while (sc.hasNextLine())
      {
        fileLines.add(sc.nextLine());
        count++;
      }
      sc.close();
      if (count > height)
      {
        throw new ImageFileFormatException();
      }
      for (String line : fileLines)
      {
        fileString += line;
      }

      int index1 = indexd2;
      int index2 = indexd2;
      int red;
      int green;
      int blue;
      for (int i = 0; i < height; i++)
      {
        for (int j = 0; j < width; j++)
        {
          index1 = fileString.indexOf("(", index1) + 1;
          index2 = fileString.indexOf(",", index1);
          red = Integer.parseInt(fileString.substring(index1, index2));
          index1 = index2 + 2;
          index2 = fileString.indexOf(",", index1);
          green = Integer.parseInt(fileString.substring(index1, index2));
          index1 = index2 + 2;
          index2 = fileString.indexOf(")", index1);
          blue = Integer.parseInt(fileString.substring(index1, index2));
          fileImage.setPixel(j, i, new Pixel(red, green, blue));

        }
      }
    }
    catch (StringIndexOutOfBoundsException io)
    {
      throw new ImageFileFormatException();
    }
    catch (NumberFormatException io)
    {
      throw new ImageFileFormatException();
    }
    return fileImage;
  }

  /**
   * Put the image object dimensions and pixels in a string format.
   * 
   * @param fileName
   *          where we want to load
   * @throws ImageFileFormatException
   *           no image
   * @throws FileNotFoundException
   *           no file
   * @return Image our picture
   */
  public static Image loadImage(String fileName)
      throws FileNotFoundException, ImageFileFormatException
  {
    return loadImage(new File(fileName));
  }
}
