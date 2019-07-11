package com.terena.xust.shootgame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JPanel;

/*
 * 
 */

public class ShootGameJPanel extends JPanel {

	/*绐椾綋鐨勫睘鎬�*/
	public static int width = Toolkit.getDefaultToolkit().getScreenSize().width;
	public static int height = Toolkit.getDefaultToolkit().getScreenSize().height;
	 
	public static final int  WIDTH = 420; //绐楀彛鐨勫
	public static final int HEIGHT = 700; //绐楀彛鐨勯珮
	public static int jframeX = width / 2 - WIDTH / 2;
	public static int jframeY = height / 2 - HEIGHT / 2;
	
	/*璁剧疆娓告垙鐨勭姸鎬�
	 * 鍚姩 杩愯 鏆傚仠 缁撴潫
	 * 榛樿鐨勭姸鎬佷负鍚姩
	 * 
	 * */
	public static final int START = 0;//鍚姩鐘舵��
	public static final int RUNNING = 1;//杩愯鐘舵��
	public static final int PAUSE = 2;//鏆傚仠鐘舵��
	public static final int  GAME_OVER = 3;//缁撴潫
	
	/*娓告垙鐨勫綋鍓嶇姸鎬�*/
	private int state = START; 
	
	
	/*瀹氫箟鍥剧墖闆�*/
	public static BufferedImage start ; //鍚姩鍥剧墖
	public static BufferedImage pause;//鏆傚仠鍥剧墖
	public static BufferedImage gameover;//缁撴潫鍥剧墖
 	public static BufferedImage top; //鎺掕姒�
	/*浣跨敤闈欐�佷唬鐮佸潡鍔犺浇鍥剧墖*/
	static {
		start = FlyingObject.loadImage("startt.png");
		pause = FlyingObject.loadImage("pause.png");
		gameover = FlyingObject.loadImage("gameover.png");
		top = FlyingObject.loadImage("top.png");
	}
	
	/*瀹氫箟瀹炰綋绫�*/
	private Sky sky = new Sky();//瀹炰緥鍖栧ぉ绌哄璞�
	private Hero hero = new Hero();//瀹炰緥鍖栬嫳闆勬満瀵硅薄
	/*鏁屼汉锛堝ぇ銆佸皬鏁屾満鍙婅湝铚傦級*/
	private FlyingObject[] enemies = {};
	private Bullet[] bullets = {};	//瀛愬脊鏁扮粍
	private EnemyBullet[] bulletss = {};	//鏁屾満瀛愬脊鏁扮粍
	private BossBullet[] bulletsss = {};	//boss瀛愬脊鏁扮粍
	
	/*鐢熸垚鏁屼汉鐨勬牳蹇冪畻娉�*/
	public FlyingObject nextOne() {
		/*瀹炰緥鍖栭殢鏈烘暟瀵硅薄*/
		Random rand = new Random();
		/*0-20鍐呯殑闅忔満鏁�*/
		int type = rand.nextInt(21);//0-19
		if(type < 4) {//0-3鏃剁敓鎴愬皬铚滆渹
			return new Bee();			
		}else if(type < 12) {//4-11鏃剁敓鎴愬皬鏁屾満
			//return new Airplane();
			return new Airplane();
		}else if(type<18){//12-19:鐢熸垚澶ф晫鏈�
			return new BigAirplane();
		}
		else {
			return new Boss();
		}
	}
	
	int enterIndex = 0;//鏁屼汉鍏ュ満璁℃暟鍣�
	int choice = 0;//鑷畾涔夌殑鏍规嵁鍒嗘暟鍔犲揩椋炴満鍏ュ満閫熷害
	int  x = 0;//鑷畾涔夋晫浜鸿繘鍦虹殑鏉′欢 
	
