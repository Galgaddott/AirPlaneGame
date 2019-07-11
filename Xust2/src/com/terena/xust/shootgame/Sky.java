package com.terena.xust.shootgame;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 * �����:������
 * @author ��ε
 *
 */
public class Sky extends FlyingObject{
	
	//���屳���л�����
	public static int turnSky =0;
	//���屳��ͼ
	private static BufferedImage images[]=new BufferedImage[3];
	//��̬����� ���ڼ���ͼƬ��Դ
	static {
		images[0] = loadImage("backfround.jpg");
		images[1] = loadImage("backfround2.jpg");
		images[2] = loadImage("sky2.jpg");
		//image = loadImage("back.png");
	}
	
	/*����*/
	private int speed;//��������
	private int y1;//��������ͼƬ���л�
	

	public Sky() {
		super(ShootGameJPanel.WIDTH,ShootGameJPanel.HEIGHT,0,0);
		speed = 1;
		y1 = -this.height;
		
	}
	
	
	
	/*��յ��ƶ�*/
	@Override
	public void step() {
		y += speed;//����
		y1 += speed;//ͬʱ����
		//��y���ڴ�������ʱ
		if(y >= ShootGameJPanel.HEIGHT) {
			//��y���õ�y1�ĳ�ʼλ��
			y = -ShootGameJPanel.HEIGHT;
		}
		if(y1 >= ShootGameJPanel.HEIGHT) {
			y1 = -ShootGameJPanel.HEIGHT;
		}
		
		
	}
	
	@Override
	public BufferedImage getImage() {
		
		switch(turnSky) {
		case 0:return images[0];
		case 1:return images[1];
		case 2:return images[2];
		
		}
		return null;
		
	}
	
	/*�������Ƿ�Խ��*/
	@Override
	public boolean outOfBounds() {
		return false;
	
	}
	
	/*��д���෽��*/
	@Override
	public void paintObject(Graphics g) {
	
		g.drawImage(getImage(), x, y, 400,700,null);
		g.drawImage(getImage(), x, y1, 400,700,null);
		
	}
	
	
	
}
