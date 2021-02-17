/*
This will (hopefully) display the game correctly. It should look like this

|  |  |      |  |  |     |  |  |
|  |  |      |  |  |     |  |  |
|  |  |      |  |  |     |  |  |

*/
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.Color;
import java.awt.geom.Line2D;

public class VisualComponent extends JComponent {

	Maths myboy = new Maths();
	public void paintComponent(Graphics g) {
		
		
		
		Graphics2D g2 = (Graphics2D) g;
		
		for(int j = 0; j < 3; j++) {
			for(int i = 1; i < 5; i++) {
				Line2D.Double line1 = new Line2D.Double((35 * i - 5) + 155 * j, 25, (35 * i - 5) + 155 * j, 130); //vertical lines that create the boxes
				g2.draw(line1);
				Line2D.Double line2 = new Line2D.Double(30 + 155 * j, 35 * i - 10, 135 + 155 * j, 35*i  - 10); //horizontal boxes lines
				g2.draw(line2);
			}
		}
		
		
		
			
		
	
	}
	public int[][][] returnarray() {
		
		int[][][] peepee = myboy.array; //just testing an array system
		return peepee;
	}
}
