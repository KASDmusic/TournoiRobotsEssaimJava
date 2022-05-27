import model.Terrain;
import view.MainFrame;

public class Controleur 
{	
	private Terrain terrain;
	private MainFrame mainFrame;
	
	public Controleur()
	{
		this.terrain = new Terrain();
		this.mainFrame = new MainFrame(this.terrain);
		
		while(this.terrain.getBalise().getToursRestants() > 0 && Terrain.nbTour < Terrain.NB_TOURS_LIMITE)
		{
			Terrain.nbTour++;
			
			for(int i=0 ; i<Terrain.NB_RBT ; i++)
			{
				//Condition creuser balise et detection Balise
				this.terrain.detectionCreuserBalise();
				
				if(this.terrain.getBalise().getToursRestants() <= 0)
					break;
				
				//Condition Communication Robot
				this.terrain.communicationRobot();
				
				this.terrain.getEnsRobots().get(i).move();
			}
			
			this.mainFrame.repaint();
			
			try { Thread.sleep(10); }
			catch(Exception e) { System.err.println(e); }
		}
	}
	
	public static void main(String[] args) 
	{
		new Controleur();
	}

}
