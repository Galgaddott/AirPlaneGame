package com.terena.xust.manystar;

import javax.swing.JFrame;

import com.terena.xust.jframedemo.Factory;

public class ManyStarJFrame extends JFrame{

	public ManyStarJFrame() {
		
		this.setTitle("Many Star");
		this.setBounds(Factory.jframeX , Factory.jframeY , Factory.jframeWidth , Factory.jframeHeight);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.add(new ManyStarJPanel() );
	}
	
	public static void main(String[] args) {
		new ManyStarJFrame();
	}
	
	
}
