import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * A simple linked list of strings with limited functionality. Items may only be added and removed
 * at the beginning of the list.
 * 
 * @author Nathan Sprague
 * 
 */
public class SimpleLinkedList
{
  private int size;
  private Node head;

  /**
   * Create an empty linked list.
   */
  public SimpleLinkedList()
  {
    size = 0;
    head = new Node(null);
  }

  /**
   * @return The number of elements stored in the list
   */
  public int size()
  {
    return size;
  }

  /**
   * Add an item at position 0 in the list.
   * 
   * @param item
   *          The item to add
   */
  public void addAtStart(String item)
  {
    head = new Node(head, item);
    size++;
  }

  /**
   * Return true if this list contains the indicated item.
   * 
   * @param item
   *          The item to search for
   * @return true if the item is in the list, false otherwise
   */
  public boolean contains(String item)
  {
    // UNFINISHED. Look at the get method if you need a reminder on how to
    // loop through a linked structure. For this method, a while loop will
    // be more appropriate than a for loop.
    //
    // Note: This method should NOT CALL get. The resulting implementation
    // would be very inefficient since get must loop through the list from
    // the beginning on each call.
    Node node = head;
    while (node.getNext() != null)
    {
      if (node.getValue().equals(item))
      {
        return true;
      }
      node = node.getNext();
    }

    return false;
  }

  /**
   * Add an item to the end of the list.
   * 
   * @param item
   *          The item to add
   */
  public void addAtEnd(String item)
  {
    // UNFINISHED. There are two cases: if the list is currently empty then
    // the new node will be the head. Otherwise the new node needs to go
    // after the current last node.
    if (size == 0)
    {
      addAtStart(item);
    }
    else
    {
      Node node = head;
      while (node.getNext().getNext() != null)
      {
        node = node.getNext();
      }
      node.setNext(new Node(item));
      size++;
    }

  }

  /**
   * Remove and return the item stored at position 0 in the list.
   * 
   * @return The item at position 0
   * @throws NoSuchElementException
   *           if the list is empty
   */
  public String removeAtStart()
  {
    String item = "";
    if (head == null)
    {
      throw new NoSuchElementException();
    }
    else
    {
      item = head.getNext().getValue();
      head.setNext(null);
      head = head.getNext();
      size--;
    }
    return item;
  }

  /**
   * Return the item stored at the indicated index.
   * 
   * @param index
   *          The index
   * @return The element stored at the indicated index
   */
  public String get(int index)
  {

    if (index >= size || index < 0)
    {
      throw new IndexOutOfBoundsException();
    }
    Node node = head;
    // Finish this code
    for (int i = 0; i < index; i++)
    {
      node = node.getNext();
    }
    return node.getValue();
  }

}
