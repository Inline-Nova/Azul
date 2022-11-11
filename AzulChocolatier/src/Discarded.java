import java.util.*;

public class Discarded
{
  private ArrayList<Tile> tiles;
  
  public Discarded()
  {
	  tiles = new ArrayList<Tile>();
  }
  
  public ArrayList<Tile> getDiscarded()
  {
	  return tiles;
  }
  
  public void discard(Tile t)
  {
	  tiles.add(t);
  }
  
  public void updateAfterRefill()
  {
	  for(int i = 0; i < 100; i++)
	  {
		  tiles.remove(0);
	  }
  }
}
