package com.terena.xust.ball;

import java.awt.Color;
import java.awt.Graphics;

/**
 * 小球类
 * @author 周蔚
 *
 */
public class Ball {

	/*成员变量*/
	public int x ,y ,d, speed ,xdir = 1 , ydir = 1;
	
	//颜色
	public Color ballColor;
	
	/*成员变量:小球的方向*/
	public int direction = 0;
	
	/*成员变量:代表方向的常量*/
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
	
	
	/*自定义画小球的方法*/
	public void drawBall(Graphics g) {
		//定义画笔的颜色
		g.setColor(ballColor);
		//画一个小球
		g.fillOval(x, y, d, d);
		
	}
	
	/*自定义方法-小球的移动*/
	public void moveBall() {
		//改变小球的位置
		x += speed*xdir;
		y += speed*ydir;
		//改变小球的方向
		if(x <= 0 || x >= Factory.jframeWidth - d) {
			xdir *= -1;
		}
		
		if(y <= 0 || y>= Factory.jframeHeight - d) {	
			ydir *=-1;
		}
		
		
	}
	
	/*自定义方法-小球的移动 方法重载  需传入挡板的参数 且返回值类型为int 如果为1：表示在挡板之下
	 * 																如果为2：表示挡板接住小球
	 * 																	*/
	
	public int moveBall(int px,int py,int pw) {
		//定义标志位
		int i = 0;
		switch(direction) {
		case LEFT_UP: 
			x -= speed; y -= speed;
			//改变方向
			if(x <= 0) direction = RIGHT_UP;
			if(y <= 0) direction = LEFT_DOWN;
			break;
		case LEFT_DOWN:
			x -= speed;
			y += speed;
			//改变方向
			if(x <= 0) direction = RIGHT_DOWN;
			//判断在挡板之上
			if(y <= py -d) {
				//判断小球在挡板之内
				if(y == py -d && x >= px -d/2 && x <= px+pw -d/2)
				{
					direction = LEFT_UP;
					i = 2;
				}
				
			}
			else   {
				//小球在挡板的下方
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
