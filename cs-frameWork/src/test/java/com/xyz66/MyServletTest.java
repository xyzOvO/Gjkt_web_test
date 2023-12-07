package com.xyz66;

import com.alibaba.fastjson.JSON;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyServletTest {  
    
    /** 
     * 测试doGet方法 
     */
    @Test  
    public void testDoGet() throws ServletException, IOException {  
        // JaveWeb的Servlet容器，负责调用servlet的service方法
        MyServlet servlet = new MyServlet();
        // http请求，包括请求头，请求参数，请URL等
        HttpServletRequest request = new MockHttpServletRequest();  
        // http响应，包括响应头，响应内容，响应状态码等
        HttpServletResponse response = new MockHttpServletResponse();  
        servlet.doGet(request, response);
        System.out.println(JSON.toJSONString(response));
        
    }  
}
