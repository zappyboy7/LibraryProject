package test;

import vo.MemberVo;

import java.util.ArrayList;
import java.util.List;

public class UserDataSet2 {
    public static List<MemberVo>memberlist = new ArrayList<>();

    public static void setMember2(){
        memberlist.add(new MemberVo("user1","1234","부하1","관리부"));
    }
}
