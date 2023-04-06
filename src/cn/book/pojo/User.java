package cn.book.pojo;


/*
*用户字段--数据库
* get方法、set方法、含参构造
*
* **/
public class User {
    private String uid;
    private String name;
    private String sex;
    private String idcard;
    private int u_times;
    private String pwd;
    private int state;
    private int role;
    public User(){}

    public User(String uid, String name, String sex, String idcard, int u_times, String pwd, int state, int role) {
        this.uid = uid;
        this.name = name;
        this.sex = sex;
        this.idcard = idcard;
        this.u_times = u_times;
        this.pwd = pwd;
        this.state = state;
        this.role = role;
    }

    public String getUid() {
        return uid;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public String getIdcard() {
        return idcard;
    }

    public int getU_times() {
        return u_times;
    }

    public String getPwd() {
        return pwd;
    }

    public int getState() {
        return state;
    }

    public int getRole() {
        return role;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public void setU_times(int u_times) {
        this.u_times = u_times;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public void setState(int state) {
        this.state = state;
    }

    public void setRole(int role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid='" + uid + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", idcard='" + idcard + '\'' +
                ", u_times=" + u_times +
                ", pwd='" + pwd + '\'' +
                ", state='" + state + '\'' +
                ", role=" + role +
                '}';
    }
}
