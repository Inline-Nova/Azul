import java.util.ArrayList;

public class AzMain {
	private ArrayList<playerBoard> boards;
	private Discarded discarded;
	private Bag bag;
	private factoryDisplay factories;
	private int currPlayer;
	private int[] choices = {0,0,0};
	
	public AzMain() {
	
		boards = new ArrayList<playerBoard>();
		boards.add(new playerBoard()); //idx 0 top left
		boards.add(new playerBoard()); //idx 1 top right
		boards.add(new playerBoard()); //idx 2 botton left
		boards.add(new playerBoard()); //idx 3 bottom right
		
		currPlayer = (int)(Math.random()*4);
		System.out.println("Curr player: " + currPlayer);
		//set number for whoever has starting tile
		bag = new Bag();
		discarded = new Discarded();
		factories = new factoryDisplay(bag, discarded);
	}
	
	public void changeChoices(int sect, int tile, int row) {
		if(sect != 0) choices[0] = sect-1; //0-10 factories or mid
		if(tile != 0) choices[1] = tile-1; //0-4
		if(row != 0) choices[2] = row-1; //0-4
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
	
	public int getSect() {
		return choices[0];
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
    	//gets the playerBoard of currPlayer
    	playerBoard currentPlayer = new playerBoard();
    	currentPlayer = boards.get(currPlayer);
    	
    	ArrayList<TreeSet<String>> wall = currentPlayer.getWall();
    	for(int i = 0; i < 5; i++)
    	{
    		if(wall.get(i).contains(color))
    		{
    			check.add(false);
    		}
    		else
    		{
    			check.add(true);
    		}
    	}
    	return check;
    }
    
    public void newRound()
    {
    	factories.fillFactories(bag, discarded);
    	
    	//refill factories, set currPlayer to whoever has starting tile
    }
}
