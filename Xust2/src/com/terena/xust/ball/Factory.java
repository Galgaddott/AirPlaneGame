package com.terena.xust.ball;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;

public class Factory {

	public static int width = Toolkit.getDefaultToolkit().getScreenSize().width;
	public static int height = Toolkit.getDefaultToolkit().getScreenSize().height;
	public static int jframeWidth = 800;
	public static int jframeHeight = 600;
	public static int jframex = width / 2 -jframeWidth / 2 ;
	public static int jframey = height / 2 -jframeHeight / 2 ;
	
	/*�Զ��巽��*/
	public static Color randomColor(int x) {
		int  R=(int)(Math.random()*x);
		int  G=(int)(Math.random()*x);
		int  B=(int)(Math.random()*x);
		 Color c =new Color(R,G,B);
		 return c;
		
	}
	
	public static Font randomFont(int x) {
		int f=(int)(Math.random()*x);
		Font font = new Font("����",Font.BOLD,f);
		return font;
		
	}
	
	public static int  randomPoint(int x) {
		int point = (int)(Math.random()*x);
		return point;
		
	}
	
	//����һ��С����Զ��巽��
	public Ball addBall() {
		int x = (int)(Math.random()*700);
		int y = (int)(Math.random()*500);
		int d = (int)(Math.random()*60 + 5);
		int speed = 1;
		int R = (int)(Math.random()*256);
		int G = (int)(Math.random()*256);
		int B = (int)(Math.random()*256);
		Color ballColor = new Color(R,G,B);
		//�������С��ķ���
		int direction = (int)(Math.random()*4);
		Ball ball = new Ball(x,y,d,speed,ballColor,direction);
		return ball;
		
	}
}
