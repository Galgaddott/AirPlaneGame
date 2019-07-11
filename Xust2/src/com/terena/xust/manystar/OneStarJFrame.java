package com.terena.xust.manystar;

import javax.swing.JFrame;

import com.terena.xust.jframedemo.Factory;

/**
 * һ���Ǵ�����
 * @author ��ε
 *
 */
public class OneStarJFrame extends JFrame {
	
	public OneStarJFrame() {
		this.setTitle("My OneStar JFrame");
		this.setBounds(Factory.jframeX , Factory.jframeY , Factory.jframeWidth , Factory.jframeHeight);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		//����������ڴ���������
		this.add(new OneStarJPanel2());
		
	}
	
	public static void main(String[] args) {
		new OneStarJFrame();
	}
	
	

}
