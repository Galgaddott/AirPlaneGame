package com.terena.xust.ball;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

public class BallJPanel extends JPanel implements Runnable,MouseMotionListener{
	
	/*����*/
	int d = 50;//С���ֱ��
	int speed = 1;//С�����������
	int m = 10;//С��˯��ʱ����
	Color c;
	
	//���������
	int bx = 100;//����x����
	int by = 500;//����y����
	int bw = 200;//����Ŀ��
	int bh = 20;//����ĸ߶�
	
	//С������x����
	int  x = (int)(Math.random() *( Factory.jframeWidth - d));
	int  y = (int)(Math.random() *( by - d));
	
	//����С��ķ���
	int xdir = 1;//����x�᷽��
	int ydir = 1;//����y�᷽��
	
	
	///�߳�t
	Thread t;

	
	//���÷���
	
	int score = 0;
	
	//������Ϸ״̬
	boolean over = false;
	
	/*���췽��*/
	public BallJPanel() {
		this.setBackground(Color.white);
		t = new Thread(this);
		t.start();
		
		//�����������
		addMouseMotionListener(this);
		
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		//������
		g.setColor(c);
		g.fillOval(x, y, d, d);
		//������
		g.setColor(Color.yellow);
		//ǿ��ת����������
		Graphics2D g1 = (Graphics2D) g;
		//��2D����������߶�
		g1.setStroke(new BasicStroke(bh));
		//�滭
		g1.drawLine(bx, by, bx+bw, by);
	
		
	}
	public void run() {
		
		while(true)
		{
			x += speed*xdir;
			y += speed*ydir;
			
			
			//��С���������ұ߽�
			if(x <=0 || x >= Factory.jframeWidth-d) {
				c = Factory.randomColor(256);
				
				xdir *= -1;//�ı�x����
			if(m>2) {
				m--;
					}
			else {
				m = 2;
				 }
			}
			
			//��С���������ϱ߽�
			if(y <=0 ) {
				c = Factory.randomColor(256);
				
				ydir *= -1;
				if(m>2) {
					m--;
						}
				else {
					m = 2;
					 }
				
			}
			
			//�ж�С���Ƿ��ڵ���֮�����ڵ���֮��
			if(y <= by - d) {//�Ƿ��ڵ���֮��
				if(y == by - d && x >= bx -d/2 && x <= bx+bw -d/2)
				{
					ydir *=-1;
					score +=10;
					if(m>2) {
						m--;
							}
					else {
						m = 2;
						 }
					//������
					if( bw > 30)
					{
						bw -=5;
					}
					else
					{
						bw =30;
					}
				}
				
			}
			else {
				over = true;
			}
			
			repaint();
			try {
				Thread.sleep(m);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		}
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
	
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		//������ƶ��������м�
		bx=e.getX() - bw/2;
		
	}
	
	
	
	
	

}
