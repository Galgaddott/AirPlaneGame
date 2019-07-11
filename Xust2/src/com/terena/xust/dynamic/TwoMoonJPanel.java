package com.terena.xust.dynamic;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class TwoMoonJPanel extends JPanel implements Runnable {
	
	Thread t;
	int x;
	public TwoMoonJPanel() {
		this.setBackground(Color.black);
		t=new Thread(this);
		t.start();
	}

	@Override
	public void run() {
		while(true)
		{
			x=x+20;
			if(x == Factory.jframeWidth)
			{
				x=0;
			}
			
			repaint();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.yellow);
		g.fillOval(250, 100, 100, 100);
		g.setColor(Color.BLACK);
		g.fillOval(x, 100, 100, 100);
	}
	
	
}
