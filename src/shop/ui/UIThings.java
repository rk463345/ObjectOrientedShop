package shop.ui;

abstract class UIThings implements UIMenuForm {
	private final String _heading;
	static Pair[] _form;
	static Pair[] _menu;
	
	UIThings (String heading, Pair[] form){
		_heading = heading;
		if (form[0] instanceof UIFormTest) {
			_form = form;
		}
		
	}
	
	public int size() {
		    return _form.length;
		  }
	public String getHeading() {
		    return _heading;
		  }

	public String getPrompt(int i) {
		return _form[i]._prompt;
	}

}
