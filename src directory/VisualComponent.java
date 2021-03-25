import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.JComponent;
import java.awt.geom.Line2D;
import java.awt.Color;
import java.awt.Font;
import java.lang.Math;
//import java.awt.Rectangle;



@SuppressWarnings("serial")
public class VisualComponent extends JComponent {

	Maths myboy = new Maths();
	public boolean startScreen = false;
	int blue = 0;
	int green = 0;
	
	public void paintComponent(Graphics g) {
	
		Graphics2D g2 = (Graphics2D) g;
		
		if(!startScreen) {
			g2.setFont(new Font("Arial", Font.PLAIN, 25));
			g2.drawString("Press Enter to Start!", 130, 85);
			g2.setFont(new Font("Arial", Font.PLAIN, 14));
			g2.drawString("W and S go up and down", 140, 100);
			g2.drawString("A and D go left and right", 140, 115);
			g2.drawString("Q and E go between slides", 140, 130);
		} else if(myboy.gameOver) {
			g2.drawString("ded", 125, 80);
			g2.drawString("R to restart", 125, 95);
		} else {
			for(int j = 0; j < 4; j++) {
				for(int i = 1; i < 6; i++) {
					Line2D.Double line1 = new Line2D.Double((20 * i) + 120 * j, 25, (20 * i) + 120 * j, 125); //vert
					g2.draw(line1);
					Line2D.Double line2 = new Line2D.Double(20 + 120 * j, 25 * i, 100 + 120 * j, 25*i); //hor
					g2.draw(line2);
				}
			}
			g2.setFont(new Font("Arial", Font.PLAIN, 8));
			for(int i = 0; i < 4; i++) {
				for(int j = 0; j< 4;j++) {
					for(int k = 0; k < 4; k++) {
						String number = Integer.toString(myboy.array[i][j][k]);
						int textwidth = g.getFontMetrics().stringWidth(number);
						int width = (k * 120) + (20 * i) + 29; // adjust for center of the text
						//1/x equation?
						int x = (int) (Math.log(myboy.array[i][j][k]) / Math.log(2)) + 1;	
						if(x >= 12 && x < 18) {
							green = (300/(x - 20)) + 255;
							//System.out.println(green + " and x" + x);
						} else {
							green = 255;
						}
						if(x > 0) {
							blue = (-300/(x + 1)) + 255;
							
						} else {
							blue = 0;
						}
						//System.out.println(x + " and " + blue);
						Color reddish = new Color(green,  blue, 0); //RGB
						
						g2.setColor(reddish);
						Rectangle bastard = new Rectangle(width - 8, 26 + (25 * j),18, 23);
						g2.fill(bastard);
						g2.draw(bastard);						
						
						g2.setColor(Color.WHITE);
						g2.drawString(number, width - textwidth/2 + 1, 47 + (25 * j));
						
					}
				}
			}
		}
		
		
	}
	public int[][][] returnarray() {
		
		int[][][] peepee = myboy.array;
		return peepee;
	}
	public int[][][] direction(int dir) {
		int[][][] postmove = myboy.direction(dir);
		myboy.update(0,0,0);
		repaint();
		return postmove;
	}
	public void reset() {
		startScreen = false;
		myboy.gameOver = false;
		myboy = new Maths(); // it's possible that too many restarts will create a huge amount of Maths objects that don't get removed, no idea what to do there
		repaint();
	}

	
}
