package shop.main;

import junit.framework.Assert;
import junit.framework.TestCase;
import shop.command.RerunnableCommand;
import shop.command.UndoableCommand;
import shop.data.Data;
import shop.data.Video;
import shop.data.Inventory;
import java.util.Iterator;

public class TEST2 extends TestCase {
  public TEST2(String name) {
    super(name);
  }
  @SuppressWarnings("deprecation")
public void test1() {
    final Inventory inventory = Data.newInventory();
    final Video v1 = Data.newVideo("K", 2003, "S");
    final Video v2 = Data.newVideo("S", 2002, "K");
    final RerunnableCommand UNDO = Data.newUndoCmd(inventory);
    final RerunnableCommand REDO = Data.newRedoCmd(inventory);
	
    UndoableCommand c = Data.newAddCmd(inventory, v1, 2);
    Assert.assertTrue  ( c.run() );
    Assert.assertEquals( 1, inventory.size() );
    Assert.assertTrue  (!c.run() );     // cannot run an undoable command twice
    Assert.assertTrue  (!Data.newAddCmd(inventory, null, 3).run()); // can't add null!
    Assert.assertTrue  (!Data.newAddCmd(inventory, v2, 0).run());   // can't add zero copies!
    Assert.assertEquals( 1, inventory.size() );
    Assert.assertTrue  ( UNDO.run() );
    Assert.assertEquals( 0, inventory.size() );
    Assert.assertTrue  (!UNDO.run() );  // nothing to undo!
    Assert.assertEquals( 0, inventory.size() );
    Assert.assertTrue  ( REDO.run() );
    Assert.assertEquals( 1, inventory.size() );
    Assert.assertTrue  (!REDO.run() );  // nothing to redo!
    Assert.assertEquals( 1, inventory.size() );
    Assert.assertTrue  ( Data.newAddCmd(inventory, v1, -2).run());   // delete!
    Assert.assertEquals( 0, inventory.size() );
    Assert.assertTrue  (!Data.newOutCmd(inventory, v1).run());       // can't check out
    Assert.assertEquals( 0, inventory.size() );
    Assert.assertTrue  ( UNDO.run() );  // should undo the AddCmd, not the OutCmd
    Assert.assertEquals( 1, inventory.size() ); 
    Assert.assertTrue  (!Data.newAddCmd(inventory, v1, -3).run());   // can't delete 3
    Assert.assertTrue  ( Data.newAddCmd(inventory, v1, -2).run());   // delete 2
    Assert.assertEquals( 0, inventory.size() );
    Assert.assertTrue  ( UNDO.run() ); 
    Assert.assertEquals( 1, inventory.size() ); 

    Assert.assertEquals( "K (2003) : S [2,0,0]", inventory.get(v1).toString() );	
    Assert.assertTrue  ( Data.newAddCmd(inventory, v1, 2).run());
    Assert.assertEquals( "K (2003) : S [4,0,0]", inventory.get(v1).toString() );	
    Assert.assertTrue  ( Data.newAddCmd(inventory, v1, 2).run());
    Assert.assertEquals( "K (2003) : S [6,0,0]", inventory.get(v1).toString() );	
    Assert.assertTrue  ( UNDO.run() );
    Assert.assertEquals( "K (2003) : S [4,0,0]", inventory.get(v1).toString() );	
    Assert.assertTrue  ( UNDO.run() );
    Assert.assertEquals( "K (2003) : S [2,0,0]", inventory.get(v1).toString() );	

    Assert.assertTrue  ( Data.newOutCmd(inventory, v1).run());
    Assert.assertEquals( "K (2003) : S [2,1,1]", inventory.get(v1).toString() );
    Assert.assertTrue  ( Data.newOutCmd(inventory, v1).run());
    Assert.assertEquals( "K (2003) : S [2,2,2]", inventory.get(v1).toString() );
    Assert.assertTrue  (!Data.newOutCmd(inventory, v1).run());
    Assert.assertEquals( "K (2003) : S [2,2,2]", inventory.get(v1).toString() );
    Assert.assertTrue  ( UNDO.run() );
    Assert.assertEquals( "K (2003) : S [2,1,1]", inventory.get(v1).toString() );
    Assert.assertTrue  ( UNDO.run() );
    Assert.assertEquals( "K (2003) : S [2,0,0]", inventory.get(v1).toString() );
    Assert.assertTrue  ( REDO.run() );
    Assert.assertEquals( "K (2003) : S [2,1,1]", inventory.get(v1).toString() );
    Assert.assertTrue  ( REDO.run() );
    Assert.assertEquals( "K (2003) : S [2,2,2]", inventory.get(v1).toString() );
    
    Assert.assertTrue  ( Data.newInCmd(inventory, v1).run() );
    Assert.assertEquals( "K (2003) : S [2,1,2]", inventory.get(v1).toString() );	
    Assert.assertTrue  ( Data.newInCmd(inventory, v1).run() );
    Assert.assertEquals( "K (2003) : S [2,0,2]", inventory.get(v1).toString() );
    Assert.assertTrue  (!Data.newInCmd(inventory, v1).run() );
    Assert.assertEquals( "K (2003) : S [2,0,2]", inventory.get(v1).toString() );
    Assert.assertTrue  ( UNDO.run() );
    Assert.assertEquals( "K (2003) : S [2,1,2]", inventory.get(v1).toString() );
    Assert.assertTrue  ( UNDO.run() );
    Assert.assertEquals( "K (2003) : S [2,2,2]", inventory.get(v1).toString() );
    Assert.assertTrue  ( REDO.run() );
    Assert.assertEquals( "K (2003) : S [2,1,2]", inventory.get(v1).toString() );
    Assert.assertTrue  ( REDO.run() );
    Assert.assertEquals( "K (2003) : S [2,0,2]", inventory.get(v1).toString() );

    Assert.assertTrue  ( Data.newAddCmd(inventory, v2, 4).run());
    Assert.assertEquals( 2, inventory.size() );
    Assert.assertTrue  ( Data.newClearCmd(inventory).run());
    Assert.assertEquals( 0, inventory.size() );
    Assert.assertTrue  ( UNDO.run() );
    Assert.assertEquals( 2, inventory.size() );
    Assert.assertTrue  ( REDO.run() );
    Assert.assertEquals( 0, inventory.size() );
  }

