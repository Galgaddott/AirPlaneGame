package com.terena.xust.dynamic;

import javax.swing.JFrame;

import com.terena.xust.jframedemo.Factory;

/**
 * һ�������䴰��
 * @author ��ε
 *
 */
public class OneStarDropJFrame extends JFrame{

	public OneStarDropJFrame() {
		this.setTitle("One Star Drop");
		this.setBounds(Factory.jframeX , Factory.jframeY , Factory.jframeWidth , Factory.jframeHeight);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.add(new TwoMoonJPanel());
		
	}
	public static void main(String[] args) {
		new OneStarDropJFrame ();
	}
}
