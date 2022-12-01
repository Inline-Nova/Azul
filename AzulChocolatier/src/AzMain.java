import java.util.ArrayList;
import java.util.TreeSet;

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
		
		
		//System.out.println(boards.get(0).printPatternLines());
	}
	
	public void changeChoices(int sect, int tile, int row) {
		if(sect != 0) choices[0] = sect-1; //0-10 factories or mid
		if(tile != 0) {
			//System.out.println("hiya");
			choices[1] = tile-1; //0-4 color choosen
			checkPats();
		}
		if(row != 0) choices[2] = row-1; //0-4 row choosen
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
	
	public int getTile() {
		return choices[1];
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
    
    
        public ArrayList<Boolean> checkPats() //returns arraylist of boolean if tile can go in the pattern lines
    {
        	//System.out.println("HIYA");
    	String color = "";
		//shade sections that can't be choosen
		if(getTile() == 0) 
			color = "black";
		else if(getTile() == 1) 
			color = "blue";
		else if(getTile() == 2) 
			color = "brown";
		else if(getTile() == 3) 
			color = "red";
		else if(getTile() == 4) 
			color = "white";
    	Tile t = new Tile(color);
    	ArrayList<Boolean> check = new ArrayList<Boolean>();
    	
    	for(int i = 0; i < 5; i++) {
    		check.add(true);
    		for(int j = 0; i < boards.get(currPlayer).getWall().get(i).size(); j++) {
    			if(!boards.get(currPlayer).getWall().get(i).toString().equals(t.toString())) 
    				check.set(i, false);
    		}
    		if(boards.get(currPlayer).getPatternLines().get(i)[0] != null && !(boards.get(currPlayer).getPatternLines().get(i)[0].toString().equals(t.toString())))
    			check.set(i, false);
    		else if(boards.get(currPlayer).getPatternLines().get(i)[boards.get(currPlayer).getPatternLines().get(i).length-1] != null){
    			check.set(i, false);
    		}
    	}
    	// || (!(patternLines.get(i)[0] == null) && !patternLines.get(i)[0].toString().equals(t.toString()))
//    	System.out.println("Tile: " + t.toString());
//    	System.out.println("Pat: " + boards.get(currPlayer).getPatternLines().get(0)[0]);
    	
    	
    	return check;
    }

	public Boolean checkRow(int r) {
		return this.checkPats().get(r);
	}
    
     public void useChoices() { //method needs to move the tiles from the factory (or middle) to where ever
     	ArrayList<Integer> tiles = chooseFac(getSect()); //how many of each color in choosen fact
     	//need to move choosen Tiles to Pattern Lines
     	
     	//System.out.println("useChoices");
     	ArrayList<Tile> tis = new ArrayList<>();
     	int tilesNum = 0;
     	
     	if(choices[1] == 0) tis = factories.moveTiles(choices[0], new Tile("black"));
     	else if(choices[1] == 1) tis = factories.moveTiles(choices[0], new Tile("blue"));
     	else if(choices[1] == 2) tis = factories.moveTiles(choices[0], new Tile("brown"));
     	else if(choices[1] == 3) tis = factories.moveTiles(choices[0], new Tile("red"));
     	else if(choices[1] == 4) tis = factories.moveTiles(choices[0], new Tile("white"));
     	
     	//System.out.println(tis.toString());
     	boards.get(currPlayer).addToPatternLines(tis, choices[2]);
     	//System.out.println(boards.get(currPlayer).printPatternLines());
     	
     	boards.get(currPlayer).setCoordsPat(currPlayer);
     	//System.out.println("facts: " + factories.getSectTiles(9).toString());
     	factories.setCoordsMid();
//     	if(choices[2] != 5) {
//     		for(Tile titi: boards.get(currPlayer).getPatternLines().get(choices[2])) {
//			  if(titi != null)System.out.print(titi.toString() + ", ");
//			  else System.out.print("n/a, ");
//     		}
//     	}
     	
//     	System.out.println();
     	for(Tile tit: boards.get(currPlayer).getFloorLine()) {
			  if(tit != null)System.out.print(tit.toString() + ", ");
			  else System.out.print("n/a, ");
		  }
     	
     	
     	currPlayer++;
     	if(currPlayer > 3) currPlayer = 0;
     	//System.out.println(boards.get(0).getPatternLines().get(0)[0].toString());
     	if(getFactories().allIsEmpty()) {
			System.out.println("empty");
		}
     }
     
    public void score() {
    	for(int i = 0; i < 4; i++) {
    		//boards.get(i)
    	}
    	//factories.refill();
    }
     
    public void newRound()
    {
    	factories.fillFactories(bag, discarded);
    	
    	//refill factories, set currPlayer to whoever has starting tile
    }
}
