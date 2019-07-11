package com.terena.xust.dynamic;

import javax.swing.JFrame;

/**
 * 窗口容器类
 * 1.继承JFrame类
 * 2.构造方法初始化参数
 * 3.将画板添加在窗体容器中
 * 4.主函数-实例化当前类对象
 * @author 周蔚
 *
 */
public class ManyStarDropJFrame extends JFrame {
		
	public ManyStarDropJFrame()
	{
		this.setTitle("Many Star Drop");
		this.setBounds(Factory.jframeX, Factory.jframeY, Factory.jframeWidth, Factory.jframeHeight);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.add(new ManyStarDropJPanel());
		
		
		
	}
	
	
	public static void main(String[] args) {
		new ManyStarDropJFrame();
	}
}
