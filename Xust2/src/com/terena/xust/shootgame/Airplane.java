package com.terena.xust.shootgame;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 * 小敌机类，飞行物能得分
 * @author 周蔚
 *
 */
public class Airplane extends FlyingObject implements Enemy {
	
	/*定义小敌机图片集*/
	private static BufferedImage[] images;
	
	/*静态的代码块加载图片*/
	
	static {
		
		images = new BufferedImage[5];
		
		for (int i = 0; i < images.length; i++) {
		
			images[i] = loadImage("enemy2"+".png");
		}
		
	}
	
	/*属性坐标增量*/
	public static  int speed;
	
	/*构造方法*/
	public Airplane() {
		super(49,36);
		speed = 4;
		
	}
	/*定义下标-死了的下标*/
	int deadIndex = 1;
	
	/*小敌机死亡得分*/
	@Override
	public int getScore() {
	
		return 1;
	}
	
	/*小敌机移动*/
	@Override
	public void step() {
		y += speed;
		
	}
	
	/*重写方法*/
	@Override
	public BufferedImage getImage() {
		//每10ms走一次--定时器
		if(isLife()) { //判断是否活着
			return images[0];
		}
		else if(isDead()) {
			BufferedImage img = images[deadIndex++];
			
			//if(deadIndex == 3) {
				//若到图片的最后一张
				state = REMOVE;
				
			//}
			return img;
		}
		
		/*死了的：
		 * 10ms img=images[1] deadIndex=2
		 * 20ms img=images[2] deadIndex=3
		 * .....
		 * 40ms img=images[4] deadIndex=5(REMOVE)
		 * */
		return null;
	}
	
	/*检测小敌机是否越界*/
	@Override
	public boolean outOfBounds() {
		
		return this.y >= ShootGameJPanel.HEIGHT;
	}
	
	public void paintObject(Graphics g) {
		g.drawImage(getImage(), x, y,50,50,null);
		

	}
	
	/*英雄机发射子弹算法*/
	public EnemyBullet[] EnemyShoot() {
		//四分之一敌机的宽
		int xStep = this.width / 4;
		int yStep = 20;//固定的20
		
			//子弹匣2束子弹
			EnemyBullet[] bs = new EnemyBullet[1];
			//x:英雄机宽度1/4处，y:英雄机之上20处
			bs[0] = new EnemyBullet(this.x + 1*xStep, this.y +this.height+yStep);
			return bs;
		
	}
	
	
	
}
