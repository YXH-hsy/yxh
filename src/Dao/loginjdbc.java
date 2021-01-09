package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class loginjdbc {

	public static int tologin(String id, String password) {
		int ans = 0;

		Connection conn = null;
		PreparedStatement presta = null;
		ResultSet res = null;
		conn = jdbctool.getconnection();
		String sql = "select * from user where id = ?";
		
		try {
			presta = conn.prepareStatement(sql);
			presta.setString(1, id);
			
			res= presta.executeQuery();
			if(res.next()) {
				ans=1;
				String pa = res.getString("password");
				System.out.println("pa:"+pa);
				if(pa.equals(password)) {
					ans = 1;
				}else ans = 0;
				return ans;
			}else {
				return -1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ans;
	}

}
