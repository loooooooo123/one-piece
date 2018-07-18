package xmlExp;

/*
 * JDOM����ǻ���java��д�Ĳ����JDOM=DOM�޸��ŵ�+SAX��ȡ���е� ����Ҫ����JDOM�������װ
 * 
 * JDOM�����ɣ�
     ��1�� Document�࣬���ڴ�ȡ��Ԫ�أ�������һ��XML�ĸ��ֲ�����
     ��2�� DOMBuilder�࣬��������һ��JDOM�ṹ����
     ��3�� Element�࣬�õ�Ԫ�ص��������ݡ�����ֵ���ӽڵ㡣
     ��4�� Attribute�࣬XML�ļ�Ԫ�������Եĸ���������
     ��5�� XMLOututter�࣬���ڽ�JDOM��ʽ��ΪXML�������
 * */

import java.io.*;
import java.util.*;
import org.jdom.*;
import org.jdom.input.*;
import org.jdom.output.XMLOutputter;

//ʹ��JDom����XML����
public class JDomReadXML {

	public static void main(String args[]) throws Exception {
		
		// ��ȡXML����
		readxml();
		
		// ����һ��XML����
		createxml();
		
	}

	// ��ȡXML����
	public static void readxml() throws Exception {
		SAXBuilder builder = new SAXBuilder();
		Document read_doc = builder.build(new File("E:\\public_project\\java_project\\xml\\demo3.xml"));
		Element root = read_doc.getRootElement(); // ȡ�ø�
		// �õ����е�linkman
		List list = root.getChildren("link");
		for (int x = 0; x < list.size(); x++) {
			Element e = (Element) list.get(x);
			// �õ�name�ӽڵ������
			String name = e.getChildText("name");
			String id = e.getChild("name").getAttribute("id").getValue();
			// �õ�email�ӽڵ������
			String email = e.getChildText("email");
			System.out.println("-------------- ��ϵ�� -------------");
			System.out.println("������" + name + "����ţ�" + id);
			System.out.println("EMAIL��" + email);
			System.out.println("-----------------------------------");
			System.out.println();
		}
	}

	// ����һ��XML����
	public static void createxml() throws Exception {
		Element addresslist = new Element("addresslist"); // ������ڵ�
		Element linkman = new Element("linkman"); // ����linkman�ڵ�
		Element name = new Element("name"); // ����name�ڵ�
		Element email = new Element("email"); // ����email�ڵ�
		Attribute id = new Attribute("id", "lxh"); // ����name�ڵ��е�����
		Document doc = new Document(addresslist); // ����Document����
		name.setText("haha"); // ����name�ڵ��е�����
		name.setAttribute(id); // ��id�������õ�name�ڵ�֮��
		email.setText("haha@163.com"); // ����email�ڵ��е�����
		linkman.addContent(name); // ��linkman�ڵ������name�ӽڵ�
		linkman.addContent(email); // ��linkman�ڵ������email�ӽڵ�
		addresslist.addContent(linkman); // �ڸ��ڵ������linkman�ӽڵ�
		XMLOutputter out = new XMLOutputter(); // ʵ����XML�����
		out.setFormat(out.getFormat().setEncoding("GBK")); // �������ʱ�ı���
		out.output(doc, new FileOutputStream(new File("E:\\public_project\\java_project\\xml\\demo5.xml")));
		// ���XML�ĵ�
	}

}
