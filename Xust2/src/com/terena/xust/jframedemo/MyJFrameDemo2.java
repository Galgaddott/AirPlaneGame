package com.terena.xust.jframedemo;

import javax.swing.JFrame;

/**
 * �ҵĵڶ�������
 * ���ù��췽����ʼ������
 * ˼�룺�������
 * 	
 * @author ��ε
 *
 */
public class MyJFrameDemo2 {

	//����-JFrame
	JFrame jframe;
	//���췽��-��ʼ������
	public MyJFrameDemo2() {
		jframe=new JFrame();
		jframe.setTitle("My Second JFrame");
		jframe.setSize(400,600);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.setLocationRelativeTo(null);
		jframe.setVisible(true);
	}
	//������
	public static void main(String[] args) {
		new MyJFrameDemo2();
	}
	
	
}
