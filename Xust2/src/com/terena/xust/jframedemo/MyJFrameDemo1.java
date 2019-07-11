package com.terena.xust.jframedemo;

import javax.swing.JFrame;

/**
 * 我的第一个窗体
 * main的函数实现
 * @author 周蔚
 *
 */
public class MyJFrameDemo1 {

	public static void main(String[] args) {
		//1.实例化JFrame对象
		JFrame jframe=new JFrame();
		//2.设置窗体名称
		jframe.setTitle("My First JFrame");
		//3.设置窗体大小
		jframe.setSize(400,600);
		//4.设置窗体默认关闭方式
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//5.设置水平垂直居中
		jframe.setLocationRelativeTo(null);
		//6.设置窗体的可见
		jframe.setVisible(true);
		
	}
}
