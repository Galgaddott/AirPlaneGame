package com.terena.xust.number;

import java.util.Scanner;

/**
 * 
 * @author ��ε
 *
 */
public class NumberGame {
	/**
	 * һ.JAVA�ı��˼��-������󽫹��ܷ�װ������ǿ���߱����ܵĶ���
	 * ��.JAVA����ǰ�Ļ���׼��
	 * 1.��װJAK-����ʹ��Ĭ��·�� ��cmd->java���ֽ�����װ���
	 * 		���ɲ��䣩ϵͳ�������£�
	 * 				-JAVA_HOME:jdk�İ�װ·��
	 * 				-path:��ĩβ��jdk��binĿ¼
	 * 				-CLASSPATH:����java�������õ���tools
	 * 2.��װeclipse��ֱ�����أ���ѹ��
	 */
		
	public static void main(String[] args) {
		//��ӭ����
		System.out.println("********************��ӭ������������Ϸ*******************************");
		//Ҫ������-������
		System.out.println("������0-100�ڵ�����");
		//���������-����������
		int num=(int)(Math.random()*100);
		//ʵ�����ࡪ��scanner
		Scanner scan = new Scanner(System.in);
		//��������
		int grade = 100;
		//ѭ��-������ѭ��
		while(true) {
			//�������
			int userNum=scan.nextInt();
			//���ıȽ��߼�-if
			if(userNum>num) {
				System.out.println("�´���..........");
				grade--;
			}
			else if(userNum<num) {
				System.out.println("��С��..........");
				grade--;
			}
			else {System.out.println("�¶���...������"+grade+"    �ܹ�����  "+(100-grade)+"��");
				break;
			}
			
		}
		/**
		 * ��ϵһ��ͳ�����´������Ҽ����������ӡ
		 */
		
		
		
	}
}
