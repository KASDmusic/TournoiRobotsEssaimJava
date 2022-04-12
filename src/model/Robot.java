package model;

import java.util.ArrayList;

public class Robot 
{
	public static final int DIST_DEP = 5;
	
	private ArrayList<Robot> ensRobots;
	
	private int x;
	private int y;
	private int xBalise;
	private int yBalise;
	
	private char dernierDep;
	
	public Robot(int x, int y)
	{
		this.ensRobots = new ArrayList<Robot>();
		
		this.x = x;
		this.y = y;
		this.xBalise = -1;
		this.yBalise = -1;
		
		this.dernierDep = ' ';
	}
	
	public ArrayList<Robot> getEnsRobots() { return this.ensRobots; }
	public int  getX() { return this.x; }
	public int  getY() { return this.y; }
	public int  getXBalise() { return this.xBalise; }
	public int  getYBalise() { return this.yBalise; }
	public char getDernierDep() { return this.dernierDep; }
	
	public void setXBalise(int x) { this.xBalise = x; }
	public void setYBalise(int y) { this.yBalise = y; }
	
	public boolean avancer(char direction)
	{
		if(direction == 'N' && this.y - Robot.DIST_DEP >= Terrain.MIN_Y)
		{
			this.y-=Robot.DIST_DEP;
			this.dernierDep = 'N';
			return true;
		}
		
		if(direction == 'S' && this.y + Robot.DIST_DEP <= Terrain.MAX_Y)
		{
			this.y+=Robot.DIST_DEP;
			this.dernierDep = 'S';
			return true;
		}
		
		if(direction == 'E' && this.x + Robot.DIST_DEP <= Terrain.MAX_X)
		{
			this.x+=Robot.DIST_DEP;
			this.dernierDep = 'E';
			return true;
		}
		
		if(direction == 'W' && this.x - Robot.DIST_DEP >= Terrain.MIN_X)
		{
			this.x-=Robot.DIST_DEP;
			this.dernierDep = 'W';
			return true;
		}
		
		return false;		
	}
}
