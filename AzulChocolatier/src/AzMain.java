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
		factories = factoryDisplay(bag);
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
	
    public ArrayList<Integer> chooseFac(int sect){
		//the numbers go in order of black, blue, brown, red, white
		ArrayList<Integer> available = new ArrayList<Integer>();
		ArrayList<Tile> tiles = new ArrayList<Tile>();
		tiles = factories.getSectTiles(sect);
		for(int i = 0; i < 5; i++) {
			available.add(0);
		}
		for(int i = 0; i< tiles.size(); i++) {
			if(tiles.get(i).toString().equals("black")) {
				available.set(0, available.get(0) + 1);
			}else if(tiles.get(i).toString().equals("blue")) {
				available.set(1, available.get(1) + 1);
			}else if(tiles.get(i).toString().equals("brown")) {
				available.set(2, available.get(2) + 1);
			}else if(tiles.get(i).toString().equals("red")) {
				available.set(3, available.get(3) + 1);
			}else if(tiles.get(i).toString().equals("white")) {
				available.set(4, available.get(4) + 1);
			}
		}
		return available;
	}
    
    
    public ArrayList<Boolean> chooseTile(String color)
    {
    	ArrayList<Boolean> check = new ArrayList<Boolean>();
    	
    	return check;
    }
    
    public void newRound()
    {
    	//refill factories, set currPlayer to whoever has starting tile
    }
}
