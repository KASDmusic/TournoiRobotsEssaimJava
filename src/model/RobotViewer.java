package model;

import java.util.ArrayList;

public class RobotViewer 
{
    private Robot robot;

    public RobotViewer(Robot robot)
    {
        this.robot = robot;
    }

    public ArrayList<Robot> getEnsRobotsContact() { return robot.getEnsRobotsContact(); }
	public int  getX() { return robot.getX(); }
	public int  getY() { return robot.getY(); }
	public int  getXBalise() { return robot.getXBalise(); }
	public int  getYBalise() { return robot.getYBalise(); }
	public char getDernierDep() { return robot.getDernierDep(); }
}
