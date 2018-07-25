    <%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
            <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

            <%
	//如果已有用户登录
	if(session.getAttribute("user")!=null){
		response.sendRedirect("/demo2/home.jsp");
	}
	//获取用户名
	String username=request.getParameter("username");
	String pwd=request.getParameter("pwd");
	
	if("admin".equals(username)&&"admin".equals(pwd)){
		//将用户保存到session
		session.setAttribute("user",username);
		//重定向到index.jsp页面
		response.sendRedirect("/demo2/home.jsp");
	}else{
		//重定向到index.jsp页面
		response.sendRedirect("/demo2/login/login.jsp");
	}
%>