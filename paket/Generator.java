package paket;

import java.awt.Color;

public class Generator extends Thread {
	private Svemir svemir;
	//private boolean radi = false;
	
	public Generator(Svemir s) {
		svemir = s;
	}
	
	@Override
	public void run() {
		try {
			
			/*synchronized (this) {
				while(!radi) {
					wait();
				}
			}*/
			
			while(!isInterrupted()) {
				
				int x = (int)(Math.random() * svemir.getWidth());
				int y = 0;
				int r = (int) ((Math.random() * (30 - 10)) + 10);
				Kometa kometa = new Kometa(x, y, Color.GRAY, r);
				svemir.dodajNebeskoTelo(kometa);
				
				sleep(900);
				
			}
			
			
		} catch (InterruptedException e) {}
		
	}
	
	public synchronized void kreniSaRadom() {
		this.start();
		//radi = true;
		//notify();
	}
	
	public synchronized void prekiniSaRadom() {
		interrupt();
	}
	
}
