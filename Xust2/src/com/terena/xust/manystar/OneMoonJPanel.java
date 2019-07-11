package com.terena.xust.manystar;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JPanel;

public class OneMoonJPanel extends JPanel{
	
	public OneMoonJPanel() {
		this.setBackground(Color.black);
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.yellow);
		g.fillOval(250, 100, 100, 100);
		g.setColor(Color.black);
		g.fillOval(250, 100, 80, 80);
		
		Random random = new Random();
			
		
		g.setFont(new Font("ËÎÌו",Font.BOLD,random.nextInt(65) ) );
			for(int i = 0; i<500; i++) {
					g.setColor(new Color ( random.nextInt(256),random.nextInt(256),random.nextInt(256)  ) );
					g.drawString("*",random.nextInt(Factory.jframeWidth), random.nextInt(Factory.height));
					
				}	
	}
	
}
