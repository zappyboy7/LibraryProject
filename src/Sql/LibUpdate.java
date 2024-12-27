package Sql;

import java.util.Scanner;

public class LibUpdate extends MysqlDBconnect {
    Scanner scan = new Scanner(System.in);
    public LibUpdate(){}
    public void LibUpdateStart(){

        try {
            System.out.print("수정할 기록번호 : ");
            String libno = scan.nextLine();
            System.out.print("수정할 항목 [1.대출인 2.반납예정일]");
            String field = scan.nextLine();

            String data = null;

            if(field.equals("1")){
                System.out.println("수정할 대출인 = ");
                data = scan.nextLine();
            }else if(field.equals("2")) {
                System.out.println("수정할 반납예정일");
                data = scan.nextLine();
            }
             // sql 입력

                String sql = "update library set ";
                if(field.equals("1")) sql += " rentname";
                else sql += " findate";
                sql += " = ? where libno = ?";

                getConnection();
                psmt = conn.prepareStatement(sql);

                if(field.equals("1")) psmt.setString(1,data);
                else psmt.setString(2,data);

                psmt.setString(2,libno);

                int result = psmt.executeUpdate();
                if(result>0) System.out.println("수정완료");
                else System.out.println("수정실패");

            }catch (Exception e){
            System.out.println("수정예외발생"+ e.getMessage());
        }
        }
    }