	/*鏁屼汉锛堝ぇ銆佸皬鏁屾満鍜岃湝铚傦級鍏ュ満*/
	public void enterAction() {//10ms璧颁竴娆�

			enterIndex++;
		if(enterIndex % 40 == 0) {
			//鑾峰彇鏁屼汉瀵硅薄
			FlyingObject obj = nextOne();
			enemies = Arrays.copyOf(enemies, enemies.length + 1);
			//灏嗘晫浜烘坊鍔犲湪鏁扮粍鐨勬渶鍚庝竴浣�
			enemies[enemies.length - 1] = obj;
		}
	}
	
	int shootIndex = 0;//瀛愬脊鍏ュ満璁℃暟鍣�
	/*瀛愬脊鍏ュ満(鑻遍泟鏈哄彂灏勫瓙寮�)*/
	public void shootAction() {
		//10ms璧颁竴娆�
		shootIndex++;
		/*300ms璧颁竴娆�*/
		if(shootIndex % 30 ==0) {
			//鑾峰彇瀛愬脊瀵硅薄
			Bullet[] bs = hero.shoot();	
			//鎵╁(bs閲屾湁鍑犱釜鍏冪礌灏辨墿瀹瑰嚑涓暱搴�)
			bullets = Arrays.copyOf(bullets, bullets.length+bs.length);
			System.arraycopy(bs, 0, bullets, bullets.length-bs.length,bs.length);
			
		}
	}
	
	int shootIndex2 = 0; //鏁屾満瀛愬脊鍏ュ満璁℃椂鍣�
	/*鏁屾満鍙戝皠瀛愬脊*/
	public void EnemyShootAction() {
		
		shootIndex2++;
		if(shootIndex2 % 100 ==0) {
			for(FlyingObject enemy:enemies) {
				if(enemy.isLife()) {
					if( ! (enemy instanceof Boss)) {
						//鑾峰彇瀛愬脊瀵硅薄
						EnemyBullet[] bss = enemy.EnemyShoot();	
						//鎵╁(bss閲屾湁鍑犱釜鍏冪礌灏辨墿瀹瑰嚑涓暱搴�)
						bulletss = Arrays.copyOf(bulletss, bulletss.length+bss.length);
						System.arraycopy(bss, 0, bulletss, bulletss.length-bss.length,bss.length);
					}
				}
			}
			
		}
	}
	
	int shootIndex3 = 0; //boss瀛愬脊鍏ュ満璁℃椂鍣�
	/*boos鍙戝皠瀛愬脊*/
	public void BossShootAction() {
		
		shootIndex3++;
		if(shootIndex3 % 200 ==0) {
			for(FlyingObject enemy:enemies) {
				if(enemy.isLife()) {
					if(enemy instanceof Boss) {
						Boss a =(Boss) enemy;
						//鑾峰彇瀛愬脊瀵硅薄
						BossBullet[] bsss = a.BossShoot();	
						//鎵╁(bss閲屾湁鍑犱釜鍏冪礌灏辨墿瀹瑰嚑涓暱搴�)
						bulletsss = Arrays.copyOf(bulletsss, bulletsss.length+bsss.length);
						System.arraycopy(bsss, 0, bulletsss, bulletsss.length-bsss.length,bsss.length);

						
					}
			
				}
				
			}
			
		}
		
		
		
	}
	
	
	
	
	/*椋炶鐗╃Щ鍔�*/
	public void stepAction() {
		//10ms璧颁竴娆�
		sky.step();//澶╃┖绉诲姩
		hero.step();//绌虹殑鏂规硶
		//鎵�鏈夋晫浜虹Щ鍔�
		for (int i = 0; i < enemies.length; i++) {
			//閬嶅巻鎵�鏈夌殑鏁屼汉
			enemies[i].step();
		}
		//鎵�鏈夎嫳闆勬満瀛愬脊绉诲姩
		for (int i = 0; i < bullets.length; i++) {
			//閬嶅巻鎵�鏈夊瓙寮�
			if(bullets[i] == null) continue;
			else  bullets[i].step();
			
		}
		
		//鏁屾満瀛愬脊鐨勭Щ鍔�
		//鎵�鏈夊瓙寮圭Щ鍔�
				for (int i = 0; i < bulletss.length; i++) {
					//閬嶅巻鎵�鏈夊瓙寮�
					bulletss[i].step();
				}
				
				//boss瀛愬脊绉诲姩
				for (int i = 0; i < bulletsss.length; i++) {
					//閬嶅巻鎵�鏈夊瓙寮�
					bulletsss[i].step();
				}
	}
	
