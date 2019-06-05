package shop.main;

import shop.ui.UIFactory;
import shop.data.Data;

public class Main {
  private Main() {}
  public static void main(String[] args) {
    Control control = new Control(Data.newInventory(), UIFactory.ui());
    control.run();
  }
}
