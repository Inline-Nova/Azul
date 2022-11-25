import java.awt.*;
import java.awt.image.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.*;
import java.awt.event.MouseListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.util.*;

public class AzJPanel extends JPanel implements KeyListener, MouseListener{
	private BufferedImage closeInstr, endScr, factory, instr, mainScr, 
	noPat, pickPat, pickTile, tileBlu, tileBlk, tileBrw, tileOne, 
	tileRed, tileSc, tileWyt, startScr, ref, ref1, ref2, choco;
	private boolean start, end, instructions, pickFact, pickPattern;
	private int choice;
	private AzMain game;
	
	public AzJPanel(){
		game = new AzMain();
		start = true;
		end = false;
		instructions = false;
		pickFact = false;
		try {
			closeInstr = ImageIO.read(AzJPanel.class.getResource("/AzulPics/Az_CloseInstructionsBtn.png"));
			endScr = ImageIO.read(AzJPanel.class.getResource("/AzulPics/Az_EndScreen.png"));
			factory = ImageIO.read(AzJPanel.class.getResource("/AzulPics/Az_Factory.png"));
			instr = ImageIO.read(AzJPanel.class.getResource("/AzulPics/Az_Instructions.png"));
			mainScr = ImageIO.read(AzJPanel.class.getResource("/AzulPics/Az_MainScreen.png"));
			noPat = ImageIO.read(AzJPanel.class.getResource("/AzulPics/Az_NoPattern.png"));
			pickPat = ImageIO.read(AzJPanel.class.getResource("/AzulPics/Az_PickPattern.png"));
			pickTile = ImageIO.read(AzJPanel.class.getResource("/AzulPics/Az_PickTile.png"));
			tileBlu =ImageIO.read(AzJPanel.class.getResource("/AzulPics/Az_TileBlue.png"));
			tileBlk = ImageIO.read(AzJPanel.class.getResource("/AzulPics/Az_TileBlack.png"));
			tileBrw = ImageIO.read(AzJPanel.class.getResource("/AzulPics/Az_TileBrown.png"));
			tileOne = ImageIO.read(AzJPanel.class.getResource("/AzulPics/Az_TileOne.png"));
			tileRed = ImageIO.read(AzJPanel.class.getResource("/AzulPics/Az_TileRed.png"));
			tileSc = ImageIO.read(AzJPanel.class.getResource("/AzulPics/Az_TileScore.png"));
			tileWyt = ImageIO.read(AzJPanel.class.getResource("/AzulPics/Az_TileWhite.png"));
			startScr = ImageIO.read(AzJPanel.class.getResource("/AzulPics/Az_StartScreen.png"));
			ref = ImageIO.read(AzJPanel.class.getResource("/AzulPics/Az_Ref.png"));
			ref1 = ImageIO.read(AzJPanel.class.getResource("/AzulPics/Az_Ref1.png"));
			ref2 = ImageIO.read(AzJPanel.class.getResource("/AzulPics/Az_Ref2.png"));
			choco = ImageIO.read(AzJPanel.class.getResource("/AzulPics/Az_CurrChoco.png"));
			
		}catch(Exception E) {
			System.out.println("Exception Error");
			return;
		}
		
		addKeyListener(this);
		addMouseListener(this);
	}
	
