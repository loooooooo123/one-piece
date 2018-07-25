    <%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
            <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

            <%
	//删除session
	session.removeAttribute("user");
	//重定向到index.jsp页面
	response.sendRedirect("/demo2/home.jsp");
%>