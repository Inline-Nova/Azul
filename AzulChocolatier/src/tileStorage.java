import java.util.*;
public class tileStorage
{
	private ArrayList<Tile> tiles;
	
	public tileStorage() {
		tiles = new ArrayList<>();
	}
	
	public tileStorage(ArrayList<Tile> tis) {
		tiles = new ArrayList<>();
		tiles = tis;
		shuffle();
	}
	
	public void fillTiles(ArrayList<Tile> tis) {
		tiles = tis;
		shuffle();
	}
	
	public void empty() {
		tiles = new ArrayList<>();
	}
	
	public void addTile(Tile ti) {
		tiles.add(ti);
	}
	
	public void shuffle() {
		Collections.shuffle(tiles);
	}
	
	public ArrayList<Tile> getTiles(){
		  return tiles;
	  }
	
	public String toString() {
		return tiles.toString();
	}
}
