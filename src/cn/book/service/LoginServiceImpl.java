package cn.book.service;

import cn.book.dao.LoginDao;
import cn.book.dao.LogingDaoImpl;
import cn.book.pojo.User;

/*
*服务层--登录接口实现类
* implements 实现某个接口后面加接口名
*  */
public class LoginServiceImpl implements LoginService {
    // 用接口创建一个对象
    LoginDao loginDao = new LogingDaoImpl();
    public User logService(User user) {
        // 首先要创建一个user--访问持久层然后返回一个u
//      User u = loginDao.LogDao(user);
        return loginDao.LogDao(user);
    }
}
