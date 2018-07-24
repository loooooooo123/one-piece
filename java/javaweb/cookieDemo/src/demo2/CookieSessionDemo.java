package demo2;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//cookie��sessionӦ��
public class CookieSessionDemo {
	
	public String str = "hello";

	public static void main(String[] args) {
		
	}
	
	//���캯��
	public CookieSessionDemo(HttpServletRequest request,HttpServletResponse response) {
		//����cookieӦ��
		cookieDemo(request,response);
	}
	
	//cookieӦ��
	public static void cookieDemo(HttpServletRequest request,HttpServletResponse response) {
		
		//���ñ����ʽ����ֹ����
		response.setContentType("text/html;charset=utf-8");
		
		//����cookie
		Cookie ck = new Cookie("ceshi","www.baidu.com");
		
		//����cookie��Чʱ�䣬��λ��
		ck.setMaxAge(60);	//����60��
		
		//����cookie��Ч����
		ck.setPath("/");  
		
		response.addCookie(ck);

		//��ȡCookie����
		String cName = ck.getName();

		//��ȡCookieֵ
		String cVal = ck.getValue();

		//��ȡ����cookie������һ������
		Cookie cArr[] = request.getCookies();
		
		System.out.println("cookie����"+cName+"cookieֵ��"+cVal);
		
		//��������cookie
		for(Cookie n:cArr) {
			//��ȡCookie����
			String cn1 = n.getName();

			//��ȡCookieֵ
			String cv1 = n.getValue();
			System.out.println("cookie����"+cn1+"cookieֵ��"+cv1);
		}
		
		//ɾ��cookie
		ck.setValue("");	//���ֵ
		ck.setMaxAge(0);	//��������cookie
		
		//�ٴα�������cookie
		for(Cookie n:cArr) {
			//��ȡCookie����
			String cn1 = n.getName();

			//��ȡCookieֵ
			String cv1 = n.getValue();
			System.out.println("cookie����"+cn1+"cookieֵ��"+cv1);
		}
	}

}
