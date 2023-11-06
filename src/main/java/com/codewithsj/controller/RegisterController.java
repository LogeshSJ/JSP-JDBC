package com.codewithsj.controller;


import com.codewithsj.dao.UserDao;
import com.codewithsj.model.Register;
import com.codewithsj.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class RegisterController extends HttpServlet {
    private  UserDao userDao;
    public RegisterController(){
        userDao = new UserDao();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        UserDao.register(username,password);
        RequestDispatcher rs = req.getRequestDispatcher("index.jsp");
        rs.forward(req,resp);
    }
}





