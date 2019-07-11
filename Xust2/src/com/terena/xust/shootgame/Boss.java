package com.terena.xust.shootgame;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Boss extends FlyingObject implements Enemy{

	/*定义图片集*/
	private static BufferedImage[] images;
	
	public static int life = 10;
	
	/*静态代码块加载图片*/
	static {
		images = new BufferedImage[5];
		for (int i = 0; i < images.length; i++) {
			if(i == 0) {
			images[i] = loadImage("boss"+".png"); 
			}
			else images[i]= loadImage("enemy1"+i+".png");
		
		}
		
	}
	
	/*定义坐标增量*/
	public static int speed;
	
	/*构造方法*/
	public  Boss() {
		super(69,99);
		speed = 1;
		
	}
	
	@Override
	public int getScore() {
		
		return 2;
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
		g.drawImage(getImage(), x, y,150,150,null);
		

	}
	
	/*英雄机发射子弹算法*/
	public BossBullet[] BossShoot() {
		//四分之一敌机的宽
		int xStep = this.width / 4;
		int yStep = 20;//固定的20
		
			BossBullet[] bss = new BossBullet[1];
		
			bss[0] = new BossBullet(this.x + 2*xStep, this.y +this.height+yStep);
			
			return bss;
		
	}
	
	/*敌机发射子弹算法*/
	public EnemyBullet[] EnemyShoot() {

					return null;
	}
	
	public void Delife() {
		life-=2;
		
	}
	
	
}
