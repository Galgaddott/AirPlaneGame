package com.terena.xust.dynamic;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JPanel;

public class OneStarDropJPanel extends JPanel implements Runnable {
	//定义变量
	int y;
	int x;
	Color c;
	Font f;
	//定义线程t
	Thread t;
	
	public OneStarDropJPanel() {
		this.setBackground(Color.black);
		//实例化线程对象
		t=new Thread(this);
		//线程启动
		t.start();
		
	
	}
	
	
	@Override
	public void paint(Graphics g) {
		
		super.paint(g);
		g.setColor(c);
		g.setFont(f);
		g.drawString("*",x, y);
		
	}

	/*重写run方法*/
	@Override
	public void run() {
		//当执行run方法才是运行状态
		while(true) {//自造死循环
			y=y+10;
			if(y == Factory.jframeHeight) {
				y = 0;
				c = Factory.randomColor(256);
				x = Factory.randomPoint(Factory.jframeWidth);
				f = Factory.randomFont(65);
			}
			
			 if(x == Factory.jframeWidth) {
					x = 0;
				}
			repaint();//重绘
			
			try {
				Thread.sleep(100);//阻塞状态
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}//当run方法运行完毕进入结束状态
		
	}
	
}
