package lianshou3;

//SAX树形解析，SAX只能读XML，不能修改XML
import org.xml.sax.*;
import org.xml.sax.helpers.*; //导入相应的包和类

public class XmlSAXDemo extends DefaultHandler {
	// 文档开始事件
	public void startDocument() throws SAXException {
		System.out.println("<?xml version=\"1.0\" encoding=\"GBK\">");
	}

	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException { // 元素开始事件
		System.out.print("<");
		System.out.print(qName);
		if (attributes != null) { // 如果存在了属性
			for (int x = 0; x < attributes.getLength(); x++) {
				System.out.print(" " + attributes.getQName(x) + "=\"" + attributes.getValue(x) + "\"");
			}
		}
		System.out.print(">");
	}

	// 元素结束事件
	public void endElement(String uri, String localName, String qName) throws SAXException {
		System.out.print("<");
		System.out.print(qName);
		System.out.print(">");
	}

	// 元素内容事件
	public void characters(char[] ch, int start, int length) throws SAXException {
		System.out.print(new String(ch, start, length));
	}

	// 文档结束事件
	public void endDocument() throws SAXException {
		System.out.println("文档结束。。。");
	}
}
