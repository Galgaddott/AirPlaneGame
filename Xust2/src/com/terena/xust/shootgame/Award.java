package com.terena.xust.shootgame;
/**
 * �����ӿ�
 * ˫������
 * ����ֵ
 * @author ��ε
 *
 */
public interface Award {
	/*
	 * ���影��������
	 * �������ֵ������ֵΪ0��1
	 * Ŀ���������������������0��1��ȷ������
	 * Ϊ˫��������������ֵ����
	 * 
	 * 
	 * */
		public int DOUBLE_FIRE = 0;//����ֵ
		public int LIFE = 1;//����ֵ
		
		/*��ȡ��������*/
		public int getAwardType();
		
		
}
