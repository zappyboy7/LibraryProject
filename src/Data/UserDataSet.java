package Data;

import vo.MemberVo;

import java.util.ArrayList;
import java.util.List;

public class UserDataSet {
    public static List<MemberVo>memberlist = new ArrayList<>();

    public static void setMember(){
        memberlist.add(new MemberVo("admin","1234","관리자","관리부"));
        memberlist.add(new MemberVo("user1","1234","부하1","관리부"));
    }
}
