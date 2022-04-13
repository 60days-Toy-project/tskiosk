package test222;

import java.sql.*;

public class Database {
	public static Connection getConnection(){
		//서버 연결
		Connection conn = null;
		      
		String url = "";
		String user = "";
		String passwd = "";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		    conn = DriverManager.getConnection(url,user,passwd);
		    System.out.println("서버 연결 성공");
		    } catch(Exception e) {
		    	System.out.println("서버 연결 실패 > "+e.toString());
		    	}
		return conn;
		
	}
    public static void close(PreparedStatement stmt, Connection conn) {
        if (stmt != null) {
            try {
                if (!stmt.isClosed())
                    stmt.close();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                stmt = null;
            }
        }

        if (conn != null) {
            try {
                if (!conn.isClosed())
                    conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                conn = null;
            }
        }
    }

    public static void close(ResultSet rs, PreparedStatement stmt, Connection conn) {
        if (rs != null) {
            try {
                if (!rs.isClosed())
                    rs.close();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                rs = null;
            }
        }

        if (stmt != null) {
            try {
                if (!stmt.isClosed())
                    stmt.close();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                stmt = null;
            }
        }
        if (conn != null) {
            try {
                if (!conn.isClosed())
                    conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                conn = null;
            }
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		getConnection();
	}

}
