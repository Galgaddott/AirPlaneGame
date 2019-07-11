package com.terena.xust.dynamic;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.util.Random;

/**
 * 公共属性类
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
			public static int jframeX = width / 2 - jframeWidth / 2;
			//窗体的水平居中坐标-y
			public static int jframeY = height / 2 - jframeHeight / 2;
			
			/*自定义方法*/
			public static Color randomColor(int x) {
				int  R=(int)(Math.random()*x);
				int  G=(int)(Math.random()*x);
				int  B=(int)(Math.random()*x);
				 Color c =new Color(R,G,B);
				 return c;
				
			}
			
			public static Font randomFont(int x) {
				int f=(int)(Math.random()*x);
				Font font = new Font("宋体",Font.BOLD,f);
				return font;
				
			}
			
			public static int  randomPoint(int x) {
				int point = (int)(Math.random()*x);
				return point;
				
			}
			
	
}
