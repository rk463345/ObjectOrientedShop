package shop.command;

/**
 * A simple command interface.
 */
public interface Command {
  /**
   * The command body.
   * It is not safe, in general, to run a <code>Command</code> more than once.
   * @return true if command succeeds, false otherwise
   */
  public boolean run ();
}
