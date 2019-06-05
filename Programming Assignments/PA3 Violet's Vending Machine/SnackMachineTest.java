import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class SnackMachineTest
{

  @Test
  void testLoad()
  {
    ArrayList<Product> pList = new ArrayList<>();
    pList.add(new Product());
    SnackMachine sm = new SnackMachine(pList);
    sm.load();
  }

  @Test
  void testSnackMachine()
  {
    ArrayList<Product> pList = new ArrayList<>();
    pList.add(new Product());
    new SnackMachine(pList);
  }

}
