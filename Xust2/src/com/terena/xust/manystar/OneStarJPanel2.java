package com.terena.xust.manystar;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JPanel;

/**
 * 一颗星随机颜色、大小、位置
 * @author 周蔚
 *
 */
public class OneStarJPanel2 extends JPanel{
	
	public OneStarJPanel2() {
		// TODO Auto-generated constructor stub
		this.setBackground(Color.black);
	} 
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		//设置随机数
		Random random=new Random();
		//设置画笔颜色
		g.setColor(new Color ( random.nextInt(256),random.nextInt(256),random.nextInt(256)  ) );
		//设置画笔字体
		g.setFont(new Font("宋体",Font.BOLD,random.nextInt(65) ) );
		//画
		g.drawString("*",random.nextInt(Factory.jframeWidth), random.nextInt(Factory.height));
				
	}

}
