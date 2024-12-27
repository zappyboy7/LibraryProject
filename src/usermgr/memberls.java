package usermgr;

import Data.UserDataSet;
import vo.MemberVo;

public class memberls {
    public memberls(){}
    public void memberlsStart(){
        //tring id, String password, String name, String dept
        System.out.println("id, \tpassword,\t이름,\t\t부서");
        for (MemberVo vo: UserDataSet.memberlist){
            System.out.println(vo.toString());
        }
    }
}
