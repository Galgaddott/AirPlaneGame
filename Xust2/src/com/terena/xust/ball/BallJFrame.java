package com.terena.xust.ball;

import javax.swing.JFrame;



public class BallJFrame extends JFrame{
	
	public BallJFrame() {
		this.setTitle("Ball JFrame");
		this.setBounds(Factory.jframex, Factory.jframey, Factory.jframeWidth, Factory.jframeHeight);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.add(new BallJPanel());
		
	}
	
	public static void main(String[] args) {
		new BallJFrame();
	}

}
