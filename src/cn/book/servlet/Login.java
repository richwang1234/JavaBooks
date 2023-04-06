package cn.book.servlet;
import cn.book.pojo.Book;
import cn.book.pojo.User;
import cn.book.service.FileService;
import cn.book.service.FileServiceImpl;
import cn.book.service.LoginService;
import cn.book.service.LoginServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.util.List;

@WebServlet("/login")
public class Login extends HttpServlet {
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        // 接收前端传过来的值
        String id = req.getParameter("uid");
        String pwd = req.getParameter("pwd");
        // 创建一个user对象--封装
        User u = new User();
        u.setUid(id);
        u.setPwd(pwd);
        // 用接口--实现类
        LoginService ls = new LoginServiceImpl();
        // 用user接收
        User user = ls.logService(u);

        /*
        * 如果user要是为空--说明了  账户密码不正确 去登陆界面并且提示：账户密码不正确
        *
        * 不为空--说明user有这个人--->要去干相应的事。根据这个给角色进到不同的界面
        * */

        if(user==null){
            // 到登陆界面，并且提示账户密码不正确
            req.setAttribute("error","账户密码不正确");
            req.getRequestDispatcher("login.jsp").forward(req,res);//语句就是回到登陆界面
        }else{
            // 如果账户密码一致，转到主界面
            req.setAttribute("user",user);
            if(user.getRole()==0){
                req.setAttribute("user",user);
                // 地址
                req.setAttribute("mainRight","show.jsp");
                // 跳转页面
                req.getRequestDispatcher("AdmMainPage.jsp").forward(req,res);
            }else{
                req.setAttribute("user",user);
                req.setAttribute("mainRight","usershow.jsp");
                // 跳转页面
                req.getRequestDispatcher("UserMain.jsp").forward(req,res);
            }

        }
    }
}
