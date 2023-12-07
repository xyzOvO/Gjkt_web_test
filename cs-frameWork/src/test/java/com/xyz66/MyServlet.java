package com.xyz66;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyServlet extends HttpServlet {
    
    /** 
     * 重定向到百度 
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)  
    throws IOException, ServletException {  
        response.setStatus(301);  
        response.setHeader("Location","https://www.baidu.com/");  
    }
}
