package com.terena.xust.manystar;

import java.awt.Toolkit;

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
}
