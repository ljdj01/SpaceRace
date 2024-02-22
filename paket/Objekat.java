package paket;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Objekat {

	protected int x, y;
	protected Color color;
	
	public Objekat(int x, int y, Color color) {
		super();
		this.x = x;
		this.y = y;
		this.color = color;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	
	public void promeniX(int pomeraj) {
		x += pomeraj;
	}
	public void promeniY(int pomeraj) {
		y += pomeraj;
	}
	
	public abstract void crtaj(Graphics g);
	
}
