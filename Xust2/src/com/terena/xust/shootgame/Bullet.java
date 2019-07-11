package com.terena.xust.shootgame;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 * �ӵ���:�Ƿ�����
 * @author ��ε
 *
 */
public class Bullet extends FlyingObject {

	/*����ͼƬ*/
	public static BufferedImage images[];
	
	//�����ӵ�ͼƬ���ֻ�����
	public static int turnBullet = 0;	
	/*��̬��������ͼƬ*/
	static {
		images = new BufferedImage[3];
		images[0] = loadImage("bullet3.png");
		images[1] = loadImage("bullet5.png");
		images[2] = loadImage("bullet6.png");
		//image = loadImage("basketball.png");
		
	}
	
	/*����y���������*/
	public static int speed;
	
	
	/*���췽��*/
	public Bullet(int x,int y) {
		super(8,14,x,y);
		speed = 10;
	}

	/*�ӵ����ƶ�*/
	@Override
	public void step() {
		y -= speed;//y-����
		
	}

	/*��дgetImage��ȡͼƬ*/
	@Override
	public BufferedImage getImage() {
		if(isLife()) {
			
			switch(turnBullet) {
			case 0: return images[0];
			case 1: return images[1];
			case 2: return images[2];
			
			}
			
		}
		else if(isDead()){
			state = REMOVE; //��״̬�޸�Ϊɾ��
		}
		
		return null;
	}

	/*�ж��ӵ��Ƿ�Խ��*/
	@Override
	public boolean outOfBounds() {
		
		return this.y <= -this.height;//�ӵ���y<=�����ӵ��ĸ�
	}
	
	public void paintObject(Graphics g) {
		g.drawImage(getImage(), x, y, 30,30,null);
		

	}
	
	
}
