import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.time.Instant;
import java.util.ArrayList;

public class AzMain {
	private ArrayList<playerBoard> boards;
	private Discarded discarded;
	private Bag bag;
	private factoryDisplay factories;
	private int currPlayer, currScoring;
	private int[] choices = {0,0,0};
	private int one, playOne; //for one: 0 is start of round, 1 is in mid, 2 is in floorline
	private boolean done, scoring;
	private String win;
	
	public AzMain() {
    	
		
		
		
		win = "";
		one = 0;
		done = false;
		scoring = false;
		boards = new ArrayList<playerBoard>();
		boards.add(new playerBoard()); //idx 0 top left
		boards.add(new playerBoard()); //idx 1 top right
		boards.add(new playerBoard()); //idx 2 botton left
		boards.add(new playerBoard()); //idx 3 bottom right
		
		currScoring = 0;
		currPlayer = (int)(Math.random()*4);
		//System.out.println("Curr player: " + currPlayer);
		playOne = currPlayer;
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
	
	public boolean getScoring() {
		return scoring;
	}
	
	public int getOne() {
		return one;
	}
	
	public boolean getDone() {
		return done;
	}
	
	public Discarded getDiscarded() {
		return discarded;
	}
	
	public Bag getBag() {
		return bag;
	}
	
	public int getCurrScor() {
		return currScoring;
	}
	
	
	public int getCurrOne() {
		return playOne;
	}
	
	public void setOne(int on) {
		one = on;
		if(on == 1) factories.addOneTile();
		//factories.setCoordsMid();
		//System.out.println(factories.getSectTiles(9));
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
		if(sect == 9 && one == 1) {
			ArrayList<Tile> tis = new ArrayList<>();
			tis.add(new Tile("one"));
			boards.get(currPlayer).addToPatternLines(tis, 5);
			factories.moveTiles(9, new Tile("one"));
			//factories.setCoordsMid();
			one = 2;
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
    		for(int j = 0; j < (boards.get(currPlayer).getWall()[i].length); j++) {
    			if(boards.get(currPlayer).getWall()[i][j] != null && boards.get(currPlayer).getWall()[i][j].toString().equals(t.toString())) 
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
//     	for(Tile tit: boards.get(currPlayer).getFloorLine()) {
//			  if(tit != null)System.out.print(tit.toString() + ", ");
//			  else System.out.print("n/a, ");
//		  }
//     	
//     	ArrayList<ArrayList<Tile>> temp = new ArrayList<>();
     	currPlayer++;
     	if(currPlayer > 3) currPlayer = 0;
     	if(getFactories().allIsEmpty()) {
     		currScoring = 0;
     		scoring = true;
     	}
//     	//System.out.println(boards.get(0).getPatternLines().get(0)[0].toString());
//     	if(getFactories().allIsEmpty()) {
//     		//System.out.println("empty?");
//			scoreAll();
//			boolean end = false;
//			for(playerBoard ply: boards) {
//				if(ply.checkRow()) {
//					System.out.println("END");
//					end = true;
//				}
//			}
//			if(!end) {
//				
//				System.out.println();
//				System.out.println("BAG SIZE: " + bag.getTiles().size());
//				System.out.println("DISCARDED SIZE: " + discarded.getTiles().size());
//				System.out.println();
//				ArrayList<Tile> tempTis = factories.fillFactories(bag, discarded);
//				for(Tile ti: tempTis) {
//					tempTis.add(ti);
//				}
				//System.out.println("FUCKKKKK: " + factories.getSectTiles(0));
//				if(bag.getTiles().size() < 36) {
//					bag.refill(discarded);
//					discarded = new Discarded();
//				}
//				factories = new factoryDisplay(bag, discarded);
//				for(ArrayList<Tile> tiss: temp) {
//					for(Tile ti: tiss) {
//						System.out.print(ti.toString() + ", ");
//					}
//					System.out.println();
//				}
				
//				factories.fillFactories(bag, discarded);
//				System.out.println("BAG SIZE 1: " + bag.getTiles().size());
//				System.out.println("DISCARDED SIZE 1: " + discarded.getTiles().size());
//				if(tempTis.size() != bag.getTiles().size()-36) {
//					discarded = new Discarded();
//				}
//				
//				if(tempTis.size() > 0) {
//					bag = new Bag(tempTis);
//				}else {
//					bag = new Bag("zero");
//				}
//				
//				System.out.println("BAG SIZE 2: " + bag.getTiles().size());
//				System.out.println("DISCARDED SIZE 2: " + discarded.getTiles().size());
				
				//factories.setCoords();
//			}
//			
//			
//		}
//     	//System.out.println("FACTORY 9: " + factories.getSectTiles(9));
//     	factories.setCoordsMid();
     	
     }
     
    public boolean score(int curr) {
    	
    	
    	
    		ArrayList<Tile[]> currPat = boards.get(curr).getPatternLines();
    		ArrayList<Tile> currFloor = boards.get(curr).getFloorLine();
    		for(int j = 0; j < 5; j++) {
    			if(currPat.get(j)[currPat.get(j).length-1] != null) {
    				currPat.get(j)[currPat.get(j).length-1].changeCoords(0,0);
    				discarded.addTile(currPat.get(j)[currPat.get(j).length-1], j);
    				boards.get(curr).score(currPat.get(j)[currPat.get(j).length-1], j);
    				boards.get(curr).setCoordsWall(curr);
    				return true;
    				
    			}
    		}
    		if(currFloor.size() > 0) {
    			System.out.println("minus");
    				if(boards.get(curr).hasOne()) {
    					playOne = curr;
    					one = 0;
    					currPlayer = playOne;
    					//System.out.println("NEW ONE: " + playOne);
    				}
    				//System.out.println("Floor Line Before: " + currFloor);
    				ArrayList<Tile> discardTis = boards.get(curr).scoreMinus();
    				//System.out.println("Floor Line After: " + boards.get(i).getFloorLine());
    				//System.out.println("to discarded: " + discardTis.toString());
    				for(Tile ti: discardTis) {
    					ti.changeCoords(0,0);
    	    			discarded.addTile(ti);
    	    			//System.out.println("DISCARDED DISCARDED: " + discarded.getTiles().size());
    	    		}
    		}
    		
    		
    	//factories.refill();
    	if(currScoring == 3) {
    		currScoring = -1;
    		scoring = false;
    		newRound();
    	}
    	else currScoring++;
    	return false;
    }
     
    public void newRound()
    {
//    	System.out.println("new round");
//    	scoring = true;
//    	for(int i = 0; i < 4; i++) {
//    		Tile[][] tempWall = boards.get(i).getWall();
//    		for(Tile[] tis: tempWall) {
//    			for(Tile ti: tis) {
//    				if(ti != null)
//    					System.out.print(ti.toString() + ", ");
//    				else
//    					System.out.print("null, ");
//    			}
//    			System.out.println();
//    		}
//    		System.out.println("-");
//    		//boards.get(i).setCoordsWall(i);;
//    	}
//    	System.out.println("BAG SIZE: " + bag.getTiles().size());
//		System.out.println("DISCARDED SIZE: " + discarded.getTiles().size());
//    	System.out.println(discarded.toString());
			if(bag.getTiles().size() < 36) {
				System.out.println("hi");
				bag.fillTiles(discarded.getTiles());
				discarded.empty();
				System.out.println(discarded.toString());
				System.out.println(bag.toString());
			}
//	    		
//	    		discarded.empty();
//	    	}
			for(playerBoard ply: boards) {
	    		if(ply.checkRow() > 0) {
	    			System.out.println("DONE");
	    			done = true;
	    			for(int i = 0; i < 4; i++) {
	    				
	    			}
	    			int scr0 = boards.get(0).getScore();
	    			int scr1 = boards.get(1).getScore();
	    			int scr2 = boards.get(2).getScore();
	    			int scr3 = boards.get(3).getScore();
	    			if(scr0 > scr1 && scr0 > scr2 && scr0 > scr3) win = win + "0 ";
	    			else if(scr1 > scr0 && scr1 > scr2 && scr1 > scr3) win = win + "1 ";
	    			else if(scr2 > scr1 && scr2 > scr0 && scr2 > scr3) win = win + "2 ";
	    			else if(scr3 > scr1 && scr3 > scr2 && scr3 > scr0) win = win + "3 ";
	    			
	    			break;
	    		}
	    	}
			if(!done)factories = new factoryDisplay(bag, discarded);
	    	System.out.println("BAG SIZE: " + bag.getTiles().size());
			System.out.println("DISCARDED SIZE: " + discarded.getTiles().size());
//	    	bag.removeAm(36);
	    	
	    	//refill factories, set currPlayer to whoever has starting tile
    	
    }
    
    public String getWin() {
    	return win;
    }
}
