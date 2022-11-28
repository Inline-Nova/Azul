import java.util.*;

public class factoryDisplay
{
  private ArrayList<ArrayList<Tile>> factories; //hi
  
  public factoryDisplay(Bag bag, Discarded dis)
  {
	  factories = new ArrayList<ArrayList<Tile>>();
	  fillFactories(bag, dis);
	  setCoords();
  }
  
  public void fillFactories(Bag bag, Discarded dis)
  {
	for(int i = 0; i < 10; i++)
	{
		if(bag.getTiles().isEmpty())
		{
			bag.refill(dis);
		}
		factories.add(bag.getNewFacTiles()); //Bag class needs to be finished
	}
  }
  
  
  public ArrayList<ArrayList<Tile>> getFactories()
  {
	  return factories;
  }
  
  public ArrayList<Tile> getSectTiles(int sect)
  {
	  return factories.get(sect); //wf
  }
  
  public ArrayList<Tile> moveTiles(int sect, Tile til){
	  System.out.println("moveTiles");
	  ArrayList<Tile> tiles = new ArrayList<>();
	  if(sect != 9) {
		  for(Tile ti: factories.get(sect)) {
			  if(ti.toString().equals(til.toString())) {
				  tiles.add(ti);
			  }else {
				  factories.get(9).add(til);
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
	  return tiles;
  }
  
  public void setCoords(){
	  int[][][] coords = { {{867, 150},{917, 150}, {867, 200}, {917, 200}}, 
			  {{1070, 225}, {1120, 225}, {1070, 275}, {1120, 275}},
			  {{1130, 410}, {1180, 410}, {1130, 460}, {1180,460}},
			  {{1107, 595}, {1157, 595}, {1107, 645}, {1157, 645}},
			  {{940, 700}, {990, 700}, {940, 750}, {990, 750}},
			  {{744, 703}, {794, 703}, {744, 753}, {794,753}},
			  {{595, 563}, {645, 563}, {595, 613}, {645, 613}},
			  {{572, 375}, {622, 375}, {572, 425}, {622, 425}},
			  {{666, 207}, {716, 207}, {666, 257}, {716, 257}}};
	  for(int i = 0; i < 9/*factories.size()*/; i++) {
		  for(int j = 0; j < 4/*factories.get(0).size()*/; j++) {
			  factories.get(i).get(j).changeCoords(coords[i][j][0], coords[i][j][1]);
		  }
	  }
  }
	  
}
