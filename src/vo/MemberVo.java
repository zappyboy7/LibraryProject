package vo;

public class MemberVo {
    private String id;
    private String password;
    private String name;
    private String dept;

    public MemberVo(){}
    public MemberVo(String id, String password, String name, String dept){
        this.id=id;
        this.password=password;
        this.name=name;
        this.dept=dept;
    }

    public String toString(){
        return id+"\t"+password+"\t"+name+"\t"+dept;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }
}
