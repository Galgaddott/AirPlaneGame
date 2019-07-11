package com.terena.xust.manystar;

import javax.swing.JFrame;

import com.terena.xust.jframedemo.Factory;

/**
 * 一颗星窗口类
 * @author 周蔚
 *
 */
public class OneStarJFrame extends JFrame {
	
	public OneStarJFrame() {
		this.setTitle("My OneStar JFrame");
		this.setBounds(Factory.jframeX , Factory.jframeY , Factory.jframeWidth , Factory.jframeHeight);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		//将画板添加在窗体容器中
		this.add(new OneStarJPanel2());
		
	}
	
	public static void main(String[] args) {
		new OneStarJFrame();
	}
	
	

}
