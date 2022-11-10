import java.util.ArrayList;

public class AzMain {
	private ArrayList<playerBoard> boards;
	private Discarded discardedTiles;
	private Bag bag;
	private factoryDisplay factories;
	private int currFact, currPlayer;
	
	public AzMain()
	{
		//uhqaiutw
	}
	
	public playerBoard getPlayerBoard(int player) {
		return boards.get(player);
	}
	
	public factoryDisplay getFactories()
	{
		return factories;
	}
}
