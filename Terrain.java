import java.util.ArrayList;

public class Terrain 
{	
	public static final int WIDTH_TERRAIN = 1000;
	public static final int HEIGHT_TERRAIN = 600;
	public static final int NB_RBT = 9;
	public static final int RAYON_DETECT = 50;
	public static final int TAILLE_RBT = 20;
	public static final int TOURS_NECESSAIRES = 10000;
	public static final int NB_TOURS_LIMITE = 1000;
	
	public static final int MIN_X = 0 + Terrain.TAILLE_RBT;
	public static final int MAX_X = Terrain.WIDTH_TERRAIN;
	public static final int MIN_Y = 0 + Terrain.TAILLE_RBT - Terrain.TAILLE_RBT;
	public static final int MAX_Y = Terrain.HEIGHT_TERRAIN - Terrain.TAILLE_RBT;
	
	public static int nbTour = 0;
	
	private ArrayList<Robot> ensRobots;
	private ArrayList<PiloteRobot> ensPiloteRobots;
	private Balise balise;
	
	public Terrain()
	{
		//Creation ensemble robot
		this.ensRobots = new ArrayList<Robot>();
		for(int i=0 ; i<Terrain.NB_RBT ; i++)
		{
			int x = Terrain.MIN_X + (int)(Math.random() * (Terrain.MAX_X - Terrain.MIN_X + 1));
			int y = Terrain.MIN_Y + (int)(Math.random() * (Terrain.MAX_Y - Terrain.MIN_Y + 1));
			this.ensRobots.add(new Robot(x, y));
		}
		
		//Creation Balise
		int x = Terrain.MIN_X + (int)(Math.random() * (Terrain.MAX_X - Terrain.MIN_X + 1));
		int y = Terrain.MIN_Y + (int)(Math.random() * (Terrain.MAX_Y - Terrain.MIN_Y + 1));
		this.balise = new Balise(x, y, Terrain.TOURS_NECESSAIRES);
		
		//Creation ensemble pilote robot
		this.ensPiloteRobots = new ArrayList<PiloteRobot>();
		for(int i=0 ; i<Terrain.NB_RBT ; i++)
		{
			this.ensPiloteRobots.add(new PiloteRobot(this.ensRobots.get(i)));
		}
	}
	
	public ArrayList<Robot> 	  getEnsRobots() 	  { return this.ensRobots; }
	public ArrayList<PiloteRobot> getEnsPiloteRobot() { return this.ensPiloteRobots; }
	public Balise           	  getBalise()    	  { return this.balise; }

	public void detectionCreuserBalise()
	{
		for(Robot r : this.ensRobots)
		{
			double x = r.getX() - this.balise.getX();
			double y = r.getY() - this.balise.getY();
			double norme = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
					
			if(norme <= Terrain.RAYON_DETECT)
			{
				this.balise.creuser();
				r.setXBalise(this.balise.getX());
				r.setYBalise(this.balise.getY());
			}
		}
	}
	
	public void communicationRobot()
	{
		for(Robot r1 : this.ensRobots)
		{
			for(Robot r2 : this.ensRobots)
			{
				if(r1 != r2)
				{
					double x = r1.getX() - r2.getX();
					double y = r1.getY() - r2.getY();
					double norme = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
					
					if(norme <= Terrain.RAYON_DETECT*2)
					{
						if(!r1.getEnsRobots().contains(r2))
							r1.getEnsRobots().add(r2);
						
						if(!r2.getEnsRobots().contains(r1))
							r2.getEnsRobots().add(r1);
					}
					else
					{
						if(r1.getEnsRobots().contains(r2))
							r1.getEnsRobots().remove(r2);
						
						if(r2.getEnsRobots().contains(r1))
							r2.getEnsRobots().remove(r1);
					}
				}
			}
		}
	}
}
