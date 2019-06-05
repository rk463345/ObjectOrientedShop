package shop.ui;

class Pair<X, Y> {
	/**final String prompt;
	public UIMenuAction action;
	public UIFormTest test;
	
	Pair(String thePrompt, Object theThing){
		prompt = thePrompt;
		if (!(theThing instanceof UIMenuAction)) {
		    test = (UIFormTest) theThing;
		}
		if (!(theThing instanceof UIFormTest)) {
			action = (UIMenuAction) theThing;
		}
	}**/
	final Y _action;
	final String _prompt;
	Pair(String prompt, Y action){
		_action = action;
		_prompt = prompt;
	}

}
