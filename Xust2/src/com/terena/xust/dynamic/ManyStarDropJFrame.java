package com.terena.xust.dynamic;

import javax.swing.JFrame;

/**
 * ����������
 * 1.�̳�JFrame��
 * 2.���췽����ʼ������
 * 3.����������ڴ���������
 * 4.������-ʵ������ǰ�����
 * @author ��ε
 *
 */
public class ManyStarDropJFrame extends JFrame {
		
	public ManyStarDropJFrame()
	{
		this.setTitle("Many Star Drop");
		this.setBounds(Factory.jframeX, Factory.jframeY, Factory.jframeWidth, Factory.jframeHeight);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.add(new ManyStarDropJPanel());
		
		
		
	}
	
	
	public static void main(String[] args) {
		new ManyStarDropJFrame();
	}
}
