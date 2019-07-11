package com.terena.xust.jframedemo;

import javax.swing.JFrame;

/**
 * 我的第二个窗体
 * 采用构造方法初始化参数
 * 思想：面向对象
 * 	
 * @author 周蔚
 *
 */
public class MyJFrameDemo2 {

	//属性-JFrame
	JFrame jframe;
	//构造方法-初始化参数
	public MyJFrameDemo2() {
		jframe=new JFrame();
		jframe.setTitle("My Second JFrame");
		jframe.setSize(400,600);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.setLocationRelativeTo(null);
		jframe.setVisible(true);
	}
	//主函数
	public static void main(String[] args) {
		new MyJFrameDemo2();
	}
	
	
}
