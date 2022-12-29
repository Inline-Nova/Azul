import java.util.*;

public class factoryDisplay
{
  private ArrayList<ArrayList<Tile>> factories; //hi
  //private String title;
  
  public factoryDisplay(ArrayList<ArrayList<Tile>> te) {
	  factories = te;
  }
  
  public factoryDisplay(Bag bag, Discarded dis)
  {
	  factories = new ArrayList<ArrayList<Tile>>();
	  fillFactories(bag, dis);
	  setCoords();
  }
  
//  public ArrayList<ArrayList<Tile>> changeFacts(ArrayList<ArrayList<Tile>>facts) {
//	  factories = new ArrayList<ArrayList<Tile>>();
//	  for(ArrayList<Tile> tis: facts) {
//		  factories.add(tis);
//	  }
//	  return factories();
//  }
  
  public void fillFactories(Bag bag, Discarded dis)
  {
	  Bag tempBag = bag;
//	  System.out.println();
//	  System.out.println("DIS: " + dis.getTiles().toString());
//	  if(bag.getTiles().size() < 36)
//		{
//			System.out.println("BAG SIZE: " + tempBag.getTiles().size());
//			tempBag.refill(dis);
//			System.out.println("BAG SIZE AFTER: " + tempBag.getTiles().size());
//		}
	//ArrayList<Tile> result = new ArrayList<Tile>();
	for(int i = 0; i < 9; i++)
	{
		factories.add(tempBag.getNewFacTiles()); //Bag class needs to be finished
		
	}
	factories.add(new ArrayList<Tile>());
//	for(ArrayList<Tile> tis: factories) {
//		for(Tile ti: tis) {
//			System.out.print(ti.toString() + ", ");
//		}
//		System.out.println();
//	}
	//System.out.println("TEMPBAG (" + tempBag.getTiles().size() + ") ");
	//return factories;
	setCoords();
  }
  
  
  public ArrayList<ArrayList<Tile>> getFactories()
  {
	  return factories;
  }
  
  public ArrayList<Tile> getSectTiles(int sect)
  {
	  return factories.get(sect); //wf
  }
  
  public boolean allIsEmpty() {
	  for(int i = 0; i < 10; i++)
		{
			if(!(factories.get(i).isEmpty()))
			{
				return false;
			}
		}
	  return true;
  }
  
  public void addOneTile() {
	  factories.get(9).add(new Tile("one"));
	  setCoordsMid();
  }
  
 public void removeOneTile() {
	  
  }
  
  public ArrayList<Tile> moveTiles(int sect, Tile til){
	  ArrayList<Tile> tiles = new ArrayList<>();
	  if(sect != 9) { 
		  for(Tile ti: factories.get(sect)) {
			  if(ti.toString().equals(til.toString())) {
				  tiles.add(ti);
			  }else {
				  factories.get(9).add(ti);
			  }
		  }
		  factories.get(sect).clear();
	  }else {
		  ListIterator<Tile> iter = factories.get(9).listIterator();
		  Tile temp;
		  while(iter.hasNext()) {
			  temp = iter.next();
			  if(temp.toString().equals(til.toString())) {
				  tiles.add(temp);
				  iter.remove();
			  }
		  }
	  }
	  //setCoords();
	  setCoordsMid();
	  return tiles;
  }
  
  public void setCoords(){
	  int[][][] coords = { {{867, 150},{917, 150}, {867, 200}, {917, 200}}, 
			  {{1070, 230}, {1120, 230}, {1070, 280}, {1120, 280}},
			  {{1130, 410}, {1180, 410}, {1130, 460}, {1180,460}},
			  {{1107, 595}, {1157, 595}, {1107, 645}, {1157, 645}},
			  {{940, 700}, {990, 700}, {940, 750}, {990, 750}},
			  {{744, 703}, {794, 703}, {744, 753}, {794,753}},
			  {{595, 563}, {645, 563}, {595, 613}, {645, 613}},
			  {{572, 375}, {622, 375}, {572, 425}, {622, 425}},
			  {{666, 207}, {716, 207}, {666, 257}, {716, 257}}};
	  for(int i = 0; i < factories.size()-1; i++) {
		  for(int j = 0; j < 4/*factories.get(0).size()*/; j++) {
			  factories.get(i).get(j).changeCoords(coords[i][j][0], coords[i][j][1]);
		  }
	  }
	 
  }
  
  public void setCoordsMid(){
	//coords for middle
	  int[] midCoord = {760, 360};
	  for(int i = 0; i < factories.get(9).size(); i++){
		  if(i < 7) {
			  factories.get(9).get(i).changeCoords(760 + (i*40), 360);
		  }else if(i < 14) {
			  factories.get(9).get(i).changeCoords(760 + ((i-7)*40), 405);
		  }else if(i < 21) {
			  factories.get(9).get(i).changeCoords(760 + ((i-14)*40), 450);
		  }else if(i < 28){
			  factories.get(9).get(i).changeCoords(760 + ((i-21)*40), 495);
		  }else if(i < 35) {
			  factories.get(9).get(i).changeCoords(760 + ((i-28)*40), 540);
		  }
	  }
  }
	  
}
