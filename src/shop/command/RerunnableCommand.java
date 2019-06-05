package shop.command;

/**
 *  A <code>Command</code> that may be run more than once.
 */
public interface RerunnableCommand extends Command {
  /**
   * The command body.
   * @return true if command succeeds, false otherwise
   */
  public boolean run ();
}
