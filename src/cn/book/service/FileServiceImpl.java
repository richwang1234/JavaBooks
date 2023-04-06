package cn.book.service;

import cn.book.dao.FileDao;
import cn.book.dao.FileDaoImpl;
import cn.book.pojo.Book;
import cn.book.pojo.BookLendType;
import cn.book.pojo.Info;
import cn.book.pojo.User;

import java.util.List;
import java.util.Set;


/*
* 接口实现类
* */
public class FileServiceImpl implements FileService {
    // 调用FileDao具体实现类
    FileDao fd = new FileDaoImpl();
    @Override
    public List<User> getAllUser() {
        //封装--获取数据库中所有的信息
        return fd.getAllUser();
    }

    // 获取管理员的信息
    @Override
    public User getAdmineUser(String admid) {
        // 访问持久层
        return fd.getUserByidOrName(admid);
    }
    // 在服务器中查询--获取目标信息对象
    @Override
    public User getGoalUserFile(String goalFile) {
        if(goalFile.equals("")||goalFile.trim()==null){
            return null;
        }else {
            return fd.getUserByidOrName(goalFile);
        }
    }

    @Override
    public List<Book> getAllBook() {
        return fd.getAllBook();
    }

    @Override
    public List<Book> getBookByNameOrId(String goalFile) {
        return fd.getBookByNameOrId(goalFile);
    }

    @Override
    public void upBookNum(String bookId, String number, String price) {
        fd.upBookNum(bookId,number,price);
    }

    @Override
    public void addBook(String a, String b, String c, String d, String e, String f, String g, String h, String l) {
        fd.addBook(a,b,c,d,e,f,g,h,l);
    }

    @Override
    public List<BookLendType> getLendFile(String bookid) {
        return fd.getLendFile(bookid);
    }

    @Override
    public List<BookLendType> getLendFileByUserName(String username) {
        return fd.getLendFileByUserName(username);
    }

    @Override
    public void lendBook(String bookid,int lendnum,int times) {
        fd.lendBook(bookid,lendnum,times);
    }

    @Override
    public void addLendRecode(String l_id, String bookid, String uid, String ltime) {
        fd.addLendRecode(l_id,bookid,uid,ltime);
    }

    @Override
    public List<BookLendType> getUserfulLendFile(String uid) {
        return fd.getUserfulLendFile(uid);
    }

    @Override
    public String getBookid(String lendid) {
        return fd.getBookid(lendid);
    }

    @Override
    public void retBook(String lendid, String time) {
        fd.retBook(lendid,time);
    }
    @Override
    public void jianjian(String bookid) {
        fd.jianjian(bookid);
    }

    @Override
    public List<BookLendType> getMyLendFile(String deal, String myid) {
        return fd.getMyLendFile(deal,myid);
    }

    @Override
    public void uppwd(String pwd, String myid) {
        fd.uppwd(pwd,myid);
    }

    @Override
    public List<Info> getInfo() {
        return fd.getInfo();
    }

    @Override
    public void insertInfo(String name, String info) {
        fd.insertInfo(name, info);
    }

    @Override
    public void Register(User user) {
        fd.Register(user);
    }

    @Override
    public void delbook(String bookid) {
        fd.delBook(bookid);
    }

    @Override
    public void addCountrecode(String uid) {
        fd.addCountrecode(uid);
    }


}
