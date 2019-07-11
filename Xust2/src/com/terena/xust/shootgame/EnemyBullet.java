package com.terena.xust.shootgame;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 * 敌机的子弹类
 * @author 周蔚
 *
 */
public class EnemyBullet extends FlyingObject {


	/*定义图片*/
	public static BufferedImage image;
	/*静态代码块加载图片*/
	static {
		image = loadImage("bullet1.png");
		
		
	}
	
	/*定义y坐标的增量*/
	public static int speed;
	
	
	/*构造方法*/
	public EnemyBullet(int x,int y) {
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
		g.drawImage(getImage(), x, y, 20,20,null);
		

	}
	
	
	
	
	
	
	
}