	/*鍒犻櫎瓒婄晫鐨勯琛岀墿*/
	public void outOfBoundsAction() {
		//10ms璧颁竴娆�
		//涓嶈秺鐣屾晫浜烘暟缁勪笅鏍�
		int index = 0;
		//涓嶈秺鐣岀殑鏁屼汉鏁扮粍
		FlyingObject[] enemyLives=new FlyingObject[enemies.length];//涓嶈秺鐣岀殑鏁屼汉鏁扮粍
		
		for (int i = 0; i < enemies.length; i++) {
			//鑾峰彇姣忎竴涓晫浜�
			FlyingObject f = enemies[i];
			//涓嶈秺鐣�  
			if(!f.outOfBounds()) {
				//灏嗕笉瓒婄晫鐨勬晫浜烘斁鍏ヤ笉瓒婄晫鐨勬暟缁勪腑
				enemyLives[index] = f;
				//涓嶈秺鐣岀殑鏁屼汉涓嬫爣鍜屼釜鏁�+1
				index++;
			}
		}
		
		//灏嗕笉瓒婄晫鐨勬晫浜烘暟缁勮緟鍔╁埌enemies
		enemies = Arrays.copyOf(enemyLives, index);
		index = 0; //涓嶈秺鐣岀殑瀛愬脊鏁扮粍鍜屼釜鏁�
		int enemyIndex = 0;
		int bossIndex = 0;
		
		//涓嶈秺鐣岀殑鑻遍泟鏈哄瓙寮规暟閲�
		Bullet[] bulletLives = new Bullet[bullets.length];
		//涓嶈秺鐣岀殑鏁屾満瀛愬脊鏁伴噺
		EnemyBullet[] EnemyBulletLives = new EnemyBullet[bulletss.length];
		//涓嶈秺鐣岀殑boss瀛愬脊鏁伴噺
				BossBullet[] BossBulletLives = new BossBullet[bulletsss.length];
		//閬嶅巻鑻遍泟鏈哄瓙寮规暟缁�
		for (int i = 0; i < bullets.length; i++) {
			//鑾峰彇姣忎竴棰楀瓙寮�
			Bullet b = bullets[i];
			if(b== null) continue;
			else	{
			if(!b.outOfBounds()) {
				//灏嗕笉瓒婄晫鐨勫瓙寮瑰瓨鍏ヤ笉瓒婄晫鏁扮粍
				bulletLives[index] = b;
				index++;
				
			}
			}
			
		}
		
		//閬嶅巻鏁屾満瀛愬脊鏁扮粍
		for (int i = 0; i < bulletss.length; i++) {
			//鑾峰彇姣忎竴棰楀瓙寮�
			EnemyBullet b = bulletss[i];
			if(!b.outOfBounds()) {
				//灏嗕笉瓒婄晫鐨勫瓙寮瑰瓨鍏ヤ笉瓒婄晫鏁扮粍
				EnemyBulletLives[enemyIndex] = b;
				enemyIndex++;
				
			}
			
			
		}
		
		//閬嶅巻boss瀛愬脊鏁扮粍
		for (int i = 0; i < bulletsss.length; i++) {
			//鑾峰彇姣忎竴棰楀瓙寮�
			BossBullet c = bulletsss[i];
			if(!c.outOfBounds()) {
				//灏嗕笉瓒婄晫鐨勫瓙寮瑰瓨鍏ヤ笉瓒婄晫鏁扮粍
				BossBulletLives[bossIndex] = c;
				bossIndex++;
				
			}
			
			
		}
		
		//灏嗕笉瓒婄晫瀛愬脊鏁扮粍璧嬪�煎埌bullets涓�
		bullets = Arrays.copyOf(bulletLives, index);
		bulletss = Arrays.copyOf(EnemyBulletLives,enemyIndex);
		bulletsss = Arrays.copyOf(BossBulletLives,bossIndex);
		
	}
	
