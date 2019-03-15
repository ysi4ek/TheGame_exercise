package logic;
import java.util.Random;

public class Robot {
	
	private Random generator;
	//private int lastChoice;
	private static Robot instance;
	
	private Robot(){
		generator = new Random();
	}
	
	public int newChoice(){
		//getRobot();
		//lastChoice = generator.nextInt(2);
		return generator.nextInt(3);
	}
	
	/*public int getLastChoice(){
		getRobot();
		return lastChoice;
	}
	*/
	
	public static Robot getRobot(){
		if(instance == null)instance = new Robot();
		return instance;
	}
	

}
