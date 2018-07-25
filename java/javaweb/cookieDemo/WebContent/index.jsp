    <%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
        <!-- 导入CookieSessionDemo包 -->
        <%@ page import="cookiesessionpage.CookieSessionDemo" %>
            <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

            <%
	//使用CookieSessionDemo包，设置cookie和session
	CookieSessionDemo cd = new CookieSessionDemo(request,response);
%>

        <!DOCTYPE html>
        <html lang="en">
        <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>欢迎访问首页</title>
        </head>
        <body>
        <h2>欢迎访问首页</h2>

        <script src="https://cdn.bootcss.com/jquery/3.2.0/jquery.min.js"></script>
        </body>
        </html>