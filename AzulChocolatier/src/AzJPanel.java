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
		//System.out.println(choice);
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
			}else
				game.getPlayerBoard(game.getCurr()).setCoordsPat(game.getCurr());
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
				if(game.getFactories().getSectTiles(0).size()>0 && x>835*(getWidth()/1775.0) && x<985*(getWidth()/1775.0) && y>117*(getHeight()/972.0) && y<267*(getHeight()/972.0)) {
					//System.out.println("1");
					pickFact = true;
					game.changeChoices(1, 0, 0);
				}else if(game.getFactories().getSectTiles(1).size()>0 && x>1037*(getWidth()/1775.0) && x<1187*(getWidth()/1775.0) && y>193*(getHeight()/972.0) && y<343*(getHeight()/972.0)) {
					//System.out.println("2");
					pickFact = true;
					game.changeChoices(2, 0, 0);
				}else if(game.getFactories().getSectTiles(2).size()>0 && x>1099*(getWidth()/1775.0) && x<1249*(getWidth()/1775.0) && y>375*(getHeight()/972.0) && y<525*(getHeight()/972.0)) {
					//System.out.println("3");
					pickFact = true;
					game.changeChoices(3, 0, 0);
				}else if(game.getFactories().getSectTiles(3).size()>0 && x>1075*(getWidth()/1775.0) && x<1225*(getWidth()/1775.0) && y>562*(getHeight()/972.0) && y<712*(getHeight()/972.0)) {
					//System.out.println("4");
					pickFact = true;
					game.changeChoices(4, 0, 0);
				}else if(game.getFactories().getSectTiles(4).size()>0 && x>907*(getWidth()/1775.0) && x<1057*(getWidth()/1775.0) && y>670*(getHeight()/972.0) && y<820*(getHeight()/972.0)) {
					//System.out.println("5");
					pickFact = true;
					game.changeChoices(5, 0, 0);
				}else if(game.getFactories().getSectTiles(5).size()>0 && x>711*(getWidth()/1775.0) && x<861*(getWidth()/1775.0) && y>672*(getHeight()/972.0) && y<822*(getHeight()/972.0)) {
					//System.out.println("6");
					pickFact = true;
					game.changeChoices(6, 0, 0);
				}else if(game.getFactories().getSectTiles(6).size()>0 && x>563*(getWidth()/1775.0) && x<713*(getWidth()/1775.0) && y>531*(getHeight()/972.0) && y<681*(getHeight()/972.0)) {
					//System.out.println("7");
					pickFact = true;
					game.changeChoices(7, 0, 0);
				}else if(game.getFactories().getSectTiles(7).size()>0 && x>540*(getWidth()/1775.0) && x<690*(getWidth()/1775.0) && y>340*(getHeight()/972.0) && y<490*(getHeight()/972.0)) {
					//System.out.println("8");
					pickFact = true;
					game.changeChoices(8, 0, 0);
				}else if(game.getFactories().getSectTiles(8).size()>0 && x>633*(getWidth()/1775.0) && x<783*(getWidth()/1775.0) && y>173*(getHeight()/972.0) && y<323*(getHeight()/972.0)) {
					//System.out.println("9");
					pickFact = true;
					game.changeChoices(9, 0, 0);
				}else if(game.getFactories().getSectTiles(9).size()>0 && x>744*(getWidth()/1775.0) && x<1060*(getWidth()/1775.0) && y>340*(getHeight()/972.0) && y<560*(getHeight()/972.0)) {
					pickFact = true;
					game.changeChoices(10, 0, 0);
				}else
					repaint();
				//add mouse lister stuff for all factories
				//once fact is choosen 
			}
			
			if(!start && pickFact && pickPattern) {
					if(game.checkRow(0) && x >= 862*(getWidth()/1775.0) && x <= 1294*(getWidth()/1775.0) && y >= 290*(getHeight()/972.0) && y <= 361*(getHeight()/972.0)) {
						//System.out.println(1);
						pickFact = false;
						pickPattern = false;
						game.changeChoices(0,0,1);
						game.useChoices();
					}else if(game.checkRow(1) && x >= 862*(getWidth()/1775.0) && x <= 1294*(getWidth()/1775.0) && y >= 373*(getHeight()/972.0) && y <= 442*(getHeight()/972.0)) {
						//System.out.println(2);
						pickFact = false;
						pickPattern = false;
						game.changeChoices(0,0,2);
						game.useChoices();
					}else if(game.checkRow(2) && x >= 862*(getWidth()/1775.0) && x <= 1294*(getWidth()/1775.0) && y >= 453*(getHeight()/972.0) && y <= 521*(getHeight()/972.0)) {
						//System.out.println(3);
						pickFact = false;
						pickPattern = false;
						game.changeChoices(0,0,3);
						game.useChoices();
					}else if(game.checkRow(3) && x >= 862*(getWidth()/1775.0) && x <= 1294*(getWidth()/1775.0) && y >= 536*(getHeight()/972.0) && y <= 605*(getHeight()/972.0)) {
						//System.out.println(4);
						pickFact = false;
						pickPattern = false;
						game.changeChoices(0,0,4);
						game.useChoices();
					}else if(game.checkRow(4) && x >= 862*(getWidth()/1775.0) && x <= 1294*(getWidth()/1775.0) && y >= 617*(getHeight()/972.0) && y <= 690*(getHeight()/972.0)) {
						//System.out.println(5);
						pickFact = false;
						pickPattern = false;
						game.changeChoices(0,0,5);
						game.useChoices();
					}else if(x >= 862*(getWidth()/1775.0) && x <= 1294*(getWidth()/1775.0) && y >= 709*(getHeight()/972.0) && y <= 770*(getHeight()/972.0)) {
						//System.out.println(6);
						pickFact = false;
						pickPattern = false;
						game.changeChoices(0,0,6);
						game.useChoices();
					}else
						game.getPlayerBoard(game.getCurr()).setCoordsPat(game.getCurr());
				
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
				drawTiles(g);
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
		//g.drawImage(pickPat, (int)(830*(getWidth()/1775.0)), (int)(202*(getHeight()/972.0)), (int)(500*(getWidth()/1775.0)), (int)(596*(getHeight()/972.0)), null);
	}
	
	public void drawTiles(Graphics g) {
		//System.out.println("hi");
		ArrayList<ArrayList<Tile>> tempFact = game.getFactories().getFactories();
		//System.out.println(tempFact.toString());
		for(int i = 0; i < 9; i++) {
			ArrayList<Tile> sect = tempFact.get(i); //in the factories
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
		
		//on the player board
			for(int i = 0; i < 4; i++) {
				ArrayList<Tile[]> tempPat = game.getPlayerBoard(i).getPatternLines();
				for(Tile[] tis: tempPat) {
					for(Tile ti: tis) {
						if(ti!= null) {
							if(ti.toString().equals("black")) {
								g.drawImage(tileBlk, (int)(ti.getX()*(getWidth()/1775.0)), (int)(ti.getY()*(getHeight()/972.0)), (int)(35*(getWidth()/1775.0)), (int)(35*(getHeight()/972.0)),null);
							}else if(ti.toString().equals("blue")) {
								g.drawImage(tileBlu, (int)(ti.getX()*(getWidth()/1775.0)), (int)(ti.getY()*(getHeight()/972.0)), (int)(35*(getWidth()/1775.0)), (int)(35*(getHeight()/972.0)),null);
							}else if(ti.toString().equals("brown")) {
								g.drawImage(tileBrw, (int)(ti.getX()*(getWidth()/1775.0)), (int)(ti.getY()*(getHeight()/972.0)), (int)(35*(getWidth()/1775.0)), (int)(35*(getHeight()/972.0)),null);
							}else if(ti.toString().equals("red")) {
								g.drawImage(tileRed, (int)(ti.getX()*(getWidth()/1775.0)), (int)(ti.getY()*(getHeight()/972.0)), (int)(35*(getWidth()/1775.0)), (int)(35*(getHeight()/972.0)),null);
							}else if(ti.toString().equals("white")) {
								g.drawImage(tileWyt, (int)(ti.getX()*(getWidth()/1775.0)), (int)(ti.getY()*(getHeight()/972.0)), (int)(35*(getWidth()/1775.0)), (int)(35*(getHeight()/972.0)),null);
							}
						}
						
					}
				}
			}
		
		//for floorLine
			for(Tile ti: game.getPlayerBoard(game.getCurr()).getFloorLine()) {
				if(ti!= null) {
					if(ti.toString().equals("black"))
						g.drawImage(tileBlk, (int)(ti.getX()*(getWidth()/1775.0)), (int)(ti.getY()*(getHeight()/972.0)), (int)(27*(getWidth()/1775.0)), (int)(27*(getHeight()/972.0)),null);
					else if(ti.toString().equals("blue"))
						g.drawImage(tileBlu, (int)(ti.getX()*(getWidth()/1775.0)), (int)(ti.getY()*(getHeight()/972.0)), (int)(27*(getWidth()/1775.0)), (int)(27*(getHeight()/972.0)),null);
					else if(ti.toString().equals("brown"))
						g.drawImage(tileBrw, (int)(ti.getX()*(getWidth()/1775.0)), (int)(ti.getY()*(getHeight()/972.0)), (int)(27*(getWidth()/1775.0)), (int)(27*(getHeight()/972.0)),null);
					else if(ti.toString().equals("red"))
						g.drawImage(tileRed, (int)(ti.getX()*(getWidth()/1775.0)), (int)(ti.getY()*(getHeight()/972.0)), (int)(27*(getWidth()/1775.0)), (int)(27*(getHeight()/972.0)),null);
					else if(ti.toString().equals("white"))
						g.drawImage(tileWyt, (int)(ti.getX()*(getWidth()/1775.0)), (int)(ti.getY()*(getHeight()/972.0)), (int)(27*(getWidth()/1775.0)), (int)(27*(getHeight()/972.0)),null);
					else if(ti.toString().equals("one"))
						g.drawImage(tileOne, (int)(ti.getX()*(getWidth()/1775.0)), (int)(ti.getY()*(getHeight()/972.0)), (int)(27*(getWidth()/1775.0)), (int)(27*(getHeight()/972.0)),null);

				}
				
			}
			
		//for midddle
			for(Tile ti: game.getFactories().getSectTiles(9)) {
				if(ti.toString().equals("black"))
					g.drawImage(tileBlk, (int)(ti.getX()*(getWidth()/1775.0)), (int)(ti.getY()*(getHeight()/972.0)), (int)(35*(getWidth()/1775.0)), (int)(35*(getHeight()/972.0)),null);
				else if(ti.toString().equals("blue"))
					g.drawImage(tileBlu, (int)(ti.getX()*(getWidth()/1775.0)), (int)(ti.getY()*(getHeight()/972.0)), (int)(35*(getWidth()/1775.0)), (int)(35*(getHeight()/972.0)),null);
				else if(ti.toString().equals("brown"))
					g.drawImage(tileBrw, (int)(ti.getX()*(getWidth()/1775.0)), (int)(ti.getY()*(getHeight()/972.0)), (int)(35*(getWidth()/1775.0)), (int)(35*(getHeight()/972.0)),null);
				else if(ti.toString().equals("red"))
					g.drawImage(tileRed, (int)(ti.getX()*(getWidth()/1775.0)), (int)(ti.getY()*(getHeight()/972.0)), (int)(35*(getWidth()/1775.0)), (int)(35*(getHeight()/972.0)),null);
				else if(ti.toString().equals("white"))
					g.drawImage(tileWyt, (int)(ti.getX()*(getWidth()/1775.0)), (int)(ti.getY()*(getHeight()/972.0)), (int)(35*(getWidth()/1775.0)), (int)(35*(getHeight()/972.0)),null);
			}
			
			
		
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
		}else if(game.getCurr() == 3){
			g.drawImage(choco, (int)(491*(getWidth()/1775.0)), (int)(828*(getHeight()/972.0)), (int)(50*(getWidth()/1775.0)), (int)(50*(getHeight()/972.0)), null);
		}else if(game.getCurr() == 1){
			g.drawImage(choco, (int)(1237*(getWidth()/1775.0)), (int)(96*(getHeight()/972.0)), (int)(50*(getWidth()/1775.0)), (int)(50*(getHeight()/972.0)), null);
		}else if(game.getCurr() == 2){
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
		playerBoard tempPat = game.getPlayerBoard(game.getCurr());
		tempPat.setCoordsPatPick();
		for(Tile[] tis: tempPat.getPatternLines()) {
			for(Tile ti: tis) {
				if(ti!= null) {
					if(ti.toString().equals("black"))
						g.drawImage(tileBlk, (int)(ti.getX()*(getWidth()/1775.0)), (int)(ti.getY()*(getHeight()/972.0)), (int)(58*(getWidth()/1775.0)), (int)(58*(getHeight()/972.0)),null);
					else if(ti.toString().equals("blue"))
						g.drawImage(tileBlu, (int)(ti.getX()*(getWidth()/1775.0)), (int)(ti.getY()*(getHeight()/972.0)), (int)(58*(getWidth()/1775.0)), (int)(58*(getHeight()/972.0)),null);
					else if(ti.toString().equals("brown"))
						g.drawImage(tileBrw, (int)(ti.getX()*(getWidth()/1775.0)), (int)(ti.getY()*(getHeight()/972.0)), (int)(58*(getWidth()/1775.0)), (int)(58*(getHeight()/972.0)),null);
					else if(ti.toString().equals("red"))
						g.drawImage(tileRed, (int)(ti.getX()*(getWidth()/1775.0)), (int)(ti.getY()*(getHeight()/972.0)), (int)(58*(getWidth()/1775.0)), (int)(58*(getHeight()/972.0)),null);
					else if(ti.toString().equals("white"))
						g.drawImage(tileWyt, (int)(ti.getX()*(getWidth()/1775.0)), (int)(ti.getY()*(getHeight()/972.0)), (int)(58*(getWidth()/1775.0)), (int)(58*(getHeight()/972.0)),null);
				}
			}
		}
		
		for(Tile ti: tempPat.getFloorLine()) {
			if(ti!= null) {
				if(ti.toString().equals("black"))
					g.drawImage(tileBlk, (int)(ti.getX()*(getWidth()/1775.0)), (int)(ti.getY()*(getHeight()/972.0)), (int)(44*(getWidth()/1775.0)), (int)(44*(getHeight()/972.0)),null);
				else if(ti.toString().equals("blue"))
					g.drawImage(tileBlu, (int)(ti.getX()*(getWidth()/1775.0)), (int)(ti.getY()*(getHeight()/972.0)), (int)(44*(getWidth()/1775.0)), (int)(44*(getHeight()/972.0)),null);
				else if(ti.toString().equals("brown"))
					g.drawImage(tileBrw, (int)(ti.getX()*(getWidth()/1775.0)), (int)(ti.getY()*(getHeight()/972.0)), (int)(44*(getWidth()/1775.0)), (int)(44*(getHeight()/972.0)),null);
				else if(ti.toString().equals("red"))
					g.drawImage(tileRed, (int)(ti.getX()*(getWidth()/1775.0)), (int)(ti.getY()*(getHeight()/972.0)), (int)(44*(getWidth()/1775.0)), (int)(44*(getHeight()/972.0)),null);
				else if(ti.toString().equals("white"))
					g.drawImage(tileWyt, (int)(ti.getX()*(getWidth()/1775.0)), (int)(ti.getY()*(getHeight()/972.0)), (int)(44*(getWidth()/1775.0)), (int)(44*(getHeight()/972.0)),null);
				else if(ti.toString().equals("one"))
					g.drawImage(tileOne, (int)(ti.getX()*(getWidth()/1775.0)), (int)(ti.getY()*(getHeight()/972.0)), (int)(44*(getWidth()/1775.0)), (int)(44*(getHeight()/972.0)),null);

			}
			
		}
		
//		for(Boolean bo: game.checkPats()) {
//			System.out.println(bo + ", ");
//		}
		
		//coords (862, 290) - 373
		for(int i = 0; i < 5; i++) {
			//System.out.println("Check: " + game.checkRow(i));
			if(!game.checkRow(i))
				g.drawImage(noPat, (int)(862*(getWidth()/1775.0)), (int)((289 + (82*i))*(getHeight()/972.0)), (int)(434*(getWidth()/1775.0)), (int)(72*(getHeight()/972.0)), null);
		}
	}
	
	public void drawScoring (Graphics g) {
		//int score = game.getPlayerBoard(game.getCurr()).getScore();
		int score = 21;
		System.out.println("score" + score);
		if(score > 100) {
			switch(game.getCurr()) {
			case 0: g.drawString("+100", 596, 68);
			case 1: g.drawString("+100", 596, 68);
			case 2: g.drawString("+100", 596, 68);
			case 3: g.drawString("+100", 589, 887);
			}
		}
		else
		switch(game.getCurr()) {
		case 0: 
			int x = 80;
			int y = 55;
				for(int i = 0; i < score; i++) {
					if(i%20 == 1) {
						y+=19;
						x-=364;
					}
					x+=10;
				}
			g.drawImage(tileSc, x, y, 20,20, null);
			System.out.println("case0");
		case 1: 
			int a = 70;
			int b = 55;
				for(int i = 0; i < score; i++) {
					if(i%20 == 1) {
						b+=19;
						a-=364;
					}
					a+=10;
				}
			g.drawImage(tileSc, a, b, 50, 50, null);
			System.out.println("case1");
		case 2:
			int c = 70;
			int d = 55;
				for(int i = 0; i < score; i++) { 
					if(i%20 == 1) {
						d+=19;
						c-=364;
					}
					c+=10;
				}
			g.drawImage(tileSc, c, d, 50, 50, null);
			System.out.println("case2");
		case 3:
			int e = 70;
			int f = 55;
				for(int i = 0; i < score; i++) {
					if(i%20 == 1) {
						f+=19;
						e-=364;
					}
					e+=10;
				}
			g.drawImage(tileSc, e, f, 50, 50, null);
			System.out.println("case3");
		}
	}
	}
	
