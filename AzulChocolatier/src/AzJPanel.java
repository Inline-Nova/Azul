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
	tileRed, tileSc, tileWyt, startScr, ref, choco;
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
			tileBlu =ImageIO.read(AzJPanel.class.getResource("/AzulPics/Az_TileBlack.png"));
			tileBlk = ImageIO.read(AzJPanel.class.getResource("/AzulPics/Az_TileBlue.png"));
			tileBrw = ImageIO.read(AzJPanel.class.getResource("/AzulPics/Az_TileBrown.png"));
			tileOne = ImageIO.read(AzJPanel.class.getResource("/AzulPics/Az_TileOne.png"));
			tileRed = ImageIO.read(AzJPanel.class.getResource("/AzulPics/Az_TileRed.png"));
			tileSc = ImageIO.read(AzJPanel.class.getResource("/AzulPics/Az_TileScore.png"));
			tileWyt = ImageIO.read(AzJPanel.class.getResource("/AzulPics/Az_TileWhite.png"));
			startScr = ImageIO.read(AzJPanel.class.getResource("/AzulPics/Az_StartScreen.png"));
			ref = ImageIO.read(AzJPanel.class.getResource("/AzulPics/Az_Ref.png"));
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
				System.out.println("yes1");
				start = false;
			}
			if(!pickFact && !pickPattern) {
				if(x>835 && x<985 && y>117 && y<267) {
					System.out.println("1");
					//chooseFac(1);
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
			drawPlayerBoards(g);
		}
		
		if(instructions && !start && !end) {
			g.drawImage(instr, (int)(567.0*(getWidth()/1775.0)), (int)(88*(getHeight()/972.0)), (int)(650*(getWidth()/1775.0)), (int)(750*(getHeight()/972.0)), null);
			g.drawImage(closeInstr, (int)(705*(getWidth()/1775.0)), (int)(856*(getHeight()/972.0)), (int)(393*(getWidth()/1775.0)), (int)(65*(getHeight()/972.0)), null);
		}
		//g.drawImage(ref, 0, 0, getWidth(), getHeight(), null);
		
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
	
	public void drawPickFac(Graphics g) {
		
	}
}
