package cn.book.dao;

import cn.book.pojo.User;
import cn.book.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/*
*持久层--登录接口实现类
* */
public class LogingDaoImpl implements LoginDao{
    @Override
    public User LogDao(User user) {
        /*
        *
        * 链接数据库的
        * 写sql语句
        *
        * */
        String id = user.getUid();
        String pwd = user.getPwd();

        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement pre = null;
        // 接收数据库返回的值
        ResultSet res = null;
        User u = null;
        try {
            // sql语句
            String sql = "select * from user where u_id='"+id+"' and u_pwd = '"+pwd+"'";
            System.out.println(sql);
            try {
                pre = connection.prepareStatement(sql);
                res = pre.executeQuery();
                // res有值--实例化
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
}
