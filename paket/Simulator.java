package paket;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Panel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Simulator extends Frame {

	private Panel bottomPanel = new Panel();
	private Button button = new Button("Pokreni!");
	private Panel centerPanel = new Panel();
	private Svemir svemir = new Svemir();
	private Generator generator = new Generator(svemir);
	
	
	
	private void populateWindow() {
		
		bottomPanel.add(button);
		bottomPanel.setPreferredSize(new Dimension(200, 30));
		add(bottomPanel, BorderLayout.SOUTH);
		
		svemir.setSize(new Dimension(getWidth(), 340));//bez prefered za tacnu velicinu 200,340
		centerPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		centerPanel.add(svemir);
		add(centerPanel, BorderLayout.CENTER);
		
		button.addActionListener((al)->{
			svemir.kreniSaRadom();
			generator.kreniSaRadom();
			
			button.setEnabled(false);
		});
		
		
	}
	
	public Simulator() {
		setBounds(700,200,200,400);
		setResizable(false);
		setVisible(true);
		
		populateWindow();
		pack();
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				svemir.prekiniSaRadom();
				generator.prekiniSaRadom();
				dispose();
			}
		});
		
	}

	public static void main(String[] args) {
		new Simulator();
	}

}
