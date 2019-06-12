package com.cheer.servlet;

import com.cheer.dao.UserDao;
import com.cheer.dao.impl.UserDaoImpl;
import com.cheer.pojo.User;
import com.cheer.service.UserService;
import com.cheer.service.impl.UserServiceImpl;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import org.apache.log4j.Logger;

/**
 * Servlet重定向路径总结
 * 相对路径：从当前请求的路径查找资源的路径
 *      相对路径如果servlet的别名中包含目录，会造成重定向资源查找失败
 * 绝对路径：第一个/ 表示服务器根目录
 *          / 虚拟项目名 / 资源路径
 *
 * Servlet请求转发：
 *      /表示项目根目录
 *      req.getRequestDispatcher("/login.jsp").forward(req.resp)
 *
 *
 */

@WebServlet(name = "UserServlet", urlPatterns = "/servlet/UserServlet")
public class UserServlet extends HttpServlet {
    //声明日志对象
    private static final Logger LOGGER = Logger.getLogger(UserServlet.class);

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        //设置请求编码格式
        req.setCharacterEncoding("utf-8");
        //设置响应编码格式
        resp.setContentType("text/html;charset=utf-8");
        //获取操作符
        String oper=req.getParameter("oper");
        if("login".equals(oper)){
            //调用登录方法
            checkUserLogin(req,resp);
        }else if("out".equals(oper)){
            //调用退出功能
            userOut(req,resp);
        }else if("reg".equals(oper)){
            //调用注册功能

        }else {
            LOGGER.debug("没有找到对应的操作符"+oper);

        }

    }
    //处理退出
    private void userOut(HttpServletRequest req, HttpServletResponse resp) {
        //获取session对象
        HttpSession hs = req.getSession();
        //强制销毁
        hs.invalidate();
        //重定向
        try {
            resp.sendRedirect("/manager/login.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //处理登录
    private void checkUserLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求信息
        String uname=req.getParameter("uname");
        String pwd =req.getParameter("pwd");

        //处理请求信息
            //获取service层对象
            UserService userService=new UserServiceImpl();
            //校验
            User user=userService.checkUserLoginService(uname,pwd);
            if(user!=null){
                    //获取session对象
                    HttpSession hs=req.getSession();

                    //将用户数据存储到session对象中
                    hs.setAttribute("user",user);
                    //重定向
                    resp.sendRedirect("/manager/main/main.jsp");
                    return;
            }else{
                //获取session对象
                    HttpSession hs=req.getSession();
                    hs.setAttribute("flag",0);
                    resp.sendRedirect("/manager/login.jsp");
                    //添加request中

                    //req.setAttribute("flag",0);
                    //请求转发
                    //req.getRequestDispatcher("/manager/../../login.jsp").forward(req,resp);
                    return;
            }
        //响应处理结果
        //直接响应
        //请求转发


    }


}
