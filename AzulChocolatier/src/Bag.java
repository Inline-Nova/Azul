import java.util.*;

public class Bag extends tileStorage
{
  private ArrayList<Tile> tiles;
  
  public Bag()
  {
	  tiles = new ArrayList<Tile>();
	  //20 of each color: blue, black, red, white, brown
	  for(int i = 0; i < 20; i++)
	  {
		  tiles.add(new Tile("blue"));
		  tiles.add(new Tile("black"));
		  tiles.add(new Tile("red"));
		  tiles.add(new Tile("white"));
		  tiles.add(new Tile("brown"));
	  }
	  super.shuffle(tiles);
  }
  
  public ArrayList<Tile> getNewFacTiles()
  {
	  ArrayList<Tile> newTiles = new ArrayList<Tile>();
	  for(int i = 0; i < 4; i++)
	  {
		  newTiles.add(tiles.get(0));
		  tiles.remove(0);
	  }
	  return newTiles;
  }
  
  public void refill(Discarded dis)
  {
	  //need to update discarded class
	  ArrayList<Tile> yeet = new ArrayList<Tile>();
	  yeet = dis.getDiscarded();
	  for(int i = 0; i < 100; i++)
	  {
		  tiles.add(yeet.get(i));
	  }
	  dis.updateAfterRefill();
	  shuffle(tiles);
  }
}
