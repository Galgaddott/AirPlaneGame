package com.terena.xust.shootgame;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 * Ӣ�ۻ�
 * @author ��ε
 *
 */
public class Hero extends FlyingObject{
	/*����ͼƬ��*/
	private static BufferedImage[] images;
	
	/*��̬��������ͼƬ*/
	static {
		
		images = new BufferedImage[2];
		for (int i = 0; i < images.length; i++) {
			images[i] = loadImage("hero"+".png");
			//images[i] = loadImage("man"+i+".png");
		}
	}
	
	
	
	/*��������ֵ*/
	private int life;
	/*����˫������*/
	private int doubleFire;
	
	/*���췽��*/
	public Hero() {
		super(97,124,150,400);
		life = 3;
		doubleFire = 0; //Ĭ��Ϊ����
	}
	
	
	/*Ӣ�ۻ���������ƶ���x,yΪ����x y����*/
	public void moveTo(int x, int y) {
		
		this.x = x - this.width / 2;
		this.y = y - this.height / 2;
		
		
	}


	@Override
	public void step() {
		//����Ҫ������� Ӣ�ۻ���������ƶ�
	}


int index = 0;//���ŵ��±�
	
	/*��д��getImage����*/
	@Override
	public BufferedImage getImage() {
		if(isLife()) {//�������
			if(index == 20) index=0;
			index += 5;
			return images[index / 20];
			/*
			 * ���ŵģ���ʱ��
			 * 10ms ����ֵimages[0]
			 * 20ms ����ֵimages[1]
			 * 30ms ����ֵimages[0]
			 * 40ms ����ֵimages[1]
			 */
		}
		return null;
	}

	//�����ӵ��ĸ���
	public static int fire=0;
	
	
	/*Ӣ�ۻ������ӵ��㷨*/
	public Bullet[] shoot() {
		//�ķ�֮һӢ�ۻ��Ŀ�
		int xStep = this.width / 4;
		int yStep = 20;//�̶���20
		switch(fire) {
		case 1:
		{	Bullet[] bs = new Bullet[1];		
			bs[0] = new Bullet(this.x + 1*xStep, this.y - yStep);
			
			return bs;
		} //��������
		case 2:
		{
			//�ӵ�ϻ2���ӵ�
			Bullet[] bs = new Bullet[2];
			//x:Ӣ�ۻ����1/4����y:Ӣ�ۻ�֮��20��
			bs[0] = new Bullet(this.x + 1*xStep, this.y - yStep);
			//x��Ӣ�ۻ����3/4����y��Ӣ�ۻ�֮��20��
			bs[1] = new Bullet(this.x + 3*xStep, this.y - yStep);
			
			return bs;
		} //˫������
		
		case 3:
		{
			//�ӵ�ϻ2���ӵ�
			Bullet[] bs = new Bullet[3];
			//x:Ӣ�ۻ����1/4����y:Ӣ�ۻ�֮��20��
			bs[0] = new Bullet(this.x + 1*xStep, this.y - yStep);
			//x��Ӣ�ۻ����3/4����y��Ӣ�ۻ�֮��20��
			bs[1] = new Bullet(this.x + 3*xStep, this.y - yStep);
			bs[2] = new Bullet(this.x + 2*xStep, this.y - yStep-10);
			
			return bs;
		}//3������
		
		case 4:
		{
			//�ӵ�ϻ2���ӵ�
			Bullet[] bs = new Bullet[4];
			//x:Ӣ�ۻ����1/4����y:Ӣ�ۻ�֮��20��
			bs[0] = new Bullet(this.x + 1*xStep, this.y - yStep);
			//x��Ӣ�ۻ����3/4����y��Ӣ�ۻ�֮��20��
			bs[1] = new Bullet(this.x + 3*xStep, this.y - yStep);
			bs[2] = new Bullet(this.x + 2*xStep, this.y - yStep-10);
			
			return bs;
			
			
			
		}//4������ �Ȳ�д
		
		case 5:
		{
			if(doubleFire > 0) {
				//�ӵ�ϻ2���ӵ�
				Bullet[] bs = new Bullet[2];
				//x:Ӣ�ۻ����1/4����y:Ӣ�ۻ�֮��20��
				bs[0] = new Bullet(this.x + 1*xStep, this.y - yStep);
				//x��Ӣ�ۻ����3/4����y��Ӣ�ۻ�֮��20��
				bs[1] = new Bullet(this.x + 3*xStep, this.y - yStep);
				//����߼���Ӣ�ۻ�û����һ��˫���������������2
				doubleFire -= 2;
				return bs;
			}
			
			
		}break;//�۷佱��
		
		
		}
		return null;
	
	}
	
	@Override
	public boolean outOfBounds() {
		// TODO �Զ����ɵķ������
		return false;
	}
	
	/*Ӣ�ۻ�����*/
	public void addLife() {
		life ++;
	}
	
	/*��ȡӢ�ۻ�����*/
	public int getLife() {
		return life;
	}
	
	/*Ӣ�ۻ�������*/
	public void subtractLife() {
		life --;
	}
	
	/*Ӣ�ۻ����ӻ���*/
	public void addDoubleFire() {
		doubleFire += 40;//����ֵ����40
	}
	
	/*��������*/
	public void clearDoubleFire() {
		doubleFire = 0;//����ֵ����
	}
	
	public void paintObject(Graphics g) {
		g.drawImage(getImage(), x, y, 60,60,null);
		

	}
	

}
