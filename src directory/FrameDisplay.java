import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.KeyStroke;
import javax.swing.*;

@SuppressWarnings("serial")
public class FrameDisplay extends JFrame{
	VisualComponent component = new VisualComponent();
	public FrameDisplay() {
		
		
			
		
		/*
		 *This was a test for a console version of this program 
		 
		for(int i = 0; i < displarray.length; i++) {
			for(int j = 0; j < displarray.length; j++) {
				for(int k = s0; k < displarray.length; k++) {
					System.out.print(displarray[i][j][k]);
					JLabel arraysec = new JLabel("" + displarray[i][j][k]);
					add(arraysec);
				}
				System.out.print("  ");
			}
			System.out.println("");
		}
		*/
		
		
		add(component);
		component.addKeyListener(new MyKeyListener());
		component.setFocusable(true);
		component.requestFocus();
		setSize(500,200);
		setTitle("3D 2048"); //this suscks
	}
	class MyKeyListener implements KeyListener
	{ 
	   public void keyPressed(KeyEvent event)
	   { 
	      String key = KeyStroke.getKeyStrokeForEvent(event).toString().replace("pressed ", ""); 
	      switch(key) {
	      	case "W":
	      		component.direction(1);
	      		break;
	      	case "S":
	      		component.direction(-1);
	      		break;
			case "A":
				component.direction(2);
				break;
			case "D":
				component.direction(-2);
				break;
			case "Q":
				component.direction(3);
				break;
			case "E":
				component.direction(-3);
				break;
			case "ENTER":
				component.startScreen = true;
				repaint();
				break;
	   		case "R":
	   			component.reset();
	   			repaint();
			break;
	      }
	   }
	   
	   // Do-nothing methods
	   public void keyReleased(KeyEvent event) {}
	   public void keyTyped(KeyEvent event) {}
	}
	
}
