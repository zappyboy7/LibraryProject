package Sql;

import java.sql.*;

public class MysqlDBconnect {
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("드라이버 로딩 예외"+e.getMessage());
        }
    }
    //맴버변수
    protected Connection conn = null;
    protected PreparedStatement psmt = null;
    protected ResultSet rs = null;

    String url = "jdbc:mysql://localhost:3306/libraryTest";
    String username = "root";
    String password = "tiger1234";

    public MysqlDBconnect(){}
    //DB연결
    public void getConnection() {
        try {
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException se) {
            System.out.println("db연결 예외발생"+se.getMessage());
        }
    }
    public void setMysqlClose(){
        try {
            if(rs != null) rs.close();
            if(psmt != null) psmt.close();
            if(conn != null) conn.close();
        }catch (Exception e){

        }
    }
}
