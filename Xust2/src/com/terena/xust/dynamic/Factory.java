package com.terena.xust.dynamic;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.util.Random;

/**
 * ����������
 * @author ��ε
 *
 */
public class Factory {

			
	       //��Ļ�Ŀ�
			public static int width = Toolkit.getDefaultToolkit().getScreenSize().width;
			//��Ļ�ĸ�
			public static int height = Toolkit.getDefaultToolkit().getScreenSize().height;
			//����Ŀ�
			public static int jframeWidth = 400;
			//����ĸ�
			public static int jframeHeight = 600;
			//�����ˮƽ��������-x
			public static int jframeX = width / 2 - jframeWidth / 2;
			//�����ˮƽ��������-y
			public static int jframeY = height / 2 - jframeHeight / 2;
			
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
			
	
}
