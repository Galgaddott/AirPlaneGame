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

	/*定义成员变量：定义一个小球的集合*/
	List<Ball> balls = new ArrayList<Ball>();
	
	/*定义成员变量：Factory*/
	Factory factory = new Factory();
	
	/*成员变量:线程Thread*/
	Thread t;
	
	/*成员变量：挡板的属性*/
	int px = 100, py = 500, pw = 200 ,ph = 20;
	
	int score;
	boolean over = false;
	int m=10;
	
	/*构造方法初始化参数*/
	public ManyBallJPanel() {
		//添加一课默认的小球
		balls.add(factory.addBall());
		t = new Thread(this);
		t.start();
		
		//添加鼠标监听事件
		addMouseListener(this);
		addMouseMotionListener(this);
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		//取出集合中每一个小球对象
		for (int i = 0; i < balls.size(); i++) {
			balls.get(i).drawBall(g);
		}
		
		//画挡板
		g.setColor(Color.black);
		Graphics2D g1 = (Graphics2D) g;
		g1.setStroke(new BasicStroke(ph));
		g1.drawLine(px, py, px+pw, py);
		
		
		//画得分板
		Font f = new Font("宋体",Font.BOLD,50);
		g.setFont(f);
		g.drawString("得分"+score, 20, 50);
		
		//结束语句
		if(over == true)
		{
			g.setFont(new Font("宋体",Font.BOLD,50));
			g.drawString("Game Over",Factory.jframeWidth/2, Factory.jframeHeight/2);
		}
	}
	
	@Override
	public void run() {
		while(true) {
			//1.改变小球的位置和方向
			//通过for循环,完成每个小球的移动
			for (int i = 0; i < balls.size(); i++) {
				Ball ball = balls.get(i);
				int result = ball.moveBall(px, py, pw);
				//未接到球
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
