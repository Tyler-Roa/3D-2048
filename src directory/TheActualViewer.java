import javax.swing.JFrame;


public class TheActualViewer {
	
	public static void main(String args[]) {
		JFrame framy = new FrameDisplay();
		framy.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		framy.setVisible(true);
		
	}
	
	/*
	 * This was a test for a console version of this program
	static VisualComponent component = new VisualComponent();
	public static void main(String args[]) {
		boolean play = true;
		Scanner in = new Scanner(System.in);
		draw();
		while(play) {
			String key = in.nextLine();
			switch(key) {
	      	case "w":
	      		component.direction(2);
	      		draw();
	      		System.out.println("going up");
	      		break;
	      	case "s":
	      		component.direction(-2);
	      		draw();
	      		break;
			case "a":
				component.direction(3);
				draw();
				break;
			case "d":
				component.direction(-3);
				draw();
				break;
			case "q":
				component.direction(1);
				draw();
				break;
			case "e":
				component.direction(-1);
				draw();
				break;
			}
		}
	}
	static void draw() {
		int[][][] displarray = component.returnarray();	
		for(int i = 0; i < displarray.length; i++) {
			for(int j = 0; j < displarray.length; j++) {
				for(int k = 0; k < displarray.length; k++) {
					System.out.print(displarray[i][j][k] + "|");					
				}
				System.out.print("  ");
			}
			System.out.println("");
		}
		
	}
	 */
}