	public void keyPressed(KeyEvent e) {}
	public void keyReleased(KeyEvent e) {}
	public void keyTyped(KeyEvent e) {
		choice = e. getKeyChar()-'0';
		System.out.println(choice);
		repaint();
	}
	
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mouseClicked(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		
		System.out.println("loc is("+x+", "+y+")");
		repaint();
		if(e.getButton() == e.BUTTON1) {
			// for starting the game
			if(start && x >= 724.0*(getWidth()/1775.0) && x <= 1117.0*(getWidth()/1775.0)
					&& y >= 594.0*(getHeight()/972.0) && y <= 684.0*(getHeight()/972.0)) {
				System.out.println("What");
				start = false;
			}
			if(!start && !pickFact && !pickPattern) {
				if(x>835*(getWidth()/1775.0) && x<985*(getWidth()/1775.0) && y>117*(getHeight()/972.0) && y<267*(getHeight()/972.0)) {
					System.out.println("1");
					pickFact = true;
					//chooseFac(1);
				}else if(x>1037*(getWidth()/1775.0) && x<1187*(getWidth()/1775.0) && y>193*(getHeight()/972.0) && y<343*(getHeight()/972.0)) {
					System.out.println("2");
					pickFact = true;
					//chooseFac(2);
				}else if(x>1099*(getWidth()/1775.0) && x<1249*(getWidth()/1775.0) && y>375*(getHeight()/972.0) && y<525*(getHeight()/972.0)) {
					System.out.println("3");
					pickFact = true;
					//chooseFac(3);
				}else if(x>1075*(getWidth()/1775.0) && x<1225*(getWidth()/1775.0) && y>562*(getHeight()/972.0) && y<712*(getHeight()/972.0)) {
					System.out.println("4");
					pickFact = true;
					//chooseFac(4);
				}else if(x>907*(getWidth()/1775.0) && x<1057*(getWidth()/1775.0) && y>670*(getHeight()/972.0) && y<820*(getHeight()/972.0)) {
					System.out.println("5");
					pickFact = true;
					//chooseFac(5);
				}else if(x>711*(getWidth()/1775.0) && x<861*(getWidth()/1775.0) && y>672*(getHeight()/972.0) && y<822*(getHeight()/972.0)) {
					System.out.println("6");
					pickFact = true;
					//chooseFac(6);
				}else if(x>563*(getWidth()/1775.0) && x<713*(getWidth()/1775.0) && y>531*(getHeight()/972.0) && y<681*(getHeight()/972.0)) {
					System.out.println("7");
					pickFact = true;
					//chooseFac(7);
				}else if(x>540*(getWidth()/1775.0) && x<690*(getWidth()/1775.0) && y>340*(getHeight()/972.0) && y<490*(getHeight()/972.0)) {
					System.out.println("8");
					pickFact = true;
					//chooseFac(8);
				}else if(x>633*(getWidth()/1775.0) && x<783*(getWidth()/1775.0) && y>173*(getHeight()/972.0) && y<323*(getHeight()/972.0)) {
					System.out.println("9");
					pickFact = true;
					//chooseFac(9);
				}
				//add mouse lister stuff for all factories
				//once fact is choosen 
			}
			
			//for instructions
			if(x >= 715*(getWidth()/1775.0) && x <= 1089*(getWidth()/1775.0) && y <= 907*(getHeight()/972.0) && y >= 860*(getHeight()/972.0))
				instructions = !instructions;
		}
		
		//if(x >= 715 && x <= 1089 && y <= 907 && y >= 860)
			//instructions = !instructions;
	}
	
	public void addNotify() {
		super.addNotify();
		requestFocus();
	}
	//hi
	public void paint(Graphics g){
		g.fillRect(0,0,getWidth(), getHeight());
		
		if(start) { 
			g.drawImage(startScr, 0, 0, getWidth(), getHeight(), null);
		}else if(end) {
			drawEndScr(g);
		}else { // all main stuff
			g.drawImage(mainScr, 0, 0, getWidth(), getHeight(), null);
			drawFactories(g);
			drawTiles(g);
			drawPlayerBoards(g);
			if(pickFact && !pickPattern) {
				drawPickFact(g);
			}
		}
		
		if(instructions && !start && !end) {
			g.drawImage(instr, (int)(567.0*(getWidth()/1775.0)), (int)(88*(getHeight()/972.0)), (int)(650*(getWidth()/1775.0)), (int)(750*(getHeight()/972.0)), null);
			g.drawImage(closeInstr, (int)(705*(getWidth()/1775.0)), (int)(856*(getHeight()/972.0)), (int)(393*(getWidth()/1775.0)), (int)(65*(getHeight()/972.0)), null);
		}
		//g.drawImage(ref2, 0, 0, getWidth(), getHeight(), null);
		
	}
	
	public void drawTiles(Graphics g) {
		//System.out.println("hi");
		ArrayList<ArrayList<Tile>> tempFact = game.getFactories().getFactories();
		//System.out.println(tempFact.toString());
		for(int i = 0; i < 9; i++) {
			ArrayList<Tile> sect = tempFact.get(i);
			for(Tile ti: sect) {
				if(ti.toString().equals("black")){
					g.drawImage(tileBlk, (int)(ti.getX()*(getWidth()/1775.0)), (int)(ti.getY()*(getHeight()/972.0)), (int)(35*(getWidth()/1775.0)), (int)(35*(getHeight()/972.0)), null);
				}else if(ti.toString().equals("blue")) {
					g.drawImage(tileBlu, (int)(ti.getX()*(getWidth()/1775.0)), (int)(ti.getY()*(getHeight()/972.0)), (int)(35*(getWidth()/1775.0)), (int)(35*(getHeight()/972.0)), null);
				}else if(ti.toString().equals("brown")) {
					g.drawImage(tileBrw, (int)(ti.getX()*(getWidth()/1775.0)), (int)(ti.getY()*(getHeight()/972.0)), (int)(35*(getWidth()/1775.0)), (int)(35*(getHeight()/972.0)), null);
				}else if(ti.toString().equals("red")) {
					g.drawImage(tileRed, (int)(ti.getX()*(getWidth()/1775.0)), (int)(ti.getY()*(getHeight()/972.0)), (int)(35*(getWidth()/1775.0)), (int)(35*(getHeight()/972.0)), null);
				}else if(ti.toString().equals("white")) {
					g.drawImage(tileWyt, (int)(ti.getX()*(getWidth()/1775.0)), (int)(ti.getY()*(getHeight()/972.0)), (int)(35*(getWidth()/1775.0)), (int)(35*(getHeight()/972.0)), null);
				}
			}
		}
		//g.drawImage(tileBlu, tempFact.get(0).get(0).getX(), tempFact.get(0).get(0).getY(), 30, 30, null);
		//g.drawImage(tileBlu, tempFact.get(0).get(1).getX(), tempFact.get(0).get(1).getY(), 30, 30, null);
		//g.drawImage(tileBlu, tempFact.get(0).get(2).getX(), tempFact.get(0).get(2).getY(), 30, 30, null);
		//g.drawImage(tileBlu, tempFact.get(0).get(3).getX(), tempFact.get(0).get(3).getY(), 30, 30, null);
	}
	
