package lianshou3;

import java.io.*;
import javax.xml.parsers.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/*
 * XML常用方法：
 * 
 * 1）Document接口：
 * 
 * //读取xml文档中指定名称的节点
 * xml对象.getElementByTagName("节点");        
 * 

 * //在xml文档中创建一个指定名称的节点，也会同时抛出一个异常
 * xml对象.createElement("节点名");
 * 

 * //在xml文档中创建一个指定文本内容的节点
 * xml对象.createTextNode("文本内容");
 * 

 * //在xml文档中某节点上创建一个指定名称的属性
 * xml对象.createAttribute("属性名");

 * //把一个xml节点对象，导入到当前xml对象中，参数布尔值为true时以递归来向下导入
 * xml对象.importNode(被导入xml节点对象,布尔值);

 *  注意：所有子节点，为false时仅导入当前获取到的节点。

 * 2）Node接口：
 * xml对象.appendChild(节点名称);
 * //将已创建的节点添加在xml对象的最后，也会同时抛出一个异常

 * xml对象.getChildNodes();
 * //取得本节点下的全部子节点

 * xml对象.getFirstChild();
 * //取得本节点下的第一个子节点

 * xml对象.getLastChild();
 * //取得本节点下的最后一个子节点

 * xml对象.has ChildNodes();
 * //判断是否包含子节点

 * xml对象.has Attributes();
 * //判断是否包含属性

 * xml对象.getNodeValue();
 * //取得本节点的内容，也会同时抛出一个异常

 * 3）NodeList接口：
 * xml对象.getLength();
 * //取得本节点的个数

 * xml对象.item(下标);
 * //取得本节点下指定索引的节点对象
 * 
 */

//读取xml
public class XmlDemo {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		
		// 读取一个XML节点下内容
		oneXmlNode();
		
		// 读取多个XML节点下内容
		AllXmlNode();
		
	}

	// 读取一个XML节点下内容
	public static void oneXmlNode() throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		// 取得DocumentBuilderFactory类的对象
		DocumentBuilder build = factory.newDocumentBuilder();
		// 取得DocumentBuilder类的对象
		Document doc = build.parse(new File("E:\\public_project\\java_project\\xml\\demo.xml"));
		// 建立Document，按路径来读取xml文件
		NodeList nl = doc.getElementsByTagName("name");
		// 用get方法获取name名称的节点
		System.out.println("姓名：" + nl.item(0).getFirstChild().getNodeValue());
		// 输出节点
	}

	// 读取多个XML节点下内容
	public static void AllXmlNode() throws ParserConfigurationException, SAXException, IOException {
		// 取得DocumentBuilderFactory类的对象
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

		// 取得DocumentBuilder类的对象
		DocumentBuilder build = factory.newDocumentBuilder();

		// 建立Document，按路径来读取xml文件
		Document doc = build.parse(new File("E:\\public_project\\java_project\\xml\\demo2.xml"));

		// 得到所有的linkman节点
		NodeList nl = doc.getElementsByTagName("linkman");

		// 取出每一个元素
		for (int x = 0; x < nl.getLength(); x++) {
			Element e = (Element) nl.item(x);
			System.out.println("姓名：" + e.getElementsByTagName("name").item(0).getFirstChild().getNodeValue());
			System.out.println("邮箱：" + e.getElementsByTagName("email").item(0).getFirstChild().getNodeValue());
		}
	}

}
