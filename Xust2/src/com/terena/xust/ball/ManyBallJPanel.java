package com.terena.xust.ball;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class ManyBallJPanel extends JPanel implements MouseMotionListener,MouseListener,Runnable  {

	/*�����Ա����������һ��С��ļ���*/
	List<Ball> balls = new ArrayList<Ball>();
	
	/*�����Ա������Factory*/
	Factory factory = new Factory();
	
	/*��Ա����:�߳�Thread*/
	Thread t;
	
	/*��Ա���������������*/
	int px = 100, py = 500, pw = 200 ,ph = 20;
	
	int score;
	boolean over = false;
	int m=10;
	
	/*���췽����ʼ������*/
	public ManyBallJPanel() {
		//���һ��Ĭ�ϵ�С��
		balls.add(factory.addBall());
		t = new Thread(this);
		t.start();
		
		//����������¼�
		addMouseListener(this);
		addMouseMotionListener(this);
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		//ȡ��������ÿһ��С�����
		for (int i = 0; i < balls.size(); i++) {
			balls.get(i).drawBall(g);
		}
		
		//������
		g.setColor(Color.black);
		Graphics2D g1 = (Graphics2D) g;
		g1.setStroke(new BasicStroke(ph));
		g1.drawLine(px, py, px+pw, py);
		
		
		//���÷ְ�
		Font f = new Font("����",Font.BOLD,50);
		g.setFont(f);
		g.drawString("�÷�"+score, 20, 50);
		
		//�������
		if(over == true)
		{
			g.setFont(new Font("����",Font.BOLD,50));
			g.drawString("Game Over",Factory.jframeWidth/2, Factory.jframeHeight/2);
		}
	}
	
	@Override
	public void run() {
		while(true) {
			//1.�ı�С���λ�úͷ���
			//ͨ��forѭ��,���ÿ��С����ƶ�
			for (int i = 0; i < balls.size(); i++) {
				Ball ball = balls.get(i);
				int result = ball.moveBall(px, py, pw);
				//δ�ӵ���
				if(result == 1) {
					balls.remove(i);
					over =true;			
				}
				if(result == 2) {
					if(over!=true)
					score += 10; 
					if(m>2) m-=1;
					else m=2;
					
				}
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
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		balls.add(factory.addBall());
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		px = e.getX() - pw/2;
		
	}

}
