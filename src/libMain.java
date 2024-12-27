import Login.LoginMethod;
import Sql.*;
import usermgr.memberIn;
import usermgr.memberls;

import java.util.Scanner;

import static Data.UserDataSet.memberlist;

public class libMain {
    Scanner scan = new Scanner(System.in);
    public libMain(){}
    public void mainStart(){
        LoginMethod.loginStart();
        boolean logout = false;
        if(LoginMethod.conti) {
            do {
                System.out.print("메뉴 [1.관리목록 2.관리등록 3.목록수정 4.관리반납 5.회원목록 6.회원등록 9. 로그아웃 0.프로그램종료]==>");
                int menu = Integer.parseInt(scan.nextLine());
                switch (menu) {
                    case 1:
                        LibrarySelect lsel = new LibrarySelect();
                        lsel.libraryselect();
                        break;
                    case 2:
                        LibraryInsert lins = new LibraryInsert();
                        lins.libraryInsertStart();
                        break;
                    case 3:
                        LibUpdate liud = new LibUpdate();
                        liud.LibUpdateStart();
                        break;
                    case 4:
                        LibDelete lide = new LibDelete();
                        lide.libDeleteStart();
                        break;
                    case 5:
                        memberls mls = new memberls();
                        mls.memberlsStart();
                        break;
                    case 6:
                        memberIn mi = new memberIn();
                        mi.memberInStart();
                        break;
                    case 9:
                        logout=true;
                        break;
                    case 0:
                        System.out.println("프로그램 종료");
                        MysqlDBconnect mydbclose = new MysqlDBconnect();
                        mydbclose.setMysqlClose();
                        System.exit(0);
                }
                if(logout) break;
            } while (true);
            if(logout) {
                mainStart();
            }
        }
        else {
            do {
                System.out.println("대충 사용자기능");
                System.out.print("메뉴 [1.관리목록 2.관리등록 0.프로그램종료]==>");
                int menu = Integer.parseInt(scan.nextLine());
                switch (menu) {
                    case 1:
                        LibrarySelect lsel = new LibrarySelect();
                        lsel.libraryselect();
                        break;
                    case 2:
                        System.out.println("!!!?");
                        LibraryInsert lins = new LibraryInsert();
                        lins.libraryInsertStart();
                        break;
                    case 9:
                        logout = true;
                        break;
                    case 0:
                        System.out.println("프로그램 종료");
                        MysqlDBconnect mydbclose = new MysqlDBconnect();
                        mydbclose.setMysqlClose();
                        System.exit(0);
                }
                if(logout) break;
            }while (true);
            if(logout) {
                mainStart();
            }
        }
    }

    public static void main(String[] args) {
     new libMain().mainStart();
    }
}


