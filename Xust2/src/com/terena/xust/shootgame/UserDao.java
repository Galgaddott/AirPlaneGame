package com.terena.xust.shootgame;

import java.sql.*;



public class UserDao {

	/*瀹氫箟鍩烘湰闈欐�佸睘鎬�*/

	// 瀹氫箟url
	public static String url = "jdbc:mysql://localhost:3306/shootgame";
	// 瀹氫箟鐢ㄦ埛鍚�
	public static String user = "root";
	// 瀹氫箟瀵嗙爜
	public static String password = "galgaddott";
	// 鍔犺浇椹卞姩璺緞
	public static String driver = "com.mysql.jdbc.Driver";
	// 瀹氫箟杩炴帴瀵硅薄
	public static Connection connection;
	// 瀹氫箟浼犺緭鍣ㄥ璞�
	public static Statement statement;

	/*鑷畾涔夋柟娉�-鑾峰彇浼犺緭鍣�*/
	public static void DBConnetion() throws Exception {
		//1 娉ㄥ唽鏁版嵁搴撻┍鍔�
		Class.forName(driver);
		//2 鑾峰彇鏁版嵁搴撹繛鎺�
		connection = DriverManager.getConnection(url, user, password);
//        if(connection != null) {
//            System.out.println("connect succeed");
//        }
		//3 鑾峰彇浼犺緭鍣�
		statement = connection.createStatement();
	}

	/*鑷畾涔夋柟娉曞皢shootgame寰楀垎瀛樺叆shootgame鏁版嵁搴�*/
	public static void saveScore(String username, int score) throws Exception {
		// 鑾峰彇浼犺緭鍣�
		try{
			DBConnetion();
			String sql = "insert into score"
					+ "(username,score)"
					+ " values('"+username+"',"+score+")";
			// 鍒╃敤浼犺緭鍣ㄥ皢sql浼犲叆鏁版嵁搴�
			statement.executeUpdate(sql);
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			connection.close();
		}
	}

	public static String[] resultName = new String[500];
	public static String[] resultScore = new String[500];
	/*灏嗘暟鎹簱涓殑鍚嶅瓧鍜屽垎鏁拌繘琛屾煡鎵�*/
	public static void getScoreAndName() throws Exception {
		// 缁撴灉闆�
		ResultSet rs = null;
		// 瀹氫箟String绫诲瀷鐨勬暟缁�

		try {
			// 鑾峰彇浼犺緭鍣�
			DBConnetion();
			// 缂栧啓sql璇彞-闄嶅簭鏌ヨ
			String sql = "select username, score from score order by score desc";
			// 灏唖ql浼犺緭鍒版暟鎹簱
			rs = statement.executeQuery(sql);
			for (int i = 0; i < resultName.length; i++) {
				if(rs.next()) {
					resultName[i] = rs.getString("username");
					resultScore[i] = rs.getString("score");
				}
			}

		}catch (Exception e){
			e.printStackTrace();
		}finally {
			connection.close();
			rs.close();
		}
		//return resultName;
	}

	/*鑷畾涔夋柟娉曞皢鐢ㄦ埛鍚嶅拰瀵嗙爜浼犲叆鏁版嵁搴�*/
	public static void saveUser(String username, String password) throws Exception {
		// 鑾峰彇浼犺緭鍣�
		try{
			DBConnetion();
			String sql = "insert into user"
					+ "(username,password)"
					+ " values('" + username + "'," + password +")";
			// 鍒╃敤浼犺緭鍣ㄥ皢sql浼犲叆鏁版嵁搴�
			statement.executeUpdate(sql);
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			connection.close();
		}
	}

	/*灏嗘暟鎹簱涓殑鍚嶅瓧鍜屽垎鏁拌繘琛屾煡鎵�*/
	public static boolean checkUserNameSame(String username) throws Exception {
		// 缁撴灉闆�
		ResultSet rs = null;
		// 瀹氫箟String绫诲瀷鐨勬暟缁�
		boolean isSame = false;
		try {
			// 鑾峰彇浼犺緭鍣�
			DBConnetion();
			// 缂栧啓sql璇彞-闄嶅簭鏌ヨ
			String sql = "select username from user where username = '"+ username +"'";
			// 灏唖ql浼犺緭鍒版暟鎹簱
			rs = statement.executeQuery(sql);
			if(rs.next()){
				isSame = true;
			} else {
				isSame = false;
			}

		}catch (Exception e){
			e.printStackTrace();
		}finally {
			connection.close();
			rs.close();
		}
		return isSame;
	}

	public static boolean isMatch(String username, String password) throws Exception {
		// 缁撴灉闆�
		ResultSet rs = null;
		boolean isMatch = false;  // 鍖归厤
		try {
			// 鑾峰彇浼犺緭鍣�
			DBConnetion();
			// 缂栧啓sql璇彞
			String sql = "select username from user where username = '"+ username +"' and password = '" + password + "'";
			// 灏唖ql浼犺緭鍒版暟鎹簱
			rs = statement.executeQuery(sql);

			// 缁撴灉闆嗕笉涓虹┖ 璇存槑鏈夊尮閰嶉」
			if(rs.next()){
				isMatch = true;
			} else {
				isMatch = false;
			}

		}catch (Exception e){
			e.printStackTrace();
		}finally {
			connection.close();
			rs.close();
		}
		return isMatch;
	}

	public static void updateScore(String username, int score) throws SQLException {
		// 缁撴灉闆�
		ResultSet rs = null;
		// 瀹氫箟String绫诲瀷鐨勬暟缁�
		try {
			// 鑾峰彇浼犺緭鍣�
			DBConnetion();
			// 缂栧啓sql璇彞-闄嶅簭鏌ヨ
			String sql = "select score from score where username = '"+ username +"'";
			// 灏唖ql浼犺緭鍒版暟鎹簱
			rs = statement.executeQuery(sql);

			/*鏇存柊鎴愮哗-鏍稿績绠楁硶*/
			if(rs.first()){
				// TODO: 濡傛灉瀛樺湪锛屽厛姣旇緝澶у皬鐒跺悗鍒犻櫎锛岄毦鐐瑰湪浜庡浣曞幓闄s閲岀殑绗竴鏉℃暟鎹�
				int hisScore = rs.getInt(1);
				if( hisScore < score){  // 褰撳墠鍒嗘暟澶т簬鍘嗗彶鎴愮哗
					// 鍒犻櫎鍘嗗彶鎴愮哗
					sql = "delete from score where username = '"+ username +"'";
					statement.execute(sql);
					// 灏嗘柊鐨勫垎鏁版彃鍏�
					saveScore(username, score);
				}
			} else { // 鐢ㄦ埛鍚嶄笉瀛樺湪鐩存帴淇濆瓨鎴愮哗
				saveScore(username, score);
			}

		}catch (Exception e){
			e.printStackTrace();
		}finally {
			connection.close();
			rs.close();
		}

	}
}
