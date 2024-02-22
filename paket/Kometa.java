package paket;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

public class Kometa extends NebeskoTelo {

	public Kometa(int x, int y, Color color, int p) {
		super(x, y, color, p);
	}
	
	private double ugao = 0;
	
	@Override
	public void crtaj(Graphics g) {
		Color staraBoja = g.getColor();
		g.setColor(color);
		g.translate(x, y);
		
		int nizX[] = new int[5];
		int nizY[] = new int[5];
		
		double ugaoPomeraj = 2* Math.PI / 5;
		if(ugao == 0) ugao = (Math.random() * 2* Math.PI);
		
		for(int i = 0; i<5; i++) {
			nizX[i] = (int)(poluprecnik * Math.cos(ugao));
			nizY[i] = (int)(poluprecnik * Math.sin(ugao));
			ugao += ugaoPomeraj;
		}
		
		g.fillPolygon(nizX, nizY, 5);
		
		g.translate(-x, -y);
		g.setColor(staraBoja);
	}

}
