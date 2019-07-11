package com.terena.xust.shootgame;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * С�۷�;������ ����
 * @author ��ε
 *
 */
public class Bee extends FlyingObject implements Award {
	
	/*����ͼƬ��*/
	private static BufferedImage[] images;
	/*��̬��������ͼƬ*/
	static {
		images = new BufferedImage[5];
		for (int i = 0; i < images.length; i++) {
			images[i] = loadImage("bee2"+".png"); 
		}
		
		
	}
	
	private int xSpeed;//x��������
	private int ySpeed;//y��������
	private int awardType;//��������(0��1)
	
	/*���췽��*/
	public Bee() {
		super(60,50);
		xSpeed = 3;
		ySpeed = 5;
		Random rand =new Random();
		awardType = rand.nextInt(2);
	}
	
	/*��д��������*/
	@Override
	public int getAwardType() {
		
		return awardType;
	}

	/*�۷���ƶ�*/
	@Override
	public void step() {
		x += xSpeed;
		y += ySpeed;
		//��ײ�����ұ߽�
		if(x<=0 || x>= ShootGameJPanel.WIDTH - this.width) {
			xSpeed *= -1;
		}
		
	}
	
	/*�������˵��±�*/
	int deadIndex = 1;
	
	
	/*��ȡͼƬ*/
	@Override
	public BufferedImage getImage() {
		//ÿ10ms��һ��--��ʱ��
		if(isLife()) {
			return images[0];
		} else if (isDead()) {
			//�ӵڶ��ſ�ʼ������ת
			BufferedImage img = images[deadIndex++];
			//if(deadIndex == images.length) {
				state = REMOVE;
			//}
			return img;
			
		}
		
		return null;
	}
	
	
	/*���С�۷��Ƿ�Խ��*/
	@Override
	public boolean outOfBounds() {
		
		return this.y >= ShootGameJPanel.HEIGHT;
	}
	
	
	/*������ g:����*/
	public void paintObject(Graphics g) {
		g.drawImage(getImage(), x, y,50,50,null);
		

	}
	
	/*Ӣ�ۻ������ӵ��㷨*/
	public EnemyBullet[] EnemyShoot() {
		
		
			//�ӵ�ϻ2���ӵ�
			EnemyBullet[] bs = new EnemyBullet[0];
			
			
			return bs;
		
	}
	
	
	
	
	
	
}
