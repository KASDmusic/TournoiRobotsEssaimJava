package model;

public class PiloteRobot implements Pilotable
{	
	private RobotViewer robotViewer;

	public PiloteRobot() {}
	
	public PiloteRobot(RobotViewer robotViewer)
	{
		this.robotViewer = robotViewer;
	}

	public void setRobotViewer(RobotViewer robotViewer) { this.robotViewer = robotViewer; }
	
	//A Completer
	public char pilote()
	{
		char[] tab = new char[] {'N', 'S', 'E', 'W', ' '};
		char mouv = tab[(int)(Math.random() * tab.length)];
		
		return mouv;
	}
}
