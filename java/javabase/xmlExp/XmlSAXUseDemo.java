package xmlExp;

import java.io.*;
import javax.xml.parsers.*;

//使用自定义的XmlSAXDemo解析类
public class XmlSAXUseDemo {

	public static void main(String args[]) throws Exception {
		// 建立SAX解析工厂
		SAXParserFactory factory = SAXParserFactory.newInstance();
		// 实例化解析器类
		SAXParser parser = factory.newSAXParser();
		// 读取XML
		parser.parse("E:\\public_project\\java_project\\xml\\demo2.xml", new XmlSAXDemo());
	}

}
