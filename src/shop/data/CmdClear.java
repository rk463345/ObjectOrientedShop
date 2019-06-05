package shop.data;

import shop.command.UndoableCommand;
import java.util.Map;

/**
 * Implementation of command to clear the inventory.
 * @see Data
 */
final class CmdClear implements UndoableCommand {
  private InventorySet _inventory;
  private Map _oldvalue;
  CmdClear(InventorySet inventory) {
    _inventory = inventory;
  }
  public boolean run() {
    if (_oldvalue != null)
      return false;
    try {
      _oldvalue = _inventory.clear();
      _inventory.getHistory().add(this);
      return true;
    } catch (ClassCastException e) {
      return false;
    } catch(IllegalArgumentException e) {return false;}
  }
  public void undo() {
    _inventory.replaceMap(_oldvalue);
  }
  public void redo() {
    _inventory.clear();
  }
}
