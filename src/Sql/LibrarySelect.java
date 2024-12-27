package Sql;

import java.sql.*;

public class LibrarySelect {
    public LibrarySelect() {
    }

    public void libraryselect() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/libraryTest";
            String username = "root";
            String password = "tiger1234";
            conn = DriverManager.getConnection(url, username, password);

            String sql = "select libno, libname, regidate, rentname, startdate, findate from library order by libno asc";
            pstmt = conn.prepareStatement(sql);

            rs = pstmt.executeQuery();
            while (rs.next()) {
                int libno = rs.getInt(1);
                String libname = rs.getString(2);
                String regidate = rs.getString(3);
                String rentname = rs.getString(4);
                String startdate = rs.getString(5);
                String findate = rs.getString(6);

                System.out.printf("%d %s %20s %6s %20s %20s\n", libno, libname, regidate, rentname, startdate, findate);
            }
        } catch (ClassNotFoundException cnfe) {
            System.out.println("드라이브로딩 예외발생...");
            cnfe.printStackTrace();
        } catch (SQLException se) {
            System.out.println("DB연결예외 발생...");
            se.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
            }
        }
    }
}