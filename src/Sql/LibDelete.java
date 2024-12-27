package Sql;

import java.sql.*;
import java.util.Scanner;

public class LibDelete extends MysqlDBconnect {

    public void LibDelete(){}

    public void libDeleteStart(){

        Scanner scan=new Scanner(System.in);
        Connection conn = null;
        PreparedStatement psmt = null;
        ResultSet rs = null;

        try {
            System.out.print("반납할 기록번호 : ");
            String inputLibno = scan.nextLine();

            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/libraryTest";
            String username = "root";
            String password = "tiger1234";
            conn = DriverManager.getConnection(url, username, password);

            String sqlst = "select libno, libname, regidate, rentname, startdate, findate from library where libno = ?";
            getConnection();
            psmt = conn.prepareStatement(sqlst);
            psmt.setString(1,inputLibno);

            rs = psmt.executeQuery();
            while (rs.next()) {
                int libno = rs.getInt(1);
                String libname = rs.getString(2);
                String regidate = rs.getString(3);
                String rentname = rs.getString(4);
                String startdate = rs.getString(5);
                String findate = rs.getString(6);

                System.out.printf("%d %s %20s %6s %20s %20s\n", libno, libname, regidate, rentname, startdate, findate);

                getConnection();
                String sqllog = "INSERT INTO loglib(libno, libname, regidate, rentname, startdate, findate) VALUES(?,?,?,?,?,?)";

                psmt = conn.prepareStatement(sqllog);
                psmt.setInt(1, libno);
                psmt.setString(2, libname);
                psmt.setString(3, regidate);
                psmt.setString(4, rentname);
                psmt.setString(5, startdate);
                psmt.setString(6, findate);

                int result = psmt.executeUpdate();
                if(result>0) {
                    System.out.println(libname + "반납처리완료");
                } else {
                    System.out.println(libname + "등록실패");
                }

           String sqlup = "update library set rentname = 0, startdate = null, findate= null where libno = ?";

            getConnection();
           psmt = conn.prepareStatement(sqlup);

            psmt.setString(1,inputLibno);

            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException sqe) {
            sqe.printStackTrace();
            System.out.println(sqe.getMessage());
        }
    }
}
