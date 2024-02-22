package paket;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Svemir extends Canvas implements Runnable {
	
	private ArrayList<NebeskoTelo> nebeskaTela = new ArrayList<>();
	private ArrayList<NebeskoTelo> nebeskaTelaZaBrisanje = new ArrayList<>();
	private Thread thread;
	//private boolean radi = false;
	
	public Svemir() {
		setBackground(Color.BLACK);
		thread = new Thread(this);
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		crtajNebeskaTela(g);
		
	}
	
	public synchronized void dodajNebeskoTelo(NebeskoTelo n) {
		nebeskaTela.add(n);
	}
	
	private synchronized void crtajNebeskaTela(Graphics g) {//ako na licu mesta koristim get Graphics nema problema sem blinkanja brda
		for(int i = 0; i < nebeskaTela.size(); i++) {
			nebeskaTela.get(i).crtaj(g);
			kretanjeKrozSvemir(i);
			//nebeskaTela.get(i).promeniY(5);//da ne bude neka greska ovde, da l odvojiti???
			//if(nebeskaTela.get(i).getY() > getHeight() + 50) brisi.add(nebeskaTela.get(i)); //nebeskaTela.remove(i); //uz remove blinka pred kraj
		}
		nebeskaTela.removeAll(nebeskaTelaZaBrisanje);
	}
	
	private void kretanjeKrozSvemir(int i) {
		nebeskaTela.get(i).promeniY(5);
		if(nebeskaTela.get(i).getY() > getHeight() + 50) nebeskaTelaZaBrisanje.add(nebeskaTela.get(i));
	}

	@Override
	public void run() {
		try {
			
			/*synchronized (this) {
				while(!radi) {
					wait();
				}
			}*/
			
			while(!Thread.interrupted()) {
				
				repaint();
				Thread.sleep(100);
				
			}
			
		}catch (InterruptedException e) {}
	}
	
	public synchronized void prekiniSaRadom() {
		thread.interrupt();
	}
	
	public synchronized void kreniSaRadom() {
		thread.start();
		//radi = true;
		//notify();
	}
	
}
