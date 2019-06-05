import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class to practice making an iterator.
 *
 * @author C. Fox
 * @version 3/19
 * @param <T>
 *          The kind of thing this set stores
 */
public class ArraySet<T> implements Iterable<T>
{
  private final T[] universe; // all the values that a set may hold
  private boolean contains[]; // which values are in the set
  private int count; // how many elements are in the set

  /**
   * Create a new empty array set with the specified universe.
   * 
   * @param elements
   */
  @SuppressWarnings("unchecked")
  public ArraySet(T[] elements)
  {
    universe = (T[]) new Object[elements == null ? 0 : elements.length];
    for (int i = 0; i < universe.length; i++)
      universe[i] = elements[i];
    contains = new boolean[universe.length];
    count = 0;
  }

  /**
   * Put an element into this array set. If the value is already in the set, do nothing.
   * 
   * @param value
   *          the value added to the set
   * @return true iff the value is in the universe
   */
  public boolean add(T value)
  {
    for (int i = 0; i < universe.length; i++)
      if (value.equals(universe[i]))
      {
        if (!contains[i])
          count++;
        contains[i] = true;
        return true;
      }
    return false;
  }

  /**
   * Take an element out of the set. If the element is not not in the set to begin with, do nothing.
   * 
   * @param value
   *          the value removed from the set
   */
  public void remove(T value)
  {
    for (int i = 0; i < universe.length; i++)
      if (value.equals(universe[i]))
      {
        if (contains[i])
          count--;
        contains[i] = false;
        return;
      }
  }

  /**
   * Return true iff the value is in the set.
   * 
   * @param value
   *          the value searched for
   * @return true iff value is in the set
   */
  public boolean contains(T value)
  {
    for (int i = 0; i < universe.length; i++)
      if (value.equals(universe[i]))
        return contains[i];
    return false;
  }

  /**
   * Return how many elements are in the set.
   * 
   * @return the set size
   */
  public int size()
  {
    return count;
  }

  /**
   * Make this set empty.
   */
  public void clear()
  {
    count = 0;
    for (int i = 0; i < contains.length; i++)
      contains[i] = false;
  }

  /**
   * Determine whether two sets hold the same elements. Note that the universes of the two sets need
   * not be the same.
   * 
   * @param other
   *          the set whose equality to this set is checked
   * @return true iff the other set is equal to this set
   */
  public boolean equals(ArraySet<T> other)
  {
    if (count != other.size())
      return false;
    for (int i = 0; i < universe.length; i++)
      if (contains[i] && !other.contains(universe[i]))
        return false;
    return true;
  }

  @Override
  public Iterator<T> iterator()
  {
    // TODO Auto-generated method stub
    return new ArraySetIterator();
  }

  private class ArraySetIterator implements Iterator<T>
  {
    private int incrementer = 0;
    private int universeIncrementer = 0;

    @Override
    public boolean hasNext()
    {
      // TODO Auto-generated method stub
      return size() > incrementer;
    }

    @Override
    public T next()
    {
      // TODO Auto-generated method stub
      if (hasNext())
      {
        incrementer++;
        for (int i = universeIncrementer; i < universe.length; i++)
        {
          if (contains(universe[i]))
          {
            universeIncrementer = i + 1;
            return universe[i];
          }
        }
      }
      throw new NoSuchElementException();
    }

  }
}
