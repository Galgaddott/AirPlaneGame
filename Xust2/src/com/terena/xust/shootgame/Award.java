package com.terena.xust.shootgame;
/**
 * 奖励接口
 * 双倍火力
 * 生命值
 * @author 周蔚
 *
 */
public interface Award {
	/*
	 * 定义奖励的属性
	 * 定义火力值或生命值为0或1
	 * 目的是利用随机产生的数字0或1来确定奖励
	 * 为双倍火力还是生命值增加
	 * 
	 * 
	 * */
		public int DOUBLE_FIRE = 0;//火力值
		public int LIFE = 1;//生命值
		
		/*获取奖励类型*/
		public int getAwardType();
		
		
}
