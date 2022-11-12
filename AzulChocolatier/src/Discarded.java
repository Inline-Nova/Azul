import java.util.*;

public class Discarded extends tileStorage
{
  
  public Discarded()
  {
	  super();
  }

  
  public void discard(Tile t)
  {
	  super.addTile(t);
  }
  
  public void updateAfterRefill()
  {
	  super.empty();
  }
  
  public boolean hasTiles() {
	  return super.getTiles().size() > 0;
  }
}
