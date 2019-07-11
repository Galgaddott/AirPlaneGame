package com.terena.xust.shootgame;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.management.RuntimeErrorException;

/**
 * 
 * 飞行物的抽象类
 * 包含飞行物所共有的属性 构造方法 自定义方法
 * 
 * @author 周蔚
 *
 */
public abstract class FlyingObject {
		
	/*定义飞行物基本属性*/
	public static final int LIFE = 0 ;//
	public static final int DEAD = 1 ;//
	public static final int  REMOVE = 2;//
	public int state = LIFE ;
	
	/*飞行物的宽高及 x y坐标*/
	
	protected int width;//宽
	protected int height;//高
	protected int x;
	protected int y;
	
	/*提供特定的构造方法:
	 * 两种：
	 * 1.英雄机 天空 子弹
	 * 2.大小敌机和蜜蜂提供
	 * 
	 * */
	
	/*专门为英雄机 天空 子弹提供的构造方法*/
	public FlyingObject(int width,int height,int x,int y) {
		
		this.width = width;
		this.height = height;
		this.x = x;
		this.y = y;
		
		
	}
	
	/*专门大小敌机和蜜蜂提供的构造方法*/
	public FlyingObject(int width,int height) {
		
		this.width = width ;
		this.height = height;
		Random rand =new Random();
		/*设置飞行物的x y 坐标*/
		x = rand.nextInt(ShootGameJPanel.WIDTH - this.width);
		y = -this.height;
		
	}
	
	/*获取图片*/
	
	public static BufferedImage loadImage( String fileName) {
		try {
			//同包中读取图片
			BufferedImage img=ImageIO.read(FlyingObject.class.getResource(fileName));
			return img;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		}
		
	}
	
	
	/*飞行物移动*/
	public abstract void step();
	/*获取图片*/
	public abstract BufferedImage getImage();
	/*判断是否活着*/
	public boolean isLife() {
		return state == LIFE ;
	}
	
	/*判断是否死了*/
	public boolean isDead() {
		return state == DEAD;
		
	}
	
	/*判断是否删除*/
	
	public boolean isRemove() {
		
		return state == REMOVE;
	}
	
	
	/*画对象 g:画笔*/
	public void paintObject(Graphics g) {
		g.drawImage(getImage(), x, y,60,60,null);
		

	}
	
	/*检测飞行物是否越界*/
	public abstract boolean outOfBounds();
	
	/*碰撞算法 this：敌人  other：子弹 英雄机*/
	public boolean hit(FlyingObject other) {
		//x1:敌人的x-子弹的宽
		int x1 = this.x - other.width;
		//x2:敌人的x+敌人的宽
		int x2 = this.x + this.width;
		//y1:敌人的y-子弹的高
		int y1 = this.y - other.height;
		//y2:敌人的y+敌人的高
		int y2 = this.y + this.height;
		int x = other.x;
		int y = other.y;
		
		//x在x1与x2之间且y在y1与y2之间则为撞上
		return x >= x1 && x<= x2 && y>= y1 && y<= y2 ;
		
		
	}

	
	/*飞行物消除*/
	
	public void goDead() {
		
		state = DEAD;
		//将对象的状态修改为DEAD(死了的，但还没有删除)
	}
	

	/*敌机发射子弹算法*/
	public EnemyBullet[] EnemyShoot() {

					return null;
	}
	
	
	
	
	
	
	
}
