import java.awt.*;
import java.awt.image.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.util.*;

public class AzJPanel extends JPanel{
	private BufferedImage closeInstr, endScr, factory, instr, mainScr, 
	noPat, pickPat, pickTile, tileBlu, tileblk, tileBrw, tileOne, tileRed, 
	tileSc, tilewytl;
	
	
	public AzJPanel(){
		try {
			closeInstr = ImageIO.read(AzJPanel.class.getResource("/Az_CloseInstructionsBtn.png"));
		}catch(Exception E) {
			System.out.println("Exception Error");
			return;
		}
	}
	
	public void paint(Graphics g){
		g.fillRect(0, 0, getWidth(),  getHeight());
		//g.drawImage(closeInstr, 10,10,100,500,null);
	}
}