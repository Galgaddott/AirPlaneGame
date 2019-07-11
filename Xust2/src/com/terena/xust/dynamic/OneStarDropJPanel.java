package com.terena.xust.dynamic;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JPanel;

public class OneStarDropJPanel extends JPanel implements Runnable {
	//�������
	int y;
	int x;
	Color c;
	Font f;
	//�����߳�t
	Thread t;
	
	public OneStarDropJPanel() {
		this.setBackground(Color.black);
		//ʵ�����̶߳���
		t=new Thread(this);
		//�߳�����
		t.start();
		
	
	}
	
	
	@Override
	public void paint(Graphics g) {
		
		super.paint(g);
		g.setColor(c);
		g.setFont(f);
		g.drawString("*",x, y);
		
	}

	/*��дrun����*/
	@Override
	public void run() {
		//��ִ��run������������״̬
		while(true) {//������ѭ��
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
			repaint();//�ػ�
			
			try {
				Thread.sleep(100);//����״̬
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}//��run����������Ͻ������״̬
		
	}
	
}
