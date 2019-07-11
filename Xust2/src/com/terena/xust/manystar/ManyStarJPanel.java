package com.terena.xust.manystar;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JPanel;

public class ManyStarJPanel extends JPanel{
	
	public ManyStarJPanel() {
		this.setBackground(Color.black);
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		//���������
		Random random = new Random();
	
		//���û�������
		g.setFont(new Font("����",Font.BOLD,random.nextInt(65) ) );
		for(int i = 0; i<500; i++) {
			//���û�����ɫ
			g.setColor(new Color ( random.nextInt(256),random.nextInt(256),random.nextInt(256)  ) );
			//��
			g.drawString("*",random.nextInt(Factory.jframeWidth), random.nextInt(Factory.height));
			
		}
		
	}
	
	
}
