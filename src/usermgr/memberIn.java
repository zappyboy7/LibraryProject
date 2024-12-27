package usermgr;

import vo.MemberVo;
import Data.UserDataSet;

import java.util.Scanner;
//tring id, String password, String name, String dept
public class memberIn {
    public memberIn(){}
    public void memberInStart(){
        Scanner scan = new Scanner(System.in);
        MemberVo vo = new MemberVo();
        System.out.print("id입력=");
        vo.setId(scan.nextLine());
        System.out.print("password입력=");
        vo.setPassword(scan.nextLine());
        System.out.print("이름입력=");
        vo.setName(scan.nextLine());
        System.out.print("부서입력=");
        vo.setDept(scan.nextLine());

        UserDataSet.memberlist.add(vo);
        System.out.println(vo.getName()+" 등록완료");
    }
}
