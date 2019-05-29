package shop.command;

/**
 * An UndoableCommand may be run at most once.
 */
public interface UndoableCommand extends Command {
  /**
   * Do the command.
   * @return true if command succeeds, false otherwise
   */
  public boolean run ();
  /**
   * Undo the command.
   */
  public void undo ();
  /**
   * Redo the command.
   */
  public void redo ();
}
