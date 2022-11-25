public class Tile
{
  private String color;
  private int x;
  private int y;
  //colors: blue, black, red, white, brown :)
  
  public Tile(String col)
  {
	  color = col;
  }
  
  public int getX() {
	  return x;
  }
  
  public int getY() {
	  return y;
  }
  
  public void changeCoords(int newX, int newY) {
	  x = newX;
	  y = newY;
  }
  
  public String toString() {
	  return color;
  }
}
