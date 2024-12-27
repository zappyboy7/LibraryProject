package test;

import Data.UserDataSet;
import vo.MemberVo;

import java.util.Scanner;

public class LoginMethod2 {
    public LoginMethod2() {}
    public static int conti = 0;
    public static void loginStart2() {
        Scanner scan = new Scanner(System.in);
        UserDataSet.setMember();

        int i = 0;
        conti = 0;
        do {
            System.out.print("아이디 : ");
            String idInput = scan.nextLine();

            System.out.print("비밀번호 : ");
            String passwordInput = scan.nextLine();

                for (int j = 0; j < UserDataSet2.memberlist.size(); j++) {
                    MemberVo vo = UserDataSet2.memberlist.get(j);

                    if (vo.getId().equals(idInput) && vo.getPassword().equals(passwordInput)) {
                        conti = 2;
                        break;
                    } else if (!vo.getId().equals(idInput) || !vo.getPassword().equals(passwordInput)) {
                        System.out.println("아이디 혹은 비밀번호 오류");
                        conti = 0;
                    }
                }
        } while (conti == 0) ;
    }

    public static void main(String[] args) {
        LoginMethod2 lm2 = new LoginMethod2();
        lm2.loginStart2();
    }
}
