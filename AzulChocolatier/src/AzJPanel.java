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
	private BufferedImage closeInstr, endScr, factory, instr, mainScr, noPat, pickPat, pickTile, tileBlu, tileBlk, tileBrw, tileOne, tileRed, tileSc, tileWyt, startScr;
	private int choice;
	private boolean start, end;
	
	public AzJPanel(){
		start = true;
		end = false;
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
			if(x >= 724.0*(getWidth()/1775.0) && x <= 1117.0*(getWidth()/1775.0)
					&& y >= 594.0*(getHeight()/972.0) && y <= 684.0*(getHeight()/972.0)) {
				System.out.println("yes1");
				start = false;
			}
			/*(if(x >= 732 && x <= 1111 && y >= 598 && y <= 680) {
				System.out.println(getWidth());
				System.out.println(getWidth()/1775);
				System.out.println(getHeight());
				start = false;
			}*/
		}
	}
	
	public void addNotify() {
		super.addNotify();
		requestFocus();
	}
	
	public void paint(Graphics g){
		g.fillRect(0,0,getWidth(), getHeight());
		if(start) {
			g.drawImage(startScr, 0, 0, getWidth(), getHeight(), null);
		}else if(end) {
			drawEndScr(g);
		}else {
			g.drawImage(mainScr, 0, 0, getWidth(), getHeight(), null);
		}
		
	}
	
	public void drawEndScr(Graphics g) {
		g.drawImage(endScr, 0, 0, getWidth(), getHeight(), null);
	}
	
}
