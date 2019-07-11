package com.terena.xust.ball;

import java.awt.Color;
import java.awt.Graphics;

/**
 * С����
 * @author ��ε
 *
 */
public class Ball {

	/*��Ա����*/
	public int x ,y ,d, speed ,xdir = 1 , ydir = 1;
	
	//��ɫ
	public Color ballColor;
	
	/*��Ա����:С��ķ���*/
	public int direction = 0;
	
	/*��Ա����:������ĳ���*/
	static final int LEFT_UP = 0;
	
	public Ball(int x, int y, int d, int speed, Color ballColor) {
		super();
		this.x = x;
		this.y = y;
		this.d = d;
		this.speed = speed;
		this.ballColor = ballColor;
	
	}
	
	public Ball(int x, int y, int d, int speed, Color ballColor, int direction) {
		super();
		this.x = x;
		this.y = y;
		this.d = d;
		this.speed = speed;
		this.ballColor = ballColor;
		this.direction = direction;
	}

	static final int LEFT_DOWN = 1;
	static final int RIGHT_UP = 2;
	static final int RIGHT_DOWN = 3;
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getD() {
		return d;
	}
	public void setD(int d) {
		this.d = d;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public int getXdir() {
		return xdir;
	}
	public void setXdir(int xdir) {
		this.xdir = xdir;
	}
	public int getYdir() {
		return ydir;
	}
	public void setYdir(int ydir) {
		this.ydir = ydir;
	}
	public Color getBallColor() {
		return ballColor;
	}
	public void setBallColor(Color ballColor) {
		this.ballColor = ballColor;
	}
	public int getDirection() {
		return direction;
	}
	public void setDirection(int direction) {
		this.direction = direction;
	}
	
	
	/*�Զ��廭С��ķ���*/
	public void drawBall(Graphics g) {
		//���廭�ʵ���ɫ
		g.setColor(ballColor);
		//��һ��С��
		g.fillOval(x, y, d, d);
		
	}
	
	/*�Զ��巽��-С����ƶ�*/
	public void moveBall() {
		//�ı�С���λ��
		x += speed*xdir;
		y += speed*ydir;
		//�ı�С��ķ���
		if(x <= 0 || x >= Factory.jframeWidth - d) {
			xdir *= -1;
		}
		
		if(y <= 0 || y>= Factory.jframeHeight - d) {	
			ydir *=-1;
		}
		
		
	}
	
	/*�Զ��巽��-С����ƶ� ��������  �贫�뵲��Ĳ��� �ҷ���ֵ����Ϊint ���Ϊ1����ʾ�ڵ���֮��
	 * 																���Ϊ2����ʾ�����סС��
	 * 																	*/
	
	public int moveBall(int px,int py,int pw) {
		//�����־λ
		int i = 0;
		switch(direction) {
		case LEFT_UP: 
			x -= speed; y -= speed;
			//�ı䷽��
			if(x <= 0) direction = RIGHT_UP;
			if(y <= 0) direction = LEFT_DOWN;
			break;
		case LEFT_DOWN:
			x -= speed;
			y += speed;
			//�ı䷽��
			if(x <= 0) direction = RIGHT_DOWN;
			//�ж��ڵ���֮��
			if(y <= py -d) {
				//�ж�С���ڵ���֮��
				if(y == py -d && x >= px -d/2 && x <= px+pw -d/2)
				{
					direction = LEFT_UP;
					i = 2;
				}
				
			}
			else   {
				//С���ڵ�����·�
				i=1;
			}
			break;
		case RIGHT_UP:
			 x += speed;
			 y -= speed;
			 if(y <= 0 ) direction = RIGHT_DOWN;
			 if(x >= Factory.jframeWidth -d) direction = LEFT_UP;
			 break;
		case RIGHT_DOWN:
			x += speed;
			y += speed;
			if(x >= Factory.jframeWidth -d) direction = LEFT_DOWN;
			if(y <= py -d)
			{
				if(y == py - d && x >= px - d /2 && x <= px + pw - d/2) {
					direction = RIGHT_UP;
					i = 2;
				}
				
			}
			else {
				i = 1;
			}
			break;
		
		}
		return i;
	}
	
	
	
}
