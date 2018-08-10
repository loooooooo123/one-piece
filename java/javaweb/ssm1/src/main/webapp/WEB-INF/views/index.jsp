    <%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
        <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
        <html>
        <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="pragma" content="no-cache">
        <meta http-equiv="cache-control" content="no-cache">
        <meta http-equiv="expires" content="0">
        <title>返回json和xml数据</title>
        <link ref="stylesheet" type="text/css"
        href="https://cdn.bootcss.com/bootstrap/3.3.6/css/bootstrap.min.css">
        <style>
        table {
        width: 50%;
        }

        table, td, th {
        border: 1px solid #cecece;
        border-collapse: collapse;
        }

        td {
        padding: 5px 10px;
        }
        </style>
        <script src="https://cdn.bootcss.com/vue/2.5.16/vue.min.js"></script>
        </head>
        <body>
        <div id="div1">

        <h2>处理json数据</h2>

        <p>
        请输入名字：<input type="text" v-model="user.username" />
        </p>
        <p>
        请输入性别：<input type="text" v-model="user.sex" />
        </p>
        <p>
        <button type="button" @click="submit1">添加json</button>
        </p>
        <p>
        <button type="button" @click="submit2">添加xml</button>
        </p>

        <table>
        <thead>
        <tr>
        <th>序号
        </td>
        <th>名字</th>
        <th>性别</th>
        </tr>
        </thead>
        <tbody>
        <tr v-for="(val,index) in list">
        <td>{{val.id}}</td>
        <td>{{val.username}}</td>
        <td>{{val.sex}}</td>
        </tr>
        </tbody>
        </table>

        </div>

        <script src="https://cdn.bootcss.com/jquery/2.0.0/jquery.min.js"></script>
        <script src="https://cdn.bootcss.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
        <script src="/ssm1/static/js/base.js"></script>
        <script src="/ssm1/static/js/index.js"></script>

        </body>
        </html>