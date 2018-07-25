    <%@ page language="java" contentType="text/html; charset=UTF-8"
             pageEncoding="UTF-8" %>
        <%@ page language="java" import="java.util.*" %>
        <%@ page language="java" import="cookiesessionpage.Shop" %>
        <%@ page language="java" import="cookiesessionpage.SessionShoppingCart" %>
        <!DOCTYPE html>
        <html>
        <head>
        <meta charset="UTF-8">
        <title>商品列表</title>
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
	SessionShoppingCart sc = new SessionShoppingCart();
	ArrayList<Shop> list1 = sc.shoplist();
	%>

        <table>
        <thead>
        <tr>
        <td>序号</td>
        <td>名称</td>
        <td>数量</td>
        <td>价格</td>
        <td>操作</td>
        </tr>
        </thead>
        <tbody>
            <%
		for(Shop obj:list1){
		%>
        <tr>
        <td><%= obj.getId() %></td>
        <td><%= obj.getShopname() %></td>
        <td><%= obj.getCount() %></td>
        <td><%= obj.getMoney() %></td>
        <td><a href="/demo2/shoppingcart/shopadd.jsp?id=<%= obj.getId() %>">加入购物车</a></td>
        </tr>
            <%
		}
		%>
        </tbody>
        </table>


        </body>
        </html>