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
import java.util.ArrayList;
import java.util.List;

@WebServlet("/fileServlet")
public class FileServlet extends HttpServlet {
    /*
    * window.location.href = "fileServlet?action=search&admid="+ admId +"&goalFile="+goalFile;
    * 管理员的用户管理界面的查询功能
    * service方法
    * */

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        // 首先获取action的信息
        String deal = req.getParameter("action");
        System.out.println(deal);
        // 服务层--实现类
        FileService fs = new FileServiceImpl();
        // 获取admid
        String admId = req.getParameter("admid");
        // 获取管理员信息
        User user = fs.getAdmineUser(admId);
        // 如果deal里面存储的信息叫做search--关于search的处理业务
        if(deal.equals("search")){
            // 获取要搜索的那条信息
            String goalFile = req.getParameter("goalFile");
            // 获取目标搜索人的信息
            User goalUserFile = fs.getGoalUserFile(goalFile);
            // 查询后的显示表格的信息
            List<User> list = new ArrayList<User>();
            list.add(goalUserFile);
            // 查询逻辑
            req.setAttribute("user",user);
            if(goalUserFile!=null){
                req.setAttribute("arr",list);
            }

            req.setAttribute("mainRight","userFile.jsp");
            req.getRequestDispatcher("AdmMainPage.jsp").forward(req,res);

        }else if(deal.equals("goUserShow")){
            //"fileServlet?action=goUserShow&admId="+${user.getUid()};
            //说明要去访问用户管理界面
            List<User> arr = fs.getAllUser();
            req.setAttribute("arr",arr);
            req.setAttribute("user",user);
            req.setAttribute("mainRight","userFile.jsp");
            req.getRequestDispatcher("AdmMainPage.jsp").forward(req,res);

        }else if(deal.equals("bookSearch")){
            //window.location.href = "fileServlet?action=bookSearch&admid="+ admId +"&goalFile="+goalFile;
            //获取图书
            String goalFile = req.getParameter("goalFile");
            System.out.println(goalFile);
            List<Book> arr = fs.getBookByNameOrId(goalFile);
            req.setAttribute("arr",arr);
            req.setAttribute("user",user);
            req.setAttribute("mainRight","book.jsp");
            req.getRequestDispatcher("AdmMainPage.jsp").forward(req,res);


//window.location.href = "action=findAllFile?admid=${user.getUid()}&bookid="+v;
        }else if(deal.equals("findAllFile")){

            //http://localhost:8080/bookss/action=findAllFile?admid=1&bookid=b145421

            //找这个图书的所有信息
            String bookId = req.getParameter("bookid");
            Book book = fs.getBookByNameOrId(bookId).get(0);

            req.setAttribute("book",book);
            req.setAttribute("user",user);
            req.setAttribute("mainRight","bookshow.jsp");
            req.getRequestDispatcher("AdmMainPage.jsp").forward(req,res);

        }else if(deal.equals("upbook")){
            //${user.getUid()}&bookId="+bookId+"&number="+number+"&price="+price;
            String bookId = req.getParameter("bookId");
            String number = req.getParameter("number");
            String price = req.getParameter("price");
            fs.upBookNum(bookId,number,price);


            List arr = fs.getBookByNameOrId(bookId);
            req.setAttribute("arr",arr);
            req.setAttribute("user",user);
            req.setAttribute("mainRight","book.jsp");
            req.getRequestDispatcher("AdmMainPage.jsp").forward(req,res);



        }else if(deal.equals("toUpBook")){
            //window.location.href = "fileServlet?action=toUpBook&
            // admid=${user.getUid()}&bookid="+m;
            String m = req.getParameter("bookid");
            Book book = fs.getBookByNameOrId(m).get(0);

            req.setAttribute("user",user);
            req.setAttribute("book",book);

            req.setAttribute("mainRight","upBook.jsp");
            req.getRequestDispatcher("AdmMainPage.jsp").forward(req,res);

        }else if(deal.equals("goBookManage")){
            //"fileServlet?action=goBookManage&admid="+${user.getUid()};
            List<Book> arr = fs.getAllBook();
            req.setAttribute("arr",arr);
            req.setAttribute("user",user);
            req.setAttribute("mainRight","book.jsp");
            req.getRequestDispatcher("AdmMainPage.jsp").forward(req,res);
        }else if(deal.equals("goHead")){
            //window.location.href = "fileServlet?action=goHead&admid="+${user.getUid()};
            req.setAttribute("user",user);
            req.setAttribute("mainRight","show.jsp");
            req.getRequestDispatcher("AdmMainPage.jsp").forward(req,res);
        }else if(deal.equals("goBookAdd")){//window.location.href = "fileServlet?action=goBookAdd&admid="+${user.getUid()};
            req.setAttribute("user",user);
            req.setAttribute("mainRight","AddBook.jsp");
            req.getRequestDispatcher("AdmMainPage.jsp").forward(req,res);
        }else if(deal.equals("sureAdd")){
            String a =req.getParameter("a");
            String b =req.getParameter("b");
            String c =req.getParameter("c");
            String d =req.getParameter("d");
            String e =req.getParameter("e");
            String f =req.getParameter("f");
            String g =req.getParameter("g");
            String h =req.getParameter("h");
            String l =req.getParameter("l");
            fs.addBook(a,b,c,d,e,f,g,h,l);
            System.out.println(a+"  "+b+"  "+c+"  "+d+"  "+e+"  "+f+"  "+h+"  "+l);

            req.setAttribute("user",user);
            req.setAttribute("mainRight","show.jsp");
            req.getRequestDispatcher("AdmMainPage.jsp").forward(req,res);
            //http://localhost:8080/bookss/fileServlet?action=suerAdd?admid=1&a=%E6%8E%A5%E5%8A%9B%E9%A2%98%E7%82%B91800&b=%E8%80%83%E7%A0%94&c=10d=78&e=978-7-5022-34&f=%E4%B8%80%E6%A5%BC%E8%A5%BF&g=%E7%9C%B8%E5%AD%90%E8%83%BD%E5%85%AC%E5%8F%B8&h=%E8%80%81%E5%B8%88&l=2021%20%E7%AC%AC%E4%BA%8C%E7%89%88

            //window.location.href = "fileServlet?action=suerAdd?admid=${user.getUid()}&a="+book_name+"&b="+book_type+"&c="+book_num+"d="+book_price+"&e="+book_ISBN+"&f="+book_address+
            //                    "&g="+book_business+"&h="+book_author+"&h="+book_edition;


        } else if(deal.equals("lookLend")){
            //"fileServlet?action=lookLend&admid=${user.getUid()}&bookid="+n;
            String bookid = req.getParameter("bookid");

            //这个时候我们去借阅表来获取这本书所有的借阅信息
            List<BookLendType> arr = fs.getLendFile(bookid);
            req.setAttribute("arr",arr);
            req.setAttribute("user",user);
            req.setAttribute("mainRight","bookLend.jsp");
            req.getRequestDispatcher("AdmMainPage.jsp").forward(req,res);
        }else if (deal.equals("goLendRecode2")){
            //"fileServlet?action=goLendRecode2&admid="+${user.getUid()};
            req.setAttribute("user",user);
            List<BookLendType> arr = fs.getLendFile("all");
            req.setAttribute("arr",arr);
            req.setAttribute("mainRight","lendRecode.jsp");
            req.getRequestDispatcher("AdmMainPage.jsp").forward(req,res);
        }else if(deal.equals("retBook")||deal.equals("unretBook")||deal.equals("all")){
                List<BookLendType> arr = fs.getLendFile(deal);
                req.setAttribute("user",user);
                req.setAttribute("arr",arr);
                req.setAttribute("mainRight","lendRecode.jsp");
                req.getRequestDispatcher("AdmMainPage.jsp").forward(req,res);
        }else if(deal.equals("recodeSearch")){
            // "&goalFile="+goalFile;
            String Username = req.getParameter("goalFile");
            List<BookLendType> arr = fs.getLendFileByUserName(Username);
            req.setAttribute("user",user);
            req.setAttribute("arr",arr);
            req.setAttribute("mainRight","lendRecode.jsp");
            req.getRequestDispatcher("AdmMainPage.jsp").forward(req,res);

        }else if(deal.equals("toinfo")){
            //window.location.href = "fileServlet?action=toinfo&admid=+${user.getUid()}";
            List<Info> arr = fs.getInfo();
            req.setAttribute("arr",arr);
            req.setAttribute("user",user);
            req.setAttribute("mainRight","info.jsp");
            req.getRequestDispatcher("AdmMainPage.jsp").forward(req,res);
        }else if(deal.equals("addinfo")){
            //fileServlet?action=addinfo&context="+document.getElementById("tex").value+"&admid=${user.getUid()}
            String info = req.getParameter("context");
            String name = user.getName();
            fs.insertInfo(name,info);
            List<Info> arr = fs.getInfo();
            req.setAttribute("arr",arr);
            req.setAttribute("user",user);
            req.setAttribute("mainRight","info.jsp");
            req.getRequestDispatcher("AdmMainPage.jsp").forward(req,res);
        }else if(deal.equals("delbook")){
          //bookid="+a;
            String bookid = req.getParameter("bookid");
            fs.delbook(bookid);

            List<Book> arr = fs.getAllBook();
            req.setAttribute("arr",arr);
            req.setAttribute("user",user);
            req.setAttribute("mainRight","book.jsp");
            req.getRequestDispatcher("AdmMainPage.jsp").forward(req,res);

        } else {
            req.getRequestDispatcher("login.jsp").forward(req,res);
        }

    }
}
