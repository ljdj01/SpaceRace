package paket;

import java.awt.Color;
import java.awt.Graphics;

public abstract class NebeskoTelo extends Objekat {
	
	protected int poluprecnik; 

	public NebeskoTelo(int x, int y, Color color, int p) {
		super(x, y, color);
		poluprecnik = p;
	}

	

}
