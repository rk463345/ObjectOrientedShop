package shop.ui;

public class UIMenuFactory {
	public static UIMenu newMenu(String heading, Pair<String, UIMenuAction>[] y) {
		return new UIMenu(heading, y);
	}
}
