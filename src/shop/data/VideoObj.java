package shop.data;

/**
 * Implementation of Video interface.
 * @see Data
 */
final class VideoObj implements Video {
  private final String _title;
  private final int    _year;
  private final String _director;

  /**
   * Initialize all object attributes.
   * Title and director are "trimmed" to remove leading and final space.
   * @throws IllegalArgumentException if object invariant violated.
   */
  VideoObj(String title, int year, String director) {
    _title = title;
    _director = director;
    _year = year;
  }

  public String director() {
    return _director;
  }

  public String title() {
    return _title;
  }

  public int year() {
    return _year;
  }

  public boolean equals(VideoObj thatObject) {
	  if (!(thatObject instanceof VideoObj)) {
          return false;             
	  }                    
	  try {  
		  return (_title.intern() == (thatObject.title().intern()) && 
				  (_year == thatObject.year()) && 
				  (_director.intern() == thatObject.director().intern()));
		  /**Video that = (Video) thatObject;
			return _title.equals(that.title())
					&& (_year == that.year())
					&& _director.equals(that.director());**/
	  }                    
	  catch (IllegalArgumentException e) {return false;}
  }

  public int hashCode() {
	  int result = 17;
      result = 37*result + this._title.hashCode();
      result = 37*result + this._year;            
      result = 37*result + this._director.hashCode();
      return result;
  }

  public int compareTo(Object thatObject) {
	  int t = this._title.compareTo(((VideoObj) thatObject).title());
      int y = this._year - ((VideoObj) thatObject).year();           
      int d = this._director.compareTo(((VideoObj) thatObject).director());
      if (t == 0 && y == 0 && d == 0) {                                    
              return 0;                
      }                
      else if (t > 0 || y > 0 || d > 0) {
              return 1;                  
      }                
      else if (t < 0 || y < 0 || d < 0) {
              return -1;                 
      }                 
      return 0;
  }

  public String toString() {
	  return "" + _title +" (" + _year +") : " + _director;
  }
}
