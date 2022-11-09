import java.util.*;

public class factoryDisplay
{
  private ArrayList<ArrayList<Tile>> factories; //hi
  
  public factoryDisplay(Bag bag)
  {
	  factories = new ArrayList<ArrayList<Tile>>();
	  fillFactories(bag);
  }
  
  public void fillFactories(Bag bag)
  {
	for(int i = 0; i < 10; i++)
	{
		factories.add(bag.getNewFacTiles()); //Bag class needs to be finished
	}
  }
  
  
  public ArrayList<ArrayList<Tile>> getFactories()
  {
	  return factories;
  }
  
  public ArrayList<Tile> getSectTiles(int sect)
  {
	  return factories.get(sect);
  }
}

