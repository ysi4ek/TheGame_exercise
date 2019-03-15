package logic;

//import java.util.logging.Logger;

public class Result {
	private int humanChoice;
	private int robotChoice;
	private String winner;
	
	public static final int PAPER = 0;
	public static final int SCISSORS = 1;
	public static final int STONE = 2;
	
	private static String convertChoice(int choice){
		if(choice == PAPER) {return "Paper";} else
		if(choice == SCISSORS){ return "Scissors";} else
		if(choice == STONE) { return "Stone";}
		else return null;
	}
	
	public Result(int human,int robot){
		if(human == PAPER || human == SCISSORS || human == STONE){
		this.humanChoice = human;
		} else {
			this.humanChoice = -1;
		}
		if(robot == PAPER || robot == SCISSORS || robot == STONE){
		this.robotChoice = robot;
		} else {
			this.robotChoice = -1;
		}
		setWinner();
		System.out.println("Human is set to " +human);
		System.out.println("Robot is set to " +robot);
		System.out.println("Winner is set to " +winner);
	}
	
	private void setWinner(){
		if( humanChoice ==-1 || robotChoice ==-1) {
			winner = null;
		} else if(robotChoice == PAPER && humanChoice == STONE){
			winner = "Robot";
		} else if((humanChoice > robotChoice) || (humanChoice==PAPER && robotChoice == STONE)){
			winner = "Human";
		} else if(humanChoice==robotChoice){
			winner = "Nobody";
		}else {
			winner ="Robot";
		}
	}
	
	public String getHumanChoice(){
		return convertChoice(humanChoice);
	}
	
	public String getRobotChoice(){
		return convertChoice(robotChoice);
	}
	
	public String getWinner(){
		return winner;
	}

}
