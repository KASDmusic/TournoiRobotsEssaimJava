package model;

public class PiloteRobot 
{	
	private Robot robot;
	
	public PiloteRobot(Robot robot)
	{
		this.robot = robot;
	}
	
	//A Completer
	public void pilote()
	{
		
		char[] tab = new char[] {'N', 'S', 'E', 'W'};
		char mouv = tab[(int)(Math.random() * tab.length)];
		
		
		robot.avancer(mouv);
		
		//robot.avancer('S');
	}
	
	public static void main(String[] args) {
		System.out.println("\\n");
	}
}
