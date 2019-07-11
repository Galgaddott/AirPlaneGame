package com.terena.xust.jframedemo;

import javax.swing.JFrame;

/**
 * 采用继承的方式
 * 逻辑运算得出水平垂直居中
 * 构造方法初始化参数
 * @author 周蔚
 *
 */
public class MyJFrameDemo3 extends JFrame{

	//构造方法初始化参数
	public MyJFrameDemo3() {
		this.setTitle("My Third JFrame");
		this.setBounds(Factory.jframeX , Factory.jframeY , Factory.jframeWidth , Factory.jframeHeight);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		
	}
	
	//主方法
	public static void main(String[] args) {
		new MyJFrameDemo3();
	}
	
}
