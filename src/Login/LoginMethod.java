package Login;

import Data.UserDataSet;
import com.sun.tools.javac.Main;
import vo.MemberVo;

import java.util.Scanner;

public class LoginMethod {
    public LoginMethod() {}
    public static boolean conti = false;
    public static void loginStart(){
        Scanner scan = new Scanner(System.in);
        UserDataSet.setMember();
            //UserDataSet.memberlist.get(0);

            int i = 0;

            do{
                MemberVo vo = new MemberVo();
/*
    깃 테스트용 주석 문구입니다.
 */

                System.out.print("아이디 : ");
                String idInput = scan.nextLine();

                System.out.print("비밀번호 : ");
                String passwordInput = scan.nextLine();

                if (idInput.equals(UserDataSet.memberlist.get(0).getId()) && passwordInput.equals(UserDataSet.memberlist.get(0).getPassword())) {
                    System.out.println("로그인 성공");
                    conti=true;
                }
                else {
                /*
                else if (!idInput.equals(UserDataSet.memberlist.get(0).getId()) || !passwordInput.equals(UserDataSet.memberlist.get(0).getPassword())) {
                i += 1;
                System.out.println("로그인실패" + (5 - i) + "로그인가능");
                    if(i==5){
                        System.out.println("로그인실패 프로그램종료");
                        System.exit(0);
                        conti = 0;
                    }
                }*/
                    int idx = -1;
                    for (i = 0; i < UserDataSet.memberlist.size(); i++) {
                        if (idInput.equals(UserDataSet.memberlist.get(i).getId()) && passwordInput.equals(UserDataSet.memberlist.get(i).getPassword())) {
                            idx = i;
                            break;
                        }
                    }
                    if (idx != -1) {
                        System.out.println("사용자 로그인 성공");
                        conti=false;
                        break;
                    }
                }
        }while(!conti);
    }
}
