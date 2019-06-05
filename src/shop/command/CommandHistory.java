package shop.command;

/**
 * An unbounded list of commands with undo/redo capability.
 *
 * <p>Logically, the functionality is described in terms of two stacks:
 * <code>undoable</code> and <code>redoable</code>, both initially empty.</p>
 */
public interface CommandHistory {
  /**
   * Add command <code>undoable</code> and clear <code>redoable</code>.
   * @param cmd the command to be run.
   */
  public void add(UndoableCommand cmd);
  
  /**
   * Returns a <code>RerunnableCommand</code> that, when run does the following:
   * Pop command from <code>undoable</code>, undo it, then push it
   * onto <code>redoable</code>.
   * @throws EmptyStackException if there is no undoable command.
   */
  public RerunnableCommand getUndo();

  /**
   * Returns a <code>RerunnableCommand</code> that, when run does the following:
   * Pop command from <code>redoable</code>, redo it, then push it
   * onto <code>undoable</code>.
   * @throws EmptyStackException if there is no redoable command.
   */
  public RerunnableCommand getRedo();
}
