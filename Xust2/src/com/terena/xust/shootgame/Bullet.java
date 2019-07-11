package com.terena.xust.shootgame;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 * 子弹类:是飞行物
 * @author 周蔚
 *
 */
public class Bullet extends FlyingObject {

	/*定义图片*/
	public static BufferedImage images[];
	
	//定义子弹图片的轮换条件
	public static int turnBullet = 0;	
	/*静态代码块加载图片*/
	static {
		images = new BufferedImage[3];
		images[0] = loadImage("bullet3.png");
		images[1] = loadImage("bullet5.png");
		images[2] = loadImage("bullet6.png");
		//image = loadImage("basketball.png");
		
	}
	
	/*定义y坐标的增量*/
	public static int speed;
	
	
	/*构造方法*/
	public Bullet(int x,int y) {
		super(8,14,x,y);
		speed = 10;
	}

	/*子弹的移动*/
	@Override
	public void step() {
		y -= speed;//y-向上
		
	}

	/*重写getImage获取图片*/
	@Override
	public BufferedImage getImage() {
		if(isLife()) {
			
			switch(turnBullet) {
			case 0: return images[0];
			case 1: return images[1];
			case 2: return images[2];
			
			}
			
		}
		else if(isDead()){
			state = REMOVE; //将状态修改为删除
		}
		
		return null;
	}

	/*判断子弹是否越界*/
	@Override
	public boolean outOfBounds() {
		
		return this.y <= -this.height;//子弹的y<=负的子弹的高
	}
	
	public void paintObject(Graphics g) {
		g.drawImage(getImage(), x, y, 30,30,null);
		

	}
	
	
}
