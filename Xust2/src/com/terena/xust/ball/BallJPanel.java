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
	
	/*属性*/
	int d = 50;//小球的直径
	int speed = 1;//小球的坐标增量
	int m = 10;//小球睡眠时间量
	Color c;
	
	//挡板的属性
	int bx = 100;//挡板x坐标
	int by = 500;//挡板y坐标
	int bw = 200;//挡板的宽度
	int bh = 20;//挡板的高度
	
	//小球的随机x坐标
	int  x = (int)(Math.random() *( Factory.jframeWidth - d));
	int  y = (int)(Math.random() *( by - d));
	
	//设置小球的方向
	int xdir = 1;//设置x轴方向
	int ydir = 1;//设置y轴方向
	
	
	///线程t
	Thread t;

	
	//设置分数
	
	int score = 0;
	
	//设置游戏状态
	boolean over = false;
	
	/*构造方法*/
	public BallJPanel() {
		this.setBackground(Color.white);
		t = new Thread(this);
		t.start();
		
		//添加鼠标监听器
		addMouseMotionListener(this);
		
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		//绘制球
		g.setColor(c);
		g.fillOval(x, y, d, d);
		//画挡板
		g.setColor(Color.yellow);
		//强制转化画笔类型
		Graphics2D g1 = (Graphics2D) g;
		//对2D进行设置其高度
		g1.setStroke(new BasicStroke(bh));
		//绘画
		g1.drawLine(bx, by, bx+bw, by);
	
		
	}
	public void run() {
		
		while(true)
		{
			x += speed*xdir;
			y += speed*ydir;
			
			
			//当小球碰到左右边界
			if(x <=0 || x >= Factory.jframeWidth-d) {
				c = Factory.randomColor(256);
				
				xdir *= -1;//改变x方向
			if(m>2) {
				m--;
					}
			else {
				m = 2;
				 }
			}
			
			//当小球碰都到上边界
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
			
			//判断小球是否在挡板之上且在挡板之内
			if(y <= by - d) {//是否在挡板之上
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
					//挡板变短
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
		//将鼠标移动至挡板中间
		bx=e.getX() - bw/2;
		
	}
	
	
	
	
	

}
