package com.terena.xust.jframedemo;

import javax.swing.JFrame;

/**
 * �ҵĵ�һ������
 * main�ĺ���ʵ��
 * @author ��ε
 *
 */
public class MyJFrameDemo1 {

	public static void main(String[] args) {
		//1.ʵ����JFrame����
		JFrame jframe=new JFrame();
		//2.���ô�������
		jframe.setTitle("My First JFrame");
		//3.���ô����С
		jframe.setSize(400,600);
		//4.���ô���Ĭ�Ϲرշ�ʽ
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//5.����ˮƽ��ֱ����
		jframe.setLocationRelativeTo(null);
		//6.���ô���Ŀɼ�
		jframe.setVisible(true);
		
	}
}
