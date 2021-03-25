
import java.util.Random;

public class Maths {
	int[][][] array = new int[4][4][4];
	boolean gameOver;
	Random ran = new Random();
	int counter = 0;
	int errorcounter = 0;
	
	
	public Maths() {
		int firstx = ran.nextInt(4);
		int firsty = ran.nextInt(4);
		int firstz = ran.nextInt(4);
		array[firstx][firsty][firstz] = 1 + ran.nextInt(1);
	}
	public void update(int lx1n, int lx2n, int lx3n) {
		int lX1 = ran.nextInt(4);
		int lX2 = ran.nextInt(4);
		int lX3 = ran.nextInt(3);
		
		if(lx1n > 0) {
			while(lX1 == lx1n) {
				lX1 = ran.nextInt(4);
			}
		}
		if(lx2n > 0) {
			while(lX2 == lx2n) {
				lX2 = ran.nextInt(4);
			}
		}
		if(lx3n > 0) {
			while(lX3 == lx3n) {
				lX3 = ran.nextInt(4);
			}
		}
		
		if(array[lX1][lX2][lX3] == 0) {
			array[lX1][lX2][lX3] = 1 + ran.nextInt(1);
			//array[lX1][lX2][lX3] = 1024; <- testing
		} else {
			try { //This is here because the odds of these random functions hitting a non-zero spot get increasingly more difficult. This helps
				counter++;
				//System.out.println("Failed a random, retrying. Tries:" + counter); good for testing
				update(lX1,lX2,lX3);
			} catch (StackOverflowError exception) {
				errorcounter++;
				//System.out.println("Woah. You got, like, super unlucky. The Random tester failed like 5000 times in a row.");
				//System.out.println("This has happened " + errorcounter + " times"); Testing Statements!!!
				int bad = 0;
				for(int[][] element :  array) {
					for(int[] element2 : element) {
						for(int elemento : element2) {
							if(elemento != 0) {
								bad++; //HUGE PROBLEM! if there are still possible moves left, this WILL cause a game over!!!	
							}
						}
					}
				}
				if(bad == 64) {
					gameOver = true;
				}
				
			}
			
			
		}
	}
	//Note: this is a garbage system that goes through the switch repeatedly. I could probably fix this if I was skilled
	//if positive, top down. if negative, bot up. 0,0,0 is at the top right, closest to the screen.
	public int[][][] direction(int direction) { //# as directions: +/- 1 = z, +/- 2 = y, +/- 3 = z 
		for(int l = 0; l < 4; l++) {
			for(int i = 0; i < 4; i++) {
				for(int j = 0; j< 4;j++) {
					for(int k = 0; k < 4; k++) {
						switch(direction) { 
						case 1:	//this is DOWN, z direction (w)
							if(j != 3) {
								if(array[i][j][k] == 0) { 
									array[i][j][k] = array[i][j + 1][k];
									array[i][j + 1][k] = 0;
								}
								if(array[i][j][k] == array[i][j + 1][k]) {
									array[i][j][k] = 2 * array[i][j + 1][k];
									array[i][j + 1][k] = 0;
								}
							}	
							break;
						case -1: //this is UP, z direction
							if(j!= 3) {
								if(array[i][3 - j][k] == 0) { 
									array[i][3 - j][k] = array[i][2 - j][k];
									array[i][2 - j][k] = 0;
								} if(array[i][3 - j][k] == array[i][2 - j][k]) {
									array[i][3-j][k] = 2 * array[i][2 - j][k];
									array[i][2 - j][k] = 0;
								}
							}
							
							break;
						case 2: //this is left
							if(i != 3) {
								if(array[i][j][k] == 0) { 
									array[i][j][k] = array[i + 1][j][k];
									array[i + 1][j][k] = 0;
								}
								if(array[i][j][k] == array[i + 1][j][k]) {
									array[i][j][k] = 2 * array[i + 1][j][k];
									array[i + 1][j][k] = 0;
								}
							}
							
							break;
							
							
						case -2: //this is right
							if(i != 3) {
								if(array[3 - i][j][k] == 0) { 
									array[3 - i][j][k] = array[2 - i][j][k];
									array[2 - i][j][k] = 0;
								}
								if(array[3 - i][j][k] == array[2 - i][j][k]) {
									array[3 - i][j][k] = 2 * array[2 - i][j][k];
									array[2 - i][j][k] = 0;
								}
							}
							
							break;
							
							
						case 3: 
							
							if(k != 3) { //it yells at me if I call this without making k != 3
								if(array[i][j][k] == 0) { 
									array[i][j][k] = array[i][j][k + 1];
									array[i][j][k + 1] = 0;
								}
								if(array[i][j][k] == array[i][j][k + 1]) {
									array[i][j][k] = 2 * array[i][j][k + 1];
									array[i][j][k + 1] = 0;
								}
							}
							break;
							
							
						case -3: 
							if(k != 3) {
								if(array[i][j][3 - k] == 0) { 
									array[i][j][3 - k] = array[i][j][2 - k];
									array[i][j][2 - k] = 0;
								
								}
								if(array[i][j][3 - k] == array[i][j][2 - k]) {
									array[i][j][3 - k] = 2 * array[i][j][2 - k];
									array[i][j][3 - k] = 0;
								}
							}
							
							break;
							
						}
					}
				}
			}
		} //grossest thing ever.
			
		
		return array;
	}
		
	

}
	
	

