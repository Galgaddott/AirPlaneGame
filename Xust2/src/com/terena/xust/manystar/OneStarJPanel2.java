package com.terena.xust.manystar;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JPanel;

/**
 * һ���������ɫ����С��λ��
 * @author ��ε
 *
 */
public class OneStarJPanel2 extends JPanel{
	
	public OneStarJPanel2() {
		// TODO Auto-generated constructor stub
		this.setBackground(Color.black);
	} 
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		//���������
		Random random=new Random();
		//���û�����ɫ
		g.setColor(new Color ( random.nextInt(256),random.nextInt(256),random.nextInt(256)  ) );
		//���û�������
		g.setFont(new Font("����",Font.BOLD,random.nextInt(65) ) );
		//��
		g.drawString("*",random.nextInt(Factory.jframeWidth), random.nextInt(Factory.height));
				
	}

}
