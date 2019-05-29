package shop.data;

import junit.framework.Assert;
import junit.framework.TestCase;

// TODO:  complete the tests
public class DataTEST extends TestCase {
  public DataTEST(String name) {
    super(name);
  }
  public void testConstructorAndAttributes() {
    String title1 = "XX";
    String director1 = "XY";
    String title2 = " XX ";
    String director2 = " XY ";
    int year = 2002;

    Video v1 = Data.newVideo(title1, year, director1);
    Assert.assertSame(title1, v1.title());
    Assert.assertEquals(year, v1.year());
    Assert.assertSame(director1, v1.director());

    Video v2 = Data.newVideo(title2, year, director2);
    Assert.assertEquals(title1, v2.title());
    Assert.assertEquals(director1, v2.director());
  }

  public void testConstructorExceptionYear() {
    try {
      Data.newVideo("X", 1800, "Y");
      Assert.fail();
    } catch (IllegalArgumentException e) { }
    try {
      Data.newVideo("X", 5000, "Y");
      Assert.fail();
    } catch (IllegalArgumentException e) { }
    try {
      Data.newVideo("X", 1801, "Y");
      Data.newVideo("X", 4999, "Y");
    } catch (IllegalArgumentException e) {
      Assert.fail();
    }
  }

  public void testConstructorExceptionTitle() {
    try {
      Data.newVideo(null, 2002, "Y");
      Assert.fail();
    } catch (IllegalArgumentException e) { }
    try {
      Data.newVideo("", 2002, "Y");
      Assert.fail();
    } catch (IllegalArgumentException e) { }
    try {
      Data.newVideo(" ", 2002, "Y");
      Assert.fail();
    } catch (IllegalArgumentException e) { }
  }

  public void testConstructorExceptionDirector() {
	  try {
	      Data.newVideo("Y", 2002, null);
	      Assert.fail();
	    } catch (IllegalArgumentException e) { }
	    try {
	      Data.newVideo("Y", 2002, "");
	      Assert.fail();
	    } catch (IllegalArgumentException e) { }
	    try {
	      Data.newVideo("Y", 2002, " ");
	      Assert.fail();
	    } catch (IllegalArgumentException e) { }
    // TODO  
  }

}