	int score = 0;//瀹氫箟鐜╁鐨勫緱鍒�
	public void bulletBangAction() {
		//10ms璧颁竴娆�
		
		//閬嶅巻鎵�鏈夊瓙寮�
		for (int i = 0; i < bullets.length; i++) {
			Bullet b = bullets[i];
			//閬嶅巻鎵�鏈夌殑鏁屼汉j
			for (int j = 0; j < enemies.length; j++) {
				//鑾峰彇姣忎竴涓晫浜�
				FlyingObject f = enemies[j];
				//纰版挒鏄惁鎾炰笂
				if(f.hit(b) && f.isLife() && b.isLife()) {
					if(f instanceof Boss)
					{
						Boss ff = (Boss) f;
						ff.Delife();
						if(ff.life<0)
							f.goDead();
					}
					else {
					f.goDead();
					}
					b.goDead();
					
					//纰版挒涔嬪悗閫昏緫澶勭悊
					if(f instanceof Enemy) {
						//鑻ヨ鎾�-寰楀垎
						Enemy en = (Enemy) f;
						//鐜╁寰楀垎
						score += en.getScore();						
						
					}
					if(f instanceof Award) {
						
						Award aw = (Award) f;
						int type = aw.getAwardType();
						
						switch(type) {
						case Award.DOUBLE_FIRE:
						{
							for (int k = 0; k < enemies.length; k++)
							{	
								FlyingObject p = enemies[k];
								p.goDead();
							}
							
						}
							break;
						case Award.LIFE:
							hero.addLife();break;
						
						}
							
					}
					
				}
				
			}
		}
	}
	
	/*鑻遍泟鏈轰笌鏁屼汉 瀛愬脊纰版挒*/
	public void heroBangAction() {
		//10ms璧颁竴娆�
	   //涓庢晫浜虹鎾�
		for (int i = 0; i < enemies.length; i++) {
			FlyingObject f = enemies[i];
			if(f.hit(hero) && f.isLife()) {
				f.goDead();
				hero.subtractLife();//鑻遍泟鏈哄噺鍛�
				hero.clearDoubleFire();//鍙屽�嶇伀鍔涙秷澶�
			}
			
		}
		//涓庢晫鏈哄瓙寮圭鎾�
		for(int i = 0; i < bulletss.length; i++) {
			FlyingObject f = bulletss[i];
			if(f.hit(hero) && f.isLife()) {
				f.goDead();
				hero.subtractLife();//鑻遍泟鏈哄噺鍛�
				hero.clearDoubleFire();//鍙屽�嶇伀鍔涙秷澶�
			}
			
		}
		
		//涓巄oos瀛愬脊鐩告挒
		//涓庢晫鏈哄瓙寮圭鎾�
				for(int i = 0; i < bulletsss.length; i++) {
					FlyingObject f = bulletsss[i];
					if(f.hit(hero) && f.isLife()) {
						f.goDead();
						hero.subtractLife();//鑻遍泟鏈哄噺鍛�
						hero.clearDoubleFire();//鍙屽�嶇伀鍔涙秷澶�
					}
					
				}
		
	}
	
	
	/*妫�娴嬫父鎴忔槸鍚︾粨鏉�*/
	public void checkGameOverAction() throws Exception {
		//10ms璧颁竴娆�
		// 鐢熷懡鍊煎皬浜�0
		if (hero.getLife() <= 0) {
			try {
//                System.out.println("curName = " + LoginJFrame.curName);
				UserDao.updateScore(LoginJFrame.curName, score);
			} catch (Exception e) {
				e.printStackTrace();
			}
			state = GAME_OVER;
		}

	}

