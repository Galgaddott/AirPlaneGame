package com.terena.xust.shootgame;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javazoom.jl.player.Player;

/**
 * 添加背景音乐
 * @author 周蔚
 *
 */
public class MusicPlayer extends Thread{

	
	/*重写线程run方法*/
	public void run() {
		
		try {
			//创建文件输入流对象
			FileInputStream fis = new FileInputStream("src/mus.mp3");
			//创建缓冲流
			BufferedInputStream bis= new BufferedInputStream(fis);
			Player shootPlayer = new Player(bis);
			shootPlayer.play();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
}
