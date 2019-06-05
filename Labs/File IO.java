import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * The Document class represents a text document as an ArrayList of Strings, where each entry in the
 * ArrayList stores a single line of text.
 * 
 * @author Nathan Sprague and ????
 * @version ??
 *
 */

public class Document
{

  private ArrayList<String> lines;

  /**
   * Initialize a document containing no text.
   */
  public Document()
  {
    lines = new ArrayList<String>();
  }

  /**
   * Create a new document by loading the contents of the indicated file. Each line in the file will
   * be stored as a line in the Document object.
   * 
   * @param fileName
   *          Name of the file to load
   * @throws FileNotFoundException
   *           If the file cannot be opened for reading.
   */
  public Document(String fileName) throws FileNotFoundException
  {
    this();
    Scanner sc = new Scanner(new File(fileName));
    while (sc.hasNextLine())
    {
      appendLine(sc.nextLine());
    }
    sc.close();
  }

  /**
   * Save the document to the indicated file. Each line in the file should be terminated with a
   * newline character. Note that this matches the format produced by the Document toString method.
   * If the indicated file doesn't exist, it will be created. If it already exists, it will be
   * overwritten.
   * 
   * @param fileName
   *          Name of the file to create
   * @throws FileNotFoundException
   *           If the file cannot be opened for writing
   */
  public void save(String fileName) throws FileNotFoundException
  {

    PrintWriter output = new PrintWriter(new File(fileName));
    output.write(toString());
    output.close();
  }

  /**
   * Add a single line of text to the end of the document. The line is stored "as-is". I.e. no
   * newline characters are added.
   * 
   * @param line
   *          The line of text to add
   */
  public void appendLine(String line)
  {
    lines.add(line);

  }

  /**
   * Delete the indicate line of text. This method uses 0-based indexing. This method performs no
   * error checking. It may raise an exception if an invalid line number is provided.
   * 
   * @param lineNumber
   *          The index of the line to delete
   */
  public void deleteLine(int lineNumber)
  {
    lines.remove(lineNumber);
  }

  /**
   * Returns the total number of characters in the document. The count includes spaces, but it does
   * not include newline characters. The count for an empty document will be 0.
   * 
   * @return The total number of characters.
   */
  public int characterCount()
  {
    int count = 0;
    for (String line : lines)
    {
      count += line.length();
    }
    return count;
  }

  /**
   * This method returns the single longest line of text in the document. The line is returned
   * without a trailing newline character.
   * 
   * @return The longest line
   */
  public String longestLine()
  {

    // NOTE: The documentation doesn't specify what should be returned if
    // the document is empty. This code returns null. An empty string would
    // also be reasonable.

    String longest = null;

    for (String line : lines)
    {
      if (longest == null || line.length() > longest.length())
      {
        longest = line;
      }
    }

    return longest;
  }

  /**
   * This method returns the entire document as a single string. Each line (including the last) will
   * be terminated with a single newline character. If the document is empty, then return value will
   * be an empty string.
   * 
   * @return The entire document as a single string
   */
  public String toString()
  {
    String result = "";

    for (String line : lines)
    {
      result += line + "\n";
    }

    return result;
  }

}
