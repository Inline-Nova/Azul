import java.util.*;

public class Bag extends tileStorage
{
  
  
  public Bag()
  {
	  ArrayList<Tile> temp = new ArrayList<>();
	  //20 of each color: blue, black, red, white, brown
	  for(int i = 0; i < 20; i++)
	  {
		  temp.add(new Tile("blue"));
		  temp.add(new Tile("black"));
		  temp.add(new Tile("red"));
		  temp.add(new Tile("white"));
		  temp.add(new Tile("brown"));
	  }
	  super.fillTiles(temp);

  }
  
  public ArrayList<Tile> getNewFacTiles()
  {
	  ArrayList<Tile> newTiles = new ArrayList<Tile>();
	  for(int i = 0; i < 4; i++)
	  {
		  newTiles.add(super.getTiles().get(0));
		  super.getTiles().remove(0);
	  }
	  return newTiles;
  }
  
  
  
  public void refill(Discarded dis)
  {
	  //need to update discarded class
	  super.fillTiles(dis.getTiles());
  }
  
  public String toString() {
	  return (super.getTiles().toString());
  }
}
