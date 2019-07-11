package com.terena.xust.dynamic;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

public class ManyStarDropJPanel extends JPanel implements Runnable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*定义每颗星的x、 y坐标*/
	int[] x;
	int[] y;
	int xx = 100;
	Color c[];
	Font  f[];
	
	/*定义线程对象t*/
	Thread t;
	

	public ManyStarDropJPanel() {
		//设置背景颜色
		this.setBackground(Color.black);
		//实例化线程对象
		t = new Thread(this);
		//线程自动
		t.start();
		//实例化数组x及y
		x = new int [300];
		y = new int [300];
		c = new Color[300];
		f = new Font[300];
		
		for (int i = 0; i < x.length; i++) {
			
			x[i] = Factory.randomPoint(Factory.jframeWidth);
			y[i] = Factory.randomPoint(Factory.jframeHeight);
			c[i] = Factory.randomColor(256);
			f[i] = Factory.randomFont(65);
			
		}
		
	}
	
	//重写绘画方法
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		for (int i = 0; i < x.length; i++) {
			g.setColor(c[i]);
			g.setFont(f[i]);
			g.drawString("*", x[i], y[i]);
		}
			g.setColor(Color.yellow);
			g.fillOval(200, 100, 100, 100);
			g.setColor(Color.black);
			g.fillOval(xx, 100, 100, 100);
			
	}
	
	//重写run方法
	public void run() {
	
		while(true)
		{
			for (int i = 0; i < x.length; i++) {
				y[i]=y[i]+Factory.randomPoint(10);
				
				if(y[i]++ == Factory.jframeHeight)
					{
					y[i] = 0;
					c[i] = Factory.randomColor(256);
					f[i] = Factory.randomFont(65);
				
					}
			}
			if(xx == Factory.jframeWidth)		
			{
				xx = 0;
			}
			xx=xx+20;
			
			repaint();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
		
	}

}
