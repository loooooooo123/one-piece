    <%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
        <!-- 导入CookieSessionDemo包 -->
        <%@ page import="demo2.CookieSessionDemo" %>
            <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

            <%
	//使用CookieSessionDemo包，设置cookie
	CookieSessionDemo cd = new CookieSessionDemo(request,response);
%>