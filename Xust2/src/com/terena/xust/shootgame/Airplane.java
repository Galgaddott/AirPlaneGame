package com.terena.xust.shootgame;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 * С�л��࣬�������ܵ÷�
 * @author ��ε
 *
 */
public class Airplane extends FlyingObject implements Enemy {
	
	/*����С�л�ͼƬ��*/
	private static BufferedImage[] images;
	
	/*��̬�Ĵ�������ͼƬ*/
	
	static {
		
		images = new BufferedImage[5];
		
		for (int i = 0; i < images.length; i++) {
		
			images[i] = loadImage("enemy2"+".png");
		}
		
	}
	
	/*������������*/
	public static  int speed;
	
	/*���췽��*/
	public Airplane() {
		super(49,36);
		speed = 4;
		
	}
	/*�����±�-���˵��±�*/
	int deadIndex = 1;
	
	/*С�л������÷�*/
	@Override
	public int getScore() {
	
		return 1;
	}
	
	/*С�л��ƶ�*/
	@Override
	public void step() {
		y += speed;
		
	}
	
	/*��д����*/
	@Override
	public BufferedImage getImage() {
		//ÿ10ms��һ��--��ʱ��
		if(isLife()) { //�ж��Ƿ����
			return images[0];
		}
		else if(isDead()) {
			BufferedImage img = images[deadIndex++];
			
			//if(deadIndex == 3) {
				//����ͼƬ�����һ��
				state = REMOVE;
				
			//}
			return img;
		}
		
		/*���˵ģ�
		 * 10ms img=images[1] deadIndex=2
		 * 20ms img=images[2] deadIndex=3
		 * .....
		 * 40ms img=images[4] deadIndex=5(REMOVE)
		 * */
		return null;
	}
	
	/*���С�л��Ƿ�Խ��*/
	@Override
	public boolean outOfBounds() {
		
		return this.y >= ShootGameJPanel.HEIGHT;
	}
	
	public void paintObject(Graphics g) {
		g.drawImage(getImage(), x, y,50,50,null);
		

	}
	
	/*Ӣ�ۻ������ӵ��㷨*/
	public EnemyBullet[] EnemyShoot() {
		//�ķ�֮һ�л��Ŀ�
		int xStep = this.width / 4;
		int yStep = 20;//�̶���20
		
			//�ӵ�ϻ2���ӵ�
			EnemyBullet[] bs = new EnemyBullet[1];
			//x:Ӣ�ۻ����1/4����y:Ӣ�ۻ�֮��20��
			bs[0] = new EnemyBullet(this.x + 1*xStep, this.y +this.height+yStep);
			return bs;
		
	}
	
	
	
}
