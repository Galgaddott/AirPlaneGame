package com.terena.xust.shootgame;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 * 大敌机:飞行物 可以得分
 * @author 周蔚
 *
 */
public class BigAirplane extends FlyingObject implements Enemy{
	



	/*定义图片集*/
	private static BufferedImage[] images;
	
	/*静态代码块加载图片*/
	static {
		images = new BufferedImage[5];
		for (int i = 0; i < images.length; i++) {
			
			if(i == 4) {images[i]=  loadImage("enemy1"+3+".png");}
			else
			images[i] = loadImage("enemy1"+i+".png"); 
		
		}
		
	}
	
	/*定义坐标增量*/
	public static int speed;
	
	/*构造方法*/
	public  BigAirplane() {
		super(69,99);
		speed = 3;
		
	}
	
	@Override
	public int getScore() {
		
		return 3;
	}
	
	@Override
	public void step() {
		// TODO Auto-generated method stub
		y += speed;
	}
	/*定义死了的下标*/
	int deadIndex = 1;
	
	
	
	@Override
	public BufferedImage getImage() {
		//每10ms走一次--定时器
				if(isLife()) {
					return images[0];
				} else if (isDead()) {
					//从第二张开始进行轮转
					BufferedImage img = images[deadIndex++];
					//if(deadIndex == 3) {
						state = REMOVE;
					//}
					return img;
					
				}
				
				return null;
	
	}

	/*判断大敌机是否越界*/
	@Override
	public boolean outOfBounds() {
		
		 return this.y >= ShootGameJPanel.HEIGHT;
	}
	
	public void paintObject(Graphics g) {
		g.drawImage(getImage(), x, y,100,100,null);
		

	}
	
	/*英雄机发射子弹算法*/
	public EnemyBullet[] EnemyShoot() {
		//四分之一敌机的宽
		int xStep = this.width / 4;
		int yStep = 20;//固定的20
		
			//子弹匣2束子弹
			EnemyBullet[] bs = new EnemyBullet[2];
			//x:英雄机宽度1/4处，y:英雄机之上20处
			bs[0] = new EnemyBullet(this.x + 1*xStep, this.y +this.height+yStep);
			//x：英雄机宽度3/4处，y：英雄机之上20处
			bs[1] = new EnemyBullet(this.x + 3*xStep, this.y +this.height+ yStep);
			//添加逻辑，英雄机没发射一次双倍火力，则火力减2
			
			return bs;
		
	}
	
	
	
	
	
}
