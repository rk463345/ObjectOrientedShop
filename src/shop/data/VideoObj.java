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
    return _director.intern();
  }

  public String title() {
    return _title.intern();
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
	  }                    
	  catch (IllegalArgumentException e) {return false;}
  }

  public int hashCode() {
	  int result = 17;
      result = 37*result + this._title.intern().hashCode();
      result = 37*result + this._year;            
      result = 37*result + this._director.intern().hashCode();
      return result;
  }

  public int compareTo(Object thatObject) {
	  int titleDiff = _title.compareTo(((VideoObj) thatObject).title());
		if (titleDiff != 0) {
			return titleDiff;
		}
		int yearDiff = _year - ((VideoObj) thatObject).year();
		if (yearDiff != 0) {
			return yearDiff;
		}
		int directorDiff = _director.compareTo(((VideoObj) thatObject).director());
		if (directorDiff != 0) {
			return directorDiff;
		}
		return 0;
  }

  public String toString() {
	  return "" + _title +" (" + _year +") : " + _director;
  }
}
