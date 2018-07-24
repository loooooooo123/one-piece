package xmlExp;

/*
 * JDOM组件是基于java编写的插件，JDOM=DOM修改优点+SAX读取快有点 ，需要下载JDOM插件并安装
 * 
 * JDOM类的组成：
     （1） Document类，用于存取根元素，定义了一个XML的各种操作。
     （2） DOMBuilder类，用来建立一个JDOM结构树。
     （3） Element类，得到元素的文字内容、属性值、子节点。
     （4） Attribute类，XML文件元素中属性的各个操作。
     （5） XMLOututter类，用于将JDOM格式化为XML并输出。
 * */

import java.io.*;
import java.util.*;
import org.jdom.*;
import org.jdom.input.*;
import org.jdom.output.XMLOutputter;

//使用JDom操作XML内容
public class JDomReadXML {

	public static void main(String args[]) throws Exception {
		
		// 读取XML内容
		readxml();
		
		// 创建一个XML内容
		createxml();
		
	}

	// 读取XML内容
	public static void readxml() throws Exception {
		SAXBuilder builder = new SAXBuilder();
		Document read_doc = builder.build(new File("E:\\public_project\\java_project\\xml\\demo3.xml"));
		Element root = read_doc.getRootElement(); // 取得根
		// 得到所有的linkman
		List list = root.getChildren("link");
		for (int x = 0; x < list.size(); x++) {
			Element e = (Element) list.get(x);
			// 得到name子节点的内容
			String name = e.getChildText("name");
			String id = e.getChild("name").getAttribute("id").getValue();
			// 得到email子节点的内容
			String email = e.getChildText("email");
			System.out.println("-------------- 联系人 -------------");
			System.out.println("姓名：" + name + "，编号：" + id);
			System.out.println("EMAIL：" + email);
			System.out.println("-----------------------------------");
			System.out.println();
		}
	}

	// 创建一个XML内容
	public static void createxml() throws Exception {
		Element addresslist = new Element("addresslist"); // 定义各节点
		Element linkman = new Element("linkman"); // 定义linkman节点
		Element name = new Element("name"); // 定义name节点
		Element email = new Element("email"); // 定义email节点
		Attribute id = new Attribute("id", "lxh"); // 定义name节点中的属性
		Document doc = new Document(addresslist); // 定义Document对象
		name.setText("haha"); // 设置name节点中的内容
		name.setAttribute(id); // 将id属性设置到name节点之中
		email.setText("haha@163.com"); // 设置email节点中的内容
		linkman.addContent(name); // 在linkman节点里添加name子节点
		linkman.addContent(email); // 在linkman节点里添加email子节点
		addresslist.addContent(linkman); // 在根节点里添加linkman子节点
		XMLOutputter out = new XMLOutputter(); // 实例化XML输出类
		out.setFormat(out.getFormat().setEncoding("GBK")); // 设置输出时的编码
		out.output(doc, new FileOutputStream(new File("E:\\public_project\\java_project\\xml\\demo5.xml")));
		// 输出XML文档
	}

}
