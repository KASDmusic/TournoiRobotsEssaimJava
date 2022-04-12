package view;

import javax.swing.*;

import model.Robot;
import model.Terrain;

import java.awt.*;

public class MainFrame extends JFrame 
{
	private Terrain terrain;
	
	public MainFrame(Terrain terrain)
	{
		this.terrain = terrain;
		
		this.setTitle("Affichage Robot Essaim");
		this.setSize(1080, 720);
		this.setLocation(0, 0);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		
		this.setVisible(true);
	}
	
	public void paint(Graphics g) 
	{   
		super.paintComponents(g);
		
		int width = (int)g.getClipBounds().getWidth();
		int height = (int)g.getClipBounds().getHeight();
		
		int x0 = (width - Terrain.WIDTH_TERRAIN)/2;
		int y0 = (height - Terrain.HEIGHT_TERRAIN)/2;
		
		//Dessin Zone jeu
		g.setColor(Color.black);
		g.drawRect(x0, y0, Terrain.WIDTH_TERRAIN, Terrain.HEIGHT_TERRAIN);
		
		//Labels nombre coups restants et nombre coups
		g.drawString("Tours Restants De La Balise : " + terrain.getBalise().getToursRestants(), width/2, y0 + Terrain.HEIGHT_TERRAIN + 20);
		g.drawString("Nombre de coups actuels : " + Terrain.nbTour, width/2, y0 + Terrain.HEIGHT_TERRAIN + 40);
		
		//Dessin Zone Detection
		g.setColor(Color.gray);
		for(Robot r : terrain.getEnsRobots())
			g.drawOval(x0 + r.getX() - Terrain.TAILLE_RBT - Terrain.RAYON_DETECT + Terrain.TAILLE_RBT/2, y0 + r.getY() - Terrain.RAYON_DETECT + Terrain.TAILLE_RBT/2, Terrain.RAYON_DETECT*2, Terrain.RAYON_DETECT*2);
			
			
		//Dessin Robots
		g.setColor(Color.blue);
		for(Robot r : terrain.getEnsRobots())
			g.fillOval(x0 + r.getX() - Terrain.TAILLE_RBT, y0 + r.getY(), Terrain.TAILLE_RBT, Terrain.TAILLE_RBT);    
		
		//Dessin de la balise
		g.setColor(Color.red);
		g.fillOval(x0 + terrain.getBalise().getX() - Terrain.TAILLE_RBT, y0 + terrain.getBalise().getY(), Terrain.TAILLE_RBT, Terrain.TAILLE_RBT);
	}
}