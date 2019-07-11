package com.terena.xust.shootgame;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 * 英雄机
 * @author 周蔚
 *
 */
public class Hero extends FlyingObject{
	/*定义图片集*/
	private static BufferedImage[] images;
	
	/*静态代码块加载图片*/
	static {
		
		images = new BufferedImage[2];
		for (int i = 0; i < images.length; i++) {
			images[i] = loadImage("hero"+".png");
			//images[i] = loadImage("man"+i+".png");
		}
	}
	
	
	
	/*定义生命值*/
	private int life;
	/*定义双倍火力*/
	private int doubleFire;
	
	/*构造方法*/
	public Hero() {
		super(97,124,150,400);
		life = 3;
		doubleFire = 0; //默认为单倍
	}
	
	
	/*英雄机随着鼠标移动，x,y为鼠标的x y坐标*/
	public void moveTo(int x, int y) {
		
		this.x = x - this.width / 2;
		this.y = y - this.height / 2;
		
		
	}


	@Override
	public void step() {
		//不需要添加内容 英雄机随着鼠标移动
	}


int index = 0;//活着的下标
	
	/*重写的getImage方法*/
	@Override
	public BufferedImage getImage() {
		if(isLife()) {//如果活着
			if(index == 20) index=0;
			index += 5;
			return images[index / 20];
			/*
			 * 活着的：定时器
			 * 10ms 返回值images[0]
			 * 20ms 返回值images[1]
			 * 30ms 返回值images[0]
			 * 40ms 返回值images[1]
			 */
		}
		return null;
	}

	//控制子弹的个数
	public static int fire=0;
	
	
	/*英雄机发射子弹算法*/
	public Bullet[] shoot() {
		//四分之一英雄机的宽
		int xStep = this.width / 4;
		int yStep = 20;//固定的20
		switch(fire) {
		case 1:
		{	Bullet[] bs = new Bullet[1];		
			bs[0] = new Bullet(this.x + 1*xStep, this.y - yStep);
			
			return bs;
		} //单倍火力
		case 2:
		{
			//子弹匣2束子弹
			Bullet[] bs = new Bullet[2];
			//x:英雄机宽度1/4处，y:英雄机之上20处
			bs[0] = new Bullet(this.x + 1*xStep, this.y - yStep);
			//x：英雄机宽度3/4处，y：英雄机之上20处
			bs[1] = new Bullet(this.x + 3*xStep, this.y - yStep);
			
			return bs;
		} //双倍火力
		
		case 3:
		{
			//子弹匣2束子弹
			Bullet[] bs = new Bullet[3];
			//x:英雄机宽度1/4处，y:英雄机之上20处
			bs[0] = new Bullet(this.x + 1*xStep, this.y - yStep);
			//x：英雄机宽度3/4处，y：英雄机之上20处
			bs[1] = new Bullet(this.x + 3*xStep, this.y - yStep);
			bs[2] = new Bullet(this.x + 2*xStep, this.y - yStep-10);
			
			return bs;
		}//3倍火力
		
		case 4:
		{
			//子弹匣2束子弹
			Bullet[] bs = new Bullet[4];
			//x:英雄机宽度1/4处，y:英雄机之上20处
			bs[0] = new Bullet(this.x + 1*xStep, this.y - yStep);
			//x：英雄机宽度3/4处，y：英雄机之上20处
			bs[1] = new Bullet(this.x + 3*xStep, this.y - yStep);
			bs[2] = new Bullet(this.x + 2*xStep, this.y - yStep-10);
			
			return bs;
			
			
			
		}//4倍火力 先不写
		
		case 5:
		{
			if(doubleFire > 0) {
				//子弹匣2束子弹
				Bullet[] bs = new Bullet[2];
				//x:英雄机宽度1/4处，y:英雄机之上20处
				bs[0] = new Bullet(this.x + 1*xStep, this.y - yStep);
				//x：英雄机宽度3/4处，y：英雄机之上20处
				bs[1] = new Bullet(this.x + 3*xStep, this.y - yStep);
				//添加逻辑，英雄机没发射一次双倍火力，则火力减2
				doubleFire -= 2;
				return bs;
			}
			
			
		}break;//蜜蜂奖励
		
		
		}
		return null;
	
	}
	
	@Override
	public boolean outOfBounds() {
		// TODO 自动生成的方法存根
		return false;
	}
	
	/*英雄机增命*/
	public void addLife() {
		life ++;
	}
	
	/*获取英雄机的命*/
	public int getLife() {
		return life;
	}
	
	/*英雄机减少命*/
	public void subtractLife() {
		life --;
	}
	
	/*英雄机增加火力*/
	public void addDoubleFire() {
		doubleFire += 40;//火力值增加40
	}
	
	/*火力清零*/
	public void clearDoubleFire() {
		doubleFire = 0;//火力值归零
	}
	
	public void paintObject(Graphics g) {
		g.drawImage(getImage(), x, y, 60,60,null);
		

	}
	

}
