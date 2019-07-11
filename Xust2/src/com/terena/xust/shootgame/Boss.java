package com.terena.xust.shootgame;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Boss extends FlyingObject implements Enemy{

	/*����ͼƬ��*/
	private static BufferedImage[] images;
	
	public static int life = 10;
	
	/*��̬��������ͼƬ*/
	static {
		images = new BufferedImage[5];
		for (int i = 0; i < images.length; i++) {
			if(i == 0) {
			images[i] = loadImage("boss"+".png"); 
			}
			else images[i]= loadImage("enemy1"+i+".png");
		
		}
		
	}
	
	/*������������*/
	public static int speed;
	
	/*���췽��*/
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
	/*�������˵��±�*/
	int deadIndex = 1;
	
	
	
	@Override
	public BufferedImage getImage() {
		//ÿ10ms��һ��--��ʱ��
				if(isLife()) {
					return images[0];
				} else if (isDead()) {
					//�ӵڶ��ſ�ʼ������ת
					BufferedImage img = images[deadIndex++];
					//if(deadIndex == 3) {
						state = REMOVE;
					//}
					return img;
					
				}
				
				return null;
	
	}

	/*�жϴ�л��Ƿ�Խ��*/
	@Override
	public boolean outOfBounds() {
		
		 return this.y >= ShootGameJPanel.HEIGHT;
	}
	
	public void paintObject(Graphics g) {
		g.drawImage(getImage(), x, y,150,150,null);
		

	}
	
	/*Ӣ�ۻ������ӵ��㷨*/
	public BossBullet[] BossShoot() {
		//�ķ�֮һ�л��Ŀ�
		int xStep = this.width / 4;
		int yStep = 20;//�̶���20
		
			BossBullet[] bss = new BossBullet[1];
		
			bss[0] = new BossBullet(this.x + 2*xStep, this.y +this.height+yStep);
			
			return bss;
		
	}
	
	/*�л������ӵ��㷨*/
	public EnemyBullet[] EnemyShoot() {

					return null;
	}
	
	public void Delife() {
		life-=2;
		
	}
	
	
}
