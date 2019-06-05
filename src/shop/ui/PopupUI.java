package shop.ui;

import javax.swing.JOptionPane;
//import java.io.IOException;

final class PopupUI implements UI {
  PopupUI() {}

  public void displayMessage(String message) {
    JOptionPane.showMessageDialog(null,message);
  }

  public void displayError(String message) {
    JOptionPane.showMessageDialog(null,message,"Error",JOptionPane.ERROR_MESSAGE);
  }

  public void processMenu(UIMenu menu) {
    StringBuffer b = new StringBuffer();
    b.append(menu.getHeading());
    b.append("\n");
    b.append("Enter choice by number:");
    b.append("\n");

    for (int i = 1; i < menu.size(); i++) {
      b.append("  " + i + ". " + menu.getPrompt(i));
      b.append("\n");
    }

    String response = JOptionPane.showInputDialog(b.toString());
    int selection;
    try {
      selection = Integer.parseInt(response, 10);
      if ((selection < 0) || (selection >= menu.size()))
        selection = 0;
    } catch (NumberFormatException e) {
      selection = 0;
    }

    menu.runAction(selection);
  }

  public String[] processForm(UIForm form) {
    // TODO 
	  String[] result = new String [form.size()];
		int i=0;
		while (i<form.size()) {
			String response = JOptionPane.showInputDialog(form.getPrompt(i));
			if (response == null) {
				response = "";
			}
			if (!form.checkInput(i, response)) {
				displayError("Invalid Input");
			} 
			else {
				result[i] = response;
				++i;
			}
		}
		return result;
  }
}
