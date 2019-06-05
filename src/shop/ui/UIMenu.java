package shop.ui;

/**
 * @see UIMenuBuilder
 */
public final class UIMenu{
	
  private final String _heading;
  private final Pair[] _menu;

  UIMenu(String heading, Pair[] menu) {
    _heading = heading;
    _menu = menu;
  }
  public int size() {
    return _menu.length;
  }
  public String getHeading() {
    return _heading;
  }
  public String getPrompt(int i) {
    return _menu[i]._prompt;
  }
  public void runAction(int i) {
    ((UIMenuAction) _menu[i]._action).run();
  }
}
