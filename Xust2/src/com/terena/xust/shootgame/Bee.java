package com.terena.xust.shootgame;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * 小蜜蜂;飞行物 奖励
 * @author 周蔚
 *
 */
public class Bee extends FlyingObject implements Award {
	
	/*定义图片集*/
	private static BufferedImage[] images;
	/*静态代码块加载图片*/
	static {
		images = new BufferedImage[5];
		for (int i = 0; i < images.length; i++) {
			images[i] = loadImage("bee2"+".png"); 
		}
		
		
	}
	
	private int xSpeed;//x坐标增量
	private int ySpeed;//y坐标增量
	private int awardType;//奖励类型(0或1)
	
	/*构造方法*/
	public Bee() {
		super(60,50);
		xSpeed = 3;
		ySpeed = 5;
		Random rand =new Random();
		awardType = rand.nextInt(2);
	}
	
	/*重写奖励类型*/
	@Override
	public int getAwardType() {
		
		return awardType;
	}

	/*蜜蜂的移动*/
	@Override
	public void step() {
		x += xSpeed;
		y += ySpeed;
		//碰撞到左右边界
		if(x<=0 || x>= ShootGameJPanel.WIDTH - this.width) {
			xSpeed *= -1;
		}
		
	}
	
	/*定义死了的下标*/
	int deadIndex = 1;
	
	
	/*获取图片*/
	@Override
	public BufferedImage getImage() {
		//每10ms走一次--定时器
		if(isLife()) {
			return images[0];
		} else if (isDead()) {
			//从第二张开始进行轮转
			BufferedImage img = images[deadIndex++];
			//if(deadIndex == images.length) {
				state = REMOVE;
			//}
			return img;
			
		}
		
		return null;
	}
	
	
	/*检测小蜜蜂是否越界*/
	@Override
	public boolean outOfBounds() {
		
		return this.y >= ShootGameJPanel.HEIGHT;
	}
	
	
	/*画对象 g:画笔*/
	public void paintObject(Graphics g) {
		g.drawImage(getImage(), x, y,50,50,null);
		

	}
	
	/*英雄机发射子弹算法*/
	public EnemyBullet[] EnemyShoot() {
		
		
			//子弹匣2束子弹
			EnemyBullet[] bs = new EnemyBullet[0];
			
			
			return bs;
		
	}
	
	
	
	
	
	
}
