package cn.book.pojo;

public class BookLendType {
    private String lend_id;
    private String lend_name;
    private String lend_stime;
    private String lend_rtime;
    private String lend_type;


    public void setLend_id(String lend_id) {
        this.lend_id = lend_id;
    }

    public void setLend_name(String lend_name) {
        this.lend_name = lend_name;
    }

    public void setLend_stime(String lend_stime) {
        this.lend_stime = lend_stime;
    }

    public void setLend_rtime(String lend_rtime) {
        this.lend_rtime = lend_rtime;
    }

    public void setLend_type(String lend_type) {
        this.lend_type = lend_type;
    }

    public String getLend_id() {
        return lend_id;
    }

    public String getLend_name() {
        return lend_name;
    }

    public String getLend_stime() {
        return lend_stime;
    }

    public String getLend_rtime() {
        return lend_rtime;
    }

    public String getLend_type() {
        return lend_type;
    }

    @Override
    public String toString() {
        return "BookLendType{" +
                "lend_id='" + lend_id + '\'' +
                ", lend_name='" + lend_name + '\'' +
                ", lend_stime='" + lend_stime + '\'' +
                ", lend_rtime='" + lend_rtime + '\'' +
                ", lend_type='" + lend_type + '\'' +
                '}';
    }
}
