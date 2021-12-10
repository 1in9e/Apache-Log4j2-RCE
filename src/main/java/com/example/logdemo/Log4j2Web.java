package com.example.logdemo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

@WebServlet(name = "Log4j2Web", value = "/log4j2-test")
public class Log4j2Web extends HttpServlet {
    private String message;
    private static final Logger logger = LogManager.getLogger();

    @Override
    public void init() throws ServletException {
        message = "Apache Log4j2 Test";
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置响应内容类型  
        resp.setContentType("text/html");

        String para = req.getParameter("para");

        //设置逻辑实现  
        PrintWriter out = resp.getWriter();
        out.println("<h1>" + para + "</h1>");
        System.setProperty("com.sun.jndi.ldap.object.trustURLCodebase", "true");
        logger.error(para);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.setProperty("com.sun.jndi.ldap.object.trustURLCodebase", "true");
        //设置响应内容类型
        resp.setContentType("text/html");

        String para = req.getParameter("para");

        //设置逻辑实现
        PrintWriter out = resp.getWriter();
        try {
            out.println("<h1>Output: " + para + "</h1>");
            logger.error(para);
        } catch (Exception e){
            out.println(e.getMessage());
        }

        // property
        Properties properties = System.getProperties();
        out.println(properties.size());
        for (Object o : properties.keySet()) {
            out.println("" + o + "=" + properties.get(o));
        }


    }

    @Override
    public void destroy() {
        super.destroy();
    }
}  