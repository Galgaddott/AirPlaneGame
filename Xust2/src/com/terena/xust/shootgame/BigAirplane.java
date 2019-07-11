package com.terena.xust.shootgame;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 * ��л�:������ ���Ե÷�
 * @author ��ε
 *
 */
public class BigAirplane extends FlyingObject implements Enemy{
	



	/*����ͼƬ��*/
	private static BufferedImage[] images;
	
	/*��̬��������ͼƬ*/
	static {
		images = new BufferedImage[5];
		for (int i = 0; i < images.length; i++) {
			
			if(i == 4) {images[i]=  loadImage("enemy1"+3+".png");}
			else
			images[i] = loadImage("enemy1"+i+".png"); 
		
		}
		
	}
	
	/*������������*/
	public static int speed;
	
	/*���췽��*/
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
		g.drawImage(getImage(), x, y,100,100,null);
		

	}
	
	/*Ӣ�ۻ������ӵ��㷨*/
	public EnemyBullet[] EnemyShoot() {
		//�ķ�֮һ�л��Ŀ�
		int xStep = this.width / 4;
		int yStep = 20;//�̶���20
		
			//�ӵ�ϻ2���ӵ�
			EnemyBullet[] bs = new EnemyBullet[2];
			//x:Ӣ�ۻ����1/4����y:Ӣ�ۻ�֮��20��
			bs[0] = new EnemyBullet(this.x + 1*xStep, this.y +this.height+yStep);
			//x��Ӣ�ۻ����3/4����y��Ӣ�ۻ�֮��20��
			bs[1] = new EnemyBullet(this.x + 3*xStep, this.y +this.height+ yStep);
			//����߼���Ӣ�ۻ�û����һ��˫���������������2
			
			return bs;
		
	}
	
	
	
	
	
}
