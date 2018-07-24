package demo2;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//cookie和session应用
public class CookieSessionDemo {
	
	public String str = "hello";

	public static void main(String[] args) {
		
	}
	
	//构造函数
	public CookieSessionDemo(HttpServletRequest request,HttpServletResponse response) {
		//调用cookie应用
		cookieDemo(request,response);
	}
	
	//cookie应用
	public static void cookieDemo(HttpServletRequest request,HttpServletResponse response) {
		
		//设置编码格式，防止乱码
		response.setContentType("text/html;charset=utf-8");
		
		//设置cookie
		Cookie ck = new Cookie("ceshi","www.baidu.com");
		
		//设置cookie有效时间，单位秒
		ck.setMaxAge(60);	//设置60秒
		
		//设置cookie有效域名
		ck.setPath("/");  
		
		response.addCookie(ck);

		//获取Cookie名称
		String cName = ck.getName();

		//获取Cookie值
		String cVal = ck.getValue();

		//获取所有cookie，返回一个数组
		Cookie cArr[] = request.getCookies();
		
		System.out.println("cookie名："+cName+"cookie值："+cVal);
		
		//遍历所有cookie
		for(Cookie n:cArr) {
			//获取Cookie名称
			String cn1 = n.getName();

			//获取Cookie值
			String cv1 = n.getValue();
			System.out.println("cookie名："+cn1+"cookie值："+cv1);
		}
		
		//删除cookie
		ck.setValue("");	//清除值
		ck.setMaxAge(0);	//立即销毁cookie
		
		//再次遍历所有cookie
		for(Cookie n:cArr) {
			//获取Cookie名称
			String cn1 = n.getName();

			//获取Cookie值
			String cv1 = n.getValue();
			System.out.println("cookie名："+cn1+"cookie值："+cv1);
		}
	}

}
