package cn.book.servlet;

import cn.book.pojo.Book;
import cn.book.pojo.BookLendType;
import cn.book.pojo.Info;
import cn.book.pojo.User;
import cn.book.service.FileService;
import cn.book.service.FileServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet("/ufiledeal")
public class UserFileServlet extends HttpServlet {
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        //window.location.href = "ufiledeal?action=goHead&myid="+${user.getUid()};
        String myid = req.getParameter("myid");
        FileService fs = new FileServiceImpl();
        User user = fs.getAdmineUser(myid);

        String deal = req.getParameter("action");

        if(deal.equals("goHead")){
            req.setAttribute("user",user);
            req.setAttribute("mainRight","usershow.jsp");
            req.getRequestDispatcher("UserMain.jsp").forward(req,res);
        }else if(deal.equals("gouserBookLook")){
            //window.location.href = "ufiledeal?action=userBookLook&admid="+${user.getUid()};
            List<Book> arr = fs.getAllBook();
            req.setAttribute("arr",arr);
            req.setAttribute("user",user);
            req.setAttribute("mainRight","userBookLook.jsp");
            req.getRequestDispatcher("UserMain.jsp").forward(req,res);
        }else if(deal.equals("bookSearch")){
            String file = req.getParameter("goalFile");
            List<Book> arr = fs.getBookByNameOrId(file);
            req.setAttribute("arr",arr);
            req.setAttribute("user",user);
            req.setAttribute("mainRight","userBookLook.jsp");
            req.getRequestDispatcher("UserMain.jsp").forward(req,res);

        }else if(deal.equals("lookbookall")){
            //sign="+v;
            String sign = req.getParameter("sign");
            Book book = fs.getBookByNameOrId(sign).get(0);
            req.setAttribute("user",user);
            req.setAttribute("book",book);
            req.setAttribute("mainRight","bookshow.jsp");
            req.getRequestDispatcher("UserMain.jsp").forward(req,res);
        }else if(deal.equals("lendBook")){//lendBook
            //bookid="+m;
            String bookid = req.getParameter("bookid");
            Book book = fs.getBookByNameOrId(bookid).get(0);
            fs.lendBook(bookid,book.getBook_lend()+1,book.getBook_times()+1);
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
            String l_id = "l"+sdf.format(date);
            sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            String ltime = sdf.format(date);


            fs.addLendRecode(l_id,bookid,user.getUid(),ltime);

            List<Book> arr = fs.getAllBook();
            req.setAttribute("arr",arr);
            req.setAttribute("user",user);
            req.setAttribute("mainRight","userBookLook.jsp");
            req.getRequestDispatcher("UserMain.jsp").forward(req,res);
        }else if(deal.equals("goUserLendRecode")){
            List<BookLendType> arr = fs.getUserfulLendFile(user.getUid());

            req.setAttribute("arr",arr);
            req.setAttribute("user",user);
            req.setAttribute("mainRight","userLendRecode.jsp");
            req.getRequestDispatcher("UserMain.jsp").forward(req,res);
        }else if(deal.equals("UserRetBook")){
            //ufiledeal?action=UserRetBook&myid=102366&lendid=l20224160805



            // &lendid="+v;
            String lendid = req.getParameter("lendid");
            //现在只有一个 借阅id

            //首先要用这个借阅id来获取一下图书的id
            String bookid = fs.getBookid(lendid);
            //1.借书记录表的数据要改为 已经还书 0
            ////  UPDATE booklend SET l_rtime ='2022-4-16 18:40:50',l_state=1 WHERE l_id='l25658965235'
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            String time = sdf.format(date);
            fs.retBook(lendid,time);


            //2.图书表的这本书的借阅次数要减少1
            //UPDATE books SET book_lend=(book_lend+1) WHERE book_id ='2111'
            fs.jianjian(bookid);

            //
            fs.addCountrecode(user.getUid());

            List<BookLendType> arr = fs.getUserfulLendFile(user.getUid());
            req.setAttribute("arr",arr);
            req.setAttribute("user",user);
            req.setAttribute("mainRight","userLendRecode.jsp");
            req.getRequestDispatcher("UserMain.jsp").forward(req,res);
        }else if(deal.equals("retBook")||deal.equals("unretBook")||deal.equals("all")){
            List<BookLendType> arr = fs.getMyLendFile(deal,myid);
            req.setAttribute("arr",arr);
            req.setAttribute("user",user);
            req.setAttribute("mainRight","userLendRecode.jsp");
            req.getRequestDispatcher("UserMain.jsp").forward(req,res);
        }else if(deal.equals("goMyFile")){
            req.setAttribute("user",user);
            req.setAttribute("mainRight","Myfile.jsp");
            req.getRequestDispatcher("UserMain.jsp").forward(req,res);
        }else if(deal.equals("touppwd")){

            req.setAttribute("user",user);
            req.setAttribute("mainRight","uppwd.jsp");
            req.getRequestDispatcher("UserMain.jsp").forward(req,res);

        }else if(deal.equals("uppwd")){
            //ufiledeal?action=uppwd&pwd="+a+"&myid=${user.getUid()}
            String pwd = req.getParameter("pwd");
            fs.uppwd(pwd,myid);

            req.setAttribute("user",user);
            req.setAttribute("mainRight","usershow.jsp");
            req.getRequestDispatcher("UserMain.jsp").forward(req,res);
        }else if (deal.equals("toInfo")){
            System.out.println(user);
            List<Info> arr = fs.getInfo();
            req.setAttribute("arr",arr);
            req.setAttribute("user",user);
            req.setAttribute("mainRight","info.jsp");
            req.getRequestDispatcher("UserMain.jsp").forward(req,res);
        }else if(deal.equals("addinfo")){
            //context="+document.getElementById("tex").value+"&myid=${user.getUid()}"
            String info = req.getParameter("context");
            String name = user.getName();
            fs.insertInfo(name,info);
            List<Info> arr = fs.getInfo();
            req.setAttribute("arr",arr);
            req.setAttribute("user",user);
            req.setAttribute("mainRight","info.jsp");
            req.getRequestDispatcher("UserMain.jsp").forward(req,res);


        }

    }


    }

