import model.Terrain;
import view.MainFrame;

import java.util.Arrays;

public class Controleur 
{	
	private Terrain terrain;
	private MainFrame mainFrame;
	
	public Controleur(boolean verbose, boolean graphic)
	{
		this.terrain = new Terrain();

		if(graphic)
			this.mainFrame = new MainFrame(this.terrain);

		if(verbose)
			System.err.println(this.terrain);
		
		while(this.terrain.getBalise().getToursRestants() > 0 && Terrain.nbTour < Terrain.NB_TOURS_LIMITE)
		{
			Terrain.nbTour++;
			
			for(int i=0 ; i<Terrain.NB_RBT ; i++)
			{
				//Condition creuser balise et detection Balise
				this.terrain.detectionCreuserBalise();
				
				if(this.terrain.getBalise().getToursRestants() <= 0)
					break;
				
				//Condition communication Robot
				this.terrain.communicationRobot();
				
				this.terrain.getEnsRobots().get(i).move();

				if(verbose)
					System.err.println(this.terrain);
			}
			
			if(graphic)
				this.mainFrame.repaint();
			
			try { Thread.sleep(10); }
			catch(Exception e) { System.err.println(e); }
		}

		System.out.println(Terrain.nbTour + " " + this.terrain.getBalise().getToursRestants());
	}
	
	public static void main(String[] args) 
	{
		boolean verbose = false;
		boolean graphic = false;

		for(String s : args)
		{
			s = s.replaceAll("'", "").toLowerCase();

			if(s.equals("-v"))
				verbose = true;
				
			if(s.equals("-g"))
				graphic = true;
		}

		new Controleur(verbose, graphic);
	}

}
