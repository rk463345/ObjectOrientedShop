package shop.ui;

import java.util.ArrayList;
import java.util.List;

public class UIMenuBuilder {
  private final List _menu;
  public UIMenuBuilder() {
    _menu = new ArrayList();
  }
  public UIMenu toUIMenu(String heading) {
    if (null == heading)
      throw new IllegalArgumentException();
    if (_menu.size() <= 1)
      throw new IllegalStateException();
    UIMenu.Pair[] array = new UIMenu.Pair[_menu.size()];
    for (int i = 0; i < _menu.size(); i++)
      array[i] = (UIMenu.Pair) (_menu.get(i));
    return new UIMenu(heading, array);
  }
  public void add(String prompt, UIMenuAction action) {
    if (null == action)
      throw new IllegalArgumentException();
    _menu.add(new UIMenu.Pair(prompt, action));
  }
}
