package com.terena.xust.number;

import java.util.Scanner;

/**
 * 
 * @author 周蔚
 *
 */
public class NumberGame {
	/**
	 * 一.JAVA的编程思想-面向对象将功能封装进对象，强调具备功能的对象
	 * 二.JAVA运行前的环境准备
	 * 1.安装JAK-建议使用默认路径 打开cmd->java出现介绍则安装完成
	 * 		（可不配）系统变量如下：
	 * 				-JAVA_HOME:jdk的安装路径
	 * 				-path:在末尾加jdk的bin目录
	 * 				-CLASSPATH:配置java开发所用到的tools
	 * 2.安装eclipse，直接下载，解压打开
	 */
		
	public static void main(String[] args) {
		//欢迎界面
		System.out.println("********************欢迎来到猜数字游戏*******************************");
		//要求输入-输出语句
		System.out.println("请输入0-100内的整数");
		//产生随机数-随机数字语句
		int num=(int)(Math.random()*100);
		//实例化类——scanner
		Scanner scan = new Scanner(System.in);
		//分数控制
		int grade = 100;
		//循环-自造死循环
		while(true) {
			//输入语句
			int userNum=scan.nextInt();
			//核心比较逻辑-if
			if(userNum>num) {
				System.out.println("猜大了..........");
				grade--;
			}
			else if(userNum<num) {
				System.out.println("猜小了..........");
				grade--;
			}
			else {System.out.println("猜对了...分数是"+grade+"    总共猜了  "+(100-grade)+"次");
				break;
			}
			
		}
		/**
		 * 联系一：统计所猜次数，且计算分数并打印
		 */
		
		
		
	}
}
