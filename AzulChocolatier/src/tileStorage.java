import java.util.*;
public class tileStorage
{
	public ArrayList<Tile> shuffle(ArrayList<Tile> tiles) {
		ArrayList<Tile> temp = tiles;
		Collections.shuffle(temp);
		return temp;
	}
}
