package model;

import java.util.ArrayList;

public class Robot 
{
	public static final int DIST_DEP = 5;

	private static int compteur = 1;
	
	private ArrayList<Robot> ensRobotsContact;

	private PiloteRobot piloteRobot;
	
	private int id;
	private int x;
	private int y;
	private int xBalise;
	private int yBalise;
	
	private char dernierDep;
	
	public Robot(int x, int y, PiloteRobot piloteRobot)
	{
		this.ensRobotsContact = new ArrayList<Robot>();
		
		this.piloteRobot = piloteRobot;

		this.id = Robot.compteur;
		this.x = x;
		this.y = y;
		this.xBalise = -1;
		this.yBalise = -1;
		
		this.dernierDep = ' ';

		Robot.compteur++;
	}
	
	public ArrayList<Robot> getEnsRobotsContact() { return this.ensRobotsContact; }
	public int  getId() { return this.id;  }
	public int  getX()  { return this.x;   }
	public int  getY()  { return this.y;   }
	public int  getXBalise() { return this.xBalise; }
	public int  getYBalise() { return this.yBalise; }
	public char getDernierDep() { return this.dernierDep; }
	
	public void setXBalise(int x) { this.xBalise = x; }
	public void setYBalise(int y) { this.yBalise = y; }

	public RobotViewer toRobotViewer(Robot rbt) { return new RobotViewer(rbt); }
	
	public boolean move()
	{
		char direction = Character.toUpperCase(this.piloteRobot.pilote());

		if(direction == 'N' && this.y - Robot.DIST_DEP >= Terrain.MIN_Y)
		{
			this.y -= Robot.DIST_DEP;
			this.dernierDep = 'N';
			return true;
		}
		else if(direction == 'S' && this.y + Robot.DIST_DEP <= Terrain.MAX_Y)
		{
			this.y += Robot.DIST_DEP;
			this.dernierDep = 'S';
			return true;
		}
		else if(direction == 'E' && this.x + Robot.DIST_DEP <= Terrain.MAX_X)
		{
			this.x += Robot.DIST_DEP;
			this.dernierDep = 'E';
			return true;
		}
		else if(direction == 'W' && this.x - Robot.DIST_DEP >= Terrain.MIN_X)
		{
			this.x -= Robot.DIST_DEP;
			this.dernierDep = 'W';
			return true;
		}
		else
		{
			this.dernierDep = ' ';
			return false;
		}	
	}

	@Override
	public String toString()
	{
		String res = "Robot " + this.id + "\n";
		res += "\tlastMove:" + this.dernierDep;
		res += "\tx:" + this.x + " | y:" + this.y + "\n";
		res += "\txBalise:" + this.xBalise + " | yBalise:" + this.yBalise + "\n";

		return res;
	}
}
