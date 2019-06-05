
package gamePlay;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

/**
 * Dictionary--The class that contains our entire list of words that count as real words.
 * 
 * References and acknowledgments: I worked with occasional TAs.
 *
 * @author Jim Zieleman
 * @version 4/18/19
 */

public class Dictionary
{
  private static PrintWriter writer;
  private ArrayList<String> list;
  private int sizeWhenSaved;
  private String fileName;
  
  private File file;

  /**
   * Construct our dictionary object.
   * 
   */
  public Dictionary()
  {
    list = new ArrayList<String>();

    this.fileName = "dictionary.txt";
    sizeWhenSaved = 0;
    file = new File(this.fileName);

    loadFile(file);
    save();
  }

  /**
   * Construct our dictionary object.
   * 
   * @param filename
   *          that we will import our dictionary of words from.
   * 
   */
  public Dictionary(String filename)
  {
    list = new ArrayList<String>();

    this.fileName = filename;
    sizeWhenSaved = 0;
    file = new File(this.fileName);

    loadFile(file);
    save();
  }

  /**
   * Helper to load a file into our dictionary.
   * 
   * @param newfile
   *          that we are loading.
   * 
   */
  public void loadFile(File newfile)
  {
    try
    {
      String word = "";
      Scanner scan;
      scan = new Scanner(file);
      while (scan.hasNext())
      {
        word = scan.nextLine().toLowerCase();
        list.add(word);
        Collections.sort(list);
      }
      scan.close();
    }
    catch (FileNotFoundException f)
    {
      // Nothing occurs
    }
  }

  /**
   * Saving our list of dictionary words from a file using writeFile.
   * 
   */
  public void save()
  {
    for (int i = 0; i < list.size(); i++)
    {
      writeFile(list.get(i));
      sizeWhenSaved++;
      Collections.sort(list);
    }
  }

  /**
   * Helper method to write our file to our list.
   * 
   * @param str
   *          the word in the list we are trying to write.
   * 
   */
  public void writeFile(String str)
  {
    if (writer != null)
    {
      writer.print(str);
    }
  }

  /**
   * Add word to the dictionary with probability prob/10. If list has grown by at least 20 words
   * since it was last saved, then save it. The list must be still be in order after this method
   * runs.
   * 
   * @param word
   *          the word we are trying to learn
   * @param prob
   *          is the probability value we are giving to the computer to learn at.
   * 
   */
  public void learn(String word, int prob)
  {
    Random rand = new Random();
    int num = rand.nextInt(11);
    if (num < prob)
    {
      if (list.contains(word.toLowerCase()))
      {
        return;
      }
      list.add(word.toLowerCase());
      sizeWhenSaved++;
      if (sizeWhenSaved >= 20)
      {
        save();
        sizeWhenSaved = 0;
      }
      Collections.sort(list);
    }

  }

  /**
   * Remove word from list, or do nothing if word is not in list. The list must still be in order
   * after this method runs.
   * 
   * @param word
   *          the word we want to forget from from our list.
   * 
   */
  public void forget(String word)
  {
    if (list.contains(word))
    {
      list.remove(word);
    }
    save();
  }

  /**
   * Return false if word is null or empty. Otherwise, return true iff word is in list. This method
   * MUST use a binary search to look for word.
   * 
   * @param word
   *          the word we want to check if it is a word.
   * @return boolean if the word is a word.
   */
  public boolean isWord(String word)
  {
    boolean inList = false;
    int index = 0;

    if (word == null || word.length() < 0)
    {
      return false;
    }
    else
    {
      index = Collections.binarySearch(list, word);
      if (index >= 0)
      {
        inList = true;
      }
    }
    return inList;
  }

  /**
   * Return false if prefix is null or empty. We are checking if the prefix exists.
   * 
   * @param prefix
   *          the string we want the prefix of.
   * @return boolean if it is the prefix or not.
   * 
   */
  boolean isPrefix(String prefix)
  {
    ArrayList<String> correctSizeStringList = new ArrayList<String>();
    for (String l : list)
    {
      if (prefix.length() <= l.length())
      {
        correctSizeStringList.add(l.substring(0, prefix.length()));
      }
    }
    return (prefix == null || Collections.binarySearch(correctSizeStringList, prefix) < 0) ? false
        : true;
  }

  /**
   * Check if our list is sorted or not.
   * 
   * @return boolean true if our list is sorted false if it isn't.
   * 
   */
  boolean isSorted()
  {
    ArrayList<String> sortedList = new ArrayList<String>();
    sortedList.addAll(list);
    Collections.sort(sortedList);
    for (int i = 0; i < list.size(); i++)
    {
      if (sortedList.get(i).compareTo(list.get(i)) != 0)
      {
        return false;
      }
    }
    return true;
  }

  /**
   * Return the dictionary list of words.
   * 
   * @return ArrayList<String> the list in our dictionary.
   * 
   */
  public ArrayList<String> getList()
  {
    return list;
  }

  /**
   * Get the word at the index given from the list.
   * 
   * @param index
   *          of the word we want
   * @return string of the word at the lists index.
   */
  String getWord(int index)
  {
    return list.get(index);
  }

  /**
   * Return the size of our dictionary list.
   * 
   * @return size of the list.
   * 
   */
  int size()
  {
    return list.size();
  }
}

