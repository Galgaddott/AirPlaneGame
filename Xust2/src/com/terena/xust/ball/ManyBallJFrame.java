package com.terena.xust.ball;

import javax.swing.JFrame;

/**
 * ¥∞ÃÂ¿‡
 * @author ÷‹Œµ
 *
 */
public class ManyBallJFrame extends JFrame{

	public ManyBallJFrame() {
		this.setTitle("Many Ball");
		this.setBounds(Factory.jframex, Factory.jframey, Factory.jframeWidth, Factory.jframeHeight);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.add(new ManyBallJPanel());
	}
	
	public static void main(String[] args) {
		new ManyBallJFrame();
	}
}
