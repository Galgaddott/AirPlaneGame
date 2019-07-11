package com.terena.xust.shootgame;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 * 天空类:飞行物
 * @author 周蔚
 *
 */
public class Sky extends FlyingObject{
	
	//定义背景切换条件
	public static int turnSky =0;
	//定义背景图
	private static BufferedImage images[]=new BufferedImage[3];
	//静态代码块 用于加载图片资源
	static {
		images[0] = loadImage("backfround.jpg");
		images[1] = loadImage("backfround2.jpg");
		images[2] = loadImage("sky2.jpg");
		//image = loadImage("back.png");
	}
	
	/*属性*/
	private int speed;//坐标增量
	private int y1;//用于两张图片的切换
	

	public Sky() {
		super(ShootGameJPanel.WIDTH,ShootGameJPanel.HEIGHT,0,0);
		speed = 1;
		y1 = -this.height;
		
	}
	
	
	
	/*天空的移动*/
	@Override
	public void step() {
		y += speed;//向下
		y1 += speed;//同时向下
		//当y大于窗体下沿时
		if(y >= ShootGameJPanel.HEIGHT) {
			//将y设置到y1的初始位置
			y = -ShootGameJPanel.HEIGHT;
		}
		if(y1 >= ShootGameJPanel.HEIGHT) {
			y1 = -ShootGameJPanel.HEIGHT;
		}
		
		
	}
	
	@Override
	public BufferedImage getImage() {
		
		switch(turnSky) {
		case 0:return images[0];
		case 1:return images[1];
		case 2:return images[2];
		
		}
		return null;
		
	}
	
	/*检测天空是否越界*/
	@Override
	public boolean outOfBounds() {
		return false;
	
	}
	
	/*重写父类方法*/
	@Override
	public void paintObject(Graphics g) {
	
		g.drawImage(getImage(), x, y, 400,700,null);
		g.drawImage(getImage(), x, y1, 400,700,null);
		
	}
	
	
	
}
