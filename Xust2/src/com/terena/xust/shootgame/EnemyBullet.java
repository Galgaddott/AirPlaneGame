package com.terena.xust.shootgame;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 * �л����ӵ���
 * @author ��ε
 *
 */
public class EnemyBullet extends FlyingObject {


	/*����ͼƬ*/
	public static BufferedImage image;
	/*��̬��������ͼƬ*/
	static {
		image = loadImage("bullet1.png");
		
		
	}
	
	/*����y���������*/
	public static int speed;
	
	
	/*���췽��*/
	public EnemyBullet(int x,int y) {
		super(8,14,x,y);
		speed = 3;
	}

	/*�ӵ����ƶ�*/
	@Override
	public void step() {
		y += speed;//�����ƶ�
		
	}

	/*��дgetImage��ȡͼƬ*/
	@Override
	public BufferedImage getImage() {
		if(isLife()) {
			return image;
			
		}
		else if(isDead()){
			state = REMOVE; //��״̬�޸�Ϊɾ��
		}
		
		return null;
	}

	/*�ж��ӵ��Ƿ�Խ��*/
	@Override
	public boolean outOfBounds() {
		
		return this.y >= 700;// ���ڴ���ĸ߾���Խ��
	}
	
	public void paintObject(Graphics g) {
		g.drawImage(getImage(), x, y, 20,20,null);
		

	}
	
	
	
	
	
	
	
}
