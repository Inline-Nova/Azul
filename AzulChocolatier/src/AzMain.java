import java.util.ArrayList;

public class AzMain {
	private ArrayList<playerBoard> boards;
	private Discarded discarded;
	private Bag bag;
	private factoryDisplay factories;
	private int currFact, currPlayer;
	
	public AzMain()
	{
		boards = new ArrayList<playerBoard>();
		boards.add(new playerBoard()); //idx 0 top left
		boards.add(new playerBoard()); //idx 1 top right
		boards.add(new playerBoard()); //idx 2 botton left
		boards.add(new playerBoard()); //idx 3 bottom right
		
		currPlayer = (int)(Math.random()*4);
		System.out.println("Curr player: " + currPlayer);
		//uhqaiutw
		bag = new Bag();
		discarded = new Discarded();
	}
	
	public playerBoard getPlayerBoard(int player) {
		return boards.get(player);
	}
	
	public factoryDisplay getFactories()
	{
		return factories;
	}
	
	public int getCurr() {
		return currPlayer;
	}
	
		public ArrayList<int> chooseFac(int sect)
	{
		//the numbers go in order of black, blue, brown, red, white
		ArrayList<int> available = new ArrayList<int>();
		ArrayList<Tile> tiles = new ArrayList<Tile>();
		tiles = getSectTiles(sect);
		return available;
	}
}
