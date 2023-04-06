package cn.book.util;

import cn.book.pojo.User;
import cn.book.service.LoginService;
import cn.book.service.LoginServiceImpl;


/*
* 测试数据库是否连接成功
* */
public class Test1 {
    public static void main(String[] args) {
        String id = "102365";
        String pwd = "111";
        User u = new User();
        u.setUid(id);
        u.setPwd(pwd);
        LoginService ls = new LoginServiceImpl();
        User user = ls.logService(u);
        if(user == null){
            System.out.println("id和密码不一致");
        }else{
            System.out.println(user.toString());
        }

    }

}
