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
	  int cnt = 0;
	  for (int i = 0; i < patternLines.size(); i++) {
		  cnt++;
		  for (int j = cnt; j < patternLines.get(j).length; j++) {
				  
		  }
	  }
  }
  
  public void setCoordsPat(int curr) {
	  int[][][] coords = {};
	  if(curr == 0) { //30x30 for pat &  24x24
		  int[][][] temp = {{{219,205}}, {{219, 240}, {183, 240}}, 
				  {{219, 277}, {183, 277}, {145, 277}}, {{219, 313}, 
					  {183, 313}, {145, 313}, {108, 313}}, 
				  {{219, 349}, {183, 349}, {145, 349}, {108, 349}, {71, 349}}, 
				  {{74, 420}, {116, 420}, {156, 420}, {198, 420}, {235, 420}, {278, 420}, {341, 420}}};
		  coords = temp;
	  }else if(curr == 1) {
		  int[][][] temp = {{{219,645}}, {{219, 690}, {183, 690}}, 
				  {{219, 725}, {183, 725}, {145, 725}}, 
				  {{219, 762}, {183, 762}, {145, 762}, {108, 762}}, 
				  {{219, 803}, {183, 803}, {145, 803}, {108, 803}, {71, 803}}, 
				  {{74, 874}, {116, 874}, {156, 874}, {198, 874}, {235, 874}, {278, 874}, {341, 874}}};
		  coords = temp;
	  }else if(curr == 2) {
		  int[][][] temp = {{{1467,205}}, {{1467, 240}, {1431, 240}}, 
				  {{1467, 277}, {1431, 277}, {1393, 277}}, 
				  {{1467, 313}, {1431, 313}, {1393, 313}, {1356, 313}}, 
				  {{1467, 349}, {1431, 349}, {1393, 349}, {1356, 349}, {1319, 349}}, 
				  {{1320, 420}, {1363, 420}, {1405, 420}, {1443, 420}, {1481, 420}, {1524, 420}, {1564, 420}}};
		  coords = temp;
	  }else if(curr == 3) {
		  int[][][] temp = {{{1467,645}}, {{1467, 690}, {1431, 690}}, 
				  {{1467, 725}, {1431, 725}, {1393, 725}}, 
				  {{1467, 762}, {1431, 762}, {1393, 762}, {1356, 762}}, 
				  {{1467, 803}, {1431, 803}, {1393, 803}, {1356, 803}, {1319, 803}}, 
				  {{1320, 874}, {1363, 874}, {1405, 874}, {1443, 874}, {1481, 874}, {1524, 874}, {1564, 874}}};
		  coords = temp;
	  }
	  
	  for(int i = 0; i < patternLines.size(); i++) {
		  for(int j = 0; j < patternLines.get(i).length; j++) {
			  patternLines.get(i)[j].changeCoords(coords[i][j][0], coords[i][j][1]);
		  }
	  }
	  for(int i = 0; i < floorLine.size(); i++) {
		  floorLine.get(i).changeCoords(coords[i][5][0], coords[i][5][1]);
	  }
  }
}

