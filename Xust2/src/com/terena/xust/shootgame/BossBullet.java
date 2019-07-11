package com.terena.xust.shootgame;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class BossBullet extends FlyingObject{

	/*定义图片*/
	public static BufferedImage image;
	/*静态代码块加载图片*/
	static {
		image = loadImage("bossBullett.png");
		
		
	}
	
	/*定义y坐标的增量*/
	public static int speed;
	
	
	/*构造方法*/
	public BossBullet(int x,int y) {
		super(8,14,x,y);
		speed = 3;
	}

	/*子弹的移动*/
	@Override
	public void step() {
		y += speed;//向下移动
		
	}

	/*重写getImage获取图片*/
	@Override
	public BufferedImage getImage() {
		if(isLife()) {
			return image;
			
		}
		else if(isDead()){
			state = REMOVE; //将状态修改为删除
		}
		
		return null;
	}

	/*判断子弹是否越界*/
	@Override
	public boolean outOfBounds() {
		
		return this.y >= 700;// 大于窗体的高就是越界
	}
	
	public void paintObject(Graphics g) {
		g.drawImage(getImage(), x, y, 100,60,null);
		

	}
	
	
	
}
