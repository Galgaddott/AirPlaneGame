package com.terena.xust.jframedemo;

import javax.swing.JFrame;

/**
 * ���ü̳еķ�ʽ
 * �߼�����ó�ˮƽ��ֱ����
 * ���췽����ʼ������
 * @author ��ε
 *
 */
public class MyJFrameDemo3 extends JFrame{

	//���췽����ʼ������
	public MyJFrameDemo3() {
		this.setTitle("My Third JFrame");
		this.setBounds(Factory.jframeX , Factory.jframeY , Factory.jframeWidth , Factory.jframeHeight);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		
	}
	
	//������
	public static void main(String[] args) {
		new MyJFrameDemo3();
	}
	
}
