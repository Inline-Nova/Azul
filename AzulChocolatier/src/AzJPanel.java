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
		if(!start && pickFact && !pickPattern) {
			//System.out.println("hi");
			ArrayList<Integer> tiles = game.chooseFac(game.getSect());
			if(choice == 1 && tiles.get(0) > 0) {
				//System.out.println(1 + "!");
				game.changeChoices(0, 1, 0);
				pickPattern = true;
			}else if(choice == 2 && tiles.get(1) > 0) {
				//System.out.println(2 + "!");
				game.changeChoices(0, 2, 0);
				pickPattern = true;
			}else if(choice == 3 && tiles.get(2) > 0) {
				//System.out.println(3 + "!");
				game.changeChoices(0, 3, 0);
				pickPattern = true;
			}else if(choice == 4 && tiles.get(3) > 0) {
				//System.out.println(4 + "!");
				game.changeChoices(0, 4, 0);
				pickPattern = true;
			}else if(choice == 5 && tiles.get(4) > 0) {
				//System.out.println(5 + "!");
				game.changeChoices(0, 5, 0);
				pickPattern = true;
			}
		}
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
				//System.out.println("What");
				start = false;
			}
			if(!start && !pickFact && !pickPattern) {
				if(x>835*(getWidth()/1775.0) && x<985*(getWidth()/1775.0) && y>117*(getHeight()/972.0) && y<267*(getHeight()/972.0)) {
					//System.out.println("1");
					pickFact = true;
					game.changeChoices(1, 0, 0);
				}else if(x>1037*(getWidth()/1775.0) && x<1187*(getWidth()/1775.0) && y>193*(getHeight()/972.0) && y<343*(getHeight()/972.0)) {
					//System.out.println("2");
					pickFact = true;
					game.changeChoices(2, 0, 0);
				}else if(x>1099*(getWidth()/1775.0) && x<1249*(getWidth()/1775.0) && y>375*(getHeight()/972.0) && y<525*(getHeight()/972.0)) {
					//System.out.println("3");
					pickFact = true;
					game.changeChoices(3, 0, 0);
				}else if(x>1075*(getWidth()/1775.0) && x<1225*(getWidth()/1775.0) && y>562*(getHeight()/972.0) && y<712*(getHeight()/972.0)) {
					//System.out.println("4");
					pickFact = true;
					game.changeChoices(4, 0, 0);
				}else if(x>907*(getWidth()/1775.0) && x<1057*(getWidth()/1775.0) && y>670*(getHeight()/972.0) && y<820*(getHeight()/972.0)) {
					//System.out.println("5");
					pickFact = true;
					game.changeChoices(5, 0, 0);
				}else if(x>711*(getWidth()/1775.0) && x<861*(getWidth()/1775.0) && y>672*(getHeight()/972.0) && y<822*(getHeight()/972.0)) {
					//System.out.println("6");
					pickFact = true;
					game.changeChoices(6, 0, 0);
				}else if(x>563*(getWidth()/1775.0) && x<713*(getWidth()/1775.0) && y>531*(getHeight()/972.0) && y<681*(getHeight()/972.0)) {
					//System.out.println("7");
					pickFact = true;
					game.changeChoices(7, 0, 0);
				}else if(x>540*(getWidth()/1775.0) && x<690*(getWidth()/1775.0) && y>340*(getHeight()/972.0) && y<490*(getHeight()/972.0)) {
					//System.out.println("8");
					pickFact = true;
					game.changeChoices(8, 0, 0);
				}else if(x>633*(getWidth()/1775.0) && x<783*(getWidth()/1775.0) && y>173*(getHeight()/972.0) && y<323*(getHeight()/972.0)) {
					//System.out.println("9");
					pickFact = true;
					game.changeChoices(9, 0, 0);
				}
				//add mouse lister stuff for all factories
				//once fact is choosen 
			}
			
			if(!start && pickFact && pickPattern) {
					if(x >= 862*(getWidth()/1775.0) && x <= 1294*(getWidth()/1775.0) && y >= 290*(getHeight()/972.0) && y <= 361*(getHeight()/972.0)) {
						//System.out.println(1);
						pickFact = false;
						pickPattern = false;
						game.changeChoices(0,0,1);
						game.useChoices();
					}else if(x >= 862*(getWidth()/1775.0) && x <= 1294*(getWidth()/1775.0) && y >= 373*(getHeight()/972.0) && y <= 442*(getHeight()/972.0)) {
						//System.out.println(2);
						pickFact = false;
						pickPattern = false;
						game.changeChoices(0,0,2);
						game.useChoices();
					}else if(x >= 862*(getWidth()/1775.0) && x <= 1294*(getWidth()/1775.0) && y >= 453*(getHeight()/972.0) && y <= 521*(getHeight()/972.0)) {
						//System.out.println(3);
						pickFact = false;
						pickPattern = false;
						game.changeChoices(0,0,3);
						game.useChoices();
					}else if(x >= 862*(getWidth()/1775.0) && x <= 1294*(getWidth()/1775.0) && y >= 536*(getHeight()/972.0) && y <= 605*(getHeight()/972.0)) {
						//System.out.println(4);
						pickFact = false;
						pickPattern = false;
						game.changeChoices(0,0,4);
						game.useChoices();
					}else if(x >= 862*(getWidth()/1775.0) && x <= 1294*(getWidth()/1775.0) && y >= 617 && y <= 690) {
						//System.out.println(5);
						pickFact = false;
						pickPattern = false;
						game.changeChoices(0,0,5);
						game.useChoices();
					}else if(x >= 862*(getWidth()/1775.0) && x <= 1294*(getWidth()/1775.0) && y >= 709 && y <= 770) {
						//System.out.println(6);
						pickFact = false;
						pickPattern = false;
						game.changeChoices(0,0,6);
						game.useChoices();
					}
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
			if((pickFact)) {
				drawPickFact(g);
				if(pickPattern) {
					drawPickRow(g);
				}
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
		g.setFont(new Font("SansSerif", Font.ITALIC, (int)(45*(getWidth()/1775.0)*(getHeight()/972.0))));
		g.setColor(new Color(10, 70, 80));
		g.drawImage(pickTile, (int)(442*(getWidth()/1775.0)), (int)(202*(getHeight()/972.0)), (int)(370*(getWidth()/1775.0)), (int)(596*(getHeight()/972.0)), null);
		ArrayList<Integer> tiles = game.chooseFac(game.getSect());
		for(int i = 0; i < 5; i++) {
			if(tiles.get(i) > 0) {
				if(i == 0) {
					g.drawImage(tileBlk, (int)(493*(getWidth()/1775.0)), (int)(303*(getHeight()/972.0)), (int)(55*(getWidth()/1775.0)), (int)(55*(getHeight()/972.0)), null);
					g.drawString("x"+tiles.get(0), (int)(565*(getWidth()/1775.0)), (int)(343*(getHeight()/972.0)));
				}else if(i == 1) {
					g.drawImage(tileBlu, (int)(493*(getWidth()/1775.0)), (int)(404*(getHeight()/972.0)), (int)(55*(getWidth()/1775.0)), (int)(55*(getHeight()/972.0)), null);
					g.drawString("x"+tiles.get(1), (int)(565*(getWidth()/1775.0)), (int)(444*(getHeight()/972.0)));
				}else if(i == 2) {
					g.drawImage(tileBrw, (int)(493*(getWidth()/1775.0)), (int)(502*(getHeight()/972.0)), (int)(55*(getWidth()/1775.0)), (int)(55*(getHeight()/972.0)), null);
					g.drawString("x"+tiles.get(2), (int)(565*(getWidth()/1775.0)), (int)(542*(getHeight()/972.0)));
				}else if(i == 3) {
					g.drawImage(tileRed, (int)(493*(getWidth()/1775.0)), (int)(600*(getHeight()/972.0)), (int)(55*(getWidth()/1775.0)), (int)(55*(getHeight()/972.0)), null);
					g.drawString("x"+tiles.get(3), (int)(565*(getWidth()/1775.0)), (int)(640*(getHeight()/972.0)));
				}else if(i == 4) {
					g.drawImage(tileWyt, (int)(493*(getWidth()/1775.0)), (int)(700*(getHeight()/972.0)), (int)(55*(getWidth()/1775.0)), (int)(55*(getHeight()/972.0)), null);
					g.drawString("x"+tiles.get(4), (int)(565*(getWidth()/1775.0)), (int)(740*(getHeight()/972.0)));
				}
			}
		}
	}
	
	public void drawPickRow(Graphics g) {
		g.drawImage(pickPat, (int)(830*(getWidth()/1775.0)), (int)(202*(getHeight()/972.0)), (int)(500*(getWidth()/1775.0)), (int)(596*(getHeight()/972.0)), null);
		//puts shadow over pickFact that wasn't choosen
		int tempChose = game.getTile();
		//System.out.println("tempChose: " + tempChose);
		if(tempChose != 0) g.drawImage(noPat, (int)(472*(getWidth()/1775.0)), (int)(285*(getHeight()/972.0)), (int)(310*(getWidth()/1775.0)), (int)(90*(getHeight()/972.0)), null);
		if(tempChose != 1) g.drawImage(noPat, (int)(472*(getWidth()/1775.0)), (int)(385*(getHeight()/972.0)), (int)(310*(getWidth()/1775.0)), (int)(90*(getHeight()/972.0)), null);
		if(tempChose != 2) g.drawImage(noPat, (int)(472*(getWidth()/1775.0)), (int)(485*(getHeight()/972.0)), (int)(310*(getWidth()/1775.0)), (int)(90*(getHeight()/972.0)), null);
		if(tempChose != 3) g.drawImage(noPat, (int)(472*(getWidth()/1775.0)), (int)(584*(getHeight()/972.0)), (int)(310*(getWidth()/1775.0)), (int)(90*(getHeight()/972.0)), null);
		if(tempChose != 4) g.drawImage(noPat, (int)(472*(getWidth()/1775.0)), (int)(682*(getHeight()/972.0)), (int)(310*(getWidth()/1775.0)), (int)(90*(getHeight()/972.0)), null);
		
		//Current tiles of current player
		ArrayList<Tile[]> tempWall = game.getPlayerBoard(game.getCurr()).getPatternLines();
		for(int i = 0; i < tempWall.size(); i++) {
			for(int j = 0; j < tempWall.get(i).length; j++) {
				
			}
		}
	}
	
	public void drawScoring (Graphics g) {
		if(!end && !instructions && !pickFact && !pickPattern) {
		int score = game.getCurr().getScore();
		switch(game.getCurr()) {
		case 1:
		case 2:
		case 3:
		case 4:
		}
		
		if(score > 100) {
			switch(game.getCurr()) {
			case 1: g.drawString("+100", 596, 68);
			case 2: g.drawString("+100", 596, 68);
			case 3: g.drawString("+100", 596, 68);
			case 4: g.drawString("+100", 589, 887);
			}
		}
	}
	}
}
