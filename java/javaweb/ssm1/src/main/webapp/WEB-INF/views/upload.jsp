    <%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
        <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
        <html>
        <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="pragma" content="no-cache">
        <meta http-equiv="cache-control" content="no-cache">
        <meta http-equiv="expires" content="0">
        <title>文件上传</title>
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

        <h2>单图上传</h2>

        <form action="/ssm1/upload/uploadOne" enctype="multipart/form-data" method="post">
        <p>文件描述：<input type="text" name="desc" /></p>
        <p>请选择一个文件：<input type="file" name="file" /></p>
        <p><input type="submit" value="上传" /></p>
        </form>

        <h2>多图上传</h2>

        <form action="/ssm1/upload/uploadAll" enctype="multipart/form-data" method="post">
        <p>文件描述：<input type="text" name="desc2" /></p>
        <p>请选择文件：<input type="file" name="file" /></p>
        <p>请选择文件：<input type="file" name="file" /></p>
        <p>请选择文件：<input type="file" name="file" /></p>
        <p><input type="submit" value="上传" /></p>
        </form>

        <h2>单图上传，pojo方式</h2>

        <form action="/ssm1/upload/uploadOnePojo" enctype="multipart/form-data" method="post">
        <p>文件描述：<input type="text" name="desc" /></p>
        <p>请选择一个文件：<input type="file" name="file" /></p>
        <p><input type="submit" value="上传" /></p>
        </form>

        <div>
        <a href="/ssm1/upload/downloadOne?filename=20180809/20180809205257.jpg">20180809205257.jpg 下载</a>
        </div>
        <div>
        <a href="/ssm1/upload/downloadOne?filename=20180809/20180809205359.jpg">20180809205359.jpg 下载</a>
        </div>
        <div>
        <a href="/ssm1/upload/downloadOne?filename=20180809/20180809205417.jpg">20180809205417.jpg 下载</a>
        </div>

        </div>

        <script src="https://cdn.bootcss.com/jquery/2.0.0/jquery.min.js"></script>
        <script src="https://cdn.bootcss.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
        <script src="/ssm1/static/js/base.js"></script>
        <script src="/ssm1/static/js/index.js"></script>

        </body>
        </html>