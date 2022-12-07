import java.util.*;
import java.util.TreeSet;

public class playerBoard
{
  private ArrayList<Tile[]> patternLines;
  private ArrayList<Tile> floorLine;
  private Tile[][] wall;
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
	  wall = new Tile[5][5];
	  
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
				  
				  if(floorLine.size() < 7) floorLine.add(ti);
				  else floorLine.add(new Tile(ti.toString()));
			  }
		  }else {
			  
			  if(floorLine.size() < 7) floorLine.add(ti);
			  else floorLine.add(new Tile(ti.toString()));
		  }
	  }
	  //printPatternLines();
  }
  
  public String printPatternLines() {
//	  System.out.println();
	  String temp = "";
	  for(Tile[] tis: patternLines) {
		  for(Tile titi: tis) {
			  if(titi != null)System.out.print(titi.toString() + ", ");
			  else System.out.print("n/a, ");
     		}
		  System.out.println();
	  }
//	  System.out.println(floorLine.toString());
//	  System.out.println();
	  return temp;
  }
  
  public Tile[][] getWall(){
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
  
  public void setScore(int sc) {
	  score = sc;
  }
  
  public boolean gameEnd() {
	  gameDone = true;
	  return gameDone;
  }
  
  public boolean hasOne() {
	  for(Tile ti: floorLine) {
		  if(ti.toString() == "one") {
			  return true;
		  }
	  }
	  return false;
  }
  
  public void score(Tile ti, int row) {
	  System.out.println("Scoring " + ti.toString() + " in row " + row);
	  System.out.println("Vert: " + checkVertAdj(ti, row) + " & Hor: " + checkHorAdj(ti, row));
	  score += checkVertAdj(ti, row) + checkHorAdj(ti, row);
	  if(checkVertAdj(ti, row) > 1 && checkHorAdj(ti, row)> 1)score += 2;
	  else if(checkHorAdj(ti, row) == 0  && checkVertAdj(ti, row) == 0) score++;
	  for(int i = 0; i < patternLines.get(row).length; i++) {
		  patternLines.get(row)[i] = null;
	  }
  }
  
  public ArrayList<Tile> scoreMinus() {
	  ArrayList<Tile> discard = new ArrayList<>();
	  for(int i = 0; i < floorLine.size(); i++) {
		  if(i < 7){
			  switch(i) {
			  case 0:
				  //System.out.println(1.1);
				  System.out.println("menos 1 " + score);
				  if(score - 1 >= 0)score = score -1;
				  else score = 0;
				  System.out.println("menos 1 " + score);
				  break;
			  case 1:
				  //System.out.println(1.2);
				  System.out.println("menos 1 " + score);
				  if(score - 1 >= 0)score = score -1;
				  else score = 0;
				  System.out.println("menos 1 " + score);
				  break;
			  case 2:
				  //System.out.println(2.1);
				  System.out.println("menos 2 " + score);
				  if(score - 2 >= 0)score = score -2;
				  else score = 0;
				  System.out.println("menos 2 " + score);
				  break;
			  case 3:
				  //System.out.println(2.2);
				  System.out.println("menos 2 " + score);
				  if(score - 2 >= 0)score = score -2;
				  else score = 0;
				  System.out.println("menos 2 " + score);
				  break;
			  case 4:
				  //System.out.println(2.3);
				  System.out.println("menos 2 " + score);
				  if(score - 2 >= 0)score = score -2;
				  else score = 0;
				  System.out.println("menos 2 " + score);
				  break;
			  case 5:
				  //System.out.println(3.1);
				  System.out.println("menos 3 " + score);
				  if(score - 3 >= 0)score = score -3;
				  else score = 0;
				  System.out.println("menos 3 " + score);
				  break;
			  case 6:
				  //System.out.println(3.2);
				  System.out.println("menos 3 " + score);
				  if(score - 3 >= 0)score = score -3;
				  else score = 0;
				  System.out.println("menos 3 " + score);
				  break;
			  }
		  }
		  if(!(floorLine.get(i).toString().equals("one"))) discard.add(floorLine.get(i));
	  }
	  floorLine = new ArrayList<>();
	  return discard;
  }
  
  
  public void checkBonus() {
	  score += checkRow();
	  score += checkColumn();
	  score += checkCompleteSet();
  }
  
  public int checkRow() {
	  int result = 0;
	  for (Tile[] a: wall) {
		  int num = 0;
		  for (int i = 0; i < a.length; i++) {
			  if (!(a[i] == null)) {
				  num++;
			  }
		  }
		  if (num == 5) {
			  result += 2;
		  }
	  }
	  System.out.println("ROW: " + result);
	  return result;
  }
  
  public int checkColumn() {
	  int result = 0;
	  for (int j = 0; j < wall[0].length; j++) {
		  int num = 0;
		  for (int i = 0; i < wall.length; i++) {
			  if (!wall[i][j].equals(null)) {
				  num++;
			  }
		  }
		  if (num == 5) {
			  result += 5;
		  }
	  }
	  System.out.println("Col: " + result);
	  return result;
  }
  
  
  public int checkCompleteSet() {
	  int result = 0;
	  for (int cnt = 0; cnt < 5; cnt++) {
		  int num = 0;
				  //if () {
					  // idk how to get the color of the tiles - use toString()
				  //}
	  num = 0;
	  for (Tile[] a: wall) {
		  for (int i = 0; i < a.length; i++) {
			  if (a[i].toString().equals("blue")) {
				  num++;
			  }
		  }
	  }
	  if (num == 5) {
		  result += 7;
	  }
	  num = 0;
	  for (Tile[] a: wall) {
		  for (int i = 0; i < a.length; i++) {
			  if (a[i].toString().equals("black")) {
				  num++;
			  }
		  }
	  }
	  if (num == 5) {
		  result += 7;
	  }
	  num = 0;for (Tile[] a: wall) {
		  for (int i = 0; i < a.length; i++) {
			  if (a[i].toString().equals("red")) {
				  num++;
			  }
		  }
	  }
	  if (num == 5) {
		  result += 7;
	  }
	  num = 0;for (Tile[] a: wall) {
		  for (int i = 0; i < a.length; i++) {
			  if (a[i].toString().equals("white")) {
				  num++;
			  }
		  }
	  }
	  if (num == 5) {
		  result += 7;
	  }
	  num = 0;for (Tile[] a: wall) {
		  for (int i = 0; i < a.length; i++) {
			  if (a[i].toString().equals("brown")) {
				  num++;
			  }
		  }
	  }
	  if (num == 5) {
		  result += 7;
	  }
	 }
	  return result;
  }

 public int checkHorAdj(Tile ti, int row)
  {
	 int col = 0;
	  switch(row) {
	  case 0:
		  if(ti.toString().equals("blue")) col = 0;
		  else if(ti.toString().equals("brown")) col = 1;
		  else if(ti.toString().equals("white")) col = 2;
		  else if(ti.toString().equals("black")) col = 3;
		  else if(ti.toString().equals("red")) col = 4;
		  
		  break;
	  case 1:
		  if(ti.toString().equals("red")) col = 0;
		  else if(ti.toString().equals("blue")) col = 1;
		  else if(ti.toString().equals("brown")) col = 2;
		  else if(ti.toString().equals("white")) col = 3;
		  else if(ti.toString().equals("black")) col = 4;
		  
		  break;
	  case 2:
		  if(ti.toString().equals("black")) col = 0;
		  else if(ti.toString().equals("red")) col = 1;
		  else if(ti.toString().equals("blue")) col = 2;
		  else if(ti.toString().equals("brown")) col = 3;
		  else if(ti.toString().equals("white")) col = 4;
		  
		  break;
	  case 3:
		  if(ti.toString().equals("white")) col = 0;
		  else if(ti.toString().equals("black")) col = 1;
		  else if(ti.toString().equals("red")) col = 2;
		  else if(ti.toString().equals("blue")) col = 3;
		  else if(ti.toString().equals("brown")) col = 4;
		  
		  break;
	  case 4:
		  if(ti.toString().equals("brown")) col = 0;
		  else if(ti.toString().equals("white")) col = 1;
		  else if(ti.toString().equals("black")) col = 2;
		  else if(ti.toString().equals("red")) col = 3;
		  else if(ti.toString().equals("blue")) col = 4;
		  
		  break;
	  }
	  int scor = 1;
	  int change = 1;
	  //System.out.println();
	  wall[row][col] = ti;
	  while(col-change >= 0) {
		  if(wall[row][col-change] != null) {
			  scor++;
			  change++;
		  }else {
			break;  
		  }
		  
	  }
	  change = 1;
	  while(col+change <= 4) {
		  if(wall[row][col+change] != null) {
			  scor++;
			  change++;
		  }else {
			 break; 
		  }
		  
	  } 
	  if(scor == 1)scor = 0;
	  return scor;
	 
	 
	 
	 
	 
	 
	 
	 // sorry it was giving errors :C
//	 int count = 0;
//	 ListIterator<Tile> iter;
//	  //if patternline row is full, check HorAdj. if not, do nothing
//	  //discard all but one tile
//	  for(int i = 0; i < patternLines.size(); i++)
//	  {
//		  Tile[] row = patternLines.get(i);
//		  if(!row[row.length - 1].isEmpty())
//		  {
//			  //patternline row is full
//			  Tile newlyAddedTile = row[0];
//			  //add tile to wall (see pic for reference)
//			  TreeSet<Tile> wallRow = wall.get(i);
//			  iter = wallRow.iterator();
//			  while(iter.hasNext())
//			  {
//				  //need to finish, iterate through wallRow
//			  }
//		  }
//	  }
//	 return count;
  }
  
  
  public int checkVertAdj(Tile ti, int row){
	  int col = 0;
	  switch(row) {
	  case 0:
		  if(ti.toString().equals("blue")) col = 0;
		  else if(ti.toString().equals("brown")) col = 1;
		  else if(ti.toString().equals("white")) col = 2;
		  else if(ti.toString().equals("black")) col = 3;
		  else if(ti.toString().equals("red")) col = 4;
		  
		  break;
	  case 1:
		  if(ti.toString().equals("red")) col = 0;
		  else if(ti.toString().equals("blue")) col = 1;
		  else if(ti.toString().equals("brown")) col = 2;
		  else if(ti.toString().equals("white")) col = 3;
		  else if(ti.toString().equals("black")) col = 4;
		  
		  break;
	  case 2:
		  if(ti.toString().equals("black")) col = 0;
		  else if(ti.toString().equals("red")) col = 1;
		  else if(ti.toString().equals("blue")) col = 2;
		  else if(ti.toString().equals("brown")) col = 3;
		  else if(ti.toString().equals("white")) col = 4;
		  
		  break;
	  case 3:
		  if(ti.toString().equals("white")) col = 0;
		  else if(ti.toString().equals("black")) col = 1;
		  else if(ti.toString().equals("red")) col = 2;
		  else if(ti.toString().equals("blue")) col = 3;
		  else if(ti.toString().equals("brown")) col = 4;
		  
		  break;
	  case 4:
		  if(ti.toString().equals("brown")) col = 0;
		  else if(ti.toString().equals("white")) col = 1;
		  else if(ti.toString().equals("black")) col = 2;
		  else if(ti.toString().equals("red")) col = 3;
		  else if(ti.toString().equals("blue")) col = 4;
		  
		  break;
	  }
	  int scor = 1;
	  int change = 1;
	  wall[row][col] = ti;
	  while(row-change >= 0) {
		  if(wall[row - change][col] != null) {
			  scor++;
			  change++;
		  }else {
			break;  
		  }
		  
	  }
	  change = 1;
	  while(row+change <= 4) {
		  if(wall[row + change][col] != null) {
			  scor++;
			  change++;
		  }else {
			 break; 
		  }
		  
	  }
	  if(scor == 1)scor = 0;
	  return scor;
  }
	
  public void setCoordsPat(int curr) {
	  int[][][] coords = {};
	  if(curr == 0) { //30x30 for pat &  24x24
		  int[][][] temp = {{{219,200}}, {{219, 236}, {183, 236}}, 
				  {{219, 273}, {183, 273}, {145, 273}}, {{219, 309}, 
					  {183, 309}, {145, 309}, {108, 309}}, 
				  {{219, 345}, {183, 345}, {145, 345}, {108, 345}, {71, 345}}, 
				  {{74, 417}, {116, 417}, {156, 417}, {198, 417}, {235, 417}, {278, 417}, {313, 417}}};
		  coords = temp;
	  }else if(curr == 3) {
		  int[][][] temp = {{{219,651}}, {{219, 689}, {183, 689}}, 
				  {{219, 726}, {183, 726}, {145, 726}}, 
				  {{219, 762}, {183, 762}, {145, 762}, {108, 762}}, 
				  {{219, 799}, {183, 799}, {145, 799}, {108, 799}, {71, 799}}, 
				  {{74, 870}, {116, 870}, {156, 870}, {198, 870}, {235, 870}, {278, 870}, {313, 870}}};
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
//	  System.out.println("\n FloorLine");
//	  for(int i = 0; i < floorLine.size(); i++) {
//		  System.out.print("(" + floorLine.get(i).getX() + ", " + floorLine.get(i).getY() + "), ");
//	  }
//	  System.out.println();
//	  System.out.println();
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
  
  public void setCoordsWall(int curr) {
	  int[][] coords = {{275, 199}, {1522, 199},
	  			{1522, 650}, {275, 650}};
	  for(int i = 0; i < wall.length; i++) {
		  for(int j = 0; j < wall[i].length; j++) {
			  if(wall[i][j] != null)
				  wall[i][j].changeCoords((int)(coords[curr][0]+(j*38)), (int)(coords[curr][1]+(i*37.75)));
		  }
	  }
  }
  
}

