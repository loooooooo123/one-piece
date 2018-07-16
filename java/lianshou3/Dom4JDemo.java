package lianshou3;

import java.io.* ;
import java.util.Iterator;

import org.dom4j.* ;
import org.dom4j.io.* ;

/*
 * 最出色的解析XML文档的DOM4J插件
 * 
 * DOM4J提供的接口与JDOM提供的类基本类似，接口如下：
  （1） Attribute接口，定义了XML的属性。
  （2） Branch接口，定义XML元素Element或Document一个公共的行为。
  （3） CDATA接口，定义了XML CDATA区域。
  （4） CharachterData接口，标识接口，标识基于字符的节点，如CDATA、Comment、Text。
  （5） Comment接口，定义了XML的注释。
  （6） Document接口，定义了XML文档。
  （7） Element接口，定义了XML元素。
  （8） Text接口，定义了XML文本节点。
 *
 * */
public class Dom4JDemo {

	public static void main(String[] args) throws DocumentException, IOException {

		// 读取XML
		readXml();

		// 创建XML
		createXml();
		
	}

	// 读取XML
	public static void readXml() throws DocumentException {
		// 读取xml文件
		File file = new File("E:\\public_project\\java_project\\xml\\demo3.xml");
		SAXReader reader = new SAXReader(); // 实例化SAX解析读取器
		Document doc = reader.read(file); // 读取XML文件
		// 取得根节点，JDOM操作的时候是要取得根节点
		Element root = doc.getRootElement();
		// 现在应该根据根节点找到全部的子节点，linkman
		Iterator iter = root.elementIterator();
		while (iter.hasNext()) {
			Element linkman = (Element) iter.next();
			System.out.println("姓名：" + linkman.elementText("name"));
			System.out.println("邮件：" + linkman.elementText("email"));
		}
	}

	// 创建XML
	public static void createXml() throws DocumentException, IOException {
		// 创建文档
		Document doc = DocumentHelper.createDocument();
		// 定义addresslist根节点
		Element addresslist = doc.addElement("addresslist");
		// 定义linkman子节点
		Element linkman = addresslist.addElement("linkman");
		// 定义name子节点
		Element name = linkman.addElement("name");
		// 定义email子节点
		Element email = linkman.addElement("email");
		// 设置name节点的内容
		name.setText("哇哈哈");
		email.setText("wahaha@163.com "); // 设置email节点的内容
		// 设置输出格式
		OutputFormat format = OutputFormat.createPrettyPrint();
		// 设置输出时的编码
		format.setEncoding("GBK");
		// 输出文件
		XMLWriter writer = new XMLWriter(new FileOutputStream(new File("E:\\public_project\\java_project\\xml\\demo6.xml")), format);
		writer.write(doc); // 输出内容
		writer.close(); // 关闭输出流
	}

}
