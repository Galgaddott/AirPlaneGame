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
	/*����ÿ���ǵ�x�� y����*/
	int[] x;
	int[] y;
	int xx = 100;
	Color c[];
	Font  f[];
	
	/*�����̶߳���t*/
	Thread t;
	

	public ManyStarDropJPanel() {
		//���ñ�����ɫ
		this.setBackground(Color.black);
		//ʵ�����̶߳���
		t = new Thread(this);
		//�߳��Զ�
		t.start();
		//ʵ��������x��y
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
	
	//��д�滭����
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
	
	//��дrun����
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
