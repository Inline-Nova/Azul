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
	  //System.out.println("addToPatternLine");
	  //System.out.println(tis.toString());
	  for(Tile ti: tis) {
		  //System.out.println("ti: " + ti.toString());
		  Boolean placed = false;
		  if(row != 5) {
			  for(int i = 0; i < patternLines.get(row).length; i++) {
				  if(patternLines.get(row)[i] == null) {
					  patternLines.get(row)[i] = ti;
					  //System.out.println("hi " + patternLines.get(row).toString());
//					  for(Tile titi: patternLines.get(row)) {
//						  if(titi != null)System.out.print(titi.toString() + ", ");
//						  else System.out.print("n/a, ");
//					  }
					  //System.out.println();
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
	  printPatternLines();
  }
  
  public String printPatternLines() {
	  System.out.println();
	  String temp = "";
	  for(Tile[] tis: patternLines) {
		  for(Tile titi: tis) {
			  if(titi != null)System.out.print(titi.toString() + ", ");
			  else System.out.print("n/a, ");
     		}
		  System.out.println();
	  }
	  System.out.println(floorLine.toString());
	  System.out.println();
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
	  for (int cnt = 0; cnt < 5; cnt++) {
		  int num = 0;
		  for (int i = 0; i < patternLines.size(); i++) {
			  for (int j = 0; j < patternLines.get(j).length; j++) {
				  //if () {
					  // idk how to get the color of the tiles - use toString()
				  //}
	  int num = 0;
	  for (Tile[] a: patternLines) {
		  for (int i = 0; i < a.length; i++) {
			  if (a[i].toString().equals("blue")) {
				  num++;
			  }
		  }
	  }
	  if (num == 5) {
		  score += 7;
	  }
	  num = 0;
	  for (Tile[] a: patternLines) {
		  for (int i = 0; i < a.length; i++) {
			  if (a[i].toString().equals("black")) {
				  num++;
			  }
		  }
	  }
	  if (num == 5) {
		  score += 7;
	  }
	  num = 0;for (Tile[] a: patternLines) {
		  for (int i = 0; i < a.length; i++) {
			  if (a[i].toString().equals("red")) {
				  num++;
			  }
		  }
	  }
	  if (num == 5) {
		  score += 7;
	  }
	  num = 0;for (Tile[] a: patternLines) {
		  for (int i = 0; i < a.length; i++) {
			  if (a[i].toString().equals("white")) {
				  num++;
			  }
		  }
	  }
	  if (num == 5) {
		  score += 7;
	  }
	  num = 0;for (Tile[] a: patternLines) {
		  for (int i = 0; i < a.length; i++) {
			  if (a[i].toString().equals("brown")) {
				  num++;
			  }
		  }
	  }
	  if (num == 5) {
		  score += 7;
	  }
  }
	
 public int checkHorAdj()
  {
	 int count = 0;
	 ListIterator<Tile> iter;
	  //if patternline row is full, check HorAdj. if not, do nothing
	  //discard all but one tile
	  for(int i = 0; i < patternLines.size(); i++)
	  {
		  Tile[] row = patternLines.get(i);
		  if(!row[row.length - 1].isEmpty())
		  {
			  //patternline row is full
			  Tile newlyAddedTile = row[0];
			  //add tile to wall (see pic for reference)
			  TreeSet<Tile> wallRow = wall.get(i);
			  iter = wallRow.iterator();
			  while(iter.hasNext())
			  {
				  //need to finish, iterate through wallRow
			  }
		  }
	  }
	 return count;
  }
  
  
  public int checkVertAdj()
  {
	  return 0;
  }
	
  public void setCoordsPat(int curr) {
	  int[][][] coords = {};
	  if(curr == 0) { //30x30 for pat &  24x24
		  int[][][] temp = {{{219,200}}, {{219, 236}, {183, 236}}, 
				  {{219, 273}, {183, 273}, {145, 273}}, {{219, 309}, 
					  {183, 309}, {145, 309}, {108, 309}}, 
				  {{219, 345}, {183, 345}, {145, 345}, {108, 345}, {71, 345}}, 
				  {{74, 417}, {116, 417}, {156, 417}, {198, 417}, {235, 417}, {278, 417}, {341, 417}}};
		  coords = temp;
	  }else if(curr == 3) {
		  int[][][] temp = {{{219,651}}, {{219, 689}, {183, 689}}, 
				  {{219, 726}, {183, 726}, {145, 726}}, 
				  {{219, 762}, {183, 762}, {145, 762}, {108, 762}}, 
				  {{219, 799}, {183, 799}, {145, 799}, {108, 799}, {71, 799}}, 
				  {{74, 870}, {116, 870}, {156, 870}, {198, 870}, {235, 870}, {278, 870}, {341, 870}}};
		  coords = temp;
	  }else if(curr == 1) {
		  int[][][] temp = {{{1466,200}}, {{1466, 236}, {1431, 236}}, 
				  {{1466, 273}, {1431, 273}, {1393, 273}}, 
				  {{1466, 309}, {1431, 309}, {1393, 309}, {1356, 309}}, 
				  {{1466, 345}, {1431, 345}, {1393, 345}, {1356, 345}, {1319, 345}}, 
				  {{1320, 417}, {1363, 417}, {1405, 417}, {1443, 417}, {1481, 417}, {1524, 417}, {1564, 417}}};
		  coords = temp;
	  }else if(curr == 2) {
		  int[][][] temp = {{{1466,651}}, {{1466, 689}, {1431, 689}}, 
				  {{1466, 726}, {1431, 726}, {1396, 726}}, 
				  {{1466, 762}, {1431, 762}, {1393, 762}, {1356, 762}}, 
				  {{1466, 799}, {1431, 799}, {1393, 799}, {1356, 799}, {1319, 799}}, 
				  {{1320, 870}, {1363, 870}, {1405, 870}, {1443, 870}, {1481, 870}, {1524, 870}, {1564, 870}}};
		  coords = temp;
	  }
	  
	  for(int i = 0; i < patternLines.size(); i++) {
		  for(int j = 0; j < patternLines.get(i).length; j++) {
			  if(patternLines.get(i)[j]!= null) patternLines.get(i)[j].changeCoords(coords[i][j][0]+1, coords[i][j][1]+1);
		  }
	  }
	  for(int i = 0; i < floorLine.size(); i++) {
		  if(i < 7) {
			  floorLine.get(i).changeCoords(coords[5][i][0], coords[5][i][1]);
		  }
	  }
	  System.out.println("\n FloorLine");
	  for(int i = 0; i < floorLine.size(); i++) {
		  System.out.print("(" + floorLine.get(i).getX() + ", " + floorLine.get(i).getY() + "), ");
	  }
	  System.out.println();
	  System.out.println();
  }
  
  public void setCoordsPatPick(){
	  int[][][] coords = {{{1222, 297}},
			  {{1222, 380}, {1138, 380}},
			  {{1222, 459}, {1138, 459}, {1052, 459}},
			  {{1222, 542}, {1138, 542}, {1052, 542}, {968,542}},
			  {{1222, 623}, {1138, 623}, {1052, 623}, {968,623}, {882, 623}},
			  {{883, 720}, {942, 720}, {1001, 720}, {1060, 720}, {1119, 720}, {1178, 720}, {1237, 720},}};
	  
	  
	  for(int i = 0; i < patternLines.size(); i++) {
		  for(int j = 0; j < patternLines.get(i).length; j++) {
			  if(patternLines.get(i)[j]!= null) patternLines.get(i)[j].changeCoords(coords[i][j][0], coords[i][j][1]);
		  }
	  }
	  for(int i = 0; i < floorLine.size(); i++) {
		  if(i < 7) {
			  floorLine.get(i).changeCoords(coords[5][i][0], coords[5][i][1]);
		  }
	  }
  }
  
}