	public void drawEndScr(Graphics g) {
		g.drawImage(endScr, 0, 0, getWidth(), getHeight(), null);
	}
	
	public void drawFactories(Graphics g)
	{
		g.drawImage(factory, (int)(835*(getWidth()/1775.0)), (int)(117*(getHeight()/972.0)), (int)(150*(getWidth()/1775.0)), (int)(150*(getHeight()/972.0)), null);
		g.drawImage(factory, (int)(1037*(getWidth()/1775.0)), (int)(193*(getHeight()/972.0)), (int)(150*(getWidth()/1775.0)), (int)(150*(getHeight()/972.0)), null);
		g.drawImage(factory, (int)(1099*(getWidth()/1775.0)), (int)(375*(getHeight()/972.0)), (int)(150*(getWidth()/1775.0)), (int)(150*(getHeight()/972.0)), null);
		g.drawImage(factory, (int)(1075*(getWidth()/1775.0)), (int)(562*(getHeight()/972.0)), (int)(150*(getWidth()/1775.0)), (int)(150*(getHeight()/972.0)), null);
		g.drawImage(factory, (int)(907*(getWidth()/1775.0)), (int)(670*(getHeight()/972.0)), (int)(150*(getWidth()/1775.0)), (int)(150*(getHeight()/972.0)), null);
		g.drawImage(factory, (int)(711*(getWidth()/1775.0)), (int)(672*(getHeight()/972.0)), (int)(150*(getWidth()/1775.0)), (int)(150*(getHeight()/972.0)), null);
		g.drawImage(factory, (int)(563*(getWidth()/1775.0)), (int)(531*(getHeight()/972.0)), (int)(150*(getWidth()/1775.0)), (int)(150*(getHeight()/972.0)), null);
		g.drawImage(factory, (int)(540*(getWidth()/1775.0)), (int)(340*(getHeight()/972.0)), (int)(150*(getWidth()/1775.0)), (int)(150*(getHeight()/972.0)), null);
		g.drawImage(factory, (int)(633*(getWidth()/1775.0)), (int)(173*(getHeight()/972.0)), (int)(150*(getWidth()/1775.0)), (int)(150*(getHeight()/972.0)), null);
	}
	
	public void drawPlayerBoards(Graphics g) {
		if(game.getCurr() == 0) {
			g.drawImage(choco, (int)(491*(getWidth()/1775.0)), (int)(96*(getHeight()/972.0)), (int)(50*(getWidth()/1775.0)), (int)(50*(getHeight()/972.0)), null);
		}else if(game.getCurr() == 1){
			g.drawImage(choco, (int)(1237*(getWidth()/1775.0)), (int)(96*(getHeight()/972.0)), (int)(50*(getWidth()/1775.0)), (int)(50*(getHeight()/972.0)), null);
		}else if(game.getCurr() == 2){
			g.drawImage(choco, (int)(491*(getWidth()/1775.0)), (int)(828*(getHeight()/972.0)), (int)(50*(getWidth()/1775.0)), (int)(50*(getHeight()/972.0)), null);
		}else if(game.getCurr() == 3){
			g.drawImage(choco, (int)(1237*(getWidth()/1775.0)), (int)(828*(getHeight()/972.0)), (int)(50*(getWidth()/1775.0)), (int)(50*(getHeight()/972.0)), null);
		}
	}
	
	public void drawPickFact(Graphics g) {
		g.drawImage(pickTile, (int)(442*(getWidth()/1775.0)), (int)(202*(getHeight()/972.0)), (int)(380*(getWidth()/1775.0)), (int)(596*(getHeight()/972.0)), null);
	}
}
