package com.terena.xust.manystar;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JPanel;

/**
 * �����ǻ�����
 * 1.�̳�JPanel
 * 2.��дpaint����
 * 
 * @author ��ε
 *t
 */
public class OneStarJPanel extends JPanel {
	/*���췽����ʼ���������*/
	
	public OneStarJPanel() {
		//���ñ�����ɫ
		this.setBackground(Color.black);
	}
	/*��д�滭�ķ���*/
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		//���û�����ɫ
		g.setColor(Color.yellow );
		//���û�������
		g.setFont(new Font("����",Font.BOLD,40));
		//��
		g.drawString("*",100,100);
		
		
	}
	
	
}
