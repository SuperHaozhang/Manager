package com.cheer.dao.impl;

import com.cheer.dao.UserDao;
import com.cheer.pojo.User;
import com.cheer.service.impl.UserServiceImpl;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class UserDaoImpl implements UserDao{
    //声明日志对象
    private static final org.apache.log4j.Logger LOGGER = Logger.getLogger(UserDaoImpl.class);
    //根据用户名和密码查询用户信息
    public User checkUserLoginDao(String uname, String pwd) {
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        SqlSession session = null;
        User user=null;
        try {

            //1、获取SqlSessionFactory
            inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            //2.获取Sqlsession对象
            session = sqlSessionFactory.openSession();
            UserDao userDao = session.getMapper(UserDao.class);

            user = userDao.checkUserLoginDao(uname,pwd);
            LOGGER.info(user);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                if (session != null) {
                    session.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return user;
    }

    @Override
    public int userChangePwdDao(String newPwd, int uid) {
        return 0;
    }

    @Override
    public List<User> userShowDao() {
        return null;
    }

    @Override
    public int userRegDao(User u) {
        return 0;
    }
}
