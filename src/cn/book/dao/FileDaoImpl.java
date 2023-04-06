package cn.book.dao;

import cn.book.pojo.Book;
import cn.book.pojo.BookLendType;
import cn.book.pojo.Info;
import cn.book.pojo.User;
import cn.book.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FileDaoImpl implements FileDao{

    // FilServiceImpl服务层到Dao持久层
    // 数据库中所有信息的查询
    @Override
    public List<User> getAllUser() {
        // 是一个列表形式
        List<User> arr = new ArrayList<User>();
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement pre = null;
        ResultSet res = null;
        try {
            String sql = "select * from user where u_id!=0";
            System.out.println(sql);
            try {
                pre = connection.prepareStatement(sql);
                res = pre.executeQuery();
                while (res.next()){
                    User u = new User();
                    u.setUid(res.getString("u_id"));
                    u.setName(res.getString("u_name"));
                    u.setSex(res.getString("u_sex"));
                    u.setIdcard(res.getString("u_idcard"));
                    u.setU_times(res.getInt("u_times"));
                    u.setPwd(res.getString("u_pwd"));
                    u.setState(res.getInt("u_state"));
                    u.setRole(res.getInt("u_role"));
                    arr.add(u);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return arr;
    }

    // 数据库中管理员信息的查询
    @Override
    public User getUserByidOrName(String admid) {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement pre = null;
        ResultSet res = null;
        User u = null;
        try {
            String sql = "select * from `user` where u_id='"+admid+"' or u_name like '%"+admid+"%'";
            System.out.println(sql);
            try {
                pre = connection.prepareStatement(sql);
                res = pre.executeQuery();
                while (res.next()){
                    u = new User();
                    u.setUid(res.getString("u_id"));
                    u.setName(res.getString("u_name"));
                    u.setSex(res.getString("u_sex"));
                    u.setIdcard(res.getString("u_idcard"));
                    u.setU_times(res.getInt("u_times"));
                    u.setPwd(res.getString("u_pwd"));
                    u.setState(res.getInt("u_state"));
                    u.setRole(res.getInt("u_role"));
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


        return u;
    }
    // 图书表的信息
    @Override
    public List<Book> getAllBook() {
        List<Book> arr = new ArrayList<Book>();
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement pre = null;
        ResultSet res = null;
        try {
            String sql = "select * from books";
            try {
                pre = connection.prepareStatement(sql);
                res = pre.executeQuery();
                while (res.next()){
                    Book book = new Book();
                    book.setBook_id(res.getString("book_id"));
                    book.setBook_name(res.getString("book_name"));
                    book.setBook_type(res.getString("book_type"));
                    book.setBook_num(res.getString("book_num"));
                    book.setBook_price(res.getDouble("book_price"));
                    book.setBook_lend(res.getInt("book_lend"));
                    book.setBook_ISBN(res.getString("book_ISBN"));
                    book.setBook_address(res.getString("book_address"));
                    book.setBook_business(res.getString("book_business"));
                    book.setBook_author(res.getString("book_author"));
                    book.setBook_edition(res.getString("book_edition"));
                    book.setBook_times(res.getInt("book_times"));
                    arr.add(book);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arr;
    }

    @Override
    public List<Book> getBookByNameOrId(String goalFile) {
        System.out.println(goalFile);
        List<Book> arr = new ArrayList<Book>();
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement pre = null;
        ResultSet res = null;
        try {
            String sql = "select * from books where book_id='"+goalFile+"' or book_name like '%"+goalFile+"%' or book_type like '%"+goalFile+"%'";
            System.out.println(sql);
            try {
                pre = connection.prepareStatement(sql);
                res = pre.executeQuery();
                while (res.next()){
                    Book book = new Book();
                    book.setBook_id(res.getString("book_id"));
                    book.setBook_name(res.getString("book_name"));
                    book.setBook_type(res.getString("book_type"));
                    book.setBook_num(res.getString("book_num"));
                    book.setBook_price(res.getDouble("book_price"));
                    book.setBook_lend(res.getInt("book_lend"));
                    book.setBook_ISBN(res.getString("book_ISBN"));
                    book.setBook_address(res.getString("book_address"));
                    book.setBook_business(res.getString("book_business"));
                    book.setBook_author(res.getString("book_author"));
                    book.setBook_edition(res.getString("book_edition"));
                    book.setBook_times(res.getInt("book_times"));
                    arr.add(book);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arr;
    }

    @Override
    public void upBookNum(String bookId, String number, String price) {
        /*
        * 这个地方对数据库是不是就是 改变数据库
        * 不是查询数据库
        * 所以 我们在这个地方写相应的sql语句
        * 然后设置以后函数专门处理sql语句
        *
        * */
        String sql = "UPDATE books SET book_num="+number+",book_price="+price+" WHERE book_id='"+bookId+"'";
        deal(sql);



    }

    @Override
    public void addBook(String a, String b, String c, String d, String e, String f, String g, String h, String l) {

        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
        String bid = "b"+sdf.format(date);
        String sql = "insert into books values('"+bid+"','"+a+"','"+b+"',"+c+","+d+",0,'"+e+"','"+f+"','"+g+"','"+h+"','"+l+"',0)";
        deal(sql);
    }

    public List<BookLendType> getLendFiles(String sql){
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement pre = null;
        ResultSet res = null;
        List<BookLendType> list = null;
        try {
            try {
                list = new ArrayList<BookLendType>();
                pre = connection.prepareStatement(sql);
                res = pre.executeQuery();
                while (res.next()){
                    BookLendType blt = new BookLendType();
                    blt.setLend_id(res.getString("a"));
                    blt.setLend_name(res.getString("b"));
                    blt.setLend_stime(res.getString("c"));
                    blt.setLend_rtime(res.getString("d"));
                    blt.setLend_type(res.getString("e"));
                    list.add(blt);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;

    }


    @Override
    public List<BookLendType> getLendFile(String bookid) {
        //SELECT l_id a,u_name b,l_ltime c,IF(l_rtime IS NULL,'*',l_rtime ) AS d,IF(l_state = 0,'未归','归还') e
        //FROM booklend,`user` WHERE l_uid=u_id AND l_bookid = 'b101121'
        String sql = null;

        if(bookid.equals("all")){
            sql = "SELECT l_id a,book_name b,l_ltime c,IF(l_rtime IS NULL,'*',l_rtime ) d,IF(l_state = 0,'未归','归还') e FROM booklend,books WHERE  l_bookid=book_id";
        }else if(bookid.equals("retBook")) {//归还的图书
            sql = "SELECT l_id a,book_name b,l_ltime c,IF(l_rtime IS NULL,'*',l_rtime ) d,IF(l_state = 0,'未归','归还') e FROM booklend,books WHERE  l_bookid=book_id  AND l_state=0";
        }else if(bookid.equals("unretBook")){
            sql = "SELECT l_id a,book_name b,l_ltime c,IF(l_rtime IS NULL,'*',l_rtime ) d,IF(l_state = 0,'未归','归还') e FROM booklend,books WHERE  l_bookid=book_id  AND l_state=1";
        }
        else{
            sql="SELECT l_id a,u_name b,l_ltime c,IF(l_rtime IS NULL,'*',l_rtime ) AS d,IF(l_state = 0,'未归','归还') e FROM booklend,`user` WHERE l_uid=u_id AND l_bookid = '"+bookid+"'";
        }

        return getLendFiles(sql);
    }

    @Override
    public List<BookLendType> getLendFileByUserName(String username) {
        String sql="SELECT l_id a,book_name b,l_ltime c,IF(l_rtime IS NULL,'*',l_rtime ) d,IF(l_state = 0,'未归','归还') e FROM booklend,books WHERE  l_bookid=book_id  AND l_uid IN(SELECT u_id l_uid FROM `user` WHERE u_name='"+username+"');";
        return getLendFiles(sql);
    }

    @Override
    public void lendBook(String bookid,int lendnum,int times) {
        String sql = "UPDATE books SET book_lend="+lendnum+",book_times="+times+" WHERE book_id='"+bookid+"'";
        deal(sql);
    }

    @Override
    public void addLendRecode(String l_id, String bookid, String uid, String ltime) {
        String sql = "INSERT INTO booklend VALUES('"+l_id+"','"+bookid+"','"+uid+"','"+ltime+"',NULL,0)";
        deal(sql);
    }

    @Override
    public List<BookLendType> getUserfulLendFile(String uid) {
        /*
        *
        * 使用当前用户id来进行搜索
        * */
        String sql = "SELECT l_id a,book_name b,l_ltime c,IF(l_rtime IS NULL,'*',l_rtime ) d,IF(l_state = 0,'未归','归还') e FROM booklend,books WHERE  l_bookid=book_id  AND l_uid='"+uid+"'";
        return getLendFiles(sql);
    }

    @Override
    public String getBookid(String lendid) {
        String sql = "SELECT l_bookid AS a FROM booklend WHERE l_id='"+lendid+"'";
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement pre = null;
        ResultSet res = null;
        List<BookLendType> list = null;
        String bookid=null;
        try {
            try {
                list = new ArrayList<BookLendType>();
                pre = connection.prepareStatement(sql);
                res = pre.executeQuery();
                while (res.next()){
                    bookid = res.getString("a");
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bookid;
    }

    @Override
    public void retBook(String lendid, String time) {
        String sql = "UPDATE booklend SET l_rtime ='"+time+"',l_state=1 WHERE l_id='"+lendid+"'";
        deal(sql);
    }

    @Override
    public void jianjian(String bookid) {
        String sql="UPDATE books SET book_lend=(book_lend+1) WHERE book_id ='"+bookid+"'";
        deal(sql);
    }

    @Override
    public List<BookLendType> getMyLendFile(String deal, String myid) {


        String sql = null;

        if(deal.equals("all")){
            sql = "SELECT l_id a,book_name b,l_ltime c,IF(l_rtime IS NULL,'*',l_rtime ) d,IF(l_state = 0,'未归','归还') e FROM booklend,books WHERE  l_bookid=book_id AND l_uid='"+myid+"'";
        }else if(deal.equals("retBook")) {//归还的图书
            sql = "SELECT l_id a,book_name b,l_ltime c,IF(l_rtime IS NULL,'*',l_rtime ) d,IF(l_state = 0,'未归','归还') e FROM booklend,books WHERE  l_bookid=book_id  AND l_state=0 AND l_uid='"+myid+"'";
        }else if(deal.equals("unretBook")){
            sql = "SELECT l_id a,book_name b,l_ltime c,IF(l_rtime IS NULL,'*',l_rtime ) d,IF(l_state = 0,'未归','归还') e FROM booklend,books WHERE  l_bookid=book_id  AND l_state=1 AND l_uid='"+myid+"'";
        }

        return getLendFiles(sql);
    }

    @Override
    public void uppwd(String pwd, String myid) {
        String sql = "UPDATE `user` SET u_pwd='"+pwd+"' WHERE u_id = '"+myid+"'";
        deal(sql);
    }

    @Override
    public List<Info> getInfo() {



        String sql = "select * from info";
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement pre = null;
        ResultSet res = null;
        List<Info> arr = null;
        try {
            try {
                arr = new ArrayList<Info>();
                pre = connection.prepareStatement(sql);
                res = pre.executeQuery();
                while (res.next()){
                    Info info = new Info();
                    info.setName(res.getString("name"));
                    info.setInfo(res.getString("info"));
                    arr.add(info);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arr;
    }

    @Override
    public void insertInfo(String name, String info) {
        String sql = "insert info values('"+name+"','"+info+"')";
        System.out.println(sql);
        deal(sql);
    }

    @Override
    public void Register(User user) {
        String sql = "INSERT `user` VALUES('"+user.getUid()+"','"+user.getName()+"','"+user.getSex()+"','"+user.getIdcard()+"',0,'"+user.getPwd()+"',0,1)";
        deal(sql);
    }

    @Override
    public void delBook(String bookid) {
        String sql = "DELETE FROM books WHERE book_id='"+bookid+"'";
        deal(sql);
    }

    @Override
    public void addCountrecode(String uid) {

        String sql = "UPDATE `user` SET u_times=u_times+1 WHERE u_id='"+uid+"'";
        deal(sql);
    }

    private void deal(String sql) {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement pre = null;
        ResultSet res = null;
            try {
                    pre = connection.prepareStatement(sql);
                    pre.executeUpdate();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
    }
}