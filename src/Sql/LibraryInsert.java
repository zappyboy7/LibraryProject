package Sql;

import java.sql.SQLException;
import java.util.Scanner;

public class LibraryInsert extends MysqlDBconnect{
    Scanner scan = new Scanner(System.in);
    public LibraryInsert(){}
    public void libraryInsertStart(){
        //  libno, libname, regidate, rentname, startdate, findate
        try {
            System.out.print("관리번호 : ");
            int libno = Integer.parseInt(scan.nextLine());

            System.out.print("문서이름 : ");
            String libname = scan.nextLine();

            System.out.print("등록일 : (ex 2024-11-11)");
            String regidate = scan.nextLine();

            System.out.print("열람자 : ");
            String rentname = scan.nextLine();

            System.out.print("열람시작일 : (ex 2024-11-11)");
            String startdate = scan.nextLine();

            System.out.print("반납예정일 : (ex 2024-11-11)");
            String findate = scan.nextLine();

            getConnection();
            String sql = "insert into library(libno, libname, regidate, rentname, startdate, findate) values(?,?,?,?,?,?)";

            psmt = conn.prepareStatement(sql);
            psmt.setInt(1,libno);
            psmt.setString(2,libname);
            psmt.setString(3,regidate);
            psmt.setString(4,rentname);
            psmt.setString(5,startdate);
            psmt.setString(6,findate);

            int result = psmt.executeUpdate();
            if(result>0) {
                System.out.println(libname + "등록완료");
            } else {
                System.out.println(libname + "등록실패");
            }

        }catch (SQLException sqe){
            sqe.printStackTrace();
        }catch (Exception e){
            System.out.println("정보를 잘못입력하였슴다");
        }
    }
}
