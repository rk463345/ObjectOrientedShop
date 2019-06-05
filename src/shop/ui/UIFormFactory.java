package shop.ui;

public class UIFormFactory {
	public static UIForm newForm(String heading, Pair<String, UIFormTest>[] y) {
		return new UIForm(heading, y);
	}
}
