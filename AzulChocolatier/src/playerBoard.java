import java.util.*;

public class playerBoard
{
  private ArrayList<String[]> patternLines;
  private String[] floorLine;
  private ArrayList<TreeSet<String>> wall;
  
  
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
  
  
  
}