	/*鍚姩绋嬪簭鐨勬墽琛�*/
	public void action() {
		//鍒涘缓鐩戝惉鍣ㄥ璞�
		MouseAdapter l = new MouseAdapter() {

			/*閲嶅啓MouseMoved榧犳爣绉诲姩浜嬩欢*/
			public void mouseMoved(MouseEvent e) {
				//杩愯鐘舵�佷笅
				if(state == RUNNING) {
					int x = e.getX();//鑾峰彇榧犳爣鐨剎鍧愭爣
					int y = e.getY();//鑾峰彇榧犳爣鐨剏鍧愭爣
					hero.moveTo(x, y);//鑻遍泟鏈洪殢榧犳爣绉诲姩
				}
				
			}
			
			/*閲嶅啓榧犳爣鐐瑰嚮浜嬩欢*/
			public void mouseClicked(MouseEvent e) {
				//鏍规嵁涓嶅悓鐨勭姸鎬佸仛鍑轰笉鍚岀殑澶勭悊
				switch(state) {
				case START: state = RUNNING;break;
				case GAME_OVER: score = 0;  sky = new Sky(); hero = new Hero(); enemies = new FlyingObject[0];
								bullets = new Bullet[0]; state = START; break;
				
				}
				
			}
			
			/*閲嶅啓榧犳爣绉诲嚭浜嬩欢*/
			@Override
			public void mouseExited(MouseEvent e) {
				if((state == RUNNING)) {
					state = PAUSE;
				}
			}
			
			/*閲嶅啓榧犳爣绉诲叆浜嬩欢*/
			@Override
			public void mouseEntered(MouseEvent e) {
				if(state == PAUSE) {
					state = RUNNING;
				}
			}
			
			
		};
		//娣诲姞榧犳爣鎿嶄綔浜嬩欢
		this.addMouseListener(l);
		//娣诲姞榧犳爣婊戝姩浜嬩欢
		this.addMouseMotionListener(l);
		
		//瀹氫箟瀹氭椂鍣ㄥ璞�
		Timer timer = new Timer();
		int intervel = 30;
		timer.schedule(new TimerTask() {

		@Override
		public void run() {
				//瀹氭椂鎵ц鐨勪换鍔�-姣�10ms鍋氫竴娆�
				if(state == RUNNING) {
					switch(score/30) {
					case 0:choice=0;Hero.fire=1;break;
					case 1:Bullet.speed=15;BigAirplane.speed=4;Sky.turnSky=1;Hero.fire=2;Airplane.speed=5;EnemyBullet.speed=7;Bullet.turnBullet=1;choice=1;break;
					case 2:Bullet.speed=20;BigAirplane.speed=6;Sky.turnSky=2;Hero.fire=3;Airplane.speed=7;EnemyBullet.speed=9;Bullet.turnBullet=2;choice=2;break;
					case 4:Bullet.speed=25;BigAirplane.speed=8;Hero.fire=4;Airplane.speed=9;EnemyBullet.speed=11;choice=3;break;
					default: Bullet.speed=30;BigAirplane.speed=11;Hero.fire=4;Airplane.speed=12;EnemyBullet.speed=15;choice=3;break;
					
					}
					//澶у皬鏁屾満铚滆渹鍏ュ満
					enterAction();
					//瀛愬脊鍙戝皠
					shootAction();
					//鏁屾満瀛愬脊鍏ュ満
					EnemyShootAction();
					//Boss瀛愬脊鍏ュ満
					BossShootAction();
					//椋炶鐗╃Щ鍔�
					stepAction();
					//鍒犻櫎瓒婄晫鐨勯琛岀墿
					outOfBoundsAction();
					//妫�娴嬪瓙寮逛笌鏁屼汉纰版挒
					bulletBangAction();
					//鑻遍泟鏈轰笌鏁屼汉纰版挒
					heroBangAction();
					//妫�娴嬫父鎴忔槸鍚︾粨鏉�
					try {
						checkGameOverAction();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				repaint();
			
		}}, intervel,intervel);
		
		
	}
	
	/*閲嶆柊paint*/
	@Override
	public void paint(Graphics g) {
		sky.paintObject(g);	//鐢诲ぉ绌�
		hero.paintObject(g);  //鐢昏嫳闆勬満
		for (int i = 0; i < enemies.length; i++) {
			if(enemies[i] == null) continue;
			else
			enemies[i].paintObject(g); //鐢绘晫浜�
		}
		for (int i = 0; i < bullets.length; i++) {
			bullets[i].paintObject(g);	//鐢诲瓙寮�
		}
		for (int i = 0; i < bulletss.length; i++) {
			bulletss[i].paintObject(g);	//鐢诲瓙寮�
		}
		for (int i = 0; i < bulletsss.length; i++) {
			bulletsss[i].paintObject(g);	//鐢诲瓙寮�
		}
		//鐢诲緱鍒嗘澘
		g.setColor(Color.WHITE);
		g.setFont(new Font("consolas", Font.BOLD, 30));
		g.drawString("SCORE:"+score, 10, 30);
		//鐢荤敓鍛藉��
		g.drawString("LIFE:"+hero.getLife(), 10, 65);
		
		//涓嶅悓鐘舵�佷笅鐢讳笉鍚岀殑鍥�
		switch(state) {
		case START:g.drawImage(start, 0, 0, null);break;
		case PAUSE:g.drawImage(pause, 0, 0, null);break;
		case GAME_OVER:g.drawImage(gameover, 0, 0, null);
						//娣诲姞鏌ヨ鍑烘潵鐨勭敤鎴峰悕鍜屽垎鏁�
			// 娣诲姞鏌ヨ鍑烘潵鐨勭敤鎴峰悕鍜宻core
		g.setColor(Color.black);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			g.drawImage(top,0,0, null);
			g.setFont(new Font("", Font.PLAIN, 20));
//                g.drawString("鎺掕姒�:", 170, 320);
			try {
//                    String[] result; // 缁撴灉鏁扮粍
				UserDao.getScoreAndName();
				int y = 300;
				// 鍙樉绀哄墠10鏉℃暟鎹�
				for (int i = 0; i < 6; i++) {
					// 缁撴灉闆嗕笉涓虹┖
					if (UserDao.resultName[i] != null) {
						g.setFont(new Font("consolas", Font.BOLD, 20));
						g.drawString(UserDao.resultName[i], 135, y);
						g.drawString(UserDao.resultScore[i], 305, y);
						y += 55; // 姣忔潯鏁版嵁闂撮殧涓�30
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;

			
		}
	}
	public static void initialGame() {
		// 瀹炰緥鍖栫獥浣撳璞�
		JFrame jFrame = new JFrame();
		// 瀹炰緥鍖栫敾鏉垮璞�
		ShootGameJPanel sgj = new ShootGameJPanel();
		// 璁剧疆绐楀彛鏍囬
		jFrame.setTitle("Shoot Game");

		// 璁剧疆绐楀彛鐨勯粯璁ゅ叧闂柟寮�-鍏抽棴绐楀彛鏃堕��鍑虹▼搴�
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 璁剧疆绐楀彛鐨勪綅缃強澶у皬
		jFrame.setBounds(jframeX, jframeY, WIDTH, HEIGHT);  // 灞呬腑鏄剧ず

		// 鏄剧ず绐楀彛
		jFrame.setVisible(true);
		// TODO: 灏嗙敾鏉挎坊鍔犲湪绐椾綋瀹瑰櫒涓�
		jFrame.add(sgj);
		// 鍚姩绋嬪簭鎵ц
		sgj.action();
		// 鍚姩鑳屾櫙闊充箰
		new MusicPlayer().start();
	}

	public static void main(String[] args) {
		new LoginJFrame();
	}
	
	
	
	
	
	
	
	
}
