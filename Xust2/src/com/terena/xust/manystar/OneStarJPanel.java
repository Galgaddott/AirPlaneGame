package com.terena.xust.manystar;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JPanel;

/**
 * 此类是画板类
 * 1.继承JPanel
 * 2.重写paint方法
 * 
 * @author 周蔚
 *t
 */
public class OneStarJPanel extends JPanel {
	/*构造方法初始化画板参数*/
	
	public OneStarJPanel() {
		//设置背景颜色
		this.setBackground(Color.black);
	}
	/*重写绘画的方法*/
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		//设置画笔颜色
		g.setColor(Color.yellow );
		//设置画笔字体
		g.setFont(new Font("宋体",Font.BOLD,40));
		//画
		g.drawString("*",100,100);
		
		
	}
	
	
}
