
public class Balise 
{
	private int x;
	private int y;
	private int toursRestants;
	
	public Balise(int x, int y, int toursRestants)
	{
		this.x = x;
		this.y = y;
		this.toursRestants = toursRestants;
	}

	public int getX() { return x; }
	public int getY() { return y; }
	public int getToursRestants() { return toursRestants; }
	
	public void creuser() { this.toursRestants--; }
}
