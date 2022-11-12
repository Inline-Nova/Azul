import java.util.ArrayList;

public class AzMain {
	private ArrayList<playerBoard> boards;
	private Discarded discardedTiles;
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
}
