    <%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
            <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

        <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
        <html>
        <head>
        <base href="<%=basePath%>">

        <title>用户登录</title>
        </head>

        <body>
            <%
  	//如果已有用户登录
	if(session.getAttribute("user")!=null){
		response.sendRedirect("/demo2/home.jsp");
	}
  	%>
        <form method="post" action="/demo2/login/loginDo.jsp">
        <p>用户名：<input type="text" name="username"/></p>
        <p>用户名：<input type="password" name="pwd"/></p>
        <p><input type="submit" name="登录"/></p>
        </form>
        </body>
        </html>