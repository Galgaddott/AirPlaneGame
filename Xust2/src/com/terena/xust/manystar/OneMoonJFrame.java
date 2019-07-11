package com.terena.xust.manystar;

import javax.swing.JFrame;

import com.terena.xust.jframedemo.Factory;

public class OneMoonJFrame extends JFrame {

	public OneMoonJFrame() {
		this.setTitle("One Moon");
		this.setBounds(Factory.jframeX , Factory.jframeY , Factory.jframeWidth , Factory.jframeHeight);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.add(new OneMoonJPanel());
		
	}
	public static void main(String[] args) {
		new OneMoonJFrame();
	}
}
