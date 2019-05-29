package shop.ui;

import java.util.ArrayList;
import java.util.List;

public final class UIFormBuilder {
  private final List _menu;
  public UIFormBuilder() {
    _menu = new ArrayList();
  }
  public UIForm toUIForm(String heading) {
    if (null == heading)
      throw new IllegalArgumentException();
    if (_menu.size() < 1)
      throw new IllegalStateException();
    UIForm.Pair[] array = new UIForm.Pair[_menu.size()];
    for (int i = 0; i < _menu.size(); i++)
      array[i] = (UIForm.Pair) (_menu.get(i));
    return new UIForm(heading, array);
  }
  public void add(String prompt, UIFormTest test) {
    _menu.add(new UIForm.Pair(prompt, test));
  }
}
