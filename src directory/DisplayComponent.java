/*
This will (hopefully) display the game correctly. It should look like this

|  |  |      |  |  |     |  |  |
|  |  |      |  |  |     |  |  |
|  |  |      |  |  |     |  |  |

*/
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;
import java.util.Random;

public class DisplayComponent extends JComponent {
  public void drawComponent(Graphics g) {
    Graphics2D g2 = (Graphics2D) g;
    
  }
  public int NumberGenerator() {
    //should generate a random number, either 2 or 4
  }
  public int freeSpace(values[][][]) {
     //this, given any 3D array, should be able to randomly select one of the empty spaces and return the coords, hopefully in an x,y,z format
  }
}

//side note for myself, do more research into JFrame and JPanel
