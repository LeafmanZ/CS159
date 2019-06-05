import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

import org.junit.jupiter.api.Test;

class ZArraySetTest
{
  enum Colors {BLUE, GREEN, YELLOW, ORANGE, RED, PURPLE };
  
  private String[] stringValues = { "blue", "green", "yellow", "orange", "red", "purple" };
  private Colors[] enumValues = Colors.values();

  @Test
  final void constructorTest()
  {
    ArraySet<String> set = new ArraySet<>(stringValues);
    assertEquals(0, set.size());
    assertFalse(set.contains("blue"));
  }

  @Test
  final void nullOrEmptyUniverseTest()
  {
    ArraySet<String> set = new ArraySet<>(null);
    assertEquals(0, set.size());
    assertFalse(set.contains("blue"));
    assertFalse(set.add("blue"));
    assertFalse(set.contains("blue"));
    set.remove("blue");
    assertEquals(0, set.size());
    set.clear();
    assertEquals(0, set.size());
    ArraySet<String> stringSet = new ArraySet<>(stringValues);
    assertTrue(set.equals(stringSet));
    assertTrue(stringSet.equals(set));
    assertTrue(stringSet.add("blue"));
    assertFalse(set.equals(stringSet));
    assertFalse(stringSet.equals(set));
  }

  @Test
  final void addTest()
  {
    ArraySet<String> stringSet = new ArraySet<>(stringValues);
    ArraySet<Colors> enumSet = new ArraySet<>(enumValues);

    assertFalse(stringSet.contains("blue"));
    assertTrue(stringSet.add("blue"));
    assertEquals(1, stringSet.size());
    assertTrue(stringSet.contains("blue"));

    assertFalse(enumSet.contains(Colors.BLUE));
    assertTrue(enumSet.add(Colors.BLUE));
    assertEquals(1, enumSet.size());
    assertTrue(enumSet.contains(Colors.BLUE));

    assertFalse(stringSet.contains("white"));
    assertFalse(stringSet.add("white"));
    assertEquals(1, stringSet.size());
    assertFalse(stringSet.contains("white"));

    assertTrue(stringSet.add("blue"));
    assertEquals(1, stringSet.size());
    assertTrue(stringSet.contains("blue"));

    assertTrue(enumSet.add(Colors.BLUE));
    assertEquals(1, enumSet.size());
    assertTrue(enumSet.contains(Colors.BLUE));
  }

  @Test
  final void removeTest()
  {
    ArraySet<String> stringSet = new ArraySet<>(stringValues);
    ArraySet<Colors> enumSet = new ArraySet<>(enumValues);

    stringSet.add("blue");
    stringSet.add("red");
    stringSet.add("orange");
    assertEquals(3, stringSet.size());
    enumSet.add(Colors.ORANGE);
    enumSet.add(Colors.YELLOW);
    enumSet.add(Colors.PURPLE);
    assertEquals(3, enumSet.size());
    
    assertTrue(stringSet.contains("red"));
    stringSet.remove("red");
    assertFalse(stringSet.contains("red"));
    assertEquals(2, stringSet.size());
    stringSet.remove("red");
    assertFalse(stringSet.contains("red"));
    assertEquals(2, stringSet.size());
    
    assertTrue(enumSet.contains(Colors.PURPLE));
    enumSet.remove(Colors.PURPLE);
    assertFalse(enumSet.contains(Colors.PURPLE));
    assertEquals(2, enumSet.size());
    enumSet.remove(Colors.PURPLE);
    assertFalse(enumSet.contains(Colors.PURPLE));
    assertEquals(2, enumSet.size());
  }

  @Test
  final void clearTest()
  {
    ArraySet<Colors> enumSet = new ArraySet<>(enumValues);

    enumSet.add(Colors.ORANGE);
    enumSet.add(Colors.YELLOW);
    enumSet.add(Colors.PURPLE);
    assertEquals(3, enumSet.size());
    
    enumSet.clear();
    assertEquals(0, enumSet.size());
    assertFalse(enumSet.contains(Colors.ORANGE));
  }

  @Test
  final void equalsTest()
  {
    String[] otherValues = { "azure", "blue", "cyan", "red", "scarlet", "crimson" };
    ArraySet<String> stringSet1 = new ArraySet<>(stringValues);
    ArraySet<String> stringSet2 = new ArraySet<>(otherValues);

    stringSet1.add("blue");
    stringSet2.add("red");
    assertFalse(stringSet1.equals(stringSet2));
    assertFalse(stringSet2.equals(stringSet1));

    stringSet1.add("red");
    stringSet2.add("blue");
    assertTrue(stringSet1.equals(stringSet2));
    assertTrue(stringSet2.equals(stringSet1));
    
    stringSet1.add("orange");
    stringSet2.add("orange");
    assertFalse(stringSet1.equals(stringSet2));
    assertFalse(stringSet2.equals(stringSet1));
    
    stringSet1.add("azure");
    stringSet2.add("azure");
    assertFalse(stringSet1.equals(stringSet2));
    assertFalse(stringSet2.equals(stringSet1));
  }

  @Test
  final void iteratorTest()
  {
    ArraySet<String> stringSet = new ArraySet<>(stringValues);
    ArraySet<Colors> enumSet = new ArraySet<>(enumValues);

    for (@SuppressWarnings("unused") Colors color : enumSet) {
      fail();   // we should never get here
    }
    
    Iterator<String> iter = stringSet.iterator();
    assertThrows(NoSuchElementException.class, ()->{ iter.next(); });
    
    stringSet.add("blue");
    stringSet.add("orange");
    stringSet.add("red");
    enumSet.add(Colors.BLUE);
    enumSet.add(Colors.RED);
    enumSet.add(Colors.ORANGE);

    Set<Colors> enumCheckSet = new HashSet<>();
    for (Colors color : enumSet) {
      enumCheckSet.add(color);
    }
    assertEquals(3, enumCheckSet.size());
    assertTrue(enumCheckSet.contains(Colors.BLUE));
    assertTrue(enumCheckSet.contains(Colors.RED));
    assertTrue(enumCheckSet.contains(Colors.ORANGE));

    Set<String> stringCheckSet = new HashSet<>();
    for (String color : stringSet) {
      stringCheckSet.add(color);
    }
    assertEquals(3, stringCheckSet.size());
    assertTrue(stringCheckSet.contains("blue"));
    assertTrue(stringCheckSet.contains("orange"));
    assertTrue(stringCheckSet.contains("red"));
    
    for (Colors color : enumValues) {
      enumSet.add(color);
    }
    enumCheckSet.clear();
    for (Colors color : enumSet) {
      enumCheckSet.add(color);
    }
    assertEquals(6, enumCheckSet.size());
  }
  
}