package com.terena.xust.jframedemo;

import java.awt.Toolkit;

/**
 * 公共类
 * 封装了常用公共的属性及方法
 * @author 周蔚
 *
 */
public class Factory {
	
	
	//屏幕的宽
	public static int width = Toolkit.getDefaultToolkit().getScreenSize().width;
	//屏幕的高
	public static int height = Toolkit.getDefaultToolkit().getScreenSize().height;
	//窗体的宽
	public static int jframeWidth = 400;
	//窗体的高
	public static int jframeHeight = 600;
	//窗体的水平居中坐标-x
	public static int jframeX=width/2-jframeWidth/2;
	//窗体的水平居中坐标-y
	public static int jframeY=height/2-jframeHeight/2;
}
