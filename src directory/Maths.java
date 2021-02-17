/*
This file should do the math for finding random empty spaces after you move your turn, as well as finding random digits and placing them in those random spaces.
might want to have a timer to prevent the user from spamming the hell out of this file

*/
import java.util.Random;

public class Maths {
	int[][][] array = new int[3][3][3];
	Random ran = new Random();
	
	
	public void update() {
		int lX1 = ran.nextInt(2);
		int lX2 = ran.nextInt(2);
		int lX3 = ran.nextInt(2);
		
		if(array[lX1][lX2][lX3] != 0) {
			array[lX1][lX2][lX3] = 1 + ran.nextInt(1);
		} else {
			update();
			System.out.println("Failed a random, retrying");
		}
	}
	public int[][][] direction(int direction) { //# as directions: +/- 1 = y, +/- 2 = x, +/- 3 = z 
		switch(direction) {
		case 1:
			for(int i = 0; i < 4; i++) {
				for(int j = 0; j < 4; j++) {
					for(int k = 0;k< 4;k++) {
						for(int l = 0; l < 4; l++) {
							if(array[i][j + 1][k] != 0 && j != 3) { //if positive, top down. if negative, bot up 
								array[i][j][k] = array[i][j + 1][k];
							}
						}
					}
				}
			}
			break;
		//case 2:
		}
		
		return array;
	}
		
	

}
	
	

