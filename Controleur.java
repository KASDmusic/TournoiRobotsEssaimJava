import java.util.ArrayList;

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
				
				this.terrain.getEnsPiloteRobot().get(i).pilote();
			}
			
			this.mainFrame.repaint();
			
			try { Thread.sleep(100); }
			catch(Exception e) { System.out.println(e); }
		}
	}
	
	public static void main(String[] args) 
	{
		new Controleur();
	}

}
