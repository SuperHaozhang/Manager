package com.cheer.service.impl;

import com.cheer.dao.UserDao;
import com.cheer.dao.impl.UserDaoImpl;
import com.cheer.pojo.User;
import com.cheer.service.UserService;
import com.cheer.servlet.UserServlet;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class UserServiceImpl implements UserService {
    //声明日志对象
    private static final org.apache.log4j.Logger LOGGER = Logger.getLogger(UserServiceImpl.class);
    //声明Dao层对象
    UserDao userDao=new UserDaoImpl();

    @Override
    public User checkUserLoginService(String uname, String pwd) {
        //打印日志
        LOGGER.debug(uname+"发起登录请求");
        User user=userDao.checkUserLoginDao(uname,pwd);
        //判断
        if(user!=null){
            LOGGER.debug(uname+"登录成功");
        }else{
            LOGGER.debug(uname+"登录失败");
        }
        return user;
    }

    @Override
    public int userChangePwdService(String newPwd, int uid) {
        return 0;
    }

    @Override
    public List<User> userShowService() {
        return null;
    }

    @Override
    public int userRegService(User u) {
        return 0;
    }
}
