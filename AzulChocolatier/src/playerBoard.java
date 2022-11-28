import java.util.*;
import java.util.TreeSet;

public class playerBoard
{
  private ArrayList<Tile[]> patternLines;
  private ArrayList<Tile> floorLine;
  private ArrayList<TreeSet<Tile>> wall;
  private boolean gameDone;
  private int score;
  
  public playerBoard()
  {
	  score = 0;
	  patternLines = new ArrayList<>();
	  for(int i = 1; i < 6; i++) {
		  patternLines.add(new Tile[i]); 
	  }
	  floorLine = new ArrayList<>();
	  wall = new ArrayList<>();
	  for(int i = 0; i < 6; i++) {
		  wall.add(new TreeSet<Tile>());
	  }
	  
  }
  
  public void addToPatternLines(ArrayList<Tile> tis, int row) {
	  System.out.println("addToPatternLine");
	  System.out.println(tis.toString());
	  for(Tile ti: tis) {
		  System.out.println("ti: " + ti.toString());
		  Boolean placed = false;
		  if(row != 5) {
			  for(int i = 0; i < patternLines.get(row).length; i++) {
				  if(patternLines.get(row)[i] == null) {
					  patternLines.get(row)[i] = ti;
					  System.out.println("hi " + patternLines.get(row).toString());
					  for(Tile titi: patternLines.get(row)) {
						  if(titi != null)System.out.print(titi.toString() + ", ");
						  else System.out.print("n/a, ");
					  }
					  System.out.println();
					  placed = true;
					  if(placed)break;
				  }
			  }
			  if(!placed) {//this placed in floor line if patternLine is full
				  floorLine.add(ti);
			  }
		  }else {
			  floorLine.add(ti);
		  }
	  }
  }
  
  public String printPatternLines() {
	  String temp = "";
	  for(Tile[] tis: patternLines) {
		  for(Tile titi: tis) {
			  if(titi != null)System.out.print(titi.toString() + ", ");
			  else System.out.print("n/a, ");
     		}
		  System.out.println();
	  }
	  return temp;
  }
  
  public ArrayList<TreeSet<Tile>> getWall(){
	  return wall;
  }
  
  public ArrayList<Tile> getFloorLine() {
	  return floorLine;
  }
  
  public ArrayList<Tile[]> getPatternLines(){
	  return patternLines;
  }
  
  public int getScore() {
	  return score;
  }
  
  public boolean gameEnd() {
	  gameDone = true;
	  return gameDone;
  }
  
  public void checkRow() {
	  for (Tile[] a: patternLines) {
		  int num = 0;
		  for (int i = 0; i < a.length; i++) {
			  if (!a[i].equals(null)) {
				  num++;
			  }
		  }
		  if (num == 5) {
			  score += 2;
		  }
	  }
  }
  public void checkColumn() {
	  for (int j = 0; j < patternLines.get(j).length; j++) {
		  int num = 0;
		  for (int i = 0; i < patternLines.size(); i++) {
			  if (!patternLines.get(i)[j].equals(null)) {
				  num++;
			  }
		  }
		  if (num == 5) {
			  score += 5;
		  }
	  }
  }
  public void checkCompleteSet() {
	  
  }
  
  public void setCoords() {
	  
  }
}

