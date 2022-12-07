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
		for(Tile ti: tis) {
			tiles.add(new Tile(ti.toString()));
		}
		shuffle();
	}
	
	public void empty() {
		tiles = new ArrayList<>();
	}
	
	public void addTile(Tile ti) {
		tiles.add(ti);
	}
	
	public void addTile(Tile ti, int am) {
		for(int i = 0; i < am; i++) {
			tiles.add(new Tile(ti.toString()));
		}
	}
	
	public void removeAm(int am) {
		for (int i = 0; i < am; i++) {
			tiles.remove(0);
		}
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
