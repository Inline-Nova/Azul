import java.util.*;

public class factoryDisplay
{
  private ArrayList<ArrayList<Tile>> factories; //hi
  
  public factoryDisplay(Bag bag, Discarded dis)
  {
	  factories = new ArrayList<ArrayList<Tile>>();
	  fillFactories(bag, dis);
  }
  
  public void fillFactories(Bag bag, Discarded dis)
  {
	for(int i = 0; i < 10; i++)
	{
		if(bag.getTiles().isEmpty())
		{
			bag.refill(dis);
		}
		factories.add(bag.getNewFacTiles()); //Bag class needs to be finished
	}
  }
  
  
  public ArrayList<ArrayList<Tile>> getFactories()
  {
	  return factories;
  }
  
  public ArrayList<Tile> getSectTiles(int sect)
  {
	  return factories.get(sect); //wf
  }
}
