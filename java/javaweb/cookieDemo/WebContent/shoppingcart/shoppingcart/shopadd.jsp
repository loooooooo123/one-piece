    <%@ page language="java" contentType="text/html; charset=UTF-8"
             pageEncoding="UTF-8" %>
        <%@ page language="java" import="java.util.*" %>
        <%@ page language="java" import="cookiesessionpage.Shop" %>
        <%@ page language="java" import="cookiesessionpage.SessionShoppingCart" %>
        <!DOCTYPE html>
        <html>
        <head>
        <meta charset="UTF-8">
        <title>加入购物车</title>
        <style>
        table{
        width:50%
        }
        table,td{
        border:1px solid gray;
        border-collapse:collapse;
        }
        td{
        padding:5px;
        }
        a:link,a:active,a:hover,a{
        color:blue;
        text-decoration:none;
        }
        </style>
        </head>
        <body>
            <%
	//获取传参
	int id = Integer.parseInt(request.getParameter("id"));
	
	//实例化购物车类
	SessionShoppingCart sc = new SessionShoppingCart();
	
	//加入购物车
	sc.shopadd(request,response,id);
	%>

        <h2>加入购物车成功！
        <a href="/demo2/shoppingcart/shoplist.jsp">返回商品列表</a>
        <a href="/demo2/shoppingcart/shopcart.jsp">查看购物车</a>
        </h2>

        <table>
        <thead>
        <tr>
        <td>名称</td>
        <td>数量</td>
        </tr>
        </thead>
        <tbody>
            <%
		for (Map.Entry<String, Integer> entry : sc.getShoppingCart().entrySet()) { 
	    %>
        <tr>
        <td><%= entry.getKey() %></td>
        <td><%= entry.getValue() %></td>
        </tr>
            <%
		}
		%>
        </tbody>
        </table>
        </body>
        </html>