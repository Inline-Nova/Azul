import java.util.*;

public class playerBoard
{
  private ArrayList<String[]> patternLines;
  private String[] floorLine;
  private ArrayList<TreeSet<String>> wall;
  private boolean gameDone;
  private int score;
  
  public playerBoard()
  {
	  patternLines = new ArrayList<>();
	  for(int i = 1; i < 6; i++) {
		  patternLines.add(new String[i]); 
	  }
	  floorLine = new String[7];
	  wall = new ArrayList<>();
	  
  }
  
  public ArrayList<TreeSet<String>> getWall(){
	  return wall;
  }
  
  public String[] getFloorLine() {
	  return floorLine;
  }
  
  public ArrayList<String[]> getPatternLines(){
	  return patternLines;
  }
  
  public boolean gameEnd() {
	  gameDone = true;
	  return gameDone;
  }
  
  public void checkRow() {
	  for (String[] a: patternLines) {
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
}

