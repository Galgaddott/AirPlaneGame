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
		//设置随机数
		Random random = new Random();
	
		//设置画笔字体
		g.setFont(new Font("宋体",Font.BOLD,random.nextInt(65) ) );
		for(int i = 0; i<500; i++) {
			//设置画笔颜色
			g.setColor(new Color ( random.nextInt(256),random.nextInt(256),random.nextInt(256)  ) );
			//画
			g.drawString("*",random.nextInt(Factory.jframeWidth), random.nextInt(Factory.height));
			
		}
		
	}
	
	
}
