package com.terena.xust.shootgame;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javazoom.jl.player.Player;

/**
 * ��ӱ�������
 * @author ��ε
 *
 */
public class MusicPlayer extends Thread{

	
	/*��д�߳�run����*/
	public void run() {
		
		try {
			//�����ļ�����������
			FileInputStream fis = new FileInputStream("src/mus.mp3");
			//����������
			BufferedInputStream bis= new BufferedInputStream(fis);
			Player shootPlayer = new Player(bis);
			shootPlayer.play();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
}