  public void test2() {
    final Inventory inventory = Data.newInventory();
    final Video v1 = Data.newVideo("K", 2003, "S");
    final RerunnableCommand UNDO = Data.newUndoCmd(inventory);
    final RerunnableCommand REDO = Data.newRedoCmd(inventory);
    Assert.assertTrue  ( Data.newAddCmd(inventory, v1,2).run());
    Assert.assertEquals( "K (2003) : S [2,0,0]", inventory.get(v1).toString() );
    Assert.assertTrue  ( Data.newOutCmd(inventory, v1).run());
    Assert.assertEquals( "K (2003) : S [2,1,1]", inventory.get(v1).toString() );
    Assert.assertTrue  ( UNDO.run() );
    Assert.assertEquals( "K (2003) : S [2,0,0]", inventory.get(v1).toString() );
    Assert.assertTrue  ( REDO.run() );
    Assert.assertEquals( "K (2003) : S [2,1,1]", inventory.get(v1).toString() );
    Assert.assertTrue  ( Data.newOutCmd(inventory, v1).run());
    Assert.assertEquals( "K (2003) : S [2,2,2]", inventory.get(v1).toString() );
    Assert.assertTrue  ( UNDO.run() );
    Assert.assertEquals( "K (2003) : S [2,1,1]", inventory.get(v1).toString() );
    Assert.assertTrue  ( UNDO.run() );
    Assert.assertEquals( "K (2003) : S [2,0,0]", inventory.get(v1).toString() );
  }
}
